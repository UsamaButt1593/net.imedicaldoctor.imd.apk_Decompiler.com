package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;

public class Grouping {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f4292a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f4293b = false;

    public static WidgetGroup a(ConstraintWidget constraintWidget, int i2, ArrayList<WidgetGroup> arrayList, WidgetGroup widgetGroup) {
        ConstraintAnchor constraintAnchor;
        int l2;
        int i3 = i2 == 0 ? constraintWidget.S0 : constraintWidget.T0;
        int i4 = 0;
        if (i3 != -1 && (widgetGroup == null || i3 != widgetGroup.f4313b)) {
            int i5 = 0;
            while (true) {
                if (i5 >= arrayList.size()) {
                    break;
                }
                WidgetGroup widgetGroup2 = arrayList.get(i5);
                if (widgetGroup2.f() == i3) {
                    if (widgetGroup != null) {
                        widgetGroup.m(i2, widgetGroup2);
                        arrayList.remove(widgetGroup);
                    }
                    widgetGroup = widgetGroup2;
                } else {
                    i5++;
                }
            }
        } else if (i3 != -1) {
            return widgetGroup;
        }
        if (widgetGroup == null) {
            if ((constraintWidget instanceof HelperWidget) && (l2 = ((HelperWidget) constraintWidget).l2(i2)) != -1) {
                int i6 = 0;
                while (true) {
                    if (i6 >= arrayList.size()) {
                        break;
                    }
                    WidgetGroup widgetGroup3 = arrayList.get(i6);
                    if (widgetGroup3.f() == l2) {
                        widgetGroup = widgetGroup3;
                        break;
                    }
                    i6++;
                }
            }
            if (widgetGroup == null) {
                widgetGroup = new WidgetGroup(i2);
            }
            arrayList.add(widgetGroup);
        }
        if (widgetGroup.a(constraintWidget)) {
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                ConstraintAnchor l22 = guideline.l2();
                if (guideline.m2() == 0) {
                    i4 = 1;
                }
                l22.d(i4, arrayList, widgetGroup);
            }
            int f2 = widgetGroup.f();
            if (i2 == 0) {
                constraintWidget.S0 = f2;
                constraintWidget.Q.d(i2, arrayList, widgetGroup);
                constraintAnchor = constraintWidget.S;
            } else {
                constraintWidget.T0 = f2;
                constraintWidget.R.d(i2, arrayList, widgetGroup);
                constraintWidget.U.d(i2, arrayList, widgetGroup);
                constraintAnchor = constraintWidget.T;
            }
            constraintAnchor.d(i2, arrayList, widgetGroup);
            constraintWidget.X.d(i2, arrayList, widgetGroup);
        }
        return widgetGroup;
    }

    private static WidgetGroup b(ArrayList<WidgetGroup> arrayList, int i2) {
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            WidgetGroup widgetGroup = arrayList.get(i3);
            if (i2 == widgetGroup.f4313b) {
                return widgetGroup;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:177:0x0359  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0395  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x039a A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r16, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer r17) {
        /*
            r0 = r16
            java.util.ArrayList r1 = r16.l2()
            int r2 = r1.size()
            r3 = 0
            r4 = 0
        L_0x000c:
            if (r4 >= r2) goto L_0x0033
            java.lang.Object r5 = r1.get(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = r16.H()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = r16.j0()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = r5.H()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = r5.j0()
            boolean r6 = d(r6, r7, r8, r9)
            if (r6 != 0) goto L_0x002b
            return r3
        L_0x002b:
            boolean r5 = r5 instanceof androidx.constraintlayout.core.widgets.Flow
            if (r5 == 0) goto L_0x0030
            return r3
        L_0x0030:
            int r4 = r4 + 1
            goto L_0x000c
        L_0x0033:
            androidx.constraintlayout.core.Metrics r4 = r0.G1
            if (r4 == 0) goto L_0x003e
            long r5 = r4.Q
            r7 = 1
            long r5 = r5 + r7
            r4.Q = r5
        L_0x003e:
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x0045:
            if (r5 >= r2) goto L_0x011b
            java.lang.Object r13 = r1.get(r5)
            androidx.constraintlayout.core.widgets.ConstraintWidget r13 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r13
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = r16.H()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = r16.j0()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = r13.H()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = r13.j0()
            boolean r4 = d(r14, r15, r4, r12)
            if (r4 != 0) goto L_0x006d
            androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure r4 = r0.f2
            int r12 = androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure.f4248k
            r14 = r17
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.R2(r3, r13, r14, r4, r12)
            goto L_0x006f
        L_0x006d:
            r14 = r17
        L_0x006f:
            boolean r4 = r13 instanceof androidx.constraintlayout.core.widgets.Guideline
            if (r4 == 0) goto L_0x0097
            r12 = r13
            androidx.constraintlayout.core.widgets.Guideline r12 = (androidx.constraintlayout.core.widgets.Guideline) r12
            int r15 = r12.m2()
            if (r15 != 0) goto L_0x0086
            if (r8 != 0) goto L_0x0083
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
        L_0x0083:
            r8.add(r12)
        L_0x0086:
            int r15 = r12.m2()
            r3 = 1
            if (r15 != r3) goto L_0x0097
            if (r6 != 0) goto L_0x0094
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
        L_0x0094:
            r6.add(r12)
        L_0x0097:
            boolean r3 = r13 instanceof androidx.constraintlayout.core.widgets.HelperWidget
            if (r3 == 0) goto L_0x00d8
            boolean r3 = r13 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r3 == 0) goto L_0x00c1
            r3 = r13
            androidx.constraintlayout.core.widgets.Barrier r3 = (androidx.constraintlayout.core.widgets.Barrier) r3
            int r12 = r3.r2()
            if (r12 != 0) goto L_0x00b2
            if (r7 != 0) goto L_0x00af
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L_0x00af:
            r7.add(r3)
        L_0x00b2:
            int r12 = r3.r2()
            r15 = 1
            if (r12 != r15) goto L_0x00d8
            if (r9 != 0) goto L_0x00d5
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            goto L_0x00d5
        L_0x00c1:
            r3 = r13
            androidx.constraintlayout.core.widgets.HelperWidget r3 = (androidx.constraintlayout.core.widgets.HelperWidget) r3
            if (r7 != 0) goto L_0x00cb
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L_0x00cb:
            r7.add(r3)
            if (r9 != 0) goto L_0x00d5
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
        L_0x00d5:
            r9.add(r3)
        L_0x00d8:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r13.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f4183f
            if (r3 != 0) goto L_0x00f4
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r13.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f4183f
            if (r3 != 0) goto L_0x00f4
            if (r4 != 0) goto L_0x00f4
            boolean r3 = r13 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r3 != 0) goto L_0x00f4
            if (r10 != 0) goto L_0x00f1
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
        L_0x00f1:
            r10.add(r13)
        L_0x00f4:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r13.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f4183f
            if (r3 != 0) goto L_0x0116
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r13.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f4183f
            if (r3 != 0) goto L_0x0116
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r13.U
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f4183f
            if (r3 != 0) goto L_0x0116
            if (r4 != 0) goto L_0x0116
            boolean r3 = r13 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r3 != 0) goto L_0x0116
            if (r11 != 0) goto L_0x0113
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
        L_0x0113:
            r11.add(r13)
        L_0x0116:
            int r5 = r5 + 1
            r3 = 0
            goto L_0x0045
        L_0x011b:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            if (r6 == 0) goto L_0x0138
            java.util.Iterator r4 = r6.iterator()
        L_0x0126:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0138
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.Guideline r5 = (androidx.constraintlayout.core.widgets.Guideline) r5
            r6 = 0
            r12 = 0
            a(r5, r6, r3, r12)
            goto L_0x0126
        L_0x0138:
            r6 = 0
            r12 = 0
            if (r7 == 0) goto L_0x0159
            java.util.Iterator r4 = r7.iterator()
        L_0x0140:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0159
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.HelperWidget r5 = (androidx.constraintlayout.core.widgets.HelperWidget) r5
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r7 = a(r5, r6, r3, r12)
            r5.k2(r3, r6, r7)
            r7.c(r3)
            r6 = 0
            r12 = 0
            goto L_0x0140
        L_0x0159:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.r(r4)
            java.util.HashSet r5 = r4.e()
            if (r5 == 0) goto L_0x0181
            java.util.HashSet r4 = r4.e()
            java.util.Iterator r4 = r4.iterator()
        L_0x016d:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0181
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.f4181d
            r6 = 0
            r7 = 0
            a(r5, r6, r3, r7)
            goto L_0x016d
        L_0x0181:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.r(r4)
            java.util.HashSet r5 = r4.e()
            if (r5 == 0) goto L_0x01a9
            java.util.HashSet r4 = r4.e()
            java.util.Iterator r4 = r4.iterator()
        L_0x0195:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01a9
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.f4181d
            r6 = 0
            r7 = 0
            a(r5, r6, r3, r7)
            goto L_0x0195
        L_0x01a9:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.r(r4)
            java.util.HashSet r5 = r4.e()
            if (r5 == 0) goto L_0x01d1
            java.util.HashSet r4 = r4.e()
            java.util.Iterator r4 = r4.iterator()
        L_0x01bd:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01d1
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.f4181d
            r6 = 0
            r7 = 0
            a(r5, r6, r3, r7)
            goto L_0x01bd
        L_0x01d1:
            r6 = 0
            r7 = 0
            if (r10 == 0) goto L_0x01e9
            java.util.Iterator r4 = r10.iterator()
        L_0x01d9:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01e9
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            a(r5, r6, r3, r7)
            goto L_0x01d9
        L_0x01e9:
            if (r8 == 0) goto L_0x0200
            java.util.Iterator r4 = r8.iterator()
        L_0x01ef:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0200
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.Guideline r5 = (androidx.constraintlayout.core.widgets.Guideline) r5
            r6 = 1
            a(r5, r6, r3, r7)
            goto L_0x01ef
        L_0x0200:
            r6 = 1
            if (r9 == 0) goto L_0x0220
            java.util.Iterator r4 = r9.iterator()
        L_0x0207:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0220
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.HelperWidget r5 = (androidx.constraintlayout.core.widgets.HelperWidget) r5
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r8 = a(r5, r6, r3, r7)
            r5.k2(r3, r6, r8)
            r8.c(r3)
            r6 = 1
            r7 = 0
            goto L_0x0207
        L_0x0220:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.r(r4)
            java.util.HashSet r5 = r4.e()
            if (r5 == 0) goto L_0x0248
            java.util.HashSet r4 = r4.e()
            java.util.Iterator r4 = r4.iterator()
        L_0x0234:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0248
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.f4181d
            r6 = 0
            r7 = 1
            a(r5, r7, r3, r6)
            goto L_0x0234
        L_0x0248:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.r(r4)
            java.util.HashSet r5 = r4.e()
            if (r5 == 0) goto L_0x0270
            java.util.HashSet r4 = r4.e()
            java.util.Iterator r4 = r4.iterator()
        L_0x025c:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0270
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.f4181d
            r6 = 0
            r7 = 1
            a(r5, r7, r3, r6)
            goto L_0x025c
        L_0x0270:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.r(r4)
            java.util.HashSet r5 = r4.e()
            if (r5 == 0) goto L_0x0298
            java.util.HashSet r4 = r4.e()
            java.util.Iterator r4 = r4.iterator()
        L_0x0284:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0298
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.f4181d
            r6 = 0
            r7 = 1
            a(r5, r7, r3, r6)
            goto L_0x0284
        L_0x0298:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.r(r4)
            java.util.HashSet r5 = r4.e()
            if (r5 == 0) goto L_0x02c0
            java.util.HashSet r4 = r4.e()
            java.util.Iterator r4 = r4.iterator()
        L_0x02ac:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x02c0
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.f4181d
            r6 = 1
            r12 = 0
            a(r5, r6, r3, r12)
            goto L_0x02ac
        L_0x02c0:
            r6 = 1
            r12 = 0
            if (r11 == 0) goto L_0x02d8
            java.util.Iterator r4 = r11.iterator()
        L_0x02c8:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x02d8
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            a(r5, r6, r3, r12)
            goto L_0x02c8
        L_0x02d8:
            r4 = 0
        L_0x02d9:
            if (r4 >= r2) goto L_0x0305
            java.lang.Object r5 = r1.get(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            boolean r6 = r5.Q0()
            if (r6 == 0) goto L_0x0302
            int r6 = r5.S0
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r6 = b(r3, r6)
            int r5 = r5.T0
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r5 = b(r3, r5)
            if (r6 == 0) goto L_0x0302
            if (r5 == 0) goto L_0x0302
            r7 = 0
            r6.m(r7, r5)
            r7 = 2
            r5.o(r7)
            r3.remove(r6)
        L_0x0302:
            int r4 = r4 + 1
            goto L_0x02d9
        L_0x0305:
            int r1 = r3.size()
            r2 = 1
            if (r1 > r2) goto L_0x030e
            r1 = 0
            return r1
        L_0x030e:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = r16.H()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 != r2) goto L_0x0350
            java.util.Iterator r1 = r3.iterator()
            r2 = r12
            r6 = 0
        L_0x031c:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0341
            java.lang.Object r4 = r1.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r4 = (androidx.constraintlayout.core.widgets.analyzer.WidgetGroup) r4
            int r5 = r4.g()
            r7 = 1
            if (r5 != r7) goto L_0x0330
            goto L_0x031c
        L_0x0330:
            r5 = 0
            r4.n(r5)
            androidx.constraintlayout.core.LinearSystem r7 = r16.I2()
            int r7 = r4.l(r7, r5)
            if (r7 <= r6) goto L_0x031c
            r2 = r4
            r6 = r7
            goto L_0x031c
        L_0x0341:
            if (r2 == 0) goto L_0x0350
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0.D1(r1)
            r0.c2(r6)
            r1 = 1
            r2.n(r1)
            goto L_0x0351
        L_0x0350:
            r2 = r12
        L_0x0351:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = r16.j0()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 != r4) goto L_0x0395
            java.util.Iterator r1 = r3.iterator()
            r3 = r12
            r6 = 0
        L_0x035f:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0384
            java.lang.Object r4 = r1.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetGroup r4 = (androidx.constraintlayout.core.widgets.analyzer.WidgetGroup) r4
            int r5 = r4.g()
            if (r5 != 0) goto L_0x0372
            goto L_0x035f
        L_0x0372:
            r5 = 0
            r4.n(r5)
            androidx.constraintlayout.core.LinearSystem r7 = r16.I2()
            r8 = 1
            int r7 = r4.l(r7, r8)
            if (r7 <= r6) goto L_0x035f
            r3 = r4
            r6 = r7
            goto L_0x035f
        L_0x0384:
            r5 = 0
            r8 = 1
            if (r3 == 0) goto L_0x0397
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0.Y1(r1)
            r0.y1(r6)
            r3.n(r8)
            r4 = r3
            goto L_0x0398
        L_0x0395:
            r5 = 0
            r8 = 1
        L_0x0397:
            r4 = r12
        L_0x0398:
            if (r2 != 0) goto L_0x039f
            if (r4 == 0) goto L_0x039d
            goto L_0x039f
        L_0x039d:
            r3 = 0
            goto L_0x03a0
        L_0x039f:
            r3 = 1
        L_0x03a0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Grouping.c(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measurer):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean d(androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r5, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r6, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r7, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r8) {
        /*
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r1 = 1
            r2 = 0
            if (r7 == r0) goto L_0x0013
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r7 == r3) goto L_0x0013
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r7 != r4) goto L_0x0011
            if (r5 == r3) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r5 = 0
            goto L_0x0014
        L_0x0013:
            r5 = 1
        L_0x0014:
            if (r8 == r0) goto L_0x0023
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r8 == r7) goto L_0x0023
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r8 != r0) goto L_0x0021
            if (r6 == r7) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r6 = 0
            goto L_0x0024
        L_0x0023:
            r6 = 1
        L_0x0024:
            if (r5 != 0) goto L_0x002a
            if (r6 == 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            return r2
        L_0x002a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Grouping.d(androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour):boolean");
    }
}
