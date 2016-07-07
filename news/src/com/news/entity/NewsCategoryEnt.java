package com.news.entity;

public class NewsCategoryEnt {
	private int categoryId;
	private String category;
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "NewsCategoryEnt [categoryId=" + categoryId + ", category=" + category + "]";
	}
	
}
