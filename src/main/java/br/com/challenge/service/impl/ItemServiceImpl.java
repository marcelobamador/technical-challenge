package br.com.challenge.service.impl;

import static java.util.Objects.isNull;
import static br.com.challenge.consts.ChallengeConstants.*;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.challenge.exception.DuplicateException;
import br.com.challenge.exception.JsonValidationException;
import br.com.challenge.exception.ObjectNotFoundException;
import br.com.challenge.model.ItemEntity;
import br.com.challenge.repository.ItemRepository;
import br.com.challenge.request.ChangeItemRequest;
import br.com.challenge.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepository;

	@Override
	public List<ItemEntity> getAllItens() {
		return this.itemRepository.findAll();
	}
	
	@Override
	public ItemEntity getAllTerminalsById(Integer id) {
		return this.itemRepository.getById(id);
	}

	@Override
	public ItemEntity addItem(String body) {
		JSONObject jsonObject = parseStringToJsonObject(body);
		ItemEntity itemEntity = parseJsonObjectToEntity(jsonObject);

		if (existsItem(itemEntity.getId())) {
			throw new DuplicateException("Item already exists: " + itemEntity.getId());
		}
		return this.itemRepository.save(itemEntity);
	}
	
	@Override
	public void deleteItemById(Integer id) {
		ItemEntity entity = itemRepository.getById(id);
		if (isNull(entity)) {
			throw new ObjectNotFoundException("Item not found: " + id);
		}
		itemRepository.deleteById(id);;
	}

	@Transactional
	public ItemEntity changeItem(Integer id, ChangeItemRequest request) {
		ItemEntity entity = itemRepository.getById(id);
		if (isNull(entity)) {
			return null;
		}

		entity.setName(request.getName());

		return itemRepository.save(entity);
	}

	private ItemEntity parseJsonObjectToEntity(JSONObject jsonObject) {
		return new Gson().fromJson(jsonObject.toString(), ItemEntity.class);
	}

	private JSONObject parseStringToJsonObject(String payload) {
		String[] splitPayload = payload.split(SPLIT_DELIMITER);

		try {
			JSONObject jsonObject = new JSONObject();

			jsonObject.put(JSON_OBJECT_ID, splitPayload[JSON_OBJECT_INDEX_ID]);
			jsonObject.put(JSON_OBJECT_NAME, splitPayload[JSON_OBJECT_INDEX_NAME]);

			return jsonObject;
		} catch (Exception e) {
			throw new JsonValidationException(e.getMessage());
		}
	}

	public boolean existsItem(Integer id) {
		return itemRepository.findById(id).isPresent();
	}

}
