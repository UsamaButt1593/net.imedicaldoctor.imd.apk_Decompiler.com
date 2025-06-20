package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.utils.a;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;

public class MotionKeyAttributes extends MotionKey {
    static final String P = "KeyAttribute";
    private static final String Q = "KeyAttributes";
    private static final boolean R = false;
    public static final int S = 1;
    private int A = 0;
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
    private float M = Float.NaN;
    private float N = Float.NaN;
    private float O = Float.NaN;
    private String y;
    private int z = -1;

    public MotionKeyAttributes() {
        this.f3726k = 1;
        this.f3727l = new HashMap<>();
    }

    private float w(int i2) {
        if (i2 == 100) {
            return (float) this.f3723h;
        }
        switch (i2) {
            case 303:
                return this.B;
            case 304:
                return this.L;
            case 305:
                return this.M;
            case 306:
                return this.N;
            case 307:
                return this.C;
            case 308:
                return this.E;
            case 309:
                return this.F;
            case 310:
                return this.D;
            case 311:
                return this.J;
            case 312:
                return this.K;
            case 313:
                return this.G;
            case 314:
                return this.H;
            case 315:
                return this.O;
            case 316:
                return this.I;
            default:
                return Float.NaN;
        }
    }

    public boolean a(int i2, int i3) {
        if (i2 == 100) {
            this.f3723h = i3;
            return true;
        } else if (i2 == 301) {
            this.z = i3;
            return true;
        } else if (i2 == 302) {
            this.A = i3;
            return true;
        } else if (!a(i2, i3)) {
            return super.a(i2, i3);
        } else {
            return true;
        }
    }

    public boolean b(int i2, float f2) {
        if (i2 != 100) {
            switch (i2) {
                case 303:
                    this.B = f2;
                    return true;
                case 304:
                    this.L = f2;
                    return true;
                case 305:
                    this.M = f2;
                    return true;
                case 306:
                    this.N = f2;
                    return true;
                case 307:
                    this.C = f2;
                    return true;
                case 308:
                    this.E = f2;
                    return true;
                case 309:
                    this.F = f2;
                    return true;
                case 310:
                    this.D = f2;
                    return true;
                case 311:
                    this.J = f2;
                    return true;
                case 312:
                    this.K = f2;
                    return true;
                case 313:
                    this.G = f2;
                    return true;
                case 314:
                    this.H = f2;
                    return true;
                case 315:
                    this.O = f2;
                    return true;
                case 316:
                    break;
                default:
                    return super.b(i2, f2);
            }
        }
        this.I = f2;
        return true;
    }

    public boolean c(int i2, String str) {
        if (i2 == 101) {
            this.f3725j = str;
            return true;
        } else if (i2 != 317) {
            return super.c(i2, str);
        } else {
            this.y = str;
            return true;
        }
    }

