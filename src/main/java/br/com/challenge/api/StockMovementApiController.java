package br.com.challenge.api;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.challenge.model.StockMovementEntity;
import br.com.challenge.request.ChangeStockRequest;
import br.com.challenge.service.StockMovementService;

@RestController
@RequestMapping("v1/stock-movement")
public class StockMovementApiController {

	@Autowired
	StockMovementService stockMovementService;

	@GetMapping
	public List<StockMovementEntity> getAllStock() {
		return stockMovementService.getAllStock();
	}

	@GetMapping("/{id}")
	public StockMovementEntity getAllStockBydId(@PathVariable Integer id) {
		return stockMovementService.getAllStockById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteStockBydId(@PathVariable Integer id) {
		stockMovementService.deleteStockById(id);
	}

	@PostMapping(value = "", consumes = MediaType.TEXT_HTML_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@Produces(MediaType.TEXT_HTML_VALUE)
	public StockMovementEntity addStock(@RequestBody String body) {
		return stockMovementService.addStock(body);
	}

	@PatchMapping("/{id}")
	public StockMovementEntity chageStock(@PathVariable Integer id, @Valid @RequestBody ChangeStockRequest changeStock) throws ParseException {
		return stockMovementService.changeStock(id, changeStock);
	}
}
