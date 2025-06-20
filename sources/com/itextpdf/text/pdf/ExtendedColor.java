package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;

public abstract class ExtendedColor extends BaseColor {
    private static final long q = 2722660170712380080L;
    public static final int r = 0;
    public static final int s = 1;
    public static final int t = 2;
    public static final int u = 3;
    public static final int v = 4;
    public static final int w = 5;
    public static final int x = 6;
    public static final int y = 7;
    protected int p;

    public ExtendedColor(int i2) {
        super(0, 0, 0);
        this.p = i2;
    }

    public static int k(BaseColor baseColor) {
        if (baseColor instanceof ExtendedColor) {
            return ((ExtendedColor) baseColor).j();
        }
        return 0;
    }

    static final float l(float f2) {
        if (f2 < 0.0f) {
            return 0.0f;
        }
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    public int j() {
        return this.p;
    }

    public ExtendedColor(int i2, float f2, float f3, float f4) {
        super(l(f2), l(f3), l(f4));
        this.p = i2;
    }

    public ExtendedColor(int i2, int i3, int i4, int i5, int i6) {
        super(l(((float) i3) / 255.0f), l(((float) i4) / 255.0f), l(((float) i5) / 255.0f), l(((float) i6) / 255.0f));
        this.p = i2;
    }
}
