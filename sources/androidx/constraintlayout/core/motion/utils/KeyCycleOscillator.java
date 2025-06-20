package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.MotionWidget;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public abstract class KeyCycleOscillator {

    /* renamed from: h  reason: collision with root package name */
    private static final String f3786h = "KeyCycleOscillator";

    /* renamed from: a  reason: collision with root package name */
    private CurveFit f3787a;

    /* renamed from: b  reason: collision with root package name */
    private CycleOscillator f3788b;

    /* renamed from: c  reason: collision with root package name */
    private String f3789c;

    /* renamed from: d  reason: collision with root package name */
    private int f3790d = 0;

    /* renamed from: e  reason: collision with root package name */
    private String f3791e = null;

    /* renamed from: f  reason: collision with root package name */
    public int f3792f = 0;

    /* renamed from: g  reason: collision with root package name */
    ArrayList<WavePoint> f3793g = new ArrayList<>();

    private static class CoreSpline extends KeyCycleOscillator {

        /* renamed from: i  reason: collision with root package name */
        String f3794i;

        /* renamed from: j  reason: collision with root package name */
        int f3795j;

        public CoreSpline(String str) {
            this.f3794i = str;
            this.f3795j = c.a(str);
        }

        public void h(MotionWidget motionWidget, float f2) {
            motionWidget.b(this.f3795j, a(f2));
        }
    }

    static class CycleOscillator {
        static final int q = -1;
        private static final String r = "CycleOscillator";

        /* renamed from: a  reason: collision with root package name */
        private final int f3796a;

        /* renamed from: b  reason: collision with root package name */
        Oscillator f3797b;

        /* renamed from: c  reason: collision with root package name */
        private final int f3798c = 0;

        /* renamed from: d  reason: collision with root package name */
        private final int f3799d = 1;

        /* renamed from: e  reason: collision with root package name */
        private final int f3800e = 2;

        /* renamed from: f  reason: collision with root package name */
        float[] f3801f;

        /* renamed from: g  reason: collision with root package name */
        double[] f3802g;

        /* renamed from: h  reason: collision with root package name */
        float[] f3803h;

        /* renamed from: i  reason: collision with root package name */
        float[] f3804i;

        /* renamed from: j  reason: collision with root package name */
        float[] f3805j;

        /* renamed from: k  reason: collision with root package name */
        float[] f3806k;

        /* renamed from: l  reason: collision with root package name */
        int f3807l;

        /* renamed from: m  reason: collision with root package name */
        CurveFit f3808m;

        /* renamed from: n  reason: collision with root package name */
        double[] f3809n;
        double[] o;
        float p;

        CycleOscillator(int i2, String str, int i3, int i4) {
            Oscillator oscillator = new Oscillator();
            this.f3797b = oscillator;
            this.f3807l = i2;
            this.f3796a = i3;
            oscillator.g(i2, str);
            this.f3801f = new float[i4];
            this.f3802g = new double[i4];
            this.f3803h = new float[i4];
            this.f3804i = new float[i4];
            this.f3805j = new float[i4];
            this.f3806k = new float[i4];
        }

        public double a() {
            return this.f3809n[1];
        }

        public double b(float f2) {
            CurveFit curveFit = this.f3808m;
            if (curveFit != null) {
                double d2 = (double) f2;
                curveFit.g(d2, this.o);
                this.f3808m.d(d2, this.f3809n);
            } else {
                double[] dArr = this.o;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d3 = (double) f2;
            double e2 = this.f3797b.e(d3, this.f3809n[1]);
            double d4 = this.f3797b.d(d3, this.f3809n[1], this.o[1]);
            double[] dArr2 = this.o;
            return dArr2[0] + (e2 * dArr2[2]) + (d4 * this.f3809n[2]);
        }

        public double c(float f2) {
            CurveFit curveFit = this.f3808m;
            if (curveFit != null) {
                curveFit.d((double) f2, this.f3809n);
            } else {
                double[] dArr = this.f3809n;
                dArr[0] = (double) this.f3804i[0];
                dArr[1] = (double) this.f3805j[0];
                dArr[2] = (double) this.f3801f[0];
            }
            double[] dArr2 = this.f3809n;
            return dArr2[0] + (this.f3797b.e((double) f2, dArr2[1]) * this.f3809n[2]);
        }

        public void d(int i2, int i3, float f2, float f3, float f4, float f5) {
            this.f3802g[i2] = ((double) i3) / 100.0d;
            this.f3803h[i2] = f2;
            this.f3804i[i2] = f3;
            this.f3805j[i2] = f4;
            this.f3801f[i2] = f5;
        }

        public void e(float f2) {
            this.p = f2;
            int length = this.f3802g.length;
            int[] iArr = new int[2];
            iArr[1] = 3;
            iArr[0] = length;
            double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, iArr);
            float[] fArr = this.f3801f;
            this.f3809n = new double[(fArr.length + 2)];
            this.o = new double[(fArr.length + 2)];
            if (this.f3802g[0] > 0.0d) {
                this.f3797b.a(0.0d, this.f3803h[0]);
            }
            double[] dArr2 = this.f3802g;
            int length2 = dArr2.length - 1;
            if (dArr2[length2] < 1.0d) {
                this.f3797b.a(1.0d, this.f3803h[length2]);
            }
            for (int i2 = 0; i2 < dArr.length; i2++) {
                double[] dArr3 = dArr[i2];
                dArr3[0] = (double) this.f3804i[i2];
                dArr3[1] = (double) this.f3805j[i2];
                dArr3[2] = (double) this.f3801f[i2];
                this.f3797b.a(this.f3802g[i2], this.f3803h[i2]);
            }
            this.f3797b.f();
            double[] dArr4 = this.f3802g;
            this.f3808m = dArr4.length > 1 ? CurveFit.a(0, dArr4, dArr) : null;
        }
    }

    private static class IntDoubleSort {
        private IntDoubleSort() {
        }

        private static int a(int[] iArr, float[] fArr, int i2, int i3) {
            int i4 = iArr[i3];
            int i5 = i2;
            while (i2 < i3) {
                if (iArr[i2] <= i4) {
                    c(iArr, fArr, i5, i2);
                    i5++;
                }
                i2++;
            }
            c(iArr, fArr, i5, i3);
            return i5;
        }

        static void b(int[] iArr, float[] fArr, int i2, int i3) {
            int[] iArr2 = new int[(iArr.length + 10)];
            iArr2[0] = i3;
            iArr2[1] = i2;
            int i4 = 2;
            while (i4 > 0) {
                int i5 = iArr2[i4 - 1];
                int i6 = i4 - 2;
                int i7 = iArr2[i6];
                if (i5 < i7) {
                    int a2 = a(iArr, fArr, i5, i7);
                    iArr2[i6] = a2 - 1;
                    iArr2[i4 - 1] = i5;
                    int i8 = i4 + 1;
                    iArr2[i4] = i7;
                    i4 += 2;
                    iArr2[i8] = a2 + 1;
                } else {
                    i4 = i6;
                }
            }
        }

        private static void c(int[] iArr, float[] fArr, int i2, int i3) {
            int i4 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i4;
            float f2 = fArr[i2];
            fArr[i2] = fArr[i3];
            fArr[i3] = f2;
        }
    }

    private static class IntFloatFloatSort {
        private IntFloatFloatSort() {
        }

        private static int a(int[] iArr, float[] fArr, float[] fArr2, int i2, int i3) {
            int i4 = iArr[i3];
            int i5 = i2;
            while (i2 < i3) {
                if (iArr[i2] <= i4) {
                    c(iArr, fArr, fArr2, i5, i2);
                    i5++;
                }
                i2++;
            }
            c(iArr, fArr, fArr2, i5, i3);
            return i5;
        }

        static void b(int[] iArr, float[] fArr, float[] fArr2, int i2, int i3) {
            int[] iArr2 = new int[(iArr.length + 10)];
            iArr2[0] = i3;
            iArr2[1] = i2;
            int i4 = 2;
            while (i4 > 0) {
                int i5 = iArr2[i4 - 1];
                int i6 = i4 - 2;
                int i7 = iArr2[i6];
                if (i5 < i7) {
                    int a2 = a(iArr, fArr, fArr2, i5, i7);
                    iArr2[i6] = a2 - 1;
                    iArr2[i4 - 1] = i5;
                    int i8 = i4 + 1;
                    iArr2[i4] = i7;
                    i4 += 2;
                    iArr2[i8] = a2 + 1;
                } else {
                    i4 = i6;
                }
            }
        }

        private static void c(int[] iArr, float[] fArr, float[] fArr2, int i2, int i3) {
            int i4 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i4;
            float f2 = fArr[i2];
            fArr[i2] = fArr[i3];
            fArr[i3] = f2;
            float f3 = fArr2[i2];
            fArr2[i2] = fArr2[i3];
            fArr2[i3] = f3;
        }
    }

    public static class PathRotateSet extends KeyCycleOscillator {

        /* renamed from: i  reason: collision with root package name */
        String f3810i;

        /* renamed from: j  reason: collision with root package name */
        int f3811j;

        public PathRotateSet(String str) {
            this.f3810i = str;
            this.f3811j = c.a(str);
        }

        public void h(MotionWidget motionWidget, float f2) {
            motionWidget.b(this.f3811j, a(f2));
        }

        public void l(MotionWidget motionWidget, float f2, double d2, double d3) {
            motionWidget.R(a(f2) + ((float) Math.toDegrees(Math.atan2(d3, d2))));
        }
    }

    static class WavePoint {

        /* renamed from: a  reason: collision with root package name */
        int f3812a;

        /* renamed from: b  reason: collision with root package name */
        float f3813b;

        /* renamed from: c  reason: collision with root package name */
        float f3814c;

        /* renamed from: d  reason: collision with root package name */
        float f3815d;

        /* renamed from: e  reason: collision with root package name */
        float f3816e;

        public WavePoint(int i2, float f2, float f3, float f4, float f5) {
            this.f3812a = i2;
            this.f3813b = f5;
            this.f3814c = f3;
            this.f3815d = f2;
            this.f3816e = f4;
        }
    }

    public static KeyCycleOscillator d(String str) {
        return str.equals("pathRotate") ? new PathRotateSet(str) : new CoreSpline(str);
    }

    public float a(float f2) {
        return (float) this.f3788b.c(f2);
    }

    public CurveFit b() {
        return this.f3787a;
    }

    public float c(float f2) {
        return (float) this.f3788b.b(f2);
    }

    /* access modifiers changed from: protected */
    public void e(Object obj) {
    }

    public void f(int i2, int i3, String str, int i4, float f2, float f3, float f4, float f5) {
        int i5 = i4;
        this.f3793g.add(new WavePoint(i2, f2, f3, f4, f5));
        if (i5 != -1) {
            this.f3792f = i5;
        }
        this.f3790d = i3;
        this.f3791e = str;
    }

    public void g(int i2, int i3, String str, int i4, float f2, float f3, float f4, float f5, Object obj) {
        int i5 = i4;
        this.f3793g.add(new WavePoint(i2, f2, f3, f4, f5));
        if (i5 != -1) {
            this.f3792f = i5;
        }
        this.f3790d = i3;
        e(obj);
        this.f3791e = str;
    }

    public void h(MotionWidget motionWidget, float f2) {
    }

    public void i(String str) {
        this.f3789c = str;
    }

    public void j(float f2) {
        int size = this.f3793g.size();
        if (size != 0) {
            Collections.sort(this.f3793g, new Comparator<WavePoint>() {
                /* renamed from: a */
                public int compare(WavePoint wavePoint, WavePoint wavePoint2) {
                    return Integer.compare(wavePoint.f3812a, wavePoint2.f3812a);
                }
            });
            double[] dArr = new double[size];
            int[] iArr = new int[2];
            iArr[1] = 3;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            this.f3788b = new CycleOscillator(this.f3790d, this.f3791e, this.f3792f, size);
            Iterator<WavePoint> it2 = this.f3793g.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                WavePoint next = it2.next();
                float f3 = next.f3815d;
                dArr[i2] = ((double) f3) * 0.01d;
                double[] dArr3 = dArr2[i2];
                float f4 = next.f3813b;
                dArr3[0] = (double) f4;
                float f5 = next.f3814c;
                dArr3[1] = (double) f5;
                float f6 = next.f3816e;
                dArr3[2] = (double) f6;
                this.f3788b.d(i2, next.f3812a, f3, f5, f6, f4);
                i2++;
                dArr2 = dArr2;
            }
            double[][] dArr4 = dArr2;
            this.f3788b.e(f2);
            this.f3787a = CurveFit.a(0, dArr, dArr2);
        }
    }

    public boolean k() {
        return this.f3792f == 1;
    }

    public String toString() {
        String str = this.f3789c;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<WavePoint> it2 = this.f3793g.iterator();
        while (it2.hasNext()) {
            WavePoint next = it2.next();
            str = str + "[" + next.f3812a + " , " + decimalFormat.format((double) next.f3813b) + "] ";
        }
        return str;
    }
}
