package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

public abstract class BaseProgressIndicatorSpec {
    @Px

    /* renamed from: a  reason: collision with root package name */
    public int f21636a;
    @Px

    /* renamed from: b  reason: collision with root package name */
    public int f21637b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public int[] f21638c = new int[0];
    @ColorInt

    /* renamed from: d  reason: collision with root package name */
    public int f21639d;

    /* renamed from: e  reason: collision with root package name */
    public int f21640e;

    /* renamed from: f  reason: collision with root package name */
    public int f21641f;
    @Px

    /* renamed from: g  reason: collision with root package name */
    public int f21642g;

    protected BaseProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.jd);
        TypedArray k2 = ThemeEnforcement.k(context, attributeSet, R.styleable.A4, i2, i3, new int[0]);
        this.f21636a = MaterialResources.d(context, k2, R.styleable.K4, dimensionPixelSize);
        this.f21637b = Math.min(MaterialResources.d(context, k2, R.styleable.J4, 0), this.f21636a / 2);
        this.f21640e = k2.getInt(R.styleable.G4, 0);
        this.f21641f = k2.getInt(R.styleable.C4, 0);
        this.f21642g = k2.getDimensionPixelSize(R.styleable.E4, 0);
        c(context, k2);
        d(context, k2);
        k2.recycle();
    }

    private void c(@NonNull Context context, @NonNull TypedArray typedArray) {
        int i2 = R.styleable.D4;
        if (!typedArray.hasValue(i2)) {
            this.f21638c = new int[]{MaterialColors.b(context, R.attr.R3, -1)};
        } else if (typedArray.peekValue(i2).type != 1) {
            this.f21638c = new int[]{typedArray.getColor(i2, -1)};
        } else {
            int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(i2, -1));
            this.f21638c = intArray;
            if (intArray.length == 0) {
                throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
            }
        }
    }

    private void d(@NonNull Context context, @NonNull TypedArray typedArray) {
        int a2;
        int i2 = R.styleable.I4;
        if (typedArray.hasValue(i2)) {
            a2 = typedArray.getColor(i2, -1);
        } else {
            this.f21639d = this.f21638c[0];
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16842803});
            float f2 = obtainStyledAttributes.getFloat(0, 0.2f);
            obtainStyledAttributes.recycle();
            a2 = MaterialColors.a(this.f21639d, (int) (f2 * 255.0f));
        }
        this.f21639d = a2;
    }

    public boolean a() {
        return this.f21641f != 0;
    }

    public boolean b() {
        return this.f21640e != 0;
    }

    /* access modifiers changed from: package-private */
    @CallSuper
    public void e() {
        if (this.f21642g < 0) {
            throw new IllegalArgumentException("indicatorTrackGapSize must be >= 0.");
        }
    }
}
