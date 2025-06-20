package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

class RunGroup {

    /* renamed from: h  reason: collision with root package name */
    public static final int f4296h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static final int f4297i = 1;

    /* renamed from: j  reason: collision with root package name */
    public static final int f4298j = 2;

    /* renamed from: k  reason: collision with root package name */
    public static int f4299k;

    /* renamed from: a  reason: collision with root package name */
    public int f4300a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4301b = false;

    /* renamed from: c  reason: collision with root package name */
    WidgetRun f4302c = null;

    /* renamed from: d  reason: collision with root package name */
    WidgetRun f4303d = null;

    /* renamed from: e  reason: collision with root package name */
    ArrayList<WidgetRun> f4304e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    int f4305f;

    /* renamed from: g  reason: collision with root package name */
    int f4306g;

    public RunGroup(WidgetRun widgetRun, int i2) {
        int i3 = f4299k;
        this.f4305f = i3;
        f4299k = i3 + 1;
        this.f4302c = widgetRun;
        this.f4303d = widgetRun;
        this.f4306g = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0072, code lost:
        r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(androidx.constraintlayout.core.widgets.analyzer.WidgetRun r6, int r7) {
        /*
            r5 = this;
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r6.f4327b
            boolean[] r0 = r0.f4194g
            boolean r0 = r0[r7]
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r6.f4333h
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.Dependency> r0 = r0.f4283k
            java.util.Iterator r0 = r0.iterator()
        L_0x0012:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x005a
            java.lang.Object r2 = r0.next()
            androidx.constraintlayout.core.widgets.analyzer.Dependency r2 = (androidx.constraintlayout.core.widgets.analyzer.Dependency) r2
            boolean r3 = r2 instanceof androidx.constraintlayout.core.widgets.analyzer.DependencyNode
            if (r3 == 0) goto L_0x0012
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r3 = r2.f4276d
            if (r3 != r6) goto L_0x0029
            goto L_0x0012
        L_0x0029:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r3.f4333h
            if (r2 != r3) goto L_0x0012
            boolean r3 = r6 instanceof androidx.constraintlayout.core.widgets.analyzer.ChainRun
            if (r3 == 0) goto L_0x004a
            r3 = r6
            androidx.constraintlayout.core.widgets.analyzer.ChainRun r3 = (androidx.constraintlayout.core.widgets.analyzer.ChainRun) r3
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r3 = r3.f4261k
            java.util.Iterator r3 = r3.iterator()
        L_0x003a:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0054
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r4 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r4
            r5.c(r4, r7)
            goto L_0x003a
        L_0x004a:
            boolean r3 = r6 instanceof androidx.constraintlayout.core.widgets.analyzer.HelperReferences
            if (r3 != 0) goto L_0x0054
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r6.f4327b
            boolean[] r3 = r3.f4194g
            r3[r7] = r1
        L_0x0054:
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r2 = r2.f4276d
            r5.c(r2, r7)
            goto L_0x0012
        L_0x005a:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r6.f4334i
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.Dependency> r0 = r0.f4283k
            java.util.Iterator r0 = r0.iterator()
        L_0x0062:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00aa
            java.lang.Object r2 = r0.next()
            androidx.constraintlayout.core.widgets.analyzer.Dependency r2 = (androidx.constraintlayout.core.widgets.analyzer.Dependency) r2
            boolean r3 = r2 instanceof androidx.constraintlayout.core.widgets.analyzer.DependencyNode
            if (r3 == 0) goto L_0x0062
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r3 = r2.f4276d
            if (r3 != r6) goto L_0x0079
            goto L_0x0062
        L_0x0079:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r3.f4333h
            if (r2 != r3) goto L_0x0062
            boolean r3 = r6 instanceof androidx.constraintlayout.core.widgets.analyzer.ChainRun
            if (r3 == 0) goto L_0x009a
            r3 = r6
            androidx.constraintlayout.core.widgets.analyzer.ChainRun r3 = (androidx.constraintlayout.core.widgets.analyzer.ChainRun) r3
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r3 = r3.f4261k
            java.util.Iterator r3 = r3.iterator()
        L_0x008a:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00a4
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r4 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r4
            r5.c(r4, r7)
            goto L_0x008a
        L_0x009a:
            boolean r3 = r6 instanceof androidx.constraintlayout.core.widgets.analyzer.HelperReferences
            if (r3 != 0) goto L_0x00a4
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r6.f4327b
            boolean[] r3 = r3.f4194g
            r3[r7] = r1
        L_0x00a4:
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r2 = r2.f4276d
            r5.c(r2, r7)
            goto L_0x0062
        L_0x00aa:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.RunGroup.c(androidx.constraintlayout.core.widgets.analyzer.WidgetRun, int):boolean");
    }

    private long e(DependencyNode dependencyNode, long j2) {
        WidgetRun widgetRun = dependencyNode.f4276d;
        if (widgetRun instanceof HelperReferences) {
            return j2;
        }
        int size = dependencyNode.f4283k.size();
        long j3 = j2;
        for (int i2 = 0; i2 < size; i2++) {
            Dependency dependency = dependencyNode.f4283k.get(i2);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.f4276d != widgetRun) {
                    j3 = Math.min(j3, e(dependencyNode2, ((long) dependencyNode2.f4278f) + j2));
                }
            }
        }
        if (dependencyNode != widgetRun.f4334i) {
            return j3;
        }
        long j4 = j2 - widgetRun.j();
        return Math.min(Math.min(j3, e(widgetRun.f4333h, j4)), j4 - ((long) widgetRun.f4333h.f4278f));
    }

    private long f(DependencyNode dependencyNode, long j2) {
        WidgetRun widgetRun = dependencyNode.f4276d;
        if (widgetRun instanceof HelperReferences) {
            return j2;
        }
        int size = dependencyNode.f4283k.size();
        long j3 = j2;
        for (int i2 = 0; i2 < size; i2++) {
            Dependency dependency = dependencyNode.f4283k.get(i2);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.f4276d != widgetRun) {
                    j3 = Math.max(j3, f(dependencyNode2, ((long) dependencyNode2.f4278f) + j2));
                }
            }
        }
        if (dependencyNode != widgetRun.f4333h) {
            return j3;
        }
        long j4 = j2 + widgetRun.j();
        return Math.max(Math.max(j3, f(widgetRun.f4334i, j4)), j4 - ((long) widgetRun.f4334i.f4278f));
    }

    public void a(WidgetRun widgetRun) {
        this.f4304e.add(widgetRun);
        this.f4303d = widgetRun;
    }

    public long b(ConstraintWidgetContainer constraintWidgetContainer, int i2) {
        long j2;
        WidgetRun widgetRun;
        long j3;
        long j4;
        WidgetRun widgetRun2 = this.f4302c;
        long j5 = 0;
        if (widgetRun2 instanceof ChainRun) {
            if (((ChainRun) widgetRun2).f4331f != i2) {
                return 0;
            }
        } else if (i2 == 0) {
            if (!(widgetRun2 instanceof HorizontalWidgetRun)) {
                return 0;
            }
        } else if (!(widgetRun2 instanceof VerticalWidgetRun)) {
            return 0;
        }
        DependencyNode dependencyNode = (i2 == 0 ? constraintWidgetContainer.f4192e : constraintWidgetContainer.f4193f).f4333h;
        DependencyNode dependencyNode2 = (i2 == 0 ? constraintWidgetContainer.f4192e : constraintWidgetContainer.f4193f).f4334i;
        boolean contains = widgetRun2.f4333h.f4284l.contains(dependencyNode);
        boolean contains2 = this.f4302c.f4334i.f4284l.contains(dependencyNode2);
        long j6 = this.f4302c.j();
        if (!contains || !contains2) {
            if (contains) {
                DependencyNode dependencyNode3 = this.f4302c.f4333h;
                j4 = f(dependencyNode3, (long) dependencyNode3.f4278f);
                j3 = ((long) this.f4302c.f4333h.f4278f) + j6;
            } else if (contains2) {
                DependencyNode dependencyNode4 = this.f4302c.f4334i;
                long e2 = e(dependencyNode4, (long) dependencyNode4.f4278f);
                j3 = ((long) (-this.f4302c.f4334i.f4278f)) + j6;
                j4 = -e2;
            } else {
                WidgetRun widgetRun3 = this.f4302c;
                j2 = ((long) widgetRun3.f4333h.f4278f) + widgetRun3.j();
                widgetRun = this.f4302c;
            }
            return Math.max(j4, j3);
        }
        long f2 = f(this.f4302c.f4333h, 0);
        long e3 = e(this.f4302c.f4334i, 0);
        long j7 = f2 - j6;
        WidgetRun widgetRun4 = this.f4302c;
        int i3 = widgetRun4.f4334i.f4278f;
        if (j7 >= ((long) (-i3))) {
            j7 += (long) i3;
        }
        int i4 = widgetRun4.f4333h.f4278f;
        long j8 = ((-e3) - j6) - ((long) i4);
        if (j8 >= ((long) i4)) {
            j8 -= (long) i4;
        }
        float u = widgetRun4.f4327b.u(i2);
        if (u > 0.0f) {
            j5 = (long) ((((float) j8) / u) + (((float) j7) / (1.0f - u)));
        }
        float f3 = (float) j5;
        long j9 = ((long) ((f3 * u) + 0.5f)) + j6 + ((long) ((f3 * (1.0f - u)) + 0.5f));
        widgetRun = this.f4302c;
        j2 = ((long) widgetRun.f4333h.f4278f) + j9;
        return j2 - ((long) widgetRun.f4334i.f4278f);
    }

    public void d(boolean z, boolean z2) {
        if (z) {
            WidgetRun widgetRun = this.f4302c;
            if (widgetRun instanceof HorizontalWidgetRun) {
                c(widgetRun, 0);
            }
        }
        if (z2) {
            WidgetRun widgetRun2 = this.f4302c;
            if (widgetRun2 instanceof VerticalWidgetRun) {
                c(widgetRun2, 1);
            }
        }
    }
}
