package com.midnightbits.scanner.fabric;

import com.midnightbits.scanner.sonar.Sonar;
import com.midnightbits.scanner.sonar.graphics.AbstractAnimatorHost;
import com.midnightbits.scanner.sonar.graphics.GraphicContext;
import com.midnightbits.scanner.sonar.graphics.Shimmers;
import com.midnightbits.scanner.utils.Clock;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;

import java.util.ArrayList;
import java.util.List;

public class FabricAnimationHost extends AbstractAnimatorHost {
    public static final FabricAnimationHost INSTANCE = new FabricAnimationHost();
    private Sonar source;

    public void initialize(Sonar source) {
        this.source = source;
        ClientTickEvents.END_CLIENT_TICK.register((client) -> {
            this.tick(Clock.currentTimeMillis());
        });
        WorldRenderEvents.LAST.register(this::renderLevel);
    }

    @Override
    public void tick(long now) {
        super.tick(now);
        this.source.removeOldEchoes();
    }

    private static final class GatherShimmers implements GraphicContext {
        List<Shimmers> cloud = new ArrayList<>();

        @Override
        public void drawScan(List<Shimmers> shimmers) {
            this.cloud.addAll(shimmers);
        }
    };

    private void renderLevel(WorldRenderContext context) {
        final var shimmers = new GatherShimmers();
        this.run(shimmers);
        Pixel.renderLevel(context, source.echoes(), shimmers.cloud);
    }
}
