package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

abstract class DrawingDelegate<S extends BaseProgressIndicatorSpec> {

    /* renamed from: a  reason: collision with root package name */
    S f21664a;

    protected static class ActiveIndicator {
        @FloatRange(from = 0.0d, to = 1.0d)

        /* renamed from: a  reason: collision with root package name */
        float f21665a;
        @FloatRange(from = 0.0d, to = 1.0d)

        /* renamed from: b  reason: collision with root package name */
        float f21666b;
        @ColorInt

        /* renamed from: c  reason: collision with root package name */
        int f21667c;
        @Px

        /* renamed from: d  reason: collision with root package name */
        int f21668d;

        protected ActiveIndicator() {
        }
    }

    public DrawingDelegate(S s) {
        this.f21664a = s;
    }

    /* access modifiers changed from: package-private */
    public abstract void a(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = -1.0d, to = 1.0d) float f2, boolean z, boolean z2);

    /* access modifiers changed from: package-private */
    public abstract void b(@NonNull Canvas canvas, @NonNull Paint paint, @ColorInt int i2, @IntRange(from = 0, to = 255) int i3);

    /* access modifiers changed from: package-private */
    public abstract void c(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull ActiveIndicator activeIndicator, @IntRange(from = 0, to = 255) int i2);

    /* access modifiers changed from: package-private */
    public abstract void d(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @ColorInt int i2, @IntRange(from = 0, to = 255) int i3, @Px int i4);

    /* access modifiers changed from: package-private */
    public abstract int e();

    /* access modifiers changed from: package-private */
    public abstract int f();

    /* access modifiers changed from: package-private */
    public void g(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = 0.0d, to = 1.0d) float f2, boolean z, boolean z2) {
        this.f21664a.e();
        a(canvas, rect, f2, z, z2);
    }
}
