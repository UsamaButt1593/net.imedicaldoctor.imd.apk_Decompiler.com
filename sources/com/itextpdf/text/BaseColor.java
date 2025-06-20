package com.itextpdf.text;

import androidx.media3.extractor.ts.PsExtractor;
import com.itextpdf.text.error_messages.MessageLocalization;

public class BaseColor {

    /* renamed from: b  reason: collision with root package name */
    public static final BaseColor f25673b = new BaseColor(255, 255, 255);

    /* renamed from: c  reason: collision with root package name */
    public static final BaseColor f25674c = new BaseColor((int) PsExtractor.x, (int) PsExtractor.x, (int) PsExtractor.x);

    /* renamed from: d  reason: collision with root package name */
    public static final BaseColor f25675d = new BaseColor(128, 128, 128);

    /* renamed from: e  reason: collision with root package name */
    public static final BaseColor f25676e = new BaseColor(64, 64, 64);

    /* renamed from: f  reason: collision with root package name */
    public static final BaseColor f25677f = new BaseColor(0, 0, 0);

    /* renamed from: g  reason: collision with root package name */
    public static final BaseColor f25678g = new BaseColor(255, 0, 0);

    /* renamed from: h  reason: collision with root package name */
    public static final BaseColor f25679h = new BaseColor(255, 175, 175);

    /* renamed from: i  reason: collision with root package name */
    public static final BaseColor f25680i = new BaseColor(255, 200, 0);

    /* renamed from: j  reason: collision with root package name */
    public static final BaseColor f25681j = new BaseColor(255, 255, 0);

    /* renamed from: k  reason: collision with root package name */
    public static final BaseColor f25682k = new BaseColor(0, 255, 0);

    /* renamed from: l  reason: collision with root package name */
    public static final BaseColor f25683l = new BaseColor(255, 0, 255);

    /* renamed from: m  reason: collision with root package name */
    public static final BaseColor f25684m = new BaseColor(0, 255, 255);

    /* renamed from: n  reason: collision with root package name */
    public static final BaseColor f25685n = new BaseColor(0, 0, 255);
    private static final double o = 0.7d;

    /* renamed from: a  reason: collision with root package name */
    private int f25686a;

    public BaseColor(float f2, float f3, float f4) {
        this(f2, f3, f4, 1.0f);
    }

    private static void i(int i2) {
        if (i2 < 0 || i2 > 255) {
            throw new IllegalArgumentException(MessageLocalization.b("color.value.outside.range.0.255", new Object[0]));
        }
    }

    public BaseColor a() {
        int g2 = g();
        int e2 = e();
        int d2 = d();
        if (g2 == 0 && e2 == 0 && d2 == 0) {
            return new BaseColor(3, 3, 3);
        }
        if (g2 > 0 && g2 < 3) {
            g2 = 3;
        }
        if (e2 > 0 && e2 < 3) {
            e2 = 3;
        }
        if (d2 > 0 && d2 < 3) {
            d2 = 3;
        }
        return new BaseColor(Math.min((int) (((double) g2) / o), 255), Math.min((int) (((double) e2) / o), 255), Math.min((int) (((double) d2) / o), 255));
    }

    public BaseColor b() {
        return new BaseColor(Math.max((int) (((double) g()) * o), 0), Math.max((int) (((double) e()) * o), 0), Math.max((int) (((double) d()) * o), 0));
    }

    public int c() {
        return (f() >> 24) & 255;
    }

    public int d() {
        return f() & 255;
    }

    public int e() {
        return (f() >> 8) & 255;
    }

    public boolean equals(Object obj) {
        return (obj instanceof BaseColor) && ((BaseColor) obj).f25686a == this.f25686a;
    }

    public int f() {
        return this.f25686a;
    }

    public int g() {
        return (f() >> 16) & 255;
    }

    /* access modifiers changed from: protected */
    public void h(int i2, int i3, int i4, int i5) {
        i(i2);
        i(i3);
        i(i4);
        i(i5);
        this.f25686a = ((i2 & 255) << 16) | ((i5 & 255) << 24) | ((i3 & 255) << 8) | (i4 & 255);
    }

    public int hashCode() {
        return this.f25686a;
    }

    public String toString() {
        return "Color value[" + Integer.toString(this.f25686a, 16) + "]";
    }

    public BaseColor(float f2, float f3, float f4, float f5) {
        this((int) (((double) (f2 * 255.0f)) + 0.5d), (int) (((double) (f3 * 255.0f)) + 0.5d), (int) (((double) (f4 * 255.0f)) + 0.5d), (int) (((double) (f5 * 255.0f)) + 0.5d));
    }

    public BaseColor(int i2) {
        this.f25686a = i2;
    }

    public BaseColor(int i2, int i3, int i4) {
        this(i2, i3, i4, 255);
    }

    public BaseColor(int i2, int i3, int i4, int i5) {
        h(i2, i3, i4, i5);
    }
}
