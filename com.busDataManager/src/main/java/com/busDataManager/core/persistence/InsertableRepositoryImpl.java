package com.busDataManager.core.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsertableRepositoryImpl<T> implements InsertableRepository<T> {

    private final JdbcAggregateTemplate template;

    @Override
    public <S extends T> S insert(S entity) {
        return template.insert(entity);
    }
}