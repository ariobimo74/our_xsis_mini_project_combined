package com.xsis.xsis.repository.dhika;

import com.xsis.xsis.model.dhika.ClientDika;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ClientRepository
 */
@Repository
public interface ClientRepositoryDika extends JpaRepository<ClientDika, Long> {

}