package br.com.challenge.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.challenge.service.StockMovementService;

@RestController
@RequestMapping("v1/stock-movement")
public class StockMovementApiController {

	@Autowired
	StockMovementService stockMovementService;
}
