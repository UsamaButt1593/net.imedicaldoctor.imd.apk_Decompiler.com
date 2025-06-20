package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;

public class KeyCycle extends Key {
    private static final String X = "KeyCycle";
    static final String Y = "KeyCycle";
    public static final String Z = "wavePeriod";
    public static final String a0 = "waveOffset";
    public static final String b0 = "wavePhase";
    public static final String c0 = "waveShape";
    public static final int d0 = 0;
    public static final int e0 = 1;
    public static final int f0 = 2;
    public static final int g0 = 3;
    public static final int h0 = 4;
    public static final int i0 = 5;
    public static final int j0 = 6;
    public static final int k0 = 4;
    /* access modifiers changed from: private */
    public String D = null;
    /* access modifiers changed from: private */
    public int E = 0;
    /* access modifiers changed from: private */
    public int F = -1;
    /* access modifiers changed from: private */
    public String G = null;
    /* access modifiers changed from: private */
    public float H = Float.NaN;
    /* access modifiers changed from: private */
    public float I = 0.0f;
    /* access modifiers changed from: private */
    public float J = 0.0f;
    /* access modifiers changed from: private */
    public float K = Float.NaN;
    /* access modifiers changed from: private */
    public int L = -1;
    /* access modifiers changed from: private */
    public float M = Float.NaN;
    /* access modifiers changed from: private */
    public float N = Float.NaN;
    /* access modifiers changed from: private */
    public float O = Float.NaN;
    /* access modifiers changed from: private */
    public float P = Float.NaN;
    /* access modifiers changed from: private */
    public float Q = Float.NaN;
    /* access modifiers changed from: private */
    public float R = Float.NaN;
    /* access modifiers changed from: private */
    public float S = Float.NaN;
    /* access modifiers changed from: private */
    public float T = Float.NaN;
    /* access modifiers changed from: private */
    public float U = Float.NaN;
    /* access modifiers changed from: private */
    public float V = Float.NaN;
    /* access modifiers changed from: private */
    public float W = Float.NaN;

    private static class Loader {

        /* renamed from: a  reason: collision with root package name */
        private static final int f4394a = 1;

        /* renamed from: b  reason: collision with root package name */
        private static final int f4395b = 2;

        /* renamed from: c  reason: collision with root package name */
        private static final int f4396c = 3;

        /* renamed from: d  reason: collision with root package name */
        private static final int f4397d = 4;

        /* renamed from: e  reason: collision with root package name */
        private static final int f4398e = 5;

        /* renamed from: f  reason: collision with root package name */
        private static final int f4399f = 6;

        /* renamed from: g  reason: collision with root package name */
        private static final int f4400g = 7;

        /* renamed from: h  reason: collision with root package name */
        private static final int f4401h = 8;

        /* renamed from: i  reason: collision with root package name */
        private static final int f4402i = 9;

        /* renamed from: j  reason: collision with root package name */
        private static final int f4403j = 10;

        /* renamed from: k  reason: collision with root package name */
        private static final int f4404k = 11;

        /* renamed from: l  reason: collision with root package name */
        private static final int f4405l = 12;

        /* renamed from: m  reason: collision with root package name */
        private static final int f4406m = 13;

        /* renamed from: n  reason: collision with root package name */
        private static final int f4407n = 14;
        private static final int o = 15;
        private static final int p = 16;
        private static final int q = 17;
        private static final int r = 18;
        private static final int s = 19;
        private static final int t = 20;
        private static final int u = 21;
        private static SparseIntArray v;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            v = sparseIntArray;
            sparseIntArray.append(R.styleable.rf, 1);
            v.append(R.styleable.pf, 2);
            v.append(R.styleable.sf, 3);
            v.append(R.styleable.of, 4);
            v.append(R.styleable.xf, 5);
            v.append(R.styleable.vf, 6);
            v.append(R.styleable.uf, 7);
            v.append(R.styleable.yf, 8);
            v.append(R.styleable.ef, 9);
            v.append(R.styleable.nf, 10);
            v.append(R.styleable.jf, 11);
            v.append(R.styleable.kf, 12);
            v.append(R.styleable.lf, 13);
            v.append(R.styleable.tf, 14);
            v.append(R.styleable.hf, 15);
            v.append(R.styleable.f0if, 16);
            v.append(R.styleable.ff, 17);
            v.append(R.styleable.gf, 18);
            v.append(R.styleable.mf, 19);
            v.append(R.styleable.qf, 20);
            v.append(R.styleable.wf, 21);
        }

