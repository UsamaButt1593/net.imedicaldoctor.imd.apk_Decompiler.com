package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

public class DependencyGraph {

    /* renamed from: j  reason: collision with root package name */
    private static final boolean f4263j = true;

    /* renamed from: a  reason: collision with root package name */
    private ConstraintWidgetContainer f4264a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4265b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4266c = true;

    /* renamed from: d  reason: collision with root package name */
    private ConstraintWidgetContainer f4267d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<WidgetRun> f4268e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<RunGroup> f4269f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private BasicMeasure.Measurer f4270g = null;

    /* renamed from: h  reason: collision with root package name */
    private BasicMeasure.Measure f4271h = new BasicMeasure.Measure();

    /* renamed from: i  reason: collision with root package name */
    ArrayList<RunGroup> f4272i = new ArrayList<>();

    public DependencyGraph(ConstraintWidgetContainer constraintWidgetContainer) {
        this.f4264a = constraintWidgetContainer;
        this.f4267d = constraintWidgetContainer;
    }

    private void a(DependencyNode dependencyNode, int i2, int i3, DependencyNode dependencyNode2, ArrayList<RunGroup> arrayList, RunGroup runGroup) {
        WidgetRun widgetRun = dependencyNode.f4276d;
        if (widgetRun.f4328c == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.f4264a;
            if (widgetRun != constraintWidgetContainer.f4192e && widgetRun != constraintWidgetContainer.f4193f) {
                if (runGroup == null) {
                    runGroup = new RunGroup(widgetRun, i3);
                    arrayList.add(runGroup);
                }
                widgetRun.f4328c = runGroup;
                runGroup.a(widgetRun);
                for (Dependency next : widgetRun.f4333h.f4283k) {
                    if (next instanceof DependencyNode) {
                        a((DependencyNode) next, i2, 0, dependencyNode2, arrayList, runGroup);
                    }
                }
                for (Dependency next2 : widgetRun.f4334i.f4283k) {
                    if (next2 instanceof DependencyNode) {
                        a((DependencyNode) next2, i2, 1, dependencyNode2, arrayList, runGroup);
                    }
                }
                if (i2 == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                    for (Dependency next3 : ((VerticalWidgetRun) widgetRun).f4307k.f4283k) {
                        if (next3 instanceof DependencyNode) {
                            a((DependencyNode) next3, i2, 2, dependencyNode2, arrayList, runGroup);
                        }
                    }
                }
                for (DependencyNode next4 : widgetRun.f4333h.f4284l) {
                    if (next4 == dependencyNode2) {
                        runGroup.f4301b = true;
                    }
                    a(next4, i2, 0, dependencyNode2, arrayList, runGroup);
                }
                for (DependencyNode next5 : widgetRun.f4334i.f4284l) {
                    if (next5 == dependencyNode2) {
                        runGroup.f4301b = true;
                    }
                    a(next5, i2, 1, dependencyNode2, arrayList, runGroup);
                }
                if (i2 == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                    for (DependencyNode a2 : ((VerticalWidgetRun) widgetRun).f4307k.f4284l) {
                        a(a2, i2, 2, dependencyNode2, arrayList, runGroup);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:128:0x01e9, code lost:
        r4 = r0.b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0074, code lost:
        if (r2.x == 0) goto L_0x0065;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r17) {
        /*
            r16 = this;
            r0 = r17
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r1 = r0.A1
            java.util.Iterator r1 = r1.iterator()
        L_0x0008:
            boolean r2 = r1.hasNext()
            r3 = 0
            if (r2 == 0) goto L_0x025f
            java.lang.Object r2 = r1.next()
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r2.b0
            r5 = r4[r3]
            r10 = 1
            r4 = r4[r10]
            int r6 = r2.l0()
            r7 = 8
            if (r6 != r7) goto L_0x0027
        L_0x0024:
            r2.f4188a = r10
            goto L_0x0008
        L_0x0027:
            float r6 = r2.B
            r11 = 1065353216(0x3f800000, float:1.0)
            r7 = 2
            int r6 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r6 >= 0) goto L_0x0036
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r6) goto L_0x0036
            r2.w = r7
        L_0x0036:
            float r6 = r2.E
            int r6 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r6 >= 0) goto L_0x0042
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 != r6) goto L_0x0042
            r2.x = r7
        L_0x0042:
            float r6 = r2.A()
            r8 = 0
            r9 = 3
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x0077
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r6) goto L_0x005b
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 == r8) goto L_0x0058
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r4 != r8) goto L_0x005b
        L_0x0058:
            r2.w = r9
            goto L_0x0077
        L_0x005b:
            if (r4 != r6) goto L_0x0068
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 == r8) goto L_0x0065
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r5 != r8) goto L_0x0068
        L_0x0065:
            r2.x = r9
            goto L_0x0077
        L_0x0068:
            if (r5 != r6) goto L_0x0077
            if (r4 != r6) goto L_0x0077
            int r6 = r2.w
            if (r6 != 0) goto L_0x0072
            r2.w = r9
        L_0x0072:
            int r6 = r2.x
            if (r6 != 0) goto L_0x0077
            goto L_0x0065
        L_0x0077:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r6) goto L_0x008d
            int r8 = r2.w
            if (r8 != r10) goto L_0x008d
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r2.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r8.f4183f
            if (r8 == 0) goto L_0x008b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r2.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r8.f4183f
            if (r8 != 0) goto L_0x008d
        L_0x008b:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
        L_0x008d:
            r8 = r5
            if (r4 != r6) goto L_0x00a2
            int r5 = r2.x
            if (r5 != r10) goto L_0x00a2
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r2.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f4183f
            if (r5 == 0) goto L_0x00a0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r2.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f4183f
            if (r5 != 0) goto L_0x00a2
        L_0x00a0:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
        L_0x00a2:
            r12 = r4
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r4 = r2.f4192e
            r4.f4329d = r8
            int r5 = r2.w
            r4.f4326a = r5
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r4 = r2.f4193f
            r4.f4329d = r12
            int r13 = r2.x
            r4.f4326a = r13
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r8 == r4) goto L_0x00bf
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r8 == r14) goto L_0x00bf
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r8 != r14) goto L_0x00cb
        L_0x00bf:
            if (r12 == r4) goto L_0x0224
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r12 == r14) goto L_0x0224
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r12 != r14) goto L_0x00cb
            goto L_0x0224
        L_0x00cb:
            r14 = 1056964608(0x3f000000, float:0.5)
            if (r8 != r6) goto L_0x015b
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r12 == r15) goto L_0x00d7
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r12 != r11) goto L_0x015b
        L_0x00d7:
            if (r5 != r9) goto L_0x0111
            if (r12 != r15) goto L_0x00e5
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r15
            r8 = r15
            r4.r(r5, r6, r7, r8, r9)
        L_0x00e5:
            int r9 = r2.D()
            float r3 = (float) r9
            float r4 = r2.f0
            float r3 = r3 * r4
            float r3 = r3 + r14
            int r7 = (int) r3
        L_0x00f0:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
        L_0x00f2:
            r4 = r16
            r5 = r2
            r6 = r8
        L_0x00f6:
            r4.r(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r2.f4192e
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.f4330e
            int r4 = r2.m0()
            r3.e(r4)
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r2.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.f4330e
            int r4 = r2.D()
            r3.e(r4)
            goto L_0x0024
        L_0x0111:
            if (r5 != r10) goto L_0x0129
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r15
            r8 = r12
            r4.r(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r2.f4192e
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.f4330e
            int r2 = r2.m0()
        L_0x0125:
            r3.f4285m = r2
            goto L_0x0008
        L_0x0129:
            if (r5 != r7) goto L_0x014a
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r11 = r0.b0
            r11 = r11[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r11 == r15) goto L_0x0135
            if (r11 != r4) goto L_0x015b
        L_0x0135:
            float r3 = r2.B
            int r4 = r17.m0()
            float r4 = (float) r4
            float r3 = r3 * r4
            float r3 = r3 + r14
            int r7 = (int) r3
            int r9 = r2.D()
        L_0x0144:
            r4 = r16
            r5 = r2
            r6 = r15
        L_0x0148:
            r8 = r12
            goto L_0x00f6
        L_0x014a:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r11 = r2.Y
            r7 = r11[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.f4183f
            if (r7 == 0) goto L_0x0158
            r7 = r11[r10]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.f4183f
            if (r7 != 0) goto L_0x015b
        L_0x0158:
            r7 = 0
            r9 = 0
            goto L_0x0144
        L_0x015b:
            if (r12 != r6) goto L_0x01db
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r8 == r11) goto L_0x0165
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r8 != r7) goto L_0x01db
        L_0x0165:
            if (r13 != r9) goto L_0x018b
            if (r8 != r11) goto L_0x0173
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r11
            r8 = r11
            r4.r(r5, r6, r7, r8, r9)
        L_0x0173:
            int r7 = r2.m0()
            float r3 = r2.f0
            int r4 = r2.B()
            r5 = -1
            if (r4 != r5) goto L_0x0184
            r4 = 1065353216(0x3f800000, float:1.0)
            float r3 = r4 / r3
        L_0x0184:
            float r4 = (float) r7
            float r4 = r4 * r3
            float r4 = r4 + r14
            int r9 = (int) r4
            goto L_0x00f0
        L_0x018b:
            if (r13 != r10) goto L_0x01a0
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r8
            r8 = r11
            r4.r(r5, r6, r7, r8, r9)
        L_0x0197:
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r2.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.f4330e
            int r2 = r2.D()
            goto L_0x0125
        L_0x01a0:
            r7 = 2
            if (r13 != r7) goto L_0x01c4
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r7 = r0.b0
            r7 = r7[r10]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r7 == r9) goto L_0x01ad
            if (r7 != r4) goto L_0x01db
        L_0x01ad:
            float r3 = r2.E
            int r7 = r2.m0()
            int r4 = r17.D()
            float r4 = (float) r4
            float r3 = r3 * r4
            float r3 = r3 + r14
            int r3 = (int) r3
            r4 = r16
            r5 = r2
            r6 = r8
            r8 = r9
            r9 = r3
            goto L_0x00f6
        L_0x01c4:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r2.Y
            r7 = 2
            r15 = r4[r7]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r15.f4183f
            if (r7 == 0) goto L_0x01d3
            r4 = r4[r9]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.f4183f
            if (r4 != 0) goto L_0x01db
        L_0x01d3:
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r11
            goto L_0x0148
        L_0x01db:
            if (r8 != r6) goto L_0x0008
            if (r12 != r6) goto L_0x0008
            if (r5 == r10) goto L_0x020d
            if (r13 != r10) goto L_0x01e4
            goto L_0x020d
        L_0x01e4:
            r4 = 2
            if (r13 != r4) goto L_0x0008
            if (r5 != r4) goto L_0x0008
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.b0
            r3 = r4[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r3 != r8) goto L_0x0008
            r3 = r4[r10]
            if (r3 != r8) goto L_0x0008
            float r3 = r2.B
            float r4 = r2.E
            int r5 = r17.m0()
            float r5 = (float) r5
            float r3 = r3 * r5
            float r3 = r3 + r14
            int r7 = (int) r3
            int r3 = r17.D()
            float r3 = (float) r3
            float r4 = r4 * r3
            float r4 = r4 + r14
            int r9 = (int) r4
            goto L_0x00f2
        L_0x020d:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r8
            r4.r(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r3 = r2.f4192e
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r3.f4330e
            int r4 = r2.m0()
            r3.f4285m = r4
            goto L_0x0197
        L_0x0224:
            int r3 = r2.m0()
            if (r8 != r4) goto L_0x023d
            int r3 = r17.m0()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r2.Q
            int r5 = r5.f4184g
            int r3 = r3 - r5
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r2.S
            int r5 = r5.f4184g
            int r3 = r3 - r5
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r7 = r3
            r6 = r5
            goto L_0x023f
        L_0x023d:
            r7 = r3
            r6 = r8
        L_0x023f:
            int r3 = r2.D()
            if (r12 != r4) goto L_0x0258
            int r3 = r17.D()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r2.R
            int r4 = r4.f4184g
            int r3 = r3 - r4
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r2.T
            int r4 = r4.f4184g
            int r3 = r3 - r4
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r9 = r3
            r8 = r4
            goto L_0x025a
        L_0x0258:
            r9 = r3
            r8 = r12
        L_0x025a:
            r4 = r16
            r5 = r2
            goto L_0x00f6
        L_0x025f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.DependencyGraph.b(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer):boolean");
    }

    private int e(ConstraintWidgetContainer constraintWidgetContainer, int i2) {
        int size = this.f4272i.size();
        long j2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            j2 = Math.max(j2, this.f4272i.get(i3).b(constraintWidgetContainer, i2));
        }
        return (int) j2;
    }

    private void j() {
        Iterator<WidgetRun> it2 = this.f4268e.iterator();
        String str = "digraph {\n";
        while (it2.hasNext()) {
            str = m(it2.next(), str);
        }
        String str2 = str + "\n}\n";
        System.out.println("content:<<\n" + str2 + "\n>>");
    }

    private void k(WidgetRun widgetRun, int i2, ArrayList<RunGroup> arrayList) {
        for (Dependency next : widgetRun.f4333h.f4283k) {
            if (next instanceof DependencyNode) {
                a((DependencyNode) next, i2, 0, widgetRun.f4334i, arrayList, (RunGroup) null);
            } else if (next instanceof WidgetRun) {
                a(((WidgetRun) next).f4333h, i2, 0, widgetRun.f4334i, arrayList, (RunGroup) null);
            }
        }
        for (Dependency next2 : widgetRun.f4334i.f4283k) {
            if (next2 instanceof DependencyNode) {
                a((DependencyNode) next2, i2, 1, widgetRun.f4333h, arrayList, (RunGroup) null);
            } else if (next2 instanceof WidgetRun) {
                a(((WidgetRun) next2).f4334i, i2, 1, widgetRun.f4333h, arrayList, (RunGroup) null);
            }
        }
        if (i2 == 1) {
            for (Dependency next3 : ((VerticalWidgetRun) widgetRun).f4307k.f4283k) {
                if (next3 instanceof DependencyNode) {
                    a((DependencyNode) next3, i2, 2, (DependencyNode) null, arrayList, (RunGroup) null);
                }
            }
        }
    }

    private String l(ChainRun chainRun, String str) {
        int i2 = chainRun.f4331f;
        StringBuilder sb = new StringBuilder("subgraph ");
        sb.append("cluster_");
        sb.append(chainRun.f4327b.y());
        sb.append(i2 == 0 ? "_h" : "_v");
        sb.append(" {\n");
        Iterator<WidgetRun> it2 = chainRun.f4261k.iterator();
        String str2 = "";
        while (it2.hasNext()) {
            WidgetRun next = it2.next();
            sb.append(next.f4327b.y());
            sb.append(i2 == 0 ? "_HORIZONTAL" : "_VERTICAL");
            sb.append(";\n");
            str2 = m(next, str2);
        }
        sb.append("}\n");
        return str + str2 + sb;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e4, code lost:
        if (r1.f4284l.isEmpty() == false) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e6, code lost:
        r2.append(org.apache.commons.lang3.StringUtils.LF);
        r2.append(r0.d());
        r2.append(" -> ");
        r0 = r1.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0153, code lost:
        if (r1.f4284l.isEmpty() == false) goto L_0x00e6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0161  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m(androidx.constraintlayout.core.widgets.analyzer.WidgetRun r10, java.lang.String r11) {
        /*
            r9 = this;
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.f4333h
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4334i
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r11)
            boolean r3 = r10 instanceof androidx.constraintlayout.core.widgets.analyzer.HelperReferences
            if (r3 != 0) goto L_0x002d
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.Dependency> r3 = r0.f4283k
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x002d
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.Dependency> r3 = r1.f4283k
            boolean r3 = r3.isEmpty()
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r4 = r0.f4284l
            boolean r4 = r4.isEmpty()
            r3 = r3 & r4
            if (r3 == 0) goto L_0x002d
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r3 = r1.f4284l
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x002d
            return r11
        L_0x002d:
            java.lang.String r3 = r9.t(r10)
            r2.append(r3)
            boolean r3 = r9.q(r0, r1)
            java.lang.String r11 = r9.n(r0, r3, r11)
            java.lang.String r11 = r9.n(r1, r3, r11)
            boolean r4 = r10 instanceof androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun
            if (r4 == 0) goto L_0x004d
            r5 = r10
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r5 = (androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun) r5
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r5 = r5.f4307k
            java.lang.String r11 = r9.n(r5, r3, r11)
        L_0x004d:
            boolean r3 = r10 instanceof androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun
            r5 = 0
            java.lang.String r6 = " -> "
            java.lang.String r7 = "\n"
            if (r3 != 0) goto L_0x00f8
            boolean r3 = r10 instanceof androidx.constraintlayout.core.widgets.analyzer.ChainRun
            if (r3 == 0) goto L_0x0063
            r8 = r10
            androidx.constraintlayout.core.widgets.analyzer.ChainRun r8 = (androidx.constraintlayout.core.widgets.analyzer.ChainRun) r8
            int r8 = r8.f4331f
            if (r8 != 0) goto L_0x0063
            goto L_0x00f8
        L_0x0063:
            if (r4 != 0) goto L_0x006f
            if (r3 == 0) goto L_0x0156
            r3 = r10
            androidx.constraintlayout.core.widgets.analyzer.ChainRun r3 = (androidx.constraintlayout.core.widgets.analyzer.ChainRun) r3
            int r3 = r3.f4331f
            r4 = 1
            if (r3 != r4) goto L_0x0156
        L_0x006f:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = r3.j0()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r3 == r4) goto L_0x00ad
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != r4) goto L_0x007e
            goto L_0x00ad
        L_0x007e:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r0) goto L_0x0156
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            float r0 = r0.A()
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x0156
            r2.append(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            java.lang.String r0 = r0.y()
            r2.append(r0)
            java.lang.String r0 = "_VERTICAL -> "
            r2.append(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            java.lang.String r0 = r0.y()
            r2.append(r0)
            java.lang.String r0 = "_HORIZONTAL;\n"
        L_0x00a8:
            r2.append(r0)
            goto L_0x0156
        L_0x00ad:
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r3 = r0.f4284l
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x00d6
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r3 = r1.f4284l
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x00d6
        L_0x00bd:
            r2.append(r7)
            java.lang.String r1 = r1.d()
            r2.append(r1)
            r2.append(r6)
            java.lang.String r0 = r0.d()
        L_0x00ce:
            r2.append(r0)
            r2.append(r7)
            goto L_0x0156
        L_0x00d6:
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r3 = r0.f4284l
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0156
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r3 = r1.f4284l
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0156
        L_0x00e6:
            r2.append(r7)
            java.lang.String r0 = r0.d()
            r2.append(r0)
            r2.append(r6)
            java.lang.String r0 = r1.d()
            goto L_0x00ce
        L_0x00f8:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = r3.H()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r3 == r4) goto L_0x0133
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != r4) goto L_0x0107
            goto L_0x0133
        L_0x0107:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r0) goto L_0x0156
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            float r0 = r0.A()
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x0156
            r2.append(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            java.lang.String r0 = r0.y()
            r2.append(r0)
            java.lang.String r0 = "_HORIZONTAL -> "
            r2.append(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            java.lang.String r0 = r0.y()
            r2.append(r0)
            java.lang.String r0 = "_VERTICAL;\n"
            goto L_0x00a8
        L_0x0133:
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r3 = r0.f4284l
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0145
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r3 = r1.f4284l
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0145
            goto L_0x00bd
        L_0x0145:
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r3 = r0.f4284l
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0156
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r3 = r1.f4284l
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0156
            goto L_0x00e6
        L_0x0156:
            boolean r0 = r10 instanceof androidx.constraintlayout.core.widgets.analyzer.ChainRun
            if (r0 == 0) goto L_0x0161
            androidx.constraintlayout.core.widgets.analyzer.ChainRun r10 = (androidx.constraintlayout.core.widgets.analyzer.ChainRun) r10
            java.lang.String r10 = r9.l(r10, r11)
            return r10
        L_0x0161:
            java.lang.String r10 = r2.toString()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.DependencyGraph.m(androidx.constraintlayout.core.widgets.analyzer.WidgetRun, java.lang.String):java.lang.String");
    }

    private String n(DependencyNode dependencyNode, boolean z, String str) {
        StringBuilder sb = new StringBuilder(str);
        for (DependencyNode d2 : dependencyNode.f4284l) {
            String str2 = (StringUtils.LF + dependencyNode.d()) + " -> " + d2.d();
            if (dependencyNode.f4278f > 0 || z || (dependencyNode.f4276d instanceof HelperReferences)) {
                String str3 = str2 + "[";
                if (dependencyNode.f4278f > 0) {
                    str3 = str3 + "label=\"" + dependencyNode.f4278f + "\"";
                    if (z) {
                        str3 = str3 + ",";
                    }
                }
                if (z) {
                    str3 = str3 + " style=dashed ";
                }
                if (dependencyNode.f4276d instanceof HelperReferences) {
                    str3 = str3 + " style=bold,color=gray ";
                }
                str2 = str3 + "]";
            }
            sb.append(str2 + StringUtils.LF);
        }
        return sb.toString();
    }

    private boolean q(DependencyNode dependencyNode, DependencyNode dependencyNode2) {
        int i2 = 0;
        for (DependencyNode dependencyNode3 : dependencyNode.f4284l) {
            if (dependencyNode3 != dependencyNode2) {
                i2++;
            }
        }
        int i3 = 0;
        for (DependencyNode dependencyNode4 : dependencyNode2.f4284l) {
            if (dependencyNode4 != dependencyNode) {
                i3++;
            }
        }
        return i2 > 0 && i3 > 0;
    }

    private void r(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i2, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i3) {
        BasicMeasure.Measure measure = this.f4271h;
        measure.f4251a = dimensionBehaviour;
        measure.f4252b = dimensionBehaviour2;
        measure.f4253c = i2;
        measure.f4254d = i3;
        this.f4270g.b(constraintWidget, measure);
        constraintWidget.c2(this.f4271h.f4255e);
        constraintWidget.y1(this.f4271h.f4256f);
        constraintWidget.x1(this.f4271h.f4258h);
        constraintWidget.g1(this.f4271h.f4257g);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String t(androidx.constraintlayout.core.widgets.analyzer.WidgetRun r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r10.f4327b
            java.lang.String r1 = r1.y()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r10.f4327b
            if (r0 != 0) goto L_0x0016
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = r3.H()
            goto L_0x001a
        L_0x0016:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = r3.j0()
        L_0x001a:
            androidx.constraintlayout.core.widgets.analyzer.RunGroup r4 = r10.f4328c
            if (r0 != 0) goto L_0x0024
            java.lang.String r5 = "_HORIZONTAL"
        L_0x0020:
            r2.append(r5)
            goto L_0x0027
        L_0x0024:
            java.lang.String r5 = "_VERTICAL"
            goto L_0x0020
        L_0x0027:
            java.lang.String r5 = " [shape=none, label=<"
            r2.append(r5)
            java.lang.String r5 = "<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">"
            r2.append(r5)
            java.lang.String r5 = "  <TR>"
            r2.append(r5)
            java.lang.String r5 = " BGCOLOR=\"green\""
            java.lang.String r6 = "    <TD "
            r2.append(r6)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r10.f4333h
            boolean r7 = r7.f4282j
            if (r0 != 0) goto L_0x004e
            if (r7 == 0) goto L_0x0048
            r2.append(r5)
        L_0x0048:
            java.lang.String r7 = " PORT=\"LEFT\" BORDER=\"1\">L</TD>"
        L_0x004a:
            r2.append(r7)
            goto L_0x0056
        L_0x004e:
            if (r7 == 0) goto L_0x0053
            r2.append(r5)
        L_0x0053:
            java.lang.String r7 = " PORT=\"TOP\" BORDER=\"1\">T</TD>"
            goto L_0x004a
        L_0x0056:
            java.lang.String r7 = "    <TD BORDER=\"1\" "
            r2.append(r7)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r7 = r10.f4330e
            boolean r7 = r7.f4282j
            if (r7 == 0) goto L_0x006d
            androidx.constraintlayout.core.widgets.ConstraintWidget r8 = r10.f4327b
            boolean r8 = r8.f4188a
            if (r8 != 0) goto L_0x006d
            java.lang.String r7 = " BGCOLOR=\"green\" "
        L_0x0069:
            r2.append(r7)
            goto L_0x007b
        L_0x006d:
            if (r7 == 0) goto L_0x0072
            java.lang.String r7 = " BGCOLOR=\"lightgray\" "
            goto L_0x0069
        L_0x0072:
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r10.f4327b
            boolean r7 = r7.f4188a
            if (r7 == 0) goto L_0x007b
            java.lang.String r7 = " BGCOLOR=\"yellow\" "
            goto L_0x0069
        L_0x007b:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r7) goto L_0x0084
            java.lang.String r3 = "style=\"dashed\""
            r2.append(r3)
        L_0x0084:
            java.lang.String r3 = ">"
            r2.append(r3)
            r2.append(r1)
            if (r4 == 0) goto L_0x00a9
            java.lang.String r1 = " ["
            r2.append(r1)
            int r1 = r4.f4305f
            int r1 = r1 + 1
            r2.append(r1)
            java.lang.String r1 = "/"
            r2.append(r1)
            int r1 = androidx.constraintlayout.core.widgets.analyzer.RunGroup.f4299k
            r2.append(r1)
            java.lang.String r1 = "]"
            r2.append(r1)
        L_0x00a9:
            java.lang.String r1 = " </TD>"
            r2.append(r1)
            r2.append(r6)
            if (r0 != 0) goto L_0x00c2
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r10 = r10.f4334i
            boolean r10 = r10.f4282j
            if (r10 == 0) goto L_0x00bc
            r2.append(r5)
        L_0x00bc:
            java.lang.String r10 = " PORT=\"RIGHT\" BORDER=\"1\">R</TD>"
        L_0x00be:
            r2.append(r10)
            goto L_0x00e2
        L_0x00c2:
            r0 = r10
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = (androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun) r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f4307k
            boolean r0 = r0.f4282j
            if (r0 == 0) goto L_0x00ce
            r2.append(r5)
        L_0x00ce:
            java.lang.String r0 = " PORT=\"BASELINE\" BORDER=\"1\">b</TD>"
            r2.append(r0)
            r2.append(r6)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r10 = r10.f4334i
            boolean r10 = r10.f4282j
            if (r10 == 0) goto L_0x00df
            r2.append(r5)
        L_0x00df:
            java.lang.String r10 = " PORT=\"BOTTOM\" BORDER=\"1\">B</TD>"
            goto L_0x00be
        L_0x00e2:
            java.lang.String r10 = "  </TR></TABLE>"
            r2.append(r10)
            java.lang.String r10 = ">];\n"
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.DependencyGraph.t(androidx.constraintlayout.core.widgets.analyzer.WidgetRun):java.lang.String");
    }

    public void c() {
        d(this.f4268e);
        this.f4272i.clear();
        RunGroup.f4299k = 0;
        k(this.f4264a.f4192e, 0, this.f4272i);
        k(this.f4264a.f4193f, 1, this.f4272i);
        this.f4265b = false;
    }

    public void d(ArrayList<WidgetRun> arrayList) {
        Object helperReferences;
        arrayList.clear();
        this.f4267d.f4192e.f();
        this.f4267d.f4193f.f();
        arrayList.add(this.f4267d.f4192e);
        arrayList.add(this.f4267d.f4193f);
        Iterator<ConstraintWidget> it2 = this.f4267d.A1.iterator();
        HashSet hashSet = null;
        while (it2.hasNext()) {
            ConstraintWidget next = it2.next();
            if (next instanceof Guideline) {
                helperReferences = new GuidelineReference(next);
            } else {
                if (next.B0()) {
                    if (next.f4190c == null) {
                        next.f4190c = new ChainRun(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f4190c);
                } else {
                    arrayList.add(next.f4192e);
                }
                if (next.D0()) {
                    if (next.f4191d == null) {
                        next.f4191d = new ChainRun(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f4191d);
                } else {
                    arrayList.add(next.f4193f);
                }
                if (next instanceof HelperWidget) {
                    helperReferences = new HelperReferences(next);
                }
            }
            arrayList.add(helperReferences);
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            it3.next().f();
        }
        Iterator<WidgetRun> it4 = arrayList.iterator();
        while (it4.hasNext()) {
            WidgetRun next2 = it4.next();
            if (next2.f4327b != this.f4267d) {
                next2.d();
            }
        }
    }

    public void f(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2) {
        if (this.f4265b) {
            c();
            Iterator<ConstraintWidget> it2 = this.f4264a.A1.iterator();
            boolean z = false;
            while (it2.hasNext()) {
                ConstraintWidget next = it2.next();
                boolean[] zArr = next.f4194g;
                zArr[0] = true;
                zArr[1] = true;
                if (next instanceof Barrier) {
                    z = true;
                }
            }
            if (!z) {
                Iterator<RunGroup> it3 = this.f4272i.iterator();
                while (it3.hasNext()) {
                    RunGroup next2 = it3.next();
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    next2.d(dimensionBehaviour == dimensionBehaviour3, dimensionBehaviour2 == dimensionBehaviour3);
                }
            }
        }
    }

    public boolean g(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (this.f4265b || this.f4266c) {
            Iterator<ConstraintWidget> it2 = this.f4264a.A1.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next = it2.next();
                next.q();
                next.f4188a = false;
                next.f4192e.n();
                next.f4193f.n();
            }
            this.f4264a.q();
            ConstraintWidgetContainer constraintWidgetContainer = this.f4264a;
            constraintWidgetContainer.f4188a = false;
            constraintWidgetContainer.f4192e.n();
            this.f4264a.f4193f.n();
            this.f4266c = false;
        }
        if (b(this.f4267d)) {
            return false;
        }
        this.f4264a.f2(0);
        this.f4264a.g2(0);
        ConstraintWidget.DimensionBehaviour z4 = this.f4264a.z(0);
        ConstraintWidget.DimensionBehaviour z5 = this.f4264a.z(1);
        if (this.f4265b) {
            c();
        }
        int o0 = this.f4264a.o0();
        int p0 = this.f4264a.p0();
        this.f4264a.f4192e.f4333h.e(o0);
        this.f4264a.f4193f.f4333h.e(p0);
        s();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (z4 == dimensionBehaviour || z5 == dimensionBehaviour) {
            if (z) {
                Iterator<WidgetRun> it3 = this.f4268e.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        if (!it3.next().p()) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z && z4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f4264a.D1(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer2 = this.f4264a;
                constraintWidgetContainer2.c2(e(constraintWidgetContainer2, 0));
                ConstraintWidgetContainer constraintWidgetContainer3 = this.f4264a;
                constraintWidgetContainer3.f4192e.f4330e.e(constraintWidgetContainer3.m0());
            }
            if (z && z5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f4264a.Y1(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer4 = this.f4264a;
                constraintWidgetContainer4.y1(e(constraintWidgetContainer4, 1));
                ConstraintWidgetContainer constraintWidgetContainer5 = this.f4264a;
                constraintWidgetContainer5.f4193f.f4330e.e(constraintWidgetContainer5.D());
            }
        }
        ConstraintWidgetContainer constraintWidgetContainer6 = this.f4264a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidgetContainer6.b0[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviour2 == dimensionBehaviour3 || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int m0 = constraintWidgetContainer6.m0() + o0;
            this.f4264a.f4192e.f4334i.e(m0);
            this.f4264a.f4192e.f4330e.e(m0 - o0);
            s();
            ConstraintWidgetContainer constraintWidgetContainer7 = this.f4264a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = constraintWidgetContainer7.b0[1];
            if (dimensionBehaviour4 == dimensionBehaviour3 || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int D = constraintWidgetContainer7.D() + p0;
                this.f4264a.f4193f.f4334i.e(D);
                this.f4264a.f4193f.f4330e.e(D - p0);
            }
            s();
            z2 = true;
        } else {
            z2 = false;
        }
        Iterator<WidgetRun> it4 = this.f4268e.iterator();
        while (it4.hasNext()) {
            WidgetRun next2 = it4.next();
            if (next2.f4327b != this.f4264a || next2.f4332g) {
                next2.e();
            }
        }
        Iterator<WidgetRun> it5 = this.f4268e.iterator();
        while (true) {
            if (!it5.hasNext()) {
                z3 = true;
                break;
            }
            WidgetRun next3 = it5.next();
            if ((z2 || next3.f4327b != this.f4264a) && (!next3.f4333h.f4282j || ((!next3.f4334i.f4282j && !(next3 instanceof GuidelineReference)) || (!next3.f4330e.f4282j && !(next3 instanceof ChainRun) && !(next3 instanceof GuidelineReference))))) {
                break;
            }
        }
        this.f4264a.D1(z4);
        this.f4264a.Y1(z5);
        return z3;
    }

    public boolean h(boolean z) {
        if (this.f4265b) {
            Iterator<ConstraintWidget> it2 = this.f4264a.A1.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next = it2.next();
                next.q();
                next.f4188a = false;
                HorizontalWidgetRun horizontalWidgetRun = next.f4192e;
                horizontalWidgetRun.f4330e.f4282j = false;
                horizontalWidgetRun.f4332g = false;
                horizontalWidgetRun.n();
                VerticalWidgetRun verticalWidgetRun = next.f4193f;
                verticalWidgetRun.f4330e.f4282j = false;
                verticalWidgetRun.f4332g = false;
                verticalWidgetRun.n();
            }
            this.f4264a.q();
            ConstraintWidgetContainer constraintWidgetContainer = this.f4264a;
            constraintWidgetContainer.f4188a = false;
            HorizontalWidgetRun horizontalWidgetRun2 = constraintWidgetContainer.f4192e;
            horizontalWidgetRun2.f4330e.f4282j = false;
            horizontalWidgetRun2.f4332g = false;
            horizontalWidgetRun2.n();
            VerticalWidgetRun verticalWidgetRun2 = this.f4264a.f4193f;
            verticalWidgetRun2.f4330e.f4282j = false;
            verticalWidgetRun2.f4332g = false;
            verticalWidgetRun2.n();
            c();
        }
        if (b(this.f4267d)) {
            return false;
        }
        this.f4264a.f2(0);
        this.f4264a.g2(0);
        this.f4264a.f4192e.f4333h.e(0);
        this.f4264a.f4193f.f4333h.e(0);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x013a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean i(boolean r10, int r11) {
        /*
            r9 = this;
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = r9.f4264a
            r1 = 0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r0.z(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r2 = r9.f4264a
            r3 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = r2.z(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r4 = r9.f4264a
            int r4 = r4.o0()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = r9.f4264a
            int r5 = r5.p0()
            if (r10 == 0) goto L_0x0086
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 == r6) goto L_0x0022
            if (r2 != r6) goto L_0x0086
        L_0x0022:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r6 = r9.f4268e
            java.util.Iterator r6 = r6.iterator()
        L_0x0028:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x003f
            java.lang.Object r7 = r6.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r7 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r7
            int r8 = r7.f4331f
            if (r8 != r11) goto L_0x0028
            boolean r7 = r7.p()
            if (r7 != 0) goto L_0x0028
            r10 = 0
        L_0x003f:
            if (r11 != 0) goto L_0x0065
            if (r10 == 0) goto L_0x0086
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r10) goto L_0x0086
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f4264a
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r10.D1(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f4264a
            int r6 = r9.e(r10, r1)
            r10.c2(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f4264a
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r6 = r10.f4192e
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r6 = r6.f4330e
            int r10 = r10.m0()
        L_0x0061:
            r6.e(r10)
            goto L_0x0086
        L_0x0065:
            if (r10 == 0) goto L_0x0086
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r10) goto L_0x0086
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f4264a
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r10.Y1(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f4264a
            int r6 = r9.e(r10, r3)
            r10.y1(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f4264a
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r6 = r10.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r6 = r6.f4330e
            int r10 = r10.D()
            goto L_0x0061
        L_0x0086:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f4264a
            if (r11 != 0) goto L_0x00b0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r10.b0
            r5 = r5[r1]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r5 == r6) goto L_0x0096
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r5 != r6) goto L_0x00bd
        L_0x0096:
            int r10 = r10.m0()
            int r10 = r10 + r4
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = r9.f4264a
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r5 = r5.f4192e
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r5 = r5.f4334i
            r5.e(r10)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = r9.f4264a
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r5 = r5.f4192e
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r5 = r5.f4330e
            int r10 = r10 - r4
            r5.e(r10)
        L_0x00ae:
            r10 = 1
            goto L_0x00d8
        L_0x00b0:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r10.b0
            r4 = r4[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r4 == r6) goto L_0x00bf
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r4 != r6) goto L_0x00bd
            goto L_0x00bf
        L_0x00bd:
            r10 = 0
            goto L_0x00d8
        L_0x00bf:
            int r10 = r10.D()
            int r10 = r10 + r5
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r4 = r9.f4264a
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r4 = r4.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r4.f4334i
            r4.e(r10)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r4 = r9.f4264a
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r4 = r4.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r4 = r4.f4330e
            int r10 = r10 - r5
            r4.e(r10)
            goto L_0x00ae
        L_0x00d8:
            r9.s()
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r4 = r9.f4268e
            java.util.Iterator r4 = r4.iterator()
        L_0x00e1:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0101
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r5 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r5
            int r6 = r5.f4331f
            if (r6 == r11) goto L_0x00f2
            goto L_0x00e1
        L_0x00f2:
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r5.f4327b
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r7 = r9.f4264a
            if (r6 != r7) goto L_0x00fd
            boolean r6 = r5.f4332g
            if (r6 != 0) goto L_0x00fd
            goto L_0x00e1
        L_0x00fd:
            r5.e()
            goto L_0x00e1
        L_0x0101:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r4 = r9.f4268e
            java.util.Iterator r4 = r4.iterator()
        L_0x0107:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x013a
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r5 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r5
            int r6 = r5.f4331f
            if (r6 == r11) goto L_0x0118
            goto L_0x0107
        L_0x0118:
            if (r10 != 0) goto L_0x0121
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r5.f4327b
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r7 = r9.f4264a
            if (r6 != r7) goto L_0x0121
            goto L_0x0107
        L_0x0121:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r6 = r5.f4333h
            boolean r6 = r6.f4282j
            if (r6 != 0) goto L_0x0128
            goto L_0x013b
        L_0x0128:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r6 = r5.f4334i
            boolean r6 = r6.f4282j
            if (r6 != 0) goto L_0x012f
            goto L_0x013b
        L_0x012f:
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.analyzer.ChainRun
            if (r6 != 0) goto L_0x0107
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r5 = r5.f4330e
            boolean r5 = r5.f4282j
            if (r5 != 0) goto L_0x0107
            goto L_0x013b
        L_0x013a:
            r1 = 1
        L_0x013b:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f4264a
            r10.D1(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r9.f4264a
            r10.Y1(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.DependencyGraph.i(boolean, int):boolean");
    }

    public void o() {
        this.f4265b = true;
    }

    public void p() {
        this.f4266c = true;
    }

    public void s() {
        DimensionDependency dimensionDependency;
        DimensionDependency dimensionDependency2;
        int m0;
        DimensionDependency dimensionDependency3;
        int m02;
        Iterator<ConstraintWidget> it2 = this.f4264a.A1.iterator();
        while (it2.hasNext()) {
            ConstraintWidget next = it2.next();
            if (!next.f4188a) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.b0;
                boolean z = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i2 = next.w;
                int i3 = next.x;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                boolean z2 = dimensionBehaviour == dimensionBehaviour3 || (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i2 == 1);
                if (dimensionBehaviour2 == dimensionBehaviour3 || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i3 == 1)) {
                    z = true;
                }
                DimensionDependency dimensionDependency4 = next.f4192e.f4330e;
                boolean z3 = dimensionDependency4.f4282j;
                DimensionDependency dimensionDependency5 = next.f4193f.f4330e;
                boolean z4 = dimensionDependency5.f4282j;
                if (!z3 || !z4) {
                    if (!z3 || !z) {
                        if (z4 && z2) {
                            r(next, dimensionBehaviour3, dimensionDependency4.f4279g, ConstraintWidget.DimensionBehaviour.FIXED, dimensionDependency5.f4279g);
                            if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                                dimensionDependency3 = next.f4192e.f4330e;
                                m02 = next.m0();
                            } else {
                                dimensionDependency2 = next.f4192e.f4330e;
                                m0 = next.m0();
                                dimensionDependency2.e(m0);
                            }
                        }
                        if (next.f4188a && (dimensionDependency = next.f4193f.f4308l) != null) {
                            dimensionDependency.e(next.t());
                        }
                    } else {
                        r(next, ConstraintWidget.DimensionBehaviour.FIXED, dimensionDependency4.f4279g, dimensionBehaviour3, dimensionDependency5.f4279g);
                        if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                            dimensionDependency3 = next.f4193f.f4330e;
                            m02 = next.D();
                        } else {
                            dimensionDependency2 = next.f4193f.f4330e;
                            m0 = next.D();
                            dimensionDependency2.e(m0);
                        }
                    }
                    dimensionDependency3.f4285m = m02;
                    dimensionDependency.e(next.t());
                } else {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    r(next, dimensionBehaviour4, dimensionDependency4.f4279g, dimensionBehaviour4, dimensionDependency5.f4279g);
                }
                next.f4188a = true;
                dimensionDependency.e(next.t());
            }
        }
    }

    public void u(BasicMeasure.Measurer measurer) {
        this.f4270g = measurer;
    }
}
