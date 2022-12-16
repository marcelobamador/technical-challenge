package br.com.challenge.api;

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

import br.com.challenge.model.ItemEntity;
import br.com.challenge.request.ChangeItemRequest;
import br.com.challenge.service.ItemService;

@RestController
@RequestMapping("v1/itens")
public class ItemApiController {

	@Autowired
	ItemService itemService;

	@GetMapping
	public List<ItemEntity> getAllItens() {
		return itemService.getAllItens();
	}
	
	@GetMapping("/{id}")
	public ItemEntity getAllItensById(@PathVariable Integer id) {
		return itemService.getAllTerminalsById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteItemById(@PathVariable Integer id) {
		itemService.deleteItemById(id);
	}
	
	@PatchMapping("/{id}")
	public ItemEntity changeItem(@PathVariable Integer id,
			@Valid @RequestBody ChangeItemRequest changeItem) {
		return itemService.changeItem(id, changeItem);
	}
	
	@PostMapping(value = "", consumes = MediaType.TEXT_HTML_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@Produces(MediaType.TEXT_HTML_VALUE)
	public ItemEntity addItem(@RequestBody String body) {
		return itemService.addItem(body);
	}

}
