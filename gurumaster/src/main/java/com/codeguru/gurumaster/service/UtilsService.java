/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeguru.gurumaster.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class UtilsService {

    public static boolean isJarRunning(String port) {
        boolean isRunning = false;
        try {
            String line;
            // Command to list all Java processes
            String[] cmd = {
                "netstat -ano | findstr :" + port
            };
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while ((line = input.readLine()) != null) {
                if (line.contains(port)) {
                    isRunning = true;
                    break;
                }
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isRunning;
    }
    public boolean isFSBS = (System.getProperty("os.name").equals("Linux"));

    public boolean serviceRunning(String port) {
        boolean isRunning = false;
        String mvncommand = (isFSBS) ? "sudo lsof -i:" : "netstat -ano | findstr :";
        // Command to be executed
        String command = mvncommand + port;

        // Create a ProcessBuilder instance
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        try {
            // Start the process
            Process process = processBuilder.start();

            // Get the input stream to read the output of the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (line.contains(port)) {
                    isRunning = true;
                    break;
                }
            }

            // Wait for the process to complete and get the exit code
            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isRunning;
    }
}
