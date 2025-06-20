package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

public class Guideline extends ConstraintWidget {
    public static final int I1 = 0;
    public static final int J1 = 1;
    public static final int K1 = 0;
    public static final int L1 = 1;
    public static final int M1 = 2;
    public static final int N1 = -1;
    protected float A1 = -1.0f;
    protected int B1 = -1;
    protected int C1 = -1;
    protected boolean D1 = true;
    private ConstraintAnchor E1 = this.R;
    private int F1;
    private int G1;
    private boolean H1;

    /* renamed from: androidx.constraintlayout.core.widgets.Guideline$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4218a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type[] r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4218a = r0
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4218a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4218a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4218a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f4218a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f4218a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f4218a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f4218a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f4218a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.NONE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Guideline.AnonymousClass1.<clinit>():void");
        }
    }

    public Guideline() {
        this.F1 = 0;
        this.G1 = 0;
        this.Z.clear();
        this.Z.add(this.E1);
        int length = this.Y.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.Y[i2] = this.E1;
        }
    }

    public void A2(int i2) {
        this.G1 = i2;
    }

    public void B2(int i2) {
        if (this.F1 != i2) {
            this.F1 = i2;
            this.Z.clear();
            this.E1 = this.F1 == 1 ? this.Q : this.R;
            this.Z.add(this.E1);
            int length = this.Y.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.Y[i3] = this.E1;
            }
        }
    }

    public boolean G0() {
        return this.H1;
    }

    public boolean H0() {
        return this.H1;
    }

    public String f0() {
        return "Guideline";
    }

    public void g(LinearSystem linearSystem, boolean z) {
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) U();
        if (constraintWidgetContainer != null) {
            ConstraintAnchor r = constraintWidgetContainer.r(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor r2 = constraintWidgetContainer.r(ConstraintAnchor.Type.RIGHT);
            ConstraintWidget constraintWidget = this.c0;
            boolean z2 = true;
            boolean z3 = constraintWidget != null && constraintWidget.b0[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (this.F1 == 0) {
                r = constraintWidgetContainer.r(ConstraintAnchor.Type.TOP);
                r2 = constraintWidgetContainer.r(ConstraintAnchor.Type.BOTTOM);
                ConstraintWidget constraintWidget2 = this.c0;
                if (constraintWidget2 == null || constraintWidget2.b0[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    z2 = false;
                }
                z3 = z2;
            }
            if (this.H1 && this.E1.o()) {
                SolverVariable u = linearSystem.u(this.E1);
                linearSystem.f(u, this.E1.f());
                if (this.B1 != -1) {
                    if (z3) {
                        linearSystem.i(linearSystem.u(r2), u, 0, 5);
                    }
                } else if (this.C1 != -1 && z3) {
                    SolverVariable u2 = linearSystem.u(r2);
                    linearSystem.i(u, linearSystem.u(r), 0, 5);
                    linearSystem.i(u2, u, 0, 5);
                }
                this.H1 = false;
            } else if (this.B1 != -1) {
                SolverVariable u3 = linearSystem.u(this.E1);
                linearSystem.e(u3, linearSystem.u(r), this.B1, 8);
                if (z3) {
                    linearSystem.i(linearSystem.u(r2), u3, 0, 5);
                }
            } else if (this.C1 != -1) {
                SolverVariable u4 = linearSystem.u(this.E1);
                SolverVariable u5 = linearSystem.u(r2);
                linearSystem.e(u4, u5, -this.C1, 8);
                if (z3) {
                    linearSystem.i(u4, linearSystem.u(r), 0, 5);
                    linearSystem.i(u5, u4, 0, 5);
                }
            } else if (this.A1 != -1.0f) {
                linearSystem.d(LinearSystem.w(linearSystem, linearSystem.u(this.E1), linearSystem.u(r2), this.A1));
            }
        }
    }

    public boolean h() {
        return true;
    }

    public void j2(LinearSystem linearSystem, boolean z) {
        if (U() != null) {
            int O = linearSystem.O(this.E1);
            if (this.F1 == 1) {
                f2(O);
                g2(0);
                y1(U().D());
                c2(0);
                return;
            }
            f2(0);
            g2(O);
            c2(U().m0());
            y1(0);
        }
    }

    public void k2() {
        if (this.B1 != -1) {
            t2();
        } else if (this.A1 != -1.0f) {
            s2();
        } else if (this.C1 != -1) {
            r2();
        }
    }

    public ConstraintAnchor l2() {
        return this.E1;
    }

    public int m2() {
        return this.F1;
    }

    public void n(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.n(constraintWidget, hashMap);
        Guideline guideline = (Guideline) constraintWidget;
        this.A1 = guideline.A1;
        this.B1 = guideline.B1;
        this.C1 = guideline.C1;
        this.D1 = guideline.D1;
        B2(guideline.F1);
    }

    public int n2() {
        return this.B1;
    }

    public int o2() {
        if (this.A1 != -1.0f) {
            return 0;
        }
        if (this.B1 != -1) {
            return 1;
        }
        return this.C1 != -1 ? 2 : -1;
    }

    public int p2() {
        return this.C1;
    }

    public float q2() {
        return this.A1;
    }

    public ConstraintAnchor r(ConstraintAnchor.Type type) {
        int i2 = AnonymousClass1.f4218a[type.ordinal()];
        if (i2 == 1 || i2 == 2) {
            if (this.F1 == 1) {
                return this.E1;
            }
            return null;
        } else if ((i2 == 3 || i2 == 4) && this.F1 == 0) {
            return this.E1;
        } else {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void r2() {
        int o0 = o0();
        if (this.F1 == 0) {
            o0 = p0();
        }
        w2(o0);
    }

    /* access modifiers changed from: package-private */
    public void s2() {
        int m0 = U().m0() - o0();
        if (this.F1 == 0) {
            m0 = U().D() - p0();
        }
        x2(m0);
    }

    /* access modifiers changed from: package-private */
    public void t2() {
        float o0 = ((float) o0()) / ((float) U().m0());
        if (this.F1 == 0) {
            o0 = ((float) p0()) / ((float) U().D());
        }
        y2(o0);
    }

    public boolean u2() {
        return this.A1 != -1.0f && this.B1 == -1 && this.C1 == -1;
    }

    public void v2(int i2) {
        this.E1.A(i2);
        this.H1 = true;
    }

    public void w2(int i2) {
        if (i2 > -1) {
            this.A1 = -1.0f;
            this.B1 = i2;
            this.C1 = -1;
        }
    }

    public void x2(int i2) {
        if (i2 > -1) {
            this.A1 = -1.0f;
            this.B1 = -1;
            this.C1 = i2;
        }
    }

    public void y2(float f2) {
        if (f2 > -1.0f) {
            this.A1 = f2;
            this.B1 = -1;
            this.C1 = -1;
        }
    }

    public void z2(int i2) {
        y2(((float) i2) / 100.0f);
    }
}
