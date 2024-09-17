package com.midnightbits.scanner;

import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.midnightbits.scanner.rt.core.Services;
import com.midnightbits.scanner.rt.core.ClientCore;
import com.midnightbits.scanner.rt.core.KeyBinding;
import com.midnightbits.scanner.rt.core.ScannerMod;
import com.midnightbits.scanner.sonar.BlockEcho;
import com.midnightbits.scanner.sonar.Sonar;

public class ResourceScannerMod implements ScannerMod {
    public static final String TAG = "resource-scanner";
    private static final Logger LOGGER = LoggerFactory.getLogger(TAG);

    private Sonar sonar = new Sonar();

    @Override
    public void onInitializeClient() {
        Path gameDir = Services.PLATFORM.getGameDir();
        Path configDir = Services.PLATFORM.getConfigDir();
        LOGGER.warn("ResourceScannerMod ({}, {})",
                Services.PLATFORM.getPlatformName(),
                Services.PLATFORM.getEnvironmentName());
        LOGGER.debug("Conf dir: {}", configDir);

        Services.PLATFORM.getKeyBinder().bind(
                "key.resource-scanner.scan",
                KeyBinding.KEY_M,
                KeyBinding.MOVEMENT_CATEGORY,
                this::onScanPressed);
    }

    private void onScanPressed(ClientCore client) {
        if (!sonar.ping(client))
            return;

        for (BlockEcho echo : sonar.echoes()) {
            LOGGER.info("{} ({}) {}", echo.getPingTime(), echo.getPosition(), echo.getId());
        }
        LOGGER.info("");
    }

    @Override
    public void setSonar(Sonar sonar) {
        this.sonar = sonar;
    }

    @Override
    public Iterable<BlockEcho> echoes() {
        return sonar.echoes();
    }
}
