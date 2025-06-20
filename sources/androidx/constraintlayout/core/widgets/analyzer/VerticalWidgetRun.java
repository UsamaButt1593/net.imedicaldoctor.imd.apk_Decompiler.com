package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;

public class VerticalWidgetRun extends WidgetRun {

    /* renamed from: k  reason: collision with root package name */
    public DependencyNode f4307k;

    /* renamed from: l  reason: collision with root package name */
    DimensionDependency f4308l = null;

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4309a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType[] r0 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4309a = r0
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4309a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4309a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun.AnonymousClass1.<clinit>():void");
        }
    }

    public VerticalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        DependencyNode dependencyNode = new DependencyNode(this);
        this.f4307k = dependencyNode;
        this.f4333h.f4277e = DependencyNode.Type.TOP;
        this.f4334i.f4277e = DependencyNode.Type.BOTTOM;
        dependencyNode.f4277e = DependencyNode.Type.BASELINE;
        this.f4331f = 1;
    }

    public void a(Dependency dependency) {
        int i2;
        float f2;
        int i3 = AnonymousClass1.f4309a[this.f4335j.ordinal()];
        if (i3 == 1) {
            s(dependency);
        } else if (i3 == 2) {
            r(dependency);
        } else if (i3 == 3) {
            ConstraintWidget constraintWidget = this.f4327b;
            q(dependency, constraintWidget.R, constraintWidget.T, 1);
            return;
        }
        DimensionDependency dimensionDependency = this.f4330e;
        if (dimensionDependency.f4275c && !dimensionDependency.f4282j && this.f4329d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget2 = this.f4327b;
            int i4 = constraintWidget2.x;
            if (i4 == 2) {
                ConstraintWidget U = constraintWidget2.U();
                if (U != null) {
                    DimensionDependency dimensionDependency2 = U.f4193f.f4330e;
                    if (dimensionDependency2.f4282j) {
                        i2 = (int) ((((float) dimensionDependency2.f4279g) * this.f4327b.E) + 0.5f);
                    }
                }
            } else if (i4 == 3 && constraintWidget2.f4192e.f4330e.f4282j) {
                int B = constraintWidget2.B();
                if (B != -1) {
                    if (B == 0) {
                        ConstraintWidget constraintWidget3 = this.f4327b;
                        f2 = ((float) constraintWidget3.f4192e.f4330e.f4279g) * constraintWidget3.A();
                        i2 = (int) (f2 + 0.5f);
                    } else if (B != 1) {
                        i2 = 0;
                    }
                }
                ConstraintWidget constraintWidget4 = this.f4327b;
                f2 = ((float) constraintWidget4.f4192e.f4330e.f4279g) / constraintWidget4.A();
                i2 = (int) (f2 + 0.5f);
            }
            this.f4330e.e(i2);
        }
        DependencyNode dependencyNode = this.f4333h;
        if (dependencyNode.f4275c) {
            DependencyNode dependencyNode2 = this.f4334i;
            if (dependencyNode2.f4275c) {
                if (!dependencyNode.f4282j || !dependencyNode2.f4282j || !this.f4330e.f4282j) {
                    if (!this.f4330e.f4282j && this.f4329d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        ConstraintWidget constraintWidget5 = this.f4327b;
                        if (constraintWidget5.w == 0 && !constraintWidget5.D0()) {
                            int i5 = this.f4333h.f4284l.get(0).f4279g;
                            DependencyNode dependencyNode3 = this.f4333h;
                            int i6 = i5 + dependencyNode3.f4278f;
                            int i7 = this.f4334i.f4284l.get(0).f4279g + this.f4334i.f4278f;
                            dependencyNode3.e(i6);
                            this.f4334i.e(i7);
                            this.f4330e.e(i7 - i6);
                            return;
                        }
                    }
                    if (!this.f4330e.f4282j && this.f4329d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.f4326a == 1 && this.f4333h.f4284l.size() > 0 && this.f4334i.f4284l.size() > 0) {
                        int i8 = (this.f4334i.f4284l.get(0).f4279g + this.f4334i.f4278f) - (this.f4333h.f4284l.get(0).f4279g + this.f4333h.f4278f);
                        DimensionDependency dimensionDependency3 = this.f4330e;
                        int i9 = dimensionDependency3.f4285m;
                        if (i8 < i9) {
                            dimensionDependency3.e(i8);
                        } else {
                            dimensionDependency3.e(i9);
                        }
                    }
                    if (this.f4330e.f4282j && this.f4333h.f4284l.size() > 0 && this.f4334i.f4284l.size() > 0) {
                        DependencyNode dependencyNode4 = this.f4333h.f4284l.get(0);
                        DependencyNode dependencyNode5 = this.f4334i.f4284l.get(0);
                        int i10 = dependencyNode4.f4279g + this.f4333h.f4278f;
                        int i11 = dependencyNode5.f4279g + this.f4334i.f4278f;
                        float g0 = this.f4327b.g0();
                        if (dependencyNode4 == dependencyNode5) {
                            i10 = dependencyNode4.f4279g;
                            i11 = dependencyNode5.f4279g;
                            g0 = 0.5f;
                        }
                        this.f4333h.e((int) (((float) i10) + 0.5f + (((float) ((i11 - i10) - this.f4330e.f4279g)) * g0)));
                        this.f4334i.e(this.f4333h.f4279g + this.f4330e.f4279g);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02dd, code lost:
        if (r10.f4327b.q0() != false) goto L_0x02df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0332, code lost:
        if (r0.f4329d == r1) goto L_0x03d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0362, code lost:
        if (r10.f4327b.q0() != false) goto L_0x02df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x03d7, code lost:
        if (r0.f4329d == r1) goto L_0x03d9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x03fd  */
    /* JADX WARNING: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d() {
        /*
            r10 = this;
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            boolean r1 = r0.f4188a
            if (r1 == 0) goto L_0x000f
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r10.f4330e
            int r0 = r0.D()
            r1.e(r0)
        L_0x000f:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r10.f4330e
            boolean r0 = r0.f4282j
            if (r0 != 0) goto L_0x0097
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r0.j0()
            r10.f4329d = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            boolean r0 = r0.q0()
            if (r0 == 0) goto L_0x002c
            androidx.constraintlayout.core.widgets.analyzer.BaselineDimensionDependency r0 = new androidx.constraintlayout.core.widgets.analyzer.BaselineDimensionDependency
            r0.<init>(r10)
            r10.f4308l = r0
        L_0x002c:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r10.f4329d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 == r1) goto L_0x00d1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r0 != r1) goto L_0x0085
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.U()
            if (r0 == 0) goto L_0x0085
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = r0.j0()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r1 != r2) goto L_0x0085
            int r1 = r0.D()
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.R
            int r2 = r2.g()
            int r1 = r1 - r2
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.T
            int r2 = r2.g()
            int r1 = r1 - r2
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r10.f4333h
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r3 = r0.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r3.f4333h
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.R
            int r4 = r4.g()
            r10.b(r2, r3, r4)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r10.f4334i
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f4334i
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.T
            int r3 = r3.g()
            int r3 = -r3
            r10.b(r2, r0, r3)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r10.f4330e
            r0.e(r1)
            return
        L_0x0085:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r10.f4329d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r0 != r1) goto L_0x00d1
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r10.f4330e
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r10.f4327b
            int r1 = r1.D()
            r0.e(r1)
            goto L_0x00d1
        L_0x0097:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r10.f4329d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r0 != r1) goto L_0x00d1
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.U()
            if (r0 == 0) goto L_0x00d1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = r0.j0()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r1 != r2) goto L_0x00d1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4333h
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r2 = r0.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r2.f4333h
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.R
            int r3 = r3.g()
            r10.b(r1, r2, r3)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4334i
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f4334i
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.T
            int r2 = r2.g()
            int r2 = -r2
            r10.b(r1, r0, r2)
            return
        L_0x00d1:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r10.f4330e
            boolean r1 = r0.f4282j
            r2 = 0
            r3 = 4
            r4 = 2
            r5 = 1
            r6 = 3
            if (r1 == 0) goto L_0x022f
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r10.f4327b
            boolean r8 = r7.f4188a
            if (r8 == 0) goto L_0x022f
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r7.Y
            r1 = r0[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.f4183f
            if (r8 == 0) goto L_0x016a
            r9 = r0[r6]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.f4183f
            if (r9 == 0) goto L_0x016a
            boolean r0 = r7.D0()
            if (r0 == 0) goto L_0x0114
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.f4333h
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r1.Y
            r1 = r1[r4]
            int r1 = r1.g()
            r0.f4278f = r1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.f4334i
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r1.Y
            r1 = r1[r6]
            int r1 = r1.g()
            int r1 = -r1
            r0.f4278f = r1
            goto L_0x0153
        L_0x0114:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r0.Y
            r0 = r0[r4]
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.h(r0)
            if (r0 == 0) goto L_0x012f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4333h
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r2.Y
            r2 = r2[r4]
            int r2 = r2.g()
            r10.b(r1, r0, r2)
        L_0x012f:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r0.Y
            r0 = r0[r6]
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.h(r0)
            if (r0 == 0) goto L_0x014b
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4334i
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r2.Y
            r2 = r2[r6]
            int r2 = r2.g()
            int r2 = -r2
            r10.b(r1, r0, r2)
        L_0x014b:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.f4333h
            r0.f4274b = r5
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.f4334i
            r0.f4274b = r5
        L_0x0153:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            boolean r0 = r0.q0()
            if (r0 == 0) goto L_0x0401
        L_0x015b:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.f4307k
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4333h
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r10.f4327b
            int r2 = r2.t()
        L_0x0165:
            r10.b(r0, r1, r2)
            goto L_0x0401
        L_0x016a:
            if (r8 == 0) goto L_0x0195
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.h(r1)
            if (r0 == 0) goto L_0x0401
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4333h
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r2.Y
            r2 = r2[r4]
            int r2 = r2.g()
            r10.b(r1, r0, r2)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.f4334i
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4333h
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r10.f4330e
            int r2 = r2.f4279g
            r10.b(r0, r1, r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            boolean r0 = r0.q0()
            if (r0 == 0) goto L_0x0401
            goto L_0x015b
        L_0x0195:
            r1 = r0[r6]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r1.f4183f
            if (r4 == 0) goto L_0x01c6
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.h(r1)
            if (r0 == 0) goto L_0x01bd
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4334i
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r2.Y
            r2 = r2[r6]
            int r2 = r2.g()
            int r2 = -r2
            r10.b(r1, r0, r2)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.f4333h
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4334i
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r10.f4330e
            int r2 = r2.f4279g
            int r2 = -r2
            r10.b(r0, r1, r2)
        L_0x01bd:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            boolean r0 = r0.q0()
            if (r0 == 0) goto L_0x0401
            goto L_0x015b
        L_0x01c6:
            r0 = r0[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.f4183f
            if (r1 == 0) goto L_0x01ef
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.h(r0)
            if (r0 == 0) goto L_0x0401
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4307k
            r10.b(r1, r0, r2)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.f4333h
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4307k
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r10.f4327b
            int r2 = r2.t()
            int r2 = -r2
            r10.b(r0, r1, r2)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.f4334i
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4333h
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r10.f4330e
            int r2 = r2.f4279g
            goto L_0x0165
        L_0x01ef:
            boolean r0 = r7 instanceof androidx.constraintlayout.core.widgets.Helper
            if (r0 != 0) goto L_0x0401
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r7.U()
            if (r0 == 0) goto L_0x0401
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.r(r1)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.f4183f
            if (r0 != 0) goto L_0x0401
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.U()
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f4333h
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4333h
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r10.f4327b
            int r2 = r2.p0()
            r10.b(r1, r0, r2)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.f4334i
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4333h
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r10.f4330e
            int r2 = r2.f4279g
            r10.b(r0, r1, r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            boolean r0 = r0.q0()
            if (r0 == 0) goto L_0x0401
            goto L_0x015b
        L_0x022f:
            if (r1 != 0) goto L_0x027e
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = r10.f4329d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r7) goto L_0x027e
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            int r1 = r0.x
            if (r1 == r4) goto L_0x0274
            if (r1 == r6) goto L_0x0240
            goto L_0x0281
        L_0x0240:
            boolean r0 = r0.D0()
            if (r0 != 0) goto L_0x0281
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            int r1 = r0.w
            if (r1 != r6) goto L_0x024d
            goto L_0x0281
        L_0x024d:
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r0 = r0.f4192e
        L_0x024f:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.f4330e
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r10.f4330e
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.f4284l
            r1.add(r0)
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.Dependency> r0 = r0.f4283k
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r10.f4330e
            r0.add(r1)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r10.f4330e
            r0.f4274b = r5
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.Dependency> r0 = r0.f4283k
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4333h
            r0.add(r1)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r10.f4330e
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.Dependency> r0 = r0.f4283k
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4334i
            r0.add(r1)
            goto L_0x0281
        L_0x0274:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.U()
            if (r0 != 0) goto L_0x027b
            goto L_0x0281
        L_0x027b:
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.f4193f
            goto L_0x024f
        L_0x027e:
            r0.b(r10)
        L_0x0281:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r0.Y
            r7 = r1[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r7.f4183f
            if (r8 == 0) goto L_0x02ea
            r9 = r1[r6]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.f4183f
            if (r9 == 0) goto L_0x02ea
            boolean r0 = r0.D0()
            if (r0 == 0) goto L_0x02b5
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.f4333h
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r1.Y
            r1 = r1[r4]
            int r1 = r1.g()
            r0.f4278f = r1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.f4334i
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r1.Y
            r1 = r1[r6]
            int r1 = r1.g()
            int r1 = -r1
            r0.f4278f = r1
            goto L_0x02d7
        L_0x02b5:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r0.Y
            r0 = r0[r4]
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.h(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r1.Y
            r1 = r1[r6]
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.h(r1)
            if (r0 == 0) goto L_0x02ce
            r0.b(r10)
        L_0x02ce:
            if (r1 == 0) goto L_0x02d3
            r1.b(r10)
        L_0x02d3:
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r0 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.CENTER
            r10.f4335j = r0
        L_0x02d7:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            boolean r0 = r0.q0()
            if (r0 == 0) goto L_0x03f3
        L_0x02df:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.f4307k
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4333h
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r10.f4308l
        L_0x02e5:
            r10.c(r0, r1, r5, r2)
            goto L_0x03f3
        L_0x02ea:
            r9 = 0
            if (r8 == 0) goto L_0x0336
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.h(r7)
            if (r0 == 0) goto L_0x03f3
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4333h
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r2.Y
            r2 = r2[r4]
            int r2 = r2.g()
            r10.b(r1, r0, r2)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.f4334i
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4333h
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r10.f4330e
            r10.c(r0, r1, r5, r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            boolean r0 = r0.q0()
            if (r0 == 0) goto L_0x031c
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.f4307k
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4333h
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r10.f4308l
            r10.c(r0, r1, r5, r2)
        L_0x031c:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r10.f4329d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x03f3
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            float r0 = r0.A()
            int r0 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x03f3
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r0 = r0.f4192e
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = r0.f4329d
            if (r2 != r1) goto L_0x03f3
            goto L_0x03d9
        L_0x0336:
            r4 = r1[r6]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r4.f4183f
            r8 = -1
            if (r7 == 0) goto L_0x0366
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.h(r4)
            if (r0 == 0) goto L_0x03f3
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4334i
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r2.Y
            r2 = r2[r6]
            int r2 = r2.g()
            int r2 = -r2
            r10.b(r1, r0, r2)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.f4333h
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4334i
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r10.f4330e
            r10.c(r0, r1, r8, r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            boolean r0 = r0.q0()
            if (r0 == 0) goto L_0x03f3
            goto L_0x02df
        L_0x0366:
            r1 = r1[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r1.f4183f
            if (r3 == 0) goto L_0x0388
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.h(r1)
            if (r0 == 0) goto L_0x03f3
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4307k
            r10.b(r1, r0, r2)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.f4333h
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4307k
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r10.f4308l
            r10.c(r0, r1, r8, r2)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.f4334i
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4333h
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r10.f4330e
            goto L_0x02e5
        L_0x0388:
            boolean r1 = r0 instanceof androidx.constraintlayout.core.widgets.Helper
            if (r1 != 0) goto L_0x03f3
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.U()
            if (r0 == 0) goto L_0x03f3
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.U()
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r0 = r0.f4193f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f4333h
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4333h
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r10.f4327b
            int r2 = r2.p0()
            r10.b(r1, r0, r2)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.f4334i
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4333h
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r10.f4330e
            r10.c(r0, r1, r5, r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            boolean r0 = r0.q0()
            if (r0 == 0) goto L_0x03c1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r10.f4307k
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r10.f4333h
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r10.f4308l
            r10.c(r0, r1, r5, r2)
        L_0x03c1:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r10.f4329d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x03f3
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            float r0 = r0.A()
            int r0 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x03f3
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r10.f4327b
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r0 = r0.f4192e
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = r0.f4329d
            if (r2 != r1) goto L_0x03f3
        L_0x03d9:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r0.f4330e
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.Dependency> r0 = r0.f4283k
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r10.f4330e
            r0.add(r1)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r10.f4330e
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f4284l
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r10.f4327b
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r1 = r1.f4192e
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r1.f4330e
            r0.add(r1)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r10.f4330e
            r0.f4273a = r10
        L_0x03f3:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r10.f4330e
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f4284l
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0401
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r0 = r10.f4330e
            r0.f4275c = r5
        L_0x0401:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun.d():void");
    }

    public void e() {
        DependencyNode dependencyNode = this.f4333h;
        if (dependencyNode.f4282j) {
            this.f4327b.g2(dependencyNode.f4279g);
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f4328c = null;
        this.f4333h.c();
        this.f4334i.c();
        this.f4307k.c();
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
        this.f4307k.c();
        this.f4307k.f4282j = false;
        this.f4330e.f4282j = false;
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return this.f4329d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f4327b.x == 0;
    }

    public String toString() {
        return "VerticalRun " + this.f4327b.y();
    }
}
