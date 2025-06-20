package com.dd;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

class CircularProgressDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private float f18564a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    private final float f18565b = -90.0f;

    /* renamed from: c  reason: collision with root package name */
    private final int f18566c;

    /* renamed from: d  reason: collision with root package name */
    private final int f18567d;

    /* renamed from: e  reason: collision with root package name */
    private final int f18568e;

    /* renamed from: f  reason: collision with root package name */
    private RectF f18569f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f18570g;

    /* renamed from: h  reason: collision with root package name */
    private Path f18571h;

    public CircularProgressDrawable(int i2, int i3, int i4) {
        this.f18566c = i2;
        this.f18567d = i3;
        this.f18568e = i4;
    }

    private Paint a() {
        if (this.f18570g == null) {
            Paint paint = new Paint();
            this.f18570g = paint;
            paint.setAntiAlias(true);
            this.f18570g.setStyle(Paint.Style.STROKE);
            this.f18570g.setStrokeWidth((float) this.f18567d);
            this.f18570g.setColor(this.f18568e);
        }
        return this.f18570g;
    }

    private RectF b() {
        if (this.f18569f == null) {
            int i2 = this.f18567d / 2;
            float f2 = (float) i2;
            this.f18569f = new RectF(f2, f2, (float) (c() - i2), (float) (c() - i2));
        }
        return this.f18569f;
    }

    public int c() {
        return this.f18566c;
    }

    public void d(float f2) {
        this.f18564a = f2;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (this.f18571h == null) {
            this.f18571h = new Path();
        }
        this.f18571h.reset();
        this.f18571h.addArc(b(), this.f18565b, this.f18564a);
        this.f18571h.offset((float) bounds.left, (float) bounds.top);
        canvas.drawPath(this.f18571h, a());
    }

    @SuppressLint({"WrongConstant"})
    public int getOpacity() {
        return 1;
    }

    public void setAlpha(int i2) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
