package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;

public class KeyAttributes extends Key {
    static final String U = "KeyAttribute";
    private static final String V = "KeyAttributes";
    private static final boolean W = false;
    public static final int X = 1;
    /* access modifiers changed from: private */
    public String D;
    /* access modifiers changed from: private */
    public int E = -1;
    private boolean F = false;
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
    public float R = Float.NaN;
    /* access modifiers changed from: private */
    public float S = Float.NaN;
    /* access modifiers changed from: private */
    public float T = Float.NaN;

    private static class Loader {

        /* renamed from: a  reason: collision with root package name */
        private static final int f4380a = 1;

        /* renamed from: b  reason: collision with root package name */
        private static final int f4381b = 2;

        /* renamed from: c  reason: collision with root package name */
        private static final int f4382c = 4;

        /* renamed from: d  reason: collision with root package name */
        private static final int f4383d = 5;

        /* renamed from: e  reason: collision with root package name */
        private static final int f4384e = 6;

        /* renamed from: f  reason: collision with root package name */
        private static final int f4385f = 8;

        /* renamed from: g  reason: collision with root package name */
        private static final int f4386g = 7;

        /* renamed from: h  reason: collision with root package name */
        private static final int f4387h = 9;

        /* renamed from: i  reason: collision with root package name */
        private static final int f4388i = 10;

        /* renamed from: j  reason: collision with root package name */
        private static final int f4389j = 12;

        /* renamed from: k  reason: collision with root package name */
        private static final int f4390k = 13;

        /* renamed from: l  reason: collision with root package name */
        private static final int f4391l = 14;

        /* renamed from: m  reason: collision with root package name */
        private static final int f4392m = 15;

        /* renamed from: n  reason: collision with root package name */
        private static final int f4393n = 16;
        private static final int o = 17;
        private static final int p = 18;
        private static final int q = 19;
        private static final int r = 20;
        private static SparseIntArray s;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            s = sparseIntArray;
            sparseIntArray.append(R.styleable.Ke, 1);
            s.append(R.styleable.Ve, 2);
            s.append(R.styleable.Re, 4);
            s.append(R.styleable.Se, 5);
            s.append(R.styleable.Te, 6);
            s.append(R.styleable.Le, 19);
            s.append(R.styleable.Me, 20);
            s.append(R.styleable.Pe, 7);
            s.append(R.styleable.cf, 8);
            s.append(R.styleable.bf, 9);
            s.append(R.styleable.Ze, 10);
            s.append(R.styleable.Xe, 12);
            s.append(R.styleable.We, 13);
            s.append(R.styleable.Qe, 14);
            s.append(R.styleable.Ne, 15);
            s.append(R.styleable.Oe, 16);
            s.append(R.styleable.Ue, 17);
            s.append(R.styleable.Ye, 18);
        }

        private Loader() {
        }

