package com.busDataManager.route.domain.stop;

import com.busDataManager.core.persistence.InsertableRepository;
import lombok.Generated;
import org.springframework.data.repository.ListCrudRepository;

@Generated
public interface StopRepository
        extends ListCrudRepository<Stop, String>, InsertableRepository<Stop> {
}
