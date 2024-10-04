package com.midnightbits.scanner.sonar.graphics;

import com.midnightbits.scanner.rt.animation.*;
import com.midnightbits.scanner.rt.math.V3i;
import com.midnightbits.scanner.sonar.BlockEcho;
import com.midnightbits.scanner.sonar.ScanWaveConsumer;
import com.midnightbits.scanner.sonar.Sonar;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class WaveAnimator implements ScanWaveConsumer {
    private static final TimeFunction TIME = TimeFunction.LINEAR;
    private static final long DURATION = 300;
    private static final double TRANSPARENT = 0.0;
    private static final double OPAQUE = 1.0;

    public enum AnimationStep {
        START,
        REPORT,
        HIDE
    }

    public interface StageReporter {
        void accept(long now, int id, AnimationStep step);
    }

    public static class Slice {
        private final Shimmers shimmers;
        private final List<BlockEcho.Partial> echoes;
        private final Sonar target;

        Slice(List<V3i> shimmers, List<BlockEcho.Partial> echoes, Sonar target) {
            this.shimmers = new Shimmers(shimmers);
            this.echoes = echoes;
            this.target = target;
        }

        public Shimmers shimmers() {
            return shimmers;
        }

        public Animation buildAnimation(Scene scene, int id, StageReporter reporter) {
            Consumer<Double> alphaConsumer = shimmers::setAlpha;
            var sequence = connectSlice(scene::add, shimmers);

            sequence = reportUsing(sequence, reporter, id, AnimationStep.START);
            sequence = sequence.andThen(rampUp(alphaConsumer));

            sequence = reportUsing(sequence, reporter, id, AnimationStep.REPORT);
            sequence = sequence.andThen(registerEchoes());

            sequence = sequence.andThen(rampDown(alphaConsumer));
            sequence = reportUsing(sequence, reporter, id, AnimationStep.HIDE);

            sequence = sequence.andThen(connectSlice(scene::remove, shimmers));

            return sequence;
        }

        public void addEchoes() {
            echoes.forEach(target::echoFrom);
        }

        private static ActionAnimation report(StageReporter reporter, int id, AnimationStep step) {
            return new ActionAnimation((now) -> reporter.accept(now, id, step));
        }

        private static Animation reportUsing(Animation animation, StageReporter reporter, int id,
                AnimationStep step) {
            if (reporter == null) {
                return animation;
            }
            return animation.andThen(report(reporter, id, step));
        }

        private static Animation connectSlice(Consumer<Shimmers> handler, Shimmers shimmers) {
            return new ActionAnimation(() -> handler.accept(shimmers));
        }

        private Animation registerEchoes() {
            return new ActionAnimation(this::addEchoes);
        }

        private static Animation rampUp(Consumer<Double> alphaConsumer) {
            return animate(alphaConsumer, TRANSPARENT, OPAQUE);
        }

        private static Animation rampDown(Consumer<Double> alphaConsumer) {
            return animate(alphaConsumer, OPAQUE, TRANSPARENT);
        }

        private static Animation animate(Consumer<Double> alphaConsumer, double startValue,
                double targetValue) {
            return new PropertyAnimation(alphaConsumer, startValue, targetValue, TIME.lastingFor(DURATION));
        }
    }

    public final List<Slice> items = new ArrayList<>();
    public final Scene scene;
    public final Animator animator;
    public final Sonar target;
    public final StageReporter reporter;
    public int sliceId = 0;

    public WaveAnimator(Scene scene, AbstractAnimatorHost animatorParent, Sonar target, StageReporter reporter) {
        this.scene = scene;
        this.animator = new Animator(animatorParent);
        this.target = target;
        this.reporter = reporter;
    }

    @Override
    public void advance(List<V3i> shimmers, List<BlockEcho.Partial> echoes) {
        final var slice = new Slice(shimmers, echoes, target);
        items.add(slice);
        scene.add(slice.shimmers());
        animator.add(slice.buildAnimation(scene, sliceId, reporter));
        ++sliceId;
    }
}
