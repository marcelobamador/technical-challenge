package br.com.challenge.service;

import java.util.List;

import br.com.challenge.model.ItemEntity;
import br.com.challenge.request.ChangeItemRequest;

public interface ItemService {
	
	List<ItemEntity> getAllItens();
	
	ItemEntity getAllTerminalsById (Integer id);
	
	void deleteItemById (Integer id);
	
	ItemEntity addItem (String body);
	
	ItemEntity changeItem(Integer name, ChangeItemRequest request);
}
