package com.busDataManager.route.infrastructure.api.stop;

import com.busDataManager.route.domain.stop.Stop;
import com.busDataManager.route.domain.stop.StopManagementUseCase;
import com.busDataManager.route.infrastructure.api.route.RouteController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(StopController.STOP_PATH)
@Slf4j
@RequiredArgsConstructor
public class StopController {

    public static final String STOP_PATH =
            RouteController.ROUTE_PATH + RouteController.ROUTE_ID_PATH + "/stops";
    public static final String STOP_ID_PATH = "/{stopId}";

    private StopManagementUseCase stopManagementUseCase;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Stop create(@Valid @RequestBody Stop stop) {
        return stopManagementUseCase.create(stop);
    }
}