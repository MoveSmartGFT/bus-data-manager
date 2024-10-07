package com.busDataManager.route.domain.stop;

import com.busDataManager.route.domain.schedule.Schedule;
import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;

import java.util.List;

@Entity
public class Stop {

    @Identity
    private String id;
    private String nombre;
    private List<Stop> stops;
    private List<Schedule> schedule;

    public Stop(String id, String nombre, List<Stop> stops, List<Schedule> schedule) {
        this.id = id;
        this.nombre = nombre;
        this.stops = stops;
        this.schedule = schedule;
    }
}
