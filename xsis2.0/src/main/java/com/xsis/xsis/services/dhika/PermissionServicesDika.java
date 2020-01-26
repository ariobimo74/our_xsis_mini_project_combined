package com.xsis.xsis.services.dhika;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.dhika.PermissionDika;

import org.springframework.data.repository.query.Param;

/**
 * PermissionServices
 */
public interface PermissionServicesDika {

    // untuk Simpan Permission
    PermissionDika save(PermissionDika permission);

    // untuk Detail Permission
    Optional<PermissionDika> getPermissionById(@Param("id") Long id);

    // untuk Permission Approval
    List<PermissionDika> getPermissionApproval();

    // untuk Permission History
    List<PermissionDika> getPermissionHistory();

    // untuk Mendapatkan Permission Search Date
    List<PermissionDika> getResultSearchDatePermission(@Param("sd") String startDate, @Param("ed") String endDate);

    List<PermissionDika> getResultSearchDatePermissionApproval(@Param("sd") String startDate, @Param("ed") String endDate);

}