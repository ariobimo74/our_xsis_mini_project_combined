package com.xsis.xsis.repository.fia;

import java.util.List;

import com.xsis.xsis.dto.fia.ReferensiBioDtoAlfia;
import com.xsis.xsis.model.fia.ReferensiAlfia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * ReferensiRepository
 */
@Repository
public interface ReferensiRepositoryAlfia extends JpaRepository<ReferensiAlfia, Long> {
    @Query(nativeQuery = true)
    List<ReferensiBioDtoAlfia> getBioId(Long biodataId);

}