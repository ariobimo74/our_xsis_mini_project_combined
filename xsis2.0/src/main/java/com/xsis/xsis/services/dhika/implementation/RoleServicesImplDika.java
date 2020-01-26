package com.xsis.xsis.services.dhika.implementation;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import com.xsis.xsis.dto.dhika.RoleDtoDika;
import com.xsis.xsis.model.dhika.RoleDika;
import com.xsis.xsis.repository.dhika.RoleRepositoryDika;
import com.xsis.xsis.services.dhika.RoleServicesDika;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * RoleServicesImpl
 */
@Service
@Transactional
public class RoleServicesImplDika implements RoleServicesDika {

    @Autowired
    private RoleRepositoryDika roleRepository;

    @Override
    public Iterable<RoleDtoDika> findAll() {
        return roleRepository.getRoleAll();
    }

    @Override
    public Iterable<RoleDika> getAllRoleAscending() {
        return roleRepository.getAllRoleAscending();
    }

    @Override
    public Iterable<RoleDika> getAllRoleDescending() {
        return roleRepository.getAllRoleDescending();
    }

    @Override
    public Optional<RoleDika> getById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public RoleDika save(RoleDika role) {
        role.setCreatedBy(2L);
        role.setCreatedOn(new Date());
        role.setIsDelete(false);
        return roleRepository.save(role);
    }

    @Override
    public RoleDika update(RoleDika role) {
        RoleDika roleDetail = roleRepository.findById(role.getId()).get();
        roleDetail.setCode(role.getCode());
        roleDetail.setName(role.getName());
        roleDetail.setModifiedBy(2L);
        roleDetail.setModifiedOn(new Date());

        return roleRepository.save(roleDetail);
    }

    @Override
    public RoleDika delete(Long id) {
        RoleDika roleEntity = roleRepository.findById(id).get();
        roleEntity.setIsDelete(true);
        roleEntity.setDeletedBy(2L);
        roleEntity.setDeleteddOn(new Date());
        return roleRepository.save(roleEntity);
    }

    // @Override
    // public Iterable<RoleDto> getAllRole(Integer pageNo, Integer pageSize, String
    // sortBy){
    // Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
    // //Page<RoleDto> pagedResult = roleRepository.getRoleAll();
    // Page<RoleDto> pagedResult = roleRepository.getRoleAll(paging);
    // return pagedResult.getContent();

    // }

    @Override
    public Iterable<RoleDika> searchRoleByCodeOrName(String code, String name) {
        return roleRepository.findByCodeOrNameIgnoreCase(code, name);
    }

    @Override
    public RoleDika searchCode(String code) {
        return roleRepository.findByEmail(code);
    }
}