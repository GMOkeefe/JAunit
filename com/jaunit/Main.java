package com.jaunit;

import com.jaunit.test.*;

public class Main {
    public static void main(String[] args) {
        JAunit.addTest(() -> { testIntEquals(); });
        JAunit.addTest(() -> { testDoubleEquals(); });
        JAunit.addTest(() -> { testBooleanEquals(); });
        JAunit.addTest(() -> { testObjectEquals(); });
        JAunit.addTest(() -> { testNull(); });
        JAunit.addTest(() -> { testLessThan(); });
        JAunit.addTest(() -> { testGreaterThan(); });
        JAunit.addTest(() -> { testLessThanOrEqualTo(); });
        JAunit.addTest(() -> { testGreaterThanOrEqualTo(); });

        JAunit.runTests();
    }

    /**
     * ------------------------------------------------------------------------
     * Tests and test data
     * ------------------------------------------------------------------------
     */
    final static double epsilon = 0.000001d;
    final static double pointEight = 0.1 + 0.1 + 0.1 + 0.1 +
                                    0.1 + 0.1 + 0.1 + 0.1;

    private static void testIntEquals() {
        Assert.equals(0, 0);
        Assert.equals(1, 1);
        Assert.equals(-1, -1);
        Assert.notEquals(0, 1);
        Assert.notEquals(1, 0);
        Assert.notEquals(-1, 0);
    }

    private static void testDoubleEquals() {
        Assert.equals(0.0, 0.0, epsilon);
        Assert.equals(1.0, 1.0, epsilon);
        Assert.equals(0.8, pointEight, epsilon);
        Assert.notEquals(0.0, 1.0, epsilon);
        Assert.notEquals(1.0, pointEight, epsilon);
        Assert.notEquals(-1.0, 0.0);
    }

    private static void testBooleanEquals() {
        Assert.equals(true, true);
        Assert.equals(false, false);
        Assert.notEquals(true, false);
        Assert.notEquals(false, true);
    }

    private static void testObjectEquals() {
        Assert.equals("Hello", "Hello");
        Assert.equals(new Integer(1), new Integer(1));
        Assert.equals(null, null);
        Assert.notEquals(null, "Hello");
        Assert.notEquals("Hello", null);
        Assert.notEquals("Hello", "Greetings");
        Assert.notEquals(new Integer(1), "Hello");
    }

    private static void testNull() {
        Assert.isNull(null);
        Assert.isNotNull("Hello");
    }

    private static void testLessThan() {
        Assert.isLessThan(1, 2);
        Assert.isLessThan(0.1, 0.2);
    }

    private static void testGreaterThan() {
        Assert.isGreaterThan(2, 1);
        Assert.isGreaterThan(0.2, 0.1);
    }

    private static void testLessThanOrEqualTo() {
        Assert.isLessThanOrEqualTo(1, 2);
        Assert.isLessThanOrEqualTo(2, 2);
        Assert.isLessThanOrEqualTo(0.1, 0.2);
        Assert.isLessThanOrEqualTo(0.2, 0.2);
    }

    private static void testGreaterThanOrEqualTo() {
        Assert.isGreaterThanOrEqualTo(2, 1);
        Assert.isGreaterThanOrEqualTo(2, 2);
        Assert.isGreaterThanOrEqualTo(0.2, 0.1);
        Assert.isGreaterThanOrEqualTo(0.2, 0.2);
    }
}