package com.dd;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.media3.exoplayer.ExoPlayer;

class CircularAnimatedDrawable extends Drawable implements Animatable {
    private static final Interpolator f3 = new LinearInterpolator();
    private static final Interpolator g3 = new DecelerateInterpolator();
    private static final int h3 = 2000;
    private static final int i3 = 600;
    public static final int j3 = 30;
    private ObjectAnimator X;
    private final Paint X2;
    private ObjectAnimator Y;
    private float Y2;
    private boolean Z;
    private float Z2;
    private float a3;
    private final float b3;
    private boolean c3;
    private final Property<CircularAnimatedDrawable, Float> d3;
    private final Property<CircularAnimatedDrawable, Float> e3;
    private final RectF s = new RectF();

    public CircularAnimatedDrawable(int i2, float f2) {
        Class<Float> cls = Float.class;
        this.d3 = new Property<CircularAnimatedDrawable, Float>(cls, "angle") {
            /* renamed from: a */
            public Float get(CircularAnimatedDrawable circularAnimatedDrawable) {
                return Float.valueOf(circularAnimatedDrawable.e());
            }

            /* renamed from: b */
            public void set(CircularAnimatedDrawable circularAnimatedDrawable, Float f2) {
                circularAnimatedDrawable.g(f2.floatValue());
            }
        };
        this.e3 = new Property<CircularAnimatedDrawable, Float>(cls, "arc") {
            /* renamed from: a */
            public Float get(CircularAnimatedDrawable circularAnimatedDrawable) {
                return Float.valueOf(circularAnimatedDrawable.f());
            }

            /* renamed from: b */
            public void set(CircularAnimatedDrawable circularAnimatedDrawable, Float f2) {
                circularAnimatedDrawable.h(f2.floatValue());
            }
        };
        this.b3 = f2;
        Paint paint = new Paint();
        this.X2 = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f2);
        paint.setColor(i2);
        i();
    }

    private void i() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, this.d3, new float[]{360.0f});
        this.Y = ofFloat;
        ofFloat.setInterpolator(f3);
        this.Y.setDuration(ExoPlayer.a1);
        this.Y.setRepeatMode(1);
        this.Y.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, this.e3, new float[]{300.0f});
        this.X = ofFloat2;
        ofFloat2.setInterpolator(g3);
        this.X.setDuration(600);
        this.X.setRepeatMode(1);
        this.X.setRepeatCount(-1);
        this.X.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
                CircularAnimatedDrawable.this.j();
            }

            public void onAnimationStart(Animator animator) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void j() {
        boolean z = !this.Z;
        this.Z = z;
        if (z) {
            this.Y2 = (this.Y2 + 60.0f) % 360.0f;
        }
    }

    public void draw(Canvas canvas) {
        float f2;
        float f4 = this.Z2 - this.Y2;
        float f5 = this.a3;
        if (!this.Z) {
            f4 += f5;
            f2 = (360.0f - f5) - 30.0f;
        } else {
            f2 = f5 + 30.0f;
        }
        canvas.drawArc(this.s, f4, f2, false, this.X2);
    }

    public float e() {
        return this.Z2;
    }

    public float f() {
        return this.a3;
    }

    public void g(float f2) {
        this.Z2 = f2;
        invalidateSelf();
    }

    public int getOpacity() {
        return -2;
    }

    public void h(float f2) {
        this.a3 = f2;
        invalidateSelf();
    }

    public boolean isRunning() {
        return this.c3;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        RectF rectF = this.s;
        float f2 = this.b3;
        rectF.left = ((float) rect.left) + (f2 / 2.0f) + 0.5f;
        rectF.right = (((float) rect.right) - (f2 / 2.0f)) - 0.5f;
        rectF.top = ((float) rect.top) + (f2 / 2.0f) + 0.5f;
        rectF.bottom = (((float) rect.bottom) - (f2 / 2.0f)) - 0.5f;
    }

    public void setAlpha(int i2) {
        this.X2.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.X2.setColorFilter(colorFilter);
    }

    public void start() {
        if (!isRunning()) {
            this.c3 = true;
            this.Y.start();
            this.X.start();
            invalidateSelf();
        }
    }

    public void stop() {
        if (isRunning()) {
            this.c3 = false;
            this.Y.cancel();
            this.X.cancel();
            invalidateSelf();
        }
    }
}
