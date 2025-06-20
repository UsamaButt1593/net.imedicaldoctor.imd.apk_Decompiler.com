package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

public class MotionKeyTrigger extends MotionKey {
    private static final String R = "KeyTrigger";
    public static final String S = "viewTransitionOnCross";
    public static final String T = "viewTransitionOnPositiveCross";
    public static final String U = "viewTransitionOnNegativeCross";
    public static final String V = "postLayout";
    public static final String W = "triggerSlack";
    public static final String X = "triggerCollisionView";
    public static final String Y = "triggerCollisionId";
    public static final String Z = "triggerID";
    public static final String a0 = "positiveCross";
    public static final String b0 = "negativeCross";
    public static final String c0 = "triggerReceiver";
    public static final String d0 = "CROSS";
    public static final int e0 = 301;
    public static final int f0 = 302;
    public static final int g0 = 303;
    public static final int h0 = 304;
    public static final int i0 = 305;
    public static final int j0 = 306;
    public static final int k0 = 307;
    public static final int l0 = 308;
    public static final int m0 = 309;
    public static final int n0 = 310;
    public static final int o0 = 311;
    public static final int p0 = 312;
    public static final int q0 = 5;
    private int A;
    private String B;
    private String C;
    private int D;
    private int E;
    float F;
    private boolean G;
    private boolean H;
    private boolean I;
    private float J;
    private float K;
    private boolean L;
    int M;
    int N;
    int O;
    FloatRect P;
    FloatRect Q;
    private int y = -1;
    private String z = null;

    public MotionKeyTrigger() {
        int i2 = MotionKey.f3721m;
        this.A = i2;
        this.B = null;
        this.C = null;
        this.D = i2;
        this.E = i2;
        this.F = 0.1f;
        this.G = true;
        this.H = true;
        this.I = true;
        this.J = Float.NaN;
        this.L = false;
        this.M = i2;
        this.N = i2;
        this.O = i2;
        this.P = new FloatRect();
        this.Q = new FloatRect();
        this.f3726k = 5;
        this.f3727l = new HashMap<>();
    }

    private void x(String str, MotionWidget motionWidget) {
        CustomVariable customVariable;
        boolean z2 = str.length() == 1;
        if (!z2) {
            str = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String next : this.f3727l.keySet()) {
            String lowerCase = next.toLowerCase(Locale.ROOT);
            if ((z2 || lowerCase.matches(str)) && (customVariable = this.f3727l.get(next)) != null) {
                customVariable.a(motionWidget);
            }
        }
    }

    public boolean a(int i2, int i3) {
        if (i2 == 307) {
            this.E = i3;
            return true;
        } else if (i2 == 308) {
            this.D = u(Integer.valueOf(i3));
            return true;
        } else if (i2 != 311) {
            switch (i2) {
                case 301:
                    this.O = i3;
                    return true;
                case 302:
                    this.N = i3;
                    return true;
                case 303:
                    this.M = i3;
                    return true;
                default:
                    return super.a(i2, i3);
            }
        } else {
            this.A = i3;
            return true;
        }
    }

    public boolean b(int i2, float f2) {
        if (i2 != 305) {
            return super.b(i2, f2);
        }
        this.F = f2;
        return true;
    }

    public boolean c(int i2, String str) {
        if (i2 == 309) {
            this.C = str;
            return true;
        } else if (i2 == 310) {
            this.B = str;
            return true;
        } else if (i2 != 312) {
            return super.c(i2, str);
        } else {
            this.z = str;
            return true;
        }
    }

