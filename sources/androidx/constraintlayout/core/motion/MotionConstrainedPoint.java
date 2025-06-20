package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.Rect;
import com.itextpdf.tool.xml.css.CSS;
import java.util.HashSet;
import java.util.LinkedHashMap;

class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    static String[] A3 = {CSS.Property.m0, "x", "y", "width", "height", "pathRotate"};
    public static final String w3 = "MotionPaths";
    public static final boolean x3 = false;
    static final int y3 = 1;
    static final int z3 = 2;
    int X = 0;
    private float X2 = 0.0f;
    int Y;
    private float Y2 = 0.0f;
    private boolean Z = false;
    private float Z2 = 0.0f;
    public float a3 = 0.0f;
    private float b3 = 1.0f;
    private float c3 = 1.0f;
    private float d3 = Float.NaN;
    private float e3 = Float.NaN;
    private float f3 = 0.0f;
    private float g3 = 0.0f;
    private float h3 = 0.0f;
    private Easing i3;
    private int j3 = 0;
    private float k3;
    private float l3;
    private float m3;
    private float n3;
    private float o3;
    private float p3 = Float.NaN;
    private float q3 = Float.NaN;
    private int r3 = -1;
    private float s = 1.0f;
    LinkedHashMap<String, CustomVariable> s3 = new LinkedHashMap<>();
    int t3 = 0;
    double[] u3 = new double[18];
    double[] v3 = new double[18];

    private boolean e(float f2, float f4) {
        return (Float.isNaN(f2) || Float.isNaN(f4)) ? Float.isNaN(f2) != Float.isNaN(f4) : Math.abs(f2 - f4) > 1.0E-6f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x013d, code lost:
        r3.g(r10, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x014d, code lost:
        r3.g(r10, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.SplineSet> r9, int r10) {
        /*
            r8 = this;
            r0 = 1
            java.util.Set r1 = r9.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0009:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01db
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r9.get(r2)
            androidx.constraintlayout.core.motion.utils.SplineSet r3 = (androidx.constraintlayout.core.motion.utils.SplineSet) r3
            r2.hashCode()
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            r6 = -1
            int r7 = r2.hashCode()
            switch(r7) {
                case -1249320806: goto L_0x00be;
                case -1249320805: goto L_0x00b3;
                case -1249320804: goto L_0x00a8;
                case -1225497657: goto L_0x009d;
                case -1225497656: goto L_0x0092;
                case -1225497655: goto L_0x0087;
                case -1001078227: goto L_0x007c;
                case -987906986: goto L_0x0071;
                case -987906985: goto L_0x0063;
                case -908189618: goto L_0x0055;
                case -908189617: goto L_0x0047;
                case 92909918: goto L_0x0039;
                case 803192288: goto L_0x002b;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x00c8
        L_0x002b:
            java.lang.String r7 = "pathRotate"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x0035
            goto L_0x00c8
        L_0x0035:
            r6 = 12
            goto L_0x00c8
        L_0x0039:
            java.lang.String r7 = "alpha"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x0043
            goto L_0x00c8
        L_0x0043:
            r6 = 11
            goto L_0x00c8
        L_0x0047:
            java.lang.String r7 = "scaleY"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x0051
            goto L_0x00c8
        L_0x0051:
            r6 = 10
            goto L_0x00c8
        L_0x0055:
            java.lang.String r7 = "scaleX"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x005f
            goto L_0x00c8
        L_0x005f:
            r6 = 9
            goto L_0x00c8
        L_0x0063:
            java.lang.String r7 = "pivotY"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x006d
            goto L_0x00c8
        L_0x006d:
            r6 = 8
            goto L_0x00c8
        L_0x0071:
            java.lang.String r7 = "pivotX"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x007a
            goto L_0x00c8
        L_0x007a:
            r6 = 7
            goto L_0x00c8
        L_0x007c:
            java.lang.String r7 = "progress"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x0085
            goto L_0x00c8
        L_0x0085:
            r6 = 6
            goto L_0x00c8
        L_0x0087:
            java.lang.String r7 = "translationZ"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x0090
            goto L_0x00c8
        L_0x0090:
            r6 = 5
            goto L_0x00c8
        L_0x0092:
            java.lang.String r7 = "translationY"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x009b
            goto L_0x00c8
        L_0x009b:
            r6 = 4
            goto L_0x00c8
        L_0x009d:
            java.lang.String r7 = "translationX"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x00a6
            goto L_0x00c8
        L_0x00a6:
            r6 = 3
            goto L_0x00c8
        L_0x00a8:
            java.lang.String r7 = "rotationZ"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x00b1
            goto L_0x00c8
        L_0x00b1:
            r6 = 2
            goto L_0x00c8
        L_0x00b3:
            java.lang.String r7 = "rotationY"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x00bc
            goto L_0x00c8
        L_0x00bc:
            r6 = 1
            goto L_0x00c8
        L_0x00be:
            java.lang.String r7 = "rotationX"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x00c7
            goto L_0x00c8
        L_0x00c7:
            r6 = 0
        L_0x00c8:
            switch(r6) {
                case 0: goto L_0x01cd;
                case 1: goto L_0x01bf;
                case 2: goto L_0x01b2;
                case 3: goto L_0x01a6;
                case 4: goto L_0x019a;
                case 5: goto L_0x018e;
                case 6: goto L_0x0182;
                case 7: goto L_0x0176;
                case 8: goto L_0x016a;
                case 9: goto L_0x015e;
                case 10: goto L_0x0152;
                case 11: goto L_0x0142;
                case 12: goto L_0x0132;
                default: goto L_0x00cb;
            }
        L_0x00cb:
            java.lang.String r4 = "CUSTOM"
            boolean r4 = r2.startsWith(r4)
            java.lang.String r5 = "MotionPaths"
            if (r4 == 0) goto L_0x0120
            java.lang.String r4 = ","
            java.lang.String[] r4 = r2.split(r4)
            r4 = r4[r0]
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.core.motion.CustomVariable> r6 = r8.s3
            boolean r6 = r6.containsKey(r4)
            if (r6 == 0) goto L_0x0009
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.core.motion.CustomVariable> r6 = r8.s3
            java.lang.Object r4 = r6.get(r4)
            androidx.constraintlayout.core.motion.CustomVariable r4 = (androidx.constraintlayout.core.motion.CustomVariable) r4
            boolean r6 = r3 instanceof androidx.constraintlayout.core.motion.utils.SplineSet.CustomSpline
            if (r6 == 0) goto L_0x00f8
            androidx.constraintlayout.core.motion.utils.SplineSet$CustomSpline r3 = (androidx.constraintlayout.core.motion.utils.SplineSet.CustomSpline) r3
            r3.k(r10, r4)
            goto L_0x0009
        L_0x00f8:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            java.lang.String r2 = " ViewSpline not a CustomSet frame = "
            r6.append(r2)
            r6.append(r10)
            java.lang.String r2 = ", value"
            r6.append(r2)
            float r2 = r4.n()
            r6.append(r2)
            r6.append(r3)
            java.lang.String r2 = r6.toString()
        L_0x011b:
            androidx.constraintlayout.core.motion.utils.Utils.f(r5, r2)
            goto L_0x0009
        L_0x0120:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "UNKNOWN spline "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            goto L_0x011b
        L_0x0132:
            float r2 = r8.p3
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x013b
            goto L_0x013d
        L_0x013b:
            float r5 = r8.p3
        L_0x013d:
            r3.g(r10, r5)
            goto L_0x0009
        L_0x0142:
            float r2 = r8.s
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x014b
            goto L_0x014d
        L_0x014b:
            float r4 = r8.s
        L_0x014d:
            r3.g(r10, r4)
            goto L_0x0009
        L_0x0152:
            float r2 = r8.c3
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x015b
            goto L_0x014d
        L_0x015b:
            float r4 = r8.c3
            goto L_0x014d
        L_0x015e:
            float r2 = r8.b3
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x0167
            goto L_0x014d
        L_0x0167:
            float r4 = r8.b3
            goto L_0x014d
        L_0x016a:
            float r2 = r8.e3
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x0173
            goto L_0x013d
        L_0x0173:
            float r5 = r8.e3
            goto L_0x013d
        L_0x0176:
            float r2 = r8.d3
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x017f
            goto L_0x013d
        L_0x017f:
            float r5 = r8.d3
            goto L_0x013d
        L_0x0182:
            float r2 = r8.q3
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x018b
            goto L_0x013d
        L_0x018b:
            float r5 = r8.q3
            goto L_0x013d
        L_0x018e:
            float r2 = r8.h3
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x0197
            goto L_0x013d
        L_0x0197:
            float r5 = r8.h3
            goto L_0x013d
        L_0x019a:
            float r2 = r8.g3
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x01a3
            goto L_0x013d
        L_0x01a3:
            float r5 = r8.g3
            goto L_0x013d
        L_0x01a6:
            float r2 = r8.f3
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x01af
            goto L_0x013d
        L_0x01af:
            float r5 = r8.f3
            goto L_0x013d
        L_0x01b2:
            float r2 = r8.Y2
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x01bb
            goto L_0x013d
        L_0x01bb:
            float r5 = r8.Y2
            goto L_0x013d
        L_0x01bf:
            float r2 = r8.a3
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x01c9
            goto L_0x013d
        L_0x01c9:
            float r5 = r8.a3
            goto L_0x013d
        L_0x01cd:
            float r2 = r8.Z2
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x01d7
            goto L_0x013d
        L_0x01d7:
            float r5 = r8.Z2
            goto L_0x013d
        L_0x01db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.MotionConstrainedPoint.a(java.util.HashMap, int):void");
    }

    public void b(MotionWidget motionWidget) {
        this.Y = motionWidget.B();
        this.s = motionWidget.B() != 4 ? 0.0f : motionWidget.g();
        this.Z = false;
        this.Y2 = motionWidget.t();
        this.Z2 = motionWidget.r();
        this.a3 = motionWidget.s();
        this.b3 = motionWidget.u();
        this.c3 = motionWidget.v();
        this.d3 = motionWidget.o();
        this.e3 = motionWidget.p();
        this.f3 = motionWidget.x();
        this.g3 = motionWidget.y();
        this.h3 = motionWidget.z();
        for (String next : motionWidget.j()) {
            CustomVariable i2 = motionWidget.i(next);
            if (i2 != null && i2.q()) {
                this.s3.put(next, i2);
            }
        }
    }

    /* renamed from: c */
    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.k3, motionConstrainedPoint.k3);
    }

    /* access modifiers changed from: package-private */
    public void f(MotionConstrainedPoint motionConstrainedPoint, HashSet<String> hashSet) {
        if (e(this.s, motionConstrainedPoint.s)) {
            hashSet.add("alpha");
        }
        if (e(this.X2, motionConstrainedPoint.X2)) {
            hashSet.add("translationZ");
        }
        int i2 = this.Y;
        int i4 = motionConstrainedPoint.Y;
        if (i2 != i4 && this.X == 0 && (i2 == 4 || i4 == 4)) {
            hashSet.add("alpha");
        }
        if (e(this.Y2, motionConstrainedPoint.Y2)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.p3) || !Float.isNaN(motionConstrainedPoint.p3)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.q3) || !Float.isNaN(motionConstrainedPoint.q3)) {
            hashSet.add("progress");
        }
        if (e(this.Z2, motionConstrainedPoint.Z2)) {
            hashSet.add("rotationX");
        }
        if (e(this.a3, motionConstrainedPoint.a3)) {
            hashSet.add("rotationY");
        }
        if (e(this.d3, motionConstrainedPoint.d3)) {
            hashSet.add("pivotX");
        }
        if (e(this.e3, motionConstrainedPoint.e3)) {
            hashSet.add("pivotY");
        }
        if (e(this.b3, motionConstrainedPoint.b3)) {
            hashSet.add("scaleX");
        }
        if (e(this.c3, motionConstrainedPoint.c3)) {
            hashSet.add("scaleY");
        }
        if (e(this.f3, motionConstrainedPoint.f3)) {
            hashSet.add("translationX");
        }
        if (e(this.g3, motionConstrainedPoint.g3)) {
            hashSet.add("translationY");
        }
        if (e(this.h3, motionConstrainedPoint.h3)) {
            hashSet.add("translationZ");
        }
        if (e(this.X2, motionConstrainedPoint.X2)) {
            hashSet.add("elevation");
        }
    }

    /* access modifiers changed from: package-private */
    public void g(MotionConstrainedPoint motionConstrainedPoint, boolean[] zArr, String[] strArr) {
        zArr[0] = zArr[0] | e(this.k3, motionConstrainedPoint.k3);
        zArr[1] = zArr[1] | e(this.l3, motionConstrainedPoint.l3);
        zArr[2] = zArr[2] | e(this.m3, motionConstrainedPoint.m3);
        zArr[3] = zArr[3] | e(this.n3, motionConstrainedPoint.n3);
        zArr[4] = e(this.o3, motionConstrainedPoint.o3) | zArr[4];
    }

    /* access modifiers changed from: package-private */
    public void h(double[] dArr, int[] iArr) {
        int[] iArr2 = iArr;
        int i2 = 0;
        float[] fArr = {this.k3, this.l3, this.m3, this.n3, this.o3, this.s, this.X2, this.Y2, this.Z2, this.a3, this.b3, this.c3, this.d3, this.e3, this.f3, this.g3, this.h3, this.p3};
        int[] iArr3 = iArr;
        for (int i4 : iArr3) {
            if (i4 < 18) {
                dArr[i2] = (double) fArr[i4];
                i2++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int i(String str, double[] dArr, int i2) {
        CustomVariable customVariable = this.s3.get(str);
        if (customVariable.r() == 1) {
            dArr[i2] = (double) customVariable.n();
            return 1;
        }
        int r = customVariable.r();
        float[] fArr = new float[r];
        customVariable.o(fArr);
        int i4 = 0;
        while (i4 < r) {
            dArr[i2] = (double) fArr[i4];
            i4++;
            i2++;
        }
        return r;
    }

    /* access modifiers changed from: package-private */
    public int j(String str) {
        return this.s3.get(str).r();
    }

    /* access modifiers changed from: package-private */
    public boolean k(String str) {
        return this.s3.containsKey(str);
    }

    /* access modifiers changed from: package-private */
    public void l(float f2, float f4, float f5, float f6) {
        this.l3 = f2;
        this.m3 = f4;
        this.n3 = f5;
        this.o3 = f6;
    }

    public void m(MotionWidget motionWidget) {
        l((float) motionWidget.E(), (float) motionWidget.F(), (float) motionWidget.D(), (float) motionWidget.k());
        b(motionWidget);
    }

    public void n(Rect rect, MotionWidget motionWidget, int i2, float f2) {
        float f4;
        l((float) rect.f3856b, (float) rect.f3858d, (float) rect.b(), (float) rect.a());
        b(motionWidget);
        this.d3 = Float.NaN;
        this.e3 = Float.NaN;
        if (i2 == 1) {
            f4 = f2 - 90.0f;
        } else if (i2 == 2) {
            f4 = f2 + 90.0f;
        } else {
            return;
        }
        this.Y2 = f4;
    }
}
