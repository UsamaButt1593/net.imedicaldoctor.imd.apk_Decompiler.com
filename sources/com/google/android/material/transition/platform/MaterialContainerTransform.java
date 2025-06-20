package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.ArcMotion;
import android.transition.PathMotion;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RequiresApi(21)
public final class MaterialContainerTransform extends Transition {
    public static final int A3 = 1;
    public static final int B3 = 2;
    private static final String C3 = "MaterialContainerTransform";
    private static final String D3 = "materialContainerTransition:bounds";
    private static final String E3 = "materialContainerTransition:shapeAppearance";
    private static final String[] F3 = {D3, E3};
    private static final ProgressThresholdsGroup G3 = new ProgressThresholdsGroup(new ProgressThresholds(0.0f, 0.25f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.75f));
    private static final ProgressThresholdsGroup H3 = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.3f, 0.9f));
    private static final ProgressThresholdsGroup I3 = new ProgressThresholdsGroup(new ProgressThresholds(0.1f, 0.4f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 0.9f));
    private static final ProgressThresholdsGroup J3 = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.2f, 0.9f));
    private static final float K3 = -1.0f;
    public static final int s3 = 0;
    public static final int t3 = 1;
    public static final int u3 = 2;
    public static final int v3 = 0;
    public static final int w3 = 1;
    public static final int x3 = 2;
    public static final int y3 = 3;
    public static final int z3 = 0;
    /* access modifiers changed from: private */
    public boolean X = false;
    @IdRes
    private int X2 = 16908290;
    private boolean Y = false;
    @IdRes
    private int Y2 = -1;
    private boolean Z = false;
    @IdRes
    private int Z2 = -1;
    @ColorInt
    private int a3 = 0;
    @ColorInt
    private int b3 = 0;
    @ColorInt
    private int c3 = 0;
    @ColorInt
    private int d3 = 1375731712;
    private int e3 = 0;
    private int f3 = 0;
    private int g3 = 0;
    @Nullable
    private View h3;
    @Nullable
    private View i3;
    @Nullable
    private ShapeAppearanceModel j3;
    @Nullable
    private ShapeAppearanceModel k3;
    @Nullable
    private ProgressThresholds l3;
    @Nullable
    private ProgressThresholds m3;
    @Nullable
    private ProgressThresholds n3;
    @Nullable
    private ProgressThresholds o3;
    private boolean p3;
    private float q3;
    private float r3;
    private boolean s = false;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FadeMode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FitMode {
    }

    public static class ProgressThresholds {
        /* access modifiers changed from: private */
        @FloatRange(from = 0.0d, to = 1.0d)

        /* renamed from: a  reason: collision with root package name */
        public final float f22184a;
        /* access modifiers changed from: private */
        @FloatRange(from = 0.0d, to = 1.0d)

        /* renamed from: b  reason: collision with root package name */
        public final float f22185b;

        public ProgressThresholds(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
            this.f22184a = f2;
            this.f22185b = f3;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float c() {
            return this.f22185b;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float d() {
            return this.f22184a;
        }
    }

    private static class ProgressThresholdsGroup {
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final ProgressThresholds f22186a;
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final ProgressThresholds f22187b;
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public final ProgressThresholds f22188c;
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        public final ProgressThresholds f22189d;

        private ProgressThresholdsGroup(@NonNull ProgressThresholds progressThresholds, @NonNull ProgressThresholds progressThresholds2, @NonNull ProgressThresholds progressThresholds3, @NonNull ProgressThresholds progressThresholds4) {
            this.f22186a = progressThresholds;
            this.f22187b = progressThresholds2;
            this.f22188c = progressThresholds3;
            this.f22189d = progressThresholds4;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TransitionDirection {
    }

    private static final class TransitionDrawable extends Drawable {
        private static final int M = 754974720;
        private static final int N = -7829368;
        private static final float O = 0.3f;
        private static final float P = 1.5f;
        private final ProgressThresholdsGroup A;
        private final FadeModeEvaluator B;
        private final FitModeEvaluator C;
        private final boolean D;
        private final Paint E;
        private final Path F;
        private FadeModeResult G;
        private FitModeResult H;
        private RectF I;
        private float J;
        private float K;
        private float L;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final View f22190a;

        /* renamed from: b  reason: collision with root package name */
        private final RectF f22191b;

        /* renamed from: c  reason: collision with root package name */
        private final ShapeAppearanceModel f22192c;

        /* renamed from: d  reason: collision with root package name */
        private final float f22193d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final View f22194e;

        /* renamed from: f  reason: collision with root package name */
        private final RectF f22195f;

        /* renamed from: g  reason: collision with root package name */
        private final ShapeAppearanceModel f22196g;

        /* renamed from: h  reason: collision with root package name */
        private final float f22197h;

        /* renamed from: i  reason: collision with root package name */
        private final Paint f22198i;

        /* renamed from: j  reason: collision with root package name */
        private final Paint f22199j;

        /* renamed from: k  reason: collision with root package name */
        private final Paint f22200k;

        /* renamed from: l  reason: collision with root package name */
        private final Paint f22201l;

        /* renamed from: m  reason: collision with root package name */
        private final Paint f22202m;

        /* renamed from: n  reason: collision with root package name */
        private final MaskEvaluator f22203n;
        private final PathMeasure o;
        private final float p;
        private final float[] q;
        private final boolean r;
        private final float s;
        private final float t;
        private final boolean u;
        private final MaterialShapeDrawable v;
        private final RectF w;
        private final RectF x;
        private final RectF y;
        private final RectF z;

        private TransitionDrawable(PathMotion pathMotion, View view, RectF rectF, ShapeAppearanceModel shapeAppearanceModel, float f2, View view2, RectF rectF2, ShapeAppearanceModel shapeAppearanceModel2, float f3, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4, int i5, boolean z2, boolean z3, FadeModeEvaluator fadeModeEvaluator, FitModeEvaluator fitModeEvaluator, ProgressThresholdsGroup progressThresholdsGroup, boolean z4) {
            RectF rectF3 = rectF;
            Paint paint = new Paint();
            this.f22198i = paint;
            Paint paint2 = new Paint();
            this.f22199j = paint2;
            Paint paint3 = new Paint();
            this.f22200k = paint3;
            this.f22201l = new Paint();
            Paint paint4 = new Paint();
            this.f22202m = paint4;
            this.f22203n = new MaskEvaluator();
            float[] fArr = new float[2];
            this.q = fArr;
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            this.v = materialShapeDrawable;
            Paint paint5 = new Paint();
            this.E = paint5;
            this.F = new Path();
            this.f22190a = view;
            this.f22191b = rectF3;
            this.f22192c = shapeAppearanceModel;
            this.f22193d = f2;
            this.f22194e = view2;
            this.f22195f = rectF2;
            this.f22196g = shapeAppearanceModel2;
            this.f22197h = f3;
            this.r = z2;
            this.u = z3;
            this.B = fadeModeEvaluator;
            this.C = fitModeEvaluator;
            this.A = progressThresholdsGroup;
            this.D = z4;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            this.s = (float) displayMetrics.widthPixels;
            this.t = (float) displayMetrics.heightPixels;
            paint.setColor(i2);
            paint2.setColor(i3);
            paint3.setColor(i4);
            materialShapeDrawable.p0(ColorStateList.valueOf(0));
            materialShapeDrawable.y0(2);
            materialShapeDrawable.v0(false);
            materialShapeDrawable.w0(N);
            RectF rectF4 = new RectF(rectF3);
            this.w = rectF4;
            this.x = new RectF(rectF4);
            RectF rectF5 = new RectF(rectF4);
            this.y = rectF5;
            this.z = new RectF(rectF5);
            PointF m2 = m(rectF);
            PointF m3 = m(rectF2);
            PathMotion pathMotion2 = pathMotion;
            PathMeasure pathMeasure = new PathMeasure(pathMotion.getPath(m2.x, m2.y, m3.x, m3.y), false);
            this.o = pathMeasure;
            this.p = pathMeasure.getLength();
            fArr[0] = rectF.centerX();
            fArr[1] = rectF3.top;
            paint4.setStyle(Paint.Style.FILL);
            paint4.setShader(TransitionUtils.d(i5));
            paint5.setStyle(Paint.Style.STROKE);
            paint5.setStrokeWidth(10.0f);
            p(0.0f);
        }

        private static float d(RectF rectF, float f2) {
            return ((rectF.centerX() / (f2 / 2.0f)) - 1.0f) * O;
        }

        private static float e(RectF rectF, float f2) {
            return (rectF.centerY() / f2) * P;
        }

        private void f(Canvas canvas, RectF rectF, Path path, @ColorInt int i2) {
            PointF m2 = m(rectF);
            if (this.L == 0.0f) {
                path.reset();
                path.moveTo(m2.x, m2.y);
                return;
            }
            path.lineTo(m2.x, m2.y);
            this.E.setColor(i2);
            canvas.drawPath(path, this.E);
        }

        private void g(Canvas canvas, RectF rectF, @ColorInt int i2) {
            this.E.setColor(i2);
            canvas.drawRect(rectF, this.E);
        }

        private void h(Canvas canvas) {
            canvas.save();
            canvas.clipPath(this.f22203n.d(), Region.Op.DIFFERENCE);
            if (Build.VERSION.SDK_INT > 28) {
                j(canvas);
            } else {
                i(canvas);
            }
            canvas.restore();
        }

        private void i(Canvas canvas) {
            MaterialShapeDrawable materialShapeDrawable = this.v;
            RectF rectF = this.I;
            materialShapeDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            this.v.o0(this.J);
            this.v.C0((int) this.K);
            this.v.setShapeAppearanceModel(this.f22203n.c());
            this.v.draw(canvas);
        }

        private void j(Canvas canvas) {
            ShapeAppearanceModel c2 = this.f22203n.c();
            if (c2.u(this.I)) {
                float a2 = c2.r().a(this.I);
                canvas.drawRoundRect(this.I, a2, a2, this.f22201l);
                return;
            }
            canvas.drawPath(this.f22203n.d(), this.f22201l);
        }

        private void k(Canvas canvas) {
            n(canvas, this.f22200k);
            Rect bounds = getBounds();
            RectF rectF = this.y;
            TransitionUtils.y(canvas, bounds, rectF.left, rectF.top, this.H.f22169b, this.G.f22161b, new CanvasCompat.CanvasOperation() {
                public void a(Canvas canvas) {
                    TransitionDrawable.this.f22194e.draw(canvas);
                }
            });
        }

        private void l(Canvas canvas) {
            n(canvas, this.f22199j);
            Rect bounds = getBounds();
            RectF rectF = this.w;
            TransitionUtils.y(canvas, bounds, rectF.left, rectF.top, this.H.f22168a, this.G.f22160a, new CanvasCompat.CanvasOperation() {
                public void a(Canvas canvas) {
                    TransitionDrawable.this.f22190a.draw(canvas);
                }
            });
        }

        private static PointF m(RectF rectF) {
            return new PointF(rectF.centerX(), rectF.top);
        }

        private void n(Canvas canvas, Paint paint) {
            if (paint.getColor() != 0 && paint.getAlpha() > 0) {
                canvas.drawRect(getBounds(), paint);
            }
        }

        /* access modifiers changed from: private */
        public void o(float f2) {
            if (this.L != f2) {
                p(f2);
            }
        }

        private void p(float f2) {
            float f3;
            float f4;
            this.L = f2;
            this.f22202m.setAlpha((int) (this.r ? TransitionUtils.m(0.0f, 255.0f, f2) : TransitionUtils.m(255.0f, 0.0f, f2)));
            this.o.getPosTan(this.p * f2, this.q, (float[]) null);
            float[] fArr = this.q;
            float f5 = fArr[0];
            float f6 = fArr[1];
            int i2 = (f2 > 1.0f ? 1 : (f2 == 1.0f ? 0 : -1));
            if (i2 > 0 || f2 < 0.0f) {
                if (i2 > 0) {
                    f4 = (f2 - 1.0f) / 0.00999999f;
                    f3 = 0.99f;
                } else {
                    f3 = 0.01f;
                    f4 = (f2 / 0.01f) * MaterialContainerTransform.K3;
                }
                this.o.getPosTan(this.p * f3, fArr, (float[]) null);
                float[] fArr2 = this.q;
                f5 += (f5 - fArr2[0]) * f4;
                f6 += (f6 - fArr2[1]) * f4;
            }
            float f7 = f5;
            float f8 = f6;
            FitModeResult a2 = this.C.a(f2, ((Float) Preconditions.l(Float.valueOf(this.A.f22187b.f22184a))).floatValue(), ((Float) Preconditions.l(Float.valueOf(this.A.f22187b.f22185b))).floatValue(), this.f22191b.width(), this.f22191b.height(), this.f22195f.width(), this.f22195f.height());
            this.H = a2;
            RectF rectF = this.w;
            float f9 = a2.f22170c;
            rectF.set(f7 - (f9 / 2.0f), f8, (f9 / 2.0f) + f7, a2.f22171d + f8);
            RectF rectF2 = this.y;
            FitModeResult fitModeResult = this.H;
            float f10 = fitModeResult.f22172e;
            rectF2.set(f7 - (f10 / 2.0f), f8, f7 + (f10 / 2.0f), fitModeResult.f22173f + f8);
            this.x.set(this.w);
            this.z.set(this.y);
            float floatValue = ((Float) Preconditions.l(Float.valueOf(this.A.f22188c.f22184a))).floatValue();
            float floatValue2 = ((Float) Preconditions.l(Float.valueOf(this.A.f22188c.f22185b))).floatValue();
            boolean b2 = this.C.b(this.H);
            RectF rectF3 = b2 ? this.x : this.z;
            float n2 = TransitionUtils.n(0.0f, 1.0f, floatValue, floatValue2, f2);
            if (!b2) {
                n2 = 1.0f - n2;
            }
            this.C.c(rectF3, n2, this.H);
            this.I = new RectF(Math.min(this.x.left, this.z.left), Math.min(this.x.top, this.z.top), Math.max(this.x.right, this.z.right), Math.max(this.x.bottom, this.z.bottom));
            this.f22203n.b(f2, this.f22192c, this.f22196g, this.w, this.x, this.z, this.A.f22189d);
            this.J = TransitionUtils.m(this.f22193d, this.f22197h, f2);
            float d2 = d(this.I, this.s);
            float e2 = e(this.I, this.t);
            float f11 = this.J;
            float f12 = (float) ((int) (e2 * f11));
            this.K = f12;
            this.f22201l.setShadowLayer(f11, (float) ((int) (d2 * f11)), f12, M);
            this.G = this.B.a(f2, ((Float) Preconditions.l(Float.valueOf(this.A.f22186a.f22184a))).floatValue(), ((Float) Preconditions.l(Float.valueOf(this.A.f22186a.f22185b))).floatValue(), 0.35f);
            if (this.f22199j.getColor() != 0) {
                this.f22199j.setAlpha(this.G.f22160a);
            }
            if (this.f22200k.getColor() != 0) {
                this.f22200k.setAlpha(this.G.f22161b);
            }
            invalidateSelf();
        }

        public void draw(@NonNull Canvas canvas) {
            if (this.f22202m.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.f22202m);
            }
            int save = this.D ? canvas.save() : -1;
            if (this.u && this.J > 0.0f) {
                h(canvas);
            }
            this.f22203n.a(canvas);
            n(canvas, this.f22198i);
            if (this.G.f22162c) {
                l(canvas);
                k(canvas);
            } else {
                k(canvas);
                l(canvas);
            }
            if (this.D) {
                canvas.restoreToCount(save);
                f(canvas, this.w, this.F, -65281);
                g(canvas, this.x, InputDeviceCompat.u);
                g(canvas, this.w, -16711936);
                g(canvas, this.z, -16711681);
                g(canvas, this.y, -16776961);
            }
        }

        public int getOpacity() {
            return -3;
        }

        public void setAlpha(int i2) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }
    }

    public MaterialContainerTransform() {
        boolean z = false;
        this.p3 = Build.VERSION.SDK_INT >= 28 ? true : z;
        this.q3 = K3;
        this.r3 = K3;
    }

    private ProgressThresholdsGroup D(boolean z, ProgressThresholdsGroup progressThresholdsGroup, ProgressThresholdsGroup progressThresholdsGroup2) {
        if (!z) {
            progressThresholdsGroup = progressThresholdsGroup2;
        }
        return new ProgressThresholdsGroup((ProgressThresholds) TransitionUtils.e(this.l3, progressThresholdsGroup.f22186a), (ProgressThresholds) TransitionUtils.e(this.m3, progressThresholdsGroup.f22187b), (ProgressThresholds) TransitionUtils.e(this.n3, progressThresholdsGroup.f22188c), (ProgressThresholds) TransitionUtils.e(this.o3, progressThresholdsGroup.f22189d));
    }

    @StyleRes
    private static int F(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.Jk});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private boolean K(@NonNull RectF rectF, @NonNull RectF rectF2) {
        int i2 = this.e3;
        if (i2 == 0) {
            return TransitionUtils.b(rectF2) > TransitionUtils.b(rectF);
        }
        if (i2 == 1) {
            return true;
        }
        if (i2 == 2) {
            return false;
        }
        throw new IllegalArgumentException("Invalid transition direction: " + this.e3);
    }

    private void M(Context context, boolean z) {
        TransitionUtils.t(this, context, R.attr.Vd, AnimationUtils.f20767b);
        TransitionUtils.s(this, context, z ? R.attr.Fd : R.attr.Ld);
        if (!this.Y) {
            TransitionUtils.u(this, context, R.attr.f20603de);
        }
    }

    private ProgressThresholdsGroup b(boolean z) {
        ProgressThresholdsGroup progressThresholdsGroup;
        ProgressThresholdsGroup progressThresholdsGroup2;
        PathMotion pathMotion = getPathMotion();
        if ((pathMotion instanceof ArcMotion) || (pathMotion instanceof MaterialArcMotion)) {
            progressThresholdsGroup = I3;
            progressThresholdsGroup2 = J3;
        } else {
            progressThresholdsGroup = G3;
            progressThresholdsGroup2 = H3;
        }
        return D(z, progressThresholdsGroup, progressThresholdsGroup2);
    }

    private static RectF c(View view, @Nullable View view2, float f2, float f4) {
        if (view2 == null) {
            return new RectF(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        }
        RectF h2 = TransitionUtils.h(view2);
        h2.offset(f2, f4);
        return h2;
    }

    private static ShapeAppearanceModel d(@NonNull View view, @NonNull RectF rectF, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        return TransitionUtils.c(v(view, shapeAppearanceModel), rectF);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void e(@androidx.annotation.NonNull android.transition.TransitionValues r2, @androidx.annotation.Nullable android.view.View r3, @androidx.annotation.IdRes int r4, @androidx.annotation.Nullable com.google.android.material.shape.ShapeAppearanceModel r5) {
        /*
            r0 = -1
            if (r4 == r0) goto L_0x000c
            android.view.View r3 = r2.view
            android.view.View r3 = com.google.android.material.transition.platform.TransitionUtils.g(r3, r4)
        L_0x0009:
            r2.view = r3
            goto L_0x002a
        L_0x000c:
            if (r3 == 0) goto L_0x000f
            goto L_0x0009
        L_0x000f:
            android.view.View r3 = r2.view
            int r4 = com.google.android.material.R.id.s3
            java.lang.Object r3 = r3.getTag(r4)
            boolean r3 = r3 instanceof android.view.View
            if (r3 == 0) goto L_0x002a
            android.view.View r3 = r2.view
            java.lang.Object r3 = r3.getTag(r4)
            android.view.View r3 = (android.view.View) r3
            android.view.View r0 = r2.view
            r1 = 0
            r0.setTag(r4, r1)
            goto L_0x0009
        L_0x002a:
            android.view.View r3 = r2.view
            boolean r4 = androidx.core.view.ViewCompat.Y0(r3)
            if (r4 != 0) goto L_0x003e
            int r4 = r3.getWidth()
            if (r4 != 0) goto L_0x003e
            int r4 = r3.getHeight()
            if (r4 == 0) goto L_0x005f
        L_0x003e:
            android.view.ViewParent r4 = r3.getParent()
            if (r4 != 0) goto L_0x0049
            android.graphics.RectF r4 = com.google.android.material.transition.platform.TransitionUtils.i(r3)
            goto L_0x004d
        L_0x0049:
            android.graphics.RectF r4 = com.google.android.material.transition.platform.TransitionUtils.h(r3)
        L_0x004d:
            java.util.Map r0 = r2.values
            java.lang.String r1 = "materialContainerTransition:bounds"
            r0.put(r1, r4)
            java.util.Map r2 = r2.values
            java.lang.String r0 = "materialContainerTransition:shapeAppearance"
            com.google.android.material.shape.ShapeAppearanceModel r3 = d(r3, r4, r5)
            r2.put(r0, r3)
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transition.platform.MaterialContainerTransform.e(android.transition.TransitionValues, android.view.View, int, com.google.android.material.shape.ShapeAppearanceModel):void");
    }

    private static float h(float f2, View view) {
        return f2 != K3 ? f2 : ViewCompat.T(view);
    }

    private static ShapeAppearanceModel v(@NonNull View view, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        if (shapeAppearanceModel != null) {
            return shapeAppearanceModel;
        }
        int i2 = R.id.s3;
        if (view.getTag(i2) instanceof ShapeAppearanceModel) {
            return (ShapeAppearanceModel) view.getTag(i2);
        }
        Context context = view.getContext();
        int F = F(context);
        if (F != -1) {
            return ShapeAppearanceModel.b(context, F, 0).m();
        }
        return view instanceof Shapeable ? ((Shapeable) view).getShapeAppearanceModel() : ShapeAppearanceModel.a().m();
    }

    @Nullable
    public View A() {
        return this.h3;
    }

    @IdRes
    public int B() {
        return this.Y2;
    }

    public int E() {
        return this.e3;
    }

    public boolean G() {
        return this.s;
    }

    public boolean J() {
        return this.p3;
    }

    public boolean L() {
        return this.X;
    }

    public void Q(@ColorInt int i2) {
        this.a3 = i2;
        this.b3 = i2;
        this.c3 = i2;
    }

    public void S(@ColorInt int i2) {
        this.a3 = i2;
    }

    public void U(boolean z) {
        this.s = z;
    }

    public void V(@IdRes int i2) {
        this.X2 = i2;
    }

    public void X(boolean z) {
        this.p3 = z;
    }

    public void Y(@ColorInt int i2) {
        this.c3 = i2;
    }

    public void b0(float f2) {
        this.r3 = f2;
    }

    public void c0(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.k3 = shapeAppearanceModel;
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        e(transitionValues, this.i3, this.Z2, this.k3);
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        e(transitionValues, this.h3, this.Y2, this.j3);
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        String str;
        String str2;
        final View view;
        View view2;
        TransitionValues transitionValues3 = transitionValues;
        TransitionValues transitionValues4 = transitionValues2;
        if (transitionValues3 == null || transitionValues4 == null) {
            return null;
        }
        RectF rectF = (RectF) transitionValues3.values.get(D3);
        ShapeAppearanceModel shapeAppearanceModel = (ShapeAppearanceModel) transitionValues3.values.get(E3);
        if (rectF == null || shapeAppearanceModel == null) {
            str = C3;
            str2 = "Skipping due to null start bounds. Ensure start view is laid out and measured.";
        } else {
            RectF rectF2 = (RectF) transitionValues4.values.get(D3);
            ShapeAppearanceModel shapeAppearanceModel2 = (ShapeAppearanceModel) transitionValues4.values.get(E3);
            if (rectF2 == null || shapeAppearanceModel2 == null) {
                str = C3;
                str2 = "Skipping due to null end bounds. Ensure end view is laid out and measured.";
            } else {
                final View view3 = transitionValues3.view;
                final View view4 = transitionValues4.view;
                View view5 = view4.getParent() != null ? view4 : view3;
                if (this.X2 == view5.getId()) {
                    view = (View) view5.getParent();
                    view2 = view5;
                } else {
                    view = TransitionUtils.f(view5, this.X2);
                    view2 = null;
                }
                RectF h2 = TransitionUtils.h(view);
                float f2 = -h2.left;
                float f4 = -h2.top;
                RectF c2 = c(view, view2, f2, f4);
                rectF.offset(f2, f4);
                rectF2.offset(f2, f4);
                boolean K = K(rectF, rectF2);
                if (!this.Z) {
                    M(view5.getContext(), K);
                }
                final TransitionDrawable transitionDrawable = new TransitionDrawable(getPathMotion(), view3, rectF, shapeAppearanceModel, h(this.q3, view3), view4, rectF2, shapeAppearanceModel2, h(this.r3, view4), this.a3, this.b3, this.c3, this.d3, K, this.p3, FadeModeEvaluators.a(this.f3, K), FitModeEvaluators.a(this.g3, K, rectF, rectF2), b(K), this.s);
                transitionDrawable.setBounds(Math.round(c2.left), Math.round(c2.top), Math.round(c2.right), Math.round(c2.bottom));
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        transitionDrawable.o(valueAnimator.getAnimatedFraction());
                    }
                });
                final TransitionDrawable transitionDrawable2 = transitionDrawable;
                addListener(new TransitionListenerAdapter() {
                    public void onTransitionEnd(@NonNull Transition transition) {
                        MaterialContainerTransform.this.removeListener(this);
                        if (!MaterialContainerTransform.this.X) {
                            view3.setAlpha(1.0f);
                            view4.setAlpha(1.0f);
                            ViewUtils.o(view).b(transitionDrawable2);
                        }
                    }

                    public void onTransitionStart(@NonNull Transition transition) {
                        ViewUtils.o(view).a(transitionDrawable2);
                        view3.setAlpha(0.0f);
                        view4.setAlpha(0.0f);
                    }
                });
                return ofFloat;
            }
        }
        Log.w(str, str2);
        return null;
    }

    @ColorInt
    public int f() {
        return this.a3;
    }

    public void f0(@Nullable View view) {
        this.i3 = view;
    }

    @IdRes
    public int g() {
        return this.X2;
    }

    public void g0(@IdRes int i2) {
        this.Z2 = i2;
    }

    @Nullable
    public String[] getTransitionProperties() {
        return F3;
    }

    public void h0(int i2) {
        this.f3 = i2;
    }

    @ColorInt
    public int i() {
        return this.c3;
    }

    public void k0(@Nullable ProgressThresholds progressThresholds) {
        this.l3 = progressThresholds;
    }

    public float l() {
        return this.r3;
    }

    public void l0(int i2) {
        this.g3 = i2;
    }

    @Nullable
    public ShapeAppearanceModel m() {
        return this.k3;
    }

    @Nullable
    public View n() {
        return this.i3;
    }

    public void n0(boolean z) {
        this.X = z;
    }

    @IdRes
    public int o() {
        return this.Z2;
    }

    public void o0(@Nullable ProgressThresholds progressThresholds) {
        this.n3 = progressThresholds;
    }

    public int p() {
        return this.f3;
    }

    @Nullable
    public ProgressThresholds q() {
        return this.l3;
    }

    public void q0(@Nullable ProgressThresholds progressThresholds) {
        this.m3 = progressThresholds;
    }

    public int r() {
        return this.g3;
    }

    public void r0(@ColorInt int i2) {
        this.d3 = i2;
    }

    @Nullable
    public ProgressThresholds s() {
        return this.n3;
    }

    public void s0(@Nullable ProgressThresholds progressThresholds) {
        this.o3 = progressThresholds;
    }

    public void setPathMotion(@Nullable PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.Y = true;
    }

    @Nullable
    public ProgressThresholds t() {
        return this.m3;
    }

    public void t0(@ColorInt int i2) {
        this.b3 = i2;
    }

    @ColorInt
    public int u() {
        return this.d3;
    }

    public void u0(float f2) {
        this.q3 = f2;
    }

    public void v0(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.j3 = shapeAppearanceModel;
    }

    @Nullable
    public ProgressThresholds w() {
        return this.o3;
    }

    public void w0(@Nullable View view) {
        this.h3 = view;
    }

    @ColorInt
    public int x() {
        return this.b3;
    }

    public float y() {
        return this.q3;
    }

    public void y0(@IdRes int i2) {
        this.Y2 = i2;
    }

    @Nullable
    public ShapeAppearanceModel z() {
        return this.j3;
    }

    public void z0(int i2) {
        this.e3 = i2;
    }

    public MaterialContainerTransform(@NonNull Context context, boolean z) {
        boolean z2 = false;
        this.p3 = Build.VERSION.SDK_INT >= 28 ? true : z2;
        this.q3 = K3;
        this.r3 = K3;
        M(context, z);
        this.Z = true;
    }
}
