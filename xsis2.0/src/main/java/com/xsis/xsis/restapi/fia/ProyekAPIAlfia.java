package com.xsis.xsis.restapi.fia;

import com.xsis.xsis.dto.fia.ProyekDtoAlfia;
import com.xsis.xsis.model.fia.RiwayatProyekAlfia;
import com.xsis.xsis.services.fia.ProyekServiceAlfia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/alfia/proyek")
public class ProyekAPIAlfia {

    @Autowired
    private ProyekServiceAlfia proyekService;

    @GetMapping("pengkerAll/{riwayat_pekerjaan_id}")
    public ResponseEntity<?> findRiwKerId(@PathVariable("riwayat_pekerjaan_id") Long riwayatPekerjaanId) {
        return new ResponseEntity<>(proyekService.getPengkerId(riwayatPekerjaanId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public RiwayatProyekAlfia getProyekId(@PathVariable(value = "id") Long id) {
        return proyekService.getById(id);
    }

    @PostMapping
    public ProyekDtoAlfia save(@RequestBody ProyekDtoAlfia proyekDto) {
        RiwayatProyekAlfia proy = new RiwayatProyekAlfia();
        proy.setRiwayatPekerjaanId(proyekDto.getRiwayatPekerjaanId());
        proy.setStartYear(proyekDto.getStartYear());
        proy.setStartMonth(proyekDto.getStartMonth());
        proy.setProjectName(proyekDto.getProjectName());
        proy.setProjectDuration(proyekDto.getProjectDuration());
        proy.setTimePeriodId(proyekDto.getTimePeriodId());
        proy.setClient(proyekDto.getClient());
        proy.setProjectPosition(proyekDto.getProjectPosition());
        proy.setDescription(proyekDto.getDescription());
        proyekService.save(proy);
        return proyekDto;
    }

    @PutMapping
    public ProyekDtoAlfia update(@RequestBody ProyekDtoAlfia proyekDto) {
        RiwayatProyekAlfia proy = new RiwayatProyekAlfia();
        proy.setId(proyekDto.getId());
        proy.setRiwayatPekerjaanId(proyekDto.getRiwayatPekerjaanId());
        proy.setStartYear(proyekDto.getStartYear());
        proy.setStartMonth(proyekDto.getStartMonth());
        proy.setProjectName(proyekDto.getProjectName());
        proy.setProjectDuration(proyekDto.getProjectDuration());
        proy.setTimePeriodId(proyekDto.getTimePeriodId());
        proy.setClient(proyekDto.getClient());
        proy.setProjectPosition(proyekDto.getProjectPosition());
        proy.setDescription(proyekDto.getDescription());
        proyekService.update(proy);
        return proyekDto;
    }

    @DeleteMapping("/{id}")
    public RiwayatProyekAlfia delete(@PathVariable(value = "id") Long id) {
        return proyekService.delete(id);
    }

}