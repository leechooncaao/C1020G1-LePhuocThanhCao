package com.furama_server.model.employee;


import com.furama_server.model.contract.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee", uniqueConstraints = {@UniqueConstraint(columnNames = {"employee_email"})})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;

    @Column(name = "employee_name", length = 45, nullable = false)
    private String name;

    @Column(name = "employee_birthday", nullable = false, columnDefinition = "date")
    private String birthday;

//    @Pattern(regexp = "(^\\d{9}$)|(^\\d{12}$)", message = "ID Card is not valid")
    @Column(name = "employee_id_card", nullable = false, length = 45)
    private String idCard;

    @Column(name = "employee_salary", nullable = false)
    private Double salary;

//    @Pattern(regexp = "(^(090)\\d{7}$)|(^(091)\\d{7}$)|(^(\\+\\(84\\) 90)\\d{7}$)|(^(\\+\\(84\\) 91)\\d{7}$)", message = "Phone number is not valid")
    @Column(name = "employee_phone", length = 45, nullable = false)
    private String phoneNumber;

//    @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$", message = "Email is not valid")
    @Column(name = "employee_email", length = 45, nullable = false)
    private String email;

    @Column(name = "employee_address", length = 45)
    private String address;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", referencedColumnName = "education_degree_id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "division_id")
    private Division division;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employee")
    private AppUser appUser;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<Contract> contracts;

    public Employee() {
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
