package com.xsis.xsis.repository.fathan;

import com.xsis.xsis.model.fathan.BiodataFathan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

/**
 * BiodataRepository
 */
@RestController
public interface BiodataRepositoryFathan extends JpaRepository<BiodataFathan, Long> {

}