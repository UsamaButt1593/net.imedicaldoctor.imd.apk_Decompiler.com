package androidx.constraintlayout.core;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import java.util.ArrayList;

public class ArrayRow implements LinearSystem.Row {

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f3589g = false;

    /* renamed from: h  reason: collision with root package name */
    private static final boolean f3590h = false;

    /* renamed from: a  reason: collision with root package name */
    SolverVariable f3591a = null;

    /* renamed from: b  reason: collision with root package name */
    float f3592b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    boolean f3593c = false;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<SolverVariable> f3594d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public ArrayRowVariables f3595e;

    /* renamed from: f  reason: collision with root package name */
    boolean f3596f = false;

    public interface ArrayRowVariables {
        void clear();

        int e();

        int f(SolverVariable solverVariable);

        void g();

        boolean h(SolverVariable solverVariable);

        float i(ArrayRow arrayRow, boolean z);

        void j(SolverVariable solverVariable, float f2);

        SolverVariable k(int i2);

        void l(SolverVariable solverVariable, float f2, boolean z);

        void m();

        float n(int i2);

        float o(SolverVariable solverVariable, boolean z);

        float p(SolverVariable solverVariable);

        int q();

        void r(float f2);
    }

    public ArrayRow() {
    }

    private SolverVariable B(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int e2 = this.f3595e.e();
        SolverVariable solverVariable2 = null;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < e2; i2++) {
            float n2 = this.f3595e.n(i2);
            if (n2 < 0.0f) {
                SolverVariable k2 = this.f3595e.k(i2);
                if ((zArr == null || !zArr[k2.Y]) && k2 != solverVariable && (((type = k2.c3) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && n2 < f2)) {
                    f2 = n2;
                    solverVariable2 = k2;
                }
            }
        }
        return solverVariable2;
    }

    private boolean z(SolverVariable solverVariable, LinearSystem linearSystem) {
        return solverVariable.f3 <= 1;
    }

    public SolverVariable A(SolverVariable solverVariable) {
        return B((boolean[]) null, solverVariable);
    }

    /* access modifiers changed from: package-private */
    public void C(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f3591a;
        if (solverVariable2 != null) {
            this.f3595e.j(solverVariable2, -1.0f);
            this.f3591a.Z = -1;
            this.f3591a = null;
        }
        float o = this.f3595e.o(solverVariable, true) * -1.0f;
        this.f3591a = solverVariable;
        if (o != 1.0f) {
            this.f3592b /= o;
            this.f3595e.r(o);
        }
    }

    public void D() {
        this.f3591a = null;
        this.f3595e.clear();
        this.f3592b = 0.0f;
        this.f3596f = false;
    }

