package com.asdi.hris.claims.reimbursement.model;

import java.math.BigDecimal;

public class ItemizedExpense {

	private int id;

	private int crId;

	private String date;

	private String description;

	private String category;

	private BigDecimal cost;

	public ItemizedExpense() {
		// TODO Auto-generated constructor stub
	}

	public ItemizedExpense(String date, String description, String category,
			String cost) {
		super();
		this.date = date;
		this.description = description;
		this.category = category;
		this.cost = new BigDecimal(cost);
	}

	public ItemizedExpense(int id, int crId, String date, String description,
			String category, BigDecimal cost) {
		super();
		this.id = id;
		this.crId = crId;
		this.date = date;
		this.description = description;
		this.category = category;
		this.cost = cost;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCrId() {
		return crId;
	}

	public void setCrId(int crId) {
		this.crId = crId;
	}

}
