package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.f;
import java.util.HashMap;
import java.util.HashSet;

public class MotionKeyPosition extends MotionKey {
    static final String L = "KeyPosition";
    protected static final float M = 20.0f;
    public static final int N = 2;
    public static final int O = 1;
    public static final int P = 0;
    static final int Q = 2;
    public int A;
    public int B;
    public float C;
    public float D;
    public float E;
    public float F;
    public float G;
    public float H;
    public int I;
    private float J;
    private float K;
    public int y;
    public String z = null;

    public MotionKeyPosition() {
        int i2 = MotionKey.f3721m;
        this.y = i2;
        this.A = i2;
        this.B = 0;
        this.C = Float.NaN;
        this.D = Float.NaN;
        this.E = Float.NaN;
        this.F = Float.NaN;
        this.G = Float.NaN;
        this.H = Float.NaN;
        this.I = 0;
        this.J = Float.NaN;
        this.K = Float.NaN;
        this.f3726k = 2;
    }

    private void v(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        float f8 = 0.0f;
        float f9 = Float.isNaN(this.E) ? 0.0f : this.E;
        float f10 = Float.isNaN(this.H) ? 0.0f : this.H;
        float f11 = Float.isNaN(this.F) ? 0.0f : this.F;
        if (!Float.isNaN(this.G)) {
            f8 = this.G;
        }
        this.J = (float) ((int) (f2 + (f9 * f6) + (f8 * f7)));
        this.K = (float) ((int) (f3 + (f6 * f10) + (f7 * f11)));
    }

    private void w(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        float f8 = this.E;
        float f9 = this.F;
        this.J = f2 + (f6 * f8) + ((-f7) * f9);
        this.K = f3 + (f7 * f8) + (f6 * f9);
    }

    private void y(int i2, int i3) {
        float f2 = this.E;
        float f3 = (float) 0;
        this.J = (((float) i2) * f2) + f3;
        this.K = (((float) i3) * f2) + f3;
    }

    /* access modifiers changed from: package-private */
    public float A() {
        return this.K;
    }

    public boolean B(int i2, int i3, FloatRect floatRect, FloatRect floatRect2, float f2, float f3) {
        x(i2, i3, floatRect.a(), floatRect.b(), floatRect2.a(), floatRect2.b());
        return Math.abs(f2 - this.J) < M && Math.abs(f3 - this.K) < M;
    }

    public void C(MotionWidget motionWidget, FloatRect floatRect, FloatRect floatRect2, float f2, float f3, String[] strArr, float[] fArr) {
        int i2 = this.I;
        if (i2 == 1) {
            E(floatRect, floatRect2, f2, f3, strArr, fArr);
        } else if (i2 != 2) {
            D(floatRect, floatRect2, f2, f3, strArr, fArr);
        } else {
            F(motionWidget, floatRect, floatRect2, f2, f3, strArr, fArr);
        }
    }

    /* access modifiers changed from: package-private */
    public void D(FloatRect floatRect, FloatRect floatRect2, float f2, float f3, String[] strArr, float[] fArr) {
        float a2 = floatRect.a();
        float b2 = floatRect.b();
        float a3 = floatRect2.a() - a2;
        float b3 = floatRect2.b() - b2;
        String str = strArr[0];
        if (str != null) {
            float f4 = (f2 - a2) / a3;
            if ("percentX".equals(str)) {
                fArr[0] = f4;
                fArr[1] = (f3 - b2) / b3;
                return;
            }
            fArr[1] = f4;
            fArr[0] = (f3 - b2) / b3;
            return;
        }
        strArr[0] = "percentX";
        fArr[0] = (f2 - a2) / a3;
        strArr[1] = "percentY";
        fArr[1] = (f3 - b2) / b3;
    }

