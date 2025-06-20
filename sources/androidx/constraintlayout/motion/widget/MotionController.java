package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.itextpdf.tool.xml.html.HTML;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class MotionController {
    public static final int N = 0;
    public static final int O = 1;
    public static final int P = 2;
    public static final int Q = 3;
    public static final int R = 4;
    public static final int S = 5;
    public static final int T = 0;
    public static final int U = 1;
    public static final int V = 2;
    public static final int W = 3;
    public static final int X = 4;
    public static final int Y = 5;
    public static final int Z = 6;
    public static final int a0 = 1;
    public static final int b0 = 2;
    private static final String c0 = "MotionController";
    private static final boolean d0 = false;
    private static final boolean e0 = false;
    static final int f0 = 0;
    static final int g0 = 1;
    static final int h0 = 2;
    static final int i0 = 3;
    static final int j0 = 4;
    static final int k0 = 5;
    private static final int l0 = -1;
    private static final int m0 = -2;
    private static final int n0 = -3;
    private ArrayList<Key> A = new ArrayList<>();
    private HashMap<String, ViewTimeCycle> B;
    private HashMap<String, ViewSpline> C;
    private HashMap<String, ViewOscillator> D;
    private KeyTrigger[] E;
    private int F;
    private int G;
    private View H;
    private int I;
    private float J;
    private Interpolator K;
    private boolean L;
    String[] M;

    /* renamed from: a  reason: collision with root package name */
    Rect f4455a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    View f4456b;

    /* renamed from: c  reason: collision with root package name */
    int f4457c;

    /* renamed from: d  reason: collision with root package name */
    boolean f4458d = false;

    /* renamed from: e  reason: collision with root package name */
    String f4459e;

    /* renamed from: f  reason: collision with root package name */
    private int f4460f = -1;

    /* renamed from: g  reason: collision with root package name */
    private MotionPaths f4461g = new MotionPaths();

    /* renamed from: h  reason: collision with root package name */
    private MotionPaths f4462h = new MotionPaths();

    /* renamed from: i  reason: collision with root package name */
    private MotionConstrainedPoint f4463i = new MotionConstrainedPoint();

    /* renamed from: j  reason: collision with root package name */
    private MotionConstrainedPoint f4464j = new MotionConstrainedPoint();

    /* renamed from: k  reason: collision with root package name */
    private CurveFit[] f4465k;

    /* renamed from: l  reason: collision with root package name */
    private CurveFit f4466l;

    /* renamed from: m  reason: collision with root package name */
    float f4467m = Float.NaN;

    /* renamed from: n  reason: collision with root package name */
    float f4468n = 0.0f;
    float o = 1.0f;
    float p;
    float q;
    private int[] r;
    private double[] s;
    private double[] t;
    private String[] u;
    private int[] v;
    private int w = 4;
    private float[] x = new float[4];
    private ArrayList<MotionPaths> y = new ArrayList<>();
    private float[] z = new float[1];

    MotionController(View view) {
        int i2 = Key.f4366f;
        this.F = i2;
        this.G = i2;
        this.H = null;
        this.I = i2;
        this.J = Float.NaN;
        this.K = null;
        this.L = false;
        Z(view);
    }

    private float D() {
        char c2;
        float f2;
        float[] fArr = new float[2];
        float f3 = 1.0f / ((float) 99);
        double d2 = 0.0d;
        double d3 = 0.0d;
        float f4 = 0.0f;
        int i2 = 0;
        while (i2 < 100) {
            float f5 = ((float) i2) * f3;
            double d4 = (double) f5;
            Easing easing = this.f4461g.s;
            Iterator<MotionPaths> it2 = this.y.iterator();
            float f6 = Float.NaN;
            float f7 = 0.0f;
            while (it2.hasNext()) {
                MotionPaths next = it2.next();
                Easing easing2 = next.s;
                if (easing2 != null) {
                    float f8 = next.Y;
                    if (f8 < f5) {
                        easing = easing2;
                        f7 = f8;
                    } else if (Float.isNaN(f6)) {
                        f6 = next.Y;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f6)) {
                    f6 = 1.0f;
                }
                float f9 = f6 - f7;
                d4 = (double) ((((float) easing.a((double) ((f5 - f7) / f9))) * f9) + f7);
            }
            this.f4465k[0].d(d4, this.s);
            float f10 = f4;
            int i3 = i2;
            this.f4461g.i(d4, this.r, this.s, fArr, 0);
            if (i3 > 0) {
                c2 = 0;
                f2 = (float) (((double) f10) + Math.hypot(d3 - ((double) fArr[1]), d2 - ((double) fArr[0])));
            } else {
                c2 = 0;
                f2 = f10;
            }
            d2 = (double) fArr[c2];
            i2 = i3 + 1;
            f4 = f2;
            d3 = (double) fArr[1];
        }
        return f4;
    }

    private void K(MotionPaths motionPaths) {
        int binarySearch = Collections.binarySearch(this.y, motionPaths);
        if (binarySearch == 0) {
            Log.e(c0, " KeyPath position \"" + motionPaths.Z + "\" outside of range");
        }
        this.y.add((-binarySearch) - 1, motionPaths);
    }

    private void O(MotionPaths motionPaths) {
        motionPaths.u((float) ((int) this.f4456b.getX()), (float) ((int) this.f4456b.getY()), (float) this.f4456b.getWidth(), (float) this.f4456b.getHeight());
    }

    private float j(float f2, float[] fArr) {
        float f3 = 0.0f;
        float f4 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f5 = this.o;
            if (((double) f5) != 1.0d) {
                float f6 = this.f4468n;
                if (f2 < f6) {
                    f2 = 0.0f;
                }
                if (f2 > f6 && ((double) f2) < 1.0d) {
                    f2 = Math.min((f2 - f6) * f5, 1.0f);
                }
            }
        }
        Easing easing = this.f4461g.s;
        Iterator<MotionPaths> it2 = this.y.iterator();
        float f7 = Float.NaN;
        while (it2.hasNext()) {
            MotionPaths next = it2.next();
            Easing easing2 = next.s;
            if (easing2 != null) {
                float f8 = next.Y;
                if (f8 < f2) {
                    easing = easing2;
                    f3 = f8;
                } else if (Float.isNaN(f7)) {
                    f7 = next.Y;
                }
            }
        }
        if (easing != null) {
            if (!Float.isNaN(f7)) {
                f4 = f7;
            }
            float f9 = f4 - f3;
            double d2 = (double) ((f2 - f3) / f9);
            f2 = (((float) easing.a(d2)) * f9) + f3;
            if (fArr != null) {
                fArr[0] = (float) easing.b(d2);
            }
        }
        return f2;
    }

    private static Interpolator v(Context context, int i2, String str, int i3) {
        if (i2 == -2) {
            return AnimationUtils.loadInterpolator(context, i3);
        }
        if (i2 == -1) {
            final Easing c2 = Easing.c(str);
            return new Interpolator() {
                public float getInterpolation(float f2) {
                    return (float) Easing.this.a((double) f2);
                }
            };
        } else if (i2 == 0) {
            return new AccelerateDecelerateInterpolator();
        } else {
            if (i2 == 1) {
                return new AccelerateInterpolator();
            }
            if (i2 == 2) {
                return new DecelerateInterpolator();
            }
            if (i2 == 4) {
                return new BounceInterpolator();
            }
            if (i2 != 5) {
                return null;
            }
            return new OvershootInterpolator();
        }
    }

    /* access modifiers changed from: package-private */
    public double[] A(double d2) {
        this.f4465k[0].d(d2, this.s);
        CurveFit curveFit = this.f4466l;
        if (curveFit != null) {
            double[] dArr = this.s;
            if (dArr.length > 0) {
                curveFit.d(d2, dArr);
            }
        }
        return this.s;
    }

    /* access modifiers changed from: package-private */
    public KeyPositionBase B(int i2, int i3, float f2, float f3) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.f4461g;
        float f4 = motionPaths.X2;
        rectF.left = f4;
        float f5 = motionPaths.Y2;
        rectF.top = f5;
        rectF.right = f4 + motionPaths.Z2;
        rectF.bottom = f5 + motionPaths.a3;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.f4462h;
        float f6 = motionPaths2.X2;
        rectF2.left = f6;
        float f7 = motionPaths2.Y2;
        rectF2.top = f7;
        rectF2.right = f6 + motionPaths2.Z2;
        rectF2.bottom = f7 + motionPaths2.a3;
        Iterator<Key> it2 = this.A.iterator();
        while (it2.hasNext()) {
            Key next = it2.next();
            if (next instanceof KeyPositionBase) {
                KeyPositionBase keyPositionBase = (KeyPositionBase) next;
                if (keyPositionBase.r(i2, i3, rectF, rectF2, f2, f3)) {
                    return keyPositionBase;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void C(float f2, int i2, int i3, float f3, float f4, float[] fArr) {
        float j2 = j(f2, this.z);
        HashMap<String, ViewSpline> hashMap = this.C;
        ViewOscillator viewOscillator = null;
        SplineSet splineSet = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, ViewSpline> hashMap2 = this.C;
        SplineSet splineSet2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, ViewSpline> hashMap3 = this.C;
        SplineSet splineSet3 = hashMap3 == null ? null : hashMap3.get(Key.f4369i);
        HashMap<String, ViewSpline> hashMap4 = this.C;
        SplineSet splineSet4 = hashMap4 == null ? null : hashMap4.get("scaleX");
        HashMap<String, ViewSpline> hashMap5 = this.C;
        SplineSet splineSet5 = hashMap5 == null ? null : hashMap5.get("scaleY");
        HashMap<String, ViewOscillator> hashMap6 = this.D;
        ViewOscillator viewOscillator2 = hashMap6 == null ? null : hashMap6.get("translationX");
        HashMap<String, ViewOscillator> hashMap7 = this.D;
        ViewOscillator viewOscillator3 = hashMap7 == null ? null : hashMap7.get("translationY");
        HashMap<String, ViewOscillator> hashMap8 = this.D;
        ViewOscillator viewOscillator4 = hashMap8 == null ? null : hashMap8.get(Key.f4369i);
        HashMap<String, ViewOscillator> hashMap9 = this.D;
        ViewOscillator viewOscillator5 = hashMap9 == null ? null : hashMap9.get("scaleX");
        HashMap<String, ViewOscillator> hashMap10 = this.D;
        if (hashMap10 != null) {
            viewOscillator = hashMap10.get("scaleY");
        }
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.b();
        velocityMatrix.d(splineSet3, j2);
        velocityMatrix.h(splineSet, splineSet2, j2);
        velocityMatrix.f(splineSet4, splineSet5, j2);
        velocityMatrix.c(viewOscillator4, j2);
        velocityMatrix.g(viewOscillator2, viewOscillator3, j2);
        velocityMatrix.e(viewOscillator5, viewOscillator, j2);
        CurveFit curveFit = this.f4466l;
        if (curveFit != null) {
            double[] dArr = this.s;
            if (dArr.length > 0) {
                double d2 = (double) j2;
                curveFit.d(d2, dArr);
                this.f4466l.g(d2, this.t);
                this.f4461g.v(f3, f4, fArr, this.r, this.t, this.s);
            }
            velocityMatrix.a(f3, f4, i2, i3, fArr);
            return;
        }
        int i4 = 0;
        if (this.f4465k != null) {
            double j3 = (double) j(j2, this.z);
            this.f4465k[0].g(j3, this.t);
            this.f4465k[0].d(j3, this.s);
            float f5 = this.z[0];
            while (true) {
                double[] dArr2 = this.t;
                if (i4 < dArr2.length) {
                    dArr2[i4] = dArr2[i4] * ((double) f5);
                    i4++;
                } else {
                    float f6 = f3;
                    float f7 = f4;
                    this.f4461g.v(f6, f7, fArr, this.r, dArr2, this.s);
                    velocityMatrix.a(f6, f7, i2, i3, fArr);
                    return;
                }
            }
        } else {
            MotionPaths motionPaths = this.f4462h;
            float f8 = motionPaths.X2;
            MotionPaths motionPaths2 = this.f4461g;
            float f9 = f8 - motionPaths2.X2;
            float f10 = motionPaths.Y2 - motionPaths2.Y2;
            ViewOscillator viewOscillator6 = viewOscillator5;
            float f11 = (motionPaths.a3 - motionPaths2.a3) + f10;
            fArr[0] = (f9 * (1.0f - f3)) + (((motionPaths.Z2 - motionPaths2.Z2) + f9) * f3);
            fArr[1] = (f10 * (1.0f - f4)) + (f11 * f4);
            velocityMatrix.b();
            velocityMatrix.d(splineSet3, j2);
            velocityMatrix.h(splineSet, splineSet2, j2);
            velocityMatrix.f(splineSet4, splineSet5, j2);
            velocityMatrix.c(viewOscillator4, j2);
            velocityMatrix.g(viewOscillator2, viewOscillator3, j2);
            velocityMatrix.e(viewOscillator6, viewOscillator, j2);
            velocityMatrix.a(f3, f4, i2, i3, fArr);
        }
    }

    public float E() {
        return this.f4461g.a3;
    }

    public float F() {
        return this.f4461g.Z2;
    }

    public float G() {
        return this.f4461g.X2;
    }

    public float H() {
        return this.f4461g.Y2;
    }

    public int I() {
        return this.G;
    }

    public View J() {
        return this.f4456b;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v58, resolved type: androidx.constraintlayout.motion.utils.ViewTimeCycle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: androidx.constraintlayout.motion.utils.ViewTimeCycle$PathRotate} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean L(android.view.View r21, float r22, long r23, androidx.constraintlayout.core.motion.utils.KeyCache r25) {
        /*
            r20 = this;
            r0 = r20
            r11 = r21
            r1 = 0
            r2 = r22
            float r2 = r0.j(r2, r1)
            int r3 = r0.I
            int r4 = androidx.constraintlayout.motion.widget.Key.f4366f
            r13 = 1065353216(0x3f800000, float:1.0)
            if (r3 == r4) goto L_0x0045
            float r3 = (float) r3
            float r3 = r13 / r3
            float r4 = r2 / r3
            double r4 = (double) r4
            double r4 = java.lang.Math.floor(r4)
            float r4 = (float) r4
            float r4 = r4 * r3
            float r2 = r2 % r3
            float r2 = r2 / r3
            float r5 = r0.J
            boolean r5 = java.lang.Float.isNaN(r5)
            if (r5 != 0) goto L_0x002e
            float r5 = r0.J
            float r2 = r2 + r5
            float r2 = r2 % r13
        L_0x002e:
            android.view.animation.Interpolator r5 = r0.K
            if (r5 == 0) goto L_0x0037
            float r2 = r5.getInterpolation(r2)
            goto L_0x0042
        L_0x0037:
            double r5 = (double) r2
            r7 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x0041
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0042
        L_0x0041:
            r2 = 0
        L_0x0042:
            float r2 = r2 * r3
            float r2 = r2 + r4
        L_0x0045:
            r14 = r2
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r2 = r0.C
            if (r2 == 0) goto L_0x0062
            java.util.Collection r2 = r2.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x0052:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0062
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.motion.utils.ViewSpline r3 = (androidx.constraintlayout.motion.utils.ViewSpline) r3
            r3.m(r11, r14)
            goto L_0x0052
        L_0x0062:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r2 = r0.B
            r15 = 0
            if (r2 == 0) goto L_0x0096
            java.util.Collection r2 = r2.values()
            java.util.Iterator r7 = r2.iterator()
            r8 = r1
            r9 = 0
        L_0x0071:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0092
            java.lang.Object r1 = r7.next()
            androidx.constraintlayout.motion.utils.ViewTimeCycle r1 = (androidx.constraintlayout.motion.utils.ViewTimeCycle) r1
            boolean r2 = r1 instanceof androidx.constraintlayout.motion.utils.ViewTimeCycle.PathRotate
            if (r2 == 0) goto L_0x0085
            r8 = r1
            androidx.constraintlayout.motion.utils.ViewTimeCycle$PathRotate r8 = (androidx.constraintlayout.motion.utils.ViewTimeCycle.PathRotate) r8
            goto L_0x0071
        L_0x0085:
            r2 = r21
            r3 = r14
            r4 = r23
            r6 = r25
            boolean r1 = r1.j(r2, r3, r4, r6)
            r9 = r9 | r1
            goto L_0x0071
        L_0x0092:
            r16 = r9
            r9 = r8
            goto L_0x0099
        L_0x0096:
            r9 = r1
            r16 = 0
        L_0x0099:
            androidx.constraintlayout.core.motion.utils.CurveFit[] r1 = r0.f4465k
            r10 = 1
            if (r1 == 0) goto L_0x01ec
            r1 = r1[r15]
            double r7 = (double) r14
            double[] r2 = r0.s
            r1.d(r7, r2)
            androidx.constraintlayout.core.motion.utils.CurveFit[] r1 = r0.f4465k
            r1 = r1[r15]
            double[] r2 = r0.t
            r1.g(r7, r2)
            androidx.constraintlayout.core.motion.utils.CurveFit r1 = r0.f4466l
            if (r1 == 0) goto L_0x00c2
            double[] r2 = r0.s
            int r3 = r2.length
            if (r3 <= 0) goto L_0x00c2
            r1.d(r7, r2)
            androidx.constraintlayout.core.motion.utils.CurveFit r1 = r0.f4466l
            double[] r2 = r0.t
            r1.g(r7, r2)
        L_0x00c2:
            boolean r1 = r0.L
            if (r1 != 0) goto L_0x00e2
            androidx.constraintlayout.motion.widget.MotionPaths r1 = r0.f4461g
            int[] r4 = r0.r
            double[] r5 = r0.s
            double[] r6 = r0.t
            r17 = 0
            boolean r3 = r0.f4458d
            r2 = r14
            r18 = r3
            r3 = r21
            r12 = r7
            r7 = r17
            r8 = r18
            r1.w(r2, r3, r4, r5, r6, r7, r8)
            r0.f4458d = r15
            goto L_0x00e3
        L_0x00e2:
            r12 = r7
        L_0x00e3:
            int r1 = r0.G
            int r2 = androidx.constraintlayout.motion.widget.Key.f4366f
            if (r1 == r2) goto L_0x0145
            android.view.View r1 = r0.H
            if (r1 != 0) goto L_0x00fb
            android.view.ViewParent r1 = r21.getParent()
            android.view.View r1 = (android.view.View) r1
            int r2 = r0.G
            android.view.View r1 = r1.findViewById(r2)
            r0.H = r1
        L_0x00fb:
            android.view.View r1 = r0.H
            if (r1 == 0) goto L_0x0145
            int r1 = r1.getTop()
            android.view.View r2 = r0.H
            int r2 = r2.getBottom()
            int r1 = r1 + r2
            float r1 = (float) r1
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            android.view.View r3 = r0.H
            int r3 = r3.getLeft()
            android.view.View r4 = r0.H
            int r4 = r4.getRight()
            int r3 = r3 + r4
            float r3 = (float) r3
            float r3 = r3 / r2
            int r2 = r21.getRight()
            int r4 = r21.getLeft()
            int r2 = r2 - r4
            if (r2 <= 0) goto L_0x0145
            int r2 = r21.getBottom()
            int r4 = r21.getTop()
            int r2 = r2 - r4
            if (r2 <= 0) goto L_0x0145
            int r2 = r21.getLeft()
            float r2 = (float) r2
            float r3 = r3 - r2
            int r2 = r21.getTop()
            float r2 = (float) r2
            float r1 = r1 - r2
            r11.setPivotX(r3)
            r11.setPivotY(r1)
        L_0x0145:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r1 = r0.C
            if (r1 == 0) goto L_0x0173
            java.util.Collection r1 = r1.values()
            java.util.Iterator r8 = r1.iterator()
        L_0x0151:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0173
            java.lang.Object r1 = r8.next()
            androidx.constraintlayout.core.motion.utils.SplineSet r1 = (androidx.constraintlayout.core.motion.utils.SplineSet) r1
            boolean r2 = r1 instanceof androidx.constraintlayout.motion.utils.ViewSpline.PathRotate
            if (r2 == 0) goto L_0x0151
            double[] r2 = r0.t
            int r3 = r2.length
            if (r3 <= r10) goto L_0x0151
            androidx.constraintlayout.motion.utils.ViewSpline$PathRotate r1 = (androidx.constraintlayout.motion.utils.ViewSpline.PathRotate) r1
            r4 = r2[r15]
            r6 = r2[r10]
            r2 = r21
            r3 = r14
            r1.n(r2, r3, r4, r6)
            goto L_0x0151
        L_0x0173:
            if (r9 == 0) goto L_0x018e
            double[] r1 = r0.t
            r7 = r1[r15]
            r17 = r1[r10]
            r1 = r9
            r2 = r21
            r3 = r25
            r4 = r14
            r5 = r23
            r19 = 1
            r9 = r17
            boolean r1 = r1.k(r2, r3, r4, r5, r7, r9)
            r16 = r16 | r1
            goto L_0x0190
        L_0x018e:
            r19 = 1
        L_0x0190:
            r10 = 1
        L_0x0191:
            androidx.constraintlayout.core.motion.utils.CurveFit[] r1 = r0.f4465k
            int r2 = r1.length
            if (r10 >= r2) goto L_0x01b5
            r1 = r1[r10]
            float[] r2 = r0.x
            r1.e(r12, r2)
            androidx.constraintlayout.motion.widget.MotionPaths r1 = r0.f4461g
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r1 = r1.h3
            java.lang.String[] r2 = r0.u
            int r3 = r10 + -1
            r2 = r2[r3]
            java.lang.Object r1 = r1.get(r2)
            androidx.constraintlayout.widget.ConstraintAttribute r1 = (androidx.constraintlayout.widget.ConstraintAttribute) r1
            float[] r2 = r0.x
            androidx.constraintlayout.motion.utils.CustomSupport.b(r1, r11, r2)
            int r10 = r10 + 1
            goto L_0x0191
        L_0x01b5:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r1 = r0.f4463i
            int r2 = r1.X
            if (r2 != 0) goto L_0x01da
            r2 = 0
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x01c6
        L_0x01c0:
            int r1 = r1.Y
            r11.setVisibility(r1)
            goto L_0x01da
        L_0x01c6:
            r2 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x01cf
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r1 = r0.f4464j
            goto L_0x01c0
        L_0x01cf:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r2 = r0.f4464j
            int r2 = r2.Y
            int r1 = r1.Y
            if (r2 == r1) goto L_0x01da
            r11.setVisibility(r15)
        L_0x01da:
            androidx.constraintlayout.motion.widget.KeyTrigger[] r1 = r0.E
            if (r1 == 0) goto L_0x0240
            r1 = 0
        L_0x01df:
            androidx.constraintlayout.motion.widget.KeyTrigger[] r2 = r0.E
            int r3 = r2.length
            if (r1 >= r3) goto L_0x0240
            r2 = r2[r1]
            r2.A(r14, r11)
            int r1 = r1 + 1
            goto L_0x01df
        L_0x01ec:
            r19 = 1
            androidx.constraintlayout.motion.widget.MotionPaths r1 = r0.f4461g
            float r2 = r1.X2
            androidx.constraintlayout.motion.widget.MotionPaths r3 = r0.f4462h
            float r4 = r3.X2
            float r4 = r4 - r2
            float r4 = r4 * r14
            float r2 = r2 + r4
            float r4 = r1.Y2
            float r5 = r3.Y2
            float r5 = r5 - r4
            float r5 = r5 * r14
            float r4 = r4 + r5
            float r5 = r1.Z2
            float r6 = r3.Z2
            float r7 = r6 - r5
            float r7 = r7 * r14
            float r7 = r7 + r5
            float r1 = r1.a3
            float r3 = r3.a3
            float r8 = r3 - r1
            float r8 = r8 * r14
            float r8 = r8 + r1
            r9 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r9
            int r10 = (int) r2
            float r4 = r4 + r9
            int r9 = (int) r4
            float r2 = r2 + r7
            int r2 = (int) r2
            float r4 = r4 + r8
            int r4 = (int) r4
            int r7 = r2 - r10
            int r8 = r4 - r9
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x022e
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x022e
            boolean r1 = r0.f4458d
            if (r1 == 0) goto L_0x023d
        L_0x022e:
            r1 = 1073741824(0x40000000, float:2.0)
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r1)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r1)
            r11.measure(r3, r1)
            r0.f4458d = r15
        L_0x023d:
            r11.layout(r10, r9, r2, r4)
        L_0x0240:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewOscillator> r1 = r0.D
            if (r1 == 0) goto L_0x026f
            java.util.Collection r1 = r1.values()
            java.util.Iterator r8 = r1.iterator()
        L_0x024c:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x026f
            java.lang.Object r1 = r8.next()
            androidx.constraintlayout.motion.utils.ViewOscillator r1 = (androidx.constraintlayout.motion.utils.ViewOscillator) r1
            boolean r2 = r1 instanceof androidx.constraintlayout.motion.utils.ViewOscillator.PathRotateSet
            if (r2 == 0) goto L_0x026b
            androidx.constraintlayout.motion.utils.ViewOscillator$PathRotateSet r1 = (androidx.constraintlayout.motion.utils.ViewOscillator.PathRotateSet) r1
            double[] r2 = r0.t
            r4 = r2[r15]
            r6 = r2[r19]
            r2 = r21
            r3 = r14
            r1.n(r2, r3, r4, r6)
            goto L_0x024c
        L_0x026b:
            r1.m(r11, r14)
            goto L_0x024c
        L_0x026f:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionController.L(android.view.View, float, long, androidx.constraintlayout.core.motion.utils.KeyCache):boolean");
    }

    /* access modifiers changed from: package-private */
    public String M() {
        return this.f4456b.getContext().getResources().getResourceEntryName(this.f4456b.getId());
    }

    /* access modifiers changed from: package-private */
    public void N(View view, KeyPositionBase keyPositionBase, float f2, float f3, String[] strArr, float[] fArr) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.f4461g;
        float f4 = motionPaths.X2;
        rectF.left = f4;
        float f5 = motionPaths.Y2;
        rectF.top = f5;
        rectF.right = f4 + motionPaths.Z2;
        rectF.bottom = f5 + motionPaths.a3;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.f4462h;
        float f6 = motionPaths2.X2;
        rectF2.left = f6;
        float f7 = motionPaths2.Y2;
        rectF2.top = f7;
        rectF2.right = f6 + motionPaths2.Z2;
        rectF2.bottom = f7 + motionPaths2.a3;
        keyPositionBase.s(view, rectF, rectF2, f2, f3, strArr, fArr);
    }

    public void P() {
        this.f4458d = true;
    }

    /* access modifiers changed from: package-private */
    public void Q(Rect rect, Rect rect2, int i2, int i3, int i4) {
        int i5;
        int width;
        int i6;
        int i7;
        int i8;
        if (i2 != 1) {
            if (i2 == 2) {
                i6 = rect.left + rect.right;
                i7 = rect.top;
                i8 = rect.bottom;
            } else if (i2 == 3) {
                i5 = rect.left + rect.right;
                width = ((rect.height() / 2) + rect.top) - (i5 / 2);
                rect2.left = width;
                rect2.top = i4 - ((i5 + rect.height()) / 2);
            } else if (i2 == 4) {
                i6 = rect.left + rect.right;
                i7 = rect.bottom;
                i8 = rect.top;
            } else {
                return;
            }
            rect2.left = i3 - (((i7 + i8) + rect.width()) / 2);
            rect2.top = (i6 - rect.height()) / 2;
        } else {
            i5 = rect.left + rect.right;
            width = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.left = width;
            rect2.top = i4 - ((i5 + rect.height()) / 2);
        }
        rect2.right = rect2.left + rect.width();
        rect2.bottom = rect2.top + rect.height();
    }

    /* access modifiers changed from: package-private */
    public void R(View view) {
        MotionPaths motionPaths = this.f4461g;
        motionPaths.Y = 0.0f;
        motionPaths.Z = 0.0f;
        this.L = true;
        motionPaths.u(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.f4462h.u(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.f4463i.p(view);
        this.f4464j.p(view);
    }

    public void S(int i2) {
        this.f4461g.X = i2;
    }

    /* access modifiers changed from: package-private */
    public void T(Rect rect, ConstraintSet constraintSet, int i2, int i3) {
        int i4 = constraintSet.f4706d;
        if (i4 != 0) {
            Q(rect, this.f4455a, i4, i2, i3);
            rect = this.f4455a;
        }
        MotionPaths motionPaths = this.f4462h;
        motionPaths.Y = 1.0f;
        motionPaths.Z = 1.0f;
        O(motionPaths);
        this.f4462h.u((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        this.f4462h.a(constraintSet.q0(this.f4457c));
        this.f4464j.o(rect, constraintSet, i4, this.f4457c);
    }

    public void U(int i2) {
        this.F = i2;
    }

    /* access modifiers changed from: package-private */
    public void V(View view) {
        MotionPaths motionPaths = this.f4461g;
        motionPaths.Y = 0.0f;
        motionPaths.Z = 0.0f;
        motionPaths.u(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.f4463i.p(view);
    }

    /* access modifiers changed from: package-private */
    public void W(Rect rect, ConstraintSet constraintSet, int i2, int i3) {
        int i4 = constraintSet.f4706d;
        if (i4 != 0) {
            Q(rect, this.f4455a, i4, i2, i3);
        }
        MotionPaths motionPaths = this.f4461g;
        motionPaths.Y = 0.0f;
        motionPaths.Z = 0.0f;
        O(motionPaths);
        this.f4461g.u((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        ConstraintSet.Constraint q0 = constraintSet.q0(this.f4457c);
        this.f4461g.a(q0);
        this.f4467m = q0.f4713d.f4752g;
        this.f4463i.o(rect, constraintSet, i4, this.f4457c);
        this.G = q0.f4715f.f4773i;
        ConstraintSet.Motion motion = q0.f4713d;
        this.I = motion.f4756k;
        this.J = motion.f4755j;
        Context context = this.f4456b.getContext();
        ConstraintSet.Motion motion2 = q0.f4713d;
        this.K = v(context, motion2.f4758m, motion2.f4757l, motion2.f4759n);
    }

    public void X(ViewState viewState, View view, int i2, int i3, int i4) {
        int b2;
        MotionPaths motionPaths = this.f4461g;
        motionPaths.Y = 0.0f;
        motionPaths.Z = 0.0f;
        Rect rect = new Rect();
        if (i2 != 1) {
            if (i2 == 2) {
                int i5 = viewState.f4352b + viewState.f4354d;
                rect.left = i4 - (((viewState.f4353c + viewState.f4355e) + viewState.c()) / 2);
                b2 = (i5 - viewState.b()) / 2;
            }
            this.f4461g.u((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
            this.f4463i.n(rect, view, i2, viewState.f4351a);
        }
        int i6 = viewState.f4352b + viewState.f4354d;
        rect.left = ((viewState.f4353c + viewState.f4355e) - viewState.c()) / 2;
        b2 = i3 - ((i6 + viewState.b()) / 2);
        rect.top = b2;
        rect.right = rect.left + viewState.c();
        rect.bottom = rect.top + viewState.b();
        this.f4461g.u((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        this.f4463i.n(rect, view, i2, viewState.f4351a);
    }

    public void Y(int i2) {
        this.G = i2;
        this.H = null;
    }

    public void Z(View view) {
        this.f4456b = view;
        this.f4457c = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.f4459e = ((ConstraintLayout.LayoutParams) layoutParams).a();
        }
    }

    public void a(Key key) {
        this.A.add(key);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x014f, code lost:
        r11 = (java.lang.Integer) r4.get(r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a0(int r17, int r18, float r19, long r20) {
        /*
            r16 = this;
            r0 = r16
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            int r5 = r0.F
            int r6 = androidx.constraintlayout.motion.widget.Key.f4366f
            if (r5 == r6) goto L_0x0025
            androidx.constraintlayout.motion.widget.MotionPaths r6 = r0.f4461g
            r6.d3 = r5
        L_0x0025:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r5 = r0.f4463i
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r6 = r0.f4464j
            r5.g(r6, r2)
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r5 = r0.A
            if (r5 == 0) goto L_0x008a
            java.util.Iterator r5 = r5.iterator()
            r7 = 0
        L_0x0035:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x008b
            java.lang.Object r8 = r5.next()
            androidx.constraintlayout.motion.widget.Key r8 = (androidx.constraintlayout.motion.widget.Key) r8
            boolean r9 = r8 instanceof androidx.constraintlayout.motion.widget.KeyPosition
            if (r9 == 0) goto L_0x0062
            androidx.constraintlayout.motion.widget.KeyPosition r8 = (androidx.constraintlayout.motion.widget.KeyPosition) r8
            androidx.constraintlayout.motion.widget.MotionPaths r9 = new androidx.constraintlayout.motion.widget.MotionPaths
            androidx.constraintlayout.motion.widget.MotionPaths r14 = r0.f4461g
            androidx.constraintlayout.motion.widget.MotionPaths r15 = r0.f4462h
            r10 = r9
            r11 = r17
            r12 = r18
            r13 = r8
            r10.<init>(r11, r12, r13, r14, r15)
            r0.K(r9)
            int r8 = r8.D
            int r9 = androidx.constraintlayout.motion.widget.Key.f4366f
            if (r8 == r9) goto L_0x0035
            r0.f4460f = r8
            goto L_0x0035
        L_0x0062:
            boolean r9 = r8 instanceof androidx.constraintlayout.motion.widget.KeyCycle
            if (r9 == 0) goto L_0x006a
            r8.d(r3)
            goto L_0x0035
        L_0x006a:
            boolean r9 = r8 instanceof androidx.constraintlayout.motion.widget.KeyTimeCycle
            if (r9 == 0) goto L_0x0072
            r8.d(r1)
            goto L_0x0035
        L_0x0072:
            boolean r9 = r8 instanceof androidx.constraintlayout.motion.widget.KeyTrigger
            if (r9 == 0) goto L_0x0083
            if (r7 != 0) goto L_0x007d
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L_0x007d:
            androidx.constraintlayout.motion.widget.KeyTrigger r8 = (androidx.constraintlayout.motion.widget.KeyTrigger) r8
            r7.add(r8)
            goto L_0x0035
        L_0x0083:
            r8.i(r4)
            r8.d(r2)
            goto L_0x0035
        L_0x008a:
            r7 = 0
        L_0x008b:
            r5 = 0
            if (r7 == 0) goto L_0x0098
            androidx.constraintlayout.motion.widget.KeyTrigger[] r8 = new androidx.constraintlayout.motion.widget.KeyTrigger[r5]
            java.lang.Object[] r7 = r7.toArray(r8)
            androidx.constraintlayout.motion.widget.KeyTrigger[] r7 = (androidx.constraintlayout.motion.widget.KeyTrigger[]) r7
            r0.E = r7
        L_0x0098:
            boolean r7 = r2.isEmpty()
            java.lang.String r8 = ","
            java.lang.String r9 = "CUSTOM,"
            r10 = 1
            if (r7 != 0) goto L_0x016b
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r0.C = r7
            java.util.Iterator r7 = r2.iterator()
        L_0x00ae:
            boolean r11 = r7.hasNext()
            if (r11 == 0) goto L_0x0105
            java.lang.Object r11 = r7.next()
            java.lang.String r11 = (java.lang.String) r11
            boolean r12 = r11.startsWith(r9)
            if (r12 == 0) goto L_0x00f5
            android.util.SparseArray r12 = new android.util.SparseArray
            r12.<init>()
            java.lang.String[] r13 = r11.split(r8)
            r13 = r13[r10]
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r14 = r0.A
            java.util.Iterator r14 = r14.iterator()
        L_0x00d1:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x00f0
            java.lang.Object r15 = r14.next()
            androidx.constraintlayout.motion.widget.Key r15 = (androidx.constraintlayout.motion.widget.Key) r15
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r6 = r15.f4379e
            if (r6 != 0) goto L_0x00e2
            goto L_0x00d1
        L_0x00e2:
            java.lang.Object r6 = r6.get(r13)
            androidx.constraintlayout.widget.ConstraintAttribute r6 = (androidx.constraintlayout.widget.ConstraintAttribute) r6
            if (r6 == 0) goto L_0x00d1
            int r15 = r15.f4375a
            r12.append(r15, r6)
            goto L_0x00d1
        L_0x00f0:
            androidx.constraintlayout.motion.utils.ViewSpline r6 = androidx.constraintlayout.motion.utils.ViewSpline.k(r11, r12)
            goto L_0x00f9
        L_0x00f5:
            androidx.constraintlayout.motion.utils.ViewSpline r6 = androidx.constraintlayout.motion.utils.ViewSpline.l(r11)
        L_0x00f9:
            if (r6 != 0) goto L_0x00fc
            goto L_0x00ae
        L_0x00fc:
            r6.i(r11)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r12 = r0.C
            r12.put(r11, r6)
            goto L_0x00ae
        L_0x0105:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r6 = r0.A
            if (r6 == 0) goto L_0x0123
            java.util.Iterator r6 = r6.iterator()
        L_0x010d:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0123
            java.lang.Object r7 = r6.next()
            androidx.constraintlayout.motion.widget.Key r7 = (androidx.constraintlayout.motion.widget.Key) r7
            boolean r11 = r7 instanceof androidx.constraintlayout.motion.widget.KeyAttributes
            if (r11 == 0) goto L_0x010d
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r11 = r0.C
            r7.a(r11)
            goto L_0x010d
        L_0x0123:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r6 = r0.f4463i
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r7 = r0.C
            r6.a(r7, r5)
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r6 = r0.f4464j
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r7 = r0.C
            r11 = 100
            r6.a(r7, r11)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r6 = r0.C
            java.util.Set r6 = r6.keySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x013d:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x016b
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            boolean r11 = r4.containsKey(r7)
            if (r11 == 0) goto L_0x015c
            java.lang.Object r11 = r4.get(r7)
            java.lang.Integer r11 = (java.lang.Integer) r11
            if (r11 == 0) goto L_0x015c
            int r11 = r11.intValue()
            goto L_0x015d
        L_0x015c:
            r11 = 0
        L_0x015d:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r12 = r0.C
            java.lang.Object r7 = r12.get(r7)
            androidx.constraintlayout.core.motion.utils.SplineSet r7 = (androidx.constraintlayout.core.motion.utils.SplineSet) r7
            if (r7 == 0) goto L_0x013d
            r7.j(r11)
            goto L_0x013d
        L_0x016b:
            boolean r6 = r1.isEmpty()
            if (r6 != 0) goto L_0x0238
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r6 = r0.B
            if (r6 != 0) goto L_0x017c
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            r0.B = r6
        L_0x017c:
            java.util.Iterator r1 = r1.iterator()
        L_0x0180:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x01e4
            java.lang.Object r6 = r1.next()
            java.lang.String r6 = (java.lang.String) r6
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r7 = r0.B
            boolean r7 = r7.containsKey(r6)
            if (r7 == 0) goto L_0x0195
            goto L_0x0180
        L_0x0195:
            boolean r7 = r6.startsWith(r9)
            if (r7 == 0) goto L_0x01d2
            android.util.SparseArray r7 = new android.util.SparseArray
            r7.<init>()
            java.lang.String[] r11 = r6.split(r8)
            r11 = r11[r10]
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r12 = r0.A
            java.util.Iterator r12 = r12.iterator()
        L_0x01ac:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x01cb
            java.lang.Object r13 = r12.next()
            androidx.constraintlayout.motion.widget.Key r13 = (androidx.constraintlayout.motion.widget.Key) r13
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r14 = r13.f4379e
            if (r14 != 0) goto L_0x01bd
            goto L_0x01ac
        L_0x01bd:
            java.lang.Object r14 = r14.get(r11)
            androidx.constraintlayout.widget.ConstraintAttribute r14 = (androidx.constraintlayout.widget.ConstraintAttribute) r14
            if (r14 == 0) goto L_0x01ac
            int r13 = r13.f4375a
            r7.append(r13, r14)
            goto L_0x01ac
        L_0x01cb:
            androidx.constraintlayout.motion.utils.ViewTimeCycle r7 = androidx.constraintlayout.motion.utils.ViewTimeCycle.h(r6, r7)
            r11 = r20
            goto L_0x01d8
        L_0x01d2:
            r11 = r20
            androidx.constraintlayout.motion.utils.ViewTimeCycle r7 = androidx.constraintlayout.motion.utils.ViewTimeCycle.i(r6, r11)
        L_0x01d8:
            if (r7 != 0) goto L_0x01db
            goto L_0x0180
        L_0x01db:
            r7.e(r6)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r13 = r0.B
            r13.put(r6, r7)
            goto L_0x0180
        L_0x01e4:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r1 = r0.A
            if (r1 == 0) goto L_0x0204
            java.util.Iterator r1 = r1.iterator()
        L_0x01ec:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0204
            java.lang.Object r6 = r1.next()
            androidx.constraintlayout.motion.widget.Key r6 = (androidx.constraintlayout.motion.widget.Key) r6
            boolean r7 = r6 instanceof androidx.constraintlayout.motion.widget.KeyTimeCycle
            if (r7 == 0) goto L_0x01ec
            androidx.constraintlayout.motion.widget.KeyTimeCycle r6 = (androidx.constraintlayout.motion.widget.KeyTimeCycle) r6
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r7 = r0.B
            r6.W(r7)
            goto L_0x01ec
        L_0x0204:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r1 = r0.B
            java.util.Set r1 = r1.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x020e:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0238
            java.lang.Object r6 = r1.next()
            java.lang.String r6 = (java.lang.String) r6
            boolean r7 = r4.containsKey(r6)
            if (r7 == 0) goto L_0x022b
            java.lang.Object r7 = r4.get(r6)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            goto L_0x022c
        L_0x022b:
            r7 = 0
        L_0x022c:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r8 = r0.B
            java.lang.Object r6 = r8.get(r6)
            androidx.constraintlayout.motion.utils.ViewTimeCycle r6 = (androidx.constraintlayout.motion.utils.ViewTimeCycle) r6
            r6.f(r7)
            goto L_0x020e
        L_0x0238:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionPaths> r1 = r0.y
            int r1 = r1.size()
            int r4 = r1 + 2
            androidx.constraintlayout.motion.widget.MotionPaths[] r6 = new androidx.constraintlayout.motion.widget.MotionPaths[r4]
            androidx.constraintlayout.motion.widget.MotionPaths r7 = r0.f4461g
            r6[r5] = r7
            int r1 = r1 + r10
            androidx.constraintlayout.motion.widget.MotionPaths r7 = r0.f4462h
            r6[r1] = r7
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionPaths> r1 = r0.y
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x025a
            int r1 = r0.f4460f
            r7 = -1
            if (r1 != r7) goto L_0x025a
            r0.f4460f = r5
        L_0x025a:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionPaths> r1 = r0.y
            java.util.Iterator r1 = r1.iterator()
            r7 = 1
        L_0x0261:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L_0x0273
            java.lang.Object r8 = r1.next()
            androidx.constraintlayout.motion.widget.MotionPaths r8 = (androidx.constraintlayout.motion.widget.MotionPaths) r8
            int r11 = r7 + 1
            r6[r7] = r8
            r7 = r11
            goto L_0x0261
        L_0x0273:
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            androidx.constraintlayout.motion.widget.MotionPaths r7 = r0.f4462h
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r7 = r7.h3
            java.util.Set r7 = r7.keySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x0284:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x02b3
            java.lang.Object r8 = r7.next()
            java.lang.String r8 = (java.lang.String) r8
            androidx.constraintlayout.motion.widget.MotionPaths r11 = r0.f4461g
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r11 = r11.h3
            boolean r11 = r11.containsKey(r8)
            if (r11 == 0) goto L_0x0284
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            r11.append(r8)
            java.lang.String r11 = r11.toString()
            boolean r11 = r2.contains(r11)
            if (r11 != 0) goto L_0x0284
            r1.add(r8)
            goto L_0x0284
        L_0x02b3:
            java.lang.String[] r2 = new java.lang.String[r5]
            java.lang.Object[] r1 = r1.toArray(r2)
            java.lang.String[] r1 = (java.lang.String[]) r1
            r0.u = r1
            int r1 = r1.length
            int[] r1 = new int[r1]
            r0.v = r1
            r1 = 0
        L_0x02c3:
            java.lang.String[] r2 = r0.u
            int r7 = r2.length
            if (r1 >= r7) goto L_0x02f9
            r2 = r2[r1]
            int[] r7 = r0.v
            r7[r1] = r5
            r7 = 0
        L_0x02cf:
            if (r7 >= r4) goto L_0x02f6
            r8 = r6[r7]
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r8 = r8.h3
            boolean r8 = r8.containsKey(r2)
            if (r8 == 0) goto L_0x02f3
            r8 = r6[r7]
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r8 = r8.h3
            java.lang.Object r8 = r8.get(r2)
            androidx.constraintlayout.widget.ConstraintAttribute r8 = (androidx.constraintlayout.widget.ConstraintAttribute) r8
            if (r8 == 0) goto L_0x02f3
            int[] r2 = r0.v
            r7 = r2[r1]
            int r8 = r8.p()
            int r7 = r7 + r8
            r2[r1] = r7
            goto L_0x02f6
        L_0x02f3:
            int r7 = r7 + 1
            goto L_0x02cf
        L_0x02f6:
            int r1 = r1 + 1
            goto L_0x02c3
        L_0x02f9:
            r1 = r6[r5]
            int r1 = r1.d3
            int r7 = androidx.constraintlayout.motion.widget.Key.f4366f
            if (r1 == r7) goto L_0x0303
            r1 = 1
            goto L_0x0304
        L_0x0303:
            r1 = 0
        L_0x0304:
            int r2 = r2.length
            r7 = 18
            int r7 = r7 + r2
            boolean[] r2 = new boolean[r7]
            r8 = 1
        L_0x030b:
            if (r8 >= r4) goto L_0x031b
            r9 = r6[r8]
            int r11 = r8 + -1
            r11 = r6[r11]
            java.lang.String[] r12 = r0.u
            r9.f(r11, r2, r12, r1)
            int r8 = r8 + 1
            goto L_0x030b
        L_0x031b:
            r1 = 1
            r8 = 0
        L_0x031d:
            if (r1 >= r7) goto L_0x0328
            boolean r9 = r2[r1]
            if (r9 == 0) goto L_0x0325
            int r8 = r8 + 1
        L_0x0325:
            int r1 = r1 + 1
            goto L_0x031d
        L_0x0328:
            int[] r1 = new int[r8]
            r0.r = r1
            r1 = 2
            int r8 = java.lang.Math.max(r1, r8)
            double[] r9 = new double[r8]
            r0.s = r9
            double[] r8 = new double[r8]
            r0.t = r8
            r8 = 1
            r9 = 0
        L_0x033b:
            if (r8 >= r7) goto L_0x034b
            boolean r11 = r2[r8]
            if (r11 == 0) goto L_0x0348
            int[] r11 = r0.r
            int r12 = r9 + 1
            r11[r9] = r8
            r9 = r12
        L_0x0348:
            int r8 = r8 + 1
            goto L_0x033b
        L_0x034b:
            int[] r2 = r0.r
            int r2 = r2.length
            int[] r7 = new int[r1]
            r7[r10] = r2
            r7[r5] = r4
            java.lang.Class r2 = java.lang.Double.TYPE
            java.lang.Object r2 = java.lang.reflect.Array.newInstance(r2, r7)
            double[][] r2 = (double[][]) r2
            double[] r7 = new double[r4]
            r8 = 0
        L_0x035f:
            if (r8 >= r4) goto L_0x0374
            r9 = r6[r8]
            r11 = r2[r8]
            int[] r12 = r0.r
            r9.g(r11, r12)
            r9 = r6[r8]
            float r9 = r9.Y
            double r11 = (double) r9
            r7[r8] = r11
            int r8 = r8 + 1
            goto L_0x035f
        L_0x0374:
            r8 = 0
        L_0x0375:
            int[] r9 = r0.r
            int r11 = r9.length
            if (r8 >= r11) goto L_0x03b6
            r9 = r9[r8]
            java.lang.String[] r11 = androidx.constraintlayout.motion.widget.MotionPaths.y3
            int r11 = r11.length
            if (r9 >= r11) goto L_0x03b3
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String[] r11 = androidx.constraintlayout.motion.widget.MotionPaths.y3
            int[] r12 = r0.r
            r12 = r12[r8]
            r11 = r11[r12]
            r9.append(r11)
            java.lang.String r11 = " ["
            r9.append(r11)
            java.lang.String r9 = r9.toString()
            r11 = 0
        L_0x039b:
            if (r11 >= r4) goto L_0x03b3
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r9)
            r9 = r2[r11]
            r13 = r9[r8]
            r12.append(r13)
            java.lang.String r9 = r12.toString()
            int r11 = r11 + 1
            goto L_0x039b
        L_0x03b3:
            int r8 = r8 + 1
            goto L_0x0375
        L_0x03b6:
            java.lang.String[] r8 = r0.u
            int r8 = r8.length
            int r8 = r8 + r10
            androidx.constraintlayout.core.motion.utils.CurveFit[] r8 = new androidx.constraintlayout.core.motion.utils.CurveFit[r8]
            r0.f4465k = r8
            r8 = 0
        L_0x03bf:
            java.lang.String[] r9 = r0.u
            int r11 = r9.length
            if (r8 >= r11) goto L_0x0423
            r9 = r9[r8]
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x03ca:
            if (r11 >= r4) goto L_0x0406
            r15 = r6[r11]
            boolean r15 = r15.o(r9)
            if (r15 == 0) goto L_0x03fd
            if (r14 != 0) goto L_0x03ec
            double[] r12 = new double[r4]
            r14 = r6[r11]
            int r14 = r14.m(r9)
            int[] r15 = new int[r1]
            r15[r10] = r14
            r15[r5] = r4
            java.lang.Class r14 = java.lang.Double.TYPE
            java.lang.Object r14 = java.lang.reflect.Array.newInstance(r14, r15)
            double[][] r14 = (double[][]) r14
        L_0x03ec:
            r15 = r6[r11]
            float r10 = r15.Y
            r20 = r2
            double r1 = (double) r10
            r12[r13] = r1
            r1 = r14[r13]
            r15.l(r9, r1, r5)
            int r13 = r13 + 1
            goto L_0x03ff
        L_0x03fd:
            r20 = r2
        L_0x03ff:
            int r11 = r11 + 1
            r2 = r20
            r1 = 2
            r10 = 1
            goto L_0x03ca
        L_0x0406:
            r20 = r2
            double[] r1 = java.util.Arrays.copyOf(r12, r13)
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r14, r13)
            double[][] r2 = (double[][]) r2
            androidx.constraintlayout.core.motion.utils.CurveFit[] r9 = r0.f4465k
            int r8 = r8 + 1
            int r10 = r0.f4460f
            androidx.constraintlayout.core.motion.utils.CurveFit r1 = androidx.constraintlayout.core.motion.utils.CurveFit.a(r10, r1, r2)
            r9[r8] = r1
            r2 = r20
            r1 = 2
            r10 = 1
            goto L_0x03bf
        L_0x0423:
            r20 = r2
            androidx.constraintlayout.core.motion.utils.CurveFit[] r1 = r0.f4465k
            int r2 = r0.f4460f
            r8 = r20
            androidx.constraintlayout.core.motion.utils.CurveFit r2 = androidx.constraintlayout.core.motion.utils.CurveFit.a(r2, r7, r8)
            r1[r5] = r2
            r1 = r6[r5]
            int r1 = r1.d3
            int r2 = androidx.constraintlayout.motion.widget.Key.f4366f
            if (r1 == r2) goto L_0x0471
            int[] r1 = new int[r4]
            double[] r2 = new double[r4]
            r7 = 2
            int[] r8 = new int[r7]
            r9 = 1
            r8[r9] = r7
            r8[r5] = r4
            java.lang.Class r7 = java.lang.Double.TYPE
            java.lang.Object r7 = java.lang.reflect.Array.newInstance(r7, r8)
            double[][] r7 = (double[][]) r7
            r8 = 0
        L_0x044e:
            if (r8 >= r4) goto L_0x046b
            r9 = r6[r8]
            int r10 = r9.d3
            r1[r8] = r10
            float r10 = r9.Y
            double r10 = (double) r10
            r2[r8] = r10
            r10 = r7[r8]
            float r11 = r9.X2
            double r11 = (double) r11
            r10[r5] = r11
            float r9 = r9.Y2
            double r11 = (double) r9
            r9 = 1
            r10[r9] = r11
            int r8 = r8 + 1
            goto L_0x044e
        L_0x046b:
            androidx.constraintlayout.core.motion.utils.CurveFit r1 = androidx.constraintlayout.core.motion.utils.CurveFit.b(r1, r2, r7)
            r0.f4466l = r1
        L_0x0471:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r0.D = r1
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r1 = r0.A
            if (r1 == 0) goto L_0x04e6
            java.util.Iterator r1 = r3.iterator()
            r2 = 2143289344(0x7fc00000, float:NaN)
        L_0x0482:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x04ae
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            androidx.constraintlayout.motion.utils.ViewOscillator r4 = androidx.constraintlayout.motion.utils.ViewOscillator.l(r3)
            if (r4 != 0) goto L_0x0495
            goto L_0x0482
        L_0x0495:
            boolean r5 = r4.k()
            if (r5 == 0) goto L_0x04a5
            boolean r5 = java.lang.Float.isNaN(r2)
            if (r5 == 0) goto L_0x04a5
            float r2 = r16.D()
        L_0x04a5:
            r4.i(r3)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewOscillator> r5 = r0.D
            r5.put(r3, r4)
            goto L_0x0482
        L_0x04ae:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.Key> r1 = r0.A
            java.util.Iterator r1 = r1.iterator()
        L_0x04b4:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x04cc
            java.lang.Object r3 = r1.next()
            androidx.constraintlayout.motion.widget.Key r3 = (androidx.constraintlayout.motion.widget.Key) r3
            boolean r4 = r3 instanceof androidx.constraintlayout.motion.widget.KeyCycle
            if (r4 == 0) goto L_0x04b4
            androidx.constraintlayout.motion.widget.KeyCycle r3 = (androidx.constraintlayout.motion.widget.KeyCycle) r3
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewOscillator> r4 = r0.D
            r3.a0(r4)
            goto L_0x04b4
        L_0x04cc:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewOscillator> r1 = r0.D
            java.util.Collection r1 = r1.values()
            java.util.Iterator r1 = r1.iterator()
        L_0x04d6:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x04e6
            java.lang.Object r3 = r1.next()
            androidx.constraintlayout.motion.utils.ViewOscillator r3 = (androidx.constraintlayout.motion.utils.ViewOscillator) r3
            r3.j(r2)
            goto L_0x04d6
        L_0x04e6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionController.a0(int, int, float, long):void");
    }

    /* access modifiers changed from: package-private */
    public void b(ArrayList<Key> arrayList) {
        this.A.addAll(arrayList);
    }

    public void b0(MotionController motionController) {
        this.f4461g.x(motionController, motionController.f4461g);
        this.f4462h.x(motionController, motionController.f4462h);
    }

    /* access modifiers changed from: package-private */
    public void c(float[] fArr, int i2) {
        int i3 = i2;
        float f2 = 1.0f / ((float) (i3 - 1));
        HashMap<String, ViewSpline> hashMap = this.C;
        if (hashMap != null) {
            SplineSet splineSet = hashMap.get("translationX");
        }
        HashMap<String, ViewSpline> hashMap2 = this.C;
        if (hashMap2 != null) {
            SplineSet splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, ViewOscillator> hashMap3 = this.D;
        if (hashMap3 != null) {
            ViewOscillator viewOscillator = hashMap3.get("translationX");
        }
        HashMap<String, ViewOscillator> hashMap4 = this.D;
        if (hashMap4 != null) {
            ViewOscillator viewOscillator2 = hashMap4.get("translationY");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            float f3 = ((float) i4) * f2;
            float f4 = this.o;
            float f5 = 0.0f;
            if (f4 != 1.0f) {
                float f6 = this.f4468n;
                if (f3 < f6) {
                    f3 = 0.0f;
                }
                if (f3 > f6 && ((double) f3) < 1.0d) {
                    f3 = Math.min((f3 - f6) * f4, 1.0f);
                }
            }
            double d2 = (double) f3;
            Easing easing = this.f4461g.s;
            Iterator<MotionPaths> it2 = this.y.iterator();
            float f7 = Float.NaN;
            while (it2.hasNext()) {
                MotionPaths next = it2.next();
                Easing easing2 = next.s;
                if (easing2 != null) {
                    float f8 = next.Y;
                    if (f8 < f3) {
                        easing = easing2;
                        f5 = f8;
                    } else if (Float.isNaN(f7)) {
                        f7 = next.Y;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f7)) {
                    f7 = 1.0f;
                }
                float f9 = f7 - f5;
                d2 = (double) ((((float) easing.a((double) ((f3 - f5) / f9))) * f9) + f5);
            }
            this.f4465k[0].d(d2, this.s);
            CurveFit curveFit = this.f4466l;
            if (curveFit != null) {
                double[] dArr = this.s;
                if (dArr.length > 0) {
                    curveFit.d(d2, dArr);
                }
            }
            this.f4461g.h(this.r, this.s, fArr, i4 * 2);
        }
    }

    /* access modifiers changed from: package-private */
    public int d(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] h2 = this.f4465k[0].h();
        if (iArr != null) {
            Iterator<MotionPaths> it2 = this.y.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                iArr[i2] = it2.next().i3;
                i2++;
            }
        }
        int i3 = 0;
        for (double d2 : h2) {
            this.f4465k[0].d(d2, this.s);
            this.f4461g.h(this.r, this.s, fArr, i3);
            i3 += 2;
        }
        return i3 / 2;
    }

    /* access modifiers changed from: package-private */
    public int e(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] h2 = this.f4465k[0].h();
        if (iArr != null) {
            Iterator<MotionPaths> it2 = this.y.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                iArr[i2] = it2.next().i3;
                i2++;
            }
        }
        int i3 = 0;
        for (int i4 = 0; i4 < h2.length; i4++) {
            this.f4465k[0].d(h2[i4], this.s);
            this.f4461g.i(h2[i4], this.r, this.s, fArr, i3);
            i3 += 2;
        }
        return i3 / 2;
    }

    /* access modifiers changed from: package-private */
    public void f(float[] fArr, int i2) {
        double d2;
        int i3 = i2;
        float f2 = 1.0f;
        float f3 = 1.0f / ((float) (i3 - 1));
        HashMap<String, ViewSpline> hashMap = this.C;
        ViewOscillator viewOscillator = null;
        SplineSet splineSet = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, ViewSpline> hashMap2 = this.C;
        SplineSet splineSet2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, ViewOscillator> hashMap3 = this.D;
        ViewOscillator viewOscillator2 = hashMap3 == null ? null : hashMap3.get("translationX");
        HashMap<String, ViewOscillator> hashMap4 = this.D;
        if (hashMap4 != null) {
            viewOscillator = hashMap4.get("translationY");
        }
        ViewOscillator viewOscillator3 = viewOscillator;
        int i4 = 0;
        while (i4 < i3) {
            float f4 = ((float) i4) * f3;
            float f5 = this.o;
            float f6 = 0.0f;
            if (f5 != f2) {
                float f7 = this.f4468n;
                if (f4 < f7) {
                    f4 = 0.0f;
                }
                if (f4 > f7 && ((double) f4) < 1.0d) {
                    f4 = Math.min((f4 - f7) * f5, f2);
                }
            }
            float f8 = f4;
            double d3 = (double) f8;
            Easing easing = this.f4461g.s;
            Iterator<MotionPaths> it2 = this.y.iterator();
            float f9 = Float.NaN;
            while (it2.hasNext()) {
                MotionPaths next = it2.next();
                Easing easing2 = next.s;
                double d4 = d3;
                if (easing2 != null) {
                    float f10 = next.Y;
                    if (f10 < f8) {
                        f6 = f10;
                        easing = easing2;
                    } else if (Float.isNaN(f9)) {
                        f9 = next.Y;
                    }
                }
                d3 = d4;
            }
            double d5 = d3;
            if (easing != null) {
                if (Float.isNaN(f9)) {
                    f9 = 1.0f;
                }
                float f11 = f9 - f6;
                d2 = (double) ((((float) easing.a((double) ((f8 - f6) / f11))) * f11) + f6);
            } else {
                d2 = d5;
            }
            this.f4465k[0].d(d2, this.s);
            CurveFit curveFit = this.f4466l;
            if (curveFit != null) {
                double[] dArr = this.s;
                if (dArr.length > 0) {
                    curveFit.d(d2, dArr);
                }
            }
            int i5 = i4 * 2;
            float f12 = f8;
            int i6 = i4;
            this.f4461g.i(d2, this.r, this.s, fArr, i5);
            if (viewOscillator2 != null) {
                fArr[i5] = fArr[i5] + viewOscillator2.a(f12);
            } else if (splineSet != null) {
                fArr[i5] = fArr[i5] + splineSet.a(f12);
            }
            if (viewOscillator3 != null) {
                int i7 = i5 + 1;
                fArr[i7] = fArr[i7] + viewOscillator3.a(f12);
            } else if (splineSet2 != null) {
                int i8 = i5 + 1;
                fArr[i8] = fArr[i8] + splineSet2.a(f12);
            }
            i4 = i6 + 1;
            f2 = 1.0f;
        }
    }

    /* access modifiers changed from: package-private */
    public void g(float f2, float[] fArr, int i2) {
        this.f4465k[0].d((double) j(f2, (float[]) null), this.s);
        this.f4461g.n(this.r, this.s, fArr, i2);
    }

    /* access modifiers changed from: package-private */
    public void h(float[] fArr, int i2) {
        float f2 = 1.0f / ((float) (i2 - 1));
        for (int i3 = 0; i3 < i2; i3++) {
            this.f4465k[0].d((double) j(((float) i3) * f2, (float[]) null), this.s);
            this.f4461g.n(this.r, this.s, fArr, i3 * 8);
        }
    }

    /* access modifiers changed from: package-private */
    public void i(boolean z2) {
        if (HTML.Tag.e0.equals(Debug.k(this.f4456b)) && this.E != null) {
            int i2 = 0;
            while (true) {
                KeyTrigger[] keyTriggerArr = this.E;
                if (i2 < keyTriggerArr.length) {
                    keyTriggerArr[i2].A(z2 ? -100.0f : 100.0f, this.f4456b);
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public int k() {
        return this.f4461g.e3;
    }

    /* access modifiers changed from: package-private */
    public int l(String str, float[] fArr, int i2) {
        SplineSet splineSet = this.C.get(str);
        if (splineSet == null) {
            return -1;
        }
        for (int i3 = 0; i3 < fArr.length; i3++) {
            fArr[i3] = splineSet.a((float) (i3 / (fArr.length - 1)));
        }
        return fArr.length;
    }

    public void m(double d2, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f4465k[0].d(d2, dArr);
        this.f4465k[0].g(d2, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.f4461g.j(d2, this.r, dArr, fArr, dArr2, fArr2);
    }

    public float n() {
        return this.p;
    }

    public float o() {
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public void p(float f2, float f3, float f4, float[] fArr) {
        double[] dArr;
        float j2 = j(f2, this.z);
        CurveFit[] curveFitArr = this.f4465k;
        int i2 = 0;
        if (curveFitArr != null) {
            double d2 = (double) j2;
            curveFitArr[0].g(d2, this.t);
            this.f4465k[0].d(d2, this.s);
            float f5 = this.z[0];
            while (true) {
                dArr = this.t;
                if (i2 >= dArr.length) {
                    break;
                }
                dArr[i2] = dArr[i2] * ((double) f5);
                i2++;
            }
            CurveFit curveFit = this.f4466l;
            if (curveFit != null) {
                double[] dArr2 = this.s;
                if (dArr2.length > 0) {
                    curveFit.d(d2, dArr2);
                    this.f4466l.g(d2, this.t);
                    this.f4461g.v(f3, f4, fArr, this.r, this.t, this.s);
                    return;
                }
                return;
            }
            this.f4461g.v(f3, f4, fArr, this.r, dArr, this.s);
            return;
        }
        MotionPaths motionPaths = this.f4462h;
        float f6 = motionPaths.X2;
        MotionPaths motionPaths2 = this.f4461g;
        float f7 = f6 - motionPaths2.X2;
        float f8 = motionPaths.Y2 - motionPaths2.Y2;
        float f9 = (motionPaths.Z2 - motionPaths2.Z2) + f7;
        float f10 = (motionPaths.a3 - motionPaths2.a3) + f8;
        fArr[0] = (f7 * (1.0f - f3)) + (f9 * f3);
        fArr[1] = (f8 * (1.0f - f4)) + (f10 * f4);
    }

    public int q() {
        int i2 = this.f4461g.X;
        Iterator<MotionPaths> it2 = this.y.iterator();
        while (it2.hasNext()) {
            i2 = Math.max(i2, it2.next().X);
        }
        return Math.max(i2, this.f4462h.X);
    }

    public float r() {
        return this.f4462h.a3;
    }

    public float s() {
        return this.f4462h.Z2;
    }

    public float t() {
        return this.f4462h.X2;
    }

    public String toString() {
        return " start: x: " + this.f4461g.X2 + " y: " + this.f4461g.Y2 + " end: x: " + this.f4462h.X2 + " y: " + this.f4462h.Y2;
    }

    public float u() {
        return this.f4462h.Y2;
    }

    /* access modifiers changed from: package-private */
    public MotionPaths w(int i2) {
        return this.y.get(i2);
    }

    public int x(int i2, int[] iArr) {
        float[] fArr = new float[2];
        Iterator<Key> it2 = this.A.iterator();
        int i3 = 0;
        int i4 = 0;
        while (it2.hasNext()) {
            Key next = it2.next();
            int i5 = next.f4378d;
            if (i5 == i2 || i2 != -1) {
                iArr[i4] = 0;
                iArr[i4 + 1] = i5;
                int i6 = next.f4375a;
                iArr[i4 + 2] = i6;
                double d2 = (double) (((float) i6) / 100.0f);
                this.f4465k[0].d(d2, this.s);
                this.f4461g.i(d2, this.r, this.s, fArr, 0);
                iArr[i4 + 3] = Float.floatToIntBits(fArr[0]);
                int i7 = i4 + 4;
                iArr[i7] = Float.floatToIntBits(fArr[1]);
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    iArr[i4 + 5] = keyPosition.O;
                    iArr[i4 + 6] = Float.floatToIntBits(keyPosition.K);
                    i7 = i4 + 7;
                    iArr[i7] = Float.floatToIntBits(keyPosition.L);
                }
                int i8 = i7 + 1;
                iArr[i4] = i8 - i4;
                i3++;
                i4 = i8;
            }
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public float y(int i2, float f2, float f3) {
        MotionPaths motionPaths = this.f4462h;
        float f4 = motionPaths.X2;
        MotionPaths motionPaths2 = this.f4461g;
        float f5 = motionPaths2.X2;
        float f6 = f4 - f5;
        float f7 = motionPaths.Y2;
        float f8 = motionPaths2.Y2;
        float f9 = f7 - f8;
        float f10 = f5 + (motionPaths2.Z2 / 2.0f);
        float f11 = f8 + (motionPaths2.a3 / 2.0f);
        float hypot = (float) Math.hypot((double) f6, (double) f9);
        if (((double) hypot) < 1.0E-7d) {
            return Float.NaN;
        }
        float f12 = f2 - f10;
        float f13 = f3 - f11;
        if (((float) Math.hypot((double) f12, (double) f13)) == 0.0f) {
            return 0.0f;
        }
        float f14 = (f12 * f6) + (f13 * f9);
        if (i2 == 0) {
            return f14 / hypot;
        }
        if (i2 == 1) {
            return (float) Math.sqrt((double) ((hypot * hypot) - (f14 * f14)));
        }
        if (i2 == 2) {
            return f12 / f6;
        }
        if (i2 == 3) {
            return f13 / f6;
        }
        if (i2 == 4) {
            return f12 / f9;
        }
        if (i2 != 5) {
            return 0.0f;
        }
        return f13 / f9;
    }

    public int z(int[] iArr, float[] fArr) {
        Iterator<Key> it2 = this.A.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it2.hasNext()) {
            Key next = it2.next();
            int i4 = next.f4375a;
            iArr[i2] = (next.f4378d * 1000) + i4;
            double d2 = (double) (((float) i4) / 100.0f);
            this.f4465k[0].d(d2, this.s);
            this.f4461g.i(d2, this.r, this.s, fArr, i3);
            i3 += 2;
            i2++;
        }
        return i2;
    }
}
