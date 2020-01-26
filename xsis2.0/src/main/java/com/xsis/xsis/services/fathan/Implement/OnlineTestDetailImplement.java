package com.xsis.xsis.services.fathan.Implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.fathan.OnlineTestDetailDto;
import com.xsis.xsis.model.fathan.OnlineTestDetail;
import com.xsis.xsis.repository.fathan.OnlineTestDetailRepository;
import com.xsis.xsis.services.fathan.OnlineTestDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * OnlineTestDetailImplement
 */
@Service
public class OnlineTestDetailImplement implements OnlineTestDetailService {

    @Autowired
    private OnlineTestDetailRepository onlineTestDetailRepository;

    @Override
    public List<OnlineTestDetail> getAll() {
        List<OnlineTestDetail> otd = new ArrayList<>();
        for (OnlineTestDetail oltd : onlineTestDetailRepository.findAll()) {
            if (!oltd.getIsDelete()) {
                otd.add(oltd);
            }
        }
        return otd;
    }

    @Override
    public Optional<OnlineTestDetail> getById(Long id) {
        return onlineTestDetailRepository.findById(id);
    }

    @Override
    public OnlineTestDetail save(OnlineTestDetail onlineTestDetail) {
        onlineTestDetail.setCreatedBy(9L);
        onlineTestDetail.setCreatedOn(new Date());
        onlineTestDetail.setIsDelete(false);

        return onlineTestDetailRepository.save(onlineTestDetail);
    }

    @Override
    public OnlineTestDetail edit(OnlineTestDetail onlineTestDetail) {
        OnlineTestDetail otd = onlineTestDetailRepository.findById(onlineTestDetail.getId()).get();
        otd.setModifiedBy(9L);
        otd.setModifiedOn(new Date());
        otd.setId(onlineTestDetail.getId());
        otd.setTestTypeId(onlineTestDetail.getTestTypeId());
        otd.setTestOrder(onlineTestDetail.getTestOrder());
        return onlineTestDetailRepository.save(otd);
    }

    @Override
    public OnlineTestDetail delete(Long id) {
        OnlineTestDetail otd = onlineTestDetailRepository.findById(id).get();
        otd.setDeletedBy(9L);
        otd.setDeleteddOn(new Date());
        otd.setIsDelete(true);
        return onlineTestDetailRepository.save(otd);
    }

    @Override
    public List<OnlineTestDetailDto> getOltId(Long onlineTestId) {
        return onlineTestDetailRepository.getOltId(onlineTestId);
    }

    @Override
    public Iterable<OnlineTestDetail> getLastOrder(Long onlineTestId) {
        return onlineTestDetailRepository.getLastOrder(onlineTestId);
    }

}