/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeguru.gurumaster.service;

import com.codeguru.gurumaster.dto.RunningAppsDto;
import com.codeguru.gurumaster.models.Mdl_apps;
import com.codeguru.gurumaster.repository.AppRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class AppService {

    @Autowired
    AppRepository appRepository;

    public List<RunningAppsDto> getRunningapps() {
        List<Mdl_apps> findApps = appRepository.findAll();

        return findApps.stream().map(app -> new RunningAppsDto(
                app.getId(),
                app.getApp(),
                app.getPath(),
                app.getStatus(),
                app.getPort()
        )).collect(Collectors.toList());

    }

}
