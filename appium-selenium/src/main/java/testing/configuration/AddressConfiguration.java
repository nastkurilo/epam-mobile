package testing.configuration;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.ServerArgument;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Optional;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.LOG_LEVEL;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.SESSION_OVERRIDE;

public class AddressConfiguration {

    private static final String ERROR_LOG_LEVEL = "error";
    private static final Logger LOG = LogManager.getRootLogger();
    private static AppiumDriverLocalService appiumDriverLocalService;

    private AddressConfiguration() {
    }

    public static AppiumDriverLocalService getAppiumDriverLocalService(int port) {
        if (appiumDriverLocalService == null)
            startService(port);
        return appiumDriverLocalService;
    }

    public static void startService(int port) {
        makePortAvailableIfOccupied(port);
        appiumDriverLocalService = new AppiumServiceBuilder()
                .withIPAddress(ConfigurationReader.get().appiumAddress())
                .usingPort(port)
                .withArgument(SESSION_OVERRIDE)
                .withArgument(LOG_LEVEL, ERROR_LOG_LEVEL)
                .build();
        appiumDriverLocalService.start();
        LOG.info("Appium server started on port {}", port);
    }

    public static void stopService() {
        Optional.ofNullable(appiumDriverLocalService).ifPresent(service -> {
            service.stop();
            LOG.info("Appium server stopped");
        });
    }

    private static void makePortAvailableIfOccupied(int port) {
        if (!isPortFree(port)) {
            try {
                Runtime.getRuntime().exec("taskkill /F /IM node.exe");
            } catch (IOException e) {
                LOG.error("Could NOT execute command, message: {}", e.getMessage());
            }
        }
    }

    private static boolean isPortFree(int port) {
        boolean isFree = true;
        try(ServerSocket ignore = new ServerSocket(port)) {
            LOG.info("Specified port {} is available and ready to use", port);
        }
        catch (Exception e) {
            isFree = false;
            LOG.warn("Specified port {} is occupied by some process, process will be terminated", port);
        }
        return isFree;
    }

}
