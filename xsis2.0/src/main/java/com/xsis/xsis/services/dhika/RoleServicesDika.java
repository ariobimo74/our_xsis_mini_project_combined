package com.xsis.xsis.services.dhika;

import java.util.Optional;

import com.xsis.xsis.dto.dhika.RoleDtoDika;
import com.xsis.xsis.model.dhika.RoleDika;

/**
 * RoleServices
 */

public interface RoleServicesDika {

    Iterable<RoleDtoDika> findAll();

    Iterable<RoleDika> getAllRoleAscending();

    Iterable<RoleDika> getAllRoleDescending();

    // Iterable<Role> findAllRoles(Integer pageNo, Integer pageSize, String sortBy);
    // Iterable<RoleDto> getAllRole(Integer pageNo, Integer pageSize, String
    // sortBy);
    Iterable<RoleDika> searchRoleByCodeOrName(String code, String name);

    RoleDika searchCode(String code);

    Optional<RoleDika> getById(Long id);

    RoleDika save(RoleDika role);

    RoleDika update(RoleDika role);

    RoleDika delete(Long id);

}