    public int e(String str) {
        return a.a(str);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0118, code lost:
        r3.g(r2, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.SplineSet> r7) {
        /*
            r6 = this;
            r0 = 7
            java.util.Set r1 = r7.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0009:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01ca
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
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.CustomVariable> r4 = r6.f3727l
            java.lang.Object r2 = r4.get(r2)
            androidx.constraintlayout.core.motion.CustomVariable r2 = (androidx.constraintlayout.core.motion.CustomVariable) r2
            if (r2 == 0) goto L_0x0009
            androidx.constraintlayout.core.motion.utils.SplineSet$CustomSpline r3 = (androidx.constraintlayout.core.motion.utils.SplineSet.CustomSpline) r3
            int r4 = r6.f3723h
            r3.k(r4, r2)
            goto L_0x0009
        L_0x003c:
            r4 = -1
            int r5 = r2.hashCode()
            switch(r5) {
                case -1249320806: goto L_0x00e7;
                case -1249320805: goto L_0x00dc;
                case -1249320804: goto L_0x00d1;
                case -1225497657: goto L_0x00c6;
                case -1225497656: goto L_0x00bb;
                case -1225497655: goto L_0x00b0;
                case -1001078227: goto L_0x00a5;
                case -987906986: goto L_0x009a;
                case -987906985: goto L_0x008c;
                case -908189618: goto L_0x007e;
                case -908189617: goto L_0x0070;
                case -4379043: goto L_0x0062;
                case 92909918: goto L_0x0054;
                case 803192288: goto L_0x0046;
                default: goto L_0x0044;
            }
        L_0x0044:
            goto L_0x00f1
        L_0x0046:
            java.lang.String r5 = "pathRotate"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x0050
            goto L_0x00f1
        L_0x0050:
            r4 = 13
            goto L_0x00f1
        L_0x0054:
            java.lang.String r5 = "alpha"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x005e
            goto L_0x00f1
        L_0x005e:
            r4 = 12
            goto L_0x00f1
        L_0x0062:
            java.lang.String r5 = "elevation"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x006c
            goto L_0x00f1
        L_0x006c:
            r4 = 11
            goto L_0x00f1
        L_0x0070:
            java.lang.String r5 = "scaleY"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x007a
            goto L_0x00f1
        L_0x007a:
            r4 = 10
            goto L_0x00f1
        L_0x007e:
            java.lang.String r5 = "scaleX"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x0088
            goto L_0x00f1
        L_0x0088:
            r4 = 9
            goto L_0x00f1
        L_0x008c:
            java.lang.String r5 = "pivotY"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x0096
            goto L_0x00f1
        L_0x0096:
            r4 = 8
            goto L_0x00f1
        L_0x009a:
            java.lang.String r5 = "pivotX"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x00a3
            goto L_0x00f1
        L_0x00a3:
            r4 = 7
            goto L_0x00f1
        L_0x00a5:
            java.lang.String r5 = "progress"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x00ae
            goto L_0x00f1
        L_0x00ae:
            r4 = 6
            goto L_0x00f1
        L_0x00b0:
            java.lang.String r5 = "translationZ"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x00b9
            goto L_0x00f1
        L_0x00b9:
            r4 = 5
            goto L_0x00f1
        L_0x00bb:
            java.lang.String r5 = "translationY"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x00c4
            goto L_0x00f1
        L_0x00c4:
            r4 = 4
            goto L_0x00f1
        L_0x00c6:
            java.lang.String r5 = "translationX"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x00cf
            goto L_0x00f1
        L_0x00cf:
            r4 = 3
            goto L_0x00f1
        L_0x00d1:
            java.lang.String r5 = "rotationZ"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x00da
            goto L_0x00f1
        L_0x00da:
            r4 = 2
            goto L_0x00f1
        L_0x00dc:
            java.lang.String r5 = "rotationY"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x00e5
            goto L_0x00f1
        L_0x00e5:
            r4 = 1
            goto L_0x00f1
        L_0x00e7:
            java.lang.String r5 = "rotationX"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x00f0
            goto L_0x00f1
        L_0x00f0:
            r4 = 0
        L_0x00f1:
            switch(r4) {
                case 0: goto L_0x01bc;
                case 1: goto L_0x01ae;
                case 2: goto L_0x01a0;
                case 3: goto L_0x0192;
                case 4: goto L_0x0185;
                case 5: goto L_0x0178;
                case 6: goto L_0x016b;
                case 7: goto L_0x015e;
                case 8: goto L_0x0151;
                case 9: goto L_0x0144;
                case 10: goto L_0x0137;
                case 11: goto L_0x012a;
                case 12: goto L_0x011d;
                case 13: goto L_0x010c;
                default: goto L_0x00f4;
            }
        L_0x00f4:
            java.io.PrintStream r3 = java.lang.System.err
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "not supported by KeyAttributes "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.println(r2)
            goto L_0x0009
        L_0x010c:
            float r2 = r6.I
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f3723h
            float r4 = r6.I
        L_0x0118:
            r3.g(r2, r4)
            goto L_0x0009
        L_0x011d:
            float r2 = r6.B
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f3723h
            float r4 = r6.B
            goto L_0x0118
        L_0x012a:
            float r2 = r6.C
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f3723h
            float r4 = r6.C
            goto L_0x0118
        L_0x0137:
            float r2 = r6.K
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f3723h
            float r4 = r6.K
            goto L_0x0118
        L_0x0144:
            float r2 = r6.J
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f3723h
            float r4 = r6.J
            goto L_0x0118
        L_0x0151:
            float r2 = r6.F
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f3723h
            float r4 = r6.H
            goto L_0x0118
        L_0x015e:
            float r2 = r6.E
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f3723h
            float r4 = r6.G
            goto L_0x0118
        L_0x016b:
            float r2 = r6.O
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f3723h
            float r4 = r6.O
            goto L_0x0118
        L_0x0178:
            float r2 = r6.N
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f3723h
            float r4 = r6.N
            goto L_0x0118
        L_0x0185:
            float r2 = r6.M
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f3723h
            float r4 = r6.M
            goto L_0x0118
        L_0x0192:
            float r2 = r6.L
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f3723h
            float r4 = r6.L
            goto L_0x0118
        L_0x01a0:
            float r2 = r6.D
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f3723h
            float r4 = r6.D
            goto L_0x0118
        L_0x01ae:
            float r2 = r6.F
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f3723h
            float r4 = r6.F
            goto L_0x0118
        L_0x01bc:
            float r2 = r6.E
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto L_0x0009
            int r2 = r6.f3723h
            float r4 = r6.E
            goto L_0x0118
        L_0x01ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.key.MotionKeyAttributes.f(java.util.HashMap):void");
    }

    /* renamed from: g */
    public MotionKey clone() {
        return null;
    }

    public void i(HashSet<String> hashSet) {
        if (!Float.isNaN(this.B)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.C)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.D)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.E)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.F)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.G)) {
            hashSet.add("pivotX");
        }
        if (!Float.isNaN(this.H)) {
            hashSet.add("pivotY");
        }
        if (!Float.isNaN(this.L)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.M)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.N)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.I)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.J)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.K)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.O)) {
            hashSet.add("progress");
        }
        if (this.f3727l.size() > 0) {
            for (String str : this.f3727l.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public void q(HashMap<String, Integer> hashMap) {
        if (!Float.isNaN(this.B)) {
            hashMap.put("alpha", Integer.valueOf(this.z));
        }
        if (!Float.isNaN(this.C)) {
            hashMap.put("elevation", Integer.valueOf(this.z));
        }
        if (!Float.isNaN(this.D)) {
            hashMap.put("rotationZ", Integer.valueOf(this.z));
        }
        if (!Float.isNaN(this.E)) {
            hashMap.put("rotationX", Integer.valueOf(this.z));
        }
        if (!Float.isNaN(this.F)) {
            hashMap.put("rotationY", Integer.valueOf(this.z));
        }
        if (!Float.isNaN(this.G)) {
            hashMap.put("pivotX", Integer.valueOf(this.z));
        }
        if (!Float.isNaN(this.H)) {
            hashMap.put("pivotY", Integer.valueOf(this.z));
        }
        if (!Float.isNaN(this.L)) {
            hashMap.put("translationX", Integer.valueOf(this.z));
        }
        if (!Float.isNaN(this.M)) {
            hashMap.put("translationY", Integer.valueOf(this.z));
        }
        if (!Float.isNaN(this.N)) {
            hashMap.put("translationZ", Integer.valueOf(this.z));
        }
        if (!Float.isNaN(this.I)) {
            hashMap.put("pathRotate", Integer.valueOf(this.z));
        }
        if (!Float.isNaN(this.J)) {
            hashMap.put("scaleX", Integer.valueOf(this.z));
        }
        if (!Float.isNaN(this.K)) {
            hashMap.put("scaleY", Integer.valueOf(this.z));
        }
        if (!Float.isNaN(this.O)) {
            hashMap.put("progress", Integer.valueOf(this.z));
        }
        if (this.f3727l.size() > 0) {
            for (String str : this.f3727l.keySet()) {
                hashMap.put("CUSTOM," + str, Integer.valueOf(this.z));
            }
        }
    }

    public int v() {
        return this.z;
    }

    public void x() {
        HashSet hashSet = new HashSet();
        i(hashSet);
        PrintStream printStream = System.out;
        printStream.println(" ------------- " + this.f3723h + " -------------");
        String[] strArr = (String[]) hashSet.toArray(new String[0]);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            int a2 = a.a(strArr[i2]);
            PrintStream printStream2 = System.out;
            printStream2.println(strArr[i2] + ":" + w(a2));
        }
    }
}
