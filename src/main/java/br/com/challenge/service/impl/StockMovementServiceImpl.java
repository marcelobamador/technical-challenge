package br.com.challenge.service.impl;

import static br.com.challenge.consts.StockMovementConstants.*;
import static java.util.Objects.isNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

import br.com.challenge.exception.DuplicateException;
import br.com.challenge.exception.JsonValidationException;
import br.com.challenge.exception.ObjectNotFoundException;
import br.com.challenge.model.StockMovementEntity;
import br.com.challenge.repository.StockMovementRespository;
import br.com.challenge.request.ChangeStockRequest;
import br.com.challenge.service.StockMovementService;

@Service
public class StockMovementServiceImpl implements StockMovementService {

	@Autowired
	StockMovementRespository stockMovementRespository;

	@Override
	public List<StockMovementEntity> getAllStock() {
		return stockMovementRespository.findAll();
	}

	@Override
	public StockMovementEntity getAllStockById(Integer id) {
		return stockMovementRespository.getById(id);
	}

	@Override
	public void deleteStockById(Integer id) {
		StockMovementEntity entity = stockMovementRespository.getById(id);
		if (isNull(entity)) {
			throw new ObjectNotFoundException("Stock not found: " + id);
		}
		stockMovementRespository.deleteById(id);
	}

	@Override
	public StockMovementEntity addStock(String body) {
		JSONObject jsonObject = parseStringToJsonObject(body);
		StockMovementEntity stockEntity = parseJsonObjectToEntity(jsonObject);

		if (existsItem(stockEntity.getId())) {
			throw new DuplicateException("Stock already exists: " + stockEntity.getId());
		}
		return stockMovementRespository.save(stockEntity);
	}
	
	@Transactional
	public StockMovementEntity changeStock(Integer id, ChangeStockRequest changeStock) throws ParseException {
		StockMovementEntity entity = stockMovementRespository.getById(id);
		if (isNull(entity)) {
			return null;
		}
		
		if (changeStock.getCreationDate() != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		    entity.setCreationDate(formatter.parse(changeStock.getCreationDate()));
		}
		
		if(changeStock.getQuantity() != null)
			entity.setQuantity(changeStock.getQuantity());
		
		return stockMovementRespository.save(entity);
	}

	private JSONObject parseStringToJsonObject(String payload) {
		String[] splitPayload = payload.split(SPLIT_DELIMITER);

		try {
			
			JSONObject jsonObjectItem = new JSONObject();
			jsonObjectItem.put(JSON_OBJECT_ITEM, Integer.parseInt(splitPayload[JSON_OBJECT_INDEX_ITEM]));
			jsonObjectItem.put(JSON_OBJECT_ID, Integer.parseInt(splitPayload[JSON_OBJECT_INDEX_ITEM]));

			JSONObject jsonObject = new JSONObject();

			jsonObject.put(JSON_OBJECT_ID, Integer.parseInt(splitPayload[JSON_OBJECT_INDEX_ID]));
			jsonObject.put(JSON_OBJECT_CREATION_DATE, splitPayload[JSON_OBJECT_INDEX_CREATION_DATE]);
			jsonObject.put(JSON_OBJECT_ITEM, jsonObjectItem);
			jsonObject.put(JSON_OBJECT_QUANTITY, Integer.parseInt(splitPayload[JSON_OBJECT_INDEX_QUANTITY]));

			return jsonObject;
		} catch (Exception e) {
			throw new JsonValidationException(e.getMessage());
		}
	}

	private StockMovementEntity parseJsonObjectToEntity(JSONObject jsonObject) {
		return new Gson().fromJson(jsonObject.toString(), StockMovementEntity.class);
	}

	public boolean existsItem(Integer id) {
		return stockMovementRespository.findById(id).isPresent();
	}

}
