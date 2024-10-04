package com.midnightbits.scanner.sonar.graphics;

import com.midnightbits.scanner.rt.core.ClientCore;
import com.midnightbits.scanner.rt.core.Services;
import com.midnightbits.scanner.sonar.Sonar;
import com.midnightbits.scanner.utils.NotificationConsumer;

public class SonarAnimation {
    private final Sonar target;
    private final Scene scene;
    private final SliceSpacing spacer;

    public SonarAnimation(Sonar target) {
        this.target = target;
        this.scene = new Scene(target);
        this.spacer = new SliceSpacing(SliceSpacing.DURATION);
    }

    public boolean sendPing(ClientCore client, NotificationConsumer pingEnd) {
        return sendPing(client, null, pingEnd);
    }

    public boolean sendPing(ClientCore client, WaveAnimator.StageReporter stageReporter) {
        return sendPing(client, stageReporter, null);
    }

    public boolean sendPing(ClientCore client, WaveAnimator.StageReporter stageReporter, NotificationConsumer pingEnd) {
        return target.sendPing(client, spacer,
                new WaveAnimator(scene, Services.PLATFORM.getAnimatorHost(), target, stageReporter), pingEnd);
    }
}
