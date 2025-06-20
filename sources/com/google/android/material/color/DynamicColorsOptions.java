package com.google.android.material.color;

import android.app.Activity;
import android.graphics.Bitmap;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.google.android.material.color.DynamicColors;
import com.google.android.material.color.utilities.QuantizerCelebi;
import com.google.android.material.color.utilities.Score;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

public class DynamicColorsOptions {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final DynamicColors.Precondition f21105e = new DynamicColors.Precondition() {
        public boolean a(@NonNull Activity activity, int i2) {
            return true;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final DynamicColors.OnAppliedCallback f21106f = new DynamicColors.OnAppliedCallback() {
        public void a(@NonNull Activity activity) {
        }
    };
    @StyleRes

    /* renamed from: a  reason: collision with root package name */
    private final int f21107a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final DynamicColors.Precondition f21108b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final DynamicColors.OnAppliedCallback f21109c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Integer f21110d;

    public static class Builder {
        /* access modifiers changed from: private */
        @StyleRes

        /* renamed from: a  reason: collision with root package name */
        public int f21111a;
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public DynamicColors.Precondition f21112b = DynamicColorsOptions.f21105e;
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public DynamicColors.OnAppliedCallback f21113c = DynamicColorsOptions.f21106f;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public Bitmap f21114d;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public Integer f21115e;

        @NonNull
        public DynamicColorsOptions f() {
            return new DynamicColorsOptions(this);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder g(@ColorInt int i2) {
            this.f21114d = null;
            this.f21115e = Integer.valueOf(i2);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder h(@NonNull Bitmap bitmap) {
            this.f21114d = bitmap;
            this.f21115e = null;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder i(@NonNull DynamicColors.OnAppliedCallback onAppliedCallback) {
            this.f21113c = onAppliedCallback;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder j(@NonNull DynamicColors.Precondition precondition) {
            this.f21112b = precondition;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder k(@StyleRes int i2) {
            this.f21111a = i2;
            return this;
        }
    }

    private DynamicColorsOptions(Builder builder) {
        Integer valueOf;
        this.f21107a = builder.f21111a;
        this.f21108b = builder.f21112b;
        this.f21109c = builder.f21113c;
        if (builder.f21115e != null) {
            valueOf = builder.f21115e;
        } else if (builder.f21114d != null) {
            valueOf = Integer.valueOf(c(builder.f21114d));
        } else {
            return;
        }
        this.f21110d = valueOf;
    }

    private static int c(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return Score.a(QuantizerCelebi.a(iArr, 128)).get(0).intValue();
    }

    @Nullable
    public Integer d() {
        return this.f21110d;
    }

    @NonNull
    public DynamicColors.OnAppliedCallback e() {
        return this.f21109c;
    }

    @NonNull
    public DynamicColors.Precondition f() {
        return this.f21108b;
    }

    @StyleRes
    public int g() {
        return this.f21107a;
    }
}
