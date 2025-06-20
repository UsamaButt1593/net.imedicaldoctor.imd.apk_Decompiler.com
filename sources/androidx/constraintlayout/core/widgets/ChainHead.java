package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

public class ChainHead {

    /* renamed from: a  reason: collision with root package name */
    protected ConstraintWidget f4162a;

    /* renamed from: b  reason: collision with root package name */
    protected ConstraintWidget f4163b;

    /* renamed from: c  reason: collision with root package name */
    protected ConstraintWidget f4164c;

    /* renamed from: d  reason: collision with root package name */
    protected ConstraintWidget f4165d;

    /* renamed from: e  reason: collision with root package name */
    protected ConstraintWidget f4166e;

    /* renamed from: f  reason: collision with root package name */
    protected ConstraintWidget f4167f;

    /* renamed from: g  reason: collision with root package name */
    protected ConstraintWidget f4168g;

    /* renamed from: h  reason: collision with root package name */
    protected ArrayList<ConstraintWidget> f4169h;

    /* renamed from: i  reason: collision with root package name */
    protected int f4170i;

    /* renamed from: j  reason: collision with root package name */
    protected int f4171j;

    /* renamed from: k  reason: collision with root package name */
    protected float f4172k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    int f4173l;

    /* renamed from: m  reason: collision with root package name */
    int f4174m;

    /* renamed from: n  reason: collision with root package name */
    int f4175n;
    boolean o;
    private int p;
    private boolean q;
    protected boolean r;
    protected boolean s;
    protected boolean t;
    protected boolean u;
    private boolean v;

    public ChainHead(ConstraintWidget constraintWidget, int i2, boolean z) {
        this.f4162a = constraintWidget;
        this.p = i2;
        this.q = z;
    }

    private void b() {
        int i2 = this.p * 2;
        ConstraintWidget constraintWidget = this.f4162a;
        boolean z = true;
        this.o = true;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z2 = false;
        while (!z2) {
            this.f4170i++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget.P0;
            int i3 = this.p;
            ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i3] = null;
            constraintWidget.O0[i3] = null;
            if (constraintWidget.l0() != 8) {
                this.f4173l++;
                ConstraintWidget.DimensionBehaviour z3 = constraintWidget.z(this.p);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (z3 != dimensionBehaviour) {
                    this.f4174m += constraintWidget.M(this.p);
                }
                int g2 = this.f4174m + constraintWidget.Y[i2].g();
                this.f4174m = g2;
                int i4 = i2 + 1;
                this.f4174m = g2 + constraintWidget.Y[i4].g();
                int g3 = this.f4175n + constraintWidget.Y[i2].g();
                this.f4175n = g3;
                this.f4175n = g3 + constraintWidget.Y[i4].g();
                if (this.f4163b == null) {
                    this.f4163b = constraintWidget;
                }
                this.f4165d = constraintWidget;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.b0;
                int i5 = this.p;
                if (dimensionBehaviourArr[i5] == dimensionBehaviour) {
                    int i6 = constraintWidget.y[i5];
                    if (i6 == 0 || i6 == 3 || i6 == 2) {
                        this.f4171j++;
                        float f2 = constraintWidget.N0[i5];
                        if (f2 > 0.0f) {
                            this.f4172k += f2;
                        }
                        if (k(constraintWidget, i5)) {
                            if (f2 < 0.0f) {
                                this.r = true;
                            } else {
                                this.s = true;
                            }
                            if (this.f4169h == null) {
                                this.f4169h = new ArrayList<>();
                            }
                            this.f4169h.add(constraintWidget);
                        }
                        if (this.f4167f == null) {
                            this.f4167f = constraintWidget;
                        }
                        ConstraintWidget constraintWidget4 = this.f4168g;
                        if (constraintWidget4 != null) {
                            constraintWidget4.O0[this.p] = constraintWidget;
                        }
                        this.f4168g = constraintWidget;
                    }
                    if (this.p != 0 ? !(constraintWidget.x == 0 && constraintWidget.C == 0 && constraintWidget.D == 0) : !(constraintWidget.w == 0 && constraintWidget.z == 0 && constraintWidget.A == 0)) {
                        this.o = false;
                    }
                    if (constraintWidget.f0 != 0.0f) {
                        this.o = false;
                        this.u = true;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.P0[this.p] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.Y[i2 + 1].f4183f;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.f4181d;
                ConstraintAnchor constraintAnchor2 = constraintWidget5.Y[i2].f4183f;
                if (constraintAnchor2 != null && constraintAnchor2.f4181d == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z2 = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        ConstraintWidget constraintWidget6 = this.f4163b;
        if (constraintWidget6 != null) {
            this.f4174m -= constraintWidget6.Y[i2].g();
        }
        ConstraintWidget constraintWidget7 = this.f4165d;
        if (constraintWidget7 != null) {
            this.f4174m -= constraintWidget7.Y[i2 + 1].g();
        }
        this.f4164c = constraintWidget;
        if (this.p != 0 || !this.q) {
            this.f4166e = this.f4162a;
        } else {
            this.f4166e = constraintWidget;
        }
        if (!this.s || !this.r) {
            z = false;
        }
        this.t = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r2 = r2.y[r3];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean k(androidx.constraintlayout.core.widgets.ConstraintWidget r2, int r3) {
        /*
            int r0 = r2.l0()
            r1 = 8
            if (r0 == r1) goto L_0x001b
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r2.b0
            r0 = r0[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x001b
            int[] r2 = r2.y
            r2 = r2[r3]
            if (r2 == 0) goto L_0x0019
            r3 = 3
            if (r2 != r3) goto L_0x001b
        L_0x0019:
            r2 = 1
            goto L_0x001c
        L_0x001b:
            r2 = 0
        L_0x001c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ChainHead.k(androidx.constraintlayout.core.widgets.ConstraintWidget, int):boolean");
    }

    public void a() {
        if (!this.v) {
            b();
        }
        this.v = true;
    }

    public ConstraintWidget c() {
        return this.f4162a;
    }

    public ConstraintWidget d() {
        return this.f4167f;
    }

    public ConstraintWidget e() {
        return this.f4163b;
    }

    public ConstraintWidget f() {
        return this.f4166e;
    }

    public ConstraintWidget g() {
        return this.f4164c;
    }

    public ConstraintWidget h() {
        return this.f4168g;
    }

    public ConstraintWidget i() {
        return this.f4165d;
    }

    public float j() {
        return this.f4172k;
    }
}
