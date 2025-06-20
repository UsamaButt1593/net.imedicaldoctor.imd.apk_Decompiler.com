package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.text.DecimalFormat;

public abstract class TimeCycleSplineSet {

    /* renamed from: k  reason: collision with root package name */
    private static final String f3899k = "SplineSet";

    /* renamed from: l  reason: collision with root package name */
    protected static final int f3900l = 0;

    /* renamed from: m  reason: collision with root package name */
    protected static final int f3901m = 1;

    /* renamed from: n  reason: collision with root package name */
    protected static final int f3902n = 2;
    protected static float o = 6.2831855f;

    /* renamed from: a  reason: collision with root package name */
    protected CurveFit f3903a;

    /* renamed from: b  reason: collision with root package name */
    protected int f3904b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected int[] f3905c = new int[10];

    /* renamed from: d  reason: collision with root package name */
    protected float[][] f3906d;

    /* renamed from: e  reason: collision with root package name */
    protected int f3907e;

    /* renamed from: f  reason: collision with root package name */
    protected String f3908f;

    /* renamed from: g  reason: collision with root package name */
    protected float[] f3909g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f3910h;

    /* renamed from: i  reason: collision with root package name */
    protected long f3911i;

    /* renamed from: j  reason: collision with root package name */
    protected float f3912j;

    public static class CustomSet extends TimeCycleSplineSet {
        String p;
        KeyFrameArray.CustomArray q;
        KeyFrameArray.FloatArray r = new KeyFrameArray.FloatArray();
        float[] s;
        float[] t;

        public CustomSet(String str, KeyFrameArray.CustomArray customArray) {
            this.p = str.split(",")[1];
            this.q = customArray;
        }

        public void c(int i2, float f2, float f3, int i3, float f4) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public void f(int i2) {
            int f2 = this.q.f();
            int h2 = this.q.g(0).h();
            double[] dArr = new double[f2];
            int i3 = h2 + 2;
            this.s = new float[i3];
            this.t = new float[h2];
            int[] iArr = new int[2];
            iArr[1] = i3;
            iArr[0] = f2;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i4 = 0; i4 < f2; i4++) {
                int d2 = this.q.d(i4);
                CustomAttribute g2 = this.q.g(i4);
                float[] g3 = this.r.g(i4);
                dArr[i4] = ((double) d2) * 0.01d;
                g2.e(this.s);
                int i5 = 0;
                while (true) {
                    float[] fArr = this.s;
                    if (i5 >= fArr.length) {
                        break;
                    }
                    dArr2[i4][i5] = (double) fArr[i5];
                    i5++;
                }
                double[] dArr3 = dArr2[i4];
                dArr3[h2] = (double) g3[0];
                dArr3[h2 + 1] = (double) g3[1];
            }
            this.f3903a = CurveFit.a(i2, dArr, dArr2);
        }

        public void g(int i2, CustomAttribute customAttribute, float f2, int i3, float f3) {
            this.q.a(i2, customAttribute);
            this.r.a(i2, new float[]{f2, f3});
            this.f3904b = Math.max(this.f3904b, i3);
        }

