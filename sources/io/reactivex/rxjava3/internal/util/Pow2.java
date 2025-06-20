package io.reactivex.rxjava3.internal.util;

public final class Pow2 {
    private Pow2() {
        throw new IllegalStateException("No instances!");
    }

    public static boolean a(int i2) {
        return (i2 & (i2 + -1)) == 0;
    }

    public static int b(int i2) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i2 - 1));
    }
}
