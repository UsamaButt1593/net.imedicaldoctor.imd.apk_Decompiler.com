package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.math.MathUtils;
import com.google.android.material.progressindicator.DrawingDelegate;

final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {

    /* renamed from: g  reason: collision with root package name */
    private static final float f21643g = 0.01f;

    /* renamed from: b  reason: collision with root package name */
    private float f21644b;

    /* renamed from: c  reason: collision with root package name */
    private float f21645c;

    /* renamed from: d  reason: collision with root package name */
    private float f21646d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f21647e;
    @FloatRange(from = 0.0d, to = 1.0d)

    /* renamed from: f  reason: collision with root package name */
    private float f21648f;

    CircularDrawingDelegate(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
    }

    private void h(@NonNull Canvas canvas, @NonNull Paint paint, float f2, float f3, @ColorInt int i2, @Px int i3, @Px int i4) {
        Paint paint2 = paint;
        float f4 = f3 >= f2 ? f3 - f2 : (f3 + 1.0f) - f2;
        float f5 = f2 % 1.0f;
        if (this.f21648f < 1.0f) {
            float f6 = f5 + f4;
            if (f6 > 1.0f) {
                Canvas canvas2 = canvas;
                Paint paint3 = paint;
                int i5 = i2;
                h(canvas2, paint3, f5, 1.0f, i5, i3, 0);
                h(canvas2, paint3, 1.0f, f6, i5, 0, i4);
                return;
            }
        }
        float degrees = (float) Math.toDegrees((double) (this.f21645c / this.f21646d));
        if (f5 == 0.0f && f4 >= 0.99f) {
            f4 += ((f4 - 0.99f) * ((degrees * 2.0f) / 360.0f)) / f21643g;
        }
        float f7 = MathUtils.f(1.0f - this.f21648f, 1.0f, f5);
        float f8 = MathUtils.f(0.0f, this.f21648f, f4);
        float degrees2 = (float) Math.toDegrees((double) (((float) i3) / this.f21646d));
        float degrees3 = ((f8 * 360.0f) - degrees2) - ((float) Math.toDegrees((double) (((float) i4) / this.f21646d)));
        float f9 = (f7 * 360.0f) + degrees2;
        if (degrees3 > 0.0f) {
            paint2.setAntiAlias(true);
            paint2.setColor(i2);
            paint2.setStrokeWidth(this.f21644b);
            float f10 = degrees * 2.0f;
            if (degrees3 < f10) {
                float f11 = degrees3 / f10;
                paint2.setStyle(Paint.Style.FILL);
                j(canvas, paint, f9 + (degrees * f11), this.f21645c * 2.0f, this.f21644b, f11);
                return;
            }
            float f12 = this.f21646d;
            RectF rectF = new RectF(-f12, -f12, f12, f12);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeCap(this.f21647e ? Paint.Cap.ROUND : Paint.Cap.BUTT);
            float f13 = f9 + degrees;
            canvas.drawArc(rectF, f13, degrees3 - f10, false, paint);
            if (!this.f21647e && this.f21645c > 0.0f) {
                paint2.setStyle(Paint.Style.FILL);
                Canvas canvas3 = canvas;
                Paint paint4 = paint;
                i(canvas3, paint4, f13, this.f21645c * 2.0f, this.f21644b);
                i(canvas3, paint4, (f9 + degrees3) - degrees, this.f21645c * 2.0f, this.f21644b);
            }
        }
    }

    private void i(@NonNull Canvas canvas, @NonNull Paint paint, float f2, float f3, float f4) {
        j(canvas, paint, f2, f3, f4, 1.0f);
    }

    private void j(@NonNull Canvas canvas, @NonNull Paint paint, float f2, float f3, float f4, float f5) {
        float min = (float) ((int) Math.min(f4, this.f21644b));
        float f6 = f3 / 2.0f;
        float min2 = Math.min(f6, (this.f21645c * min) / this.f21644b);
        RectF rectF = new RectF((-min) / 2.0f, (-f3) / 2.0f, min / 2.0f, f6);
        canvas.save();
        double d2 = (double) f2;
        canvas.translate((float) (((double) this.f21646d) * Math.cos(Math.toRadians(d2))), (float) (((double) this.f21646d) * Math.sin(Math.toRadians(d2))));
        canvas.rotate(f2);
        canvas.scale(f5, f5);
        canvas.drawRoundRect(rectF, min2, min2, paint);
        canvas.restore();
    }

    private int k() {
        S s = this.f21664a;
        return ((CircularProgressIndicatorSpec) s).f21661h + (((CircularProgressIndicatorSpec) s).f21662i * 2);
    }

    /* access modifiers changed from: package-private */
    public void a(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = 0.0d, to = 1.0d) float f2, boolean z, boolean z2) {
        float f3;
        float width = ((float) rect.width()) / ((float) f());
        float height = ((float) rect.height()) / ((float) e());
        S s = this.f21664a;
        float f4 = (((float) ((CircularProgressIndicatorSpec) s).f21661h) / 2.0f) + ((float) ((CircularProgressIndicatorSpec) s).f21662i);
        canvas.translate((f4 * width) + ((float) rect.left), (f4 * height) + ((float) rect.top));
        canvas.rotate(-90.0f);
        canvas.scale(width, height);
        if (((CircularProgressIndicatorSpec) this.f21664a).f21663j != 0) {
            canvas.scale(1.0f, -1.0f);
        }
        float f5 = -f4;
        canvas.clipRect(f5, f5, f4, f4);
        S s2 = this.f21664a;
        this.f21647e = ((CircularProgressIndicatorSpec) s2).f21636a / 2 <= ((CircularProgressIndicatorSpec) s2).f21637b;
        this.f21644b = ((float) ((CircularProgressIndicatorSpec) s2).f21636a) * f2;
        this.f21645c = ((float) Math.min(((CircularProgressIndicatorSpec) s2).f21636a / 2, ((CircularProgressIndicatorSpec) s2).f21637b)) * f2;
        S s3 = this.f21664a;
        float f6 = ((float) (((CircularProgressIndicatorSpec) s3).f21661h - ((CircularProgressIndicatorSpec) s3).f21636a)) / 2.0f;
        this.f21646d = f6;
        if (z || z2) {
            if ((z && ((CircularProgressIndicatorSpec) s3).f21640e == 2) || (z2 && ((CircularProgressIndicatorSpec) s3).f21641f == 1)) {
                f3 = f6 + (((1.0f - f2) * ((float) ((CircularProgressIndicatorSpec) s3).f21636a)) / 2.0f);
            } else if ((z && ((CircularProgressIndicatorSpec) s3).f21640e == 1) || (z2 && ((CircularProgressIndicatorSpec) s3).f21641f == 2)) {
                f3 = f6 - (((1.0f - f2) * ((float) ((CircularProgressIndicatorSpec) s3).f21636a)) / 2.0f);
            }
            this.f21646d = f3;
        }
        if (!z2 || ((CircularProgressIndicatorSpec) s3).f21641f != 3) {
            this.f21648f = 1.0f;
        } else {
            this.f21648f = f2;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(@NonNull Canvas canvas, @NonNull Paint paint, @ColorInt int i2, @IntRange(from = 0, to = 255) int i3) {
    }

    /* access modifiers changed from: package-private */
    public void c(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate.ActiveIndicator activeIndicator, @IntRange(from = 0, to = 255) int i2) {
        int a2 = MaterialColors.a(activeIndicator.f21667c, i2);
        float f2 = activeIndicator.f21665a;
        float f3 = activeIndicator.f21666b;
        int i3 = activeIndicator.f21668d;
        h(canvas, paint, f2, f3, a2, i3, i3);
    }

    /* access modifiers changed from: package-private */
    public void d(@NonNull Canvas canvas, @NonNull Paint paint, float f2, float f3, @ColorInt int i2, @IntRange(from = 0, to = 255) int i3, int i4) {
        h(canvas, paint, f2, f3, MaterialColors.a(i2, i3), i4, i4);
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return k();
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return k();
    }
}
