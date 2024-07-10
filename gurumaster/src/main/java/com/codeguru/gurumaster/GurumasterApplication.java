package com.codeguru.gurumaster;

import com.codeguru.gurumaster.models.Mdl_apps;
import com.codeguru.gurumaster.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GurumasterApplication implements CommandLineRunner {
    
    @Autowired
    AppRepository appRepository;

    public static void main(String[] args) {
        SpringApplication.run(GurumasterApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
        Mdl_apps mdl_apps = new Mdl_apps();

    }
    
}
