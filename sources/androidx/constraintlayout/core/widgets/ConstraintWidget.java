package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import com.itextpdf.text.html.HtmlTags;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

public class ConstraintWidget {
    private static final boolean U0 = false;
    protected static final int V0 = 1;
    protected static final int W0 = 2;
    private static final boolean X0 = false;
    public static final int Y0 = 0;
    public static final int Z0 = 1;
    public static final int a1 = 2;
    public static final int b1 = 3;
    public static final int c1 = 4;
    public static final int d1 = -1;
    public static final int e1 = 0;
    public static final int f1 = 1;
    public static final int g1 = 2;
    public static final int h1 = 0;
    public static final int i1 = 4;
    public static final int j1 = 8;
    public static final int k1 = 0;
    public static final int l1 = 1;
    public static final int m1 = 2;
    public static final int n1 = 0;
    public static final int o1 = 1;
    public static final int p1 = 2;
    public static final int q1 = 3;
    private static final int r1 = -2;
    public static final int s1 = 0;
    public static final int t1 = 1;
    public static final int u1 = 2;
    public static final int v1 = 3;
    public static final int w1 = 4;
    static final int x1 = 0;
    static final int y1 = 1;
    public static float z1 = 0.5f;
    public int A;
    int A0;
    public float B;
    int B0;
    public int C;
    boolean C0;
    public int D;
    boolean D0;
    public float E;
    boolean E0;
    public boolean F;
    boolean F0;
    public boolean G;
    boolean G0;
    int H;
    boolean H0;
    float I;
    boolean I0;
    private int[] J;
    int J0;
    private float K;
    int K0;
    private boolean L;
    boolean L0;
    private boolean M;
    boolean M0;
    private boolean N;
    public float[] N0;
    private int O;
    protected ConstraintWidget[] O0;
    private int P;
    protected ConstraintWidget[] P0;
    public ConstraintAnchor Q;
    ConstraintWidget Q0;
    public ConstraintAnchor R;
    ConstraintWidget R0;
    public ConstraintAnchor S;
    public int S0;
    public ConstraintAnchor T;
    public int T0;
    public ConstraintAnchor U;
    ConstraintAnchor V;
    ConstraintAnchor W;
    public ConstraintAnchor X;
    public ConstraintAnchor[] Y;
    protected ArrayList<ConstraintAnchor> Z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f4188a;
    private boolean[] a0;

    /* renamed from: b  reason: collision with root package name */
    public WidgetRun[] f4189b;
    public DimensionBehaviour[] b0;

    /* renamed from: c  reason: collision with root package name */
    public ChainRun f4190c;
    public ConstraintWidget c0;

    /* renamed from: d  reason: collision with root package name */
    public ChainRun f4191d;
    int d0;

    /* renamed from: e  reason: collision with root package name */
    public HorizontalWidgetRun f4192e;
    int e0;

    /* renamed from: f  reason: collision with root package name */
    public VerticalWidgetRun f4193f;
    public float f0;

    /* renamed from: g  reason: collision with root package name */
    public boolean[] f4194g;
    protected int g0;

    /* renamed from: h  reason: collision with root package name */
    boolean f4195h;
    protected int h0;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4196i;
    protected int i0;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4197j;
    int j0;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4198k;
    int k0;

    /* renamed from: l  reason: collision with root package name */
    private int f4199l;
    protected int l0;

    /* renamed from: m  reason: collision with root package name */
    private int f4200m;
    protected int m0;

    /* renamed from: n  reason: collision with root package name */
    public WidgetFrame f4201n;
    int n0;
    public String o;
    protected int o0;
    private boolean p;
    protected int p0;
    private boolean q;
    float q0;
    private boolean r;
    float r0;
    private boolean s;
    private Object s0;
    public int t;
    private int t0;
    public int u;
    private int u0;
    private int v;
    private boolean v0;
    public int w;
    private String w0;
    public int x;
    private String x0;
    public int[] y;
    int y0;
    public int z;
    int z0;

