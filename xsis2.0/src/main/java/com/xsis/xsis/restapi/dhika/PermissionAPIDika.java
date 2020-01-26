package com.xsis.xsis.restapi.dhika;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.dhika.PermissionDika;
import com.xsis.xsis.services.dhika.PermissionServicesDika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * PermissionAPI
 */
@RestController
@RequestMapping(path = "/api/permission", produces = "application/json")
@CrossOrigin(origins = "*")
public class PermissionAPIDika {

    @Autowired
    private PermissionServicesDika permissionServices;

    @GetMapping("/permissionApproval")
    public ResponseEntity<?> permissionApproval() {
        return new ResponseEntity<>(permissionServices.getPermissionApproval(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<PermissionDika> getId(@PathVariable(value = "id") Long id) {
        return permissionServices.getPermissionById(id);
    }

    @GetMapping("/permissionHistory")
    public ResponseEntity<?> permissionHistory() {
        return new ResponseEntity<>(permissionServices.getPermissionHistory(), HttpStatus.OK);
    }

    @GetMapping("/searchDate")
    public List<PermissionDika> searchDate(@RequestParam(name = "sd") String startDate,
            @RequestParam(name = "ed") String endDate) {
        return permissionServices.getResultSearchDatePermission(startDate, endDate);
    }

    @GetMapping("/searchDate2")
    public List<PermissionDika> searchDateApproval(@RequestParam(name = "sd") String startDate,
            @RequestParam(name = "ed") String endDate) {
        return permissionServices.getResultSearchDatePermissionApproval(startDate, endDate);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public PermissionDika postPermission(@RequestBody PermissionDika permission) {
        permission.setCreatedBy(3L);
        permission.setCreatedOn(new Date());
        permission.setIsDelete(false);
        permission.setStatus("Submitted");
        return permissionServices.save(permission);
    }

    @PutMapping("/{id}")
    public PermissionDika approvalPermission(@PathVariable(value = "id") Long id) {
        PermissionDika per = permissionServices.getPermissionById(id).get();
        per.setStatus("Approved");
        per.setIsDelete(false);
        return permissionServices.save(per);
    }

    @DeleteMapping("/{id}")
    public PermissionDika rejectedPermission(@PathVariable(value = "id") Long id) {
        PermissionDika permission = permissionServices.getPermissionById(id).get();
        permission.setStatus("Rejected");
        permission.setIsDelete(false);
        return permissionServices.save(permission);
    }

}