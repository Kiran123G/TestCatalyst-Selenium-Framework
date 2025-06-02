package com.framework.constants;

import org.aeonbits.owner.ConfigFactory;
import com.framework.configurations.ConfigurationManager;
import com.framework.configurations.FrameworkConfig;


public class FrameworkConstants {
	

    private static final FrameworkConfig config = ConfigurationManager.getConfig();	

    public static final String BASE_URL = "";

    
    public static final int IMPLICIT_WAIT = 10;  
    public static final int EXPLICIT_WAIT = 20;  	

    
    public static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/config.properties";
    public static final String REPORT_PATH = System.getProperty("user.dir") + "/test-output/reports/";
    public static final String USER_NAME = config.getUsername();	
    public static final String PASSWORD = config.getPassword();	
    

    
    private FrameworkConstants() {
        throw new IllegalStateException("Constants class");
    }
}
