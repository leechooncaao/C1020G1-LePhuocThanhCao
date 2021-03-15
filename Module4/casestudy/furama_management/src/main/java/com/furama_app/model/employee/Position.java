package com.furama_app.model.employee;

import javax.persistence.*;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Integer id;

    @Column(name = "position_name", length = 45)
    private String name;
}
