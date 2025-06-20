package org.apache.commons.lang3.math;

public class IEEE754rUtils {
    public static double max(double d2, double d3) {
        if (Double.isNaN(d2)) {
            return d3;
        }
        return Double.isNaN(d3) ? d2 : Math.max(d2, d3);
    }

    public static double min(double d2, double d3) {
        if (Double.isNaN(d2)) {
            return d3;
        }
        return Double.isNaN(d3) ? d2 : Math.min(d2, d3);
    }

    public static double max(double d2, double d3, double d4) {
        return max(max(d2, d3), d4);
    }

    public static double min(double d2, double d3, double d4) {
        return min(min(d2, d3), d4);
    }

    public static double max(double[] dArr) {
        if (dArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (dArr.length != 0) {
            double d2 = dArr[0];
            for (int i2 = 1; i2 < dArr.length; i2++) {
                d2 = max(dArr[i2], d2);
            }
            return d2;
        } else {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }

    public static double min(double[] dArr) {
        if (dArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (dArr.length != 0) {
            double d2 = dArr[0];
            for (int i2 = 1; i2 < dArr.length; i2++) {
                d2 = min(dArr[i2], d2);
            }
            return d2;
        } else {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }

    public static float max(float f2, float f3) {
        if (Float.isNaN(f2)) {
            return f3;
        }
        return Float.isNaN(f3) ? f2 : Math.max(f2, f3);
    }

    public static float min(float f2, float f3) {
        if (Float.isNaN(f2)) {
            return f3;
        }
        return Float.isNaN(f3) ? f2 : Math.min(f2, f3);
    }

    public static float max(float f2, float f3, float f4) {
        return max(max(f2, f3), f4);
    }

    public static float min(float f2, float f3, float f4) {
        return min(min(f2, f3), f4);
    }

    public static float max(float[] fArr) {
        if (fArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (fArr.length != 0) {
            float f2 = fArr[0];
            for (int i2 = 1; i2 < fArr.length; i2++) {
                f2 = max(fArr[i2], f2);
            }
            return f2;
        } else {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }

    public static float min(float[] fArr) {
        if (fArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (fArr.length != 0) {
            float f2 = fArr[0];
            for (int i2 = 1; i2 < fArr.length; i2++) {
                f2 = min(fArr[i2], f2);
            }
            return f2;
        } else {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }
}
