package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

@SuppressLint({"ParcelCreator"})
public class CandleEntry extends Entry {
    private float X2;
    private float Y2;
    private float Z2;
    private float a3;

    public CandleEntry(float f2, float f3, float f4, float f5, float f6) {
        super(f2, (f3 + f4) / 2.0f);
        this.X2 = f3;
        this.Y2 = f4;
        this.a3 = f5;
        this.Z2 = f6;
    }

    public float B() {
        return this.Y2;
    }

    public float C() {
        return this.a3;
    }

    public float D() {
        return Math.abs(this.X2 - this.Y2);
    }

    public void E(float f2) {
        this.Z2 = f2;
    }

    public void H(float f2) {
        this.X2 = f2;
    }

    public void I(float f2) {
        this.Y2 = f2;
    }

    public void K(float f2) {
        this.a3 = f2;
    }

    public float c() {
        return super.c();
    }

    /* renamed from: p */
    public CandleEntry k() {
        return new CandleEntry(m(), this.X2, this.Y2, this.a3, this.Z2, a());
    }

    public float t() {
        return Math.abs(this.a3 - this.Z2);
    }

    public float v() {
        return this.Z2;
    }

    public float z() {
        return this.X2;
    }

    public CandleEntry(float f2, float f3, float f4, float f5, float f6, Drawable drawable) {
        super(f2, (f3 + f4) / 2.0f, drawable);
        this.X2 = f3;
        this.Y2 = f4;
        this.a3 = f5;
        this.Z2 = f6;
    }

    public CandleEntry(float f2, float f3, float f4, float f5, float f6, Drawable drawable, Object obj) {
        super(f2, (f3 + f4) / 2.0f, drawable, obj);
        this.X2 = f3;
        this.Y2 = f4;
        this.a3 = f5;
        this.Z2 = f6;
    }

    public CandleEntry(float f2, float f3, float f4, float f5, float f6, Object obj) {
        super(f2, (f3 + f4) / 2.0f, obj);
        this.X2 = f3;
        this.Y2 = f4;
        this.a3 = f5;
        this.Z2 = f6;
    }
}
