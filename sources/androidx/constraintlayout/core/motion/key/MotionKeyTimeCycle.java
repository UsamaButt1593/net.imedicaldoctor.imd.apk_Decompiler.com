package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.c;
import java.util.HashMap;
import java.util.HashSet;

public class MotionKeyTimeCycle extends MotionKey {
    static final String Q = "KeyTimeCycle";
    private static final String R = "KeyTimeCycle";
    public static final int S = 3;
    private float A = Float.NaN;
    private float B = Float.NaN;
    private float C = Float.NaN;
    private float D = Float.NaN;
    private float E = Float.NaN;
    private float F = Float.NaN;
    private float G = Float.NaN;
    private float H = Float.NaN;
    private float I = Float.NaN;
    private float J = Float.NaN;
    private float K = Float.NaN;
    private float L = Float.NaN;
    private int M = 0;
    private String N = null;
    private float O = Float.NaN;
    private float P = 0.0f;
    private String y;
    private int z = -1;

    public MotionKeyTimeCycle() {
        this.f3726k = 3;
        this.f3727l = new HashMap<>();
    }

    public boolean a(int i2, int i3) {
        if (i2 == 100) {
            this.f3723h = i3;
            return true;
        } else if (i2 != 421) {
            return super.a(i2, i3);
        } else {
            this.M = i3;
            return true;
        }
    }

    public boolean b(int i2, float f2) {
        if (i2 == 315) {
            this.L = t(Float.valueOf(f2));
            return true;
        } else if (i2 == 401) {
            this.z = u(Float.valueOf(f2));
            return true;
        } else if (i2 == 403) {
            this.A = f2;
            return true;
        } else if (i2 == 416) {
            this.F = t(Float.valueOf(f2));
            return true;
        } else if (i2 == 423) {
            this.O = t(Float.valueOf(f2));
            return true;
        } else if (i2 != 424) {
            switch (i2) {
                case 304:
                    this.I = t(Float.valueOf(f2));
                    return true;
                case 305:
                    this.J = t(Float.valueOf(f2));
                    return true;
                case 306:
                    this.K = t(Float.valueOf(f2));
                    return true;
                case 307:
                    this.B = t(Float.valueOf(f2));
                    return true;
                case 308:
                    this.D = t(Float.valueOf(f2));
                    return true;
                case 309:
                    this.E = t(Float.valueOf(f2));
                    return true;
                case 310:
                    this.C = t(Float.valueOf(f2));
                    return true;
                case 311:
                    this.G = t(Float.valueOf(f2));
                    return true;
                case 312:
                    this.H = t(Float.valueOf(f2));
                    return true;
                default:
                    return super.b(i2, f2);
            }
        } else {
            this.P = t(Float.valueOf(f2));
            return true;
        }
    }

    public boolean c(int i2, String str) {
        if (i2 == 420) {
            this.y = str;
            return true;
        } else if (i2 != 421) {
            return super.c(i2, str);
        } else {
            this.M = 7;
            this.N = str;
            return true;
        }
    }

    public boolean d(int i2, boolean z2) {
        return super.d(i2, z2);
    }

    public int e(String str) {
        return c.a(str);
    }

    public void f(HashMap<String, SplineSet> hashMap) {
    }

    /* renamed from: g */
    public MotionKey clone() {
        return new MotionKeyTimeCycle().h(this);
    }

