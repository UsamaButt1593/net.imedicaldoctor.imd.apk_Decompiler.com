package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CircularProgressIndicator extends BaseProgressIndicator<CircularProgressIndicatorSpec> {
    public static final int v3 = R.style.Zi;
    public static final int w3 = 0;
    public static final int x3 = 1;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IndicatorDirection {
    }

    public CircularProgressIndicator(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void u() {
        CircularDrawingDelegate circularDrawingDelegate = new CircularDrawingDelegate((CircularProgressIndicatorSpec) this.s);
        setIndeterminateDrawable(IndeterminateDrawable.z(getContext(), (CircularProgressIndicatorSpec) this.s, circularDrawingDelegate));
        setProgressDrawable(DeterminateDrawable.C(getContext(), (CircularProgressIndicatorSpec) this.s, circularDrawingDelegate));
    }

    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) this.s).f21663j;
    }

    @Px
    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) this.s).f21662i;
    }

    @Px
    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) this.s).f21661h;
    }

    public void setIndicatorDirection(int i2) {
        ((CircularProgressIndicatorSpec) this.s).f21663j = i2;
        invalidate();
    }

    public void setIndicatorInset(@Px int i2) {
        S s = this.s;
        if (((CircularProgressIndicatorSpec) s).f21662i != i2) {
            ((CircularProgressIndicatorSpec) s).f21662i = i2;
            invalidate();
        }
    }

    public void setIndicatorSize(@Px int i2) {
        int max = Math.max(i2, getTrackThickness() * 2);
        S s = this.s;
        if (((CircularProgressIndicatorSpec) s).f21661h != max) {
            ((CircularProgressIndicatorSpec) s).f21661h = max;
            ((CircularProgressIndicatorSpec) s).e();
            requestLayout();
            invalidate();
        }
    }

    public void setTrackThickness(int i2) {
        super.setTrackThickness(i2);
        ((CircularProgressIndicatorSpec) this.s).e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public CircularProgressIndicatorSpec i(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new CircularProgressIndicatorSpec(context, attributeSet);
    }

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.L2);
    }

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2, v3);
        u();
    }
}
