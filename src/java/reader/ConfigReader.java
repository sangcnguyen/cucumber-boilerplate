package reader;

import enums.DriverType;
import enums.EnviromentType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;
    private final String propertyFilePath = "./src/test/resources/config.properties";

    public ConfigReader() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Properties file not found at path : " + propertyFilePath);
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException ignore) {
            }
        }
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) {
            try {
                return Long.parseLong(implicitlyWait);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
            }
        }
        return 30;
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) {
            return url;
        } else {
            throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
        }
    }

    public DriverType getBrowser() {
        String browserName = properties.getProperty("browser");
        if (browserName == null || browserName.equals("chrome")) {
            return DriverType.CHROME;
        } else if (browserName.equalsIgnoreCase("firefox")) {
            return DriverType.FIREFOX;
        } else
            throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }

    public EnviromentType getEnvironment() {
        String environmentName = properties.getProperty("environment");
        if (environmentName == null || environmentName.equalsIgnoreCase("local")) {
            return EnviromentType.LOCAL;
        } else if (environmentName.equals("remote")) {
            return EnviromentType.REMOTE;
        } else
            throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
    }

    public boolean getBrowserWindowSize() {
        String windowSize = properties.getProperty("windowMaximize");
        if (windowSize != null) {
            return Boolean.parseBoolean(windowSize);
        }
        return true;
    }

    public String getTestDataResourcePath() {
        String testDataResourcePath = properties.getProperty("testDataResourcePath");
        if (testDataResourcePath != null) {
            return testDataResourcePath;
        } else {
            throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
        }
    }
}
