package com.furama_server.model.contract;

import javax.persistence.*;

@Entity
@Table(name = "attach_service")
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attach_service_id")
    private Integer id;

    @Column(name = "attach_service_name", length = 45, nullable = false)
    private String name;

    @Column(name = "attach_service_cost", nullable = false)
    private Double cost;

    @Column(name = "attach_service_unit", nullable = false)
    private Integer unit;

    @Column(name = "attach_service_status", length = 45)
    private String status;

    public AttachService() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
