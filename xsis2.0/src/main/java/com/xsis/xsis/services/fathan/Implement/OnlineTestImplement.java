package com.xsis.xsis.services.fathan.Implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.fathan.OnlineTestDto;
import com.xsis.xsis.model.fathan.OnlineTest;
import com.xsis.xsis.repository.fathan.OnlineTestRepository;
import com.xsis.xsis.services.fathan.OnlineTestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * OnlineTestImplement
 */
@Service
public class OnlineTestImplement implements OnlineTestService {

    @Autowired
    private OnlineTestRepository onlineTestRepository;

    @Override
    public List<OnlineTest> getAll() {
        List<OnlineTest> ot = new ArrayList<>();
        for (OnlineTest olt : onlineTestRepository.findAll()) {
            if (!olt.getIsDelete()) {
                ot.add(olt);
            }
        }
        return ot;
    }

    @Override
    public Optional<OnlineTest> getById(Long id) {
        return onlineTestRepository.findById(id);
    }

    // int num = 0;

    @Override
    public OnlineTest save(OnlineTest onlineTest) {
        onlineTest.setCreatedBy(9L);
        onlineTest.setCreatedOn(new Date());
        onlineTest.setIsDelete(false);
        // num += 1;
        // String code = String.format("%04d", num);
        // onlineTest.setPeriodeCode("PRD" + code);
        onlineTest.setStatus("Proses");
        return onlineTestRepository.save(onlineTest);
    }

    @Override
    public OnlineTest edit(OnlineTest onlineTest) {
        onlineTest.setModifiedBy(9L);
        onlineTest.setModifiedOn(new Date());
        return onlineTestRepository.save(onlineTest);
    }

    @Override
    public OnlineTest delete(Long id) {
        OnlineTest ot = onlineTestRepository.findById(id).get();
        ot.setDeletedBy(9L);
        ot.setDeleteddOn(new Date());
        ot.setIsDelete(true);
        return onlineTestRepository.save(ot);
    }

    @Override
    public List<OnlineTestDto> getBioId(Long biodataId) {
        return onlineTestRepository.getBioId(biodataId);
    }

    @Override
    public Iterable<OnlineTest> getLastId() {
        return onlineTestRepository.getLastId();
    }

    @Override
    public Iterable<OnlineTest> getLastPeriod(Long id) {
        return onlineTestRepository.getLastPeriod(id);
    }

    @Override
    public OnlineTest ubahStatus(Long id) {
        OnlineTest ot = onlineTestRepository.getLastStatus(id);
        ot.setModifiedBy(9L);
        ot.setModifiedOn(new Date());
        ot.setStatus("Selesai");

        return onlineTestRepository.save(ot);
    }

    @Override
    public Iterable<OnlineTest> getLastCodePeriode() {
        return onlineTestRepository.getLastCodePeriode();
    }

}