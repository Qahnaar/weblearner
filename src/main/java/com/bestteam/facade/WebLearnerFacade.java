package com.bestteam.facade;

import java.util.List;

public interface WebLearnerFacade<T, E> {

	void save(T entity);

	E get(long entityId);

	void update(T entity);

	void delete(T entity);

	List<E> getAll();
}
