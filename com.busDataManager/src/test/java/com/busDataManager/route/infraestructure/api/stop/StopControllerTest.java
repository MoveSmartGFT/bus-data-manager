package com.busDataManager.route.infraestructure.api.stop;

import com.busDataManager.core.exception.EntityAlreadyExistsException;
import com.busDataManager.route.RouteInstancioModels;
import com.busDataManager.route.domain.stop.Stop;
import com.busDataManager.route.domain.stop.StopManagementUseCase;
import com.busDataManager.route.infrastructure.api.stop.StopController;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.javacrumbs.jsonunit.core.Option;
import org.instancio.Instancio;
import org.instancio.junit.InstancioExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static net.javacrumbs.jsonunit.spring.JsonUnitResultMatchers.json;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@ExtendWith(InstancioExtension.class)
public class StopControllerTest {

    private MockMvc mockMvc;

    @Mock
    private StopManagementUseCase stopManagementUseCase;

    @Autowired
    private ObjectMapper objectMapper;

    Stop stop = Instancio.create(RouteInstancioModels.STOP_MODEL);

    @Test
    @DisplayName("WHEN a stop creation request is received THEN returns stop object and status 201")
    void testStopCreate() throws Exception {
        when(stopManagementUseCase.create(stop)).thenReturn(stop);

        mockMvc.perform(
                        post(StopController.STOP_PATH)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content(objectMapper.writeValueAsString(stop))
                )
                .andExpect(status().isCreated())
                .andExpect(json().when(Option.TREATING_NULL_AS_ABSENT).isEqualTo(objectMapper.writeValueAsString(stop)));
    }

    @Test
    @DisplayName("WHEN a stop creation request is received WHEN stop already exists THEN returns status 409")
    void testStopCreateConflict() throws Exception {
        when(stopManagementUseCase.create(stop))
                .thenThrow(new EntityAlreadyExistsException("Stop", stop.getId()));

        mockMvc.perform(
                        post(StopController.STOP_PATH)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content(objectMapper.writeValueAsString(stop))
                )
                .andExpect(status().isConflict());
    }

    @Test
    @DisplayName("WHEN a stop creation request is received WHEN is a bad request THEN returns status 400")
    void testStopCreateBadRequest() throws Exception {
        mockMvc.perform(
                        post(StopController.STOP_PATH)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content("Stop")
                )
                .andExpect(status().isBadRequest());
    }
}
