package com.hjj.pojo;

public class CategoryBean {
	private int categoryId;
	private String categoryName;
	private String categoryIntroduce;
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
	
	public String getCategoryIntroduce() {
		return categoryIntroduce;
	}
	public void setCategoryIntroduce(String categoryIntroduce) {
		this.categoryIntroduce = categoryIntroduce;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryIntroduce="
				+ categoryIntroduce + "]";
	}
	
	
}
