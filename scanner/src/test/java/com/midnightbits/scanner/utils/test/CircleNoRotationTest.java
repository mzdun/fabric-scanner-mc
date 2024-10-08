// Copyright (c) 2024 Marcin Zdun
// This code is licensed under MIT license (see LICENSE for details)

package com.midnightbits.scanner.utils.test;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.midnightbits.scanner.rt.math.V3i;
import com.midnightbits.scanner.test.support.Iterables;
import com.midnightbits.scanner.utils.Circle;

public class CircleNoRotationTest {
    @Test
    void print0x0() {
        final var circle = new Circle(0);
        Assertions.assertEquals(
                "*\n", asString(circle));
        Iterables.assertEquals(new V3i[] { pt(0, 0) }, circle);
    }

    @Test
    void print1x1() {
        final var circle = new Circle(1);
        Assertions.assertEquals(
                """
                        ***
                        ***
                        ***
                        """, asString(circle));
        Iterables.assertEquals(new V3i[] {
                pt(-1, -1), pt(0, -1), pt(1, -1),
                pt(-1, 0), pt(0, 0), pt(1, 0),
                pt(-1, 1), pt(0, 1), pt(1, 1),
        }, circle);
    }

    @Test
    void print2x2() {
        final var circle = new Circle(2);
        Assertions.assertEquals(
                """
                        *****
                        *****
                        *****
                        *****
                        *****
                        """, asString(circle));
        Iterables.assertEquals(new V3i[] {
                pt(-2, -2), pt(-1, -2), pt(0, -2), pt(1, -2), pt(2, -2),
                pt(-2, -1), pt(-1, -1), pt(0, -1), pt(1, -1), pt(2, -1),
                pt(-2, 0), pt(-1, 0), pt(0, 0), pt(1, 0), pt(2, 0),
                pt(-2, 1), pt(-1, 1), pt(0, 1), pt(1, 1), pt(2, 1),
                pt(-2, 2), pt(-1, 2), pt(0, 2), pt(1, 2), pt(2, 2),
        }, circle);
    }

    @Test
    void print3x3() {
        final var circle = new Circle(3);
        Assertions.assertEquals(
                """
                        .*****.
                        *******
                        *******
                        *******
                        *******
                        *******
                        .*****.
                        """, asString(circle));
        Iterables.assertEquals(new V3i[] {
                pt(-2, -3), pt(-1, -3), pt(0, -3), pt(1, -3), pt(2, -3),
                pt(-3, -2), pt(-2, -2), pt(-1, -2), pt(0, -2), pt(1, -2), pt(2, -2), pt(3, -2),
                pt(-3, -1), pt(-2, -1), pt(-1, -1), pt(0, -1), pt(1, -1), pt(2, -1), pt(3, -1),
                pt(-3, 0), pt(-2, 0), pt(-1, 0), pt(0, 0), pt(1, 0), pt(2, 0), pt(3, 0),
                pt(-3, 1), pt(-2, 1), pt(-1, 1), pt(0, 1), pt(1, 1), pt(2, 1), pt(3, 1),
                pt(-3, 2), pt(-2, 2), pt(-1, 2), pt(0, 2), pt(1, 2), pt(2, 2), pt(3, 2),
                pt(-2, 3), pt(-1, 3), pt(0, 3), pt(1, 3), pt(2, 3),
        }, circle);
    }

