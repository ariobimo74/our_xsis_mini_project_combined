package com.xsis.xsis.services.dhika.implementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.xsis.xsis.model.dhika.PermissionDika;
import com.xsis.xsis.repository.dhika.PermissionRepositoryDika;
import com.xsis.xsis.services.dhika.PermissionServicesDika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PermissionServicesImpl
 */
@Service
@Transactional
public class PermissionServicesImplDika implements PermissionServicesDika {

    @Autowired
    private PermissionRepositoryDika permissionRepository;

    @Override
    public PermissionDika save(PermissionDika permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public Optional<PermissionDika> getPermissionById(Long id) {
        return permissionRepository.findById(id);
    }

    @Override
    public List<PermissionDika> getPermissionApproval() {
        return permissionRepository.getPermissionApproval();
    }

    @Override
    public List<PermissionDika> getPermissionHistory() {
        return permissionRepository.getPermissionHistory();
    }

    @Override
    public List<PermissionDika> getResultSearchDatePermission(String startDate, String endDate) {
        return permissionRepository.searchPermission(startDate, endDate);
    }

    @Override
    public List<PermissionDika> getResultSearchDatePermissionApproval(String startDate, String endDate) {
        return permissionRepository.searchPermissionApproval(startDate, endDate);
    }

}