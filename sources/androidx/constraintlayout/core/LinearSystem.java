package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;

public class LinearSystem {
    public static boolean A = false;
    private static int B = 1000;
    public static Metrics C = null;
    public static long D = 0;
    public static long E = 0;
    public static final boolean r = false;
    public static final boolean s = false;
    public static final boolean t = false;
    private static final boolean u = false;
    public static boolean v = false;
    public static boolean w = true;
    public static boolean x = true;
    public static boolean y = true;
    public static boolean z = true;

    /* renamed from: a  reason: collision with root package name */
    public boolean f3601a;

    /* renamed from: b  reason: collision with root package name */
    int f3602b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, SolverVariable> f3603c;

    /* renamed from: d  reason: collision with root package name */
    private Row f3604d;

    /* renamed from: e  reason: collision with root package name */
    private int f3605e;

    /* renamed from: f  reason: collision with root package name */
    private int f3606f;

    /* renamed from: g  reason: collision with root package name */
    ArrayRow[] f3607g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3608h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3609i;

    /* renamed from: j  reason: collision with root package name */
    private boolean[] f3610j;

    /* renamed from: k  reason: collision with root package name */
    int f3611k;

    /* renamed from: l  reason: collision with root package name */
    int f3612l;

    /* renamed from: m  reason: collision with root package name */
    private int f3613m;

    /* renamed from: n  reason: collision with root package name */
    final Cache f3614n;
    private SolverVariable[] o;
    private int p;
    private Row q;

    interface Row {
        void a(LinearSystem linearSystem, SolverVariable solverVariable, boolean z);

        void b(LinearSystem linearSystem);

        void c(LinearSystem linearSystem, ArrayRow arrayRow, boolean z);

        void clear();

        void d(Row row);

        SolverVariable e(LinearSystem linearSystem, boolean[] zArr);

        void f(SolverVariable solverVariable);

        SolverVariable getKey();

        boolean isEmpty();
    }

    class ValuesRow extends ArrayRow {
        public ValuesRow(Cache cache) {
            this.f3595e = new SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        this.f3601a = false;
        this.f3602b = 0;
        this.f3603c = null;
        this.f3605e = 32;
        this.f3606f = 32;
        this.f3607g = null;
        this.f3608h = false;
        this.f3609i = false;
        this.f3610j = new boolean[32];
        this.f3611k = 1;
        this.f3612l = 0;
        this.f3613m = 32;
        this.o = new SolverVariable[B];
        this.p = 0;
        this.f3607g = new ArrayRow[32];
        W();
        Cache cache = new Cache();
        this.f3614n = cache;
        this.f3604d = new PriorityGoalRow(cache);
        this.q = A ? new ValuesRow(cache) : new ArrayRow(cache);
    }

    private void A() {
        B();
        String str = "";
        for (int i2 = 0; i2 < this.f3612l; i2++) {
            str = (str + this.f3607g[i2]) + StringUtils.LF;
        }
        System.out.println(str + this.f3604d + StringUtils.LF);
    }

    private void B() {
        System.out.println("Display Rows (" + this.f3612l + "x" + this.f3611k + ")\n");
    }

