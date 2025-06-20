package com.airbnb.lottie.model;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class Font {

    /* renamed from: a  reason: collision with root package name */
    private final String f17108a;

    /* renamed from: b  reason: collision with root package name */
    private final String f17109b;

    /* renamed from: c  reason: collision with root package name */
    private final String f17110c;

    /* renamed from: d  reason: collision with root package name */
    private final float f17111d;

    public Font(String str, String str2, String str3, float f2) {
        this.f17108a = str;
        this.f17109b = str2;
        this.f17110c = str3;
        this.f17111d = f2;
    }

    /* access modifiers changed from: package-private */
    public float a() {
        return this.f17111d;
    }

    public String b() {
        return this.f17108a;
    }

    public String c() {
        return this.f17109b;
    }

    public String d() {
        return this.f17110c;
    }
}
