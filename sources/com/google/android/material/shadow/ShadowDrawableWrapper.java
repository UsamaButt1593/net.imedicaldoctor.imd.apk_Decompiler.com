package com.google.android.material.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;

@Deprecated
public class ShadowDrawableWrapper extends DrawableWrapperCompat {
    static final double k3 = Math.cos(Math.toRadians(45.0d));
    static final float l3 = 1.5f;
    static final float m3 = 0.25f;
    static final float n3 = 0.5f;
    static final float o3 = 1.0f;
    @NonNull
    final Paint X;
    float X2;
    @NonNull
    final Paint Y;
    Path Y2;
    @NonNull
    final RectF Z;
    float Z2;
    float a3;
    float b3;
    float c3;
    private boolean d3 = true;
    private final int e3;
    private final int f3;
    private final int g3;
    private boolean h3 = true;
    private float i3;
    private boolean j3 = false;

    public ShadowDrawableWrapper(Context context, Drawable drawable, float f2, float f4, float f5) {
        super(drawable);
        this.e3 = ContextCompat.g(context, R.color.A0);
        this.f3 = ContextCompat.g(context, R.color.z0);
        this.g3 = ContextCompat.g(context, R.color.y0);
        Paint paint = new Paint(5);
        this.X = paint;
        paint.setStyle(Paint.Style.FILL);
        this.X2 = (float) Math.round(f2);
        this.Z = new RectF();
        Paint paint2 = new Paint(paint);
        this.Y = paint2;
        paint2.setAntiAlias(false);
        r(f4, f5);
    }

    private void c(@NonNull Rect rect) {
        float f2 = this.a3;
        float f4 = l3 * f2;
        this.Z.set(((float) rect.left) + f2, ((float) rect.top) + f4, ((float) rect.right) - f2, ((float) rect.bottom) - f4);
        Drawable a2 = a();
        RectF rectF = this.Z;
        a2.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        d();
    }

