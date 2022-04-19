package com.sfcc_smoke.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;

public class Driver {
    private Driver() {
    }

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            synchronized (Driver.class) {
                String browser = System.getProperty("browser") != null ? browser = System.getProperty("browser") : ConfigReader.getProperty("browser");
                switch (browser) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--disable-notifications");
                        driverPool.set(new ChromeDriver(chromeOptions));
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                        break;

                    case "chrome-remote":
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        ChromeOptions remoteOptions = new ChromeOptions();
                        try {
                            String ipAddress = "172.26.3.130";
                            URL urlPage = new URL("http://" + ipAddress + ":4444/wd/hub");
                            desiredCapabilities.setBrowserName("chrome");
                            remoteOptions.addArguments("--disable-notifications");
                            driverPool.set(new RemoteWebDriver(urlPage, desiredCapabilities));
                            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case "chrome-headless":
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions chromeOption = new ChromeOptions();
                        chromeOption.addArguments("--disable-notifications");
                        driverPool.set(new ChromeDriver(chromeOption.setHeadless(true)));
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                        break;

                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.addArguments("--disable-notifications");
                        driverPool.set(new FirefoxDriver(firefoxOptions));
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                        break;

                    case "firefox-remote":
                        FirefoxOptions remoteOptions1 = new FirefoxOptions();
                        DesiredCapabilities firefoxCapabilities = new DesiredCapabilities();
                        try {
                            String ipAddress = "172.26.3.130";
                            URL urlPage1 = new URL("http://" + ipAddress + ":4444/wd/hub");
                            firefoxCapabilities.setBrowserName("firefox");
                            remoteOptions1.addArguments("--disable-notifications");
                            driverPool.set(new RemoteWebDriver(urlPage1, firefoxCapabilities));
                            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case "safari":
                        if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
                            throw new WebDriverException("Your OS does not support Safari");
                        }
                        WebDriver driver = WebDriverManager.safaridriver().browserInDocker().create();
                        driverPool.set(driver);
                        break;

                    case "safari-remote":
                        try {
                            String ipAddress = "172.26.3.130";
                            URL urlPage2 = new URL("http://" + ipAddress + ":4444/wd/hub");
                            DesiredCapabilities safariCapability = new DesiredCapabilities();
                            safariCapability.setBrowserName("safari");
                            driverPool.set(new RemoteWebDriver(urlPage2, safariCapability));
                            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}

