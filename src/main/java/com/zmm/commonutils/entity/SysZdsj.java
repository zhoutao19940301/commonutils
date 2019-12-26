package com.zmm.commonutils.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel( description = "字典数据")
@Table(name = "sys_zdsj")
public class SysZdsj implements Serializable {
    @ApiModelProperty(value = "字典数据ID" )
    @Id
    @Column(name = "ZDSJ_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long zdsjId;

    @ApiModelProperty(value = "字典类型ID" )
    @Column(name = "ZDLX_ID")
    private Long zdlxId;

    @ApiModelProperty(value = "字典数据名称" )
    @Column(name = "ZDSJMC")
    private String zdsjmc;

    @ApiModelProperty(value = "字典数据值" )
    @Column(name = "ZDSJZ")
    private String zdsjz;

    private static final long serialVersionUID = 1L;

    public Long getZdsjId() {
        return zdsjId;
    }

    public void setZdsjId(Long zdsjId) {
        this.zdsjId = zdsjId;
    }

    public Long getZdlxId() {
        return zdlxId;
    }

    public void setZdlxId(Long zdlxId) {
        this.zdlxId = zdlxId;
    }

    public String getZdsjmc() {
        return zdsjmc;
    }

    public void setZdsjmc(String zdsjmc) {
        this.zdsjmc = zdsjmc;
    }

    public String getZdsjz() {
        return zdsjz;
    }

    public void setZdsjz(String zdsjz) {
        this.zdsjz = zdsjz;
    }
}