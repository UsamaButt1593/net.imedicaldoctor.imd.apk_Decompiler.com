package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.math.MathUtils;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.ClampedCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.shape.ShapeableDelegate;

public class MaskableFrameLayout extends FrameLayout implements Maskable, Shapeable {
    private static final int c3 = -1;
    private final RectF X2;
    @Nullable
    private OnMaskChangedListener Y2;
    @NonNull
    private ShapeAppearanceModel Z2;
    private final ShapeableDelegate a3;
    @Nullable
    private Boolean b3;
    private float s;

    public MaskableFrameLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ CornerSize d(CornerSize cornerSize) {
        return cornerSize instanceof AbsoluteCornerSize ? ClampedCornerSize.b((AbsoluteCornerSize) cornerSize) : cornerSize;
    }

    private void e() {
        this.a3.f(this, this.X2);
        OnMaskChangedListener onMaskChangedListener = this.Y2;
        if (onMaskChangedListener != null) {
            onMaskChangedListener.a(this.X2);
        }
    }

    private void f() {
        if (this.s != -1.0f) {
            float b2 = AnimationUtils.b(0.0f, ((float) getWidth()) / 2.0f, 0.0f, 1.0f, this.s);
            setMaskRectF(new RectF(b2, 0.0f, ((float) getWidth()) - b2, (float) getHeight()));
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        this.a3.e(canvas, new d(this));
    }

    public void getFocusedRect(Rect rect) {
        RectF rectF = this.X2;
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    @NonNull
    public RectF getMaskRectF() {
        return this.X2;
    }

    @Deprecated
    public float getMaskXPercentage() {
        return this.s;
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.Z2;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Boolean bool = this.b3;
        if (bool != null) {
            this.a3.h(this, bool.booleanValue());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.b3 = Boolean.valueOf(this.a3.c());
        this.a3.h(this, true);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.s != -1.0f) {
            f();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.X2.isEmpty() && motionEvent.getAction() == 0) {
            if (!this.X2.contains(motionEvent.getX(), motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setForceCompatClipping(boolean z) {
        this.a3.h(this, z);
    }

    public void setMaskRectF(@NonNull RectF rectF) {
        this.X2.set(rectF);
        e();
    }

    @Deprecated
    public void setMaskXPercentage(float f2) {
        float d2 = MathUtils.d(f2, 0.0f, 1.0f);
        if (this.s != d2) {
            this.s = d2;
            f();
        }
    }

    public void setOnMaskChangedListener(@Nullable OnMaskChangedListener onMaskChangedListener) {
        this.Y2 = onMaskChangedListener;
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        ShapeAppearanceModel y = shapeAppearanceModel.y(new c());
        this.Z2 = y;
        this.a3.g(this, y);
    }

    public MaskableFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskableFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.s = -1.0f;
        this.X2 = new RectF();
        this.a3 = ShapeableDelegate.a(this);
        this.b3 = null;
        setShapeAppearanceModel(ShapeAppearanceModel.f(context, attributeSet, i2, 0, 0).m());
    }
}
