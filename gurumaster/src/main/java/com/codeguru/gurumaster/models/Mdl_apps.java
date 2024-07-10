package com.codeguru.gurumaster.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "runningapps")

public class Mdl_apps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 30, nullable = false, unique = true)
    private String app;
    @Column(length = 30, nullable = false)
    private String path;
    @Column(length = 30, nullable = false)
    private String status;
    @Column(length = 30, nullable = false)
    private String port;
}