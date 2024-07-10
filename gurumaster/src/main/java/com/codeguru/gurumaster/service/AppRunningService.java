package com.codeguru.gurumaster.service;

import com.codeguru.gurumaster.models.Mdl_DeployDetails;
import com.codeguru.gurumaster.repository.DeployDetailsRepository;
import com.codeguru.gurumaster.service.utils.AppRunningUtil;
import com.codeguru.gurumaster.utils.MyUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class AppRunningService {

    boolean os = MyUtils.isFSBS;

    @Autowired
    private DeployDetailsRepository deployDetailsRepository;

    AppRunningUtil appRunningUtil = new AppRunningUtil();

    @Async("asynchrExecutor")
    public void runApplicationsService() {
        while(true){
            List<Mdl_DeployDetails> deployList = deployDetailsRepository.findAll();

            for (Mdl_DeployDetails singleDeploy : deployList) {

                int port = singleDeploy.getPort();
                boolean isPortRunning = appRunningUtil.checkForJarRunning(port);
                if (isPortRunning) {
                    System.out.println("--------------------------- PORT " + port + " IS RUNNING-------------------------------------");
                } else {
                    String jarPathLinux = singleDeploy.getFinal_deploy_location_linux() + "/target/"
                            + "" + singleDeploy.getProject_final_name() + ".jar";
                    
                    String jarPathWin = singleDeploy.getFinal_deploy_location_win() + "target/"
                            + "" + singleDeploy.getProject_final_name() + ".jar";
                    String jarPath = os ? jarPathLinux : jarPathWin;

                    System.out.println("------------------------- " + port + " NOT RUNNING, NOW RUNNING ---------------------------------------");
                    
                    appRunningUtil.runJar(jarPath);
                    
                    while(!appRunningUtil.checkForJarRunning(port)){
                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                        }
                        continue;
                    }
                    
                }
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                }

            }
        }
//        return "done";
    }

}
