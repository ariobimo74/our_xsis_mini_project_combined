package com.xsis.xsis.services.dhika;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.dhika.TimePeriodDika;

/**
 * TimePeriodServices
 */
public interface TimePeriodServicesDika {

    public List<TimePeriodDika> findAll();

    Optional<TimePeriodDika> getById(Long id);

    TimePeriodDika save(TimePeriodDika timePeriod);

    TimePeriodDika update(TimePeriodDika timePeriod);

    TimePeriodDika delete(Long id);

}