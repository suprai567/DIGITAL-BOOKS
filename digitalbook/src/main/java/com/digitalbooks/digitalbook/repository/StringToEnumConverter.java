package com.digitalbooks.digitalbook.repository;

import org.springframework.core.convert.converter.Converter;

import com.digitalbooks.digitalbook.entity.Category;

public class StringToEnumConverter implements Converter<String, Category> {

	@Override
	public Category convert(String source) {
		return Category.valueOf(source.toUpperCase());
	}

}
