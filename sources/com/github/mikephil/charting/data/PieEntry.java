package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.util.Log;

@SuppressLint({"ParcelCreator"})
public class PieEntry extends Entry {
    private String X2;

    public PieEntry(float f2) {
        super(0.0f, f2);
    }

    @Deprecated
    public float m() {
        Log.i("DEPRECATED", "Pie entries do not have x values");
        return super.m();
    }

    @Deprecated
    public void o(float f2) {
        super.o(f2);
        Log.i("DEPRECATED", "Pie entries do not have x values");
    }

    /* renamed from: p */
    public PieEntry k() {
        return new PieEntry(c(), this.X2, a());
    }

    public String t() {
        return this.X2;
    }

    public float v() {
        return c();
    }

    public void z(String str) {
        this.X2 = str;
    }

    public PieEntry(float f2, Drawable drawable) {
        super(0.0f, f2, drawable);
    }

    public PieEntry(float f2, Drawable drawable, Object obj) {
        super(0.0f, f2, drawable, obj);
    }

    public PieEntry(float f2, Object obj) {
        super(0.0f, f2, obj);
    }

    public PieEntry(float f2, String str) {
        super(0.0f, f2);
        this.X2 = str;
    }

    public PieEntry(float f2, String str, Drawable drawable) {
        super(0.0f, f2, drawable);
        this.X2 = str;
    }

    public PieEntry(float f2, String str, Drawable drawable, Object obj) {
        super(0.0f, f2, drawable, obj);
        this.X2 = str;
    }

    public PieEntry(float f2, String str, Object obj) {
        super(0.0f, f2, obj);
        this.X2 = str;
    }
}
