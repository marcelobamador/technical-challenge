package br.com.challenge.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "stock_movement")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class StockMovementEntity {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "creation_date")
	private Date creationDate;

	@OneToOne
	private ItemEntity item;

	@Column(name = "quantity")
	private Integer quantity;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the item
	 */
	public ItemEntity getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(ItemEntity item) {
		this.item = item;
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
