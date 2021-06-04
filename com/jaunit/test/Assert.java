package com.jaunit.test;

import com.jaunit.flow.Check;
import com.jaunit.flow.False;
import com.jaunit.flow.True;

public class Assert {
    public static void equals(double x, double y, double epsilon) throws AssertionError {
        try {
            Check.equals(x, y, epsilon);
        }
        catch (False e) {
            throw new AssertionError(e.getMessage() + " but should be false");
        }
        catch (True e) {}
    }

    public static void notEquals(double x, double y, double epsilon) throws AssertionError {
        try {
            Check.equals(x, y, epsilon);
        }
        catch (True e) {
            throw new AssertionError(e.getMessage() + " but should be true");
        }
        catch (False e) {}
    }

    public static <T> void equals(T x, T y) throws AssertionError {
        try {
            Check.equals(x, y);
        }
        catch (False e) {
            throw new AssertionError(e.getMessage() + " but should be false");
        }
        catch (True e) {}
    }

    public static <T> void notEquals(T x, T y) throws AssertionError {
        try {
            Check.equals(x, y);
        }
        catch (True e) {
            throw new AssertionError(e.getMessage() + " but should be true");
        }
        catch (False e) {}
    }

    public static void isNull(Object x) throws AssertionError {
        try {
            Check.isNull(x);
        }
        catch (False e) {
            throw new AssertionError(e.getMessage() + " but should be true");
        }
        catch (True e) {}
    }

    public static void isNotNull(Object x) throws AssertionError {
        try {
            Check.isNull(x);
        }
        catch (True e) {
            throw new AssertionError(e.getMessage() + " but should be false");
        }
        catch (False e) {}
    }

    public static void isLessThan(long x, long y) throws AssertionError {
        try {
            Check.lessThan(x, y);
        }
        catch (False e) {
            throw new AssertionError(e.getMessage() + " but should be true");
        }
        catch (True e) {}
    }

    public static void isLessThan(double x, double y) throws AssertionError {
        try {
            Check.lessThan(x, y);
        }
        catch (False e) {
            throw new AssertionError(e.getMessage() + " but should be true");
        }
        catch (True e) {}
    }

    public static void isGreaterThan(long x, long y) throws AssertionError {
        try {
            Check.greaterThan(x, y);
        }
        catch (False e) {
            throw new AssertionError(e.getMessage() + " but should be true");
        }
        catch (True e) {}
    }

    public static void isGreaterThan(double x, double y) throws AssertionError {
        try {
            Check.greaterThan(x, y);
        }
        catch (False e) {
            throw new AssertionError(e.getMessage() + " but should be true");
        }
        catch (True e) {}
    }

    public static void isLessThanOrEqualTo(long x, long y) throws AssertionError {
        try {
            Check.lessThanOrEqualTo(x, y);
        }
        catch (False e) {
            throw new AssertionError(e.getMessage() + " but should be true");
        }
        catch (True e) {}
    }

    public static void isLessThanOrEqualTo(double x, double y) throws AssertionError {
        try {
            Check.lessThanOrEqualTo(x, y);
        }
        catch (False e) {
            throw new AssertionError(e.getMessage() + " but should be true");
        }
        catch (True e) {}
    }

    public static void isGreaterThanOrEqualTo(long x, long y) throws AssertionError {
        try {
            Check.greaterThanOrEqualTo(x, y);
        }
        catch (False e) {
            throw new AssertionError(e.getMessage() + " but should be true");
        }
        catch (True e) {}
    }

    public static void isGreaterThanOrEqualTo(double x, double y) throws AssertionError {
        try {
            Check.greaterThanOrEqualTo(x, y);
        }
        catch (False e) {
            throw new AssertionError(e.getMessage() + " but should be true");
        }
        catch (True e) {}
    }
}
