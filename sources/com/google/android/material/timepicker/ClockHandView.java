package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.math.MathUtils;
import com.google.android.material.motion.MotionUtils;
import java.util.ArrayList;
import java.util.List;

class ClockHandView extends View {
    private static final int r3 = 200;
    private final TimeInterpolator X2;
    private final ValueAnimator Y2;
    private boolean Z2;
    private float a3;
    private float b3;
    private boolean c3;
    private final int d3;
    private boolean e3;
    private final List<OnRotateListener> f3;
    private final int g3;
    private final float h3;
    private final Paint i3;
    private final RectF j3;
    @Px
    private final int k3;
    private float l3;
    private boolean m3;
    private OnActionUpListener n3;
    private double o3;
    private int p3;
    private int q3;
    private final int s;

    public interface OnActionUpListener {
        void e(@FloatRange(from = 0.0d, to = 360.0d) float f2, boolean z);
    }

    public interface OnRotateListener {
        void d(@FloatRange(from = 0.0d, to = 360.0d) float f2, boolean z);
    }

    public ClockHandView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void c(float f2, float f4) {
        int i2 = 2;
        if (MathUtils.a((float) (getWidth() / 2), (float) (getHeight() / 2), f2, f4) > ((float) i(2)) + ViewUtils.i(getContext(), 12)) {
            i2 = 1;
        }
        this.q3 = i2;
    }

    private void d(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        int i2 = i(this.q3);
        float f2 = (float) width;
        float f4 = (float) i2;
        float f5 = (float) height;
        this.i3.setStrokeWidth(0.0f);
        canvas.drawCircle((((float) Math.cos(this.o3)) * f4) + f2, (f4 * ((float) Math.sin(this.o3))) + f5, (float) this.g3, this.i3);
        double sin = Math.sin(this.o3);
        double cos = Math.cos(this.o3);
        double d2 = (double) ((float) (i2 - this.g3));
        float f6 = (float) (width + ((int) (cos * d2)));
        float f7 = (float) (height + ((int) (d2 * sin)));
        this.i3.setStrokeWidth((float) this.k3);
        canvas.drawLine(f2, f5, f6, f7, this.i3);
        canvas.drawCircle(f2, f5, this.h3, this.i3);
    }

    private int g(float f2, float f4) {
        int degrees = (int) Math.toDegrees(Math.atan2((double) (f4 - ((float) (getHeight() / 2))), (double) (f2 - ((float) (getWidth() / 2)))));
        int i2 = degrees + 90;
        return i2 < 0 ? degrees + 450 : i2;
    }

    @Dimension
    private int i(int i2) {
        return i2 == 2 ? Math.round(((float) this.p3) * 0.66f) : this.p3;
    }

