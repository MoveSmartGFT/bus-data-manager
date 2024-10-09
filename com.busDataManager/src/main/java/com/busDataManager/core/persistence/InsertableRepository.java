package com.busDataManager.core.persistence;

public interface InsertableRepository<T> {
    <S extends T> S insert(S entity);
}
