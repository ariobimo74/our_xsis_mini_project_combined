package com.xsis.xsis.repository.fathan;

import com.xsis.xsis.model.fathan.entity.PengalamanKerjaFathan;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

/**
 * PengalamanKerjaRepository
 */
@RestController
public interface PengalamanKerjaRepositoryFathan extends CrudRepository<PengalamanKerjaFathan, Long> {

}