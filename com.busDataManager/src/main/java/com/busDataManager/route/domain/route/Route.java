package com.busDataManager.route.domain.route;

import com.busDataManager.route.domain.stop.Stop;
import lombok.Generated;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.ddd.annotation.Identity;

import java.util.List;

/**
 * Route Aggregate Root
 */
@Generated
@AggregateRoot
public class Route {

    /**
     * Identifier for the route
     */
    @Identity
    private String id;

    /**
     * Name of the route
     */
    private String name;

    /**
     * List of stops for the route
     */
    private List<Stop> stops;

    /**
     * Schedules of the route
     */
    private List<String> schedules;
}
