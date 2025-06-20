package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.constraintlayout.core.motion.utils.a;
import com.dd.plist.ASCIIPropertyListParser;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;

public class MotionKeyCycle extends MotionKey {
    private static final String R = "KeyCycle";
    static final String S = "KeyCycle";
    public static final String T = "wavePeriod";
    public static final String U = "waveOffset";
    public static final String V = "wavePhase";
    public static final String W = "waveShape";
    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;
    public static final int a0 = 3;
    public static final int b0 = 4;
    public static final int c0 = 5;
    public static final int d0 = 6;
    public static final int e0 = 4;
    private int A = -1;
    private String B = null;
    private float C = Float.NaN;
    private float D = 0.0f;
    private float E = 0.0f;
    private float F = Float.NaN;
    private float G = Float.NaN;
    private float H = Float.NaN;
    private float I = Float.NaN;
    private float J = Float.NaN;
    private float K = Float.NaN;
    private float L = Float.NaN;
    private float M = Float.NaN;
    private float N = Float.NaN;
    private float O = Float.NaN;
    private float P = Float.NaN;
    private float Q = Float.NaN;
    private String y = null;
    private int z = 0;

    public MotionKeyCycle() {
        this.f3726k = 4;
        this.f3727l = new HashMap<>();
    }

    public boolean a(int i2, int i3) {
        if (i2 == 401) {
            this.z = i3;
            return true;
        } else if (i2 == 421) {
            this.A = i3;
            return true;
        } else if (b(i2, (float) i3)) {
            return true;
        } else {
            return super.a(i2, i3);
        }
    }

    public boolean b(int i2, float f2) {
        if (i2 == 315) {
            this.F = f2;
            return true;
        } else if (i2 == 403) {
            this.G = f2;
            return true;
        } else if (i2 != 416) {
            switch (i2) {
                case 304:
                    this.O = f2;
                    return true;
                case 305:
                    this.P = f2;
                    return true;
                case 306:
                    this.Q = f2;
                    return true;
                case 307:
                    this.H = f2;
                    return true;
                case 308:
                    this.K = f2;
                    return true;
                case 309:
                    this.L = f2;
                    return true;
                case 310:
                    this.I = f2;
                    return true;
                case 311:
                    this.M = f2;
                    return true;
                case 312:
                    this.N = f2;
                    return true;
                default:
                    switch (i2) {
                        case 423:
                            this.C = f2;
                            return true;
                        case 424:
                            this.D = f2;
                            return true;
                        case TypedValues.CycleType.w /*425*/:
                            this.E = f2;
                            return true;
                        default:
                            return super.b(i2, f2);
                    }
            }
        } else {
            this.J = f2;
            return true;
        }
    }