    /* access modifiers changed from: package-private */
    public int E() {
        return (this.f3591a != null ? 4 : 0) + 8 + this.f3595e.q();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0066, code lost:
        r7 = r10.f3595e.n(r2);
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String F() {
        /*
            r10 = this;
            androidx.constraintlayout.core.SolverVariable r0 = r10.f3591a
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0018
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
        L_0x0013:
            java.lang.String r0 = r0.toString()
            goto L_0x0026
        L_0x0018:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            androidx.constraintlayout.core.SolverVariable r1 = r10.f3591a
            r0.append(r1)
            goto L_0x0013
        L_0x0026:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " = "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r1 = r10.f3592b
            r2 = 0
            r3 = 1
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0053
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r10.f3592b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 1
            goto L_0x0054
        L_0x0053:
            r1 = 0
        L_0x0054:
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r5 = r10.f3595e
            int r5 = r5.e()
        L_0x005a:
            if (r2 >= r5) goto L_0x00d6
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r6 = r10.f3595e
            androidx.constraintlayout.core.SolverVariable r6 = r6.k(r2)
            if (r6 != 0) goto L_0x0066
            goto L_0x00d3
        L_0x0066:
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r7 = r10.f3595e
            float r7 = r7.n(r2)
            int r8 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r8 != 0) goto L_0x0071
            goto L_0x00d3
        L_0x0071:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L_0x0091
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ae
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "- "
        L_0x0087:
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r7 = r7 * r9
            goto L_0x00ae
        L_0x0091:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            if (r8 <= 0) goto L_0x00a5
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " + "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00ae
        L_0x00a5:
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " - "
            goto L_0x0087
        L_0x00ae:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x00c4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        L_0x00b9:
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
            goto L_0x00d2
        L_0x00c4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            goto L_0x00b9
        L_0x00d2:
            r1 = 1
        L_0x00d3:
            int r2 = r2 + 1
            goto L_0x005a
        L_0x00d6:
            if (r1 != 0) goto L_0x00e9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0.0"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x00e9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.ArrayRow.F():java.lang.String");
    }

    public void G(LinearSystem linearSystem, SolverVariable solverVariable, boolean z) {
        if (solverVariable != null && solverVariable.g3) {
            float p = this.f3595e.p(solverVariable);
            this.f3592b += solverVariable.i3 * p;
            this.f3595e.o(solverVariable, z);
            if (z) {
                solverVariable.h(this);
            }
            this.f3595e.l(linearSystem.f3614n.f3600d[solverVariable.h3], p, z);
            if (LinearSystem.x && this.f3595e.e() == 0) {
                this.f3596f = true;
                linearSystem.f3601a = true;
            }
        }
    }

    public void a(LinearSystem linearSystem, SolverVariable solverVariable, boolean z) {
        if (solverVariable != null && solverVariable.Z2) {
            this.f3592b += solverVariable.Y2 * this.f3595e.p(solverVariable);
            this.f3595e.o(solverVariable, z);
            if (z) {
                solverVariable.h(this);
            }
            if (LinearSystem.x && this.f3595e.e() == 0) {
                this.f3596f = true;
                linearSystem.f3601a = true;
            }
        }
    }

    public void b(LinearSystem linearSystem) {
        if (linearSystem.f3607g.length != 0) {
            boolean z = false;
            while (!z) {
                int e2 = this.f3595e.e();
                for (int i2 = 0; i2 < e2; i2++) {
                    SolverVariable k2 = this.f3595e.k(i2);
                    if (k2.Z != -1 || k2.Z2 || k2.g3) {
                        this.f3594d.add(k2);
                    }
                }
                int size = this.f3594d.size();
                if (size > 0) {
                    for (int i3 = 0; i3 < size; i3++) {
                        SolverVariable solverVariable = this.f3594d.get(i3);
                        if (solverVariable.Z2) {
                            a(linearSystem, solverVariable, true);
                        } else if (solverVariable.g3) {
                            G(linearSystem, solverVariable, true);
                        } else {
                            c(linearSystem, linearSystem.f3607g[solverVariable.Z], true);
                        }
                    }
                    this.f3594d.clear();
                } else {
                    z = true;
                }
            }
            if (LinearSystem.x && this.f3591a != null && this.f3595e.e() == 0) {
                this.f3596f = true;
                linearSystem.f3601a = true;
            }
        }
    }

    public void c(LinearSystem linearSystem, ArrayRow arrayRow, boolean z) {
        this.f3592b += arrayRow.f3592b * this.f3595e.i(arrayRow, z);
        if (z) {
            arrayRow.f3591a.h(this);
        }
        if (LinearSystem.x && this.f3591a != null && this.f3595e.e() == 0) {
            this.f3596f = true;
            linearSystem.f3601a = true;
        }
    }

    public void clear() {
        this.f3595e.clear();
        this.f3591a = null;
        this.f3592b = 0.0f;
    }

    public void d(LinearSystem.Row row) {
        if (row instanceof ArrayRow) {
            ArrayRow arrayRow = (ArrayRow) row;
            this.f3591a = null;
            this.f3595e.clear();
            for (int i2 = 0; i2 < arrayRow.f3595e.e(); i2++) {
                this.f3595e.l(arrayRow.f3595e.k(i2), arrayRow.f3595e.n(i2), true);
            }
        }
    }

    public SolverVariable e(LinearSystem linearSystem, boolean[] zArr) {
        return B(zArr, (SolverVariable) null);
    }

    public void f(SolverVariable solverVariable) {
        int i2 = solverVariable.X2;
        float f2 = 1.0f;
        if (i2 != 1) {
            if (i2 == 2) {
                f2 = 1000.0f;
            } else if (i2 == 3) {
                f2 = 1000000.0f;
            } else if (i2 == 4) {
                f2 = 1.0E9f;
            } else if (i2 == 5) {
                f2 = 1.0E12f;
            }
        }
        this.f3595e.j(solverVariable, f2);
    }

    public ArrayRow g(LinearSystem linearSystem, int i2) {
        this.f3595e.j(linearSystem.s(i2, "ep"), 1.0f);
        this.f3595e.j(linearSystem.s(i2, "em"), -1.0f);
        return this;
    }

    public SolverVariable getKey() {
        return this.f3591a;
    }

    /* access modifiers changed from: package-private */
    public ArrayRow h(SolverVariable solverVariable, int i2) {
        this.f3595e.j(solverVariable, (float) i2);
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean i(LinearSystem linearSystem) {
        boolean z;
        SolverVariable j2 = j(linearSystem);
        if (j2 == null) {
            z = true;
        } else {
            C(j2);
            z = false;
        }
        if (this.f3595e.e() == 0) {
            this.f3596f = true;
        }
        return z;
    }

    public boolean isEmpty() {
        return this.f3591a == null && this.f3592b == 0.0f && this.f3595e.e() == 0;
    }

    /* access modifiers changed from: package-private */
    public SolverVariable j(LinearSystem linearSystem) {
        int e2 = this.f3595e.e();
        SolverVariable solverVariable = null;
        SolverVariable solverVariable2 = null;
        boolean z = false;
        boolean z2 = false;
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i2 = 0; i2 < e2; i2++) {
            float n2 = this.f3595e.n(i2);
            SolverVariable k2 = this.f3595e.k(i2);
            if (k2.c3 == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null || f2 > n2) {
                    z = z(k2, linearSystem);
                    f2 = n2;
                    solverVariable = k2;
                } else if (!z && z(k2, linearSystem)) {
                    f2 = n2;
                    solverVariable = k2;
                    z = true;
                }
            } else if (solverVariable == null && n2 < 0.0f) {
                if (solverVariable2 == null || f3 > n2) {
                    z2 = z(k2, linearSystem);
                    f3 = n2;
                    solverVariable2 = k2;
                } else if (!z2 && z(k2, linearSystem)) {
                    f3 = n2;
                    solverVariable2 = k2;
                    z2 = true;
                }
            }
        }
        return solverVariable != null ? solverVariable : solverVariable2;
    }

    /* access modifiers changed from: package-private */
    public ArrayRow k(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i3) {
        float f3;
        int i4;
        if (solverVariable2 == solverVariable3) {
            this.f3595e.j(solverVariable, 1.0f);
            this.f3595e.j(solverVariable4, 1.0f);
            this.f3595e.j(solverVariable2, -2.0f);
            return this;
        }
        if (f2 == 0.5f) {
            this.f3595e.j(solverVariable, 1.0f);
            this.f3595e.j(solverVariable2, -1.0f);
            this.f3595e.j(solverVariable3, -1.0f);
            this.f3595e.j(solverVariable4, 1.0f);
            if (i2 > 0 || i3 > 0) {
                i4 = (-i2) + i3;
            }
            return this;
        }
        if (f2 <= 0.0f) {
            this.f3595e.j(solverVariable, -1.0f);
            this.f3595e.j(solverVariable2, 1.0f);
            f3 = (float) i2;
        } else if (f2 >= 1.0f) {
            this.f3595e.j(solverVariable4, -1.0f);
            this.f3595e.j(solverVariable3, 1.0f);
            i4 = -i3;
        } else {
            float f4 = 1.0f - f2;
            this.f3595e.j(solverVariable, f4 * 1.0f);
            this.f3595e.j(solverVariable2, f4 * -1.0f);
            this.f3595e.j(solverVariable3, -1.0f * f2);
            this.f3595e.j(solverVariable4, 1.0f * f2);
            if (i2 > 0 || i3 > 0) {
                f3 = (((float) (-i2)) * f4) + (((float) i3) * f2);
            }
            return this;
        }
        this.f3592b = f3;
        return this;
        f3 = (float) i4;
        this.f3592b = f3;
        return this;
    }

    /* access modifiers changed from: package-private */
    public ArrayRow l(SolverVariable solverVariable, int i2) {
        this.f3591a = solverVariable;
        float f2 = (float) i2;
        solverVariable.Y2 = f2;
        this.f3592b = f2;
        this.f3596f = true;
        return this;
    }

    /* access modifiers changed from: package-private */
    public ArrayRow m(SolverVariable solverVariable, SolverVariable solverVariable2, float f2) {
        this.f3595e.j(solverVariable, -1.0f);
        this.f3595e.j(solverVariable2, f2);
        return this;
    }

    public ArrayRow n(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2) {
        this.f3595e.j(solverVariable, -1.0f);
        this.f3595e.j(solverVariable2, 1.0f);
        this.f3595e.j(solverVariable3, f2);
        this.f3595e.j(solverVariable4, -f2);
        return this;
    }

    public ArrayRow o(float f2, float f3, float f4, SolverVariable solverVariable, int i2, SolverVariable solverVariable2, int i3, SolverVariable solverVariable3, int i4, SolverVariable solverVariable4, int i5) {
        if (f3 == 0.0f || f2 == f4) {
            this.f3592b = (float) (((-i2) - i3) + i4 + i5);
            this.f3595e.j(solverVariable, 1.0f);
            this.f3595e.j(solverVariable2, -1.0f);
            this.f3595e.j(solverVariable4, 1.0f);
            this.f3595e.j(solverVariable3, -1.0f);
        } else {
            float f5 = (f2 / f3) / (f4 / f3);
            this.f3592b = ((float) ((-i2) - i3)) + (((float) i4) * f5) + (((float) i5) * f5);
            this.f3595e.j(solverVariable, 1.0f);
            this.f3595e.j(solverVariable2, -1.0f);
            this.f3595e.j(solverVariable4, f5);
            this.f3595e.j(solverVariable3, -f5);
        }
        return this;
    }

    public ArrayRow p(float f2, float f3, float f4, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.f3592b = 0.0f;
        if (f3 == 0.0f || f2 == f4) {
            this.f3595e.j(solverVariable, 1.0f);
            this.f3595e.j(solverVariable2, -1.0f);
            this.f3595e.j(solverVariable4, 1.0f);
            this.f3595e.j(solverVariable3, -1.0f);
        } else if (f2 == 0.0f) {
            this.f3595e.j(solverVariable, 1.0f);
            this.f3595e.j(solverVariable2, -1.0f);
        } else if (f4 == 0.0f) {
            this.f3595e.j(solverVariable3, 1.0f);
            this.f3595e.j(solverVariable4, -1.0f);
        } else {
            float f5 = (f2 / f3) / (f4 / f3);
            this.f3595e.j(solverVariable, 1.0f);
            this.f3595e.j(solverVariable2, -1.0f);
            this.f3595e.j(solverVariable4, f5);
            this.f3595e.j(solverVariable3, -f5);
        }
        return this;
    }

    public ArrayRow q(SolverVariable solverVariable, int i2) {
        ArrayRowVariables arrayRowVariables;
        float f2;
        if (i2 < 0) {
            this.f3592b = (float) (i2 * -1);
            arrayRowVariables = this.f3595e;
            f2 = 1.0f;
        } else {
            this.f3592b = (float) i2;
            arrayRowVariables = this.f3595e;
            f2 = -1.0f;
        }
        arrayRowVariables.j(solverVariable, f2);
        return this;
    }

    public ArrayRow r(SolverVariable solverVariable, SolverVariable solverVariable2, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f3592b = (float) i2;
        }
        if (!z) {
            this.f3595e.j(solverVariable, -1.0f);
            this.f3595e.j(solverVariable2, 1.0f);
        } else {
            this.f3595e.j(solverVariable, 1.0f);
            this.f3595e.j(solverVariable2, -1.0f);
        }
        return this;
    }

