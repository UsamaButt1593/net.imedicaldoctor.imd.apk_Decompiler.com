package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

@SuppressLint({"ParcelCreator"})
public class BubbleEntry extends Entry {
    private float X2;

    public BubbleEntry(float f2, float f3, float f4) {
        super(f2, f3);
        this.X2 = f4;
    }

    /* renamed from: p */
    public BubbleEntry k() {
        return new BubbleEntry(m(), c(), this.X2, a());
    }

    public float t() {
        return this.X2;
    }

    public void v(float f2) {
        this.X2 = f2;
    }

    public BubbleEntry(float f2, float f3, float f4, Drawable drawable) {
        super(f2, f3, drawable);
        this.X2 = f4;
    }

    public BubbleEntry(float f2, float f3, float f4, Drawable drawable, Object obj) {
        super(f2, f3, drawable, obj);
        this.X2 = f4;
    }

    public BubbleEntry(float f2, float f3, float f4, Object obj) {
        super(f2, f3, obj);
        this.X2 = f4;
    }
}
