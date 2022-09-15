package com.digitalbooks.digitalbook.entity;

public enum Category {
	COMIC("comic"), HORROR("horror"), ACTION("action"), DRAMA("drama"), ADVENTURE("adventure");

	private final String value;

	Category(String value) {
		this.value = value;
		// TODO Auto-generated constructor stub
	}

	public String getValue() {
		return value;
	}

	public static Category findByValue(String category2) {
		System.out.println("Hello");
		Category result = null;
		for (Category category : Category.values()) {
			if (category.getValue().equalsIgnoreCase(category2)) {
				result = category;
				break;
			}
		}
		return result;
	}
}
