package org.selenium;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AuthorizationDataLoader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = AuthorizationDataLoader.class.getClassLoader().getResourceAsStream("login.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find login.properties");
            }
            else {
                properties.load(input);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
