package org.selenium;

import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxOptionsConfig {
    public FirefoxOptionsConfig() {}

    public FirefoxOptions createOptions() {
        String headless = new BrowserConfig().getHeadless();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("test-type");
        options.addArguments("--start-maximized");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--enable-precise-memory-info");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");
        options.addArguments("test-type=browser");
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--lang=pl");

        if ("true".equals(headless)) {
            options.addArguments("--headless=new");
        }

        return options;
    }
}
