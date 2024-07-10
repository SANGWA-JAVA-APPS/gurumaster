/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeguru.gurumaster.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author HP
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class RunningAppsDto {
    private Long id;
    private String app;
    private String path;
    private String status;
    private String port;
}
