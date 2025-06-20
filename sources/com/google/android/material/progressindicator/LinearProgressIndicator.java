package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LinearProgressIndicator extends BaseProgressIndicator<LinearProgressIndicatorSpec> {
    public static final int A3 = 2;
    public static final int B3 = 3;
    public static final int v3 = R.style.lj;
    public static final int w3 = 0;
    public static final int x3 = 1;
    public static final int y3 = 0;
    public static final int z3 = 1;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IndeterminateAnimationType {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IndicatorDirection {
    }

    public LinearProgressIndicator(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void u() {
        LinearDrawingDelegate linearDrawingDelegate = new LinearDrawingDelegate((LinearProgressIndicatorSpec) this.s);
        setIndeterminateDrawable(IndeterminateDrawable.B(getContext(), (LinearProgressIndicatorSpec) this.s, linearDrawingDelegate));
        setProgressDrawable(DeterminateDrawable.E(getContext(), (LinearProgressIndicatorSpec) this.s, linearDrawingDelegate));
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) this.s).f21697h;
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) this.s).f21698i;
    }

    @Px
    public int getTrackStopIndicatorSize() {
        return ((LinearProgressIndicatorSpec) this.s).f21700k;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        S s = this.s;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s;
        boolean z2 = true;
        if (!(((LinearProgressIndicatorSpec) s).f21698i == 1 || ((ViewCompat.c0(this) == 1 && ((LinearProgressIndicatorSpec) this.s).f21698i == 2) || (ViewCompat.c0(this) == 0 && ((LinearProgressIndicatorSpec) this.s).f21698i == 3)))) {
            z2 = false;
        }
        linearProgressIndicatorSpec.f21699j = z2;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        int paddingLeft = i2 - (getPaddingLeft() + getPaddingRight());
        int paddingTop = i3 - (getPaddingTop() + getPaddingBottom());
        IndeterminateDrawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
        DeterminateDrawable progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
    }

    public void p(int i2, boolean z) {
        S s = this.s;
        if (s == null || ((LinearProgressIndicatorSpec) s).f21697h != 0 || !isIndeterminate()) {
            super.p(i2, z);
        }
    }

    public void setIndeterminateAnimationType(int i2) {
        IndeterminateDrawable indeterminateDrawable;
        IndeterminateAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate;
        if (((LinearProgressIndicatorSpec) this.s).f21697h != i2) {
            if (!s() || !isIndeterminate()) {
                S s = this.s;
                ((LinearProgressIndicatorSpec) s).f21697h = i2;
                ((LinearProgressIndicatorSpec) s).e();
                if (i2 == 0) {
                    indeterminateDrawable = getIndeterminateDrawable();
                    linearIndeterminateDisjointAnimatorDelegate = new LinearIndeterminateContiguousAnimatorDelegate((LinearProgressIndicatorSpec) this.s);
                } else {
                    indeterminateDrawable = getIndeterminateDrawable();
                    linearIndeterminateDisjointAnimatorDelegate = new LinearIndeterminateDisjointAnimatorDelegate(getContext(), (LinearProgressIndicatorSpec) this.s);
                }
                indeterminateDrawable.G(linearIndeterminateDisjointAnimatorDelegate);
                invalidate();
                return;
            }
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
    }

    public void setIndicatorColor(@NonNull int... iArr) {
        super.setIndicatorColor(iArr);
        ((LinearProgressIndicatorSpec) this.s).e();
    }

    public void setIndicatorDirection(int i2) {
        S s = this.s;
        ((LinearProgressIndicatorSpec) s).f21698i = i2;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s;
        boolean z = true;
        if (!(i2 == 1 || ((ViewCompat.c0(this) == 1 && ((LinearProgressIndicatorSpec) this.s).f21698i == 2) || (ViewCompat.c0(this) == 0 && i2 == 3)))) {
            z = false;
        }
        linearProgressIndicatorSpec.f21699j = z;
        invalidate();
    }

    public void setTrackCornerRadius(int i2) {
        super.setTrackCornerRadius(i2);
        ((LinearProgressIndicatorSpec) this.s).e();
        invalidate();
    }

    public void setTrackStopIndicatorSize(@Px int i2) {
        S s = this.s;
        if (((LinearProgressIndicatorSpec) s).f21700k != i2) {
            ((LinearProgressIndicatorSpec) s).f21700k = Math.min(i2, ((LinearProgressIndicatorSpec) s).f21636a);
            ((LinearProgressIndicatorSpec) this.s).e();
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public LinearProgressIndicatorSpec i(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new LinearProgressIndicatorSpec(context, attributeSet);
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.Hb);
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2, v3);
        u();
    }
}
