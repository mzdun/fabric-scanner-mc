// Copyright (c) 2024 Marcin Zdun
// This code is licensed under MIT license (see LICENSE for details)

package com.midnightbits.scanner.fabric;

import java.nio.file.Path;

import com.midnightbits.scanner.platform.KeyBinder;
import com.midnightbits.scanner.platform.PlatformInterface;
import com.midnightbits.scanner.utils.CacheableValue;
import com.midnightbits.scanner.utils.Manifests;

import net.fabricmc.loader.api.FabricLoader;

public class FabricPlatform implements PlatformInterface {
    private final FabricKeyBinder binder = new FabricKeyBinder();

    private final CacheableValue<String> scannerVersion = new CacheableValue<>(
            () -> Manifests.getAttribute("Scanner-Version"));
    private final CacheableValue<String> minecraftVersion = new CacheableValue<>(
            () -> Manifests.getAttribute("Fabric-Minecraft-Version"));

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public String getScannerVersion() {
        return scannerVersion.get();
    }

    @Override
    public String getMinecraftVersion() {
        return minecraftVersion.get();
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public Path getConfigDir() {
        return FabricLoader.getInstance().getConfigDir();
    }

    @Override
    public KeyBinder getKeyBinder() {
        return binder;
    }
}
