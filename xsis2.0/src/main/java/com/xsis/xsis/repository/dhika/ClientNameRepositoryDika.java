package com.xsis.xsis.repository.dhika;

import com.xsis.xsis.model.dhika.ClientnameDika;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ClientNameRepository
 */
@Repository
public interface ClientNameRepositoryDika extends JpaRepository<ClientnameDika, Long> {

}