package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.state.WidgetFrame;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

public abstract class SplineSet {

    /* renamed from: f  reason: collision with root package name */
    private static final String f3859f = "SplineSet";

    /* renamed from: a  reason: collision with root package name */
    protected CurveFit f3860a;

    /* renamed from: b  reason: collision with root package name */
    protected int[] f3861b = new int[10];

    /* renamed from: c  reason: collision with root package name */
    protected float[] f3862c = new float[10];

    /* renamed from: d  reason: collision with root package name */
    private int f3863d;

    /* renamed from: e  reason: collision with root package name */
    private String f3864e;

    private static class CoreSpline extends SplineSet {

        /* renamed from: g  reason: collision with root package name */
        String f3865g;

        /* renamed from: h  reason: collision with root package name */
        long f3866h;

        public CoreSpline(String str, long j2) {
            this.f3865g = str;
            this.f3866h = j2;
        }

        public void h(TypedValues typedValues, float f2) {
            typedValues.b(typedValues.e(this.f3865g), a(f2));
        }
    }

    public static class CustomSet extends SplineSet {

        /* renamed from: g  reason: collision with root package name */
        String f3867g;

        /* renamed from: h  reason: collision with root package name */
        KeyFrameArray.CustomArray f3868h;

        /* renamed from: i  reason: collision with root package name */
        float[] f3869i;

        public CustomSet(String str, KeyFrameArray.CustomArray customArray) {
            this.f3867g = str.split(",")[1];
            this.f3868h = customArray;
        }

        public void g(int i2, float f2) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void j(int i2) {
            int f2 = this.f3868h.f();
            int h2 = this.f3868h.g(0).h();
            double[] dArr = new double[f2];
            this.f3869i = new float[h2];
            int[] iArr = new int[2];
            iArr[1] = h2;
            iArr[0] = f2;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i3 = 0; i3 < f2; i3++) {
                int d2 = this.f3868h.d(i3);
                CustomAttribute g2 = this.f3868h.g(i3);
                dArr[i3] = ((double) d2) * 0.01d;
                g2.e(this.f3869i);
                int i4 = 0;
                while (true) {
                    float[] fArr = this.f3869i;
                    if (i4 >= fArr.length) {
                        break;
                    }
                    dArr2[i3][i4] = (double) fArr[i4];
                    i4++;
                }
            }
            this.f3860a = CurveFit.a(i2, dArr, dArr2);
        }

        public void k(int i2, CustomAttribute customAttribute) {
            this.f3868h.a(i2, customAttribute);
        }

        public void l(WidgetFrame widgetFrame, float f2) {
            this.f3860a.e((double) f2, this.f3869i);
            widgetFrame.z(this.f3868h.g(0), this.f3869i);
        }
    }

    public static class CustomSpline extends SplineSet {

        /* renamed from: g  reason: collision with root package name */
        String f3870g;

        /* renamed from: h  reason: collision with root package name */
        KeyFrameArray.CustomVar f3871h;

        /* renamed from: i  reason: collision with root package name */
        float[] f3872i;

        public CustomSpline(String str, KeyFrameArray.CustomVar customVar) {
            this.f3870g = str.split(",")[1];
            this.f3871h = customVar;
        }

        public void g(int i2, float f2) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void h(TypedValues typedValues, float f2) {
            l((MotionWidget) typedValues, f2);
        }

        public void j(int i2) {
            int f2 = this.f3871h.f();
            int r = this.f3871h.g(0).r();
            double[] dArr = new double[f2];
            this.f3872i = new float[r];
            int[] iArr = new int[2];
            iArr[1] = r;
            iArr[0] = f2;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i3 = 0; i3 < f2; i3++) {
                int d2 = this.f3871h.d(i3);
                CustomVariable g2 = this.f3871h.g(i3);
                dArr[i3] = ((double) d2) * 0.01d;
                g2.o(this.f3872i);
                int i4 = 0;
                while (true) {
                    float[] fArr = this.f3872i;
                    if (i4 >= fArr.length) {
                        break;
                    }
                    dArr2[i3][i4] = (double) fArr[i4];
                    i4++;
                }
            }
            this.f3860a = CurveFit.a(i2, dArr, dArr2);
        }

        public void k(int i2, CustomVariable customVariable) {
            this.f3871h.a(i2, customVariable);
        }

        public void l(MotionWidget motionWidget, float f2) {
            this.f3860a.e((double) f2, this.f3872i);
            this.f3871h.g(0).w(motionWidget, this.f3872i);
        }
    }

    private static class Sort {
        private Sort() {
        }

        static void a(int[] iArr, float[] fArr, int i2, int i3) {
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

        private static int b(int[] iArr, float[] fArr, int i2, int i3) {
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

        private static void c(int[] iArr, float[] fArr, int i2, int i3) {
            int i4 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i4;
            float f2 = fArr[i2];
            fArr[i2] = fArr[i3];
            fArr[i3] = f2;
        }
    }

    public static SplineSet d(String str, KeyFrameArray.CustomArray customArray) {
        return new CustomSet(str, customArray);
    }

    public static SplineSet e(String str, KeyFrameArray.CustomVar customVar) {
        return new CustomSpline(str, customVar);
    }

    public static SplineSet f(String str, long j2) {
        return new CoreSpline(str, j2);
    }

    public float a(float f2) {
        return (float) this.f3860a.c((double) f2, 0);
    }

    public CurveFit b() {
        return this.f3860a;
    }

    public float c(float f2) {
        return (float) this.f3860a.f((double) f2, 0);
    }

    public void g(int i2, float f2) {
        int[] iArr = this.f3861b;
        if (iArr.length < this.f3863d + 1) {
            this.f3861b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f3862c;
            this.f3862c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f3861b;
        int i3 = this.f3863d;
        iArr2[i3] = i2;
        this.f3862c[i3] = f2;
        this.f3863d = i3 + 1;
    }

    public void h(TypedValues typedValues, float f2) {
        typedValues.b(a.a(this.f3864e), a(f2));
    }

    public void i(String str) {
        this.f3864e = str;
    }

    public void j(int i2) {
        int i3 = this.f3863d;
        if (i3 != 0) {
            Sort.a(this.f3861b, this.f3862c, 0, i3 - 1);
            int i4 = 1;
            for (int i5 = 1; i5 < this.f3863d; i5++) {
                int[] iArr = this.f3861b;
                if (iArr[i5 - 1] != iArr[i5]) {
                    i4++;
                }
            }
            double[] dArr = new double[i4];
            int[] iArr2 = new int[2];
            iArr2[1] = 1;
            iArr2[0] = i4;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr2);
            int i6 = 0;
            for (int i7 = 0; i7 < this.f3863d; i7++) {
                if (i7 > 0) {
                    int[] iArr3 = this.f3861b;
                    if (iArr3[i7] == iArr3[i7 - 1]) {
                    }
                }
                dArr[i6] = ((double) this.f3861b[i7]) * 0.01d;
                dArr2[i6][0] = (double) this.f3862c[i7];
                i6++;
            }
            this.f3860a = CurveFit.a(i2, dArr, dArr2);
        }
    }

    public String toString() {
        String str = this.f3864e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i2 = 0; i2 < this.f3863d; i2++) {
            str = str + "[" + this.f3861b[i2] + " , " + decimalFormat.format((double) this.f3862c[i2]) + "] ";
        }
        return str;
    }
}
