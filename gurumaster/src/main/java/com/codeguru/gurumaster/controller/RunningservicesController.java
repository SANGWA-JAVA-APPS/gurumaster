/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeguru.gurumaster.controller;

import com.codeguru.gurumaster.models.Mdl_apps;
import com.codeguru.gurumaster.repository.AppRepository;
import com.codeguru.gurumaster.service.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/running")
public class RunningservicesController {

    @Autowired
    UtilsService utilService;

    @Autowired
    AppRepository appRepository;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to Guru Master !";
    }

    @GetMapping("/myjar")
    public ResponseEntity<String> CheckOnAllServices(@RequestParam String myjar) {
        boolean result = utilService.serviceRunning(myjar);
        String response = "";
        response = (result) ? myjar + " is running." : myjar + " is not running.";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Mdl_apps> createStructure(@RequestBody Mdl_apps mdl_runningapps) {
        return new ResponseEntity<>(appRepository.save(mdl_runningapps), HttpStatus.CREATED);
    }

}
