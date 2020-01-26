package com.xsis.xsis.repository.eko;

import com.xsis.xsis.models.entity.IdentitasTypeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * IdentitasRepository
 */
@Repository
public interface IdentitasRepository extends JpaRepository<IdentitasTypeEntity, Long> {

}