    public void i(HashSet<String> hashSet) {
        if (!Float.isNaN(this.A)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.B)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.C)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.D)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.E)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.G)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.H)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.F)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.I)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.J)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.K)) {
            hashSet.add("translationZ");
        }
        if (this.f3727l.size() > 0) {
            for (String str : this.f3727l.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void v(java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet> r12) {
        /*
            r11 = this;
            r0 = 7
            java.util.Set r1 = r12.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0009:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01a2
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r12.get(r2)
            r4 = r3
            androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet r4 = (androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet) r4
            if (r4 != 0) goto L_0x001f
            goto L_0x0009
        L_0x001f:
            java.lang.String r3 = "CUSTOM"
            boolean r3 = r2.startsWith(r3)
            if (r3 == 0) goto L_0x0045
            java.lang.String r2 = r2.substring(r0)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.CustomVariable> r3 = r11.f3727l
            java.lang.Object r2 = r3.get(r2)
            r7 = r2
            androidx.constraintlayout.core.motion.CustomVariable r7 = (androidx.constraintlayout.core.motion.CustomVariable) r7
            if (r7 == 0) goto L_0x0009
            r5 = r4
            androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet$CustomVarSet r5 = (androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet.CustomVarSet) r5
            int r6 = r11.f3723h
            float r8 = r11.O
            int r9 = r11.M
            float r10 = r11.P
            r5.g(r6, r7, r8, r9, r10)
            goto L_0x0009
        L_0x0045:
            r3 = -1
            int r5 = r2.hashCode()
            switch(r5) {
                case -1249320806: goto L_0x00d4;
                case -1249320805: goto L_0x00c9;
                case -1249320804: goto L_0x00be;
                case -1225497657: goto L_0x00b3;
                case -1225497656: goto L_0x00a8;
                case -1225497655: goto L_0x009d;
                case -1001078227: goto L_0x0092;
                case -908189618: goto L_0x0087;
                case -908189617: goto L_0x0079;
                case -4379043: goto L_0x006b;
                case 92909918: goto L_0x005d;
                case 803192288: goto L_0x004f;
                default: goto L_0x004d;
            }
        L_0x004d:
            goto L_0x00de
        L_0x004f:
            java.lang.String r5 = "pathRotate"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x0059
            goto L_0x00de
        L_0x0059:
            r3 = 11
            goto L_0x00de
        L_0x005d:
            java.lang.String r5 = "alpha"
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
            java.lang.String r5 = "scaleY"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x0083
            goto L_0x00de
        L_0x0083:
            r3 = 8
            goto L_0x00de
        L_0x0087:
            java.lang.String r5 = "scaleX"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x0090
            goto L_0x00de
        L_0x0090:
            r3 = 7
            goto L_0x00de
        L_0x0092:
            java.lang.String r5 = "progress"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x009b
            goto L_0x00de
        L_0x009b:
            r3 = 6
            goto L_0x00de
        L_0x009d:
            java.lang.String r5 = "translationZ"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x00a6
            goto L_0x00de
        L_0x00a6:
            r3 = 5
            goto L_0x00de
        L_0x00a8:
            java.lang.String r5 = "translationY"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x00b1
            goto L_0x00de
        L_0x00b1:
            r3 = 4
            goto L_0x00de
        L_0x00b3:
            java.lang.String r5 = "translationX"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x00bc
            goto L_0x00de
        L_0x00bc:
            r3 = 3
            goto L_0x00de
        L_0x00be:
            java.lang.String r5 = "rotationZ"
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
                case 0: goto L_0x0194;
                case 1: goto L_0x0186;
                case 2: goto L_0x0179;
                case 3: goto L_0x016c;
                case 4: goto L_0x015f;
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
            androidx.constraintlayout.core.motion.utils.Utils.f(r3, r2)
            goto L_0x0009
        L_0x00fe:
            float r2 = r11.F
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r5 = r11.f3723h
            float r6 = r11.F
        L_0x010a:
            float r7 = r11.O
            int r8 = r11.M
            float r9 = r11.P
            r4.c(r5, r6, r7, r8, r9)
            goto L_0x0009
        L_0x0115:
            float r2 = r11.A
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r5 = r11.f3723h
            float r6 = r11.A
            goto L_0x010a
        L_0x0122:
            float r2 = r11.K
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
        L_0x012a:
            int r5 = r11.f3723h
            float r6 = r11.K
            goto L_0x010a
        L_0x012f:
            float r2 = r11.H
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r5 = r11.f3723h
            float r6 = r11.H
            goto L_0x010a
        L_0x013c:
            float r2 = r11.G
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r5 = r11.f3723h
            float r6 = r11.G
            goto L_0x010a
        L_0x0149:
            float r2 = r11.L
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r5 = r11.f3723h
            float r6 = r11.L
            goto L_0x010a
        L_0x0156:
            float r2 = r11.K
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            goto L_0x012a
        L_0x015f:
            float r2 = r11.J
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r5 = r11.f3723h
            float r6 = r11.J
            goto L_0x010a
        L_0x016c:
            float r2 = r11.I
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r5 = r11.f3723h
            float r6 = r11.I
            goto L_0x010a
        L_0x0179:
            float r2 = r11.C
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r5 = r11.f3723h
            float r6 = r11.C
            goto L_0x010a
        L_0x0186:
            float r2 = r11.E
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r5 = r11.f3723h
            float r6 = r11.E
            goto L_0x010a
        L_0x0194:
            float r2 = r11.D
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r5 = r11.f3723h
            float r6 = r11.D
            goto L_0x010a
        L_0x01a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle.v(java.util.HashMap):void");
    }

    /* renamed from: w */
    public MotionKeyTimeCycle h(MotionKey motionKey) {
        super.h(motionKey);
        MotionKeyTimeCycle motionKeyTimeCycle = (MotionKeyTimeCycle) motionKey;
        this.y = motionKeyTimeCycle.y;
        this.z = motionKeyTimeCycle.z;
        this.M = motionKeyTimeCycle.M;
        this.O = motionKeyTimeCycle.O;
        this.P = motionKeyTimeCycle.P;
        this.L = motionKeyTimeCycle.L;
        this.A = motionKeyTimeCycle.A;
        this.B = motionKeyTimeCycle.B;
        this.C = motionKeyTimeCycle.C;
        this.F = motionKeyTimeCycle.F;
        this.D = motionKeyTimeCycle.D;
        this.E = motionKeyTimeCycle.E;
        this.G = motionKeyTimeCycle.G;
        this.H = motionKeyTimeCycle.H;
        this.I = motionKeyTimeCycle.I;
        this.J = motionKeyTimeCycle.J;
        this.K = motionKeyTimeCycle.K;
        return this;
    }
}
