package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.io.PrintStream;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {

    /* renamed from: l  reason: collision with root package name */
    private static final boolean f3575l = false;

    /* renamed from: m  reason: collision with root package name */
    static final int f3576m = -1;

    /* renamed from: n  reason: collision with root package name */
    private static final boolean f3577n = false;
    private static float o = 0.001f;

    /* renamed from: a  reason: collision with root package name */
    int f3578a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayRow f3579b;

    /* renamed from: c  reason: collision with root package name */
    protected final Cache f3580c;

    /* renamed from: d  reason: collision with root package name */
    private int f3581d = 8;

    /* renamed from: e  reason: collision with root package name */
    private SolverVariable f3582e = null;

    /* renamed from: f  reason: collision with root package name */
    private int[] f3583f = new int[8];

    /* renamed from: g  reason: collision with root package name */
    private int[] f3584g = new int[8];

    /* renamed from: h  reason: collision with root package name */
    private float[] f3585h = new float[8];

    /* renamed from: i  reason: collision with root package name */
    private int f3586i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f3587j = -1;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3588k = false;

    ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.f3579b = arrayRow;
        this.f3580c = cache;
    }

    public int a() {
        return this.f3586i;
    }

    public final int b(int i2) {
        return this.f3583f[i2];
    }

    public final int c(int i2) {
        return this.f3584g[i2];
    }

    public final void clear() {
        int i2 = this.f3586i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f3578a) {
            SolverVariable solverVariable = this.f3580c.f3600d[this.f3583f[i2]];
            if (solverVariable != null) {
                solverVariable.h(this.f3579b);
            }
            i2 = this.f3584g[i2];
            i3++;
        }
        this.f3586i = -1;
        this.f3587j = -1;
        this.f3588k = false;
        this.f3578a = 0;
    }

    /* access modifiers changed from: package-private */
    public SolverVariable d() {
        SolverVariable solverVariable = this.f3582e;
        if (solverVariable != null) {
            return solverVariable;
        }
        int i2 = this.f3586i;
        int i3 = 0;
        SolverVariable solverVariable2 = null;
        while (i2 != -1 && i3 < this.f3578a) {
            if (this.f3585h[i2] < 0.0f) {
                SolverVariable solverVariable3 = this.f3580c.f3600d[this.f3583f[i2]];
                if (solverVariable2 == null || solverVariable2.X2 < solverVariable3.X2) {
                    solverVariable2 = solverVariable3;
                }
            }
            i2 = this.f3584g[i2];
            i3++;
        }
        return solverVariable2;
    }

    public int e() {
        return this.f3578a;
    }

    public int f(SolverVariable solverVariable) {
        int i2 = this.f3586i;
        if (i2 == -1) {
            return -1;
        }
        int i3 = 0;
        while (i2 != -1 && i3 < this.f3578a) {
            if (this.f3583f[i2] == solverVariable.Y) {
                return i2;
            }
            i2 = this.f3584g[i2];
            i3++;
        }
        return -1;
    }

    public void g() {
        int i2 = this.f3578a;
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
        int i2 = this.f3586i;
        if (i2 == -1) {
            return false;
        }
        int i3 = 0;
        while (i2 != -1 && i3 < this.f3578a) {
            if (this.f3583f[i2] == solverVariable.Y) {
                return true;
            }
            i2 = this.f3584g[i2];
            i3++;
        }
        return false;
    }

    public float i(ArrayRow arrayRow, boolean z) {
        float p = p(arrayRow.f3591a);
        o(arrayRow.f3591a, z);
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.f3595e;
        int e2 = arrayRowVariables.e();
        for (int i2 = 0; i2 < e2; i2++) {
            SolverVariable k2 = arrayRowVariables.k(i2);
            l(k2, arrayRowVariables.p(k2) * p, z);
        }
        return p;
    }

    public final void j(SolverVariable solverVariable, float f2) {
        if (f2 == 0.0f) {
            o(solverVariable, true);
            return;
        }
        int i2 = this.f3586i;
        if (i2 == -1) {
            this.f3586i = 0;
            this.f3585h[0] = f2;
            this.f3583f[0] = solverVariable.Y;
            this.f3584g[0] = -1;
            solverVariable.f3++;
            solverVariable.a(this.f3579b);
            this.f3578a++;
            if (!this.f3588k) {
                int i3 = this.f3587j + 1;
                this.f3587j = i3;
                int[] iArr = this.f3583f;
                if (i3 >= iArr.length) {
                    this.f3588k = true;
                    this.f3587j = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i4 = 0;
        int i5 = -1;
        while (i2 != -1 && i4 < this.f3578a) {
            int i6 = this.f3583f[i2];
            int i7 = solverVariable.Y;
            if (i6 == i7) {
                this.f3585h[i2] = f2;
                return;
            }
            if (i6 < i7) {
                i5 = i2;
            }
            i2 = this.f3584g[i2];
            i4++;
        }
        int i8 = this.f3587j;
        int i9 = i8 + 1;
        if (this.f3588k) {
            int[] iArr2 = this.f3583f;
            if (iArr2[i8] != -1) {
                i8 = iArr2.length;
            }
        } else {
            i8 = i9;
        }
        int[] iArr3 = this.f3583f;
        if (i8 >= iArr3.length && this.f3578a < iArr3.length) {
            int i10 = 0;
            while (true) {
                int[] iArr4 = this.f3583f;
                if (i10 >= iArr4.length) {
                    break;
                } else if (iArr4[i10] == -1) {
                    i8 = i10;
                    break;
                } else {
                    i10++;
                }
            }
        }
        int[] iArr5 = this.f3583f;
        if (i8 >= iArr5.length) {
            i8 = iArr5.length;
            int i11 = this.f3581d * 2;
            this.f3581d = i11;
            this.f3588k = false;
            this.f3587j = i8 - 1;
            this.f3585h = Arrays.copyOf(this.f3585h, i11);
            this.f3583f = Arrays.copyOf(this.f3583f, this.f3581d);
            this.f3584g = Arrays.copyOf(this.f3584g, this.f3581d);
        }
        this.f3583f[i8] = solverVariable.Y;
        this.f3585h[i8] = f2;
        int[] iArr6 = this.f3584g;
        if (i5 != -1) {
            iArr6[i8] = iArr6[i5];
            iArr6[i5] = i8;
        } else {
            iArr6[i8] = this.f3586i;
            this.f3586i = i8;
        }
        solverVariable.f3++;
        solverVariable.a(this.f3579b);
        int i12 = this.f3578a + 1;
        this.f3578a = i12;
        if (!this.f3588k) {
            this.f3587j++;
        }
        int[] iArr7 = this.f3583f;
        if (i12 >= iArr7.length) {
            this.f3588k = true;
        }
        if (this.f3587j >= iArr7.length) {
            this.f3588k = true;
            this.f3587j = iArr7.length - 1;
        }
    }

    public SolverVariable k(int i2) {
        int i3 = this.f3586i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f3578a) {
            if (i4 == i2) {
                return this.f3580c.f3600d[this.f3583f[i3]];
            }
            i3 = this.f3584g[i3];
            i4++;
        }
        return null;
    }

    public void l(SolverVariable solverVariable, float f2, boolean z) {
        float f3 = o;
        if (f2 <= (-f3) || f2 >= f3) {
            int i2 = this.f3586i;
            if (i2 == -1) {
                this.f3586i = 0;
                this.f3585h[0] = f2;
                this.f3583f[0] = solverVariable.Y;
                this.f3584g[0] = -1;
                solverVariable.f3++;
                solverVariable.a(this.f3579b);
                this.f3578a++;
                if (!this.f3588k) {
                    int i3 = this.f3587j + 1;
                    this.f3587j = i3;
                    int[] iArr = this.f3583f;
                    if (i3 >= iArr.length) {
                        this.f3588k = true;
                        this.f3587j = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i4 = 0;
            int i5 = -1;
            while (i2 != -1 && i4 < this.f3578a) {
                int i6 = this.f3583f[i2];
                int i7 = solverVariable.Y;
                if (i6 == i7) {
                    float[] fArr = this.f3585h;
                    float f4 = fArr[i2] + f2;
                    float f5 = o;
                    if (f4 > (-f5) && f4 < f5) {
                        f4 = 0.0f;
                    }
                    fArr[i2] = f4;
                    if (f4 == 0.0f) {
                        if (i2 == this.f3586i) {
                            this.f3586i = this.f3584g[i2];
                        } else {
                            int[] iArr2 = this.f3584g;
                            iArr2[i5] = iArr2[i2];
                        }
                        if (z) {
                            solverVariable.h(this.f3579b);
                        }
                        if (this.f3588k) {
                            this.f3587j = i2;
                        }
                        solverVariable.f3--;
                        this.f3578a--;
                        return;
                    }
                    return;
                }
                if (i6 < i7) {
                    i5 = i2;
                }
                i2 = this.f3584g[i2];
                i4++;
            }
            int i8 = this.f3587j;
            int i9 = i8 + 1;
            if (this.f3588k) {
                int[] iArr3 = this.f3583f;
                if (iArr3[i8] != -1) {
                    i8 = iArr3.length;
                }
            } else {
                i8 = i9;
            }
            int[] iArr4 = this.f3583f;
            if (i8 >= iArr4.length && this.f3578a < iArr4.length) {
                int i10 = 0;
                while (true) {
                    int[] iArr5 = this.f3583f;
                    if (i10 >= iArr5.length) {
                        break;
                    } else if (iArr5[i10] == -1) {
                        i8 = i10;
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            int[] iArr6 = this.f3583f;
            if (i8 >= iArr6.length) {
                i8 = iArr6.length;
                int i11 = this.f3581d * 2;
                this.f3581d = i11;
                this.f3588k = false;
                this.f3587j = i8 - 1;
                this.f3585h = Arrays.copyOf(this.f3585h, i11);
                this.f3583f = Arrays.copyOf(this.f3583f, this.f3581d);
                this.f3584g = Arrays.copyOf(this.f3584g, this.f3581d);
            }
            this.f3583f[i8] = solverVariable.Y;
            this.f3585h[i8] = f2;
            int[] iArr7 = this.f3584g;
            if (i5 != -1) {
                iArr7[i8] = iArr7[i5];
                iArr7[i5] = i8;
            } else {
                iArr7[i8] = this.f3586i;
                this.f3586i = i8;
            }
            solverVariable.f3++;
            solverVariable.a(this.f3579b);
            this.f3578a++;
            if (!this.f3588k) {
                this.f3587j++;
            }
            int i12 = this.f3587j;
            int[] iArr8 = this.f3583f;
            if (i12 >= iArr8.length) {
                this.f3588k = true;
                this.f3587j = iArr8.length - 1;
            }
        }
    }

    public void m() {
        int i2 = this.f3586i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f3578a) {
            float[] fArr = this.f3585h;
            fArr[i2] = fArr[i2] * -1.0f;
            i2 = this.f3584g[i2];
            i3++;
        }
    }

    public float n(int i2) {
        int i3 = this.f3586i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f3578a) {
            if (i4 == i2) {
                return this.f3585h[i3];
            }
            i3 = this.f3584g[i3];
            i4++;
        }
        return 0.0f;
    }

    public final float o(SolverVariable solverVariable, boolean z) {
        if (this.f3582e == solverVariable) {
            this.f3582e = null;
        }
        int i2 = this.f3586i;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.f3578a) {
            if (this.f3583f[i2] == solverVariable.Y) {
                if (i2 == this.f3586i) {
                    this.f3586i = this.f3584g[i2];
                } else {
                    int[] iArr = this.f3584g;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    solverVariable.h(this.f3579b);
                }
                solverVariable.f3--;
                this.f3578a--;
                this.f3583f[i2] = -1;
                if (this.f3588k) {
                    this.f3587j = i2;
                }
                return this.f3585h[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.f3584g[i2];
        }
        return 0.0f;
    }

    public final float p(SolverVariable solverVariable) {
        int i2 = this.f3586i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f3578a) {
            if (this.f3583f[i2] == solverVariable.Y) {
                return this.f3585h[i2];
            }
            i2 = this.f3584g[i2];
            i3++;
        }
        return 0.0f;
    }

    public int q() {
        return (this.f3583f.length * 12) + 36;
    }

    public void r(float f2) {
        int i2 = this.f3586i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f3578a) {
            float[] fArr = this.f3585h;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.f3584g[i2];
            i3++;
        }
    }

    public final float s(int i2) {
        return this.f3585h[i2];
    }

    /* access modifiers changed from: package-private */
    public boolean t() {
        int i2 = this.f3586i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f3578a) {
            if (this.f3585h[i2] > 0.0f) {
                return true;
            }
            i2 = this.f3584g[i2];
            i3++;
        }
        return false;
    }

    public String toString() {
        int i2 = this.f3586i;
        String str = "";
        int i3 = 0;
        while (i2 != -1 && i3 < this.f3578a) {
            str = ((str + " -> ") + this.f3585h[i2] + " : ") + this.f3580c.f3600d[this.f3583f[i2]];
            i2 = this.f3584g[i2];
            i3++;
        }
        return str;
    }
}
