package com.h6ah4i.android.widget.advrecyclerview.swipeable;

class SwipeReactionUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final int f25521a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f25522b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f25523c = 2;

    SwipeReactionUtils() {
    }

    public static boolean a(int i2) {
        return c(i2) == 2;
    }

    public static boolean b(int i2) {
        return d(i2) == 2;
    }

    public static int c(int i2) {
        return i2 & 3;
    }

    public static int d(int i2) {
        return (i2 >>> 16) & 3;
    }
}
