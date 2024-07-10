package com.codeguru.gurumaster.controller;

import com.codeguru.gurumaster.service.AppRunningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/run")
public class AppRunningController {
    
    @Autowired
    private AppRunningService appRunningService;
    
    @GetMapping("/")
    public void checkForRunning(){
        appRunningService.runApplicationsService();
    }
    
}