    public boolean d(int i2, boolean z2) {
        if (i2 != 304) {
            return super.d(i2, z2);
        }
        this.L = z2;
        return true;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int e(java.lang.String r3) {
        /*
            r2 = this;
            r3.hashCode()
            r0 = -1
            int r1 = r3.hashCode()
            switch(r1) {
                case -1594793529: goto L_0x0082;
                case -966421266: goto L_0x0077;
                case -786670827: goto L_0x006c;
                case -648752941: goto L_0x0061;
                case -638126837: goto L_0x0056;
                case -76025313: goto L_0x004b;
                case -9754574: goto L_0x0040;
                case 364489912: goto L_0x0035;
                case 1301930599: goto L_0x0028;
                case 1401391082: goto L_0x001b;
                case 1535404999: goto L_0x000e;
                default: goto L_0x000b;
            }
        L_0x000b:
            r3 = -1
            goto L_0x008c
        L_0x000e:
            java.lang.String r1 = "triggerReceiver"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0017
            goto L_0x000b
        L_0x0017:
            r3 = 10
            goto L_0x008c
        L_0x001b:
            java.lang.String r1 = "postLayout"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0024
            goto L_0x000b
        L_0x0024:
            r3 = 9
            goto L_0x008c
        L_0x0028:
            java.lang.String r1 = "viewTransitionOnCross"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0031
            goto L_0x000b
        L_0x0031:
            r3 = 8
            goto L_0x008c
        L_0x0035:
            java.lang.String r1 = "triggerSlack"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x003e
            goto L_0x000b
        L_0x003e:
            r3 = 7
            goto L_0x008c
        L_0x0040:
            java.lang.String r1 = "viewTransitionOnNegativeCross"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0049
            goto L_0x000b
        L_0x0049:
            r3 = 6
            goto L_0x008c
        L_0x004b:
            java.lang.String r1 = "triggerCollisionView"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0054
            goto L_0x000b
        L_0x0054:
            r3 = 5
            goto L_0x008c
        L_0x0056:
            java.lang.String r1 = "negativeCross"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x005f
            goto L_0x000b
        L_0x005f:
            r3 = 4
            goto L_0x008c
        L_0x0061:
            java.lang.String r1 = "triggerID"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x006a
            goto L_0x000b
        L_0x006a:
            r3 = 3
            goto L_0x008c
        L_0x006c:
            java.lang.String r1 = "triggerCollisionId"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0075
            goto L_0x000b
        L_0x0075:
            r3 = 2
            goto L_0x008c
        L_0x0077:
            java.lang.String r1 = "viewTransitionOnPositiveCross"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0080
            goto L_0x000b
        L_0x0080:
            r3 = 1
            goto L_0x008c
        L_0x0082:
            java.lang.String r1 = "positiveCross"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x008b
            goto L_0x000b
        L_0x008b:
            r3 = 0
        L_0x008c:
            switch(r3) {
                case 0: goto L_0x00ae;
                case 1: goto L_0x00ab;
                case 2: goto L_0x00a8;
                case 3: goto L_0x00a5;
                case 4: goto L_0x00a2;
                case 5: goto L_0x009f;
                case 6: goto L_0x009c;
                case 7: goto L_0x0099;
                case 8: goto L_0x0096;
                case 9: goto L_0x0093;
                case 10: goto L_0x0090;
                default: goto L_0x008f;
            }
        L_0x008f:
            return r0
        L_0x0090:
            r3 = 311(0x137, float:4.36E-43)
            return r3
        L_0x0093:
            r3 = 304(0x130, float:4.26E-43)
            return r3
        L_0x0096:
            r3 = 301(0x12d, float:4.22E-43)
            return r3
        L_0x0099:
            r3 = 305(0x131, float:4.27E-43)
            return r3
        L_0x009c:
            r3 = 303(0x12f, float:4.25E-43)
            return r3
        L_0x009f:
            r3 = 306(0x132, float:4.29E-43)
            return r3
        L_0x00a2:
            r3 = 310(0x136, float:4.34E-43)
            return r3
        L_0x00a5:
            r3 = 308(0x134, float:4.32E-43)
            return r3
        L_0x00a8:
            r3 = 307(0x133, float:4.3E-43)
            return r3
        L_0x00ab:
            r3 = 302(0x12e, float:4.23E-43)
            return r3
        L_0x00ae:
            r3 = 309(0x135, float:4.33E-43)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.key.MotionKeyTrigger.e(java.lang.String):int");
    }

    public void f(HashMap<String, SplineSet> hashMap) {
    }

    /* renamed from: g */
    public MotionKey clone() {
        return new MotionKeyTrigger().h(this);
    }

    public void i(HashSet<String> hashSet) {
    }

    public void v(float f2, MotionWidget motionWidget) {
    }

    /* renamed from: w */
    public MotionKeyTrigger h(MotionKey motionKey) {
        super.h(motionKey);
        MotionKeyTrigger motionKeyTrigger = (MotionKeyTrigger) motionKey;
        this.y = motionKeyTrigger.y;
        this.z = motionKeyTrigger.z;
        this.A = motionKeyTrigger.A;
        this.B = motionKeyTrigger.B;
        this.C = motionKeyTrigger.C;
        this.D = motionKeyTrigger.D;
        this.E = motionKeyTrigger.E;
        this.F = motionKeyTrigger.F;
        this.G = motionKeyTrigger.G;
        this.H = motionKeyTrigger.H;
        this.I = motionKeyTrigger.I;
        this.J = motionKeyTrigger.J;
        this.K = motionKeyTrigger.K;
        this.L = motionKeyTrigger.L;
        this.P = motionKeyTrigger.P;
        this.Q = motionKeyTrigger.Q;
        return this;
    }
}