    public boolean c(int i2, String str) {
        if (i2 == 420) {
            this.y = str;
            return true;
        } else if (i2 != 422) {
            return super.c(i2, str);
        } else {
            this.B = str;
            return true;
        }
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
                case -1581616630: goto L_0x010f;
                case -1310311125: goto L_0x0103;
                case -1249320806: goto L_0x00f7;
                case -1249320805: goto L_0x00eb;
                case -1249320804: goto L_0x00df;
                case -1225497657: goto L_0x00d3;
                case -1225497656: goto L_0x00c7;
                case -1225497655: goto L_0x00bb;
                case -1019779949: goto L_0x00ad;
                case -1001078227: goto L_0x009f;
                case -991726143: goto L_0x0091;
                case -987906986: goto L_0x0083;
                case -987906985: goto L_0x0076;
                case -908189618: goto L_0x0069;
                case -908189617: goto L_0x005c;
                case 92909918: goto L_0x004f;
                case 106629499: goto L_0x0042;
                case 579057826: goto L_0x0035;
                case 803192288: goto L_0x0028;
                case 1532805160: goto L_0x001b;
                case 1941332754: goto L_0x000e;
                default: goto L_0x000b;
            }
        L_0x000b:
            r3 = -1
            goto L_0x011a
        L_0x000e:
            java.lang.String r1 = "visibility"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0017
            goto L_0x000b
        L_0x0017:
            r3 = 20
            goto L_0x011a
        L_0x001b:
            java.lang.String r1 = "waveShape"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0024
            goto L_0x000b
        L_0x0024:
            r3 = 19
            goto L_0x011a
        L_0x0028:
            java.lang.String r1 = "pathRotate"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0031
            goto L_0x000b
        L_0x0031:
            r3 = 18
            goto L_0x011a
        L_0x0035:
            java.lang.String r1 = "curveFit"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x003e
            goto L_0x000b
        L_0x003e:
            r3 = 17
            goto L_0x011a
        L_0x0042:
            java.lang.String r1 = "phase"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x004b
            goto L_0x000b
        L_0x004b:
            r3 = 16
            goto L_0x011a
        L_0x004f:
            java.lang.String r1 = "alpha"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0058
            goto L_0x000b
        L_0x0058:
            r3 = 15
            goto L_0x011a
        L_0x005c:
            java.lang.String r1 = "scaleY"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0065
            goto L_0x000b
        L_0x0065:
            r3 = 14
            goto L_0x011a
        L_0x0069:
            java.lang.String r1 = "scaleX"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0072
            goto L_0x000b
        L_0x0072:
            r3 = 13
            goto L_0x011a
        L_0x0076:
            java.lang.String r1 = "pivotY"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x007f
            goto L_0x000b
        L_0x007f:
            r3 = 12
            goto L_0x011a
        L_0x0083:
            java.lang.String r1 = "pivotX"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x008d
            goto L_0x000b
        L_0x008d:
            r3 = 11
            goto L_0x011a
        L_0x0091:
            java.lang.String r1 = "period"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x009b
            goto L_0x000b
        L_0x009b:
            r3 = 10
            goto L_0x011a
        L_0x009f:
            java.lang.String r1 = "progress"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x00a9
            goto L_0x000b
        L_0x00a9:
            r3 = 9
            goto L_0x011a
        L_0x00ad:
            java.lang.String r1 = "offset"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x00b7
            goto L_0x000b
        L_0x00b7:
            r3 = 8
            goto L_0x011a
        L_0x00bb:
            java.lang.String r1 = "translationZ"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x00c5
            goto L_0x000b
        L_0x00c5:
            r3 = 7
            goto L_0x011a
        L_0x00c7:
            java.lang.String r1 = "translationY"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x00d1
            goto L_0x000b
        L_0x00d1:
            r3 = 6
            goto L_0x011a
        L_0x00d3:
            java.lang.String r1 = "translationX"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x00dd
            goto L_0x000b
        L_0x00dd:
            r3 = 5
            goto L_0x011a
        L_0x00df:
            java.lang.String r1 = "rotationZ"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x00e9
            goto L_0x000b
        L_0x00e9:
            r3 = 4
            goto L_0x011a
        L_0x00eb:
            java.lang.String r1 = "rotationY"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x00f5
            goto L_0x000b
        L_0x00f5:
            r3 = 3
            goto L_0x011a
        L_0x00f7:
            java.lang.String r1 = "rotationX"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0101
            goto L_0x000b
        L_0x0101:
            r3 = 2
            goto L_0x011a
        L_0x0103:
            java.lang.String r1 = "easing"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x010d
            goto L_0x000b
        L_0x010d:
            r3 = 1
            goto L_0x011a
        L_0x010f:
            java.lang.String r1 = "customWave"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0119
            goto L_0x000b
        L_0x0119:
            r3 = 0
        L_0x011a:
            switch(r3) {
                case 0: goto L_0x015a;
                case 1: goto L_0x0157;
                case 2: goto L_0x0154;
                case 3: goto L_0x0151;
                case 4: goto L_0x014e;
                case 5: goto L_0x014b;
                case 6: goto L_0x0148;
                case 7: goto L_0x0145;
                case 8: goto L_0x0142;
                case 9: goto L_0x013f;
                case 10: goto L_0x013c;
                case 11: goto L_0x0139;
                case 12: goto L_0x0136;
                case 13: goto L_0x0133;
                case 14: goto L_0x0130;
                case 15: goto L_0x012d;
                case 16: goto L_0x012a;
                case 17: goto L_0x0127;
                case 18: goto L_0x0124;
                case 19: goto L_0x0121;
                case 20: goto L_0x011e;
                default: goto L_0x011d;
            }
        L_0x011d:
            return r0
        L_0x011e:
            r3 = 402(0x192, float:5.63E-43)
            return r3
        L_0x0121:
            r3 = 421(0x1a5, float:5.9E-43)
            return r3
        L_0x0124:
            r3 = 416(0x1a0, float:5.83E-43)
            return r3
        L_0x0127:
            r3 = 401(0x191, float:5.62E-43)
            return r3
        L_0x012a:
            r3 = 425(0x1a9, float:5.96E-43)
            return r3
        L_0x012d:
            r3 = 403(0x193, float:5.65E-43)
            return r3
        L_0x0130:
            r3 = 312(0x138, float:4.37E-43)
            return r3
        L_0x0133:
            r3 = 311(0x137, float:4.36E-43)
            return r3
        L_0x0136:
            r3 = 314(0x13a, float:4.4E-43)
            return r3
        L_0x0139:
            r3 = 313(0x139, float:4.39E-43)
            return r3
        L_0x013c:
            r3 = 423(0x1a7, float:5.93E-43)
            return r3
        L_0x013f:
            r3 = 315(0x13b, float:4.41E-43)
            return r3
        L_0x0142:
            r3 = 424(0x1a8, float:5.94E-43)
            return r3
        L_0x0145:
            r3 = 306(0x132, float:4.29E-43)
            return r3
        L_0x0148:
            r3 = 305(0x131, float:4.27E-43)
            return r3
        L_0x014b:
            r3 = 304(0x130, float:4.26E-43)
            return r3
        L_0x014e:
            r3 = 310(0x136, float:4.34E-43)
            return r3
        L_0x0151:
            r3 = 309(0x135, float:4.33E-43)
            return r3
        L_0x0154:
            r3 = 308(0x134, float:4.32E-43)
            return r3
        L_0x0157:
            r3 = 420(0x1a4, float:5.89E-43)
            return r3
        L_0x015a:
            r3 = 422(0x1a6, float:5.91E-43)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.key.MotionKeyCycle.e(java.lang.String):int");
    }

    public void f(HashMap<String, SplineSet> hashMap) {
    }

    /* renamed from: g */
    public MotionKey clone() {
        return null;
    }

    public void i(HashSet<String> hashSet) {
        if (!Float.isNaN(this.G)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.H)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.I)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.K)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.L)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.M)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.N)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.J)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.O)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.P)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.Q)) {
            hashSet.add("translationZ");
        }
        if (this.f3727l.size() > 0) {
            for (String str : this.f3727l.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public void v(HashMap<String, KeyCycleOscillator> hashMap) {
        KeyCycleOscillator keyCycleOscillator;
        KeyCycleOscillator keyCycleOscillator2;
        HashMap<String, KeyCycleOscillator> hashMap2 = hashMap;
        for (String next : hashMap.keySet()) {
            if (next.startsWith("CUSTOM")) {
                CustomVariable customVariable = this.f3727l.get(next.substring(7));
                if (!(customVariable == null || customVariable.m() != 901 || (keyCycleOscillator2 = hashMap2.get(next)) == null)) {
                    keyCycleOscillator2.g(this.f3723h, this.A, this.B, -1, this.C, this.D, this.E, customVariable.n(), customVariable);
                }
            } else {
                float x = x(next);
                if (!Float.isNaN(x) && (keyCycleOscillator = hashMap2.get(next)) != null) {
                    keyCycleOscillator.f(this.f3723h, this.A, this.B, -1, this.C, this.D, this.E, x);
                }
            }
        }
    }

    public void w() {
        PrintStream printStream = System.out;
        printStream.println("MotionKeyCycle{mWaveShape=" + this.A + ", mWavePeriod=" + this.C + ", mWaveOffset=" + this.D + ", mWavePhase=" + this.E + ", mRotation=" + this.I + ASCIIPropertyListParser.f18653k);
    }

    public float x(String str) {
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
            case -1249320804:
                if (str.equals("rotationZ")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1019779949:
                if (str.equals(TypedValues.CycleType.R)) {
                    c2 = 6;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c2 = 7;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c2 = 8;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
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
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = 11;
                    break;
                }
                break;
            case 106629499:
                if (str.equals(TypedValues.CycleType.S)) {
                    c2 = 12;
                    break;
                }
                break;
            case 803192288:
                if (str.equals("pathRotate")) {
                    c2 = 13;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return this.K;
            case 1:
                return this.L;
            case 2:
                return this.I;
            case 3:
                return this.O;
            case 4:
                return this.P;
            case 5:
                return this.Q;
            case 6:
                return this.D;
            case 7:
                return this.F;
            case 8:
                return this.M;
            case 9:
                return this.N;
            case 10:
                return this.H;
            case 11:
                return this.G;
            case 12:
                return this.E;
            case 13:
                return this.J;
            default:
                return Float.NaN;
        }
    }

    public void y() {
        HashSet hashSet = new HashSet();
        i(hashSet);
        Utils.c(" ------------- " + this.f3723h + " -------------");
        Utils.c("MotionKeyCycle{Shape=" + this.A + ", Period=" + this.C + ", Offset=" + this.D + ", Phase=" + this.E + ASCIIPropertyListParser.f18653k);
        String[] strArr = (String[]) hashSet.toArray(new String[0]);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            a.a(strArr[i2]);
            Utils.c(strArr[i2] + ":" + x(strArr[i2]));
        }
    }
}
