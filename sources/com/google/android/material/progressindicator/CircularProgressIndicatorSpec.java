package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;

public final class CircularProgressIndicatorSpec extends BaseProgressIndicatorSpec {
    @Px

    /* renamed from: h  reason: collision with root package name */
    public int f21661h;
    @Px

    /* renamed from: i  reason: collision with root package name */
    public int f21662i;

    /* renamed from: j  reason: collision with root package name */
    public int f21663j;

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.L2);
    }

    /* access modifiers changed from: package-private */
    public int f() {
        int i2 = this.f21642g;
        if (i2 == 0) {
            return 0;
        }
        return (int) Math.round(360.0d / ((((double) ((this.f21661h - (this.f21662i * 2)) - this.f21636a)) * 3.141592653589793d) / ((double) (i2 + this.f21637b))));
    }

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        this(context, attributeSet, i2, CircularProgressIndicator.v3);
    }

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(context, attributeSet, i2, i3);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.dd);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.Yc);
        TypedArray k2 = ThemeEnforcement.k(context, attributeSet, R.styleable.r7, i2, i3, new int[0]);
        this.f21661h = Math.max(MaterialResources.d(context, k2, R.styleable.u7, dimensionPixelSize), this.f21636a * 2);
        this.f21662i = MaterialResources.d(context, k2, R.styleable.t7, dimensionPixelSize2);
        this.f21663j = k2.getInt(R.styleable.s7, 0);
        k2.recycle();
        e();
    }
}
