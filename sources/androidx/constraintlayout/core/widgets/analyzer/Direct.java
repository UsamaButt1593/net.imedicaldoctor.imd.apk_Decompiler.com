package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;

public class Direct {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f4286a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f4287b = false;

    /* renamed from: c  reason: collision with root package name */
    private static BasicMeasure.Measure f4288c = new BasicMeasure.Measure();

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f4289d = true;

    /* renamed from: e  reason: collision with root package name */
    private static int f4290e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static int f4291f = 0;

    private static boolean a(int i2, ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour H = constraintWidget.H();
        ConstraintWidget.DimensionBehaviour j0 = constraintWidget.j0();
        ConstraintWidgetContainer constraintWidgetContainer = constraintWidget.U() != null ? (ConstraintWidgetContainer) constraintWidget.U() : null;
        if (constraintWidgetContainer != null) {
            ConstraintWidget.DimensionBehaviour H2 = constraintWidgetContainer.H();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (constraintWidgetContainer != null) {
            ConstraintWidget.DimensionBehaviour j02 = constraintWidgetContainer.j0();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
        boolean z = H == dimensionBehaviour5 || constraintWidget.G0() || H == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (H == (dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.w == 0 && constraintWidget.f0 == 0.0f && constraintWidget.r0(0)) || (H == dimensionBehaviour2 && constraintWidget.w == 1 && constraintWidget.u0(0, constraintWidget.m0()));
        boolean z2 = j0 == dimensionBehaviour5 || constraintWidget.H0() || j0 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (j0 == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.x == 0 && constraintWidget.f0 == 0.0f && constraintWidget.r0(1)) || (j0 == dimensionBehaviour && constraintWidget.x == 1 && constraintWidget.u0(1, constraintWidget.D()));
        if (constraintWidget.f0 <= 0.0f || (!z && !z2)) {
            return z && z2;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0084, code lost:
        r11 = r12.S.f4183f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0094, code lost:
        r11 = r12.Q.f4183f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(int r16, androidx.constraintlayout.core.widgets.ConstraintWidget r17, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer r18, boolean r19) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r17.z0()
            if (r3 == 0) goto L_0x000d
            return
        L_0x000d:
            int r3 = f4290e
            r4 = 1
            int r3 = r3 + r4
            f4290e = r3
            boolean r3 = r0 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r3 != 0) goto L_0x002f
            boolean r3 = r17.F0()
            if (r3 == 0) goto L_0x002f
            int r3 = r16 + 1
            boolean r5 = a(r3, r0)
            if (r5 == 0) goto L_0x002f
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r5 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r5.<init>()
            int r6 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f4248k
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.R2(r3, r0, r1, r5, r6)
        L_0x002f:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r0.r(r3)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r0.r(r5)
            int r6 = r3.f()
            int r7 = r5.f()
            java.util.HashSet r8 = r3.e()
            r9 = 0
            r10 = 8
            if (r8 == 0) goto L_0x012e
            boolean r8 = r3.o()
            if (r8 == 0) goto L_0x012e
            java.util.HashSet r3 = r3.e()
            java.util.Iterator r3 = r3.iterator()
        L_0x005a:
            boolean r8 = r3.hasNext()
            if (r8 == 0) goto L_0x012e
            java.lang.Object r8 = r3.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r8
            androidx.constraintlayout.core.widgets.ConstraintWidget r12 = r8.f4181d
            int r13 = r16 + 1
            boolean r14 = a(r13, r12)
            boolean r15 = r12.F0()
            if (r15 == 0) goto L_0x0080
            if (r14 == 0) goto L_0x0080
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r15 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r15.<init>()
            int r11 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f4248k
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.R2(r13, r12, r1, r15, r11)
        L_0x0080:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r12.Q
            if (r8 != r11) goto L_0x0090
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r12.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r11.f4183f
            if (r11 == 0) goto L_0x0090
            boolean r11 = r11.o()
            if (r11 != 0) goto L_0x00a0
        L_0x0090:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r12.S
            if (r8 != r11) goto L_0x00a2
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r12.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r11.f4183f
            if (r11 == 0) goto L_0x00a2
            boolean r11 = r11.o()
            if (r11 == 0) goto L_0x00a2
        L_0x00a0:
            r11 = 1
            goto L_0x00a3
        L_0x00a2:
            r11 = 0
        L_0x00a3:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = r12.H()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r15 != r4) goto L_0x00e6
            if (r14 == 0) goto L_0x00ae
            goto L_0x00e6
        L_0x00ae:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = r12.H()
            if (r8 != r4) goto L_0x00ec
            int r4 = r12.A
            if (r4 < 0) goto L_0x00ec
            int r4 = r12.z
            if (r4 < 0) goto L_0x00ec
            int r4 = r12.l0()
            if (r4 == r10) goto L_0x00ce
            int r4 = r12.w
            if (r4 != 0) goto L_0x00ec
            float r4 = r12.A()
            int r4 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r4 != 0) goto L_0x00ec
        L_0x00ce:
            boolean r4 = r12.B0()
            if (r4 != 0) goto L_0x00ec
            boolean r4 = r12.E0()
            if (r4 != 0) goto L_0x00ec
            if (r11 == 0) goto L_0x00ec
            boolean r4 = r12.B0()
            if (r4 != 0) goto L_0x00ec
            g(r13, r0, r1, r12, r2)
            goto L_0x00ec
        L_0x00e6:
            boolean r4 = r12.F0()
            if (r4 == 0) goto L_0x00ef
        L_0x00ec:
            r4 = 1
            goto L_0x005a
        L_0x00ef:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r12.Q
            if (r8 != r4) goto L_0x010a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r12.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r14.f4183f
            if (r14 != 0) goto L_0x010a
            int r4 = r4.g()
            int r4 = r4 + r6
            int r8 = r12.m0()
            int r8 = r8 + r4
            r12.q1(r4, r8)
        L_0x0106:
            b(r13, r12, r1, r2)
            goto L_0x00ec
        L_0x010a:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r12.S
            if (r8 != r14) goto L_0x0122
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.f4183f
            if (r4 != 0) goto L_0x0122
            int r4 = r14.g()
            int r4 = r6 - r4
            int r8 = r12.m0()
            int r8 = r4 - r8
            r12.q1(r8, r4)
            goto L_0x0106
        L_0x0122:
            if (r11 == 0) goto L_0x00ec
            boolean r4 = r12.B0()
            if (r4 != 0) goto L_0x00ec
            f(r13, r1, r12, r2)
            goto L_0x00ec
        L_0x012e:
            boolean r3 = r0 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r3 == 0) goto L_0x0133
            return
        L_0x0133:
            java.util.HashSet r3 = r5.e()
            if (r3 == 0) goto L_0x021e
            boolean r3 = r5.o()
            if (r3 == 0) goto L_0x021e
            java.util.HashSet r3 = r5.e()
            java.util.Iterator r3 = r3.iterator()
        L_0x0147:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x021e
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r4
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r4.f4181d
            r6 = 1
            int r8 = r16 + 1
            boolean r11 = a(r8, r5)
            boolean r12 = r5.F0()
            if (r12 == 0) goto L_0x016e
            if (r11 == 0) goto L_0x016e
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r12 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r12.<init>()
            int r13 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f4248k
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.R2(r8, r5, r1, r12, r13)
        L_0x016e:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r5.Q
            if (r4 != r12) goto L_0x017e
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r5.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r12.f4183f
            if (r12 == 0) goto L_0x017e
            boolean r12 = r12.o()
            if (r12 != 0) goto L_0x018e
        L_0x017e:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r5.S
            if (r4 != r12) goto L_0x0190
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r5.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r12.f4183f
            if (r12 == 0) goto L_0x0190
            boolean r12 = r12.o()
            if (r12 == 0) goto L_0x0190
        L_0x018e:
            r12 = 1
            goto L_0x0191
        L_0x0190:
            r12 = 0
        L_0x0191:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = r5.H()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r13 != r14) goto L_0x01d5
            if (r11 == 0) goto L_0x019c
            goto L_0x01d5
        L_0x019c:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = r5.H()
            if (r4 != r14) goto L_0x0147
            int r4 = r5.A
            if (r4 < 0) goto L_0x0147
            int r4 = r5.z
            if (r4 < 0) goto L_0x0147
            int r4 = r5.l0()
            if (r4 == r10) goto L_0x01bc
            int r4 = r5.w
            if (r4 != 0) goto L_0x0147
            float r4 = r5.A()
            int r4 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r4 != 0) goto L_0x0147
        L_0x01bc:
            boolean r4 = r5.B0()
            if (r4 != 0) goto L_0x0147
            boolean r4 = r5.E0()
            if (r4 != 0) goto L_0x0147
            if (r12 == 0) goto L_0x0147
            boolean r4 = r5.B0()
            if (r4 != 0) goto L_0x0147
            g(r8, r0, r1, r5, r2)
            goto L_0x0147
        L_0x01d5:
            boolean r11 = r5.F0()
            if (r11 == 0) goto L_0x01dd
            goto L_0x0147
        L_0x01dd:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r5.Q
            if (r4 != r11) goto L_0x01f9
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r5.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r13.f4183f
            if (r13 != 0) goto L_0x01f9
            int r4 = r11.g()
            int r4 = r4 + r7
            int r11 = r5.m0()
            int r11 = r11 + r4
            r5.q1(r4, r11)
        L_0x01f4:
            b(r8, r5, r1, r2)
            goto L_0x0147
        L_0x01f9:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r5.S
            if (r4 != r13) goto L_0x0211
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r11.f4183f
            if (r4 != 0) goto L_0x0211
            int r4 = r13.g()
            int r4 = r7 - r4
            int r11 = r5.m0()
            int r11 = r4 - r11
            r5.q1(r11, r4)
            goto L_0x01f4
        L_0x0211:
            if (r12 == 0) goto L_0x0147
            boolean r4 = r5.B0()
            if (r4 != 0) goto L_0x0147
            f(r8, r1, r5, r2)
            goto L_0x0147
        L_0x021e:
            r17.N0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Direct.b(int, androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer, boolean):void");
    }

    public static String c(int i2) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("  ");
        }
        sb.append("+-(" + i2 + ") ");
        return sb.toString();
    }

    private static void d(int i2, Barrier barrier, BasicMeasure.Measurer measurer, int i3, boolean z) {
        if (barrier.m2()) {
            int i4 = i2 + 1;
            if (i3 == 0) {
                b(i4, barrier, measurer, z);
            } else {
                k(i4, barrier, measurer);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01d1, code lost:
        if (r6.f4181d == r0) goto L_0x01d5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x014e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean e(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r20, androidx.constraintlayout.core.LinearSystem r21, int r22, int r23, androidx.constraintlayout.core.widgets.ChainHead r24, boolean r25, boolean r26, boolean r27) {
        /*
            r0 = 0
            if (r27 == 0) goto L_0x0004
            return r0
        L_0x0004:
            if (r22 != 0) goto L_0x000d
            boolean r1 = r20.G0()
            if (r1 != 0) goto L_0x0014
            return r0
        L_0x000d:
            boolean r1 = r20.H0()
            if (r1 != 0) goto L_0x0014
            return r0
        L_0x0014:
            boolean r1 = r20.O2()
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r24.c()
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r24.g()
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r24.e()
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r24.i()
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r24.f()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r7 = r2.Y
            r7 = r7[r23]
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r3.Y
            int r8 = r23 + 1
            r3 = r3[r8]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r7.f4183f
            if (r9 == 0) goto L_0x0229
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.f4183f
            if (r10 != 0) goto L_0x0040
            goto L_0x0229
        L_0x0040:
            boolean r9 = r9.o()
            if (r9 == 0) goto L_0x0229
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r3.f4183f
            boolean r9 = r9.o()
            if (r9 != 0) goto L_0x0050
            goto L_0x0229
        L_0x0050:
            if (r4 == 0) goto L_0x0229
            if (r5 != 0) goto L_0x0056
            goto L_0x0229
        L_0x0056:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.f4183f
            int r7 = r7.f()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r9 = r4.Y
            r9 = r9[r23]
            int r9 = r9.g()
            int r7 = r7 + r9
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f4183f
            int r3 = r3.f()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r9 = r5.Y
            r9 = r9[r8]
            int r9 = r9.g()
            int r3 = r3 - r9
            int r9 = r3 - r7
            if (r9 > 0) goto L_0x0079
            return r0
        L_0x0079:
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r10 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r10.<init>()
            r13 = r2
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 0
        L_0x0083:
            r17 = 0
            r0 = 1
            if (r11 != 0) goto L_0x0100
            boolean r18 = a(r0, r13)
            r16 = 0
            if (r18 != 0) goto L_0x0091
            return r16
        L_0x0091:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r13.b0
            r0 = r0[r22]
            r18 = r2
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r2) goto L_0x009c
            return r16
        L_0x009c:
            boolean r0 = r13.F0()
            if (r0 == 0) goto L_0x00af
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r0 = r20.G2()
            int r2 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f4248k
            r19 = r11
            r11 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.R2(r11, r13, r0, r10, r2)
            goto L_0x00b1
        L_0x00af:
            r19 = r11
        L_0x00b1:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r13.Y
            r0 = r0[r23]
            int r0 = r0.g()
            int r15 = r15 + r0
            if (r22 != 0) goto L_0x00c2
            int r0 = r13.m0()
        L_0x00c0:
            int r15 = r15 + r0
            goto L_0x00c7
        L_0x00c2:
            int r0 = r13.D()
            goto L_0x00c0
        L_0x00c7:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r13.Y
            r0 = r0[r8]
            int r0 = r0.g()
            int r15 = r15 + r0
            int r14 = r14 + 1
            int r0 = r13.l0()
            r2 = 8
            if (r0 == r2) goto L_0x00dc
            int r12 = r12 + 1
        L_0x00dc:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r13.Y
            r0 = r0[r8]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.f4183f
            if (r0 == 0) goto L_0x00f5
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.f4181d
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r0.Y
            r2 = r2[r23]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f4183f
            if (r2 == 0) goto L_0x00f5
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r2.f4181d
            if (r2 == r13) goto L_0x00f3
            goto L_0x00f5
        L_0x00f3:
            r17 = r0
        L_0x00f5:
            if (r17 == 0) goto L_0x00fc
            r13 = r17
            r11 = r19
            goto L_0x00fd
        L_0x00fc:
            r11 = 1
        L_0x00fd:
            r2 = r18
            goto L_0x0083
        L_0x0100:
            r18 = r2
            r0 = 0
            if (r12 != 0) goto L_0x0106
            return r0
        L_0x0106:
            if (r12 == r14) goto L_0x0109
            return r0
        L_0x0109:
            if (r9 >= r15) goto L_0x010c
            return r0
        L_0x010c:
            int r9 = r9 - r15
            r0 = 2
            if (r25 == 0) goto L_0x0115
            int r2 = r12 + 1
            int r9 = r9 / r2
        L_0x0113:
            r2 = 1
            goto L_0x011c
        L_0x0115:
            if (r26 == 0) goto L_0x0113
            if (r12 <= r0) goto L_0x0113
            int r9 = r9 / r12
            r2 = 1
            int r9 = r9 - r2
        L_0x011c:
            if (r12 != r2) goto L_0x014e
            if (r22 != 0) goto L_0x0125
            float r0 = r6.E()
            goto L_0x0129
        L_0x0125:
            float r0 = r6.g0()
        L_0x0129:
            r2 = 1056964608(0x3f000000, float:0.5)
            float r3 = (float) r7
            float r3 = r3 + r2
            float r2 = (float) r9
            float r2 = r2 * r0
            float r3 = r3 + r2
            int r0 = (int) r3
            if (r22 != 0) goto L_0x013d
            int r2 = r4.m0()
            int r2 = r2 + r0
            r4.q1(r0, r2)
            goto L_0x0145
        L_0x013d:
            int r2 = r4.D()
            int r2 = r2 + r0
            r4.t1(r0, r2)
        L_0x0145:
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r0 = r20.G2()
            r2 = 1
            b(r2, r4, r0, r1)
            return r2
        L_0x014e:
            if (r25 == 0) goto L_0x01dd
            int r7 = r7 + r9
            r0 = r18
            r3 = 0
        L_0x0154:
            if (r3 != 0) goto L_0x0228
            int r4 = r0.l0()
            r5 = 8
            if (r4 != r5) goto L_0x0179
            if (r22 != 0) goto L_0x016b
            r0.q1(r7, r7)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r4 = r20.G2()
            b(r2, r0, r4, r1)
            goto L_0x0175
        L_0x016b:
            r0.t1(r7, r7)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r4 = r20.G2()
            k(r2, r0, r4)
        L_0x0175:
            r2 = r21
            r4 = 0
            goto L_0x01ba
        L_0x0179:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r0.Y
            r2 = r2[r23]
            int r2 = r2.g()
            int r7 = r7 + r2
            if (r22 != 0) goto L_0x019a
            int r2 = r0.m0()
            int r2 = r2 + r7
            r0.q1(r7, r2)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r2 = r20.G2()
            r4 = 1
            b(r4, r0, r2, r1)
            int r2 = r0.m0()
        L_0x0198:
            int r7 = r7 + r2
            goto L_0x01af
        L_0x019a:
            r4 = 1
            int r2 = r0.D()
            int r2 = r2 + r7
            r0.t1(r7, r2)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r2 = r20.G2()
            k(r4, r0, r2)
            int r2 = r0.D()
            goto L_0x0198
        L_0x01af:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r0.Y
            r2 = r2[r8]
            int r2 = r2.g()
            int r7 = r7 + r2
            int r7 = r7 + r9
            goto L_0x0175
        L_0x01ba:
            r0.g(r2, r4)
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r0.Y
            r4 = r4[r8]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.f4183f
            if (r4 == 0) goto L_0x01d3
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r4.f4181d
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r4.Y
            r6 = r6[r23]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r6.f4183f
            if (r6 == 0) goto L_0x01d3
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r6.f4181d
            if (r6 == r0) goto L_0x01d5
        L_0x01d3:
            r4 = r17
        L_0x01d5:
            if (r4 == 0) goto L_0x01d9
            r0 = r4
            goto L_0x01da
        L_0x01d9:
            r3 = 1
        L_0x01da:
            r2 = 1
            goto L_0x0154
        L_0x01dd:
            if (r26 == 0) goto L_0x0227
            if (r12 != r0) goto L_0x0225
            if (r22 != 0) goto L_0x0204
            int r0 = r4.m0()
            int r0 = r0 + r7
            r4.q1(r7, r0)
            int r0 = r5.m0()
            int r0 = r3 - r0
            r5.q1(r0, r3)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r0 = r20.G2()
            r2 = 1
            b(r2, r4, r0, r1)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r0 = r20.G2()
            b(r2, r5, r0, r1)
            goto L_0x0224
        L_0x0204:
            r2 = 1
            int r0 = r4.D()
            int r0 = r0 + r7
            r4.t1(r7, r0)
            int r0 = r5.D()
            int r0 = r3 - r0
            r5.t1(r0, r3)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r0 = r20.G2()
            k(r2, r4, r0)
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer r0 = r20.G2()
            k(r2, r5, r0)
        L_0x0224:
            return r2
        L_0x0225:
            r0 = 0
            return r0
        L_0x0227:
            r2 = 1
        L_0x0228:
            return r2
        L_0x0229:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Direct.e(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, androidx.constraintlayout.core.LinearSystem, int, int, androidx.constraintlayout.core.widgets.ChainHead, boolean, boolean, boolean):boolean");
    }

    private static void f(int i2, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget, boolean z) {
        float E = constraintWidget.E();
        int f2 = constraintWidget.Q.f4183f.f();
        int f3 = constraintWidget.S.f4183f.f();
        int g2 = constraintWidget.Q.g() + f2;
        int g3 = f3 - constraintWidget.S.g();
        if (f2 == f3) {
            E = 0.5f;
        } else {
            f2 = g2;
            f3 = g3;
        }
        int m0 = constraintWidget.m0();
        int i3 = (f3 - f2) - m0;
        if (f2 > f3) {
            i3 = (f2 - f3) - m0;
        }
        int i4 = ((int) (i3 > 0 ? (E * ((float) i3)) + 0.5f : E * ((float) i3))) + f2;
        int i5 = i4 + m0;
        if (f2 > f3) {
            i5 = i4 - m0;
        }
        constraintWidget.q1(i4, i5);
        b(i2 + 1, constraintWidget, measurer, z);
    }

    private static void g(int i2, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2, boolean z) {
        float E = constraintWidget2.E();
        int f2 = constraintWidget2.Q.f4183f.f() + constraintWidget2.Q.g();
        int f3 = constraintWidget2.S.f4183f.f() - constraintWidget2.S.g();
        if (f3 >= f2) {
            int m0 = constraintWidget2.m0();
            if (constraintWidget2.l0() != 8) {
                int i3 = constraintWidget2.w;
                if (i3 == 2) {
                    if (!(constraintWidget instanceof ConstraintWidgetContainer)) {
                        constraintWidget = constraintWidget.U();
                    }
                    m0 = (int) (constraintWidget2.E() * 0.5f * ((float) constraintWidget.m0()));
                } else if (i3 == 0) {
                    m0 = f3 - f2;
                }
                m0 = Math.max(constraintWidget2.z, m0);
                int i4 = constraintWidget2.A;
                if (i4 > 0) {
                    m0 = Math.min(i4, m0);
                }
            }
            int i5 = f2 + ((int) ((E * ((float) ((f3 - f2) - m0))) + 0.5f));
            constraintWidget2.q1(i5, m0 + i5);
            b(i2 + 1, constraintWidget2, measurer, z);
        }
    }

    private static void h(int i2, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget) {
        float g0 = constraintWidget.g0();
        int f2 = constraintWidget.R.f4183f.f();
        int f3 = constraintWidget.T.f4183f.f();
        int g2 = constraintWidget.R.g() + f2;
        int g3 = f3 - constraintWidget.T.g();
        if (f2 == f3) {
            g0 = 0.5f;
        } else {
            f2 = g2;
            f3 = g3;
        }
        int D = constraintWidget.D();
        int i3 = (f3 - f2) - D;
        if (f2 > f3) {
            i3 = (f2 - f3) - D;
        }
        int i4 = (int) (i3 > 0 ? (g0 * ((float) i3)) + 0.5f : g0 * ((float) i3));
        int i5 = f2 + i4;
        int i6 = i5 + D;
        if (f2 > f3) {
            i5 = f2 - i4;
            i6 = i5 - D;
        }
        constraintWidget.t1(i5, i6);
        k(i2 + 1, constraintWidget, measurer);
    }

    private static void i(int i2, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2) {
        float g0 = constraintWidget2.g0();
        int f2 = constraintWidget2.R.f4183f.f() + constraintWidget2.R.g();
        int f3 = constraintWidget2.T.f4183f.f() - constraintWidget2.T.g();
        if (f3 >= f2) {
            int D = constraintWidget2.D();
            if (constraintWidget2.l0() != 8) {
                int i3 = constraintWidget2.x;
                if (i3 == 2) {
                    if (!(constraintWidget instanceof ConstraintWidgetContainer)) {
                        constraintWidget = constraintWidget.U();
                    }
                    D = (int) (g0 * 0.5f * ((float) constraintWidget.D()));
                } else if (i3 == 0) {
                    D = f3 - f2;
                }
                D = Math.max(constraintWidget2.C, D);
                int i4 = constraintWidget2.D;
                if (i4 > 0) {
                    D = Math.min(i4, D);
                }
            }
            int i5 = f2 + ((int) ((g0 * ((float) ((f3 - f2) - D))) + 0.5f));
            constraintWidget2.t1(i5, D + i5);
            k(i2 + 1, constraintWidget2, measurer);
        }
    }

    public static void j(ConstraintWidgetContainer constraintWidgetContainer, BasicMeasure.Measurer measurer) {
        int q2;
        int q22;
        ConstraintWidget.DimensionBehaviour H = constraintWidgetContainer.H();
        ConstraintWidget.DimensionBehaviour j0 = constraintWidgetContainer.j0();
        f4290e = 0;
        f4291f = 0;
        constraintWidgetContainer.V0();
        ArrayList<ConstraintWidget> l2 = constraintWidgetContainer.l2();
        int size = l2.size();
        for (int i2 = 0; i2 < size; i2++) {
            l2.get(i2).V0();
        }
        boolean O2 = constraintWidgetContainer.O2();
        if (H == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.q1(0, constraintWidgetContainer.m0());
        } else {
            constraintWidgetContainer.r1(0);
        }
        boolean z = false;
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget = l2.get(i3);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.m2() == 1) {
                    if (guideline.n2() != -1) {
                        q22 = guideline.n2();
                    } else if (guideline.p2() == -1 || !constraintWidgetContainer.G0()) {
                        if (constraintWidgetContainer.G0()) {
                            q22 = (int) ((guideline.q2() * ((float) constraintWidgetContainer.m0())) + 0.5f);
                        }
                        z = true;
                    } else {
                        q22 = constraintWidgetContainer.m0() - guideline.p2();
                    }
                    guideline.v2(q22);
                    z = true;
                }
            } else if ((constraintWidget instanceof Barrier) && ((Barrier) constraintWidget).r2() == 0) {
                z2 = true;
            }
        }
        if (z) {
            for (int i4 = 0; i4 < size; i4++) {
                ConstraintWidget constraintWidget2 = l2.get(i4);
                if (constraintWidget2 instanceof Guideline) {
                    Guideline guideline2 = (Guideline) constraintWidget2;
                    if (guideline2.m2() == 1) {
                        b(0, guideline2, measurer, O2);
                    }
                }
            }
        }
        b(0, constraintWidgetContainer, measurer, O2);
        if (z2) {
            for (int i5 = 0; i5 < size; i5++) {
                ConstraintWidget constraintWidget3 = l2.get(i5);
                if (constraintWidget3 instanceof Barrier) {
                    Barrier barrier = (Barrier) constraintWidget3;
                    if (barrier.r2() == 0) {
                        d(0, barrier, measurer, 0, O2);
                    }
                }
            }
        }
        if (j0 == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.t1(0, constraintWidgetContainer.D());
        } else {
            constraintWidgetContainer.s1(0);
        }
        boolean z3 = false;
        boolean z4 = false;
        for (int i6 = 0; i6 < size; i6++) {
            ConstraintWidget constraintWidget4 = l2.get(i6);
            if (constraintWidget4 instanceof Guideline) {
                Guideline guideline3 = (Guideline) constraintWidget4;
                if (guideline3.m2() == 0) {
                    if (guideline3.n2() != -1) {
                        q2 = guideline3.n2();
                    } else if (guideline3.p2() == -1 || !constraintWidgetContainer.H0()) {
                        if (constraintWidgetContainer.H0()) {
                            q2 = (int) ((guideline3.q2() * ((float) constraintWidgetContainer.D())) + 0.5f);
                        }
                        z3 = true;
                    } else {
                        q2 = constraintWidgetContainer.D() - guideline3.p2();
                    }
                    guideline3.v2(q2);
                    z3 = true;
                }
            } else if ((constraintWidget4 instanceof Barrier) && ((Barrier) constraintWidget4).r2() == 1) {
                z4 = true;
            }
        }
        if (z3) {
            for (int i7 = 0; i7 < size; i7++) {
                ConstraintWidget constraintWidget5 = l2.get(i7);
                if (constraintWidget5 instanceof Guideline) {
                    Guideline guideline4 = (Guideline) constraintWidget5;
                    if (guideline4.m2() == 0) {
                        k(1, guideline4, measurer);
                    }
                }
            }
        }
        k(0, constraintWidgetContainer, measurer);
        if (z4) {
            for (int i8 = 0; i8 < size; i8++) {
                ConstraintWidget constraintWidget6 = l2.get(i8);
                if (constraintWidget6 instanceof Barrier) {
                    Barrier barrier2 = (Barrier) constraintWidget6;
                    if (barrier2.r2() == 1) {
                        d(0, barrier2, measurer, 1, O2);
                    }
                }
            }
        }
        for (int i9 = 0; i9 < size; i9++) {
            ConstraintWidget constraintWidget7 = l2.get(i9);
            if (constraintWidget7.F0() && a(0, constraintWidget7)) {
                ConstraintWidgetContainer.R2(0, constraintWidget7, measurer, f4288c, BasicMeasure.Measure.f4248k);
                if (!(constraintWidget7 instanceof Guideline)) {
                    b(0, constraintWidget7, measurer, O2);
                } else if (((Guideline) constraintWidget7).m2() != 0) {
                    b(0, constraintWidget7, measurer, O2);
                }
                k(0, constraintWidget7, measurer);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0082, code lost:
        r14 = r11.T.f4183f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0092, code lost:
        r14 = r11.R.f4183f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void k(int r16, androidx.constraintlayout.core.widgets.ConstraintWidget r17, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer r18) {
        /*
            r0 = r17
            r1 = r18
            boolean r2 = r17.L0()
            if (r2 == 0) goto L_0x000b
            return
        L_0x000b:
            int r2 = f4291f
            r3 = 1
            int r2 = r2 + r3
            f4291f = r2
            boolean r2 = r0 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r2 != 0) goto L_0x002d
            boolean r2 = r17.F0()
            if (r2 == 0) goto L_0x002d
            int r2 = r16 + 1
            boolean r4 = a(r2, r0)
            if (r4 == 0) goto L_0x002d
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r4 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r4.<init>()
            int r5 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f4248k
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.R2(r2, r0, r1, r4, r5)
        L_0x002d:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.r(r2)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.r(r4)
            int r5 = r2.f()
            int r6 = r4.f()
            java.util.HashSet r7 = r2.e()
            r8 = 0
            r9 = 8
            if (r7 == 0) goto L_0x012e
            boolean r7 = r2.o()
            if (r7 == 0) goto L_0x012e
            java.util.HashSet r2 = r2.e()
            java.util.Iterator r2 = r2.iterator()
        L_0x0058:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x012e
            java.lang.Object r7 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r7
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r7.f4181d
            int r12 = r16 + 1
            boolean r13 = a(r12, r11)
            boolean r14 = r11.F0()
            if (r14 == 0) goto L_0x007e
            if (r13 == 0) goto L_0x007e
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r14 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r14.<init>()
            int r15 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f4248k
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.R2(r12, r11, r1, r14, r15)
        L_0x007e:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r11.R
            if (r7 != r14) goto L_0x008e
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r11.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r14.f4183f
            if (r14 == 0) goto L_0x008e
            boolean r14 = r14.o()
            if (r14 != 0) goto L_0x009e
        L_0x008e:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r11.T
            if (r7 != r14) goto L_0x00a0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r11.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r14.f4183f
            if (r14 == 0) goto L_0x00a0
            boolean r14 = r14.o()
            if (r14 == 0) goto L_0x00a0
        L_0x009e:
            r14 = 1
            goto L_0x00a1
        L_0x00a0:
            r14 = 0
        L_0x00a1:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = r11.j0()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r15 != r10) goto L_0x00e5
            if (r13 == 0) goto L_0x00ac
            goto L_0x00e5
        L_0x00ac:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = r11.j0()
            if (r7 != r10) goto L_0x0058
            int r7 = r11.D
            if (r7 < 0) goto L_0x0058
            int r7 = r11.C
            if (r7 < 0) goto L_0x0058
            int r7 = r11.l0()
            if (r7 == r9) goto L_0x00cc
            int r7 = r11.x
            if (r7 != 0) goto L_0x0058
            float r7 = r11.A()
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x0058
        L_0x00cc:
            boolean r7 = r11.D0()
            if (r7 != 0) goto L_0x0058
            boolean r7 = r11.E0()
            if (r7 != 0) goto L_0x0058
            if (r14 == 0) goto L_0x0058
            boolean r7 = r11.D0()
            if (r7 != 0) goto L_0x0058
            i(r12, r0, r1, r11)
            goto L_0x0058
        L_0x00e5:
            boolean r10 = r11.F0()
            if (r10 == 0) goto L_0x00ed
            goto L_0x0058
        L_0x00ed:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r11.R
            if (r7 != r10) goto L_0x0109
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r11.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r13.f4183f
            if (r13 != 0) goto L_0x0109
            int r7 = r10.g()
            int r7 = r7 + r5
            int r10 = r11.D()
            int r10 = r10 + r7
            r11.t1(r7, r10)
        L_0x0104:
            k(r12, r11, r1)
            goto L_0x0058
        L_0x0109:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r11.T
            if (r7 != r13) goto L_0x0121
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r10.f4183f
            if (r7 != 0) goto L_0x0121
            int r7 = r13.g()
            int r7 = r5 - r7
            int r10 = r11.D()
            int r10 = r7 - r10
            r11.t1(r10, r7)
            goto L_0x0104
        L_0x0121:
            if (r14 == 0) goto L_0x0058
            boolean r7 = r11.D0()
            if (r7 != 0) goto L_0x0058
            h(r12, r1, r11)
            goto L_0x0058
        L_0x012e:
            boolean r2 = r0 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r2 == 0) goto L_0x0133
            return
        L_0x0133:
            java.util.HashSet r2 = r4.e()
            if (r2 == 0) goto L_0x021d
            boolean r2 = r4.o()
            if (r2 == 0) goto L_0x021d
            java.util.HashSet r2 = r4.e()
            java.util.Iterator r2 = r2.iterator()
        L_0x0147:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x021d
            java.lang.Object r4 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r4
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r4.f4181d
            int r7 = r16 + 1
            boolean r10 = a(r7, r5)
            boolean r11 = r5.F0()
            if (r11 == 0) goto L_0x016d
            if (r10 == 0) goto L_0x016d
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r11 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r11.<init>()
            int r12 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f4248k
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.R2(r7, r5, r1, r11, r12)
        L_0x016d:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r5.R
            if (r4 != r11) goto L_0x017d
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r5.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r11.f4183f
            if (r11 == 0) goto L_0x017d
            boolean r11 = r11.o()
            if (r11 != 0) goto L_0x018d
        L_0x017d:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r5.T
            if (r4 != r11) goto L_0x018f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r5.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r11.f4183f
            if (r11 == 0) goto L_0x018f
            boolean r11 = r11.o()
            if (r11 == 0) goto L_0x018f
        L_0x018d:
            r11 = 1
            goto L_0x0190
        L_0x018f:
            r11 = 0
        L_0x0190:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = r5.j0()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r12 != r13) goto L_0x01d4
            if (r10 == 0) goto L_0x019b
            goto L_0x01d4
        L_0x019b:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = r5.j0()
            if (r4 != r13) goto L_0x0147
            int r4 = r5.D
            if (r4 < 0) goto L_0x0147
            int r4 = r5.C
            if (r4 < 0) goto L_0x0147
            int r4 = r5.l0()
            if (r4 == r9) goto L_0x01bb
            int r4 = r5.x
            if (r4 != 0) goto L_0x0147
            float r4 = r5.A()
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 != 0) goto L_0x0147
        L_0x01bb:
            boolean r4 = r5.D0()
            if (r4 != 0) goto L_0x0147
            boolean r4 = r5.E0()
            if (r4 != 0) goto L_0x0147
            if (r11 == 0) goto L_0x0147
            boolean r4 = r5.D0()
            if (r4 != 0) goto L_0x0147
            i(r7, r0, r1, r5)
            goto L_0x0147
        L_0x01d4:
            boolean r10 = r5.F0()
            if (r10 == 0) goto L_0x01dc
            goto L_0x0147
        L_0x01dc:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r5.R
            if (r4 != r10) goto L_0x01f8
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r5.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r12.f4183f
            if (r12 != 0) goto L_0x01f8
            int r4 = r10.g()
            int r4 = r4 + r6
            int r10 = r5.D()
            int r10 = r10 + r4
            r5.t1(r4, r10)
        L_0x01f3:
            k(r7, r5, r1)
            goto L_0x0147
        L_0x01f8:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r5.T
            if (r4 != r12) goto L_0x0210
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r10.f4183f
            if (r4 != 0) goto L_0x0210
            int r4 = r12.g()
            int r4 = r6 - r4
            int r10 = r5.D()
            int r10 = r4 - r10
            r5.t1(r10, r4)
            goto L_0x01f3
        L_0x0210:
            if (r11 == 0) goto L_0x0147
            boolean r4 = r5.D0()
            if (r4 != 0) goto L_0x0147
            h(r7, r1, r5)
            goto L_0x0147
        L_0x021d:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.r(r2)
            java.util.HashSet r4 = r2.e()
            if (r4 == 0) goto L_0x0285
            boolean r4 = r2.o()
            if (r4 == 0) goto L_0x0285
            int r4 = r2.f()
            java.util.HashSet r2 = r2.e()
            java.util.Iterator r2 = r2.iterator()
        L_0x023b:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0285
            java.lang.Object r5 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r5.f4181d
            int r7 = r16 + 1
            boolean r8 = a(r7, r6)
            boolean r9 = r6.F0()
            if (r9 == 0) goto L_0x0261
            if (r8 == 0) goto L_0x0261
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r9 = new androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure
            r9.<init>()
            int r10 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f4248k
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.R2(r7, r6, r1, r9, r10)
        L_0x0261:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = r6.j0()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r9 != r10) goto L_0x026b
            if (r8 == 0) goto L_0x023b
        L_0x026b:
            boolean r8 = r6.F0()
            if (r8 == 0) goto L_0x0272
            goto L_0x023b
        L_0x0272:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r6.U
            if (r5 != r8) goto L_0x023b
            int r5 = r5.g()
            int r5 = r5 + r4
            r6.o1(r5)
            k(r7, r6, r1)     // Catch:{ all -> 0x0282 }
            goto L_0x023b
        L_0x0282:
            r0 = move-exception
            r1 = r0
            throw r1
        L_0x0285:
            r17.O0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Direct.k(int, androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer):void");
    }
}