    private int E(Row row) throws Exception {
        for (int i2 = 0; i2 < this.f3612l; i2++) {
            ArrayRow arrayRow = this.f3607g[i2];
            if (arrayRow.f3591a.c3 != SolverVariable.Type.UNRESTRICTED && arrayRow.f3592b < 0.0f) {
                boolean z2 = false;
                int i3 = 0;
                while (!z2) {
                    Metrics metrics = C;
                    if (metrics != null) {
                        metrics.o++;
                    }
                    i3++;
                    float f2 = Float.MAX_VALUE;
                    int i4 = 0;
                    int i5 = -1;
                    int i6 = -1;
                    int i7 = 0;
                    while (true) {
                        if (i4 >= this.f3612l) {
                            break;
                        }
                        ArrayRow arrayRow2 = this.f3607g[i4];
                        if (arrayRow2.f3591a.c3 != SolverVariable.Type.UNRESTRICTED && !arrayRow2.f3596f && arrayRow2.f3592b < 0.0f) {
                            int i8 = 9;
                            if (z) {
                                int e2 = arrayRow2.f3595e.e();
                                int i9 = 0;
                                while (i9 < e2) {
                                    SolverVariable k2 = arrayRow2.f3595e.k(i9);
                                    float p2 = arrayRow2.f3595e.p(k2);
                                    if (p2 > 0.0f) {
                                        int i10 = 0;
                                        while (i10 < i8) {
                                            float f3 = k2.a3[i10] / p2;
                                            if ((f3 < f2 && i10 == i7) || i10 > i7) {
                                                i7 = i10;
                                                i6 = k2.Y;
                                                i5 = i4;
                                                f2 = f3;
                                            }
                                            i10++;
                                            i8 = 9;
                                        }
                                    }
                                    i9++;
                                    i8 = 9;
                                }
                            } else {
                                for (int i11 = 1; i11 < this.f3611k; i11++) {
                                    SolverVariable solverVariable = this.f3614n.f3600d[i11];
                                    float p3 = arrayRow2.f3595e.p(solverVariable);
                                    if (p3 > 0.0f) {
                                        for (int i12 = 0; i12 < 9; i12++) {
                                            float f4 = solverVariable.a3[i12] / p3;
                                            if ((f4 < f2 && i12 == i7) || i12 > i7) {
                                                i7 = i12;
                                                i5 = i4;
                                                i6 = i11;
                                                f2 = f4;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i4++;
                    }
                    if (i5 != -1) {
                        ArrayRow arrayRow3 = this.f3607g[i5];
                        arrayRow3.f3591a.Z = -1;
                        Metrics metrics2 = C;
                        if (metrics2 != null) {
                            metrics2.f3629n++;
                        }
                        arrayRow3.C(this.f3614n.f3600d[i6]);
                        SolverVariable solverVariable2 = arrayRow3.f3591a;
                        solverVariable2.Z = i5;
                        solverVariable2.o(this, arrayRow3);
                    } else {
                        z2 = true;
                    }
                    if (i3 > this.f3611k / 2) {
                        z2 = true;
                    }
                }
                return i3;
            }
        }
        return 0;
    }

    private String H(int i2) {
        int i3 = i2 * 4;
        int i4 = i3 / 1024;
        int i5 = i4 / 1024;
        if (i5 > 0) {
            return "" + i5 + " Mb";
        } else if (i4 > 0) {
            return "" + i4 + " Kb";
        } else {
            return "" + i3 + " bytes";
        }
    }

    private String I(int i2) {
        if (i2 == 1) {
            return "LOW";
        }
        if (i2 == 2) {
            return "MEDIUM";
        }
        if (i2 == 3) {
            return "HIGH";
        }
        if (i2 == 4) {
            return "HIGHEST";
        }
        if (i2 == 5) {
            return "EQUALITY";
        }
        if (i2 == 8) {
            return "FIXED";
        }
        return i2 == 6 ? "BARRIER" : "NONE";
    }

    public static Metrics L() {
        return C;
    }

    private void S() {
        int i2 = this.f3605e * 2;
        this.f3605e = i2;
        this.f3607g = (ArrayRow[]) Arrays.copyOf(this.f3607g, i2);
        Cache cache = this.f3614n;
        cache.f3600d = (SolverVariable[]) Arrays.copyOf(cache.f3600d, this.f3605e);
        int i3 = this.f3605e;
        this.f3610j = new boolean[i3];
        this.f3606f = i3;
        this.f3613m = i3;
        Metrics metrics = C;
        if (metrics != null) {
            metrics.f3623h++;
            metrics.t = Math.max(metrics.t, (long) i3);
            Metrics metrics2 = C;
            metrics2.J = metrics2.t;
        }
    }

    private final int V(Row row, boolean z2) {
        Metrics metrics = C;
        if (metrics != null) {
            metrics.f3627l++;
        }
        for (int i2 = 0; i2 < this.f3611k; i2++) {
            this.f3610j[i2] = false;
        }
        boolean z3 = false;
        int i3 = 0;
        while (!z3) {
            Metrics metrics2 = C;
            if (metrics2 != null) {
                metrics2.f3628m++;
            }
            i3++;
            if (i3 >= this.f3611k * 2) {
                return i3;
            }
            if (row.getKey() != null) {
                this.f3610j[row.getKey().Y] = true;
            }
            SolverVariable e2 = row.e(this, this.f3610j);
            if (e2 != null) {
                boolean[] zArr = this.f3610j;
                int i4 = e2.Y;
                if (zArr[i4]) {
                    return i3;
                }
                zArr[i4] = true;
            }
            if (e2 != null) {
                float f2 = Float.MAX_VALUE;
                int i5 = -1;
                for (int i6 = 0; i6 < this.f3612l; i6++) {
                    ArrayRow arrayRow = this.f3607g[i6];
                    if (arrayRow.f3591a.c3 != SolverVariable.Type.UNRESTRICTED && !arrayRow.f3596f && arrayRow.y(e2)) {
                        float p2 = arrayRow.f3595e.p(e2);
                        if (p2 < 0.0f) {
                            float f3 = (-arrayRow.f3592b) / p2;
                            if (f3 < f2) {
                                i5 = i6;
                                f2 = f3;
                            }
                        }
                    }
                }
                if (i5 > -1) {
                    ArrayRow arrayRow2 = this.f3607g[i5];
                    arrayRow2.f3591a.Z = -1;
                    Metrics metrics3 = C;
                    if (metrics3 != null) {
                        metrics3.f3629n++;
                    }
                    arrayRow2.C(e2);
                    SolverVariable solverVariable = arrayRow2.f3591a;
                    solverVariable.Z = i5;
                    solverVariable.o(this, arrayRow2);
                }
            } else {
                z3 = true;
            }
        }
        return i3;
    }

    private void W() {
        int i2 = 0;
        if (A) {
            while (i2 < this.f3612l) {
                ArrayRow arrayRow = this.f3607g[i2];
                if (arrayRow != null) {
                    this.f3614n.f3597a.c(arrayRow);
                }
                this.f3607g[i2] = null;
                i2++;
            }
            return;
        }
        while (i2 < this.f3612l) {
            ArrayRow arrayRow2 = this.f3607g[i2];
            if (arrayRow2 != null) {
                this.f3614n.f3598b.c(arrayRow2);
            }
            this.f3607g[i2] = null;
            i2++;
        }
    }

    private SolverVariable a(SolverVariable.Type type, String str) {
        SolverVariable b2 = this.f3614n.f3599c.b();
        if (b2 == null) {
            b2 = new SolverVariable(type, str);
        } else {
            b2.i();
        }
        b2.m(type, str);
        int i2 = this.p;
        int i3 = B;
        if (i2 >= i3) {
            int i4 = i3 * 2;
            B = i4;
            this.o = (SolverVariable[]) Arrays.copyOf(this.o, i4);
        }
        SolverVariable[] solverVariableArr = this.o;
        int i5 = this.p;
        this.p = i5 + 1;
        solverVariableArr[i5] = b2;
        return b2;
    }

    private void g(ArrayRow arrayRow) {
        arrayRow.g(this, 0);
    }

    private final void m(ArrayRow arrayRow) {
        int i2;
        if (!x || !arrayRow.f3596f) {
            ArrayRow[] arrayRowArr = this.f3607g;
            int i3 = this.f3612l;
            arrayRowArr[i3] = arrayRow;
            SolverVariable solverVariable = arrayRow.f3591a;
            solverVariable.Z = i3;
            this.f3612l = i3 + 1;
            solverVariable.o(this, arrayRow);
        } else {
            arrayRow.f3591a.j(this, arrayRow.f3592b);
        }
        if (x && this.f3601a) {
            int i4 = 0;
            while (i4 < this.f3612l) {
                if (this.f3607g[i4] == null) {
                    System.out.println("WTF");
                }
                ArrayRow arrayRow2 = this.f3607g[i4];
                if (arrayRow2 != null && arrayRow2.f3596f) {
                    arrayRow2.f3591a.j(this, arrayRow2.f3592b);
                    (A ? this.f3614n.f3597a : this.f3614n.f3598b).c(arrayRow2);
                    this.f3607g[i4] = null;
                    int i5 = i4 + 1;
                    int i6 = i5;
                    while (true) {
                        i2 = this.f3612l;
                        if (i5 >= i2) {
                            break;
                        }
                        ArrayRow[] arrayRowArr2 = this.f3607g;
                        int i7 = i5 - 1;
                        ArrayRow arrayRow3 = arrayRowArr2[i5];
                        arrayRowArr2[i7] = arrayRow3;
                        SolverVariable solverVariable2 = arrayRow3.f3591a;
                        if (solverVariable2.Z == i5) {
                            solverVariable2.Z = i7;
                        }
                        i6 = i5;
                        i5++;
                    }
                    if (i6 < i2) {
                        this.f3607g[i6] = null;
                    }
                    this.f3612l = i2 - 1;
                    i4--;
                }
                i4++;
            }
            this.f3601a = false;
        }
    }

    private void n(ArrayRow arrayRow, int i2) {
        o(arrayRow, i2, 0);
    }

    private void r() {
        for (int i2 = 0; i2 < this.f3612l; i2++) {
            ArrayRow arrayRow = this.f3607g[i2];
            arrayRow.f3591a.Y2 = arrayRow.f3592b;
        }
    }

    public static ArrayRow w(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f2) {
        return linearSystem.v().m(solverVariable, solverVariable2, f2);
    }

    private SolverVariable y(String str, SolverVariable.Type type) {
        Metrics metrics = C;
        if (metrics != null) {
            metrics.p++;
        }
        if (this.f3611k + 1 >= this.f3606f) {
            S();
        }
        SolverVariable a2 = a(type, (String) null);
        a2.k(str);
        int i2 = this.f3602b + 1;
        this.f3602b = i2;
        this.f3611k++;
        a2.Y = i2;
        if (this.f3603c == null) {
            this.f3603c = new HashMap<>();
        }
        this.f3603c.put(str, a2);
        this.f3614n.f3600d[this.f3602b] = a2;
        return a2;
    }

    /* access modifiers changed from: package-private */
    public void C() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f3605e; i3++) {
            ArrayRow arrayRow = this.f3607g[i3];
            if (arrayRow != null) {
                i2 += arrayRow.E();
            }
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.f3612l; i5++) {
            ArrayRow arrayRow2 = this.f3607g[i5];
            if (arrayRow2 != null) {
                i4 += arrayRow2.E();
            }
        }
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append("Linear System -> Table size: ");
        sb.append(this.f3605e);
        sb.append(" (");
        int i6 = this.f3605e;
        sb.append(H(i6 * i6));
        sb.append(") -- row sizes: ");
        sb.append(H(i2));
        sb.append(", actual size: ");
        sb.append(H(i4));
        sb.append(" rows: ");
        sb.append(this.f3612l);
        sb.append("/");
        sb.append(this.f3613m);
        sb.append(" cols: ");
        sb.append(this.f3611k);
        sb.append("/");
        sb.append(this.f3606f);
        sb.append(StringUtils.SPACE);
        sb.append(0);
        sb.append(" occupied cells, ");
        sb.append(H(0));
        printStream.println(sb.toString());
    }

    public void D() {
        B();
        String str = "";
        for (int i2 = 0; i2 < this.f3612l; i2++) {
            if (this.f3607g[i2].f3591a.c3 == SolverVariable.Type.UNRESTRICTED) {
                str = (str + this.f3607g[i2].F()) + StringUtils.LF;
            }
        }
        System.out.println(str + this.f3604d + StringUtils.LF);
    }

    public void F(Metrics metrics) {
        C = metrics;
    }

    public Cache G() {
        return this.f3614n;
    }

    /* access modifiers changed from: package-private */
    public Row J() {
        return this.f3604d;
    }

    public int K() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f3612l; i3++) {
            ArrayRow arrayRow = this.f3607g[i3];
            if (arrayRow != null) {
                i2 += arrayRow.E();
            }
        }
        return i2;
    }

    public int M() {
        return this.f3612l;
    }

    public int N() {
        return this.f3602b;
    }

    public int O(Object obj) {
        SolverVariable j2 = ((ConstraintAnchor) obj).j();
        if (j2 != null) {
            return (int) (j2.Y2 + 0.5f);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public ArrayRow P(int i2) {
        return this.f3607g[i2];
    }

    /* access modifiers changed from: package-private */
    public float Q(String str) {
        SolverVariable R = R(str, SolverVariable.Type.UNRESTRICTED);
        if (R == null) {
            return 0.0f;
        }
        return R.Y2;
    }

    /* access modifiers changed from: package-private */
    public SolverVariable R(String str, SolverVariable.Type type) {
        if (this.f3603c == null) {
            this.f3603c = new HashMap<>();
        }
        SolverVariable solverVariable = this.f3603c.get(str);
        return solverVariable == null ? y(str, type) : solverVariable;
    }

    public void T() throws Exception {
        Metrics metrics = C;
        if (metrics != null) {
            metrics.f3624i++;
        }
        if (this.f3604d.isEmpty()) {
            r();
            return;
        }
        if (this.f3608h || this.f3609i) {
            Metrics metrics2 = C;
            if (metrics2 != null) {
                metrics2.v++;
            }
            int i2 = 0;
            while (i2 < this.f3612l) {
                if (this.f3607g[i2].f3596f) {
                    i2++;
                }
            }
            Metrics metrics3 = C;
            if (metrics3 != null) {
                metrics3.u++;
            }
            r();
            return;
        }
        U(this.f3604d);
    }

    /* access modifiers changed from: package-private */
    public void U(Row row) throws Exception {
        Metrics metrics = C;
        if (metrics != null) {
            metrics.z++;
            metrics.A = Math.max(metrics.A, (long) this.f3611k);
            Metrics metrics2 = C;
            metrics2.B = Math.max(metrics2.B, (long) this.f3612l);
        }
        E(row);
        V(row, false);
        r();
    }

    public void X(ArrayRow arrayRow) {
        SolverVariable solverVariable;
        int i2;
        if (arrayRow.f3596f && (solverVariable = arrayRow.f3591a) != null) {
            int i3 = solverVariable.Z;
            if (i3 != -1) {
                while (true) {
                    i2 = this.f3612l;
                    if (i3 >= i2 - 1) {
                        break;
                    }
                    ArrayRow[] arrayRowArr = this.f3607g;
                    int i4 = i3 + 1;
                    ArrayRow arrayRow2 = arrayRowArr[i4];
                    SolverVariable solverVariable2 = arrayRow2.f3591a;
                    if (solverVariable2.Z == i4) {
                        solverVariable2.Z = i3;
                    }
                    arrayRowArr[i3] = arrayRow2;
                    i3 = i4;
                }
                this.f3612l = i2 - 1;
            }
            SolverVariable solverVariable3 = arrayRow.f3591a;
            if (!solverVariable3.Z2) {
                solverVariable3.j(this, arrayRow.f3592b);
            }
            (A ? this.f3614n.f3597a : this.f3614n.f3598b).c(arrayRow);
        }
    }

    public void Y() {
        Cache cache;
        int i2 = 0;
        while (true) {
            cache = this.f3614n;
            SolverVariable[] solverVariableArr = cache.f3600d;
            if (i2 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i2];
            if (solverVariable != null) {
                solverVariable.i();
            }
            i2++;
        }
        cache.f3599c.d(this.o, this.p);
        this.p = 0;
        Arrays.fill(this.f3614n.f3600d, (Object) null);
        HashMap<String, SolverVariable> hashMap = this.f3603c;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f3602b = 0;
        this.f3604d.clear();
        this.f3611k = 1;
        for (int i3 = 0; i3 < this.f3612l; i3++) {
            ArrayRow arrayRow = this.f3607g[i3];
            if (arrayRow != null) {
                arrayRow.f3593c = false;
            }
        }
        W();
        this.f3612l = 0;
        this.q = A ? new ValuesRow(this.f3614n) : new ArrayRow(this.f3614n);
    }

    public void b(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f2, int i2) {
        ConstraintWidget constraintWidget3 = constraintWidget;
        ConstraintWidget constraintWidget4 = constraintWidget2;
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable u2 = u(constraintWidget3.r(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable u3 = u(constraintWidget3.r(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable u4 = u(constraintWidget3.r(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable u5 = u(constraintWidget3.r(type4));
        SolverVariable u6 = u(constraintWidget4.r(type));
        SolverVariable u7 = u(constraintWidget4.r(type2));
        SolverVariable u8 = u(constraintWidget4.r(type3));
        SolverVariable u9 = u(constraintWidget4.r(type4));
        ArrayRow v2 = v();
        double d2 = (double) f2;
        SolverVariable solverVariable = u8;
        double d3 = (double) i2;
        v2.v(u3, u5, u7, u9, (float) (Math.sin(d2) * d3));
        d(v2);
        ArrayRow v3 = v();
        v3.v(u2, u4, u6, solverVariable, (float) (Math.cos(d2) * d3));
        d(v3);
    }

    public void c(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i3, int i4) {
        int i5 = i4;
        ArrayRow v2 = v();
        v2.k(solverVariable, solverVariable2, i2, f2, solverVariable3, solverVariable4, i3);
        if (i5 != 8) {
            v2.g(this, i5);
        }
        d(v2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x009d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(androidx.constraintlayout.core.ArrayRow r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0003
            return
        L_0x0003:
            androidx.constraintlayout.core.Metrics r0 = C
            r1 = 1
            if (r0 == 0) goto L_0x0017
            long r3 = r0.f3625j
            long r3 = r3 + r1
            r0.f3625j = r3
            boolean r3 = r8.f3596f
            if (r3 == 0) goto L_0x0017
            long r3 = r0.f3626k
            long r3 = r3 + r1
            r0.f3626k = r3
        L_0x0017:
            int r0 = r7.f3612l
            r3 = 1
            int r0 = r0 + r3
            int r4 = r7.f3613m
            if (r0 >= r4) goto L_0x0026
            int r0 = r7.f3611k
            int r0 = r0 + r3
            int r4 = r7.f3606f
            if (r0 < r4) goto L_0x0029
        L_0x0026:
            r7.S()
        L_0x0029:
            boolean r0 = r8.f3596f
            r4 = 0
            if (r0 != 0) goto L_0x009f
            r8.b(r7)
            boolean r0 = r8.isEmpty()
            if (r0 == 0) goto L_0x0038
            return
        L_0x0038:
            r8.w()
            boolean r0 = r8.i(r7)
            if (r0 == 0) goto L_0x0096
            androidx.constraintlayout.core.SolverVariable r0 = r7.t()
            r8.f3591a = r0
            int r5 = r7.f3612l
            r7.m(r8)
            int r6 = r7.f3612l
            int r5 = r5 + r3
            if (r6 != r5) goto L_0x0096
            androidx.constraintlayout.core.LinearSystem$Row r4 = r7.q
            r4.d(r8)
            androidx.constraintlayout.core.LinearSystem$Row r4 = r7.q
            r7.V(r4, r3)
            int r4 = r0.Z
            r5 = -1
            if (r4 != r5) goto L_0x0097
            androidx.constraintlayout.core.SolverVariable r4 = r8.f3591a
            if (r4 != r0) goto L_0x0076
            androidx.constraintlayout.core.SolverVariable r0 = r8.A(r0)
            if (r0 == 0) goto L_0x0076
            androidx.constraintlayout.core.Metrics r4 = C
            if (r4 == 0) goto L_0x0073
            long r5 = r4.f3629n
            long r5 = r5 + r1
            r4.f3629n = r5
        L_0x0073:
            r8.C(r0)
        L_0x0076:
            boolean r0 = r8.f3596f
            if (r0 != 0) goto L_0x007f
            androidx.constraintlayout.core.SolverVariable r0 = r8.f3591a
            r0.o(r7, r8)
        L_0x007f:
            boolean r0 = A
            if (r0 == 0) goto L_0x008b
            androidx.constraintlayout.core.Cache r0 = r7.f3614n
            androidx.constraintlayout.core.Pools$Pool<androidx.constraintlayout.core.ArrayRow> r0 = r0.f3597a
        L_0x0087:
            r0.c(r8)
            goto L_0x0090
        L_0x008b:
            androidx.constraintlayout.core.Cache r0 = r7.f3614n
            androidx.constraintlayout.core.Pools$Pool<androidx.constraintlayout.core.ArrayRow> r0 = r0.f3598b
            goto L_0x0087
        L_0x0090:
            int r0 = r7.f3612l
            int r0 = r0 - r3
            r7.f3612l = r0
            goto L_0x0097
        L_0x0096:
            r3 = 0
        L_0x0097:
            boolean r0 = r8.x()
            if (r0 != 0) goto L_0x009e
            return
        L_0x009e:
            r4 = r3
        L_0x009f:
            if (r4 != 0) goto L_0x00a4
            r7.m(r8)
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.LinearSystem.d(androidx.constraintlayout.core.ArrayRow):void");
    }

    public ArrayRow e(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        if (!w || i3 != 8 || !solverVariable2.Z2 || solverVariable.Z != -1) {
            ArrayRow v2 = v();
            v2.r(solverVariable, solverVariable2, i2);
            if (i3 != 8) {
                v2.g(this, i3);
            }
            d(v2);
            return v2;
        }
        solverVariable.j(this, solverVariable2.Y2 + ((float) i2));
        return null;
    }

    public void f(SolverVariable solverVariable, int i2) {
        ArrayRow arrayRow;
        if (!w || solverVariable.Z != -1) {
            int i3 = solverVariable.Z;
            if (i3 != -1) {
                ArrayRow arrayRow2 = this.f3607g[i3];
                if (!arrayRow2.f3596f) {
                    if (arrayRow2.f3595e.e() == 0) {
                        arrayRow2.f3596f = true;
                    } else {
                        arrayRow = v();
                        arrayRow.q(solverVariable, i2);
                    }
                }
                arrayRow2.f3592b = (float) i2;
                return;
            }
            arrayRow = v();
            arrayRow.l(solverVariable, i2);
            d(arrayRow);
            return;
        }
        float f2 = (float) i2;
        solverVariable.j(this, f2);
        for (int i4 = 0; i4 < this.f3602b + 1; i4++) {
            SolverVariable solverVariable2 = this.f3614n.f3600d[i4];
            if (solverVariable2 != null && solverVariable2.g3 && solverVariable2.h3 == solverVariable.Y) {
                solverVariable2.j(this, solverVariable2.i3 + f2);
            }
        }
    }

    public void h(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, boolean z2) {
        ArrayRow v2 = v();
        SolverVariable x2 = x();
        x2.X2 = 0;
        v2.t(solverVariable, solverVariable2, x2, i2);
        d(v2);
    }

    public void i(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        ArrayRow v2 = v();
        SolverVariable x2 = x();
        x2.X2 = 0;
        v2.t(solverVariable, solverVariable2, x2, i2);
        if (i3 != 8) {
            o(v2, (int) (v2.f3595e.p(x2) * -1.0f), i3);
        }
        d(v2);
    }

    public void j(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, boolean z2) {
        ArrayRow v2 = v();
        SolverVariable x2 = x();
        x2.X2 = 0;
        v2.u(solverVariable, solverVariable2, x2, i2);
        d(v2);
    }

    public void k(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        ArrayRow v2 = v();
        SolverVariable x2 = x();
        x2.X2 = 0;
        v2.u(solverVariable, solverVariable2, x2, i2);
        if (i3 != 8) {
            o(v2, (int) (v2.f3595e.p(x2) * -1.0f), i3);
        }
        d(v2);
    }

    public void l(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2, int i2) {
        ArrayRow v2 = v();
        v2.n(solverVariable, solverVariable2, solverVariable3, solverVariable4, f2);
        if (i2 != 8) {
            v2.g(this, i2);
        }
        d(v2);
    }

    /* access modifiers changed from: package-private */
    public void o(ArrayRow arrayRow, int i2, int i3) {
        arrayRow.h(s(i3, (String) null), i2);
    }

    public void p(SolverVariable solverVariable, SolverVariable solverVariable2, int i2) {
        if (solverVariable.Z == -1 && i2 == 0) {
            if (solverVariable2.g3) {
                solverVariable2 = this.f3614n.f3600d[solverVariable2.h3];
            }
            if (solverVariable.g3) {
                SolverVariable solverVariable3 = this.f3614n.f3600d[solverVariable.h3];
            } else {
                solverVariable.l(this, solverVariable2, 0.0f);
            }
        } else {
            e(solverVariable, solverVariable2, i2, 8);
        }
    }

    /* access modifiers changed from: package-private */
    public final void q() {
        int i2;
        int i3 = 0;
        while (i3 < this.f3612l) {
            ArrayRow arrayRow = this.f3607g[i3];
            if (arrayRow.f3595e.e() == 0) {
                arrayRow.f3596f = true;
            }
            if (arrayRow.f3596f) {
                SolverVariable solverVariable = arrayRow.f3591a;
                solverVariable.Y2 = arrayRow.f3592b;
                solverVariable.h(arrayRow);
                int i4 = i3;
                while (true) {
                    i2 = this.f3612l;
                    if (i4 >= i2 - 1) {
                        break;
                    }
                    ArrayRow[] arrayRowArr = this.f3607g;
                    int i5 = i4 + 1;
                    arrayRowArr[i4] = arrayRowArr[i5];
                    i4 = i5;
                }
                this.f3607g[i2 - 1] = null;
                this.f3612l = i2 - 1;
                i3--;
                (A ? this.f3614n.f3597a : this.f3614n.f3598b).c(arrayRow);
            }
            i3++;
        }
    }

    public SolverVariable s(int i2, String str) {
        Metrics metrics = C;
        if (metrics != null) {
            metrics.q++;
        }
        if (this.f3611k + 1 >= this.f3606f) {
            S();
        }
        SolverVariable a2 = a(SolverVariable.Type.ERROR, str);
        int i3 = this.f3602b + 1;
        this.f3602b = i3;
        this.f3611k++;
        a2.Y = i3;
        a2.X2 = i2;
        this.f3614n.f3600d[i3] = a2;
        this.f3604d.f(a2);
        return a2;
    }

    public SolverVariable t() {
        Metrics metrics = C;
        if (metrics != null) {
            metrics.s++;
        }
        if (this.f3611k + 1 >= this.f3606f) {
            S();
        }
        SolverVariable a2 = a(SolverVariable.Type.SLACK, (String) null);
        int i2 = this.f3602b + 1;
        this.f3602b = i2;
        this.f3611k++;
        a2.Y = i2;
        this.f3614n.f3600d[i2] = a2;
        return a2;
    }

    public SolverVariable u(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.f3611k + 1 >= this.f3606f) {
            S();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.j();
            if (solverVariable == null) {
                constraintAnchor.z(this.f3614n);
                solverVariable = constraintAnchor.j();
            }
            int i2 = solverVariable.Y;
            if (i2 == -1 || i2 > this.f3602b || this.f3614n.f3600d[i2] == null) {
                if (i2 != -1) {
                    solverVariable.i();
                }
                int i3 = this.f3602b + 1;
                this.f3602b = i3;
                this.f3611k++;
                solverVariable.Y = i3;
                solverVariable.c3 = SolverVariable.Type.UNRESTRICTED;
                this.f3614n.f3600d[i3] = solverVariable;
            }
        }
        return solverVariable;
    }

    public ArrayRow v() {
        ArrayRow arrayRow;
        if (A) {
            arrayRow = this.f3614n.f3597a.b();
            if (arrayRow == null) {
                arrayRow = new ValuesRow(this.f3614n);
                E++;
                SolverVariable.g();
                return arrayRow;
            }
        } else {
            arrayRow = this.f3614n.f3598b.b();
            if (arrayRow == null) {
                arrayRow = new ArrayRow(this.f3614n);
                D++;
                SolverVariable.g();
                return arrayRow;
            }
        }
        arrayRow.D();
        SolverVariable.g();
        return arrayRow;
    }

    public SolverVariable x() {
        Metrics metrics = C;
        if (metrics != null) {
            metrics.r++;
        }
        if (this.f3611k + 1 >= this.f3606f) {
            S();
        }
        SolverVariable a2 = a(SolverVariable.Type.SLACK, (String) null);
        int i2 = this.f3602b + 1;
        this.f3602b = i2;
        this.f3611k++;
        a2.Y = i2;
        this.f3614n.f3600d[i2] = a2;
        return a2;
    }

    public void z() {
        B();
        String str = " num vars " + this.f3602b + StringUtils.LF;
        for (int i2 = 0; i2 < this.f3602b + 1; i2++) {
            SolverVariable solverVariable = this.f3614n.f3600d[i2];
            if (solverVariable != null && solverVariable.Z2) {
                str = str + " $[" + i2 + "] => " + solverVariable + " = " + solverVariable.Y2 + StringUtils.LF;
            }
        }
        String str2 = str + StringUtils.LF;
        for (int i3 = 0; i3 < this.f3602b + 1; i3++) {
            SolverVariable[] solverVariableArr = this.f3614n.f3600d;
            SolverVariable solverVariable2 = solverVariableArr[i3];
            if (solverVariable2 != null && solverVariable2.g3) {
                str2 = str2 + " ~[" + i3 + "] => " + solverVariable2 + " = " + solverVariableArr[solverVariable2.h3] + " + " + solverVariable2.i3 + StringUtils.LF;
            }
        }
        String str3 = str2 + "\n\n #  ";
        for (int i4 = 0; i4 < this.f3612l; i4++) {
            str3 = (str3 + this.f3607g[i4].F()) + "\n #  ";
        }
        if (this.f3604d != null) {
            str3 = str3 + "Goal: " + this.f3604d + StringUtils.LF;
        }
        System.out.println(str3);
    }
}
