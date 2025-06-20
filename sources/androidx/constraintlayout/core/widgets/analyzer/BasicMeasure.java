package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import java.util.ArrayList;

public class BasicMeasure {

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f4237d = false;

    /* renamed from: e  reason: collision with root package name */
    private static final int f4238e = 30;

    /* renamed from: f  reason: collision with root package name */
    public static final int f4239f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static final int f4240g = 1073741824;

    /* renamed from: h  reason: collision with root package name */
    public static final int f4241h = Integer.MIN_VALUE;

    /* renamed from: i  reason: collision with root package name */
    public static final int f4242i = -1;

    /* renamed from: j  reason: collision with root package name */
    public static final int f4243j = -2;

    /* renamed from: k  reason: collision with root package name */
    public static final int f4244k = -3;

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<ConstraintWidget> f4245a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private Measure f4246b = new Measure();

    /* renamed from: c  reason: collision with root package name */
    private ConstraintWidgetContainer f4247c;

    public static class Measure {

        /* renamed from: k  reason: collision with root package name */
        public static int f4248k = 0;

        /* renamed from: l  reason: collision with root package name */
        public static int f4249l = 1;

        /* renamed from: m  reason: collision with root package name */
        public static int f4250m = 2;

        /* renamed from: a  reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f4251a;

        /* renamed from: b  reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f4252b;

        /* renamed from: c  reason: collision with root package name */
        public int f4253c;

        /* renamed from: d  reason: collision with root package name */
        public int f4254d;

        /* renamed from: e  reason: collision with root package name */
        public int f4255e;

        /* renamed from: f  reason: collision with root package name */
        public int f4256f;

        /* renamed from: g  reason: collision with root package name */
        public int f4257g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f4258h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f4259i;

        /* renamed from: j  reason: collision with root package name */
        public int f4260j;
    }

    public interface Measurer {
        void a();

        void b(ConstraintWidget constraintWidget, Measure measure);
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        this.f4247c = constraintWidgetContainer;
    }

