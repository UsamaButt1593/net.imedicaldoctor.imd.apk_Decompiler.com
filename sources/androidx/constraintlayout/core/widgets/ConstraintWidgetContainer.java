package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.core.widgets.analyzer.DependencyGraph;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

public class ConstraintWidgetContainer extends WidgetContainer {
    private static final int g2 = 8;
    private static final boolean h2 = false;
    private static final boolean i2 = false;
    static final boolean j2 = false;
    static int k2;
    BasicMeasure B1 = new BasicMeasure(this);
    public DependencyGraph C1 = new DependencyGraph(this);
    private int D1;
    protected BasicMeasure.Measurer E1 = null;
    private boolean F1 = false;
    public Metrics G1;
    protected LinearSystem H1 = new LinearSystem();
    int I1;
    int J1;
    int K1;
    int L1;
    public int M1 = 0;
    public int N1 = 0;
    ChainHead[] O1 = new ChainHead[4];
    ChainHead[] P1 = new ChainHead[4];
    public boolean Q1 = false;
    public boolean R1 = false;
    public boolean S1 = false;
    public int T1 = 0;
    public int U1 = 0;
    private int V1 = 257;
    public boolean W1 = false;
    private boolean X1 = false;
    private boolean Y1 = false;
    int Z1 = 0;
    private WeakReference<ConstraintAnchor> a2 = null;
    private WeakReference<ConstraintAnchor> b2 = null;
    private WeakReference<ConstraintAnchor> c2 = null;
    private WeakReference<ConstraintAnchor> d2 = null;
    HashSet<ConstraintWidget> e2 = new HashSet<>();
    public BasicMeasure.Measure f2 = new BasicMeasure.Measure();

    public ConstraintWidgetContainer() {
    }