    @Test
    void printDefault() {
        final var circle = new Circle();
        Assertions.assertEquals(
                """
                        ......*********......
                        ....*************....
                        ...***************...
                        ..*****************..
                        .*******************.
                        .*******************.
                        *********************
                        *********************
                        *********************
                        *********************
                        *********************
                        *********************
                        *********************
                        *********************
                        *********************
                        .*******************.
                        .*******************.
                        ..*****************..
                        ...***************...
                        ....*************....
                        ......*********......
                        """, asString(circle));
        Iterables.assertEquals(new V3i[] {
                pt(-4, -10), pt(-3, -10), pt(-2, -10), pt(-1, -10), pt(0, -10), pt(1, -10), pt(2, -10), pt(3, -10),
                pt(4, -10),
                pt(-6, -9), pt(-5, -9), pt(-4, -9), pt(-3, -9), pt(-2, -9), pt(-1, -9), pt(0, -9), pt(1, -9), pt(2, -9),
                pt(3, -9), pt(4, -9), pt(5, -9), pt(6, -9),
                pt(-7, -8), pt(-6, -8), pt(-5, -8), pt(-4, -8), pt(-3, -8), pt(-2, -8), pt(-1, -8), pt(0, -8),
                pt(1, -8), pt(2, -8), pt(3, -8), pt(4, -8), pt(5, -8), pt(6, -8), pt(7, -8),
                pt(-8, -7), pt(-7, -7), pt(-6, -7), pt(-5, -7), pt(-4, -7), pt(-3, -7), pt(-2, -7), pt(-1, -7),
                pt(0, -7), pt(1, -7), pt(2, -7), pt(3, -7), pt(4, -7), pt(5, -7), pt(6, -7), pt(7, -7), pt(8, -7),
                pt(-9, -6), pt(-8, -6), pt(-7, -6), pt(-6, -6), pt(-5, -6), pt(-4, -6), pt(-3, -6), pt(-2, -6),
                pt(-1, -6), pt(0, -6), pt(1, -6), pt(2, -6), pt(3, -6), pt(4, -6), pt(5, -6), pt(6, -6), pt(7, -6),
                pt(8, -6), pt(9, -6),
                pt(-9, -5), pt(-8, -5), pt(-7, -5), pt(-6, -5), pt(-5, -5), pt(-4, -5), pt(-3, -5), pt(-2, -5),
                pt(-1, -5), pt(0, -5), pt(1, -5), pt(2, -5), pt(3, -5), pt(4, -5), pt(5, -5), pt(6, -5), pt(7, -5),
                pt(8, -5), pt(9, -5),
                pt(-10, -4), pt(-9, -4), pt(-8, -4), pt(-7, -4), pt(-6, -4), pt(-5, -4), pt(-4, -4), pt(-3, -4),
                pt(-2, -4), pt(-1, -4), pt(0, -4), pt(1, -4), pt(2, -4), pt(3, -4), pt(4, -4), pt(5, -4), pt(6, -4),
                pt(7, -4), pt(8, -4), pt(9, -4), pt(10, -4),
                pt(-10, -3), pt(-9, -3), pt(-8, -3), pt(-7, -3), pt(-6, -3), pt(-5, -3), pt(-4, -3), pt(-3, -3),
                pt(-2, -3), pt(-1, -3), pt(0, -3), pt(1, -3), pt(2, -3), pt(3, -3), pt(4, -3), pt(5, -3), pt(6, -3),
                pt(7, -3), pt(8, -3), pt(9, -3), pt(10, -3),
                pt(-10, -2), pt(-9, -2), pt(-8, -2), pt(-7, -2), pt(-6, -2), pt(-5, -2), pt(-4, -2), pt(-3, -2),
                pt(-2, -2), pt(-1, -2), pt(0, -2), pt(1, -2), pt(2, -2), pt(3, -2), pt(4, -2), pt(5, -2), pt(6, -2),
                pt(7, -2), pt(8, -2), pt(9, -2), pt(10, -2),
                pt(-10, -1), pt(-9, -1), pt(-8, -1), pt(-7, -1), pt(-6, -1), pt(-5, -1), pt(-4, -1), pt(-3, -1),
                pt(-2, -1), pt(-1, -1), pt(0, -1), pt(1, -1), pt(2, -1), pt(3, -1), pt(4, -1), pt(5, -1), pt(6, -1),
                pt(7, -1), pt(8, -1), pt(9, -1), pt(10, -1),
                pt(-10, 0), pt(-9, 0), pt(-8, 0), pt(-7, 0), pt(-6, 0), pt(-5, 0), pt(-4, 0), pt(-3, 0), pt(-2, 0),
                pt(-1, 0), pt(0, 0), pt(1, 0), pt(2, 0), pt(3, 0), pt(4, 0), pt(5, 0), pt(6, 0), pt(7, 0), pt(8, 0),
                pt(9, 0), pt(10, 0),
                pt(-10, 1), pt(-9, 1), pt(-8, 1), pt(-7, 1), pt(-6, 1), pt(-5, 1), pt(-4, 1), pt(-3, 1), pt(-2, 1),
                pt(-1, 1), pt(0, 1), pt(1, 1), pt(2, 1), pt(3, 1), pt(4, 1), pt(5, 1), pt(6, 1), pt(7, 1), pt(8, 1),
                pt(9, 1), pt(10, 1),
                pt(-10, 2), pt(-9, 2), pt(-8, 2), pt(-7, 2), pt(-6, 2), pt(-5, 2), pt(-4, 2), pt(-3, 2), pt(-2, 2),
                pt(-1, 2), pt(0, 2), pt(1, 2), pt(2, 2), pt(3, 2), pt(4, 2), pt(5, 2), pt(6, 2), pt(7, 2), pt(8, 2),
                pt(9, 2), pt(10, 2),
                pt(-10, 3), pt(-9, 3), pt(-8, 3), pt(-7, 3), pt(-6, 3), pt(-5, 3), pt(-4, 3), pt(-3, 3), pt(-2, 3),
                pt(-1, 3), pt(0, 3), pt(1, 3), pt(2, 3), pt(3, 3), pt(4, 3), pt(5, 3), pt(6, 3), pt(7, 3), pt(8, 3),
                pt(9, 3), pt(10, 3),
                pt(-10, 4), pt(-9, 4), pt(-8, 4), pt(-7, 4), pt(-6, 4), pt(-5, 4), pt(-4, 4), pt(-3, 4), pt(-2, 4),
                pt(-1, 4), pt(0, 4), pt(1, 4), pt(2, 4), pt(3, 4), pt(4, 4), pt(5, 4), pt(6, 4), pt(7, 4), pt(8, 4),
                pt(9, 4), pt(10, 4),
                pt(-9, 5), pt(-8, 5), pt(-7, 5), pt(-6, 5), pt(-5, 5), pt(-4, 5), pt(-3, 5), pt(-2, 5), pt(-1, 5),
                pt(0, 5), pt(1, 5), pt(2, 5), pt(3, 5), pt(4, 5), pt(5, 5), pt(6, 5), pt(7, 5), pt(8, 5), pt(9, 5),
                pt(-9, 6), pt(-8, 6), pt(-7, 6), pt(-6, 6), pt(-5, 6), pt(-4, 6), pt(-3, 6), pt(-2, 6), pt(-1, 6),
                pt(0, 6), pt(1, 6), pt(2, 6), pt(3, 6), pt(4, 6), pt(5, 6), pt(6, 6), pt(7, 6), pt(8, 6), pt(9, 6),
                pt(-8, 7), pt(-7, 7), pt(-6, 7), pt(-5, 7), pt(-4, 7), pt(-3, 7), pt(-2, 7), pt(-1, 7), pt(0, 7),
                pt(1, 7), pt(2, 7), pt(3, 7), pt(4, 7), pt(5, 7), pt(6, 7), pt(7, 7), pt(8, 7),
                pt(-7, 8), pt(-6, 8), pt(-5, 8), pt(-4, 8), pt(-3, 8), pt(-2, 8), pt(-1, 8), pt(0, 8), pt(1, 8),
                pt(2, 8), pt(3, 8), pt(4, 8), pt(5, 8), pt(6, 8), pt(7, 8),
                pt(-6, 9), pt(-5, 9), pt(-4, 9), pt(-3, 9), pt(-2, 9), pt(-1, 9), pt(0, 9), pt(1, 9), pt(2, 9),
                pt(3, 9), pt(4, 9), pt(5, 9), pt(6, 9),
                pt(-4, 10), pt(-3, 10), pt(-2, 10), pt(-1, 10), pt(0, 10), pt(1, 10), pt(2, 10), pt(3, 10), pt(4, 10),
        }, circle);
    }

