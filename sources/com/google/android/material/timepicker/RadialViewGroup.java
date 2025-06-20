package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RadialViewGroup extends ConstraintLayout {
    private static final String H3 = "skip";
    static final int I3 = 1;
    static final int J3 = 2;
    static final float K3 = 0.66f;
    private final Runnable E3;
    private int F3;
    private MaterialShapeDrawable G3;

    public RadialViewGroup(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void I(List<View> list, ConstraintSet constraintSet, int i2) {
        float f2 = 0.0f;
        for (View id : list) {
            constraintSet.M(id.getId(), R.id.I0, i2, f2);
            f2 += 360.0f / ((float) list.size());
        }
    }

    private Drawable J() {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.G3 = materialShapeDrawable;
        materialShapeDrawable.m0(new RelativeCornerSize(0.5f));
        this.G3.p0(ColorStateList.valueOf(-1));
        return this.G3;
    }

    private static boolean N(View view) {
        return H3.equals(view.getTag());
    }

    private void P() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.E3);
            handler.post(this.E3);
        }
    }

    /* access modifiers changed from: package-private */
    @Dimension
    public int K(int i2) {
        return i2 == 2 ? Math.round(((float) this.F3) * K3) : this.F3;
    }

    @Dimension
    public int L() {
        return this.F3;
    }

    public void M(@Dimension int i2) {
        this.F3 = i2;
        O();
    }

    /* access modifiers changed from: protected */
    public void O() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.H(this);
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getId() != R.id.I0 && !N(childAt)) {
                int i3 = (Integer) childAt.getTag(R.id.F2);
                if (i3 == null) {
                    i3 = 1;
                }
                if (!hashMap.containsKey(i3)) {
                    hashMap.put(i3, new ArrayList());
                }
                ((List) hashMap.get(i3)).add(childAt);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            I((List) entry.getValue(), constraintSet, K(((Integer) entry.getKey()).intValue()));
        }
        constraintSet.r(this);
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (view.getId() == -1) {
            view.setId(ViewCompat.D());
        }
        P();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        O();
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        P();
    }

    public void setBackgroundColor(@ColorInt int i2) {
        this.G3.p0(ColorStateList.valueOf(i2));
    }

    public RadialViewGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RadialViewGroup(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater.from(context).inflate(R.layout.g0, this);
        ViewCompat.P1(this, J());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Qr, i2, 0);
        this.F3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Rr, 0);
        this.E3 = new d(this);
        obtainStyledAttributes.recycle();
    }
}
