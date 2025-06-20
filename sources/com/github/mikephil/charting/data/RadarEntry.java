package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;

@SuppressLint({"ParcelCreator"})
public class RadarEntry extends Entry {
    public RadarEntry(float f2) {
        super(0.0f, f2);
    }

    @Deprecated
    public float m() {
        return super.m();
    }

    @Deprecated
    public void o(float f2) {
        super.o(f2);
    }

    /* renamed from: p */
    public RadarEntry k() {
        return new RadarEntry(c(), a());
    }

    public float t() {
        return c();
    }

    public RadarEntry(float f2, Object obj) {
        super(0.0f, f2, obj);
    }
}
