package com.xsis.xsis.model.kur;

import javax.persistence.*;
import com.xsis.xsis.models.common.CommonEntity;

@Entity
@Table(name = "x_rencana_jadwal_detail")
public class RencanaDetailKur extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rencana_jadwal_id", referencedColumnName = "id")
    private RencanaJadwalKur rencanaJadwalId;

    @ManyToOne
    @JoinColumn(name = "biodata_id", referencedColumnName = "id")
    private BiodataKur biodataId;

    public RencanaDetailKur() {
    }

    public RencanaDetailKur(Long id, RencanaJadwalKur rencanaJadwalId, BiodataKur biodataId) {
        this.id = id;
        this.rencanaJadwalId = rencanaJadwalId;
        this.biodataId = biodataId;
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return RencanaJadwal return the rencanaJadwalId
     */
    public RencanaJadwalKur getRencanaJadwalId() {
        return rencanaJadwalId;
    }

    /**
     * @param rencanaJadwalId the rencanaJadwalId to set
     */
    public void setRencanaJadwalId(RencanaJadwalKur rencanaJadwalId) {
        this.rencanaJadwalId = rencanaJadwalId;
    }

    /**
     * @return Biodata return the biodataId
     */
    public BiodataKur getBiodataId() {
        return biodataId;
    }

    /**
     * @param biodataId the biodataId to set
     */
    public void setBiodataId(BiodataKur biodataId) {
        this.biodataId = biodataId;
    }

}