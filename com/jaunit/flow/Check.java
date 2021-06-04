package com.jaunit.flow;

public class Check {
    public static void isTrue(boolean x) throws True, False {
        equals(x, true);
    }

    public static void isFalse(boolean x) throws True, False {
        equals(x, false);
    }

    public static void isNull(Object x) throws True, False {
        try {
            int res = x.hashCode();
        }
        catch (NullPointerException e) {
            throw new True("object is null");
        }
        throw new False(x.toString() + " is null");
    }

    public static void equals(long x, long y) throws True, False {
        String condition = x + " = " + y;
        try {
            long res = 1/(x - y);
            throw new False(condition);
        }
        catch (ArithmeticException e) {
            throw new True(condition);
        }
    }

    public static void equals(double x, double y, double epsilon) throws True, False {
        String condition = x + " = " + y + ", with a tolerance of " + epsilon;
        try {
            double res = Math.abs(x - y) * (1/epsilon);
            int rounded = 1/(int)res;
            throw new False(condition);
        }
        catch (ArithmeticException e) {
            throw new True(condition);
        }
    }

    public static void equals(boolean x, boolean y) throws True, False {
        String condition = x + " is " + y;
        try {
            int i = 0;
            boolean resX = (x && (i++ == 0));
            boolean resY = (y && (i-- == 0));

            i = 1/i;
            throw new False(condition);
        }
        catch (ArithmeticException e) {
            throw new True(condition);
        }
    }

    public static void equals(Object x, Object y) throws True, False {
        try {
            isNull(x);
        }
        catch (True e) {
            try {
                isNull(y);
            }
            catch (True f) {
                throw new True("null = null");
            }
            catch (False f) {
                throw new False(y.toString() + " is not null");
            }
        }
        catch (False e) {
            try {
                isNull(y);
            }
            catch (True f) {
                throw new False(x.toString() + " is not null");
            }
            catch (False f) {
                String condition = x.toString() + " = " + y.toString();
                try {
                    equals(x.equals(y), true);
                }
                catch (True g) {
                    throw new True(condition);
                }
                catch (False g) {
                    throw new False(condition);
                }
            }
        }
    }

    public static void lessThan(long x, long y) throws True, False {
        String condition = x + " < " + y;
        try {
            StringBuilder s = new StringBuilder((int)(x - y));

            throw new False(condition);
        }
        catch (NegativeArraySizeException e) {
            throw new True(condition);
        }
    }

    public static void lessThan(double x, double y) throws True, False {
        String condition = x + " < " + y;
        try {
            StringBuilder s = new StringBuilder((int)Math.floor(x - y));

            throw new False(condition);
        }
        catch (NegativeArraySizeException e) {
            throw new True(condition);
        }
    }

    public static void greaterThan(long x, long y) throws True, False {
        String condition = x + " > " + y;
        try {
            StringBuilder s = new StringBuilder((int)(y - x));

            throw new False(condition);
        }
        catch (NegativeArraySizeException e) {
            throw new True(condition);
        }
    }

    public static void greaterThan(double x, double y) throws True, False {
        String condition = x + " > " + y;
        try {
            StringBuilder s = new StringBuilder((int)Math.floor(y - x));

            throw new False(condition);
        }
        catch (NegativeArraySizeException e) {
            throw new True(condition);
        }
    }

    public static void lessThanOrEqualTo(long x, long y) throws True, False {
        String condition = x + " <= " + y;
        try {
            greaterThan(x, y);
        }
        catch (True e) {
            throw new False(condition);
        }
        catch (False e) {
            throw new True(condition);
        }
    }

    public static void lessThanOrEqualTo(double x, double y) throws True, False {
        String condition = x + " <= " + y;
        try {
            greaterThan(x, y);
        }
        catch (True e) {
            throw new False(condition);
        }
        catch (False e) {
            throw new True(condition);
        }
    }

    public static void greaterThanOrEqualTo(long x, long y) throws True, False {
        String condition = x + " >= " + y;
        try {
            lessThan(x, y);
        }
        catch (True e) {
            throw new False(condition);
        }
        catch (False e) {
            throw new True(condition);
        }
    }

    public static void greaterThanOrEqualTo(double x, double y) throws True, False {
        String condition = x + " >= " + y;
        try {
            lessThan(x, y);
        }
        catch (True e) {
            throw new False(condition);
        }
        catch (False e) {
            throw new True(condition);
        }
    }
}
