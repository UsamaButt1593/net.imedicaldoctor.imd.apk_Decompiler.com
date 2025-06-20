package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

public class Flow extends VirtualLayout {
    public static final int o2 = 0;
    public static final int p2 = 1;
    public static final int q2 = 2;
    public static final int r2 = 0;
    public static final int s2 = 1;
    public static final int t2 = 2;
    public static final int u2 = 3;
    public static final int v2 = 0;
    public static final int w2 = 1;
    public static final int x2 = 2;
    public static final int y2 = 3;
    /* access modifiers changed from: private */
    public int P1 = -1;
    /* access modifiers changed from: private */
    public int Q1 = -1;
    /* access modifiers changed from: private */
    public int R1 = -1;
    /* access modifiers changed from: private */
    public int S1 = -1;
    /* access modifiers changed from: private */
    public int T1 = -1;
    /* access modifiers changed from: private */
    public int U1 = -1;
    /* access modifiers changed from: private */
    public float V1 = 0.5f;
    /* access modifiers changed from: private */
    public float W1 = 0.5f;
    /* access modifiers changed from: private */
    public float X1 = 0.5f;
    /* access modifiers changed from: private */
    public float Y1 = 0.5f;
    /* access modifiers changed from: private */
    public float Z1 = 0.5f;
    /* access modifiers changed from: private */
    public float a2 = 0.5f;
    /* access modifiers changed from: private */
    public int b2 = 0;
    /* access modifiers changed from: private */
    public int c2 = 0;
    /* access modifiers changed from: private */
    public int d2 = 2;
    /* access modifiers changed from: private */
    public int e2 = 2;
    private int f2 = 0;
    private int g2 = -1;
    private int h2 = 0;
    private ArrayList<WidgetsList> i2 = new ArrayList<>();
    private ConstraintWidget[] j2 = null;
    private ConstraintWidget[] k2 = null;
    private int[] l2 = null;
    /* access modifiers changed from: private */
    public ConstraintWidget[] m2;
    /* access modifiers changed from: private */
    public int n2 = 0;

    private class WidgetsList {

        /* renamed from: a  reason: collision with root package name */
        private int f4204a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public ConstraintWidget f4205b = null;

        /* renamed from: c  reason: collision with root package name */
        int f4206c = 0;

        /* renamed from: d  reason: collision with root package name */
        private ConstraintAnchor f4207d;

        /* renamed from: e  reason: collision with root package name */
        private ConstraintAnchor f4208e;

        /* renamed from: f  reason: collision with root package name */
        private ConstraintAnchor f4209f;

        /* renamed from: g  reason: collision with root package name */
        private ConstraintAnchor f4210g;

        /* renamed from: h  reason: collision with root package name */
        private int f4211h = 0;

        /* renamed from: i  reason: collision with root package name */
        private int f4212i = 0;

        /* renamed from: j  reason: collision with root package name */
        private int f4213j = 0;

        /* renamed from: k  reason: collision with root package name */
        private int f4214k = 0;

        /* renamed from: l  reason: collision with root package name */
        private int f4215l = 0;

        /* renamed from: m  reason: collision with root package name */
        private int f4216m = 0;

        /* renamed from: n  reason: collision with root package name */
        private int f4217n = 0;
        private int o = 0;
        private int p = 0;
        private int q = 0;

        public WidgetsList(int i2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i3) {
            this.f4204a = i2;
            this.f4207d = constraintAnchor;
            this.f4208e = constraintAnchor2;
            this.f4209f = constraintAnchor3;
            this.f4210g = constraintAnchor4;
            this.f4211h = Flow.this.s2();
            this.f4212i = Flow.this.u2();
            this.f4213j = Flow.this.t2();
            this.f4214k = Flow.this.r2();
            this.q = i3;
        }

        private void h() {
            this.f4215l = 0;
            this.f4216m = 0;
            this.f4205b = null;
            this.f4206c = 0;
            int i2 = this.o;
            int i3 = 0;
            while (i3 < i2 && this.f4217n + i3 < Flow.this.n2) {
                ConstraintWidget constraintWidget = Flow.this.m2[this.f4217n + i3];
                if (this.f4204a == 0) {
                    int m0 = constraintWidget.m0();
                    int I2 = Flow.this.b2;
                    if (constraintWidget.l0() == 8) {
                        I2 = 0;
                    }
                    this.f4215l += m0 + I2;
                    int V2 = Flow.this.e3(constraintWidget, this.q);
                    if (this.f4205b == null || this.f4206c < V2) {
                        this.f4205b = constraintWidget;
                        this.f4206c = V2;
                        this.f4216m = V2;
                    }
                } else {
                    int U2 = Flow.this.f3(constraintWidget, this.q);
                    int V22 = Flow.this.e3(constraintWidget, this.q);
                    int J2 = Flow.this.c2;
                    if (constraintWidget.l0() == 8) {
                        J2 = 0;
                    }
                    this.f4216m += V22 + J2;
                    if (this.f4205b == null || this.f4206c < U2) {
                        this.f4205b = constraintWidget;
                        this.f4206c = U2;
                        this.f4215l = U2;
                    }
                }
                i3++;
            }
        }

        public void b(ConstraintWidget constraintWidget) {
            int i2 = 0;
            if (this.f4204a == 0) {
                int U2 = Flow.this.f3(constraintWidget, this.q);
                if (constraintWidget.H() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.p++;
                    U2 = 0;
                }
                int I2 = Flow.this.b2;
                if (constraintWidget.l0() != 8) {
                    i2 = I2;
                }
                this.f4215l += U2 + i2;
                int V2 = Flow.this.e3(constraintWidget, this.q);
                if (this.f4205b == null || this.f4206c < V2) {
                    this.f4205b = constraintWidget;
                    this.f4206c = V2;
                    this.f4216m = V2;
                }
            } else {
                int U22 = Flow.this.f3(constraintWidget, this.q);
                int V22 = Flow.this.e3(constraintWidget, this.q);
                if (constraintWidget.j0() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.p++;
                    V22 = 0;
                }
                int J2 = Flow.this.c2;
                if (constraintWidget.l0() != 8) {
                    i2 = J2;
                }
                this.f4216m += V22 + i2;
                if (this.f4205b == null || this.f4206c < U22) {
                    this.f4205b = constraintWidget;
                    this.f4206c = U22;
                    this.f4215l = U22;
                }
            }
            this.o++;
        }