    /* access modifiers changed from: package-private */
    public void E(FloatRect floatRect, FloatRect floatRect2, float f2, float f3, String[] strArr, float[] fArr) {
        float a2 = floatRect.a();
        float b2 = floatRect.b();
        float a3 = floatRect2.a() - a2;
        float b3 = floatRect2.b() - b2;
        float hypot = (float) Math.hypot((double) a3, (double) b3);
        if (((double) hypot) < 1.0E-4d) {
            System.out.println("distance ~ 0");
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f4 = a3 / hypot;
        float f5 = b3 / hypot;
        float f6 = f3 - b2;
        float f7 = f2 - a2;
        float f8 = ((f4 * f6) - (f7 * f5)) / hypot;
        float f9 = ((f4 * f7) + (f5 * f6)) / hypot;
        String str = strArr[0];
        if (str == null) {
            strArr[0] = "percentX";
            strArr[1] = "percentY";
            fArr[0] = f9;
            fArr[1] = f8;
        } else if ("percentX".equals(str)) {
            fArr[0] = f9;
            fArr[1] = f8;
        }
    }

    /* access modifiers changed from: package-private */
    public void F(MotionWidget motionWidget, FloatRect floatRect, FloatRect floatRect2, float f2, float f3, String[] strArr, float[] fArr) {
        floatRect.a();
        floatRect.b();
        floatRect2.a();
        floatRect2.b();
        MotionWidget n2 = motionWidget.n();
        int D2 = n2.D();
        int k2 = n2.k();
        String str = strArr[0];
        if (str != null) {
            float f4 = f2 / ((float) D2);
            if ("percentX".equals(str)) {
                fArr[0] = f4;
                fArr[1] = f3 / ((float) k2);
                return;
            }
            fArr[1] = f4;
            fArr[0] = f3 / ((float) k2);
            return;
        }
        strArr[0] = "percentX";
        fArr[0] = f2 / ((float) D2);
        strArr[1] = "percentY";
        fArr[1] = f3 / ((float) k2);
    }

    public boolean a(int i2, int i3) {
        if (i2 == 100) {
            this.f3723h = i3;
            return true;
        } else if (i2 == 508) {
            this.y = i3;
            return true;
        } else if (i2 != 510) {
            return super.a(i2, i3);
        } else {
            this.I = i3;
            return true;
        }
    }

    public boolean b(int i2, float f2) {
        switch (i2) {
            case 503:
                this.C = f2;
                return true;
            case 504:
                break;
            case 505:
                this.C = f2;
                break;
            case TypedValues.PositionType.f4023n /*506*/:
                this.E = f2;
                return true;
            case 507:
                this.F = f2;
                return true;
            default:
                return super.b(i2, f2);
        }
        this.D = f2;
        return true;
    }

    public boolean c(int i2, String str) {
        if (i2 != 501) {
            return super.c(i2, str);
        }
        this.z = str.toString();
        return true;
    }

    public int e(String str) {
        return f.a(str);
    }

    public void f(HashMap<String, SplineSet> hashMap) {
    }

    /* renamed from: g */
    public MotionKey clone() {
        return new MotionKeyPosition().h(this);
    }

    public MotionKey h(MotionKey motionKey) {
        super.h(motionKey);
        MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
        this.z = motionKeyPosition.z;
        this.A = motionKeyPosition.A;
        this.B = motionKeyPosition.B;
        this.C = motionKeyPosition.C;
        this.D = Float.NaN;
        this.E = motionKeyPosition.E;
        this.F = motionKeyPosition.F;
        this.G = motionKeyPosition.G;
        this.H = motionKeyPosition.H;
        this.J = motionKeyPosition.J;
        this.K = motionKeyPosition.K;
        return this;
    }

    public void i(HashSet<String> hashSet) {
    }

    /* access modifiers changed from: package-private */
    public void x(int i2, int i3, float f2, float f3, float f4, float f5) {
        int i4 = this.I;
        if (i4 == 1) {
            w(f2, f3, f4, f5);
        } else if (i4 != 2) {
            v(f2, f3, f4, f5);
        } else {
            y(i2, i3);
        }
    }

    /* access modifiers changed from: package-private */
    public float z() {
        return this.J;
    }
}
