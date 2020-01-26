package com.xsis.xsis.services.rio;

import com.xsis.xsis.model.rio.BiodataEntityRio;
import com.xsis.xsis.repository.rio.BiodataRepositoryRio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BiodataSeviceRio
{
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");

    @Autowired
    private BiodataRepositoryRio biodataRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public Iterable<BiodataEntityRio> getBiodataEntity()
    {
        List<BiodataEntityRio> biodataEntities = new ArrayList<>();
        for(BiodataEntityRio biodataEntity : biodataRepository.findAll()){
            if(!biodataEntity.getIsDelete()){
                biodataEntities.add(biodataEntity);
            }
        }
        return biodataEntities;
    }

    public Optional<BiodataEntityRio> findBiodataById(Long biodataId)
    {
        return biodataRepository.findById(biodataId);
    }

    public BiodataEntityRio saveBiodata(BiodataEntityRio biodataEntity)
    {
        biodataEntity.setCreatedBy((long) 1);
        biodataEntity.setCreatedOn(new Date());
        return biodataRepository.save(biodataEntity);
    }

    public BiodataEntityRio updateBiodata(BiodataEntityRio biodataEntity)
    {
        BiodataEntityRio biodataDetail = biodataRepository.findById(biodataEntity.getId()).get();
        biodataDetail.setModifiedBy((long) 1);
        biodataDetail.setModifiedOn(new Date());
        biodataDetail.setBiodataId(biodataEntity.getBiodataId());
        biodataDetail.setToken(biodataEntity.getToken());
        biodataDetail.setExpiredToken(biodataEntity.getExpiredToken());
        biodataDetail.setEmail(biodataEntity.getEmail());
        return biodataRepository.save(biodataDetail);
    }

    public BiodataEntityRio hideBiodata(Long id)
    {
        BiodataEntityRio biodataEntity = biodataRepository.findById(id).get();
        biodataEntity.setIsDelete(true);
        return biodataRepository.save(biodataEntity);
    }

    public void deleteBiodata(Long biodataId)
    {
        biodataRepository.deleteById(biodataId);
    }

    public BiodataEntityRio sendEmailBiodata(BiodataEntityRio biodataEntity)
    {
        BiodataEntityRio biodataDetail = biodataRepository.findById(biodataEntity.getId()).get();
        biodataDetail.setModifiedBy((long) 1);
        biodataDetail.setModifiedOn(new Date());
        biodataDetail.setToken(biodataEntity.getToken());
        biodataDetail.setExpiredToken(biodataEntity.getExpiredToken());
        biodataRepository.save(biodataDetail);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, dd MMM yyyy");
        String stringGetExpiredToken = simpleDateFormat.format(biodataEntity.getExpiredToken());

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(biodataEntity.getEmail());
        simpleMailMessage.setSubject("Token");
        simpleMailMessage.setText("Token: " + biodataEntity.getToken() + "\n Expired Token: " + stringGetExpiredToken);
        try{
            javaMailSender.send(simpleMailMessage);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return biodataDetail;
    }
}
