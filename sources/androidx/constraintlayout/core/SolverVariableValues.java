package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.io.PrintStream;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

public class SolverVariableValues implements ArrayRow.ArrayRowVariables {

    /* renamed from: n  reason: collision with root package name */
    private static final boolean f3643n = false;
    private static final boolean o = true;
    private static float p = 0.001f;

    /* renamed from: a  reason: collision with root package name */
    private final int f3644a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f3645b = 16;

    /* renamed from: c  reason: collision with root package name */
    private int f3646c = 16;

    /* renamed from: d  reason: collision with root package name */
    int[] f3647d = new int[16];

    /* renamed from: e  reason: collision with root package name */
    int[] f3648e = new int[16];

    /* renamed from: f  reason: collision with root package name */
    int[] f3649f = new int[16];

    /* renamed from: g  reason: collision with root package name */
    float[] f3650g = new float[16];

    /* renamed from: h  reason: collision with root package name */
    int[] f3651h = new int[16];

    /* renamed from: i  reason: collision with root package name */
    int[] f3652i = new int[16];

    /* renamed from: j  reason: collision with root package name */
    int f3653j = 0;

    /* renamed from: k  reason: collision with root package name */
    int f3654k = -1;

    /* renamed from: l  reason: collision with root package name */
    private final ArrayRow f3655l;

    /* renamed from: m  reason: collision with root package name */
    protected final Cache f3656m;

    SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.f3655l = arrayRow;
        this.f3656m = cache;
        clear();
    }

    private void a(SolverVariable solverVariable, int i2) {
        int[] iArr;
        int i3 = solverVariable.Y % this.f3646c;
        int[] iArr2 = this.f3647d;
        int i4 = iArr2[i3];
        if (i4 == -1) {
            iArr2[i3] = i2;
        } else {
            while (true) {
                iArr = this.f3648e;
                int i5 = iArr[i4];
                if (i5 == -1) {
                    break;
                }
                i4 = i5;
            }
            iArr[i4] = i2;
        }
        this.f3648e[i2] = -1;
    }

    private void b(int i2, SolverVariable solverVariable, float f2) {
        this.f3649f[i2] = solverVariable.Y;
        this.f3650g[i2] = f2;
        this.f3651h[i2] = -1;
        this.f3652i[i2] = -1;
        solverVariable.a(this.f3655l);
        solverVariable.f3++;
        this.f3653j++;
    }

    private void c() {
        for (int i2 = 0; i2 < this.f3646c; i2++) {
            if (this.f3647d[i2] != -1) {
                String str = hashCode() + " hash [" + i2 + "] => ";
                int i3 = this.f3647d[i2];
                boolean z = false;
                while (!z) {
                    str = str + StringUtils.SPACE + this.f3649f[i3];
                    int i4 = this.f3648e[i3];
                    if (i4 != -1) {
                        i3 = i4;
                    } else {
                        z = true;
                    }
                }
                System.out.println(str);
            }
        }
    }

    private int d() {
        for (int i2 = 0; i2 < this.f3645b; i2++) {
            if (this.f3649f[i2] == -1) {
                return i2;
            }
        }
        return -1;
    }

    private void s() {
        int i2 = this.f3645b * 2;
        this.f3649f = Arrays.copyOf(this.f3649f, i2);
        this.f3650g = Arrays.copyOf(this.f3650g, i2);
        this.f3651h = Arrays.copyOf(this.f3651h, i2);
        this.f3652i = Arrays.copyOf(this.f3652i, i2);
        this.f3648e = Arrays.copyOf(this.f3648e, i2);
        for (int i3 = this.f3645b; i3 < i2; i3++) {
            this.f3649f[i3] = -1;
            this.f3648e[i3] = -1;
        }
        this.f3645b = i2;
    }

    private void t(int i2, SolverVariable solverVariable, float f2) {
        int d2 = d();
        b(d2, solverVariable, f2);
        if (i2 != -1) {
            this.f3651h[d2] = i2;
            int[] iArr = this.f3652i;
            iArr[d2] = iArr[i2];
            iArr[i2] = d2;
        } else {
            this.f3651h[d2] = -1;
            if (this.f3653j > 0) {
                this.f3652i[d2] = this.f3654k;
                this.f3654k = d2;
            } else {
                this.f3652i[d2] = -1;
            }
        }
        int i3 = this.f3652i[d2];
        if (i3 != -1) {
            this.f3651h[i3] = d2;
        }
        a(solverVariable, d2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void u(androidx.constraintlayout.core.SolverVariable r6) {
        /*
            r5 = this;
            int r6 = r6.Y
            int r0 = r5.f3646c
            int r0 = r6 % r0
            int[] r1 = r5.f3647d
            r2 = r1[r0]
            r3 = -1
            if (r2 != r3) goto L_0x000e
            return
        L_0x000e:
            int[] r4 = r5.f3649f
            r4 = r4[r2]
            if (r4 != r6) goto L_0x001d
            int[] r6 = r5.f3648e
            r4 = r6[r2]
            r1[r0] = r4
            r6[r2] = r3
            goto L_0x0039
        L_0x001d:
            int[] r0 = r5.f3648e
            r1 = r0[r2]
            if (r1 == r3) goto L_0x002b
            int[] r4 = r5.f3649f
            r4 = r4[r1]
            if (r4 == r6) goto L_0x002b
            r2 = r1
            goto L_0x001d
        L_0x002b:
            if (r1 == r3) goto L_0x0039
            int[] r4 = r5.f3649f
            r4 = r4[r1]
            if (r4 != r6) goto L_0x0039
            r6 = r0[r1]
            r0[r2] = r6
            r0[r1] = r3
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.SolverVariableValues.u(androidx.constraintlayout.core.SolverVariable):void");
    }

    public void clear() {
        int i2 = this.f3653j;
        for (int i3 = 0; i3 < i2; i3++) {
            SolverVariable k2 = k(i3);
            if (k2 != null) {
                k2.h(this.f3655l);
            }
        }
        for (int i4 = 0; i4 < this.f3645b; i4++) {
            this.f3649f[i4] = -1;
            this.f3648e[i4] = -1;
        }
        for (int i5 = 0; i5 < this.f3646c; i5++) {
            this.f3647d[i5] = -1;
        }
        this.f3653j = 0;
        this.f3654k = -1;
    }

    public int e() {
        return this.f3653j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int f(androidx.constraintlayout.core.SolverVariable r4) {
        /*
            r3 = this;
            int r0 = r3.f3653j
            r1 = -1
            if (r0 == 0) goto L_0x0033
            if (r4 != 0) goto L_0x0008
            goto L_0x0033
        L_0x0008:
            int r4 = r4.Y
            int r0 = r3.f3646c
            int r0 = r4 % r0
            int[] r2 = r3.f3647d
            r0 = r2[r0]
            if (r0 != r1) goto L_0x0015
            return r1
        L_0x0015:
            int[] r2 = r3.f3649f
            r2 = r2[r0]
            if (r2 != r4) goto L_0x001c
            return r0
        L_0x001c:
            int[] r2 = r3.f3648e
            r0 = r2[r0]
            if (r0 == r1) goto L_0x0029
            int[] r2 = r3.f3649f
            r2 = r2[r0]
            if (r2 == r4) goto L_0x0029
            goto L_0x001c
        L_0x0029:
            if (r0 != r1) goto L_0x002c
            return r1
        L_0x002c:
            int[] r2 = r3.f3649f
            r2 = r2[r0]
            if (r2 != r4) goto L_0x0033
            return r0
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.SolverVariableValues.f(androidx.constraintlayout.core.SolverVariable):int");
    }

    public void g() {
        int i2 = this.f3653j;
        System.out.print("{ ");
        for (int i3 = 0; i3 < i2; i3++) {
            SolverVariable k2 = k(i3);
            if (k2 != null) {
                PrintStream printStream = System.out;
                printStream.print(k2 + " = " + n(i3) + StringUtils.SPACE);
            }
        }
        System.out.println(" }");
    }

    public boolean h(SolverVariable solverVariable) {
        return f(solverVariable) != -1;
    }

    public float i(ArrayRow arrayRow, boolean z) {
        float p2 = p(arrayRow.f3591a);
        o(arrayRow.f3591a, z);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.f3595e;
        int e2 = solverVariableValues.e();
        int i2 = 0;
        int i3 = 0;
        while (i2 < e2) {
            int i4 = solverVariableValues.f3649f[i3];
            if (i4 != -1) {
                l(this.f3656m.f3600d[i4], solverVariableValues.f3650g[i3] * p2, z);
                i2++;
            }
            i3++;
        }
        return p2;
    }

    public void j(SolverVariable solverVariable, float f2) {
        float f3 = p;
        if (f2 <= (-f3) || f2 >= f3) {
            if (this.f3653j == 0) {
                b(0, solverVariable, f2);
                a(solverVariable, 0);
                this.f3654k = 0;
                return;
            }
            int f4 = f(solverVariable);
            if (f4 != -1) {
                this.f3650g[f4] = f2;
                return;
            }
            if (this.f3653j + 1 >= this.f3645b) {
                s();
            }
            int i2 = this.f3653j;
            int i3 = this.f3654k;
            int i4 = -1;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = this.f3649f[i3];
                int i7 = solverVariable.Y;
                if (i6 == i7) {
                    this.f3650g[i3] = f2;
                    return;
                }
                if (i6 < i7) {
                    i4 = i3;
                }
                i3 = this.f3652i[i3];
                if (i3 == -1) {
                    break;
                }
            }
            t(i4, solverVariable, f2);
            return;
        }
        o(solverVariable, true);
    }

    public SolverVariable k(int i2) {
        int i3 = this.f3653j;
        if (i3 == 0) {
            return null;
        }
        int i4 = this.f3654k;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i2 && i4 != -1) {
                return this.f3656m.f3600d[this.f3649f[i4]];
            }
            i4 = this.f3652i[i4];
            if (i4 == -1) {
                break;
            }
        }
        return null;
    }

    public void l(SolverVariable solverVariable, float f2, boolean z) {
        float f3 = p;
        if (f2 <= (-f3) || f2 >= f3) {
            int f4 = f(solverVariable);
            if (f4 == -1) {
                j(solverVariable, f2);
                return;
            }
            float[] fArr = this.f3650g;
            float f5 = fArr[f4] + f2;
            fArr[f4] = f5;
            float f6 = p;
            if (f5 > (-f6) && f5 < f6) {
                fArr[f4] = 0.0f;
                o(solverVariable, z);
            }
        }
    }

    public void m() {
        int i2 = this.f3653j;
        int i3 = this.f3654k;
        int i4 = 0;
        while (i4 < i2) {
            float[] fArr = this.f3650g;
            fArr[i3] = fArr[i3] * -1.0f;
            i3 = this.f3652i[i3];
            if (i3 != -1) {
                i4++;
            } else {
                return;
            }
        }
    }

    public float n(int i2) {
        int i3 = this.f3653j;
        int i4 = this.f3654k;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i2) {
                return this.f3650g[i4];
            }
            i4 = this.f3652i[i4];
            if (i4 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    public float o(SolverVariable solverVariable, boolean z) {
        int f2 = f(solverVariable);
        if (f2 == -1) {
            return 0.0f;
        }
        u(solverVariable);
        float f3 = this.f3650g[f2];
        if (this.f3654k == f2) {
            this.f3654k = this.f3652i[f2];
        }
        this.f3649f[f2] = -1;
        int[] iArr = this.f3651h;
        int i2 = iArr[f2];
        if (i2 != -1) {
            int[] iArr2 = this.f3652i;
            iArr2[i2] = iArr2[f2];
        }
        int i3 = this.f3652i[f2];
        if (i3 != -1) {
            iArr[i3] = iArr[f2];
        }
        this.f3653j--;
        solverVariable.f3--;
        if (z) {
            solverVariable.h(this.f3655l);
        }
        return f3;
    }

    public float p(SolverVariable solverVariable) {
        int f2 = f(solverVariable);
        if (f2 != -1) {
            return this.f3650g[f2];
        }
        return 0.0f;
    }

    public int q() {
        return 0;
    }

    public void r(float f2) {
        int i2 = this.f3653j;
        int i3 = this.f3654k;
        int i4 = 0;
        while (i4 < i2) {
            float[] fArr = this.f3650g;
            fArr[i3] = fArr[i3] / f2;
            i3 = this.f3652i[i3];
            if (i3 != -1) {
                i4++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb;
        String str;
        String str2 = hashCode() + " { ";
        int i2 = this.f3653j;
        for (int i3 = 0; i3 < i2; i3++) {
            SolverVariable k2 = k(i3);
            if (k2 != null) {
                String str3 = str2 + k2 + " = " + n(i3) + StringUtils.SPACE;
                int f2 = f(k2);
                String str4 = str3 + "[p: ";
                if (this.f3651h[f2] != -1) {
                    sb = new StringBuilder();
                    sb.append(str4);
                    sb.append(this.f3656m.f3600d[this.f3649f[this.f3651h[f2]]]);
                } else {
                    sb = new StringBuilder();
                    sb.append(str4);
                    sb.append("none");
                }
                String str5 = sb.toString() + ", n: ";
                if (this.f3652i[f2] != -1) {
                    str = str5 + this.f3656m.f3600d[this.f3649f[this.f3652i[f2]]];
                } else {
                    str = str5 + "none";
                }
                str2 = str + "]";
            }
        }
        return str2 + " }";
    }
}
