package com.bestteam.converter;

public interface WebLearnerConverter<T, E> {
	E convertToDto(T entity);

	T convertToEntity(E dto);
}
