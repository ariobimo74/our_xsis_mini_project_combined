package com.xsis.xsis.repository.dhika;

import java.util.List;

import com.xsis.xsis.model.dhika.PermissionDika;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * PermissionReposotory
 */
@Repository
public interface PermissionRepositoryDika extends PagingAndSortingRepository<PermissionDika, Long> {

    @Query("SELECT p FROM PermissionDika p WHERE p.isDelete = FALSE and p.status = 'Submitted' ORDER BY p.permissionTime")
    List<PermissionDika> getPermissionApproval();

    @Query("SELECT p FROM PermissionDika p WHERE p.isDelete = FALSE ORDER BY p.permissionTime")
    List<PermissionDika> getPermissionHistory();

    @Query(value = "SELECT * FROM x_permission WHERE isdelete = false AND (CAST(permission_time as varchar) BETWEEN :sd AND :ed) ORDER BY permission_time", nativeQuery = true)
    List<PermissionDika> searchPermission(@Param("sd") String startDate, @Param("ed") String endDate);

    @Query(value = "SELECT * FROM x_permission WHERE isdelete = false AND status = 'Submitted' AND (CAST(permission_time as varchar) BETWEEN :sd AND :ed) ORDER BY permission_time", nativeQuery = true)
    List<PermissionDika> searchPermissionApproval(@Param("sd") String startDate, @Param("ed") String endDate);

    // @Query(value = "SELECT * FROM x_permission WHERE isdelete = false AND
    // (CAST(permission_time as varchar) permission_time >= :sd AND permission_time
    // < :ed )", nativeQuery = true)
    // List<Permission> searchPermission(@Param("sd") String startDate, @Param("ed")
    // String endDate);

}