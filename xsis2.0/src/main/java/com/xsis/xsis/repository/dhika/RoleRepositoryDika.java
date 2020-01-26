package com.xsis.xsis.repository.dhika;

import java.util.List;

import com.xsis.xsis.dto.dhika.RoleDtoDika;
import com.xsis.xsis.model.dhika.RoleDika;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * RoleRepository
 */
@Repository
public interface RoleRepositoryDika extends PagingAndSortingRepository<RoleDika, Long> {

    @Query("SELECT r FROM RoleDika r WHERE r.isDelete = FALSE AND (LOWER(r.code) LIKE LOWER(CONCAT('%', ?1,'%')) OR LOWER(r.name) LIKE LOWER(CONCAT('%', ?2,'%')))")
    Iterable<RoleDika> findByCodeOrNameIgnoreCase(String code, String name);

    @Query("SELECT r FROM RoleDika r WHERE r.isDelete = FALSE AND r.code = '?1'")
    RoleDika findByEmail(String code);

    // @Query(nativeQuery = true)
    // Iterable<RoleDto> getRoleAll();
    // @Query("SELECT r FR")

    // @Override
    // @Query("SELECT r FROM Role r WHERE r.isDelete=false")
    // default Page<Role> findAll(Pageable p) {
    // if (p.getSort() == null) {
    // // The default sort order
    // Page<Role> pagedResult = roleRepository.findAll(paging);
    // return pagedResult;
    // }
    // return findBy(pageable);
    // }

    @Query(nativeQuery = true)
    List<RoleDtoDika> getRoleAll();

    @Query("SELECT r FROM RoleDika r WHERE r.isDelete=false ORDER BY r.name asc")
    Iterable<RoleDika> getAllRoleAscending();

    @Query("SELECT r FROM RoleDika r WHERE r.isDelete=false ORDER BY r.name desc")
    Iterable<RoleDika> getAllRoleDescending();

    @Override
    @Query("SELECT r FROM RoleDika r WHERE r.isDelete=false")
    Page<RoleDika> findAll(Pageable pageable);

}