        private Loader() {
        }

        /* access modifiers changed from: private */
        public static void b(KeyCycle keyCycle, TypedArray typedArray) {
            int i2;
            int indexCount = typedArray.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArray.getIndex(i3);
                switch (v.get(index)) {
                    case 1:
                        if (!MotionLayout.p5) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyCycle.f4376b = typedArray.getResourceId(index, keyCycle.f4376b);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyCycle.f4376b);
                            keyCycle.f4376b = resourceId;
                            if (resourceId != -1) {
                                break;
                            }
                        }
                        keyCycle.f4377c = typedArray.getString(index);
                        break;
                    case 2:
                        keyCycle.f4375a = typedArray.getInt(index, keyCycle.f4375a);
                        break;
                    case 3:
                        String unused = keyCycle.D = typedArray.getString(index);
                        break;
                    case 4:
                        int unused2 = keyCycle.E = typedArray.getInteger(index, keyCycle.E);
                        break;
                    case 5:
                        if (typedArray.peekValue(index).type == 3) {
                            String unused3 = keyCycle.G = typedArray.getString(index);
                            i2 = 7;
                        } else {
                            i2 = typedArray.getInt(index, keyCycle.F);
                        }
                        int unused4 = keyCycle.F = i2;
                        break;
                    case 6:
                        float unused5 = keyCycle.H = typedArray.getFloat(index, keyCycle.H);
                        break;
                    case 7:
                        float unused6 = keyCycle.I = typedArray.peekValue(index).type == 5 ? typedArray.getDimension(index, keyCycle.I) : typedArray.getFloat(index, keyCycle.I);
                        break;
                    case 8:
                        int unused7 = keyCycle.L = typedArray.getInt(index, keyCycle.L);
                        break;
                    case 9:
                        float unused8 = keyCycle.M = typedArray.getFloat(index, keyCycle.M);
                        break;
                    case 10:
                        float unused9 = keyCycle.N = typedArray.getDimension(index, keyCycle.N);
                        break;
                    case 11:
                        float unused10 = keyCycle.O = typedArray.getFloat(index, keyCycle.O);
                        break;
                    case 12:
                        float unused11 = keyCycle.Q = typedArray.getFloat(index, keyCycle.Q);
                        break;
                    case 13:
                        float unused12 = keyCycle.R = typedArray.getFloat(index, keyCycle.R);
                        break;
                    case 14:
                        float unused13 = keyCycle.P = typedArray.getFloat(index, keyCycle.P);
                        break;
                    case 15:
                        float unused14 = keyCycle.S = typedArray.getFloat(index, keyCycle.S);
                        break;
                    case 16:
                        float unused15 = keyCycle.T = typedArray.getFloat(index, keyCycle.T);
                        break;
                    case 17:
                        float unused16 = keyCycle.U = typedArray.getDimension(index, keyCycle.U);
                        break;
                    case 18:
                        float unused17 = keyCycle.V = typedArray.getDimension(index, keyCycle.V);
                        break;
                    case 19:
                        float unused18 = keyCycle.W = typedArray.getDimension(index, keyCycle.W);
                        break;
                    case 20:
                        float unused19 = keyCycle.K = typedArray.getFloat(index, keyCycle.K);
                        break;
                    case 21:
                        float unused20 = keyCycle.J = typedArray.getFloat(index, keyCycle.J) / 360.0f;
                        break;
                    default:
                        Log.e(TypedValues.CycleType.f3962a, "unused attribute 0x" + Integer.toHexString(index) + "   " + v.get(index));
                        break;
                }
            }
        }
    }

    public KeyCycle() {
        this.f4378d = 4;
        this.f4379e = new HashMap<>();
    }

    public void a(HashMap<String, ViewSpline> hashMap) {
        int i2;
        float f2;
        Debug.n(TypedValues.CycleType.f3962a, "add " + hashMap.size() + " values", 2);
        for (String next : hashMap.keySet()) {
            SplineSet splineSet = hashMap.get(next);
            if (splineSet != null) {
                next.hashCode();
                char c2 = 65535;
                switch (next.hashCode()) {
                    case -1249320806:
                        if (next.equals("rotationX")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1249320805:
                        if (next.equals("rotationY")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1225497657:
                        if (next.equals("translationX")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -1225497656:
                        if (next.equals("translationY")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -1225497655:
                        if (next.equals("translationZ")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case -1001078227:
                        if (next.equals("progress")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case -908189618:
                        if (next.equals("scaleX")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case -908189617:
                        if (next.equals("scaleY")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case -40300674:
                        if (next.equals(Key.f4369i)) {
                            c2 = 8;
                            break;
                        }
                        break;
                    case -4379043:
                        if (next.equals("elevation")) {
                            c2 = 9;
                            break;
                        }
                        break;
                    case 37232917:
                        if (next.equals("transitionPathRotate")) {
                            c2 = 10;
                            break;
                        }
                        break;
                    case 92909918:
                        if (next.equals("alpha")) {
                            c2 = 11;
                            break;
                        }
                        break;
                    case 156108012:
                        if (next.equals("waveOffset")) {
                            c2 = 12;
                            break;
                        }
                        break;
                    case 1530034690:
                        if (next.equals("wavePhase")) {
                            c2 = 13;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        i2 = this.f4375a;
                        f2 = this.Q;
                        break;
                    case 1:
                        i2 = this.f4375a;
                        f2 = this.R;
                        break;
                    case 2:
                        i2 = this.f4375a;
                        f2 = this.U;
                        break;
                    case 3:
                        i2 = this.f4375a;
                        f2 = this.V;
                        break;
                    case 4:
                        i2 = this.f4375a;
                        f2 = this.W;
                        break;
                    case 5:
                        i2 = this.f4375a;
                        f2 = this.K;
                        break;
                    case 6:
                        i2 = this.f4375a;
                        f2 = this.S;
                        break;
                    case 7:
                        i2 = this.f4375a;
                        f2 = this.T;
                        break;
                    case 8:
                        i2 = this.f4375a;
                        f2 = this.O;
                        break;
                    case 9:
                        i2 = this.f4375a;
                        f2 = this.N;
                        break;
                    case 10:
                        i2 = this.f4375a;
                        f2 = this.P;
                        break;
                    case 11:
                        i2 = this.f4375a;
                        f2 = this.M;
                        break;
                    case 12:
                        i2 = this.f4375a;
                        f2 = this.I;
                        break;
                    case 13:
                        i2 = this.f4375a;
                        f2 = this.J;
                        break;
                    default:
                        if (!next.startsWith("CUSTOM")) {
                            Log.v("WARNING KeyCycle", "  UNKNOWN  " + next);
                            break;
                        } else {
                            continue;
                        }
                }
                splineSet.g(i2, f2);
            }
        }
    }

    public void a0(HashMap<String, ViewOscillator> hashMap) {
        ViewOscillator viewOscillator;
        ViewOscillator viewOscillator2;
        HashMap<String, ViewOscillator> hashMap2 = hashMap;
        for (String next : hashMap.keySet()) {
            if (next.startsWith("CUSTOM")) {
                ConstraintAttribute constraintAttribute = this.f4379e.get(next.substring(7));
                if (!(constraintAttribute == null || constraintAttribute.j() != ConstraintAttribute.AttributeType.FLOAT_TYPE || (viewOscillator2 = hashMap2.get(next)) == null)) {
                    viewOscillator2.g(this.f4375a, this.F, this.G, this.L, this.H, this.I, this.J, constraintAttribute.k(), constraintAttribute);
                }
            } else {
                float b02 = b0(next);
                if (!Float.isNaN(b02) && (viewOscillator = hashMap2.get(next)) != null) {
                    viewOscillator.f(this.f4375a, this.F, this.G, this.L, this.H, this.I, this.J, b02);
                }
            }
        }
    }

    /* renamed from: b */
    public Key clone() {
        return new KeyCycle().c(this);
    }

    public float b0(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c2 = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c2 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c2 = 7;
                    break;
                }
                break;
            case -40300674:
                if (str.equals(Key.f4369i)) {
                    c2 = 8;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c2 = 9;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c2 = 10;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = 11;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c2 = 12;
                    break;
                }
                break;
            case 1530034690:
                if (str.equals("wavePhase")) {
                    c2 = 13;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return this.Q;
            case 1:
                return this.R;
            case 2:
                return this.U;
            case 3:
                return this.V;
            case 4:
                return this.W;
            case 5:
                return this.K;
            case 6:
                return this.S;
            case 7:
                return this.T;
            case 8:
                return this.O;
            case 9:
                return this.N;
            case 10:
                return this.P;
            case 11:
                return this.M;
            case 12:
                return this.I;
            case 13:
                return this.J;
            default:
                if (str.startsWith("CUSTOM")) {
                    return Float.NaN;
                }
                Log.v("WARNING! KeyCycle", "  UNKNOWN  " + str);
                return Float.NaN;
        }
    }

    public Key c(Key key) {
        super.c(key);
        KeyCycle keyCycle = (KeyCycle) key;
        this.D = keyCycle.D;
        this.E = keyCycle.E;
        this.F = keyCycle.F;
        this.G = keyCycle.G;
        this.H = keyCycle.H;
        this.I = keyCycle.I;
        this.J = keyCycle.J;
        this.K = keyCycle.K;
        this.L = keyCycle.L;
        this.M = keyCycle.M;
        this.N = keyCycle.N;
        this.O = keyCycle.O;
        this.P = keyCycle.P;
        this.Q = keyCycle.Q;
        this.R = keyCycle.R;
        this.S = keyCycle.S;
        this.T = keyCycle.T;
        this.U = keyCycle.U;
        this.V = keyCycle.V;
        this.W = keyCycle.W;
        return this;
    }

    public void d(HashSet<String> hashSet) {
        if (!Float.isNaN(this.M)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.N)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.O)) {
            hashSet.add(Key.f4369i);
        }
        if (!Float.isNaN(this.Q)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.R)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.S)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.T)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.P)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.U)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.V)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.W)) {
            hashSet.add("translationZ");
        }
        if (this.f4379e.size() > 0) {
            for (String str : this.f4379e.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public void f(Context context, AttributeSet attributeSet) {
        Loader.b(this, context.obtainStyledAttributes(attributeSet, R.styleable.df));
    }

    public void j(String str, Object obj) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1913008125:
                if (str.equals(Key.A)) {
                    c2 = 0;
                    break;
                }
                break;
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c2 = 6;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c2 = 7;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c2 = 8;
                    break;
                }
                break;
            case -40300674:
                if (str.equals(Key.f4369i)) {
                    c2 = 9;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c2 = 10;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c2 = 11;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = 12;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c2 = 13;
                    break;
                }
                break;
            case 184161818:
                if (str.equals("wavePeriod")) {
                    c2 = 14;
                    break;
                }
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    c2 = 15;
                    break;
                }
                break;
            case 1530034690:
                if (str.equals("wavePhase")) {
                    c2 = 16;
                    break;
                }
                break;
            case 1532805160:
                if (str.equals("waveShape")) {
                    c2 = 17;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.K = m(obj);
                return;
            case 1:
                this.D = obj.toString();
                return;
            case 2:
                this.Q = m(obj);
                return;
            case 3:
                this.R = m(obj);
                return;
            case 4:
                this.U = m(obj);
                return;
            case 5:
                this.V = m(obj);
                return;
            case 6:
                this.W = m(obj);
                return;
            case 7:
                this.S = m(obj);
                return;
            case 8:
                this.T = m(obj);
                return;
            case 9:
                this.O = m(obj);
                return;
            case 10:
                this.N = m(obj);
                return;
            case 11:
                this.P = m(obj);
                return;
            case 12:
                this.M = m(obj);
                return;
            case 13:
                this.I = m(obj);
                return;
            case 14:
                this.H = m(obj);
                return;
            case 15:
                this.E = n(obj);
                return;
            case 16:
                this.J = m(obj);
                return;
            case 17:
                if (obj instanceof Integer) {
                    this.F = n(obj);
                    return;
                }
                this.F = 7;
                this.G = obj.toString();
                return;
            default:
                return;
        }
    }
}
