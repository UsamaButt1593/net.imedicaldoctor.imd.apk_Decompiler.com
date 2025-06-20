package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import com.itextpdf.tool.xml.css.CSS;
import java.util.Arrays;
import java.util.HashMap;

public class MotionPaths implements Comparable<MotionPaths> {
    public static final String m3 = "MotionPaths";
    public static final boolean n3 = false;
    public static final boolean o3 = false;
    static final int p3 = 0;
    static final int q3 = 1;
    static final int r3 = 2;
    static final int s3 = 3;
    static final int t3 = 4;
    static final int u3 = 5;
    public static final int v3 = 1;
    public static final int w3 = 0;
    public static final int x3 = 2;
    static String[] y3 = {CSS.Property.m0, "x", "y", "width", "height", "pathRotate"};
    int X = 0;
    float X2;
    float Y;
    float Y2;
    float Z;
    float Z2;
    float a3;
    float b3 = Float.NaN;
    float c3 = Float.NaN;
    int d3 = -1;
    int e3 = -1;
    float f3 = Float.NaN;
    Motion g3 = null;
    HashMap<String, CustomVariable> h3 = new HashMap<>();
    int i3 = 0;
    int j3;
    double[] k3 = new double[18];
    double[] l3 = new double[18];
    Easing s;

    public MotionPaths() {
    }

    private boolean e(float f2, float f4) {
        return (Float.isNaN(f2) || Float.isNaN(f4)) ? Float.isNaN(f2) != Float.isNaN(f4) : Math.abs(f2 - f4) > 1.0E-6f;
    }

    private static final float y(float f2, float f4, float f5, float f6, float f7, float f8) {
        return (((f7 - f5) * f4) - ((f8 - f6) * f2)) + f5;
    }

    private static final float z(float f2, float f4, float f5, float f6, float f7, float f8) {
        return ((f7 - f5) * f2) + ((f8 - f6) * f4) + f6;
    }

    public void a(MotionWidget motionWidget) {
        this.s = Easing.c(motionWidget.f3686i.f3693c);
        MotionWidget.Motion motion = motionWidget.f3686i;
        this.d3 = motion.f3694d;
        this.e3 = motion.f3691a;
        this.b3 = motion.f3698h;
        this.X = motion.f3695e;
        this.j3 = motion.f3692b;
        this.c3 = motionWidget.f3687j.f3707d;
        this.f3 = 0.0f;
        for (String next : motionWidget.j()) {
            CustomVariable i2 = motionWidget.i(next);
            if (i2 != null && i2.q()) {
                this.h3.put(next, i2);
            }
        }
    }

