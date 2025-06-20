package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.cardview.R;

class RoundRectDrawableWithShadow extends Drawable {
    private static final double q = Math.cos(Math.toRadians(45.0d));
    private static final float r = 1.5f;
    static RoundRectHelper s;

    /* renamed from: a  reason: collision with root package name */
    private final int f3528a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f3529b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f3530c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f3531d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f3532e;

    /* renamed from: f  reason: collision with root package name */
    private float f3533f;

    /* renamed from: g  reason: collision with root package name */
    private Path f3534g;

    /* renamed from: h  reason: collision with root package name */
    private float f3535h;

    /* renamed from: i  reason: collision with root package name */
    private float f3536i;

    /* renamed from: j  reason: collision with root package name */
    private float f3537j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f3538k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f3539l = true;

    /* renamed from: m  reason: collision with root package name */
    private final int f3540m;

    /* renamed from: n  reason: collision with root package name */
    private final int f3541n;
    private boolean o = true;
    private boolean p = false;

    interface RoundRectHelper {
        void a(Canvas canvas, RectF rectF, float f2, Paint paint);
    }

    RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f2, float f3, float f4) {
        this.f3540m = resources.getColor(R.color.f3490d);
        this.f3541n = resources.getColor(R.color.f3489c);
        this.f3528a = resources.getDimensionPixelSize(R.dimen.f3491a);
        this.f3529b = new Paint(5);
        n(colorStateList);
        Paint paint = new Paint(5);
        this.f3530c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f3533f = (float) ((int) (f2 + 0.5f));
        this.f3532e = new RectF();
        Paint paint2 = new Paint(this.f3530c);
        this.f3531d = paint2;
        paint2.setAntiAlias(false);
        s(f3, f4);
    }

    private void a(Rect rect) {
        float f2 = this.f3535h;
        float f3 = r * f2;
        this.f3532e.set(((float) rect.left) + f2, ((float) rect.top) + f3, ((float) rect.right) - f2, ((float) rect.bottom) - f3);
        b();
    }

    private void b() {
        float f2 = this.f3533f;
        RectF rectF = new RectF(-f2, -f2, f2, f2);
        RectF rectF2 = new RectF(rectF);
        float f3 = this.f3536i;
        rectF2.inset(-f3, -f3);
        Path path = this.f3534g;
        if (path == null) {
            this.f3534g = new Path();
        } else {
            path.reset();
        }
        this.f3534g.setFillType(Path.FillType.EVEN_ODD);
        this.f3534g.moveTo(-this.f3533f, 0.0f);
        this.f3534g.rLineTo(-this.f3536i, 0.0f);
        this.f3534g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f3534g.arcTo(rectF, 270.0f, -90.0f, false);
        this.f3534g.close();
        float f4 = this.f3533f;
        float f5 = f4 / (this.f3536i + f4);
        Paint paint = this.f3530c;
        float f6 = this.f3533f + this.f3536i;
        int i2 = this.f3540m;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f6, new int[]{i2, i2, this.f3541n}, new float[]{0.0f, f5, 1.0f}, tileMode));
        Paint paint2 = this.f3531d;
        float f7 = this.f3533f;
        float f8 = this.f3536i;
        float f9 = (-f7) - f8;
        int i3 = this.f3540m;
        paint2.setShader(new LinearGradient(0.0f, (-f7) + f8, 0.0f, f9, new int[]{i3, i3, this.f3541n}, new float[]{0.0f, 0.5f, 1.0f}, tileMode));
        this.f3531d.setAntiAlias(false);
    }

    static float c(float f2, float f3, boolean z) {
        return z ? (float) (((double) f2) + ((1.0d - q) * ((double) f3))) : f2;
    }

    static float d(float f2, float f3, boolean z) {
        float f4 = f2 * r;
        return z ? (float) (((double) f4) + ((1.0d - q) * ((double) f3))) : f4;
    }

    private void e(Canvas canvas) {
        float f2 = this.f3533f;
        float f3 = (-f2) - this.f3536i;
        float f4 = f2 + ((float) this.f3528a) + (this.f3537j / 2.0f);
        float f5 = f4 * 2.0f;
        boolean z = this.f3532e.width() - f5 > 0.0f;
        boolean z2 = this.f3532e.height() - f5 > 0.0f;
        int save = canvas.save();
        RectF rectF = this.f3532e;
        canvas.translate(rectF.left + f4, rectF.top + f4);
        canvas.drawPath(this.f3534g, this.f3530c);
        if (z) {
            canvas.drawRect(0.0f, f3, this.f3532e.width() - f5, -this.f3533f, this.f3531d);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        RectF rectF2 = this.f3532e;
        canvas.translate(rectF2.right - f4, rectF2.bottom - f4);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f3534g, this.f3530c);
        if (z) {
            canvas.drawRect(0.0f, f3, this.f3532e.width() - f5, (-this.f3533f) + this.f3536i, this.f3531d);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        RectF rectF3 = this.f3532e;
        canvas.translate(rectF3.left + f4, rectF3.bottom - f4);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f3534g, this.f3530c);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.f3532e.height() - f5, -this.f3533f, this.f3531d);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF4 = this.f3532e;
        canvas.translate(rectF4.right - f4, rectF4.top + f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f3534g, this.f3530c);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.f3532e.height() - f5, -this.f3533f, this.f3531d);
        }
        canvas.restoreToCount(save4);
    }

    private void n(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f3538k = colorStateList;
        this.f3529b.setColor(colorStateList.getColorForState(getState(), this.f3538k.getDefaultColor()));
    }

    private void s(float f2, float f3) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f2 + ". Must be >= 0");
        } else if (f3 >= 0.0f) {
            float t = (float) t(f2);
            float t2 = (float) t(f3);
            if (t > t2) {
                if (!this.p) {
                    this.p = true;
                }
                t = t2;
            }
            if (this.f3537j != t || this.f3535h != t2) {
                this.f3537j = t;
                this.f3535h = t2;
                this.f3536i = (float) ((int) ((t * r) + ((float) this.f3528a) + 0.5f));
                this.f3539l = true;
                invalidateSelf();
            }
        } else {
            throw new IllegalArgumentException("Invalid max shadow size " + f3 + ". Must be >= 0");
        }
    }

    private int t(float f2) {
        int i2 = (int) (f2 + 0.5f);
        return i2 % 2 == 1 ? i2 - 1 : i2;
    }

    public void draw(Canvas canvas) {
        if (this.f3539l) {
            a(getBounds());
            this.f3539l = false;
        }
        canvas.translate(0.0f, this.f3537j / 2.0f);
        e(canvas);
        canvas.translate(0.0f, (-this.f3537j) / 2.0f);
        s.a(canvas, this.f3532e, this.f3533f, this.f3529b);
    }

    /* access modifiers changed from: package-private */
    public ColorStateList f() {
        return this.f3538k;
    }

    /* access modifiers changed from: package-private */
    public float g() {
        return this.f3533f;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) d(this.f3535h, this.f3533f, this.o));
        int ceil2 = (int) Math.ceil((double) c(this.f3535h, this.f3533f, this.o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void h(Rect rect) {
        getPadding(rect);
    }

    /* access modifiers changed from: package-private */
    public float i() {
        return this.f3535h;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.f3538k;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* access modifiers changed from: package-private */
    public float j() {
        float f2 = this.f3535h;
        return (Math.max(f2, this.f3533f + ((float) this.f3528a) + ((f2 * r) / 2.0f)) * 2.0f) + (((this.f3535h * r) + ((float) this.f3528a)) * 2.0f);
    }

    /* access modifiers changed from: package-private */
    public float k() {
        float f2 = this.f3535h;
        return (Math.max(f2, this.f3533f + ((float) this.f3528a) + (f2 / 2.0f)) * 2.0f) + ((this.f3535h + ((float) this.f3528a)) * 2.0f);
    }

    /* access modifiers changed from: package-private */
    public float l() {
        return this.f3537j;
    }

    /* access modifiers changed from: package-private */
    public void m(boolean z) {
        this.o = z;
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void o(@Nullable ColorStateList colorStateList) {
        n(colorStateList);
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f3539l = true;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f3538k;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f3529b.getColor() == colorForState) {
            return false;
        }
        this.f3529b.setColor(colorForState);
        this.f3539l = true;
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void p(float f2) {
        if (f2 >= 0.0f) {
            float f3 = (float) ((int) (f2 + 0.5f));
            if (this.f3533f != f3) {
                this.f3533f = f3;
                this.f3539l = true;
                invalidateSelf();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f2 + ". Must be >= 0");
    }

    /* access modifiers changed from: package-private */
    public void q(float f2) {
        s(this.f3537j, f2);
    }

    /* access modifiers changed from: package-private */
    public void r(float f2) {
        s(f2, this.f3535h);
    }

    public void setAlpha(int i2) {
        this.f3529b.setAlpha(i2);
        this.f3530c.setAlpha(i2);
        this.f3531d.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f3529b.setColorFilter(colorFilter);
    }
}