    /* renamed from: androidx.constraintlayout.core.widgets.ConstraintWidget$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4202a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f4203b;

        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x008f */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4203b = r0
                r1 = 1
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f4203b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f4203b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f4203b     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type[] r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f4202a = r4
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f4202a     // Catch:{ NoSuchFieldError -> 0x004e }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f4202a     // Catch:{ NoSuchFieldError -> 0x0058 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f4202a     // Catch:{ NoSuchFieldError -> 0x0062 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f4202a     // Catch:{ NoSuchFieldError -> 0x006d }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f4202a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f4202a     // Catch:{ NoSuchFieldError -> 0x0083 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = f4202a     // Catch:{ NoSuchFieldError -> 0x008f }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                int[] r0 = f4202a     // Catch:{ NoSuchFieldError -> 0x009b }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.NONE     // Catch:{ NoSuchFieldError -> 0x009b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009b }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009b }
            L_0x009b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.AnonymousClass1.<clinit>():void");
        }
    }

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        this.f4188a = false;
        this.f4189b = new WidgetRun[2];
        this.f4192e = null;
        this.f4193f = null;
        this.f4194g = new boolean[]{true, true};
        this.f4195h = false;
        this.f4196i = true;
        this.f4197j = false;
        this.f4198k = true;
        this.f4199l = -1;
        this.f4200m = -1;
        this.f4201n = new WidgetFrame(this);
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = -1;
        this.u = -1;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = new int[2];
        this.z = 0;
        this.A = 0;
        this.B = 1.0f;
        this.C = 0;
        this.D = 0;
        this.E = 1.0f;
        this.H = -1;
        this.I = 1.0f;
        this.J = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.K = 0.0f;
        this.L = false;
        this.N = false;
        this.O = 0;
        this.P = 0;
        this.Q = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.R = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.S = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.T = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.U = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.V = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.W = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.X = constraintAnchor;
        this.Y = new ConstraintAnchor[]{this.Q, this.S, this.R, this.T, this.U, constraintAnchor};
        this.Z = new ArrayList<>();
        this.a0 = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.b0 = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.c0 = null;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = 0.0f;
        this.g0 = -1;
        this.h0 = 0;
        this.i0 = 0;
        this.j0 = 0;
        this.k0 = 0;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = 0;
        float f2 = z1;
        this.q0 = f2;
        this.r0 = f2;
        this.t0 = 0;
        this.u0 = 0;
        this.v0 = false;
        this.w0 = null;
        this.x0 = null;
        this.I0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.N0 = new float[]{-1.0f, -1.0f};
        this.O0 = new ConstraintWidget[]{null, null};
        this.P0 = new ConstraintWidget[]{null, null};
        this.Q0 = null;
        this.R0 = null;
        this.S0 = -1;
        this.T0 = -1;
        d();
    }

    private void Z0(StringBuilder sb, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.f4183f != null) {
            sb.append(str);
            sb.append(" : [ '");
            sb.append(constraintAnchor.f4183f);
            sb.append("',");
            sb.append(constraintAnchor.f4184g);
            sb.append(",");
            sb.append(constraintAnchor.f4185h);
            sb.append(",");
            sb.append(" ] ,\n");
        }
    }

    private void a1(StringBuilder sb, String str, float f2, float f3) {
        if (f2 != f3) {
            sb.append(str);
            sb.append(" :   ");
            sb.append(f2);
            sb.append(",\n");
        }
    }

    private void b1(StringBuilder sb, String str, int i2, int i3) {
        if (i2 != i3) {
            sb.append(str);
            sb.append(" :   ");
            sb.append(i2);
            sb.append(",\n");
        }
    }

    private void c0(StringBuilder sb, String str, int i2, int i3, int i4, int i5, int i6, int i7, float f2, float f3) {
        sb.append(str);
        sb.append(" :  {\n");
        b1(sb, "      size", i2, 0);
        b1(sb, "      min", i3, 0);
        b1(sb, "      max", i4, Integer.MAX_VALUE);
        b1(sb, "      matchMin", i6, 0);
        b1(sb, "      matchDef", i7, 0);
        a1(sb, "      matchPercent", f2, 1.0f);
        sb.append("    },\n");
    }

    private void c1(StringBuilder sb, ConstraintAnchor constraintAnchor, float f2) {
        if (constraintAnchor.f4183f != null) {
            sb.append("circle : [ '");
            sb.append(constraintAnchor.f4183f);
            sb.append("',");
            sb.append(constraintAnchor.f4184g);
            sb.append(",");
            sb.append(f2);
            sb.append(",");
            sb.append(" ] ,\n");
        }
    }

    private void d() {
        this.Z.add(this.Q);
        this.Z.add(this.R);
        this.Z.add(this.S);
        this.Z.add(this.T);
        this.Z.add(this.V);
        this.Z.add(this.W);
        this.Z.add(this.X);
        this.Z.add(this.U);
    }

    private void d0(StringBuilder sb, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.f4183f != null) {
            sb.append("    ");
            sb.append(str);
            sb.append(" : [ '");
            sb.append(constraintAnchor.f4183f);
            sb.append("'");
            if (!(constraintAnchor.f4185h == Integer.MIN_VALUE && constraintAnchor.f4184g == 0)) {
                sb.append(",");
                sb.append(constraintAnchor.f4184g);
                if (constraintAnchor.f4185h != Integer.MIN_VALUE) {
                    sb.append(",");
                    sb.append(constraintAnchor.f4185h);
                    sb.append(",");
                }
            }
            sb.append(" ] ,\n");
        }
    }

    private void d1(StringBuilder sb, String str, float f2, int i2) {
        if (f2 != 0.0f) {
            sb.append(str);
            sb.append(" :  [");
            sb.append(f2);
            sb.append(",");
            sb.append(i2);
            sb.append("");
            sb.append("],\n");
        }
    }

    private void e1(StringBuilder sb, String str, int i2, int i3, int i4, int i5, int i6, int i7, float f2, float f3) {
        sb.append(str);
        sb.append(" :  {\n");
        b1(sb, "size", i2, Integer.MIN_VALUE);
        b1(sb, "min", i3, 0);
        b1(sb, "max", i4, Integer.MAX_VALUE);
        b1(sb, "matchMin", i6, 0);
        b1(sb, "matchDef", i7, 0);
        b1(sb, "matchPercent", i7, 1);
        sb.append("},\n");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x037d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x038a  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x03ce  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x03e4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x03e5  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0425 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x046e  */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x04a4 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x04d4  */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x04e0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:362:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:366:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i(androidx.constraintlayout.core.LinearSystem r32, boolean r33, boolean r34, boolean r35, boolean r36, androidx.constraintlayout.core.SolverVariable r37, androidx.constraintlayout.core.SolverVariable r38, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r39, boolean r40, androidx.constraintlayout.core.widgets.ConstraintAnchor r41, androidx.constraintlayout.core.widgets.ConstraintAnchor r42, int r43, int r44, int r45, int r46, float r47, boolean r48, boolean r49, boolean r50, boolean r51, boolean r52, int r53, int r54, int r55, int r56, float r57, boolean r58) {
        /*
            r31 = this;
            r0 = r31
            r10 = r32
            r11 = r37
            r12 = r38
            r13 = r41
            r14 = r42
            r15 = r45
            r1 = r46
            r2 = r54
            r3 = r55
            r4 = r56
            androidx.constraintlayout.core.SolverVariable r9 = r10.u(r13)
            androidx.constraintlayout.core.SolverVariable r8 = r10.u(r14)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r41.k()
            androidx.constraintlayout.core.SolverVariable r7 = r10.u(r5)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r42.k()
            androidx.constraintlayout.core.SolverVariable r6 = r10.u(r5)
            androidx.constraintlayout.core.Metrics r5 = androidx.constraintlayout.core.LinearSystem.L()
            if (r5 == 0) goto L_0x0040
            androidx.constraintlayout.core.Metrics r5 = androidx.constraintlayout.core.LinearSystem.L()
            long r11 = r5.H
            r16 = 1
            long r11 = r11 + r16
            r5.H = r11
        L_0x0040:
            boolean r11 = r41.p()
            boolean r12 = r42.p()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r0.X
            boolean r16 = r5.p()
            if (r12 == 0) goto L_0x0053
            int r5 = r11 + 1
            goto L_0x0054
        L_0x0053:
            r5 = r11
        L_0x0054:
            if (r16 == 0) goto L_0x0058
            int r5 = r5 + 1
        L_0x0058:
            if (r48 == 0) goto L_0x005d
            r18 = 3
            goto L_0x005f
        L_0x005d:
            r18 = r53
        L_0x005f:
            int[] r17 = androidx.constraintlayout.core.widgets.ConstraintWidget.AnonymousClass1.f4203b
            int r19 = r39.ordinal()
            r2 = r17[r19]
            r14 = 1
            if (r2 == r14) goto L_0x0073
            r14 = 2
            if (r2 == r14) goto L_0x0073
            r14 = 3
            if (r2 == r14) goto L_0x0073
            r14 = 4
            if (r2 == r14) goto L_0x0078
        L_0x0073:
            r2 = r18
        L_0x0075:
            r18 = 0
            goto L_0x007e
        L_0x0078:
            r2 = r18
            if (r2 == r14) goto L_0x0075
            r18 = 1
        L_0x007e:
            int r14 = r0.f4199l
            r13 = -1
            if (r14 == r13) goto L_0x008c
            if (r33 == 0) goto L_0x008c
            r0.f4199l = r13
            r21 = r6
            r18 = 0
            goto L_0x0090
        L_0x008c:
            r14 = r44
            r21 = r6
        L_0x0090:
            int r6 = r0.f4200m
            if (r6 == r13) goto L_0x009b
            if (r33 != 0) goto L_0x009b
            r0.f4200m = r13
            r14 = r6
            r18 = 0
        L_0x009b:
            int r6 = r0.u0
            r13 = 8
            if (r6 != r13) goto L_0x00a4
            r14 = 0
            r18 = 0
        L_0x00a4:
            if (r58 == 0) goto L_0x00bd
            if (r11 != 0) goto L_0x00b2
            if (r12 != 0) goto L_0x00b2
            if (r16 != 0) goto L_0x00b2
            r6 = r43
            r10.f(r9, r6)
            goto L_0x00bd
        L_0x00b2:
            if (r11 == 0) goto L_0x00bd
            if (r12 != 0) goto L_0x00bd
            int r6 = r41.g()
            r10.e(r9, r7, r6, r13)
        L_0x00bd:
            if (r18 != 0) goto L_0x00eb
            if (r40 == 0) goto L_0x00d6
            r6 = 3
            r13 = 0
            r10.e(r8, r9, r13, r6)
            r6 = 8
            if (r15 <= 0) goto L_0x00cd
            r10.i(r8, r9, r15, r6)
        L_0x00cd:
            r14 = 2147483647(0x7fffffff, float:NaN)
            if (r1 >= r14) goto L_0x00dc
            r10.k(r8, r9, r1, r6)
            goto L_0x00dc
        L_0x00d6:
            r6 = 8
            r13 = 0
            r10.e(r8, r9, r14, r6)
        L_0x00dc:
            r1 = r4
            r40 = r5
            r13 = r7
            r15 = r8
            r23 = r18
            r14 = r21
            r18 = r36
        L_0x00e7:
            r21 = r3
            goto L_0x01cc
        L_0x00eb:
            r1 = 2
            r13 = 0
            if (r5 == r1) goto L_0x0111
            if (r48 != 0) goto L_0x0111
            r1 = 1
            if (r2 == r1) goto L_0x00f6
            if (r2 != 0) goto L_0x0111
        L_0x00f6:
            int r1 = java.lang.Math.max(r3, r14)
            if (r4 <= 0) goto L_0x0100
            int r1 = java.lang.Math.min(r4, r1)
        L_0x0100:
            r6 = 8
            r10.e(r8, r9, r1, r6)
            r18 = r36
            r1 = r4
            r40 = r5
            r13 = r7
            r15 = r8
            r14 = r21
            r23 = 0
            goto L_0x00e7
        L_0x0111:
            r1 = -2
            if (r3 != r1) goto L_0x0116
            r6 = r14
            goto L_0x0117
        L_0x0116:
            r6 = r3
        L_0x0117:
            if (r4 != r1) goto L_0x011b
            r1 = r14
            goto L_0x011c
        L_0x011b:
            r1 = r4
        L_0x011c:
            if (r14 <= 0) goto L_0x0122
            r3 = 1
            if (r2 == r3) goto L_0x0122
            r14 = 0
        L_0x0122:
            r3 = 8
            if (r6 <= 0) goto L_0x012d
            r10.i(r8, r9, r6, r3)
            int r14 = java.lang.Math.max(r14, r6)
        L_0x012d:
            r4 = 1
            if (r1 <= 0) goto L_0x013c
            if (r34 == 0) goto L_0x0135
            if (r2 != r4) goto L_0x0135
            goto L_0x0138
        L_0x0135:
            r10.k(r8, r9, r1, r3)
        L_0x0138:
            int r14 = java.lang.Math.min(r14, r1)
        L_0x013c:
            if (r2 != r4) goto L_0x015a
            if (r34 == 0) goto L_0x0145
            r10.e(r8, r9, r14, r3)
            r4 = 5
            goto L_0x014c
        L_0x0145:
            r4 = 5
            r10.e(r8, r9, r14, r4)
            r10.k(r8, r9, r14, r3)
        L_0x014c:
            r40 = r5
            r13 = r7
            r15 = r8
            r23 = r18
            r14 = r21
            r18 = r36
            r21 = r6
            goto L_0x01cc
        L_0x015a:
            r4 = 5
            r14 = 2
            if (r2 != r14) goto L_0x01c0
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = r41.l()
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            if (r3 == r4) goto L_0x018b
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = r41.l()
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r13 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            if (r3 != r13) goto L_0x016f
            goto L_0x018b
        L_0x016f:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.c0
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.r(r4)
            androidx.constraintlayout.core.SolverVariable r3 = r10.u(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.c0
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r13 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
        L_0x017f:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.r(r13)
            androidx.constraintlayout.core.SolverVariable r4 = r10.u(r4)
            r23 = r3
            r13 = r4
            goto L_0x019a
        L_0x018b:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.c0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.r(r4)
            androidx.constraintlayout.core.SolverVariable r3 = r10.u(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.c0
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r13 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            goto L_0x017f
        L_0x019a:
            androidx.constraintlayout.core.ArrayRow r3 = r32.v()
            r24 = 5
            r4 = r8
            r14 = r5
            r5 = r9
            r40 = r14
            r14 = r21
            r21 = r6
            r6 = r13
            r13 = r7
            r7 = r23
            r15 = r8
            r8 = r57
            androidx.constraintlayout.core.ArrayRow r3 = r3.n(r4, r5, r6, r7, r8)
            r10.d(r3)
            if (r34 == 0) goto L_0x01bb
            r18 = 0
        L_0x01bb:
            r23 = r18
            r18 = r36
            goto L_0x01cc
        L_0x01c0:
            r40 = r5
            r13 = r7
            r15 = r8
            r14 = r21
            r21 = r6
            r23 = r18
            r18 = 1
        L_0x01cc:
            if (r58 == 0) goto L_0x04d4
            if (r50 == 0) goto L_0x01dc
            r1 = r37
            r4 = r38
            r5 = r40
            r2 = r15
            r3 = 0
            r6 = 2
            r15 = r9
            goto L_0x04de
        L_0x01dc:
            if (r11 != 0) goto L_0x01e7
            if (r12 != 0) goto L_0x01e7
            if (r16 != 0) goto L_0x01e7
        L_0x01e2:
            r2 = r15
            r1 = 5
        L_0x01e4:
            r3 = 0
            goto L_0x049f
        L_0x01e7:
            if (r11 == 0) goto L_0x0203
            if (r12 != 0) goto L_0x0203
            r7 = r41
            r8 = 0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r7.f4183f
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.f4181d
            if (r34 == 0) goto L_0x01fb
            boolean r1 = r1 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 == 0) goto L_0x01fb
            r13 = 8
            goto L_0x01fc
        L_0x01fb:
            r13 = 5
        L_0x01fc:
            r22 = r34
            r6 = r13
            r2 = r15
            r3 = 0
            goto L_0x04a2
        L_0x0203:
            r7 = r41
            r8 = 0
            if (r11 != 0) goto L_0x0236
            if (r12 == 0) goto L_0x0236
            int r1 = r42.g()
            int r1 = -r1
            r2 = 8
            r10.e(r15, r14, r1, r2)
            if (r34 == 0) goto L_0x01e2
            boolean r1 = r0.f4197j
            if (r1 == 0) goto L_0x022e
            boolean r1 = r9.Z2
            if (r1 == 0) goto L_0x022e
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.c0
            if (r1 == 0) goto L_0x022e
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r1
            if (r33 == 0) goto L_0x022a
            r1.u2(r7)
            goto L_0x01e2
        L_0x022a:
            r1.z2(r7)
            goto L_0x01e2
        L_0x022e:
            r6 = r37
            r1 = 5
            r10.i(r9, r6, r8, r1)
            r2 = r15
            goto L_0x01e4
        L_0x0236:
            r6 = r37
            if (r11 == 0) goto L_0x01e2
            if (r12 == 0) goto L_0x01e2
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r7.f4183f
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r3.f4181d
            r12 = r42
            r3 = 2
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r12.f4183f
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r4.f4181d
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r31.U()
            r16 = 6
            if (r23 == 0) goto L_0x033b
            if (r2 != 0) goto L_0x02a3
            if (r1 != 0) goto L_0x027a
            if (r21 != 0) goto L_0x027a
            boolean r1 = r13.Z2
            if (r1 == 0) goto L_0x026f
            boolean r1 = r14.Z2
            if (r1 == 0) goto L_0x026f
            int r1 = r41.g()
            r2 = 8
            r10.e(r9, r13, r1, r2)
            int r1 = r42.g()
            int r1 = -r1
            r10.e(r15, r14, r1, r2)
            return
        L_0x026f:
            r1 = 8
            r3 = 8
            r19 = 0
            r22 = 1
            r24 = 0
            goto L_0x0282
        L_0x027a:
            r1 = 5
            r3 = 5
            r19 = 1
            r22 = 0
            r24 = 1
        L_0x0282:
            boolean r8 = r11 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r8 != 0) goto L_0x0297
            boolean r8 = r5 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r8 == 0) goto L_0x028b
            goto L_0x0297
        L_0x028b:
            r8 = r38
            r25 = r22
            r22 = r19
            r19 = r3
        L_0x0293:
            r3 = r1
            r1 = 6
            goto L_0x037b
        L_0x0297:
            r8 = r38
            r3 = r1
            r25 = r22
            r1 = 6
            r22 = r19
            r19 = 4
            goto L_0x037b
        L_0x02a3:
            if (r2 != r3) goto L_0x02c3
            boolean r1 = r11 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 != 0) goto L_0x02bc
            boolean r1 = r5 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 == 0) goto L_0x02ae
            goto L_0x02bc
        L_0x02ae:
            r8 = r38
            r1 = 6
            r3 = 5
            r19 = 5
        L_0x02b4:
            r22 = 1
            r24 = 1
        L_0x02b8:
            r25 = 0
            goto L_0x037b
        L_0x02bc:
            r8 = r38
            r1 = 6
            r3 = 5
        L_0x02c0:
            r19 = 4
            goto L_0x02b4
        L_0x02c3:
            r8 = 1
            if (r2 != r8) goto L_0x02cc
            r8 = r38
            r1 = 6
            r3 = 8
            goto L_0x02c0
        L_0x02cc:
            r8 = 3
            if (r2 != r8) goto L_0x032f
            int r8 = r0.H
            r3 = -1
            if (r8 != r3) goto L_0x02ec
            r8 = r38
            if (r51 == 0) goto L_0x02e9
            if (r34 == 0) goto L_0x02e7
            r1 = 5
        L_0x02db:
            r3 = 8
        L_0x02dd:
            r19 = 5
        L_0x02df:
            r22 = 1
            r24 = 1
            r25 = 1
            goto L_0x037b
        L_0x02e7:
            r1 = 4
            goto L_0x02db
        L_0x02e9:
            r1 = 8
            goto L_0x02db
        L_0x02ec:
            if (r48 == 0) goto L_0x0308
            r3 = r54
            r8 = 2
            if (r3 == r8) goto L_0x02fb
            r1 = 1
            if (r3 != r1) goto L_0x02f7
            goto L_0x02fb
        L_0x02f7:
            r1 = 8
            r3 = 5
            goto L_0x02fd
        L_0x02fb:
            r1 = 5
            r3 = 4
        L_0x02fd:
            r8 = r38
            r19 = r3
            r22 = 1
            r24 = 1
            r25 = 1
            goto L_0x0293
        L_0x0308:
            if (r1 <= 0) goto L_0x030f
            r8 = r38
            r1 = 6
            r3 = 5
            goto L_0x02dd
        L_0x030f:
            if (r1 != 0) goto L_0x032a
            if (r21 != 0) goto L_0x032a
            if (r51 != 0) goto L_0x031c
            r8 = r38
            r1 = 6
            r3 = 5
            r19 = 8
            goto L_0x02df
        L_0x031c:
            if (r11 == r4) goto L_0x0322
            if (r5 == r4) goto L_0x0322
            r1 = 4
            goto L_0x0323
        L_0x0322:
            r1 = 5
        L_0x0323:
            r8 = r38
            r3 = r1
            r1 = 6
        L_0x0327:
            r19 = 4
            goto L_0x02df
        L_0x032a:
            r8 = r38
            r1 = 6
            r3 = 5
            goto L_0x0327
        L_0x032f:
            r8 = r38
            r1 = 6
            r3 = 5
            r19 = 4
            r22 = 0
            r24 = 0
            goto L_0x02b8
        L_0x033b:
            boolean r1 = r13.Z2
            if (r1 == 0) goto L_0x02bc
            boolean r1 = r14.Z2
            if (r1 == 0) goto L_0x02bc
            int r1 = r41.g()
            int r2 = r42.g()
            r3 = 8
            r48 = r32
            r49 = r9
            r50 = r13
            r51 = r1
            r52 = r47
            r53 = r14
            r54 = r15
            r55 = r2
            r56 = r3
            r48.c(r49, r50, r51, r52, r53, r54, r55, r56)
            if (r34 == 0) goto L_0x037a
            if (r18 == 0) goto L_0x037a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r12.f4183f
            if (r1 == 0) goto L_0x0371
            int r13 = r42.g()
            r8 = r38
            goto L_0x0374
        L_0x0371:
            r8 = r38
            r13 = 0
        L_0x0374:
            if (r14 == r8) goto L_0x037a
            r1 = 5
            r10.i(r8, r15, r13, r1)
        L_0x037a:
            return
        L_0x037b:
            if (r24 == 0) goto L_0x0386
            if (r13 != r14) goto L_0x0386
            if (r11 == r4) goto L_0x0386
            r24 = 0
            r26 = 0
            goto L_0x0388
        L_0x0386:
            r26 = 1
        L_0x0388:
            if (r22 == 0) goto L_0x03ce
            if (r23 != 0) goto L_0x039d
            if (r49 != 0) goto L_0x039d
            if (r51 != 0) goto L_0x039d
            if (r13 != r6) goto L_0x039d
            if (r14 != r8) goto L_0x039d
            r22 = 0
            r26 = 8
            r27 = 8
            r28 = 0
            goto L_0x03a5
        L_0x039d:
            r22 = r34
            r27 = r1
            r28 = r26
            r26 = r3
        L_0x03a5:
            int r29 = r41.g()
            int r30 = r42.g()
            r1 = r32
            r3 = r2
            r2 = r9
            r12 = r3
            r3 = r13
            r39 = r12
            r12 = r4
            r4 = r29
            r29 = r12
            r12 = r5
            r5 = r47
            r6 = r14
            r7 = r15
            r8 = r30
            r20 = r15
            r15 = r9
            r9 = r27
            r1.c(r2, r3, r4, r5, r6, r7, r8, r9)
            r3 = r26
            r26 = r28
            goto L_0x03d8
        L_0x03ce:
            r39 = r2
            r29 = r4
            r12 = r5
            r20 = r15
            r15 = r9
            r22 = r34
        L_0x03d8:
            int r1 = r0.u0
            r2 = 8
            if (r1 != r2) goto L_0x03e5
            boolean r1 = r42.n()
            if (r1 != 0) goto L_0x03e5
            return
        L_0x03e5:
            if (r24 == 0) goto L_0x0408
            if (r22 == 0) goto L_0x03f6
            if (r13 == r14) goto L_0x03f6
            if (r23 != 0) goto L_0x03f6
            boolean r1 = r11 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 != 0) goto L_0x03f5
            boolean r1 = r12 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 == 0) goto L_0x03f6
        L_0x03f5:
            r3 = 6
        L_0x03f6:
            int r1 = r41.g()
            r10.i(r15, r13, r1, r3)
            int r1 = r42.g()
            int r1 = -r1
            r2 = r20
            r10.k(r2, r14, r1, r3)
            goto L_0x040a
        L_0x0408:
            r2 = r20
        L_0x040a:
            if (r22 == 0) goto L_0x041f
            if (r52 == 0) goto L_0x041f
            boolean r1 = r11 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 != 0) goto L_0x041f
            boolean r1 = r12 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r1 != 0) goto L_0x041f
            r1 = r29
            if (r12 == r1) goto L_0x0421
            r3 = 6
            r4 = 6
            r26 = 1
            goto L_0x0423
        L_0x041f:
            r1 = r29
        L_0x0421:
            r4 = r19
        L_0x0423:
            if (r26 == 0) goto L_0x046c
            if (r25 == 0) goto L_0x044c
            if (r51 == 0) goto L_0x042b
            if (r35 == 0) goto L_0x044c
        L_0x042b:
            if (r11 == r1) goto L_0x0432
            if (r12 != r1) goto L_0x0430
            goto L_0x0432
        L_0x0430:
            r6 = r4
            goto L_0x0433
        L_0x0432:
            r6 = 6
        L_0x0433:
            boolean r5 = r11 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r5 != 0) goto L_0x043b
            boolean r5 = r12 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r5 == 0) goto L_0x043c
        L_0x043b:
            r6 = 5
        L_0x043c:
            boolean r5 = r11 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r5 != 0) goto L_0x0444
            boolean r5 = r12 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r5 == 0) goto L_0x0445
        L_0x0444:
            r6 = 5
        L_0x0445:
            if (r51 == 0) goto L_0x0448
            r6 = 5
        L_0x0448:
            int r4 = java.lang.Math.max(r6, r4)
        L_0x044c:
            if (r22 == 0) goto L_0x045d
            int r3 = java.lang.Math.min(r3, r4)
            if (r48 == 0) goto L_0x045c
            if (r51 != 0) goto L_0x045c
            if (r11 == r1) goto L_0x045a
            if (r12 != r1) goto L_0x045c
        L_0x045a:
            r4 = 4
            goto L_0x045d
        L_0x045c:
            r4 = r3
        L_0x045d:
            int r1 = r41.g()
            r10.e(r15, r13, r1, r4)
            int r1 = r42.g()
            int r1 = -r1
            r10.e(r2, r14, r1, r4)
        L_0x046c:
            if (r22 == 0) goto L_0x047e
            r1 = r37
            if (r1 != r13) goto L_0x0477
            int r3 = r41.g()
            goto L_0x0478
        L_0x0477:
            r3 = 0
        L_0x0478:
            if (r13 == r1) goto L_0x047e
            r4 = 5
            r10.i(r15, r1, r3, r4)
        L_0x047e:
            if (r22 == 0) goto L_0x049b
            if (r23 == 0) goto L_0x049b
            if (r45 != 0) goto L_0x049b
            if (r21 != 0) goto L_0x049b
            if (r23 == 0) goto L_0x0495
            r3 = r39
            r1 = 3
            if (r3 != r1) goto L_0x0495
            r1 = 8
            r3 = 0
            r10.i(r2, r15, r3, r1)
            r1 = 5
            goto L_0x049d
        L_0x0495:
            r3 = 0
            r1 = 5
            r10.i(r2, r15, r3, r1)
            goto L_0x049d
        L_0x049b:
            r1 = 5
            r3 = 0
        L_0x049d:
            r6 = 5
            goto L_0x04a2
        L_0x049f:
            r22 = r34
            goto L_0x049d
        L_0x04a2:
            if (r22 == 0) goto L_0x04d3
            if (r18 == 0) goto L_0x04d3
            r1 = r42
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r1.f4183f
            if (r4 == 0) goto L_0x04b3
            int r13 = r42.g()
            r4 = r38
            goto L_0x04b6
        L_0x04b3:
            r4 = r38
            r13 = 0
        L_0x04b6:
            if (r14 == r4) goto L_0x04d3
            boolean r3 = r0.f4197j
            if (r3 == 0) goto L_0x04d0
            boolean r3 = r2.Z2
            if (r3 == 0) goto L_0x04d0
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.c0
            if (r3 == 0) goto L_0x04d0
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r3 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r3
            if (r33 == 0) goto L_0x04cc
            r3.t2(r1)
            goto L_0x04cf
        L_0x04cc:
            r3.y2(r1)
        L_0x04cf:
            return
        L_0x04d0:
            r10.i(r4, r2, r13, r6)
        L_0x04d3:
            return
        L_0x04d4:
            r1 = r37
            r4 = r38
            r2 = r15
            r3 = 0
            r15 = r9
            r5 = r40
            r6 = 2
        L_0x04de:
            if (r5 >= r6) goto L_0x051f
            if (r34 == 0) goto L_0x051f
            if (r18 == 0) goto L_0x051f
            r5 = 8
            r10.i(r15, r1, r3, r5)
            if (r33 != 0) goto L_0x04f4
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.U
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f4183f
            if (r1 != 0) goto L_0x04f2
            goto L_0x04f4
        L_0x04f2:
            r13 = 0
            goto L_0x04f5
        L_0x04f4:
            r13 = 1
        L_0x04f5:
            if (r33 != 0) goto L_0x0517
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.U
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f4183f
            if (r1 == 0) goto L_0x0517
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.f4181d
            float r5 = r1.f0
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 == 0) goto L_0x0515
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r1.b0
            r5 = r1[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r6) goto L_0x0515
            r5 = 1
            r1 = r1[r5]
            if (r1 != r6) goto L_0x0515
            r14 = 1
            goto L_0x0518
        L_0x0515:
            r14 = 0
            goto L_0x0518
        L_0x0517:
            r14 = r13
        L_0x0518:
            if (r14 == 0) goto L_0x051f
            r1 = 8
            r10.i(r4, r2, r3, r1)
        L_0x051f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.i(androidx.constraintlayout.core.LinearSystem, boolean, boolean, boolean, boolean, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r4 = r0[r4 + 1];
        r0 = r4.f4183f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean x0(int r4) {
        /*
            r3 = this;
            int r4 = r4 * 2
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r3.Y
            r1 = r0[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r1.f4183f
            if (r2 == 0) goto L_0x001b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f4183f
            if (r2 == r1) goto L_0x001b
            r1 = 1
            int r4 = r4 + r1
            r4 = r0[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r4.f4183f
            if (r0 == 0) goto L_0x001b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.f4183f
            if (r0 != r4) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r1 = 0
        L_0x001c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.x0(int):boolean");
    }

    public float A() {
        return this.f0;
    }

    public boolean A0(int i2) {
        return this.a0[i2];
    }

    public void A1(float f2) {
        this.q0 = f2;
    }

    public int B() {
        return this.g0;
    }

    public boolean B0() {
        ConstraintAnchor constraintAnchor = this.Q;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f4183f;
        if (constraintAnchor2 != null && constraintAnchor2.f4183f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.S;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f4183f;
        return constraintAnchor4 != null && constraintAnchor4.f4183f == constraintAnchor3;
    }

    public void B1(int i2) {
        this.J0 = i2;
    }

    public boolean C() {
        return this.L;
    }

    public boolean C0() {
        return this.M;
    }

    public void C1(int i2, int i3) {
        this.h0 = i2;
        int i4 = i3 - i2;
        this.d0 = i4;
        int i5 = this.o0;
        if (i4 < i5) {
            this.d0 = i5;
        }
    }

    public int D() {
        if (this.u0 == 8) {
            return 0;
        }
        return this.e0;
    }

    public boolean D0() {
        ConstraintAnchor constraintAnchor = this.R;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f4183f;
        if (constraintAnchor2 != null && constraintAnchor2.f4183f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.T;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f4183f;
        return constraintAnchor4 != null && constraintAnchor4.f4183f == constraintAnchor3;
    }

    public void D1(DimensionBehaviour dimensionBehaviour) {
        this.b0[0] = dimensionBehaviour;
    }

    public float E() {
        return this.q0;
    }

    public boolean E0() {
        return this.N;
    }

    public void E1(int i2, int i3, int i4, float f2) {
        this.w = i2;
        this.z = i3;
        if (i4 == Integer.MAX_VALUE) {
            i4 = 0;
        }
        this.A = i4;
        this.B = f2;
        if (f2 > 0.0f && f2 < 1.0f && i2 == 0) {
            this.w = 2;
        }
    }

    public ConstraintWidget F() {
        if (!B0()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor r2 = constraintWidget.r(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor k2 = r2 == null ? null : r2.k();
            ConstraintWidget i2 = k2 == null ? null : k2.i();
            if (i2 == U()) {
                return constraintWidget;
            }
            ConstraintAnchor k3 = i2 == null ? null : i2.r(ConstraintAnchor.Type.RIGHT).k();
            if (k3 == null || k3.i() == constraintWidget) {
                constraintWidget = i2;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public boolean F0() {
        return this.f4196i && this.u0 != 8;
    }

    public void F1(float f2) {
        this.N0[0] = f2;
    }

    public int G() {
        return this.J0;
    }

    public boolean G0() {
        return this.p || (this.Q.o() && this.S.o());
    }

    /* access modifiers changed from: protected */
    public void G1(int i2, boolean z2) {
        this.a0[i2] = z2;
    }

    public DimensionBehaviour H() {
        return this.b0[0];
    }

    public boolean H0() {
        return this.q || (this.R.o() && this.T.o());
    }

    public void H1(boolean z2) {
        this.M = z2;
    }

    public int I() {
        ConstraintAnchor constraintAnchor = this.Q;
        int i2 = constraintAnchor != null ? constraintAnchor.f4184g : 0;
        ConstraintAnchor constraintAnchor2 = this.S;
        return constraintAnchor2 != null ? i2 + constraintAnchor2.f4184g : i2;
    }

    public boolean I0() {
        return this.c0 == null;
    }

    public void I1(boolean z2) {
        this.N = z2;
    }

    public int J() {
        return this.O;
    }

    public boolean J0() {
        return this.x == 0 && this.f0 == 0.0f && this.C == 0 && this.D == 0 && this.b0[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public void J1(int i2, int i3) {
        this.O = i2;
        this.P = i3;
        N1(false);
    }

    public int K() {
        return this.P;
    }

    public boolean K0() {
        return this.w == 0 && this.f0 == 0.0f && this.z == 0 && this.A == 0 && this.b0[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public void K1(int i2, int i3) {
        if (i3 == 0) {
            c2(i2);
        } else if (i3 == 1) {
            y1(i2);
        }
    }

    public int L() {
        return o0();
    }

    public boolean L0() {
        return this.s;
    }

    public void L1(int i2) {
        this.J[1] = i2;
    }

    public int M(int i2) {
        if (i2 == 0) {
            return m0();
        }
        if (i2 == 1) {
            return D();
        }
        return 0;
    }

    public boolean M0() {
        return this.F;
    }

    public void M1(int i2) {
        this.J[0] = i2;
    }

    public int N() {
        return this.J[1];
    }

    public void N0() {
        this.r = true;
    }

    public void N1(boolean z2) {
        this.f4196i = z2;
    }

    public int O() {
        return this.J[0];
    }

    public void O0() {
        this.s = true;
    }

    public void O1(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.p0 = i2;
    }

    public int P() {
        return this.p0;
    }

    public boolean P0(int i2) {
        char c2 = i2 == 0 ? (char) 1 : 0;
        DimensionBehaviour[] dimensionBehaviourArr = this.b0;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[i2];
        DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[c2];
        DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour3 && dimensionBehaviour2 == dimensionBehaviour3;
    }

    public void P1(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.o0 = i2;
    }

    public int Q() {
        return this.o0;
    }

    public boolean Q0() {
        DimensionBehaviour[] dimensionBehaviourArr = this.b0;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2;
    }

    public void Q1(int i2, int i3) {
        this.l0 = i2;
        this.m0 = i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = r2.T;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.core.widgets.ConstraintWidget R(int r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x000f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.f4183f
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.f4183f
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f4181d
            return r3
        L_0x000f:
            r0 = 1
            if (r3 != r0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.f4183f
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.f4183f
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f4181d
            return r3
        L_0x001f:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.R(int):androidx.constraintlayout.core.widgets.ConstraintWidget");
    }

    public void R0() {
        this.Q.x();
        this.R.x();
        this.S.x();
        this.T.x();
        this.U.x();
        this.V.x();
        this.W.x();
        this.X.x();
        this.c0 = null;
        this.K = 0.0f;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = 0.0f;
        this.g0 = -1;
        this.h0 = 0;
        this.i0 = 0;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = 0;
        this.o0 = 0;
        this.p0 = 0;
        float f2 = z1;
        this.q0 = f2;
        this.r0 = f2;
        DimensionBehaviour[] dimensionBehaviourArr = this.b0;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.s0 = null;
        this.t0 = 0;
        this.u0 = 0;
        this.x0 = null;
        this.G0 = false;
        this.H0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.L0 = false;
        this.M0 = false;
        float[] fArr = this.N0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.t = -1;
        this.u = -1;
        int[] iArr = this.J;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.w = 0;
        this.x = 0;
        this.B = 1.0f;
        this.E = 1.0f;
        this.A = Integer.MAX_VALUE;
        this.D = Integer.MAX_VALUE;
        this.z = 0;
        this.C = 0;
        this.f4195h = false;
        this.H = -1;
        this.I = 1.0f;
        this.I0 = false;
        boolean[] zArr = this.f4194g;
        zArr[0] = true;
        zArr[1] = true;
        this.N = false;
        boolean[] zArr2 = this.a0;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f4196i = true;
        int[] iArr2 = this.y;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f4199l = -1;
        this.f4200m = -1;
    }

    public void R1(int i2, int i3) {
        this.h0 = i2;
        this.i0 = i3;
    }

    public int S() {
        int i2;
        int i3 = this.e0;
        if (this.b0[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i3;
        }
        if (this.x == 1) {
            i2 = Math.max(this.C, i3);
        } else {
            i2 = this.C;
            if (i2 > 0) {
                this.e0 = i2;
            } else {
                i2 = 0;
            }
        }
        int i4 = this.D;
        return (i4 <= 0 || i4 >= i2) ? i2 : i4;
    }

    public void S0() {
        U0();
        V1(z1);
        A1(z1);
    }

    public void S1(ConstraintWidget constraintWidget) {
        this.c0 = constraintWidget;
    }

    public int T() {
        int i2;
        int i3 = this.d0;
        if (this.b0[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i3;
        }
        if (this.w == 1) {
            i2 = Math.max(this.z, i3);
        } else {
            i2 = this.z;
            if (i2 > 0) {
                this.d0 = i2;
            } else {
                i2 = 0;
            }
        }
        int i4 = this.A;
        return (i4 <= 0 || i4 >= i2) ? i2 : i4;
    }

    public void T0(ConstraintAnchor constraintAnchor) {
        if (U() == null || !(U() instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) U()).K2()) {
            ConstraintAnchor r2 = r(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor r3 = r(ConstraintAnchor.Type.RIGHT);
            ConstraintAnchor r4 = r(ConstraintAnchor.Type.TOP);
            ConstraintAnchor r5 = r(ConstraintAnchor.Type.BOTTOM);
            ConstraintAnchor r6 = r(ConstraintAnchor.Type.CENTER);
            ConstraintAnchor r7 = r(ConstraintAnchor.Type.CENTER_X);
            ConstraintAnchor r8 = r(ConstraintAnchor.Type.CENTER_Y);
            if (constraintAnchor == r6) {
                if (r2.p() && r3.p() && r2.k() == r3.k()) {
                    r2.x();
                    r3.x();
                }
                if (r4.p() && r5.p() && r4.k() == r5.k()) {
                    r4.x();
                    r5.x();
                }
                this.q0 = 0.5f;
            } else {
                if (constraintAnchor == r7) {
                    if (r2.p() && r3.p() && r2.k().i() == r3.k().i()) {
                        r2.x();
                        r3.x();
                    }
                    this.q0 = 0.5f;
                } else if (constraintAnchor == r8) {
                    if (r4.p() && r5.p() && r4.k().i() == r5.k().i()) {
                        r4.x();
                        r5.x();
                    }
                } else if (constraintAnchor == r2 || constraintAnchor == r3 ? !(!r2.p() || r2.k() != r3.k()) : (constraintAnchor == r4 || constraintAnchor == r5) && r4.p() && r4.k() == r5.k()) {
                    r6.x();
                }
                constraintAnchor.x();
            }
            this.r0 = 0.5f;
            constraintAnchor.x();
        }
    }

    /* access modifiers changed from: package-private */
    public void T1(int i2, int i3) {
        if (i3 == 0) {
            this.j0 = i2;
        } else if (i3 == 1) {
            this.k0 = i2;
        }
    }

    public ConstraintWidget U() {
        return this.c0;
    }

    public void U0() {
        ConstraintWidget U2 = U();
        if (U2 == null || !(U2 instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) U()).K2()) {
            int size = this.Z.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.Z.get(i2).x();
            }
        }
    }

    public void U1(String str) {
        this.x0 = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = r2.R;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.core.widgets.ConstraintWidget V(int r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x000f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.f4183f
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.f4183f
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f4181d
            return r3
        L_0x000f:
            r0 = 1
            if (r3 != r0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.f4183f
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.f4183f
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f4181d
            return r3
        L_0x001f:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.V(int):androidx.constraintlayout.core.widgets.ConstraintWidget");
    }

    public void V0() {
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        int size = this.Z.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.Z.get(i2).y();
        }
    }

    public void V1(float f2) {
        this.r0 = f2;
    }

    /* access modifiers changed from: package-private */
    public int W(int i2) {
        if (i2 == 0) {
            return this.j0;
        }
        if (i2 == 1) {
            return this.k0;
        }
        return 0;
    }

    public void W0(Cache cache) {
        this.Q.z(cache);
        this.R.z(cache);
        this.S.z(cache);
        this.T.z(cache);
        this.U.z(cache);
        this.X.z(cache);
        this.V.z(cache);
        this.W.z(cache);
    }

    public void W1(int i2) {
        this.K0 = i2;
    }

    public int X() {
        return o0() + this.d0;
    }

    public void X0() {
        this.r = false;
        this.s = false;
    }

    public void X1(int i2, int i3) {
        this.i0 = i2;
        int i4 = i3 - i2;
        this.e0 = i4;
        int i5 = this.p0;
        if (i4 < i5) {
            this.e0 = i5;
        }
    }

    /* access modifiers changed from: protected */
    public int Y() {
        return this.h0 + this.l0;
    }

    public StringBuilder Y0(StringBuilder sb) {
        sb.append("{\n");
        Z0(sb, "left", this.Q);
        Z0(sb, "top", this.R);
        Z0(sb, "right", this.S);
        Z0(sb, "bottom", this.T);
        Z0(sb, HtmlTags.i0, this.U);
        Z0(sb, "centerX", this.V);
        Z0(sb, "centerY", this.W);
        c1(sb, this.X, this.K);
        e1(sb, "width", this.d0, this.o0, this.J[0], this.f4199l, this.z, this.w, this.B, this.N0[0]);
        e1(sb, "height", this.e0, this.p0, this.J[1], this.f4200m, this.C, this.x, this.E, this.N0[1]);
        d1(sb, "dimensionRatio", this.f0, this.g0);
        a1(sb, "horizontalBias", this.q0, z1);
        a1(sb, "verticalBias", this.r0, z1);
        sb.append("}\n");
        return sb;
    }

    public void Y1(DimensionBehaviour dimensionBehaviour) {
        this.b0[1] = dimensionBehaviour;
    }

    /* access modifiers changed from: protected */
    public int Z() {
        return this.i0 + this.m0;
    }

    public void Z1(int i2, int i3, int i4, float f2) {
        this.x = i2;
        this.C = i3;
        if (i4 == Integer.MAX_VALUE) {
            i4 = 0;
        }
        this.D = i4;
        this.E = f2;
        if (f2 > 0.0f && f2 < 1.0f && i2 == 0) {
            this.x = 2;
        }
    }

    public WidgetRun a0(int i2) {
        if (i2 == 0) {
            return this.f4192e;
        }
        if (i2 == 1) {
            return this.f4193f;
        }
        return null;
    }

    public void a2(float f2) {
        this.N0[1] = f2;
    }

    public void b0(StringBuilder sb) {
        sb.append("  " + this.o + ":{\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("    actualWidth:");
        sb2.append(this.d0);
        sb.append(sb2.toString());
        sb.append(StringUtils.LF);
        sb.append("    actualHeight:" + this.e0);
        sb.append(StringUtils.LF);
        sb.append("    actualLeft:" + this.h0);
        sb.append(StringUtils.LF);
        sb.append("    actualTop:" + this.i0);
        sb.append(StringUtils.LF);
        d0(sb, "left", this.Q);
        d0(sb, "top", this.R);
        d0(sb, "right", this.S);
        d0(sb, "bottom", this.T);
        d0(sb, HtmlTags.i0, this.U);
        d0(sb, "centerX", this.V);
        d0(sb, "centerY", this.W);
        c0(sb, "    width", this.d0, this.o0, this.J[0], this.f4199l, this.z, this.w, this.B, this.N0[0]);
        c0(sb, "    height", this.e0, this.p0, this.J[1], this.f4200m, this.C, this.x, this.E, this.N0[1]);
        d1(sb, "    dimensionRatio", this.f0, this.g0);
        a1(sb, "    horizontalBias", this.q0, z1);
        a1(sb, "    verticalBias", this.r0, z1);
        b1(sb, "    horizontalChainStyle", this.J0, 0);
        b1(sb, "    verticalChainStyle", this.K0, 0);
        sb.append("  }");
    }

    public void b2(int i2) {
        this.u0 = i2;
    }

    public void c2(int i2) {
        this.d0 = i2;
        int i3 = this.o0;
        if (i2 < i3) {
            this.d0 = i3;
        }
    }

    public void d2(boolean z2) {
        this.F = z2;
    }

    public void e(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet<ConstraintWidget> hashSet, int i2, boolean z2) {
        if (z2) {
            if (hashSet.contains(this)) {
                Optimizer.a(constraintWidgetContainer, linearSystem, this);
                hashSet.remove(this);
                g(linearSystem, constraintWidgetContainer.S2(64));
            } else {
                return;
            }
        }
        if (i2 == 0) {
            HashSet<ConstraintAnchor> e2 = this.Q.e();
            if (e2 != null) {
                Iterator<ConstraintAnchor> it2 = e2.iterator();
                while (it2.hasNext()) {
                    it2.next().f4181d.e(constraintWidgetContainer, linearSystem, hashSet, i2, true);
                }
            }
            HashSet<ConstraintAnchor> e3 = this.S.e();
            if (e3 != null) {
                Iterator<ConstraintAnchor> it3 = e3.iterator();
                while (it3.hasNext()) {
                    it3.next().f4181d.e(constraintWidgetContainer, linearSystem, hashSet, i2, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> e4 = this.R.e();
        if (e4 != null) {
            Iterator<ConstraintAnchor> it4 = e4.iterator();
            while (it4.hasNext()) {
                it4.next().f4181d.e(constraintWidgetContainer, linearSystem, hashSet, i2, true);
            }
        }
        HashSet<ConstraintAnchor> e5 = this.T.e();
        if (e5 != null) {
            Iterator<ConstraintAnchor> it5 = e5.iterator();
            while (it5.hasNext()) {
                it5.next().f4181d.e(constraintWidgetContainer, linearSystem, hashSet, i2, true);
            }
        }
        HashSet<ConstraintAnchor> e6 = this.U.e();
        if (e6 != null) {
            Iterator<ConstraintAnchor> it6 = e6.iterator();
            while (it6.hasNext()) {
                it6.next().f4181d.e(constraintWidgetContainer, linearSystem, hashSet, i2, true);
            }
        }
    }

    public int e0() {
        return p0();
    }

    public void e2(int i2) {
        if (i2 >= 0 && i2 <= 3) {
            this.v = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return (this instanceof VirtualLayout) || (this instanceof Guideline);
    }

    public String f0() {
        return this.x0;
    }

    public void f1(boolean z2) {
        this.v0 = z2;
    }

    public void f2(int i2) {
        this.h0 = i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:202:0x0300  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0302  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0305  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0308  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0343  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x038d  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x0448  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x04ac  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x04c0  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x04c2  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x04c9  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x055e  */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x0561  */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x05a2  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x05aa  */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x05d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(androidx.constraintlayout.core.LinearSystem r54, boolean r55) {
        /*
            r53 = this;
            r15 = r53
            r14 = r54
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.Q
            androidx.constraintlayout.core.SolverVariable r13 = r14.u(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.S
            androidx.constraintlayout.core.SolverVariable r12 = r14.u(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.R
            androidx.constraintlayout.core.SolverVariable r11 = r14.u(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.T
            androidx.constraintlayout.core.SolverVariable r10 = r14.u(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.U
            androidx.constraintlayout.core.SolverVariable r9 = r14.u(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            r8 = 2
            r1 = 3
            r7 = 1
            r6 = 0
            if (r0 == 0) goto L_0x004f
            if (r0 == 0) goto L_0x0036
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r0.b0
            r2 = r2[r6]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r3) goto L_0x0036
            r2 = 1
            goto L_0x0037
        L_0x0036:
            r2 = 0
        L_0x0037:
            if (r0 == 0) goto L_0x0043
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r0.b0
            r0 = r0[r7]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r3) goto L_0x0043
            r0 = 1
            goto L_0x0044
        L_0x0043:
            r0 = 0
        L_0x0044:
            int r3 = r15.v
            if (r3 == r7) goto L_0x0055
            if (r3 == r8) goto L_0x0052
            if (r3 == r1) goto L_0x004f
            r5 = r0
            r4 = r2
            goto L_0x0057
        L_0x004f:
            r4 = 0
        L_0x0050:
            r5 = 0
            goto L_0x0057
        L_0x0052:
            r5 = r0
            r4 = 0
            goto L_0x0057
        L_0x0055:
            r4 = r2
            goto L_0x0050
        L_0x0057:
            int r0 = r15.u0
            r3 = 8
            if (r0 != r3) goto L_0x0072
            boolean r0 = r15.v0
            if (r0 != 0) goto L_0x0072
            boolean r0 = r53.s0()
            if (r0 != 0) goto L_0x0072
            boolean[] r0 = r15.a0
            boolean r2 = r0[r6]
            if (r2 != 0) goto L_0x0072
            boolean r0 = r0[r7]
            if (r0 != 0) goto L_0x0072
            return
        L_0x0072:
            boolean r0 = r15.p
            r2 = 5
            if (r0 != 0) goto L_0x007b
            boolean r8 = r15.q
            if (r8 == 0) goto L_0x00f8
        L_0x007b:
            if (r0 == 0) goto L_0x00aa
            int r0 = r15.h0
            r14.f(r13, r0)
            int r0 = r15.h0
            int r8 = r15.d0
            int r0 = r0 + r8
            r14.f(r12, r0)
            if (r4 == 0) goto L_0x00aa
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            if (r0 == 0) goto L_0x00aa
            boolean r8 = r15.f4198k
            if (r8 == 0) goto L_0x00a1
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r15.Q
            r0.u2(r8)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r15.S
            r0.t2(r8)
            goto L_0x00aa
        L_0x00a1:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.S
            androidx.constraintlayout.core.SolverVariable r0 = r14.u(r0)
            r14.i(r0, r12, r6, r2)
        L_0x00aa:
            boolean r0 = r15.q
            if (r0 == 0) goto L_0x00eb
            int r0 = r15.i0
            r14.f(r11, r0)
            int r0 = r15.i0
            int r8 = r15.e0
            int r0 = r0 + r8
            r14.f(r10, r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.U
            boolean r0 = r0.n()
            if (r0 == 0) goto L_0x00cb
            int r0 = r15.i0
            int r8 = r15.n0
            int r0 = r0 + r8
            r14.f(r9, r0)
        L_0x00cb:
            if (r5 == 0) goto L_0x00eb
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            if (r0 == 0) goto L_0x00eb
            boolean r8 = r15.f4198k
            if (r8 == 0) goto L_0x00e2
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r15.R
            r0.z2(r8)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r15.T
            r0.y2(r8)
            goto L_0x00eb
        L_0x00e2:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.T
            androidx.constraintlayout.core.SolverVariable r0 = r14.u(r0)
            r14.i(r0, r10, r6, r2)
        L_0x00eb:
            boolean r0 = r15.p
            if (r0 == 0) goto L_0x00f8
            boolean r0 = r15.q
            if (r0 == 0) goto L_0x00f8
            r15.p = r6
            r15.q = r6
            return
        L_0x00f8:
            androidx.constraintlayout.core.Metrics r0 = androidx.constraintlayout.core.LinearSystem.C
            r17 = 1
            if (r0 == 0) goto L_0x0104
            long r1 = r0.K
            long r1 = r1 + r17
            r0.K = r1
        L_0x0104:
            if (r55 == 0) goto L_0x0193
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r1 = r15.f4192e
            if (r1 == 0) goto L_0x0193
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r2 = r15.f4193f
            if (r2 == 0) goto L_0x0193
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r8 = r1.f4333h
            boolean r7 = r8.f4282j
            if (r7 == 0) goto L_0x0193
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r1.f4334i
            boolean r1 = r1.f4282j
            if (r1 == 0) goto L_0x0193
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r2.f4333h
            boolean r1 = r1.f4282j
            if (r1 == 0) goto L_0x0193
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r2.f4334i
            boolean r1 = r1.f4282j
            if (r1 == 0) goto L_0x0193
            if (r0 == 0) goto L_0x012e
            long r1 = r0.w
            long r1 = r1 + r17
            r0.w = r1
        L_0x012e:
            int r0 = r8.f4279g
            r14.f(r13, r0)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r0 = r15.f4192e
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f4334i
            int r0 = r0.f4279g
            r14.f(r12, r0)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f4333h
            int r0 = r0.f4279g
            r14.f(r11, r0)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f4334i
            int r0 = r0.f4279g
            r14.f(r10, r0)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f4307k
            int r0 = r0.f4279g
            r14.f(r9, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            if (r0 == 0) goto L_0x018e
            if (r4 == 0) goto L_0x0174
            boolean[] r0 = r15.f4194g
            boolean r0 = r0[r6]
            if (r0 == 0) goto L_0x0174
            boolean r0 = r53.B0()
            if (r0 != 0) goto L_0x0174
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.S
            androidx.constraintlayout.core.SolverVariable r0 = r14.u(r0)
            r14.i(r0, r12, r6, r3)
        L_0x0174:
            if (r5 == 0) goto L_0x018e
            boolean[] r0 = r15.f4194g
            r1 = 1
            boolean r0 = r0[r1]
            if (r0 == 0) goto L_0x018e
            boolean r0 = r53.D0()
            if (r0 != 0) goto L_0x018e
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.T
            androidx.constraintlayout.core.SolverVariable r0 = r14.u(r0)
            r14.i(r0, r10, r6, r3)
        L_0x018e:
            r15.p = r6
            r15.q = r6
            return
        L_0x0193:
            if (r0 == 0) goto L_0x019b
            long r1 = r0.x
            long r1 = r1 + r17
            r0.x = r1
        L_0x019b:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            if (r0 == 0) goto L_0x0210
            boolean r0 = r15.x0(r6)
            if (r0 == 0) goto L_0x01af
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r0
            r0.q2(r15, r6)
            r0 = 1
        L_0x01ad:
            r1 = 1
            goto L_0x01b4
        L_0x01af:
            boolean r0 = r53.B0()
            goto L_0x01ad
        L_0x01b4:
            boolean r2 = r15.x0(r1)
            if (r2 == 0) goto L_0x01c3
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r15.c0
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r2 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r2
            r2.q2(r15, r1)
            r1 = 1
            goto L_0x01c7
        L_0x01c3:
            boolean r1 = r53.D0()
        L_0x01c7:
            if (r0 != 0) goto L_0x01e7
            if (r4 == 0) goto L_0x01e7
            int r2 = r15.u0
            if (r2 == r3) goto L_0x01e7
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f4183f
            if (r2 != 0) goto L_0x01e7
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f4183f
            if (r2 != 0) goto L_0x01e7
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r15.c0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.S
            androidx.constraintlayout.core.SolverVariable r2 = r14.u(r2)
            r7 = 1
            r14.i(r2, r12, r6, r7)
        L_0x01e7:
            if (r1 != 0) goto L_0x020b
            if (r5 == 0) goto L_0x020b
            int r2 = r15.u0
            if (r2 == r3) goto L_0x020b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f4183f
            if (r2 != 0) goto L_0x020b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f4183f
            if (r2 != 0) goto L_0x020b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.U
            if (r2 != 0) goto L_0x020b
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r15.c0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.T
            androidx.constraintlayout.core.SolverVariable r2 = r14.u(r2)
            r7 = 1
            r14.i(r2, r10, r6, r7)
        L_0x020b:
            r29 = r0
            r28 = r1
            goto L_0x0214
        L_0x0210:
            r28 = 0
            r29 = 0
        L_0x0214:
            int r0 = r15.d0
            int r1 = r15.o0
            if (r0 >= r1) goto L_0x021b
            goto L_0x021c
        L_0x021b:
            r1 = r0
        L_0x021c:
            int r2 = r15.e0
            int r7 = r15.p0
            if (r2 >= r7) goto L_0x0223
            goto L_0x0224
        L_0x0223:
            r7 = r2
        L_0x0224:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r15.b0
            r3 = r8[r6]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r22 = r1
            if (r3 == r6) goto L_0x0232
            r1 = 1
        L_0x022f:
            r21 = 1
            goto L_0x0234
        L_0x0232:
            r1 = 0
            goto L_0x022f
        L_0x0234:
            r8 = r8[r21]
            r23 = r7
            r27 = r9
            if (r8 == r6) goto L_0x023e
            r7 = 1
            goto L_0x023f
        L_0x023e:
            r7 = 0
        L_0x023f:
            int r9 = r15.g0
            r15.H = r9
            r30 = r10
            float r10 = r15.f0
            r15.I = r10
            r31 = r11
            int r11 = r15.w
            r32 = r12
            int r12 = r15.x
            r24 = 0
            r33 = r13
            int r24 = (r10 > r24 ? 1 : (r10 == r24 ? 0 : -1))
            if (r24 <= 0) goto L_0x02c3
            int r13 = r15.u0
            r14 = 8
            if (r13 == r14) goto L_0x02c3
            if (r3 != r6) goto L_0x0264
            if (r11 != 0) goto L_0x0264
            r11 = 3
        L_0x0264:
            if (r8 != r6) goto L_0x0269
            if (r12 != 0) goto L_0x0269
            r12 = 3
        L_0x0269:
            if (r3 != r6) goto L_0x0276
            if (r8 != r6) goto L_0x0276
            r13 = 3
            if (r11 != r13) goto L_0x0277
            if (r12 != r13) goto L_0x0277
            r15.h2(r4, r5, r1, r7)
            goto L_0x02bc
        L_0x0276:
            r13 = 3
        L_0x0277:
            r1 = 4
            if (r3 != r6) goto L_0x0296
            if (r11 != r13) goto L_0x0296
            r7 = 0
            r15.H = r7
            float r0 = (float) r2
            float r10 = r10 * r0
            int r0 = (int) r10
            r1 = r0
            if (r8 == r6) goto L_0x028e
            r35 = r12
            r34 = r23
            r14 = 0
            r36 = 4
            goto L_0x02cc
        L_0x028e:
            r36 = r11
            r35 = r12
        L_0x0292:
            r34 = r23
        L_0x0294:
            r14 = 1
            goto L_0x02cc
        L_0x0296:
            if (r8 != r6) goto L_0x02bc
            if (r12 != r13) goto L_0x02bc
            r2 = 1
            r15.H = r2
            r2 = -1
            if (r9 != r2) goto L_0x02a5
            r2 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 / r10
            r15.I = r2
        L_0x02a5:
            float r2 = r15.I
            float r0 = (float) r0
            float r2 = r2 * r0
            int r7 = (int) r2
            r34 = r7
            r36 = r11
            if (r3 == r6) goto L_0x02b7
            r1 = r22
            r14 = 0
            r35 = 4
            goto L_0x02cc
        L_0x02b7:
            r35 = r12
            r1 = r22
            goto L_0x0294
        L_0x02bc:
            r36 = r11
            r35 = r12
            r1 = r22
            goto L_0x0292
        L_0x02c3:
            r36 = r11
            r35 = r12
            r1 = r22
            r34 = r23
            r14 = 0
        L_0x02cc:
            int[] r0 = r15.y
            r2 = 0
            r0[r2] = r36
            r2 = 1
            r0[r2] = r35
            r15.f4195h = r14
            if (r14 == 0) goto L_0x02e2
            int r0 = r15.H
            r2 = -1
            if (r0 == 0) goto L_0x02df
            if (r0 != r2) goto L_0x02e3
        L_0x02df:
            r20 = 1
            goto L_0x02e5
        L_0x02e2:
            r2 = -1
        L_0x02e3:
            r20 = 0
        L_0x02e5:
            if (r14 == 0) goto L_0x02f1
            int r0 = r15.H
            r3 = 1
            if (r0 == r3) goto L_0x02ee
            if (r0 != r2) goto L_0x02f1
        L_0x02ee:
            r37 = 1
            goto L_0x02f3
        L_0x02f1:
            r37 = 0
        L_0x02f3:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.b0
            r2 = 0
            r0 = r0[r2]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r13) goto L_0x0302
            boolean r0 = r15 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x0302
            r9 = 1
            goto L_0x0303
        L_0x0302:
            r9 = 0
        L_0x0303:
            if (r9 == 0) goto L_0x0308
            r22 = 0
            goto L_0x030a
        L_0x0308:
            r22 = r1
        L_0x030a:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.X
            boolean r0 = r0.p()
            r1 = 1
            r38 = r0 ^ 1
            boolean[] r0 = r15.a0
            r2 = 0
            boolean r23 = r0[r2]
            boolean r39 = r0[r1]
            int r0 = r15.t
            r40 = 0
            r8 = 2
            if (r0 == r8) goto L_0x038f
            boolean r0 = r15.p
            if (r0 != 0) goto L_0x038f
            if (r55 == 0) goto L_0x0337
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r0 = r15.f4192e
            if (r0 == 0) goto L_0x0337
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r0.f4333h
            boolean r2 = r1.f4282j
            if (r2 == 0) goto L_0x0337
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f4334i
            boolean r0 = r0.f4282j
            if (r0 != 0) goto L_0x0341
        L_0x0337:
            r12 = r54
            r10 = r32
            r11 = r33
            r3 = 8
            goto L_0x03a5
        L_0x0341:
            if (r55 == 0) goto L_0x038d
            int r0 = r1.f4279g
            r12 = r54
            r11 = r33
            r12.f(r11, r0)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r0 = r15.f4192e
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f4334i
            int r0 = r0.f4279g
            r10 = r32
            r12.f(r10, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            if (r0 == 0) goto L_0x0377
            if (r4 == 0) goto L_0x0377
            boolean[] r0 = r15.f4194g
            r1 = 0
            boolean r0 = r0[r1]
            if (r0 == 0) goto L_0x0377
            boolean r0 = r53.B0()
            if (r0 != 0) goto L_0x0377
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.S
            androidx.constraintlayout.core.SolverVariable r0 = r12.u(r0)
            r3 = 8
            r12.i(r0, r10, r1, r3)
        L_0x0377:
            r46 = r4
            r47 = r5
            r48 = r6
            r52 = r13
            r32 = r14
            r49 = r27
            r50 = r30
            r51 = r31
            r30 = r10
            r31 = r11
            goto L_0x0446
        L_0x038d:
            r12 = r54
        L_0x038f:
            r46 = r4
            r47 = r5
            r48 = r6
            r52 = r13
            r49 = r27
            r50 = r30
            r51 = r31
            r30 = r32
            r31 = r33
            r32 = r14
            goto L_0x0446
        L_0x03a5:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            if (r0 == 0) goto L_0x03b1
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.S
            androidx.constraintlayout.core.SolverVariable r0 = r12.u(r0)
            r7 = r0
            goto L_0x03b3
        L_0x03b1:
            r7 = r40
        L_0x03b3:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            if (r0 == 0) goto L_0x03c0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.Q
            androidx.constraintlayout.core.SolverVariable r0 = r12.u(r0)
            r16 = r0
            goto L_0x03c2
        L_0x03c0:
            r16 = r40
        L_0x03c2:
            boolean[] r0 = r15.f4194g
            r17 = 0
            boolean r18 = r0[r17]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.b0
            r32 = r0[r17]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r15.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.S
            r33 = r2
            int r2 = r15.h0
            r41 = r2
            int r2 = r15.o0
            int[] r3 = r15.J
            r43 = r3[r17]
            float r3 = r15.q0
            r21 = 1
            r0 = r0[r21]
            if (r0 != r6) goto L_0x03e7
            r44 = 1
            goto L_0x03e9
        L_0x03e7:
            r44 = 0
        L_0x03e9:
            int r0 = r15.z
            r24 = r0
            int r0 = r15.A
            r25 = r0
            float r0 = r15.B
            r26 = r0
            r0 = 1
            r19 = r33
            r33 = r41
            r41 = r2
            r2 = r0
            r0 = r53
            r45 = r1
            r1 = r54
            r42 = r3
            r3 = r4
            r46 = r4
            r4 = r5
            r47 = r5
            r5 = r18
            r48 = r6
            r6 = r16
            r8 = r32
            r49 = r27
            r16 = r10
            r50 = r30
            r10 = r45
            r17 = r11
            r51 = r31
            r11 = r19
            r30 = r16
            r12 = r33
            r52 = r13
            r31 = r17
            r13 = r22
            r32 = r14
            r14 = r41
            r15 = r43
            r16 = r42
            r17 = r20
            r18 = r44
            r19 = r29
            r20 = r28
            r21 = r23
            r22 = r36
            r23 = r35
            r27 = r38
            r0.i(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
        L_0x0446:
            if (r55 == 0) goto L_0x04ac
            r15 = r53
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.f4193f
            if (r0 == 0) goto L_0x049f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r0.f4333h
            boolean r2 = r1.f4282j
            if (r2 == 0) goto L_0x049f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f4334i
            boolean r0 = r0.f4282j
            if (r0 == 0) goto L_0x049f
            int r0 = r1.f4279g
            r14 = r54
            r13 = r51
            r14.f(r13, r0)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f4334i
            int r0 = r0.f4279g
            r12 = r50
            r14.f(r12, r0)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r15.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f4307k
            int r0 = r0.f4279g
            r1 = r49
            r14.f(r1, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            if (r0 == 0) goto L_0x0499
            if (r28 != 0) goto L_0x0499
            if (r47 == 0) goto L_0x0499
            boolean[] r2 = r15.f4194g
            r11 = 1
            boolean r2 = r2[r11]
            if (r2 == 0) goto L_0x0495
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.T
            androidx.constraintlayout.core.SolverVariable r0 = r14.u(r0)
            r2 = 8
            r10 = 0
            r14.i(r0, r12, r10, r2)
            goto L_0x049d
        L_0x0495:
            r2 = 8
            r10 = 0
            goto L_0x049d
        L_0x0499:
            r2 = 8
            r10 = 0
            r11 = 1
        L_0x049d:
            r7 = 0
            goto L_0x04bb
        L_0x049f:
            r14 = r54
            r1 = r49
            r12 = r50
            r13 = r51
            r2 = 8
            r10 = 0
            r11 = 1
            goto L_0x04ba
        L_0x04ac:
            r2 = 8
            r10 = 0
            r11 = 1
            r15 = r53
            r14 = r54
            r1 = r49
            r12 = r50
            r13 = r51
        L_0x04ba:
            r7 = 1
        L_0x04bb:
            int r0 = r15.u
            r3 = 2
            if (r0 != r3) goto L_0x04c2
            r6 = 0
            goto L_0x04c3
        L_0x04c2:
            r6 = r7
        L_0x04c3:
            if (r6 == 0) goto L_0x05a2
            boolean r0 = r15.q
            if (r0 != 0) goto L_0x05a2
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.b0
            r0 = r0[r11]
            r3 = r52
            if (r0 != r3) goto L_0x04d7
            boolean r0 = r15 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x04d7
            r9 = 1
            goto L_0x04d8
        L_0x04d7:
            r9 = 0
        L_0x04d8:
            if (r9 == 0) goto L_0x04dc
            r34 = 0
        L_0x04dc:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            if (r0 == 0) goto L_0x04e8
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.T
            androidx.constraintlayout.core.SolverVariable r0 = r14.u(r0)
            r7 = r0
            goto L_0x04ea
        L_0x04e8:
            r7 = r40
        L_0x04ea:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.c0
            if (r0 == 0) goto L_0x04f6
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.R
            androidx.constraintlayout.core.SolverVariable r0 = r14.u(r0)
            r6 = r0
            goto L_0x04f8
        L_0x04f6:
            r6 = r40
        L_0x04f8:
            int r0 = r15.n0
            if (r0 > 0) goto L_0x0500
            int r0 = r15.u0
            if (r0 != r2) goto L_0x053e
        L_0x0500:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.U
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r0.f4183f
            if (r3 == 0) goto L_0x052d
            int r0 = r53.t()
            r14.e(r1, r13, r0, r2)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.U
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.f4183f
            androidx.constraintlayout.core.SolverVariable r0 = r14.u(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.U
            int r3 = r3.g()
            r14.e(r1, r0, r3, r2)
            if (r47 == 0) goto L_0x052a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.T
            androidx.constraintlayout.core.SolverVariable r0 = r14.u(r0)
            r1 = 5
            r14.i(r7, r0, r10, r1)
        L_0x052a:
            r27 = 0
            goto L_0x0540
        L_0x052d:
            int r3 = r15.u0
            if (r3 != r2) goto L_0x0539
            int r0 = r0.g()
        L_0x0535:
            r14.e(r1, r13, r0, r2)
            goto L_0x053e
        L_0x0539:
            int r0 = r53.t()
            goto L_0x0535
        L_0x053e:
            r27 = r38
        L_0x0540:
            boolean[] r0 = r15.f4194g
            boolean r5 = r0[r11]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.b0
            r8 = r0[r11]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r15.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.T
            int r1 = r15.i0
            int r2 = r15.p0
            int[] r10 = r15.J
            r16 = r10[r11]
            float r10 = r15.r0
            r17 = 0
            r0 = r0[r17]
            r11 = r48
            if (r0 != r11) goto L_0x0561
            r18 = 1
            goto L_0x0563
        L_0x0561:
            r18 = 0
        L_0x0563:
            int r0 = r15.C
            r24 = r0
            int r0 = r15.D
            r25 = r0
            float r0 = r15.E
            r26 = r0
            r0 = 0
            r19 = r2
            r2 = r0
            r0 = r53
            r20 = r1
            r1 = r54
            r11 = r3
            r3 = r47
            r21 = r4
            r4 = r46
            r17 = r10
            r10 = r21
            r33 = r12
            r12 = r20
            r38 = r13
            r13 = r34
            r14 = r19
            r15 = r16
            r16 = r17
            r17 = r37
            r19 = r28
            r20 = r29
            r21 = r39
            r22 = r35
            r23 = r36
            r0.i(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x05a6
        L_0x05a2:
            r33 = r12
            r38 = r13
        L_0x05a6:
            r7 = r53
            if (r32 == 0) goto L_0x05cc
            int r0 = r7.H
            r6 = 8
            r1 = 1
            float r5 = r7.I
            if (r0 != r1) goto L_0x05c1
            r0 = r54
            r1 = r33
            r2 = r38
            r3 = r30
            r4 = r31
        L_0x05bd:
            r0.l(r1, r2, r3, r4, r5, r6)
            goto L_0x05cc
        L_0x05c1:
            r0 = r54
            r1 = r30
            r2 = r31
            r3 = r33
            r4 = r38
            goto L_0x05bd
        L_0x05cc:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r7.X
            boolean r0 = r0.p()
            if (r0 == 0) goto L_0x05f4
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r7.X
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.k()
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.i()
            float r1 = r7.K
            r2 = 1119092736(0x42b40000, float:90.0)
            float r1 = r1 + r2
            double r1 = (double) r1
            double r1 = java.lang.Math.toRadians(r1)
            float r1 = (float) r1
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r7.X
            int r2 = r2.g()
            r3 = r54
            r3.b(r7, r0, r1, r2)
        L_0x05f4:
            r0 = 0
            r7.p = r0
            r7.q = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.g(androidx.constraintlayout.core.LinearSystem, boolean):void");
    }

    public float g0() {
        return this.r0;
    }

    public void g1(int i2) {
        this.n0 = i2;
        this.L = i2 > 0;
    }

    public void g2(int i2) {
        this.i0 = i2;
    }

    public boolean h() {
        return this.u0 != 8;
    }

    public ConstraintWidget h0() {
        if (!D0()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor r2 = constraintWidget.r(ConstraintAnchor.Type.TOP);
            ConstraintAnchor k2 = r2 == null ? null : r2.k();
            ConstraintWidget i2 = k2 == null ? null : k2.i();
            if (i2 == U()) {
                return constraintWidget;
            }
            ConstraintAnchor k3 = i2 == null ? null : i2.r(ConstraintAnchor.Type.BOTTOM).k();
            if (k3 == null || k3.i() == constraintWidget) {
                constraintWidget = i2;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public void h1(Object obj) {
        this.s0 = obj;
    }

    public void h2(boolean z2, boolean z3, boolean z4, boolean z5) {
        if (this.H == -1) {
            if (z4 && !z5) {
                this.H = 0;
            } else if (!z4 && z5) {
                this.H = 1;
                if (this.g0 == -1) {
                    this.I = 1.0f / this.I;
                }
            }
        }
        if (this.H == 0 && (!this.R.p() || !this.T.p())) {
            this.H = 1;
        } else if (this.H == 1 && (!this.Q.p() || !this.S.p())) {
            this.H = 0;
        }
        if (this.H == -1 && (!this.R.p() || !this.T.p() || !this.Q.p() || !this.S.p())) {
            if (this.R.p() && this.T.p()) {
                this.H = 0;
            } else if (this.Q.p() && this.S.p()) {
                this.I = 1.0f / this.I;
                this.H = 1;
            }
        }
        if (this.H == -1) {
            int i2 = this.z;
            if (i2 > 0 && this.C == 0) {
                this.H = 0;
            } else if (i2 == 0 && this.C > 0) {
                this.I = 1.0f / this.I;
                this.H = 1;
            }
        }
    }

    public int i0() {
        return this.K0;
    }

    public void i1(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.t0 = i2;
    }

    public void i2(boolean z2, boolean z3) {
        int i2;
        int i3;
        boolean m2 = z2 & this.f4192e.m();
        boolean m3 = z3 & this.f4193f.m();
        HorizontalWidgetRun horizontalWidgetRun = this.f4192e;
        int i4 = horizontalWidgetRun.f4333h.f4279g;
        VerticalWidgetRun verticalWidgetRun = this.f4193f;
        int i5 = verticalWidgetRun.f4333h.f4279g;
        int i6 = horizontalWidgetRun.f4334i.f4279g;
        int i7 = verticalWidgetRun.f4334i.f4279g;
        int i8 = i7 - i5;
        if (i6 - i4 < 0 || i8 < 0 || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE) {
            i6 = 0;
            i4 = 0;
            i7 = 0;
            i5 = 0;
        }
        int i9 = i6 - i4;
        int i10 = i7 - i5;
        if (m2) {
            this.h0 = i4;
        }
        if (m3) {
            this.i0 = i5;
        }
        if (this.u0 == 8) {
            this.d0 = 0;
            this.e0 = 0;
            return;
        }
        if (m2) {
            if (this.b0[0] == DimensionBehaviour.FIXED && i9 < (i3 = this.d0)) {
                i9 = i3;
            }
            this.d0 = i9;
            int i11 = this.o0;
            if (i9 < i11) {
                this.d0 = i11;
            }
        }
        if (m3) {
            if (this.b0[1] == DimensionBehaviour.FIXED && i10 < (i2 = this.e0)) {
                i10 = i2;
            }
            this.e0 = i10;
            int i12 = this.p0;
            if (i10 < i12) {
                this.e0 = i12;
            }
        }
    }

    public void j(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        k(type, constraintWidget, type2, 0);
    }

    public DimensionBehaviour j0() {
        return this.b0[1];
    }

    public void j1(String str) {
        this.w0 = str;
    }

    public void j2(LinearSystem linearSystem, boolean z2) {
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
        int O2 = linearSystem.O(this.Q);
        int O3 = linearSystem.O(this.R);
        int O4 = linearSystem.O(this.S);
        int O5 = linearSystem.O(this.T);
        if (z2 && (horizontalWidgetRun = this.f4192e) != null) {
            DependencyNode dependencyNode = horizontalWidgetRun.f4333h;
            if (dependencyNode.f4282j) {
                DependencyNode dependencyNode2 = horizontalWidgetRun.f4334i;
                if (dependencyNode2.f4282j) {
                    O2 = dependencyNode.f4279g;
                    O4 = dependencyNode2.f4279g;
                }
            }
        }
        if (z2 && (verticalWidgetRun = this.f4193f) != null) {
            DependencyNode dependencyNode3 = verticalWidgetRun.f4333h;
            if (dependencyNode3.f4282j) {
                DependencyNode dependencyNode4 = verticalWidgetRun.f4334i;
                if (dependencyNode4.f4282j) {
                    O3 = dependencyNode3.f4279g;
                    O5 = dependencyNode4.f4279g;
                }
            }
        }
        int i2 = O5 - O3;
        if (O4 - O2 < 0 || i2 < 0 || O2 == Integer.MIN_VALUE || O2 == Integer.MAX_VALUE || O3 == Integer.MIN_VALUE || O3 == Integer.MAX_VALUE || O4 == Integer.MIN_VALUE || O4 == Integer.MAX_VALUE || O5 == Integer.MIN_VALUE || O5 == Integer.MAX_VALUE) {
            O2 = 0;
            O5 = 0;
            O3 = 0;
            O4 = 0;
        }
        v1(O2, O3, O4, O5);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:72:0x015c, code lost:
        if (r11 != null) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x018d, code lost:
        if (r11.p() != false) goto L_0x018f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01bc, code lost:
        if (r11.p() != false) goto L_0x018f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k(androidx.constraintlayout.core.widgets.ConstraintAnchor.Type r9, androidx.constraintlayout.core.widgets.ConstraintWidget r10, androidx.constraintlayout.core.widgets.ConstraintAnchor.Type r11, int r12) {
        /*
            r8 = this;
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER
            r1 = 0
            if (r9 != r0) goto L_0x00a3
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r9 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            if (r11 != r0) goto L_0x0074
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r8.r(r9)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r12 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r8.r(r12)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r8.r(r3)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r8.r(r5)
            r7 = 1
            if (r11 == 0) goto L_0x0028
            boolean r11 = r11.p()
            if (r11 != 0) goto L_0x0030
        L_0x0028:
            if (r2 == 0) goto L_0x0032
            boolean r11 = r2.p()
            if (r11 == 0) goto L_0x0032
        L_0x0030:
            r9 = 0
            goto L_0x0039
        L_0x0032:
            r8.k(r9, r10, r9, r1)
            r8.k(r12, r10, r12, r1)
            r9 = 1
        L_0x0039:
            if (r4 == 0) goto L_0x0041
            boolean r11 = r4.p()
            if (r11 != 0) goto L_0x0049
        L_0x0041:
            if (r6 == 0) goto L_0x004b
            boolean r11 = r6.p()
            if (r11 == 0) goto L_0x004b
        L_0x0049:
            r7 = 0
            goto L_0x0051
        L_0x004b:
            r8.k(r3, r10, r3, r1)
            r8.k(r5, r10, r5, r1)
        L_0x0051:
            if (r9 == 0) goto L_0x005e
            if (r7 == 0) goto L_0x005e
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r8.r(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r10.r(r0)
            goto L_0x0093
        L_0x005e:
            if (r9 == 0) goto L_0x006f
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r9 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_X
        L_0x0062:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r8.r(r9)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.r(r9)
            r11.a(r9, r1)
            goto L_0x01c2
        L_0x006f:
            if (r7 == 0) goto L_0x01c2
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r9 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_Y
            goto L_0x0062
        L_0x0074:
            if (r11 == r9) goto L_0x0098
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r12 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            if (r11 != r12) goto L_0x007b
            goto L_0x0098
        L_0x007b:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r9 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            if (r11 == r9) goto L_0x0083
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r12 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            if (r11 != r12) goto L_0x01c2
        L_0x0083:
            r8.k(r9, r10, r11, r1)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r9 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            r8.k(r9, r10, r11, r1)
        L_0x008b:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r8.r(r0)
        L_0x008f:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r10.r(r11)
        L_0x0093:
            r9.a(r10, r1)
            goto L_0x01c2
        L_0x0098:
            r8.k(r9, r10, r11, r1)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r9 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            r8.k(r9, r10, r11, r1)     // Catch:{ all -> 0x00a1 }
            goto L_0x008b
        L_0x00a1:
            r9 = move-exception
            throw r9
        L_0x00a3:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_X
            if (r9 != r2) goto L_0x00c8
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            if (r11 == r3) goto L_0x00af
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            if (r11 != r4) goto L_0x00c8
        L_0x00af:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r8.r(r3)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r10.r(r11)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r11 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r8.r(r11)
            r9.a(r10, r1)
            r11.a(r10, r1)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r8.r(r2)
            goto L_0x0093
        L_0x00c8:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_Y
            if (r9 != r3) goto L_0x00f1
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            if (r11 == r4) goto L_0x00d4
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            if (r11 != r5) goto L_0x00f1
        L_0x00d4:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.r(r11)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r8.r(r4)
            r10.a(r9, r1)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r10 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r8.r(r10)
            r10.a(r9, r1)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r8.r(r3)
            r10.a(r9, r1)
            goto L_0x01c2
        L_0x00f1:
            if (r9 != r2) goto L_0x0115
            if (r11 != r2) goto L_0x0115
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r9 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r8.r(r9)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.r(r9)
            r12.a(r9, r1)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r9 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r8.r(r9)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.r(r9)
            r12.a(r9, r1)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r8.r(r2)
            goto L_0x008f
        L_0x0115:
            if (r9 != r3) goto L_0x0139
            if (r11 != r3) goto L_0x0139
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r9 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r8.r(r9)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.r(r9)
            r12.a(r9, r1)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r9 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r8.r(r9)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.r(r9)
            r12.a(r9, r1)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r8.r(r3)
            goto L_0x008f
        L_0x0139:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r8.r(r9)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r10.r(r11)
            boolean r11 = r1.v(r10)
            if (r11 == 0) goto L_0x01c2
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r11 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE
            if (r9 != r11) goto L_0x015f
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r9 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r8.r(r9)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r11 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r8.r(r11)
            if (r9 == 0) goto L_0x015c
            r9.x()
        L_0x015c:
            if (r11 == 0) goto L_0x01bf
            goto L_0x0192
        L_0x015f:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            if (r9 == r4) goto L_0x0196
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            if (r9 != r4) goto L_0x0168
            goto L_0x0196
        L_0x0168:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r11 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            if (r9 == r11) goto L_0x0170
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r11 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            if (r9 != r11) goto L_0x01bf
        L_0x0170:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r8.r(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r11.k()
            if (r0 == r10) goto L_0x017d
            r11.x()
        L_0x017d:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r8.r(r9)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.h()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r8.r(r2)
            boolean r0 = r11.p()
            if (r0 == 0) goto L_0x01bf
        L_0x018f:
            r9.x()
        L_0x0192:
            r11.x()
            goto L_0x01bf
        L_0x0196:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r8.r(r11)
            if (r11 == 0) goto L_0x019f
            r11.x()
        L_0x019f:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r8.r(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r11.k()
            if (r0 == r10) goto L_0x01ac
            r11.x()
        L_0x01ac:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r8.r(r9)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.h()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r8.r(r3)
            boolean r0 = r11.p()
            if (r0 == 0) goto L_0x01bf
            goto L_0x018f
        L_0x01bf:
            r1.a(r10, r12)
        L_0x01c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.k(androidx.constraintlayout.core.widgets.ConstraintAnchor$Type, androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.core.widgets.ConstraintAnchor$Type, int):void");
    }

    public int k0() {
        int i2 = this.Q != null ? this.R.f4184g : 0;
        return this.S != null ? i2 + this.T.f4184g : i2;
    }

    public void k1(LinearSystem linearSystem, String str) {
        this.w0 = str;
        SolverVariable u2 = linearSystem.u(this.Q);
        SolverVariable u3 = linearSystem.u(this.R);
        SolverVariable u4 = linearSystem.u(this.S);
        SolverVariable u5 = linearSystem.u(this.T);
        u2.k(str + ".left");
        u3.k(str + ".top");
        u4.k(str + ".right");
        u5.k(str + ".bottom");
        SolverVariable u6 = linearSystem.u(this.U);
        u6.k(str + ".baseline");
    }

    public void l(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i2) {
        if (constraintAnchor.i() == this) {
            k(constraintAnchor.l(), constraintAnchor2.i(), constraintAnchor2.l(), i2);
        }
    }

    public int l0() {
        return this.u0;
    }

    public void l1(int i2, int i3) {
        this.d0 = i2;
        int i4 = this.o0;
        if (i2 < i4) {
            this.d0 = i4;
        }
        this.e0 = i3;
        int i5 = this.p0;
        if (i3 < i5) {
            this.e0 = i5;
        }
    }

    public void m(ConstraintWidget constraintWidget, float f2, int i2) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        v0(type, constraintWidget, type, i2, 0);
        this.K = f2;
    }

    public int m0() {
        if (this.u0 == 8) {
            return 0;
        }
        return this.d0;
    }

    public void m1(float f2, int i2) {
        this.f0 = f2;
        this.g0 = i2;
    }

    public void n(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        this.t = constraintWidget.t;
        this.u = constraintWidget.u;
        this.w = constraintWidget.w;
        this.x = constraintWidget.x;
        int[] iArr = this.y;
        int[] iArr2 = constraintWidget.y;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.z = constraintWidget.z;
        this.A = constraintWidget.A;
        this.C = constraintWidget.C;
        this.D = constraintWidget.D;
        this.E = constraintWidget.E;
        this.F = constraintWidget.F;
        this.G = constraintWidget.G;
        this.H = constraintWidget.H;
        this.I = constraintWidget.I;
        int[] iArr3 = constraintWidget.J;
        this.J = Arrays.copyOf(iArr3, iArr3.length);
        this.K = constraintWidget.K;
        this.L = constraintWidget.L;
        this.M = constraintWidget.M;
        this.Q.x();
        this.R.x();
        this.S.x();
        this.T.x();
        this.U.x();
        this.V.x();
        this.W.x();
        this.X.x();
        this.b0 = (DimensionBehaviour[]) Arrays.copyOf(this.b0, 2);
        ConstraintWidget constraintWidget2 = null;
        this.c0 = this.c0 == null ? null : hashMap.get(constraintWidget.c0);
        this.d0 = constraintWidget.d0;
        this.e0 = constraintWidget.e0;
        this.f0 = constraintWidget.f0;
        this.g0 = constraintWidget.g0;
        this.h0 = constraintWidget.h0;
        this.i0 = constraintWidget.i0;
        this.j0 = constraintWidget.j0;
        this.k0 = constraintWidget.k0;
        this.l0 = constraintWidget.l0;
        this.m0 = constraintWidget.m0;
        this.n0 = constraintWidget.n0;
        this.o0 = constraintWidget.o0;
        this.p0 = constraintWidget.p0;
        this.q0 = constraintWidget.q0;
        this.r0 = constraintWidget.r0;
        this.s0 = constraintWidget.s0;
        this.t0 = constraintWidget.t0;
        this.u0 = constraintWidget.u0;
        this.v0 = constraintWidget.v0;
        this.w0 = constraintWidget.w0;
        this.x0 = constraintWidget.x0;
        this.y0 = constraintWidget.y0;
        this.z0 = constraintWidget.z0;
        this.A0 = constraintWidget.A0;
        this.B0 = constraintWidget.B0;
        this.C0 = constraintWidget.C0;
        this.D0 = constraintWidget.D0;
        this.E0 = constraintWidget.E0;
        this.F0 = constraintWidget.F0;
        this.G0 = constraintWidget.G0;
        this.H0 = constraintWidget.H0;
        this.J0 = constraintWidget.J0;
        this.K0 = constraintWidget.K0;
        this.L0 = constraintWidget.L0;
        this.M0 = constraintWidget.M0;
        float[] fArr = this.N0;
        float[] fArr2 = constraintWidget.N0;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.O0;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.O0;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.P0;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.P0;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget3 = constraintWidget.Q0;
        this.Q0 = constraintWidget3 == null ? null : hashMap.get(constraintWidget3);
        ConstraintWidget constraintWidget4 = constraintWidget.R0;
        if (constraintWidget4 != null) {
            constraintWidget2 = hashMap.get(constraintWidget4);
        }
        this.R0 = constraintWidget2;
    }

    public int n0() {
        return this.v;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n1(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x0091
            int r1 = r9.length()
            if (r1 != 0) goto L_0x000b
            goto L_0x0091
        L_0x000b:
            int r1 = r9.length()
            r2 = 44
            int r2 = r9.indexOf(r2)
            r3 = 0
            r4 = 1
            r5 = -1
            if (r2 <= 0) goto L_0x0039
            int r6 = r1 + -1
            if (r2 >= r6) goto L_0x0039
            java.lang.String r6 = r9.substring(r3, r2)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x002b
            goto L_0x0036
        L_0x002b:
            java.lang.String r3 = "H"
            boolean r3 = r6.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0035
            r3 = 1
            goto L_0x0036
        L_0x0035:
            r3 = -1
        L_0x0036:
            int r2 = r2 + r4
            r5 = r3
            r3 = r2
        L_0x0039:
            r2 = 58
            int r2 = r9.indexOf(r2)
            if (r2 < 0) goto L_0x0077
            int r1 = r1 - r4
            if (r2 >= r1) goto L_0x0077
            java.lang.String r1 = r9.substring(r3, r2)
            int r2 = r2 + r4
            java.lang.String r9 = r9.substring(r2)
            int r2 = r1.length()
            if (r2 <= 0) goto L_0x0087
            int r2 = r9.length()
            if (r2 <= 0) goto L_0x0087
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x0086 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            int r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0087
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0087
            if (r5 != r4) goto L_0x0071
            float r9 = r9 / r1
            float r9 = java.lang.Math.abs(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0088
        L_0x0071:
            float r1 = r1 / r9
            float r9 = java.lang.Math.abs(r1)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0088
        L_0x0077:
            java.lang.String r9 = r9.substring(r3)
            int r1 = r9.length()
            if (r1 <= 0) goto L_0x0087
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0088
        L_0x0086:
        L_0x0087:
            r9 = 0
        L_0x0088:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0090
            r8.f0 = r9
            r8.g0 = r5
        L_0x0090:
            return
        L_0x0091:
            r8.f0 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.n1(java.lang.String):void");
    }

    public void o(LinearSystem linearSystem) {
        linearSystem.u(this.Q);
        linearSystem.u(this.R);
        linearSystem.u(this.S);
        linearSystem.u(this.T);
        if (this.n0 > 0) {
            linearSystem.u(this.U);
        }
    }

    public int o0() {
        ConstraintWidget constraintWidget = this.c0;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.h0 : ((ConstraintWidgetContainer) constraintWidget).I1 + this.h0;
    }

    public void o1(int i2) {
        if (this.L) {
            int i3 = i2 - this.n0;
            int i4 = this.e0 + i3;
            this.i0 = i3;
            this.R.A(i3);
            this.T.A(i4);
            this.U.A(i2);
            this.q = true;
        }
    }

    public void p() {
        this.f4196i = true;
    }

    public int p0() {
        ConstraintWidget constraintWidget = this.c0;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.i0 : ((ConstraintWidgetContainer) constraintWidget).J1 + this.i0;
    }

    public void p1(int i2, int i3, int i4, int i5, int i6, int i7) {
        v1(i2, i3, i4, i5);
        g1(i6);
        if (i7 == 0) {
            this.p = true;
        } else {
            if (i7 == 1) {
                this.p = false;
            } else if (i7 == 2) {
                this.p = true;
            } else {
                this.p = false;
            }
            this.q = true;
            return;
        }
        this.q = false;
    }

    public void q() {
        if (this.f4192e == null) {
            this.f4192e = new HorizontalWidgetRun(this);
        }
        if (this.f4193f == null) {
            this.f4193f = new VerticalWidgetRun(this);
        }
    }

    public boolean q0() {
        return this.L;
    }

    public void q1(int i2, int i3) {
        if (!this.p) {
            this.Q.A(i2);
            this.S.A(i3);
            this.h0 = i2;
            this.d0 = i3 - i2;
            this.p = true;
        }
    }

    public ConstraintAnchor r(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.f4202a[type.ordinal()]) {
            case 1:
                return this.Q;
            case 2:
                return this.R;
            case 3:
                return this.S;
            case 4:
                return this.T;
            case 5:
                return this.U;
            case 6:
                return this.X;
            case 7:
                return this.V;
            case 8:
                return this.W;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public boolean r0(int i2) {
        if (i2 == 0) {
            return (this.Q.f4183f != null ? 1 : 0) + (this.S.f4183f != null ? 1 : 0) < 2;
        }
        return ((this.R.f4183f != null ? 1 : 0) + (this.T.f4183f != null ? 1 : 0)) + (this.U.f4183f != null ? 1 : 0) < 2;
    }

    public void r1(int i2) {
        this.Q.A(i2);
        this.h0 = i2;
    }

    public ArrayList<ConstraintAnchor> s() {
        return this.Z;
    }

    public boolean s0() {
        int size = this.Z.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.Z.get(i2).n()) {
                return true;
            }
        }
        return false;
    }

    public void s1(int i2) {
        this.R.A(i2);
        this.i0 = i2;
    }

    public int t() {
        return this.n0;
    }

    public boolean t0() {
        return (this.f4199l == -1 && this.f4200m == -1) ? false : true;
    }

    public void t1(int i2, int i3) {
        if (!this.q) {
            this.R.A(i2);
            this.T.A(i3);
            this.i0 = i2;
            this.e0 = i3 - i2;
            if (this.L) {
                this.U.A(i2 + this.n0);
            }
            this.q = true;
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.x0 != null) {
            str = "type: " + this.x0 + StringUtils.SPACE;
        } else {
            str = str2;
        }
        sb.append(str);
        if (this.w0 != null) {
            str2 = "id: " + this.w0 + StringUtils.SPACE;
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.h0);
        sb.append(", ");
        sb.append(this.i0);
        sb.append(") - (");
        sb.append(this.d0);
        sb.append(" x ");
        sb.append(this.e0);
        sb.append(")");
        return sb.toString();
    }

    public float u(int i2) {
        if (i2 == 0) {
            return this.q0;
        }
        if (i2 == 1) {
            return this.r0;
        }
        return -1.0f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
        r5 = r4.S.f4183f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean u0(int r5, int r6) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            if (r5 != 0) goto L_0x0040
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r4.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f4183f
            if (r5 == 0) goto L_0x007c
            boolean r5 = r5.o()
            if (r5 == 0) goto L_0x007c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r4.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f4183f
            if (r5 == 0) goto L_0x007c
            boolean r5 = r5.o()
            if (r5 == 0) goto L_0x007c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r4.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f4183f
            int r5 = r5.f()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r4.S
            int r2 = r2.g()
            int r5 = r5 - r2
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r4.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f4183f
            int r2 = r2.f()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r4.Q
            int r3 = r3.g()
            int r2 = r2 + r3
            int r5 = r5 - r2
            if (r5 < r6) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            r0 = 0
        L_0x003f:
            return r0
        L_0x0040:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r4.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f4183f
            if (r5 == 0) goto L_0x007c
            boolean r5 = r5.o()
            if (r5 == 0) goto L_0x007c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r4.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f4183f
            if (r5 == 0) goto L_0x007c
            boolean r5 = r5.o()
            if (r5 == 0) goto L_0x007c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r4.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f4183f
            int r5 = r5.f()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r4.T
            int r2 = r2.g()
            int r5 = r5 - r2
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r4.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f4183f
            int r2 = r2.f()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r4.R
            int r3 = r3.g()
            int r2 = r2 + r3
            int r5 = r5 - r2
            if (r5 < r6) goto L_0x007a
            goto L_0x007b
        L_0x007a:
            r0 = 0
        L_0x007b:
            return r0
        L_0x007c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.u0(int, int):boolean");
    }

    public void u1(int i2, int i3, int i4) {
        if (i4 == 0) {
            C1(i2, i3);
        } else if (i4 == 1) {
            X1(i2, i3);
        }
    }

    public int v() {
        return p0() + this.e0;
    }

    public void v0(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i2, int i3) {
        r(type).b(constraintWidget.r(type2), i2, i3, true);
    }

    public void v1(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8 = i4 - i2;
        int i9 = i5 - i3;
        this.h0 = i2;
        this.i0 = i3;
        if (this.u0 == 8) {
            this.d0 = 0;
            this.e0 = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.b0;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i8 < (i7 = this.d0)) {
            i8 = i7;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i9 < (i6 = this.e0)) {
            i9 = i6;
        }
        this.d0 = i8;
        this.e0 = i9;
        int i10 = this.p0;
        if (i9 < i10) {
            this.e0 = i10;
        }
        int i11 = this.o0;
        if (i8 < i11) {
            this.d0 = i11;
        }
        int i12 = this.A;
        if (i12 > 0 && dimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.d0 = Math.min(this.d0, i12);
        }
        int i13 = this.D;
        if (i13 > 0 && this.b0[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.e0 = Math.min(this.e0, i13);
        }
        int i14 = this.d0;
        if (i8 != i14) {
            this.f4199l = i14;
        }
        int i15 = this.e0;
        if (i9 != i15) {
            this.f4200m = i15;
        }
    }

    public Object w() {
        return this.s0;
    }

    public boolean w0() {
        return this.v0;
    }

    public void w1(ConstraintAnchor.Type type, int i2) {
        ConstraintAnchor constraintAnchor;
        int i3 = AnonymousClass1.f4202a[type.ordinal()];
        if (i3 == 1) {
            constraintAnchor = this.Q;
        } else if (i3 == 2) {
            constraintAnchor = this.R;
        } else if (i3 == 3) {
            constraintAnchor = this.S;
        } else if (i3 == 4) {
            constraintAnchor = this.T;
        } else if (i3 == 5) {
            constraintAnchor = this.U;
        } else {
            return;
        }
        constraintAnchor.f4185h = i2;
    }

    public int x() {
        return this.t0;
    }

    public void x1(boolean z2) {
        this.L = z2;
    }

    public String y() {
        return this.w0;
    }

    public boolean y0() {
        return this.G;
    }

    public void y1(int i2) {
        this.e0 = i2;
        int i3 = this.p0;
        if (i2 < i3) {
            this.e0 = i3;
        }
    }

    public DimensionBehaviour z(int i2) {
        if (i2 == 0) {
            return H();
        }
        if (i2 == 1) {
            return j0();
        }
        return null;
    }

    public boolean z0() {
        return this.r;
    }

    public void z1(boolean z2) {
        this.G = z2;
    }

    public ConstraintWidget(int i2, int i3) {
        this(0, 0, i2, i3);
    }

    public ConstraintWidget(int i2, int i3, int i4, int i5) {
        this.f4188a = false;
        this.f4189b = new WidgetRun[2];
        this.f4192e = null;
        this.f4193f = null;
        this.f4194g = new boolean[]{true, true};
        this.f4195h = false;
        this.f4196i = true;
        this.f4197j = false;
        this.f4198k = true;
        this.f4199l = -1;
        this.f4200m = -1;
        this.f4201n = new WidgetFrame(this);
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = -1;
        this.u = -1;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = new int[2];
        this.z = 0;
        this.A = 0;
        this.B = 1.0f;
        this.C = 0;
        this.D = 0;
        this.E = 1.0f;
        this.H = -1;
        this.I = 1.0f;
        this.J = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.K = 0.0f;
        this.L = false;
        this.N = false;
        this.O = 0;
        this.P = 0;
        this.Q = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.R = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.S = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.T = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.U = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.V = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.W = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.X = constraintAnchor;
        this.Y = new ConstraintAnchor[]{this.Q, this.S, this.R, this.T, this.U, constraintAnchor};
        this.Z = new ArrayList<>();
        this.a0 = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.b0 = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.c0 = null;
        this.f0 = 0.0f;
        this.g0 = -1;
        this.j0 = 0;
        this.k0 = 0;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = 0;
        float f2 = z1;
        this.q0 = f2;
        this.r0 = f2;
        this.t0 = 0;
        this.u0 = 0;
        this.v0 = false;
        this.w0 = null;
        this.x0 = null;
        this.I0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.N0 = new float[]{-1.0f, -1.0f};
        this.O0 = new ConstraintWidget[]{null, null};
        this.P0 = new ConstraintWidget[]{null, null};
        this.Q0 = null;
        this.R0 = null;
        this.S0 = -1;
        this.T0 = -1;
        this.h0 = i2;
        this.i0 = i3;
        this.d0 = i4;
        this.e0 = i5;
        d();
    }

    public ConstraintWidget(String str) {
        this.f4188a = false;
        this.f4189b = new WidgetRun[2];
        this.f4192e = null;
        this.f4193f = null;
        this.f4194g = new boolean[]{true, true};
        this.f4195h = false;
        this.f4196i = true;
        this.f4197j = false;
        this.f4198k = true;
        this.f4199l = -1;
        this.f4200m = -1;
        this.f4201n = new WidgetFrame(this);
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = -1;
        this.u = -1;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = new int[2];
        this.z = 0;
        this.A = 0;
        this.B = 1.0f;
        this.C = 0;
        this.D = 0;
        this.E = 1.0f;
        this.H = -1;
        this.I = 1.0f;
        this.J = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.K = 0.0f;
        this.L = false;
        this.N = false;
        this.O = 0;
        this.P = 0;
        this.Q = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.R = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.S = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.T = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.U = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.V = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.W = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.X = constraintAnchor;
        this.Y = new ConstraintAnchor[]{this.Q, this.S, this.R, this.T, this.U, constraintAnchor};
        this.Z = new ArrayList<>();
        this.a0 = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.b0 = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.c0 = null;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = 0.0f;
        this.g0 = -1;
        this.h0 = 0;
        this.i0 = 0;
        this.j0 = 0;
        this.k0 = 0;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = 0;
        float f2 = z1;
        this.q0 = f2;
        this.r0 = f2;
        this.t0 = 0;
        this.u0 = 0;
        this.v0 = false;
        this.w0 = null;
        this.x0 = null;
        this.I0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.N0 = new float[]{-1.0f, -1.0f};
        this.O0 = new ConstraintWidget[]{null, null};
        this.P0 = new ConstraintWidget[]{null, null};
        this.Q0 = null;
        this.R0 = null;
        this.S0 = -1;
        this.T0 = -1;
        d();
        j1(str);
    }

    public ConstraintWidget(String str, int i2, int i3) {
        this(i2, i3);
        j1(str);
    }

    public ConstraintWidget(String str, int i2, int i3, int i4, int i5) {
        this(i2, i3, i4, i5);
        j1(str);
    }
}
