package com.busDataManager.route.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Generated;
import org.jmolecules.ddd.types.ValueObject;

@Generated
public record Coordinates (
        @NotNull @Min(value = -90) @Max(value = 90) String latitude,
        @NotNull @Min(value = -180) @Max(value = 180) String longitude
) implements ValueObject { }