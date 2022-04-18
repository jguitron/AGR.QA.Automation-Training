package com.ashley_ui.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;
import java.time.Duration;

public class Driver {

    private Driver() {
    }

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            synchronized (Driver.class) {

            String browserType = ConfigurationReader.getProperty("browser");

                switch (browserType) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--disable-notifications");
                        driverPool.set(new ChromeDriver(chromeOptions));
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                        break;

                    case "mobile-chrome":
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions mobileOptions = new ChromeOptions();
                        mobileOptions.addArguments(("window-size=767,860"));
                        mobileOptions.addArguments("--disable-notifications");
                        driverPool.set(new ChromeDriver(mobileOptions));
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                        break;

                    case "chrome-remote":
                        try {
                            String ipAddress = "172.26.3.130";
                            URL url = new URL("http://" + ipAddress + ":4444/wd/hub");
                            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                            desiredCapabilities.setBrowserName("chrome");
                            ChromeOptions remoteOptions = new ChromeOptions();
                            remoteOptions.addArguments("--disable-notifications");
                            driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                            driverPool.get().manage().window().maximize();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case "chrome-headless":
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions chromeOption = new ChromeOptions();
                        chromeOption.addArguments(("window-size=1920,1080"));
                        chromeOption.addArguments("--disable-notifications");
                        driverPool.set(new ChromeDriver(chromeOption.setHeadless(true)));
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                        break;

                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                        break;

                    case "safari":
                        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                            throw new WebDriverException("Your operating system does not support the requested browser");
                        }
                        WebDriverManager.getInstance(SafariDriver.class).setup();
                        driverPool.set(new SafariDriver());
                        break;

                    case "safari-remote":
                        try {
                            String ipAddress = "172.26.3.130";
                            URL url = new URL("http://" + ipAddress + ":4444/wd/hub");
                            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                            desiredCapabilities.setBrowserName("safari");
                            driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
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
