package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

public abstract class WidgetRun implements Dependency {

    /* renamed from: a  reason: collision with root package name */
    public int f4326a;

    /* renamed from: b  reason: collision with root package name */
    ConstraintWidget f4327b;

    /* renamed from: c  reason: collision with root package name */
    RunGroup f4328c;

    /* renamed from: d  reason: collision with root package name */
    protected ConstraintWidget.DimensionBehaviour f4329d;

    /* renamed from: e  reason: collision with root package name */
    DimensionDependency f4330e = new DimensionDependency(this);

    /* renamed from: f  reason: collision with root package name */
    public int f4331f = 0;

    /* renamed from: g  reason: collision with root package name */
    boolean f4332g = false;

    /* renamed from: h  reason: collision with root package name */
    public DependencyNode f4333h = new DependencyNode(this);

    /* renamed from: i  reason: collision with root package name */
    public DependencyNode f4334i = new DependencyNode(this);

    /* renamed from: j  reason: collision with root package name */
    protected RunType f4335j = RunType.NONE;

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.WidgetRun$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4336a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type[] r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4336a = r0
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4336a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4336a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4336a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f4336a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.WidgetRun.AnonymousClass1.<clinit>():void");
        }
    }

    enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.f4327b = constraintWidget;
    }

    private void o(int i2, int i3) {
        DimensionDependency dimensionDependency;
        int g2;
        int i4 = this.f4326a;
        if (i4 != 0) {
            if (i4 == 1) {
                int g3 = g(this.f4330e.f4285m, i2);
                dimensionDependency = this.f4330e;
                g2 = Math.min(g3, i3);
                dimensionDependency.e(g2);
            } else if (i4 == 2) {
                ConstraintWidget U = this.f4327b.U();
                if (U != null) {
                    DimensionDependency dimensionDependency2 = (i2 == 0 ? U.f4192e : U.f4193f).f4330e;
                    if (dimensionDependency2.f4282j) {
                        ConstraintWidget constraintWidget = this.f4327b;
                        i3 = (int) ((((float) dimensionDependency2.f4279g) * (i2 == 0 ? constraintWidget.B : constraintWidget.E)) + 0.5f);
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else if (i4 == 3) {
                ConstraintWidget constraintWidget2 = this.f4327b;
                WidgetRun widgetRun = constraintWidget2.f4192e;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = widgetRun.f4329d;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour == dimensionBehaviour2 && widgetRun.f4326a == 3) {
                    VerticalWidgetRun verticalWidgetRun = constraintWidget2.f4193f;
                    if (verticalWidgetRun.f4329d == dimensionBehaviour2 && verticalWidgetRun.f4326a == 3) {
                        return;
                    }
                }
                if (i2 == 0) {
                    widgetRun = constraintWidget2.f4193f;
                }
                if (widgetRun.f4330e.f4282j) {
                    float A = constraintWidget2.A();
                    this.f4330e.e(i2 == 1 ? (int) ((((float) widgetRun.f4330e.f4279g) / A) + 0.5f) : (int) ((A * ((float) widgetRun.f4330e.f4279g)) + 0.5f));
                    return;
                }
                return;
            } else {
                return;
            }
        }
        dimensionDependency = this.f4330e;
        g2 = g(i3, i2);
        dimensionDependency.e(g2);
    }

    public void a(Dependency dependency) {
    }

    /* access modifiers changed from: protected */
    public final void b(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i2) {
        dependencyNode.f4284l.add(dependencyNode2);
        dependencyNode.f4278f = i2;
        dependencyNode2.f4283k.add(dependencyNode);
    }

    /* access modifiers changed from: protected */
    public final void c(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i2, DimensionDependency dimensionDependency) {
        dependencyNode.f4284l.add(dependencyNode2);
        dependencyNode.f4284l.add(this.f4330e);
        dependencyNode.f4280h = i2;
        dependencyNode.f4281i = dimensionDependency;
        dependencyNode2.f4283k.add(dependencyNode);
        dimensionDependency.f4283k.add(dependencyNode);
    }

    /* access modifiers changed from: package-private */
    public abstract void d();

    /* access modifiers changed from: package-private */
    public abstract void e();

    /* access modifiers changed from: package-private */
    public abstract void f();

    /* access modifiers changed from: protected */
    public final int g(int i2, int i3) {
        int i4;
        if (i3 == 0) {
            ConstraintWidget constraintWidget = this.f4327b;
            int i5 = constraintWidget.A;
            i4 = Math.max(constraintWidget.z, i2);
            if (i5 > 0) {
                i4 = Math.min(i5, i2);
            }
            if (i4 == i2) {
                return i2;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.f4327b;
            int i6 = constraintWidget2.D;
            int max = Math.max(constraintWidget2.C, i2);
            if (i6 > 0) {
                max = Math.min(i6, i2);
            }
            if (i4 == i2) {
                return i2;
            }
        }
        return i4;
    }

    /* access modifiers changed from: protected */
    public final DependencyNode h(ConstraintAnchor constraintAnchor) {
        WidgetRun widgetRun;
        WidgetRun widgetRun2;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f4183f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f4181d;
        int i2 = AnonymousClass1.f4336a[constraintAnchor2.f4182e.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                widgetRun2 = constraintWidget.f4192e;
            } else if (i2 == 3) {
                widgetRun = constraintWidget.f4193f;
            } else if (i2 == 4) {
                return constraintWidget.f4193f.f4307k;
            } else {
                if (i2 != 5) {
                    return null;
                }
                widgetRun2 = constraintWidget.f4193f;
            }
            return widgetRun2.f4334i;
        }
        widgetRun = constraintWidget.f4192e;
        return widgetRun.f4333h;
    }

    /* access modifiers changed from: protected */
    public final DependencyNode i(ConstraintAnchor constraintAnchor, int i2) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f4183f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f4181d;
        WidgetRun widgetRun = i2 == 0 ? constraintWidget.f4192e : constraintWidget.f4193f;
        int i3 = AnonymousClass1.f4336a[constraintAnchor2.f4182e.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.f4334i;
        }
        return widgetRun.f4333h;
    }

    public long j() {
        DimensionDependency dimensionDependency = this.f4330e;
        if (dimensionDependency.f4282j) {
            return (long) dimensionDependency.f4279g;
        }
        return 0;
    }

    public boolean k() {
        int size = this.f4333h.f4284l.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f4333h.f4284l.get(i3).f4276d != this) {
                i2++;
            }
        }
        int size2 = this.f4334i.f4284l.size();
        for (int i4 = 0; i4 < size2; i4++) {
            if (this.f4334i.f4284l.get(i4).f4276d != this) {
                i2++;
            }
        }
        return i2 >= 2;
    }

    public boolean l() {
        return this.f4330e.f4282j;
    }

    public boolean m() {
        return this.f4332g;
    }

    /* access modifiers changed from: package-private */
    public abstract void n();

    /* access modifiers changed from: package-private */
    public abstract boolean p();

    /* access modifiers changed from: protected */
    public void q(Dependency dependency, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i2) {
        DependencyNode dependencyNode;
        DependencyNode h2 = h(constraintAnchor);
        DependencyNode h3 = h(constraintAnchor2);
        if (h2.f4282j && h3.f4282j) {
            int g2 = h2.f4279g + constraintAnchor.g();
            int g3 = h3.f4279g - constraintAnchor2.g();
            int i3 = g3 - g2;
            if (!this.f4330e.f4282j && this.f4329d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                o(i2, i3);
            }
            DimensionDependency dimensionDependency = this.f4330e;
            if (dimensionDependency.f4282j) {
                if (dimensionDependency.f4279g == i3) {
                    this.f4333h.e(g2);
                    dependencyNode = this.f4334i;
                } else {
                    ConstraintWidget constraintWidget = this.f4327b;
                    float E = i2 == 0 ? constraintWidget.E() : constraintWidget.g0();
                    if (h2 == h3) {
                        g2 = h2.f4279g;
                        g3 = h3.f4279g;
                        E = 0.5f;
                    }
                    this.f4333h.e((int) (((float) g2) + 0.5f + (((float) ((g3 - g2) - this.f4330e.f4279g)) * E)));
                    dependencyNode = this.f4334i;
                    g3 = this.f4333h.f4279g + this.f4330e.f4279g;
                }
                dependencyNode.e(g3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void r(Dependency dependency) {
    }

    /* access modifiers changed from: protected */
    public void s(Dependency dependency) {
    }

    public long t(int i2) {
        int i3;
        DimensionDependency dimensionDependency = this.f4330e;
        if (!dimensionDependency.f4282j) {
            return 0;
        }
        long j2 = (long) dimensionDependency.f4279g;
        if (k()) {
            i3 = this.f4333h.f4278f - this.f4334i.f4278f;
        } else if (i2 != 0) {
            return j2 - ((long) this.f4334i.f4278f);
        } else {
            i3 = this.f4333h.f4278f;
        }
        return j2 + ((long) i3);
    }
}
