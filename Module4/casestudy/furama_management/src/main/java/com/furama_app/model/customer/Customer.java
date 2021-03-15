package com.furama_app.model.customer;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customer_type_id")
    private CustomerType customerType;

    @Column(name = "customer_name", length = 45, nullable = false)
    private String name;

    @Column(name = "customer_birthday", columnDefinition = "date",nullable = false)
    private String birthday;

    @Column(name = "customer_gender", length = 10, nullable = false)
    private String gender;

    @Column(name = "customer_id_card", length = 45, nullable = false)
    private String idCard;

    @Column(name = "customer_phone", length = 45, nullable = false)
    private String phoneNumber;

    @Column(name = "customer_email", length = 45)
    private String email;

    @Column(name = "customer_address", length = 45)
    private String address;

    public Customer() {
    }

    public Customer(CustomerType customerType, String name, String birthday, String gender, String idCard, String phoneNumber, String email, String address) {
        this.customerType = customerType;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
