package com.sfcc_smoke.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class Driver {
    private Driver() {
    }

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    private static final String BS_USERNAME = ConfigReader.getProperty("BS_USERNAME");
    private static final String BS_PASSWORD = ConfigReader.getProperty("BS_ACCESS_KEY");
    private static final String REMOTE_URL = "https://" + BS_USERNAME + ":" + BS_PASSWORD + "@hub-cloud.browserstack.com/wd/hub";
    static ChromeOptions chromeOptions;
    static SafariOptions safariOptions = new SafariOptions();

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            synchronized (Driver.class) {
                String browser = System.getProperty("browser") != null ? browser = System.getProperty("browser") : ConfigReader.getProperty("browser");
                switch (browser) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--disable-notifications");
                        chromeOptions.setAcceptInsecureCerts(true);
                        driverPool.set(new ChromeDriver(chromeOptions));
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                        break;
                    case "chrome-remote":
                        chromeOptions = new ChromeOptions();
                        try {
                            String ipAddress = "172.26.3.230";
                            URL urlPage = new URL("http://" + ipAddress + ":4444/");
                            chromeOptions.addArguments("--disable-notifications");
                            chromeOptions.setAcceptInsecureCerts(true);
                            driverPool.set(new RemoteWebDriver(urlPage, chromeOptions));
                            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case "chrome-headless":
                        WebDriverManager.chromedriver().setup();
                        chromeOptions = new ChromeOptions();
                        DesiredCapabilities headlessCapabilities = new DesiredCapabilities();
                        chromeOptions.addArguments("--disable-notifications");
                        chromeOptions.setAcceptInsecureCerts(true);
                        driverPool.set(new ChromeDriver(chromeOptions.setHeadless(true)));
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        DesiredCapabilities firefoxCaps = new DesiredCapabilities();
                        firefoxOptions.addArguments("--disable-notifications");
                        firefoxCaps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                        firefoxCaps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                        driverPool.set(new FirefoxDriver(firefoxOptions));
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                        break;
                    case "firefox-remote":
                        FirefoxOptions remoteOptions1 = new FirefoxOptions();
                        DesiredCapabilities firefoxCapabilities = new DesiredCapabilities();
                        try {
                            String ipAddress = "172.26.3.230";
                            URL urlPage1 = new URL("http://" + ipAddress + ":4444/wd/hub");
                            firefoxCapabilities.setBrowserName("firefox");
                            firefoxCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                            firefoxCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                            remoteOptions1.addArguments("--disable-notifications");
                            driverPool.set(new RemoteWebDriver(urlPage1, firefoxCapabilities));
                            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
                        driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                        break;
                    case "safari-remote":
                        try {
                            String ipAddress = "172.26.3.230";
                            URL urlPage2 = new URL("http://" + ipAddress + ":4444/wd/hub");
                            DesiredCapabilities safariCapability = new DesiredCapabilities();
                            safariCapability.setBrowserName("safari");
                            safariCapability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                            safariCapability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                            driverPool.set(new RemoteWebDriver(urlPage2, safariCapability));
                            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case "chrome-bstack":
                        try {
                            DesiredCapabilities bsChromeCaps = new DesiredCapabilities();
                            bsChromeCaps.setCapability("browserName", "Chrome");
                            bsChromeCaps.setCapability("browserVersion", "latest");
                            bsChromeCaps.setAcceptInsecureCerts(true);
                            bsChromeCaps.acceptInsecureCerts();
                            HashMap<String, Object> chromeOptionsMap = new HashMap<>();
                            chromeOptionsMap.put("os", "Windows");
                            chromeOptionsMap.put("osVersion", "10");
                            chromeOptionsMap.put("local", ConfigReader.getProperty("BS_LOCAL"));
                            chromeOptionsMap.put("seleniumVersion", ConfigReader.getProperty("BS_SELENIUM_VERSION"));
                            chromeOptionsMap.put("video", "true");
                            bsChromeCaps.setCapability("bstack:options", chromeOptionsMap);
                            bsChromeCaps.setCapability("BS_SESSION_NAME", ConfigReader.getProperty("BS_SESSION_NAME"));
                            bsChromeCaps.setCapability("buildName", ConfigReader.getProperty("CHROME_BS_BUILD_NAME"));
//                            bsChromeCaps.setCapability("acceptSslCert", "true");
                            driverPool.set(new RemoteWebDriver(new URL(REMOTE_URL), bsChromeCaps));
                            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case "safari-bstack":
                        try {
                            DesiredCapabilities bsSafariCaps = new DesiredCapabilities();
                            bsSafariCaps.setCapability("browserName", "Safari");
                            bsSafariCaps.setCapability("browserVersion", "15.3");
                            bsSafariCaps.setAcceptInsecureCerts(true);
                            HashMap<String, Object> safariOptionsMaps = new HashMap<>();
                            safariOptionsMaps.put("os", "OS X");
                            safariOptionsMaps.put("osVersion", "Monterey");
                            safariOptionsMaps.put("local", ConfigReader.getProperty("BS_LOCAL"));
                            safariOptionsMaps.put("seleniumVersion", ConfigReader.getProperty("BS_SELENIUM_VERSION"));
                            safariOptionsMaps.put("video", "true");
                            bsSafariCaps.setCapability("bstack:options", safariOptionsMaps);
                            bsSafariCaps.setCapability("BS_SESSION_NAME", ConfigReader.getProperty("BS_SESSION_NAME"));
                            bsSafariCaps.setCapability("buildName", ConfigReader.getProperty("SAFARI_BS_BUILD_NAME"));
                            driverPool.set(new RemoteWebDriver(new URL(REMOTE_URL), bsSafariCaps));
                            safariOptions.setImplicitWaitTimeout(Duration.ofSeconds(15));
                        } catch (Exception ex) {
                            ex.printStackTrace();
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
