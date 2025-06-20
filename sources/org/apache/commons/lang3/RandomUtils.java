package org.apache.commons.lang3;

import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static byte[] nextBytes(int i2) {
        Validate.isTrue(i2 >= 0, "Count cannot be negative.", new Object[0]);
        byte[] bArr = new byte[i2];
        RANDOM.nextBytes(bArr);
        return bArr;
    }

    public static double nextDouble(double d2, double d3) {
        boolean z = true;
        Validate.isTrue(d3 >= d2, "Start value must be smaller or equal to end value.", new Object[0]);
        if (d2 < 0.0d) {
            z = false;
        }
        Validate.isTrue(z, "Both range values must be non-negative.", new Object[0]);
        return d2 == d3 ? d2 : d2 + ((d3 - d2) * RANDOM.nextDouble());
    }

    public static float nextFloat(float f2, float f3) {
        boolean z = true;
        Validate.isTrue(f3 >= f2, "Start value must be smaller or equal to end value.", new Object[0]);
        if (f2 < 0.0f) {
            z = false;
        }
        Validate.isTrue(z, "Both range values must be non-negative.", new Object[0]);
        return f2 == f3 ? f2 : f2 + ((f3 - f2) * RANDOM.nextFloat());
    }

    public static int nextInt(int i2, int i3) {
        boolean z = true;
        Validate.isTrue(i3 >= i2, "Start value must be smaller or equal to end value.", new Object[0]);
        if (i2 < 0) {
            z = false;
        }
        Validate.isTrue(z, "Both range values must be non-negative.", new Object[0]);
        return i2 == i3 ? i2 : i2 + RANDOM.nextInt(i3 - i2);
    }

    public static long nextLong(long j2, long j3) {
        boolean z = true;
        Validate.isTrue(j3 >= j2, "Start value must be smaller or equal to end value.", new Object[0]);
        if (j2 < 0) {
            z = false;
        }
        Validate.isTrue(z, "Both range values must be non-negative.", new Object[0]);
        return j2 == j3 ? j2 : (long) nextDouble((double) j2, (double) j3);
    }
}