    public static boolean R2(int i3, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, BasicMeasure.Measure measure, int i4) {
        int i5;
        int i6;
        if (measurer == null) {
            return false;
        }
        if (constraintWidget.l0() == 8 || (constraintWidget instanceof Guideline) || (constraintWidget instanceof Barrier)) {
            measure.f4255e = 0;
            measure.f4256f = 0;
            return false;
        }
        measure.f4251a = constraintWidget.H();
        measure.f4252b = constraintWidget.j0();
        measure.f4253c = constraintWidget.m0();
        measure.f4254d = constraintWidget.D();
        measure.f4259i = false;
        measure.f4260j = i4;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.f4251a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z = dimensionBehaviour == dimensionBehaviour2;
        boolean z2 = measure.f4252b == dimensionBehaviour2;
        boolean z3 = z && constraintWidget.f0 > 0.0f;
        boolean z4 = z2 && constraintWidget.f0 > 0.0f;
        if (z && constraintWidget.r0(0) && constraintWidget.w == 0 && !z3) {
            measure.f4251a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z2 && constraintWidget.x == 0) {
                measure.f4251a = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z = false;
        }
        if (z2 && constraintWidget.r0(1) && constraintWidget.x == 0 && !z4) {
            measure.f4252b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z && constraintWidget.w == 0) {
                measure.f4252b = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z2 = false;
        }
        if (constraintWidget.G0()) {
            measure.f4251a = ConstraintWidget.DimensionBehaviour.FIXED;
            z = false;
        }
        if (constraintWidget.H0()) {
            measure.f4252b = ConstraintWidget.DimensionBehaviour.FIXED;
            z2 = false;
        }
        if (z3) {
            if (constraintWidget.y[0] == 4) {
                measure.f4251a = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z2) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = measure.f4252b;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour3 == dimensionBehaviour4) {
                    i6 = measure.f4254d;
                } else {
                    measure.f4251a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    measurer.b(constraintWidget, measure);
                    i6 = measure.f4256f;
                }
                measure.f4251a = dimensionBehaviour4;
                measure.f4253c = (int) (constraintWidget.A() * ((float) i6));
            }
        }
        if (z4) {
            if (constraintWidget.y[1] == 4) {
                measure.f4252b = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = measure.f4251a;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour5 == dimensionBehaviour6) {
                    i5 = measure.f4253c;
                } else {
                    measure.f4252b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    measurer.b(constraintWidget, measure);
                    i5 = measure.f4255e;
                }
                measure.f4252b = dimensionBehaviour6;
                measure.f4254d = constraintWidget.B() == -1 ? (int) (((float) i5) / constraintWidget.A()) : (int) (constraintWidget.A() * ((float) i5));
            }
        }
        measurer.b(constraintWidget, measure);
        constraintWidget.c2(measure.f4255e);
        constraintWidget.y1(measure.f4256f);
        constraintWidget.x1(measure.f4258h);
        constraintWidget.g1(measure.f4257g);
        measure.f4260j = BasicMeasure.Measure.f4248k;
        return measure.f4259i;
    }

    private void T2() {
        this.M1 = 0;
        this.N1 = 0;
    }

    private void s2(ConstraintWidget constraintWidget) {
        int i3 = this.M1 + 1;
        ChainHead[] chainHeadArr = this.P1;
        if (i3 >= chainHeadArr.length) {
            this.P1 = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.P1[this.M1] = new ChainHead(constraintWidget, 0, O2());
        this.M1++;
    }

    private void v2(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.H1.i(solverVariable, this.H1.u(constraintAnchor), 0, 5);
    }

    private void w2(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.H1.i(this.H1.u(constraintAnchor), solverVariable, 0, 5);
    }

    private void x2(ConstraintWidget constraintWidget) {
        int i3 = this.N1 + 1;
        ChainHead[] chainHeadArr = this.O1;
        if (i3 >= chainHeadArr.length) {
            this.O1 = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.O1[this.N1] = new ChainHead(constraintWidget, 1, O2());
        this.N1++;
    }

    public void A2() {
        this.C1.f(H(), j0());
    }

    public boolean B2(boolean z) {
        return this.C1.g(z);
    }

    public boolean C2(boolean z) {
        return this.C1.h(z);
    }

    public boolean D2(boolean z, int i3) {
        return this.C1.i(z, i3);
    }

    public void E2(Metrics metrics) {
        this.G1 = metrics;
        this.H1.F(metrics);
    }

    public ArrayList<Guideline> F2() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.A1.size();
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget = this.A1.get(i3);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.m2() == 0) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public BasicMeasure.Measurer G2() {
        return this.E1;
    }

    public int H2() {
        return this.V1;
    }

    public LinearSystem I2() {
        return this.H1;
    }

    public ArrayList<Guideline> J2() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.A1.size();
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget = this.A1.get(i3);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.m2() == 1) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public boolean K2() {
        return false;
    }

    public void L2() {
        this.C1.o();
    }

    public void M2() {
        this.C1.p();
    }

    public boolean N2() {
        return this.Y1;
    }

    public boolean O2() {
        return this.F1;
    }

    public boolean P2() {
        return this.X1;
    }

    public long Q2(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        int i12 = i10;
        this.I1 = i12;
        int i13 = i11;
        this.J1 = i13;
        return this.B1.d(this, i3, i12, i13, i4, i5, i6, i7, i8, i9);
    }

    public void R0() {
        this.H1.Y();
        this.I1 = 0;
        this.K1 = 0;
        this.J1 = 0;
        this.L1 = 0;
        this.W1 = false;
        super.R0();
    }

    public boolean S2(int i3) {
        return (this.V1 & i3) == i3;
    }

    public void U2(BasicMeasure.Measurer measurer) {
        this.E1 = measurer;
        this.C1.u(measurer);
    }

    public void V2(int i3) {
        this.V1 = i3;
        LinearSystem.v = S2(512);
    }

    public void W2(int i3, int i4, int i5, int i6) {
        this.I1 = i3;
        this.J1 = i4;
        this.K1 = i5;
        this.L1 = i6;
    }

    public void X2(int i3) {
        this.D1 = i3;
    }

    public void Y2(boolean z) {
        this.F1 = z;
    }

    public boolean Z2(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        boolean S2 = S2(64);
        j2(linearSystem, S2);
        int size = this.A1.size();
        boolean z = false;
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget = this.A1.get(i3);
            constraintWidget.j2(linearSystem, S2);
            if (constraintWidget.t0()) {
                z = true;
            }
        }
        return z;
    }

    public void a3() {
        this.B1.e(this);
    }

    public void b0(StringBuilder sb) {
        sb.append(this.o + ":{\n");
        sb.append("  actualWidth:" + this.d0);
        sb.append(StringUtils.LF);
        sb.append("  actualHeight:" + this.e0);
        sb.append(StringUtils.LF);
        Iterator<ConstraintWidget> it2 = l2().iterator();
        while (it2.hasNext()) {
            it2.next().b0(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }

    public String f0() {
        return "ConstraintLayout";
    }

    public void i2(boolean z, boolean z2) {
        super.i2(z, z2);
        int size = this.A1.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.A1.get(i3).i2(z, z2);
        }
    }

    /* JADX WARNING: type inference failed for: r6v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0317  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0319  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n2() {
        /*
            r18 = this;
            r1 = r18
            r2 = 0
            r1.h0 = r2
            r1.i0 = r2
            r1.X1 = r2
            r1.Y1 = r2
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r0 = r1.A1
            int r3 = r0.size()
            int r0 = r18.m0()
            int r0 = java.lang.Math.max(r2, r0)
            int r4 = r18.D()
            int r4 = java.lang.Math.max(r2, r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r1.b0
            r6 = 1
            r7 = r5[r6]
            r5 = r5[r2]
            androidx.constraintlayout.core.Metrics r8 = r1.G1
            if (r8 == 0) goto L_0x0033
            long r9 = r8.P
            r11 = 1
            long r9 = r9 + r11
            r8.P = r9
        L_0x0033:
            int r8 = r1.D1
            if (r8 != 0) goto L_0x008f
            int r8 = r1.V1
            boolean r8 = androidx.constraintlayout.core.widgets.Optimizer.b(r8, r6)
            if (r8 == 0) goto L_0x008f
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r8 = r18.G2()
            androidx.constraintlayout.core.widgets.analyzer.Direct.j(r1, r8)
            r8 = 0
        L_0x0047:
            if (r8 >= r3) goto L_0x008f
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r9 = r1.A1
            java.lang.Object r9 = r9.get(r8)
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r9
            boolean r10 = r9.F0()
            if (r10 == 0) goto L_0x008c
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r10 != 0) goto L_0x008c
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r10 != 0) goto L_0x008c
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.VirtualLayout
            if (r10 != 0) goto L_0x008c
            boolean r10 = r9.E0()
            if (r10 != 0) goto L_0x008c
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = r9.z(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r9.z(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r10 != r12) goto L_0x0080
            int r10 = r9.w
            if (r10 == r6) goto L_0x0080
            if (r11 != r12) goto L_0x0080
            int r10 = r9.x
            if (r10 == r6) goto L_0x0080
            goto L_0x008c
        L_0x0080:
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r10 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r10.<init>()
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r11 = r1.E1
            int r12 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f4248k
            R2(r2, r9, r11, r10, r12)
        L_0x008c:
            int r8 = r8 + 1
            goto L_0x0047
        L_0x008f:
            r8 = 2
            if (r3 <= r8) goto L_0x00d8
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 == r9) goto L_0x0098
            if (r7 != r9) goto L_0x00d8
        L_0x0098:
            int r10 = r1.V1
            r11 = 1024(0x400, float:1.435E-42)
            boolean r10 = androidx.constraintlayout.core.widgets.Optimizer.b(r10, r11)
            if (r10 == 0) goto L_0x00d8
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r10 = r18.G2()
            boolean r10 = androidx.constraintlayout.core.widgets.analyzer.Grouping.c(r1, r10)
            if (r10 == 0) goto L_0x00d8
            if (r5 != r9) goto L_0x00c0
            int r10 = r18.m0()
            if (r0 >= r10) goto L_0x00bc
            if (r0 <= 0) goto L_0x00bc
            r1.c2(r0)
            r1.X1 = r6
            goto L_0x00c0
        L_0x00bc:
            int r0 = r18.m0()
        L_0x00c0:
            if (r7 != r9) goto L_0x00d4
            int r9 = r18.D()
            if (r4 >= r9) goto L_0x00d0
            if (r4 <= 0) goto L_0x00d0
            r1.y1(r4)
            r1.Y1 = r6
            goto L_0x00d4
        L_0x00d0:
            int r4 = r18.D()
        L_0x00d4:
            r9 = r4
            r4 = r0
            r0 = 1
            goto L_0x00db
        L_0x00d8:
            r9 = r4
            r4 = r0
            r0 = 0
        L_0x00db:
            r10 = 64
            boolean r11 = r1.S2(r10)
            if (r11 != 0) goto L_0x00ee
            r11 = 128(0x80, float:1.794E-43)
            boolean r11 = r1.S2(r11)
            if (r11 == 0) goto L_0x00ec
            goto L_0x00ee
        L_0x00ec:
            r11 = 0
            goto L_0x00ef
        L_0x00ee:
            r11 = 1
        L_0x00ef:
            androidx.constraintlayout.core.LinearSystem r12 = r1.H1
            r12.f3608h = r2
            r12.f3609i = r2
            int r13 = r1.V1
            if (r13 == 0) goto L_0x00fd
            if (r11 == 0) goto L_0x00fd
            r12.f3609i = r6
        L_0x00fd:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r11 = r1.A1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = r18.H()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r12 == r13) goto L_0x0110
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = r18.j0()
            if (r12 != r13) goto L_0x010e
            goto L_0x0110
        L_0x010e:
            r12 = 0
            goto L_0x0111
        L_0x0110:
            r12 = 1
        L_0x0111:
            r18.T2()
            r13 = 0
        L_0x0115:
            if (r13 >= r3) goto L_0x012b
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r14 = r1.A1
            java.lang.Object r14 = r14.get(r13)
            androidx.constraintlayout.core.widgets.ConstraintWidget r14 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r14
            boolean r15 = r14 instanceof androidx.constraintlayout.core.widgets.WidgetContainer
            if (r15 == 0) goto L_0x0128
            androidx.constraintlayout.core.widgets.WidgetContainer r14 = (androidx.constraintlayout.core.widgets.WidgetContainer) r14
            r14.n2()
        L_0x0128:
            int r13 = r13 + 1
            goto L_0x0115
        L_0x012b:
            boolean r10 = r1.S2(r10)
            r13 = r0
            r0 = 0
            r14 = 1
        L_0x0132:
            if (r14 == 0) goto L_0x0320
            int r15 = r0 + 1
            androidx.constraintlayout.core.LinearSystem r0 = r1.H1     // Catch:{ Exception -> 0x0158 }
            r0.Y()     // Catch:{ Exception -> 0x0158 }
            r18.T2()     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.LinearSystem r0 = r1.H1     // Catch:{ Exception -> 0x0158 }
            r1.o(r0)     // Catch:{ Exception -> 0x0158 }
            r0 = 0
        L_0x0144:
            if (r0 >= r3) goto L_0x015b
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r6 = r1.A1     // Catch:{ Exception -> 0x0158 }
            java.lang.Object r6 = r6.get(r0)     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r6     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.LinearSystem r2 = r1.H1     // Catch:{ Exception -> 0x0158 }
            r6.o(r2)     // Catch:{ Exception -> 0x0158 }
            int r0 = r0 + 1
            r2 = 0
            r6 = 1
            goto L_0x0144
        L_0x0158:
            r0 = move-exception
            goto L_0x01e6
        L_0x015b:
            androidx.constraintlayout.core.LinearSystem r0 = r1.H1     // Catch:{ Exception -> 0x0158 }
            boolean r14 = r1.r2(r0)     // Catch:{ Exception -> 0x0158 }
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.a2     // Catch:{ Exception -> 0x0158 }
            r2 = 0
            if (r0 == 0) goto L_0x0181
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0158 }
            if (r0 == 0) goto L_0x0181
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.a2     // Catch:{ Exception -> 0x0158 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.LinearSystem r6 = r1.H1     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.R     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.SolverVariable r6 = r6.u(r8)     // Catch:{ Exception -> 0x0158 }
            r1.w2(r0, r6)     // Catch:{ Exception -> 0x0158 }
            r1.a2 = r2     // Catch:{ Exception -> 0x0158 }
        L_0x0181:
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.c2     // Catch:{ Exception -> 0x0158 }
            if (r0 == 0) goto L_0x01a0
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0158 }
            if (r0 == 0) goto L_0x01a0
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.c2     // Catch:{ Exception -> 0x0158 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.LinearSystem r6 = r1.H1     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.T     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.SolverVariable r6 = r6.u(r8)     // Catch:{ Exception -> 0x0158 }
            r1.v2(r0, r6)     // Catch:{ Exception -> 0x0158 }
            r1.c2 = r2     // Catch:{ Exception -> 0x0158 }
        L_0x01a0:
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.b2     // Catch:{ Exception -> 0x0158 }
            if (r0 == 0) goto L_0x01bf
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0158 }
            if (r0 == 0) goto L_0x01bf
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.b2     // Catch:{ Exception -> 0x0158 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.LinearSystem r6 = r1.H1     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.Q     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.SolverVariable r6 = r6.u(r8)     // Catch:{ Exception -> 0x0158 }
            r1.w2(r0, r6)     // Catch:{ Exception -> 0x0158 }
            r1.b2 = r2     // Catch:{ Exception -> 0x0158 }
        L_0x01bf:
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.d2     // Catch:{ Exception -> 0x0158 }
            if (r0 == 0) goto L_0x01de
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0158 }
            if (r0 == 0) goto L_0x01de
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.d2     // Catch:{ Exception -> 0x0158 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.LinearSystem r6 = r1.H1     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.S     // Catch:{ Exception -> 0x0158 }
            androidx.constraintlayout.core.SolverVariable r6 = r6.u(r8)     // Catch:{ Exception -> 0x0158 }
            r1.v2(r0, r6)     // Catch:{ Exception -> 0x0158 }
            r1.d2 = r2     // Catch:{ Exception -> 0x0158 }
        L_0x01de:
            if (r14 == 0) goto L_0x01ff
            androidx.constraintlayout.core.LinearSystem r0 = r1.H1     // Catch:{ Exception -> 0x0158 }
            r0.T()     // Catch:{ Exception -> 0x0158 }
            goto L_0x01ff
        L_0x01e6:
            r0.printStackTrace()
            java.io.PrintStream r2 = java.lang.System.out
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "EXCEPTION : "
            r6.append(r8)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r2.println(r0)
        L_0x01ff:
            androidx.constraintlayout.core.LinearSystem r0 = r1.H1
            if (r14 == 0) goto L_0x020a
            boolean[] r2 = androidx.constraintlayout.core.widgets.Optimizer.f4232n
            boolean r0 = r1.Z2(r0, r2)
            goto L_0x0221
        L_0x020a:
            r1.j2(r0, r10)
            r0 = 0
        L_0x020e:
            if (r0 >= r3) goto L_0x0220
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r2 = r1.A1
            java.lang.Object r2 = r2.get(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            androidx.constraintlayout.core.LinearSystem r6 = r1.H1
            r2.j2(r6, r10)
            int r0 = r0 + 1
            goto L_0x020e
        L_0x0220:
            r0 = 0
        L_0x0221:
            r2 = 8
            if (r12 == 0) goto L_0x0292
            if (r15 >= r2) goto L_0x0292
            boolean[] r6 = androidx.constraintlayout.core.widgets.Optimizer.f4232n
            r8 = 2
            boolean r6 = r6[r8]
            if (r6 == 0) goto L_0x0292
            r6 = 0
            r8 = 0
            r14 = 0
        L_0x0231:
            if (r6 >= r3) goto L_0x025b
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r2 = r1.A1
            java.lang.Object r2 = r2.get(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            r16 = r0
            int r0 = r2.h0
            int r17 = r2.m0()
            int r0 = r0 + r17
            int r14 = java.lang.Math.max(r14, r0)
            int r0 = r2.i0
            int r2 = r2.D()
            int r0 = r0 + r2
            int r8 = java.lang.Math.max(r8, r0)
            int r6 = r6 + 1
            r0 = r16
            r2 = 8
            goto L_0x0231
        L_0x025b:
            r16 = r0
            int r0 = r1.o0
            int r0 = java.lang.Math.max(r0, r14)
            int r2 = r1.p0
            int r2 = java.lang.Math.max(r2, r8)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 != r6) goto L_0x027e
            int r8 = r18.m0()
            if (r8 >= r0) goto L_0x027e
            r1.c2(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.b0
            r8 = 0
            r0[r8] = r6
            r13 = 1
            r16 = 1
        L_0x027e:
            if (r7 != r6) goto L_0x0294
            int r0 = r18.D()
            if (r0 >= r2) goto L_0x0294
            r1.y1(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.b0
            r2 = 1
            r0[r2] = r6
            r13 = 1
            r16 = 1
            goto L_0x0294
        L_0x0292:
            r16 = r0
        L_0x0294:
            int r0 = r1.o0
            int r2 = r18.m0()
            int r0 = java.lang.Math.max(r0, r2)
            int r2 = r18.m0()
            if (r0 <= r2) goto L_0x02b1
            r1.c2(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.b0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r6 = 0
            r0[r6] = r2
            r13 = 1
            r16 = 1
        L_0x02b1:
            int r0 = r1.p0
            int r2 = r18.D()
            int r0 = java.lang.Math.max(r0, r2)
            int r2 = r18.D()
            if (r0 <= r2) goto L_0x02cf
            r1.y1(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.b0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r6 = 1
            r0[r6] = r2
            r2 = 1
            r16 = 1
            goto L_0x02d1
        L_0x02cf:
            r6 = 1
            r2 = r13
        L_0x02d1:
            if (r2 != 0) goto L_0x0310
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.b0
            r8 = 0
            r0 = r0[r8]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r13) goto L_0x02f2
            if (r4 <= 0) goto L_0x02f2
            int r0 = r18.m0()
            if (r0 <= r4) goto L_0x02f2
            r1.X1 = r6
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.b0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0[r8] = r2
            r1.c2(r4)
            r2 = 1
            r16 = 1
        L_0x02f2:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.b0
            r0 = r0[r6]
            if (r0 != r13) goto L_0x0310
            if (r9 <= 0) goto L_0x0310
            int r0 = r18.D()
            if (r0 <= r9) goto L_0x0310
            r1.Y1 = r6
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.b0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0[r6] = r2
            r1.y1(r9)
            r0 = 8
            r2 = 1
            r13 = 1
            goto L_0x0315
        L_0x0310:
            r13 = r2
            r2 = r16
            r0 = 8
        L_0x0315:
            if (r15 <= r0) goto L_0x0319
            r14 = 0
            goto L_0x031a
        L_0x0319:
            r14 = r2
        L_0x031a:
            r0 = r15
            r2 = 0
            r6 = 1
            r8 = 2
            goto L_0x0132
        L_0x0320:
            r1.A1 = r11
            if (r13 == 0) goto L_0x032c
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.b0
            r2 = 0
            r0[r2] = r5
            r2 = 1
            r0[r2] = r7
        L_0x032c:
            androidx.constraintlayout.core.LinearSystem r0 = r1.H1
            androidx.constraintlayout.core.Cache r0 = r0.G()
            r1.W0(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.n2():void");
    }

    /* access modifiers changed from: package-private */
    public void q2(ConstraintWidget constraintWidget, int i3) {
        if (i3 == 0) {
            s2(constraintWidget);
        } else if (i3 == 1) {
            x2(constraintWidget);
        }
    }

    public boolean r2(LinearSystem linearSystem) {
        boolean S2 = S2(64);
        g(linearSystem, S2);
        int size = this.A1.size();
        boolean z = false;
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget = this.A1.get(i3);
            constraintWidget.G1(0, false);
            constraintWidget.G1(1, false);
            if (constraintWidget instanceof Barrier) {
                z = true;
            }
        }
        if (z) {
            for (int i4 = 0; i4 < size; i4++) {
                ConstraintWidget constraintWidget2 = this.A1.get(i4);
                if (constraintWidget2 instanceof Barrier) {
                    ((Barrier) constraintWidget2).s2();
                }
            }
        }
        this.e2.clear();
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintWidget constraintWidget3 = this.A1.get(i5);
            if (constraintWidget3.f()) {
                if (constraintWidget3 instanceof VirtualLayout) {
                    this.e2.add(constraintWidget3);
                } else {
                    constraintWidget3.g(linearSystem, S2);
                }
            }
        }
        while (this.e2.size() > 0) {
            int size2 = this.e2.size();
            Iterator<ConstraintWidget> it2 = this.e2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                VirtualLayout virtualLayout = (VirtualLayout) it2.next();
                if (virtualLayout.o2(this.e2)) {
                    virtualLayout.g(linearSystem, S2);
                    this.e2.remove(virtualLayout);
                    break;
                }
            }
            if (size2 == this.e2.size()) {
                Iterator<ConstraintWidget> it3 = this.e2.iterator();
                while (it3.hasNext()) {
                    it3.next().g(linearSystem, S2);
                }
                this.e2.clear();
            }
        }
        if (LinearSystem.v) {
            HashSet hashSet = new HashSet();
            for (int i6 = 0; i6 < size; i6++) {
                ConstraintWidget constraintWidget4 = this.A1.get(i6);
                if (!constraintWidget4.f()) {
                    hashSet.add(constraintWidget4);
                }
            }
            e(this, linearSystem, hashSet, H() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 0 : 1, false);
            Iterator it4 = hashSet.iterator();
            while (it4.hasNext()) {
                ConstraintWidget constraintWidget5 = (ConstraintWidget) it4.next();
                Optimizer.a(this, linearSystem, constraintWidget5);
                constraintWidget5.g(linearSystem, S2);
            }
        } else {
            for (int i7 = 0; i7 < size; i7++) {
                ConstraintWidget constraintWidget6 = this.A1.get(i7);
                if (constraintWidget6 instanceof ConstraintWidgetContainer) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget6.b0;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget6.D1(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget6.Y1(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    constraintWidget6.g(linearSystem, S2);
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget6.D1(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget6.Y1(dimensionBehaviour2);
                    }
                } else {
                    Optimizer.a(this, linearSystem, constraintWidget6);
                    if (!constraintWidget6.f()) {
                        constraintWidget6.g(linearSystem, S2);
                    }
                }
            }
        }
        if (this.M1 > 0) {
            Chain.b(this, linearSystem, (ArrayList<ConstraintWidget>) null, 0);
        }
        if (this.N1 > 0) {
            Chain.b(this, linearSystem, (ArrayList<ConstraintWidget>) null, 1);
        }
        return true;
    }

    public void t2(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.d2;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.f() > this.d2.get().f()) {
            this.d2 = new WeakReference<>(constraintAnchor);
        }
    }

    public void u2(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.b2;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.f() > this.b2.get().f()) {
            this.b2 = new WeakReference<>(constraintAnchor);
        }
    }

    /* access modifiers changed from: package-private */
    public void y2(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.c2;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.f() > this.c2.get().f()) {
            this.c2 = new WeakReference<>(constraintAnchor);
        }
    }

    /* access modifiers changed from: package-private */
    public void z2(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.a2;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.f() > this.a2.get().f()) {
            this.a2 = new WeakReference<>(constraintAnchor);
        }
    }

    public ConstraintWidgetContainer(int i3, int i4) {
        super(i3, i4);
    }

    public ConstraintWidgetContainer(int i3, int i4, int i5, int i6) {
        super(i3, i4, i5, i6);
    }

    public ConstraintWidgetContainer(String str, int i3, int i4) {
        super(i3, i4);
        j1(str);
    }
}