        public boolean h(MotionWidget motionWidget, float f2, long j2, KeyCache keyCache) {
            MotionWidget motionWidget2 = motionWidget;
            long j3 = j2;
            this.f3903a.e((double) f2, this.s);
            float[] fArr = this.s;
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            long j4 = j3 - this.f3911i;
            if (Float.isNaN(this.f3912j)) {
                float a2 = keyCache.a(motionWidget2, this.p, 0);
                this.f3912j = a2;
                if (Float.isNaN(a2)) {
                    this.f3912j = 0.0f;
                }
            }
            float f5 = (float) ((((double) this.f3912j) + ((((double) j4) * 1.0E-9d) * ((double) f3))) % 1.0d);
            this.f3912j = f5;
            this.f3911i = j3;
            float a3 = a(f5);
            this.f3910h = false;
            int i2 = 0;
            while (true) {
                float[] fArr2 = this.t;
                if (i2 >= fArr2.length) {
                    break;
                }
                boolean z = this.f3910h;
                float f6 = this.s[i2];
                this.f3910h = z | (((double) f6) != 0.0d);
                fArr2[i2] = (f6 * a3) + f4;
                i2++;
            }
            motionWidget2.M(this.q.g(0), this.t);
            if (f3 != 0.0f) {
                this.f3910h = true;
            }
            return this.f3910h;
        }
    }

    public static class CustomVarSet extends TimeCycleSplineSet {
        String p;
        KeyFrameArray.CustomVar q;
        KeyFrameArray.FloatArray r = new KeyFrameArray.FloatArray();
        float[] s;
        float[] t;

        public CustomVarSet(String str, KeyFrameArray.CustomVar customVar) {
            this.p = str.split(",")[1];
            this.q = customVar;
        }

        public void c(int i2, float f2, float f3, int i3, float f4) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public void f(int i2) {
            int f2 = this.q.f();
            int r2 = this.q.g(0).r();
            double[] dArr = new double[f2];
            int i3 = r2 + 2;
            this.s = new float[i3];
            this.t = new float[r2];
            int[] iArr = new int[2];
            iArr[1] = i3;
            iArr[0] = f2;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i4 = 0; i4 < f2; i4++) {
                int d2 = this.q.d(i4);
                CustomVariable g2 = this.q.g(i4);
                float[] g3 = this.r.g(i4);
                dArr[i4] = ((double) d2) * 0.01d;
                g2.o(this.s);
                int i5 = 0;
                while (true) {
                    float[] fArr = this.s;
                    if (i5 >= fArr.length) {
                        break;
                    }
                    dArr2[i4][i5] = (double) fArr[i5];
                    i5++;
                }
                double[] dArr3 = dArr2[i4];
                dArr3[r2] = (double) g3[0];
                dArr3[r2 + 1] = (double) g3[1];
            }
            this.f3903a = CurveFit.a(i2, dArr, dArr2);
        }

        public void g(int i2, CustomVariable customVariable, float f2, int i3, float f3) {
            this.q.a(i2, customVariable);
            this.r.a(i2, new float[]{f2, f3});
            this.f3904b = Math.max(this.f3904b, i3);
        }

        public boolean h(MotionWidget motionWidget, float f2, long j2, KeyCache keyCache) {
            MotionWidget motionWidget2 = motionWidget;
            long j3 = j2;
            this.f3903a.e((double) f2, this.s);
            float[] fArr = this.s;
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            long j4 = j3 - this.f3911i;
            if (Float.isNaN(this.f3912j)) {
                float a2 = keyCache.a(motionWidget2, this.p, 0);
                this.f3912j = a2;
                if (Float.isNaN(a2)) {
                    this.f3912j = 0.0f;
                }
            }
            float f5 = (float) ((((double) this.f3912j) + ((((double) j4) * 1.0E-9d) * ((double) f3))) % 1.0d);
            this.f3912j = f5;
            this.f3911i = j3;
            float a3 = a(f5);
            this.f3910h = false;
            int i2 = 0;
            while (true) {
                float[] fArr2 = this.t;
                if (i2 >= fArr2.length) {
                    break;
                }
                boolean z = this.f3910h;
                float f6 = this.s[i2];
                this.f3910h = z | (((double) f6) != 0.0d);
                fArr2[i2] = (f6 * a3) + f4;
                i2++;
            }
            this.q.g(0).w(motionWidget2, this.t);
            if (f3 != 0.0f) {
                this.f3910h = true;
            }
            return this.f3910h;
        }
    }

    protected static class Sort {
        protected Sort() {
        }

        static void a(int[] iArr, float[][] fArr, int i2, int i3) {
            int[] iArr2 = new int[(iArr.length + 10)];
            iArr2[0] = i3;
            iArr2[1] = i2;
            int i4 = 2;
            while (i4 > 0) {
                int i5 = iArr2[i4 - 1];
                int i6 = i4 - 2;
                int i7 = iArr2[i6];
                if (i5 < i7) {
                    int b2 = b(iArr, fArr, i5, i7);
                    iArr2[i6] = b2 - 1;
                    iArr2[i4 - 1] = i5;
                    int i8 = i4 + 1;
                    iArr2[i4] = i7;
                    i4 += 2;
                    iArr2[i8] = b2 + 1;
                } else {
                    i4 = i6;
                }
            }
        }

        private static int b(int[] iArr, float[][] fArr, int i2, int i3) {
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

        private static void c(int[] iArr, float[][] fArr, int i2, int i3) {
            int i4 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i4;
            float[] fArr2 = fArr[i2];
            fArr[i2] = fArr[i3];
            fArr[i3] = fArr2;
        }
    }

    public TimeCycleSplineSet() {
        int[] iArr = new int[2];
        iArr[1] = 3;
        iArr[0] = 10;
        this.f3906d = (float[][]) Array.newInstance(Float.TYPE, iArr);
        this.f3909g = new float[3];
        this.f3910h = false;
        this.f3912j = Float.NaN;
    }

    /* access modifiers changed from: protected */
    public float a(float f2) {
        float abs;
        switch (this.f3904b) {
            case 1:
                return Math.signum(f2 * o);
            case 2:
                abs = Math.abs(f2);
                break;
            case 3:
                return (((f2 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f2 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos((double) (f2 * o));
            case 6:
                float abs2 = 1.0f - Math.abs(((f2 * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin((double) (f2 * o));
        }
        return 1.0f - abs;
    }

    public CurveFit b() {
        return this.f3903a;
    }

    public void c(int i2, float f2, float f3, int i3, float f4) {
        int[] iArr = this.f3905c;
        int i4 = this.f3907e;
        iArr[i4] = i2;
        float[] fArr = this.f3906d[i4];
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f4;
        this.f3904b = Math.max(this.f3904b, i3);
        this.f3907e++;
    }

    /* access modifiers changed from: protected */
    public void d(long j2) {
        this.f3911i = j2;
    }

    public void e(String str) {
        this.f3908f = str;
    }

    public void f(int i2) {
        int i3 = this.f3907e;
        if (i3 == 0) {
            PrintStream printStream = System.err;
            printStream.println("Error no points added to " + this.f3908f);
            return;
        }
        Sort.a(this.f3905c, this.f3906d, 0, i3 - 1);
        int i4 = 1;
        int i5 = 0;
        while (true) {
            int[] iArr = this.f3905c;
            if (i4 >= iArr.length) {
                break;
            }
            if (iArr[i4] != iArr[i4 - 1]) {
                i5++;
            }
            i4++;
        }
        if (i5 == 0) {
            i5 = 1;
        }
        double[] dArr = new double[i5];
        int[] iArr2 = new int[2];
        iArr2[1] = 3;
        iArr2[0] = i5;
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr2);
        int i6 = 0;
        for (int i7 = 0; i7 < this.f3907e; i7++) {
            if (i7 > 0) {
                int[] iArr3 = this.f3905c;
                if (iArr3[i7] == iArr3[i7 - 1]) {
                }
            }
            dArr[i6] = ((double) this.f3905c[i7]) * 0.01d;
            double[] dArr3 = dArr2[i6];
            float[] fArr = this.f3906d[i7];
            dArr3[0] = (double) fArr[0];
            dArr3[1] = (double) fArr[1];
            dArr3[2] = (double) fArr[2];
            i6++;
        }
        this.f3903a = CurveFit.a(i2, dArr, dArr2);
    }

    public String toString() {
        String str = this.f3908f;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i2 = 0; i2 < this.f3907e; i2++) {
            str = str + "[" + this.f3905c[i2] + " , " + decimalFormat.format(this.f3906d[i2]) + "] ";
        }
        return str;
    }
}
