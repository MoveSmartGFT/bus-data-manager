package com.busDataManager.route.application.stop;

import com.busDataManager.core.exception.EntityAlreadyExistsException;
import com.busDataManager.route.domain.stop.Stop;
import com.busDataManager.route.domain.stop.StopManagementUseCase;
import com.busDataManager.route.domain.stop.StopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class StopManagementUseCaseImpl implements StopManagementUseCase {

    private StopRepository stopRepository;

    /**
     * @param stop data
     * @return Stop
     */
    @Override
    public Stop create(Stop stop) {
        if (stopRepository.existsById(stop.getId()))
            throw new EntityAlreadyExistsException(STOP, stop.getId());

        return stopRepository.insert(stop);
    }
}
