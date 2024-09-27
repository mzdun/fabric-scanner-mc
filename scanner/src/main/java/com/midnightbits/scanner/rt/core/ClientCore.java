// Copyright (c) 2024 Marcin Zdun
// This code is licensed under MIT license (see LICENSE for details)

package com.midnightbits.scanner.rt.core;

import com.midnightbits.scanner.rt.math.V3i;
import com.midnightbits.scanner.rt.text.Text;

public interface ClientCore {
    BlockInfo getBlockInfo(V3i pos);

    V3i getPlayerPos();

    float getCameraPitch();

    float getCameraYaw();

    void sendPlayerMessage(Text message, boolean overlay);
}
