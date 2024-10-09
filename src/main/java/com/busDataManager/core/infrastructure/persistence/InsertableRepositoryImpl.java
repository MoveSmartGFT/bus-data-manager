package com.busDataManager.core.infrastructure.persistence;

import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.stereotype.Component;

@Component
public class InsertableRepositoryImpl<T> implements InsertableRepository<T> {

    private final JdbcAggregateTemplate template;

    public InsertableRepositoryImpl(JdbcAggregateTemplate template) {
        this.template = template;
    }

    @Override
    public <S extends T> S insert(S entity) {
        return template.insert(entity);
    }
}