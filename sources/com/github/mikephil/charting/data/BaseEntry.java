package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

public abstract class BaseEntry {
    private Object X;
    private Drawable Y;
    private float s;

    public BaseEntry() {
        this.s = 0.0f;
        this.X = null;
        this.Y = null;
    }

    public Object a() {
        return this.X;
    }

    public Drawable b() {
        return this.Y;
    }

    public float c() {
        return this.s;
    }

    public void d(Object obj) {
        this.X = obj;
    }

    public void g(Drawable drawable) {
        this.Y = drawable;
    }

    public void j(float f2) {
        this.s = f2;
    }

    public BaseEntry(float f2) {
        this.X = null;
        this.Y = null;
        this.s = f2;
    }

    public BaseEntry(float f2, Drawable drawable) {
        this(f2);
        this.Y = drawable;
    }

    public BaseEntry(float f2, Drawable drawable, Object obj) {
        this(f2);
        this.Y = drawable;
        this.X = obj;
    }

    public BaseEntry(float f2, Object obj) {
        this(f2);
        this.X = obj;
    }
}
