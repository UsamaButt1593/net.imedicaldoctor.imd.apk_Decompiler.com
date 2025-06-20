package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
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
    LinkedHashMap<String, ConstraintAttribute> s3 = new LinkedHashMap<>();
    int t3 = 0;
    double[] u3 = new double[18];
    double[] v3 = new double[18];

    private boolean f(float f2, float f4) {
        return (Float.isNaN(f2) || Float.isNaN(f4)) ? Float.isNaN(f2) != Float.isNaN(f4) : Math.abs(f2 - f4) > 1.0E-6f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x014b, code lost:
        r3.g(r10, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x015b, code lost:
        r3.g(r10, r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r9, int r10) {
        /*
            r8 = this;
            r0 = 1
            java.util.Set r1 = r9.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0009:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01f4
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r9.get(r2)
            androidx.constraintlayout.motion.utils.ViewSpline r3 = (androidx.constraintlayout.motion.utils.ViewSpline) r3
            r2.hashCode()
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            r6 = -1
            int r7 = r2.hashCode()
            switch(r7) {
                case -1249320806: goto L_0x00cc;
                case -1249320805: goto L_0x00c1;
                case -1225497657: goto L_0x00b6;
                case -1225497656: goto L_0x00ab;
                case -1225497655: goto L_0x00a0;
                case -1001078227: goto L_0x0095;
                case -908189618: goto L_0x008a;
                case -908189617: goto L_0x007f;
                case -760884510: goto L_0x0071;
                case -760884509: goto L_0x0063;
                case -40300674: goto L_0x0055;
                case -4379043: goto L_0x0047;
                case 37232917: goto L_0x0039;
                case 92909918: goto L_0x002b;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x00d6
        L_0x002b:
            java.lang.String r7 = "alpha"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x0035
            goto L_0x00d6
        L_0x0035:
            r6 = 13
            goto L_0x00d6
        L_0x0039:
            java.lang.String r7 = "transitionPathRotate"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x0043
            goto L_0x00d6
        L_0x0043:
            r6 = 12
            goto L_0x00d6
        L_0x0047:
            java.lang.String r7 = "elevation"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x0051
            goto L_0x00d6
        L_0x0051:
            r6 = 11
            goto L_0x00d6
        L_0x0055:
            java.lang.String r7 = "rotation"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x005f
            goto L_0x00d6
        L_0x005f:
            r6 = 10
            goto L_0x00d6
        L_0x0063:
            java.lang.String r7 = "transformPivotY"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x006d
            goto L_0x00d6
        L_0x006d:
            r6 = 9
            goto L_0x00d6
        L_0x0071:
            java.lang.String r7 = "transformPivotX"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x007b
            goto L_0x00d6
        L_0x007b:
            r6 = 8
            goto L_0x00d6
        L_0x007f:
            java.lang.String r7 = "scaleY"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x0088
            goto L_0x00d6
        L_0x0088:
            r6 = 7
            goto L_0x00d6
        L_0x008a:
            java.lang.String r7 = "scaleX"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x0093
            goto L_0x00d6
        L_0x0093:
            r6 = 6
            goto L_0x00d6
        L_0x0095:
            java.lang.String r7 = "progress"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x009e
            goto L_0x00d6
        L_0x009e:
            r6 = 5
            goto L_0x00d6
        L_0x00a0:
            java.lang.String r7 = "translationZ"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x00a9
            goto L_0x00d6
        L_0x00a9:
            r6 = 4
            goto L_0x00d6
        L_0x00ab:
            java.lang.String r7 = "translationY"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x00b4
            goto L_0x00d6
        L_0x00b4:
            r6 = 3
            goto L_0x00d6
        L_0x00b6:
            java.lang.String r7 = "translationX"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x00bf
            goto L_0x00d6
        L_0x00bf:
            r6 = 2
            goto L_0x00d6
        L_0x00c1:
            java.lang.String r7 = "rotationY"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x00ca
            goto L_0x00d6
        L_0x00ca:
            r6 = 1
            goto L_0x00d6
        L_0x00cc:
            java.lang.String r7 = "rotationX"
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L_0x00d5
            goto L_0x00d6
        L_0x00d5:
            r6 = 0
        L_0x00d6:
            switch(r6) {
                case 0: goto L_0x01e6;
                case 1: goto L_0x01d8;
                case 2: goto L_0x01cc;
                case 3: goto L_0x01c0;
                case 4: goto L_0x01b4;
                case 5: goto L_0x01a8;
                case 6: goto L_0x019c;
                case 7: goto L_0x0190;
                case 8: goto L_0x0184;
                case 9: goto L_0x0178;
                case 10: goto L_0x016c;
                case 11: goto L_0x0160;
                case 12: goto L_0x0150;
                case 13: goto L_0x0140;
                default: goto L_0x00d9;
            }
        L_0x00d9:
            java.lang.String r4 = "CUSTOM"
            boolean r4 = r2.startsWith(r4)
            java.lang.String r5 = "MotionPaths"
            if (r4 == 0) goto L_0x012e
            java.lang.String r4 = ","
            java.lang.String[] r4 = r2.split(r4)
            r4 = r4[r0]
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r6 = r8.s3
            boolean r6 = r6.containsKey(r4)
            if (r6 == 0) goto L_0x0009
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r6 = r8.s3
            java.lang.Object r4 = r6.get(r4)
            androidx.constraintlayout.widget.ConstraintAttribute r4 = (androidx.constraintlayout.widget.ConstraintAttribute) r4
            boolean r6 = r3 instanceof androidx.constraintlayout.motion.utils.ViewSpline.CustomSet
            if (r6 == 0) goto L_0x0106
            androidx.constraintlayout.motion.utils.ViewSpline$CustomSet r3 = (androidx.constraintlayout.motion.utils.ViewSpline.CustomSet) r3
            r3.n(r10, r4)
            goto L_0x0009
        L_0x0106:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            java.lang.String r2 = " ViewSpline not a CustomSet frame = "
            r6.append(r2)
            r6.append(r10)
            java.lang.String r2 = ", value"
            r6.append(r2)
            float r2 = r4.k()
            r6.append(r2)
            r6.append(r3)
            java.lang.String r2 = r6.toString()
        L_0x0129:
            android.util.Log.e(r5, r2)
            goto L_0x0009
        L_0x012e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "UNKNOWN spline "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            goto L_0x0129
        L_0x0140:
            float r2 = r8.s
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x0149
            goto L_0x014b
        L_0x0149:
            float r4 = r8.s
        L_0x014b:
            r3.g(r10, r4)
            goto L_0x0009
        L_0x0150:
            float r2 = r8.p3
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x0159
            goto L_0x015b
        L_0x0159:
            float r5 = r8.p3
        L_0x015b:
            r3.g(r10, r5)
            goto L_0x0009
        L_0x0160:
            float r2 = r8.X2
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x0169
            goto L_0x015b
        L_0x0169:
            float r5 = r8.X2
            goto L_0x015b
        L_0x016c:
            float r2 = r8.Y2
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x0175
            goto L_0x015b
        L_0x0175:
            float r5 = r8.Y2
            goto L_0x015b
        L_0x0178:
            float r2 = r8.e3
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x0181
            goto L_0x015b
        L_0x0181:
            float r5 = r8.e3
            goto L_0x015b
        L_0x0184:
            float r2 = r8.d3
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x018d
            goto L_0x015b
        L_0x018d:
            float r5 = r8.d3
            goto L_0x015b
        L_0x0190:
            float r2 = r8.c3
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x0199
            goto L_0x014b
        L_0x0199:
            float r4 = r8.c3
            goto L_0x014b
        L_0x019c:
            float r2 = r8.b3
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x01a5
            goto L_0x014b
        L_0x01a5:
            float r4 = r8.b3
            goto L_0x014b
        L_0x01a8:
            float r2 = r8.q3
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x01b1
            goto L_0x015b
        L_0x01b1:
            float r5 = r8.q3
            goto L_0x015b
        L_0x01b4:
            float r2 = r8.h3
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x01bd
            goto L_0x015b
        L_0x01bd:
            float r5 = r8.h3
            goto L_0x015b
        L_0x01c0:
            float r2 = r8.g3
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x01c9
            goto L_0x015b
        L_0x01c9:
            float r5 = r8.g3
            goto L_0x015b
        L_0x01cc:
            float r2 = r8.f3
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x01d5
            goto L_0x015b
        L_0x01d5:
            float r5 = r8.f3
            goto L_0x015b
        L_0x01d8:
            float r2 = r8.a3
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x01e2
            goto L_0x015b
        L_0x01e2:
            float r5 = r8.a3
            goto L_0x015b
        L_0x01e6:
            float r2 = r8.Z2
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 == 0) goto L_0x01f0
            goto L_0x015b
        L_0x01f0:
            float r5 = r8.Z2
            goto L_0x015b
        L_0x01f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionConstrainedPoint.a(java.util.HashMap, int):void");
    }

    public void b(View view) {
        this.Y = view.getVisibility();
        this.s = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.Z = false;
        this.X2 = view.getElevation();
        this.Y2 = view.getRotation();
        this.Z2 = view.getRotationX();
        this.a3 = view.getRotationY();
        this.b3 = view.getScaleX();
        this.c3 = view.getScaleY();
        this.d3 = view.getPivotX();
        this.e3 = view.getPivotY();
        this.f3 = view.getTranslationX();
        this.g3 = view.getTranslationY();
        this.h3 = view.getTranslationZ();
    }

    public void c(ConstraintSet.Constraint constraint) {
        ConstraintSet.PropertySet propertySet = constraint.f4712c;
        int i2 = propertySet.f4762c;
        this.X = i2;
        int i4 = propertySet.f4761b;
        this.Y = i4;
        this.s = (i4 == 0 || i2 != 0) ? propertySet.f4763d : 0.0f;
        ConstraintSet.Transform transform = constraint.f4715f;
        this.Z = transform.f4777m;
        this.X2 = transform.f4778n;
        this.Y2 = transform.f4766b;
        this.Z2 = transform.f4767c;
        this.a3 = transform.f4768d;
        this.b3 = transform.f4769e;
        this.c3 = transform.f4770f;
        this.d3 = transform.f4771g;
        this.e3 = transform.f4772h;
        this.f3 = transform.f4774j;
        this.g3 = transform.f4775k;
        this.h3 = transform.f4776l;
        this.i3 = Easing.c(constraint.f4713d.f4749d);
        ConstraintSet.Motion motion = constraint.f4713d;
        this.p3 = motion.f4754i;
        this.j3 = motion.f4751f;
        this.r3 = motion.f4747b;
        this.q3 = constraint.f4712c.f4764e;
        for (String next : constraint.f4716g.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.f4716g.get(next);
            if (constraintAttribute.n()) {
                this.s3.put(next, constraintAttribute);
            }
        }
    }

    /* renamed from: e */
    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.k3, motionConstrainedPoint.k3);
    }

    /* access modifiers changed from: package-private */
    public void g(MotionConstrainedPoint motionConstrainedPoint, HashSet<String> hashSet) {
        if (f(this.s, motionConstrainedPoint.s)) {
            hashSet.add("alpha");
        }
        if (f(this.X2, motionConstrainedPoint.X2)) {
            hashSet.add("elevation");
        }
        int i2 = this.Y;
        int i4 = motionConstrainedPoint.Y;
        if (i2 != i4 && this.X == 0 && (i2 == 0 || i4 == 0)) {
            hashSet.add("alpha");
        }
        if (f(this.Y2, motionConstrainedPoint.Y2)) {
            hashSet.add(Key.f4369i);
        }
        if (!Float.isNaN(this.p3) || !Float.isNaN(motionConstrainedPoint.p3)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.q3) || !Float.isNaN(motionConstrainedPoint.q3)) {
            hashSet.add("progress");
        }
        if (f(this.Z2, motionConstrainedPoint.Z2)) {
            hashSet.add("rotationX");
        }
        if (f(this.a3, motionConstrainedPoint.a3)) {
            hashSet.add("rotationY");
        }
        if (f(this.d3, motionConstrainedPoint.d3)) {
            hashSet.add(Key.f4372l);
        }
        if (f(this.e3, motionConstrainedPoint.e3)) {
            hashSet.add(Key.f4373m);
        }
        if (f(this.b3, motionConstrainedPoint.b3)) {
            hashSet.add("scaleX");
        }
        if (f(this.c3, motionConstrainedPoint.c3)) {
            hashSet.add("scaleY");
        }
        if (f(this.f3, motionConstrainedPoint.f3)) {
            hashSet.add("translationX");
        }
        if (f(this.g3, motionConstrainedPoint.g3)) {
            hashSet.add("translationY");
        }
        if (f(this.h3, motionConstrainedPoint.h3)) {
            hashSet.add("translationZ");
        }
    }

    /* access modifiers changed from: package-private */
    public void h(MotionConstrainedPoint motionConstrainedPoint, boolean[] zArr, String[] strArr) {
        zArr[0] = zArr[0] | f(this.k3, motionConstrainedPoint.k3);
        zArr[1] = zArr[1] | f(this.l3, motionConstrainedPoint.l3);
        zArr[2] = zArr[2] | f(this.m3, motionConstrainedPoint.m3);
        zArr[3] = zArr[3] | f(this.n3, motionConstrainedPoint.n3);
        zArr[4] = f(this.o3, motionConstrainedPoint.o3) | zArr[4];
    }

    /* access modifiers changed from: package-private */
    public void i(double[] dArr, int[] iArr) {
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
    public int j(String str, double[] dArr, int i2) {
        ConstraintAttribute constraintAttribute = this.s3.get(str);
        if (constraintAttribute.p() == 1) {
            dArr[i2] = (double) constraintAttribute.k();
            return 1;
        }
        int p = constraintAttribute.p();
        float[] fArr = new float[p];
        constraintAttribute.l(fArr);
        int i4 = 0;
        while (i4 < p) {
            dArr[i2] = (double) fArr[i4];
            i4++;
            i2++;
        }
        return p;
    }

    /* access modifiers changed from: package-private */
    public int k(String str) {
        return this.s3.get(str).p();
    }

    /* access modifiers changed from: package-private */
    public boolean l(String str) {
        return this.s3.containsKey(str);
    }

    /* access modifiers changed from: package-private */
    public void m(float f2, float f4, float f5, float f6) {
        this.l3 = f2;
        this.m3 = f4;
        this.n3 = f5;
        this.o3 = f6;
    }

    public void n(Rect rect, View view, int i2, float f2) {
        float f4;
        m((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        b(view);
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

    public void o(Rect rect, ConstraintSet constraintSet, int i2, int i4) {
        float f2;
        m((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        c(constraintSet.q0(i4));
        float f4 = 90.0f;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return;
                    }
                }
            }
            f2 = this.Y2 + 90.0f;
            this.Y2 = f2;
            if (f2 > 180.0f) {
                f4 = 360.0f;
                this.Y2 = f2 - f4;
            }
            return;
        }
        f2 = this.Y2;
        this.Y2 = f2 - f4;
    }

    public void p(View view) {
        m(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        b(view);
    }
}