        public void c() {
            this.f4206c = 0;
            this.f4205b = null;
            this.f4215l = 0;
            this.f4216m = 0;
            this.f4217n = 0;
            this.o = 0;
            this.p = 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:140:0x0262  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x00e1  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void d(boolean r17, int r18, boolean r19) {
            /*
                r16 = this;
                r0 = r16
                int r1 = r0.o
                r2 = 0
                r3 = 0
            L_0x0006:
                if (r3 >= r1) goto L_0x0027
                int r4 = r0.f4217n
                int r4 = r4 + r3
                androidx.constraintlayout.core.widgets.Flow r5 = androidx.constraintlayout.core.widgets.Flow.this
                int r5 = r5.n2
                if (r4 < r5) goto L_0x0014
                goto L_0x0027
            L_0x0014:
                androidx.constraintlayout.core.widgets.Flow r4 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r4 = r4.m2
                int r5 = r0.f4217n
                int r5 = r5 + r3
                r4 = r4[r5]
                if (r4 == 0) goto L_0x0024
                r4.U0()
            L_0x0024:
                int r3 = r3 + 1
                goto L_0x0006
            L_0x0027:
                if (r1 == 0) goto L_0x0353
                androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f4205b
                if (r3 != 0) goto L_0x002f
                goto L_0x0353
            L_0x002f:
                if (r19 == 0) goto L_0x0035
                if (r18 != 0) goto L_0x0035
                r4 = 1
                goto L_0x0036
            L_0x0035:
                r4 = 0
            L_0x0036:
                r5 = -1
                r6 = 0
                r7 = -1
                r8 = -1
            L_0x003a:
                if (r6 >= r1) goto L_0x0069
                if (r17 == 0) goto L_0x0042
                int r9 = r1 + -1
                int r9 = r9 - r6
                goto L_0x0043
            L_0x0042:
                r9 = r6
            L_0x0043:
                int r10 = r0.f4217n
                int r10 = r10 + r9
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.n2
                if (r10 < r11) goto L_0x004f
                goto L_0x0069
            L_0x004f:
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r10 = r10.m2
                int r11 = r0.f4217n
                int r11 = r11 + r9
                r9 = r10[r11]
                if (r9 == 0) goto L_0x0066
                int r9 = r9.l0()
                if (r9 != 0) goto L_0x0066
                if (r7 != r5) goto L_0x0065
                r7 = r6
            L_0x0065:
                r8 = r6
            L_0x0066:
                int r6 = r6 + 1
                goto L_0x003a
            L_0x0069:
                int r6 = r0.f4204a
                r9 = 0
                if (r6 != 0) goto L_0x01fd
                androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r0.f4205b
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                int r10 = r10.Q1
                r6.W1(r10)
                int r10 = r0.f4212i
                if (r18 <= 0) goto L_0x0084
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.c2
                int r10 = r10 + r11
            L_0x0084:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.f4208e
                r11.a(r12, r10)
                if (r19 == 0) goto L_0x0096
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r6.T
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f4210g
                int r12 = r0.f4214k
                r10.a(r11, r12)
            L_0x0096:
                if (r18 <= 0) goto L_0x00a3
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.f4208e
                androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r10.f4181d
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r10.T
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.R
                r10.a(r11, r2)
            L_0x00a3:
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                int r10 = r10.e2
                r11 = 3
                if (r10 != r11) goto L_0x00dd
                boolean r10 = r6.q0()
                if (r10 != 0) goto L_0x00dd
                r10 = 0
            L_0x00b3:
                if (r10 >= r1) goto L_0x00dd
                if (r17 == 0) goto L_0x00bb
                int r12 = r1 + -1
                int r12 = r12 - r10
                goto L_0x00bc
            L_0x00bb:
                r12 = r10
            L_0x00bc:
                int r13 = r0.f4217n
                int r13 = r13 + r12
                androidx.constraintlayout.core.widgets.Flow r14 = androidx.constraintlayout.core.widgets.Flow.this
                int r14 = r14.n2
                if (r13 < r14) goto L_0x00c8
                goto L_0x00dd
            L_0x00c8:
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r13 = r13.m2
                int r14 = r0.f4217n
                int r14 = r14 + r12
                r12 = r13[r14]
                boolean r13 = r12.q0()
                if (r13 == 0) goto L_0x00da
                goto L_0x00de
            L_0x00da:
                int r10 = r10 + 1
                goto L_0x00b3
            L_0x00dd:
                r12 = r6
            L_0x00de:
                r10 = 0
            L_0x00df:
                if (r10 >= r1) goto L_0x0353
                if (r17 == 0) goto L_0x00e7
                int r13 = r1 + -1
                int r13 = r13 - r10
                goto L_0x00e8
            L_0x00e7:
                r13 = r10
            L_0x00e8:
                int r14 = r0.f4217n
                int r14 = r14 + r13
                androidx.constraintlayout.core.widgets.Flow r15 = androidx.constraintlayout.core.widgets.Flow.this
                int r15 = r15.n2
                if (r14 < r15) goto L_0x00f5
                goto L_0x0353
            L_0x00f5:
                androidx.constraintlayout.core.widgets.Flow r14 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r14 = r14.m2
                int r15 = r0.f4217n
                int r15 = r15 + r13
                r14 = r14[r15]
                if (r14 != 0) goto L_0x0106
                r14 = r9
            L_0x0103:
                r9 = 3
                goto L_0x01f7
            L_0x0106:
                if (r10 != 0) goto L_0x0111
                androidx.constraintlayout.core.widgets.ConstraintAnchor r15 = r14.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f4207d
                int r3 = r0.f4211h
                r14.l(r15, r11, r3)
            L_0x0111:
                if (r13 != 0) goto L_0x016f
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.P1
                r11 = 1065353216(0x3f800000, float:1.0)
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                float r13 = r13.V1
                if (r17 == 0) goto L_0x0125
                float r13 = r11 - r13
            L_0x0125:
                int r15 = r0.f4217n
                if (r15 != 0) goto L_0x0149
                androidx.constraintlayout.core.widgets.Flow r15 = androidx.constraintlayout.core.widgets.Flow.this
                int r15 = r15.R1
                if (r15 == r5) goto L_0x0149
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.R1
                if (r17 == 0) goto L_0x0142
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                float r13 = r13.X1
            L_0x013f:
                float r11 = r11 - r13
            L_0x0140:
                r13 = r11
                goto L_0x0169
            L_0x0142:
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                float r11 = r11.X1
                goto L_0x0140
            L_0x0149:
                if (r19 == 0) goto L_0x0169
                androidx.constraintlayout.core.widgets.Flow r15 = androidx.constraintlayout.core.widgets.Flow.this
                int r15 = r15.T1
                if (r15 == r5) goto L_0x0169
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.T1
                if (r17 == 0) goto L_0x0162
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                float r13 = r13.Z1
                goto L_0x013f
            L_0x0162:
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                float r11 = r11.Z1
                goto L_0x0140
            L_0x0169:
                r14.B1(r3)
                r14.A1(r13)
            L_0x016f:
                int r3 = r1 + -1
                if (r10 != r3) goto L_0x017c
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f4209f
                int r13 = r0.f4213j
                r14.l(r3, r11, r13)
            L_0x017c:
                if (r9 == 0) goto L_0x01a7
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r9.S
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                int r13 = r13.b2
                r3.a(r11, r13)
                if (r10 != r7) goto L_0x0194
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.Q
                int r11 = r0.f4211h
                r3.B(r11)
            L_0x0194:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r9.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r14.Q
                r3.a(r11, r2)
                r3 = 1
                int r11 = r8 + 1
                if (r10 != r11) goto L_0x01a7
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r9.S
                int r9 = r0.f4213j
                r3.B(r9)
            L_0x01a7:
                if (r14 == r6) goto L_0x0103
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.e2
                r9 = 3
                if (r3 != r9) goto L_0x01c8
                boolean r3 = r12.q0()
                if (r3 == 0) goto L_0x01c8
                if (r14 == r12) goto L_0x01c8
                boolean r3 = r14.q0()
                if (r3 == 0) goto L_0x01c8
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.U
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r12.U
            L_0x01c4:
                r3.a(r11, r2)
                goto L_0x01f7
            L_0x01c8:
                androidx.constraintlayout.core.widgets.Flow r3 = androidx.constraintlayout.core.widgets.Flow.this
                int r3 = r3.e2
                if (r3 == 0) goto L_0x01f2
                r11 = 1
                if (r3 == r11) goto L_0x01ed
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.R
                if (r4 == 0) goto L_0x01e8
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f4208e
                int r13 = r0.f4212i
                r3.a(r11, r13)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.T
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f4210g
                int r13 = r0.f4214k
                r3.a(r11, r13)
                goto L_0x01f7
            L_0x01e8:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.R
                r3.a(r11, r2)
            L_0x01ed:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.T
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.T
                goto L_0x01c4
            L_0x01f2:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.R
                goto L_0x01c4
            L_0x01f7:
                int r10 = r10 + 1
                r9 = r14
                r11 = 3
                goto L_0x00df
            L_0x01fd:
                androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f4205b
                androidx.constraintlayout.core.widgets.Flow r6 = androidx.constraintlayout.core.widgets.Flow.this
                int r6 = r6.P1
                r3.B1(r6)
                int r6 = r0.f4211h
                if (r18 <= 0) goto L_0x0213
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                int r10 = r10.b2
                int r6 = r6 + r10
            L_0x0213:
                if (r17 == 0) goto L_0x0235
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f4209f
                r10.a(r11, r6)
                if (r19 == 0) goto L_0x0227
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.f4207d
                int r11 = r0.f4213j
                r6.a(r10, r11)
            L_0x0227:
                if (r18 <= 0) goto L_0x0252
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r0.f4209f
                androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r6.f4181d
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r6.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.S
            L_0x0231:
                r6.a(r10, r2)
                goto L_0x0252
            L_0x0235:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f4207d
                r10.a(r11, r6)
                if (r19 == 0) goto L_0x0247
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.f4209f
                int r11 = r0.f4213j
                r6.a(r10, r11)
            L_0x0247:
                if (r18 <= 0) goto L_0x0252
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r0.f4207d
                androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r6.f4181d
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r6.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.Q
                goto L_0x0231
            L_0x0252:
                r6 = 0
            L_0x0253:
                if (r6 >= r1) goto L_0x0353
                int r10 = r0.f4217n
                int r10 = r10 + r6
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.n2
                if (r10 < r11) goto L_0x0262
                goto L_0x0353
            L_0x0262:
                androidx.constraintlayout.core.widgets.Flow r10 = androidx.constraintlayout.core.widgets.Flow.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r10 = r10.m2
                int r11 = r0.f4217n
                int r11 = r11 + r6
                r10 = r10[r11]
                if (r10 != 0) goto L_0x0272
                r12 = 1
                goto L_0x034f
            L_0x0272:
                if (r6 != 0) goto L_0x02be
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.f4208e
                int r13 = r0.f4212i
                r10.l(r11, r12, r13)
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.Q1
                androidx.constraintlayout.core.widgets.Flow r12 = androidx.constraintlayout.core.widgets.Flow.this
                float r12 = r12.W1
                int r13 = r0.f4217n
                if (r13 != 0) goto L_0x02a2
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                int r13 = r13.S1
                if (r13 == r5) goto L_0x02a2
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.S1
                androidx.constraintlayout.core.widgets.Flow r12 = androidx.constraintlayout.core.widgets.Flow.this
                float r12 = r12.Y1
                goto L_0x02b8
            L_0x02a2:
                if (r19 == 0) goto L_0x02b8
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                int r13 = r13.U1
                if (r13 == r5) goto L_0x02b8
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.U1
                androidx.constraintlayout.core.widgets.Flow r12 = androidx.constraintlayout.core.widgets.Flow.this
                float r12 = r12.a2
            L_0x02b8:
                r10.W1(r11)
                r10.V1(r12)
            L_0x02be:
                int r11 = r1 + -1
                if (r6 != r11) goto L_0x02cb
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.T
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.f4210g
                int r13 = r0.f4214k
                r10.l(r11, r12, r13)
            L_0x02cb:
                if (r9 == 0) goto L_0x02f6
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r9.T
                androidx.constraintlayout.core.widgets.Flow r13 = androidx.constraintlayout.core.widgets.Flow.this
                int r13 = r13.c2
                r11.a(r12, r13)
                if (r6 != r7) goto L_0x02e3
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.R
                int r12 = r0.f4212i
                r11.B(r12)
            L_0x02e3:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r9.T
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r10.R
                r11.a(r12, r2)
                r11 = 1
                int r12 = r8 + 1
                if (r6 != r12) goto L_0x02f6
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.T
                int r11 = r0.f4214k
                r9.B(r11)
            L_0x02f6:
                if (r10 == r3) goto L_0x031d
                r9 = 2
                androidx.constraintlayout.core.widgets.Flow r11 = androidx.constraintlayout.core.widgets.Flow.this
                int r11 = r11.d2
                if (r17 == 0) goto L_0x031f
                if (r11 == 0) goto L_0x0310
                r12 = 1
                if (r11 == r12) goto L_0x0318
                if (r11 == r9) goto L_0x0309
                goto L_0x031d
            L_0x0309:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.Q
                r9.a(r11, r2)
            L_0x0310:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.S
            L_0x0314:
                r9.a(r11, r2)
                goto L_0x031d
            L_0x0318:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.Q
                goto L_0x0314
            L_0x031d:
                r12 = 1
                goto L_0x034e
            L_0x031f:
                r12 = 1
                if (r11 == 0) goto L_0x0349
                if (r11 == r12) goto L_0x0341
                if (r11 == r9) goto L_0x0327
                goto L_0x034e
            L_0x0327:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.Q
                if (r4 == 0) goto L_0x033c
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f4207d
                int r13 = r0.f4211h
                r9.a(r11, r13)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f4209f
                int r13 = r0.f4213j
                r9.a(r11, r13)
                goto L_0x034e
            L_0x033c:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.Q
                r9.a(r11, r2)
            L_0x0341:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.S
            L_0x0345:
                r9.a(r11, r2)
                goto L_0x034e
            L_0x0349:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r10.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.Q
                goto L_0x0345
            L_0x034e:
                r9 = r10
            L_0x034f:
                int r6 = r6 + 1
                goto L_0x0253
            L_0x0353:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.WidgetsList.d(boolean, int, boolean):void");
        }

        public int e() {
            return this.f4204a == 1 ? this.f4216m - Flow.this.c2 : this.f4216m;
        }

        public int f() {
            return this.f4204a == 0 ? this.f4215l - Flow.this.b2 : this.f4215l;
        }

        public void g(int i2) {
            Flow flow;
            ConstraintWidget.DimensionBehaviour H;
            int m0;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour;
            int i3;
            int i4 = this.p;
            if (i4 != 0) {
                int i5 = this.o;
                int i6 = i2 / i4;
                int i7 = 0;
                while (i7 < i5 && this.f4217n + i7 < Flow.this.n2) {
                    ConstraintWidget constraintWidget = Flow.this.m2[this.f4217n + i7];
                    if (this.f4204a == 0) {
                        if (constraintWidget != null && constraintWidget.H() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.w == 0) {
                            flow = Flow.this;
                            H = ConstraintWidget.DimensionBehaviour.FIXED;
                            dimensionBehaviour = constraintWidget.j0();
                            i3 = constraintWidget.D();
                            m0 = i6;
                        }
                        i7++;
                    } else {
                        if (constraintWidget != null && constraintWidget.j0() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.x == 0) {
                            flow = Flow.this;
                            H = constraintWidget.H();
                            m0 = constraintWidget.m0();
                            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
                            i3 = i6;
                        }
                        i7++;
                    }
                    flow.w2(constraintWidget, H, m0, dimensionBehaviour, i3);
                    i7++;
                }
                h();
            }
        }

        public void i(int i2) {
            this.f4217n = i2;
        }

        public void j(int i2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i3, int i4, int i5, int i6, int i7) {
            this.f4204a = i2;
            this.f4207d = constraintAnchor;
            this.f4208e = constraintAnchor2;
            this.f4209f = constraintAnchor3;
            this.f4210g = constraintAnchor4;
            this.f4211h = i3;
            this.f4212i = i4;
            this.f4213j = i5;
            this.f4214k = i6;
            this.q = i7;
        }
    }

    private void c3(boolean z) {
        ConstraintWidget constraintWidget;
        float f3;
        int i3;
        if (this.l2 != null && this.k2 != null && this.j2 != null) {
            for (int i4 = 0; i4 < this.n2; i4++) {
                this.m2[i4].U0();
            }
            int[] iArr = this.l2;
            int i5 = iArr[0];
            int i6 = iArr[1];
            float f4 = this.V1;
            ConstraintWidget constraintWidget2 = null;
            int i7 = 0;
            while (i7 < i5) {
                if (z) {
                    i3 = (i5 - i7) - 1;
                    f3 = 1.0f - this.V1;
                } else {
                    f3 = f4;
                    i3 = i7;
                }
                ConstraintWidget constraintWidget3 = this.k2[i3];
                if (!(constraintWidget3 == null || constraintWidget3.l0() == 8)) {
                    if (i7 == 0) {
                        constraintWidget3.l(constraintWidget3.Q, this.Q, s2());
                        constraintWidget3.B1(this.P1);
                        constraintWidget3.A1(f3);
                    }
                    if (i7 == i5 - 1) {
                        constraintWidget3.l(constraintWidget3.S, this.S, t2());
                    }
                    if (i7 > 0 && constraintWidget2 != null) {
                        constraintWidget3.l(constraintWidget3.Q, constraintWidget2.S, this.b2);
                        constraintWidget2.l(constraintWidget2.S, constraintWidget3.Q, 0);
                    }
                    constraintWidget2 = constraintWidget3;
                }
                i7++;
                f4 = f3;
            }
            for (int i8 = 0; i8 < i6; i8++) {
                ConstraintWidget constraintWidget4 = this.j2[i8];
                if (!(constraintWidget4 == null || constraintWidget4.l0() == 8)) {
                    if (i8 == 0) {
                        constraintWidget4.l(constraintWidget4.R, this.R, u2());
                        constraintWidget4.W1(this.Q1);
                        constraintWidget4.V1(this.W1);
                    }
                    if (i8 == i6 - 1) {
                        constraintWidget4.l(constraintWidget4.T, this.T, r2());
                    }
                    if (i8 > 0 && constraintWidget2 != null) {
                        constraintWidget4.l(constraintWidget4.R, constraintWidget2.T, this.c2);
                        constraintWidget2.l(constraintWidget2.T, constraintWidget4.R, 0);
                    }
                    constraintWidget2 = constraintWidget4;
                }
            }
            for (int i9 = 0; i9 < i5; i9++) {
                for (int i10 = 0; i10 < i6; i10++) {
                    int i11 = (i10 * i5) + i9;
                    if (this.h2 == 1) {
                        i11 = (i9 * i6) + i10;
                    }
                    ConstraintWidget[] constraintWidgetArr = this.m2;
                    if (!(i11 >= constraintWidgetArr.length || (constraintWidget = constraintWidgetArr[i11]) == null || constraintWidget.l0() == 8)) {
                        ConstraintWidget constraintWidget5 = this.k2[i9];
                        ConstraintWidget constraintWidget6 = this.j2[i10];
                        if (constraintWidget != constraintWidget5) {
                            constraintWidget.l(constraintWidget.Q, constraintWidget5.Q, 0);
                            constraintWidget.l(constraintWidget.S, constraintWidget5.S, 0);
                        }
                        if (constraintWidget != constraintWidget6) {
                            constraintWidget.l(constraintWidget.R, constraintWidget6.R, 0);
                            constraintWidget.l(constraintWidget.T, constraintWidget6.T, 0);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final int e3(ConstraintWidget constraintWidget, int i3) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.j0() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i4 = constraintWidget.x;
            if (i4 == 0) {
                return 0;
            }
            if (i4 == 2) {
                int i5 = (int) (constraintWidget.E * ((float) i3));
                if (i5 != constraintWidget.D()) {
                    constraintWidget.N1(true);
                    w2(constraintWidget, constraintWidget.H(), constraintWidget.m0(), ConstraintWidget.DimensionBehaviour.FIXED, i5);
                }
                return i5;
            } else if (i4 == 1) {
                return constraintWidget.D();
            } else {
                if (i4 == 3) {
                    return (int) ((((float) constraintWidget.m0()) * constraintWidget.f0) + 0.5f);
                }
            }
        }
        return constraintWidget.D();
    }

    /* access modifiers changed from: private */
    public final int f3(ConstraintWidget constraintWidget, int i3) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.H() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i4 = constraintWidget.w;
            if (i4 == 0) {
                return 0;
            }
            if (i4 == 2) {
                int i5 = (int) (constraintWidget.B * ((float) i3));
                if (i5 != constraintWidget.m0()) {
                    constraintWidget.N1(true);
                    w2(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i5, constraintWidget.j0(), constraintWidget.D());
                }
                return i5;
            } else if (i4 == 1) {
                return constraintWidget.m0();
            } else {
                if (i4 == 3) {
                    return (int) ((((float) constraintWidget.D()) * constraintWidget.f0) + 0.5f);
                }
            }
        }
        return constraintWidget.m0();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x011b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005c  */
    private void g3(androidx.constraintlayout.core.widgets.ConstraintWidget[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            r10 = this;
            r0 = 0
            int r1 = r10.g2
            if (r13 != 0) goto L_0x0026
            if (r1 > 0) goto L_0x0023
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x000a:
            if (r2 >= r12) goto L_0x0023
            if (r2 <= 0) goto L_0x0011
            int r4 = r10.b2
            int r3 = r3 + r4
        L_0x0011:
            r4 = r11[r2]
            if (r4 != 0) goto L_0x0016
            goto L_0x0020
        L_0x0016:
            int r4 = r10.f3(r4, r14)
            int r3 = r3 + r4
            if (r3 <= r14) goto L_0x001e
            goto L_0x0023
        L_0x001e:
            int r1 = r1 + 1
        L_0x0020:
            int r2 = r2 + 1
            goto L_0x000a
        L_0x0023:
            r2 = r1
            r1 = 0
            goto L_0x0045
        L_0x0026:
            if (r1 > 0) goto L_0x0044
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x002b:
            if (r2 >= r12) goto L_0x0044
            if (r2 <= 0) goto L_0x0032
            int r4 = r10.c2
            int r3 = r3 + r4
        L_0x0032:
            r4 = r11[r2]
            if (r4 != 0) goto L_0x0037
            goto L_0x0041
        L_0x0037:
            int r4 = r10.e3(r4, r14)
            int r3 = r3 + r4
            if (r3 <= r14) goto L_0x003f
            goto L_0x0044
        L_0x003f:
            int r1 = r1 + 1
        L_0x0041:
            int r2 = r2 + 1
            goto L_0x002b
        L_0x0044:
            r2 = 0
        L_0x0045:
            int[] r3 = r10.l2
            if (r3 != 0) goto L_0x004e
            r3 = 2
            int[] r3 = new int[r3]
            r10.l2 = r3
        L_0x004e:
            r3 = 1
            if (r1 != 0) goto L_0x0053
            if (r13 == r3) goto L_0x0057
        L_0x0053:
            if (r2 != 0) goto L_0x0059
            if (r13 != 0) goto L_0x0059
        L_0x0057:
            r4 = 1
            goto L_0x005a
        L_0x0059:
            r4 = 0
        L_0x005a:
            if (r4 != 0) goto L_0x011b
            if (r13 != 0) goto L_0x0068
            float r1 = (float) r12
            float r5 = (float) r2
            float r1 = r1 / r5
            double r5 = (double) r1
            double r5 = java.lang.Math.ceil(r5)
            int r1 = (int) r5
            goto L_0x0071
        L_0x0068:
            float r2 = (float) r12
            float r5 = (float) r1
            float r2 = r2 / r5
            double r5 = (double) r2
            double r5 = java.lang.Math.ceil(r5)
            int r2 = (int) r5
        L_0x0071:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r5 = r10.k2
            r6 = 0
            if (r5 == 0) goto L_0x007e
            int r7 = r5.length
            if (r7 >= r2) goto L_0x007a
            goto L_0x007e
        L_0x007a:
            java.util.Arrays.fill(r5, r6)
            goto L_0x0082
        L_0x007e:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r5 = new androidx.constraintlayout.core.widgets.ConstraintWidget[r2]
            r10.k2 = r5
        L_0x0082:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r5 = r10.j2
            if (r5 == 0) goto L_0x008e
            int r7 = r5.length
            if (r7 >= r1) goto L_0x008a
            goto L_0x008e
        L_0x008a:
            java.util.Arrays.fill(r5, r6)
            goto L_0x0092
        L_0x008e:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r5 = new androidx.constraintlayout.core.widgets.ConstraintWidget[r1]
            r10.j2 = r5
        L_0x0092:
            r5 = 0
        L_0x0093:
            if (r5 >= r2) goto L_0x00d7
            r6 = 0
        L_0x0096:
            if (r6 >= r1) goto L_0x00d4
            int r7 = r6 * r2
            int r7 = r7 + r5
            if (r13 != r3) goto L_0x00a0
            int r7 = r5 * r1
            int r7 = r7 + r6
        L_0x00a0:
            int r8 = r11.length
            if (r7 < r8) goto L_0x00a4
            goto L_0x00d1
        L_0x00a4:
            r7 = r11[r7]
            if (r7 != 0) goto L_0x00a9
            goto L_0x00d1
        L_0x00a9:
            int r8 = r10.f3(r7, r14)
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r9 = r10.k2
            r9 = r9[r5]
            if (r9 == 0) goto L_0x00b9
            int r9 = r9.m0()
            if (r9 >= r8) goto L_0x00bd
        L_0x00b9:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r8 = r10.k2
            r8[r5] = r7
        L_0x00bd:
            int r8 = r10.e3(r7, r14)
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r9 = r10.j2
            r9 = r9[r6]
            if (r9 == 0) goto L_0x00cd
            int r9 = r9.D()
            if (r9 >= r8) goto L_0x00d1
        L_0x00cd:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r8 = r10.j2
            r8[r6] = r7
        L_0x00d1:
            int r6 = r6 + 1
            goto L_0x0096
        L_0x00d4:
            int r5 = r5 + 1
            goto L_0x0093
        L_0x00d7:
            r5 = 0
            r6 = 0
        L_0x00d9:
            if (r5 >= r2) goto L_0x00ee
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r7 = r10.k2
            r7 = r7[r5]
            if (r7 == 0) goto L_0x00eb
            if (r5 <= 0) goto L_0x00e6
            int r8 = r10.b2
            int r6 = r6 + r8
        L_0x00e6:
            int r7 = r10.f3(r7, r14)
            int r6 = r6 + r7
        L_0x00eb:
            int r5 = r5 + 1
            goto L_0x00d9
        L_0x00ee:
            r5 = 0
            r7 = 0
        L_0x00f0:
            if (r5 >= r1) goto L_0x0105
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r8 = r10.j2
            r8 = r8[r5]
            if (r8 == 0) goto L_0x0102
            if (r5 <= 0) goto L_0x00fd
            int r9 = r10.c2
            int r7 = r7 + r9
        L_0x00fd:
            int r8 = r10.e3(r8, r14)
            int r7 = r7 + r8
        L_0x0102:
            int r5 = r5 + 1
            goto L_0x00f0
        L_0x0105:
            r15[r0] = r6
            r15[r3] = r7
            if (r13 != 0) goto L_0x0113
            if (r6 <= r14) goto L_0x0057
            if (r2 <= r3) goto L_0x0057
            int r2 = r2 + -1
            goto L_0x005a
        L_0x0113:
            if (r7 <= r14) goto L_0x0057
            if (r1 <= r3) goto L_0x0057
            int r1 = r1 + -1
            goto L_0x005a
        L_0x011b:
            int[] r11 = r10.l2
            r11[r0] = r2
            r11[r3] = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.g3(androidx.constraintlayout.core.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    private void h3(ConstraintWidget[] constraintWidgetArr, int i3, int i4, int i5, int[] iArr) {
        ConstraintAnchor constraintAnchor;
        int i6;
        int i7;
        int i8;
        ConstraintAnchor constraintAnchor2;
        int i9;
        int i10;
        int i11;
        int i12 = i3;
        int i13 = i5;
        if (i12 != 0) {
            this.i2.clear();
            WidgetsList widgetsList = new WidgetsList(i4, this.Q, this.R, this.S, this.T, i5);
            this.i2.add(widgetsList);
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            if (i4 == 0) {
                while (i16 < i12) {
                    ConstraintWidget constraintWidget = constraintWidgetArr[i16];
                    int f3 = f3(constraintWidget, i13);
                    if (constraintWidget.H() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i14++;
                    }
                    int i17 = i14;
                    boolean z = (i15 == i13 || (this.b2 + i15) + f3 > i13) && widgetsList.f4205b != null;
                    if (!z && i16 > 0 && (i11 = this.g2) > 0 && i16 % i11 == 0) {
                        z = true;
                    }
                    if (z) {
                        widgetsList = new WidgetsList(i4, this.Q, this.R, this.S, this.T, i5);
                        widgetsList.i(i16);
                        this.i2.add(widgetsList);
                    } else if (i16 > 0) {
                        i15 += this.b2 + f3;
                        widgetsList.b(constraintWidget);
                        i16++;
                        i14 = i17;
                    }
                    i15 = f3;
                    widgetsList.b(constraintWidget);
                    i16++;
                    i14 = i17;
                }
            } else {
                while (i16 < i12) {
                    ConstraintWidget constraintWidget2 = constraintWidgetArr[i16];
                    int e3 = e3(constraintWidget2, i13);
                    if (constraintWidget2.j0() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i14++;
                    }
                    int i18 = i14;
                    boolean z2 = (i15 == i13 || (this.c2 + i15) + e3 > i13) && widgetsList.f4205b != null;
                    if (!z2 && i16 > 0 && (i10 = this.g2) > 0 && i16 % i10 == 0) {
                        z2 = true;
                    }
                    if (z2) {
                        widgetsList = new WidgetsList(i4, this.Q, this.R, this.S, this.T, i5);
                        widgetsList.i(i16);
                        this.i2.add(widgetsList);
                    } else if (i16 > 0) {
                        i9 = i15 + this.c2 + e3;
                        widgetsList.b(constraintWidget2);
                        i16++;
                        i14 = i18;
                    }
                    i9 = e3;
                    widgetsList.b(constraintWidget2);
                    i16++;
                    i14 = i18;
                }
            }
            int size = this.i2.size();
            ConstraintAnchor constraintAnchor3 = this.Q;
            ConstraintAnchor constraintAnchor4 = this.R;
            ConstraintAnchor constraintAnchor5 = this.S;
            ConstraintAnchor constraintAnchor6 = this.T;
            int s22 = s2();
            int u22 = u2();
            int t22 = t2();
            int r22 = r2();
            ConstraintWidget.DimensionBehaviour H = H();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z3 = H == dimensionBehaviour || j0() == dimensionBehaviour;
            if (i14 > 0 && z3) {
                for (int i19 = 0; i19 < size; i19++) {
                    WidgetsList widgetsList2 = this.i2.get(i19);
                    widgetsList2.g(i13 - (i4 == 0 ? widgetsList2.f() : widgetsList2.e()));
                }
            }
            int i20 = u22;
            int i21 = t22;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = s22;
            ConstraintAnchor constraintAnchor7 = constraintAnchor4;
            ConstraintAnchor constraintAnchor8 = constraintAnchor3;
            int i26 = r22;
            while (i24 < size) {
                WidgetsList widgetsList3 = this.i2.get(i24);
                if (i4 == 0) {
                    if (i24 < size - 1) {
                        constraintAnchor2 = this.i2.get(i24 + 1).f4205b.R;
                        i8 = 0;
                    } else {
                        constraintAnchor2 = this.T;
                        i8 = r2();
                    }
                    ConstraintAnchor constraintAnchor9 = widgetsList3.f4205b.T;
                    ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                    ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                    int i27 = i22;
                    ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                    int i28 = i23;
                    ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                    ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                    i6 = i24;
                    widgetsList3.j(i4, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i25, i20, i21, i8, i5);
                    int max = Math.max(i28, widgetsList3.f());
                    i22 = i27 + widgetsList3.e();
                    if (i6 > 0) {
                        i22 += this.c2;
                    }
                    constraintAnchor8 = constraintAnchor11;
                    i23 = max;
                    constraintAnchor7 = constraintAnchor9;
                    i20 = 0;
                    constraintAnchor = constraintAnchor14;
                    int i29 = i8;
                    constraintAnchor6 = constraintAnchor2;
                    i26 = i29;
                } else {
                    ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                    int i30 = i22;
                    int i31 = i23;
                    i6 = i24;
                    if (i6 < size - 1) {
                        constraintAnchor = this.i2.get(i6 + 1).f4205b.Q;
                        i7 = 0;
                    } else {
                        constraintAnchor = this.S;
                        i7 = t2();
                    }
                    ConstraintAnchor constraintAnchor16 = widgetsList3.f4205b.S;
                    widgetsList3.j(i4, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i25, i20, i7, i26, i5);
                    i23 = i31 + widgetsList3.f();
                    int max2 = Math.max(i30, widgetsList3.e());
                    if (i6 > 0) {
                        i23 += this.b2;
                    }
                    i22 = max2;
                    i21 = i7;
                    constraintAnchor8 = constraintAnchor16;
                    i25 = 0;
                }
                i24 = i6 + 1;
                int i32 = i5;
                constraintAnchor5 = constraintAnchor;
            }
            iArr[0] = i23;
            iArr[1] = i22;
        }
    }

    private void i3(ConstraintWidget[] constraintWidgetArr, int i3, int i4, int i5, int[] iArr) {
        ConstraintAnchor constraintAnchor;
        int i6;
        int i7;
        int i8;
        ConstraintAnchor constraintAnchor2;
        int i9;
        int i10;
        int i11;
        int i12 = i3;
        int i13 = i5;
        if (i12 != 0) {
            this.i2.clear();
            WidgetsList widgetsList = new WidgetsList(i4, this.Q, this.R, this.S, this.T, i5);
            this.i2.add(widgetsList);
            int i14 = 0;
            int i15 = 0;
            if (i4 == 0) {
                int i16 = 0;
                int i17 = 0;
                while (i17 < i12) {
                    int i18 = i14 + 1;
                    ConstraintWidget constraintWidget = constraintWidgetArr[i17];
                    int f3 = f3(constraintWidget, i13);
                    if (constraintWidget.H() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i15++;
                    }
                    int i19 = i15;
                    boolean z = (i16 == i13 || (this.b2 + i16) + f3 > i13) && widgetsList.f4205b != null;
                    if (!z && i17 > 0 && (i11 = this.g2) > 0 && i18 > i11) {
                        z = true;
                    }
                    if (z) {
                        widgetsList = new WidgetsList(i4, this.Q, this.R, this.S, this.T, i5);
                        widgetsList.i(i17);
                        this.i2.add(widgetsList);
                        i14 = i18;
                        i16 = f3;
                    } else {
                        i16 = i17 > 0 ? i16 + this.b2 + f3 : f3;
                        i14 = 0;
                    }
                    widgetsList.b(constraintWidget);
                    i17++;
                    i15 = i19;
                }
            } else {
                int i20 = 0;
                while (i20 < i12) {
                    ConstraintWidget constraintWidget2 = constraintWidgetArr[i20];
                    int e3 = e3(constraintWidget2, i13);
                    if (constraintWidget2.j0() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i15++;
                    }
                    int i21 = i15;
                    boolean z2 = (i14 == i13 || (this.c2 + i14) + e3 > i13) && widgetsList.f4205b != null;
                    if (!z2 && i20 > 0 && (i10 = this.g2) > 0 && i10 < 0) {
                        z2 = true;
                    }
                    if (z2) {
                        widgetsList = new WidgetsList(i4, this.Q, this.R, this.S, this.T, i5);
                        widgetsList.i(i20);
                        this.i2.add(widgetsList);
                    } else if (i20 > 0) {
                        i9 = i14 + this.c2 + e3;
                        widgetsList.b(constraintWidget2);
                        i20++;
                        i15 = i21;
                    }
                    i9 = e3;
                    widgetsList.b(constraintWidget2);
                    i20++;
                    i15 = i21;
                }
            }
            int size = this.i2.size();
            ConstraintAnchor constraintAnchor3 = this.Q;
            ConstraintAnchor constraintAnchor4 = this.R;
            ConstraintAnchor constraintAnchor5 = this.S;
            ConstraintAnchor constraintAnchor6 = this.T;
            int s22 = s2();
            int u22 = u2();
            int t22 = t2();
            int r22 = r2();
            ConstraintWidget.DimensionBehaviour H = H();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z3 = H == dimensionBehaviour || j0() == dimensionBehaviour;
            if (i15 > 0 && z3) {
                for (int i22 = 0; i22 < size; i22++) {
                    WidgetsList widgetsList2 = this.i2.get(i22);
                    widgetsList2.g(i13 - (i4 == 0 ? widgetsList2.f() : widgetsList2.e()));
                }
            }
            int i23 = u22;
            int i24 = t22;
            int i25 = 0;
            int i26 = 0;
            int i27 = 0;
            int i28 = s22;
            ConstraintAnchor constraintAnchor7 = constraintAnchor4;
            ConstraintAnchor constraintAnchor8 = constraintAnchor3;
            int i29 = r22;
            while (i27 < size) {
                WidgetsList widgetsList3 = this.i2.get(i27);
                if (i4 == 0) {
                    if (i27 < size - 1) {
                        constraintAnchor2 = this.i2.get(i27 + 1).f4205b.R;
                        i8 = 0;
                    } else {
                        constraintAnchor2 = this.T;
                        i8 = r2();
                    }
                    ConstraintAnchor constraintAnchor9 = widgetsList3.f4205b.T;
                    ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                    ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                    int i30 = i25;
                    ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                    int i31 = i26;
                    ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                    ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                    i6 = i27;
                    widgetsList3.j(i4, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i28, i23, i24, i8, i5);
                    int max = Math.max(i31, widgetsList3.f());
                    i25 = i30 + widgetsList3.e();
                    if (i6 > 0) {
                        i25 += this.c2;
                    }
                    constraintAnchor8 = constraintAnchor11;
                    i26 = max;
                    constraintAnchor7 = constraintAnchor9;
                    i23 = 0;
                    constraintAnchor = constraintAnchor14;
                    int i32 = i8;
                    constraintAnchor6 = constraintAnchor2;
                    i29 = i32;
                } else {
                    ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                    int i33 = i25;
                    int i34 = i26;
                    i6 = i27;
                    if (i6 < size - 1) {
                        constraintAnchor = this.i2.get(i6 + 1).f4205b.Q;
                        i7 = 0;
                    } else {
                        constraintAnchor = this.S;
                        i7 = t2();
                    }
                    ConstraintAnchor constraintAnchor16 = widgetsList3.f4205b.S;
                    widgetsList3.j(i4, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i28, i23, i7, i29, i5);
                    i26 = i34 + widgetsList3.f();
                    int max2 = Math.max(i33, widgetsList3.e());
                    if (i6 > 0) {
                        i26 += this.b2;
                    }
                    i25 = max2;
                    i24 = i7;
                    constraintAnchor8 = constraintAnchor16;
                    i28 = 0;
                }
                i27 = i6 + 1;
                int i35 = i5;
                constraintAnchor5 = constraintAnchor;
            }
            iArr[0] = i26;
            iArr[1] = i25;
        }
    }

    private void j3(ConstraintWidget[] constraintWidgetArr, int i3, int i4, int i5, int[] iArr) {
        WidgetsList widgetsList;
        int i6 = i3;
        if (i6 != 0) {
            if (this.i2.size() == 0) {
                widgetsList = new WidgetsList(i4, this.Q, this.R, this.S, this.T, i5);
                this.i2.add(widgetsList);
            } else {
                WidgetsList widgetsList2 = this.i2.get(0);
                widgetsList2.c();
                widgetsList = widgetsList2;
                int i7 = i4;
                widgetsList.j(i7, this.Q, this.R, this.S, this.T, s2(), u2(), t2(), r2(), i5);
            }
            for (int i8 = 0; i8 < i6; i8++) {
                widgetsList.b(constraintWidgetArr[i8]);
            }
            iArr[0] = widgetsList.f();
            iArr[1] = widgetsList.e();
        }
    }

    public void A3(int i3) {
        this.c2 = i3;
    }

    public void B3(int i3) {
        this.Q1 = i3;
    }

    public void C3(int i3) {
        this.f2 = i3;
    }

    public float d3() {
        return (float) this.g2;
    }

    public void g(LinearSystem linearSystem, boolean z) {
        super.g(linearSystem, z);
        boolean z2 = U() != null && ((ConstraintWidgetContainer) U()).O2();
        int i3 = this.f2;
        if (i3 != 0) {
            if (i3 == 1) {
                int size = this.i2.size();
                int i4 = 0;
                while (i4 < size) {
                    this.i2.get(i4).d(z2, i4, i4 == size + -1);
                    i4++;
                }
            } else if (i3 == 2) {
                c3(z2);
            } else if (i3 == 3) {
                int size2 = this.i2.size();
                int i5 = 0;
                while (i5 < size2) {
                    this.i2.get(i5).d(z2, i5, i5 == size2 + -1);
                    i5++;
                }
            }
        } else if (this.i2.size() > 0) {
            this.i2.get(0).d(z2, 0, true);
        }
        z2(false);
    }

    public void k3(float f3) {
        this.X1 = f3;
    }

    public void l3(int i3) {
        this.R1 = i3;
    }

    public void m3(float f3) {
        this.Y1 = f3;
    }

    public void n(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.n(constraintWidget, hashMap);
        Flow flow = (Flow) constraintWidget;
        this.P1 = flow.P1;
        this.Q1 = flow.Q1;
        this.R1 = flow.R1;
        this.S1 = flow.S1;
        this.T1 = flow.T1;
        this.U1 = flow.U1;
        this.V1 = flow.V1;
        this.W1 = flow.W1;
        this.X1 = flow.X1;
        this.Y1 = flow.Y1;
        this.Z1 = flow.Z1;
        this.a2 = flow.a2;
        this.b2 = flow.b2;
        this.c2 = flow.c2;
        this.d2 = flow.d2;
        this.e2 = flow.e2;
        this.f2 = flow.f2;
        this.g2 = flow.g2;
        this.h2 = flow.h2;
    }

    public void n3(int i3) {
        this.S1 = i3;
    }

    public void o3(int i3) {
        this.d2 = i3;
    }

    public void p3(float f3) {
        this.V1 = f3;
    }

    public void q3(int i3) {
        this.b2 = i3;
    }

    public void r3(int i3) {
        this.P1 = i3;
    }

    public void s3(float f3) {
        this.Z1 = f3;
    }

    public void t3(int i3) {
        this.T1 = i3;
    }

    public void u3(float f3) {
        this.a2 = f3;
    }

    /* JADX WARNING: type inference failed for: r11v2 */
    /* JADX WARNING: type inference failed for: r11v10 */
    /* JADX WARNING: type inference failed for: r11v19 */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        if (r6.Q1 == -1) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
        if (r6.Q1 == -1) goto L_0x0049;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0114  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void v2(int r19, int r20, int r21, int r22) {
        /*
            r18 = this;
            r6 = r18
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            int r0 = r6.B1
            r11 = 0
            if (r0 <= 0) goto L_0x001c
            boolean r0 = r18.x2()
            if (r0 != 0) goto L_0x001c
            r6.A2(r11, r11)
            r6.z2(r11)
            return
        L_0x001c:
            int r12 = r18.s2()
            int r13 = r18.t2()
            int r14 = r18.u2()
            int r15 = r18.r2()
            r0 = 2
            int[] r5 = new int[r0]
            int r1 = r8 - r12
            int r1 = r1 - r13
            int r2 = r6.h2
            r4 = 1
            if (r2 != r4) goto L_0x003a
            int r1 = r10 - r14
            int r1 = r1 - r15
        L_0x003a:
            r16 = r1
            r1 = -1
            if (r2 != 0) goto L_0x004c
            int r2 = r6.P1
            if (r2 != r1) goto L_0x0045
            r6.P1 = r11
        L_0x0045:
            int r2 = r6.Q1
            if (r2 != r1) goto L_0x0057
        L_0x0049:
            r6.Q1 = r11
            goto L_0x0057
        L_0x004c:
            int r2 = r6.P1
            if (r2 != r1) goto L_0x0052
            r6.P1 = r11
        L_0x0052:
            int r2 = r6.Q1
            if (r2 != r1) goto L_0x0057
            goto L_0x0049
        L_0x0057:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r1 = r6.A1
            r2 = 0
            r3 = 0
        L_0x005b:
            int r11 = r6.B1
            r0 = 8
            if (r2 >= r11) goto L_0x0071
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r11 = r6.A1
            r11 = r11[r2]
            int r11 = r11.l0()
            if (r11 != r0) goto L_0x006d
            int r3 = r3 + 1
        L_0x006d:
            int r2 = r2 + 1
            r0 = 2
            goto L_0x005b
        L_0x0071:
            if (r3 <= 0) goto L_0x0090
            int r11 = r11 - r3
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r1 = new androidx.constraintlayout.core.widgets.ConstraintWidget[r11]
            r2 = 0
            r3 = 0
        L_0x0078:
            int r11 = r6.B1
            if (r2 >= r11) goto L_0x008e
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r11 = r6.A1
            r11 = r11[r2]
            int r4 = r11.l0()
            if (r4 == r0) goto L_0x008a
            r1[r3] = r11
            int r3 = r3 + 1
        L_0x008a:
            int r2 = r2 + 1
            r4 = 1
            goto L_0x0078
        L_0x008e:
            r2 = r3
            goto L_0x0091
        L_0x0090:
            r2 = r11
        L_0x0091:
            r6.m2 = r1
            r6.n2 = r2
            int r0 = r6.f2
            if (r0 == 0) goto L_0x00cf
            r4 = 1
            if (r0 == r4) goto L_0x00c2
            r3 = 2
            if (r0 == r3) goto L_0x00b5
            r3 = 3
            if (r0 == r3) goto L_0x00a7
            r17 = r5
            r0 = 0
            r11 = 1
            goto L_0x00dc
        L_0x00a7:
            int r3 = r6.h2
            r0 = r18
            r11 = 1
            r4 = r16
            r17 = r5
            r0.i3(r1, r2, r3, r4, r5)
        L_0x00b3:
            r0 = 0
            goto L_0x00dc
        L_0x00b5:
            r17 = r5
            r11 = 1
            int r3 = r6.h2
            r0 = r18
            r4 = r16
            r0.g3(r1, r2, r3, r4, r5)
            goto L_0x00b3
        L_0x00c2:
            r17 = r5
            r11 = 1
            int r3 = r6.h2
            r0 = r18
            r4 = r16
            r0.h3(r1, r2, r3, r4, r5)
            goto L_0x00b3
        L_0x00cf:
            r17 = r5
            r11 = 1
            int r3 = r6.h2
            r0 = r18
            r4 = r16
            r0.j3(r1, r2, r3, r4, r5)
            goto L_0x00b3
        L_0x00dc:
            r1 = r17[r0]
            int r1 = r1 + r12
            int r1 = r1 + r13
            r2 = r17[r11]
            int r2 = r2 + r14
            int r2 = r2 + r15
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 1073741824(0x40000000, float:2.0)
            if (r7 != r4) goto L_0x00ec
            r1 = r8
            goto L_0x00f7
        L_0x00ec:
            if (r7 != r3) goto L_0x00f3
            int r1 = java.lang.Math.min(r1, r8)
            goto L_0x00f7
        L_0x00f3:
            if (r7 != 0) goto L_0x00f6
            goto L_0x00f7
        L_0x00f6:
            r1 = 0
        L_0x00f7:
            if (r9 != r4) goto L_0x00fb
            r2 = r10
            goto L_0x0106
        L_0x00fb:
            if (r9 != r3) goto L_0x0102
            int r2 = java.lang.Math.min(r2, r10)
            goto L_0x0106
        L_0x0102:
            if (r9 != 0) goto L_0x0105
            goto L_0x0106
        L_0x0105:
            r2 = 0
        L_0x0106:
            r6.A2(r1, r2)
            r6.c2(r1)
            r6.y1(r2)
            int r1 = r6.B1
            if (r1 <= 0) goto L_0x0114
            goto L_0x0115
        L_0x0114:
            r11 = 0
        L_0x0115:
            r6.z2(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.v2(int, int, int, int):void");
    }

    public void v3(int i3) {
        this.U1 = i3;
    }

    public void w3(int i3) {
        this.g2 = i3;
    }

    public void x3(int i3) {
        this.h2 = i3;
    }

    public void y3(int i3) {
        this.e2 = i3;
    }

    public void z3(float f3) {
        this.W1 = f3;
    }
}
