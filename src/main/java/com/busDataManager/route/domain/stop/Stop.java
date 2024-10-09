package com.busDataManager.route.domain.stop;

import com.busDataManager.route.domain.route.Route;
import jakarta.validation.Valid;
import com.busDataManager.route.domain.Coordinates;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@Getter
@Entity
@RequiredArgsConstructor
@Generated
public class Stop {

    /**
     * Identifier for the stop
     */
    @Identity
    @Id
    @Valid
    @NotBlank
    private String id;

    /**
     * Name of the stop
     */
    @NotBlank
    private String name;

    /**
     * Location of the stop
     */
    @Valid
    @NotNull
    private Coordinates location;

    /**
     * Routes which contains that stop
     */
    @NotNull
    private AggregateReference<Route, String> routes;

    public @Valid @NotBlank String getId() {
        return id;
    }
}