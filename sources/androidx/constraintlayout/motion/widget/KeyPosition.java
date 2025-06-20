package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

public class KeyPosition extends KeyPositionBase {
    private static final String R = "KeyPosition";
    static final String S = "KeyPosition";
    public static final int T = 2;
    public static final int U = 1;
    public static final int V = 0;
    public static final String W = "transitionEasing";
    public static final String X = "drawPath";
    public static final String Y = "percentWidth";
    public static final String Z = "percentHeight";
    public static final String a0 = "sizePercent";
    public static final String b0 = "percentX";
    public static final String c0 = "percentY";
    static final int d0 = 2;
    String F = null;
    int G = Key.f4366f;
    int H = 0;
    float I = Float.NaN;
    float J = Float.NaN;
    float K = Float.NaN;
    float L = Float.NaN;
    float M = Float.NaN;
    float N = Float.NaN;
    int O = 0;
    private float P = Float.NaN;
    private float Q = Float.NaN;

    private static class Loader {

        /* renamed from: a  reason: collision with root package name */
        private static final int f4414a = 1;

        /* renamed from: b  reason: collision with root package name */
        private static final int f4415b = 2;

        /* renamed from: c  reason: collision with root package name */
        private static final int f4416c = 3;

        /* renamed from: d  reason: collision with root package name */
        private static final int f4417d = 4;

        /* renamed from: e  reason: collision with root package name */
        private static final int f4418e = 5;

        /* renamed from: f  reason: collision with root package name */
        private static final int f4419f = 6;

        /* renamed from: g  reason: collision with root package name */
        private static final int f4420g = 7;

        /* renamed from: h  reason: collision with root package name */
        private static final int f4421h = 8;

        /* renamed from: i  reason: collision with root package name */
        private static final int f4422i = 9;

        /* renamed from: j  reason: collision with root package name */
        private static final int f4423j = 10;

        /* renamed from: k  reason: collision with root package name */
        private static final int f4424k = 11;

        /* renamed from: l  reason: collision with root package name */
        private static final int f4425l = 12;

        /* renamed from: m  reason: collision with root package name */
        private static SparseIntArray f4426m;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f4426m = sparseIntArray;
            sparseIntArray.append(R.styleable.Hf, 1);
            f4426m.append(R.styleable.Ff, 2);
            f4426m.append(R.styleable.Of, 3);
            f4426m.append(R.styleable.Df, 4);
            f4426m.append(R.styleable.Ef, 5);
            f4426m.append(R.styleable.Lf, 6);
            f4426m.append(R.styleable.Mf, 7);
            f4426m.append(R.styleable.Gf, 9);
            f4426m.append(R.styleable.Nf, 8);
            f4426m.append(R.styleable.Kf, 11);
            f4426m.append(R.styleable.Jf, 12);
            f4426m.append(R.styleable.If, 10);
        }

        private Loader() {
        }

