package com.google.android.material.color;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

public class ColorContrastOptions {
    @StyleRes

    /* renamed from: a  reason: collision with root package name */
    private final int f21016a;
    @StyleRes

    /* renamed from: b  reason: collision with root package name */
    private final int f21017b;

    public static class Builder {
        /* access modifiers changed from: private */
        @StyleRes

        /* renamed from: a  reason: collision with root package name */
        public int f21018a;
        /* access modifiers changed from: private */
        @StyleRes

        /* renamed from: b  reason: collision with root package name */
        public int f21019b;

        @NonNull
        public ColorContrastOptions c() {
            return new ColorContrastOptions(this);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder d(@StyleRes int i2) {
            this.f21019b = i2;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder e(@StyleRes int i2) {
            this.f21018a = i2;
            return this;
        }
    }

    private ColorContrastOptions(Builder builder) {
        this.f21016a = builder.f21018a;
        this.f21017b = builder.f21019b;
    }

    @StyleRes
    public int a() {
        return this.f21017b;
    }

    @StyleRes
    public int b() {
        return this.f21016a;
    }
}
