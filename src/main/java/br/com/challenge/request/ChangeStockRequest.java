package br.com.challenge.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ChangeStockRequest {

	@NotBlank(message = "Invalid date")
	private String creationDate;

	@Min(value = 0)
	private Integer quantity;

	/**
	 * @return the creationDate
	 */
	public String getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
