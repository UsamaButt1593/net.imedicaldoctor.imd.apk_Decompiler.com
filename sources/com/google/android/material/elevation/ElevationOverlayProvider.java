package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;

public class ElevationOverlayProvider {

    /* renamed from: f  reason: collision with root package name */
    private static final float f21411f = 4.5f;

    /* renamed from: g  reason: collision with root package name */
    private static final float f21412g = 2.0f;

    /* renamed from: h  reason: collision with root package name */
    private static final int f21413h = ((int) Math.round(5.1000000000000005d));

    /* renamed from: a  reason: collision with root package name */
    private final boolean f21414a;

    /* renamed from: b  reason: collision with root package name */
    private final int f21415b;

    /* renamed from: c  reason: collision with root package name */
    private final int f21416c;

    /* renamed from: d  reason: collision with root package name */
    private final int f21417d;

    /* renamed from: e  reason: collision with root package name */
    private final float f21418e;

    public ElevationOverlayProvider(@NonNull Context context) {
        this(MaterialAttributes.b(context, R.attr.y6, false), MaterialColors.b(context, R.attr.x6, 0), MaterialColors.b(context, R.attr.w6, 0), MaterialColors.b(context, R.attr.e4, 0), context.getResources().getDisplayMetrics().density);
    }

    private boolean m(@ColorInt int i2) {
        return ColorUtils.D(i2, 255) == this.f21417d;
    }

    public int a(float f2) {
        return Math.round(b(f2) * 255.0f);
    }

    public float b(float f2) {
        float f3 = this.f21418e;
        if (f3 <= 0.0f || f2 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p((double) (f2 / f3))) * f21411f) + 2.0f) / 100.0f, 1.0f);
    }

    @ColorInt
    public int c(@ColorInt int i2, float f2) {
        int i3;
        float b2 = b(f2);
        int alpha = Color.alpha(i2);
        int t = MaterialColors.t(ColorUtils.D(i2, 255), this.f21415b, b2);
        if (b2 > 0.0f && (i3 = this.f21416c) != 0) {
            t = MaterialColors.s(t, ColorUtils.D(i3, f21413h));
        }
        return ColorUtils.D(t, alpha);
    }

    @ColorInt
    public int d(@ColorInt int i2, float f2, @NonNull View view) {
        return c(i2, f2 + i(view));
    }

    @ColorInt
    public int e(@ColorInt int i2, float f2) {
        return (!this.f21414a || !m(i2)) ? i2 : c(i2, f2);
    }

    @ColorInt
    public int f(@ColorInt int i2, float f2, @NonNull View view) {
        return e(i2, f2 + i(view));
    }

    @ColorInt
    public int g(float f2) {
        return e(this.f21417d, f2);
    }

    @ColorInt
    public int h(float f2, @NonNull View view) {
        return g(f2 + i(view));
    }

    public float i(@NonNull View view) {
        return ViewUtils.p(view);
    }

    @ColorInt
    public int j() {
        return this.f21415b;
    }

    @ColorInt
    public int k() {
        return this.f21417d;
    }

    public boolean l() {
        return this.f21414a;
    }

    public ElevationOverlayProvider(boolean z, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4, float f2) {
        this.f21414a = z;
        this.f21415b = i2;
        this.f21416c = i3;
        this.f21417d = i4;
        this.f21418e = f2;
    }
}
