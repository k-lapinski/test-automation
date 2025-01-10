package org.selenium;

import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Getter
public class BrowserConfig {
    private String browser;
    private String headless;
    private String address;

    public BrowserConfig() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            properties.load(input);
            this.browser = properties.getProperty("browser");
            this.headless = properties.getProperty("headless");
            this.address = properties.getProperty("address");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
