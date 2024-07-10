package com.codeguru.gurumaster.service.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;

public class AppRunningUtil {
    
        public boolean checkForJarRunning(int port){
        
        try (ServerSocket socket = new ServerSocket(port)) {
            return false; // Port is available
        } catch (IOException e) {
            return true; // Port is in use
        }
        
    }
        
    public void runJar(String jarPath) {
        ProcessBuilder runJar = new ProcessBuilder(
                "java", "-jar", jarPath);
        runJar.inheritIO();

        try {
            Process process = runJar.start();
//            System.out.println(".................................................................................................................");
//            System.out.println(".....................................................GREAT.....................................................");
//            System.out.println(".....................................................GURU_DEPLOY IS NOW UP  AND RUNNING againi (RESTARTED)");
//            System.out.println(".................................................................................................................");
//            int exitCode = process.waitFor();
//            System.out.println("\n process exited with code: " + exitCode);
//            System.out.println("\n\n.....................................................CLONING AGAIN INTO: " + jarPath + " ----------------------------");
////            callClone(port);
//            System.out.println(".....................................................GURU_DEPLOY IS NOW UP  AND RUNNING againi (RESTARTED)");

        } catch (IOException e) {
            System.out.println(e);
            System.out.println("failing to running");
        }
    }

    
    public boolean checkProcessIsRunnningLinux(int port) {
        String[] command = new String[]{"fuser", "-k", port + "/tcp"};
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();// Create a ProcessBuilder
            processBuilder.command(command);/// Set the command and arguments
            Process process = processBuilder.start();// Start the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream())); // Read the output
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (line != null && line.contains("LISTENING") || line.contains("FIN_WAIT_2") || line.contains("CLOSE_WAIT")) {
                    if (!line.contains("LISTENING")) {
                        System.out.println("\n.....................................................??HALF WAY-- --WATING TO COMPLETELY CLOSE PROCESS ON PORT: " + port + " IS STILL RUNNING.----------------------");
                    }
                    System.out.println("\n.....................................................??HALF WAY-- --WATING TO COMPLETELY CLOSE PROCESS ON PORT: " + port + " IS STILL RUNNING.----------------------");
                    return true;
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    
}
