package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;
import java.util.Comparator;
import org.apache.commons.lang3.StringUtils;

public class PriorityGoalRow extends ArrayRow {
    private static final float o = 1.0E-4f;
    private static final boolean p = false;
    static final int q = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f3633i = 128;

    /* renamed from: j  reason: collision with root package name */
    private SolverVariable[] f3634j = new SolverVariable[128];

    /* renamed from: k  reason: collision with root package name */
    private SolverVariable[] f3635k = new SolverVariable[128];

    /* renamed from: l  reason: collision with root package name */
    private int f3636l = 0;

    /* renamed from: m  reason: collision with root package name */
    GoalVariableAccessor f3637m = new GoalVariableAccessor(this);

    /* renamed from: n  reason: collision with root package name */
    Cache f3638n;

    class GoalVariableAccessor {

        /* renamed from: a  reason: collision with root package name */
        SolverVariable f3639a;

        /* renamed from: b  reason: collision with root package name */
        PriorityGoalRow f3640b;

        public GoalVariableAccessor(PriorityGoalRow priorityGoalRow) {
            this.f3640b = priorityGoalRow;
        }

        public void a(SolverVariable solverVariable) {
            for (int i2 = 0; i2 < 9; i2++) {
                float[] fArr = this.f3639a.b3;
                float f2 = fArr[i2] + solverVariable.b3[i2];
                fArr[i2] = f2;
                if (Math.abs(f2) < 1.0E-4f) {
                    this.f3639a.b3[i2] = 0.0f;
                }
            }
        }

        public boolean b(SolverVariable solverVariable, float f2) {
            boolean z = true;
            if (this.f3639a.s) {
                for (int i2 = 0; i2 < 9; i2++) {
                    float[] fArr = this.f3639a.b3;
                    float f3 = fArr[i2] + (solverVariable.b3[i2] * f2);
                    fArr[i2] = f3;
                    if (Math.abs(f3) < 1.0E-4f) {
                        this.f3639a.b3[i2] = 0.0f;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    PriorityGoalRow.this.J(this.f3639a);
                }
                return false;
            }
            for (int i3 = 0; i3 < 9; i3++) {
                float f4 = solverVariable.b3[i3];
                if (f4 != 0.0f) {
                    float f5 = f4 * f2;
                    if (Math.abs(f5) < 1.0E-4f) {
                        f5 = 0.0f;
                    }
                    this.f3639a.b3[i3] = f5;
                } else {
                    this.f3639a.b3[i3] = 0.0f;
                }
            }
            return true;
        }

        public void c(SolverVariable solverVariable) {
            this.f3639a = solverVariable;
        }

        public final boolean d() {
            for (int i2 = 8; i2 >= 0; i2--) {
                float f2 = this.f3639a.b3[i2];
                if (f2 > 0.0f) {
                    return false;
                }
                if (f2 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean e() {
            for (int i2 = 0; i2 < 9; i2++) {
                if (this.f3639a.b3[i2] != 0.0f) {
                    return false;
                }
            }
            return true;
        }

        public final boolean f(SolverVariable solverVariable) {
            int i2 = 8;
            while (true) {
                if (i2 < 0) {
                    break;
                }
                float f2 = solverVariable.b3[i2];
                float f3 = this.f3639a.b3[i2];
                if (f3 == f2) {
                    i2--;
                } else if (f3 < f2) {
                    return true;
                }
            }
            return false;
        }

        public void g() {
            Arrays.fill(this.f3639a.b3, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f3639a != null) {
                for (int i2 = 0; i2 < 9; i2++) {
                    str = str + this.f3639a.b3[i2] + StringUtils.SPACE;
                }
            }
            return str + "] " + this.f3639a;
        }
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.f3638n = cache;
    }

    private final void I(SolverVariable solverVariable) {
        int i2;
        int i3 = this.f3636l + 1;
        SolverVariable[] solverVariableArr = this.f3634j;
        if (i3 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.f3634j = solverVariableArr2;
            this.f3635k = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.f3634j;
        int i4 = this.f3636l;
        solverVariableArr3[i4] = solverVariable;
        int i5 = i4 + 1;
        this.f3636l = i5;
        if (i5 > 1 && solverVariableArr3[i4].Y > solverVariable.Y) {
            int i6 = 0;
            while (true) {
                i2 = this.f3636l;
                if (i6 >= i2) {
                    break;
                }
                this.f3635k[i6] = this.f3634j[i6];
                i6++;
            }
            Arrays.sort(this.f3635k, 0, i2, new Comparator<SolverVariable>() {
                /* renamed from: a */
                public int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
                    return solverVariable.Y - solverVariable2.Y;
                }
            });
            for (int i7 = 0; i7 < this.f3636l; i7++) {
                this.f3634j[i7] = this.f3635k[i7];
            }
        }
        solverVariable.s = true;
        solverVariable.a(this);
    }

    /* access modifiers changed from: private */
    public final void J(SolverVariable solverVariable) {
        int i2 = 0;
        while (i2 < this.f3636l) {
            if (this.f3634j[i2] == solverVariable) {
                while (true) {
                    int i3 = this.f3636l;
                    if (i2 < i3 - 1) {
                        SolverVariable[] solverVariableArr = this.f3634j;
                        int i4 = i2 + 1;
                        solverVariableArr[i2] = solverVariableArr[i4];
                        i2 = i4;
                    } else {
                        this.f3636l = i3 - 1;
                        solverVariable.s = false;
                        return;
                    }
                }
            } else {
                i2++;
            }
        }
    }

    public void c(LinearSystem linearSystem, ArrayRow arrayRow, boolean z) {
        SolverVariable solverVariable = arrayRow.f3591a;
        if (solverVariable != null) {
            ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.f3595e;
            int e2 = arrayRowVariables.e();
            for (int i2 = 0; i2 < e2; i2++) {
                SolverVariable k2 = arrayRowVariables.k(i2);
                float n2 = arrayRowVariables.n(i2);
                this.f3637m.c(k2);
                if (this.f3637m.b(solverVariable, n2)) {
                    I(k2);
                }
                this.f3592b += arrayRow.f3592b * n2;
            }
            J(solverVariable);
        }
    }

    public void clear() {
        this.f3636l = 0;
        this.f3592b = 0.0f;
    }

    public SolverVariable e(LinearSystem linearSystem, boolean[] zArr) {
        int i2 = -1;
        for (int i3 = 0; i3 < this.f3636l; i3++) {
            SolverVariable solverVariable = this.f3634j[i3];
            if (!zArr[solverVariable.Y]) {
                this.f3637m.c(solverVariable);
                GoalVariableAccessor goalVariableAccessor = this.f3637m;
                if (i2 == -1) {
                    if (!goalVariableAccessor.d()) {
                    }
                } else if (!goalVariableAccessor.f(this.f3634j[i2])) {
                }
                i2 = i3;
            }
        }
        if (i2 == -1) {
            return null;
        }
        return this.f3634j[i2];
    }

    public void f(SolverVariable solverVariable) {
        this.f3637m.c(solverVariable);
        this.f3637m.g();
        solverVariable.b3[solverVariable.X2] = 1.0f;
        I(solverVariable);
    }

    public boolean isEmpty() {
        return this.f3636l == 0;
    }

    public String toString() {
        String str = "" + " goal -> (" + this.f3592b + ") : ";
        for (int i2 = 0; i2 < this.f3636l; i2++) {
            this.f3637m.c(this.f3634j[i2]);
            str = str + this.f3637m + StringUtils.SPACE;
        }
        return str;
    }
}
