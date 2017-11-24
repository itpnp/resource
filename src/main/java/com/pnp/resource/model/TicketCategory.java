package com.pnp.resource.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kategori")
public class TicketCategory {

	@Id
	@Column(name="id_kategori")
	private int categoryId;
	
	@Column(name="nama_kategori")
	private String categoryName;
	
	@Column(name="status")
	private String status;

	
	public TicketCategory() {
		super();
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
