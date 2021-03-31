package com.furama_server.model.service;

import javax.persistence.*;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer id;

//    @Pattern(regexp = "^(DV-)\\d{4}$", message = "Code must be DV-XXXX")
    @Column(name = "service_code", length = 45)
    private String code;

    @Column(name = "service_name", length = 45, nullable = false)
    private String name;

//    @DecimalMin(value = "0.01", message = "Negative value is not permitted")
    @Column(name = "service_area")
    private Integer area;

//    @DecimalMin(value = "0.01", message = "Negative value is not permitted")
    @Column(name = "service_cost", nullable = false)
    private Double cost;

//    @DecimalMin(value = "0.01", message = "Negative value is not permitted")
    @Column(name = "service_max_people")
    private Integer maxPeople;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "rent_type_id", nullable = false)
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id", referencedColumnName = "service_type_id", nullable = false)
    private ServiceType serviceType;

    @Column(name = "standard_room", length = 45)
    private String standardRoom;

    @Column(name = "description_other_convenience", length = 45)
    private String description;

//    @DecimalMin(value = "0.01", message = "Negative value is not permitted")
    @Column(name = "pool_area")
    private Double poolArea;

//    @DecimalMin(value = "0.01", message = "Negative value is not permitted")
    @Column(name = "number_of_floors")
    private Integer numberFloor;

    public Service() {
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

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(Integer numberFloor) {
        this.numberFloor = numberFloor;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
