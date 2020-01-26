package com.xsis.xsis.model.fathan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.xsis.xsis.dto.fathan.OnlineTestDetailDto;
import com.xsis.xsis.models.common.CommonEntity;

/**
 * OnlineTestDetail
 */

@SqlResultSetMapping(name = "testTypeMapping", classes = @ConstructorResult(targetClass = OnlineTestDetailDto.class, columns = {
        @ColumnResult(name = "id", type = Long.class), @ColumnResult(name = "isdelete", type = Boolean.class),
        @ColumnResult(name = "online_test_id", type = Long.class),
        @ColumnResult(name = "name", type = String.class), }))

@NamedNativeQuery(name = "OnlineTestDetail.getOltId", query = "select b.id,b.isdelete,b.online_test_id,a.name from x_test_type a join x_online_test_detail b on a.id =b.test_type_id"
        + " where b.isdelete=false and b.online_test_Id=:onlineTestId order by test_order", resultSetMapping = "testTypeMapping")

@Entity
@Table(name = "x_online_test_detail")
public class OnlineTestDetail extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "online_test_id")
    private Long onlineTestId;

    @Column(name = "test_type_id")
    private Long testTypeId;

    @Column(name = "test_order")
    private Integer testOrder;

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
     * @return Long return the onlineTestId
     */
    public Long getOnlineTestId() {
        return onlineTestId;
    }

    /**
     * @param onlineTestId the onlineTestId to set
     */
    public void setOnlineTestId(Long onlineTestId) {
        this.onlineTestId = onlineTestId;
    }

    /**
     * @return Long return the testTypeId
     */
    public Long getTestTypeId() {
        return testTypeId;
    }

    /**
     * @param testTypeId the testTypeId to set
     */
    public void setTestTypeId(Long testTypeId) {
        this.testTypeId = testTypeId;
    }

    /**
     * @return Integer return the testOrder
     */
    public Integer getTestOrder() {
        return testOrder;
    }

    /**
     * @param testOrder the testOrder to set
     */
    public void setTestOrder(Integer testOrder) {
        this.testOrder = testOrder;
    }

}