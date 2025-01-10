package org.selenium;

import jdk.jshell.spi.ExecutionControl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverFactory {

    public WebDriver createInstance() throws ExecutionControl.NotImplementedException {

        String browserType = new BrowserConfig().getBrowser();
        Logger log = LoggerFactory.getLogger(getClass());
        log.info("Browser: {}", browserType);

        if (browserType == null) {
            throw new ExecutionControl.NotImplementedException("Browser type is not specified");
        }

        return switch (browserType) {
            case "CHROME" -> new ChromeDriver(new ChromeOptionsConfig().createOptions());
            case "FIREFOX" -> new FirefoxDriver(new FirefoxOptionsConfig().createOptions());
            default -> throw new ExecutionControl.NotImplementedException("Browser type is not specified");
        };
    }
}