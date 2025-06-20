package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import java.util.List;

public class HorizontalWidgetRun extends WidgetRun {

    /* renamed from: k  reason: collision with root package name */
    private static int[] f4294k = new int[2];

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4295a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType[] r0 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4295a = r0
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4295a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4295a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun.AnonymousClass1.<clinit>():void");
        }
    }

    public HorizontalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.f4333h.f4277e = DependencyNode.Type.LEFT;
        this.f4334i.f4277e = DependencyNode.Type.RIGHT;
        this.f4331f = 0;
    }

    private void u(int[] iArr, int i2, int i3, int i4, int i5, float f2, int i6) {
        int i7 = i3 - i2;
        int i8 = i5 - i4;
        if (i6 == -1) {
            int i9 = (int) ((((float) i8) * f2) + 0.5f);
            int i10 = (int) ((((float) i7) / f2) + 0.5f);
            if (i9 <= i7) {
                iArr[0] = i9;
                iArr[1] = i8;
            } else if (i10 <= i8) {
                iArr[0] = i7;
                iArr[1] = i10;
            }
        } else if (i6 == 0) {
            iArr[0] = (int) ((((float) i8) * f2) + 0.5f);
            iArr[1] = i8;
        } else if (i6 == 1) {
            iArr[0] = i7;
            iArr[1] = (int) ((((float) i7) * f2) + 0.5f);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x029d, code lost:
        if (r14 != 1) goto L_0x02f0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.constraintlayout.core.widgets.analyzer.Dependency r17) {
        /*
            r16 = this;
            r8 = r16
            int[] r0 = androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun.AnonymousClass1.f4295a
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = r8.f4335j
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 3
            r9 = 1
            r10 = 0
            if (r0 == r9) goto L_0x0029
            if (r0 == r1) goto L_0x0023
            if (r0 == r2) goto L_0x0017
            goto L_0x002e
        L_0x0017:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f4327b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.S
            r3 = r17
            r8.q(r3, r1, r0, r10)
            return
        L_0x0023:
            r3 = r17
            r16.r(r17)
            goto L_0x002e
        L_0x0029:
            r3 = r17
            r16.s(r17)
        L_0x002e:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f4330e
            boolean r0 = r0.f4282j
            r11 = 1056964608(0x3f000000, float:0.5)
            if (r0 != 0) goto L_0x02f0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r8.f4329d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r3) goto L_0x02f0
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f4327b
            int r3 = r0.w
            if (r3 == r1) goto L_0x02d5
            if (r3 == r2) goto L_0x0046
            goto L_0x02f0
        L_0x0046:
            int r1 = r0.x
            r3 = -1
            if (r1 == 0) goto L_0x0082
            if (r1 != r2) goto L_0x004e
            goto L_0x0082
        L_0x004e:
            int r0 = r0.B()
            if (r0 == r3) goto L_0x005a
            if (r0 == 0) goto L_0x006c
            if (r0 == r9) goto L_0x005a
            r0 = 0
            goto L_0x007b
        L_0x005a:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f4327b
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r1 = r0.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r1.f4330e
            int r1 = r1.f4279g
            float r1 = (float) r1
            float r0 = r0.A()
            float r1 = r1 * r0
        L_0x0069:
            float r1 = r1 + r11
            int r0 = (int) r1
            goto L_0x007b
        L_0x006c:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f4327b
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r1 = r0.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r1.f4330e
            int r1 = r1.f4279g
            float r1 = (float) r1
            float r0 = r0.A()
            float r1 = r1 / r0
            goto L_0x0069
        L_0x007b:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r8.f4330e
            r1.e(r0)
            goto L_0x02f0
        L_0x0082:
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r1 = r0.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r12 = r1.f4333h
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r13 = r1.f4334i
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f4183f
            if (r1 == 0) goto L_0x0090
            r1 = 1
            goto L_0x0091
        L_0x0090:
            r1 = 0
        L_0x0091:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f4183f
            if (r2 == 0) goto L_0x0099
            r2 = 1
            goto L_0x009a
        L_0x0099:
            r2 = 0
        L_0x009a:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.f4183f
            if (r4 == 0) goto L_0x00a2
            r4 = 1
            goto L_0x00a3
        L_0x00a2:
            r4 = 0
        L_0x00a3:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r0.T
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f4183f
            if (r5 == 0) goto L_0x00ab
            r5 = 1
            goto L_0x00ac
        L_0x00ab:
            r5 = 0
        L_0x00ac:
            int r14 = r0.B()
            if (r1 == 0) goto L_0x01f3
            if (r2 == 0) goto L_0x01f3
            if (r4 == 0) goto L_0x01f3
            if (r5 == 0) goto L_0x01f3
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f4327b
            float r15 = r0.A()
            boolean r0 = r12.f4282j
            if (r0 == 0) goto L_0x0121
            boolean r0 = r13.f4282j
            if (r0 == 0) goto L_0x0121
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f4333h
            boolean r1 = r0.f4275c
            if (r1 == 0) goto L_0x0120
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f4334i
            boolean r1 = r1.f4275c
            if (r1 != 0) goto L_0x00d3
            goto L_0x0120
        L_0x00d3:
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f4284l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f4279g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f4333h
            int r1 = r1.f4278f
            int r2 = r0 + r1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f4334i
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f4284l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f4279g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f4334i
            int r1 = r1.f4278f
            int r3 = r0 - r1
            int r0 = r12.f4279g
            int r1 = r12.f4278f
            int r4 = r0 + r1
            int r0 = r13.f4279g
            int r1 = r13.f4278f
            int r5 = r0 - r1
            int[] r1 = f4294k
            r0 = r16
            r6 = r15
            r7 = r14
            r0.u(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f4330e
            int[] r1 = f4294k
            r1 = r1[r10]
            r0.e(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f4327b
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.f4330e
            int[] r1 = f4294k
            r1 = r1[r9]
            r0.e(r1)
        L_0x0120:
            return
        L_0x0121:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f4333h
            boolean r1 = r0.f4282j
            if (r1 == 0) goto L_0x017e
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f4334i
            boolean r2 = r1.f4282j
            if (r2 == 0) goto L_0x017e
            boolean r2 = r12.f4275c
            if (r2 == 0) goto L_0x017d
            boolean r2 = r13.f4275c
            if (r2 != 0) goto L_0x0136
            goto L_0x017d
        L_0x0136:
            int r2 = r0.f4279g
            int r0 = r0.f4278f
            int r2 = r2 + r0
            int r0 = r1.f4279g
            int r1 = r1.f4278f
            int r3 = r0 - r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r12.f4284l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f4279g
            int r1 = r12.f4278f
            int r4 = r0 + r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r13.f4284l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f4279g
            int r1 = r13.f4278f
            int r5 = r0 - r1
            int[] r1 = f4294k
            r0 = r16
            r6 = r15
            r7 = r14
            r0.u(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f4330e
            int[] r1 = f4294k
            r1 = r1[r10]
            r0.e(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f4327b
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.f4330e
            int[] r1 = f4294k
            r1 = r1[r9]
            r0.e(r1)
            goto L_0x017e
        L_0x017d:
            return
        L_0x017e:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f4333h
            boolean r1 = r0.f4275c
            if (r1 == 0) goto L_0x01f2
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f4334i
            boolean r1 = r1.f4275c
            if (r1 == 0) goto L_0x01f2
            boolean r1 = r12.f4275c
            if (r1 == 0) goto L_0x01f2
            boolean r1 = r13.f4275c
            if (r1 != 0) goto L_0x0193
            goto L_0x01f2
        L_0x0193:
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f4284l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f4279g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f4333h
            int r1 = r1.f4278f
            int r2 = r0 + r1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f4334i
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f4284l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f4279g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f4334i
            int r1 = r1.f4278f
            int r3 = r0 - r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r12.f4284l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f4279g
            int r1 = r12.f4278f
            int r4 = r0 + r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r13.f4284l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f4279g
            int r1 = r13.f4278f
            int r5 = r0 - r1
            int[] r1 = f4294k
            r0 = r16
            r6 = r15
            r7 = r14
            r0.u(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f4330e
            int[] r1 = f4294k
            r1 = r1[r10]
            r0.e(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f4327b
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.f4330e
            int[] r1 = f4294k
            r1 = r1[r9]
        L_0x01ed:
            r0.e(r1)
            goto L_0x02f0
        L_0x01f2:
            return
        L_0x01f3:
            if (r1 == 0) goto L_0x026c
            if (r4 == 0) goto L_0x026c
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f4333h
            boolean r0 = r0.f4275c
            if (r0 == 0) goto L_0x026b
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f4334i
            boolean r0 = r0.f4275c
            if (r0 != 0) goto L_0x0204
            goto L_0x026b
        L_0x0204:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f4327b
            float r0 = r0.A()
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f4333h
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.f4284l
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r1 = r1.f4279g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.f4333h
            int r2 = r2.f4278f
            int r1 = r1 + r2
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.f4334i
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r2 = r2.f4284l
            java.lang.Object r2 = r2.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            int r2 = r2.f4279g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r8.f4334i
            int r4 = r4.f4278f
            int r2 = r2 - r4
            if (r14 == r3) goto L_0x0258
            if (r14 == 0) goto L_0x0258
            if (r14 == r9) goto L_0x0234
            goto L_0x02f0
        L_0x0234:
            int r2 = r2 - r1
            int r1 = r8.g(r2, r10)
            float r2 = (float) r1
            float r2 = r2 / r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.g(r2, r9)
            if (r2 == r3) goto L_0x0248
            float r1 = (float) r3
            float r1 = r1 * r0
        L_0x0246:
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x0248:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f4330e
            r0.e(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f4327b
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.f4330e
            r0.e(r3)
            goto L_0x02f0
        L_0x0258:
            int r2 = r2 - r1
            int r1 = r8.g(r2, r10)
            float r2 = (float) r1
            float r2 = r2 * r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.g(r2, r9)
            if (r2 == r3) goto L_0x0248
            float r1 = (float) r3
            float r1 = r1 / r0
            goto L_0x0246
        L_0x026b:
            return
        L_0x026c:
            if (r2 == 0) goto L_0x02f0
            if (r5 == 0) goto L_0x02f0
            boolean r0 = r12.f4275c
            if (r0 == 0) goto L_0x02d4
            boolean r0 = r13.f4275c
            if (r0 != 0) goto L_0x0279
            goto L_0x02d4
        L_0x0279:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f4327b
            float r0 = r0.A()
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r12.f4284l
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r1 = r1.f4279g
            int r2 = r12.f4278f
            int r1 = r1 + r2
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r2 = r13.f4284l
            java.lang.Object r2 = r2.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            int r2 = r2.f4279g
            int r4 = r13.f4278f
            int r2 = r2 - r4
            if (r14 == r3) goto L_0x02c1
            if (r14 == 0) goto L_0x02a0
            if (r14 == r9) goto L_0x02c1
            goto L_0x02f0
        L_0x02a0:
            int r2 = r2 - r1
            int r1 = r8.g(r2, r9)
            float r2 = (float) r1
            float r2 = r2 * r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.g(r2, r10)
            if (r2 == r3) goto L_0x02b4
            float r1 = (float) r3
            float r1 = r1 / r0
        L_0x02b2:
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x02b4:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f4330e
            r0.e(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f4327b
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.f4330e
            goto L_0x01ed
        L_0x02c1:
            int r2 = r2 - r1
            int r1 = r8.g(r2, r9)
            float r2 = (float) r1
            float r2 = r2 / r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.g(r2, r10)
            if (r2 == r3) goto L_0x02b4
            float r1 = (float) r3
            float r1 = r1 * r0
            goto L_0x02b2
        L_0x02d4:
            return
        L_0x02d5:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.U()
            if (r0 == 0) goto L_0x02f0
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r0 = r0.f4192e
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.f4330e
            boolean r1 = r0.f4282j
            if (r1 == 0) goto L_0x02f0
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r8.f4327b
            float r1 = r1.B
            int r0 = r0.f4279g
            float r0 = (float) r0
            float r0 = r0 * r1
            float r0 = r0 + r11
            int r0 = (int) r0
            goto L_0x007b
        L_0x02f0:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f4333h
            boolean r1 = r0.f4275c
            if (r1 == 0) goto L_0x0412
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f4334i
            boolean r2 = r1.f4275c
            if (r2 != 0) goto L_0x02fe
            goto L_0x0412
        L_0x02fe:
            boolean r0 = r0.f4282j
            if (r0 == 0) goto L_0x030d
            boolean r0 = r1.f4282j
            if (r0 == 0) goto L_0x030d
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f4330e
            boolean r0 = r0.f4282j
            if (r0 == 0) goto L_0x030d
            return
        L_0x030d:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f4330e
            boolean r0 = r0.f4282j
            if (r0 != 0) goto L_0x0357
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r8.f4329d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x0357
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f4327b
            int r1 = r0.w
            if (r1 != 0) goto L_0x0357
            boolean r0 = r0.B0()
            if (r0 != 0) goto L_0x0357
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f4333h
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f4284l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f4334i
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.f4284l
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r0 = r0.f4279g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.f4333h
            int r3 = r2.f4278f
            int r0 = r0 + r3
            int r1 = r1.f4279g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r8.f4334i
            int r3 = r3.f4278f
            int r1 = r1 + r3
            int r3 = r1 - r0
            r2.e(r0)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f4334i
            r0.e(r1)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f4330e
            r0.e(r3)
            return
        L_0x0357:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f4330e
            boolean r0 = r0.f4282j
            if (r0 != 0) goto L_0x03bb
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r8.f4329d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x03bb
            int r0 = r8.f4326a
            if (r0 != r9) goto L_0x03bb
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f4333h
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f4284l
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x03bb
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f4334i
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f4284l
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x03bb
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f4333h
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f4284l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f4334i
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.f4284l
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r0 = r0.f4279g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.f4333h
            int r2 = r2.f4278f
            int r0 = r0 + r2
            int r1 = r1.f4279g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.f4334i
            int r2 = r2.f4278f
            int r1 = r1 + r2
            int r1 = r1 - r0
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f4330e
            int r0 = r0.f4285m
            int r0 = java.lang.Math.min(r1, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r8.f4327b
            int r2 = r1.A
            int r1 = r1.z
            int r0 = java.lang.Math.max(r1, r0)
            if (r2 <= 0) goto L_0x03b6
            int r0 = java.lang.Math.min(r2, r0)
        L_0x03b6:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r8.f4330e
            r1.e(r0)
        L_0x03bb:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f4330e
            boolean r0 = r0.f4282j
            if (r0 != 0) goto L_0x03c2
            return
        L_0x03c2:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f4333h
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f4284l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f4334i
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.f4284l
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r2 = r0.f4279g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r8.f4333h
            int r3 = r3.f4278f
            int r2 = r2 + r3
            int r3 = r1.f4279g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r8.f4334i
            int r4 = r4.f4278f
            int r3 = r3 + r4
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r8.f4327b
            float r4 = r4.E()
            if (r0 != r1) goto L_0x03f2
            int r2 = r0.f4279g
            int r3 = r1.f4279g
            r4 = 1056964608(0x3f000000, float:0.5)
        L_0x03f2:
            int r3 = r3 - r2
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r8.f4330e
            int r0 = r0.f4279g
            int r3 = r3 - r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f4333h
            float r1 = (float) r2
            float r1 = r1 + r11
            float r2 = (float) r3
            float r2 = r2 * r4
            float r1 = r1 + r2
            int r1 = (int) r1
            r0.e(r1)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f4334i
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f4333h
            int r1 = r1.f4279g
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r8.f4330e
            int r2 = r2.f4279g
            int r1 = r1 + r2
            r0.e(r1)
        L_0x0412:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun.a(androidx.constraintlayout.core.widgets.analyzer.Dependency):void");
    }

    /* access modifiers changed from: package-private */
    public void d() {
        int i2;
        DependencyNode dependencyNode;
        DependencyNode dependencyNode2;
        DependencyNode dependencyNode3;
        ConstraintAnchor constraintAnchor;
        List list;
        Object obj;
        DependencyNode dependencyNode4;
        int i3;
        DependencyNode dependencyNode5;
        DependencyNode dependencyNode6;
        int i4;
        DependencyNode dependencyNode7;
        DependencyNode dependencyNode8;
        ConstraintWidget U;
        ConstraintWidget U2;
        ConstraintWidget constraintWidget = this.f4327b;
        if (constraintWidget.f4188a) {
            this.f4330e.e(constraintWidget.m0());
        }
        if (!this.f4330e.f4282j) {
            ConstraintWidget.DimensionBehaviour H = this.f4327b.H();
            this.f4329d = H;
            if (H != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (H == dimensionBehaviour && (U2 = this.f4327b.U()) != null && (U2.H() == ConstraintWidget.DimensionBehaviour.FIXED || U2.H() == dimensionBehaviour)) {
                    int m0 = (U2.m0() - this.f4327b.Q.g()) - this.f4327b.S.g();
                    b(this.f4333h, U2.f4192e.f4333h, this.f4327b.Q.g());
                    b(this.f4334i, U2.f4192e.f4334i, -this.f4327b.S.g());
                    this.f4330e.e(m0);
                    return;
                } else if (this.f4329d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f4330e.e(this.f4327b.m0());
                }
            }
        } else {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.f4329d;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour2 == dimensionBehaviour3 && (U = this.f4327b.U()) != null && (U.H() == ConstraintWidget.DimensionBehaviour.FIXED || U.H() == dimensionBehaviour3)) {
                b(this.f4333h, U.f4192e.f4333h, this.f4327b.Q.g());
                b(this.f4334i, U.f4192e.f4334i, -this.f4327b.S.g());
                return;
            }
        }
        DimensionDependency dimensionDependency = this.f4330e;
        if (dimensionDependency.f4282j) {
            ConstraintWidget constraintWidget2 = this.f4327b;
            if (constraintWidget2.f4188a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.Y;
                ConstraintAnchor constraintAnchor2 = constraintAnchorArr[0];
                ConstraintAnchor constraintAnchor3 = constraintAnchor2.f4183f;
                if (constraintAnchor3 == null || constraintAnchorArr[1].f4183f == null) {
                    if (constraintAnchor3 != null) {
                        dependencyNode8 = h(constraintAnchor2);
                        if (dependencyNode8 != null) {
                            dependencyNode7 = this.f4333h;
                            i4 = this.f4327b.Y[0].g();
                        } else {
                            return;
                        }
                    } else {
                        ConstraintAnchor constraintAnchor4 = constraintAnchorArr[1];
                        if (constraintAnchor4.f4183f != null) {
                            DependencyNode h2 = h(constraintAnchor4);
                            if (h2 != null) {
                                b(this.f4334i, h2, -this.f4327b.Y[1].g());
                                dependencyNode6 = this.f4333h;
                                dependencyNode5 = this.f4334i;
                                i3 = -this.f4330e.f4279g;
                                b(dependencyNode6, dependencyNode5, i3);
                                return;
                            }
                            return;
                        } else if (!(constraintWidget2 instanceof Helper) && constraintWidget2.U() != null && this.f4327b.r(ConstraintAnchor.Type.CENTER).f4183f == null) {
                            dependencyNode8 = this.f4327b.U().f4192e.f4333h;
                            dependencyNode7 = this.f4333h;
                            i4 = this.f4327b.o0();
                        } else {
                            return;
                        }
                    }
                    b(dependencyNode7, dependencyNode8, i4);
                    dependencyNode6 = this.f4334i;
                    dependencyNode5 = this.f4333h;
                    i3 = this.f4330e.f4279g;
                    b(dependencyNode6, dependencyNode5, i3);
                    return;
                } else if (constraintWidget2.B0()) {
                    this.f4333h.f4278f = this.f4327b.Y[0].g();
                    dependencyNode3 = this.f4334i;
                    constraintAnchor = this.f4327b.Y[1];
                    dependencyNode3.f4278f = -constraintAnchor.g();
                } else {
                    DependencyNode h3 = h(this.f4327b.Y[0]);
                    if (h3 != null) {
                        b(this.f4333h, h3, this.f4327b.Y[0].g());
                    }
                    DependencyNode h4 = h(this.f4327b.Y[1]);
                    if (h4 != null) {
                        b(this.f4334i, h4, -this.f4327b.Y[1].g());
                    }
                    this.f4333h.f4274b = true;
                    this.f4334i.f4274b = true;
                    return;
                }
            }
        }
        if (this.f4329d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.f4327b;
            int i5 = constraintWidget3.w;
            if (i5 == 2) {
                ConstraintWidget U3 = constraintWidget3.U();
                if (U3 != null) {
                    DimensionDependency dimensionDependency2 = U3.f4193f.f4330e;
                    this.f4330e.f4284l.add(dimensionDependency2);
                    dimensionDependency2.f4283k.add(this.f4330e);
                    DimensionDependency dimensionDependency3 = this.f4330e;
                    dimensionDependency3.f4274b = true;
                    dimensionDependency3.f4283k.add(this.f4333h);
                    list = this.f4330e.f4283k;
                    obj = this.f4334i;
                }
            } else if (i5 == 3) {
                if (constraintWidget3.x == 3) {
                    this.f4333h.f4273a = this;
                    this.f4334i.f4273a = this;
                    VerticalWidgetRun verticalWidgetRun = constraintWidget3.f4193f;
                    verticalWidgetRun.f4333h.f4273a = this;
                    verticalWidgetRun.f4334i.f4273a = this;
                    dimensionDependency.f4273a = this;
                    if (constraintWidget3.D0()) {
                        this.f4330e.f4284l.add(this.f4327b.f4193f.f4330e);
                        this.f4327b.f4193f.f4330e.f4283k.add(this.f4330e);
                        VerticalWidgetRun verticalWidgetRun2 = this.f4327b.f4193f;
                        verticalWidgetRun2.f4330e.f4273a = this;
                        this.f4330e.f4284l.add(verticalWidgetRun2.f4333h);
                        this.f4330e.f4284l.add(this.f4327b.f4193f.f4334i);
                        this.f4327b.f4193f.f4333h.f4283k.add(this.f4330e);
                        list = this.f4327b.f4193f.f4334i.f4283k;
                    } else if (this.f4327b.B0()) {
                        this.f4327b.f4193f.f4330e.f4284l.add(this.f4330e);
                        list = this.f4330e.f4283k;
                        obj = this.f4327b.f4193f.f4330e;
                    } else {
                        dependencyNode4 = this.f4327b.f4193f.f4330e;
                        list = dependencyNode4.f4284l;
                    }
                } else {
                    DimensionDependency dimensionDependency4 = constraintWidget3.f4193f.f4330e;
                    dimensionDependency.f4284l.add(dimensionDependency4);
                    dimensionDependency4.f4283k.add(this.f4330e);
                    this.f4327b.f4193f.f4333h.f4283k.add(this.f4330e);
                    this.f4327b.f4193f.f4334i.f4283k.add(this.f4330e);
                    DimensionDependency dimensionDependency5 = this.f4330e;
                    dimensionDependency5.f4274b = true;
                    dimensionDependency5.f4283k.add(this.f4333h);
                    this.f4330e.f4283k.add(this.f4334i);
                    this.f4333h.f4284l.add(this.f4330e);
                    dependencyNode4 = this.f4334i;
                    list = dependencyNode4.f4284l;
                }
                obj = this.f4330e;
            }
            list.add(obj);
        }
        ConstraintWidget constraintWidget4 = this.f4327b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget4.Y;
        ConstraintAnchor constraintAnchor5 = constraintAnchorArr2[0];
        ConstraintAnchor constraintAnchor6 = constraintAnchor5.f4183f;
        if (constraintAnchor6 == null || constraintAnchorArr2[1].f4183f == null) {
            if (constraintAnchor6 != null) {
                dependencyNode2 = h(constraintAnchor5);
                if (dependencyNode2 != null) {
                    dependencyNode = this.f4333h;
                    i2 = this.f4327b.Y[0].g();
                } else {
                    return;
                }
            } else {
                ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[1];
                if (constraintAnchor7.f4183f != null) {
                    DependencyNode h5 = h(constraintAnchor7);
                    if (h5 != null) {
                        b(this.f4334i, h5, -this.f4327b.Y[1].g());
                        c(this.f4333h, this.f4334i, -1, this.f4330e);
                        return;
                    }
                    return;
                } else if (!(constraintWidget4 instanceof Helper) && constraintWidget4.U() != null) {
                    dependencyNode2 = this.f4327b.U().f4192e.f4333h;
                    dependencyNode = this.f4333h;
                    i2 = this.f4327b.o0();
                } else {
                    return;
                }
            }
            b(dependencyNode, dependencyNode2, i2);
            c(this.f4334i, this.f4333h, 1, this.f4330e);
        } else if (constraintWidget4.B0()) {
            this.f4333h.f4278f = this.f4327b.Y[0].g();
            dependencyNode3 = this.f4334i;
            constraintAnchor = this.f4327b.Y[1];
            dependencyNode3.f4278f = -constraintAnchor.g();
        } else {
            DependencyNode h6 = h(this.f4327b.Y[0]);
            DependencyNode h7 = h(this.f4327b.Y[1]);
            if (h6 != null) {
                h6.b(this);
            }
            if (h7 != null) {
                h7.b(this);
            }
            this.f4335j = WidgetRun.RunType.CENTER;
        }
    }

    public void e() {
        DependencyNode dependencyNode = this.f4333h;
        if (dependencyNode.f4282j) {
            this.f4327b.f2(dependencyNode.f4279g);
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f4328c = null;
        this.f4333h.c();
        this.f4334i.c();
        this.f4330e.c();
        this.f4332g = false;
    }

    /* access modifiers changed from: package-private */
    public void n() {
        this.f4332g = false;
        this.f4333h.c();
        this.f4333h.f4282j = false;
        this.f4334i.c();
        this.f4334i.f4282j = false;
        this.f4330e.f4282j = false;
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return this.f4329d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f4327b.w == 0;
    }

    public String toString() {
        return "HorizontalRun " + this.f4327b.y();
    }
}
