package com.google.android.material.color;

import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

public class HarmonizedColorsOptions {
    @NonNull
    @ColorRes

    /* renamed from: a  reason: collision with root package name */
    private final int[] f21120a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final HarmonizedColorAttributes f21121b;
    @AttrRes

    /* renamed from: c  reason: collision with root package name */
    private final int f21122c;

    public static class Builder {
        /* access modifiers changed from: private */
        @NonNull
        @ColorRes

        /* renamed from: a  reason: collision with root package name */
        public int[] f21123a = new int[0];
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public HarmonizedColorAttributes f21124b;
        /* access modifiers changed from: private */
        @AttrRes

        /* renamed from: c  reason: collision with root package name */
        public int f21125c = R.attr.R3;

        @NonNull
        public HarmonizedColorsOptions d() {
            return new HarmonizedColorsOptions(this);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder e(@AttrRes int i2) {
            this.f21125c = i2;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder f(@Nullable HarmonizedColorAttributes harmonizedColorAttributes) {
            this.f21124b = harmonizedColorAttributes;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder g(@NonNull @ColorRes int[] iArr) {
            this.f21123a = iArr;
            return this;
        }
    }

    private HarmonizedColorsOptions(Builder builder) {
        this.f21120a = builder.f21123a;
        this.f21121b = builder.f21124b;
        this.f21122c = builder.f21125c;
    }

    @NonNull
    public static HarmonizedColorsOptions a() {
        return new Builder().f(HarmonizedColorAttributes.c()).d();
    }

    @AttrRes
    public int b() {
        return this.f21122c;
    }

    @Nullable
    public HarmonizedColorAttributes c() {
        return this.f21121b;
    }

    @NonNull
    @ColorRes
    public int[] d() {
        return this.f21120a;
    }

    /* access modifiers changed from: package-private */
    @StyleRes
    public int e(@StyleRes int i2) {
        HarmonizedColorAttributes harmonizedColorAttributes = this.f21121b;
        return (harmonizedColorAttributes == null || harmonizedColorAttributes.e() == 0) ? i2 : this.f21121b.e();
    }
}
