package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DrawerArrowDrawable extends Drawable {

    /* renamed from: m  reason: collision with root package name */
    public static final int f2875m = 0;

    /* renamed from: n  reason: collision with root package name */
    public static final int f2876n = 1;
    public static final int o = 2;
    public static final int p = 3;
    private static final float q = ((float) Math.toRadians(45.0d));

    /* renamed from: a  reason: collision with root package name */
    private final Paint f2877a;

    /* renamed from: b  reason: collision with root package name */
    private float f2878b;

    /* renamed from: c  reason: collision with root package name */
    private float f2879c;

    /* renamed from: d  reason: collision with root package name */
    private float f2880d;

    /* renamed from: e  reason: collision with root package name */
    private float f2881e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2882f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f2883g = new Path();

    /* renamed from: h  reason: collision with root package name */
    private final int f2884h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2885i = false;

    /* renamed from: j  reason: collision with root package name */
    private float f2886j;

    /* renamed from: k  reason: collision with root package name */
    private float f2887k;

    /* renamed from: l  reason: collision with root package name */
    private int f2888l = 2;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ArrowDirection {
    }

    public DrawerArrowDrawable(Context context) {
        Paint paint = new Paint();
        this.f2877a = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, R.styleable.C3, R.attr.o1, R.style.v1);
        p(obtainStyledAttributes.getColor(R.styleable.G3, 0));
        o(obtainStyledAttributes.getDimension(R.styleable.K3, 0.0f));
        t(obtainStyledAttributes.getBoolean(R.styleable.J3, true));
        r((float) Math.round(obtainStyledAttributes.getDimension(R.styleable.I3, 0.0f)));
        this.f2884h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.H3, 0);
        this.f2879c = (float) Math.round(obtainStyledAttributes.getDimension(R.styleable.F3, 0.0f));
        this.f2878b = (float) Math.round(obtainStyledAttributes.getDimension(R.styleable.D3, 0.0f));
        this.f2880d = obtainStyledAttributes.getDimension(R.styleable.E3, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private static float k(float f2, float f3, float f4) {
        return f2 + ((f3 - f2) * f4);
    }

    public float a() {
        return this.f2878b;
    }

    public float b() {
        return this.f2880d;
    }

    public float c() {
        return this.f2879c;
    }

    public float d() {
        return this.f2877a.getStrokeWidth();
    }

    public void draw(@NonNull Canvas canvas) {
        Canvas canvas2 = canvas;
        Rect bounds = getBounds();
        int i2 = this.f2888l;
        boolean z = false;
        if (i2 != 0 && (i2 == 1 || (i2 == 3 ? DrawableCompat.f(this) == 0 : DrawableCompat.f(this) == 1))) {
            z = true;
        }
        float f2 = this.f2878b;
        float k2 = k(this.f2879c, (float) Math.sqrt((double) (f2 * f2 * 2.0f)), this.f2886j);
        float k3 = k(this.f2879c, this.f2880d, this.f2886j);
        float round = (float) Math.round(k(0.0f, this.f2887k, this.f2886j));
        float k4 = k(0.0f, q, this.f2886j);
        double d2 = (double) k2;
        float k5 = k(z ? 0.0f : -180.0f, z ? 180.0f : 0.0f, this.f2886j);
        double d3 = (double) k4;
        boolean z2 = z;
        float round2 = (float) Math.round(Math.cos(d3) * d2);
        float round3 = (float) Math.round(d2 * Math.sin(d3));
        this.f2883g.rewind();
        float k6 = k(this.f2881e + this.f2877a.getStrokeWidth(), -this.f2887k, this.f2886j);
        float f3 = (-k3) / 2.0f;
        this.f2883g.moveTo(f3 + round, 0.0f);
        this.f2883g.rLineTo(k3 - (round * 2.0f), 0.0f);
        this.f2883g.moveTo(f3, k6);
        this.f2883g.rLineTo(round2, round3);
        this.f2883g.moveTo(f3, -k6);
        this.f2883g.rLineTo(round2, -round3);
        this.f2883g.close();
        canvas.save();
        float strokeWidth = this.f2877a.getStrokeWidth();
        float height = ((float) bounds.height()) - (3.0f * strokeWidth);
        float f4 = this.f2881e;
        canvas2.translate((float) bounds.centerX(), ((float) ((((int) (height - (2.0f * f4))) / 4) * 2)) + (strokeWidth * 1.5f) + f4);
        if (this.f2882f) {
            canvas2.rotate(k5 * ((float) (this.f2885i ^ z2 ? -1 : 1)));
        } else if (z2) {
            canvas2.rotate(180.0f);
        }
        canvas2.drawPath(this.f2883g, this.f2877a);
        canvas.restore();
    }

    @ColorInt
    public int e() {
        return this.f2877a.getColor();
    }

    public int f() {
        return this.f2888l;
    }

    public float g() {
        return this.f2881e;
    }

    public int getIntrinsicHeight() {
        return this.f2884h;
    }

    public int getIntrinsicWidth() {
        return this.f2884h;
    }

    public int getOpacity() {
        return -3;
    }

    public final Paint h() {
        return this.f2877a;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float i() {
        return this.f2886j;
    }

    public boolean j() {
        return this.f2882f;
    }

    public void l(float f2) {
        if (this.f2878b != f2) {
            this.f2878b = f2;
            invalidateSelf();
        }
    }

    public void m(float f2) {
        if (this.f2880d != f2) {
            this.f2880d = f2;
            invalidateSelf();
        }
    }

    public void n(float f2) {
        if (this.f2879c != f2) {
            this.f2879c = f2;
            invalidateSelf();
        }
    }

    public void o(float f2) {
        if (this.f2877a.getStrokeWidth() != f2) {
            this.f2877a.setStrokeWidth(f2);
            this.f2887k = (float) (((double) (f2 / 2.0f)) * Math.cos((double) q));
            invalidateSelf();
        }
    }

    public void p(@ColorInt int i2) {
        if (i2 != this.f2877a.getColor()) {
            this.f2877a.setColor(i2);
            invalidateSelf();
        }
    }

    public void q(int i2) {
        if (i2 != this.f2888l) {
            this.f2888l = i2;
            invalidateSelf();
        }
    }

    public void r(float f2) {
        if (f2 != this.f2881e) {
            this.f2881e = f2;
            invalidateSelf();
        }
    }

    public void s(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.f2886j != f2) {
            this.f2886j = f2;
            invalidateSelf();
        }
    }

    public void setAlpha(int i2) {
        if (i2 != this.f2877a.getAlpha()) {
            this.f2877a.setAlpha(i2);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2877a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void t(boolean z) {
        if (this.f2882f != z) {
            this.f2882f = z;
            invalidateSelf();
        }
    }

    public void u(boolean z) {
        if (this.f2885i != z) {
            this.f2885i = z;
            invalidateSelf();
        }
    }
}
