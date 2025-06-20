package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;

public class KeyTimeCycle extends Key {
    static final String V = "KeyTimeCycle";
    private static final String W = "KeyTimeCycle";
    public static final String X = "wavePeriod";
    public static final String Y = "waveOffset";
    public static final String Z = "waveShape";
    public static final int a0 = 0;
    public static final int b0 = 1;
    public static final int c0 = 2;
    public static final int d0 = 3;
    public static final int e0 = 4;
    public static final int f0 = 5;
    public static final int g0 = 6;
    public static final int h0 = 3;
    /* access modifiers changed from: private */
    public String D;
    /* access modifiers changed from: private */
    public int E = -1;
    /* access modifiers changed from: private */
    public float F = Float.NaN;
    /* access modifiers changed from: private */
    public float G = Float.NaN;
    /* access modifiers changed from: private */
    public float H = Float.NaN;
    /* access modifiers changed from: private */
    public float I = Float.NaN;
    /* access modifiers changed from: private */
    public float J = Float.NaN;
    /* access modifiers changed from: private */
    public float K = Float.NaN;
    /* access modifiers changed from: private */
    public float L = Float.NaN;
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
    public int R = 0;
    /* access modifiers changed from: private */
    public String S = null;
    /* access modifiers changed from: private */
    public float T = Float.NaN;
    /* access modifiers changed from: private */
    public float U = 0.0f;

    private static class Loader {

        /* renamed from: a  reason: collision with root package name */
        private static final int f4427a = 1;

        /* renamed from: b  reason: collision with root package name */
        private static final int f4428b = 2;

        /* renamed from: c  reason: collision with root package name */
        private static final int f4429c = 4;

        /* renamed from: d  reason: collision with root package name */
        private static final int f4430d = 5;

        /* renamed from: e  reason: collision with root package name */
        private static final int f4431e = 6;

        /* renamed from: f  reason: collision with root package name */
        private static final int f4432f = 8;

        /* renamed from: g  reason: collision with root package name */
        private static final int f4433g = 7;

        /* renamed from: h  reason: collision with root package name */
        private static final int f4434h = 9;

        /* renamed from: i  reason: collision with root package name */
        private static final int f4435i = 10;

        /* renamed from: j  reason: collision with root package name */
        private static final int f4436j = 12;

        /* renamed from: k  reason: collision with root package name */
        private static final int f4437k = 13;

        /* renamed from: l  reason: collision with root package name */
        private static final int f4438l = 14;

        /* renamed from: m  reason: collision with root package name */
        private static final int f4439m = 15;

        /* renamed from: n  reason: collision with root package name */
        private static final int f4440n = 16;
        private static final int o = 17;
        private static final int p = 18;
        private static final int q = 19;
        private static final int r = 20;
        private static final int s = 21;
        private static SparseIntArray t;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            t = sparseIntArray;
            sparseIntArray.append(R.styleable.Qf, 1);
            t.append(R.styleable.Zf, 2);
            t.append(R.styleable.Vf, 4);
            t.append(R.styleable.Wf, 5);
            t.append(R.styleable.Xf, 6);
            t.append(R.styleable.Tf, 7);
            t.append(R.styleable.fg, 8);
            t.append(R.styleable.eg, 9);
            t.append(R.styleable.dg, 10);
            t.append(R.styleable.bg, 12);
            t.append(R.styleable.ag, 13);
            t.append(R.styleable.Uf, 14);
            t.append(R.styleable.Rf, 15);
            t.append(R.styleable.Sf, 16);
            t.append(R.styleable.Yf, 17);
            t.append(R.styleable.cg, 18);
            t.append(R.styleable.ig, 20);
            t.append(R.styleable.hg, 21);
            t.append(R.styleable.kg, 19);
        }

        private Loader() {
        }

