package br.com.challenge.service;

import java.text.ParseException;
import java.util.List;

import br.com.challenge.model.StockMovementEntity;
import br.com.challenge.request.ChangeStockRequest;

public interface StockMovementService {
	
	List<StockMovementEntity> getAllStock();
	
	StockMovementEntity getAllStockById(Integer id);
	
	void deleteStockById(Integer id);
	
	StockMovementEntity addStock(String body);
	
	StockMovementEntity changeStock(Integer id, ChangeStockRequest changeStock) throws ParseException;
}
