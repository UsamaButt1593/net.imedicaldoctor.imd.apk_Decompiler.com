package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;

class HelperReferences extends WidgetRun {
    public HelperReferences(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    private void u(DependencyNode dependencyNode) {
        this.f4333h.f4283k.add(dependencyNode);
        dependencyNode.f4284l.add(this.f4333h);
    }

    public void a(Dependency dependency) {
        Barrier barrier = (Barrier) this.f4327b;
        int p2 = barrier.p2();
        int i2 = 0;
        int i3 = -1;
        for (DependencyNode dependencyNode : this.f4333h.f4284l) {
            int i4 = dependencyNode.f4279g;
            if (i3 == -1 || i4 < i3) {
                i3 = i4;
            }
            if (i2 < i4) {
                i2 = i4;
            }
        }
        if (p2 == 0 || p2 == 2) {
            this.f4333h.e(i3 + barrier.q2());
        } else {
            this.f4333h.e(i2 + barrier.q2());
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        WidgetRun widgetRun;
        ConstraintWidget constraintWidget = this.f4327b;
        if (constraintWidget instanceof Barrier) {
            this.f4333h.f4274b = true;
            Barrier barrier = (Barrier) constraintWidget;
            int p2 = barrier.p2();
            boolean o2 = barrier.o2();
            int i2 = 0;
            if (p2 == 0) {
                this.f4333h.f4277e = DependencyNode.Type.LEFT;
                while (i2 < barrier.B1) {
                    ConstraintWidget constraintWidget2 = barrier.A1[i2];
                    if (o2 || constraintWidget2.l0() != 8) {
                        DependencyNode dependencyNode = constraintWidget2.f4192e.f4333h;
                        dependencyNode.f4283k.add(this.f4333h);
                        this.f4333h.f4284l.add(dependencyNode);
                    }
                    i2++;
                }
                u(this.f4327b.f4192e.f4333h);
                widgetRun = this.f4327b.f4192e;
            } else if (p2 != 1) {
                if (p2 == 2) {
                    this.f4333h.f4277e = DependencyNode.Type.TOP;
                    while (i2 < barrier.B1) {
                        ConstraintWidget constraintWidget3 = barrier.A1[i2];
                        if (o2 || constraintWidget3.l0() != 8) {
                            DependencyNode dependencyNode2 = constraintWidget3.f4193f.f4333h;
                            dependencyNode2.f4283k.add(this.f4333h);
                            this.f4333h.f4284l.add(dependencyNode2);
                        }
                        i2++;
                    }
                } else if (p2 == 3) {
                    this.f4333h.f4277e = DependencyNode.Type.BOTTOM;
                    while (i2 < barrier.B1) {
                        ConstraintWidget constraintWidget4 = barrier.A1[i2];
                        if (o2 || constraintWidget4.l0() != 8) {
                            DependencyNode dependencyNode3 = constraintWidget4.f4193f.f4334i;
                            dependencyNode3.f4283k.add(this.f4333h);
                            this.f4333h.f4284l.add(dependencyNode3);
                        }
                        i2++;
                    }
                } else {
                    return;
                }
                u(this.f4327b.f4193f.f4333h);
                widgetRun = this.f4327b.f4193f;
            } else {
                this.f4333h.f4277e = DependencyNode.Type.RIGHT;
                while (i2 < barrier.B1) {
                    ConstraintWidget constraintWidget5 = barrier.A1[i2];
                    if (o2 || constraintWidget5.l0() != 8) {
                        DependencyNode dependencyNode4 = constraintWidget5.f4192e.f4334i;
                        dependencyNode4.f4283k.add(this.f4333h);
                        this.f4333h.f4284l.add(dependencyNode4);
                    }
                    i2++;
                }
                u(this.f4327b.f4192e.f4333h);
                widgetRun = this.f4327b.f4192e;
            }
            u(widgetRun.f4334i);
        }
    }

    public void e() {
        ConstraintWidget constraintWidget = this.f4327b;
        if (constraintWidget instanceof Barrier) {
            int p2 = ((Barrier) constraintWidget).p2();
            if (p2 == 0 || p2 == 1) {
                this.f4327b.f2(this.f4333h.f4279g);
            } else {
                this.f4327b.g2(this.f4333h.f4279g);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f4328c = null;
        this.f4333h.c();
    }

    /* access modifiers changed from: package-private */
    public void n() {
        this.f4333h.f4282j = false;
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return false;
    }
}
