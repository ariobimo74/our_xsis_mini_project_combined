package com.xsis.xsis.repository.dhika;

import java.util.List;

import com.xsis.xsis.model.dhika.PlacementDika;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * PlacementRepository
 */
@Repository
public interface PlacementRepositoryDika extends JpaRepository<PlacementDika, Long> {

    static final String myQ = "SELECT a.* FROM x_placement a JOIN x_employee b ON a.employee_id = b.id WHERE b.is_ero = false";

    @Query(value = myQ, nativeQuery = true)
    List<PlacementDika> getAll();

}