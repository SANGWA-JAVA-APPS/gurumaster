/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeguru.gurumaster.repository;

import com.codeguru.gurumaster.models.Mdl_apps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author HP
 */
@Repository
public interface AppRepository extends JpaRepository<Mdl_apps, Long> {

}
