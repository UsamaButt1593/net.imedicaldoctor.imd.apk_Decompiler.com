package com.google.android.material.transition;

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
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.transition.ArcMotion;
import androidx.transition.PathMotion;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class MaterialContainerTransform extends Transition {
    public static final int A4 = 3;
    public static final int B4 = 0;
    public static final int C4 = 1;
    public static final int D4 = 2;
    private static final String E4 = "MaterialContainerTransform";
    private static final String F4 = "materialContainerTransition:bounds";
    private static final String G4 = "materialContainerTransition:shapeAppearance";
    private static final String[] H4 = {F4, G4};
    private static final ProgressThresholdsGroup I4 = new ProgressThresholdsGroup(new ProgressThresholds(0.0f, 0.25f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.75f));
    private static final ProgressThresholdsGroup J4 = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.3f, 0.9f));
    private static final ProgressThresholdsGroup K4 = new ProgressThresholdsGroup(new ProgressThresholds(0.1f, 0.4f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 0.9f));
    private static final ProgressThresholdsGroup L4 = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.2f, 0.9f));
    private static final float M4 = -1.0f;
    public static final int u4 = 0;
    public static final int v4 = 1;
    public static final int w4 = 2;
    public static final int x4 = 0;
    public static final int y4 = 1;
    public static final int z4 = 2;
    private boolean V3 = false;
    /* access modifiers changed from: private */
    public boolean W3 = false;
    private boolean X3 = false;
    private boolean Y3 = false;
    @IdRes
    private int Z3 = 16908290;
    @IdRes
    private int a4 = -1;
    @IdRes
    private int b4 = -1;
    @ColorInt
    private int c4 = 0;
    @ColorInt
    private int d4 = 0;
    @ColorInt
    private int e4 = 0;
    @ColorInt
    private int f4 = 1375731712;
    private int g4 = 0;
    private int h4 = 0;
    private int i4 = 0;
    @Nullable
    private View j4;
    @Nullable
    private View k4;
    @Nullable
    private ShapeAppearanceModel l4;
    @Nullable
    private ShapeAppearanceModel m4;
    @Nullable
    private ProgressThresholds n4;
    @Nullable
    private ProgressThresholds o4;
    @Nullable
    private ProgressThresholds p4;
    @Nullable
    private ProgressThresholds q4;
    private boolean r4;
    private float s4;
    private float t4;

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
        public final float f22114a;
        /* access modifiers changed from: private */
        @FloatRange(from = 0.0d, to = 1.0d)

        /* renamed from: b  reason: collision with root package name */
        public final float f22115b;

        public ProgressThresholds(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
            this.f22114a = f2;
            this.f22115b = f3;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float c() {
            return this.f22115b;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float d() {
            return this.f22114a;
        }
    }

    private static class ProgressThresholdsGroup {
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final ProgressThresholds f22116a;
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final ProgressThresholds f22117b;
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public final ProgressThresholds f22118c;
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        public final ProgressThresholds f22119d;

        private ProgressThresholdsGroup(@NonNull ProgressThresholds progressThresholds, @NonNull ProgressThresholds progressThresholds2, @NonNull ProgressThresholds progressThresholds3, @NonNull ProgressThresholds progressThresholds4) {
            this.f22116a = progressThresholds;
            this.f22117b = progressThresholds2;
            this.f22118c = progressThresholds3;
            this.f22119d = progressThresholds4;
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
        public final View f22120a;

        /* renamed from: b  reason: collision with root package name */
        private final RectF f22121b;

        /* renamed from: c  reason: collision with root package name */
        private final ShapeAppearanceModel f22122c;

        /* renamed from: d  reason: collision with root package name */
        private final float f22123d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final View f22124e;

        /* renamed from: f  reason: collision with root package name */
        private final RectF f22125f;

        /* renamed from: g  reason: collision with root package name */
        private final ShapeAppearanceModel f22126g;

        /* renamed from: h  reason: collision with root package name */
        private final float f22127h;

        /* renamed from: i  reason: collision with root package name */
        private final Paint f22128i;

        /* renamed from: j  reason: collision with root package name */
        private final Paint f22129j;

        /* renamed from: k  reason: collision with root package name */
        private final Paint f22130k;

        /* renamed from: l  reason: collision with root package name */
        private final Paint f22131l;

        /* renamed from: m  reason: collision with root package name */
        private final Paint f22132m;

        /* renamed from: n  reason: collision with root package name */
        private final MaskEvaluator f22133n;
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
            this.f22128i = paint;
            Paint paint2 = new Paint();
            this.f22129j = paint2;
            Paint paint3 = new Paint();
            this.f22130k = paint3;
            this.f22131l = new Paint();
            Paint paint4 = new Paint();
            this.f22132m = paint4;
            this.f22133n = new MaskEvaluator();
            float[] fArr = new float[2];
            this.q = fArr;
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            this.v = materialShapeDrawable;
            Paint paint5 = new Paint();
            this.E = paint5;
            this.F = new Path();
            this.f22120a = view;
            this.f22121b = rectF3;
            this.f22122c = shapeAppearanceModel;
            this.f22123d = f2;
            this.f22124e = view2;
            this.f22125f = rectF2;
            this.f22126g = shapeAppearanceModel2;
            this.f22127h = f3;
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
            PathMeasure pathMeasure = new PathMeasure(pathMotion.a(m2.x, m2.y, m3.x, m3.y), false);
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
            canvas.clipPath(this.f22133n.d(), Region.Op.DIFFERENCE);
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
            this.v.setShapeAppearanceModel(this.f22133n.c());
            this.v.draw(canvas);
        }

        private void j(Canvas canvas) {
            ShapeAppearanceModel c2 = this.f22133n.c();
            if (c2.u(this.I)) {
                float a2 = c2.r().a(this.I);
                canvas.drawRoundRect(this.I, a2, a2, this.f22131l);
                return;
            }
            canvas.drawPath(this.f22133n.d(), this.f22131l);
        }

        private void k(Canvas canvas) {
            n(canvas, this.f22130k);
            Rect bounds = getBounds();
            RectF rectF = this.y;
            TransitionUtils.y(canvas, bounds, rectF.left, rectF.top, this.H.f22104b, this.G.f22096b, new CanvasCompat.CanvasOperation() {
                public void a(Canvas canvas) {
                    TransitionDrawable.this.f22124e.draw(canvas);
                }
            });
        }

        private void l(Canvas canvas) {
            n(canvas, this.f22129j);
            Rect bounds = getBounds();
            RectF rectF = this.w;
            TransitionUtils.y(canvas, bounds, rectF.left, rectF.top, this.H.f22103a, this.G.f22095a, new CanvasCompat.CanvasOperation() {
                public void a(Canvas canvas) {
                    TransitionDrawable.this.f22120a.draw(canvas);
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
            this.f22132m.setAlpha((int) (this.r ? TransitionUtils.m(0.0f, 255.0f, f2) : TransitionUtils.m(255.0f, 0.0f, f2)));
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
                    f4 = (f2 / 0.01f) * MaterialContainerTransform.M4;
                }
                this.o.getPosTan(this.p * f3, fArr, (float[]) null);
                float[] fArr2 = this.q;
                f5 += (f5 - fArr2[0]) * f4;
                f6 += (f6 - fArr2[1]) * f4;
            }
            float f7 = f5;
            float f8 = f6;
            FitModeResult a2 = this.C.a(f2, ((Float) Preconditions.l(Float.valueOf(this.A.f22117b.f22114a))).floatValue(), ((Float) Preconditions.l(Float.valueOf(this.A.f22117b.f22115b))).floatValue(), this.f22121b.width(), this.f22121b.height(), this.f22125f.width(), this.f22125f.height());
            this.H = a2;
            RectF rectF = this.w;
            float f9 = a2.f22105c;
            rectF.set(f7 - (f9 / 2.0f), f8, (f9 / 2.0f) + f7, a2.f22106d + f8);
            RectF rectF2 = this.y;
            FitModeResult fitModeResult = this.H;
            float f10 = fitModeResult.f22107e;
            rectF2.set(f7 - (f10 / 2.0f), f8, f7 + (f10 / 2.0f), fitModeResult.f22108f + f8);
            this.x.set(this.w);
            this.z.set(this.y);
            float floatValue = ((Float) Preconditions.l(Float.valueOf(this.A.f22118c.f22114a))).floatValue();
            float floatValue2 = ((Float) Preconditions.l(Float.valueOf(this.A.f22118c.f22115b))).floatValue();
            boolean b2 = this.C.b(this.H);
            RectF rectF3 = b2 ? this.x : this.z;
            float n2 = TransitionUtils.n(0.0f, 1.0f, floatValue, floatValue2, f2);
            if (!b2) {
                n2 = 1.0f - n2;
            }
            this.C.c(rectF3, n2, this.H);
            this.I = new RectF(Math.min(this.x.left, this.z.left), Math.min(this.x.top, this.z.top), Math.max(this.x.right, this.z.right), Math.max(this.x.bottom, this.z.bottom));
            this.f22133n.b(f2, this.f22122c, this.f22126g, this.w, this.x, this.z, this.A.f22119d);
            this.J = TransitionUtils.m(this.f22123d, this.f22127h, f2);
            float d2 = d(this.I, this.s);
            float e2 = e(this.I, this.t);
            float f11 = this.J;
            float f12 = (float) ((int) (e2 * f11));
            this.K = f12;
            this.f22131l.setShadowLayer(f11, (float) ((int) (d2 * f11)), f12, M);
            this.G = this.B.a(f2, ((Float) Preconditions.l(Float.valueOf(this.A.f22116a.f22114a))).floatValue(), ((Float) Preconditions.l(Float.valueOf(this.A.f22116a.f22115b))).floatValue(), 0.35f);
            if (this.f22129j.getColor() != 0) {
                this.f22129j.setAlpha(this.G.f22095a);
            }
            if (this.f22130k.getColor() != 0) {
                this.f22130k.setAlpha(this.G.f22096b);
            }
            invalidateSelf();
        }

        public void draw(@NonNull Canvas canvas) {
            if (this.f22132m.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.f22132m);
            }
            int save = this.D ? canvas.save() : -1;
            if (this.u && this.J > 0.0f) {
                h(canvas);
            }
            this.f22133n.a(canvas);
            n(canvas, this.f22128i);
            if (this.G.f22097c) {
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
        this.r4 = Build.VERSION.SDK_INT >= 28 ? true : z;
        this.s4 = M4;
        this.t4 = M4;
    }

    private ProgressThresholdsGroup D1(boolean z) {
        ProgressThresholdsGroup progressThresholdsGroup;
        ProgressThresholdsGroup progressThresholdsGroup2;
        PathMotion b0 = b0();
        if ((b0 instanceof ArcMotion) || (b0 instanceof MaterialArcMotion)) {
            progressThresholdsGroup = K4;
            progressThresholdsGroup2 = L4;
        } else {
            progressThresholdsGroup = I4;
            progressThresholdsGroup2 = J4;
        }
        return E2(z, progressThresholdsGroup, progressThresholdsGroup2);
    }

    private ProgressThresholdsGroup E2(boolean z, ProgressThresholdsGroup progressThresholdsGroup, ProgressThresholdsGroup progressThresholdsGroup2) {
        if (!z) {
            progressThresholdsGroup = progressThresholdsGroup2;
        }
        return new ProgressThresholdsGroup((ProgressThresholds) TransitionUtils.e(this.n4, progressThresholdsGroup.f22116a), (ProgressThresholds) TransitionUtils.e(this.o4, progressThresholdsGroup.f22117b), (ProgressThresholds) TransitionUtils.e(this.p4, progressThresholdsGroup.f22118c), (ProgressThresholds) TransitionUtils.e(this.q4, progressThresholdsGroup.f22119d));
    }

    private static RectF F1(View view, @Nullable View view2, float f2, float f3) {
        if (view2 == null) {
            return new RectF(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        }
        RectF h2 = TransitionUtils.h(view2);
        h2.offset(f2, f3);
        return h2;
    }

    private static ShapeAppearanceModel H1(@NonNull View view, @NonNull RectF rectF, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        return TransitionUtils.c(p2(view, shapeAppearanceModel), rectF);
    }

    @StyleRes
    private static int I2(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.Jk});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private boolean M2(@NonNull RectF rectF, @NonNull RectF rectF2) {
        int i2 = this.g4;
        if (i2 == 0) {
            return TransitionUtils.b(rectF2) > TransitionUtils.b(rectF);
        }
        if (i2 == 1) {
            return true;
        }
        if (i2 == 2) {
            return false;
        }
        throw new IllegalArgumentException("Invalid transition direction: " + this.g4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void O1(@androidx.annotation.NonNull androidx.transition.TransitionValues r2, @androidx.annotation.Nullable android.view.View r3, @androidx.annotation.IdRes int r4, @androidx.annotation.Nullable com.google.android.material.shape.ShapeAppearanceModel r5) {
        /*
            r0 = -1
            if (r4 == r0) goto L_0x000c
            android.view.View r3 = r2.f16095b
            android.view.View r3 = com.google.android.material.transition.TransitionUtils.g(r3, r4)
        L_0x0009:
            r2.f16095b = r3
            goto L_0x002a
        L_0x000c:
            if (r3 == 0) goto L_0x000f
            goto L_0x0009
        L_0x000f:
            android.view.View r3 = r2.f16095b
            int r4 = com.google.android.material.R.id.s3
            java.lang.Object r3 = r3.getTag(r4)
            boolean r3 = r3 instanceof android.view.View
            if (r3 == 0) goto L_0x002a
            android.view.View r3 = r2.f16095b
            java.lang.Object r3 = r3.getTag(r4)
            android.view.View r3 = (android.view.View) r3
            android.view.View r0 = r2.f16095b
            r1 = 0
            r0.setTag(r4, r1)
            goto L_0x0009
        L_0x002a:
            android.view.View r3 = r2.f16095b
            boolean r4 = androidx.core.view.ViewCompat.Y0(r3)
            if (r4 != 0) goto L_0x003e
            int r4 = r3.getWidth()
            if (r4 != 0) goto L_0x003e
            int r4 = r3.getHeight()
            if (r4 == 0) goto L_0x005f
        L_0x003e:
            android.view.ViewParent r4 = r3.getParent()
            if (r4 != 0) goto L_0x0049
            android.graphics.RectF r4 = com.google.android.material.transition.TransitionUtils.i(r3)
            goto L_0x004d
        L_0x0049:
            android.graphics.RectF r4 = com.google.android.material.transition.TransitionUtils.h(r3)
        L_0x004d:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r2.f16094a
            java.lang.String r1 = "materialContainerTransition:bounds"
            r0.put(r1, r4)
            java.util.Map<java.lang.String, java.lang.Object> r2 = r2.f16094a
            java.lang.String r0 = "materialContainerTransition:shapeAppearance"
            com.google.android.material.shape.ShapeAppearanceModel r3 = H1(r3, r4, r5)
            r2.put(r0, r3)
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transition.MaterialContainerTransform.O1(androidx.transition.TransitionValues, android.view.View, int, com.google.android.material.shape.ShapeAppearanceModel):void");
    }

    private void P2(Context context, boolean z) {
        TransitionUtils.t(this, context, R.attr.Vd, AnimationUtils.f20767b);
        TransitionUtils.s(this, context, z ? R.attr.Fd : R.attr.Ld);
        if (!this.X3) {
            TransitionUtils.u(this, context, R.attr.f20603de);
        }
    }

    private static float T1(float f2, View view) {
        return f2 != M4 ? f2 : ViewCompat.T(view);
    }

    private static ShapeAppearanceModel p2(@NonNull View view, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        if (shapeAppearanceModel != null) {
            return shapeAppearanceModel;
        }
        int i2 = R.id.s3;
        if (view.getTag(i2) instanceof ShapeAppearanceModel) {
            return (ShapeAppearanceModel) view.getTag(i2);
        }
        Context context = view.getContext();
        int I2 = I2(context);
        if (I2 != -1) {
            return ShapeAppearanceModel.b(context, I2, 0).m();
        }
        return view instanceof Shapeable ? ((Shapeable) view).getShapeAppearanceModel() : ShapeAppearanceModel.a().m();
    }

    @Nullable
    public View B2() {
        return this.j4;
    }

    @IdRes
    public int C2() {
        return this.a4;
    }

    public int G2() {
        return this.g4;
    }

    public boolean J2() {
        return this.V3;
    }

    public boolean L2() {
        return this.r4;
    }

    public boolean N2() {
        return this.W3;
    }

    public void Q2(@ColorInt int i2) {
        this.c4 = i2;
        this.d4 = i2;
        this.e4 = i2;
    }

    @ColorInt
    public int R1() {
        return this.c4;
    }

    @IdRes
    public int S1() {
        return this.Z3;
    }

    public void S2(@ColorInt int i2) {
        this.c4 = i2;
    }

    public void T2(boolean z) {
        this.V3 = z;
    }

    @ColorInt
    public int U1() {
        return this.e4;
    }

    public void U2(@IdRes int i2) {
        this.Z3 = i2;
    }

    public void V2(boolean z) {
        this.r4 = z;
    }

    public void W2(@ColorInt int i2) {
        this.e4 = i2;
    }

    public void X2(float f2) {
        this.t4 = f2;
    }

    public void Y2(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.m4 = shapeAppearanceModel;
    }

    public void Z2(@Nullable View view) {
        this.k4 = view;
    }

    public float a2() {
        return this.t4;
    }

    public void a3(@IdRes int i2) {
        this.b4 = i2;
    }

    @Nullable
    public ShapeAppearanceModel b2() {
        return this.m4;
    }

    public void b3(int i2) {
        this.h4 = i2;
    }

    public void c3(@Nullable ProgressThresholds progressThresholds) {
        this.n4 = progressThresholds;
    }

    @Nullable
    public View d2() {
        return this.k4;
    }

    public void d3(int i2) {
        this.i4 = i2;
    }

    @IdRes
    public int e2() {
        return this.b4;
    }

    public void e3(boolean z) {
        this.W3 = z;
    }

    public int f2() {
        return this.h4;
    }

    public void f3(@Nullable ProgressThresholds progressThresholds) {
        this.p4 = progressThresholds;
    }

    @Nullable
    public ProgressThresholds g2() {
        return this.n4;
    }

    public void g3(@Nullable ProgressThresholds progressThresholds) {
        this.o4 = progressThresholds;
    }

    public void h3(@ColorInt int i2) {
        this.f4 = i2;
    }

    public int i2() {
        return this.i4;
    }

    public void i3(@Nullable ProgressThresholds progressThresholds) {
        this.q4 = progressThresholds;
    }

    @Nullable
    public ProgressThresholds j2() {
        return this.p4;
    }

    public void j3(@ColorInt int i2) {
        this.d4 = i2;
    }

    public void k3(float f2) {
        this.s4 = f2;
    }

    public void l3(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.l4 = shapeAppearanceModel;
    }

    @Nullable
    public ProgressThresholds m2() {
        return this.o4;
    }

    public void m3(@Nullable View view) {
        this.j4 = view;
    }

    public void n(@NonNull TransitionValues transitionValues) {
        O1(transitionValues, this.k4, this.b4, this.m4);
    }

    @ColorInt
    public int n2() {
        return this.f4;
    }

    public void n3(@IdRes int i2) {
        this.a4 = i2;
    }

    public void o3(int i2) {
        this.g4 = i2;
    }

    public void q(@NonNull TransitionValues transitionValues) {
        O1(transitionValues, this.j4, this.a4, this.l4);
    }

    @Nullable
    public ProgressThresholds q2() {
        return this.q4;
    }

    @Nullable
    public String[] r0() {
        return H4;
    }

    @ColorInt
    public int r2() {
        return this.d4;
    }

    @Nullable
    public Animator u(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        String str;
        String str2;
        final View view;
        View view2;
        TransitionValues transitionValues3 = transitionValues;
        TransitionValues transitionValues4 = transitionValues2;
        if (transitionValues3 == null || transitionValues4 == null) {
            return null;
        }
        RectF rectF = (RectF) transitionValues3.f16094a.get(F4);
        ShapeAppearanceModel shapeAppearanceModel = (ShapeAppearanceModel) transitionValues3.f16094a.get(G4);
        if (rectF == null || shapeAppearanceModel == null) {
            str = E4;
            str2 = "Skipping due to null start bounds. Ensure start view is laid out and measured.";
        } else {
            RectF rectF2 = (RectF) transitionValues4.f16094a.get(F4);
            ShapeAppearanceModel shapeAppearanceModel2 = (ShapeAppearanceModel) transitionValues4.f16094a.get(G4);
            if (rectF2 == null || shapeAppearanceModel2 == null) {
                str = E4;
                str2 = "Skipping due to null end bounds. Ensure end view is laid out and measured.";
            } else {
                final View view3 = transitionValues3.f16095b;
                final View view4 = transitionValues4.f16095b;
                View view5 = view4.getParent() != null ? view4 : view3;
                if (this.Z3 == view5.getId()) {
                    view = (View) view5.getParent();
                    view2 = view5;
                } else {
                    view = TransitionUtils.f(view5, this.Z3);
                    view2 = null;
                }
                RectF h2 = TransitionUtils.h(view);
                float f2 = -h2.left;
                float f3 = -h2.top;
                RectF F1 = F1(view, view2, f2, f3);
                rectF.offset(f2, f3);
                rectF2.offset(f2, f3);
                boolean M2 = M2(rectF, rectF2);
                if (!this.Y3) {
                    P2(view5.getContext(), M2);
                }
                final TransitionDrawable transitionDrawable = new TransitionDrawable(b0(), view3, rectF, shapeAppearanceModel, T1(this.s4, view3), view4, rectF2, shapeAppearanceModel2, T1(this.t4, view4), this.c4, this.d4, this.e4, this.f4, M2, this.r4, FadeModeEvaluators.a(this.h4, M2), FitModeEvaluators.a(this.i4, M2, rectF, rectF2), D1(M2), this.V3);
                transitionDrawable.setBounds(Math.round(F1.left), Math.round(F1.top), Math.round(F1.right), Math.round(F1.bottom));
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        transitionDrawable.o(valueAnimator.getAnimatedFraction());
                    }
                });
                final TransitionDrawable transitionDrawable2 = transitionDrawable;
                c(new TransitionListenerAdapter() {
                    public void b(@NonNull Transition transition) {
                        ViewUtils.o(view).a(transitionDrawable2);
                        view3.setAlpha(0.0f);
                        view4.setAlpha(0.0f);
                    }

                    public void k(@NonNull Transition transition) {
                        MaterialContainerTransform.this.S0(this);
                        if (!MaterialContainerTransform.this.W3) {
                            view3.setAlpha(1.0f);
                            view4.setAlpha(1.0f);
                            ViewUtils.o(view).b(transitionDrawable2);
                        }
                    }
                });
                return ofFloat;
            }
        }
        Log.w(str, str2);
        return null;
    }

    public void u1(@Nullable PathMotion pathMotion) {
        super.u1(pathMotion);
        this.X3 = true;
    }

    public float u2() {
        return this.s4;
    }

    @Nullable
    public ShapeAppearanceModel w2() {
        return this.l4;
    }

    public MaterialContainerTransform(@NonNull Context context, boolean z) {
        boolean z2 = false;
        this.r4 = Build.VERSION.SDK_INT >= 28 ? true : z2;
        this.s4 = M4;
        this.t4 = M4;
        P2(context, z);
        this.Y3 = true;
    }
}
