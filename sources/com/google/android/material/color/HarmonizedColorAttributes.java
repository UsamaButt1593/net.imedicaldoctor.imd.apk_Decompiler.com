package com.google.android.material.color;

import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import com.google.android.material.R;

public final class HarmonizedColorAttributes {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f21116c = {R.attr.s3, R.attr.x3, R.attr.t3, R.attr.y3};

    /* renamed from: a  reason: collision with root package name */
    private final int[] f21117a;
    @StyleRes

    /* renamed from: b  reason: collision with root package name */
    private final int f21118b;

    private HarmonizedColorAttributes(@AttrRes @NonNull int[] iArr, @StyleRes int i2) {
        if (i2 == 0 || iArr.length != 0) {
            this.f21117a = iArr;
            this.f21118b = i2;
            return;
        }
        throw new IllegalArgumentException("Theme overlay should be used with the accompanying int[] attributes.");
    }

    @NonNull
    public static HarmonizedColorAttributes a(@AttrRes @NonNull int[] iArr) {
        return new HarmonizedColorAttributes(iArr, 0);
    }

    @NonNull
    public static HarmonizedColorAttributes b(@AttrRes @NonNull int[] iArr, @StyleRes int i2) {
        return new HarmonizedColorAttributes(iArr, i2);
    }

    @NonNull
    public static HarmonizedColorAttributes c() {
        return b(f21116c, R.style.aa);
    }

    @NonNull
    public int[] d() {
        return this.f21117a;
    }

    @StyleRes
    public int e() {
        return this.f21118b;
    }
}
