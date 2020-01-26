package com.xsis.xsis.repository.vac_prof_respro;

import java.util.List;

import com.xsis.xsis.model.vac_prof_respro.Biodata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * BiodataRepository
 */
public interface BiodataRepository extends JpaRepository<Biodata, Long> {

    @Query(value = "select * from x_biodata where ((LOWER(fullname) like LOWER(concat('%',:pelamar,'%'))) and isdelete = false) order by fullname", nativeQuery = true)
    List<Biodata> getPelamar(@Param("pelamar") String pelamar);

}