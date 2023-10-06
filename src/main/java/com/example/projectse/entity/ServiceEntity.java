package com.example.projectse.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "service")
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int code;
    private int type;
}
