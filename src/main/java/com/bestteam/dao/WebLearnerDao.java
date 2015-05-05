package com.bestteam.dao;

import java.util.List;

public interface WebLearnerDao<T> {

	void create(T entity);

	T read(long entityId);

	void update(T entity);

	void delete(T entity);

	List<T> readAll();
}
