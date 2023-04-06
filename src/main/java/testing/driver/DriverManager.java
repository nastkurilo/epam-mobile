package testing.driver;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import testing.configuration.AddressConfiguration;
import testing.configuration.CapabilitiesConfigurator;
import testing.configuration.ConfigurationReader;
import testing.configuration.EnvironmentType;

import java.io.IOException;
import java.util.Optional;

public class DriverManager {

    private static final Logger LOG = LogManager.getRootLogger();
    private static final EnvironmentType ENVIRONMENT_TYPE = EnvironmentType.valueOf(ConfigurationReader.get().environment().toUpperCase());
    private static AppiumDriver<MobileElement> driver;
    private static WebDriverWait wait;

    private DriverManager() {
    }

    public static AppiumDriver<MobileElement> getDriver() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    private static AppiumDriver<MobileElement> createDriver() {
        switch (ENVIRONMENT_TYPE) {
            case LOCAL:
                driver = new AndroidDriver<>(AddressConfiguration.getAppiumDriverLocalService(ConfigurationReader.get().appiumPort()),
                        CapabilitiesConfigurator.getLocalCapabilities());
                break;
            default:
                throw new IllegalArgumentException(String.format("Unexpected environment value: %s", ENVIRONMENT_TYPE));
        }
        LOG.info("Driver is created");
        LOG.info("Environment type is {}", ENVIRONMENT_TYPE);
        return driver;
    }

    public static WebDriverWait getWebDriverWait(int timeLimitInSeconds) {
        if (wait == null) {
            wait = new WebDriverWait(getDriver(), timeLimitInSeconds);
        }
        return wait;
    }

    public static void closeDriver() {
        Optional.ofNullable(getDriver()).ifPresent(driverInstance -> {
            driverInstance.quit();
            driver = null;
            LOG.info("Driver was closed");
        });
    }

    public static void closeAppium() {
        AddressConfiguration.stopService();
    }

    public static void  closeEmulator() {
        try {
            Runtime.getRuntime().exec(String.format("adb -s %s emu kill",ConfigurationReader.get().udid()));
            LOG.info("AVD is closed");
        } catch (IOException e) {
            LOG.error("AVD is NOT closed, message: {}", e.getMessage());
        }
    }

}
