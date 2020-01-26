package com.xsis.xsis.restapi.fathan;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.fathan.OnlineTestDetail;
import com.xsis.xsis.services.fathan.OnlineTestDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * OnlineTestDetailAPI
 */
@RestController
@RequestMapping(path = "api/onlineDetail", produces = "application/json")
@CrossOrigin(origins = "*")
public class OnlineTestDetailAPI {
    @Autowired
    private OnlineTestDetailService onlineTestDetailService;

    @GetMapping("/")
    public List<OnlineTestDetail> GetAll() {
        return onlineTestDetailService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<OnlineTestDetail> getById(@PathVariable("id") Long id) {
        return onlineTestDetailService.getById(id);
    }

    @PostMapping(path = "/post", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public OnlineTestDetail addDetail(@RequestBody OnlineTestDetail onlineTestDetail) {
        return onlineTestDetailService.save(onlineTestDetail);
    }

    @PutMapping(path = "/{id}")
    public OnlineTestDetail editDetail(@RequestBody OnlineTestDetail onlineTestDetail) {
        return onlineTestDetailService.edit(onlineTestDetail);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public OnlineTestDetail deleteDetail(@PathVariable("id") Long id) {
        return onlineTestDetailService.delete(id);
    }

    @GetMapping("/onlineTestDetail/{online_test_id}")
    public ResponseEntity<?> findBioId(@PathVariable("online_test_id") Long onlineTestId) {
        return new ResponseEntity<>(onlineTestDetailService.getOltId(onlineTestId), HttpStatus.OK);
    }

    @GetMapping("/lastOrder")
    public Iterable<OnlineTestDetail> findLastOrder(@RequestParam(name = "onlineTestId") Long onlineTestId) {
        return onlineTestDetailService.getLastOrder(onlineTestId);
    }
}