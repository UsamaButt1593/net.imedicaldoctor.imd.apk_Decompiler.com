package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

public class KeyTrigger extends Key {
    static final String Y = "KeyTrigger";
    private static final String Z = "KeyTrigger";
    public static final String a0 = "viewTransitionOnCross";
    public static final String b0 = "viewTransitionOnPositiveCross";
    public static final String c0 = "viewTransitionOnNegativeCross";
    public static final String d0 = "postLayout";
    public static final String e0 = "triggerSlack";
    public static final String f0 = "triggerCollisionView";
    public static final String g0 = "triggerCollisionId";
    public static final String h0 = "triggerID";
    public static final String i0 = "positiveCross";
    public static final String j0 = "negativeCross";
    public static final String k0 = "triggerReceiver";
    public static final String l0 = "CROSS";
    public static final int m0 = 5;
    private int D = -1;
    /* access modifiers changed from: private */
    public String E = null;
    /* access modifiers changed from: private */
    public int F;
    /* access modifiers changed from: private */
    public String G;
    /* access modifiers changed from: private */
    public String H;
    /* access modifiers changed from: private */
    public int I;
    /* access modifiers changed from: private */
    public int J;
    private View K;
    float L;
    private boolean M;
    private boolean N;
    private boolean O;
    /* access modifiers changed from: private */
    public float P;
    private float Q;
    /* access modifiers changed from: private */
    public boolean R;
    int S;
    int T;
    int U;
    RectF V;
    RectF W;
    HashMap<String, Method> X;

    private static class Loader {

        /* renamed from: a  reason: collision with root package name */
        private static final int f4441a = 1;

        /* renamed from: b  reason: collision with root package name */
        private static final int f4442b = 2;

        /* renamed from: c  reason: collision with root package name */
        private static final int f4443c = 4;

        /* renamed from: d  reason: collision with root package name */
        private static final int f4444d = 5;

        /* renamed from: e  reason: collision with root package name */
        private static final int f4445e = 6;

        /* renamed from: f  reason: collision with root package name */
        private static final int f4446f = 7;

        /* renamed from: g  reason: collision with root package name */
        private static final int f4447g = 8;

        /* renamed from: h  reason: collision with root package name */
        private static final int f4448h = 9;

        /* renamed from: i  reason: collision with root package name */
        private static final int f4449i = 10;

        /* renamed from: j  reason: collision with root package name */
        private static final int f4450j = 11;

        /* renamed from: k  reason: collision with root package name */
        private static final int f4451k = 12;

        /* renamed from: l  reason: collision with root package name */
        private static final int f4452l = 13;

        /* renamed from: m  reason: collision with root package name */
        private static final int f4453m = 14;

        /* renamed from: n  reason: collision with root package name */
        private static SparseIntArray f4454n;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f4454n = sparseIntArray;
            sparseIntArray.append(R.styleable.mg, 8);
            f4454n.append(R.styleable.qg, 4);
            f4454n.append(R.styleable.rg, 1);
            f4454n.append(R.styleable.sg, 2);
            f4454n.append(R.styleable.ng, 7);
            f4454n.append(R.styleable.tg, 6);
            f4454n.append(R.styleable.vg, 5);
            f4454n.append(R.styleable.pg, 9);
            f4454n.append(R.styleable.og, 10);
            f4454n.append(R.styleable.ug, 11);
            f4454n.append(R.styleable.wg, 12);
            f4454n.append(R.styleable.xg, 13);
            f4454n.append(R.styleable.yg, 14);
        }

        private Loader() {
        }

