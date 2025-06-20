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

public final class LinearProgressIndicatorSpec extends BaseProgressIndicatorSpec {

    /* renamed from: h  reason: collision with root package name */
    public int f21697h;

    /* renamed from: i  reason: collision with root package name */
    public int f21698i;

    /* renamed from: j  reason: collision with root package name */
    boolean f21699j;
    @Px

    /* renamed from: k  reason: collision with root package name */
    public int f21700k;

    public LinearProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.Hb);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        super.e();
        if (this.f21700k < 0) {
            throw new IllegalArgumentException("Stop indicator size must be >= 0.");
        } else if (this.f21697h != 0) {
        } else {
            if (this.f21637b > 0 && this.f21642g == 0) {
                throw new IllegalArgumentException("Rounded corners without gap are not supported in contiguous indeterminate animation.");
            } else if (this.f21638c.length < 3) {
                throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
            }
        }
    }

    public LinearProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        this(context, attributeSet, i2, LinearProgressIndicator.v3);
    }

    public LinearProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(context, attributeSet, i2, i3);
        boolean z = false;
        TypedArray k2 = ThemeEnforcement.k(context, attributeSet, R.styleable.Bl, R.attr.Hb, LinearProgressIndicator.v3, new int[0]);
        this.f21697h = k2.getInt(R.styleable.Cl, 1);
        this.f21698i = k2.getInt(R.styleable.Dl, 0);
        this.f21700k = Math.min(k2.getDimensionPixelSize(R.styleable.El, 0), this.f21636a);
        k2.recycle();
        e();
        this.f21699j = this.f21698i == 1 ? true : z;
    }
}
