package com.airbnb.lottie;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

public class LottieImageAsset {

    /* renamed from: a  reason: collision with root package name */
    private final int f16741a;

    /* renamed from: b  reason: collision with root package name */
    private final int f16742b;

    /* renamed from: c  reason: collision with root package name */
    private final String f16743c;

    /* renamed from: d  reason: collision with root package name */
    private final String f16744d;

    /* renamed from: e  reason: collision with root package name */
    private final String f16745e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f16746f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieImageAsset(int i2, int i3, String str, String str2, String str3) {
        this.f16741a = i2;
        this.f16742b = i3;
        this.f16743c = str;
        this.f16744d = str2;
        this.f16745e = str3;
    }

    @Nullable
    public Bitmap a() {
        return this.f16746f;
    }

    public String b() {
        return this.f16745e;
    }

    public String c() {
        return this.f16744d;
    }

    public int d() {
        return this.f16742b;
    }

    public String e() {
        return this.f16743c;
    }

    public int f() {
        return this.f16741a;
    }

    public void g(@Nullable Bitmap bitmap) {
        this.f16746f = bitmap;
    }
}