    /* renamed from: b */
    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.Z, motionPaths.Z);
    }

    public void c(Motion motion) {
        motion.F((double) this.c3);
    }

    /* access modifiers changed from: package-private */
    public void f(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z) {
        boolean e2 = e(this.X2, motionPaths.X2);
        boolean e4 = e(this.Y2, motionPaths.Y2);
        zArr[0] = zArr[0] | e(this.Z, motionPaths.Z);
        boolean z2 = e2 | e4 | z;
        zArr[1] = zArr[1] | z2;
        zArr[2] = z2 | zArr[2];
        zArr[3] = zArr[3] | e(this.Z2, motionPaths.Z2);
        zArr[4] = e(this.a3, motionPaths.a3) | zArr[4];
    }

    /* access modifiers changed from: package-private */
    public void g(double[] dArr, int[] iArr) {
        float[] fArr = {this.Z, this.X2, this.Y2, this.Z2, this.a3, this.b3};
        int i2 = 0;
        for (int i4 : iArr) {
            if (i4 < 6) {
                dArr[i2] = (double) fArr[i4];
                i2++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h(int[] iArr, double[] dArr, float[] fArr, int i2) {
        float f2 = this.Z2;
        float f4 = this.a3;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            float f5 = (float) dArr[i4];
            int i5 = iArr[i4];
            if (i5 == 3) {
                f2 = f5;
            } else if (i5 == 4) {
                f4 = f5;
            }
        }
        fArr[i2] = f2;
        fArr[i2 + 1] = f4;
    }

    /* access modifiers changed from: package-private */
    public void i(double d2, int[] iArr, double[] dArr, float[] fArr, int i2) {
        int[] iArr2 = iArr;
        float f2 = this.X2;
        float f4 = this.Y2;
        float f5 = this.Z2;
        float f6 = this.a3;
        for (int i4 = 0; i4 < iArr2.length; i4++) {
            float f7 = (float) dArr[i4];
            int i5 = iArr2[i4];
            if (i5 == 1) {
                f2 = f7;
            } else if (i5 == 2) {
                f4 = f7;
            } else if (i5 == 3) {
                f5 = f7;
            } else if (i5 == 4) {
                f6 = f7;
            }
        }
        Motion motion = this.g3;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.r(d2, fArr2, new float[2]);
            float f8 = fArr2[0];
            float f9 = fArr2[1];
            double d4 = (double) f8;
            double d5 = (double) f2;
            double d6 = (double) f4;
            f2 = (float) ((d4 + (Math.sin(d6) * d5)) - ((double) (f5 / 2.0f)));
            f4 = (float) ((((double) f9) - (d5 * Math.cos(d6))) - ((double) (f6 / 2.0f)));
        }
        fArr[i2] = f2 + (f5 / 2.0f) + 0.0f;
        fArr[i2 + 1] = f4 + (f6 / 2.0f) + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public void j(double d2, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f2;
        int[] iArr2 = iArr;
        float f4 = this.X2;
        float f5 = this.Y2;
        float f6 = this.Z2;
        float f7 = this.a3;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            float f12 = (float) dArr[i2];
            float f13 = (float) dArr2[i2];
            int i4 = iArr2[i2];
            if (i4 == 1) {
                f4 = f12;
                f8 = f13;
            } else if (i4 == 2) {
                f5 = f12;
                f10 = f13;
            } else if (i4 == 3) {
                f6 = f12;
                f9 = f13;
            } else if (i4 == 4) {
                f7 = f12;
                f11 = f13;
            }
        }
        float f14 = 2.0f;
        float f15 = (f9 / 2.0f) + f8;
        float f16 = (f11 / 2.0f) + f10;
        Motion motion = this.g3;
        if (motion != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motion.r(d2, fArr3, fArr4);
            float f17 = fArr3[0];
            float f18 = fArr3[1];
            float f19 = fArr4[0];
            double d4 = (double) f4;
            float f20 = fArr4[1];
            double d5 = (double) f5;
            f2 = f6;
            double d6 = (double) f8;
            double d7 = (double) f10;
            float sin = (float) (((double) f19) + (Math.sin(d5) * d6) + (Math.cos(d5) * d7));
            f16 = (float) ((((double) f20) - (d6 * Math.cos(d5))) + (Math.sin(d5) * d7));
            f15 = sin;
            f4 = (float) ((((double) f17) + (Math.sin(d5) * d4)) - ((double) (f6 / 2.0f)));
            f5 = (float) ((((double) f18) - (d4 * Math.cos(d5))) - ((double) (f7 / 2.0f)));
            f14 = 2.0f;
        } else {
            f2 = f6;
        }
        fArr[0] = f4 + (f2 / f14) + 0.0f;
        fArr[1] = f5 + (f7 / f14) + 0.0f;
        fArr2[0] = f15;
        fArr2[1] = f16;
    }

    /* access modifiers changed from: package-private */
    public void k(double d2, int[] iArr, double[] dArr, float[] fArr, int i2) {
        int[] iArr2 = iArr;
        float f2 = this.X2;
        float f4 = this.Y2;
        float f5 = this.Z2;
        float f6 = this.a3;
        for (int i4 = 0; i4 < iArr2.length; i4++) {
            float f7 = (float) dArr[i4];
            int i5 = iArr2[i4];
            if (i5 == 1) {
                f2 = f7;
            } else if (i5 == 2) {
                f4 = f7;
            } else if (i5 == 3) {
                f5 = f7;
            } else if (i5 == 4) {
                f6 = f7;
            }
        }
        Motion motion = this.g3;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.r(d2, fArr2, new float[2]);
            float f8 = fArr2[0];
            float f9 = fArr2[1];
            double d4 = (double) f8;
            double d5 = (double) f2;
            double d6 = (double) f4;
            f2 = (float) ((d4 + (Math.sin(d6) * d5)) - ((double) (f5 / 2.0f)));
            f4 = (float) ((((double) f9) - (d5 * Math.cos(d6))) - ((double) (f6 / 2.0f)));
        }
        fArr[i2] = f2 + (f5 / 2.0f) + 0.0f;
        fArr[i2 + 1] = f4 + (f6 / 2.0f) + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public int l(String str, double[] dArr, int i2) {
        CustomVariable customVariable = this.h3.get(str);
        int i4 = 0;
        if (customVariable == null) {
            return 0;
        }
        if (customVariable.r() == 1) {
            dArr[i2] = (double) customVariable.n();
            return 1;
        }
        int r = customVariable.r();
        float[] fArr = new float[r];
        customVariable.o(fArr);
        while (i4 < r) {
            dArr[i2] = (double) fArr[i4];
            i4++;
            i2++;
        }
        return r;
    }

    /* access modifiers changed from: package-private */
    public int m(String str) {
        CustomVariable customVariable = this.h3.get(str);
        if (customVariable == null) {
            return 0;
        }
        return customVariable.r();
    }

    /* access modifiers changed from: package-private */
    public void n(int[] iArr, double[] dArr, float[] fArr, int i2) {
        float f2 = this.X2;
        float f4 = this.Y2;
        float f5 = this.Z2;
        float f6 = this.a3;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            float f7 = (float) dArr[i4];
            int i5 = iArr[i4];
            if (i5 == 1) {
                f2 = f7;
            } else if (i5 == 2) {
                f4 = f7;
            } else if (i5 == 3) {
                f5 = f7;
            } else if (i5 == 4) {
                f6 = f7;
            }
        }
        Motion motion = this.g3;
        if (motion != null) {
            float s2 = motion.s();
            double d2 = (double) f2;
            double d4 = (double) f4;
            f4 = (float) ((((double) this.g3.t()) - (d2 * Math.cos(d4))) - ((double) (f6 / 2.0f)));
            f2 = (float) ((((double) s2) + (Math.sin(d4) * d2)) - ((double) (f5 / 2.0f)));
        }
        float f8 = f5 + f2;
        float f9 = f6 + f4;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i2] = f2 + 0.0f;
        fArr[i2 + 1] = f4 + 0.0f;
        fArr[i2 + 2] = f8 + 0.0f;
        fArr[i2 + 3] = f4 + 0.0f;
        fArr[i2 + 4] = f8 + 0.0f;
        int i6 = i2 + 6;
        fArr[i2 + 5] = f9 + 0.0f;
        fArr[i6] = f2 + 0.0f;
        fArr[i2 + 7] = f9 + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public boolean o(String str) {
        return this.h3.containsKey(str);
    }

    /* access modifiers changed from: package-private */
    public void p(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        MotionKeyPosition motionKeyPosition2 = motionKeyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f2 = ((float) motionKeyPosition2.f3723h) / 100.0f;
        this.Y = f2;
        this.X = motionKeyPosition2.B;
        float f4 = Float.isNaN(motionKeyPosition2.C) ? f2 : motionKeyPosition2.C;
        float f5 = Float.isNaN(motionKeyPosition2.D) ? f2 : motionKeyPosition2.D;
        float f6 = motionPaths4.Z2;
        float f7 = motionPaths3.Z2;
        float f8 = motionPaths4.a3;
        float f9 = motionPaths3.a3;
        this.Z = this.Y;
        float f10 = motionPaths3.X2;
        float f11 = motionPaths3.Y2;
        float f12 = (motionPaths4.X2 + (f6 / 2.0f)) - ((f7 / 2.0f) + f10);
        float f13 = (motionPaths4.Y2 + (f8 / 2.0f)) - (f11 + (f9 / 2.0f));
        float f14 = (f6 - f7) * f4;
        float f15 = f14 / 2.0f;
        this.X2 = (float) ((int) ((f10 + (f12 * f2)) - f15));
        float f16 = (f8 - f9) * f5;
        float f17 = f16 / 2.0f;
        this.Y2 = (float) ((int) ((f11 + (f13 * f2)) - f17));
        this.Z2 = (float) ((int) (f7 + f14));
        this.a3 = (float) ((int) (f9 + f16));
        MotionKeyPosition motionKeyPosition3 = motionKeyPosition;
        float f18 = Float.isNaN(motionKeyPosition3.E) ? f2 : motionKeyPosition3.E;
        float f19 = 0.0f;
        float f20 = Float.isNaN(motionKeyPosition3.H) ? 0.0f : motionKeyPosition3.H;
        if (!Float.isNaN(motionKeyPosition3.F)) {
            f2 = motionKeyPosition3.F;
        }
        if (!Float.isNaN(motionKeyPosition3.G)) {
            f19 = motionKeyPosition3.G;
        }
        this.i3 = 0;
        MotionPaths motionPaths5 = motionPaths;
        this.X2 = (float) ((int) (((motionPaths5.X2 + (f18 * f12)) + (f19 * f13)) - f15));
        this.Y2 = (float) ((int) (((motionPaths5.Y2 + (f12 * f20)) + (f13 * f2)) - f17));
        this.s = Easing.c(motionKeyPosition3.z);
        this.d3 = motionKeyPosition3.A;
    }

    /* access modifiers changed from: package-private */
    public void q(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        MotionKeyPosition motionKeyPosition2 = motionKeyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f2 = ((float) motionKeyPosition2.f3723h) / 100.0f;
        this.Y = f2;
        this.X = motionKeyPosition2.B;
        float f4 = Float.isNaN(motionKeyPosition2.C) ? f2 : motionKeyPosition2.C;
        float f5 = Float.isNaN(motionKeyPosition2.D) ? f2 : motionKeyPosition2.D;
        float f6 = motionPaths4.Z2 - motionPaths3.Z2;
        float f7 = motionPaths4.a3 - motionPaths3.a3;
        this.Z = this.Y;
        if (!Float.isNaN(motionKeyPosition2.E)) {
            f2 = motionKeyPosition2.E;
        }
        float f8 = motionPaths3.X2;
        float f9 = motionPaths3.Z2;
        float f10 = motionPaths3.Y2;
        float f11 = motionPaths3.a3;
        float f12 = (motionPaths4.X2 + (motionPaths4.Z2 / 2.0f)) - ((f9 / 2.0f) + f8);
        float f13 = (motionPaths4.Y2 + (motionPaths4.a3 / 2.0f)) - ((f11 / 2.0f) + f10);
        float f14 = f12 * f2;
        float f15 = f6 * f4;
        float f16 = f15 / 2.0f;
        this.X2 = (float) ((int) ((f8 + f14) - f16));
        float f17 = f2 * f13;
        float f18 = f7 * f5;
        float f19 = f18 / 2.0f;
        this.Y2 = (float) ((int) ((f10 + f17) - f19));
        this.Z2 = (float) ((int) (f9 + f15));
        this.a3 = (float) ((int) (f11 + f18));
        MotionKeyPosition motionKeyPosition3 = motionKeyPosition;
        float f20 = Float.isNaN(motionKeyPosition3.F) ? 0.0f : motionKeyPosition3.F;
        float f21 = (-f13) * f20;
        float f22 = f12 * f20;
        this.i3 = 1;
        MotionPaths motionPaths5 = motionPaths;
        this.X2 = ((float) ((int) ((motionPaths5.X2 + f14) - f16))) + f21;
        this.Y2 = ((float) ((int) ((motionPaths5.Y2 + f17) - f19))) + f22;
        this.e3 = this.e3;
        this.s = Easing.c(motionKeyPosition3.z);
        this.d3 = motionKeyPosition3.A;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0068, code lost:
        if (java.lang.Float.isNaN(r9.F) != false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00bb, code lost:
        if (java.lang.Float.isNaN(r9.F) != false) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void r(int r7, int r8, androidx.constraintlayout.core.motion.key.MotionKeyPosition r9, androidx.constraintlayout.core.motion.MotionPaths r10, androidx.constraintlayout.core.motion.MotionPaths r11) {
        /*
            r6 = this;
            int r7 = r9.f3723h
            float r7 = (float) r7
            r8 = 1120403456(0x42c80000, float:100.0)
            float r7 = r7 / r8
            r6.Y = r7
            int r8 = r9.B
            r6.X = r8
            int r8 = r9.I
            r6.i3 = r8
            float r8 = r9.C
            boolean r8 = java.lang.Float.isNaN(r8)
            if (r8 == 0) goto L_0x001a
            r8 = r7
            goto L_0x001c
        L_0x001a:
            float r8 = r9.C
        L_0x001c:
            float r0 = r9.D
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 == 0) goto L_0x0026
            r0 = r7
            goto L_0x0028
        L_0x0026:
            float r0 = r9.D
        L_0x0028:
            float r1 = r11.Z2
            float r2 = r10.Z2
            float r1 = r1 - r2
            float r3 = r11.a3
            float r4 = r10.a3
            float r3 = r3 - r4
            float r5 = r6.Y
            r6.Z = r5
            float r1 = r1 * r8
            float r2 = r2 + r1
            int r1 = (int) r2
            float r1 = (float) r1
            r6.Z2 = r1
            float r3 = r3 * r0
            float r4 = r4 + r3
            int r1 = (int) r4
            float r1 = (float) r1
            r6.a3 = r1
            int r1 = r9.I
            r2 = 1
            if (r1 == r2) goto L_0x009f
            r2 = 2
            if (r1 == r2) goto L_0x0078
            float r8 = r9.E
            boolean r8 = java.lang.Float.isNaN(r8)
            if (r8 == 0) goto L_0x0056
            r8 = r7
            goto L_0x0058
        L_0x0056:
            float r8 = r9.E
        L_0x0058:
            float r0 = r11.X2
            float r1 = r10.X2
            float r0 = r0 - r1
            float r8 = r8 * r0
            float r8 = r8 + r1
            r6.X2 = r8
            float r8 = r9.F
            boolean r8 = java.lang.Float.isNaN(r8)
            if (r8 == 0) goto L_0x006b
            goto L_0x006d
        L_0x006b:
            float r7 = r9.F
        L_0x006d:
            float r8 = r11.Y2
            float r11 = r10.Y2
            float r8 = r8 - r11
            float r7 = r7 * r8
            float r7 = r7 + r11
        L_0x0075:
            r6.Y2 = r7
            goto L_0x00be
        L_0x0078:
            float r1 = r9.E
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0089
            float r8 = r11.X2
            float r0 = r10.X2
            float r8 = r8 - r0
            float r8 = r8 * r7
            float r8 = r8 + r0
            goto L_0x0091
        L_0x0089:
            float r1 = r9.E
            float r8 = java.lang.Math.min(r0, r8)
            float r8 = r8 * r1
        L_0x0091:
            r6.X2 = r8
            float r8 = r9.F
            boolean r8 = java.lang.Float.isNaN(r8)
            if (r8 == 0) goto L_0x009c
            goto L_0x006d
        L_0x009c:
            float r7 = r9.F
            goto L_0x0075
        L_0x009f:
            float r8 = r9.E
            boolean r8 = java.lang.Float.isNaN(r8)
            if (r8 == 0) goto L_0x00a9
            r8 = r7
            goto L_0x00ab
        L_0x00a9:
            float r8 = r9.E
        L_0x00ab:
            float r0 = r11.X2
            float r1 = r10.X2
            float r0 = r0 - r1
            float r8 = r8 * r0
            float r8 = r8 + r1
            r6.X2 = r8
            float r8 = r9.F
            boolean r8 = java.lang.Float.isNaN(r8)
            if (r8 == 0) goto L_0x006b
            goto L_0x006d
        L_0x00be:
            int r7 = r10.e3
            r6.e3 = r7
            java.lang.String r7 = r9.z
            androidx.constraintlayout.core.motion.utils.Easing r7 = androidx.constraintlayout.core.motion.utils.Easing.c(r7)
            r6.s = r7
            int r7 = r9.A
            r6.d3 = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.MotionPaths.r(int, int, androidx.constraintlayout.core.motion.key.MotionKeyPosition, androidx.constraintlayout.core.motion.MotionPaths, androidx.constraintlayout.core.motion.MotionPaths):void");
    }

    /* access modifiers changed from: package-private */
    public void s(int i2, int i4, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        MotionKeyPosition motionKeyPosition2 = motionKeyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f2 = ((float) motionKeyPosition2.f3723h) / 100.0f;
        this.Y = f2;
        this.X = motionKeyPosition2.B;
        float f4 = Float.isNaN(motionKeyPosition2.C) ? f2 : motionKeyPosition2.C;
        float f5 = Float.isNaN(motionKeyPosition2.D) ? f2 : motionKeyPosition2.D;
        float f6 = motionPaths4.Z2;
        float f7 = motionPaths3.Z2;
        float f8 = motionPaths4.a3;
        float f9 = motionPaths3.a3;
        this.Z = this.Y;
        float f10 = motionPaths3.X2;
        float f11 = motionPaths3.Y2;
        float f12 = motionPaths4.X2 + (f6 / 2.0f);
        float f13 = motionPaths4.Y2 + (f8 / 2.0f);
        float f14 = (f6 - f7) * f4;
        this.X2 = (float) ((int) ((f10 + ((f12 - ((f7 / 2.0f) + f10)) * f2)) - (f14 / 2.0f)));
        float f15 = (f8 - f9) * f5;
        this.Y2 = (float) ((int) ((f11 + ((f13 - (f11 + (f9 / 2.0f))) * f2)) - (f15 / 2.0f)));
        this.Z2 = (float) ((int) (f7 + f14));
        this.a3 = (float) ((int) (f9 + f15));
        this.i3 = 2;
        MotionKeyPosition motionKeyPosition3 = motionKeyPosition;
        if (!Float.isNaN(motionKeyPosition3.E)) {
            this.X2 = (float) ((int) (motionKeyPosition3.E * ((float) ((int) (((float) i2) - this.Z2)))));
        }
        if (!Float.isNaN(motionKeyPosition3.F)) {
            this.Y2 = (float) ((int) (motionKeyPosition3.F * ((float) ((int) (((float) i4) - this.a3)))));
        }
        this.e3 = this.e3;
        this.s = Easing.c(motionKeyPosition3.z);
        this.d3 = motionKeyPosition3.A;
    }

    /* access modifiers changed from: package-private */
    public void u(float f2, float f4, float f5, float f6) {
        this.X2 = f2;
        this.Y2 = f4;
        this.Z2 = f5;
        this.a3 = f6;
    }

    /* access modifiers changed from: package-private */
    public void v(float f2, float f4, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        int[] iArr2 = iArr;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            float f9 = (float) dArr[i2];
            double d2 = dArr2[i2];
            int i4 = iArr2[i2];
            if (i4 == 1) {
                f5 = f9;
            } else if (i4 == 2) {
                f7 = f9;
            } else if (i4 == 3) {
                f6 = f9;
            } else if (i4 == 4) {
                f8 = f9;
            }
        }
        float f10 = f5 - ((0.0f * f6) / 2.0f);
        float f11 = f7 - ((0.0f * f8) / 2.0f);
        fArr[0] = (f10 * (1.0f - f2)) + (((f6 * 1.0f) + f10) * f2) + 0.0f;
        fArr[1] = (f11 * (1.0f - f4)) + (((f8 * 1.0f) + f11) * f4) + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public void w(float f2, MotionWidget motionWidget, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f4;
        float f5;
        MotionWidget motionWidget2 = motionWidget;
        int[] iArr2 = iArr;
        double[] dArr4 = dArr2;
        float f6 = this.X2;
        float f7 = this.Y2;
        float f8 = this.Z2;
        float f9 = this.a3;
        if (iArr2.length != 0 && this.k3.length <= iArr2[iArr2.length - 1]) {
            int i2 = iArr2[iArr2.length - 1] + 1;
            this.k3 = new double[i2];
            this.l3 = new double[i2];
        }
        Arrays.fill(this.k3, Double.NaN);
        for (int i4 = 0; i4 < iArr2.length; i4++) {
            double[] dArr5 = this.k3;
            int i5 = iArr2[i4];
            dArr5[i5] = dArr[i4];
            this.l3[i5] = dArr4[i4];
        }
        float f10 = Float.NaN;
        int i6 = 0;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        while (true) {
            double[] dArr6 = this.k3;
            if (i6 >= dArr6.length) {
                break;
            }
            double d2 = 0.0d;
            if (!Double.isNaN(dArr6[i6]) || !(dArr3 == null || dArr3[i6] == 0.0d)) {
                if (dArr3 != null) {
                    d2 = dArr3[i6];
                }
                if (!Double.isNaN(this.k3[i6])) {
                    d2 = this.k3[i6] + d2;
                }
                f5 = f10;
                float f15 = (float) d2;
                float f16 = (float) this.l3[i6];
                if (i6 == 1) {
                    f10 = f5;
                    f11 = f16;
                    f6 = f15;
                } else if (i6 == 2) {
                    f10 = f5;
                    f12 = f16;
                    f7 = f15;
                } else if (i6 == 3) {
                    f10 = f5;
                    f13 = f16;
                    f8 = f15;
                } else if (i6 == 4) {
                    f10 = f5;
                    f14 = f16;
                    f9 = f15;
                } else if (i6 == 5) {
                    f10 = f15;
                }
                i6++;
                double[] dArr7 = dArr2;
            } else {
                f5 = f10;
            }
            f10 = f5;
            i6++;
            double[] dArr72 = dArr2;
        }
        float f17 = f10;
        Motion motion = this.g3;
        if (motion != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motion.r((double) f2, fArr, fArr2);
            float f18 = fArr[0];
            float f19 = fArr[1];
            float f20 = fArr2[0];
            float f21 = fArr2[1];
            double d4 = (double) f6;
            double d5 = (double) f7;
            double sin = ((double) f18) + (Math.sin(d5) * d4);
            f4 = f9;
            float f22 = (float) (sin - ((double) (f8 / 2.0f)));
            float cos = (float) ((((double) f19) - (Math.cos(d5) * d4)) - ((double) (f9 / 2.0f)));
            double d6 = (double) f11;
            double d7 = (double) f12;
            float sin2 = (float) (((double) f20) + (Math.sin(d5) * d6) + (Math.cos(d5) * d4 * d7));
            float f23 = f22;
            float cos2 = (float) ((((double) f21) - (d6 * Math.cos(d5))) + (d4 * Math.sin(d5) * d7));
            double[] dArr8 = dArr2;
            if (dArr8.length >= 2) {
                dArr8[0] = (double) sin2;
                dArr8[1] = (double) cos2;
            }
            if (!Float.isNaN(f17)) {
                motionWidget2.R((float) (((double) f17) + Math.toDegrees(Math.atan2((double) cos2, (double) sin2))));
            }
            f6 = f23;
            f7 = cos;
        } else {
            float f24 = f17;
            f4 = f9;
            if (!Float.isNaN(f24)) {
                motionWidget2.R((float) (((double) 0.0f) + ((double) f24) + Math.toDegrees(Math.atan2((double) (f12 + (f14 / 2.0f)), (double) (f11 + (f13 / 2.0f))))));
            }
        }
        float f25 = f6 + 0.5f;
        float f26 = f7 + 0.5f;
        motionWidget2.G((int) f25, (int) f26, (int) (f25 + f8), (int) (f26 + f4));
    }

    public void x(Motion motion, MotionPaths motionPaths) {
        double d2 = (double) (((this.X2 + (this.Z2 / 2.0f)) - motionPaths.X2) - (motionPaths.Z2 / 2.0f));
        double d4 = (double) (((this.Y2 + (this.a3 / 2.0f)) - motionPaths.Y2) - (motionPaths.a3 / 2.0f));
        this.g3 = motion;
        this.X2 = (float) Math.hypot(d4, d2);
        this.Y2 = (float) (Float.isNaN(this.f3) ? Math.atan2(d4, d2) + 1.5707963267948966d : Math.toRadians((double) this.f3));
    }

    public MotionPaths(int i2, int i4, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        if (motionPaths.e3 != -1) {
            r(i2, i4, motionKeyPosition, motionPaths, motionPaths2);
            return;
        }
        int i5 = motionKeyPosition.I;
        if (i5 == 1) {
            q(motionKeyPosition, motionPaths, motionPaths2);
        } else if (i5 != 2) {
            p(motionKeyPosition, motionPaths, motionPaths2);
        } else {
            s(i2, i4, motionKeyPosition, motionPaths, motionPaths2);
        }
    }
}
