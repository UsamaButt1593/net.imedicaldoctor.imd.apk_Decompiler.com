package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.key.MotionKey;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.key.MotionKeyTrigger;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.DifferentialInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.core.motion.utils.ViewState;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Motion implements TypedValues {
    public static final int T = 0;
    public static final int U = 1;
    public static final int V = 2;
    public static final int W = 3;
    public static final int X = 4;
    public static final int Y = 5;
    public static final int Z = 0;
    public static final int a0 = 1;
    public static final int b0 = 2;
    public static final int c0 = 3;
    public static final int d0 = 4;
    public static final int e0 = 5;
    public static final int f0 = 6;
    public static final int g0 = 1;
    public static final int h0 = 2;
    private static final String i0 = "MotionController";
    private static final boolean j0 = false;
    private static final boolean k0 = false;
    static final int l0 = 0;
    static final int m0 = 1;
    static final int n0 = 2;
    static final int o0 = 3;
    static final int p0 = 4;
    static final int q0 = 5;
    private static final int r0 = -1;
    private static final int s0 = -2;
    private static final int t0 = -3;
    private String[] A;
    private int[] B;
    private int C = 4;
    private float[] D = new float[4];
    private ArrayList<MotionPaths> E = new ArrayList<>();
    private float[] F = new float[1];
    private ArrayList<MotionKey> G = new ArrayList<>();
    private HashMap<String, TimeCycleSplineSet> H;
    private HashMap<String, SplineSet> I;
    private HashMap<String, KeyCycleOscillator> J;
    private MotionKeyTrigger[] K;
    private int L = -1;
    private int M = -1;
    private MotionWidget N = null;
    private int O = -1;
    private float P = Float.NaN;
    private DifferentialInterpolator Q = null;
    private boolean R = false;
    String[] S;

    /* renamed from: h  reason: collision with root package name */
    Rect f3674h = new Rect();

    /* renamed from: i  reason: collision with root package name */
    MotionWidget f3675i;

    /* renamed from: j  reason: collision with root package name */
    int f3676j;

    /* renamed from: k  reason: collision with root package name */
    String f3677k;

    /* renamed from: l  reason: collision with root package name */
    private int f3678l = -1;

    /* renamed from: m  reason: collision with root package name */
    private MotionPaths f3679m = new MotionPaths();

    /* renamed from: n  reason: collision with root package name */
    private MotionPaths f3680n = new MotionPaths();
    private MotionConstrainedPoint o = new MotionConstrainedPoint();
    private MotionConstrainedPoint p = new MotionConstrainedPoint();
    private CurveFit[] q;
    private CurveFit r;
    float s = Float.NaN;
    float t = 0.0f;
    float u = 1.0f;
    float v;
    float w;
    private int[] x;
    private double[] y;
    private double[] z;

    public Motion(MotionWidget motionWidget) {
        c0(motionWidget);
    }

    private static DifferentialInterpolator A(int i2, String str, int i3) {
        if (i2 != -1) {
            return null;
        }
        final Easing c2 = Easing.c(str);
        return new DifferentialInterpolator() {

            /* renamed from: a  reason: collision with root package name */
            float f3681a;

            public float a() {
                return (float) c2.b((double) this.f3681a);
            }

            public float getInterpolation(float f2) {
                this.f3681a = f2;
                return (float) c2.a((double) f2);
            }
        };
    }

    private float I() {
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
            Easing easing = this.f3679m.s;
            Iterator<MotionPaths> it2 = this.E.iterator();
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
            this.q[0].d(d4, this.y);
            float f10 = f4;
            int i3 = i2;
            this.f3679m.i(d4, this.x, this.y, fArr, 0);
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

    private void P(MotionPaths motionPaths) {
        Iterator<MotionPaths> it2 = this.E.iterator();
        MotionPaths motionPaths2 = null;
        while (it2.hasNext()) {
            MotionPaths next = it2.next();
            if (motionPaths.Z == next.Z) {
                motionPaths2 = next;
            }
        }
        if (motionPaths2 != null) {
            this.E.remove(motionPaths2);
        }
        int binarySearch = Collections.binarySearch(this.E, motionPaths);
        if (binarySearch == 0) {
            Utils.f(i0, " KeyPath position \"" + motionPaths.Z + "\" outside of range");
        }
        this.E.add((-binarySearch) - 1, motionPaths);
    }

    private void T(MotionPaths motionPaths) {
        motionPaths.u((float) this.f3675i.E(), (float) this.f3675i.F(), (float) this.f3675i.D(), (float) this.f3675i.k());
    }

    private float o(float f2, float[] fArr) {
        float f3 = 0.0f;
        float f4 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f5 = this.u;
            if (((double) f5) != 1.0d) {
                float f6 = this.t;
                if (f2 < f6) {
                    f2 = 0.0f;
                }
                if (f2 > f6 && ((double) f2) < 1.0d) {
                    f2 = Math.min((f2 - f6) * f5, 1.0f);
                }
            }
        }
        Easing easing = this.f3679m.s;
        Iterator<MotionPaths> it2 = this.E.iterator();
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

    public MotionPaths B(int i2) {
        return this.E.get(i2);
    }

    public int C(int i2, int[] iArr) {
        float[] fArr = new float[2];
        Iterator<MotionKey> it2 = this.G.iterator();
        int i3 = 0;
        int i4 = 0;
        while (it2.hasNext()) {
            MotionKey next = it2.next();
            int i5 = next.f3726k;
            if (i5 == i2 || i2 != -1) {
                iArr[i4] = 0;
                iArr[i4 + 1] = i5;
                int i6 = next.f3723h;
                iArr[i4 + 2] = i6;
                double d2 = (double) (((float) i6) / 100.0f);
                this.q[0].d(d2, this.y);
                this.f3679m.i(d2, this.x, this.y, fArr, 0);
                iArr[i4 + 3] = Float.floatToIntBits(fArr[0]);
                int i7 = i4 + 4;
                iArr[i7] = Float.floatToIntBits(fArr[1]);
                if (next instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) next;
                    iArr[i4 + 5] = motionKeyPosition.I;
                    iArr[i4 + 6] = Float.floatToIntBits(motionKeyPosition.E);
                    i7 = i4 + 7;
                    iArr[i7] = Float.floatToIntBits(motionKeyPosition.F);
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
    public float D(int i2, float f2, float f3) {
        MotionPaths motionPaths = this.f3680n;
        float f4 = motionPaths.X2;
        MotionPaths motionPaths2 = this.f3679m;
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

    public int E(int[] iArr, float[] fArr) {
        Iterator<MotionKey> it2 = this.G.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it2.hasNext()) {
            MotionKey next = it2.next();
            int i4 = next.f3723h;
            iArr[i2] = (next.f3726k * 1000) + i4;
            double d2 = (double) (((float) i4) / 100.0f);
            this.q[0].d(d2, this.y);
            this.f3679m.i(d2, this.x, this.y, fArr, i3);
            i3 += 2;
            i2++;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public double[] F(double d2) {
        this.q[0].d(d2, this.y);
        CurveFit curveFit = this.r;
        if (curveFit != null) {
            double[] dArr = this.y;
            if (dArr.length > 0) {
                curveFit.d(d2, dArr);
            }
        }
        return this.y;
    }

    /* access modifiers changed from: package-private */
    public MotionKeyPosition G(int i2, int i3, float f2, float f3) {
        FloatRect floatRect = new FloatRect();
        MotionPaths motionPaths = this.f3679m;
        float f4 = motionPaths.X2;
        floatRect.f3772b = f4;
        float f5 = motionPaths.Y2;
        floatRect.f3774d = f5;
        floatRect.f3773c = f4 + motionPaths.Z2;
        floatRect.f3771a = f5 + motionPaths.a3;
        FloatRect floatRect2 = new FloatRect();
        MotionPaths motionPaths2 = this.f3680n;
        float f6 = motionPaths2.X2;
        floatRect2.f3772b = f6;
        float f7 = motionPaths2.Y2;
        floatRect2.f3774d = f7;
        floatRect2.f3773c = f6 + motionPaths2.Z2;
        floatRect2.f3771a = f7 + motionPaths2.a3;
        Iterator<MotionKey> it2 = this.G.iterator();
        while (it2.hasNext()) {
            MotionKey next = it2.next();
            if (next instanceof MotionKeyPosition) {
                MotionKeyPosition motionKeyPosition = (MotionKeyPosition) next;
                if (motionKeyPosition.B(i2, i3, floatRect, floatRect2, f2, f3)) {
                    return motionKeyPosition;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void H(float f2, int i2, int i3, float f3, float f4, float[] fArr) {
        float o2 = o(f2, this.F);
        HashMap<String, SplineSet> hashMap = this.I;
        KeyCycleOscillator keyCycleOscillator = null;
        SplineSet splineSet = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, SplineSet> hashMap2 = this.I;
        SplineSet splineSet2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, SplineSet> hashMap3 = this.I;
        SplineSet splineSet3 = hashMap3 == null ? null : hashMap3.get("rotationZ");
        HashMap<String, SplineSet> hashMap4 = this.I;
        SplineSet splineSet4 = hashMap4 == null ? null : hashMap4.get("scaleX");
        HashMap<String, SplineSet> hashMap5 = this.I;
        SplineSet splineSet5 = hashMap5 == null ? null : hashMap5.get("scaleY");
        HashMap<String, KeyCycleOscillator> hashMap6 = this.J;
        KeyCycleOscillator keyCycleOscillator2 = hashMap6 == null ? null : hashMap6.get("translationX");
        HashMap<String, KeyCycleOscillator> hashMap7 = this.J;
        KeyCycleOscillator keyCycleOscillator3 = hashMap7 == null ? null : hashMap7.get("translationY");
        HashMap<String, KeyCycleOscillator> hashMap8 = this.J;
        KeyCycleOscillator keyCycleOscillator4 = hashMap8 == null ? null : hashMap8.get("rotationZ");
        HashMap<String, KeyCycleOscillator> hashMap9 = this.J;
        KeyCycleOscillator keyCycleOscillator5 = hashMap9 == null ? null : hashMap9.get("scaleX");
        HashMap<String, KeyCycleOscillator> hashMap10 = this.J;
        if (hashMap10 != null) {
            keyCycleOscillator = hashMap10.get("scaleY");
        }
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.b();
        velocityMatrix.d(splineSet3, o2);
        velocityMatrix.h(splineSet, splineSet2, o2);
        velocityMatrix.f(splineSet4, splineSet5, o2);
        velocityMatrix.c(keyCycleOscillator4, o2);
        velocityMatrix.g(keyCycleOscillator2, keyCycleOscillator3, o2);
        velocityMatrix.e(keyCycleOscillator5, keyCycleOscillator, o2);
        CurveFit curveFit = this.r;
        if (curveFit != null) {
            double[] dArr = this.y;
            if (dArr.length > 0) {
                double d2 = (double) o2;
                curveFit.d(d2, dArr);
                this.r.g(d2, this.z);
                this.f3679m.v(f3, f4, fArr, this.x, this.z, this.y);
            }
            velocityMatrix.a(f3, f4, i2, i3, fArr);
            return;
        }
        int i4 = 0;
        if (this.q != null) {
            double o3 = (double) o(o2, this.F);
            this.q[0].g(o3, this.z);
            this.q[0].d(o3, this.y);
            float f5 = this.F[0];
            while (true) {
                double[] dArr2 = this.z;
                if (i4 < dArr2.length) {
                    dArr2[i4] = dArr2[i4] * ((double) f5);
                    i4++;
                } else {
                    float f6 = f3;
                    float f7 = f4;
                    this.f3679m.v(f6, f7, fArr, this.x, dArr2, this.y);
                    velocityMatrix.a(f6, f7, i2, i3, fArr);
                    return;
                }
            }
        } else {
            MotionPaths motionPaths = this.f3680n;
            float f8 = motionPaths.X2;
            MotionPaths motionPaths2 = this.f3679m;
            float f9 = f8 - motionPaths2.X2;
            float f10 = motionPaths.Y2 - motionPaths2.Y2;
            KeyCycleOscillator keyCycleOscillator6 = keyCycleOscillator5;
            float f11 = (motionPaths.a3 - motionPaths2.a3) + f10;
            fArr[0] = (f9 * (1.0f - f3)) + (((motionPaths.Z2 - motionPaths2.Z2) + f9) * f3);
            fArr[1] = (f10 * (1.0f - f4)) + (f11 * f4);
            velocityMatrix.b();
            velocityMatrix.d(splineSet3, o2);
            velocityMatrix.h(splineSet, splineSet2, o2);
            velocityMatrix.f(splineSet4, splineSet5, o2);
            velocityMatrix.c(keyCycleOscillator4, o2);
            velocityMatrix.g(keyCycleOscillator2, keyCycleOscillator3, o2);
            velocityMatrix.e(keyCycleOscillator6, keyCycleOscillator, o2);
            velocityMatrix.a(f3, f4, i2, i3, fArr);
        }
    }

    public float J() {
        return this.f3679m.a3;
    }

    public float K() {
        return this.f3679m.Z2;
    }

    public float L() {
        return this.f3679m.X2;
    }

    public float M() {
        return this.f3679m.Y2;
    }

    public int N() {
        return this.M;
    }

    public MotionWidget O() {
        return this.f3675i;
    }

    public boolean Q(MotionWidget motionWidget, float f2, long j2, KeyCache keyCache) {
        double d2;
        int i2;
        MotionWidget motionWidget2 = motionWidget;
        float o2 = o(f2, (float[]) null);
        int i3 = this.O;
        if (i3 != -1) {
            float f3 = 1.0f / ((float) i3);
            float floor = ((float) Math.floor((double) (o2 / f3))) * f3;
            float f4 = (o2 % f3) / f3;
            if (!Float.isNaN(this.P)) {
                f4 = (f4 + this.P) % 1.0f;
            }
            DifferentialInterpolator differentialInterpolator = this.Q;
            o2 = ((differentialInterpolator != null ? differentialInterpolator.getInterpolation(f4) : ((double) f4) > 0.5d ? 1.0f : 0.0f) * f3) + floor;
        }
        float f5 = o2;
        HashMap<String, SplineSet> hashMap = this.I;
        if (hashMap != null) {
            for (SplineSet h2 : hashMap.values()) {
                h2.h(motionWidget2, f5);
            }
        }
        CurveFit[] curveFitArr = this.q;
        if (curveFitArr != null) {
            double d3 = (double) f5;
            curveFitArr[0].d(d3, this.y);
            this.q[0].g(d3, this.z);
            CurveFit curveFit = this.r;
            if (curveFit != null) {
                double[] dArr = this.y;
                if (dArr.length > 0) {
                    curveFit.d(d3, dArr);
                    this.r.g(d3, this.z);
                }
            }
            if (!this.R) {
                d2 = d3;
                this.f3679m.w(f5, motionWidget, this.x, this.y, this.z, (double[]) null);
            } else {
                d2 = d3;
            }
            if (this.M != -1) {
                if (this.N == null) {
                    this.N = motionWidget.n().f(this.M);
                }
                MotionWidget motionWidget3 = this.N;
                if (motionWidget3 != null) {
                    float w2 = ((float) (motionWidget3.w() + this.N.h())) / 2.0f;
                    float l2 = ((float) (this.N.l() + this.N.q())) / 2.0f;
                    if (motionWidget.q() - motionWidget.l() > 0 && motionWidget.h() - motionWidget.w() > 0) {
                        motionWidget2.N(l2 - ((float) motionWidget.l()));
                        motionWidget2.O(w2 - ((float) motionWidget.w()));
                    }
                }
            }
            int i4 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.q;
                if (i4 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i4].e(d2, this.D);
                this.f3679m.h3.get(this.A[i4 - 1]).w(motionWidget2, this.D);
                i4++;
            }
            MotionConstrainedPoint motionConstrainedPoint = this.o;
            if (motionConstrainedPoint.X == 0) {
                if (f5 > 0.0f) {
                    if (f5 >= 1.0f) {
                        motionConstrainedPoint = this.p;
                    } else if (this.p.Y != motionConstrainedPoint.Y) {
                        i2 = 4;
                        motionWidget2.b0(i2);
                    }
                }
                i2 = motionConstrainedPoint.Y;
                motionWidget2.b0(i2);
            }
            if (this.K != null) {
                int i5 = 0;
                while (true) {
                    MotionKeyTrigger[] motionKeyTriggerArr = this.K;
                    if (i5 >= motionKeyTriggerArr.length) {
                        break;
                    }
                    motionKeyTriggerArr[i5].v(f5, motionWidget2);
                    i5++;
                }
            }
        } else {
            MotionPaths motionPaths = this.f3679m;
            float f6 = motionPaths.X2;
            MotionPaths motionPaths2 = this.f3680n;
            float f7 = f6 + ((motionPaths2.X2 - f6) * f5);
            float f8 = motionPaths.Y2;
            float f9 = f8 + ((motionPaths2.Y2 - f8) * f5);
            float f10 = motionPaths.Z2;
            float f11 = f10 + ((motionPaths2.Z2 - f10) * f5);
            float f12 = motionPaths.a3;
            float f13 = f7 + 0.5f;
            float f14 = f9 + 0.5f;
            motionWidget2.G((int) f13, (int) f14, (int) (f13 + f11), (int) (f14 + f12 + ((motionPaths2.a3 - f12) * f5)));
        }
        HashMap<String, KeyCycleOscillator> hashMap2 = this.J;
        if (hashMap2 == null) {
            return false;
        }
        for (KeyCycleOscillator next : hashMap2.values()) {
            if (next instanceof KeyCycleOscillator.PathRotateSet) {
                double[] dArr2 = this.z;
                ((KeyCycleOscillator.PathRotateSet) next).l(motionWidget, f5, dArr2[0], dArr2[1]);
            } else {
                next.h(motionWidget2, f5);
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public String R() {
        return this.f3675i.m();
    }

    /* access modifiers changed from: package-private */
    public void S(MotionWidget motionWidget, MotionKeyPosition motionKeyPosition, float f2, float f3, String[] strArr, float[] fArr) {
        FloatRect floatRect = new FloatRect();
        MotionPaths motionPaths = this.f3679m;
        float f4 = motionPaths.X2;
        floatRect.f3772b = f4;
        float f5 = motionPaths.Y2;
        floatRect.f3774d = f5;
        floatRect.f3773c = f4 + motionPaths.Z2;
        floatRect.f3771a = f5 + motionPaths.a3;
        FloatRect floatRect2 = new FloatRect();
        MotionPaths motionPaths2 = this.f3680n;
        float f6 = motionPaths2.X2;
        floatRect2.f3772b = f6;
        float f7 = motionPaths2.Y2;
        floatRect2.f3774d = f7;
        floatRect2.f3773c = f6 + motionPaths2.Z2;
        floatRect2.f3771a = f7 + motionPaths2.a3;
        motionKeyPosition.C(motionWidget, floatRect, floatRect2, f2, f3, strArr, fArr);
    }

    /* access modifiers changed from: package-private */
    public void U(Rect rect, Rect rect2, int i2, int i3, int i4) {
        int i5;
        int b2;
        int i6;
        int i7;
        int i8;
        if (i2 != 1) {
            if (i2 == 2) {
                i6 = rect.f3856b + rect.f3857c;
                i7 = rect.f3858d;
                i8 = rect.f3855a;
            } else if (i2 == 3) {
                i5 = rect.f3856b + rect.f3857c;
                b2 = ((rect.a() / 2) + rect.f3858d) - (i5 / 2);
                rect2.f3856b = b2;
                rect2.f3858d = i4 - ((i5 + rect.a()) / 2);
            } else if (i2 == 4) {
                i6 = rect.f3856b + rect.f3857c;
                i7 = rect.f3855a;
                i8 = rect.f3858d;
            } else {
                return;
            }
            rect2.f3856b = i3 - (((i7 + i8) + rect.b()) / 2);
            rect2.f3858d = (i6 - rect.a()) / 2;
        } else {
            i5 = rect.f3856b + rect.f3857c;
            b2 = ((rect.f3858d + rect.f3855a) - rect.b()) / 2;
            rect2.f3856b = b2;
            rect2.f3858d = i4 - ((i5 + rect.a()) / 2);
        }
        rect2.f3857c = rect2.f3856b + rect.b();
        rect2.f3855a = rect2.f3858d + rect.a();
    }

    /* access modifiers changed from: package-private */
    public void V(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.f3679m;
        motionPaths.Y = 0.0f;
        motionPaths.Z = 0.0f;
        this.R = true;
        motionPaths.u((float) motionWidget.E(), (float) motionWidget.F(), (float) motionWidget.D(), (float) motionWidget.k());
        this.f3680n.u((float) motionWidget.E(), (float) motionWidget.F(), (float) motionWidget.D(), (float) motionWidget.k());
        this.o.m(motionWidget);
        this.p.m(motionWidget);
    }

    public void W(int i2) {
        this.f3679m.X = i2;
    }

    public void X(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.f3680n;
        motionPaths.Y = 1.0f;
        motionPaths.Z = 1.0f;
        T(motionPaths);
        this.f3680n.u((float) motionWidget.l(), (float) motionWidget.w(), (float) motionWidget.D(), (float) motionWidget.k());
        this.f3680n.a(motionWidget);
        this.p.m(motionWidget);
    }

    public void Y(int i2) {
        this.L = i2;
    }

    public void Z(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.f3679m;
        motionPaths.Y = 0.0f;
        motionPaths.Z = 0.0f;
        motionPaths.u((float) motionWidget.E(), (float) motionWidget.F(), (float) motionWidget.D(), (float) motionWidget.k());
        this.f3679m.a(motionWidget);
        this.o.m(motionWidget);
    }

    public boolean a(int i2, int i3) {
        if (i2 != 509) {
            return i2 == 704;
        }
        Y(i3);
        return true;
    }

    public void a0(ViewState viewState, MotionWidget motionWidget, int i2, int i3, int i4) {
        int b2;
        MotionPaths motionPaths = this.f3679m;
        motionPaths.Y = 0.0f;
        motionPaths.Z = 0.0f;
        Rect rect = new Rect();
        if (i2 != 1) {
            if (i2 == 2) {
                int i5 = viewState.f4061b + viewState.f4063d;
                rect.f3856b = i4 - (((viewState.f4062c + viewState.f4064e) + viewState.c()) / 2);
                b2 = (i5 - viewState.b()) / 2;
            }
            this.f3679m.u((float) rect.f3856b, (float) rect.f3858d, (float) rect.b(), (float) rect.a());
            this.o.n(rect, motionWidget, i2, viewState.f4060a);
        }
        int i6 = viewState.f4061b + viewState.f4063d;
        rect.f3856b = ((viewState.f4062c + viewState.f4064e) - viewState.c()) / 2;
        b2 = i3 - ((i6 + viewState.b()) / 2);
        rect.f3858d = b2;
        rect.f3857c = rect.f3856b + viewState.c();
        rect.f3855a = rect.f3858d + viewState.b();
        this.f3679m.u((float) rect.f3856b, (float) rect.f3858d, (float) rect.b(), (float) rect.a());
        this.o.n(rect, motionWidget, i2, viewState.f4060a);
    }

    public boolean b(int i2, float f2) {
        return false;
    }

    public void b0(int i2) {
        this.M = i2;
        this.N = null;
    }

    public boolean c(int i2, String str) {
        if (705 == i2) {
            PrintStream printStream = System.out;
            printStream.println("TYPE_INTERPOLATOR  " + str);
            this.Q = A(-1, str, 0);
        }
        return false;
    }

    public void c0(MotionWidget motionWidget) {
        this.f3675i = motionWidget;
    }

    public boolean d(int i2, boolean z2) {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x015b, code lost:
        r9 = (java.lang.Integer) r6.get(r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d0(int r20, int r21, float r22, long r23) {
        /*
            r19 = this;
            r0 = r19
            r1 = r23
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            int r7 = r0.L
            r8 = -1
            if (r7 == r8) goto L_0x0026
            androidx.constraintlayout.core.motion.MotionPaths r9 = r0.f3679m
            r9.d3 = r7
        L_0x0026:
            androidx.constraintlayout.core.motion.MotionConstrainedPoint r7 = r0.o
            androidx.constraintlayout.core.motion.MotionConstrainedPoint r9 = r0.p
            r7.f(r9, r4)
            java.util.ArrayList<androidx.constraintlayout.core.motion.key.MotionKey> r7 = r0.G
            if (r7 == 0) goto L_0x008e
            java.util.Iterator r7 = r7.iterator()
            r10 = 0
        L_0x0036:
            boolean r11 = r7.hasNext()
            if (r11 == 0) goto L_0x008f
            java.lang.Object r11 = r7.next()
            androidx.constraintlayout.core.motion.key.MotionKey r11 = (androidx.constraintlayout.core.motion.key.MotionKey) r11
            boolean r12 = r11 instanceof androidx.constraintlayout.core.motion.key.MotionKeyPosition
            if (r12 == 0) goto L_0x0066
            androidx.constraintlayout.core.motion.key.MotionKeyPosition r11 = (androidx.constraintlayout.core.motion.key.MotionKeyPosition) r11
            androidx.constraintlayout.core.motion.MotionPaths r12 = new androidx.constraintlayout.core.motion.MotionPaths
            androidx.constraintlayout.core.motion.MotionPaths r15 = r0.f3679m
            androidx.constraintlayout.core.motion.MotionPaths r14 = r0.f3680n
            r13 = r12
            r18 = r14
            r14 = r20
            r17 = r15
            r15 = r21
            r16 = r11
            r13.<init>(r14, r15, r16, r17, r18)
            r0.P(r12)
            int r11 = r11.y
            if (r11 == r8) goto L_0x0036
            r0.f3678l = r11
            goto L_0x0036
        L_0x0066:
            boolean r12 = r11 instanceof androidx.constraintlayout.core.motion.key.MotionKeyCycle
            if (r12 == 0) goto L_0x006e
            r11.i(r5)
            goto L_0x0036
        L_0x006e:
            boolean r12 = r11 instanceof androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle
            if (r12 == 0) goto L_0x0076
            r11.i(r3)
            goto L_0x0036
        L_0x0076:
            boolean r12 = r11 instanceof androidx.constraintlayout.core.motion.key.MotionKeyTrigger
            if (r12 == 0) goto L_0x0087
            if (r10 != 0) goto L_0x0081
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
        L_0x0081:
            androidx.constraintlayout.core.motion.key.MotionKeyTrigger r11 = (androidx.constraintlayout.core.motion.key.MotionKeyTrigger) r11
            r10.add(r11)
            goto L_0x0036
        L_0x0087:
            r11.q(r6)
            r11.i(r4)
            goto L_0x0036
        L_0x008e:
            r10 = 0
        L_0x008f:
            r7 = 0
            if (r10 == 0) goto L_0x009c
            androidx.constraintlayout.core.motion.key.MotionKeyTrigger[] r11 = new androidx.constraintlayout.core.motion.key.MotionKeyTrigger[r7]
            java.lang.Object[] r10 = r10.toArray(r11)
            androidx.constraintlayout.core.motion.key.MotionKeyTrigger[] r10 = (androidx.constraintlayout.core.motion.key.MotionKeyTrigger[]) r10
            r0.K = r10
        L_0x009c:
            boolean r10 = r4.isEmpty()
            java.lang.String r11 = ","
            java.lang.String r12 = "CUSTOM,"
            r13 = 1
            if (r10 != 0) goto L_0x0177
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            r0.I = r10
            java.util.Iterator r10 = r4.iterator()
        L_0x00b2:
            boolean r14 = r10.hasNext()
            if (r14 == 0) goto L_0x0110
            java.lang.Object r14 = r10.next()
            java.lang.String r14 = (java.lang.String) r14
            boolean r15 = r14.startsWith(r12)
            if (r15 == 0) goto L_0x00fd
            androidx.constraintlayout.core.motion.utils.KeyFrameArray$CustomVar r15 = new androidx.constraintlayout.core.motion.utils.KeyFrameArray$CustomVar
            r15.<init>()
            java.lang.String[] r16 = r14.split(r11)
            r9 = r16[r13]
            java.util.ArrayList<androidx.constraintlayout.core.motion.key.MotionKey> r8 = r0.G
            java.util.Iterator r8 = r8.iterator()
        L_0x00d5:
            boolean r17 = r8.hasNext()
            if (r17 == 0) goto L_0x00f8
            java.lang.Object r17 = r8.next()
            r13 = r17
            androidx.constraintlayout.core.motion.key.MotionKey r13 = (androidx.constraintlayout.core.motion.key.MotionKey) r13
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.CustomVariable> r7 = r13.f3727l
            if (r7 != 0) goto L_0x00ea
        L_0x00e7:
            r7 = 0
            r13 = 1
            goto L_0x00d5
        L_0x00ea:
            java.lang.Object r7 = r7.get(r9)
            androidx.constraintlayout.core.motion.CustomVariable r7 = (androidx.constraintlayout.core.motion.CustomVariable) r7
            if (r7 == 0) goto L_0x00e7
            int r13 = r13.f3723h
            r15.a(r13, r7)
            goto L_0x00e7
        L_0x00f8:
            androidx.constraintlayout.core.motion.utils.SplineSet r7 = androidx.constraintlayout.core.motion.utils.SplineSet.e(r14, r15)
            goto L_0x0101
        L_0x00fd:
            androidx.constraintlayout.core.motion.utils.SplineSet r7 = androidx.constraintlayout.core.motion.utils.SplineSet.f(r14, r1)
        L_0x0101:
            if (r7 != 0) goto L_0x0107
        L_0x0103:
            r7 = 0
            r8 = -1
            r13 = 1
            goto L_0x00b2
        L_0x0107:
            r7.i(r14)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.SplineSet> r8 = r0.I
            r8.put(r14, r7)
            goto L_0x0103
        L_0x0110:
            java.util.ArrayList<androidx.constraintlayout.core.motion.key.MotionKey> r7 = r0.G
            if (r7 == 0) goto L_0x012e
            java.util.Iterator r7 = r7.iterator()
        L_0x0118:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x012e
            java.lang.Object r8 = r7.next()
            androidx.constraintlayout.core.motion.key.MotionKey r8 = (androidx.constraintlayout.core.motion.key.MotionKey) r8
            boolean r9 = r8 instanceof androidx.constraintlayout.core.motion.key.MotionKeyAttributes
            if (r9 == 0) goto L_0x0118
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.SplineSet> r9 = r0.I
            r8.f(r9)
            goto L_0x0118
        L_0x012e:
            androidx.constraintlayout.core.motion.MotionConstrainedPoint r7 = r0.o
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.SplineSet> r8 = r0.I
            r9 = 0
            r7.a(r8, r9)
            androidx.constraintlayout.core.motion.MotionConstrainedPoint r7 = r0.p
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.SplineSet> r8 = r0.I
            r9 = 100
            r7.a(r8, r9)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.SplineSet> r7 = r0.I
            java.util.Set r7 = r7.keySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x0149:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0177
            java.lang.Object r8 = r7.next()
            java.lang.String r8 = (java.lang.String) r8
            boolean r9 = r6.containsKey(r8)
            if (r9 == 0) goto L_0x0168
            java.lang.Object r9 = r6.get(r8)
            java.lang.Integer r9 = (java.lang.Integer) r9
            if (r9 == 0) goto L_0x0168
            int r9 = r9.intValue()
            goto L_0x0169
        L_0x0168:
            r9 = 0
        L_0x0169:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.SplineSet> r10 = r0.I
            java.lang.Object r8 = r10.get(r8)
            androidx.constraintlayout.core.motion.utils.SplineSet r8 = (androidx.constraintlayout.core.motion.utils.SplineSet) r8
            if (r8 == 0) goto L_0x0149
            r8.j(r9)
            goto L_0x0149
        L_0x0177:
            boolean r7 = r3.isEmpty()
            if (r7 != 0) goto L_0x023c
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet> r7 = r0.H
            if (r7 != 0) goto L_0x0188
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r0.H = r7
        L_0x0188:
            java.util.Iterator r3 = r3.iterator()
        L_0x018c:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x01e8
            java.lang.Object r7 = r3.next()
            java.lang.String r7 = (java.lang.String) r7
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet> r8 = r0.H
            boolean r8 = r8.containsKey(r7)
            if (r8 == 0) goto L_0x01a1
            goto L_0x018c
        L_0x01a1:
            boolean r8 = r7.startsWith(r12)
            if (r8 == 0) goto L_0x01dd
            androidx.constraintlayout.core.motion.utils.KeyFrameArray$CustomVar r8 = new androidx.constraintlayout.core.motion.utils.KeyFrameArray$CustomVar
            r8.<init>()
            java.lang.String[] r9 = r7.split(r11)
            r10 = 1
            r9 = r9[r10]
            java.util.ArrayList<androidx.constraintlayout.core.motion.key.MotionKey> r10 = r0.G
            java.util.Iterator r10 = r10.iterator()
        L_0x01b9:
            boolean r13 = r10.hasNext()
            if (r13 == 0) goto L_0x01d8
            java.lang.Object r13 = r10.next()
            androidx.constraintlayout.core.motion.key.MotionKey r13 = (androidx.constraintlayout.core.motion.key.MotionKey) r13
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.CustomVariable> r14 = r13.f3727l
            if (r14 != 0) goto L_0x01ca
            goto L_0x01b9
        L_0x01ca:
            java.lang.Object r14 = r14.get(r9)
            androidx.constraintlayout.core.motion.CustomVariable r14 = (androidx.constraintlayout.core.motion.CustomVariable) r14
            if (r14 == 0) goto L_0x01b9
            int r13 = r13.f3723h
            r8.a(r13, r14)
            goto L_0x01b9
        L_0x01d8:
            androidx.constraintlayout.core.motion.utils.SplineSet r8 = androidx.constraintlayout.core.motion.utils.SplineSet.e(r7, r8)
            goto L_0x01e1
        L_0x01dd:
            androidx.constraintlayout.core.motion.utils.SplineSet r8 = androidx.constraintlayout.core.motion.utils.SplineSet.f(r7, r1)
        L_0x01e1:
            if (r8 != 0) goto L_0x01e4
            goto L_0x018c
        L_0x01e4:
            r8.i(r7)
            goto L_0x018c
        L_0x01e8:
            java.util.ArrayList<androidx.constraintlayout.core.motion.key.MotionKey> r1 = r0.G
            if (r1 == 0) goto L_0x0208
            java.util.Iterator r1 = r1.iterator()
        L_0x01f0:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0208
            java.lang.Object r2 = r1.next()
            androidx.constraintlayout.core.motion.key.MotionKey r2 = (androidx.constraintlayout.core.motion.key.MotionKey) r2
            boolean r3 = r2 instanceof androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle
            if (r3 == 0) goto L_0x01f0
            androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle r2 = (androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle) r2
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet> r3 = r0.H
            r2.v(r3)
            goto L_0x01f0
        L_0x0208:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet> r1 = r0.H
            java.util.Set r1 = r1.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0212:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x023c
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            boolean r3 = r6.containsKey(r2)
            if (r3 == 0) goto L_0x022f
            java.lang.Object r3 = r6.get(r2)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            goto L_0x0230
        L_0x022f:
            r3 = 0
        L_0x0230:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet> r7 = r0.H
            java.lang.Object r2 = r7.get(r2)
            androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet r2 = (androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet) r2
            r2.f(r3)
            goto L_0x0212
        L_0x023c:
            java.util.ArrayList<androidx.constraintlayout.core.motion.MotionPaths> r1 = r0.E
            int r1 = r1.size()
            int r2 = r1 + 2
            androidx.constraintlayout.core.motion.MotionPaths[] r3 = new androidx.constraintlayout.core.motion.MotionPaths[r2]
            androidx.constraintlayout.core.motion.MotionPaths r6 = r0.f3679m
            r7 = 0
            r3[r7] = r6
            r6 = 1
            int r1 = r1 + r6
            androidx.constraintlayout.core.motion.MotionPaths r6 = r0.f3680n
            r3[r1] = r6
            java.util.ArrayList<androidx.constraintlayout.core.motion.MotionPaths> r1 = r0.E
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0261
            int r1 = r0.f3678l
            int r6 = androidx.constraintlayout.core.motion.key.MotionKey.f3721m
            if (r1 != r6) goto L_0x0261
            r0.f3678l = r7
        L_0x0261:
            java.util.ArrayList<androidx.constraintlayout.core.motion.MotionPaths> r1 = r0.E
            java.util.Iterator r1 = r1.iterator()
            r6 = 1
        L_0x0268:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x027a
            java.lang.Object r7 = r1.next()
            androidx.constraintlayout.core.motion.MotionPaths r7 = (androidx.constraintlayout.core.motion.MotionPaths) r7
            int r8 = r6 + 1
            r3[r6] = r7
            r6 = r8
            goto L_0x0268
        L_0x027a:
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            androidx.constraintlayout.core.motion.MotionPaths r6 = r0.f3680n
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.CustomVariable> r6 = r6.h3
            java.util.Set r6 = r6.keySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x028b:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x02ba
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            androidx.constraintlayout.core.motion.MotionPaths r8 = r0.f3679m
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.CustomVariable> r8 = r8.h3
            boolean r8 = r8.containsKey(r7)
            if (r8 == 0) goto L_0x028b
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r12)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            boolean r8 = r4.contains(r8)
            if (r8 != 0) goto L_0x028b
            r1.add(r7)
            goto L_0x028b
        L_0x02ba:
            r7 = 0
            java.lang.String[] r4 = new java.lang.String[r7]
            java.lang.Object[] r1 = r1.toArray(r4)
            java.lang.String[] r1 = (java.lang.String[]) r1
            r0.A = r1
            int r1 = r1.length
            int[] r1 = new int[r1]
            r0.B = r1
            r1 = 0
        L_0x02cb:
            java.lang.String[] r4 = r0.A
            int r6 = r4.length
            if (r1 >= r6) goto L_0x0302
            r4 = r4[r1]
            int[] r6 = r0.B
            r7 = 0
            r6[r1] = r7
            r6 = 0
        L_0x02d8:
            if (r6 >= r2) goto L_0x02ff
            r7 = r3[r6]
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.CustomVariable> r7 = r7.h3
            boolean r7 = r7.containsKey(r4)
            if (r7 == 0) goto L_0x02fc
            r7 = r3[r6]
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.CustomVariable> r7 = r7.h3
            java.lang.Object r7 = r7.get(r4)
            androidx.constraintlayout.core.motion.CustomVariable r7 = (androidx.constraintlayout.core.motion.CustomVariable) r7
            if (r7 == 0) goto L_0x02fc
            int[] r4 = r0.B
            r6 = r4[r1]
            int r7 = r7.r()
            int r6 = r6 + r7
            r4[r1] = r6
            goto L_0x02ff
        L_0x02fc:
            int r6 = r6 + 1
            goto L_0x02d8
        L_0x02ff:
            int r1 = r1 + 1
            goto L_0x02cb
        L_0x0302:
            r1 = 0
            r6 = r3[r1]
            int r1 = r6.d3
            r6 = -1
            if (r1 == r6) goto L_0x030c
            r1 = 1
            goto L_0x030d
        L_0x030c:
            r1 = 0
        L_0x030d:
            int r4 = r4.length
            r6 = 18
            int r6 = r6 + r4
            boolean[] r4 = new boolean[r6]
            r7 = 1
        L_0x0314:
            if (r7 >= r2) goto L_0x0324
            r8 = r3[r7]
            int r9 = r7 + -1
            r9 = r3[r9]
            java.lang.String[] r10 = r0.A
            r8.f(r9, r4, r10, r1)
            int r7 = r7 + 1
            goto L_0x0314
        L_0x0324:
            r1 = 1
            r7 = 0
        L_0x0326:
            if (r1 >= r6) goto L_0x0331
            boolean r8 = r4[r1]
            if (r8 == 0) goto L_0x032e
            int r7 = r7 + 1
        L_0x032e:
            int r1 = r1 + 1
            goto L_0x0326
        L_0x0331:
            int[] r1 = new int[r7]
            r0.x = r1
            r1 = 2
            int r7 = java.lang.Math.max(r1, r7)
            double[] r8 = new double[r7]
            r0.y = r8
            double[] r7 = new double[r7]
            r0.z = r7
            r7 = 1
            r8 = 0
        L_0x0344:
            if (r7 >= r6) goto L_0x0354
            boolean r9 = r4[r7]
            if (r9 == 0) goto L_0x0351
            int[] r9 = r0.x
            int r10 = r8 + 1
            r9[r8] = r7
            r8 = r10
        L_0x0351:
            int r7 = r7 + 1
            goto L_0x0344
        L_0x0354:
            int[] r4 = r0.x
            int r4 = r4.length
            int[] r6 = new int[r1]
            r7 = 1
            r6[r7] = r4
            r4 = 0
            r6[r4] = r2
            java.lang.Class r4 = java.lang.Double.TYPE
            java.lang.Object r4 = java.lang.reflect.Array.newInstance(r4, r6)
            double[][] r4 = (double[][]) r4
            double[] r6 = new double[r2]
            r7 = 0
        L_0x036a:
            if (r7 >= r2) goto L_0x037f
            r8 = r3[r7]
            r9 = r4[r7]
            int[] r10 = r0.x
            r8.g(r9, r10)
            r8 = r3[r7]
            float r8 = r8.Y
            double r8 = (double) r8
            r6[r7] = r8
            int r7 = r7 + 1
            goto L_0x036a
        L_0x037f:
            r7 = 0
        L_0x0380:
            int[] r8 = r0.x
            int r9 = r8.length
            if (r7 >= r9) goto L_0x03c2
            r8 = r8[r7]
            java.lang.String[] r9 = androidx.constraintlayout.core.motion.MotionPaths.y3
            int r9 = r9.length
            if (r8 >= r9) goto L_0x03bf
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String[] r9 = androidx.constraintlayout.core.motion.MotionPaths.y3
            int[] r10 = r0.x
            r10 = r10[r7]
            r9 = r9[r10]
            r8.append(r9)
            java.lang.String r9 = " ["
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r9 = r8
            r8 = 0
        L_0x03a7:
            if (r8 >= r2) goto L_0x03bf
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r9)
            r9 = r4[r8]
            r11 = r9[r7]
            r10.append(r11)
            java.lang.String r9 = r10.toString()
            int r8 = r8 + 1
            goto L_0x03a7
        L_0x03bf:
            int r7 = r7 + 1
            goto L_0x0380
        L_0x03c2:
            java.lang.String[] r7 = r0.A
            int r7 = r7.length
            r8 = 1
            int r7 = r7 + r8
            androidx.constraintlayout.core.motion.utils.CurveFit[] r7 = new androidx.constraintlayout.core.motion.utils.CurveFit[r7]
            r0.q = r7
            r7 = 0
        L_0x03cc:
            java.lang.String[] r8 = r0.A
            int r9 = r8.length
            if (r7 >= r9) goto L_0x0432
            r8 = r8[r7]
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
        L_0x03d7:
            if (r9 >= r2) goto L_0x0416
            r13 = r3[r9]
            boolean r13 = r13.o(r8)
            if (r13 == 0) goto L_0x040e
            if (r12 != 0) goto L_0x03fc
            double[] r11 = new double[r2]
            r12 = r3[r9]
            int r12 = r12.m(r8)
            int[] r13 = new int[r1]
            r14 = 1
            r13[r14] = r12
            r14 = 0
            r13[r14] = r2
            java.lang.Class r12 = java.lang.Double.TYPE
            java.lang.Object r12 = java.lang.reflect.Array.newInstance(r12, r13)
            double[][] r12 = (double[][]) r12
            goto L_0x03fd
        L_0x03fc:
            r14 = 0
        L_0x03fd:
            r13 = r3[r9]
            float r15 = r13.Y
            r23 = r2
            double r1 = (double) r15
            r11[r10] = r1
            r1 = r12[r10]
            r13.l(r8, r1, r14)
            int r10 = r10 + 1
            goto L_0x0410
        L_0x040e:
            r23 = r2
        L_0x0410:
            int r9 = r9 + 1
            r2 = r23
            r1 = 2
            goto L_0x03d7
        L_0x0416:
            r23 = r2
            double[] r1 = java.util.Arrays.copyOf(r11, r10)
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r12, r10)
            double[][] r2 = (double[][]) r2
            androidx.constraintlayout.core.motion.utils.CurveFit[] r8 = r0.q
            int r7 = r7 + 1
            int r9 = r0.f3678l
            androidx.constraintlayout.core.motion.utils.CurveFit r1 = androidx.constraintlayout.core.motion.utils.CurveFit.a(r9, r1, r2)
            r8[r7] = r1
            r2 = r23
            r1 = 2
            goto L_0x03cc
        L_0x0432:
            r23 = r2
            androidx.constraintlayout.core.motion.utils.CurveFit[] r1 = r0.q
            int r2 = r0.f3678l
            androidx.constraintlayout.core.motion.utils.CurveFit r2 = androidx.constraintlayout.core.motion.utils.CurveFit.a(r2, r6, r4)
            r4 = 0
            r1[r4] = r2
            r1 = r3[r4]
            int r1 = r1.d3
            r2 = -1
            if (r1 == r2) goto L_0x0481
            r1 = r23
            int[] r2 = new int[r1]
            double[] r6 = new double[r1]
            r7 = 2
            int[] r8 = new int[r7]
            r9 = 1
            r8[r9] = r7
            r8[r4] = r1
            java.lang.Class r4 = java.lang.Double.TYPE
            java.lang.Object r4 = java.lang.reflect.Array.newInstance(r4, r8)
            double[][] r4 = (double[][]) r4
            r9 = 0
        L_0x045d:
            if (r9 >= r1) goto L_0x047b
            r7 = r3[r9]
            int r8 = r7.d3
            r2[r9] = r8
            float r8 = r7.Y
            double r10 = (double) r8
            r6[r9] = r10
            r8 = r4[r9]
            float r10 = r7.X2
            double r10 = (double) r10
            r12 = 0
            r8[r12] = r10
            float r7 = r7.Y2
            double r10 = (double) r7
            r7 = 1
            r8[r7] = r10
            int r9 = r9 + 1
            goto L_0x045d
        L_0x047b:
            androidx.constraintlayout.core.motion.utils.CurveFit r1 = androidx.constraintlayout.core.motion.utils.CurveFit.b(r2, r6, r4)
            r0.r = r1
        L_0x0481:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r0.J = r1
            java.util.ArrayList<androidx.constraintlayout.core.motion.key.MotionKey> r1 = r0.G
            if (r1 == 0) goto L_0x04f6
            java.util.Iterator r1 = r5.iterator()
            r2 = 2143289344(0x7fc00000, float:NaN)
        L_0x0492:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x04be
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            androidx.constraintlayout.core.motion.utils.KeyCycleOscillator r4 = androidx.constraintlayout.core.motion.utils.KeyCycleOscillator.d(r3)
            if (r4 != 0) goto L_0x04a5
            goto L_0x0492
        L_0x04a5:
            boolean r5 = r4.k()
            if (r5 == 0) goto L_0x04b5
            boolean r5 = java.lang.Float.isNaN(r2)
            if (r5 == 0) goto L_0x04b5
            float r2 = r19.I()
        L_0x04b5:
            r4.i(r3)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.KeyCycleOscillator> r5 = r0.J
            r5.put(r3, r4)
            goto L_0x0492
        L_0x04be:
            java.util.ArrayList<androidx.constraintlayout.core.motion.key.MotionKey> r1 = r0.G
            java.util.Iterator r1 = r1.iterator()
        L_0x04c4:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x04dc
            java.lang.Object r3 = r1.next()
            androidx.constraintlayout.core.motion.key.MotionKey r3 = (androidx.constraintlayout.core.motion.key.MotionKey) r3
            boolean r4 = r3 instanceof androidx.constraintlayout.core.motion.key.MotionKeyCycle
            if (r4 == 0) goto L_0x04c4
            androidx.constraintlayout.core.motion.key.MotionKeyCycle r3 = (androidx.constraintlayout.core.motion.key.MotionKeyCycle) r3
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.KeyCycleOscillator> r4 = r0.J
            r3.v(r4)
            goto L_0x04c4
        L_0x04dc:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.KeyCycleOscillator> r1 = r0.J
            java.util.Collection r1 = r1.values()
            java.util.Iterator r1 = r1.iterator()
        L_0x04e6:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x04f6
            java.lang.Object r3 = r1.next()
            androidx.constraintlayout.core.motion.utils.KeyCycleOscillator r3 = (androidx.constraintlayout.core.motion.utils.KeyCycleOscillator) r3
            r3.j(r2)
            goto L_0x04e6
        L_0x04f6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.Motion.d0(int, int, float, long):void");
    }

    public int e(String str) {
        return 0;
    }

    public void e0(Motion motion) {
        this.f3679m.x(motion, motion.f3679m);
        this.f3680n.x(motion, motion.f3680n);
    }

    public void f(MotionKey motionKey) {
        this.G.add(motionKey);
    }

    /* access modifiers changed from: package-private */
    public void g(ArrayList<MotionKey> arrayList) {
        this.G.addAll(arrayList);
    }

    /* access modifiers changed from: package-private */
    public void h(float[] fArr, int i2) {
        int i3 = i2;
        float f2 = 1.0f / ((float) (i3 - 1));
        HashMap<String, SplineSet> hashMap = this.I;
        if (hashMap != null) {
            SplineSet splineSet = hashMap.get("translationX");
        }
        HashMap<String, SplineSet> hashMap2 = this.I;
        if (hashMap2 != null) {
            SplineSet splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> hashMap3 = this.J;
        if (hashMap3 != null) {
            KeyCycleOscillator keyCycleOscillator = hashMap3.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> hashMap4 = this.J;
        if (hashMap4 != null) {
            KeyCycleOscillator keyCycleOscillator2 = hashMap4.get("translationY");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            float f3 = ((float) i4) * f2;
            float f4 = this.u;
            float f5 = 0.0f;
            if (f4 != 1.0f) {
                float f6 = this.t;
                if (f3 < f6) {
                    f3 = 0.0f;
                }
                if (f3 > f6 && ((double) f3) < 1.0d) {
                    f3 = Math.min((f3 - f6) * f4, 1.0f);
                }
            }
            double d2 = (double) f3;
            Easing easing = this.f3679m.s;
            Iterator<MotionPaths> it2 = this.E.iterator();
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
            this.q[0].d(d2, this.y);
            CurveFit curveFit = this.r;
            if (curveFit != null) {
                double[] dArr = this.y;
                if (dArr.length > 0) {
                    curveFit.d(d2, dArr);
                }
            }
            this.f3679m.h(this.x, this.y, fArr, i4 * 2);
        }
    }

    /* access modifiers changed from: package-private */
    public int i(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] h2 = this.q[0].h();
        if (iArr != null) {
            Iterator<MotionPaths> it2 = this.E.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                iArr[i2] = it2.next().i3;
                i2++;
            }
        }
        int i3 = 0;
        for (double d2 : h2) {
            this.q[0].d(d2, this.y);
            this.f3679m.h(this.x, this.y, fArr, i3);
            i3 += 2;
        }
        return i3 / 2;
    }

    public int j(float[] fArr, int[] iArr, int[] iArr2) {
        if (fArr == null) {
            return 0;
        }
        double[] h2 = this.q[0].h();
        if (iArr != null) {
            Iterator<MotionPaths> it2 = this.E.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                iArr[i2] = it2.next().i3;
                i2++;
            }
        }
        if (iArr2 != null) {
            Iterator<MotionPaths> it3 = this.E.iterator();
            int i3 = 0;
            while (it3.hasNext()) {
                iArr2[i3] = (int) (it3.next().Z * 100.0f);
                i3++;
            }
        }
        int i4 = 0;
        for (int i5 = 0; i5 < h2.length; i5++) {
            this.q[0].d(h2[i5], this.y);
            this.f3679m.i(h2[i5], this.x, this.y, fArr, i4);
            i4 += 2;
        }
        return i4 / 2;
    }

    public void k(float[] fArr, int i2) {
        double d2;
        int i3 = i2;
        float f2 = 1.0f;
        float f3 = 1.0f / ((float) (i3 - 1));
        HashMap<String, SplineSet> hashMap = this.I;
        KeyCycleOscillator keyCycleOscillator = null;
        SplineSet splineSet = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, SplineSet> hashMap2 = this.I;
        SplineSet splineSet2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, KeyCycleOscillator> hashMap3 = this.J;
        KeyCycleOscillator keyCycleOscillator2 = hashMap3 == null ? null : hashMap3.get("translationX");
        HashMap<String, KeyCycleOscillator> hashMap4 = this.J;
        if (hashMap4 != null) {
            keyCycleOscillator = hashMap4.get("translationY");
        }
        KeyCycleOscillator keyCycleOscillator3 = keyCycleOscillator;
        int i4 = 0;
        while (i4 < i3) {
            float f4 = ((float) i4) * f3;
            float f5 = this.u;
            float f6 = 0.0f;
            if (f5 != f2) {
                float f7 = this.t;
                if (f4 < f7) {
                    f4 = 0.0f;
                }
                if (f4 > f7 && ((double) f4) < 1.0d) {
                    f4 = Math.min((f4 - f7) * f5, f2);
                }
            }
            float f8 = f4;
            double d3 = (double) f8;
            Easing easing = this.f3679m.s;
            Iterator<MotionPaths> it2 = this.E.iterator();
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
            this.q[0].d(d2, this.y);
            CurveFit curveFit = this.r;
            if (curveFit != null) {
                double[] dArr = this.y;
                if (dArr.length > 0) {
                    curveFit.d(d2, dArr);
                }
            }
            int i5 = i4 * 2;
            float f12 = f8;
            int i6 = i4;
            this.f3679m.i(d2, this.x, this.y, fArr, i5);
            if (keyCycleOscillator2 != null) {
                fArr[i5] = fArr[i5] + keyCycleOscillator2.a(f12);
            } else if (splineSet != null) {
                fArr[i5] = fArr[i5] + splineSet.a(f12);
            }
            if (keyCycleOscillator3 != null) {
                int i7 = i5 + 1;
                fArr[i7] = fArr[i7] + keyCycleOscillator3.a(f12);
            } else if (splineSet2 != null) {
                int i8 = i5 + 1;
                fArr[i8] = fArr[i8] + splineSet2.a(f12);
            }
            i4 = i6 + 1;
            f2 = 1.0f;
        }
    }

    public void l(float f2, float[] fArr, int i2) {
        this.q[0].d((double) o(f2, (float[]) null), this.y);
        this.f3679m.n(this.x, this.y, fArr, i2);
    }

    /* access modifiers changed from: package-private */
    public void m(float[] fArr, int i2) {
        float f2 = 1.0f / ((float) (i2 - 1));
        for (int i3 = 0; i3 < i2; i3++) {
            this.q[0].d((double) o(((float) i3) * f2, (float[]) null), this.y);
            this.f3679m.n(this.x, this.y, fArr, i3 * 8);
        }
    }

    /* access modifiers changed from: package-private */
    public void n(boolean z2) {
    }

    public int p() {
        return this.f3679m.e3;
    }

    /* access modifiers changed from: package-private */
    public int q(String str, float[] fArr, int i2) {
        SplineSet splineSet = this.I.get(str);
        if (splineSet == null) {
            return -1;
        }
        for (int i3 = 0; i3 < fArr.length; i3++) {
            fArr[i3] = splineSet.a((float) (i3 / (fArr.length - 1)));
        }
        return fArr.length;
    }

    public void r(double d2, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.q[0].d(d2, dArr);
        this.q[0].g(d2, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.f3679m.j(d2, this.x, dArr, fArr, dArr2, fArr2);
    }

    public float s() {
        return this.v;
    }

    public float t() {
        return this.w;
    }

    public String toString() {
        return " start: x: " + this.f3679m.X2 + " y: " + this.f3679m.Y2 + " end: x: " + this.f3680n.X2 + " y: " + this.f3680n.Y2;
    }

    /* access modifiers changed from: package-private */
    public void u(float f2, float f3, float f4, float[] fArr) {
        double[] dArr;
        float o2 = o(f2, this.F);
        CurveFit[] curveFitArr = this.q;
        int i2 = 0;
        if (curveFitArr != null) {
            double d2 = (double) o2;
            curveFitArr[0].g(d2, this.z);
            this.q[0].d(d2, this.y);
            float f5 = this.F[0];
            while (true) {
                dArr = this.z;
                if (i2 >= dArr.length) {
                    break;
                }
                dArr[i2] = dArr[i2] * ((double) f5);
                i2++;
            }
            CurveFit curveFit = this.r;
            if (curveFit != null) {
                double[] dArr2 = this.y;
                if (dArr2.length > 0) {
                    curveFit.d(d2, dArr2);
                    this.r.g(d2, this.z);
                    this.f3679m.v(f3, f4, fArr, this.x, this.z, this.y);
                    return;
                }
                return;
            }
            this.f3679m.v(f3, f4, fArr, this.x, dArr, this.y);
            return;
        }
        MotionPaths motionPaths = this.f3680n;
        float f6 = motionPaths.X2;
        MotionPaths motionPaths2 = this.f3679m;
        float f7 = f6 - motionPaths2.X2;
        float f8 = motionPaths.Y2 - motionPaths2.Y2;
        float f9 = (motionPaths.Z2 - motionPaths2.Z2) + f7;
        float f10 = (motionPaths.a3 - motionPaths2.a3) + f8;
        fArr[0] = (f7 * (1.0f - f3)) + (f9 * f3);
        fArr[1] = (f8 * (1.0f - f4)) + (f10 * f4);
    }

    public int v() {
        int i2 = this.f3679m.X;
        Iterator<MotionPaths> it2 = this.E.iterator();
        while (it2.hasNext()) {
            i2 = Math.max(i2, it2.next().X);
        }
        return Math.max(i2, this.f3680n.X);
    }

    public float w() {
        return this.f3680n.a3;
    }

    public float x() {
        return this.f3680n.Z2;
    }

    public float y() {
        return this.f3680n.X2;
    }

    public float z() {
        return this.f3680n.Y2;
    }
}
