package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ClippableRoundedCornerLayout extends FrameLayout {
    private float X2;
    @Nullable
    private Path s;

    public ClippableRoundedCornerLayout(@NonNull Context context) {
        super(context);
    }

    public void a() {
        this.s = null;
        this.X2 = 0.0f;
        invalidate();
    }

    public void b(float f2, float f3, float f4, float f5, float f6) {
        d(new RectF(f2, f3, f4, f5), f6);
    }

    public void c(@NonNull Rect rect, float f2) {
        b((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom, f2);
    }

    public void d(@NonNull RectF rectF, float f2) {
        if (this.s == null) {
            this.s = new Path();
        }
        this.X2 = f2;
        this.s.reset();
        this.s.addRoundRect(rectF, f2, f2, Path.Direction.CW);
        this.s.close();
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.s == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.clipPath(this.s);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public void e(float f2) {
        b((float) getLeft(), (float) getTop(), (float) getRight(), (float) getBottom(), f2);
    }

    public float getCornerRadius() {
        return this.X2;
    }

    public ClippableRoundedCornerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ClippableRoundedCornerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
