package org.selenium;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsConfig {
    public ChromeOptionsConfig() {}

    public ChromeOptions createOptions() {
        String headless = new BrowserConfig().getHeadless();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
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
