package androidx.constraintlayout.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ConstraintLayout extends ViewGroup {
    private static final boolean A3 = false;
    private static final boolean B3 = false;
    public static final int C3 = 0;
    private static SharedValues D3 = null;
    public static final String v3 = "ConstraintLayout-2.1.4";
    private static final String w3 = "ConstraintLayout";
    private static final boolean x3 = true;
    private static final boolean y3 = false;
    private static final boolean z3 = false;
    /* access modifiers changed from: private */
    public ArrayList<ConstraintHelper> X2 = new ArrayList<>(4);
    /* access modifiers changed from: protected */
    public ConstraintWidgetContainer Y2 = new ConstraintWidgetContainer();
    private int Z2 = 0;
    private int a3 = 0;
    private int b3 = Integer.MAX_VALUE;
    private int c3 = Integer.MAX_VALUE;
    protected boolean d3 = true;
    /* access modifiers changed from: private */
    public int e3 = 257;
    private ConstraintSet f3 = null;
    protected ConstraintLayoutStates g3 = null;
    private int h3 = -1;
    private HashMap<String, Integer> i3 = new HashMap<>();
    private int j3 = -1;
    private int k3 = -1;
    int l3 = -1;
    int m3 = -1;
    int n3 = 0;
    int o3 = 0;
    private SparseArray<ConstraintWidget> p3 = new SparseArray<>();
    private ConstraintsChangedListener q3;
    private Metrics r3;
    SparseArray<View> s = new SparseArray<>();
    Measurer s3 = new Measurer(this);
    private int t3 = 0;
    private int u3 = 0;

    /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4625a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4625a = r0
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4625a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4625a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4625a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.AnonymousClass1.<clinit>():void");
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int A0 = Integer.MIN_VALUE;
        public static final int B0 = 0;
        public static final int C0 = 1;
        public static final int D0 = 1;
        public static final int E0 = 2;
        public static final int F0 = 3;
        public static final int G0 = 4;
        public static final int H0 = 5;
        public static final int I0 = 6;
        public static final int J0 = 7;
        public static final int K0 = 8;
        public static final int L0 = 1;
        public static final int M0 = 0;
        public static final int N0 = 2;
        public static final int O0 = 0;
        public static final int P0 = 1;
        public static final int Q0 = 2;
        public static final int R0 = 0;
        public static final int S0 = 1;
        public static final int T0 = 2;
        public static final int U0 = 3;
        public static final int x0 = 0;
        public static final int y0 = 0;
        public static final int z0 = -1;
        public int A = Integer.MIN_VALUE;
        public int B = Integer.MIN_VALUE;
        public int C = Integer.MIN_VALUE;
        public int D = 0;
        boolean E = true;
        boolean F = true;
        public float G = 0.5f;
        public float H = 0.5f;
        public String I = null;
        float J = 0.0f;
        int K = 1;
        public float L = -1.0f;
        public float M = -1.0f;
        public int N = 0;
        public int O = 0;
        public int P = 0;
        public int Q = 0;
        public int R = 0;
        public int S = 0;
        public int T = 0;
        public int U = 0;
        public float V = 1.0f;
        public float W = 1.0f;
        public int X = -1;
        public int Y = -1;
        public int Z = -1;

        /* renamed from: a  reason: collision with root package name */
        public int f4626a = -1;
        public boolean a0 = false;

        /* renamed from: b  reason: collision with root package name */
        public int f4627b = -1;
        public boolean b0 = false;

        /* renamed from: c  reason: collision with root package name */
        public float f4628c = -1.0f;
        public String c0 = null;

        /* renamed from: d  reason: collision with root package name */
        public boolean f4629d = true;
        public int d0 = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f4630e = -1;
        boolean e0 = true;

        /* renamed from: f  reason: collision with root package name */
        public int f4631f = -1;
        boolean f0 = true;

        /* renamed from: g  reason: collision with root package name */
        public int f4632g = -1;
        boolean g0 = false;

        /* renamed from: h  reason: collision with root package name */
        public int f4633h = -1;
        boolean h0 = false;

        /* renamed from: i  reason: collision with root package name */
        public int f4634i = -1;
        boolean i0 = false;

        /* renamed from: j  reason: collision with root package name */
        public int f4635j = -1;
        boolean j0 = false;

        /* renamed from: k  reason: collision with root package name */
        public int f4636k = -1;
        boolean k0 = false;

        /* renamed from: l  reason: collision with root package name */
        public int f4637l = -1;
        int l0 = -1;

        /* renamed from: m  reason: collision with root package name */
        public int f4638m = -1;
        int m0 = -1;

        /* renamed from: n  reason: collision with root package name */
        public int f4639n = -1;
        int n0 = -1;
        public int o = -1;
        int o0 = -1;
        public int p = -1;
        int p0 = Integer.MIN_VALUE;
        public int q = 0;
        int q0 = Integer.MIN_VALUE;
        public float r = 0.0f;
        float r0 = 0.5f;
        public int s = -1;
        int s0;
        public int t = -1;
        int t0;
        public int u = -1;
        float u0;
        public int v = -1;
        ConstraintWidget v0 = new ConstraintWidget();
        public int w = Integer.MIN_VALUE;
        public boolean w0 = false;
        public int x = Integer.MIN_VALUE;
        public int y = Integer.MIN_VALUE;
        public int z = Integer.MIN_VALUE;

        private static class Table {
            public static final int A = 26;
            public static final int B = 27;
            public static final int C = 28;
            public static final int D = 29;
            public static final int E = 30;
            public static final int F = 31;
            public static final int G = 32;
            public static final int H = 33;
            public static final int I = 34;
            public static final int J = 35;
            public static final int K = 36;
            public static final int L = 37;
            public static final int M = 38;
            public static final int N = 39;
            public static final int O = 40;
            public static final int P = 41;
            public static final int Q = 42;
            public static final int R = 43;
            public static final int S = 44;
            public static final int T = 45;
            public static final int U = 46;
            public static final int V = 47;
            public static final int W = 48;
            public static final int X = 49;
            public static final int Y = 50;
            public static final int Z = 51;

            /* renamed from: a  reason: collision with root package name */
            public static final int f4640a = 0;
            public static final int a0 = 52;

            /* renamed from: b  reason: collision with root package name */
            public static final int f4641b = 1;
            public static final int b0 = 53;

            /* renamed from: c  reason: collision with root package name */
            public static final int f4642c = 2;
            public static final int c0 = 54;

            /* renamed from: d  reason: collision with root package name */
            public static final int f4643d = 3;
            public static final int d0 = 55;

            /* renamed from: e  reason: collision with root package name */
            public static final int f4644e = 4;
            public static final int e0 = 64;

            /* renamed from: f  reason: collision with root package name */
            public static final int f4645f = 5;
            public static final int f0 = 65;

            /* renamed from: g  reason: collision with root package name */
            public static final int f4646g = 6;
            public static final int g0 = 66;

            /* renamed from: h  reason: collision with root package name */
            public static final int f4647h = 7;
            public static final int h0 = 67;

            /* renamed from: i  reason: collision with root package name */
            public static final int f4648i = 8;
            public static final SparseIntArray i0;

            /* renamed from: j  reason: collision with root package name */
            public static final int f4649j = 9;

            /* renamed from: k  reason: collision with root package name */
            public static final int f4650k = 10;

            /* renamed from: l  reason: collision with root package name */
            public static final int f4651l = 11;

            /* renamed from: m  reason: collision with root package name */
            public static final int f4652m = 12;

            /* renamed from: n  reason: collision with root package name */
            public static final int f4653n = 13;
            public static final int o = 14;
            public static final int p = 15;
            public static final int q = 16;
            public static final int r = 17;
            public static final int s = 18;
            public static final int t = 19;
            public static final int u = 20;
            public static final int v = 21;
            public static final int w = 22;
            public static final int x = 23;
            public static final int y = 24;
            public static final int z = 25;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                i0 = sparseIntArray;
                sparseIntArray.append(R.styleable.t8, 64);
                sparseIntArray.append(R.styleable.W7, 65);
                sparseIntArray.append(R.styleable.f8, 8);
                sparseIntArray.append(R.styleable.g8, 9);
                sparseIntArray.append(R.styleable.i8, 10);
                sparseIntArray.append(R.styleable.j8, 11);
                sparseIntArray.append(R.styleable.p8, 12);
                sparseIntArray.append(R.styleable.o8, 13);
                sparseIntArray.append(R.styleable.M7, 14);
                sparseIntArray.append(R.styleable.L7, 15);
                sparseIntArray.append(R.styleable.H7, 16);
                sparseIntArray.append(R.styleable.J7, 52);
                sparseIntArray.append(R.styleable.I7, 53);
                sparseIntArray.append(R.styleable.N7, 2);
                sparseIntArray.append(R.styleable.P7, 3);
                sparseIntArray.append(R.styleable.O7, 4);
                sparseIntArray.append(R.styleable.y8, 49);
                sparseIntArray.append(R.styleable.z8, 50);
                sparseIntArray.append(R.styleable.T7, 5);
                sparseIntArray.append(R.styleable.U7, 6);
                sparseIntArray.append(R.styleable.V7, 7);
                sparseIntArray.append(R.styleable.C7, 67);
                sparseIntArray.append(R.styleable.z6, 1);
                sparseIntArray.append(R.styleable.k8, 17);
                sparseIntArray.append(R.styleable.l8, 18);
                sparseIntArray.append(R.styleable.S7, 19);
                sparseIntArray.append(R.styleable.R7, 20);
                sparseIntArray.append(R.styleable.D8, 21);
                sparseIntArray.append(R.styleable.G8, 22);
                sparseIntArray.append(R.styleable.E8, 23);
                sparseIntArray.append(R.styleable.B8, 24);
                sparseIntArray.append(R.styleable.F8, 25);
                sparseIntArray.append(R.styleable.C8, 26);
                sparseIntArray.append(R.styleable.A8, 55);
                sparseIntArray.append(R.styleable.H8, 54);
                sparseIntArray.append(R.styleable.b8, 29);
                sparseIntArray.append(R.styleable.q8, 30);
                sparseIntArray.append(R.styleable.Q7, 44);
                sparseIntArray.append(R.styleable.d8, 45);
                sparseIntArray.append(R.styleable.s8, 46);
                sparseIntArray.append(R.styleable.c8, 47);
                sparseIntArray.append(R.styleable.r8, 48);
                sparseIntArray.append(R.styleable.F7, 27);
                sparseIntArray.append(R.styleable.E7, 28);
                sparseIntArray.append(R.styleable.u8, 31);
                sparseIntArray.append(R.styleable.X7, 32);
                sparseIntArray.append(R.styleable.w8, 33);
                sparseIntArray.append(R.styleable.v8, 34);
                sparseIntArray.append(R.styleable.x8, 35);
                sparseIntArray.append(R.styleable.Z7, 36);
                sparseIntArray.append(R.styleable.Y7, 37);
                sparseIntArray.append(R.styleable.a8, 38);
                sparseIntArray.append(R.styleable.e8, 39);
                sparseIntArray.append(R.styleable.n8, 40);
                sparseIntArray.append(R.styleable.h8, 41);
                sparseIntArray.append(R.styleable.K7, 42);
                sparseIntArray.append(R.styleable.G7, 43);
                sparseIntArray.append(R.styleable.m8, 51);
                sparseIntArray.append(R.styleable.J8, 66);
            }

            private Table() {
            }
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public String a() {
            return this.c0;
        }

        public ConstraintWidget b() {
            return this.v0;
        }

        public void c() {
            ConstraintWidget constraintWidget = this.v0;
            if (constraintWidget != null) {
                constraintWidget.R0();
            }
        }

        public void d(String str) {
            this.v0.j1(str);
        }

        public void e() {
            this.h0 = false;
            this.e0 = true;
            this.f0 = true;
            int i2 = this.width;
            if (i2 == -2 && this.a0) {
                this.e0 = false;
                if (this.P == 0) {
                    this.P = 1;
                }
            }
            int i3 = this.height;
            if (i3 == -2 && this.b0) {
                this.f0 = false;
                if (this.Q == 0) {
                    this.Q = 1;
                }
            }
            if (i2 == 0 || i2 == -1) {
                this.e0 = false;
                if (i2 == 0 && this.P == 1) {
                    this.width = -2;
                    this.a0 = true;
                }
            }
            if (i3 == 0 || i3 == -1) {
                this.f0 = false;
                if (i3 == 0 && this.Q == 1) {
                    this.height = -2;
                    this.b0 = true;
                }
            }
            if (this.f4628c != -1.0f || this.f4626a != -1 || this.f4627b != -1) {
                this.h0 = true;
                this.e0 = true;
                this.f0 = true;
                if (!(this.v0 instanceof Guideline)) {
                    this.v0 = new Guideline();
                }
                ((Guideline) this.v0).B2(this.Z);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:72:0x00d0, code lost:
            if (r1 > 0) goto L_0x00d2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x00df, code lost:
            if (r1 > 0) goto L_0x00d2;
         */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x005e  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x007a  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0082  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x00e6  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x00f1  */
        @android.annotation.TargetApi(17)
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void resolveLayoutDirection(int r11) {
            /*
                r10 = this;
                int r0 = r10.leftMargin
                int r1 = r10.rightMargin
                super.resolveLayoutDirection(r11)
                int r11 = r10.getLayoutDirection()
                r2 = 0
                r3 = 1
                if (r3 != r11) goto L_0x0011
                r11 = 1
                goto L_0x0012
            L_0x0011:
                r11 = 0
            L_0x0012:
                r4 = -1
                r10.n0 = r4
                r10.o0 = r4
                r10.l0 = r4
                r10.m0 = r4
                int r5 = r10.w
                r10.p0 = r5
                int r5 = r10.y
                r10.q0 = r5
                float r5 = r10.G
                r10.r0 = r5
                int r6 = r10.f4626a
                r10.s0 = r6
                int r7 = r10.f4627b
                r10.t0 = r7
                float r8 = r10.f4628c
                r10.u0 = r8
                r9 = -2147483648(0xffffffff80000000, float:-0.0)
                if (r11 == 0) goto L_0x0092
                int r11 = r10.s
                if (r11 == r4) goto L_0x003f
                r10.n0 = r11
            L_0x003d:
                r2 = 1
                goto L_0x0046
            L_0x003f:
                int r11 = r10.t
                if (r11 == r4) goto L_0x0046
                r10.o0 = r11
                goto L_0x003d
            L_0x0046:
                int r11 = r10.u
                if (r11 == r4) goto L_0x004d
                r10.m0 = r11
                r2 = 1
            L_0x004d:
                int r11 = r10.v
                if (r11 == r4) goto L_0x0054
                r10.l0 = r11
                r2 = 1
            L_0x0054:
                int r11 = r10.A
                if (r11 == r9) goto L_0x005a
                r10.q0 = r11
            L_0x005a:
                int r11 = r10.B
                if (r11 == r9) goto L_0x0060
                r10.p0 = r11
            L_0x0060:
                r11 = 1065353216(0x3f800000, float:1.0)
                if (r2 == 0) goto L_0x0068
                float r2 = r11 - r5
                r10.r0 = r2
            L_0x0068:
                boolean r2 = r10.h0
                if (r2 == 0) goto L_0x00b6
                int r2 = r10.Z
                if (r2 != r3) goto L_0x00b6
                boolean r2 = r10.f4629d
                if (r2 == 0) goto L_0x00b6
                r2 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r3 == 0) goto L_0x0082
                float r11 = r11 - r8
                r10.u0 = r11
                r10.s0 = r4
                r10.t0 = r4
                goto L_0x00b6
            L_0x0082:
                if (r6 == r4) goto L_0x008b
                r10.t0 = r6
                r10.s0 = r4
            L_0x0088:
                r10.u0 = r2
                goto L_0x00b6
            L_0x008b:
                if (r7 == r4) goto L_0x00b6
                r10.s0 = r7
                r10.t0 = r4
                goto L_0x0088
            L_0x0092:
                int r11 = r10.s
                if (r11 == r4) goto L_0x0098
                r10.m0 = r11
            L_0x0098:
                int r11 = r10.t
                if (r11 == r4) goto L_0x009e
                r10.l0 = r11
            L_0x009e:
                int r11 = r10.u
                if (r11 == r4) goto L_0x00a4
                r10.n0 = r11
            L_0x00a4:
                int r11 = r10.v
                if (r11 == r4) goto L_0x00aa
                r10.o0 = r11
            L_0x00aa:
                int r11 = r10.A
                if (r11 == r9) goto L_0x00b0
                r10.p0 = r11
            L_0x00b0:
                int r11 = r10.B
                if (r11 == r9) goto L_0x00b6
                r10.q0 = r11
            L_0x00b6:
                int r11 = r10.u
                if (r11 != r4) goto L_0x00fe
                int r11 = r10.v
                if (r11 != r4) goto L_0x00fe
                int r11 = r10.t
                if (r11 != r4) goto L_0x00fe
                int r11 = r10.s
                if (r11 != r4) goto L_0x00fe
                int r11 = r10.f4632g
                if (r11 == r4) goto L_0x00d5
                r10.n0 = r11
                int r11 = r10.rightMargin
                if (r11 > 0) goto L_0x00e2
                if (r1 <= 0) goto L_0x00e2
            L_0x00d2:
                r10.rightMargin = r1
                goto L_0x00e2
            L_0x00d5:
                int r11 = r10.f4633h
                if (r11 == r4) goto L_0x00e2
                r10.o0 = r11
                int r11 = r10.rightMargin
                if (r11 > 0) goto L_0x00e2
                if (r1 <= 0) goto L_0x00e2
                goto L_0x00d2
            L_0x00e2:
                int r11 = r10.f4630e
                if (r11 == r4) goto L_0x00f1
                r10.l0 = r11
                int r11 = r10.leftMargin
                if (r11 > 0) goto L_0x00fe
                if (r0 <= 0) goto L_0x00fe
            L_0x00ee:
                r10.leftMargin = r0
                goto L_0x00fe
            L_0x00f1:
                int r11 = r10.f4631f
                if (r11 == r4) goto L_0x00fe
                r10.m0 = r11
                int r11 = r10.leftMargin
                if (r11 > 0) goto L_0x00fe
                if (r0 <= 0) goto L_0x00fe
                goto L_0x00ee
            L_0x00fe:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x01f4, code lost:
            android.util.Log.e(androidx.constraintlayout.widget.ConstraintLayout.w3, r5);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public LayoutParams(android.content.Context r11, android.util.AttributeSet r12) {
            /*
                r10 = this;
                r10.<init>(r11, r12)
                r0 = -1
                r10.f4626a = r0
                r10.f4627b = r0
                r1 = -1082130432(0xffffffffbf800000, float:-1.0)
                r10.f4628c = r1
                r2 = 1
                r10.f4629d = r2
                r10.f4630e = r0
                r10.f4631f = r0
                r10.f4632g = r0
                r10.f4633h = r0
                r10.f4634i = r0
                r10.f4635j = r0
                r10.f4636k = r0
                r10.f4637l = r0
                r10.f4638m = r0
                r10.f4639n = r0
                r10.o = r0
                r10.p = r0
                r3 = 0
                r10.q = r3
                r4 = 0
                r10.r = r4
                r10.s = r0
                r10.t = r0
                r10.u = r0
                r10.v = r0
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                r10.w = r5
                r10.x = r5
                r10.y = r5
                r10.z = r5
                r10.A = r5
                r10.B = r5
                r10.C = r5
                r10.D = r3
                r10.E = r2
                r10.F = r2
                r6 = 1056964608(0x3f000000, float:0.5)
                r10.G = r6
                r10.H = r6
                r7 = 0
                r10.I = r7
                r10.J = r4
                r10.K = r2
                r10.L = r1
                r10.M = r1
                r10.N = r3
                r10.O = r3
                r10.P = r3
                r10.Q = r3
                r10.R = r3
                r10.S = r3
                r10.T = r3
                r10.U = r3
                r1 = 1065353216(0x3f800000, float:1.0)
                r10.V = r1
                r10.W = r1
                r10.X = r0
                r10.Y = r0
                r10.Z = r0
                r10.a0 = r3
                r10.b0 = r3
                r10.c0 = r7
                r10.d0 = r3
                r10.e0 = r2
                r10.f0 = r2
                r10.g0 = r3
                r10.h0 = r3
                r10.i0 = r3
                r10.j0 = r3
                r10.k0 = r3
                r10.l0 = r0
                r10.m0 = r0
                r10.n0 = r0
                r10.o0 = r0
                r10.p0 = r5
                r10.q0 = r5
                r10.r0 = r6
                androidx.constraintlayout.core.widgets.ConstraintWidget r1 = new androidx.constraintlayout.core.widgets.ConstraintWidget
                r1.<init>()
                r10.v0 = r1
                r10.w0 = r3
                int[] r1 = androidx.constraintlayout.widget.R.styleable.y6
                android.content.res.TypedArray r11 = r11.obtainStyledAttributes(r12, r1)
                int r12 = r11.getIndexCount()
                r1 = 0
            L_0x00b0:
                if (r1 >= r12) goto L_0x03a6
                int r5 = r11.getIndex(r1)
                android.util.SparseIntArray r6 = androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.Table.i0
                int r6 = r6.get(r5)
                java.lang.String r7 = "ConstraintLayout"
                r8 = 2
                r9 = -2
                switch(r6) {
                    case 1: goto L_0x039a;
                    case 2: goto L_0x0389;
                    case 3: goto L_0x0380;
                    case 4: goto L_0x036b;
                    case 5: goto L_0x0362;
                    case 6: goto L_0x0359;
                    case 7: goto L_0x0350;
                    case 8: goto L_0x033f;
                    case 9: goto L_0x032e;
                    case 10: goto L_0x031c;
                    case 11: goto L_0x030a;
                    case 12: goto L_0x02f8;
                    case 13: goto L_0x02e6;
                    case 14: goto L_0x02d4;
                    case 15: goto L_0x02c2;
                    case 16: goto L_0x02b0;
                    case 17: goto L_0x029e;
                    case 18: goto L_0x028c;
                    case 19: goto L_0x027a;
                    case 20: goto L_0x0268;
                    case 21: goto L_0x025e;
                    case 22: goto L_0x0254;
                    case 23: goto L_0x024a;
                    case 24: goto L_0x0240;
                    case 25: goto L_0x0236;
                    case 26: goto L_0x022c;
                    case 27: goto L_0x0222;
                    case 28: goto L_0x0218;
                    case 29: goto L_0x020e;
                    case 30: goto L_0x0204;
                    case 31: goto L_0x01f9;
                    case 32: goto L_0x01ea;
                    case 33: goto L_0x01d3;
                    case 34: goto L_0x01bc;
                    case 35: goto L_0x01ac;
                    case 36: goto L_0x0195;
                    case 37: goto L_0x017e;
                    case 38: goto L_0x016e;
                    default: goto L_0x00c3;
                }
            L_0x00c3:
                switch(r6) {
                    case 44: goto L_0x0165;
                    case 45: goto L_0x015b;
                    case 46: goto L_0x0151;
                    case 47: goto L_0x0149;
                    case 48: goto L_0x0141;
                    case 49: goto L_0x0137;
                    case 50: goto L_0x012d;
                    case 51: goto L_0x0125;
                    case 52: goto L_0x0113;
                    case 53: goto L_0x0101;
                    case 54: goto L_0x00f7;
                    case 55: goto L_0x00ed;
                    default: goto L_0x00c6;
                }
            L_0x00c6:
                switch(r6) {
                    case 64: goto L_0x00e6;
                    case 65: goto L_0x00df;
                    case 66: goto L_0x00d5;
                    case 67: goto L_0x00cb;
                    default: goto L_0x00c9;
                }
            L_0x00c9:
                goto L_0x03a2
            L_0x00cb:
                boolean r6 = r10.f4629d
                boolean r5 = r11.getBoolean(r5, r6)
                r10.f4629d = r5
                goto L_0x03a2
            L_0x00d5:
                int r6 = r10.d0
                int r5 = r11.getInt(r5, r6)
                r10.d0 = r5
                goto L_0x03a2
            L_0x00df:
                androidx.constraintlayout.widget.ConstraintSet.A0(r10, r11, r5, r2)
                r10.F = r2
                goto L_0x03a2
            L_0x00e6:
                androidx.constraintlayout.widget.ConstraintSet.A0(r10, r11, r5, r3)
                r10.E = r2
                goto L_0x03a2
            L_0x00ed:
                int r6 = r10.C
                int r5 = r11.getDimensionPixelSize(r5, r6)
                r10.C = r5
                goto L_0x03a2
            L_0x00f7:
                int r6 = r10.D
                int r5 = r11.getDimensionPixelSize(r5, r6)
                r10.D = r5
                goto L_0x03a2
            L_0x0101:
                int r6 = r10.o
                int r6 = r11.getResourceId(r5, r6)
                r10.o = r6
                if (r6 != r0) goto L_0x03a2
                int r5 = r11.getInt(r5, r0)
                r10.o = r5
                goto L_0x03a2
            L_0x0113:
                int r6 = r10.f4639n
                int r6 = r11.getResourceId(r5, r6)
                r10.f4639n = r6
                if (r6 != r0) goto L_0x03a2
                int r5 = r11.getInt(r5, r0)
                r10.f4639n = r5
                goto L_0x03a2
            L_0x0125:
                java.lang.String r5 = r11.getString(r5)
                r10.c0 = r5
                goto L_0x03a2
            L_0x012d:
                int r6 = r10.Y
                int r5 = r11.getDimensionPixelOffset(r5, r6)
                r10.Y = r5
                goto L_0x03a2
            L_0x0137:
                int r6 = r10.X
                int r5 = r11.getDimensionPixelOffset(r5, r6)
                r10.X = r5
                goto L_0x03a2
            L_0x0141:
                int r5 = r11.getInt(r5, r3)
                r10.O = r5
                goto L_0x03a2
            L_0x0149:
                int r5 = r11.getInt(r5, r3)
                r10.N = r5
                goto L_0x03a2
            L_0x0151:
                float r6 = r10.M
                float r5 = r11.getFloat(r5, r6)
                r10.M = r5
                goto L_0x03a2
            L_0x015b:
                float r6 = r10.L
                float r5 = r11.getFloat(r5, r6)
                r10.L = r5
                goto L_0x03a2
            L_0x0165:
                java.lang.String r5 = r11.getString(r5)
                androidx.constraintlayout.widget.ConstraintSet.C0(r10, r5)
                goto L_0x03a2
            L_0x016e:
                float r6 = r10.W
                float r5 = r11.getFloat(r5, r6)
                float r5 = java.lang.Math.max(r4, r5)
                r10.W = r5
                r10.Q = r8
                goto L_0x03a2
            L_0x017e:
                int r6 = r10.U     // Catch:{ Exception -> 0x0188 }
                int r6 = r11.getDimensionPixelSize(r5, r6)     // Catch:{ Exception -> 0x0188 }
                r10.U = r6     // Catch:{ Exception -> 0x0188 }
                goto L_0x03a2
            L_0x0188:
                int r6 = r10.U
                int r5 = r11.getInt(r5, r6)
                if (r5 != r9) goto L_0x03a2
                r10.U = r9
                goto L_0x03a2
            L_0x0195:
                int r6 = r10.S     // Catch:{ Exception -> 0x019f }
                int r6 = r11.getDimensionPixelSize(r5, r6)     // Catch:{ Exception -> 0x019f }
                r10.S = r6     // Catch:{ Exception -> 0x019f }
                goto L_0x03a2
            L_0x019f:
                int r6 = r10.S
                int r5 = r11.getInt(r5, r6)
                if (r5 != r9) goto L_0x03a2
                r10.S = r9
                goto L_0x03a2
            L_0x01ac:
                float r6 = r10.V
                float r5 = r11.getFloat(r5, r6)
                float r5 = java.lang.Math.max(r4, r5)
                r10.V = r5
                r10.P = r8
                goto L_0x03a2
            L_0x01bc:
                int r6 = r10.T     // Catch:{ Exception -> 0x01c6 }
                int r6 = r11.getDimensionPixelSize(r5, r6)     // Catch:{ Exception -> 0x01c6 }
                r10.T = r6     // Catch:{ Exception -> 0x01c6 }
                goto L_0x03a2
            L_0x01c6:
                int r6 = r10.T
                int r5 = r11.getInt(r5, r6)
                if (r5 != r9) goto L_0x03a2
                r10.T = r9
                goto L_0x03a2
            L_0x01d3:
                int r6 = r10.R     // Catch:{ Exception -> 0x01dd }
                int r6 = r11.getDimensionPixelSize(r5, r6)     // Catch:{ Exception -> 0x01dd }
                r10.R = r6     // Catch:{ Exception -> 0x01dd }
                goto L_0x03a2
            L_0x01dd:
                int r6 = r10.R
                int r5 = r11.getInt(r5, r6)
                if (r5 != r9) goto L_0x03a2
                r10.R = r9
                goto L_0x03a2
            L_0x01ea:
                int r5 = r11.getInt(r5, r3)
                r10.Q = r5
                if (r5 != r2) goto L_0x03a2
                java.lang.String r5 = "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead."
            L_0x01f4:
                android.util.Log.e(r7, r5)
                goto L_0x03a2
            L_0x01f9:
                int r5 = r11.getInt(r5, r3)
                r10.P = r5
                if (r5 != r2) goto L_0x03a2
                java.lang.String r5 = "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead."
                goto L_0x01f4
            L_0x0204:
                float r6 = r10.H
                float r5 = r11.getFloat(r5, r6)
                r10.H = r5
                goto L_0x03a2
            L_0x020e:
                float r6 = r10.G
                float r5 = r11.getFloat(r5, r6)
                r10.G = r5
                goto L_0x03a2
            L_0x0218:
                boolean r6 = r10.b0
                boolean r5 = r11.getBoolean(r5, r6)
                r10.b0 = r5
                goto L_0x03a2
            L_0x0222:
                boolean r6 = r10.a0
                boolean r5 = r11.getBoolean(r5, r6)
                r10.a0 = r5
                goto L_0x03a2
            L_0x022c:
                int r6 = r10.B
                int r5 = r11.getDimensionPixelSize(r5, r6)
                r10.B = r5
                goto L_0x03a2
            L_0x0236:
                int r6 = r10.A
                int r5 = r11.getDimensionPixelSize(r5, r6)
                r10.A = r5
                goto L_0x03a2
            L_0x0240:
                int r6 = r10.z
                int r5 = r11.getDimensionPixelSize(r5, r6)
                r10.z = r5
                goto L_0x03a2
            L_0x024a:
                int r6 = r10.y
                int r5 = r11.getDimensionPixelSize(r5, r6)
                r10.y = r5
                goto L_0x03a2
            L_0x0254:
                int r6 = r10.x
                int r5 = r11.getDimensionPixelSize(r5, r6)
                r10.x = r5
                goto L_0x03a2
            L_0x025e:
                int r6 = r10.w
                int r5 = r11.getDimensionPixelSize(r5, r6)
                r10.w = r5
                goto L_0x03a2
            L_0x0268:
                int r6 = r10.v
                int r6 = r11.getResourceId(r5, r6)
                r10.v = r6
                if (r6 != r0) goto L_0x03a2
                int r5 = r11.getInt(r5, r0)
                r10.v = r5
                goto L_0x03a2
            L_0x027a:
                int r6 = r10.u
                int r6 = r11.getResourceId(r5, r6)
                r10.u = r6
                if (r6 != r0) goto L_0x03a2
                int r5 = r11.getInt(r5, r0)
                r10.u = r5
                goto L_0x03a2
            L_0x028c:
                int r6 = r10.t
                int r6 = r11.getResourceId(r5, r6)
                r10.t = r6
                if (r6 != r0) goto L_0x03a2
                int r5 = r11.getInt(r5, r0)
                r10.t = r5
                goto L_0x03a2
            L_0x029e:
                int r6 = r10.s
                int r6 = r11.getResourceId(r5, r6)
                r10.s = r6
                if (r6 != r0) goto L_0x03a2
                int r5 = r11.getInt(r5, r0)
                r10.s = r5
                goto L_0x03a2
            L_0x02b0:
                int r6 = r10.f4638m
                int r6 = r11.getResourceId(r5, r6)
                r10.f4638m = r6
                if (r6 != r0) goto L_0x03a2
                int r5 = r11.getInt(r5, r0)
                r10.f4638m = r5
                goto L_0x03a2
            L_0x02c2:
                int r6 = r10.f4637l
                int r6 = r11.getResourceId(r5, r6)
                r10.f4637l = r6
                if (r6 != r0) goto L_0x03a2
                int r5 = r11.getInt(r5, r0)
                r10.f4637l = r5
                goto L_0x03a2
            L_0x02d4:
                int r6 = r10.f4636k
                int r6 = r11.getResourceId(r5, r6)
                r10.f4636k = r6
                if (r6 != r0) goto L_0x03a2
                int r5 = r11.getInt(r5, r0)
                r10.f4636k = r5
                goto L_0x03a2
            L_0x02e6:
                int r6 = r10.f4635j
                int r6 = r11.getResourceId(r5, r6)
                r10.f4635j = r6
                if (r6 != r0) goto L_0x03a2
                int r5 = r11.getInt(r5, r0)
                r10.f4635j = r5
                goto L_0x03a2
            L_0x02f8:
                int r6 = r10.f4634i
                int r6 = r11.getResourceId(r5, r6)
                r10.f4634i = r6
                if (r6 != r0) goto L_0x03a2
                int r5 = r11.getInt(r5, r0)
                r10.f4634i = r5
                goto L_0x03a2
            L_0x030a:
                int r6 = r10.f4633h
                int r6 = r11.getResourceId(r5, r6)
                r10.f4633h = r6
                if (r6 != r0) goto L_0x03a2
                int r5 = r11.getInt(r5, r0)
                r10.f4633h = r5
                goto L_0x03a2
            L_0x031c:
                int r6 = r10.f4632g
                int r6 = r11.getResourceId(r5, r6)
                r10.f4632g = r6
                if (r6 != r0) goto L_0x03a2
                int r5 = r11.getInt(r5, r0)
                r10.f4632g = r5
                goto L_0x03a2
            L_0x032e:
                int r6 = r10.f4631f
                int r6 = r11.getResourceId(r5, r6)
                r10.f4631f = r6
                if (r6 != r0) goto L_0x03a2
                int r5 = r11.getInt(r5, r0)
                r10.f4631f = r5
                goto L_0x03a2
            L_0x033f:
                int r6 = r10.f4630e
                int r6 = r11.getResourceId(r5, r6)
                r10.f4630e = r6
                if (r6 != r0) goto L_0x03a2
                int r5 = r11.getInt(r5, r0)
                r10.f4630e = r5
                goto L_0x03a2
            L_0x0350:
                float r6 = r10.f4628c
                float r5 = r11.getFloat(r5, r6)
                r10.f4628c = r5
                goto L_0x03a2
            L_0x0359:
                int r6 = r10.f4627b
                int r5 = r11.getDimensionPixelOffset(r5, r6)
                r10.f4627b = r5
                goto L_0x03a2
            L_0x0362:
                int r6 = r10.f4626a
                int r5 = r11.getDimensionPixelOffset(r5, r6)
                r10.f4626a = r5
                goto L_0x03a2
            L_0x036b:
                float r6 = r10.r
                float r5 = r11.getFloat(r5, r6)
                r6 = 1135869952(0x43b40000, float:360.0)
                float r5 = r5 % r6
                r10.r = r5
                int r7 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
                if (r7 >= 0) goto L_0x03a2
                float r5 = r6 - r5
                float r5 = r5 % r6
                r10.r = r5
                goto L_0x03a2
            L_0x0380:
                int r6 = r10.q
                int r5 = r11.getDimensionPixelSize(r5, r6)
                r10.q = r5
                goto L_0x03a2
            L_0x0389:
                int r6 = r10.p
                int r6 = r11.getResourceId(r5, r6)
                r10.p = r6
                if (r6 != r0) goto L_0x03a2
                int r5 = r11.getInt(r5, r0)
                r10.p = r5
                goto L_0x03a2
            L_0x039a:
                int r6 = r10.Z
                int r5 = r11.getInt(r5, r6)
                r10.Z = r5
            L_0x03a2:
                int r1 = r1 + 1
                goto L_0x00b0
            L_0x03a6:
                r11.recycle()
                r10.e()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.<init>(android.content.Context, android.util.AttributeSet):void");
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f4626a = layoutParams.f4626a;
            this.f4627b = layoutParams.f4627b;
            this.f4628c = layoutParams.f4628c;
            this.f4629d = layoutParams.f4629d;
            this.f4630e = layoutParams.f4630e;
            this.f4631f = layoutParams.f4631f;
            this.f4632g = layoutParams.f4632g;
            this.f4633h = layoutParams.f4633h;
            this.f4634i = layoutParams.f4634i;
            this.f4635j = layoutParams.f4635j;
            this.f4636k = layoutParams.f4636k;
            this.f4637l = layoutParams.f4637l;
            this.f4638m = layoutParams.f4638m;
            this.f4639n = layoutParams.f4639n;
            this.o = layoutParams.o;
            this.p = layoutParams.p;
            this.q = layoutParams.q;
            this.r = layoutParams.r;
            this.s = layoutParams.s;
            this.t = layoutParams.t;
            this.u = layoutParams.u;
            this.v = layoutParams.v;
            this.w = layoutParams.w;
            this.x = layoutParams.x;
            this.y = layoutParams.y;
            this.z = layoutParams.z;
            this.A = layoutParams.A;
            this.B = layoutParams.B;
            this.C = layoutParams.C;
            this.D = layoutParams.D;
            this.G = layoutParams.G;
            this.H = layoutParams.H;
            this.I = layoutParams.I;
            this.J = layoutParams.J;
            this.K = layoutParams.K;
            this.L = layoutParams.L;
            this.M = layoutParams.M;
            this.N = layoutParams.N;
            this.O = layoutParams.O;
            this.a0 = layoutParams.a0;
            this.b0 = layoutParams.b0;
            this.P = layoutParams.P;
            this.Q = layoutParams.Q;
            this.R = layoutParams.R;
            this.T = layoutParams.T;
            this.S = layoutParams.S;
            this.U = layoutParams.U;
            this.V = layoutParams.V;
            this.W = layoutParams.W;
            this.X = layoutParams.X;
            this.Y = layoutParams.Y;
            this.Z = layoutParams.Z;
            this.e0 = layoutParams.e0;
            this.f0 = layoutParams.f0;
            this.g0 = layoutParams.g0;
            this.h0 = layoutParams.h0;
            this.l0 = layoutParams.l0;
            this.m0 = layoutParams.m0;
            this.n0 = layoutParams.n0;
            this.o0 = layoutParams.o0;
            this.p0 = layoutParams.p0;
            this.q0 = layoutParams.q0;
            this.r0 = layoutParams.r0;
            this.c0 = layoutParams.c0;
            this.d0 = layoutParams.d0;
            this.v0 = layoutParams.v0;
            this.E = layoutParams.E;
            this.F = layoutParams.F;
        }
    }

    class Measurer implements BasicMeasure.Measurer {

        /* renamed from: a  reason: collision with root package name */
        ConstraintLayout f4654a;

        /* renamed from: b  reason: collision with root package name */
        int f4655b;

        /* renamed from: c  reason: collision with root package name */
        int f4656c;

        /* renamed from: d  reason: collision with root package name */
        int f4657d;

        /* renamed from: e  reason: collision with root package name */
        int f4658e;

        /* renamed from: f  reason: collision with root package name */
        int f4659f;

        /* renamed from: g  reason: collision with root package name */
        int f4660g;

        public Measurer(ConstraintLayout constraintLayout) {
            this.f4654a = constraintLayout;
        }

        private boolean d(int i2, int i3, int i4) {
            if (i2 == i3) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i2);
            View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i4 == size;
            }
            return false;
        }

        public final void a() {
            int childCount = this.f4654a.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f4654a.getChildAt(i2);
                if (childAt instanceof Placeholder) {
                    ((Placeholder) childAt).b(this.f4654a);
                }
            }
            int size = this.f4654a.X2.size();
            if (size > 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    ((ConstraintHelper) this.f4654a.X2.get(i3)).E(this.f4654a);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:100:0x0196  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00b4  */
        /* JADX WARNING: Removed duplicated region for block: B:98:0x0183  */
        @android.annotation.SuppressLint({"WrongCall"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b(androidx.constraintlayout.core.widgets.ConstraintWidget r18, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure r19) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                r2 = r19
                if (r1 != 0) goto L_0x0009
                return
            L_0x0009:
                int r3 = r18.l0()
                r4 = 8
                r5 = 0
                if (r3 != r4) goto L_0x001f
                boolean r3 = r18.C0()
                if (r3 != 0) goto L_0x001f
                r2.f4255e = r5
                r2.f4256f = r5
                r2.f4257g = r5
                return
            L_0x001f:
                androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r18.U()
                if (r3 != 0) goto L_0x0026
                return
            L_0x0026:
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = r2.f4251a
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = r2.f4252b
                int r6 = r2.f4253c
                int r7 = r2.f4254d
                int r8 = r0.f4655b
                int r9 = r0.f4656c
                int r8 = r8 + r9
                int r9 = r0.f4657d
                java.lang.Object r10 = r18.w()
                android.view.View r10 = (android.view.View) r10
                int[] r11 = androidx.constraintlayout.widget.ConstraintLayout.AnonymousClass1.f4625a
                int r12 = r3.ordinal()
                r12 = r11[r12]
                r13 = 4
                r14 = 3
                r15 = 2
                r5 = 1
                if (r12 == r5) goto L_0x0090
                if (r12 == r15) goto L_0x00a6
                if (r12 == r14) goto L_0x0097
                if (r12 == r13) goto L_0x0051
                r6 = 0
                goto L_0x00ac
            L_0x0051:
                int r6 = r0.f4659f
                r12 = -2
                int r6 = android.view.ViewGroup.getChildMeasureSpec(r6, r9, r12)
                int r9 = r1.w
                if (r9 != r5) goto L_0x005e
                r9 = 1
                goto L_0x005f
            L_0x005e:
                r9 = 0
            L_0x005f:
                int r12 = r2.f4260j
                int r13 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f4249l
                if (r12 == r13) goto L_0x0069
                int r13 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f4250m
                if (r12 != r13) goto L_0x00ac
            L_0x0069:
                int r12 = r10.getMeasuredHeight()
                int r13 = r18.D()
                if (r12 != r13) goto L_0x0075
                r12 = 1
                goto L_0x0076
            L_0x0075:
                r12 = 0
            L_0x0076:
                int r13 = r2.f4260j
                int r14 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f4250m
                if (r13 == r14) goto L_0x008c
                if (r9 == 0) goto L_0x008c
                if (r9 == 0) goto L_0x0082
                if (r12 != 0) goto L_0x008c
            L_0x0082:
                boolean r9 = r10 instanceof androidx.constraintlayout.widget.Placeholder
                if (r9 != 0) goto L_0x008c
                boolean r9 = r18.G0()
                if (r9 == 0) goto L_0x00ac
            L_0x008c:
                int r6 = r18.m0()
            L_0x0090:
                r12 = 1073741824(0x40000000, float:2.0)
                int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r12)
                goto L_0x00ac
            L_0x0097:
                r12 = 1073741824(0x40000000, float:2.0)
                int r6 = r0.f4659f
                int r13 = r18.I()
                int r9 = r9 + r13
                r13 = -1
            L_0x00a1:
                int r6 = android.view.ViewGroup.getChildMeasureSpec(r6, r9, r13)
                goto L_0x00ac
            L_0x00a6:
                r12 = 1073741824(0x40000000, float:2.0)
                int r6 = r0.f4659f
                r13 = -2
                goto L_0x00a1
            L_0x00ac:
                int r9 = r4.ordinal()
                r9 = r11[r9]
                if (r9 == r5) goto L_0x00fd
                if (r9 == r15) goto L_0x0113
                r7 = 3
                if (r9 == r7) goto L_0x0104
                r7 = 4
                if (r9 == r7) goto L_0x00be
                r7 = 0
                goto L_0x0119
            L_0x00be:
                int r7 = r0.f4660g
                r9 = -2
                int r7 = android.view.ViewGroup.getChildMeasureSpec(r7, r8, r9)
                int r8 = r1.x
                if (r8 != r5) goto L_0x00cb
                r8 = 1
                goto L_0x00cc
            L_0x00cb:
                r8 = 0
            L_0x00cc:
                int r9 = r2.f4260j
                int r11 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f4249l
                if (r9 == r11) goto L_0x00d6
                int r11 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f4250m
                if (r9 != r11) goto L_0x0119
            L_0x00d6:
                int r9 = r10.getMeasuredWidth()
                int r11 = r18.m0()
                if (r9 != r11) goto L_0x00e2
                r9 = 1
                goto L_0x00e3
            L_0x00e2:
                r9 = 0
            L_0x00e3:
                int r11 = r2.f4260j
                int r12 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f4250m
                if (r11 == r12) goto L_0x00f9
                if (r8 == 0) goto L_0x00f9
                if (r8 == 0) goto L_0x00ef
                if (r9 != 0) goto L_0x00f9
            L_0x00ef:
                boolean r8 = r10 instanceof androidx.constraintlayout.widget.Placeholder
                if (r8 != 0) goto L_0x00f9
                boolean r8 = r18.H0()
                if (r8 == 0) goto L_0x0119
            L_0x00f9:
                int r7 = r18.D()
            L_0x00fd:
                r9 = 1073741824(0x40000000, float:2.0)
                int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r9)
                goto L_0x0119
            L_0x0104:
                r9 = 1073741824(0x40000000, float:2.0)
                int r7 = r0.f4660g
                int r11 = r18.k0()
                int r8 = r8 + r11
                r11 = -1
            L_0x010e:
                int r7 = android.view.ViewGroup.getChildMeasureSpec(r7, r8, r11)
                goto L_0x0119
            L_0x0113:
                r9 = 1073741824(0x40000000, float:2.0)
                int r7 = r0.f4660g
                r11 = -2
                goto L_0x010e
            L_0x0119:
                androidx.constraintlayout.core.widgets.ConstraintWidget r8 = r18.U()
                androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r8 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r8
                if (r8 == 0) goto L_0x0196
                androidx.constraintlayout.widget.ConstraintLayout r9 = androidx.constraintlayout.widget.ConstraintLayout.this
                int r9 = r9.e3
                r11 = 256(0x100, float:3.59E-43)
                boolean r9 = androidx.constraintlayout.core.widgets.Optimizer.b(r9, r11)
                if (r9 == 0) goto L_0x0196
                int r9 = r10.getMeasuredWidth()
                int r11 = r18.m0()
                if (r9 != r11) goto L_0x0196
                int r9 = r10.getMeasuredWidth()
                int r11 = r8.m0()
                if (r9 >= r11) goto L_0x0196
                int r9 = r10.getMeasuredHeight()
                int r11 = r18.D()
                if (r9 != r11) goto L_0x0196
                int r9 = r10.getMeasuredHeight()
                int r8 = r8.D()
                if (r9 >= r8) goto L_0x0196
                int r8 = r10.getBaseline()
                int r9 = r18.t()
                if (r8 != r9) goto L_0x0196
                boolean r8 = r18.F0()
                if (r8 != 0) goto L_0x0196
                int r8 = r18.J()
                int r9 = r18.m0()
                boolean r8 = r0.d(r8, r6, r9)
                if (r8 == 0) goto L_0x0196
                int r8 = r18.K()
                int r9 = r18.D()
                boolean r8 = r0.d(r8, r7, r9)
                if (r8 == 0) goto L_0x0196
                int r3 = r18.m0()
                r2.f4255e = r3
                int r3 = r18.D()
                r2.f4256f = r3
                int r1 = r18.t()
                r2.f4257g = r1
                return
            L_0x0196:
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
                if (r3 != r8) goto L_0x019c
                r9 = 1
                goto L_0x019d
            L_0x019c:
                r9 = 0
            L_0x019d:
                if (r4 != r8) goto L_0x01a1
                r8 = 1
                goto L_0x01a2
            L_0x01a1:
                r8 = 0
            L_0x01a2:
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
                if (r4 == r11) goto L_0x01ad
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
                if (r4 != r12) goto L_0x01ab
                goto L_0x01ad
            L_0x01ab:
                r4 = 0
                goto L_0x01ae
            L_0x01ad:
                r4 = 1
            L_0x01ae:
                if (r3 == r11) goto L_0x01b7
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
                if (r3 != r11) goto L_0x01b5
                goto L_0x01b7
            L_0x01b5:
                r3 = 0
                goto L_0x01b8
            L_0x01b7:
                r3 = 1
            L_0x01b8:
                r11 = 0
                if (r9 == 0) goto L_0x01c3
                float r12 = r1.f0
                int r12 = (r12 > r11 ? 1 : (r12 == r11 ? 0 : -1))
                if (r12 <= 0) goto L_0x01c3
                r12 = 1
                goto L_0x01c4
            L_0x01c3:
                r12 = 0
            L_0x01c4:
                if (r8 == 0) goto L_0x01ce
                float r13 = r1.f0
                int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                if (r11 <= 0) goto L_0x01ce
                r11 = 1
                goto L_0x01cf
            L_0x01ce:
                r11 = 0
            L_0x01cf:
                if (r10 != 0) goto L_0x01d2
                return
            L_0x01d2:
                android.view.ViewGroup$LayoutParams r13 = r10.getLayoutParams()
                androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r13 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r13
                int r14 = r2.f4260j
                int r15 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f4249l
                if (r14 == r15) goto L_0x01f5
                int r15 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f4250m
                if (r14 == r15) goto L_0x01f5
                if (r9 == 0) goto L_0x01f5
                int r9 = r1.w
                if (r9 != 0) goto L_0x01f5
                if (r8 == 0) goto L_0x01f5
                int r8 = r1.x
                if (r8 == 0) goto L_0x01ef
                goto L_0x01f5
            L_0x01ef:
                r0 = -1
                r5 = 0
                r14 = 0
                r15 = 0
                goto L_0x0291
            L_0x01f5:
                boolean r8 = r10 instanceof androidx.constraintlayout.widget.VirtualLayout
                if (r8 == 0) goto L_0x0207
                boolean r8 = r1 instanceof androidx.constraintlayout.core.widgets.VirtualLayout
                if (r8 == 0) goto L_0x0207
                r8 = r1
                androidx.constraintlayout.core.widgets.VirtualLayout r8 = (androidx.constraintlayout.core.widgets.VirtualLayout) r8
                r9 = r10
                androidx.constraintlayout.widget.VirtualLayout r9 = (androidx.constraintlayout.widget.VirtualLayout) r9
                r9.J(r8, r6, r7)
                goto L_0x020a
            L_0x0207:
                r10.measure(r6, r7)
            L_0x020a:
                r1.J1(r6, r7)
                int r8 = r10.getMeasuredWidth()
                int r9 = r10.getMeasuredHeight()
                int r14 = r10.getBaseline()
                int r15 = r1.z
                if (r15 <= 0) goto L_0x0222
                int r15 = java.lang.Math.max(r15, r8)
                goto L_0x0223
            L_0x0222:
                r15 = r8
            L_0x0223:
                int r5 = r1.A
                if (r5 <= 0) goto L_0x022b
                int r15 = java.lang.Math.min(r5, r15)
            L_0x022b:
                int r5 = r1.C
                if (r5 <= 0) goto L_0x0236
                int r5 = java.lang.Math.max(r5, r9)
                r16 = r6
                goto L_0x0239
            L_0x0236:
                r16 = r6
                r5 = r9
            L_0x0239:
                int r6 = r1.D
                if (r6 <= 0) goto L_0x0241
                int r5 = java.lang.Math.min(r6, r5)
            L_0x0241:
                androidx.constraintlayout.widget.ConstraintLayout r6 = androidx.constraintlayout.widget.ConstraintLayout.this
                int r6 = r6.e3
                r0 = 1
                boolean r6 = androidx.constraintlayout.core.widgets.Optimizer.b(r6, r0)
                if (r6 != 0) goto L_0x0266
                r0 = 1056964608(0x3f000000, float:0.5)
                if (r12 == 0) goto L_0x025c
                if (r4 == 0) goto L_0x025c
                float r3 = r1.f0
                float r4 = (float) r5
                float r4 = r4 * r3
                float r4 = r4 + r0
                int r15 = (int) r4
                goto L_0x0266
            L_0x025c:
                if (r11 == 0) goto L_0x0266
                if (r3 == 0) goto L_0x0266
                float r3 = r1.f0
                float r4 = (float) r15
                float r4 = r4 / r3
                float r4 = r4 + r0
                int r5 = (int) r4
            L_0x0266:
                if (r8 != r15) goto L_0x026d
                if (r9 == r5) goto L_0x026b
                goto L_0x026d
            L_0x026b:
                r0 = -1
                goto L_0x0291
            L_0x026d:
                r0 = 1073741824(0x40000000, float:2.0)
                if (r8 == r15) goto L_0x0276
                int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r0)
                goto L_0x0278
            L_0x0276:
                r6 = r16
            L_0x0278:
                if (r9 == r5) goto L_0x027e
                int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r0)
            L_0x027e:
                r10.measure(r6, r7)
                r1.J1(r6, r7)
                int r15 = r10.getMeasuredWidth()
                int r5 = r10.getMeasuredHeight()
                int r14 = r10.getBaseline()
                goto L_0x026b
            L_0x0291:
                if (r14 == r0) goto L_0x0295
                r0 = 1
                goto L_0x0296
            L_0x0295:
                r0 = 0
            L_0x0296:
                int r3 = r2.f4253c
                if (r15 != r3) goto L_0x02a1
                int r3 = r2.f4254d
                if (r5 == r3) goto L_0x029f
                goto L_0x02a1
            L_0x029f:
                r3 = 0
                goto L_0x02a2
            L_0x02a1:
                r3 = 1
            L_0x02a2:
                r2.f4259i = r3
                boolean r3 = r13.g0
                if (r3 == 0) goto L_0x02a9
                r0 = 1
            L_0x02a9:
                if (r0 == 0) goto L_0x02b7
                r3 = -1
                if (r14 == r3) goto L_0x02b7
                int r1 = r18.t()
                if (r1 == r14) goto L_0x02b7
                r1 = 1
                r2.f4259i = r1
            L_0x02b7:
                r2.f4255e = r15
                r2.f4256f = r5
                r2.f4258h = r0
                r2.f4257g = r14
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.Measurer.b(androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure):void");
        }

        public void c(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f4655b = i4;
            this.f4656c = i5;
            this.f4657d = i6;
            this.f4658e = i7;
            this.f4659f = i2;
            this.f4660g = i3;
        }
    }

    public ConstraintLayout(@NonNull Context context) {
        super(context);
        v((AttributeSet) null, 0, 0);
    }

    private void C() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ConstraintWidget p = p(getChildAt(i2));
            if (p != null) {
                p.R0();
            }
        }
        if (isInEditMode) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    D(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    n(childAt.getId()).j1(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.h3 != -1) {
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt2 = getChildAt(i5);
                if (childAt2.getId() == this.h3 && (childAt2 instanceof Constraints)) {
                    this.f3 = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        ConstraintSet constraintSet = this.f3;
        if (constraintSet != null) {
            constraintSet.t(this, true);
        }
        this.Y2.p2();
        int size = this.X2.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.X2.get(i6).H(this);
            }
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt3 = getChildAt(i7);
            if (childAt3 instanceof Placeholder) {
                ((Placeholder) childAt3).c(this);
            }
        }
        this.p3.clear();
        this.p3.put(0, this.Y2);
        this.p3.put(getId(), this.Y2);
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt4 = getChildAt(i8);
            this.p3.put(childAt4.getId(), p(childAt4));
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt5 = getChildAt(i9);
            ConstraintWidget p2 = p(childAt5);
            if (p2 != null) {
                this.Y2.b(p2);
                i(isInEditMode, childAt5, p2, (LayoutParams) childAt5.getLayoutParams(), this.p3);
            }
        }
    }

    private void G(ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray, int i2, ConstraintAnchor.Type type) {
        View view = this.s.get(i2);
        ConstraintWidget constraintWidget2 = sparseArray.get(i2);
        if (constraintWidget2 != null && view != null && (view.getLayoutParams() instanceof LayoutParams)) {
            layoutParams.g0 = true;
            ConstraintAnchor.Type type2 = ConstraintAnchor.Type.BASELINE;
            if (type == type2) {
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                layoutParams2.g0 = true;
                layoutParams2.v0.x1(true);
            }
            constraintWidget.r(type2).b(constraintWidget2.r(type), layoutParams.D, layoutParams.C, true);
            constraintWidget.x1(true);
            constraintWidget.r(ConstraintAnchor.Type.TOP).x();
            constraintWidget.r(ConstraintAnchor.Type.BOTTOM).x();
        }
    }

    private boolean H() {
        int childCount = getChildCount();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            } else if (getChildAt(i2).isLayoutRequested()) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            C();
        }
        return z;
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int max2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        return max2 > 0 ? max2 : max;
    }

    public static SharedValues getSharedValues() {
        if (D3 == null) {
            D3 = new SharedValues();
        }
        return D3;
    }

    private final ConstraintWidget n(int i2) {
        if (i2 == 0) {
            return this.Y2;
        }
        View view = this.s.get(i2);
        if (view == null && (view = findViewById(i2)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.Y2;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).v0;
    }

    private void v(AttributeSet attributeSet, int i2, int i4) {
        this.Y2.h1(this);
        this.Y2.U2(this.s3);
        this.s.put(getId(), this);
        this.f3 = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.y6, i2, i4);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == R.styleable.P6) {
                    this.Z2 = obtainStyledAttributes.getDimensionPixelOffset(index, this.Z2);
                } else if (index == R.styleable.Q6) {
                    this.a3 = obtainStyledAttributes.getDimensionPixelOffset(index, this.a3);
                } else if (index == R.styleable.N6) {
                    this.b3 = obtainStyledAttributes.getDimensionPixelOffset(index, this.b3);
                } else if (index == R.styleable.O6) {
                    this.c3 = obtainStyledAttributes.getDimensionPixelOffset(index, this.c3);
                } else if (index == R.styleable.I8) {
                    this.e3 = obtainStyledAttributes.getInt(index, this.e3);
                } else if (index == R.styleable.D7) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            z(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.g3 = null;
                        }
                    }
                } else if (index == R.styleable.h7) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f3 = constraintSet;
                        constraintSet.w0(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f3 = null;
                    }
                    this.h3 = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.Y2.V2(this.e3);
    }

    private void y() {
        this.d3 = true;
        this.j3 = -1;
        this.k3 = -1;
        this.l3 = -1;
        this.m3 = -1;
        this.n3 = 0;
        this.o3 = 0;
    }

    /* access modifiers changed from: protected */
    public void A(int i2, int i4, int i5, int i6, boolean z, boolean z2) {
        Measurer measurer = this.s3;
        int i7 = measurer.f4658e;
        int resolveSizeAndState = View.resolveSizeAndState(i5 + measurer.f4657d, i2, 0);
        int resolveSizeAndState2 = View.resolveSizeAndState(i6 + i7, i4, 0);
        int i8 = resolveSizeAndState & ViewCompat.x;
        int i9 = resolveSizeAndState2 & ViewCompat.x;
        int min = Math.min(this.b3, i8);
        int min2 = Math.min(this.c3, i9);
        if (z) {
            min |= 16777216;
        }
        if (z2) {
            min2 |= 16777216;
        }
        setMeasuredDimension(min, min2);
        this.j3 = min;
        this.k3 = min2;
    }

    /* access modifiers changed from: protected */
    public void B(ConstraintWidgetContainer constraintWidgetContainer, int i2, int i4, int i5) {
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        int mode2 = View.MeasureSpec.getMode(i5);
        int size2 = View.MeasureSpec.getSize(i5);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i6 = max + max2;
        int paddingWidth = getPaddingWidth();
        this.s3.c(i4, i5, max, max2, paddingWidth, i6);
        int max3 = Math.max(0, getPaddingStart());
        int max4 = Math.max(0, getPaddingEnd());
        int max5 = (max3 > 0 || max4 > 0) ? w() ? max4 : max3 : Math.max(0, getPaddingLeft());
        int i7 = size - paddingWidth;
        int i8 = size2 - i6;
        E(constraintWidgetContainer, mode, i7, mode2, i8);
        constraintWidgetContainer.Q2(i2, mode, i7, mode2, i8, this.j3, this.k3, max5, max);
    }

    public void D(int i2, Object obj, Object obj2) {
        if (i2 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.i3 == null) {
                this.i3 = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            Integer num = (Integer) obj2;
            num.intValue();
            this.i3.put(str, num);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (r3 == 0) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0045, code lost:
        if (r3 == 0) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0050, code lost:
        if (r3 == 0) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
        if (r3 == 0) goto L_0x0027;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void E(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r8, int r9, int r10, int r11, int r12) {
        /*
            r7 = this;
            androidx.constraintlayout.widget.ConstraintLayout$Measurer r0 = r7.s3
            int r1 = r0.f4658e
            int r0 = r0.f4657d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            int r3 = r7.getChildCount()
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 0
            if (r9 == r5) goto L_0x002e
            if (r9 == 0) goto L_0x0023
            if (r9 == r4) goto L_0x001a
            r9 = r2
        L_0x0018:
            r10 = 0
            goto L_0x0033
        L_0x001a:
            int r9 = r7.b3
            int r9 = r9 - r0
            int r10 = java.lang.Math.min(r9, r10)
            r9 = r2
            goto L_0x0033
        L_0x0023:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != 0) goto L_0x0018
        L_0x0027:
            int r10 = r7.Z2
            int r10 = java.lang.Math.max(r6, r10)
            goto L_0x0033
        L_0x002e:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != 0) goto L_0x0033
            goto L_0x0027
        L_0x0033:
            if (r11 == r5) goto L_0x004e
            if (r11 == 0) goto L_0x0043
            if (r11 == r4) goto L_0x003b
        L_0x0039:
            r12 = 0
            goto L_0x0053
        L_0x003b:
            int r11 = r7.c3
            int r11 = r11 - r1
            int r12 = java.lang.Math.min(r11, r12)
            goto L_0x0053
        L_0x0043:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != 0) goto L_0x0039
        L_0x0047:
            int r11 = r7.a3
            int r12 = java.lang.Math.max(r6, r11)
            goto L_0x0053
        L_0x004e:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != 0) goto L_0x0053
            goto L_0x0047
        L_0x0053:
            int r11 = r8.m0()
            if (r10 != r11) goto L_0x005f
            int r11 = r8.D()
            if (r12 == r11) goto L_0x0062
        L_0x005f:
            r8.M2()
        L_0x0062:
            r8.f2(r6)
            r8.g2(r6)
            int r11 = r7.b3
            int r11 = r11 - r0
            r8.M1(r11)
            int r11 = r7.c3
            int r11 = r11 - r1
            r8.L1(r11)
            r8.P1(r6)
            r8.O1(r6)
            r8.D1(r9)
            r8.c2(r10)
            r8.Y1(r2)
            r8.y1(r12)
            int r9 = r7.Z2
            int r9 = r9 - r0
            r8.P1(r9)
            int r9 = r7.a3
            int r9 = r9 - r1
            r8.O1(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.E(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, int, int, int, int):void");
    }

    public void F(int i2, int i4, int i5) {
        ConstraintLayoutStates constraintLayoutStates = this.g3;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.e(i2, (float) i4, (float) i5);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<ConstraintHelper> arrayList = this.X2;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.X2.get(i2).F(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = (float) getWidth();
            float height = (float) getHeight();
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i5 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i6 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(SupportMenu.f5941c);
                        float f2 = (float) i5;
                        float f4 = (float) i6;
                        float f5 = (float) (i5 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        Canvas canvas2 = canvas;
                        float f6 = f4;
                        float f7 = f4;
                        float f8 = f5;
                        float f9 = f2;
                        Paint paint2 = paint;
                        canvas2.drawLine(f2, f6, f8, f7, paint);
                        float parseInt4 = (float) (i6 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        float f10 = f5;
                        float f11 = parseInt4;
                        canvas2.drawLine(f10, f7, f8, f11, paint);
                        float f12 = parseInt4;
                        float f13 = f9;
                        canvas2.drawLine(f10, f12, f13, f11, paint);
                        float f14 = f9;
                        canvas2.drawLine(f14, f12, f13, f7, paint);
                        paint.setColor(-16711936);
                        float f15 = f5;
                        Paint paint3 = paint;
                        canvas2.drawLine(f14, f7, f15, parseInt4, paint);
                        canvas2.drawLine(f14, parseInt4, f15, f7, paint);
                    }
                }
            }
        }
    }

    public void forceLayout() {
        y();
        super.forceLayout();
    }

    public int getMaxHeight() {
        return this.c3;
    }

    public int getMaxWidth() {
        return this.b3;
    }

    public int getMinHeight() {
        return this.a3;
    }

    public int getMinWidth() {
        return this.Z2;
    }

    public int getOptimizationLevel() {
        return this.Y2.H2();
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        if (this.Y2.o == null) {
            int id2 = getId();
            if (id2 != -1) {
                this.Y2.o = getContext().getResources().getResourceEntryName(id2);
            } else {
                this.Y2.o = "parent";
            }
        }
        if (this.Y2.y() == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.Y2;
            constraintWidgetContainer.j1(constraintWidgetContainer.o);
            Log.v(w3, " setDebugName " + this.Y2.y());
        }
        Iterator<ConstraintWidget> it2 = this.Y2.l2().iterator();
        while (it2.hasNext()) {
            ConstraintWidget next = it2.next();
            View view = (View) next.w();
            if (view != null) {
                if (next.o == null && (id = view.getId()) != -1) {
                    next.o = getContext().getResources().getResourceEntryName(id);
                }
                if (next.y() == null) {
                    next.j1(next.o);
                    Log.v(w3, " setDebugName " + next.y());
                }
            }
        }
        this.Y2.b0(sb);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0166  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i(boolean r17, android.view.View r18, androidx.constraintlayout.core.widgets.ConstraintWidget r19, androidx.constraintlayout.widget.ConstraintLayout.LayoutParams r20, android.util.SparseArray<androidx.constraintlayout.core.widgets.ConstraintWidget> r21) {
        /*
            r16 = this;
            r0 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r20.e()
            r9 = 0
            r7.w0 = r9
            int r1 = r18.getVisibility()
            r6.b2(r1)
            boolean r1 = r7.j0
            if (r1 == 0) goto L_0x0022
            r1 = 1
            r6.H1(r1)
            r1 = 8
            r6.b2(r1)
        L_0x0022:
            r6.h1(r0)
            boolean r1 = r0 instanceof androidx.constraintlayout.widget.ConstraintHelper
            if (r1 == 0) goto L_0x0037
            androidx.constraintlayout.widget.ConstraintHelper r0 = (androidx.constraintlayout.widget.ConstraintHelper) r0
            r10 = r16
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = r10.Y2
            boolean r1 = r1.O2()
            r0.B(r6, r1)
            goto L_0x0039
        L_0x0037:
            r10 = r16
        L_0x0039:
            boolean r0 = r7.h0
            r11 = -1
            if (r0 == 0) goto L_0x0060
            r0 = r6
            androidx.constraintlayout.core.widgets.Guideline r0 = (androidx.constraintlayout.core.widgets.Guideline) r0
            int r1 = r7.s0
            int r2 = r7.t0
            float r3 = r7.u0
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0052
            r0.y2(r3)
            goto L_0x0239
        L_0x0052:
            if (r1 == r11) goto L_0x0059
            r0.w2(r1)
            goto L_0x0239
        L_0x0059:
            if (r2 == r11) goto L_0x0239
            r0.x2(r2)
            goto L_0x0239
        L_0x0060:
            int r0 = r7.l0
            int r1 = r7.m0
            int r12 = r7.n0
            int r13 = r7.o0
            int r5 = r7.p0
            int r14 = r7.q0
            float r15 = r7.r0
            int r2 = r7.p
            if (r2 == r11) goto L_0x0083
            java.lang.Object r0 = r8.get(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r0
            if (r0 == 0) goto L_0x0169
            float r1 = r7.r
            int r2 = r7.q
            r6.m(r0, r1, r2)
            goto L_0x0169
        L_0x0083:
            if (r0 == r11) goto L_0x0096
            java.lang.Object r0 = r8.get(r0)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x00ac
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            int r4 = r7.leftMargin
            r0 = r19
            r1 = r3
            goto L_0x00a9
        L_0x0096:
            if (r1 == r11) goto L_0x00ac
            java.lang.Object r0 = r8.get(r1)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x00ac
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            int r4 = r7.leftMargin
            r0 = r19
        L_0x00a9:
            r0.v0(r1, r2, r3, r4, r5)
        L_0x00ac:
            if (r12 == r11) goto L_0x00c0
            java.lang.Object r0 = r8.get(r12)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x00d6
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            int r4 = r7.rightMargin
            r0 = r19
            goto L_0x00d2
        L_0x00c0:
            if (r13 == r11) goto L_0x00d6
            java.lang.Object r0 = r8.get(r13)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x00d6
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            int r4 = r7.rightMargin
            r0 = r19
            r1 = r3
        L_0x00d2:
            r5 = r14
            r0.v0(r1, r2, r3, r4, r5)
        L_0x00d6:
            int r0 = r7.f4634i
            if (r0 == r11) goto L_0x00ed
            java.lang.Object r0 = r8.get(r0)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x0107
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            int r4 = r7.topMargin
            int r5 = r7.x
            r0 = r19
            r1 = r3
            goto L_0x0104
        L_0x00ed:
            int r0 = r7.f4635j
            if (r0 == r11) goto L_0x0107
            java.lang.Object r0 = r8.get(r0)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x0107
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            int r4 = r7.topMargin
            int r5 = r7.x
            r0 = r19
        L_0x0104:
            r0.v0(r1, r2, r3, r4, r5)
        L_0x0107:
            int r0 = r7.f4636k
            if (r0 == r11) goto L_0x011f
            java.lang.Object r0 = r8.get(r0)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x0138
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            int r4 = r7.bottomMargin
            int r5 = r7.z
            r0 = r19
            goto L_0x0135
        L_0x011f:
            int r0 = r7.f4637l
            if (r0 == r11) goto L_0x0138
            java.lang.Object r0 = r8.get(r0)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x0138
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            int r4 = r7.bottomMargin
            int r5 = r7.z
            r0 = r19
            r1 = r3
        L_0x0135:
            r0.v0(r1, r2, r3, r4, r5)
        L_0x0138:
            int r4 = r7.f4638m
            if (r4 == r11) goto L_0x014a
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE
        L_0x013e:
            r0 = r16
            r1 = r19
            r2 = r20
            r3 = r21
            r0.G(r1, r2, r3, r4, r5)
            goto L_0x0158
        L_0x014a:
            int r4 = r7.f4639n
            if (r4 == r11) goto L_0x0151
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            goto L_0x013e
        L_0x0151:
            int r4 = r7.o
            if (r4 == r11) goto L_0x0158
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            goto L_0x013e
        L_0x0158:
            r0 = 0
            int r1 = (r15 > r0 ? 1 : (r15 == r0 ? 0 : -1))
            if (r1 < 0) goto L_0x0160
            r6.A1(r15)
        L_0x0160:
            float r1 = r7.H
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x0169
            r6.V1(r1)
        L_0x0169:
            if (r17 == 0) goto L_0x0178
            int r0 = r7.X
            if (r0 != r11) goto L_0x0173
            int r1 = r7.Y
            if (r1 == r11) goto L_0x0178
        L_0x0173:
            int r1 = r7.Y
            r6.R1(r0, r1)
        L_0x0178:
            boolean r0 = r7.e0
            r1 = -2
            if (r0 != 0) goto L_0x01ac
            int r0 = r7.width
            if (r0 != r11) goto L_0x01a3
            boolean r0 = r7.a0
            if (r0 == 0) goto L_0x018b
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
        L_0x0187:
            r6.D1(r0)
            goto L_0x018e
        L_0x018b:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            goto L_0x0187
        L_0x018e:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r6.r(r0)
            int r2 = r7.leftMargin
            r0.f4184g = r2
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r6.r(r0)
            int r2 = r7.rightMargin
            r0.f4184g = r2
            goto L_0x01bf
        L_0x01a3:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r6.D1(r0)
            r6.c2(r9)
            goto L_0x01bf
        L_0x01ac:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r6.D1(r0)
            int r0 = r7.width
            r6.c2(r0)
            int r0 = r7.width
            if (r0 != r1) goto L_0x01bf
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r6.D1(r0)
        L_0x01bf:
            boolean r0 = r7.f0
            if (r0 != 0) goto L_0x01f2
            int r0 = r7.height
            if (r0 != r11) goto L_0x01e9
            boolean r0 = r7.b0
            if (r0 == 0) goto L_0x01d1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
        L_0x01cd:
            r6.Y1(r0)
            goto L_0x01d4
        L_0x01d1:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            goto L_0x01cd
        L_0x01d4:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r6.r(r0)
            int r1 = r7.topMargin
            r0.f4184g = r1
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r6.r(r0)
            int r1 = r7.bottomMargin
            r0.f4184g = r1
            goto L_0x0205
        L_0x01e9:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r6.Y1(r0)
            r6.y1(r9)
            goto L_0x0205
        L_0x01f2:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r6.Y1(r0)
            int r0 = r7.height
            r6.y1(r0)
            int r0 = r7.height
            if (r0 != r1) goto L_0x0205
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r6.Y1(r0)
        L_0x0205:
            java.lang.String r0 = r7.I
            r6.n1(r0)
            float r0 = r7.L
            r6.F1(r0)
            float r0 = r7.M
            r6.a2(r0)
            int r0 = r7.N
            r6.B1(r0)
            int r0 = r7.O
            r6.W1(r0)
            int r0 = r7.d0
            r6.e2(r0)
            int r0 = r7.P
            int r1 = r7.R
            int r2 = r7.T
            float r3 = r7.V
            r6.E1(r0, r1, r2, r3)
            int r0 = r7.Q
            int r1 = r7.S
            int r2 = r7.U
            float r3 = r7.W
            r6.Z1(r0, r1, r2, r3)
        L_0x0239:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.i(boolean, android.view.View, androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.widget.ConstraintLayout$LayoutParams, android.util.SparseArray):void");
    }

    public void j(Metrics metrics) {
        this.r3 = metrics;
        this.Y2.E2(metrics);
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* renamed from: l */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public Object m(int i2, Object obj) {
        if (i2 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.i3;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.i3.get(str);
    }

    public View o(int i2) {
        return this.s.get(i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.v0;
            if ((childAt.getVisibility() != 8 || layoutParams.h0 || layoutParams.i0 || layoutParams.k0 || isInEditMode) && !layoutParams.j0) {
                int o0 = constraintWidget.o0();
                int p0 = constraintWidget.p0();
                int m0 = constraintWidget.m0() + o0;
                int D = constraintWidget.D() + p0;
                childAt.layout(o0, p0, m0, D);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(o0, p0, m0, D);
                }
            }
        }
        int size = this.X2.size();
        if (size > 0) {
            for (int i8 = 0; i8 < size; i8++) {
                this.X2.get(i8).D(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        if (this.t3 == i2) {
            int i5 = this.u3;
        }
        if (!this.d3) {
            int childCount = getChildCount();
            int i6 = 0;
            while (true) {
                if (i6 >= childCount) {
                    break;
                } else if (getChildAt(i6).isLayoutRequested()) {
                    this.d3 = true;
                    break;
                } else {
                    i6++;
                }
            }
        }
        this.t3 = i2;
        this.u3 = i4;
        this.Y2.Y2(w());
        if (this.d3) {
            this.d3 = false;
            if (H()) {
                this.Y2.a3();
            }
        }
        B(this.Y2, this.e3, i2, i4);
        A(i2, i4, this.Y2.m0(), this.Y2.D(), this.Y2.P2(), this.Y2.N2());
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget p = p(view);
        if ((view instanceof Guideline) && !(p instanceof Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Guideline guideline = new Guideline();
            layoutParams.v0 = guideline;
            layoutParams.h0 = true;
            guideline.B2(layoutParams.Z);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.I();
            ((LayoutParams) view.getLayoutParams()).i0 = true;
            if (!this.X2.contains(constraintHelper)) {
                this.X2.add(constraintHelper);
            }
        }
        this.s.put(view.getId(), view);
        this.d3 = true;
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.s.remove(view.getId());
        this.Y2.o2(p(view));
        this.X2.remove(view);
        this.d3 = true;
    }

    public final ConstraintWidget p(View view) {
        if (view == this) {
            return this.Y2;
        }
        if (view == null) {
            return null;
        }
        if (!(view.getLayoutParams() instanceof LayoutParams)) {
            view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
            if (!(view.getLayoutParams() instanceof LayoutParams)) {
                return null;
            }
        }
        return ((LayoutParams) view.getLayoutParams()).v0;
    }

    public void requestLayout() {
        y();
        super.requestLayout();
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.f3 = constraintSet;
    }

    public void setId(int i2) {
        this.s.remove(getId());
        super.setId(i2);
        this.s.put(getId(), this);
    }

    public void setMaxHeight(int i2) {
        if (i2 != this.c3) {
            this.c3 = i2;
            requestLayout();
        }
    }

    public void setMaxWidth(int i2) {
        if (i2 != this.b3) {
            this.b3 = i2;
            requestLayout();
        }
    }

    public void setMinHeight(int i2) {
        if (i2 != this.a3) {
            this.a3 = i2;
            requestLayout();
        }
    }

    public void setMinWidth(int i2) {
        if (i2 != this.Z2) {
            this.Z2 = i2;
            requestLayout();
        }
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.q3 = constraintsChangedListener;
        ConstraintLayoutStates constraintLayoutStates = this.g3;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.d(constraintsChangedListener);
        }
    }

    public void setOptimizationLevel(int i2) {
        this.e3 = i2;
        this.Y2.V2(i2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean w() {
        return (getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection();
    }

    public void x(int i2) {
        if (i2 != 0) {
            try {
                this.g3 = new ConstraintLayoutStates(getContext(), this, i2);
                return;
            } catch (Resources.NotFoundException unused) {
            }
        }
        this.g3 = null;
    }

    /* access modifiers changed from: protected */
    public void z(int i2) {
        this.g3 = new ConstraintLayoutStates(getContext(), this, i2);
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        v(attributeSet, 0, 0);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        v(attributeSet, i2, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i4) {
        super(context, attributeSet, i2, i4);
        v(attributeSet, i2, i4);
    }
}
