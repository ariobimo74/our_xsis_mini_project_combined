package com.xsis.xsis.restapi.fathan;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.fathan.OnlineTest;
import com.xsis.xsis.services.fathan.OnlineTestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * OnlineTestAPI
 */
@RestController
@RequestMapping("api/onlineTest")
@CrossOrigin("*")
public class OnlineTestAPI {
    @Autowired
    private OnlineTestService onlineTestService;

    @GetMapping("/")
    public List<OnlineTest> getAll() {
        return onlineTestService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<OnlineTest> getId(@PathVariable(value = "id") Long id) {
        return onlineTestService.getById(id);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public OnlineTest addOT(@RequestBody OnlineTest onlineTest) {
        return onlineTestService.save(onlineTest);
    }

    @PutMapping(path = "/{id}")
    public OnlineTest editOT(@RequestBody OnlineTest onlineTest) {
        return onlineTestService.edit(onlineTest);
    }

    @DeleteMapping(path = "/{id}")
    public OnlineTest deleteOT(@PathVariable("id") Long id) {
        return onlineTestService.delete(id);
    }

    @GetMapping("/biodata/{biodata_id}")
    public ResponseEntity<?> findBioId(@PathVariable("biodata_id") Long biodataId) {
        return new ResponseEntity<>(onlineTestService.getBioId(biodataId), HttpStatus.OK);
    }

    @GetMapping("/lastId")
    public Iterable<OnlineTest> findLastId() {
        return onlineTestService.getLastId();
    }

    @GetMapping("/lastPeriod")
    public Iterable<OnlineTest> findLastPeriod(@RequestParam(name = "biodataId") Long id) {
        return onlineTestService.getLastPeriod(id);
    }

    @GetMapping("/lastCodePeriod")
    public Iterable<OnlineTest> findLastCodePeriod() {
        return onlineTestService.getLastCodePeriode();
    }

    @DeleteMapping("/ubahStatus")
    public OnlineTest changeStatus(@RequestParam(name = "biodataId") Long id) {
        return onlineTestService.ubahStatus(id);
    }

}