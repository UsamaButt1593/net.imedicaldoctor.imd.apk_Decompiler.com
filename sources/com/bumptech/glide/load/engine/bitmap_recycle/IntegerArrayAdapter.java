package com.bumptech.glide.load.engine.bitmap_recycle;

public final class IntegerArrayAdapter implements ArrayAdapterInterface<int[]> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f17984a = "IntegerArrayPool";

    public int a() {
        return 4;
    }

    /* renamed from: c */
    public int b(int[] iArr) {
        return iArr.length;
    }

    /* renamed from: d */
    public int[] newArray(int i2) {
        return new int[i2];
    }

    public String n() {
        return f17984a;
    }
}
