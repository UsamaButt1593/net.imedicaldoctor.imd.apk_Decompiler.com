package com.google.android.material.color.utilities;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ToneDeltaPair {

    /* renamed from: a  reason: collision with root package name */
    private final DynamicColor f21285a;

    /* renamed from: b  reason: collision with root package name */
    private final DynamicColor f21286b;

    /* renamed from: c  reason: collision with root package name */
    private final double f21287c;

    /* renamed from: d  reason: collision with root package name */
    private final TonePolarity f21288d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f21289e;

    public ToneDeltaPair(@NonNull DynamicColor dynamicColor, @NonNull DynamicColor dynamicColor2, double d2, @NonNull TonePolarity tonePolarity, boolean z) {
        this.f21285a = dynamicColor;
        this.f21286b = dynamicColor2;
        this.f21287c = d2;
        this.f21288d = tonePolarity;
        this.f21289e = z;
    }

    public double a() {
        return this.f21287c;
    }

    @NonNull
    public TonePolarity b() {
        return this.f21288d;
    }

    @NonNull
    public DynamicColor c() {
        return this.f21285a;
    }

    @NonNull
    public DynamicColor d() {
        return this.f21286b;
    }

    public boolean e() {
        return this.f21289e;
    }
}
