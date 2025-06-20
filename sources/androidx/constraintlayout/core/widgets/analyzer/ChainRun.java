package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

public class ChainRun extends WidgetRun {

    /* renamed from: k  reason: collision with root package name */
    ArrayList<WidgetRun> f4261k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    private int f4262l;

    public ChainRun(ConstraintWidget constraintWidget, int i2) {
        super(constraintWidget);
        this.f4331f = i2;
        u();
    }

    private void u() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2 = this.f4327b;
        do {
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget2.V(this.f4331f);
        } while (constraintWidget2 != null);
        this.f4327b = constraintWidget;
        this.f4261k.add(constraintWidget.a0(this.f4331f));
        ConstraintWidget R = constraintWidget.R(this.f4331f);
        while (R != null) {
            this.f4261k.add(R.a0(this.f4331f));
            R = R.R(this.f4331f);
        }
        Iterator<WidgetRun> it2 = this.f4261k.iterator();
        while (it2.hasNext()) {
            WidgetRun next = it2.next();
            int i2 = this.f4331f;
            if (i2 == 0) {
                next.f4327b.f4190c = this;
            } else if (i2 == 1) {
                next.f4327b.f4191d = this;
            }
        }
        if (this.f4331f == 0 && ((ConstraintWidgetContainer) this.f4327b.U()).O2() && this.f4261k.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.f4261k;
            this.f4327b = arrayList.get(arrayList.size() - 1).f4327b;
        }
        this.f4262l = this.f4331f == 0 ? this.f4327b.G() : this.f4327b.i0();
    }

    private ConstraintWidget v() {
        for (int i2 = 0; i2 < this.f4261k.size(); i2++) {
            WidgetRun widgetRun = this.f4261k.get(i2);
            if (widgetRun.f4327b.l0() != 8) {
                return widgetRun.f4327b;
            }
        }
        return null;
    }

    private ConstraintWidget w() {
        for (int size = this.f4261k.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.f4261k.get(size);
            if (widgetRun.f4327b.l0() != 8) {
                return widgetRun.f4327b;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.constraintlayout.core.widgets.analyzer.Dependency r27) {
        /*
            r26 = this;
            r0 = r26
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r0.f4333h
            boolean r1 = r1.f4282j
            if (r1 == 0) goto L_0x03f4
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r0.f4334i
            boolean r1 = r1.f4282j
            if (r1 != 0) goto L_0x0010
            goto L_0x03f4
        L_0x0010:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f4327b
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.U()
            boolean r2 = r1 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r2 == 0) goto L_0x0021
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r1
            boolean r1 = r1.O2()
            goto L_0x0022
        L_0x0021:
            r1 = 0
        L_0x0022:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r0.f4334i
            int r2 = r2.f4279g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r0.f4333h
            int r4 = r4.f4279g
            int r2 = r2 - r4
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r4 = r0.f4261k
            int r4 = r4.size()
            r5 = 0
        L_0x0032:
            r6 = -1
            r7 = 8
            if (r5 >= r4) goto L_0x004a
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r8 = r0.f4261k
            java.lang.Object r8 = r8.get(r5)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r8 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r8
            androidx.constraintlayout.core.widgets.ConstraintWidget r8 = r8.f4327b
            int r8 = r8.l0()
            if (r8 != r7) goto L_0x004b
            int r5 = r5 + 1
            goto L_0x0032
        L_0x004a:
            r5 = -1
        L_0x004b:
            int r8 = r4 + -1
            r9 = r8
        L_0x004e:
            if (r9 < 0) goto L_0x0064
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r10 = r0.f4261k
            java.lang.Object r10 = r10.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r10 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r10
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r10.f4327b
            int r10 = r10.l0()
            if (r10 != r7) goto L_0x0063
            int r9 = r9 + -1
            goto L_0x004e
        L_0x0063:
            r6 = r9
        L_0x0064:
            r9 = 0
        L_0x0065:
            r11 = 2
            if (r9 >= r11) goto L_0x0109
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x006f:
            if (r13 >= r4) goto L_0x00fb
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r3 = r0.f4261k
            java.lang.Object r3 = r3.get(r13)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r3 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r3.f4327b
            int r11 = r11.l0()
            if (r11 != r7) goto L_0x0083
            goto L_0x00f4
        L_0x0083:
            int r16 = r16 + 1
            if (r13 <= 0) goto L_0x008e
            if (r13 < r5) goto L_0x008e
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r11 = r3.f4333h
            int r11 = r11.f4278f
            int r14 = r14 + r11
        L_0x008e:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r11 = r3.f4330e
            int r7 = r11.f4279g
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = r3.f4329d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r10 == r12) goto L_0x009a
            r10 = 1
            goto L_0x009b
        L_0x009a:
            r10 = 0
        L_0x009b:
            if (r10 == 0) goto L_0x00bd
            int r11 = r0.f4331f
            if (r11 != 0) goto L_0x00ac
            androidx.constraintlayout.core.widgets.ConstraintWidget r12 = r3.f4327b
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r12 = r12.f4192e
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r12 = r12.f4330e
            boolean r12 = r12.f4282j
            if (r12 != 0) goto L_0x00ac
            return
        L_0x00ac:
            r12 = 1
            if (r11 != r12) goto L_0x00ba
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r3.f4327b
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r11 = r11.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r11 = r11.f4330e
            boolean r11 = r11.f4282j
            if (r11 != 0) goto L_0x00ba
            return
        L_0x00ba:
            r19 = r7
            goto L_0x00d3
        L_0x00bd:
            r19 = r7
            r12 = 1
            int r7 = r3.f4326a
            if (r7 != r12) goto L_0x00cc
            if (r9 != 0) goto L_0x00cc
            int r7 = r11.f4285m
            int r15 = r15 + 1
        L_0x00ca:
            r10 = 1
            goto L_0x00d5
        L_0x00cc:
            boolean r7 = r11.f4282j
            if (r7 == 0) goto L_0x00d3
            r7 = r19
            goto L_0x00ca
        L_0x00d3:
            r7 = r19
        L_0x00d5:
            if (r10 != 0) goto L_0x00e9
            int r15 = r15 + 1
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r3.f4327b
            float[] r7 = r7.N0
            int r10 = r0.f4331f
            r7 = r7[r10]
            r10 = 0
            int r11 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r11 < 0) goto L_0x00ea
            float r17 = r17 + r7
            goto L_0x00ea
        L_0x00e9:
            int r14 = r14 + r7
        L_0x00ea:
            if (r13 >= r8) goto L_0x00f4
            if (r13 >= r6) goto L_0x00f4
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r3.f4334i
            int r3 = r3.f4278f
            int r3 = -r3
            int r14 = r14 + r3
        L_0x00f4:
            int r13 = r13 + 1
            r7 = 8
            r11 = 2
            goto L_0x006f
        L_0x00fb:
            if (r14 < r2) goto L_0x0106
            if (r15 != 0) goto L_0x0100
            goto L_0x0106
        L_0x0100:
            int r9 = r9 + 1
            r7 = 8
            goto L_0x0065
        L_0x0106:
            r3 = r16
            goto L_0x010e
        L_0x0109:
            r3 = 0
            r14 = 0
            r15 = 0
            r17 = 0
        L_0x010e:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r0.f4333h
            int r7 = r7.f4279g
            if (r1 == 0) goto L_0x0118
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r0.f4334i
            int r7 = r7.f4279g
        L_0x0118:
            r9 = 1056964608(0x3f000000, float:0.5)
            if (r14 <= r2) goto L_0x0129
            r10 = 1073741824(0x40000000, float:2.0)
            int r11 = r14 - r2
            float r11 = (float) r11
            float r11 = r11 / r10
            float r11 = r11 + r9
            int r10 = (int) r11
            if (r1 == 0) goto L_0x0128
            int r7 = r7 + r10
            goto L_0x0129
        L_0x0128:
            int r7 = r7 - r10
        L_0x0129:
            if (r15 <= 0) goto L_0x021e
            int r10 = r2 - r14
            float r10 = (float) r10
            float r11 = (float) r15
            float r11 = r10 / r11
            float r11 = r11 + r9
            int r11 = (int) r11
            r12 = 0
            r13 = 0
        L_0x0135:
            if (r12 >= r4) goto L_0x01d2
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r9 = r0.f4261k
            java.lang.Object r9 = r9.get(r12)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r9 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r9
            r19 = r11
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r9.f4327b
            int r11 = r11.l0()
            r20 = r14
            r14 = 8
            if (r11 != r14) goto L_0x0157
        L_0x014d:
            r23 = r1
            r24 = r3
            r21 = r7
            r22 = r10
            goto L_0x01c0
        L_0x0157:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r9.f4329d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 != r14) goto L_0x014d
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r11 = r9.f4330e
            boolean r14 = r11.f4282j
            if (r14 != 0) goto L_0x014d
            r14 = 0
            int r18 = (r17 > r14 ? 1 : (r17 == r14 ? 0 : -1))
            if (r18 <= 0) goto L_0x017b
            androidx.constraintlayout.core.widgets.ConstraintWidget r14 = r9.f4327b
            float[] r14 = r14.N0
            r21 = r7
            int r7 = r0.f4331f
            r7 = r14[r7]
            float r7 = r7 * r10
            float r7 = r7 / r17
            r14 = 1056964608(0x3f000000, float:0.5)
            float r7 = r7 + r14
            int r7 = (int) r7
            goto L_0x017f
        L_0x017b:
            r21 = r7
            r7 = r19
        L_0x017f:
            int r14 = r0.f4331f
            if (r14 != 0) goto L_0x018e
            androidx.constraintlayout.core.widgets.ConstraintWidget r14 = r9.f4327b
            r22 = r10
            int r10 = r14.A
            int r14 = r14.z
            r23 = r1
            goto L_0x019d
        L_0x018e:
            r22 = r10
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r9.f4327b
            int r14 = r10.D
            int r10 = r10.C
            r23 = r1
            r25 = r14
            r14 = r10
            r10 = r25
        L_0x019d:
            int r1 = r9.f4326a
            r24 = r3
            r3 = 1
            if (r1 != r3) goto L_0x01ab
            int r1 = r11.f4285m
            int r1 = java.lang.Math.min(r7, r1)
            goto L_0x01ac
        L_0x01ab:
            r1 = r7
        L_0x01ac:
            int r1 = java.lang.Math.max(r14, r1)
            if (r10 <= 0) goto L_0x01b6
            int r1 = java.lang.Math.min(r10, r1)
        L_0x01b6:
            if (r1 == r7) goto L_0x01bb
            int r13 = r13 + 1
            r7 = r1
        L_0x01bb:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r9.f4330e
            r1.e(r7)
        L_0x01c0:
            int r12 = r12 + 1
            r11 = r19
            r14 = r20
            r7 = r21
            r10 = r22
            r1 = r23
            r3 = r24
            r9 = 1056964608(0x3f000000, float:0.5)
            goto L_0x0135
        L_0x01d2:
            r23 = r1
            r24 = r3
            r21 = r7
            r20 = r14
            if (r13 <= 0) goto L_0x020f
            int r15 = r15 - r13
            r1 = 0
            r14 = 0
        L_0x01df:
            if (r1 >= r4) goto L_0x0211
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r3 = r0.f4261k
            java.lang.Object r3 = r3.get(r1)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r3 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r3.f4327b
            int r7 = r7.l0()
            r9 = 8
            if (r7 != r9) goto L_0x01f4
            goto L_0x020c
        L_0x01f4:
            if (r1 <= 0) goto L_0x01fd
            if (r1 < r5) goto L_0x01fd
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r3.f4333h
            int r7 = r7.f4278f
            int r14 = r14 + r7
        L_0x01fd:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r7 = r3.f4330e
            int r7 = r7.f4279g
            int r14 = r14 + r7
            if (r1 >= r8) goto L_0x020c
            if (r1 >= r6) goto L_0x020c
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r3.f4334i
            int r3 = r3.f4278f
            int r3 = -r3
            int r14 = r14 + r3
        L_0x020c:
            int r1 = r1 + 1
            goto L_0x01df
        L_0x020f:
            r14 = r20
        L_0x0211:
            int r1 = r0.f4262l
            r3 = 2
            if (r1 != r3) goto L_0x021c
            if (r13 != 0) goto L_0x021c
            r1 = 0
            r0.f4262l = r1
            goto L_0x0228
        L_0x021c:
            r1 = 0
            goto L_0x0228
        L_0x021e:
            r23 = r1
            r24 = r3
            r21 = r7
            r20 = r14
            r1 = 0
            r3 = 2
        L_0x0228:
            if (r14 <= r2) goto L_0x022c
            r0.f4262l = r3
        L_0x022c:
            if (r24 <= 0) goto L_0x0234
            if (r15 != 0) goto L_0x0234
            if (r5 != r6) goto L_0x0234
            r0.f4262l = r3
        L_0x0234:
            int r3 = r0.f4262l
            r7 = 1
            r9 = r24
            if (r3 != r7) goto L_0x02ca
            if (r9 <= r7) goto L_0x0242
            int r2 = r2 - r14
            int r3 = r9 + -1
            int r2 = r2 / r3
            goto L_0x0249
        L_0x0242:
            if (r9 != r7) goto L_0x0248
            int r2 = r2 - r14
            r3 = 2
            int r2 = r2 / r3
            goto L_0x0249
        L_0x0248:
            r2 = 0
        L_0x0249:
            if (r15 <= 0) goto L_0x024c
            r2 = 0
        L_0x024c:
            r7 = r21
            r3 = 0
        L_0x024f:
            if (r3 >= r4) goto L_0x03f4
            if (r23 == 0) goto L_0x0258
            int r1 = r3 + 1
            int r1 = r4 - r1
            goto L_0x0259
        L_0x0258:
            r1 = r3
        L_0x0259:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r9 = r0.f4261k
            java.lang.Object r1 = r9.get(r1)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r1 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r1
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r1.f4327b
            int r9 = r9.l0()
            r10 = 8
            if (r9 != r10) goto L_0x0276
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f4333h
            r9.e(r7)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r1.f4334i
            r1.e(r7)
            goto L_0x02c7
        L_0x0276:
            if (r3 <= 0) goto L_0x027d
            if (r23 == 0) goto L_0x027c
            int r7 = r7 - r2
            goto L_0x027d
        L_0x027c:
            int r7 = r7 + r2
        L_0x027d:
            if (r3 <= 0) goto L_0x028a
            if (r3 < r5) goto L_0x028a
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f4333h
            int r9 = r9.f4278f
            if (r23 == 0) goto L_0x0289
            int r7 = r7 - r9
            goto L_0x028a
        L_0x0289:
            int r7 = r7 + r9
        L_0x028a:
            if (r23 == 0) goto L_0x0292
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f4334i
        L_0x028e:
            r9.e(r7)
            goto L_0x0295
        L_0x0292:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f4333h
            goto L_0x028e
        L_0x0295:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r9 = r1.f4330e
            int r10 = r9.f4279g
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r1.f4329d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 != r12) goto L_0x02a6
            int r11 = r1.f4326a
            r12 = 1
            if (r11 != r12) goto L_0x02a6
            int r10 = r9.f4285m
        L_0x02a6:
            if (r23 == 0) goto L_0x02aa
            int r7 = r7 - r10
            goto L_0x02ab
        L_0x02aa:
            int r7 = r7 + r10
        L_0x02ab:
            if (r23 == 0) goto L_0x02b4
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f4333h
        L_0x02af:
            r9.e(r7)
            r9 = 1
            goto L_0x02b7
        L_0x02b4:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f4334i
            goto L_0x02af
        L_0x02b7:
            r1.f4332g = r9
            if (r3 >= r8) goto L_0x02c7
            if (r3 >= r6) goto L_0x02c7
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r1.f4334i
            int r1 = r1.f4278f
            int r1 = -r1
            if (r23 == 0) goto L_0x02c6
            int r7 = r7 - r1
            goto L_0x02c7
        L_0x02c6:
            int r7 = r7 + r1
        L_0x02c7:
            int r3 = r3 + 1
            goto L_0x024f
        L_0x02ca:
            if (r3 != 0) goto L_0x0351
            int r2 = r2 - r14
            r3 = 1
            int r7 = r9 + 1
            int r2 = r2 / r7
            if (r15 <= 0) goto L_0x02d4
            r2 = 0
        L_0x02d4:
            r7 = r21
            r3 = 0
        L_0x02d7:
            if (r3 >= r4) goto L_0x03f4
            if (r23 == 0) goto L_0x02e0
            int r1 = r3 + 1
            int r1 = r4 - r1
            goto L_0x02e1
        L_0x02e0:
            r1 = r3
        L_0x02e1:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r9 = r0.f4261k
            java.lang.Object r1 = r9.get(r1)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r1 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r1
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r1.f4327b
            int r9 = r9.l0()
            r10 = 8
            if (r9 != r10) goto L_0x02fe
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f4333h
            r9.e(r7)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r1.f4334i
            r1.e(r7)
            goto L_0x034e
        L_0x02fe:
            if (r23 == 0) goto L_0x0302
            int r7 = r7 - r2
            goto L_0x0303
        L_0x0302:
            int r7 = r7 + r2
        L_0x0303:
            if (r3 <= 0) goto L_0x0310
            if (r3 < r5) goto L_0x0310
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f4333h
            int r9 = r9.f4278f
            if (r23 == 0) goto L_0x030f
            int r7 = r7 - r9
            goto L_0x0310
        L_0x030f:
            int r7 = r7 + r9
        L_0x0310:
            if (r23 == 0) goto L_0x0318
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f4334i
        L_0x0314:
            r9.e(r7)
            goto L_0x031b
        L_0x0318:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f4333h
            goto L_0x0314
        L_0x031b:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r9 = r1.f4330e
            int r10 = r9.f4279g
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r1.f4329d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 != r12) goto L_0x0330
            int r11 = r1.f4326a
            r12 = 1
            if (r11 != r12) goto L_0x0330
            int r9 = r9.f4285m
            int r10 = java.lang.Math.min(r10, r9)
        L_0x0330:
            if (r23 == 0) goto L_0x0334
            int r7 = r7 - r10
            goto L_0x0335
        L_0x0334:
            int r7 = r7 + r10
        L_0x0335:
            if (r23 == 0) goto L_0x033d
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f4333h
        L_0x0339:
            r9.e(r7)
            goto L_0x0340
        L_0x033d:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f4334i
            goto L_0x0339
        L_0x0340:
            if (r3 >= r8) goto L_0x034e
            if (r3 >= r6) goto L_0x034e
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r1.f4334i
            int r1 = r1.f4278f
            int r1 = -r1
            if (r23 == 0) goto L_0x034d
            int r7 = r7 - r1
            goto L_0x034e
        L_0x034d:
            int r7 = r7 + r1
        L_0x034e:
            int r3 = r3 + 1
            goto L_0x02d7
        L_0x0351:
            r7 = 2
            if (r3 != r7) goto L_0x03f4
            int r3 = r0.f4331f
            if (r3 != 0) goto L_0x035f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f4327b
            float r3 = r3.E()
            goto L_0x0365
        L_0x035f:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f4327b
            float r3 = r3.g0()
        L_0x0365:
            if (r23 == 0) goto L_0x036b
            r7 = 1065353216(0x3f800000, float:1.0)
            float r3 = r7 - r3
        L_0x036b:
            int r2 = r2 - r14
            float r2 = (float) r2
            float r2 = r2 * r3
            r3 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r3
            int r2 = (int) r2
            if (r2 < 0) goto L_0x0377
            if (r15 <= 0) goto L_0x0378
        L_0x0377:
            r2 = 0
        L_0x0378:
            if (r23 == 0) goto L_0x037d
            int r7 = r21 - r2
            goto L_0x037f
        L_0x037d:
            int r7 = r21 + r2
        L_0x037f:
            r3 = 0
        L_0x0380:
            if (r3 >= r4) goto L_0x03f4
            if (r23 == 0) goto L_0x0389
            int r1 = r3 + 1
            int r1 = r4 - r1
            goto L_0x038a
        L_0x0389:
            r1 = r3
        L_0x038a:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r2 = r0.f4261k
            java.lang.Object r1 = r2.get(r1)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r1 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r1
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r1.f4327b
            int r2 = r2.l0()
            r9 = 8
            if (r2 != r9) goto L_0x03a8
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r1.f4333h
            r2.e(r7)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r1.f4334i
            r1.e(r7)
            r12 = 1
            goto L_0x03f1
        L_0x03a8:
            if (r3 <= 0) goto L_0x03b5
            if (r3 < r5) goto L_0x03b5
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r1.f4333h
            int r2 = r2.f4278f
            if (r23 == 0) goto L_0x03b4
            int r7 = r7 - r2
            goto L_0x03b5
        L_0x03b4:
            int r7 = r7 + r2
        L_0x03b5:
            if (r23 == 0) goto L_0x03bd
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r1.f4334i
        L_0x03b9:
            r2.e(r7)
            goto L_0x03c0
        L_0x03bd:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r1.f4333h
            goto L_0x03b9
        L_0x03c0:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r1.f4330e
            int r10 = r2.f4279g
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r1.f4329d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 != r12) goto L_0x03d2
            int r11 = r1.f4326a
            r12 = 1
            if (r11 != r12) goto L_0x03d3
            int r10 = r2.f4285m
            goto L_0x03d3
        L_0x03d2:
            r12 = 1
        L_0x03d3:
            if (r23 == 0) goto L_0x03d7
            int r7 = r7 - r10
            goto L_0x03d8
        L_0x03d7:
            int r7 = r7 + r10
        L_0x03d8:
            if (r23 == 0) goto L_0x03e0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r1.f4333h
        L_0x03dc:
            r2.e(r7)
            goto L_0x03e3
        L_0x03e0:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r1.f4334i
            goto L_0x03dc
        L_0x03e3:
            if (r3 >= r8) goto L_0x03f1
            if (r3 >= r6) goto L_0x03f1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r1.f4334i
            int r1 = r1.f4278f
            int r1 = -r1
            if (r23 == 0) goto L_0x03f0
            int r7 = r7 - r1
            goto L_0x03f1
        L_0x03f0:
            int r7 = r7 + r1
        L_0x03f1:
            int r3 = r3 + 1
            goto L_0x0380
        L_0x03f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.ChainRun.a(androidx.constraintlayout.core.widgets.analyzer.Dependency):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006d, code lost:
        if (r1 != null) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a3, code lost:
        if (r1 != null) goto L_0x00a5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d() {
        /*
            r5 = this;
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r0 = r5.f4261k
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0016
            java.lang.Object r1 = r0.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r1 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r1
            r1.d()
            goto L_0x0006
        L_0x0016:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r0 = r5.f4261k
            int r0 = r0.size()
            r1 = 1
            if (r0 >= r1) goto L_0x0020
            return
        L_0x0020:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r2 = r5.f4261k
            r3 = 0
            java.lang.Object r2 = r2.get(r3)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r2 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r2
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r2.f4327b
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r4 = r5.f4261k
            int r0 = r0 - r1
            java.lang.Object r0 = r4.get(r0)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r0 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.f4327b
            int r4 = r5.f4331f
            if (r4 != 0) goto L_0x0070
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r2.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.S
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r5.i(r1, r3)
            int r1 = r1.g()
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r5.v()
            if (r4 == 0) goto L_0x0052
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r4.Q
            int r1 = r1.g()
        L_0x0052:
            if (r2 == 0) goto L_0x0059
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r5.f4333h
            r5.b(r4, r2, r1)
        L_0x0059:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r5.i(r0, r3)
            int r0 = r0.g()
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r5.w()
            if (r2 == 0) goto L_0x006d
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r2.S
            int r0 = r0.g()
        L_0x006d:
            if (r1 == 0) goto L_0x00ab
            goto L_0x00a5
        L_0x0070:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.T
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r5.i(r2, r1)
            int r2 = r2.g()
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r5.v()
            if (r4 == 0) goto L_0x0088
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r4.R
            int r2 = r2.g()
        L_0x0088:
            if (r3 == 0) goto L_0x008f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r5.f4333h
            r5.b(r4, r3, r2)
        L_0x008f:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r5.i(r0, r1)
            int r0 = r0.g()
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r5.w()
            if (r2 == 0) goto L_0x00a3
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r2.T
            int r0 = r0.g()
        L_0x00a3:
            if (r1 == 0) goto L_0x00ab
        L_0x00a5:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r5.f4334i
            int r0 = -r0
            r5.b(r2, r1, r0)
        L_0x00ab:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r5.f4333h
            r0.f4273a = r5
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r5.f4334i
            r0.f4273a = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.ChainRun.d():void");
    }

    public void e() {
        for (int i2 = 0; i2 < this.f4261k.size(); i2++) {
            this.f4261k.get(i2).e();
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f4328c = null;
        Iterator<WidgetRun> it2 = this.f4261k.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
    }

    public long j() {
        int size = this.f4261k.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            WidgetRun widgetRun = this.f4261k.get(i2);
            j2 = j2 + ((long) widgetRun.f4333h.f4278f) + widgetRun.j() + ((long) widgetRun.f4334i.f4278f);
        }
        return j2;
    }

    /* access modifiers changed from: package-private */
    public void n() {
        this.f4333h.f4282j = false;
        this.f4334i.f4282j = false;
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        int size = this.f4261k.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.f4261k.get(i2).p()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f4331f == 0 ? "horizontal : " : "vertical : ");
        Iterator<WidgetRun> it2 = this.f4261k.iterator();
        while (it2.hasNext()) {
            sb.append("<");
            sb.append(it2.next());
            sb.append("> ");
        }
        return sb.toString();
    }
}
