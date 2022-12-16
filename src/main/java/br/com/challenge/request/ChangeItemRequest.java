package br.com.challenge.request;

import javax.validation.constraints.NotBlank;

public class ChangeItemRequest {

	@NotBlank(message = "Invalid name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