    private void d() {
        float f2 = this.X2;
        RectF rectF = new RectF(-f2, -f2, f2, f2);
        RectF rectF2 = new RectF(rectF);
        float f4 = this.b3;
        rectF2.inset(-f4, -f4);
        Path path = this.Y2;
        if (path == null) {
            this.Y2 = new Path();
        } else {
            path.reset();
        }
        this.Y2.setFillType(Path.FillType.EVEN_ODD);
        this.Y2.moveTo(-this.X2, 0.0f);
        this.Y2.rLineTo(-this.b3, 0.0f);
        this.Y2.arcTo(rectF2, 180.0f, 90.0f, false);
        this.Y2.arcTo(rectF, 270.0f, -90.0f, false);
        this.Y2.close();
        float f5 = -rectF2.top;
        if (f5 > 0.0f) {
            float f6 = this.X2 / f5;
            Paint paint = this.X;
            float[] fArr = {0.0f, f6, ((1.0f - f6) / 2.0f) + f6, 1.0f};
            RadialGradient radialGradient = r8;
            RadialGradient radialGradient2 = new RadialGradient(0.0f, 0.0f, f5, new int[]{0, this.e3, this.f3, this.g3}, fArr, Shader.TileMode.CLAMP);
            paint.setShader(radialGradient);
        }
        this.Y.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.e3, this.f3, this.g3}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.Y.setAntiAlias(false);
    }

    public static float e(float f2, float f4, boolean z) {
        return z ? (float) (((double) f2) + ((1.0d - k3) * ((double) f4))) : f2;
    }

    public static float f(float f2, float f4, boolean z) {
        float f5 = f2 * l3;
        return z ? (float) (((double) f5) + ((1.0d - k3) * ((double) f4))) : f5;
    }

    private void g(@NonNull Canvas canvas) {
        float f2;
        int i2;
        int i4;
        float f4;
        float f5;
        float f6;
        Canvas canvas2 = canvas;
        int save = canvas.save();
        canvas2.rotate(this.i3, this.Z.centerX(), this.Z.centerY());
        float f7 = this.X2;
        float f8 = (-f7) - this.b3;
        float f9 = f7 * 2.0f;
        boolean z = this.Z.width() - f9 > 0.0f;
        boolean z2 = this.Z.height() - f9 > 0.0f;
        float f10 = this.c3;
        float f11 = f7 / ((f10 - (0.5f * f10)) + f7);
        float f12 = f7 / ((f10 - (m3 * f10)) + f7);
        float f13 = f7 / ((f10 - (f10 * 1.0f)) + f7);
        int save2 = canvas.save();
        RectF rectF = this.Z;
        canvas2.translate(rectF.left + f7, rectF.top + f7);
        canvas2.scale(f11, f12);
        canvas2.drawPath(this.Y2, this.X);
        if (z) {
            canvas2.scale(1.0f / f11, 1.0f);
            i4 = save2;
            f2 = f13;
            i2 = save;
            f4 = f12;
            canvas.drawRect(0.0f, f8, this.Z.width() - f9, -this.X2, this.Y);
        } else {
            i4 = save2;
            f2 = f13;
            i2 = save;
            f4 = f12;
        }
        canvas2.restoreToCount(i4);
        int save3 = canvas.save();
        RectF rectF2 = this.Z;
        canvas2.translate(rectF2.right - f7, rectF2.bottom - f7);
        float f14 = f2;
        canvas2.scale(f11, f14);
        canvas2.rotate(180.0f);
        canvas2.drawPath(this.Y2, this.X);
        if (z) {
            canvas2.scale(1.0f / f11, 1.0f);
            f5 = f4;
            f6 = f14;
            canvas.drawRect(0.0f, f8, this.Z.width() - f9, (-this.X2) + this.b3, this.Y);
        } else {
            f5 = f4;
            f6 = f14;
        }
        canvas2.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF3 = this.Z;
        canvas2.translate(rectF3.left + f7, rectF3.bottom - f7);
        canvas2.scale(f11, f6);
        canvas2.rotate(270.0f);
        canvas2.drawPath(this.Y2, this.X);
        if (z2) {
            canvas2.scale(1.0f / f6, 1.0f);
            canvas.drawRect(0.0f, f8, this.Z.height() - f9, -this.X2, this.Y);
        }
        canvas2.restoreToCount(save4);
        int save5 = canvas.save();
        RectF rectF4 = this.Z;
        canvas2.translate(rectF4.right - f7, rectF4.top + f7);
        float f15 = f5;
        canvas2.scale(f11, f15);
        canvas2.rotate(90.0f);
        canvas2.drawPath(this.Y2, this.X);
        if (z2) {
            canvas2.scale(1.0f / f15, 1.0f);
            canvas.drawRect(0.0f, f8, this.Z.height() - f9, -this.X2, this.Y);
        }
        canvas2.restoreToCount(save5);
        canvas2.restoreToCount(i2);
    }

    private static int s(float f2) {
        int round = Math.round(f2);
        return round % 2 == 1 ? round - 1 : round;
    }

    public void draw(@NonNull Canvas canvas) {
        if (this.d3) {
            c(getBounds());
            this.d3 = false;
        }
        g(canvas);
        super.draw(canvas);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(@NonNull Rect rect) {
        int ceil = (int) Math.ceil((double) f(this.a3, this.X2, this.h3));
        int ceil2 = (int) Math.ceil((double) e(this.a3, this.X2, this.h3));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public float h() {
        return this.X2;
    }

    public float i() {
        return this.a3;
    }

    public float j() {
        float f2 = this.a3;
        return (Math.max(f2, this.X2 + ((f2 * l3) / 2.0f)) * 2.0f) + (this.a3 * l3 * 2.0f);
    }

    public float k() {
        float f2 = this.a3;
        return (Math.max(f2, this.X2 + (f2 / 2.0f)) * 2.0f) + (this.a3 * 2.0f);
    }

    public float l() {
        return this.c3;
    }

    public void m(boolean z) {
        this.h3 = z;
        invalidateSelf();
    }

    public void n(float f2) {
        float round = (float) Math.round(f2);
        if (this.X2 != round) {
            this.X2 = round;
            this.d3 = true;
            invalidateSelf();
        }
    }

    public void o(float f2) {
        r(this.c3, f2);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.d3 = true;
    }

    public final void p(float f2) {
        if (this.i3 != f2) {
            this.i3 = f2;
            invalidateSelf();
        }
    }

    public void q(float f2) {
        r(f2, this.a3);
    }

    public void r(float f2, float f4) {
        if (f2 < 0.0f || f4 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float s = (float) s(f2);
        float s2 = (float) s(f4);
        if (s > s2) {
            if (!this.j3) {
                this.j3 = true;
            }
            s = s2;
        }
        if (this.c3 != s || this.a3 != s2) {
            this.c3 = s;
            this.a3 = s2;
            this.b3 = (float) Math.round(s * l3);
            this.Z2 = s2;
            this.d3 = true;
            invalidateSelf();
        }
    }

    public void setAlpha(int i2) {
        super.setAlpha(i2);
        this.X.setAlpha(i2);
        this.Y.setAlpha(i2);
    }
}
