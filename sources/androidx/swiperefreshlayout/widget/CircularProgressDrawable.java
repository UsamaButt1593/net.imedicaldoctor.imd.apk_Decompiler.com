package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CircularProgressDrawable extends Drawable implements Animatable {
    private static final Interpolator Z2 = new LinearInterpolator();
    private static final Interpolator a3 = new FastOutSlowInInterpolator();
    public static final int b3 = 0;
    private static final float c3 = 11.0f;
    private static final float d3 = 3.0f;
    private static final int e3 = 12;
    private static final int f3 = 6;
    public static final int g3 = 1;
    private static final float h3 = 7.5f;
    private static final float i3 = 2.5f;
    private static final int j3 = 10;
    private static final int k3 = 5;
    private static final int[] l3 = {ViewCompat.y};
    private static final float m3 = 0.75f;
    private static final float n3 = 0.5f;
    private static final int o3 = 1332;
    private static final float p3 = 216.0f;
    private static final float q3 = 0.8f;
    private static final float r3 = 0.01f;
    private static final float s3 = 0.20999998f;
    private float X;
    float X2;
    private Resources Y;
    boolean Y2;
    private Animator Z;
    private final Ring s;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressDrawableSize {
    }

    private static class Ring {

        /* renamed from: a  reason: collision with root package name */
        final RectF f15938a = new RectF();

        /* renamed from: b  reason: collision with root package name */
        final Paint f15939b;

        /* renamed from: c  reason: collision with root package name */
        final Paint f15940c;

        /* renamed from: d  reason: collision with root package name */
        final Paint f15941d;

        /* renamed from: e  reason: collision with root package name */
        float f15942e;

        /* renamed from: f  reason: collision with root package name */
        float f15943f;

        /* renamed from: g  reason: collision with root package name */
        float f15944g;

        /* renamed from: h  reason: collision with root package name */
        float f15945h;

        /* renamed from: i  reason: collision with root package name */
        int[] f15946i;

        /* renamed from: j  reason: collision with root package name */
        int f15947j;

        /* renamed from: k  reason: collision with root package name */
        float f15948k;

        /* renamed from: l  reason: collision with root package name */
        float f15949l;

        /* renamed from: m  reason: collision with root package name */
        float f15950m;

        /* renamed from: n  reason: collision with root package name */
        boolean f15951n;
        Path o;
        float p;
        float q;
        int r;
        int s;
        int t;
        int u;

        Ring() {
            Paint paint = new Paint();
            this.f15939b = paint;
            Paint paint2 = new Paint();
            this.f15940c = paint2;
            Paint paint3 = new Paint();
            this.f15941d = paint3;
            this.f15942e = 0.0f;
            this.f15943f = 0.0f;
            this.f15944g = 0.0f;
            this.f15945h = 5.0f;
            this.p = 1.0f;
            this.t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        /* access modifiers changed from: package-private */
        public void A(int i2) {
            this.f15941d.setColor(i2);
        }

        /* access modifiers changed from: package-private */
        public void B(float f2) {
            this.q = f2;
        }

        /* access modifiers changed from: package-private */
        public void C(int i2) {
            this.u = i2;
        }

        /* access modifiers changed from: package-private */
        public void D(ColorFilter colorFilter) {
            this.f15939b.setColorFilter(colorFilter);
        }

        /* access modifiers changed from: package-private */
        public void E(int i2) {
            this.f15947j = i2;
            this.u = this.f15946i[i2];
        }

        /* access modifiers changed from: package-private */
        public void F(@NonNull int[] iArr) {
            this.f15946i = iArr;
            E(0);
        }

        /* access modifiers changed from: package-private */
        public void G(float f2) {
            this.f15943f = f2;
        }

        /* access modifiers changed from: package-private */
        public void H(float f2) {
            this.f15944g = f2;
        }

        /* access modifiers changed from: package-private */
        public void I(boolean z) {
            if (this.f15951n != z) {
                this.f15951n = z;
            }
        }

        /* access modifiers changed from: package-private */
        public void J(float f2) {
            this.f15942e = f2;
        }

        /* access modifiers changed from: package-private */
        public void K(Paint.Cap cap) {
            this.f15939b.setStrokeCap(cap);
        }

        /* access modifiers changed from: package-private */
        public void L(float f2) {
            this.f15945h = f2;
            this.f15939b.setStrokeWidth(f2);
        }

        /* access modifiers changed from: package-private */
        public void M() {
            this.f15948k = this.f15942e;
            this.f15949l = this.f15943f;
            this.f15950m = this.f15944g;
        }

        /* access modifiers changed from: package-private */
        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f15938a;
            float f2 = this.q;
            float f3 = (this.f15945h / 2.0f) + f2;
            if (f2 <= 0.0f) {
                f3 = (((float) Math.min(rect.width(), rect.height())) / 2.0f) - Math.max((((float) this.r) * this.p) / 2.0f, this.f15945h / 2.0f);
            }
            rectF.set(((float) rect.centerX()) - f3, ((float) rect.centerY()) - f3, ((float) rect.centerX()) + f3, ((float) rect.centerY()) + f3);
            float f4 = this.f15942e;
            float f5 = this.f15944g;
            float f6 = (f4 + f5) * 360.0f;
            float f7 = ((this.f15943f + f5) * 360.0f) - f6;
            this.f15939b.setColor(this.u);
            this.f15939b.setAlpha(this.t);
            float f8 = this.f15945h / 2.0f;
            rectF.inset(f8, f8);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f15941d);
            float f9 = -f8;
            rectF.inset(f9, f9);
            canvas.drawArc(rectF, f6, f7, false, this.f15939b);
            b(canvas, f6, f7, rectF);
        }

        /* access modifiers changed from: package-private */
        public void b(Canvas canvas, float f2, float f3, RectF rectF) {
            if (this.f15951n) {
                Path path = this.o;
                if (path == null) {
                    Path path2 = new Path();
                    this.o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                this.o.moveTo(0.0f, 0.0f);
                this.o.lineTo(((float) this.r) * this.p, 0.0f);
                Path path3 = this.o;
                float f4 = this.p;
                path3.lineTo((((float) this.r) * f4) / 2.0f, ((float) this.s) * f4);
                this.o.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((((float) this.r) * this.p) / 2.0f), rectF.centerY() + (this.f15945h / 2.0f));
                this.o.close();
                this.f15940c.setColor(this.u);
                this.f15940c.setAlpha(this.t);
                canvas.save();
                canvas.rotate(f2 + f3, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.o, this.f15940c);
                canvas.restore();
            }
        }

        /* access modifiers changed from: package-private */
        public int c() {
            return this.t;
        }

        /* access modifiers changed from: package-private */
        public float d() {
            return (float) this.s;
        }

        /* access modifiers changed from: package-private */
        public float e() {
            return this.p;
        }

        /* access modifiers changed from: package-private */
        public float f() {
            return (float) this.r;
        }

        /* access modifiers changed from: package-private */
        public int g() {
            return this.f15941d.getColor();
        }

        /* access modifiers changed from: package-private */
        public float h() {
            return this.q;
        }

        /* access modifiers changed from: package-private */
        public int[] i() {
            return this.f15946i;
        }

        /* access modifiers changed from: package-private */
        public float j() {
            return this.f15943f;
        }

        /* access modifiers changed from: package-private */
        public int k() {
            return this.f15946i[l()];
        }

        /* access modifiers changed from: package-private */
        public int l() {
            return (this.f15947j + 1) % this.f15946i.length;
        }

        /* access modifiers changed from: package-private */
        public float m() {
            return this.f15944g;
        }

        /* access modifiers changed from: package-private */
        public boolean n() {
            return this.f15951n;
        }

        /* access modifiers changed from: package-private */
        public float o() {
            return this.f15942e;
        }

        /* access modifiers changed from: package-private */
        public int p() {
            return this.f15946i[this.f15947j];
        }

        /* access modifiers changed from: package-private */
        public float q() {
            return this.f15949l;
        }

        /* access modifiers changed from: package-private */
        public float r() {
            return this.f15950m;
        }

        /* access modifiers changed from: package-private */
        public float s() {
            return this.f15948k;
        }

        /* access modifiers changed from: package-private */
        public Paint.Cap t() {
            return this.f15939b.getStrokeCap();
        }

        /* access modifiers changed from: package-private */
        public float u() {
            return this.f15945h;
        }

        /* access modifiers changed from: package-private */
        public void v() {
            E(l());
        }

        /* access modifiers changed from: package-private */
        public void w() {
            this.f15948k = 0.0f;
            this.f15949l = 0.0f;
            this.f15950m = 0.0f;
            J(0.0f);
            G(0.0f);
            H(0.0f);
        }

        /* access modifiers changed from: package-private */
        public void x(int i2) {
            this.t = i2;
        }

        /* access modifiers changed from: package-private */
        public void y(float f2, float f3) {
            this.r = (int) f2;
            this.s = (int) f3;
        }

        /* access modifiers changed from: package-private */
        public void z(float f2) {
            if (f2 != this.p) {
                this.p = f2;
            }
        }
    }

    public CircularProgressDrawable(@NonNull Context context) {
        this.Y = ((Context) Preconditions.l(context)).getResources();
        Ring ring = new Ring();
        this.s = ring;
        ring.F(l3);
        E(2.5f);
        G();
    }

    private void A(float f2) {
        this.X = f2;
    }

    private void B(float f2, float f4, float f5, float f6) {
        Ring ring = this.s;
        float f7 = this.Y.getDisplayMetrics().density;
        ring.L(f4 * f7);
        ring.B(f2 * f7);
        ring.E(0);
        ring.y(f5 * f7, f6 * f7);
    }

    private void G() {
        final Ring ring = this.s;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressDrawable.this.H(floatValue, ring);
                CircularProgressDrawable.this.e(floatValue, ring, false);
                CircularProgressDrawable.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(Z2);
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
                CircularProgressDrawable.this.e(1.0f, ring, true);
                ring.M();
                ring.v();
                CircularProgressDrawable circularProgressDrawable = CircularProgressDrawable.this;
                if (circularProgressDrawable.Y2) {
                    circularProgressDrawable.Y2 = false;
                    animator.cancel();
                    animator.setDuration(1332);
                    animator.start();
                    ring.I(false);
                    return;
                }
                circularProgressDrawable.X2 += 1.0f;
            }

            public void onAnimationStart(Animator animator) {
                CircularProgressDrawable.this.X2 = 0.0f;
            }
        });
        this.Z = ofFloat;
    }

    private void a(float f2, Ring ring) {
        H(f2, ring);
        ring.J(ring.s() + (((ring.q() - r3) - ring.s()) * f2));
        ring.G(ring.q());
        ring.H(ring.r() + ((((float) (Math.floor((double) (ring.r() / q3)) + 1.0d)) - ring.r()) * f2));
    }

    private int f(float f2, int i2, int i4) {
        int i5 = (i2 >> 24) & 255;
        int i6 = (i2 >> 16) & 255;
        int i7 = (i2 >> 8) & 255;
        int i8 = i2 & 255;
        return ((i5 + ((int) (((float) (((i4 >> 24) & 255) - i5)) * f2))) << 24) | ((i6 + ((int) (((float) (((i4 >> 16) & 255) - i6)) * f2))) << 16) | ((i7 + ((int) (((float) (((i4 >> 8) & 255) - i7)) * f2))) << 8) | (i8 + ((int) (f2 * ((float) ((i4 & 255) - i8)))));
    }

    private float p() {
        return this.X;
    }

    public void C(float f2, float f4) {
        this.s.J(f2);
        this.s.G(f4);
        invalidateSelf();
    }

    public void D(@NonNull Paint.Cap cap) {
        this.s.K(cap);
        invalidateSelf();
    }

    public void E(float f2) {
        this.s.L(f2);
        invalidateSelf();
    }

    public void F(int i2) {
        float f2;
        float f4;
        float f5;
        float f6;
        if (i2 == 0) {
            f2 = 12.0f;
            f4 = 6.0f;
            f5 = c3;
            f6 = 3.0f;
        } else {
            f2 = 10.0f;
            f4 = 5.0f;
            f5 = h3;
            f6 = 2.5f;
        }
        B(f5, f6, f2, f4);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void H(float f2, Ring ring) {
        ring.C(f2 > 0.75f ? f((f2 - 0.75f) / 0.25f, ring.p(), ring.k()) : ring.p());
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.X, bounds.exactCenterX(), bounds.exactCenterY());
        this.s.a(canvas, bounds);
        canvas.restore();
    }

    /* access modifiers changed from: package-private */
    public void e(float f2, Ring ring, boolean z) {
        float f4;
        float f5;
        if (this.Y2) {
            a(f2, ring);
        } else if (f2 != 1.0f || z) {
            float r = ring.r();
            if (f2 < 0.5f) {
                f4 = ring.s();
                f5 = (a3.getInterpolation(f2 / 0.5f) * 0.79f) + r3 + f4;
            } else {
                float s2 = ring.s() + 0.79f;
                float f6 = s2;
                f4 = s2 - (((1.0f - a3.getInterpolation((f2 - 0.5f) / 0.5f)) * 0.79f) + r3);
                f5 = f6;
            }
            float f7 = r + (s3 * f2);
            float f8 = (f2 + this.X2) * p3;
            ring.J(f4);
            ring.G(f5);
            ring.H(f7);
            A(f8);
        }
    }

    public boolean g() {
        return this.s.n();
    }

    public int getAlpha() {
        return this.s.c();
    }

    public int getOpacity() {
        return -3;
    }

    public float h() {
        return this.s.d();
    }

    public float i() {
        return this.s.e();
    }

    public boolean isRunning() {
        return this.Z.isRunning();
    }

    public float j() {
        return this.s.f();
    }

    public int k() {
        return this.s.g();
    }

    public float l() {
        return this.s.h();
    }

    @NonNull
    public int[] m() {
        return this.s.i();
    }

    public float n() {
        return this.s.j();
    }

    public float o() {
        return this.s.m();
    }

    public float q() {
        return this.s.o();
    }

    @NonNull
    public Paint.Cap r() {
        return this.s.t();
    }

    public float s() {
        return this.s.u();
    }

    public void setAlpha(int i2) {
        this.s.x(i2);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.s.D(colorFilter);
        invalidateSelf();
    }

    public void start() {
        Animator animator;
        long j2;
        this.Z.cancel();
        this.s.M();
        if (this.s.j() != this.s.o()) {
            this.Y2 = true;
            animator = this.Z;
            j2 = 666;
        } else {
            this.s.E(0);
            this.s.w();
            animator = this.Z;
            j2 = 1332;
        }
        animator.setDuration(j2);
        this.Z.start();
    }

    public void stop() {
        this.Z.cancel();
        A(0.0f);
        this.s.I(false);
        this.s.E(0);
        this.s.w();
        invalidateSelf();
    }

    public void t(float f2, float f4) {
        this.s.y(f2, f4);
        invalidateSelf();
    }

    public void u(boolean z) {
        this.s.I(z);
        invalidateSelf();
    }

    public void v(float f2) {
        this.s.z(f2);
        invalidateSelf();
    }

    public void w(int i2) {
        this.s.A(i2);
        invalidateSelf();
    }

    public void x(float f2) {
        this.s.B(f2);
        invalidateSelf();
    }

    public void y(@NonNull int... iArr) {
        this.s.F(iArr);
        this.s.E(0);
        invalidateSelf();
    }

    public void z(float f2) {
        this.s.H(f2);
        invalidateSelf();
    }
}
