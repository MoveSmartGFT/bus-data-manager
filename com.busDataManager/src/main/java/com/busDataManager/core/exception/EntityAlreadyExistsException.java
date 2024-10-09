package com.busDataManager.core.exception;

import lombok.Getter;

@Getter
public class EntityAlreadyExistsException extends RuntimeException {
    private final String objectType;
    private final String id;

    public EntityAlreadyExistsException(String objectType, String id) {
        super("%s with id %s already exists".formatted(objectType, id));
        this.objectType = objectType;
        this.id = id;
    }
}