        public static void a(KeyTimeCycle keyTimeCycle, TypedArray typedArray) {
            int i2;
            int indexCount = typedArray.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArray.getIndex(i3);
                switch (t.get(index)) {
                    case 1:
                        float unused = keyTimeCycle.F = typedArray.getFloat(index, keyTimeCycle.F);
                        break;
                    case 2:
                        float unused2 = keyTimeCycle.G = typedArray.getDimension(index, keyTimeCycle.G);
                        break;
                    case 4:
                        float unused3 = keyTimeCycle.H = typedArray.getFloat(index, keyTimeCycle.H);
                        break;
                    case 5:
                        float unused4 = keyTimeCycle.I = typedArray.getFloat(index, keyTimeCycle.I);
                        break;
                    case 6:
                        float unused5 = keyTimeCycle.J = typedArray.getFloat(index, keyTimeCycle.J);
                        break;
                    case 7:
                        float unused6 = keyTimeCycle.L = typedArray.getFloat(index, keyTimeCycle.L);
                        break;
                    case 8:
                        float unused7 = keyTimeCycle.K = typedArray.getFloat(index, keyTimeCycle.K);
                        break;
                    case 9:
                        String unused8 = keyTimeCycle.D = typedArray.getString(index);
                        break;
                    case 10:
                        if (!MotionLayout.p5) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyTimeCycle.f4376b = typedArray.getResourceId(index, keyTimeCycle.f4376b);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyTimeCycle.f4376b);
                            keyTimeCycle.f4376b = resourceId;
                            if (resourceId != -1) {
                                break;
                            }
                        }
                        keyTimeCycle.f4377c = typedArray.getString(index);
                        break;
                    case 12:
                        keyTimeCycle.f4375a = typedArray.getInt(index, keyTimeCycle.f4375a);
                        break;
                    case 13:
                        int unused9 = keyTimeCycle.E = typedArray.getInteger(index, keyTimeCycle.E);
                        break;
                    case 14:
                        float unused10 = keyTimeCycle.M = typedArray.getFloat(index, keyTimeCycle.M);
                        break;
                    case 15:
                        float unused11 = keyTimeCycle.N = typedArray.getDimension(index, keyTimeCycle.N);
                        break;
                    case 16:
                        float unused12 = keyTimeCycle.O = typedArray.getDimension(index, keyTimeCycle.O);
                        break;
                    case 17:
                        float unused13 = keyTimeCycle.P = typedArray.getDimension(index, keyTimeCycle.P);
                        break;
                    case 18:
                        float unused14 = keyTimeCycle.Q = typedArray.getFloat(index, keyTimeCycle.Q);
                        break;
                    case 19:
                        if (typedArray.peekValue(index).type == 3) {
                            String unused15 = keyTimeCycle.S = typedArray.getString(index);
                            i2 = 7;
                        } else {
                            i2 = typedArray.getInt(index, keyTimeCycle.R);
                        }
                        int unused16 = keyTimeCycle.R = i2;
                        break;
                    case 20:
                        float unused17 = keyTimeCycle.T = typedArray.getFloat(index, keyTimeCycle.T);
                        break;
                    case 21:
                        float unused18 = keyTimeCycle.U = typedArray.peekValue(index).type == 5 ? typedArray.getDimension(index, keyTimeCycle.U) : typedArray.getFloat(index, keyTimeCycle.U);
                        break;
                    default:
                        Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + t.get(index));
                        break;
                }
            }
        }
    }

    public KeyTimeCycle() {
        this.f4378d = 3;
        this.f4379e = new HashMap<>();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x010a, code lost:
        r4.c(r5, r6, r11.T, r11.R, r11.U);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void W(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r12) {
        /*
            r11 = this;
            r0 = 7
            java.util.Set r1 = r12.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0009:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01a6
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r12.get(r2)
            r4 = r3
            androidx.constraintlayout.motion.utils.ViewTimeCycle r4 = (androidx.constraintlayout.motion.utils.ViewTimeCycle) r4
            if (r4 != 0) goto L_0x001f
            goto L_0x0009
        L_0x001f:
            java.lang.String r3 = "CUSTOM"
            boolean r3 = r2.startsWith(r3)
            if (r3 == 0) goto L_0x0045
            java.lang.String r2 = r2.substring(r0)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r3 = r11.f4379e
            java.lang.Object r2 = r3.get(r2)
            r7 = r2
            androidx.constraintlayout.widget.ConstraintAttribute r7 = (androidx.constraintlayout.widget.ConstraintAttribute) r7
            if (r7 == 0) goto L_0x0009
            r5 = r4
            androidx.constraintlayout.motion.utils.ViewTimeCycle$CustomSet r5 = (androidx.constraintlayout.motion.utils.ViewTimeCycle.CustomSet) r5
            int r6 = r11.f4375a
            float r8 = r11.T
            int r9 = r11.R
            float r10 = r11.U
            r5.k(r6, r7, r8, r9, r10)
            goto L_0x0009
        L_0x0045:
            r3 = -1
            int r5 = r2.hashCode()
            switch(r5) {
                case -1249320806: goto L_0x00d4;
                case -1249320805: goto L_0x00c9;
                case -1225497657: goto L_0x00be;
                case -1225497656: goto L_0x00b3;
                case -1225497655: goto L_0x00a8;
                case -1001078227: goto L_0x009d;
                case -908189618: goto L_0x0092;
                case -908189617: goto L_0x0087;
                case -40300674: goto L_0x0079;
                case -4379043: goto L_0x006b;
                case 37232917: goto L_0x005d;
                case 92909918: goto L_0x004f;
                default: goto L_0x004d;
            }
        L_0x004d:
            goto L_0x00de
        L_0x004f:
            java.lang.String r5 = "alpha"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x0059
            goto L_0x00de
        L_0x0059:
            r3 = 11
            goto L_0x00de
        L_0x005d:
            java.lang.String r5 = "transitionPathRotate"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x0067
            goto L_0x00de
        L_0x0067:
            r3 = 10
            goto L_0x00de
        L_0x006b:
            java.lang.String r5 = "elevation"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x0075
            goto L_0x00de
        L_0x0075:
            r3 = 9
            goto L_0x00de
        L_0x0079:
            java.lang.String r5 = "rotation"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x0083
            goto L_0x00de
        L_0x0083:
            r3 = 8
            goto L_0x00de
        L_0x0087:
            java.lang.String r5 = "scaleY"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x0090
            goto L_0x00de
        L_0x0090:
            r3 = 7
            goto L_0x00de
        L_0x0092:
            java.lang.String r5 = "scaleX"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x009b
            goto L_0x00de
        L_0x009b:
            r3 = 6
            goto L_0x00de
        L_0x009d:
            java.lang.String r5 = "progress"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x00a6
            goto L_0x00de
        L_0x00a6:
            r3 = 5
            goto L_0x00de
        L_0x00a8:
            java.lang.String r5 = "translationZ"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x00b1
            goto L_0x00de
        L_0x00b1:
            r3 = 4
            goto L_0x00de
        L_0x00b3:
            java.lang.String r5 = "translationY"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x00bc
            goto L_0x00de
        L_0x00bc:
            r3 = 3
            goto L_0x00de
        L_0x00be:
            java.lang.String r5 = "translationX"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x00c7
            goto L_0x00de
        L_0x00c7:
            r3 = 2
            goto L_0x00de
        L_0x00c9:
            java.lang.String r5 = "rotationY"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x00d2
            goto L_0x00de
        L_0x00d2:
            r3 = 1
            goto L_0x00de
        L_0x00d4:
            java.lang.String r5 = "rotationX"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x00dd
            goto L_0x00de
        L_0x00dd:
            r3 = 0
        L_0x00de:
            switch(r3) {
                case 0: goto L_0x0198;
                case 1: goto L_0x018a;
                case 2: goto L_0x017d;
                case 3: goto L_0x0170;
                case 4: goto L_0x0163;
                case 5: goto L_0x0156;
                case 6: goto L_0x0149;
                case 7: goto L_0x013c;
                case 8: goto L_0x012f;
                case 9: goto L_0x0122;
                case 10: goto L_0x0115;
                case 11: goto L_0x00fe;
                default: goto L_0x00e1;
            }
        L_0x00e1:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "UNKNOWN addValues \""
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = "\""
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "KeyTimeCycles"
            android.util.Log.e(r3, r2)
            goto L_0x0009
        L_0x00fe:
            float r2 = r11.F
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r5 = r11.f4375a
            float r6 = r11.F
        L_0x010a:
            float r7 = r11.T
            int r8 = r11.R
            float r9 = r11.U
            r4.c(r5, r6, r7, r8, r9)
            goto L_0x0009
        L_0x0115:
            float r2 = r11.K
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r5 = r11.f4375a
            float r6 = r11.K
            goto L_0x010a
        L_0x0122:
            float r2 = r11.G
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r5 = r11.f4375a
            float r6 = r11.G
            goto L_0x010a
        L_0x012f:
            float r2 = r11.H
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r5 = r11.f4375a
            float r6 = r11.H
            goto L_0x010a
        L_0x013c:
            float r2 = r11.M
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r5 = r11.f4375a
            float r6 = r11.M
            goto L_0x010a
        L_0x0149:
            float r2 = r11.L
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r5 = r11.f4375a
            float r6 = r11.L
            goto L_0x010a
        L_0x0156:
            float r2 = r11.Q
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r5 = r11.f4375a
            float r6 = r11.Q
            goto L_0x010a
        L_0x0163:
            float r2 = r11.P
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r5 = r11.f4375a
            float r6 = r11.P
            goto L_0x010a
        L_0x0170:
            float r2 = r11.O
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r5 = r11.f4375a
            float r6 = r11.O
            goto L_0x010a
        L_0x017d:
            float r2 = r11.N
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r5 = r11.f4375a
            float r6 = r11.N
            goto L_0x010a
        L_0x018a:
            float r2 = r11.J
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r5 = r11.f4375a
            float r6 = r11.J
            goto L_0x010a
        L_0x0198:
            float r2 = r11.I
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r5 = r11.f4375a
            float r6 = r11.I
            goto L_0x010a
        L_0x01a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyTimeCycle.W(java.util.HashMap):void");
    }

    public void a(HashMap<String, ViewSpline> hashMap) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    /* renamed from: b */
    public Key clone() {
        return new KeyTimeCycle().c(this);
    }

    public Key c(Key key) {
        super.c(key);
        KeyTimeCycle keyTimeCycle = (KeyTimeCycle) key;
        this.D = keyTimeCycle.D;
        this.E = keyTimeCycle.E;
        this.R = keyTimeCycle.R;
        this.T = keyTimeCycle.T;
        this.U = keyTimeCycle.U;
        this.Q = keyTimeCycle.Q;
        this.F = keyTimeCycle.F;
        this.G = keyTimeCycle.G;
        this.H = keyTimeCycle.H;
        this.K = keyTimeCycle.K;
        this.I = keyTimeCycle.I;
        this.J = keyTimeCycle.J;
        this.L = keyTimeCycle.L;
        this.M = keyTimeCycle.M;
        this.N = keyTimeCycle.N;
        this.O = keyTimeCycle.O;
        this.P = keyTimeCycle.P;
        return this;
    }

    public void d(HashSet<String> hashSet) {
        if (!Float.isNaN(this.F)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.G)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.H)) {
            hashSet.add(Key.f4369i);
        }
        if (!Float.isNaN(this.I)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.J)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.N)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.O)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.P)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.K)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.L)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.M)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.Q)) {
            hashSet.add("progress");
        }
        if (this.f4379e.size() > 0) {
            for (String str : this.f4379e.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public void f(Context context, AttributeSet attributeSet) {
        Loader.a(this, context.obtainStyledAttributes(attributeSet, R.styleable.Pf));
    }

    public void i(HashMap<String, Integer> hashMap) {
        if (this.E != -1) {
            if (!Float.isNaN(this.F)) {
                hashMap.put("alpha", Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.G)) {
                hashMap.put("elevation", Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.H)) {
                hashMap.put(Key.f4369i, Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.I)) {
                hashMap.put("rotationX", Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.J)) {
                hashMap.put("rotationY", Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.N)) {
                hashMap.put("translationX", Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.O)) {
                hashMap.put("translationY", Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.P)) {
                hashMap.put("translationZ", Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.K)) {
                hashMap.put("transitionPathRotate", Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.L)) {
                hashMap.put("scaleX", Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.L)) {
                hashMap.put("scaleY", Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.Q)) {
                hashMap.put("progress", Integer.valueOf(this.E));
            }
            if (this.f4379e.size() > 0) {
                for (String str : this.f4379e.keySet()) {
                    hashMap.put("CUSTOM," + str, Integer.valueOf(this.E));
                }
            }
        }
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
            case 1532805160:
                if (str.equals("waveShape")) {
                    c2 = 16;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.Q = m(obj);
                return;
            case 1:
                this.D = obj.toString();
                return;
            case 2:
                this.I = m(obj);
                return;
            case 3:
                this.J = m(obj);
                return;
            case 4:
                this.N = m(obj);
                return;
            case 5:
                this.O = m(obj);
                return;
            case 6:
                this.P = m(obj);
                return;
            case 7:
                this.L = m(obj);
                return;
            case 8:
                this.M = m(obj);
                return;
            case 9:
                this.H = m(obj);
                return;
            case 10:
                this.G = m(obj);
                return;
            case 11:
                this.K = m(obj);
                return;
            case 12:
                this.F = m(obj);
                return;
            case 13:
                this.U = m(obj);
                return;
            case 14:
                this.T = m(obj);
                return;
            case 15:
                this.E = n(obj);
                return;
            case 16:
                if (obj instanceof Integer) {
                    this.R = n(obj);
                    return;
                }
                this.R = 7;
                this.S = obj.toString();
                return;
            default:
                return;
        }
    }
}
