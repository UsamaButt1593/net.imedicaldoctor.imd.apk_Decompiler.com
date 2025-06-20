package com.airbnb.lottie.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class DocumentData {

    /* renamed from: a  reason: collision with root package name */
    public final String f17097a;

    /* renamed from: b  reason: collision with root package name */
    public final String f17098b;

    /* renamed from: c  reason: collision with root package name */
    public final float f17099c;

    /* renamed from: d  reason: collision with root package name */
    public final Justification f17100d;

    /* renamed from: e  reason: collision with root package name */
    public final int f17101e;

    /* renamed from: f  reason: collision with root package name */
    public final float f17102f;

    /* renamed from: g  reason: collision with root package name */
    public final float f17103g;
    @ColorInt

    /* renamed from: h  reason: collision with root package name */
    public final int f17104h;
    @ColorInt

    /* renamed from: i  reason: collision with root package name */
    public final int f17105i;

    /* renamed from: j  reason: collision with root package name */
    public final float f17106j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f17107k;

    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f2, Justification justification, int i2, float f3, float f4, @ColorInt int i3, @ColorInt int i4, float f5, boolean z) {
        this.f17097a = str;
        this.f17098b = str2;
        this.f17099c = f2;
        this.f17100d = justification;
        this.f17101e = i2;
        this.f17102f = f3;
        this.f17103g = f4;
        this.f17104h = i3;
        this.f17105i = i4;
        this.f17106j = f5;
        this.f17107k = z;
    }

    public int hashCode() {
        int hashCode = (((((int) (((float) (((this.f17097a.hashCode() * 31) + this.f17098b.hashCode()) * 31)) + this.f17099c)) * 31) + this.f17100d.ordinal()) * 31) + this.f17101e;
        long floatToRawIntBits = (long) Float.floatToRawIntBits(this.f17102f);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.f17104h;
    }
}