        /* access modifiers changed from: private */
        public static void b(KeyPosition keyPosition, TypedArray typedArray) {
            float f2;
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (f4426m.get(index)) {
                    case 1:
                        if (MotionLayout.p5) {
                            int resourceId = typedArray.getResourceId(index, keyPosition.f4376b);
                            keyPosition.f4376b = resourceId;
                            if (resourceId != -1) {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type != 3) {
                            keyPosition.f4376b = typedArray.getResourceId(index, keyPosition.f4376b);
                            continue;
                        }
                        keyPosition.f4377c = typedArray.getString(index);
                        break;
                    case 2:
                        keyPosition.f4375a = typedArray.getInt(index, keyPosition.f4375a);
                        continue;
                    case 3:
                        keyPosition.F = typedArray.peekValue(index).type == 3 ? typedArray.getString(index) : Easing.o[typedArray.getInteger(index, 0)];
                        continue;
                    case 4:
                        keyPosition.D = typedArray.getInteger(index, keyPosition.D);
                        continue;
                    case 5:
                        keyPosition.H = typedArray.getInt(index, keyPosition.H);
                        continue;
                    case 6:
                        keyPosition.K = typedArray.getFloat(index, keyPosition.K);
                        continue;
                    case 7:
                        keyPosition.L = typedArray.getFloat(index, keyPosition.L);
                        continue;
                    case 8:
                        f2 = typedArray.getFloat(index, keyPosition.J);
                        keyPosition.I = f2;
                        break;
                    case 9:
                        keyPosition.O = typedArray.getInt(index, keyPosition.O);
                        continue;
                    case 10:
                        keyPosition.G = typedArray.getInt(index, keyPosition.G);
                        continue;
                    case 11:
                        keyPosition.I = typedArray.getFloat(index, keyPosition.I);
                        continue;
                    case 12:
                        f2 = typedArray.getFloat(index, keyPosition.J);
                        break;
                    default:
                        Log.e(TypedValues.PositionType.f4010a, "unused attribute 0x" + Integer.toHexString(index) + "   " + f4426m.get(index));
                        continue;
                }
                keyPosition.J = f2;
            }
            if (keyPosition.f4375a == -1) {
                Log.e(TypedValues.PositionType.f4010a, "no frame position");
            }
        }
    }

    public KeyPosition() {
        this.f4378d = 2;
    }

    private void t(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        float f8 = 0.0f;
        float f9 = Float.isNaN(this.K) ? 0.0f : this.K;
        float f10 = Float.isNaN(this.N) ? 0.0f : this.N;
        float f11 = Float.isNaN(this.L) ? 0.0f : this.L;
        if (!Float.isNaN(this.M)) {
            f8 = this.M;
        }
        this.P = (float) ((int) (f2 + (f9 * f6) + (f8 * f7)));
        this.Q = (float) ((int) (f3 + (f6 * f10) + (f7 * f11)));
    }

    private void u(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        float f8 = this.K;
        float f9 = this.L;
        this.P = f2 + (f6 * f8) + ((-f7) * f9);
        this.Q = f3 + (f7 * f8) + (f6 * f9);
    }

    private void v(int i2, int i3) {
        float f2 = this.K;
        float f3 = (float) 0;
        this.P = (((float) i2) * f2) + f3;
        this.Q = (((float) i3) * f2) + f3;
    }

    public void a(HashMap<String, ViewSpline> hashMap) {
    }

    /* renamed from: b */
    public Key clone() {
        return new KeyPosition().c(this);
    }

    public Key c(Key key) {
        super.c(key);
        KeyPosition keyPosition = (KeyPosition) key;
        this.F = keyPosition.F;
        this.G = keyPosition.G;
        this.H = keyPosition.H;
        this.I = keyPosition.I;
        this.J = Float.NaN;
        this.K = keyPosition.K;
        this.L = keyPosition.L;
        this.M = keyPosition.M;
        this.N = keyPosition.N;
        this.P = keyPosition.P;
        this.Q = keyPosition.Q;
        return this;
    }

    public void f(Context context, AttributeSet attributeSet) {
        Loader.b(this, context.obtainStyledAttributes(attributeSet, R.styleable.Cf));
    }

    public void j(String str, Object obj) {
        float m2;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1127236479:
                if (str.equals("percentWidth")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1017587252:
                if (str.equals("percentHeight")) {
                    c2 = 2;
                    break;
                }
                break;
            case -827014263:
                if (str.equals("drawPath")) {
                    c2 = 3;
                    break;
                }
                break;
            case -200259324:
                if (str.equals("sizePercent")) {
                    c2 = 4;
                    break;
                }
                break;
            case 428090547:
                if (str.equals("percentX")) {
                    c2 = 5;
                    break;
                }
                break;
            case 428090548:
                if (str.equals("percentY")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.F = obj.toString();
                return;
            case 1:
                this.I = m(obj);
                return;
            case 2:
                m2 = m(obj);
                break;
            case 3:
                this.H = n(obj);
                return;
            case 4:
                m2 = m(obj);
                this.I = m2;
                break;
            case 5:
                this.K = m(obj);
                return;
            case 6:
                this.L = m(obj);
                return;
            default:
                return;
        }
        this.J = m2;
    }

    /* access modifiers changed from: package-private */
    public void o(int i2, int i3, float f2, float f3, float f4, float f5) {
        int i4 = this.O;
        if (i4 == 1) {
            u(f2, f3, f4, f5);
        } else if (i4 != 2) {
            t(f2, f3, f4, f5);
        } else {
            v(i2, i3);
        }
    }

    /* access modifiers changed from: package-private */
    public float p() {
        return this.P;
    }

    /* access modifiers changed from: package-private */
    public float q() {
        return this.Q;
    }

    public boolean r(int i2, int i3, RectF rectF, RectF rectF2, float f2, float f3) {
        o(i2, i3, rectF.centerX(), rectF.centerY(), rectF2.centerX(), rectF2.centerY());
        return Math.abs(f2 - this.P) < 20.0f && Math.abs(f3 - this.Q) < 20.0f;
    }

    public void s(View view, RectF rectF, RectF rectF2, float f2, float f3, String[] strArr, float[] fArr) {
        int i2 = this.O;
        if (i2 == 1) {
            x(rectF, rectF2, f2, f3, strArr, fArr);
        } else if (i2 != 2) {
            w(rectF, rectF2, f2, f3, strArr, fArr);
        } else {
            y(view, rectF, rectF2, f2, f3, strArr, fArr);
        }
    }

    /* access modifiers changed from: package-private */
    public void w(RectF rectF, RectF rectF2, float f2, float f3, String[] strArr, float[] fArr) {
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        float centerX2 = rectF2.centerX() - centerX;
        float centerY2 = rectF2.centerY() - centerY;
        String str = strArr[0];
        if (str != null) {
            float f4 = (f2 - centerX) / centerX2;
            if ("percentX".equals(str)) {
                fArr[0] = f4;
                fArr[1] = (f3 - centerY) / centerY2;
                return;
            }
            fArr[1] = f4;
            fArr[0] = (f3 - centerY) / centerY2;
            return;
        }
        strArr[0] = "percentX";
        fArr[0] = (f2 - centerX) / centerX2;
        strArr[1] = "percentY";
        fArr[1] = (f3 - centerY) / centerY2;
    }

    /* access modifiers changed from: package-private */
    public void x(RectF rectF, RectF rectF2, float f2, float f3, String[] strArr, float[] fArr) {
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        float centerX2 = rectF2.centerX() - centerX;
        float centerY2 = rectF2.centerY() - centerY;
        float hypot = (float) Math.hypot((double) centerX2, (double) centerY2);
        if (((double) hypot) < 1.0E-4d) {
            System.out.println("distance ~ 0");
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f4 = centerX2 / hypot;
        float f5 = centerY2 / hypot;
        float f6 = f3 - centerY;
        float f7 = f2 - centerX;
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
    public void y(View view, RectF rectF, RectF rectF2, float f2, float f3, String[] strArr, float[] fArr) {
        rectF.centerX();
        rectF.centerY();
        rectF2.centerX();
        rectF2.centerY();
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        String str = strArr[0];
        if (str != null) {
            float f4 = f2 / ((float) width);
            if ("percentX".equals(str)) {
                fArr[0] = f4;
                fArr[1] = f3 / ((float) height);
                return;
            }
            fArr[1] = f4;
            fArr[0] = f3 / ((float) height);
            return;
        }
        strArr[0] = "percentX";
        fArr[0] = f2 / ((float) width);
        strArr[1] = "percentY";
        fArr[1] = f3 / ((float) height);
    }

    public void z(int i2) {
        this.O = i2;
    }
}
