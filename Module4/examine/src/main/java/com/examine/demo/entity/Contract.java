package com.examine.demo.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer id;

    @NotNull
    @Pattern(regexp = "^(MGD-)\\d{4}$", message = "Code must be MGD-XXXX")
    @Column(name = "contract_code", length = 45)
    private String code;

    @NotNull
//    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$",message = "Date must be dd/mm/yyyy")
    @Column(name = "contract_date", nullable = false, columnDefinition = "date")
    private String date;

    @NotNull
    @Min(value = 500000, message = "Cost must be >= 500.000 VND")
    @Column(name = "contract_cost", nullable = false)
    private Double cost;

    @NotNull
    @Min(value = 20, message = "Area must be >= 20 m2")
    @Column(name = "area", nullable = false)
    private Double area;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    private Customer customer;

    @NotNull
    @Column(name = "service_type", nullable = false)
    private String serviceType;

    public Contract() {
    }

    public Contract(String code, String date, Double cost, Double area, Customer customer, String serviceType) {
        this.code = code;
        this.date = date;
        this.cost = cost;
        this.area = area;
        this.customer = customer;
        this.serviceType = serviceType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
}