    @Test
    void print25x25() {
        final var circle = new Circle(25);
        Assertions.assertEquals(
                """
                        ..................***************..................
                        ................*******************................
                        .............*************************.............
                        ............***************************............
                        ..........*******************************..........
                        .........*********************************.........
                        ........***********************************........
                        .......*************************************.......
                        ......***************************************......
                        .....*****************************************.....
                        ....*******************************************....
                        ....*******************************************....
                        ...*********************************************...
                        ..***********************************************..
                        ..***********************************************..
                        ..***********************************************..
                        .*************************************************.
                        .*************************************************.
                        ***************************************************
                        ***************************************************
                        ***************************************************
                        ***************************************************
                        ***************************************************
                        ***************************************************
                        ***************************************************
                        ***************************************************
                        ***************************************************
                        ***************************************************
                        ***************************************************
                        ***************************************************
                        ***************************************************
                        ***************************************************
                        ***************************************************
                        .*************************************************.
                        .*************************************************.
                        ..***********************************************..
                        ..***********************************************..
                        ..***********************************************..
                        ...*********************************************...
                        ....*******************************************....
                        ....*******************************************....
                        .....*****************************************.....
                        ......***************************************......
                        .......*************************************.......
                        ........***********************************........
                        .........*********************************.........
                        ..........*******************************..........
                        ............***************************............
                        .............*************************.............
                        ................*******************................
                        ..................***************..................
                        """,
                asString(circle));
        Iterables.assertEquals(CircleTestData25.DATA, circle);
    }

    static V3i pt(int x, int y) {
        return new V3i(x, y, 0);
    }

    @SuppressWarnings("unused")
    private void assertEquals_(Circle circle, V3i[] expectedRaw) {
        int y = -2 * circle.getRadius();
        StringBuilder builder = new StringBuilder();
        for (V3i pos : circle) {
            if (pos.getY() != y) {
                y = pos.getY();
                if (!builder.isEmpty())
                    builder.append('\n');
            }
            builder.append(String.format(" pt(%s, %s),", pos.getX(), pos.getY()));
        }
        builder.append('\n');
        System.out.println(builder);
    }

    static String asString(Circle circle) {
        final int size = circle.getRadius() * 2 + 1;
        final boolean[] flags = new boolean[size * size];
        Arrays.fill(flags, false);
        for (V3i pos : circle) {
            final int i = pos.getX() + circle.getRadius();
            final int j = pos.getY() + circle.getRadius();
            flags[j * size + i] = true;
        }
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < size; ++j) {
            for (int i = 0; i < size; ++i) {
                builder.append(flags[j * size + i] ? "*" : ".");
            }
            builder.append('\n');
        }
        return builder.toString();
    }
}