    private boolean a(Measurer measurer, ConstraintWidget constraintWidget, int i2) {
        this.f4246b.f4251a = constraintWidget.H();
        this.f4246b.f4252b = constraintWidget.j0();
        this.f4246b.f4253c = constraintWidget.m0();
        this.f4246b.f4254d = constraintWidget.D();
        Measure measure = this.f4246b;
        measure.f4259i = false;
        measure.f4260j = i2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.f4251a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z = dimensionBehaviour == dimensionBehaviour2;
        boolean z2 = measure.f4252b == dimensionBehaviour2;
        boolean z3 = z && constraintWidget.f0 > 0.0f;
        boolean z4 = z2 && constraintWidget.f0 > 0.0f;
        if (z3 && constraintWidget.y[0] == 4) {
            measure.f4251a = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z4 && constraintWidget.y[1] == 4) {
            measure.f4252b = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.b(constraintWidget, measure);
        constraintWidget.c2(this.f4246b.f4255e);
        constraintWidget.y1(this.f4246b.f4256f);
        constraintWidget.x1(this.f4246b.f4258h);
        constraintWidget.g1(this.f4246b.f4257g);
        Measure measure2 = this.f4246b;
        measure2.f4260j = Measure.f4248k;
        return measure2.f4259i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008e, code lost:
        if (r8 != r9) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0095, code lost:
        if (r5.f0 <= 0.0f) goto L_0x0098;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r13) {
        /*
            r12 = this;
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r0 = r13.A1
            int r0 = r0.size()
            r1 = 64
            boolean r1 = r13.S2(r1)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r2 = r13.G2()
            r3 = 0
            r4 = 0
        L_0x0012:
            if (r4 >= r0) goto L_0x00b0
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r5 = r13.A1
            java.lang.Object r5 = r5.get(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r6 == 0) goto L_0x0022
            goto L_0x00ac
        L_0x0022:
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r6 == 0) goto L_0x0028
            goto L_0x00ac
        L_0x0028:
            boolean r6 = r5.E0()
            if (r6 == 0) goto L_0x0030
            goto L_0x00ac
        L_0x0030:
            if (r1 == 0) goto L_0x0048
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r6 = r5.f4192e
            if (r6 == 0) goto L_0x0048
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r7 = r5.f4193f
            if (r7 == 0) goto L_0x0048
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r6 = r6.f4330e
            boolean r6 = r6.f4282j
            if (r6 == 0) goto L_0x0048
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r6 = r7.f4330e
            boolean r6 = r6.f4282j
            if (r6 == 0) goto L_0x0048
            goto L_0x00ac
        L_0x0048:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = r5.z(r3)
            r7 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = r5.z(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r9) goto L_0x0061
            int r10 = r5.w
            if (r10 == r7) goto L_0x0061
            if (r8 != r9) goto L_0x0061
            int r10 = r5.x
            if (r10 == r7) goto L_0x0061
            r10 = 1
            goto L_0x0062
        L_0x0061:
            r10 = 0
        L_0x0062:
            if (r10 != 0) goto L_0x0098
            boolean r11 = r13.S2(r7)
            if (r11 == 0) goto L_0x0098
            boolean r11 = r5 instanceof androidx.constraintlayout.core.widgets.VirtualLayout
            if (r11 != 0) goto L_0x0098
            if (r6 != r9) goto L_0x007d
            int r11 = r5.w
            if (r11 != 0) goto L_0x007d
            if (r8 == r9) goto L_0x007d
            boolean r11 = r5.B0()
            if (r11 != 0) goto L_0x007d
            r10 = 1
        L_0x007d:
            if (r8 != r9) goto L_0x008c
            int r11 = r5.x
            if (r11 != 0) goto L_0x008c
            if (r6 == r9) goto L_0x008c
            boolean r11 = r5.B0()
            if (r11 != 0) goto L_0x008c
            r10 = 1
        L_0x008c:
            if (r6 == r9) goto L_0x0090
            if (r8 != r9) goto L_0x0098
        L_0x0090:
            float r6 = r5.f0
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x0098
            goto L_0x0099
        L_0x0098:
            r7 = r10
        L_0x0099:
            if (r7 == 0) goto L_0x009c
            goto L_0x00ac
        L_0x009c:
            int r6 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f4248k
            r12.a(r2, r5, r6)
            androidx.constraintlayout.core.Metrics r5 = r13.G1
            if (r5 == 0) goto L_0x00ac
            long r6 = r5.f3618c
            r8 = 1
            long r6 = r6 + r8
            r5.f3618c = r6
        L_0x00ac:
            int r4 = r4 + 1
            goto L_0x0012
        L_0x00b0:
            r2.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.b(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer):void");
    }

    private void c(ConstraintWidgetContainer constraintWidgetContainer, String str, int i2, int i3, int i4) {
        int Q = constraintWidgetContainer.Q();
        int P = constraintWidgetContainer.P();
        constraintWidgetContainer.P1(0);
        constraintWidgetContainer.O1(0);
        constraintWidgetContainer.c2(i3);
        constraintWidgetContainer.y1(i4);
        constraintWidgetContainer.P1(Q);
        constraintWidgetContainer.O1(P);
        this.f4247c.X2(i2);
        this.f4247c.n2();
    }

    public long d(ConstraintWidgetContainer constraintWidgetContainer, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        boolean z;
        int i12;
        int i13;
        boolean z2;
        Measurer measurer;
        int i14;
        int i15;
        int i16;
        boolean z3;
        Metrics metrics;
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        int i17 = i2;
        int i18 = i5;
        int i19 = i7;
        Measurer G2 = constraintWidgetContainer.G2();
        int size = constraintWidgetContainer2.A1.size();
        int m0 = constraintWidgetContainer.m0();
        int D = constraintWidgetContainer.D();
        boolean b2 = Optimizer.b(i17, 128);
        boolean z4 = b2 || Optimizer.b(i17, 64);
        if (z4) {
            int i20 = 0;
            while (true) {
                if (i20 >= size) {
                    break;
                }
                ConstraintWidget constraintWidget = constraintWidgetContainer2.A1.get(i20);
                ConstraintWidget.DimensionBehaviour H = constraintWidget.H();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z5 = (H == dimensionBehaviour) && (constraintWidget.j0() == dimensionBehaviour) && constraintWidget.A() > 0.0f;
                if ((!constraintWidget.B0() || !z5) && ((!constraintWidget.D0() || !z5) && !(constraintWidget instanceof VirtualLayout) && !constraintWidget.B0() && !constraintWidget.D0())) {
                    i20++;
                }
            }
            z4 = false;
        }
        if (z4 && (metrics = LinearSystem.C) != null) {
            metrics.f3620e++;
        }
        boolean z6 = z4 & ((i18 == 1073741824 && i19 == 1073741824) || b2);
        if (z6) {
            int min = Math.min(constraintWidgetContainer.O(), i6);
            int min2 = Math.min(constraintWidgetContainer.N(), i8);
            if (i18 == 1073741824 && constraintWidgetContainer.m0() != min) {
                constraintWidgetContainer2.c2(min);
                constraintWidgetContainer.L2();
            }
            if (i19 == 1073741824 && constraintWidgetContainer.D() != min2) {
                constraintWidgetContainer2.y1(min2);
                constraintWidgetContainer.L2();
            }
            if (i18 == 1073741824 && i19 == 1073741824) {
                z = constraintWidgetContainer2.B2(b2);
                i11 = 2;
            } else {
                boolean C2 = constraintWidgetContainer2.C2(b2);
                if (i18 == 1073741824) {
                    C2 &= constraintWidgetContainer2.D2(b2, 0);
                    i11 = 1;
                } else {
                    i11 = 0;
                }
                if (i19 == 1073741824) {
                    z = constraintWidgetContainer2.D2(b2, 1) & C2;
                    i11++;
                } else {
                    z = C2;
                }
            }
            if (z) {
                constraintWidgetContainer2.i2(i18 == 1073741824, i19 == 1073741824);
            }
        } else {
            z = false;
            i11 = 0;
        }
        if (z && i11 == 2) {
            return 0;
        }
        int H2 = constraintWidgetContainer.H2();
        if (size > 0) {
            b(constraintWidgetContainer);
        }
        e(constraintWidgetContainer);
        int size2 = this.f4245a.size();
        if (size > 0) {
            c(constraintWidgetContainer, "First pass", 0, m0, D);
        }
        if (size2 > 0) {
            ConstraintWidget.DimensionBehaviour H3 = constraintWidgetContainer.H();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z7 = H3 == dimensionBehaviour2;
            boolean z8 = constraintWidgetContainer.j0() == dimensionBehaviour2;
            int max = Math.max(constraintWidgetContainer.m0(), this.f4247c.Q());
            int max2 = Math.max(constraintWidgetContainer.D(), this.f4247c.P());
            int i21 = 0;
            boolean z9 = false;
            while (i21 < size2) {
                ConstraintWidget constraintWidget2 = this.f4245a.get(i21);
                if (!(constraintWidget2 instanceof VirtualLayout)) {
                    i14 = H2;
                    i15 = m0;
                    i16 = D;
                } else {
                    int m02 = constraintWidget2.m0();
                    i14 = H2;
                    int D2 = constraintWidget2.D();
                    i16 = D;
                    boolean a2 = a(G2, constraintWidget2, Measure.f4249l) | z9;
                    Metrics metrics2 = constraintWidgetContainer2.G1;
                    i15 = m0;
                    boolean z10 = a2;
                    if (metrics2 != null) {
                        metrics2.f3619d++;
                    }
                    int m03 = constraintWidget2.m0();
                    int D3 = constraintWidget2.D();
                    if (m03 != m02) {
                        constraintWidget2.c2(m03);
                        if (z7 && constraintWidget2.X() > max) {
                            max = Math.max(max, constraintWidget2.X() + constraintWidget2.r(ConstraintAnchor.Type.RIGHT).g());
                        }
                        z3 = true;
                    } else {
                        z3 = z10;
                    }
                    if (D3 != D2) {
                        constraintWidget2.y1(D3);
                        if (z8 && constraintWidget2.v() > max2) {
                            max2 = Math.max(max2, constraintWidget2.v() + constraintWidget2.r(ConstraintAnchor.Type.BOTTOM).g());
                        }
                        z3 = true;
                    }
                    z9 = z3 | ((VirtualLayout) constraintWidget2).y2();
                }
                i21++;
                H2 = i14;
                D = i16;
                m0 = i15;
            }
            int i22 = H2;
            int i23 = m0;
            int i24 = D;
            int i25 = 2;
            int i26 = 0;
            while (i26 < i25) {
                int i27 = 0;
                while (i27 < size2) {
                    ConstraintWidget constraintWidget3 = this.f4245a.get(i27);
                    if ((!(constraintWidget3 instanceof Helper) || (constraintWidget3 instanceof VirtualLayout)) && !(constraintWidget3 instanceof Guideline) && constraintWidget3.l0() != 8 && ((!z6 || !constraintWidget3.f4192e.f4330e.f4282j || !constraintWidget3.f4193f.f4330e.f4282j) && !(constraintWidget3 instanceof VirtualLayout))) {
                        int m04 = constraintWidget3.m0();
                        int D4 = constraintWidget3.D();
                        int t = constraintWidget3.t();
                        int i28 = Measure.f4249l;
                        z2 = z6;
                        if (i26 == 1) {
                            i28 = Measure.f4250m;
                        }
                        boolean a3 = a(G2, constraintWidget3, i28) | z9;
                        Metrics metrics3 = constraintWidgetContainer2.G1;
                        i13 = size2;
                        measurer = G2;
                        if (metrics3 != null) {
                            metrics3.f3619d++;
                        }
                        int m05 = constraintWidget3.m0();
                        int D5 = constraintWidget3.D();
                        if (m05 != m04) {
                            constraintWidget3.c2(m05);
                            if (z7 && constraintWidget3.X() > max) {
                                max = Math.max(max, constraintWidget3.X() + constraintWidget3.r(ConstraintAnchor.Type.RIGHT).g());
                            }
                            a3 = true;
                        }
                        if (D5 != D4) {
                            constraintWidget3.y1(D5);
                            if (z8 && constraintWidget3.v() > max2) {
                                max2 = Math.max(max2, constraintWidget3.v() + constraintWidget3.r(ConstraintAnchor.Type.BOTTOM).g());
                            }
                            a3 = true;
                        }
                        z9 = (!constraintWidget3.q0() || t == constraintWidget3.t()) ? a3 : true;
                    } else {
                        z2 = z6;
                        i13 = size2;
                        measurer = G2;
                    }
                    i27++;
                    G2 = measurer;
                    z6 = z2;
                    size2 = i13;
                }
                boolean z11 = z6;
                int i29 = size2;
                Measurer measurer2 = G2;
                if (!z9) {
                    break;
                }
                i26++;
                c(constraintWidgetContainer, "intermediate pass", i26, i23, i24);
                G2 = measurer2;
                z6 = z11;
                size2 = i29;
                i25 = 2;
                z9 = false;
            }
            i12 = i22;
        } else {
            i12 = H2;
        }
        constraintWidgetContainer2.V2(i12);
        return 0;
    }

    public void e(ConstraintWidgetContainer constraintWidgetContainer) {
        this.f4245a.clear();
        int size = constraintWidgetContainer.A1.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer.A1.get(i2);
            ConstraintWidget.DimensionBehaviour H = constraintWidget.H();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (H == dimensionBehaviour || constraintWidget.j0() == dimensionBehaviour) {
                this.f4245a.add(constraintWidget);
            }
        }
        constraintWidgetContainer.L2();
    }
}