    public ArrayRow s(SolverVariable solverVariable, int i2, SolverVariable solverVariable2) {
        this.f3592b = (float) i2;
        this.f3595e.j(solverVariable, -1.0f);
        return this;
    }

    public ArrayRow t(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f3592b = (float) i2;
        }
        if (!z) {
            this.f3595e.j(solverVariable, -1.0f);
            this.f3595e.j(solverVariable2, 1.0f);
            this.f3595e.j(solverVariable3, 1.0f);
        } else {
            this.f3595e.j(solverVariable, 1.0f);
            this.f3595e.j(solverVariable2, -1.0f);
            this.f3595e.j(solverVariable3, -1.0f);
        }
        return this;
    }

    public String toString() {
        return F();
    }

    public ArrayRow u(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f3592b = (float) i2;
        }
        if (!z) {
            this.f3595e.j(solverVariable, -1.0f);
            this.f3595e.j(solverVariable2, 1.0f);
            this.f3595e.j(solverVariable3, -1.0f);
        } else {
            this.f3595e.j(solverVariable, 1.0f);
            this.f3595e.j(solverVariable2, -1.0f);
            this.f3595e.j(solverVariable3, 1.0f);
        }
        return this;
    }

    public ArrayRow v(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2) {
        this.f3595e.j(solverVariable3, 0.5f);
        this.f3595e.j(solverVariable4, 0.5f);
        this.f3595e.j(solverVariable, -0.5f);
        this.f3595e.j(solverVariable2, -0.5f);
        this.f3592b = -f2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void w() {
        float f2 = this.f3592b;
        if (f2 < 0.0f) {
            this.f3592b = f2 * -1.0f;
            this.f3595e.m();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        SolverVariable solverVariable = this.f3591a;
        return solverVariable != null && (solverVariable.c3 == SolverVariable.Type.UNRESTRICTED || this.f3592b >= 0.0f);
    }

    /* access modifiers changed from: package-private */
    public boolean y(SolverVariable solverVariable) {
        return this.f3595e.h(solverVariable);
    }

    public ArrayRow(Cache cache) {
        this.f3595e = new ArrayLinkedVariables(this, cache);
    }
}
