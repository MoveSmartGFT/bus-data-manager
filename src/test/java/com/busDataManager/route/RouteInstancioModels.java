package com.busDataManager.route;

import com.busDataManager.route.domain.route.Route;
import com.busDataManager.route.domain.stop.Stop;
import lombok.experimental.UtilityClass;
import org.instancio.Instancio;
import org.instancio.Model;

@UtilityClass
public class RouteInstancioModels {

    public static final Model<Stop> STOP_MODEL =
            Instancio.of(Stop.class)
            .toModel();

    public static final Model<Route> ROUTE_MODEL =
            Instancio.of(Route.class)
                    .toModel();
}