        public static void a(KeyTrigger keyTrigger, TypedArray typedArray, Context context) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (f4454n.get(index)) {
                    case 1:
                        String unused = keyTrigger.G = typedArray.getString(index);
                        break;
                    case 2:
                        String unused2 = keyTrigger.H = typedArray.getString(index);
                        break;
                    case 4:
                        String unused3 = keyTrigger.E = typedArray.getString(index);
                        break;
                    case 5:
                        keyTrigger.L = typedArray.getFloat(index, keyTrigger.L);
                        break;
                    case 6:
                        int unused4 = keyTrigger.I = typedArray.getResourceId(index, keyTrigger.I);
                        break;
                    case 7:
                        if (!MotionLayout.p5) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyTrigger.f4376b = typedArray.getResourceId(index, keyTrigger.f4376b);
                                break;
                            }
                        } else {
                            int resourceId = typedArray.getResourceId(index, keyTrigger.f4376b);
                            keyTrigger.f4376b = resourceId;
                            if (resourceId != -1) {
                                break;
                            }
                        }
                        keyTrigger.f4377c = typedArray.getString(index);
                        break;
                    case 8:
                        int integer = typedArray.getInteger(index, keyTrigger.f4375a);
                        keyTrigger.f4375a = integer;
                        float unused5 = keyTrigger.P = (((float) integer) + 0.5f) / 100.0f;
                        break;
                    case 9:
                        int unused6 = keyTrigger.J = typedArray.getResourceId(index, keyTrigger.J);
                        break;
                    case 10:
                        boolean unused7 = keyTrigger.R = typedArray.getBoolean(index, keyTrigger.R);
                        break;
                    case 11:
                        int unused8 = keyTrigger.F = typedArray.getResourceId(index, keyTrigger.F);
                        break;
                    case 12:
                        keyTrigger.U = typedArray.getResourceId(index, keyTrigger.U);
                        break;
                    case 13:
                        keyTrigger.S = typedArray.getResourceId(index, keyTrigger.S);
                        break;
                    case 14:
                        keyTrigger.T = typedArray.getResourceId(index, keyTrigger.T);
                        break;
                    default:
                        Log.e(TypedValues.TriggerType.f4038a, "unused attribute 0x" + Integer.toHexString(index) + "   " + f4454n.get(index));
                        break;
                }
            }
        }
    }

    public KeyTrigger() {
        int i2 = Key.f4366f;
        this.F = i2;
        this.G = null;
        this.H = null;
        this.I = i2;
        this.J = i2;
        this.K = null;
        this.L = 0.1f;
        this.M = true;
        this.N = true;
        this.O = true;
        this.P = Float.NaN;
        this.R = false;
        this.S = i2;
        this.T = i2;
        this.U = i2;
        this.V = new RectF();
        this.W = new RectF();
        this.X = new HashMap<>();
        this.f4378d = 5;
        this.f4379e = new HashMap<>();
    }

    private void B(String str, View view) {
        Method method;
        if (str != null) {
            if (str.startsWith(".")) {
                C(str, view);
                return;
            }
            if (this.X.containsKey(str)) {
                method = this.X.get(str);
                if (method == null) {
                    return;
                }
            } else {
                method = null;
            }
            if (method == null) {
                try {
                    method = view.getClass().getMethod(str, (Class[]) null);
                    this.X.put(str, method);
                } catch (NoSuchMethodException unused) {
                    this.X.put(str, (Object) null);
                    Log.e(TypedValues.TriggerType.f4038a, "Could not find method \"" + str + "\"on class " + view.getClass().getSimpleName() + StringUtils.SPACE + Debug.k(view));
                    return;
                }
            }
            try {
                method.invoke(view, (Object[]) null);
            } catch (Exception unused2) {
                Log.e(TypedValues.TriggerType.f4038a, "Exception in call \"" + this.E + "\"on class " + view.getClass().getSimpleName() + StringUtils.SPACE + Debug.k(view));
            }
        }
    }

    private void C(String str, View view) {
        ConstraintAttribute constraintAttribute;
        boolean z = str.length() == 1;
        if (!z) {
            str = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String next : this.f4379e.keySet()) {
            String lowerCase = next.toLowerCase(Locale.ROOT);
            if ((z || lowerCase.matches(str)) && (constraintAttribute = this.f4379e.get(next)) != null) {
                constraintAttribute.a(view);
            }
        }
    }

    private void E(RectF rectF, View view, boolean z) {
        rectF.top = (float) view.getTop();
        rectF.bottom = (float) view.getBottom();
        rectF.left = (float) view.getLeft();
        rectF.right = (float) view.getRight();
        if (z) {
            view.getMatrix().mapRect(rectF);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void A(float r10, android.view.View r11) {
        /*
            r9 = this;
            int r0 = r9.J
            int r1 = androidx.constraintlayout.motion.widget.Key.f4366f
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L_0x0062
            android.view.View r0 = r9.K
            if (r0 != 0) goto L_0x001a
            android.view.ViewParent r0 = r11.getParent()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r1 = r9.J
            android.view.View r0 = r0.findViewById(r1)
            r9.K = r0
        L_0x001a:
            android.graphics.RectF r0 = r9.V
            android.view.View r1 = r9.K
            boolean r4 = r9.R
            r9.E(r0, r1, r4)
            android.graphics.RectF r0 = r9.W
            boolean r1 = r9.R
            r9.E(r0, r11, r1)
            android.graphics.RectF r0 = r9.V
            android.graphics.RectF r1 = r9.W
            boolean r0 = r0.intersect(r1)
            if (r0 == 0) goto L_0x004c
            boolean r0 = r9.M
            if (r0 == 0) goto L_0x003c
            r9.M = r3
            r0 = 1
            goto L_0x003d
        L_0x003c:
            r0 = 0
        L_0x003d:
            boolean r1 = r9.O
            if (r1 == 0) goto L_0x0045
            r9.O = r3
            r1 = 1
            goto L_0x0046
        L_0x0045:
            r1 = 0
        L_0x0046:
            r9.N = r2
            r4 = r1
            r1 = 0
            goto L_0x00e3
        L_0x004c:
            boolean r0 = r9.M
            if (r0 != 0) goto L_0x0054
            r9.M = r2
            r0 = 1
            goto L_0x0055
        L_0x0054:
            r0 = 0
        L_0x0055:
            boolean r1 = r9.N
            if (r1 == 0) goto L_0x005d
            r9.N = r3
            r1 = 1
            goto L_0x005e
        L_0x005d:
            r1 = 0
        L_0x005e:
            r9.O = r2
            goto L_0x00e2
        L_0x0062:
            boolean r0 = r9.M
            r1 = 0
            if (r0 == 0) goto L_0x0078
            float r0 = r9.P
            float r4 = r10 - r0
            float r5 = r9.Q
            float r5 = r5 - r0
            float r4 = r4 * r5
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0088
            r9.M = r3
            r0 = 1
            goto L_0x0089
        L_0x0078:
            float r0 = r9.P
            float r0 = r10 - r0
            float r0 = java.lang.Math.abs(r0)
            float r4 = r9.L
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0088
            r9.M = r2
        L_0x0088:
            r0 = 0
        L_0x0089:
            boolean r4 = r9.N
            if (r4 == 0) goto L_0x00a2
            float r4 = r9.P
            float r5 = r10 - r4
            float r6 = r9.Q
            float r6 = r6 - r4
            float r6 = r6 * r5
            int r4 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b2
            int r4 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b2
            r9.N = r3
            r4 = 1
            goto L_0x00b3
        L_0x00a2:
            float r4 = r9.P
            float r4 = r10 - r4
            float r4 = java.lang.Math.abs(r4)
            float r5 = r9.L
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b2
            r9.N = r2
        L_0x00b2:
            r4 = 0
        L_0x00b3:
            boolean r5 = r9.O
            if (r5 == 0) goto L_0x00d1
            float r5 = r9.P
            float r6 = r10 - r5
            float r7 = r9.Q
            float r7 = r7 - r5
            float r7 = r7 * r6
            int r5 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r5 >= 0) goto L_0x00cc
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x00cc
            r9.O = r3
            r1 = 1
            goto L_0x00cd
        L_0x00cc:
            r1 = 0
        L_0x00cd:
            r8 = r4
            r4 = r1
            r1 = r8
            goto L_0x00e3
        L_0x00d1:
            float r1 = r9.P
            float r1 = r10 - r1
            float r1 = java.lang.Math.abs(r1)
            float r5 = r9.L
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x00e1
            r9.O = r2
        L_0x00e1:
            r1 = r4
        L_0x00e2:
            r4 = 0
        L_0x00e3:
            r9.Q = r10
            if (r1 != 0) goto L_0x00eb
            if (r0 != 0) goto L_0x00eb
            if (r4 == 0) goto L_0x00f6
        L_0x00eb:
            android.view.ViewParent r5 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r5 = (androidx.constraintlayout.motion.widget.MotionLayout) r5
            int r6 = r9.I
            r5.z0(r6, r4, r10)
        L_0x00f6:
            int r10 = r9.F
            int r5 = androidx.constraintlayout.motion.widget.Key.f4366f
            if (r10 != r5) goto L_0x00fe
            r10 = r11
            goto L_0x010a
        L_0x00fe:
            android.view.ViewParent r10 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r10 = (androidx.constraintlayout.motion.widget.MotionLayout) r10
            int r5 = r9.F
            android.view.View r10 = r10.findViewById(r5)
        L_0x010a:
            if (r1 == 0) goto L_0x0128
            java.lang.String r1 = r9.G
            if (r1 == 0) goto L_0x0113
            r9.B(r1, r10)
        L_0x0113:
            int r1 = r9.S
            int r5 = androidx.constraintlayout.motion.widget.Key.f4366f
            if (r1 == r5) goto L_0x0128
            android.view.ViewParent r1 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r1 = (androidx.constraintlayout.motion.widget.MotionLayout) r1
            int r5 = r9.S
            android.view.View[] r6 = new android.view.View[r2]
            r6[r3] = r10
            r1.n1(r5, r6)
        L_0x0128:
            if (r4 == 0) goto L_0x0146
            java.lang.String r1 = r9.H
            if (r1 == 0) goto L_0x0131
            r9.B(r1, r10)
        L_0x0131:
            int r1 = r9.T
            int r4 = androidx.constraintlayout.motion.widget.Key.f4366f
            if (r1 == r4) goto L_0x0146
            android.view.ViewParent r1 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r1 = (androidx.constraintlayout.motion.widget.MotionLayout) r1
            int r4 = r9.T
            android.view.View[] r5 = new android.view.View[r2]
            r5[r3] = r10
            r1.n1(r4, r5)
        L_0x0146:
            if (r0 == 0) goto L_0x0164
            java.lang.String r0 = r9.E
            if (r0 == 0) goto L_0x014f
            r9.B(r0, r10)
        L_0x014f:
            int r0 = r9.U
            int r1 = androidx.constraintlayout.motion.widget.Key.f4366f
            if (r0 == r1) goto L_0x0164
            android.view.ViewParent r11 = r11.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r11 = (androidx.constraintlayout.motion.widget.MotionLayout) r11
            int r0 = r9.U
            android.view.View[] r1 = new android.view.View[r2]
            r1[r3] = r10
            r11.n1(r0, r1)
        L_0x0164:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyTrigger.A(float, android.view.View):void");
    }

    /* access modifiers changed from: package-private */
    public int D() {
        return this.D;
    }

    public void a(HashMap<String, ViewSpline> hashMap) {
    }

    /* renamed from: b */
    public Key clone() {
        return new KeyTrigger().c(this);
    }

    public Key c(Key key) {
        super.c(key);
        KeyTrigger keyTrigger = (KeyTrigger) key;
        this.D = keyTrigger.D;
        this.E = keyTrigger.E;
        this.F = keyTrigger.F;
        this.G = keyTrigger.G;
        this.H = keyTrigger.H;
        this.I = keyTrigger.I;
        this.J = keyTrigger.J;
        this.K = keyTrigger.K;
        this.L = keyTrigger.L;
        this.M = keyTrigger.M;
        this.N = keyTrigger.N;
        this.O = keyTrigger.O;
        this.P = keyTrigger.P;
        this.Q = keyTrigger.Q;
        this.R = keyTrigger.R;
        this.V = keyTrigger.V;
        this.W = keyTrigger.W;
        this.X = keyTrigger.X;
        return this;
    }

    public void d(HashSet<String> hashSet) {
    }

    public void f(Context context, AttributeSet attributeSet) {
        Loader.a(this, context.obtainStyledAttributes(attributeSet, R.styleable.lg), context);
    }

    public void j(String str, Object obj) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1594793529:
                if (str.equals("positiveCross")) {
                    c2 = 0;
                    break;
                }
                break;
            case -966421266:
                if (str.equals("viewTransitionOnPositiveCross")) {
                    c2 = 1;
                    break;
                }
                break;
            case -786670827:
                if (str.equals("triggerCollisionId")) {
                    c2 = 2;
                    break;
                }
                break;
            case -648752941:
                if (str.equals("triggerID")) {
                    c2 = 3;
                    break;
                }
                break;
            case -638126837:
                if (str.equals("negativeCross")) {
                    c2 = 4;
                    break;
                }
                break;
            case -76025313:
                if (str.equals("triggerCollisionView")) {
                    c2 = 5;
                    break;
                }
                break;
            case -9754574:
                if (str.equals("viewTransitionOnNegativeCross")) {
                    c2 = 6;
                    break;
                }
                break;
            case 64397344:
                if (str.equals("CROSS")) {
                    c2 = 7;
                    break;
                }
                break;
            case 364489912:
                if (str.equals("triggerSlack")) {
                    c2 = 8;
                    break;
                }
                break;
            case 1301930599:
                if (str.equals("viewTransitionOnCross")) {
                    c2 = 9;
                    break;
                }
                break;
            case 1401391082:
                if (str.equals("postLayout")) {
                    c2 = 10;
                    break;
                }
                break;
            case 1535404999:
                if (str.equals("triggerReceiver")) {
                    c2 = 11;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.H = obj.toString();
                return;
            case 1:
                this.T = n(obj);
                return;
            case 2:
                this.J = n(obj);
                return;
            case 3:
                this.I = n(obj);
                return;
            case 4:
                this.G = obj.toString();
                return;
            case 5:
                this.K = (View) obj;
                return;
            case 6:
                this.S = n(obj);
                return;
            case 7:
                this.E = obj.toString();
                return;
            case 8:
                this.L = m(obj);
                return;
            case 9:
                this.U = n(obj);
                return;
            case 10:
                this.R = l(obj);
                return;
            case 11:
                this.F = n(obj);
                return;
            default:
                return;
        }
    }
}
