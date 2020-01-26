package com.xsis.xsis.restapi.dhika;

import java.util.Optional;

import com.xsis.xsis.model.dhika.RoleDika;
import com.xsis.xsis.services.dhika.RoleServicesDika;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
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
 * RoleAPI
 */
@RestController
@RequestMapping(path = "/api/role", produces = "application/json")
@CrossOrigin(origins = "*")
public class RoleAPIDika {

    @Autowired
    private RoleServicesDika roleService;

    @GetMapping
    public ResponseEntity<?> findRoleCode() {
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllRolePaging")
    public ResponseEntity<?> findRolePaging() {
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    // @GetMapping("/getAllRoleAscending")
    // public ResponseEntity<?> RoleAscending() {
    // return new ResponseEntity<>(roleService.getAllRoleAscending(),
    // HttpStatus.OK);
    // }

    // @GetMapping("/getAllRoleDescending")
    // public ResponseEntity<?> RoleDescending() {
    // return new ResponseEntity<>(roleService.getAllRoleDescending(),
    // HttpStatus.OK);
    // }

    // @GetMapping("getAllRole")
    // public ResponseEntity<?> getAllRole(@RequestParam(defaultValue = "0") Integer
    // pageNo,
    // @RequestParam(defaultValue = "10") Integer pageSize,
    // @RequestParam(defaultValue = "name") String sortBy){

    // return new ResponseEntity<>(roleService.findAllRoles(pageNo, pageSize,
    // sortBy), HttpStatus.OK);
    // }

    @GetMapping("/searchLikeCodeOrName")
    public ResponseEntity<Iterable<RoleDika>> getAllRole(@RequestParam String code, @RequestParam String name) {
        Iterable<RoleDika> list = roleService.searchRoleByCodeOrName(code, name);

        return new ResponseEntity<Iterable<RoleDika>>(list, HttpStatus.OK);
    }

    @GetMapping("validatorcode")
    public RoleDika ValidatorRole(@RequestParam String code) {
        return roleService.searchCode(code);
    }

    @GetMapping("/{id}")
    public Optional<RoleDika> getId(@PathVariable(value = "id") Long id) {
        return roleService.getById(id);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public RoleDika addRole(@RequestBody RoleDika role) {
        return roleService.save(role);
    }

    @PutMapping(path = "/{id}")
    public RoleDika editRole(@RequestBody RoleDika role) {
        return roleService.update(role);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public RoleDika deleteRole(@PathVariable("id") Long id) {
        return roleService.delete(id);
    }
}