        public static void a(KeyAttributes keyAttributes, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (s.get(index)) {
                    case 1:
                        float unused = keyAttributes.G = typedArray.getFloat(index, keyAttributes.G);
                        break;
                    case 2:
                        float unused2 = keyAttributes.H = typedArray.getDimension(index, keyAttributes.H);
                        break;
                    case 4:
                        float unused3 = keyAttributes.I = typedArray.getFloat(index, keyAttributes.I);
                        break;
                    case 5:
                        float unused4 = keyAttributes.J = typedArray.getFloat(index, keyAttributes.J);
                        break;
                    case 6:
                        float unused5 = keyAttributes.K = typedArray.getFloat(index, keyAttributes.K);
                        break;
                    case 7:
                        float unused6 = keyAttributes.O = typedArray.getFloat(index, keyAttributes.O);
                        break;
                    case 8:
                        float unused7 = keyAttributes.N = typedArray.getFloat(index, keyAttributes.N);
                        break;
                    case 9:
                        String unused8 = keyAttributes.D = typedArray.getString(index);
                        break;
                    case 10:
                        if (!MotionLayout.p5) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyAttributes.f4376b = typedArray.getResourceId(index, keyAttributes.f4376b);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyAttributes.f4376b);
                            keyAttributes.f4376b = resourceId;
                            if (resourceId != -1) {
                                break;
                            }
                        }
                        keyAttributes.f4377c = typedArray.getString(index);
                        break;
                    case 12:
                        keyAttributes.f4375a = typedArray.getInt(index, keyAttributes.f4375a);
                        break;
                    case 13:
                        int unused9 = keyAttributes.E = typedArray.getInteger(index, keyAttributes.E);
                        break;
                    case 14:
                        float unused10 = keyAttributes.P = typedArray.getFloat(index, keyAttributes.P);
                        break;
                    case 15:
                        float unused11 = keyAttributes.Q = typedArray.getDimension(index, keyAttributes.Q);
                        break;
                    case 16:
                        float unused12 = keyAttributes.R = typedArray.getDimension(index, keyAttributes.R);
                        break;
                    case 17:
                        float unused13 = keyAttributes.S = typedArray.getDimension(index, keyAttributes.S);
                        break;
                    case 18:
                        float unused14 = keyAttributes.T = typedArray.getFloat(index, keyAttributes.T);
                        break;
                    case 19:
                        float unused15 = keyAttributes.L = typedArray.getDimension(index, keyAttributes.L);
                        break;
                    case 20:
                        float unused16 = keyAttributes.M = typedArray.getDimension(index, keyAttributes.M);
                        break;
                    default:
                        Log.e(KeyAttributes.U, "unused attribute 0x" + Integer.toHexString(index) + "   " + s.get(index));
                        break;
                }
            }
        }
    }

    public KeyAttributes() {
        this.f4378d = 1;
        this.f4379e = new HashMap<>();
    }

    /* access modifiers changed from: package-private */
    public int T() {
        return this.E;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0102, code lost:
        r3.g(r2, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r7) {
        /*
            r6 = this;
            r0 = 7
            java.util.Set r1 = r7.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0009:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01b4
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r7.get(r2)
            androidx.constraintlayout.core.motion.utils.SplineSet r3 = (androidx.constraintlayout.core.motion.utils.SplineSet) r3
            if (r3 != 0) goto L_0x001e
            goto L_0x0009
        L_0x001e:
            java.lang.String r4 = "CUSTOM"
            boolean r4 = r2.startsWith(r4)
            if (r4 == 0) goto L_0x003c
            java.lang.String r2 = r2.substring(r0)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r4 = r6.f4379e
            java.lang.Object r2 = r4.get(r2)
            androidx.constraintlayout.widget.ConstraintAttribute r2 = (androidx.constraintlayout.widget.ConstraintAttribute) r2
            if (r2 == 0) goto L_0x0009
            androidx.constraintlayout.motion.utils.ViewSpline$CustomSet r3 = (androidx.constraintlayout.motion.utils.ViewSpline.CustomSet) r3
            int r4 = r6.f4375a
            r3.n(r4, r2)
            goto L_0x0009
        L_0x003c:
            r4 = -1
            int r5 = r2.hashCode()
            switch(r5) {
                case -1249320806: goto L_0x00e7;
                case -1249320805: goto L_0x00dc;
                case -1225497657: goto L_0x00d1;
                case -1225497656: goto L_0x00c6;
                case -1225497655: goto L_0x00bb;
                case -1001078227: goto L_0x00b0;
                case -908189618: goto L_0x00a5;
                case -908189617: goto L_0x009a;
                case -760884510: goto L_0x008c;
                case -760884509: goto L_0x007e;
                case -40300674: goto L_0x0070;
                case -4379043: goto L_0x0062;
                case 37232917: goto L_0x0054;
                case 92909918: goto L_0x0046;
                default: goto L_0x0044;
            }
        L_0x0044:
            goto L_0x00f1
        L_0x0046:
            java.lang.String r5 = "alpha"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x0050
            goto L_0x00f1
        L_0x0050:
            r4 = 13
            goto L_0x00f1
        L_0x0054:
            java.lang.String r5 = "transitionPathRotate"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x005e
            goto L_0x00f1
        L_0x005e:
            r4 = 12
            goto L_0x00f1
        L_0x0062:
            java.lang.String r5 = "elevation"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x006c
            goto L_0x00f1
        L_0x006c:
            r4 = 11
            goto L_0x00f1
        L_0x0070:
            java.lang.String r5 = "rotation"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x007a
            goto L_0x00f1
        L_0x007a:
            r4 = 10
            goto L_0x00f1
        L_0x007e:
            java.lang.String r5 = "transformPivotY"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x0088
            goto L_0x00f1
        L_0x0088:
            r4 = 9
            goto L_0x00f1
        L_0x008c:
            java.lang.String r5 = "transformPivotX"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x0096
            goto L_0x00f1
        L_0x0096:
            r4 = 8
            goto L_0x00f1
        L_0x009a:
            java.lang.String r5 = "scaleY"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x00a3
            goto L_0x00f1
        L_0x00a3:
            r4 = 7
            goto L_0x00f1
        L_0x00a5:
            java.lang.String r5 = "scaleX"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x00ae
            goto L_0x00f1
        L_0x00ae:
            r4 = 6
            goto L_0x00f1
        L_0x00b0:
            java.lang.String r5 = "progress"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x00b9
            goto L_0x00f1
        L_0x00b9:
            r4 = 5
            goto L_0x00f1
        L_0x00bb:
            java.lang.String r5 = "translationZ"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x00c4
            goto L_0x00f1
        L_0x00c4:
            r4 = 4
            goto L_0x00f1
        L_0x00c6:
            java.lang.String r5 = "translationY"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x00cf
            goto L_0x00f1
        L_0x00cf:
            r4 = 3
            goto L_0x00f1
        L_0x00d1:
            java.lang.String r5 = "translationX"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x00da
            goto L_0x00f1
        L_0x00da:
            r4 = 2
            goto L_0x00f1
        L_0x00dc:
            java.lang.String r5 = "rotationY"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x00e5
            goto L_0x00f1
        L_0x00e5:
            r4 = 1
            goto L_0x00f1
        L_0x00e7:
            java.lang.String r5 = "rotationX"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x00f0
            goto L_0x00f1
        L_0x00f0:
            r4 = 0
        L_0x00f1:
            switch(r4) {
                case 0: goto L_0x01a6;
                case 1: goto L_0x0198;
                case 2: goto L_0x018a;
                case 3: goto L_0x017c;
                case 4: goto L_0x016f;
                case 5: goto L_0x0162;
                case 6: goto L_0x0155;
                case 7: goto L_0x0148;
                case 8: goto L_0x013b;
                case 9: goto L_0x012e;
                case 10: goto L_0x0121;
                case 11: goto L_0x0114;
                case 12: goto L_0x0107;
                case 13: goto L_0x00f6;
                default: goto L_0x00f4;
            }
        L_0x00f4:
            goto L_0x0009
        L_0x00f6:
            float r2 = r6.G
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f4375a
            float r4 = r6.G
        L_0x0102:
            r3.g(r2, r4)
            goto L_0x0009
        L_0x0107:
            float r2 = r6.N
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f4375a
            float r4 = r6.N
            goto L_0x0102
        L_0x0114:
            float r2 = r6.H
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f4375a
            float r4 = r6.H
            goto L_0x0102
        L_0x0121:
            float r2 = r6.I
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f4375a
            float r4 = r6.I
            goto L_0x0102
        L_0x012e:
            float r2 = r6.K
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f4375a
            float r4 = r6.M
            goto L_0x0102
        L_0x013b:
            float r2 = r6.J
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f4375a
            float r4 = r6.L
            goto L_0x0102
        L_0x0148:
            float r2 = r6.P
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f4375a
            float r4 = r6.P
            goto L_0x0102
        L_0x0155:
            float r2 = r6.O
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f4375a
            float r4 = r6.O
            goto L_0x0102
        L_0x0162:
            float r2 = r6.T
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f4375a
            float r4 = r6.T
            goto L_0x0102
        L_0x016f:
            float r2 = r6.S
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f4375a
            float r4 = r6.S
            goto L_0x0102
        L_0x017c:
            float r2 = r6.R
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f4375a
            float r4 = r6.R
            goto L_0x0102
        L_0x018a:
            float r2 = r6.Q
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f4375a
            float r4 = r6.Q
            goto L_0x0102
        L_0x0198:
            float r2 = r6.K
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f4375a
            float r4 = r6.K
            goto L_0x0102
        L_0x01a6:
            float r2 = r6.J
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f4375a
            float r4 = r6.J
            goto L_0x0102
        L_0x01b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyAttributes.a(java.util.HashMap):void");
    }

    /* renamed from: b */
    public Key clone() {
        return new KeyAttributes().c(this);
    }

    public Key c(Key key) {
        super.c(key);
        KeyAttributes keyAttributes = (KeyAttributes) key;
        this.E = keyAttributes.E;
        this.F = keyAttributes.F;
        this.G = keyAttributes.G;
        this.H = keyAttributes.H;
        this.I = keyAttributes.I;
        this.J = keyAttributes.J;
        this.K = keyAttributes.K;
        this.L = keyAttributes.L;
        this.M = keyAttributes.M;
        this.N = keyAttributes.N;
        this.O = keyAttributes.O;
        this.P = keyAttributes.P;
        this.Q = keyAttributes.Q;
        this.R = keyAttributes.R;
        this.S = keyAttributes.S;
        this.T = keyAttributes.T;
        return this;
    }

    public void d(HashSet<String> hashSet) {
        if (!Float.isNaN(this.G)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.H)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.I)) {
            hashSet.add(Key.f4369i);
        }
        if (!Float.isNaN(this.J)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.K)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.L)) {
            hashSet.add(Key.f4372l);
        }
        if (!Float.isNaN(this.M)) {
            hashSet.add(Key.f4373m);
        }
        if (!Float.isNaN(this.Q)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.R)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.S)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.N)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.O)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.P)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.T)) {
            hashSet.add("progress");
        }
        if (this.f4379e.size() > 0) {
            for (String str : this.f4379e.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public void f(Context context, AttributeSet attributeSet) {
        Loader.a(this, context.obtainStyledAttributes(attributeSet, R.styleable.Je));
    }

    public void i(HashMap<String, Integer> hashMap) {
        if (this.E != -1) {
            if (!Float.isNaN(this.G)) {
                hashMap.put("alpha", Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.H)) {
                hashMap.put("elevation", Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.I)) {
                hashMap.put(Key.f4369i, Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.J)) {
                hashMap.put("rotationX", Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.K)) {
                hashMap.put("rotationY", Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.L)) {
                hashMap.put(Key.f4372l, Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.M)) {
                hashMap.put(Key.f4373m, Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.Q)) {
                hashMap.put("translationX", Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.R)) {
                hashMap.put("translationY", Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.S)) {
                hashMap.put("translationZ", Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.N)) {
                hashMap.put("transitionPathRotate", Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.O)) {
                hashMap.put("scaleX", Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.P)) {
                hashMap.put("scaleY", Integer.valueOf(this.E));
            }
            if (!Float.isNaN(this.T)) {
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
            case -760884510:
                if (str.equals(Key.f4372l)) {
                    c2 = 9;
                    break;
                }
                break;
            case -760884509:
                if (str.equals(Key.f4373m)) {
                    c2 = 10;
                    break;
                }
                break;
            case -40300674:
                if (str.equals(Key.f4369i)) {
                    c2 = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c2 = 12;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c2 = 13;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
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
            case 1941332754:
                if (str.equals("visibility")) {
                    c2 = 16;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.T = m(obj);
                return;
            case 1:
                this.D = obj.toString();
                return;
            case 2:
                this.J = m(obj);
                return;
            case 3:
                this.K = m(obj);
                return;
            case 4:
                this.Q = m(obj);
                return;
            case 5:
                this.R = m(obj);
                return;
            case 6:
                this.S = m(obj);
                return;
            case 7:
                this.O = m(obj);
                return;
            case 8:
                this.P = m(obj);
                return;
            case 9:
                this.L = m(obj);
                return;
            case 10:
                this.M = m(obj);
                return;
            case 11:
                this.I = m(obj);
                return;
            case 12:
                this.H = m(obj);
                return;
            case 13:
                this.N = m(obj);
                return;
            case 14:
                this.G = m(obj);
                return;
            case 15:
                this.E = n(obj);
                return;
            case 16:
                this.F = l(obj);
                return;
            default:
                return;
        }
    }
}