    private Pair<Float, Float> k(float f2) {
        float h2 = h();
        if (Math.abs(h2 - f2) > 180.0f) {
            if (h2 > 180.0f && f2 < 180.0f) {
                f2 += 360.0f;
            }
            if (h2 < 180.0f && f2 > 180.0f) {
                h2 += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(h2), Float.valueOf(f2));
    }

    private boolean l(float f2, float f4, boolean z, boolean z2, boolean z3) {
        float g2 = (float) g(f2, f4);
        boolean z4 = false;
        boolean z5 = h() != g2;
        if (z2 && z5) {
            return true;
        }
        if (!z5 && !z) {
            return false;
        }
        if (z3 && this.Z2) {
            z4 = true;
        }
        r(g2, z4);
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(ValueAnimator valueAnimator) {
        s(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
    }

    private void s(@FloatRange(from = 0.0d, to = 360.0d) float f2, boolean z) {
        float f4 = f2 % 360.0f;
        this.l3 = f4;
        this.o3 = Math.toRadians((double) (f4 - 90.0f));
        float i2 = (float) i(this.q3);
        float width = ((float) (getWidth() / 2)) + (((float) Math.cos(this.o3)) * i2);
        float height = ((float) (getHeight() / 2)) + (i2 * ((float) Math.sin(this.o3)));
        RectF rectF = this.j3;
        int i4 = this.g3;
        rectF.set(width - ((float) i4), height - ((float) i4), width + ((float) i4), height + ((float) i4));
        for (OnRotateListener d2 : this.f3) {
            d2.d(f4, z);
        }
        invalidate();
    }

    public void b(OnRotateListener onRotateListener) {
        this.f3.add(onRotateListener);
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.q3;
    }

    public RectF f() {
        return this.j3;
    }

    @FloatRange(from = 0.0d, to = 360.0d)
    public float h() {
        return this.l3;
    }

    public int j() {
        return this.g3;
    }

    public void n(boolean z) {
        this.Z2 = z;
    }

    public void o(@Dimension int i2) {
        this.p3 = i2;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        super.onLayout(z, i2, i4, i5, i6);
        if (!this.Y2.isRunning()) {
            q(h());
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        OnActionUpListener onActionUpListener;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                int i2 = (int) (x - this.a3);
                int i4 = (int) (y - this.b3);
                this.c3 = (i2 * i2) + (i4 * i4) > this.d3;
                boolean z4 = this.m3;
                z3 = actionMasked == 1;
                if (this.e3) {
                    c(x, y);
                }
                z2 = z4;
            } else {
                z3 = false;
                z2 = false;
            }
            z = false;
        } else {
            this.a3 = x;
            this.b3 = y;
            this.c3 = true;
            this.m3 = false;
            z3 = false;
            z2 = false;
            z = true;
        }
        boolean l2 = l(x, y, z2, z, z3) | this.m3;
        this.m3 = l2;
        if (l2 && z3 && (onActionUpListener = this.n3) != null) {
            onActionUpListener.e((float) g(x, y), this.c3);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void p(int i2) {
        this.q3 = i2;
        invalidate();
    }

    public void q(@FloatRange(from = 0.0d, to = 360.0d) float f2) {
        r(f2, false);
    }

    public void r(@FloatRange(from = 0.0d, to = 360.0d) float f2, boolean z) {
        ValueAnimator valueAnimator = this.Y2;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z) {
            s(f2, false);
            return;
        }
        Pair<Float, Float> k2 = k(f2);
        this.Y2.setFloatValues(new float[]{((Float) k2.first).floatValue(), ((Float) k2.second).floatValue()});
        this.Y2.setDuration((long) this.s);
        this.Y2.setInterpolator(this.X2);
        this.Y2.addUpdateListener(new b(this));
        this.Y2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                animator.end();
            }
        });
        this.Y2.start();
    }

    /* access modifiers changed from: package-private */
    public void t(boolean z) {
        if (this.e3 && !z) {
            this.q3 = 1;
        }
        this.e3 = z;
        invalidate();
    }

    public void u(OnActionUpListener onActionUpListener) {
        this.n3 = onActionUpListener;
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.Ic);
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Y2 = new ValueAnimator();
        this.f3 = new ArrayList();
        Paint paint = new Paint();
        this.i3 = paint;
        this.j3 = new RectF();
        this.q3 = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.y7, i2, R.style.uk);
        this.s = MotionUtils.f(context, R.attr.Fd, 200);
        this.X2 = MotionUtils.g(context, R.attr.Vd, AnimationUtils.f20767b);
        this.p3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.A7, 0);
        this.g3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.B7, 0);
        Resources resources = getResources();
        this.k3 = resources.getDimensionPixelSize(R.dimen.H9);
        this.h3 = (float) resources.getDimensionPixelSize(R.dimen.F9);
        int color = obtainStyledAttributes.getColor(R.styleable.z7, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        q(0.0f);
        this.d3 = ViewConfiguration.get(context).getScaledTouchSlop();
        ViewCompat.Z1(this, 2);
        obtainStyledAttributes.recycle();
    }
}
