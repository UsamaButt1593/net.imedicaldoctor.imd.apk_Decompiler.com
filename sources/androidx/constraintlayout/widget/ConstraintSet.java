package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.exifinterface.media.ExifInterface;
import com.itextpdf.text.html.HtmlTags;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintSet {
    public static final int A = 1;
    private static final int A0 = 29;
    private static final int A1 = 81;
    public static final int B = 0;
    private static final int B0 = 30;
    private static final int B1 = 82;
    public static final int C = 1;
    private static final int C0 = 31;
    private static final int C1 = 83;
    public static final int D = 0;
    private static final int D0 = 32;
    private static final int D1 = 84;
    public static final int E = 4;
    private static final int E0 = 33;
    private static final int E1 = 85;
    public static final int F = 8;
    private static final int F0 = 34;
    private static final int F1 = 86;
    public static final int G = 1;
    private static final int G0 = 35;
    private static final int G1 = 87;
    public static final int H = 2;
    private static final int H0 = 36;
    private static final int H1 = 88;
    public static final int I = 3;
    private static final int I0 = 37;
    private static final int I1 = 89;
    public static final int J = 4;
    private static final int J0 = 38;
    private static final int J1 = 90;
    public static final int K = 5;
    private static final int K0 = 39;
    private static final int K1 = 91;
    public static final int L = 6;
    private static final int L0 = 40;
    private static final int L1 = 92;
    public static final int M = 7;
    private static final int M0 = 41;
    private static final int M1 = 93;
    public static final int N = 8;
    private static final int N0 = 42;
    private static final int N1 = 94;
    public static final int O = 0;
    private static final int O0 = 43;
    private static final int O1 = 95;
    public static final int P = 1;
    private static final int P0 = 44;
    private static final int P1 = 96;
    public static final int Q = 0;
    private static final int Q0 = 45;
    private static final int Q1 = 97;
    public static final int R = 1;
    private static final int R0 = 46;
    private static final int R1 = 98;
    public static final int S = 2;
    private static final int S0 = 47;
    private static final int S1 = 99;
    private static final boolean T = false;
    private static final int T0 = 48;
    private static final String T1 = "weight";
    /* access modifiers changed from: private */
    public static final int[] U = {0, 4, 8};
    private static final int U0 = 49;
    private static final String U1 = "ratio";
    private static final int V = 1;
    private static final int V0 = 50;
    private static final String V1 = "parent";
    private static SparseIntArray W = new SparseIntArray();
    private static final int W0 = 51;
    private static SparseIntArray X = new SparseIntArray();
    private static final int X0 = 52;
    private static final int Y = 1;
    private static final int Y0 = 53;
    private static final int Z = 2;
    private static final int Z0 = 54;
    private static final int a0 = 3;
    private static final int a1 = 55;
    private static final int b0 = 4;
    private static final int b1 = 56;
    private static final int c0 = 5;
    private static final int c1 = 57;
    private static final int d0 = 6;
    private static final int d1 = 58;
    private static final int e0 = 7;
    private static final int e1 = 59;
    private static final int f0 = 8;
    private static final int f1 = 60;
    private static final int g0 = 9;
    private static final int g1 = 61;

    /* renamed from: h  reason: collision with root package name */
    private static final String f4696h = "ConstraintSet";
    private static final int h0 = 10;
    private static final int h1 = 62;

    /* renamed from: i  reason: collision with root package name */
    private static final String f4697i = "XML parser error must be within a Constraint ";
    private static final int i0 = 11;
    private static final int i1 = 63;

    /* renamed from: j  reason: collision with root package name */
    private static final int f4698j = -1;
    private static final int j0 = 12;
    private static final int j1 = 64;

    /* renamed from: k  reason: collision with root package name */
    private static final int f4699k = -2;
    private static final int k0 = 13;
    private static final int k1 = 65;

    /* renamed from: l  reason: collision with root package name */
    private static final int f4700l = -3;
    private static final int l0 = 14;
    private static final int l1 = 66;

    /* renamed from: m  reason: collision with root package name */
    private static final int f4701m = -4;
    private static final int m0 = 15;
    private static final int m1 = 67;

    /* renamed from: n  reason: collision with root package name */
    public static final int f4702n = 0;
    private static final int n0 = 16;
    private static final int n1 = 68;
    public static final int o = 1;
    private static final int o0 = 17;
    private static final int o1 = 69;
    public static final int p = 2;
    private static final int p0 = 18;
    private static final int p1 = 70;
    public static final int q = 3;
    private static final int q0 = 19;
    private static final int q1 = 71;
    public static final int r = 4;
    private static final int r0 = 20;
    private static final int r1 = 72;
    public static final int s = -1;
    private static final int s0 = 21;
    private static final int s1 = 73;
    public static final int t = 0;
    private static final int t0 = 22;
    private static final int t1 = 74;
    public static final int u = -2;
    private static final int u0 = 23;
    private static final int u1 = 75;
    public static final int v = 1;
    private static final int v0 = 24;
    private static final int v1 = 76;
    public static final int w = 0;
    private static final int w0 = 25;
    private static final int w1 = 77;
    public static final int x = 2;
    private static final int x0 = 26;
    private static final int x1 = 78;
    public static final int y = 0;
    private static final int y0 = 27;
    private static final int y1 = 79;
    public static final int z = 0;
    private static final int z0 = 28;
    private static final int z1 = 80;

    /* renamed from: a  reason: collision with root package name */
    private boolean f4703a;

    /* renamed from: b  reason: collision with root package name */
    public String f4704b;

    /* renamed from: c  reason: collision with root package name */
    public String f4705c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f4706d = 0;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, ConstraintAttribute> f4707e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private boolean f4708f = true;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public HashMap<Integer, Constraint> f4709g = new HashMap<>();

    public static class Constraint {

        /* renamed from: a  reason: collision with root package name */
        int f4710a;

        /* renamed from: b  reason: collision with root package name */
        String f4711b;

        /* renamed from: c  reason: collision with root package name */
        public final PropertySet f4712c = new PropertySet();

        /* renamed from: d  reason: collision with root package name */
        public final Motion f4713d = new Motion();

        /* renamed from: e  reason: collision with root package name */
        public final Layout f4714e = new Layout();

        /* renamed from: f  reason: collision with root package name */
        public final Transform f4715f = new Transform();

        /* renamed from: g  reason: collision with root package name */
        public HashMap<String, ConstraintAttribute> f4716g = new HashMap<>();

        /* renamed from: h  reason: collision with root package name */
        Delta f4717h;

        static class Delta {

            /* renamed from: m  reason: collision with root package name */
            private static final int f4718m = 4;

            /* renamed from: n  reason: collision with root package name */
            private static final int f4719n = 10;
            private static final int o = 10;
            private static final int p = 5;

            /* renamed from: a  reason: collision with root package name */
            int[] f4720a = new int[10];

            /* renamed from: b  reason: collision with root package name */
            int[] f4721b = new int[10];

            /* renamed from: c  reason: collision with root package name */
            int f4722c = 0;

            /* renamed from: d  reason: collision with root package name */
            int[] f4723d = new int[10];

            /* renamed from: e  reason: collision with root package name */
            float[] f4724e = new float[10];

            /* renamed from: f  reason: collision with root package name */
            int f4725f = 0;

            /* renamed from: g  reason: collision with root package name */
            int[] f4726g = new int[5];

            /* renamed from: h  reason: collision with root package name */
            String[] f4727h = new String[5];

            /* renamed from: i  reason: collision with root package name */
            int f4728i = 0;

            /* renamed from: j  reason: collision with root package name */
            int[] f4729j = new int[4];

            /* renamed from: k  reason: collision with root package name */
            boolean[] f4730k = new boolean[4];

            /* renamed from: l  reason: collision with root package name */
            int f4731l = 0;

            Delta() {
            }

            /* access modifiers changed from: package-private */
            public void a(int i2, float f2) {
                int i3 = this.f4725f;
                int[] iArr = this.f4723d;
                if (i3 >= iArr.length) {
                    this.f4723d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f4724e;
                    this.f4724e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f4723d;
                int i4 = this.f4725f;
                iArr2[i4] = i2;
                float[] fArr2 = this.f4724e;
                this.f4725f = i4 + 1;
                fArr2[i4] = f2;
            }

            /* access modifiers changed from: package-private */
            public void b(int i2, int i3) {
                int i4 = this.f4722c;
                int[] iArr = this.f4720a;
                if (i4 >= iArr.length) {
                    this.f4720a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f4721b;
                    this.f4721b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f4720a;
                int i5 = this.f4722c;
                iArr3[i5] = i2;
                int[] iArr4 = this.f4721b;
                this.f4722c = i5 + 1;
                iArr4[i5] = i3;
            }

            /* access modifiers changed from: package-private */
            public void c(int i2, String str) {
                int i3 = this.f4728i;
                int[] iArr = this.f4726g;
                if (i3 >= iArr.length) {
                    this.f4726g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f4727h;
                    this.f4727h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f4726g;
                int i4 = this.f4728i;
                iArr2[i4] = i2;
                String[] strArr2 = this.f4727h;
                this.f4728i = i4 + 1;
                strArr2[i4] = str;
            }

            /* access modifiers changed from: package-private */
            public void d(int i2, boolean z) {
                int i3 = this.f4731l;
                int[] iArr = this.f4729j;
                if (i3 >= iArr.length) {
                    this.f4729j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f4730k;
                    this.f4730k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f4729j;
                int i4 = this.f4731l;
                iArr2[i4] = i2;
                boolean[] zArr2 = this.f4730k;
                this.f4731l = i4 + 1;
                zArr2[i4] = z;
            }

            /* access modifiers changed from: package-private */
            public void e(Constraint constraint) {
                for (int i2 = 0; i2 < this.f4722c; i2++) {
                    ConstraintSet.S0(constraint, this.f4720a[i2], this.f4721b[i2]);
                }
                for (int i3 = 0; i3 < this.f4725f; i3++) {
                    ConstraintSet.R0(constraint, this.f4723d[i3], this.f4724e[i3]);
                }
                for (int i4 = 0; i4 < this.f4728i; i4++) {
                    ConstraintSet.T0(constraint, this.f4726g[i4], this.f4727h[i4]);
                }
                for (int i5 = 0; i5 < this.f4731l; i5++) {
                    ConstraintSet.U0(constraint, this.f4729j[i5], this.f4730k[i5]);
                }
            }

            /* access modifiers changed from: package-private */
            @SuppressLint({"LogConditional"})
            public void f(String str) {
                Log.v(str, "int");
                for (int i2 = 0; i2 < this.f4722c; i2++) {
                    Log.v(str, this.f4720a[i2] + " = " + this.f4721b[i2]);
                }
                Log.v(str, "float");
                for (int i3 = 0; i3 < this.f4725f; i3++) {
                    Log.v(str, this.f4723d[i3] + " = " + this.f4724e[i3]);
                }
                Log.v(str, "strings");
                for (int i4 = 0; i4 < this.f4728i; i4++) {
                    Log.v(str, this.f4726g[i4] + " = " + this.f4727h[i4]);
                }
                Log.v(str, TypedValues.Custom.f3953f);
                for (int i5 = 0; i5 < this.f4731l; i5++) {
                    Log.v(str, this.f4729j[i5] + " = " + this.f4730k[i5]);
                }
            }
        }

        /* access modifiers changed from: private */
        public void k(int i2, ConstraintLayout.LayoutParams layoutParams) {
            this.f4710a = i2;
            Layout layout2 = this.f4714e;
            layout2.f4741j = layoutParams.f4630e;
            layout2.f4742k = layoutParams.f4631f;
            layout2.f4743l = layoutParams.f4632g;
            layout2.f4744m = layoutParams.f4633h;
            layout2.f4745n = layoutParams.f4634i;
            layout2.o = layoutParams.f4635j;
            layout2.p = layoutParams.f4636k;
            layout2.q = layoutParams.f4637l;
            layout2.r = layoutParams.f4638m;
            layout2.s = layoutParams.f4639n;
            layout2.t = layoutParams.o;
            layout2.u = layoutParams.s;
            layout2.v = layoutParams.t;
            layout2.w = layoutParams.u;
            layout2.x = layoutParams.v;
            layout2.y = layoutParams.G;
            layout2.z = layoutParams.H;
            layout2.A = layoutParams.I;
            layout2.B = layoutParams.p;
            layout2.C = layoutParams.q;
            layout2.D = layoutParams.r;
            layout2.E = layoutParams.X;
            layout2.F = layoutParams.Y;
            layout2.G = layoutParams.Z;
            layout2.f4739h = layoutParams.f4628c;
            layout2.f4737f = layoutParams.f4626a;
            layout2.f4738g = layoutParams.f4627b;
            layout2.f4735d = layoutParams.width;
            layout2.f4736e = layoutParams.height;
            layout2.H = layoutParams.leftMargin;
            layout2.I = layoutParams.rightMargin;
            layout2.J = layoutParams.topMargin;
            layout2.K = layoutParams.bottomMargin;
            layout2.N = layoutParams.D;
            layout2.V = layoutParams.M;
            layout2.W = layoutParams.L;
            layout2.Y = layoutParams.O;
            layout2.X = layoutParams.N;
            layout2.n0 = layoutParams.a0;
            layout2.o0 = layoutParams.b0;
            layout2.Z = layoutParams.P;
            layout2.a0 = layoutParams.Q;
            layout2.b0 = layoutParams.T;
            layout2.c0 = layoutParams.U;
            layout2.d0 = layoutParams.R;
            layout2.e0 = layoutParams.S;
            layout2.f0 = layoutParams.V;
            layout2.g0 = layoutParams.W;
            layout2.m0 = layoutParams.c0;
            layout2.P = layoutParams.x;
            layout2.R = layoutParams.z;
            layout2.O = layoutParams.w;
            layout2.Q = layoutParams.y;
            layout2.T = layoutParams.A;
            layout2.S = layoutParams.B;
            layout2.U = layoutParams.C;
            layout2.q0 = layoutParams.d0;
            layout2.L = layoutParams.getMarginEnd();
            this.f4714e.M = layoutParams.getMarginStart();
        }

        /* access modifiers changed from: private */
        public void l(int i2, Constraints.LayoutParams layoutParams) {
            k(i2, layoutParams);
            this.f4712c.f4763d = layoutParams.V0;
            Transform transform = this.f4715f;
            transform.f4766b = layoutParams.Y0;
            transform.f4767c = layoutParams.Z0;
            transform.f4768d = layoutParams.a1;
            transform.f4769e = layoutParams.b1;
            transform.f4770f = layoutParams.c1;
            transform.f4771g = layoutParams.d1;
            transform.f4772h = layoutParams.e1;
            transform.f4774j = layoutParams.f1;
            transform.f4775k = layoutParams.g1;
            transform.f4776l = layoutParams.h1;
            transform.f4778n = layoutParams.X0;
            transform.f4777m = layoutParams.W0;
        }

        /* access modifiers changed from: private */
        public void m(ConstraintHelper constraintHelper, int i2, Constraints.LayoutParams layoutParams) {
            l(i2, layoutParams);
            if (constraintHelper instanceof Barrier) {
                Layout layout2 = this.f4714e;
                layout2.j0 = 1;
                Barrier barrier = (Barrier) constraintHelper;
                layout2.h0 = barrier.getType();
                this.f4714e.k0 = barrier.getReferencedIds();
                this.f4714e.i0 = barrier.getMargin();
            }
        }

        private ConstraintAttribute n(String str, ConstraintAttribute.AttributeType attributeType) {
            if (this.f4716g.containsKey(str)) {
                ConstraintAttribute constraintAttribute = this.f4716g.get(str);
                if (constraintAttribute.j() == attributeType) {
                    return constraintAttribute;
                }
                throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute.j().name());
            }
            ConstraintAttribute constraintAttribute2 = new ConstraintAttribute(str, attributeType);
            this.f4716g.put(str, constraintAttribute2);
            return constraintAttribute2;
        }

        /* access modifiers changed from: private */
        public void p(String str, int i2) {
            n(str, ConstraintAttribute.AttributeType.COLOR_TYPE).s(i2);
        }

        /* access modifiers changed from: private */
        public void q(String str, float f2) {
            n(str, ConstraintAttribute.AttributeType.FLOAT_TYPE).t(f2);
        }

        /* access modifiers changed from: private */
        public void r(String str, int i2) {
            n(str, ConstraintAttribute.AttributeType.INT_TYPE).u(i2);
        }

        /* access modifiers changed from: private */
        public void s(String str, String str2) {
            n(str, ConstraintAttribute.AttributeType.STRING_TYPE).v(str2);
        }

        public void h(Constraint constraint) {
            Delta delta = this.f4717h;
            if (delta != null) {
                delta.e(constraint);
            }
        }

        public void i(ConstraintLayout.LayoutParams layoutParams) {
            Layout layout2 = this.f4714e;
            layoutParams.f4630e = layout2.f4741j;
            layoutParams.f4631f = layout2.f4742k;
            layoutParams.f4632g = layout2.f4743l;
            layoutParams.f4633h = layout2.f4744m;
            layoutParams.f4634i = layout2.f4745n;
            layoutParams.f4635j = layout2.o;
            layoutParams.f4636k = layout2.p;
            layoutParams.f4637l = layout2.q;
            layoutParams.f4638m = layout2.r;
            layoutParams.f4639n = layout2.s;
            layoutParams.o = layout2.t;
            layoutParams.s = layout2.u;
            layoutParams.t = layout2.v;
            layoutParams.u = layout2.w;
            layoutParams.v = layout2.x;
            layoutParams.leftMargin = layout2.H;
            layoutParams.rightMargin = layout2.I;
            layoutParams.topMargin = layout2.J;
            layoutParams.bottomMargin = layout2.K;
            layoutParams.A = layout2.T;
            layoutParams.B = layout2.S;
            layoutParams.x = layout2.P;
            layoutParams.z = layout2.R;
            layoutParams.G = layout2.y;
            layoutParams.H = layout2.z;
            layoutParams.p = layout2.B;
            layoutParams.q = layout2.C;
            layoutParams.r = layout2.D;
            layoutParams.I = layout2.A;
            layoutParams.X = layout2.E;
            layoutParams.Y = layout2.F;
            layoutParams.M = layout2.V;
            layoutParams.L = layout2.W;
            layoutParams.O = layout2.Y;
            layoutParams.N = layout2.X;
            layoutParams.a0 = layout2.n0;
            layoutParams.b0 = layout2.o0;
            layoutParams.P = layout2.Z;
            layoutParams.Q = layout2.a0;
            layoutParams.T = layout2.b0;
            layoutParams.U = layout2.c0;
            layoutParams.R = layout2.d0;
            layoutParams.S = layout2.e0;
            layoutParams.V = layout2.f0;
            layoutParams.W = layout2.g0;
            layoutParams.Z = layout2.G;
            layoutParams.f4628c = layout2.f4739h;
            layoutParams.f4626a = layout2.f4737f;
            layoutParams.f4627b = layout2.f4738g;
            layoutParams.width = layout2.f4735d;
            layoutParams.height = layout2.f4736e;
            String str = layout2.m0;
            if (str != null) {
                layoutParams.c0 = str;
            }
            layoutParams.d0 = layout2.q0;
            layoutParams.setMarginStart(layout2.M);
            layoutParams.setMarginEnd(this.f4714e.L);
            layoutParams.e();
        }

        /* renamed from: j */
        public Constraint clone() {
            Constraint constraint = new Constraint();
            constraint.f4714e.a(this.f4714e);
            constraint.f4713d.a(this.f4713d);
            constraint.f4712c.a(this.f4712c);
            constraint.f4715f.a(this.f4715f);
            constraint.f4710a = this.f4710a;
            constraint.f4717h = this.f4717h;
            return constraint;
        }

        public void o(String str) {
            Delta delta = this.f4717h;
            if (delta != null) {
                delta.f(str);
            } else {
                Log.v(str, "DELTA IS NULL");
            }
        }
    }

    public static class Layout {
        private static final int A0 = 7;
        private static final int A1 = 82;
        private static final int B0 = 8;
        private static final int B1 = 83;
        private static final int C0 = 9;
        private static final int C1 = 84;
        private static final int D0 = 10;
        private static final int D1 = 85;
        private static final int E0 = 11;
        private static final int E1 = 86;
        private static final int F0 = 12;
        private static final int F1 = 87;
        private static final int G0 = 13;
        private static final int G1 = 88;
        private static final int H0 = 14;
        private static final int H1 = 89;
        private static final int I0 = 15;
        private static final int I1 = 90;
        private static final int J0 = 16;
        private static final int J1 = 91;
        private static final int K0 = 17;
        private static final int L0 = 18;
        private static final int M0 = 19;
        private static final int N0 = 20;
        private static final int O0 = 21;
        private static final int P0 = 22;
        private static final int Q0 = 23;
        private static final int R0 = 24;
        private static final int S0 = 25;
        private static final int T0 = 26;
        private static final int U0 = 27;
        private static final int V0 = 28;
        private static final int W0 = 29;
        private static final int X0 = 30;
        private static final int Y0 = 31;
        private static final int Z0 = 32;
        private static final int a1 = 33;
        private static final int b1 = 34;
        private static final int c1 = 35;
        private static final int d1 = 36;
        private static final int e1 = 37;
        private static final int f1 = 38;
        private static final int g1 = 39;
        private static final int h1 = 40;
        private static final int i1 = 41;
        private static final int j1 = 42;
        private static final int k1 = 61;
        private static final int l1 = 62;
        private static final int m1 = 63;
        private static final int n1 = 69;
        private static final int o1 = 70;
        private static final int p1 = 71;
        private static final int q1 = 72;
        public static final int r0 = -1;
        private static final int r1 = 73;
        public static final int s0 = Integer.MIN_VALUE;
        private static final int s1 = 74;
        private static SparseIntArray t0 = null;
        private static final int t1 = 75;
        private static final int u0 = 1;
        private static final int u1 = 76;
        private static final int v0 = 2;
        private static final int v1 = 77;
        private static final int w0 = 3;
        private static final int w1 = 78;
        private static final int x0 = 4;
        private static final int x1 = 79;
        private static final int y0 = 5;
        private static final int y1 = 80;
        private static final int z0 = 6;
        private static final int z1 = 81;
        public String A = null;
        public int B = -1;
        public int C = 0;
        public float D = 0.0f;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = 0;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public int T = Integer.MIN_VALUE;
        public int U = Integer.MIN_VALUE;
        public float V = -1.0f;
        public float W = -1.0f;
        public int X = 0;
        public int Y = 0;
        public int Z = 0;

        /* renamed from: a  reason: collision with root package name */
        public boolean f4732a = false;
        public int a0 = 0;

        /* renamed from: b  reason: collision with root package name */
        public boolean f4733b = false;
        public int b0 = 0;

        /* renamed from: c  reason: collision with root package name */
        public boolean f4734c = false;
        public int c0 = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f4735d;
        public int d0 = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f4736e;
        public int e0 = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f4737f = -1;
        public float f0 = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        public int f4738g = -1;
        public float g0 = 1.0f;

        /* renamed from: h  reason: collision with root package name */
        public float f4739h = -1.0f;
        public int h0 = -1;

        /* renamed from: i  reason: collision with root package name */
        public boolean f4740i = true;
        public int i0 = 0;

        /* renamed from: j  reason: collision with root package name */
        public int f4741j = -1;
        public int j0 = -1;

        /* renamed from: k  reason: collision with root package name */
        public int f4742k = -1;
        public int[] k0;

        /* renamed from: l  reason: collision with root package name */
        public int f4743l = -1;
        public String l0;

        /* renamed from: m  reason: collision with root package name */
        public int f4744m = -1;
        public String m0;

        /* renamed from: n  reason: collision with root package name */
        public int f4745n = -1;
        public boolean n0 = false;
        public int o = -1;
        public boolean o0 = false;
        public int p = -1;
        public boolean p0 = true;
        public int q = -1;
        public int q0 = 0;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = -1;
        public int v = -1;
        public int w = -1;
        public int x = -1;
        public float y = 0.5f;
        public float z = 0.5f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            t0 = sparseIntArray;
            sparseIntArray.append(R.styleable.rh, 24);
            t0.append(R.styleable.sh, 25);
            t0.append(R.styleable.uh, 28);
            t0.append(R.styleable.vh, 29);
            t0.append(R.styleable.Ah, 35);
            t0.append(R.styleable.zh, 34);
            t0.append(R.styleable.Yg, 4);
            t0.append(R.styleable.Xg, 3);
            t0.append(R.styleable.Tg, 1);
            t0.append(R.styleable.Jh, 6);
            t0.append(R.styleable.Kh, 7);
            t0.append(R.styleable.fh, 17);
            t0.append(R.styleable.gh, 18);
            t0.append(R.styleable.hh, 19);
            t0.append(R.styleable.Pg, 90);
            t0.append(R.styleable.Ag, 26);
            t0.append(R.styleable.wh, 31);
            t0.append(R.styleable.xh, 32);
            t0.append(R.styleable.eh, 10);
            t0.append(R.styleable.dh, 9);
            t0.append(R.styleable.Oh, 13);
            t0.append(R.styleable.Rh, 16);
            t0.append(R.styleable.Ph, 14);
            t0.append(R.styleable.Mh, 11);
            t0.append(R.styleable.Qh, 15);
            t0.append(R.styleable.Nh, 12);
            t0.append(R.styleable.Dh, 38);
            t0.append(R.styleable.ph, 37);
            t0.append(R.styleable.oh, 39);
            t0.append(R.styleable.Ch, 40);
            t0.append(R.styleable.nh, 20);
            t0.append(R.styleable.Bh, 36);
            t0.append(R.styleable.ch, 5);
            t0.append(R.styleable.qh, 91);
            t0.append(R.styleable.yh, 91);
            t0.append(R.styleable.th, 91);
            t0.append(R.styleable.Wg, 91);
            t0.append(R.styleable.Sg, 91);
            t0.append(R.styleable.Dg, 23);
            t0.append(R.styleable.Fg, 27);
            t0.append(R.styleable.Hg, 30);
            t0.append(R.styleable.Ig, 8);
            t0.append(R.styleable.Eg, 33);
            t0.append(R.styleable.Gg, 2);
            t0.append(R.styleable.Bg, 22);
            t0.append(R.styleable.Cg, 21);
            t0.append(R.styleable.Eh, 41);
            t0.append(R.styleable.ih, 42);
            t0.append(R.styleable.Rg, 41);
            t0.append(R.styleable.Qg, 42);
            t0.append(R.styleable.Th, 76);
            t0.append(R.styleable.Zg, 61);
            t0.append(R.styleable.bh, 62);
            t0.append(R.styleable.ah, 63);
            t0.append(R.styleable.Ih, 69);
            t0.append(R.styleable.mh, 70);
            t0.append(R.styleable.Mg, 71);
            t0.append(R.styleable.Kg, 72);
            t0.append(R.styleable.Lg, 73);
            t0.append(R.styleable.Ng, 74);
            t0.append(R.styleable.Jg, 75);
        }

        public void a(Layout layout2) {
            this.f4732a = layout2.f4732a;
            this.f4735d = layout2.f4735d;
            this.f4733b = layout2.f4733b;
            this.f4736e = layout2.f4736e;
            this.f4737f = layout2.f4737f;
            this.f4738g = layout2.f4738g;
            this.f4739h = layout2.f4739h;
            this.f4740i = layout2.f4740i;
            this.f4741j = layout2.f4741j;
            this.f4742k = layout2.f4742k;
            this.f4743l = layout2.f4743l;
            this.f4744m = layout2.f4744m;
            this.f4745n = layout2.f4745n;
            this.o = layout2.o;
            this.p = layout2.p;
            this.q = layout2.q;
            this.r = layout2.r;
            this.s = layout2.s;
            this.t = layout2.t;
            this.u = layout2.u;
            this.v = layout2.v;
            this.w = layout2.w;
            this.x = layout2.x;
            this.y = layout2.y;
            this.z = layout2.z;
            this.A = layout2.A;
            this.B = layout2.B;
            this.C = layout2.C;
            this.D = layout2.D;
            this.E = layout2.E;
            this.F = layout2.F;
            this.G = layout2.G;
            this.H = layout2.H;
            this.I = layout2.I;
            this.J = layout2.J;
            this.K = layout2.K;
            this.L = layout2.L;
            this.M = layout2.M;
            this.N = layout2.N;
            this.O = layout2.O;
            this.P = layout2.P;
            this.Q = layout2.Q;
            this.R = layout2.R;
            this.S = layout2.S;
            this.T = layout2.T;
            this.U = layout2.U;
            this.V = layout2.V;
            this.W = layout2.W;
            this.X = layout2.X;
            this.Y = layout2.Y;
            this.Z = layout2.Z;
            this.a0 = layout2.a0;
            this.b0 = layout2.b0;
            this.c0 = layout2.c0;
            this.d0 = layout2.d0;
            this.e0 = layout2.e0;
            this.f0 = layout2.f0;
            this.g0 = layout2.g0;
            this.h0 = layout2.h0;
            this.i0 = layout2.i0;
            this.j0 = layout2.j0;
            this.m0 = layout2.m0;
            int[] iArr = layout2.k0;
            if (iArr == null || layout2.l0 != null) {
                this.k0 = null;
            } else {
                this.k0 = Arrays.copyOf(iArr, iArr.length);
            }
            this.l0 = layout2.l0;
            this.n0 = layout2.n0;
            this.o0 = layout2.o0;
            this.p0 = layout2.p0;
            this.q0 = layout2.q0;
        }

        /* JADX WARNING: type inference failed for: r2v8, types: [java.lang.String] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(androidx.constraintlayout.motion.widget.MotionScene r10, java.lang.StringBuilder r11) {
            /*
                r9 = this;
                java.lang.Class r0 = r9.getClass()
                java.lang.reflect.Field[] r0 = r0.getDeclaredFields()
                java.lang.String r1 = "\n"
                r11.append(r1)
                r1 = 0
            L_0x000e:
                int r2 = r0.length
                if (r1 >= r2) goto L_0x007e
                r2 = r0[r1]
                java.lang.String r3 = r2.getName()
                int r4 = r2.getModifiers()
                boolean r4 = java.lang.reflect.Modifier.isStatic(r4)
                if (r4 == 0) goto L_0x0022
                goto L_0x007b
            L_0x0022:
                java.lang.Object r4 = r2.get(r9)     // Catch:{ IllegalAccessException -> 0x0059 }
                java.lang.Class r2 = r2.getType()     // Catch:{ IllegalAccessException -> 0x0059 }
                java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ IllegalAccessException -> 0x0059 }
                java.lang.String r6 = "\"\n"
                java.lang.String r7 = " = \""
                java.lang.String r8 = "    "
                if (r2 != r5) goto L_0x005b
                java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ IllegalAccessException -> 0x0059 }
                int r2 = r4.intValue()     // Catch:{ IllegalAccessException -> 0x0059 }
                r5 = -1
                if (r2 == r5) goto L_0x007b
                int r2 = r4.intValue()     // Catch:{ IllegalAccessException -> 0x0059 }
                java.lang.String r2 = r10.X(r2)     // Catch:{ IllegalAccessException -> 0x0059 }
                r11.append(r8)     // Catch:{ IllegalAccessException -> 0x0059 }
                r11.append(r3)     // Catch:{ IllegalAccessException -> 0x0059 }
                r11.append(r7)     // Catch:{ IllegalAccessException -> 0x0059 }
                if (r2 != 0) goto L_0x0051
                goto L_0x0052
            L_0x0051:
                r4 = r2
            L_0x0052:
                r11.append(r4)     // Catch:{ IllegalAccessException -> 0x0059 }
            L_0x0055:
                r11.append(r6)     // Catch:{ IllegalAccessException -> 0x0059 }
                goto L_0x007b
            L_0x0059:
                r2 = move-exception
                goto L_0x0078
            L_0x005b:
                java.lang.Class r5 = java.lang.Float.TYPE     // Catch:{ IllegalAccessException -> 0x0059 }
                if (r2 != r5) goto L_0x007b
                java.lang.Float r4 = (java.lang.Float) r4     // Catch:{ IllegalAccessException -> 0x0059 }
                float r2 = r4.floatValue()     // Catch:{ IllegalAccessException -> 0x0059 }
                r5 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r2 == 0) goto L_0x007b
                r11.append(r8)     // Catch:{ IllegalAccessException -> 0x0059 }
                r11.append(r3)     // Catch:{ IllegalAccessException -> 0x0059 }
                r11.append(r7)     // Catch:{ IllegalAccessException -> 0x0059 }
                r11.append(r4)     // Catch:{ IllegalAccessException -> 0x0059 }
                goto L_0x0055
            L_0x0078:
                r2.printStackTrace()
            L_0x007b:
                int r1 = r1 + 1
                goto L_0x000e
            L_0x007e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.Layout.b(androidx.constraintlayout.motion.widget.MotionScene, java.lang.StringBuilder):void");
        }

        /* access modifiers changed from: package-private */
        public void c(Context context, AttributeSet attributeSet) {
            StringBuilder sb;
            String str;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.zg);
            this.f4733b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                int i3 = t0.get(index);
                switch (i3) {
                    case 1:
                        this.r = ConstraintSet.y0(obtainStyledAttributes, index, this.r);
                        break;
                    case 2:
                        this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        break;
                    case 3:
                        this.q = ConstraintSet.y0(obtainStyledAttributes, index, this.q);
                        break;
                    case 4:
                        this.p = ConstraintSet.y0(obtainStyledAttributes, index, this.p);
                        break;
                    case 5:
                        this.A = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.E = obtainStyledAttributes.getDimensionPixelOffset(index, this.E);
                        break;
                    case 7:
                        this.F = obtainStyledAttributes.getDimensionPixelOffset(index, this.F);
                        break;
                    case 8:
                        this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                        break;
                    case 9:
                        this.x = ConstraintSet.y0(obtainStyledAttributes, index, this.x);
                        break;
                    case 10:
                        this.w = ConstraintSet.y0(obtainStyledAttributes, index, this.w);
                        break;
                    case 11:
                        this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        break;
                    case 12:
                        this.S = obtainStyledAttributes.getDimensionPixelSize(index, this.S);
                        break;
                    case 13:
                        this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    case 14:
                        this.Q = obtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    case 15:
                        this.T = obtainStyledAttributes.getDimensionPixelSize(index, this.T);
                        break;
                    case 16:
                        this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    case 17:
                        this.f4737f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f4737f);
                        break;
                    case 18:
                        this.f4738g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f4738g);
                        break;
                    case 19:
                        this.f4739h = obtainStyledAttributes.getFloat(index, this.f4739h);
                        break;
                    case 20:
                        this.y = obtainStyledAttributes.getFloat(index, this.y);
                        break;
                    case 21:
                        this.f4736e = obtainStyledAttributes.getLayoutDimension(index, this.f4736e);
                        break;
                    case 22:
                        this.f4735d = obtainStyledAttributes.getLayoutDimension(index, this.f4735d);
                        break;
                    case 23:
                        this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case 24:
                        this.f4741j = ConstraintSet.y0(obtainStyledAttributes, index, this.f4741j);
                        break;
                    case 25:
                        this.f4742k = ConstraintSet.y0(obtainStyledAttributes, index, this.f4742k);
                        break;
                    case 26:
                        this.G = obtainStyledAttributes.getInt(index, this.G);
                        break;
                    case 27:
                        this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case 28:
                        this.f4743l = ConstraintSet.y0(obtainStyledAttributes, index, this.f4743l);
                        break;
                    case 29:
                        this.f4744m = ConstraintSet.y0(obtainStyledAttributes, index, this.f4744m);
                        break;
                    case 30:
                        this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        break;
                    case 31:
                        this.u = ConstraintSet.y0(obtainStyledAttributes, index, this.u);
                        break;
                    case 32:
                        this.v = ConstraintSet.y0(obtainStyledAttributes, index, this.v);
                        break;
                    case 33:
                        this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    case 34:
                        this.o = ConstraintSet.y0(obtainStyledAttributes, index, this.o);
                        break;
                    case 35:
                        this.f4745n = ConstraintSet.y0(obtainStyledAttributes, index, this.f4745n);
                        break;
                    case 36:
                        this.z = obtainStyledAttributes.getFloat(index, this.z);
                        break;
                    case 37:
                        this.W = obtainStyledAttributes.getFloat(index, this.W);
                        break;
                    case 38:
                        this.V = obtainStyledAttributes.getFloat(index, this.V);
                        break;
                    case 39:
                        this.X = obtainStyledAttributes.getInt(index, this.X);
                        break;
                    case 40:
                        this.Y = obtainStyledAttributes.getInt(index, this.Y);
                        break;
                    case 41:
                        ConstraintSet.A0(this, obtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        ConstraintSet.A0(this, obtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i3) {
                            case 61:
                                this.B = ConstraintSet.y0(obtainStyledAttributes, index, this.B);
                                break;
                            case 62:
                                this.C = obtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            case 63:
                                this.D = obtainStyledAttributes.getFloat(index, this.D);
                                break;
                            default:
                                switch (i3) {
                                    case 69:
                                        this.f0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                        continue;
                                    case 70:
                                        this.g0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                        continue;
                                    case 71:
                                        Log.e(ConstraintSet.f4696h, "CURRENTLY UNSUPPORTED");
                                        continue;
                                    case 72:
                                        this.h0 = obtainStyledAttributes.getInt(index, this.h0);
                                        continue;
                                    case 73:
                                        this.i0 = obtainStyledAttributes.getDimensionPixelSize(index, this.i0);
                                        continue;
                                    case 74:
                                        this.l0 = obtainStyledAttributes.getString(index);
                                        continue;
                                    case 75:
                                        this.p0 = obtainStyledAttributes.getBoolean(index, this.p0);
                                        continue;
                                    case 76:
                                        this.q0 = obtainStyledAttributes.getInt(index, this.q0);
                                        continue;
                                    case 77:
                                        this.s = ConstraintSet.y0(obtainStyledAttributes, index, this.s);
                                        continue;
                                    case 78:
                                        this.t = ConstraintSet.y0(obtainStyledAttributes, index, this.t);
                                        continue;
                                    case 79:
                                        this.U = obtainStyledAttributes.getDimensionPixelSize(index, this.U);
                                        continue;
                                    case 80:
                                        this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                                        continue;
                                    case 81:
                                        this.Z = obtainStyledAttributes.getInt(index, this.Z);
                                        continue;
                                    case 82:
                                        this.a0 = obtainStyledAttributes.getInt(index, this.a0);
                                        continue;
                                    case 83:
                                        this.c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.c0);
                                        continue;
                                    case 84:
                                        this.b0 = obtainStyledAttributes.getDimensionPixelSize(index, this.b0);
                                        continue;
                                    case 85:
                                        this.e0 = obtainStyledAttributes.getDimensionPixelSize(index, this.e0);
                                        continue;
                                    case 86:
                                        this.d0 = obtainStyledAttributes.getDimensionPixelSize(index, this.d0);
                                        continue;
                                    case 87:
                                        this.n0 = obtainStyledAttributes.getBoolean(index, this.n0);
                                        continue;
                                    case 88:
                                        this.o0 = obtainStyledAttributes.getBoolean(index, this.o0);
                                        continue;
                                    case 89:
                                        this.m0 = obtainStyledAttributes.getString(index);
                                        continue;
                                    case 90:
                                        this.f4740i = obtainStyledAttributes.getBoolean(index, this.f4740i);
                                        continue;
                                    case 91:
                                        sb = new StringBuilder();
                                        str = "unused attribute 0x";
                                        break;
                                    default:
                                        sb = new StringBuilder();
                                        str = "Unknown attribute 0x";
                                        break;
                                }
                                sb.append(str);
                                sb.append(Integer.toHexString(index));
                                sb.append("   ");
                                sb.append(t0.get(index));
                                Log.w(ConstraintSet.f4696h, sb.toString());
                                break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class Motion {
        private static final int A = 9;
        private static final int B = 10;
        private static final int o = -2;
        private static final int p = -1;
        private static final int q = -3;
        private static SparseIntArray r = null;
        private static final int s = 1;
        private static final int t = 2;
        private static final int u = 3;
        private static final int v = 4;
        private static final int w = 5;
        private static final int x = 6;
        private static final int y = 7;
        private static final int z = 8;

        /* renamed from: a  reason: collision with root package name */
        public boolean f4746a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f4747b = -1;

        /* renamed from: c  reason: collision with root package name */
        public int f4748c = 0;

        /* renamed from: d  reason: collision with root package name */
        public String f4749d = null;

        /* renamed from: e  reason: collision with root package name */
        public int f4750e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f4751f = 0;

        /* renamed from: g  reason: collision with root package name */
        public float f4752g = Float.NaN;

        /* renamed from: h  reason: collision with root package name */
        public int f4753h = -1;

        /* renamed from: i  reason: collision with root package name */
        public float f4754i = Float.NaN;

        /* renamed from: j  reason: collision with root package name */
        public float f4755j = Float.NaN;

        /* renamed from: k  reason: collision with root package name */
        public int f4756k = -1;

        /* renamed from: l  reason: collision with root package name */
        public String f4757l = null;

        /* renamed from: m  reason: collision with root package name */
        public int f4758m = -3;

        /* renamed from: n  reason: collision with root package name */
        public int f4759n = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            r = sparseIntArray;
            sparseIntArray.append(R.styleable.qj, 1);
            r.append(R.styleable.sj, 2);
            r.append(R.styleable.wj, 3);
            r.append(R.styleable.pj, 4);
            r.append(R.styleable.oj, 5);
            r.append(R.styleable.nj, 6);
            r.append(R.styleable.rj, 7);
            r.append(R.styleable.vj, 8);
            r.append(R.styleable.uj, 9);
            r.append(R.styleable.tj, 10);
        }

        public void a(Motion motion) {
            this.f4746a = motion.f4746a;
            this.f4747b = motion.f4747b;
            this.f4749d = motion.f4749d;
            this.f4750e = motion.f4750e;
            this.f4751f = motion.f4751f;
            this.f4754i = motion.f4754i;
            this.f4752g = motion.f4752g;
            this.f4753h = motion.f4753h;
        }

        /* access modifiers changed from: package-private */
        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.mj);
            this.f4746a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (r.get(index)) {
                    case 1:
                        this.f4754i = obtainStyledAttributes.getFloat(index, this.f4754i);
                        break;
                    case 2:
                        this.f4750e = obtainStyledAttributes.getInt(index, this.f4750e);
                        break;
                    case 3:
                        this.f4749d = obtainStyledAttributes.peekValue(index).type == 3 ? obtainStyledAttributes.getString(index) : Easing.o[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    case 4:
                        this.f4751f = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f4747b = ConstraintSet.y0(obtainStyledAttributes, index, this.f4747b);
                        break;
                    case 6:
                        this.f4748c = obtainStyledAttributes.getInteger(index, this.f4748c);
                        break;
                    case 7:
                        this.f4752g = obtainStyledAttributes.getFloat(index, this.f4752g);
                        break;
                    case 8:
                        this.f4756k = obtainStyledAttributes.getInteger(index, this.f4756k);
                        break;
                    case 9:
                        this.f4755j = obtainStyledAttributes.getFloat(index, this.f4755j);
                        break;
                    case 10:
                        int i3 = obtainStyledAttributes.peekValue(index).type;
                        if (i3 != 1) {
                            if (i3 != 3) {
                                this.f4758m = obtainStyledAttributes.getInteger(index, this.f4759n);
                                break;
                            } else {
                                String string = obtainStyledAttributes.getString(index);
                                this.f4757l = string;
                                if (string.indexOf("/") <= 0) {
                                    this.f4758m = -1;
                                    break;
                                } else {
                                    this.f4759n = obtainStyledAttributes.getResourceId(index, -1);
                                }
                            }
                        } else {
                            int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            this.f4759n = resourceId;
                            if (resourceId == -1) {
                                break;
                            }
                        }
                        this.f4758m = -2;
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class PropertySet {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4760a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f4761b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f4762c = 0;

        /* renamed from: d  reason: collision with root package name */
        public float f4763d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f4764e = Float.NaN;

        public void a(PropertySet propertySet) {
            this.f4760a = propertySet.f4760a;
            this.f4761b = propertySet.f4761b;
            this.f4763d = propertySet.f4763d;
            this.f4764e = propertySet.f4764e;
            this.f4762c = propertySet.f4762c;
        }

        /* access modifiers changed from: package-private */
        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.al);
            this.f4760a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.cl) {
                    this.f4763d = obtainStyledAttributes.getFloat(index, this.f4763d);
                } else if (index == R.styleable.bl) {
                    this.f4761b = obtainStyledAttributes.getInt(index, this.f4761b);
                    this.f4761b = ConstraintSet.U[this.f4761b];
                } else if (index == R.styleable.fl) {
                    this.f4762c = obtainStyledAttributes.getInt(index, this.f4762c);
                } else if (index == R.styleable.el) {
                    this.f4764e = obtainStyledAttributes.getFloat(index, this.f4764e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class Transform {
        private static final int A = 12;
        private static SparseIntArray o = null;
        private static final int p = 1;
        private static final int q = 2;
        private static final int r = 3;
        private static final int s = 4;
        private static final int t = 5;
        private static final int u = 6;
        private static final int v = 7;
        private static final int w = 8;
        private static final int x = 9;
        private static final int y = 10;
        private static final int z = 11;

        /* renamed from: a  reason: collision with root package name */
        public boolean f4765a = false;

        /* renamed from: b  reason: collision with root package name */
        public float f4766b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        public float f4767c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        public float f4768d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f4769e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f4770f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f4771g = Float.NaN;

        /* renamed from: h  reason: collision with root package name */
        public float f4772h = Float.NaN;

        /* renamed from: i  reason: collision with root package name */
        public int f4773i = -1;

        /* renamed from: j  reason: collision with root package name */
        public float f4774j = 0.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f4775k = 0.0f;

        /* renamed from: l  reason: collision with root package name */
        public float f4776l = 0.0f;

        /* renamed from: m  reason: collision with root package name */
        public boolean f4777m = false;

        /* renamed from: n  reason: collision with root package name */
        public float f4778n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            o = sparseIntArray;
            sparseIntArray.append(R.styleable.On, 1);
            o.append(R.styleable.Pn, 2);
            o.append(R.styleable.Qn, 3);
            o.append(R.styleable.Mn, 4);
            o.append(R.styleable.Nn, 5);
            o.append(R.styleable.In, 6);
            o.append(R.styleable.Jn, 7);
            o.append(R.styleable.Kn, 8);
            o.append(R.styleable.Ln, 9);
            o.append(R.styleable.Rn, 10);
            o.append(R.styleable.Sn, 11);
            o.append(R.styleable.Tn, 12);
        }

        public void a(Transform transform) {
            this.f4765a = transform.f4765a;
            this.f4766b = transform.f4766b;
            this.f4767c = transform.f4767c;
            this.f4768d = transform.f4768d;
            this.f4769e = transform.f4769e;
            this.f4770f = transform.f4770f;
            this.f4771g = transform.f4771g;
            this.f4772h = transform.f4772h;
            this.f4773i = transform.f4773i;
            this.f4774j = transform.f4774j;
            this.f4775k = transform.f4775k;
            this.f4776l = transform.f4776l;
            this.f4777m = transform.f4777m;
            this.f4778n = transform.f4778n;
        }

        /* access modifiers changed from: package-private */
        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Hn);
            this.f4765a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (o.get(index)) {
                    case 1:
                        this.f4766b = obtainStyledAttributes.getFloat(index, this.f4766b);
                        break;
                    case 2:
                        this.f4767c = obtainStyledAttributes.getFloat(index, this.f4767c);
                        break;
                    case 3:
                        this.f4768d = obtainStyledAttributes.getFloat(index, this.f4768d);
                        break;
                    case 4:
                        this.f4769e = obtainStyledAttributes.getFloat(index, this.f4769e);
                        break;
                    case 5:
                        this.f4770f = obtainStyledAttributes.getFloat(index, this.f4770f);
                        break;
                    case 6:
                        this.f4771g = obtainStyledAttributes.getDimension(index, this.f4771g);
                        break;
                    case 7:
                        this.f4772h = obtainStyledAttributes.getDimension(index, this.f4772h);
                        break;
                    case 8:
                        this.f4774j = obtainStyledAttributes.getDimension(index, this.f4774j);
                        break;
                    case 9:
                        this.f4775k = obtainStyledAttributes.getDimension(index, this.f4775k);
                        break;
                    case 10:
                        this.f4776l = obtainStyledAttributes.getDimension(index, this.f4776l);
                        break;
                    case 11:
                        this.f4777m = true;
                        this.f4778n = obtainStyledAttributes.getDimension(index, this.f4778n);
                        break;
                    case 12:
                        this.f4773i = ConstraintSet.y0(obtainStyledAttributes, index, this.f4773i);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    class WriteJsonEngine {
        private static final String o = "       ";

        /* renamed from: a  reason: collision with root package name */
        Writer f4779a;

        /* renamed from: b  reason: collision with root package name */
        ConstraintLayout f4780b;

        /* renamed from: c  reason: collision with root package name */
        Context f4781c;

        /* renamed from: d  reason: collision with root package name */
        int f4782d;

        /* renamed from: e  reason: collision with root package name */
        int f4783e = 0;

        /* renamed from: f  reason: collision with root package name */
        final String f4784f = "'left'";

        /* renamed from: g  reason: collision with root package name */
        final String f4785g = "'right'";

        /* renamed from: h  reason: collision with root package name */
        final String f4786h = "'baseline'";

        /* renamed from: i  reason: collision with root package name */
        final String f4787i = "'bottom'";

        /* renamed from: j  reason: collision with root package name */
        final String f4788j = "'top'";

        /* renamed from: k  reason: collision with root package name */
        final String f4789k = "'start'";

        /* renamed from: l  reason: collision with root package name */
        final String f4790l = "'end'";

        /* renamed from: m  reason: collision with root package name */
        HashMap<Integer, String> f4791m = new HashMap<>();

        WriteJsonEngine(Writer writer, ConstraintLayout constraintLayout, int i2) throws IOException {
            this.f4779a = writer;
            this.f4780b = constraintLayout;
            this.f4781c = constraintLayout.getContext();
            this.f4782d = i2;
        }

        private void e(String str, int i2, int i3, float f2, int i4, int i5, boolean z) throws IOException {
            Writer writer;
            StringBuilder sb;
            String str2;
            Writer writer2;
            StringBuilder sb2;
            String str3;
            StringBuilder sb3;
            Writer writer3;
            String str4;
            if (i2 == 0) {
                if (i5 == -1 && i4 == -1) {
                    if (i3 == 1) {
                        writer3 = this.f4779a;
                        sb3 = new StringBuilder();
                        sb3.append(o);
                        sb3.append(str);
                        str4 = ": '???????????',\n";
                    } else if (i3 == 2) {
                        writer3 = this.f4779a;
                        sb3 = new StringBuilder();
                        sb3.append(o);
                        sb3.append(str);
                        sb3.append(": '");
                        sb3.append(f2);
                        str4 = "%',\n";
                    } else {
                        return;
                    }
                    sb3.append(str4);
                } else if (i3 != 0) {
                    if (i3 == 1) {
                        writer2 = this.f4779a;
                        sb2 = new StringBuilder();
                        sb2.append(o);
                        sb2.append(str);
                        str3 = ": {'wrap' ,";
                    } else if (i3 == 2) {
                        writer2 = this.f4779a;
                        sb2 = new StringBuilder();
                        sb2.append(o);
                        sb2.append(str);
                        sb2.append(": {'");
                        sb2.append(f2);
                        str3 = "'% ,";
                    } else {
                        return;
                    }
                    sb3.append(str3);
                    sb3.append(i4);
                    sb3.append(", ");
                    sb3.append(i5);
                    sb3.append("}\n");
                } else {
                    Writer writer4 = this.f4779a;
                    writer4.write(o + str + ": {'spread' ," + i4 + ", " + i5 + "}\n");
                    return;
                }
                writer3.write(sb3.toString());
                return;
            }
            if (i2 == -2) {
                writer = this.f4779a;
                sb = new StringBuilder();
                sb.append(o);
                sb.append(str);
                str2 = ": 'wrap'\n";
            } else if (i2 == -1) {
                writer = this.f4779a;
                sb = new StringBuilder();
                sb.append(o);
                sb.append(str);
                str2 = ": 'parent'\n";
            } else {
                Writer writer5 = this.f4779a;
                writer5.write(o + str + ": " + i2 + ",\n");
                return;
            }
            sb.append(str2);
            writer.write(sb.toString());
        }

        private void f(int i2, int i3, int i4, float f2) {
        }

        /* access modifiers changed from: package-private */
        public String a(int i2) {
            if (this.f4791m.containsKey(Integer.valueOf(i2))) {
                return "'" + this.f4791m.get(Integer.valueOf(i2)) + "'";
            } else if (i2 == 0) {
                return "'parent'";
            } else {
                String b2 = b(i2);
                this.f4791m.put(Integer.valueOf(i2), b2);
                return "'" + b2 + "'";
            }
        }

        /* access modifiers changed from: package-private */
        public String b(int i2) {
            if (i2 != -1) {
                try {
                    return this.f4781c.getResources().getResourceEntryName(i2);
                } catch (Exception unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unknown");
                    int i3 = this.f4783e + 1;
                    this.f4783e = i3;
                    sb.append(i3);
                    return sb.toString();
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("unknown");
                int i4 = this.f4783e + 1;
                this.f4783e = i4;
                sb2.append(i4);
                return sb2.toString();
            }
        }

        /* access modifiers changed from: package-private */
        public void c(int i2, float f2, int i3) throws IOException {
            if (i2 != -1) {
                this.f4779a.write("       circle");
                this.f4779a.write(":[");
                this.f4779a.write(a(i2));
                Writer writer = this.f4779a;
                writer.write(", " + f2);
                Writer writer2 = this.f4779a;
                writer2.write(i3 + "]");
            }
        }

        /* access modifiers changed from: package-private */
        public void d(String str, int i2, String str2, int i3, int i4) throws IOException {
            if (i2 != -1) {
                Writer writer = this.f4779a;
                writer.write(o + str);
                this.f4779a.write(":[");
                this.f4779a.write(a(i2));
                this.f4779a.write(" , ");
                this.f4779a.write(str2);
                if (i3 != 0) {
                    Writer writer2 = this.f4779a;
                    writer2.write(" , " + i3);
                }
                this.f4779a.write("],\n");
            }
        }

        /* access modifiers changed from: package-private */
        public void g() throws IOException {
            this.f4779a.write("\n'ConstraintSet':{\n");
            for (Integer num : ConstraintSet.this.f4709g.keySet()) {
                String a2 = a(num.intValue());
                Writer writer = this.f4779a;
                writer.write(a2 + ":{\n");
                Layout layout2 = ((Constraint) ConstraintSet.this.f4709g.get(num)).f4714e;
                e("height", layout2.f4736e, layout2.a0, layout2.g0, layout2.e0, layout2.c0, layout2.o0);
                e("width", layout2.f4735d, layout2.Z, layout2.f0, layout2.d0, layout2.b0, layout2.n0);
                d("'left'", layout2.f4741j, "'left'", layout2.H, layout2.O);
                d("'left'", layout2.f4742k, "'right'", layout2.H, layout2.O);
                d("'right'", layout2.f4743l, "'left'", layout2.I, layout2.Q);
                d("'right'", layout2.f4744m, "'right'", layout2.I, layout2.Q);
                d("'baseline'", layout2.r, "'baseline'", -1, layout2.U);
                d("'baseline'", layout2.s, "'top'", -1, layout2.U);
                d("'baseline'", layout2.t, "'bottom'", -1, layout2.U);
                d("'top'", layout2.o, "'bottom'", layout2.J, layout2.P);
                d("'top'", layout2.f4745n, "'top'", layout2.J, layout2.P);
                d("'bottom'", layout2.q, "'bottom'", layout2.K, layout2.R);
                d("'bottom'", layout2.p, "'top'", layout2.K, layout2.R);
                d("'start'", layout2.v, "'start'", layout2.M, layout2.T);
                d("'start'", layout2.u, "'end'", layout2.M, layout2.T);
                d("'end'", layout2.w, "'start'", layout2.L, layout2.S);
                d("'end'", layout2.x, "'end'", layout2.L, layout2.S);
                i("'horizontalBias'", layout2.y, 0.5f);
                i("'verticalBias'", layout2.z, 0.5f);
                c(layout2.B, layout2.D, layout2.C);
                f(layout2.G, layout2.f4737f, layout2.f4738g, layout2.f4739h);
                k("'dimensionRatio'", layout2.A);
                j("'barrierMargin'", layout2.i0);
                j("'type'", layout2.j0);
                k("'ReferenceId'", layout2.l0);
                m("'mBarrierAllowsGoneWidgets'", layout2.p0, true);
                j("'WrapBehavior'", layout2.q0);
                h("'verticalWeight'", layout2.V);
                h("'horizontalWeight'", layout2.W);
                j("'horizontalChainStyle'", layout2.X);
                j("'verticalChainStyle'", layout2.Y);
                j("'barrierDirection'", layout2.h0);
                int[] iArr = layout2.k0;
                if (iArr != null) {
                    n("'ReferenceIds'", iArr);
                }
                this.f4779a.write("}\n");
            }
            this.f4779a.write("}\n");
        }

        /* access modifiers changed from: package-private */
        public void h(String str, float f2) throws IOException {
            if (f2 != -1.0f) {
                Writer writer = this.f4779a;
                writer.write(o + str);
                Writer writer2 = this.f4779a;
                writer2.write(": " + f2);
                this.f4779a.write(",\n");
            }
        }

        /* access modifiers changed from: package-private */
        public void i(String str, float f2, float f3) throws IOException {
            if (f2 != f3) {
                Writer writer = this.f4779a;
                writer.write(o + str);
                Writer writer2 = this.f4779a;
                writer2.write(": " + f2);
                this.f4779a.write(",\n");
            }
        }

        /* access modifiers changed from: package-private */
        public void j(String str, int i2) throws IOException {
            if (i2 != 0 && i2 != -1) {
                Writer writer = this.f4779a;
                writer.write(o + str);
                this.f4779a.write(":");
                Writer writer2 = this.f4779a;
                writer2.write(", " + i2);
                this.f4779a.write(StringUtils.LF);
            }
        }

        /* access modifiers changed from: package-private */
        public void k(String str, String str2) throws IOException {
            if (str2 != null) {
                Writer writer = this.f4779a;
                writer.write(o + str);
                this.f4779a.write(":");
                Writer writer2 = this.f4779a;
                writer2.write(", " + str2);
                this.f4779a.write(StringUtils.LF);
            }
        }

        /* access modifiers changed from: package-private */
        public void l(String str, boolean z) throws IOException {
            if (z) {
                Writer writer = this.f4779a;
                writer.write(o + str);
                Writer writer2 = this.f4779a;
                writer2.write(": " + z);
                this.f4779a.write(",\n");
            }
        }

        /* access modifiers changed from: package-private */
        public void m(String str, boolean z, boolean z2) throws IOException {
            if (z != z2) {
                Writer writer = this.f4779a;
                writer.write(o + str);
                Writer writer2 = this.f4779a;
                writer2.write(": " + z);
                this.f4779a.write(",\n");
            }
        }

        /* access modifiers changed from: package-private */
        public void n(String str, int[] iArr) throws IOException {
            if (iArr != null) {
                Writer writer = this.f4779a;
                writer.write(o + str);
                this.f4779a.write(": ");
                int i2 = 0;
                while (i2 < iArr.length) {
                    Writer writer2 = this.f4779a;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i2 == 0 ? "[" : ", ");
                    sb.append(a(iArr[i2]));
                    writer2.write(sb.toString());
                    i2++;
                }
                this.f4779a.write("],\n");
            }
        }
    }

    class WriteXmlEngine {
        private static final String o = "\n       ";

        /* renamed from: a  reason: collision with root package name */
        Writer f4793a;

        /* renamed from: b  reason: collision with root package name */
        ConstraintLayout f4794b;

        /* renamed from: c  reason: collision with root package name */
        Context f4795c;

        /* renamed from: d  reason: collision with root package name */
        int f4796d;

        /* renamed from: e  reason: collision with root package name */
        int f4797e = 0;

        /* renamed from: f  reason: collision with root package name */
        final String f4798f = "'left'";

        /* renamed from: g  reason: collision with root package name */
        final String f4799g = "'right'";

        /* renamed from: h  reason: collision with root package name */
        final String f4800h = "'baseline'";

        /* renamed from: i  reason: collision with root package name */
        final String f4801i = "'bottom'";

        /* renamed from: j  reason: collision with root package name */
        final String f4802j = "'top'";

        /* renamed from: k  reason: collision with root package name */
        final String f4803k = "'start'";

        /* renamed from: l  reason: collision with root package name */
        final String f4804l = "'end'";

        /* renamed from: m  reason: collision with root package name */
        HashMap<Integer, String> f4805m = new HashMap<>();

        WriteXmlEngine(Writer writer, ConstraintLayout constraintLayout, int i2) throws IOException {
            this.f4793a = writer;
            this.f4794b = constraintLayout;
            this.f4795c = constraintLayout.getContext();
            this.f4796d = i2;
        }

        private void c(String str, int i2, int i3) throws IOException {
            Writer writer;
            StringBuilder sb;
            String str2;
            if (i2 != i3) {
                if (i2 == -2) {
                    writer = this.f4793a;
                    sb = new StringBuilder();
                    sb.append(o);
                    sb.append(str);
                    str2 = "=\"wrap_content\"";
                } else if (i2 == -1) {
                    writer = this.f4793a;
                    sb = new StringBuilder();
                    sb.append(o);
                    sb.append(str);
                    str2 = "=\"match_parent\"";
                } else {
                    Writer writer2 = this.f4793a;
                    writer2.write(o + str + "=\"" + i2 + "dp\"");
                    return;
                }
                sb.append(str2);
                writer.write(sb.toString());
            }
        }

        private void d(String str, boolean z, boolean z2) throws IOException {
            if (z != z2) {
                Writer writer = this.f4793a;
                writer.write(o + str + "=\"" + z + "dp\"");
            }
        }

        private void g(String str, int i2, int i3) throws IOException {
            if (i2 != i3) {
                Writer writer = this.f4793a;
                writer.write(o + str + "=\"" + i2 + "dp\"");
            }
        }

        private void h(String str, int i2, String[] strArr, int i3) throws IOException {
            if (i2 != i3) {
                Writer writer = this.f4793a;
                writer.write(o + str + "=\"" + strArr[i2] + "\"");
            }
        }

        /* access modifiers changed from: package-private */
        public String a(int i2) {
            if (this.f4805m.containsKey(Integer.valueOf(i2))) {
                return "@+id/" + this.f4805m.get(Integer.valueOf(i2)) + "";
            } else if (i2 == 0) {
                return ConstraintSet.V1;
            } else {
                String b2 = b(i2);
                this.f4805m.put(Integer.valueOf(i2), b2);
                return "@+id/" + b2 + "";
            }
        }

        /* access modifiers changed from: package-private */
        public String b(int i2) {
            if (i2 != -1) {
                try {
                    return this.f4795c.getResources().getResourceEntryName(i2);
                } catch (Exception unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unknown");
                    int i3 = this.f4797e + 1;
                    this.f4797e = i3;
                    sb.append(i3);
                    return sb.toString();
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("unknown");
                int i4 = this.f4797e + 1;
                this.f4797e = i4;
                sb2.append(i4);
                return sb2.toString();
            }
        }

        /* access modifiers changed from: package-private */
        public void e(int i2, float f2, int i3) throws IOException {
            if (i2 != -1) {
                this.f4793a.write("circle");
                this.f4793a.write(":[");
                this.f4793a.write(a(i2));
                Writer writer = this.f4793a;
                writer.write(", " + f2);
                Writer writer2 = this.f4793a;
                writer2.write(i3 + "]");
            }
        }

        /* access modifiers changed from: package-private */
        public void f(String str, int i2, String str2, int i3, int i4) throws IOException {
            if (i2 != -1) {
                Writer writer = this.f4793a;
                writer.write(o + str);
                this.f4793a.write(":[");
                this.f4793a.write(a(i2));
                this.f4793a.write(" , ");
                this.f4793a.write(str2);
                if (i3 != 0) {
                    Writer writer2 = this.f4793a;
                    writer2.write(" , " + i3);
                }
                this.f4793a.write("],\n");
            }
        }

        /* access modifiers changed from: package-private */
        public void i() throws IOException {
            this.f4793a.write("\n<ConstraintSet>\n");
            for (Integer num : ConstraintSet.this.f4709g.keySet()) {
                String a2 = a(num.intValue());
                this.f4793a.write("  <Constraint");
                Writer writer = this.f4793a;
                writer.write("\n       android:id=\"" + a2 + "\"");
                Layout layout2 = ((Constraint) ConstraintSet.this.f4709g.get(num)).f4714e;
                c("android:layout_width", layout2.f4735d, -5);
                c("android:layout_height", layout2.f4736e, -5);
                j("app:layout_constraintGuide_begin", (float) layout2.f4737f, -1.0f);
                j("app:layout_constraintGuide_end", (float) layout2.f4738g, -1.0f);
                j("app:layout_constraintGuide_percent", layout2.f4739h, -1.0f);
                j("app:layout_constraintHorizontal_bias", layout2.y, 0.5f);
                j("app:layout_constraintVertical_bias", layout2.z, 0.5f);
                m("app:layout_constraintDimensionRatio", layout2.A, (String) null);
                o("app:layout_constraintCircle", layout2.B);
                j("app:layout_constraintCircleRadius", (float) layout2.C, 0.0f);
                j("app:layout_constraintCircleAngle", layout2.D, 0.0f);
                j("android:orientation", (float) layout2.G, -1.0f);
                j("app:layout_constraintVertical_weight", layout2.V, -1.0f);
                j("app:layout_constraintHorizontal_weight", layout2.W, -1.0f);
                j("app:layout_constraintHorizontal_chainStyle", (float) layout2.X, 0.0f);
                j("app:layout_constraintVertical_chainStyle", (float) layout2.Y, 0.0f);
                j("app:barrierDirection", (float) layout2.h0, -1.0f);
                j("app:barrierMargin", (float) layout2.i0, 0.0f);
                g("app:layout_marginLeft", layout2.H, 0);
                g("app:layout_goneMarginLeft", layout2.O, Integer.MIN_VALUE);
                g("app:layout_marginRight", layout2.I, 0);
                g("app:layout_goneMarginRight", layout2.Q, Integer.MIN_VALUE);
                g("app:layout_marginStart", layout2.M, 0);
                g("app:layout_goneMarginStart", layout2.T, Integer.MIN_VALUE);
                g("app:layout_marginEnd", layout2.L, 0);
                g("app:layout_goneMarginEnd", layout2.S, Integer.MIN_VALUE);
                g("app:layout_marginTop", layout2.J, 0);
                g("app:layout_goneMarginTop", layout2.P, Integer.MIN_VALUE);
                g("app:layout_marginBottom", layout2.K, 0);
                g("app:layout_goneMarginBottom", layout2.R, Integer.MIN_VALUE);
                g("app:goneBaselineMargin", layout2.U, Integer.MIN_VALUE);
                g("app:baselineMargin", layout2.N, 0);
                d("app:layout_constrainedWidth", layout2.n0, false);
                d("app:layout_constrainedHeight", layout2.o0, false);
                d("app:barrierAllowsGoneWidgets", layout2.p0, true);
                j("app:layout_wrapBehaviorInParent", (float) layout2.q0, 0.0f);
                o("app:baselineToBaseline", layout2.r);
                o("app:baselineToBottom", layout2.t);
                o("app:baselineToTop", layout2.s);
                o("app:layout_constraintBottom_toBottomOf", layout2.q);
                o("app:layout_constraintBottom_toTopOf", layout2.p);
                o("app:layout_constraintEnd_toEndOf", layout2.x);
                o("app:layout_constraintEnd_toStartOf", layout2.w);
                o("app:layout_constraintLeft_toLeftOf", layout2.f4741j);
                o("app:layout_constraintLeft_toRightOf", layout2.f4742k);
                o("app:layout_constraintRight_toLeftOf", layout2.f4743l);
                o("app:layout_constraintRight_toRightOf", layout2.f4744m);
                o("app:layout_constraintStart_toEndOf", layout2.u);
                o("app:layout_constraintStart_toStartOf", layout2.v);
                o("app:layout_constraintTop_toBottomOf", layout2.o);
                o("app:layout_constraintTop_toTopOf", layout2.f4745n);
                String[] strArr = {"spread", "wrap", "percent"};
                h("app:layout_constraintHeight_default", layout2.a0, strArr, 0);
                j("app:layout_constraintHeight_percent", layout2.g0, 1.0f);
                g("app:layout_constraintHeight_min", layout2.e0, 0);
                g("app:layout_constraintHeight_max", layout2.c0, 0);
                d("android:layout_constrainedHeight", layout2.o0, false);
                h("app:layout_constraintWidth_default", layout2.Z, strArr, 0);
                j("app:layout_constraintWidth_percent", layout2.f0, 1.0f);
                g("app:layout_constraintWidth_min", layout2.d0, 0);
                g("app:layout_constraintWidth_max", layout2.b0, 0);
                d("android:layout_constrainedWidth", layout2.n0, false);
                j("app:layout_constraintVertical_weight", layout2.V, -1.0f);
                j("app:layout_constraintHorizontal_weight", layout2.W, -1.0f);
                k("app:layout_constraintHorizontal_chainStyle", layout2.X);
                k("app:layout_constraintVertical_chainStyle", layout2.Y);
                h("app:barrierDirection", layout2.h0, new String[]{"left", "right", "top", "bottom", "start", TtmlNode.p0}, -1);
                m("app:layout_constraintTag", layout2.m0, (String) null);
                int[] iArr = layout2.k0;
                if (iArr != null) {
                    n("'ReferenceIds'", iArr);
                }
                this.f4793a.write(" />\n");
            }
            this.f4793a.write("</ConstraintSet>\n");
        }

        /* access modifiers changed from: package-private */
        public void j(String str, float f2, float f3) throws IOException {
            if (f2 != f3) {
                Writer writer = this.f4793a;
                writer.write(o + str);
                Writer writer2 = this.f4793a;
                writer2.write("=\"" + f2 + "\"");
            }
        }

        /* access modifiers changed from: package-private */
        public void k(String str, int i2) throws IOException {
            if (i2 != 0 && i2 != -1) {
                Writer writer = this.f4793a;
                writer.write(o + str + "=\"" + i2 + "\"\n");
            }
        }

        /* access modifiers changed from: package-private */
        public void l(String str, String str2) throws IOException {
            if (str2 != null) {
                this.f4793a.write(str);
                this.f4793a.write(":");
                Writer writer = this.f4793a;
                writer.write(", " + str2);
                this.f4793a.write(StringUtils.LF);
            }
        }

        /* access modifiers changed from: package-private */
        public void m(String str, String str2, String str3) throws IOException {
            if (str2 != null && !str2.equals(str3)) {
                Writer writer = this.f4793a;
                writer.write(o + str);
                Writer writer2 = this.f4793a;
                writer2.write("=\"" + str2 + "\"");
            }
        }

        /* access modifiers changed from: package-private */
        public void n(String str, int[] iArr) throws IOException {
            if (iArr != null) {
                Writer writer = this.f4793a;
                writer.write(o + str);
                this.f4793a.write(":");
                int i2 = 0;
                while (i2 < iArr.length) {
                    Writer writer2 = this.f4793a;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i2 == 0 ? "[" : ", ");
                    sb.append(a(iArr[i2]));
                    writer2.write(sb.toString());
                    i2++;
                }
                this.f4793a.write("],\n");
            }
        }

        /* access modifiers changed from: package-private */
        public void o(String str, int i2) throws IOException {
            if (i2 != -1) {
                Writer writer = this.f4793a;
                writer.write(o + str);
                Writer writer2 = this.f4793a;
                writer2.write("=\"" + a(i2) + "\"");
            }
        }
    }

    static {
        W.append(R.styleable.I5, 25);
        W.append(R.styleable.J5, 26);
        W.append(R.styleable.L5, 29);
        W.append(R.styleable.M5, 30);
        W.append(R.styleable.S5, 36);
        W.append(R.styleable.R5, 35);
        W.append(R.styleable.p5, 4);
        W.append(R.styleable.o5, 3);
        W.append(R.styleable.k5, 1);
        W.append(R.styleable.m5, 91);
        W.append(R.styleable.l5, 92);
        W.append(R.styleable.b6, 6);
        W.append(R.styleable.c6, 7);
        W.append(R.styleable.w5, 17);
        W.append(R.styleable.x5, 18);
        W.append(R.styleable.y5, 19);
        W.append(R.styleable.g5, 99);
        W.append(R.styleable.e4, 27);
        W.append(R.styleable.N5, 32);
        W.append(R.styleable.O5, 33);
        W.append(R.styleable.v5, 10);
        W.append(R.styleable.u5, 9);
        W.append(R.styleable.g6, 13);
        W.append(R.styleable.j6, 16);
        W.append(R.styleable.h6, 14);
        W.append(R.styleable.e6, 11);
        W.append(R.styleable.i6, 15);
        W.append(R.styleable.f6, 12);
        W.append(R.styleable.V5, 40);
        W.append(R.styleable.G5, 39);
        W.append(R.styleable.F5, 41);
        W.append(R.styleable.U5, 42);
        W.append(R.styleable.E5, 20);
        W.append(R.styleable.T5, 37);
        W.append(R.styleable.t5, 5);
        W.append(R.styleable.H5, 87);
        W.append(R.styleable.Q5, 87);
        W.append(R.styleable.K5, 87);
        W.append(R.styleable.n5, 87);
        W.append(R.styleable.j5, 87);
        W.append(R.styleable.j4, 24);
        W.append(R.styleable.l4, 28);
        W.append(R.styleable.B4, 31);
        W.append(R.styleable.C4, 8);
        W.append(R.styleable.k4, 34);
        W.append(R.styleable.m4, 2);
        W.append(R.styleable.h4, 23);
        W.append(R.styleable.i4, 21);
        W.append(R.styleable.W5, 95);
        W.append(R.styleable.z5, 96);
        W.append(R.styleable.g4, 22);
        W.append(R.styleable.r4, 43);
        W.append(R.styleable.E4, 44);
        W.append(R.styleable.z4, 45);
        W.append(R.styleable.A4, 46);
        W.append(R.styleable.y4, 60);
        W.append(R.styleable.w4, 47);
        W.append(R.styleable.x4, 48);
        W.append(R.styleable.s4, 49);
        W.append(R.styleable.t4, 50);
        W.append(R.styleable.u4, 51);
        W.append(R.styleable.v4, 52);
        W.append(R.styleable.D4, 53);
        W.append(R.styleable.X5, 54);
        W.append(R.styleable.A5, 55);
        W.append(R.styleable.Y5, 56);
        W.append(R.styleable.B5, 57);
        W.append(R.styleable.Z5, 58);
        W.append(R.styleable.C5, 59);
        W.append(R.styleable.q5, 61);
        W.append(R.styleable.s5, 62);
        W.append(R.styleable.r5, 63);
        W.append(R.styleable.G4, 64);
        W.append(R.styleable.v6, 65);
        W.append(R.styleable.N4, 66);
        W.append(R.styleable.w6, 67);
        W.append(R.styleable.n6, 79);
        W.append(R.styleable.f4, 38);
        W.append(R.styleable.m6, 68);
        W.append(R.styleable.a6, 69);
        W.append(R.styleable.D5, 70);
        W.append(R.styleable.l6, 97);
        W.append(R.styleable.K4, 71);
        W.append(R.styleable.I4, 72);
        W.append(R.styleable.J4, 73);
        W.append(R.styleable.L4, 74);
        W.append(R.styleable.H4, 75);
        W.append(R.styleable.o6, 76);
        W.append(R.styleable.P5, 77);
        W.append(R.styleable.x6, 78);
        W.append(R.styleable.i5, 80);
        W.append(R.styleable.h5, 81);
        W.append(R.styleable.q6, 82);
        W.append(R.styleable.u6, 83);
        W.append(R.styleable.t6, 84);
        W.append(R.styleable.s6, 85);
        W.append(R.styleable.r6, 86);
        SparseIntArray sparseIntArray = X;
        int i2 = R.styleable.Aa;
        sparseIntArray.append(i2, 6);
        X.append(i2, 7);
        X.append(R.styleable.T8, 27);
        X.append(R.styleable.Ea, 13);
        X.append(R.styleable.Ha, 16);
        X.append(R.styleable.Fa, 14);
        X.append(R.styleable.Ca, 11);
        X.append(R.styleable.Ga, 15);
        X.append(R.styleable.Da, 12);
        X.append(R.styleable.ta, 40);
        X.append(R.styleable.ma, 39);
        X.append(R.styleable.la, 41);
        X.append(R.styleable.sa, 42);
        X.append(R.styleable.ka, 20);
        X.append(R.styleable.ra, 37);
        X.append(R.styleable.ba, 5);
        X.append(R.styleable.na, 87);
        X.append(R.styleable.qa, 87);
        X.append(R.styleable.oa, 87);
        X.append(R.styleable.Y9, 87);
        X.append(R.styleable.X9, 87);
        X.append(R.styleable.Y8, 24);
        X.append(R.styleable.a9, 28);
        X.append(R.styleable.q9, 31);
        X.append(R.styleable.r9, 8);
        X.append(R.styleable.Z8, 34);
        X.append(R.styleable.b9, 2);
        X.append(R.styleable.W8, 23);
        X.append(R.styleable.X8, 21);
        X.append(R.styleable.ua, 95);
        X.append(R.styleable.fa, 96);
        X.append(R.styleable.V8, 22);
        X.append(R.styleable.g9, 43);
        X.append(R.styleable.t9, 44);
        X.append(R.styleable.o9, 45);
        X.append(R.styleable.p9, 46);
        X.append(R.styleable.n9, 60);
        X.append(R.styleable.l9, 47);
        X.append(R.styleable.m9, 48);
        X.append(R.styleable.h9, 49);
        X.append(R.styleable.i9, 50);
        X.append(R.styleable.j9, 51);
        X.append(R.styleable.k9, 52);
        X.append(R.styleable.s9, 53);
        X.append(R.styleable.va, 54);
        X.append(R.styleable.ga, 55);
        X.append(R.styleable.wa, 56);
        X.append(R.styleable.ha, 57);
        X.append(R.styleable.xa, 58);
        X.append(R.styleable.ia, 59);
        X.append(R.styleable.aa, 62);
        X.append(R.styleable.Z9, 63);
        X.append(R.styleable.v9, 64);
        X.append(R.styleable.Ua, 65);
        X.append(R.styleable.B9, 66);
        X.append(R.styleable.Va, 67);
        X.append(R.styleable.La, 79);
        X.append(R.styleable.U8, 38);
        X.append(R.styleable.Ma, 98);
        X.append(R.styleable.Ka, 68);
        X.append(R.styleable.ya, 69);
        X.append(R.styleable.ja, 70);
        X.append(R.styleable.z9, 71);
        X.append(R.styleable.x9, 72);
        X.append(R.styleable.y9, 73);
        X.append(R.styleable.A9, 74);
        X.append(R.styleable.w9, 75);
        X.append(R.styleable.Na, 76);
        X.append(R.styleable.pa, 77);
        X.append(R.styleable.Wa, 78);
        X.append(R.styleable.W9, 80);
        X.append(R.styleable.V9, 81);
        X.append(R.styleable.Pa, 82);
        X.append(R.styleable.Ta, 83);
        X.append(R.styleable.Sa, 84);
        X.append(R.styleable.Ra, 85);
        X.append(R.styleable.Qa, 86);
        X.append(R.styleable.Ja, 97);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (r4 == -1) goto L_0x0022;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void A0(java.lang.Object r3, android.content.res.TypedArray r4, int r5, int r6) {
        /*
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            android.util.TypedValue r0 = r4.peekValue(r5)
            int r0 = r0.type
            r1 = 3
            if (r0 == r1) goto L_0x006d
            r1 = 5
            r2 = 0
            if (r0 == r1) goto L_0x0028
            int r4 = r4.getInt(r5, r2)
            r5 = -4
            r0 = -2
            if (r4 == r5) goto L_0x0024
            r5 = -3
            if (r4 == r5) goto L_0x0020
            if (r4 == r0) goto L_0x0022
            r5 = -1
            if (r4 == r5) goto L_0x0022
        L_0x0020:
            r4 = 0
            goto L_0x002d
        L_0x0022:
            r2 = r4
            goto L_0x0020
        L_0x0024:
            r2 = 1
            r4 = 1
            r2 = -2
            goto L_0x002d
        L_0x0028:
            int r4 = r4.getDimensionPixelSize(r5, r2)
            goto L_0x0022
        L_0x002d:
            boolean r5 = r3 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r5 == 0) goto L_0x003f
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r3 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r3
            if (r6 != 0) goto L_0x003a
            r3.width = r2
            r3.a0 = r4
            goto L_0x006c
        L_0x003a:
            r3.height = r2
            r3.b0 = r4
            goto L_0x006c
        L_0x003f:
            boolean r5 = r3 instanceof androidx.constraintlayout.widget.ConstraintSet.Layout
            if (r5 == 0) goto L_0x0051
            androidx.constraintlayout.widget.ConstraintSet$Layout r3 = (androidx.constraintlayout.widget.ConstraintSet.Layout) r3
            if (r6 != 0) goto L_0x004c
            r3.f4735d = r2
            r3.n0 = r4
            goto L_0x006c
        L_0x004c:
            r3.f4736e = r2
            r3.o0 = r4
            goto L_0x006c
        L_0x0051:
            boolean r5 = r3 instanceof androidx.constraintlayout.widget.ConstraintSet.Constraint.Delta
            if (r5 == 0) goto L_0x006c
            androidx.constraintlayout.widget.ConstraintSet$Constraint$Delta r3 = (androidx.constraintlayout.widget.ConstraintSet.Constraint.Delta) r3
            if (r6 != 0) goto L_0x0064
            r5 = 23
            r3.b(r5, r2)
            r5 = 80
        L_0x0060:
            r3.d(r5, r4)
            goto L_0x006c
        L_0x0064:
            r5 = 21
            r3.b(r5, r2)
            r5 = 81
            goto L_0x0060
        L_0x006c:
            return
        L_0x006d:
            java.lang.String r4 = r4.getString(r5)
            B0(r3, r4, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.A0(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    static void B0(Object obj, String str, int i2) {
        int i3;
        int i4;
        if (str != null) {
            int indexOf = str.indexOf(61);
            int length = str.length();
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                String substring2 = str.substring(indexOf + 1);
                if (substring2.length() > 0) {
                    String trim = substring.trim();
                    String trim2 = substring2.trim();
                    if (U1.equalsIgnoreCase(trim)) {
                        if (obj instanceof ConstraintLayout.LayoutParams) {
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) obj;
                            if (i2 == 0) {
                                layoutParams.width = 0;
                            } else {
                                layoutParams.height = 0;
                            }
                            C0(layoutParams, trim2);
                        } else if (obj instanceof Layout) {
                            ((Layout) obj).A = trim2;
                        } else if (obj instanceof Constraint.Delta) {
                            ((Constraint.Delta) obj).c(5, trim2);
                        }
                    } else if (T1.equalsIgnoreCase(trim)) {
                        try {
                            float parseFloat = Float.parseFloat(trim2);
                            if (obj instanceof ConstraintLayout.LayoutParams) {
                                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) obj;
                                if (i2 == 0) {
                                    layoutParams2.width = 0;
                                    layoutParams2.L = parseFloat;
                                    return;
                                }
                                layoutParams2.height = 0;
                                layoutParams2.M = parseFloat;
                            } else if (obj instanceof Layout) {
                                Layout layout2 = (Layout) obj;
                                if (i2 == 0) {
                                    layout2.f4735d = 0;
                                    layout2.W = parseFloat;
                                    return;
                                }
                                layout2.f4736e = 0;
                                layout2.V = parseFloat;
                            } else if (obj instanceof Constraint.Delta) {
                                Constraint.Delta delta = (Constraint.Delta) obj;
                                if (i2 == 0) {
                                    delta.b(23, 0);
                                    i4 = 39;
                                } else {
                                    delta.b(21, 0);
                                    i4 = 40;
                                }
                                delta.a(i4, parseFloat);
                            }
                        } catch (NumberFormatException unused) {
                        }
                    } else if (V1.equalsIgnoreCase(trim)) {
                        float max = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(trim2)));
                        if (obj instanceof ConstraintLayout.LayoutParams) {
                            ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) obj;
                            if (i2 == 0) {
                                layoutParams3.width = 0;
                                layoutParams3.V = max;
                                layoutParams3.P = 2;
                                return;
                            }
                            layoutParams3.height = 0;
                            layoutParams3.W = max;
                            layoutParams3.Q = 2;
                        } else if (obj instanceof Layout) {
                            Layout layout3 = (Layout) obj;
                            if (i2 == 0) {
                                layout3.f4735d = 0;
                                layout3.f0 = max;
                                layout3.Z = 2;
                                return;
                            }
                            layout3.f4736e = 0;
                            layout3.g0 = max;
                            layout3.a0 = 2;
                        } else if (obj instanceof Constraint.Delta) {
                            Constraint.Delta delta2 = (Constraint.Delta) obj;
                            if (i2 == 0) {
                                delta2.b(23, 0);
                                i3 = 54;
                            } else {
                                delta2.b(21, 0);
                                i3 = 55;
                            }
                            delta2.b(i3, 2);
                        }
                    }
                }
            }
        }
    }

    static void C0(ConstraintLayout.LayoutParams layoutParams, String str) {
        float f2 = Float.NaN;
        int i2 = -1;
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i3 = 0;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (substring.equalsIgnoreCase(ExifInterface.T4)) {
                    i2 = 0;
                } else if (substring.equalsIgnoreCase("H")) {
                    i2 = 1;
                }
                i3 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 < 0 || indexOf2 >= length - 1) {
                String substring2 = str.substring(i3);
                if (substring2.length() > 0) {
                    f2 = Float.parseFloat(substring2);
                }
            } else {
                String substring3 = str.substring(i3, indexOf2);
                String substring4 = str.substring(indexOf2 + 1);
                if (substring3.length() > 0 && substring4.length() > 0) {
                    try {
                        float parseFloat = Float.parseFloat(substring3);
                        float parseFloat2 = Float.parseFloat(substring4);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            f2 = i2 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
        layoutParams.I = str;
        layoutParams.J = f2;
        layoutParams.K = i2;
    }

    private String F1(int i2) {
        switch (i2) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return HtmlTags.i0;
            case 6:
                return "start";
            case 7:
                return TtmlNode.p0;
            default:
                return "undefined";
        }
    }

    private void G0(Context context, Constraint constraint, TypedArray typedArray, boolean z2) {
        Motion motion;
        String str;
        Motion motion2;
        StringBuilder sb;
        String str2;
        if (z2) {
            H0(context, constraint, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            if (!(index == R.styleable.f4 || R.styleable.B4 == index || R.styleable.C4 == index)) {
                constraint.f4713d.f4746a = true;
                constraint.f4714e.f4733b = true;
                constraint.f4712c.f4760a = true;
                constraint.f4715f.f4765a = true;
            }
            switch (W.get(index)) {
                case 1:
                    Layout layout2 = constraint.f4714e;
                    layout2.r = y0(typedArray, index, layout2.r);
                    continue;
                case 2:
                    Layout layout3 = constraint.f4714e;
                    layout3.K = typedArray.getDimensionPixelSize(index, layout3.K);
                    continue;
                case 3:
                    Layout layout4 = constraint.f4714e;
                    layout4.q = y0(typedArray, index, layout4.q);
                    continue;
                case 4:
                    Layout layout5 = constraint.f4714e;
                    layout5.p = y0(typedArray, index, layout5.p);
                    continue;
                case 5:
                    constraint.f4714e.A = typedArray.getString(index);
                    continue;
                case 6:
                    Layout layout6 = constraint.f4714e;
                    layout6.E = typedArray.getDimensionPixelOffset(index, layout6.E);
                    continue;
                case 7:
                    Layout layout7 = constraint.f4714e;
                    layout7.F = typedArray.getDimensionPixelOffset(index, layout7.F);
                    continue;
                case 8:
                    Layout layout8 = constraint.f4714e;
                    layout8.L = typedArray.getDimensionPixelSize(index, layout8.L);
                    continue;
                case 9:
                    Layout layout9 = constraint.f4714e;
                    layout9.x = y0(typedArray, index, layout9.x);
                    continue;
                case 10:
                    Layout layout10 = constraint.f4714e;
                    layout10.w = y0(typedArray, index, layout10.w);
                    continue;
                case 11:
                    Layout layout11 = constraint.f4714e;
                    layout11.R = typedArray.getDimensionPixelSize(index, layout11.R);
                    continue;
                case 12:
                    Layout layout12 = constraint.f4714e;
                    layout12.S = typedArray.getDimensionPixelSize(index, layout12.S);
                    continue;
                case 13:
                    Layout layout13 = constraint.f4714e;
                    layout13.O = typedArray.getDimensionPixelSize(index, layout13.O);
                    continue;
                case 14:
                    Layout layout14 = constraint.f4714e;
                    layout14.Q = typedArray.getDimensionPixelSize(index, layout14.Q);
                    continue;
                case 15:
                    Layout layout15 = constraint.f4714e;
                    layout15.T = typedArray.getDimensionPixelSize(index, layout15.T);
                    continue;
                case 16:
                    Layout layout16 = constraint.f4714e;
                    layout16.P = typedArray.getDimensionPixelSize(index, layout16.P);
                    continue;
                case 17:
                    Layout layout17 = constraint.f4714e;
                    layout17.f4737f = typedArray.getDimensionPixelOffset(index, layout17.f4737f);
                    continue;
                case 18:
                    Layout layout18 = constraint.f4714e;
                    layout18.f4738g = typedArray.getDimensionPixelOffset(index, layout18.f4738g);
                    continue;
                case 19:
                    Layout layout19 = constraint.f4714e;
                    layout19.f4739h = typedArray.getFloat(index, layout19.f4739h);
                    continue;
                case 20:
                    Layout layout20 = constraint.f4714e;
                    layout20.y = typedArray.getFloat(index, layout20.y);
                    continue;
                case 21:
                    Layout layout21 = constraint.f4714e;
                    layout21.f4736e = typedArray.getLayoutDimension(index, layout21.f4736e);
                    continue;
                case 22:
                    PropertySet propertySet = constraint.f4712c;
                    propertySet.f4761b = typedArray.getInt(index, propertySet.f4761b);
                    PropertySet propertySet2 = constraint.f4712c;
                    propertySet2.f4761b = U[propertySet2.f4761b];
                    continue;
                case 23:
                    Layout layout22 = constraint.f4714e;
                    layout22.f4735d = typedArray.getLayoutDimension(index, layout22.f4735d);
                    continue;
                case 24:
                    Layout layout23 = constraint.f4714e;
                    layout23.H = typedArray.getDimensionPixelSize(index, layout23.H);
                    continue;
                case 25:
                    Layout layout24 = constraint.f4714e;
                    layout24.f4741j = y0(typedArray, index, layout24.f4741j);
                    continue;
                case 26:
                    Layout layout25 = constraint.f4714e;
                    layout25.f4742k = y0(typedArray, index, layout25.f4742k);
                    continue;
                case 27:
                    Layout layout26 = constraint.f4714e;
                    layout26.G = typedArray.getInt(index, layout26.G);
                    continue;
                case 28:
                    Layout layout27 = constraint.f4714e;
                    layout27.I = typedArray.getDimensionPixelSize(index, layout27.I);
                    continue;
                case 29:
                    Layout layout28 = constraint.f4714e;
                    layout28.f4743l = y0(typedArray, index, layout28.f4743l);
                    continue;
                case 30:
                    Layout layout29 = constraint.f4714e;
                    layout29.f4744m = y0(typedArray, index, layout29.f4744m);
                    continue;
                case 31:
                    Layout layout30 = constraint.f4714e;
                    layout30.M = typedArray.getDimensionPixelSize(index, layout30.M);
                    continue;
                case 32:
                    Layout layout31 = constraint.f4714e;
                    layout31.u = y0(typedArray, index, layout31.u);
                    continue;
                case 33:
                    Layout layout32 = constraint.f4714e;
                    layout32.v = y0(typedArray, index, layout32.v);
                    continue;
                case 34:
                    Layout layout33 = constraint.f4714e;
                    layout33.J = typedArray.getDimensionPixelSize(index, layout33.J);
                    continue;
                case 35:
                    Layout layout34 = constraint.f4714e;
                    layout34.o = y0(typedArray, index, layout34.o);
                    continue;
                case 36:
                    Layout layout35 = constraint.f4714e;
                    layout35.f4745n = y0(typedArray, index, layout35.f4745n);
                    continue;
                case 37:
                    Layout layout36 = constraint.f4714e;
                    layout36.z = typedArray.getFloat(index, layout36.z);
                    continue;
                case 38:
                    constraint.f4710a = typedArray.getResourceId(index, constraint.f4710a);
                    continue;
                case 39:
                    Layout layout37 = constraint.f4714e;
                    layout37.W = typedArray.getFloat(index, layout37.W);
                    continue;
                case 40:
                    Layout layout38 = constraint.f4714e;
                    layout38.V = typedArray.getFloat(index, layout38.V);
                    continue;
                case 41:
                    Layout layout39 = constraint.f4714e;
                    layout39.X = typedArray.getInt(index, layout39.X);
                    continue;
                case 42:
                    Layout layout40 = constraint.f4714e;
                    layout40.Y = typedArray.getInt(index, layout40.Y);
                    continue;
                case 43:
                    PropertySet propertySet3 = constraint.f4712c;
                    propertySet3.f4763d = typedArray.getFloat(index, propertySet3.f4763d);
                    continue;
                case 44:
                    Transform transform = constraint.f4715f;
                    transform.f4777m = true;
                    transform.f4778n = typedArray.getDimension(index, transform.f4778n);
                    continue;
                case 45:
                    Transform transform2 = constraint.f4715f;
                    transform2.f4767c = typedArray.getFloat(index, transform2.f4767c);
                    continue;
                case 46:
                    Transform transform3 = constraint.f4715f;
                    transform3.f4768d = typedArray.getFloat(index, transform3.f4768d);
                    continue;
                case 47:
                    Transform transform4 = constraint.f4715f;
                    transform4.f4769e = typedArray.getFloat(index, transform4.f4769e);
                    continue;
                case 48:
                    Transform transform5 = constraint.f4715f;
                    transform5.f4770f = typedArray.getFloat(index, transform5.f4770f);
                    continue;
                case 49:
                    Transform transform6 = constraint.f4715f;
                    transform6.f4771g = typedArray.getDimension(index, transform6.f4771g);
                    continue;
                case 50:
                    Transform transform7 = constraint.f4715f;
                    transform7.f4772h = typedArray.getDimension(index, transform7.f4772h);
                    continue;
                case 51:
                    Transform transform8 = constraint.f4715f;
                    transform8.f4774j = typedArray.getDimension(index, transform8.f4774j);
                    continue;
                case 52:
                    Transform transform9 = constraint.f4715f;
                    transform9.f4775k = typedArray.getDimension(index, transform9.f4775k);
                    continue;
                case 53:
                    Transform transform10 = constraint.f4715f;
                    transform10.f4776l = typedArray.getDimension(index, transform10.f4776l);
                    continue;
                case 54:
                    Layout layout41 = constraint.f4714e;
                    layout41.Z = typedArray.getInt(index, layout41.Z);
                    continue;
                case 55:
                    Layout layout42 = constraint.f4714e;
                    layout42.a0 = typedArray.getInt(index, layout42.a0);
                    continue;
                case 56:
                    Layout layout43 = constraint.f4714e;
                    layout43.b0 = typedArray.getDimensionPixelSize(index, layout43.b0);
                    continue;
                case 57:
                    Layout layout44 = constraint.f4714e;
                    layout44.c0 = typedArray.getDimensionPixelSize(index, layout44.c0);
                    continue;
                case 58:
                    Layout layout45 = constraint.f4714e;
                    layout45.d0 = typedArray.getDimensionPixelSize(index, layout45.d0);
                    continue;
                case 59:
                    Layout layout46 = constraint.f4714e;
                    layout46.e0 = typedArray.getDimensionPixelSize(index, layout46.e0);
                    continue;
                case 60:
                    Transform transform11 = constraint.f4715f;
                    transform11.f4766b = typedArray.getFloat(index, transform11.f4766b);
                    continue;
                case 61:
                    Layout layout47 = constraint.f4714e;
                    layout47.B = y0(typedArray, index, layout47.B);
                    continue;
                case 62:
                    Layout layout48 = constraint.f4714e;
                    layout48.C = typedArray.getDimensionPixelSize(index, layout48.C);
                    continue;
                case 63:
                    Layout layout49 = constraint.f4714e;
                    layout49.D = typedArray.getFloat(index, layout49.D);
                    continue;
                case 64:
                    Motion motion3 = constraint.f4713d;
                    motion3.f4747b = y0(typedArray, index, motion3.f4747b);
                    continue;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        motion = constraint.f4713d;
                        str = typedArray.getString(index);
                    } else {
                        motion = constraint.f4713d;
                        str = Easing.o[typedArray.getInteger(index, 0)];
                    }
                    motion.f4749d = str;
                    continue;
                case 66:
                    constraint.f4713d.f4751f = typedArray.getInt(index, 0);
                    continue;
                case 67:
                    Motion motion4 = constraint.f4713d;
                    motion4.f4754i = typedArray.getFloat(index, motion4.f4754i);
                    continue;
                case 68:
                    PropertySet propertySet4 = constraint.f4712c;
                    propertySet4.f4764e = typedArray.getFloat(index, propertySet4.f4764e);
                    continue;
                case 69:
                    constraint.f4714e.f0 = typedArray.getFloat(index, 1.0f);
                    continue;
                case 70:
                    constraint.f4714e.g0 = typedArray.getFloat(index, 1.0f);
                    continue;
                case 71:
                    Log.e(f4696h, "CURRENTLY UNSUPPORTED");
                    continue;
                case 72:
                    Layout layout50 = constraint.f4714e;
                    layout50.h0 = typedArray.getInt(index, layout50.h0);
                    continue;
                case 73:
                    Layout layout51 = constraint.f4714e;
                    layout51.i0 = typedArray.getDimensionPixelSize(index, layout51.i0);
                    continue;
                case 74:
                    constraint.f4714e.l0 = typedArray.getString(index);
                    continue;
                case 75:
                    Layout layout52 = constraint.f4714e;
                    layout52.p0 = typedArray.getBoolean(index, layout52.p0);
                    continue;
                case 76:
                    Motion motion5 = constraint.f4713d;
                    motion5.f4750e = typedArray.getInt(index, motion5.f4750e);
                    continue;
                case 77:
                    constraint.f4714e.m0 = typedArray.getString(index);
                    continue;
                case 78:
                    PropertySet propertySet5 = constraint.f4712c;
                    propertySet5.f4762c = typedArray.getInt(index, propertySet5.f4762c);
                    continue;
                case 79:
                    Motion motion6 = constraint.f4713d;
                    motion6.f4752g = typedArray.getFloat(index, motion6.f4752g);
                    continue;
                case 80:
                    Layout layout53 = constraint.f4714e;
                    layout53.n0 = typedArray.getBoolean(index, layout53.n0);
                    continue;
                case 81:
                    Layout layout54 = constraint.f4714e;
                    layout54.o0 = typedArray.getBoolean(index, layout54.o0);
                    continue;
                case 82:
                    Motion motion7 = constraint.f4713d;
                    motion7.f4748c = typedArray.getInteger(index, motion7.f4748c);
                    continue;
                case 83:
                    Transform transform12 = constraint.f4715f;
                    transform12.f4773i = y0(typedArray, index, transform12.f4773i);
                    continue;
                case 84:
                    Motion motion8 = constraint.f4713d;
                    motion8.f4756k = typedArray.getInteger(index, motion8.f4756k);
                    continue;
                case 85:
                    Motion motion9 = constraint.f4713d;
                    motion9.f4755j = typedArray.getFloat(index, motion9.f4755j);
                    continue;
                case 86:
                    int i3 = typedArray.peekValue(index).type;
                    if (i3 != 1) {
                        if (i3 != 3) {
                            Motion motion10 = constraint.f4713d;
                            motion10.f4758m = typedArray.getInteger(index, motion10.f4759n);
                            break;
                        } else {
                            constraint.f4713d.f4757l = typedArray.getString(index);
                            if (constraint.f4713d.f4757l.indexOf("/") <= 0) {
                                constraint.f4713d.f4758m = -1;
                                break;
                            } else {
                                constraint.f4713d.f4759n = typedArray.getResourceId(index, -1);
                                motion2 = constraint.f4713d;
                            }
                        }
                    } else {
                        constraint.f4713d.f4759n = typedArray.getResourceId(index, -1);
                        motion2 = constraint.f4713d;
                        if (motion2.f4759n == -1) {
                            continue;
                        }
                    }
                    motion2.f4758m = -2;
                    break;
                case 87:
                    sb = new StringBuilder();
                    str2 = "unused attribute 0x";
                    break;
                case 91:
                    Layout layout55 = constraint.f4714e;
                    layout55.s = y0(typedArray, index, layout55.s);
                    continue;
                case 92:
                    Layout layout56 = constraint.f4714e;
                    layout56.t = y0(typedArray, index, layout56.t);
                    continue;
                case 93:
                    Layout layout57 = constraint.f4714e;
                    layout57.N = typedArray.getDimensionPixelSize(index, layout57.N);
                    continue;
                case 94:
                    Layout layout58 = constraint.f4714e;
                    layout58.U = typedArray.getDimensionPixelSize(index, layout58.U);
                    continue;
                case 95:
                    A0(constraint.f4714e, typedArray, index, 0);
                    continue;
                case 96:
                    A0(constraint.f4714e, typedArray, index, 1);
                    continue;
                case 97:
                    Layout layout59 = constraint.f4714e;
                    layout59.q0 = typedArray.getInt(index, layout59.q0);
                    continue;
                default:
                    sb = new StringBuilder();
                    str2 = "Unknown attribute 0x";
                    break;
            }
            sb.append(str2);
            sb.append(Integer.toHexString(index));
            sb.append("   ");
            sb.append(W.get(index));
            Log.w(f4696h, sb.toString());
        }
        Layout layout60 = constraint.f4714e;
        if (layout60.l0 != null) {
            layout60.k0 = null;
        }
    }

    private static String[] G1(String str) {
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        boolean z2 = false;
        for (int i3 = 0; i3 < charArray.length; i3++) {
            char c2 = charArray[i3];
            if (c2 == ',' && !z2) {
                arrayList.add(new String(charArray, i2, i3 - i2));
                i2 = i3 + 1;
            } else if (c2 == '\"') {
                z2 = !z2;
            }
        }
        arrayList.add(new String(charArray, i2, charArray.length - i2));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0482, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x009d, code lost:
        r0.b(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x014b, code lost:
        r0.a(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01a5, code lost:
        r0.c(r4, r13.getString(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01ea, code lost:
        r3 = r13.getFloat(r3, 1.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x003c, code lost:
        r4.append(r5);
        r4.append(java.lang.Integer.toHexString(r3));
        r4.append("   ");
        r4.append(W.get(r3));
        android.util.Log.w(f4696h, r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0065, code lost:
        r0.d(r4, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void H0(android.content.Context r11, androidx.constraintlayout.widget.ConstraintSet.Constraint r12, android.content.res.TypedArray r13) {
        /*
            int r11 = r13.getIndexCount()
            androidx.constraintlayout.widget.ConstraintSet$Constraint$Delta r0 = new androidx.constraintlayout.widget.ConstraintSet$Constraint$Delta
            r0.<init>()
            r12.f4717h = r0
            androidx.constraintlayout.widget.ConstraintSet$Motion r1 = r12.f4713d
            r2 = 0
            r1.f4746a = r2
            androidx.constraintlayout.widget.ConstraintSet$Layout r1 = r12.f4714e
            r1.f4733b = r2
            androidx.constraintlayout.widget.ConstraintSet$PropertySet r1 = r12.f4712c
            r1.f4760a = r2
            androidx.constraintlayout.widget.ConstraintSet$Transform r1 = r12.f4715f
            r1.f4765a = r2
            r1 = 0
        L_0x001d:
            if (r1 >= r11) goto L_0x0486
            int r3 = r13.getIndex(r1)
            android.util.SparseIntArray r4 = X
            int r4 = r4.get(r3)
            r5 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r6 = "   "
            r7 = 3
            java.lang.String r8 = "ConstraintSet"
            r9 = 1
            r10 = -1
            switch(r4) {
                case 2: goto L_0x0477;
                case 3: goto L_0x0035;
                case 4: goto L_0x0035;
                case 5: goto L_0x0474;
                case 6: goto L_0x0469;
                case 7: goto L_0x045e;
                case 8: goto L_0x0452;
                case 9: goto L_0x0035;
                case 10: goto L_0x0035;
                case 11: goto L_0x0446;
                case 12: goto L_0x043a;
                case 13: goto L_0x042e;
                case 14: goto L_0x0422;
                case 15: goto L_0x0416;
                case 16: goto L_0x040a;
                case 17: goto L_0x03fe;
                case 18: goto L_0x03f2;
                case 19: goto L_0x03e6;
                case 20: goto L_0x03da;
                case 21: goto L_0x03ce;
                case 22: goto L_0x03be;
                case 23: goto L_0x03b2;
                case 24: goto L_0x03a6;
                case 25: goto L_0x0035;
                case 26: goto L_0x0035;
                case 27: goto L_0x039a;
                case 28: goto L_0x038e;
                case 29: goto L_0x0035;
                case 30: goto L_0x0035;
                case 31: goto L_0x0382;
                case 32: goto L_0x0035;
                case 33: goto L_0x0035;
                case 34: goto L_0x0376;
                case 35: goto L_0x0035;
                case 36: goto L_0x0035;
                case 37: goto L_0x036a;
                case 38: goto L_0x035e;
                case 39: goto L_0x0352;
                case 40: goto L_0x0346;
                case 41: goto L_0x033a;
                case 42: goto L_0x032e;
                case 43: goto L_0x0322;
                case 44: goto L_0x0313;
                case 45: goto L_0x0307;
                case 46: goto L_0x02fb;
                case 47: goto L_0x02ef;
                case 48: goto L_0x02e3;
                case 49: goto L_0x02d7;
                case 50: goto L_0x02cb;
                case 51: goto L_0x02bf;
                case 52: goto L_0x02b3;
                case 53: goto L_0x02a7;
                case 54: goto L_0x029b;
                case 55: goto L_0x028f;
                case 56: goto L_0x0283;
                case 57: goto L_0x0277;
                case 58: goto L_0x026b;
                case 59: goto L_0x025f;
                case 60: goto L_0x0253;
                case 61: goto L_0x0035;
                case 62: goto L_0x0247;
                case 63: goto L_0x023b;
                case 64: goto L_0x022f;
                case 65: goto L_0x0213;
                case 66: goto L_0x020b;
                case 67: goto L_0x01ff;
                case 68: goto L_0x01f3;
                case 69: goto L_0x01f0;
                case 70: goto L_0x01e8;
                case 71: goto L_0x01e1;
                case 72: goto L_0x01d5;
                case 73: goto L_0x01c9;
                case 74: goto L_0x01c6;
                case 75: goto L_0x01ba;
                case 76: goto L_0x01ae;
                case 77: goto L_0x01a3;
                case 78: goto L_0x0197;
                case 79: goto L_0x018c;
                case 80: goto L_0x0180;
                case 81: goto L_0x0174;
                case 82: goto L_0x0168;
                case 83: goto L_0x015c;
                case 84: goto L_0x0150;
                case 85: goto L_0x0141;
                case 86: goto L_0x00cb;
                case 87: goto L_0x00c2;
                case 88: goto L_0x0035;
                case 89: goto L_0x0035;
                case 90: goto L_0x0035;
                case 91: goto L_0x0035;
                case 92: goto L_0x0035;
                case 93: goto L_0x00b7;
                case 94: goto L_0x00ac;
                case 95: goto L_0x00a7;
                case 96: goto L_0x00a2;
                case 97: goto L_0x0093;
                case 98: goto L_0x006a;
                case 99: goto L_0x005b;
                default: goto L_0x0035;
            }
        L_0x0035:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Unknown attribute 0x"
        L_0x003c:
            r4.append(r5)
            java.lang.String r5 = java.lang.Integer.toHexString(r3)
            r4.append(r5)
            r4.append(r6)
            android.util.SparseIntArray r5 = W
            int r3 = r5.get(r3)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            android.util.Log.w(r8, r3)
            goto L_0x0482
        L_0x005b:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            boolean r4 = r4.f4740i
            boolean r3 = r13.getBoolean(r3, r4)
            r4 = 99
        L_0x0065:
            r0.d(r4, r3)
            goto L_0x0482
        L_0x006a:
            boolean r4 = androidx.constraintlayout.motion.widget.MotionLayout.p5
            if (r4 == 0) goto L_0x0080
            int r4 = r12.f4710a
            int r4 = r13.getResourceId(r3, r4)
            r12.f4710a = r4
            if (r4 != r10) goto L_0x0482
        L_0x0078:
            java.lang.String r3 = r13.getString(r3)
            r12.f4711b = r3
            goto L_0x0482
        L_0x0080:
            android.util.TypedValue r4 = r13.peekValue(r3)
            int r4 = r4.type
            if (r4 != r7) goto L_0x0089
            goto L_0x0078
        L_0x0089:
            int r4 = r12.f4710a
            int r3 = r13.getResourceId(r3, r4)
            r12.f4710a = r3
            goto L_0x0482
        L_0x0093:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.q0
            int r3 = r13.getInt(r3, r4)
            r4 = 97
        L_0x009d:
            r0.b(r4, r3)
            goto L_0x0482
        L_0x00a2:
            A0(r0, r13, r3, r9)
            goto L_0x0482
        L_0x00a7:
            A0(r0, r13, r3, r2)
            goto L_0x0482
        L_0x00ac:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.U
            int r3 = r13.getDimensionPixelSize(r3, r4)
            r4 = 94
            goto L_0x009d
        L_0x00b7:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.N
            int r3 = r13.getDimensionPixelSize(r3, r4)
            r4 = 93
            goto L_0x009d
        L_0x00c2:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "unused attribute 0x"
            goto L_0x003c
        L_0x00cb:
            android.util.TypedValue r4 = r13.peekValue(r3)
            int r4 = r4.type
            r5 = -2
            r6 = 89
            r8 = 88
            if (r4 != r9) goto L_0x00f4
            androidx.constraintlayout.widget.ConstraintSet$Motion r4 = r12.f4713d
            int r3 = r13.getResourceId(r3, r10)
            r4.f4759n = r3
            androidx.constraintlayout.widget.ConstraintSet$Motion r3 = r12.f4713d
            int r3 = r3.f4759n
            r0.b(r6, r3)
            androidx.constraintlayout.widget.ConstraintSet$Motion r3 = r12.f4713d
            int r4 = r3.f4759n
            if (r4 == r10) goto L_0x0482
        L_0x00ed:
            r3.f4758m = r5
            r0.b(r8, r5)
            goto L_0x0482
        L_0x00f4:
            if (r4 != r7) goto L_0x012e
            androidx.constraintlayout.widget.ConstraintSet$Motion r4 = r12.f4713d
            java.lang.String r7 = r13.getString(r3)
            r4.f4757l = r7
            androidx.constraintlayout.widget.ConstraintSet$Motion r4 = r12.f4713d
            java.lang.String r4 = r4.f4757l
            r7 = 90
            r0.c(r7, r4)
            androidx.constraintlayout.widget.ConstraintSet$Motion r4 = r12.f4713d
            java.lang.String r4 = r4.f4757l
            java.lang.String r7 = "/"
            int r4 = r4.indexOf(r7)
            if (r4 <= 0) goto L_0x0125
            androidx.constraintlayout.widget.ConstraintSet$Motion r4 = r12.f4713d
            int r3 = r13.getResourceId(r3, r10)
            r4.f4759n = r3
            androidx.constraintlayout.widget.ConstraintSet$Motion r3 = r12.f4713d
            int r3 = r3.f4759n
            r0.b(r6, r3)
            androidx.constraintlayout.widget.ConstraintSet$Motion r3 = r12.f4713d
            goto L_0x00ed
        L_0x0125:
            androidx.constraintlayout.widget.ConstraintSet$Motion r3 = r12.f4713d
            r3.f4758m = r10
            r0.b(r8, r10)
            goto L_0x0482
        L_0x012e:
            androidx.constraintlayout.widget.ConstraintSet$Motion r4 = r12.f4713d
            int r5 = r4.f4759n
            int r3 = r13.getInteger(r3, r5)
            r4.f4758m = r3
            androidx.constraintlayout.widget.ConstraintSet$Motion r3 = r12.f4713d
            int r3 = r3.f4758m
            r0.b(r8, r3)
            goto L_0x0482
        L_0x0141:
            androidx.constraintlayout.widget.ConstraintSet$Motion r4 = r12.f4713d
            float r4 = r4.f4755j
            float r3 = r13.getFloat(r3, r4)
            r4 = 85
        L_0x014b:
            r0.a(r4, r3)
            goto L_0x0482
        L_0x0150:
            androidx.constraintlayout.widget.ConstraintSet$Motion r4 = r12.f4713d
            int r4 = r4.f4756k
            int r3 = r13.getInteger(r3, r4)
            r4 = 84
            goto L_0x009d
        L_0x015c:
            androidx.constraintlayout.widget.ConstraintSet$Transform r4 = r12.f4715f
            int r4 = r4.f4773i
            int r3 = y0(r13, r3, r4)
            r4 = 83
            goto L_0x009d
        L_0x0168:
            androidx.constraintlayout.widget.ConstraintSet$Motion r4 = r12.f4713d
            int r4 = r4.f4748c
            int r3 = r13.getInteger(r3, r4)
            r4 = 82
            goto L_0x009d
        L_0x0174:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            boolean r4 = r4.o0
            boolean r3 = r13.getBoolean(r3, r4)
            r4 = 81
            goto L_0x0065
        L_0x0180:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            boolean r4 = r4.n0
            boolean r3 = r13.getBoolean(r3, r4)
            r4 = 80
            goto L_0x0065
        L_0x018c:
            androidx.constraintlayout.widget.ConstraintSet$Motion r4 = r12.f4713d
            float r4 = r4.f4752g
            float r3 = r13.getFloat(r3, r4)
            r4 = 79
            goto L_0x014b
        L_0x0197:
            androidx.constraintlayout.widget.ConstraintSet$PropertySet r4 = r12.f4712c
            int r4 = r4.f4762c
            int r3 = r13.getInt(r3, r4)
            r4 = 78
            goto L_0x009d
        L_0x01a3:
            r4 = 77
        L_0x01a5:
            java.lang.String r3 = r13.getString(r3)
            r0.c(r4, r3)
            goto L_0x0482
        L_0x01ae:
            androidx.constraintlayout.widget.ConstraintSet$Motion r4 = r12.f4713d
            int r4 = r4.f4750e
            int r3 = r13.getInt(r3, r4)
            r4 = 76
            goto L_0x009d
        L_0x01ba:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            boolean r4 = r4.p0
            boolean r3 = r13.getBoolean(r3, r4)
            r4 = 75
            goto L_0x0065
        L_0x01c6:
            r4 = 74
            goto L_0x01a5
        L_0x01c9:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.i0
            int r3 = r13.getDimensionPixelSize(r3, r4)
            r4 = 73
            goto L_0x009d
        L_0x01d5:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.h0
            int r3 = r13.getInt(r3, r4)
            r4 = 72
            goto L_0x009d
        L_0x01e1:
            java.lang.String r3 = "CURRENTLY UNSUPPORTED"
            android.util.Log.e(r8, r3)
            goto L_0x0482
        L_0x01e8:
            r4 = 70
        L_0x01ea:
            float r3 = r13.getFloat(r3, r5)
            goto L_0x014b
        L_0x01f0:
            r4 = 69
            goto L_0x01ea
        L_0x01f3:
            androidx.constraintlayout.widget.ConstraintSet$PropertySet r4 = r12.f4712c
            float r4 = r4.f4764e
            float r3 = r13.getFloat(r3, r4)
            r4 = 68
            goto L_0x014b
        L_0x01ff:
            androidx.constraintlayout.widget.ConstraintSet$Motion r4 = r12.f4713d
            float r4 = r4.f4754i
            float r3 = r13.getFloat(r3, r4)
            r4 = 67
            goto L_0x014b
        L_0x020b:
            r4 = 66
            int r3 = r13.getInt(r3, r2)
            goto L_0x009d
        L_0x0213:
            android.util.TypedValue r4 = r13.peekValue(r3)
            int r4 = r4.type
            r5 = 65
            if (r4 != r7) goto L_0x0226
            java.lang.String r3 = r13.getString(r3)
        L_0x0221:
            r0.c(r5, r3)
            goto L_0x0482
        L_0x0226:
            java.lang.String[] r4 = androidx.constraintlayout.core.motion.utils.Easing.o
            int r3 = r13.getInteger(r3, r2)
            r3 = r4[r3]
            goto L_0x0221
        L_0x022f:
            androidx.constraintlayout.widget.ConstraintSet$Motion r4 = r12.f4713d
            int r4 = r4.f4747b
            int r3 = y0(r13, r3, r4)
            r4 = 64
            goto L_0x009d
        L_0x023b:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            float r4 = r4.D
            float r3 = r13.getFloat(r3, r4)
            r4 = 63
            goto L_0x014b
        L_0x0247:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.C
            int r3 = r13.getDimensionPixelSize(r3, r4)
            r4 = 62
            goto L_0x009d
        L_0x0253:
            androidx.constraintlayout.widget.ConstraintSet$Transform r4 = r12.f4715f
            float r4 = r4.f4766b
            float r3 = r13.getFloat(r3, r4)
            r4 = 60
            goto L_0x014b
        L_0x025f:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.e0
            int r3 = r13.getDimensionPixelSize(r3, r4)
            r4 = 59
            goto L_0x009d
        L_0x026b:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.d0
            int r3 = r13.getDimensionPixelSize(r3, r4)
            r4 = 58
            goto L_0x009d
        L_0x0277:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.c0
            int r3 = r13.getDimensionPixelSize(r3, r4)
            r4 = 57
            goto L_0x009d
        L_0x0283:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.b0
            int r3 = r13.getDimensionPixelSize(r3, r4)
            r4 = 56
            goto L_0x009d
        L_0x028f:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.a0
            int r3 = r13.getInt(r3, r4)
            r4 = 55
            goto L_0x009d
        L_0x029b:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.Z
            int r3 = r13.getInt(r3, r4)
            r4 = 54
            goto L_0x009d
        L_0x02a7:
            androidx.constraintlayout.widget.ConstraintSet$Transform r4 = r12.f4715f
            float r4 = r4.f4776l
            float r3 = r13.getDimension(r3, r4)
            r4 = 53
            goto L_0x014b
        L_0x02b3:
            androidx.constraintlayout.widget.ConstraintSet$Transform r4 = r12.f4715f
            float r4 = r4.f4775k
            float r3 = r13.getDimension(r3, r4)
            r4 = 52
            goto L_0x014b
        L_0x02bf:
            androidx.constraintlayout.widget.ConstraintSet$Transform r4 = r12.f4715f
            float r4 = r4.f4774j
            float r3 = r13.getDimension(r3, r4)
            r4 = 51
            goto L_0x014b
        L_0x02cb:
            androidx.constraintlayout.widget.ConstraintSet$Transform r4 = r12.f4715f
            float r4 = r4.f4772h
            float r3 = r13.getDimension(r3, r4)
            r4 = 50
            goto L_0x014b
        L_0x02d7:
            androidx.constraintlayout.widget.ConstraintSet$Transform r4 = r12.f4715f
            float r4 = r4.f4771g
            float r3 = r13.getDimension(r3, r4)
            r4 = 49
            goto L_0x014b
        L_0x02e3:
            androidx.constraintlayout.widget.ConstraintSet$Transform r4 = r12.f4715f
            float r4 = r4.f4770f
            float r3 = r13.getFloat(r3, r4)
            r4 = 48
            goto L_0x014b
        L_0x02ef:
            androidx.constraintlayout.widget.ConstraintSet$Transform r4 = r12.f4715f
            float r4 = r4.f4769e
            float r3 = r13.getFloat(r3, r4)
            r4 = 47
            goto L_0x014b
        L_0x02fb:
            androidx.constraintlayout.widget.ConstraintSet$Transform r4 = r12.f4715f
            float r4 = r4.f4768d
            float r3 = r13.getFloat(r3, r4)
            r4 = 46
            goto L_0x014b
        L_0x0307:
            androidx.constraintlayout.widget.ConstraintSet$Transform r4 = r12.f4715f
            float r4 = r4.f4767c
            float r3 = r13.getFloat(r3, r4)
            r4 = 45
            goto L_0x014b
        L_0x0313:
            r4 = 44
            r0.d(r4, r9)
            androidx.constraintlayout.widget.ConstraintSet$Transform r5 = r12.f4715f
            float r5 = r5.f4778n
            float r3 = r13.getDimension(r3, r5)
            goto L_0x014b
        L_0x0322:
            androidx.constraintlayout.widget.ConstraintSet$PropertySet r4 = r12.f4712c
            float r4 = r4.f4763d
            float r3 = r13.getFloat(r3, r4)
            r4 = 43
            goto L_0x014b
        L_0x032e:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.Y
            int r3 = r13.getInt(r3, r4)
            r4 = 42
            goto L_0x009d
        L_0x033a:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.X
            int r3 = r13.getInt(r3, r4)
            r4 = 41
            goto L_0x009d
        L_0x0346:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            float r4 = r4.V
            float r3 = r13.getFloat(r3, r4)
            r4 = 40
            goto L_0x014b
        L_0x0352:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            float r4 = r4.W
            float r3 = r13.getFloat(r3, r4)
            r4 = 39
            goto L_0x014b
        L_0x035e:
            int r4 = r12.f4710a
            int r3 = r13.getResourceId(r3, r4)
            r12.f4710a = r3
            r4 = 38
            goto L_0x009d
        L_0x036a:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            float r4 = r4.z
            float r3 = r13.getFloat(r3, r4)
            r4 = 37
            goto L_0x014b
        L_0x0376:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.J
            int r3 = r13.getDimensionPixelSize(r3, r4)
            r4 = 34
            goto L_0x009d
        L_0x0382:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.M
            int r3 = r13.getDimensionPixelSize(r3, r4)
            r4 = 31
            goto L_0x009d
        L_0x038e:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.I
            int r3 = r13.getDimensionPixelSize(r3, r4)
            r4 = 28
            goto L_0x009d
        L_0x039a:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.G
            int r3 = r13.getInt(r3, r4)
            r4 = 27
            goto L_0x009d
        L_0x03a6:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.H
            int r3 = r13.getDimensionPixelSize(r3, r4)
            r4 = 24
            goto L_0x009d
        L_0x03b2:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.f4735d
            int r3 = r13.getLayoutDimension(r3, r4)
            r4 = 23
            goto L_0x009d
        L_0x03be:
            int[] r4 = U
            androidx.constraintlayout.widget.ConstraintSet$PropertySet r5 = r12.f4712c
            int r5 = r5.f4761b
            int r3 = r13.getInt(r3, r5)
            r3 = r4[r3]
            r4 = 22
            goto L_0x009d
        L_0x03ce:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.f4736e
            int r3 = r13.getLayoutDimension(r3, r4)
            r4 = 21
            goto L_0x009d
        L_0x03da:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            float r4 = r4.y
            float r3 = r13.getFloat(r3, r4)
            r4 = 20
            goto L_0x014b
        L_0x03e6:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            float r4 = r4.f4739h
            float r3 = r13.getFloat(r3, r4)
            r4 = 19
            goto L_0x014b
        L_0x03f2:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.f4738g
            int r3 = r13.getDimensionPixelOffset(r3, r4)
            r4 = 18
            goto L_0x009d
        L_0x03fe:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.f4737f
            int r3 = r13.getDimensionPixelOffset(r3, r4)
            r4 = 17
            goto L_0x009d
        L_0x040a:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.P
            int r3 = r13.getDimensionPixelSize(r3, r4)
            r4 = 16
            goto L_0x009d
        L_0x0416:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.T
            int r3 = r13.getDimensionPixelSize(r3, r4)
            r4 = 15
            goto L_0x009d
        L_0x0422:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.Q
            int r3 = r13.getDimensionPixelSize(r3, r4)
            r4 = 14
            goto L_0x009d
        L_0x042e:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.O
            int r3 = r13.getDimensionPixelSize(r3, r4)
            r4 = 13
            goto L_0x009d
        L_0x043a:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.S
            int r3 = r13.getDimensionPixelSize(r3, r4)
            r4 = 12
            goto L_0x009d
        L_0x0446:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.R
            int r3 = r13.getDimensionPixelSize(r3, r4)
            r4 = 11
            goto L_0x009d
        L_0x0452:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.L
            int r3 = r13.getDimensionPixelSize(r3, r4)
            r4 = 8
            goto L_0x009d
        L_0x045e:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.F
            int r3 = r13.getDimensionPixelOffset(r3, r4)
            r4 = 7
            goto L_0x009d
        L_0x0469:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.E
            int r3 = r13.getDimensionPixelOffset(r3, r4)
            r4 = 6
            goto L_0x009d
        L_0x0474:
            r4 = 5
            goto L_0x01a5
        L_0x0477:
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r12.f4714e
            int r4 = r4.K
            int r3 = r13.getDimensionPixelSize(r3, r4)
            r4 = 2
            goto L_0x009d
        L_0x0482:
            int r1 = r1 + 1
            goto L_0x001d
        L_0x0486:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.H0(android.content.Context, androidx.constraintlayout.widget.ConstraintSet$Constraint, android.content.res.TypedArray):void");
    }

    /* access modifiers changed from: private */
    public static void R0(Constraint constraint, int i2, float f2) {
        if (i2 == 19) {
            constraint.f4714e.f4739h = f2;
        } else if (i2 == 20) {
            constraint.f4714e.y = f2;
        } else if (i2 == 37) {
            constraint.f4714e.z = f2;
        } else if (i2 == 60) {
            constraint.f4715f.f4766b = f2;
        } else if (i2 == 63) {
            constraint.f4714e.D = f2;
        } else if (i2 == 79) {
            constraint.f4713d.f4752g = f2;
        } else if (i2 == 85) {
            constraint.f4713d.f4755j = f2;
        } else if (i2 == 87) {
        } else {
            if (i2 == 39) {
                constraint.f4714e.W = f2;
            } else if (i2 != 40) {
                switch (i2) {
                    case 43:
                        constraint.f4712c.f4763d = f2;
                        return;
                    case 44:
                        Transform transform = constraint.f4715f;
                        transform.f4778n = f2;
                        transform.f4777m = true;
                        return;
                    case 45:
                        constraint.f4715f.f4767c = f2;
                        return;
                    case 46:
                        constraint.f4715f.f4768d = f2;
                        return;
                    case 47:
                        constraint.f4715f.f4769e = f2;
                        return;
                    case 48:
                        constraint.f4715f.f4770f = f2;
                        return;
                    case 49:
                        constraint.f4715f.f4771g = f2;
                        return;
                    case 50:
                        constraint.f4715f.f4772h = f2;
                        return;
                    case 51:
                        constraint.f4715f.f4774j = f2;
                        return;
                    case 52:
                        constraint.f4715f.f4775k = f2;
                        return;
                    case 53:
                        constraint.f4715f.f4776l = f2;
                        return;
                    default:
                        switch (i2) {
                            case 67:
                                constraint.f4713d.f4754i = f2;
                                return;
                            case 68:
                                constraint.f4712c.f4764e = f2;
                                return;
                            case 69:
                                constraint.f4714e.f0 = f2;
                                return;
                            case 70:
                                constraint.f4714e.g0 = f2;
                                return;
                            default:
                                Log.w(f4696h, "Unknown attribute 0x");
                                return;
                        }
                }
            } else {
                constraint.f4714e.V = f2;
            }
        }
    }

    /* access modifiers changed from: private */
    public static void S0(Constraint constraint, int i2, int i3) {
        if (i2 == 6) {
            constraint.f4714e.E = i3;
        } else if (i2 == 7) {
            constraint.f4714e.F = i3;
        } else if (i2 == 8) {
            constraint.f4714e.L = i3;
        } else if (i2 == 27) {
            constraint.f4714e.G = i3;
        } else if (i2 == 28) {
            constraint.f4714e.I = i3;
        } else if (i2 == 41) {
            constraint.f4714e.X = i3;
        } else if (i2 == 42) {
            constraint.f4714e.Y = i3;
        } else if (i2 == 61) {
            constraint.f4714e.B = i3;
        } else if (i2 == 62) {
            constraint.f4714e.C = i3;
        } else if (i2 == 72) {
            constraint.f4714e.h0 = i3;
        } else if (i2 != 73) {
            switch (i2) {
                case 2:
                    constraint.f4714e.K = i3;
                    return;
                case 11:
                    constraint.f4714e.R = i3;
                    return;
                case 12:
                    constraint.f4714e.S = i3;
                    return;
                case 13:
                    constraint.f4714e.O = i3;
                    return;
                case 14:
                    constraint.f4714e.Q = i3;
                    return;
                case 15:
                    constraint.f4714e.T = i3;
                    return;
                case 16:
                    constraint.f4714e.P = i3;
                    return;
                case 17:
                    constraint.f4714e.f4737f = i3;
                    return;
                case 18:
                    constraint.f4714e.f4738g = i3;
                    return;
                case 31:
                    constraint.f4714e.M = i3;
                    return;
                case 34:
                    constraint.f4714e.J = i3;
                    return;
                case 38:
                    constraint.f4710a = i3;
                    return;
                case 64:
                    constraint.f4713d.f4747b = i3;
                    return;
                case 66:
                    constraint.f4713d.f4751f = i3;
                    return;
                case 76:
                    constraint.f4713d.f4750e = i3;
                    return;
                case 78:
                    constraint.f4712c.f4762c = i3;
                    return;
                case 93:
                    constraint.f4714e.N = i3;
                    return;
                case 94:
                    constraint.f4714e.U = i3;
                    return;
                case 97:
                    constraint.f4714e.q0 = i3;
                    return;
                default:
                    switch (i2) {
                        case 21:
                            constraint.f4714e.f4736e = i3;
                            return;
                        case 22:
                            constraint.f4712c.f4761b = i3;
                            return;
                        case 23:
                            constraint.f4714e.f4735d = i3;
                            return;
                        case 24:
                            constraint.f4714e.H = i3;
                            return;
                        default:
                            switch (i2) {
                                case 54:
                                    constraint.f4714e.Z = i3;
                                    return;
                                case 55:
                                    constraint.f4714e.a0 = i3;
                                    return;
                                case 56:
                                    constraint.f4714e.b0 = i3;
                                    return;
                                case 57:
                                    constraint.f4714e.c0 = i3;
                                    return;
                                case 58:
                                    constraint.f4714e.d0 = i3;
                                    return;
                                case 59:
                                    constraint.f4714e.e0 = i3;
                                    return;
                                default:
                                    switch (i2) {
                                        case 82:
                                            constraint.f4713d.f4748c = i3;
                                            return;
                                        case 83:
                                            constraint.f4715f.f4773i = i3;
                                            return;
                                        case 84:
                                            constraint.f4713d.f4756k = i3;
                                            return;
                                        default:
                                            switch (i2) {
                                                case 87:
                                                    return;
                                                case 88:
                                                    constraint.f4713d.f4758m = i3;
                                                    return;
                                                case 89:
                                                    constraint.f4713d.f4759n = i3;
                                                    return;
                                                default:
                                                    Log.w(f4696h, "Unknown attribute 0x");
                                                    return;
                                            }
                                    }
                            }
                    }
            }
        } else {
            constraint.f4714e.i0 = i3;
        }
    }

    /* access modifiers changed from: private */
    public static void T0(Constraint constraint, int i2, String str) {
        if (i2 == 5) {
            constraint.f4714e.A = str;
        } else if (i2 == 65) {
            constraint.f4713d.f4749d = str;
        } else if (i2 == 74) {
            Layout layout2 = constraint.f4714e;
            layout2.l0 = str;
            layout2.k0 = null;
        } else if (i2 == 77) {
            constraint.f4714e.m0 = str;
        } else if (i2 == 87) {
        } else {
            if (i2 != 90) {
                Log.w(f4696h, "Unknown attribute 0x");
            } else {
                constraint.f4713d.f4757l = str;
            }
        }
    }

    /* access modifiers changed from: private */
    public static void U0(Constraint constraint, int i2, boolean z2) {
        if (i2 == 44) {
            constraint.f4715f.f4777m = z2;
        } else if (i2 == 75) {
            constraint.f4714e.p0 = z2;
        } else if (i2 == 87) {
        } else {
            if (i2 == 80) {
                constraint.f4714e.n0 = z2;
            } else if (i2 != 81) {
                Log.w(f4696h, "Unknown attribute 0x");
            } else {
                constraint.f4714e.o0 = z2;
            }
        }
    }

    private int[] Z(View view, String str) {
        int i2;
        Object m2;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i3 = 0;
        int i4 = 0;
        while (i3 < split.length) {
            String trim = split[i3].trim();
            try {
                i2 = R.id.class.getField(trim).getInt((Object) null);
            } catch (Exception unused) {
                i2 = 0;
            }
            if (i2 == 0) {
                i2 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i2 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (m2 = ((ConstraintLayout) view.getParent()).m(0, trim)) != null && (m2 instanceof Integer)) {
                i2 = ((Integer) m2).intValue();
            }
            iArr[i4] = i2;
            i3++;
            i4++;
        }
        return i4 != split.length ? Arrays.copyOf(iArr, i4) : iArr;
    }

    private void d0(int i2, int i3, int i4, int i5, int[] iArr, float[] fArr, int i6, int i7, int i8) {
        int[] iArr2 = iArr;
        float[] fArr2 = fArr;
        if (iArr2.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        } else if (fArr2 == null || fArr2.length == iArr2.length) {
            if (fArr2 != null) {
                i0(iArr2[0]).f4714e.W = fArr2[0];
            }
            i0(iArr2[0]).f4714e.X = i6;
            L(iArr2[0], i7, i2, i3, -1);
            for (int i9 = 1; i9 < iArr2.length; i9++) {
                int i10 = i9 - 1;
                L(iArr2[i9], i7, iArr2[i10], i8, -1);
                L(iArr2[i10], i8, iArr2[i9], i7, -1);
                if (fArr2 != null) {
                    i0(iArr2[i9]).f4714e.W = fArr2[i9];
                }
            }
            L(iArr2[iArr2.length - 1], i8, i4, i5, -1);
        } else {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
    }

    private void h(ConstraintAttribute.AttributeType attributeType, String... strArr) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (this.f4707e.containsKey(strArr[i2])) {
                ConstraintAttribute constraintAttribute = this.f4707e.get(strArr[i2]);
                if (!(constraintAttribute == null || constraintAttribute.j() == attributeType)) {
                    throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute.j().name());
                }
            } else {
                this.f4707e.put(strArr[i2], new ConstraintAttribute(strArr[i2], attributeType));
            }
        }
    }

    private Constraint h0(Context context, AttributeSet attributeSet, boolean z2) {
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z2 ? R.styleable.S8 : R.styleable.d4);
        G0(context, constraint, obtainStyledAttributes, z2);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    private Constraint i0(int i2) {
        if (!this.f4709g.containsKey(Integer.valueOf(i2))) {
            this.f4709g.put(Integer.valueOf(i2), new Constraint());
        }
        return this.f4709g.get(Integer.valueOf(i2));
    }

    static String m0(int i2) {
        for (Field field : ConstraintSet.class.getDeclaredFields()) {
            if (field.getName().contains("_") && field.getType() == Integer.TYPE && Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers())) {
                try {
                    if (field.getInt((Object) null) == i2) {
                        return field.getName();
                    }
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return "UNKNOWN";
    }

    static String p0(Context context, int i2, XmlPullParser xmlPullParser) {
        return ".(" + Debug.i(context, i2) + ".xml:" + xmlPullParser.getLineNumber() + ") \"" + xmlPullParser.getName() + "\"";
    }

    public static Constraint w(Context context, XmlPullParser xmlPullParser) {
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(asAttributeSet, R.styleable.S8);
        H0(context, constraint, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    /* access modifiers changed from: private */
    public static int y0(TypedArray typedArray, int i2, int i3) {
        int resourceId = typedArray.getResourceId(i2, i3);
        return resourceId == -1 ? typedArray.getInt(i2, -1) : resourceId;
    }

    public void A(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        ConstraintSet constraintSet;
        int i7;
        int i8;
        int i9;
        if (i3 == 0) {
            i8 = 0;
            i4 = 6;
            i5 = 0;
            i9 = 0;
            i6 = 7;
            constraintSet = this;
            i7 = i2;
        } else {
            i4 = 7;
            i5 = 0;
            i6 = 6;
            constraintSet = this;
            i7 = i2;
            i8 = i3;
            i9 = i3;
        }
        constraintSet.x(i7, i8, i4, i5, i9, i6, 0, 0.5f);
    }

    public void A1(int i2, float f2) {
        i0(i2).f4714e.z = f2;
    }

    public void B(int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f2) {
        L(i2, 6, i3, i4, i5);
        L(i2, 7, i6, i7, i8);
        Constraint constraint = this.f4709g.get(Integer.valueOf(i2));
        if (constraint != null) {
            constraint.f4714e.y = f2;
        }
    }

    public void B1(int i2, int i3) {
        i0(i2).f4714e.Y = i3;
    }

    public void C(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        ConstraintSet constraintSet;
        int i7;
        int i8;
        int i9;
        if (i3 == 0) {
            i8 = 0;
            i4 = 3;
            i5 = 0;
            i9 = 0;
            i6 = 4;
            constraintSet = this;
            i7 = i2;
        } else {
            i4 = 4;
            i5 = 0;
            i6 = 3;
            constraintSet = this;
            i7 = i2;
            i8 = i3;
            i9 = i3;
        }
        constraintSet.x(i7, i8, i4, i5, i9, i6, 0, 0.5f);
    }

    public void C1(int i2, float f2) {
        i0(i2).f4714e.V = f2;
    }

    public void D(int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f2) {
        L(i2, 3, i3, i4, i5);
        L(i2, 4, i6, i7, i8);
        Constraint constraint = this.f4709g.get(Integer.valueOf(i2));
        if (constraint != null) {
            constraint.f4714e.z = f2;
        }
    }

    public void D0(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i2 = 0; i2 < split.length; i2++) {
            String[] split2 = split[i2].split("=");
            if (split2.length != 2) {
                Log.w(f4696h, " Unable to parse " + split[i2]);
            } else {
                constraint.q(split2[0], Float.parseFloat(split2[1]));
            }
        }
    }

    public void D1(int i2, int i3) {
        i0(i2).f4712c.f4761b = i3;
    }

    public void E(int i2) {
        this.f4709g.remove(Integer.valueOf(i2));
    }

    public void E0(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i2 = 0; i2 < split.length; i2++) {
            String[] split2 = split[i2].split("=");
            if (split2.length != 2) {
                Log.w(f4696h, " Unable to parse " + split[i2]);
            } else {
                constraint.q(split2[0], (float) Integer.decode(split2[1]).intValue());
            }
        }
    }

    public void E1(int i2, int i3) {
        i0(i2).f4712c.f4762c = i3;
    }

    public void F(int i2, int i3) {
        Constraint constraint;
        if (this.f4709g.containsKey(Integer.valueOf(i2)) && (constraint = this.f4709g.get(Integer.valueOf(i2))) != null) {
            switch (i3) {
                case 1:
                    Layout layout2 = constraint.f4714e;
                    layout2.f4742k = -1;
                    layout2.f4741j = -1;
                    layout2.H = -1;
                    layout2.O = Integer.MIN_VALUE;
                    return;
                case 2:
                    Layout layout3 = constraint.f4714e;
                    layout3.f4744m = -1;
                    layout3.f4743l = -1;
                    layout3.I = -1;
                    layout3.Q = Integer.MIN_VALUE;
                    return;
                case 3:
                    Layout layout4 = constraint.f4714e;
                    layout4.o = -1;
                    layout4.f4745n = -1;
                    layout4.J = 0;
                    layout4.P = Integer.MIN_VALUE;
                    return;
                case 4:
                    Layout layout5 = constraint.f4714e;
                    layout5.p = -1;
                    layout5.q = -1;
                    layout5.K = 0;
                    layout5.R = Integer.MIN_VALUE;
                    return;
                case 5:
                    Layout layout6 = constraint.f4714e;
                    layout6.r = -1;
                    layout6.s = -1;
                    layout6.t = -1;
                    layout6.N = 0;
                    layout6.U = Integer.MIN_VALUE;
                    return;
                case 6:
                    Layout layout7 = constraint.f4714e;
                    layout7.u = -1;
                    layout7.v = -1;
                    layout7.M = 0;
                    layout7.T = Integer.MIN_VALUE;
                    return;
                case 7:
                    Layout layout8 = constraint.f4714e;
                    layout8.w = -1;
                    layout8.x = -1;
                    layout8.L = 0;
                    layout8.S = Integer.MIN_VALUE;
                    return;
                case 8:
                    Layout layout9 = constraint.f4714e;
                    layout9.D = -1.0f;
                    layout9.C = -1;
                    layout9.B = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void F0(Constraint constraint, String str) {
        String[] G12 = G1(str);
        for (int i2 = 0; i2 < G12.length; i2++) {
            String[] split = G12[i2].split("=");
            Log.w(f4696h, " Unable to parse " + G12[i2]);
            constraint.s(split[0], split[1]);
        }
    }

    public void G(Context context, int i2) {
        H((ConstraintLayout) LayoutInflater.from(context).inflate(i2, (ViewGroup) null));
    }

    public void H(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f4709g.clear();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = constraintLayout.getChildAt(i2);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!this.f4708f || id != -1) {
                if (!this.f4709g.containsKey(Integer.valueOf(id))) {
                    this.f4709g.put(Integer.valueOf(id), new Constraint());
                }
                Constraint constraint = this.f4709g.get(Integer.valueOf(id));
                if (constraint != null) {
                    constraint.f4716g = ConstraintAttribute.d(this.f4707e, childAt);
                    constraint.k(id, layoutParams);
                    constraint.f4712c.f4761b = childAt.getVisibility();
                    constraint.f4712c.f4763d = childAt.getAlpha();
                    constraint.f4715f.f4766b = childAt.getRotation();
                    constraint.f4715f.f4767c = childAt.getRotationX();
                    constraint.f4715f.f4768d = childAt.getRotationY();
                    constraint.f4715f.f4769e = childAt.getScaleX();
                    constraint.f4715f.f4770f = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                        Transform transform = constraint.f4715f;
                        transform.f4771g = pivotX;
                        transform.f4772h = pivotY;
                    }
                    constraint.f4715f.f4774j = childAt.getTranslationX();
                    constraint.f4715f.f4775k = childAt.getTranslationY();
                    constraint.f4715f.f4776l = childAt.getTranslationZ();
                    Transform transform2 = constraint.f4715f;
                    if (transform2.f4777m) {
                        transform2.f4778n = childAt.getElevation();
                    }
                    if (childAt instanceof Barrier) {
                        Barrier barrier = (Barrier) childAt;
                        constraint.f4714e.p0 = barrier.getAllowsGoneWidget();
                        constraint.f4714e.k0 = barrier.getReferencedIds();
                        constraint.f4714e.h0 = barrier.getType();
                        constraint.f4714e.i0 = barrier.getMargin();
                    }
                }
                i2++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void H1(Writer writer, ConstraintLayout constraintLayout, int i2) throws IOException {
        writer.write("\n---------------------------------------------\n");
        if ((i2 & 1) == 1) {
            new WriteXmlEngine(writer, constraintLayout, i2).i();
        } else {
            new WriteJsonEngine(writer, constraintLayout, i2).g();
        }
        writer.write("\n---------------------------------------------\n");
    }

    public void I(ConstraintSet constraintSet) {
        this.f4709g.clear();
        for (Integer next : constraintSet.f4709g.keySet()) {
            Constraint constraint = constraintSet.f4709g.get(next);
            if (constraint != null) {
                this.f4709g.put(next, constraint.clone());
            }
        }
    }

    public void I0(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = constraintLayout.getChildAt(i2);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!this.f4708f || id != -1) {
                if (!this.f4709g.containsKey(Integer.valueOf(id))) {
                    this.f4709g.put(Integer.valueOf(id), new Constraint());
                }
                Constraint constraint = this.f4709g.get(Integer.valueOf(id));
                if (constraint != null) {
                    if (!constraint.f4714e.f4733b) {
                        constraint.k(id, layoutParams);
                        if (childAt instanceof ConstraintHelper) {
                            constraint.f4714e.k0 = ((ConstraintHelper) childAt).getReferencedIds();
                            if (childAt instanceof Barrier) {
                                Barrier barrier = (Barrier) childAt;
                                constraint.f4714e.p0 = barrier.getAllowsGoneWidget();
                                constraint.f4714e.h0 = barrier.getType();
                                constraint.f4714e.i0 = barrier.getMargin();
                            }
                        }
                        constraint.f4714e.f4733b = true;
                    }
                    PropertySet propertySet = constraint.f4712c;
                    if (!propertySet.f4760a) {
                        propertySet.f4761b = childAt.getVisibility();
                        constraint.f4712c.f4763d = childAt.getAlpha();
                        constraint.f4712c.f4760a = true;
                    }
                    Transform transform = constraint.f4715f;
                    if (!transform.f4765a) {
                        transform.f4765a = true;
                        transform.f4766b = childAt.getRotation();
                        constraint.f4715f.f4767c = childAt.getRotationX();
                        constraint.f4715f.f4768d = childAt.getRotationY();
                        constraint.f4715f.f4769e = childAt.getScaleX();
                        constraint.f4715f.f4770f = childAt.getScaleY();
                        float pivotX = childAt.getPivotX();
                        float pivotY = childAt.getPivotY();
                        if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                            Transform transform2 = constraint.f4715f;
                            transform2.f4771g = pivotX;
                            transform2.f4772h = pivotY;
                        }
                        constraint.f4715f.f4774j = childAt.getTranslationX();
                        constraint.f4715f.f4775k = childAt.getTranslationY();
                        constraint.f4715f.f4776l = childAt.getTranslationZ();
                        Transform transform3 = constraint.f4715f;
                        if (transform3.f4777m) {
                            transform3.f4778n = childAt.getElevation();
                        }
                    }
                }
                i2++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void J(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.f4709g.clear();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = constraints.getChildAt(i2);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!this.f4708f || id != -1) {
                if (!this.f4709g.containsKey(Integer.valueOf(id))) {
                    this.f4709g.put(Integer.valueOf(id), new Constraint());
                }
                Constraint constraint = this.f4709g.get(Integer.valueOf(id));
                if (constraint != null) {
                    if (childAt instanceof ConstraintHelper) {
                        constraint.m((ConstraintHelper) childAt, id, layoutParams);
                    }
                    constraint.l(id, layoutParams);
                }
                i2++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void J0(ConstraintSet constraintSet) {
        for (Integer next : constraintSet.f4709g.keySet()) {
            next.intValue();
            Constraint constraint = constraintSet.f4709g.get(next);
            if (!this.f4709g.containsKey(next)) {
                this.f4709g.put(next, new Constraint());
            }
            Constraint constraint2 = this.f4709g.get(next);
            if (constraint2 != null) {
                Layout layout2 = constraint2.f4714e;
                if (!layout2.f4733b) {
                    layout2.a(constraint.f4714e);
                }
                PropertySet propertySet = constraint2.f4712c;
                if (!propertySet.f4760a) {
                    propertySet.a(constraint.f4712c);
                }
                Transform transform = constraint2.f4715f;
                if (!transform.f4765a) {
                    transform.a(constraint.f4715f);
                }
                Motion motion = constraint2.f4713d;
                if (!motion.f4746a) {
                    motion.a(constraint.f4713d);
                }
                for (String next2 : constraint.f4716g.keySet()) {
                    if (!constraint2.f4716g.containsKey(next2)) {
                        constraint2.f4716g.put(next2, constraint.f4716g.get(next2));
                    }
                }
            }
        }
    }

    public void K(int i2, int i3, int i4, int i5) {
        Layout layout2;
        Layout layout3;
        if (!this.f4709g.containsKey(Integer.valueOf(i2))) {
            this.f4709g.put(Integer.valueOf(i2), new Constraint());
        }
        Constraint constraint = this.f4709g.get(Integer.valueOf(i2));
        if (constraint != null) {
            switch (i3) {
                case 1:
                    if (i5 == 1) {
                        Layout layout4 = constraint.f4714e;
                        layout4.f4741j = i4;
                        layout4.f4742k = -1;
                        return;
                    } else if (i5 == 2) {
                        Layout layout5 = constraint.f4714e;
                        layout5.f4742k = i4;
                        layout5.f4741j = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("left to " + F1(i5) + " undefined");
                    }
                case 2:
                    if (i5 == 1) {
                        Layout layout6 = constraint.f4714e;
                        layout6.f4743l = i4;
                        layout6.f4744m = -1;
                        return;
                    } else if (i5 == 2) {
                        Layout layout7 = constraint.f4714e;
                        layout7.f4744m = i4;
                        layout7.f4743l = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + F1(i5) + " undefined");
                    }
                case 3:
                    if (i5 == 3) {
                        layout2 = constraint.f4714e;
                        layout2.f4745n = i4;
                        layout2.o = -1;
                        break;
                    } else if (i5 == 4) {
                        layout2 = constraint.f4714e;
                        layout2.o = i4;
                        layout2.f4745n = -1;
                        break;
                    } else {
                        throw new IllegalArgumentException("right to " + F1(i5) + " undefined");
                    }
                case 4:
                    if (i5 == 4) {
                        layout2 = constraint.f4714e;
                        layout2.q = i4;
                        layout2.p = -1;
                        break;
                    } else if (i5 == 3) {
                        layout2 = constraint.f4714e;
                        layout2.p = i4;
                        layout2.q = -1;
                        break;
                    } else {
                        throw new IllegalArgumentException("right to " + F1(i5) + " undefined");
                    }
                case 5:
                    if (i5 == 5) {
                        layout3 = constraint.f4714e;
                        layout3.r = i4;
                    } else if (i5 == 3) {
                        layout3 = constraint.f4714e;
                        layout3.s = i4;
                    } else if (i5 == 4) {
                        layout3 = constraint.f4714e;
                        layout3.t = i4;
                    } else {
                        throw new IllegalArgumentException("right to " + F1(i5) + " undefined");
                    }
                    layout3.q = -1;
                    layout3.p = -1;
                    layout3.f4745n = -1;
                    layout3.o = -1;
                    return;
                case 6:
                    if (i5 == 6) {
                        Layout layout8 = constraint.f4714e;
                        layout8.v = i4;
                        layout8.u = -1;
                        return;
                    } else if (i5 == 7) {
                        Layout layout9 = constraint.f4714e;
                        layout9.u = i4;
                        layout9.v = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + F1(i5) + " undefined");
                    }
                case 7:
                    if (i5 == 7) {
                        Layout layout10 = constraint.f4714e;
                        layout10.x = i4;
                        layout10.w = -1;
                        return;
                    } else if (i5 == 6) {
                        Layout layout11 = constraint.f4714e;
                        layout11.w = i4;
                        layout11.x = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + F1(i5) + " undefined");
                    }
                default:
                    throw new IllegalArgumentException(F1(i3) + " to " + F1(i5) + " unknown");
            }
            layout2.r = -1;
            layout2.s = -1;
            layout2.t = -1;
        }
    }

    public void K0(String str) {
        this.f4707e.remove(str);
    }

    public void L(int i2, int i3, int i4, int i5, int i6) {
        Layout layout2;
        Layout layout3;
        Layout layout4;
        if (!this.f4709g.containsKey(Integer.valueOf(i2))) {
            this.f4709g.put(Integer.valueOf(i2), new Constraint());
        }
        Constraint constraint = this.f4709g.get(Integer.valueOf(i2));
        if (constraint != null) {
            switch (i3) {
                case 1:
                    if (i5 == 1) {
                        Layout layout5 = constraint.f4714e;
                        layout5.f4741j = i4;
                        layout5.f4742k = -1;
                    } else if (i5 == 2) {
                        Layout layout6 = constraint.f4714e;
                        layout6.f4742k = i4;
                        layout6.f4741j = -1;
                    } else {
                        throw new IllegalArgumentException("Left to " + F1(i5) + " undefined");
                    }
                    constraint.f4714e.H = i6;
                    return;
                case 2:
                    if (i5 == 1) {
                        Layout layout7 = constraint.f4714e;
                        layout7.f4743l = i4;
                        layout7.f4744m = -1;
                    } else if (i5 == 2) {
                        Layout layout8 = constraint.f4714e;
                        layout8.f4744m = i4;
                        layout8.f4743l = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + F1(i5) + " undefined");
                    }
                    constraint.f4714e.I = i6;
                    return;
                case 3:
                    if (i5 == 3) {
                        layout2 = constraint.f4714e;
                        layout2.f4745n = i4;
                        layout2.o = -1;
                    } else if (i5 == 4) {
                        layout2 = constraint.f4714e;
                        layout2.o = i4;
                        layout2.f4745n = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + F1(i5) + " undefined");
                    }
                    layout2.r = -1;
                    layout2.s = -1;
                    layout2.t = -1;
                    constraint.f4714e.J = i6;
                    return;
                case 4:
                    if (i5 == 4) {
                        layout3 = constraint.f4714e;
                        layout3.q = i4;
                        layout3.p = -1;
                    } else if (i5 == 3) {
                        layout3 = constraint.f4714e;
                        layout3.p = i4;
                        layout3.q = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + F1(i5) + " undefined");
                    }
                    layout3.r = -1;
                    layout3.s = -1;
                    layout3.t = -1;
                    constraint.f4714e.K = i6;
                    return;
                case 5:
                    if (i5 == 5) {
                        layout4 = constraint.f4714e;
                        layout4.r = i4;
                    } else if (i5 == 3) {
                        layout4 = constraint.f4714e;
                        layout4.s = i4;
                    } else if (i5 == 4) {
                        layout4 = constraint.f4714e;
                        layout4.t = i4;
                    } else {
                        throw new IllegalArgumentException("right to " + F1(i5) + " undefined");
                    }
                    layout4.q = -1;
                    layout4.p = -1;
                    layout4.f4745n = -1;
                    layout4.o = -1;
                    return;
                case 6:
                    if (i5 == 6) {
                        Layout layout9 = constraint.f4714e;
                        layout9.v = i4;
                        layout9.u = -1;
                    } else if (i5 == 7) {
                        Layout layout10 = constraint.f4714e;
                        layout10.u = i4;
                        layout10.v = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + F1(i5) + " undefined");
                    }
                    constraint.f4714e.M = i6;
                    return;
                case 7:
                    if (i5 == 7) {
                        Layout layout11 = constraint.f4714e;
                        layout11.x = i4;
                        layout11.w = -1;
                    } else if (i5 == 6) {
                        Layout layout12 = constraint.f4714e;
                        layout12.w = i4;
                        layout12.x = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + F1(i5) + " undefined");
                    }
                    constraint.f4714e.L = i6;
                    return;
                default:
                    throw new IllegalArgumentException(F1(i3) + " to " + F1(i5) + " unknown");
            }
        }
    }

    public void L0(int i2) {
        Constraint constraint;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        ConstraintSet constraintSet;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        ConstraintSet constraintSet2;
        int i13;
        if (this.f4709g.containsKey(Integer.valueOf(i2)) && (constraint = this.f4709g.get(Integer.valueOf(i2))) != null) {
            Layout layout2 = constraint.f4714e;
            int i14 = layout2.f4742k;
            int i15 = layout2.f4743l;
            if (i14 == -1 && i15 == -1) {
                int i16 = layout2.u;
                int i17 = layout2.w;
                if (!(i16 == -1 && i17 == -1)) {
                    if (i16 != -1 && i17 != -1) {
                        i11 = 0;
                        constraintSet2 = this;
                        constraintSet2.L(i16, 7, i17, 6, 0);
                        i10 = 7;
                        i12 = 6;
                        i13 = i17;
                        i9 = i14;
                    } else if (i17 != -1) {
                        i9 = layout2.f4744m;
                        if (i9 != -1) {
                            i10 = 7;
                            i11 = 0;
                            i12 = 7;
                            constraintSet2 = this;
                            i13 = i14;
                        } else {
                            i9 = layout2.f4741j;
                            if (i9 != -1) {
                                i10 = 6;
                                i11 = 0;
                                i12 = 6;
                                constraintSet2 = this;
                                i13 = i17;
                            }
                        }
                    }
                    constraintSet2.L(i13, i12, i9, i10, i11);
                }
                F(i2, 6);
                i3 = 7;
            } else {
                if (i14 == -1 || i15 == -1) {
                    i4 = layout2.f4744m;
                    if (i4 != -1) {
                        i5 = 2;
                        i6 = 0;
                        i7 = 2;
                        constraintSet = this;
                        i8 = i14;
                    } else {
                        i4 = layout2.f4741j;
                        if (i4 != -1) {
                            i5 = 1;
                            i6 = 0;
                            i7 = 1;
                            constraintSet = this;
                            i8 = i15;
                        }
                        F(i2, 1);
                        i3 = 2;
                    }
                } else {
                    i6 = 0;
                    constraintSet = this;
                    constraintSet.L(i14, 2, i15, 1, 0);
                    i5 = 2;
                    i7 = 1;
                    i8 = i15;
                    i4 = i14;
                }
                constraintSet.L(i8, i7, i4, i5, i6);
                F(i2, 1);
                i3 = 2;
            }
            F(i2, i3);
        }
    }

    public void M(int i2, int i3, int i4, float f2) {
        Layout layout2 = i0(i2).f4714e;
        layout2.B = i3;
        layout2.C = i4;
        layout2.D = f2;
    }

    public void M0(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        ConstraintSet constraintSet;
        int i7;
        if (this.f4709g.containsKey(Integer.valueOf(i2))) {
            Constraint constraint = this.f4709g.get(Integer.valueOf(i2));
            if (constraint != null) {
                Layout layout2 = constraint.f4714e;
                int i8 = layout2.o;
                int i9 = layout2.p;
                if (!(i8 == -1 && i9 == -1)) {
                    if (i8 == -1 || i9 == -1) {
                        i3 = layout2.q;
                        if (i3 != -1) {
                            i4 = 4;
                            i5 = 0;
                            i6 = 4;
                            constraintSet = this;
                            i7 = i8;
                        } else {
                            i3 = layout2.f4745n;
                            if (i3 != -1) {
                                i4 = 3;
                                i5 = 0;
                                i6 = 3;
                                constraintSet = this;
                                i7 = i9;
                            }
                        }
                    } else {
                        i5 = 0;
                        constraintSet = this;
                        constraintSet.L(i8, 4, i9, 3, 0);
                        i4 = 4;
                        i6 = 3;
                        i7 = i9;
                        i3 = i8;
                    }
                    constraintSet.L(i7, i6, i3, i4, i5);
                }
            } else {
                return;
            }
        }
        F(i2, 3);
        F(i2, 4);
    }

    public void N(int i2, int i3) {
        i0(i2).f4714e.a0 = i3;
    }

    public void N0(int i2, float f2) {
        i0(i2).f4712c.f4763d = f2;
    }

    public void O(int i2, int i3) {
        i0(i2).f4714e.Z = i3;
    }

    public void O0(int i2, boolean z2) {
        i0(i2).f4715f.f4777m = z2;
    }

    public void P(int i2, int i3) {
        i0(i2).f4714e.f4736e = i3;
    }

    public void P0(int i2, int i3) {
        i0(i2).f4714e.j0 = i3;
    }

    public void Q(int i2, int i3) {
        i0(i2).f4714e.c0 = i3;
    }

    public void Q0(int i2, String str, int i3) {
        i0(i2).p(str, i3);
    }

    public void R(int i2, int i3) {
        i0(i2).f4714e.b0 = i3;
    }

    public void S(int i2, int i3) {
        i0(i2).f4714e.e0 = i3;
    }

    public void T(int i2, int i3) {
        i0(i2).f4714e.d0 = i3;
    }

    public void U(int i2, float f2) {
        i0(i2).f4714e.g0 = f2;
    }

    public void V(int i2, float f2) {
        i0(i2).f4714e.f0 = f2;
    }

    public void V0(int i2, String str) {
        i0(i2).f4714e.A = str;
    }

    public void W(int i2, int i3) {
        i0(i2).f4714e.f4735d = i3;
    }

    public void W0(int i2, int i3) {
        i0(i2).f4714e.E = i3;
    }

    public void X(int i2, boolean z2) {
        i0(i2).f4714e.o0 = z2;
    }

    public void X0(int i2, int i3) {
        i0(i2).f4714e.F = i3;
    }

    public void Y(int i2, boolean z2) {
        i0(i2).f4714e.n0 = z2;
    }

    public void Y0(int i2, float f2) {
        i0(i2).f4715f.f4778n = f2;
        i0(i2).f4715f.f4777m = true;
    }

    public void Z0(int i2, String str, float f2) {
        i0(i2).q(str, f2);
    }

    public void a0(int i2, int i3) {
        Layout layout2 = i0(i2).f4714e;
        layout2.f4732a = true;
        layout2.G = i3;
    }

    public void a1(boolean z2) {
        this.f4708f = z2;
    }

    public void b0(int i2, int i3, int i4, int... iArr) {
        Layout layout2 = i0(i2).f4714e;
        layout2.j0 = 1;
        layout2.h0 = i3;
        layout2.i0 = i4;
        layout2.f4732a = false;
        layout2.k0 = iArr;
    }

    public void b1(int i2, int i3, int i4) {
        Constraint i02 = i0(i2);
        switch (i3) {
            case 1:
                i02.f4714e.O = i4;
                return;
            case 2:
                i02.f4714e.Q = i4;
                return;
            case 3:
                i02.f4714e.P = i4;
                return;
            case 4:
                i02.f4714e.R = i4;
                return;
            case 5:
                i02.f4714e.U = i4;
                return;
            case 6:
                i02.f4714e.T = i4;
                return;
            case 7:
                i02.f4714e.S = i4;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void c0(int i2, int i3, int i4, int i5, int[] iArr, float[] fArr, int i6) {
        d0(i2, i3, i4, i5, iArr, fArr, i6, 1, 2);
    }

    public void c1(int i2, int i3) {
        i0(i2).f4714e.f4737f = i3;
        i0(i2).f4714e.f4738g = -1;
        i0(i2).f4714e.f4739h = -1.0f;
    }

    public void d1(int i2, int i3) {
        i0(i2).f4714e.f4738g = i3;
        i0(i2).f4714e.f4737f = -1;
        i0(i2).f4714e.f4739h = -1.0f;
    }

    public void e0(int i2, int i3, int i4, int i5, int[] iArr, float[] fArr, int i6) {
        d0(i2, i3, i4, i5, iArr, fArr, i6, 6, 7);
    }

    public void e1(int i2, float f2) {
        i0(i2).f4714e.f4739h = f2;
        i0(i2).f4714e.f4738g = -1;
        i0(i2).f4714e.f4737f = -1;
    }

    public void f0(int i2, int i3, int i4, int i5, int[] iArr, float[] fArr, int i6) {
        int[] iArr2 = iArr;
        float[] fArr2 = fArr;
        if (iArr2.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        } else if (fArr2 == null || fArr2.length == iArr2.length) {
            if (fArr2 != null) {
                i0(iArr2[0]).f4714e.V = fArr2[0];
            }
            i0(iArr2[0]).f4714e.Y = i6;
            L(iArr2[0], 3, i2, i3, 0);
            for (int i7 = 1; i7 < iArr2.length; i7++) {
                int i8 = i7 - 1;
                L(iArr2[i7], 3, iArr2[i8], 4, 0);
                L(iArr2[i8], 4, iArr2[i7], 3, 0);
                if (fArr2 != null) {
                    i0(iArr2[i7]).f4714e.V = fArr2[i7];
                }
            }
            L(iArr2[iArr2.length - 1], 4, i4, i5, 0);
        } else {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
    }

    public void f1(int i2, float f2) {
        i0(i2).f4714e.y = f2;
    }

    public void g0(MotionScene motionScene, int... iArr) {
        HashSet hashSet;
        Set<Integer> keySet = this.f4709g.keySet();
        if (iArr.length != 0) {
            hashSet = new HashSet();
            for (int valueOf : iArr) {
                hashSet.add(Integer.valueOf(valueOf));
            }
        } else {
            hashSet = new HashSet(keySet);
        }
        System.out.println(hashSet.size() + " constraints");
        StringBuilder sb = new StringBuilder();
        for (Integer num : (Integer[]) hashSet.toArray(new Integer[0])) {
            Constraint constraint = this.f4709g.get(num);
            if (constraint != null) {
                sb.append("<Constraint id=");
                sb.append(num);
                sb.append(" \n");
                constraint.f4714e.b(motionScene, sb);
                sb.append("/>\n");
            }
        }
        System.out.println(sb.toString());
    }

    public void g1(int i2, int i3) {
        i0(i2).f4714e.X = i3;
    }

    public void h1(int i2, float f2) {
        i0(i2).f4714e.W = f2;
    }

    public void i(String... strArr) {
        h(ConstraintAttribute.AttributeType.COLOR_TYPE, strArr);
    }

    public void i1(int i2, String str, int i3) {
        i0(i2).r(str, i3);
    }

    public void j(String... strArr) {
        h(ConstraintAttribute.AttributeType.FLOAT_TYPE, strArr);
    }

    public boolean j0(int i2) {
        return i0(i2).f4715f.f4777m;
    }

    public void j1(int i2, int i3) {
        if (i3 >= 0 && i3 <= 3) {
            i0(i2).f4714e.q0 = i3;
        }
    }

    public void k(String... strArr) {
        h(ConstraintAttribute.AttributeType.INT_TYPE, strArr);
    }

    public Constraint k0(int i2) {
        if (this.f4709g.containsKey(Integer.valueOf(i2))) {
            return this.f4709g.get(Integer.valueOf(i2));
        }
        return null;
    }

    public void k1(int i2, int i3, int i4) {
        Constraint i02 = i0(i2);
        switch (i3) {
            case 1:
                i02.f4714e.H = i4;
                return;
            case 2:
                i02.f4714e.I = i4;
                return;
            case 3:
                i02.f4714e.J = i4;
                return;
            case 4:
                i02.f4714e.K = i4;
                return;
            case 5:
                i02.f4714e.N = i4;
                return;
            case 6:
                i02.f4714e.M = i4;
                return;
            case 7:
                i02.f4714e.L = i4;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void l(String... strArr) {
        h(ConstraintAttribute.AttributeType.STRING_TYPE, strArr);
    }

    public HashMap<String, ConstraintAttribute> l0() {
        return this.f4707e;
    }

    public void l1(int i2, int... iArr) {
        i0(i2).f4714e.k0 = iArr;
    }

    public void m(int i2, int i3, int i4) {
        L(i2, 1, i3, i3 == 0 ? 1 : 2, 0);
        L(i2, 2, i4, i4 == 0 ? 2 : 1, 0);
        if (i3 != 0) {
            L(i3, 2, i2, 1, 0);
        }
        if (i4 != 0) {
            L(i4, 1, i2, 2, 0);
        }
    }

    public void m1(int i2, float f2) {
        i0(i2).f4715f.f4766b = f2;
    }

    public void n(int i2, int i3, int i4) {
        L(i2, 6, i3, i3 == 0 ? 6 : 7, 0);
        L(i2, 7, i4, i4 == 0 ? 7 : 6, 0);
        if (i3 != 0) {
            L(i3, 7, i2, 6, 0);
        }
        if (i4 != 0) {
            L(i4, 6, i2, 7, 0);
        }
    }

    public int n0(int i2) {
        return i0(i2).f4714e.f4736e;
    }

    public void n1(int i2, float f2) {
        i0(i2).f4715f.f4767c = f2;
    }

    public void o(int i2, int i3, int i4) {
        L(i2, 3, i3, i3 == 0 ? 3 : 4, 0);
        L(i2, 4, i4, i4 == 0 ? 4 : 3, 0);
        if (i3 != 0) {
            L(i3, 4, i2, 3, 0);
        }
        if (i4 != 0) {
            L(i4, 3, i2, 4, 0);
        }
    }

    public int[] o0() {
        Integer[] numArr = (Integer[]) this.f4709g.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = numArr[i2].intValue();
        }
        return iArr;
    }

    public void o1(int i2, float f2) {
        i0(i2).f4715f.f4768d = f2;
    }

    public void p(ConstraintLayout constraintLayout) {
        Constraint constraint;
        int childCount = constraintLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (!this.f4709g.containsKey(Integer.valueOf(id))) {
                Log.w(f4696h, "id unknown " + Debug.k(childAt));
            } else if (this.f4708f && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (this.f4709g.containsKey(Integer.valueOf(id)) && (constraint = this.f4709g.get(Integer.valueOf(id))) != null) {
                ConstraintAttribute.r(childAt, constraint.f4716g);
            }
        }
    }

    public void p1(int i2, float f2) {
        i0(i2).f4715f.f4769e = f2;
    }

    public void q(ConstraintSet constraintSet) {
        for (Constraint next : constraintSet.f4709g.values()) {
            if (next.f4717h != null) {
                if (next.f4711b != null) {
                    for (Integer intValue : this.f4709g.keySet()) {
                        Constraint k02 = k0(intValue.intValue());
                        String str = k02.f4714e.m0;
                        if (str != null && next.f4711b.matches(str)) {
                            next.f4717h.e(k02);
                            k02.f4716g.putAll((HashMap) next.f4716g.clone());
                        }
                    }
                } else {
                    next.f4717h.e(k0(next.f4710a));
                }
            }
        }
    }

    public Constraint q0(int i2) {
        return i0(i2);
    }

    public void q1(int i2, float f2) {
        i0(i2).f4715f.f4770f = f2;
    }

    public void r(ConstraintLayout constraintLayout) {
        t(constraintLayout, true);
        constraintLayout.setConstraintSet((ConstraintSet) null);
        constraintLayout.requestLayout();
    }

    public int[] r0(int i2) {
        int[] iArr = i0(i2).f4714e.k0;
        return iArr == null ? new int[0] : Arrays.copyOf(iArr, iArr.length);
    }

    public void r1(int i2, String str, String str2) {
        i0(i2).s(str, str2);
    }

    public void s(ConstraintHelper constraintHelper, ConstraintWidget constraintWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        Constraint constraint;
        int id = constraintHelper.getId();
        if (this.f4709g.containsKey(Integer.valueOf(id)) && (constraint = this.f4709g.get(Integer.valueOf(id))) != null && (constraintWidget instanceof HelperWidget)) {
            constraintHelper.z(constraint, (HelperWidget) constraintWidget, layoutParams, sparseArray);
        }
    }

    public int s0(int i2) {
        return i0(i2).f4712c.f4761b;
    }

    public void s1(int i2, float f2, float f3) {
        Transform transform = i0(i2).f4715f;
        transform.f4772h = f3;
        transform.f4771g = f2;
    }

    /* access modifiers changed from: package-private */
    public void t(ConstraintLayout constraintLayout, boolean z2) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f4709g.keySet());
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (!this.f4709g.containsKey(Integer.valueOf(id))) {
                Log.w(f4696h, "id unknown " + Debug.k(childAt));
            } else if (this.f4708f && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id != -1) {
                if (this.f4709g.containsKey(Integer.valueOf(id))) {
                    hashSet.remove(Integer.valueOf(id));
                    Constraint constraint = this.f4709g.get(Integer.valueOf(id));
                    if (constraint != null) {
                        if (childAt instanceof Barrier) {
                            constraint.f4714e.j0 = 1;
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            barrier.setType(constraint.f4714e.h0);
                            barrier.setMargin(constraint.f4714e.i0);
                            barrier.setAllowsGoneWidget(constraint.f4714e.p0);
                            Layout layout2 = constraint.f4714e;
                            int[] iArr = layout2.k0;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = layout2.l0;
                                if (str != null) {
                                    layout2.k0 = Z(barrier, str);
                                    barrier.setReferencedIds(constraint.f4714e.k0);
                                }
                            }
                        }
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.e();
                        constraint.i(layoutParams);
                        if (z2) {
                            ConstraintAttribute.r(childAt, constraint.f4716g);
                        }
                        childAt.setLayoutParams(layoutParams);
                        PropertySet propertySet = constraint.f4712c;
                        if (propertySet.f4762c == 0) {
                            childAt.setVisibility(propertySet.f4761b);
                        }
                        childAt.setAlpha(constraint.f4712c.f4763d);
                        childAt.setRotation(constraint.f4715f.f4766b);
                        childAt.setRotationX(constraint.f4715f.f4767c);
                        childAt.setRotationY(constraint.f4715f.f4768d);
                        childAt.setScaleX(constraint.f4715f.f4769e);
                        childAt.setScaleY(constraint.f4715f.f4770f);
                        Transform transform = constraint.f4715f;
                        if (transform.f4773i != -1) {
                            View findViewById = ((View) childAt.getParent()).findViewById(constraint.f4715f.f4773i);
                            if (findViewById != null) {
                                float top = ((float) (findViewById.getTop() + findViewById.getBottom())) / 2.0f;
                                float left = ((float) (findViewById.getLeft() + findViewById.getRight())) / 2.0f;
                                if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                    childAt.setPivotX(left - ((float) childAt.getLeft()));
                                    childAt.setPivotY(top - ((float) childAt.getTop()));
                                }
                            }
                        } else {
                            if (!Float.isNaN(transform.f4771g)) {
                                childAt.setPivotX(constraint.f4715f.f4771g);
                            }
                            if (!Float.isNaN(constraint.f4715f.f4772h)) {
                                childAt.setPivotY(constraint.f4715f.f4772h);
                            }
                        }
                        childAt.setTranslationX(constraint.f4715f.f4774j);
                        childAt.setTranslationY(constraint.f4715f.f4775k);
                        childAt.setTranslationZ(constraint.f4715f.f4776l);
                        Transform transform2 = constraint.f4715f;
                        if (transform2.f4777m) {
                            childAt.setElevation(transform2.f4778n);
                        }
                    }
                } else {
                    Log.v(f4696h, "WARNING NO CONSTRAINTS for view " + id);
                }
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            Integer num = (Integer) it2.next();
            Constraint constraint2 = this.f4709g.get(num);
            if (constraint2 != null) {
                if (constraint2.f4714e.j0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    Layout layout3 = constraint2.f4714e;
                    int[] iArr2 = layout3.k0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = layout3.l0;
                        if (str2 != null) {
                            layout3.k0 = Z(barrier2, str2);
                            barrier2.setReferencedIds(constraint2.f4714e.k0);
                        }
                    }
                    barrier2.setType(constraint2.f4714e.h0);
                    barrier2.setMargin(constraint2.f4714e.i0);
                    ConstraintLayout.LayoutParams k2 = constraintLayout.generateDefaultLayoutParams();
                    barrier2.I();
                    constraint2.i(k2);
                    constraintLayout.addView(barrier2, k2);
                }
                if (constraint2.f4714e.f4732a) {
                    Guideline guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.LayoutParams k3 = constraintLayout.generateDefaultLayoutParams();
                    constraint2.i(k3);
                    constraintLayout.addView(guideline, k3);
                }
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = constraintLayout.getChildAt(i3);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).r(constraintLayout);
            }
        }
    }

    public int t0(int i2) {
        return i0(i2).f4712c.f4762c;
    }

    public void t1(int i2, float f2) {
        i0(i2).f4715f.f4771g = f2;
    }

    public void u(int i2, ConstraintLayout.LayoutParams layoutParams) {
        Constraint constraint;
        if (this.f4709g.containsKey(Integer.valueOf(i2)) && (constraint = this.f4709g.get(Integer.valueOf(i2))) != null) {
            constraint.i(layoutParams);
        }
    }

    public int u0(int i2) {
        return i0(i2).f4714e.f4735d;
    }

    public void u1(int i2, float f2) {
        i0(i2).f4715f.f4772h = f2;
    }

    public void v(ConstraintLayout constraintLayout) {
        t(constraintLayout, false);
        constraintLayout.setConstraintSet((ConstraintSet) null);
    }

    public boolean v0() {
        return this.f4708f;
    }

    public void v1(int i2, float f2, float f3) {
        Transform transform = i0(i2).f4715f;
        transform.f4774j = f2;
        transform.f4775k = f3;
    }

    public void w0(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    Constraint h02 = h0(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        h02.f4714e.f4732a = true;
                    }
                    this.f4709g.put(Integer.valueOf(h02.f4710a), h02);
                }
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public void w1(int i2, float f2) {
        i0(i2).f4715f.f4774j = f2;
    }

    public void x(int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f2) {
        Constraint constraint;
        int i9 = i4;
        float f3 = f2;
        if (i5 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (i8 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (f3 <= 0.0f || f3 > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        } else {
            if (i9 == 1 || i9 == 2) {
                int i10 = i2;
                L(i10, 1, i3, i4, i5);
                L(i10, 2, i6, i7, i8);
                constraint = this.f4709g.get(Integer.valueOf(i2));
                if (constraint == null) {
                    return;
                }
            } else if (i9 == 6 || i9 == 7) {
                int i11 = i2;
                L(i11, 6, i3, i4, i5);
                L(i11, 7, i6, i7, i8);
                constraint = this.f4709g.get(Integer.valueOf(i2));
                if (constraint == null) {
                    return;
                }
            } else {
                int i12 = i2;
                L(i12, 3, i3, i4, i5);
                L(i12, 4, i6, i7, i8);
                Constraint constraint2 = this.f4709g.get(Integer.valueOf(i2));
                if (constraint2 != null) {
                    constraint2.f4714e.z = f3;
                    return;
                }
                return;
            }
            constraint.f4714e.y = f3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01cf, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void x0(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            r9 = this;
            int r0 = r11.getEventType()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r1 = 0
            r2 = r1
        L_0x0006:
            r3 = 1
            if (r0 == r3) goto L_0x01dc
            if (r0 == 0) goto L_0x01cc
            r4 = -1
            r5 = 3
            r6 = 2
            r7 = 0
            if (r0 == r6) goto L_0x006d
            if (r0 == r5) goto L_0x0015
            goto L_0x01cf
        L_0x0015:
            java.lang.String r0 = r11.getName()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.util.Locale r8 = java.util.Locale.ROOT     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.String r0 = r0.toLowerCase(r8)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            int r8 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            switch(r8) {
                case -2075718416: goto L_0x004b;
                case -190376483: goto L_0x0041;
                case 426575017: goto L_0x0037;
                case 2146106725: goto L_0x0027;
                default: goto L_0x0026;
            }     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
        L_0x0026:
            goto L_0x0054
        L_0x0027:
            java.lang.String r8 = "constraintset"
            boolean r0 = r0.equals(r8)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x0054
            r4 = 0
            goto L_0x0054
        L_0x0031:
            r10 = move-exception
            goto L_0x01d5
        L_0x0034:
            r10 = move-exception
            goto L_0x01d9
        L_0x0037:
            java.lang.String r7 = "constraintoverride"
            boolean r0 = r0.equals(r7)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x0054
            r4 = 2
            goto L_0x0054
        L_0x0041:
            java.lang.String r7 = "constraint"
            boolean r0 = r0.equals(r7)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x0054
            r4 = 1
            goto L_0x0054
        L_0x004b:
            java.lang.String r7 = "guideline"
            boolean r0 = r0.equals(r7)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x0054
            r4 = 3
        L_0x0054:
            if (r4 == 0) goto L_0x006c
            if (r4 == r3) goto L_0x005e
            if (r4 == r6) goto L_0x005e
            if (r4 == r5) goto L_0x005e
            goto L_0x01cf
        L_0x005e:
            java.util.HashMap<java.lang.Integer, androidx.constraintlayout.widget.ConstraintSet$Constraint> r0 = r9.f4709g     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            int r3 = r2.f4710a     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r0.put(r3, r2)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r2 = r1
            goto L_0x01cf
        L_0x006c:
            return
        L_0x006d:
            java.lang.String r0 = r11.getName()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            int r8 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            switch(r8) {
                case -2025855158: goto L_0x00d6;
                case -1984451626: goto L_0x00cc;
                case -1962203927: goto L_0x00c2;
                case -1269513683: goto L_0x00b8;
                case -1238332596: goto L_0x00ae;
                case -71750448: goto L_0x00a4;
                case 366511058: goto L_0x0099;
                case 1331510167: goto L_0x008f;
                case 1791837707: goto L_0x0084;
                case 1803088381: goto L_0x007a;
                default: goto L_0x0078;
            }     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
        L_0x0078:
            goto L_0x00df
        L_0x007a:
            java.lang.String r5 = "Constraint"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x00df
            r4 = 0
            goto L_0x00df
        L_0x0084:
            java.lang.String r5 = "CustomAttribute"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x00df
            r4 = 8
            goto L_0x00df
        L_0x008f:
            java.lang.String r6 = "Barrier"
            boolean r0 = r0.equals(r6)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x00df
            r4 = 3
            goto L_0x00df
        L_0x0099:
            java.lang.String r5 = "CustomMethod"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x00df
            r4 = 9
            goto L_0x00df
        L_0x00a4:
            java.lang.String r5 = "Guideline"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x00df
            r4 = 2
            goto L_0x00df
        L_0x00ae:
            java.lang.String r5 = "Transform"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x00df
            r4 = 5
            goto L_0x00df
        L_0x00b8:
            java.lang.String r5 = "PropertySet"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x00df
            r4 = 4
            goto L_0x00df
        L_0x00c2:
            java.lang.String r5 = "ConstraintOverride"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x00df
            r4 = 1
            goto L_0x00df
        L_0x00cc:
            java.lang.String r5 = "Motion"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x00df
            r4 = 7
            goto L_0x00df
        L_0x00d6:
            java.lang.String r5 = "Layout"
            boolean r0 = r0.equals(r5)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            if (r0 == 0) goto L_0x00df
            r4 = 6
        L_0x00df:
            java.lang.String r0 = "XML parser error must be within a Constraint "
            switch(r4) {
                case 0: goto L_0x01c3;
                case 1: goto L_0x01ba;
                case 2: goto L_0x01ab;
                case 3: goto L_0x019e;
                case 4: goto L_0x0179;
                case 5: goto L_0x0154;
                case 6: goto L_0x012e;
                case 7: goto L_0x0108;
                case 8: goto L_0x00e6;
                case 9: goto L_0x00e6;
                default: goto L_0x00e4;
            }
        L_0x00e4:
            goto L_0x01cf
        L_0x00e6:
            if (r2 == 0) goto L_0x00ef
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r0 = r2.f4716g     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            androidx.constraintlayout.widget.ConstraintAttribute.q(r10, r11, r0)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            goto L_0x01cf
        L_0x00ef:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            throw r10     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
        L_0x0108:
            if (r2 == 0) goto L_0x0115
            androidx.constraintlayout.widget.ConstraintSet$Motion r0 = r2.f4713d     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r0.b(r10, r3)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            goto L_0x01cf
        L_0x0115:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            throw r10     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
        L_0x012e:
            if (r2 == 0) goto L_0x013b
            androidx.constraintlayout.widget.ConstraintSet$Layout r0 = r2.f4714e     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r0.c(r10, r3)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            goto L_0x01cf
        L_0x013b:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            throw r10     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
        L_0x0154:
            if (r2 == 0) goto L_0x0160
            androidx.constraintlayout.widget.ConstraintSet$Transform r0 = r2.f4715f     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r0.b(r10, r3)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            goto L_0x01cf
        L_0x0160:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            throw r10     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
        L_0x0179:
            if (r2 == 0) goto L_0x0185
            androidx.constraintlayout.widget.ConstraintSet$PropertySet r0 = r2.f4712c     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r0.b(r10, r3)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            goto L_0x01cf
        L_0x0185:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            throw r10     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
        L_0x019e:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r2 = r9.h0(r10, r0, r7)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            androidx.constraintlayout.widget.ConstraintSet$Layout r0 = r2.f4714e     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r0.j0 = r3     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            goto L_0x01cf
        L_0x01ab:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r2 = r9.h0(r10, r0, r7)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            androidx.constraintlayout.widget.ConstraintSet$Layout r0 = r2.f4714e     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r0.f4732a = r3     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            r0.f4733b = r3     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            goto L_0x01cf
        L_0x01ba:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r2 = r9.h0(r10, r0, r3)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            goto L_0x01cf
        L_0x01c3:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r2 = r9.h0(r10, r0, r7)     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            goto L_0x01cf
        L_0x01cc:
            r11.getName()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
        L_0x01cf:
            int r0 = r11.next()     // Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x0031 }
            goto L_0x0006
        L_0x01d5:
            r10.printStackTrace()
            goto L_0x01dc
        L_0x01d9:
            r10.printStackTrace()
        L_0x01dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.x0(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public void x1(int i2, float f2) {
        i0(i2).f4715f.f4775k = f2;
    }

    public void y(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        ConstraintSet constraintSet;
        int i7;
        int i8;
        int i9;
        if (i3 == 0) {
            i8 = 0;
            i4 = 1;
            i5 = 0;
            i9 = 0;
            i6 = 2;
            constraintSet = this;
            i7 = i2;
        } else {
            i4 = 2;
            i5 = 0;
            i6 = 1;
            constraintSet = this;
            i7 = i2;
            i8 = i3;
            i9 = i3;
        }
        constraintSet.x(i7, i8, i4, i5, i9, i6, 0, 0.5f);
    }

    public void y1(int i2, float f2) {
        i0(i2).f4715f.f4776l = f2;
    }

    public void z(int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f2) {
        L(i2, 1, i3, i4, i5);
        L(i2, 2, i6, i7, i8);
        Constraint constraint = this.f4709g.get(Integer.valueOf(i2));
        if (constraint != null) {
            constraint.f4714e.y = f2;
        }
    }

    public void z0(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i2 = 0; i2 < split.length; i2++) {
            String[] split2 = split[i2].split("=");
            if (split2.length != 2) {
                Log.w(f4696h, " Unable to parse " + split[i2]);
            } else {
                constraint.p(split2[0], Color.parseColor(split2[1]));
            }
        }
    }

    public void z1(boolean z2) {
        this.f4703a = z2;
    }
}
