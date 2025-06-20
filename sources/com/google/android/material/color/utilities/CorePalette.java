package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CorePalette {

    /* renamed from: a  reason: collision with root package name */
    public TonalPalette f21172a;

    /* renamed from: b  reason: collision with root package name */
    public TonalPalette f21173b;

    /* renamed from: c  reason: collision with root package name */
    public TonalPalette f21174c;

    /* renamed from: d  reason: collision with root package name */
    public TonalPalette f21175d;

    /* renamed from: e  reason: collision with root package name */
    public TonalPalette f21176e;

    /* renamed from: f  reason: collision with root package name */
    public TonalPalette f21177f;

    private CorePalette(int i2, boolean z) {
        TonalPalette c2;
        Hct b2 = Hct.b(i2);
        double d2 = b2.d();
        double c3 = b2.c();
        if (z) {
            this.f21172a = TonalPalette.c(d2, c3);
            this.f21173b = TonalPalette.c(d2, c3 / 3.0d);
            this.f21174c = TonalPalette.c(60.0d + d2, c3 / 2.0d);
            this.f21175d = TonalPalette.c(d2, Math.min(c3 / 12.0d, 4.0d));
            c2 = TonalPalette.c(d2, Math.min(c3 / 6.0d, 8.0d));
        } else {
            this.f21172a = TonalPalette.c(d2, Math.max(48.0d, c3));
            this.f21173b = TonalPalette.c(d2, 16.0d);
            this.f21174c = TonalPalette.c(60.0d + d2, 24.0d);
            this.f21175d = TonalPalette.c(d2, 4.0d);
            c2 = TonalPalette.c(d2, 8.0d);
        }
        this.f21176e = c2;
        this.f21177f = TonalPalette.c(25.0d, 84.0d);
    }

    public static CorePalette a(int i2) {
        return new CorePalette(i2, true);
    }

    public static CorePalette b(int i2) {
        return new CorePalette(i2, false);
    }
}
