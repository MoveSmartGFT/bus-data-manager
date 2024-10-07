package com.busDataManager.route.domain.schedule;

import org.jmolecules.ddd.annotation.ValueObject;

import java.time.LocalDateTime;

@ValueObject
public class Schedule {
    private String typeOfDay;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer frequencyInMinutes;

    public Schedule(String typeOfDay, LocalDateTime startTime, LocalDateTime endTime, Integer frequencyInMinutes) {
        this.typeOfDay = typeOfDay;
        this.startTime = startTime;
        this.endTime = endTime;
        this.frequencyInMinutes = frequencyInMinutes;
    }

    public String getTypeOfDay() {
        return typeOfDay;
    }
}
