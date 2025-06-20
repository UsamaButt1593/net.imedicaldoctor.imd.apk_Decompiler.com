package com.h6ah4i.android.widget.advrecyclerview.expandable;

class ExpandableAdapterHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final long f25441a = -1;

    /* renamed from: b  reason: collision with root package name */
    private static final long f25442b = 4294967295L;

    /* renamed from: c  reason: collision with root package name */
    private static final long f25443c = 2147483647L;

    /* renamed from: d  reason: collision with root package name */
    static final int f25444d = Integer.MIN_VALUE;

    private ExpandableAdapterHelper() {
    }

    public static int a(int i2) {
        return i2 & Integer.MAX_VALUE;
    }

    public static long b(long j2, long j3) {
        return ((j2 & f25443c) << 32) | (j3 & 4294967295L);
    }

    public static long c(long j2) {
        return ((j2 & f25443c) << 32) | 4294967295L;
    }

    public static int d(int i2) {
        return i2 & Integer.MAX_VALUE;
    }

    public static int e(long j2) {
        return (int) (j2 >>> 32);
    }

    public static long f(int i2, int i3) {
        return (((long) i2) & 4294967295L) | (((long) i3) << 32);
    }

    public static long g(int i2) {
        return (((long) i2) & 4294967295L) | -4294967296L;
    }

    public static int h(long j2) {
        return (int) (j2 & 4294967295L);
    }

    public static boolean i(int i2) {
        return (i2 & Integer.MIN_VALUE) != 0;
    }
}
