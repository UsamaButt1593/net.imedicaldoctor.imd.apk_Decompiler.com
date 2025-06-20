package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.math.MathUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.DrawingDelegate;

final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {

    /* renamed from: b  reason: collision with root package name */
    private float f21671b = 300.0f;

    /* renamed from: c  reason: collision with root package name */
    private float f21672c;

    /* renamed from: d  reason: collision with root package name */
    private float f21673d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f21674e;
    @FloatRange(from = 0.0d, to = 1.0d)

    /* renamed from: f  reason: collision with root package name */
    private float f21675f;

    LinearDrawingDelegate(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
    }

    private void h(@NonNull Canvas canvas, @NonNull Paint paint, float f2, float f3, @ColorInt int i2, @Px int i3, @Px int i4) {
        Paint paint2 = paint;
        float d2 = MathUtils.d(f2, 0.0f, 1.0f);
        float d3 = MathUtils.d(f3, 0.0f, 1.0f);
        float f4 = com.google.android.material.math.MathUtils.f(1.0f - this.f21675f, 1.0f, d2);
        float f5 = com.google.android.material.math.MathUtils.f(1.0f - this.f21675f, 1.0f, d3);
        float f6 = this.f21671b;
        int d4 = (int) ((f4 * f6) + ((float) ((int) ((((float) i3) * MathUtils.d(f4, 0.0f, 0.01f)) / 0.01f))));
        int d5 = (int) ((f5 * f6) - ((float) ((int) ((((float) i4) * (1.0f - MathUtils.d(f5, 0.99f, 1.0f))) / 0.01f))));
        float f7 = (-f6) / 2.0f;
        if (d4 <= d5) {
            float f8 = this.f21673d;
            float f9 = ((float) d4) + f8;
            float f10 = ((float) d5) - f8;
            float f11 = f8 * 2.0f;
            paint2.setColor(i2);
            paint2.setAntiAlias(true);
            paint2.setStrokeWidth(this.f21672c);
            if (f9 >= f10) {
                j(canvas, paint, new PointF(f9 + f7, 0.0f), new PointF(f10 + f7, 0.0f), f11, this.f21672c);
                return;
            }
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeCap(this.f21674e ? Paint.Cap.ROUND : Paint.Cap.BUTT);
            float f12 = f9 + f7;
            float f13 = f10 + f7;
            canvas.drawLine(f12, 0.0f, f13, 0.0f, paint);
            if (!this.f21674e && this.f21673d > 0.0f) {
                paint2.setStyle(Paint.Style.FILL);
                if (f9 > 0.0f) {
                    i(canvas, paint, new PointF(f12, 0.0f), f11, this.f21672c);
                }
                if (f10 < this.f21671b) {
                    i(canvas, paint, new PointF(f13, 0.0f), f11, this.f21672c);
                }
            }
        }
    }

    private void i(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull PointF pointF, float f2, float f3) {
        j(canvas, paint, pointF, (PointF) null, f2, f3);
    }

    private void j(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull PointF pointF, @Nullable PointF pointF2, float f2, float f3) {
        float min = Math.min(f3, this.f21672c);
        float f4 = f2 / 2.0f;
        float min2 = Math.min(f4, (this.f21673d * min) / this.f21672c);
        RectF rectF = new RectF((-f2) / 2.0f, (-min) / 2.0f, f4, min / 2.0f);
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        if (pointF2 != null) {
            canvas.translate(pointF2.x, pointF2.y);
            Path path = new Path();
            path.addRoundRect(rectF, min2, min2, Path.Direction.CCW);
            canvas.clipPath(path);
            canvas.translate(-pointF2.x, -pointF2.y);
        }
        canvas.translate(pointF.x, pointF.y);
        canvas.drawRoundRect(rectF, min2, min2, paint);
        canvas.restore();
    }

    /* access modifiers changed from: package-private */
    public void a(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = 0.0d, to = 1.0d) float f2, boolean z, boolean z2) {
        this.f21671b = (float) rect.width();
        float f3 = (float) ((LinearProgressIndicatorSpec) this.f21664a).f21636a;
        canvas.translate(((float) rect.left) + (((float) rect.width()) / 2.0f), ((float) rect.top) + (((float) rect.height()) / 2.0f) + Math.max(0.0f, (((float) rect.height()) - f3) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.f21664a).f21699j) {
            canvas.scale(-1.0f, 1.0f);
        }
        float f4 = this.f21671b / 2.0f;
        float f5 = f3 / 2.0f;
        canvas.clipRect(-f4, -f5, f4, f5);
        S s = this.f21664a;
        this.f21674e = ((LinearProgressIndicatorSpec) s).f21636a / 2 == ((LinearProgressIndicatorSpec) s).f21637b;
        this.f21672c = ((float) ((LinearProgressIndicatorSpec) s).f21636a) * f2;
        this.f21673d = ((float) Math.min(((LinearProgressIndicatorSpec) s).f21636a / 2, ((LinearProgressIndicatorSpec) s).f21637b)) * f2;
        if (z || z2) {
            if ((z && ((LinearProgressIndicatorSpec) this.f21664a).f21640e == 2) || (z2 && ((LinearProgressIndicatorSpec) this.f21664a).f21641f == 1)) {
                canvas.scale(1.0f, -1.0f);
            }
            if (z || (z2 && ((LinearProgressIndicatorSpec) this.f21664a).f21641f != 3)) {
                canvas.translate(0.0f, (((float) ((LinearProgressIndicatorSpec) this.f21664a).f21636a) * (1.0f - f2)) / 2.0f);
            }
        }
        if (!z2 || ((LinearProgressIndicatorSpec) this.f21664a).f21641f != 3) {
            this.f21675f = 1.0f;
        } else {
            this.f21675f = f2;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(@NonNull Canvas canvas, @NonNull Paint paint, @ColorInt int i2, @IntRange(from = 0, to = 255) int i3) {
        int a2 = MaterialColors.a(i2, i3);
        if (((LinearProgressIndicatorSpec) this.f21664a).f21700k > 0 && a2 != 0) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(a2);
            PointF pointF = new PointF((this.f21671b / 2.0f) - (this.f21672c / 2.0f), 0.0f);
            S s = this.f21664a;
            i(canvas, paint, pointF, (float) ((LinearProgressIndicatorSpec) s).f21700k, (float) ((LinearProgressIndicatorSpec) s).f21700k);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate.ActiveIndicator activeIndicator, int i2) {
        int a2 = MaterialColors.a(activeIndicator.f21667c, i2);
        float f2 = activeIndicator.f21665a;
        float f3 = activeIndicator.f21666b;
        int i3 = activeIndicator.f21668d;
        h(canvas, paint, f2, f3, a2, i3, i3);
    }

    /* access modifiers changed from: package-private */
    public void d(@NonNull Canvas canvas, @NonNull Paint paint, float f2, float f3, int i2, int i3, @Px int i4) {
        h(canvas, paint, f2, f3, MaterialColors.a(i2, i3), i4, i4);
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return ((LinearProgressIndicatorSpec) this.f21664a).f21636a;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return -1;
    }
}
