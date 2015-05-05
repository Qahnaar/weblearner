package com.bestteam.service;

import java.util.List;

public interface WebLearnerService<T> {
	void save(T entity);

	T get(long entityId);

	void update(T entity);

	void delete(T entity);

	List<T> getAll();
}
