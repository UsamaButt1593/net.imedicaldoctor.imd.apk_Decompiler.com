package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;

class GuidelineReference extends WidgetRun {
    public GuidelineReference(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.f4192e.f();
        constraintWidget.f4193f.f();
        this.f4331f = ((Guideline) constraintWidget).m2();
    }

    private void u(DependencyNode dependencyNode) {
        this.f4333h.f4283k.add(dependencyNode);
        dependencyNode.f4284l.add(this.f4333h);
    }

    public void a(Dependency dependency) {
        DependencyNode dependencyNode = this.f4333h;
        if (dependencyNode.f4275c && !dependencyNode.f4282j) {
            this.f4333h.e((int) ((((float) dependencyNode.f4284l.get(0).f4279g) * ((Guideline) this.f4327b).q2()) + 0.5f));
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        WidgetRun widgetRun;
        DependencyNode dependencyNode;
        DependencyNode dependencyNode2;
        Guideline guideline = (Guideline) this.f4327b;
        int n2 = guideline.n2();
        int p2 = guideline.p2();
        guideline.q2();
        if (guideline.m2() == 1) {
            DependencyNode dependencyNode3 = this.f4333h;
            if (n2 != -1) {
                dependencyNode3.f4284l.add(this.f4327b.c0.f4192e.f4333h);
                this.f4327b.c0.f4192e.f4333h.f4283k.add(this.f4333h);
                dependencyNode2 = this.f4333h;
            } else if (p2 != -1) {
                dependencyNode3.f4284l.add(this.f4327b.c0.f4192e.f4334i);
                this.f4327b.c0.f4192e.f4334i.f4283k.add(this.f4333h);
                dependencyNode2 = this.f4333h;
                n2 = -p2;
            } else {
                dependencyNode3.f4274b = true;
                dependencyNode3.f4284l.add(this.f4327b.c0.f4192e.f4334i);
                this.f4327b.c0.f4192e.f4334i.f4283k.add(this.f4333h);
                u(this.f4327b.f4192e.f4333h);
                widgetRun = this.f4327b.f4192e;
            }
            dependencyNode2.f4278f = n2;
            u(this.f4327b.f4192e.f4333h);
            widgetRun = this.f4327b.f4192e;
        } else {
            DependencyNode dependencyNode4 = this.f4333h;
            if (n2 != -1) {
                dependencyNode4.f4284l.add(this.f4327b.c0.f4193f.f4333h);
                this.f4327b.c0.f4193f.f4333h.f4283k.add(this.f4333h);
                dependencyNode = this.f4333h;
            } else if (p2 != -1) {
                dependencyNode4.f4284l.add(this.f4327b.c0.f4193f.f4334i);
                this.f4327b.c0.f4193f.f4334i.f4283k.add(this.f4333h);
                dependencyNode = this.f4333h;
                n2 = -p2;
            } else {
                dependencyNode4.f4274b = true;
                dependencyNode4.f4284l.add(this.f4327b.c0.f4193f.f4334i);
                this.f4327b.c0.f4193f.f4334i.f4283k.add(this.f4333h);
                u(this.f4327b.f4193f.f4333h);
                widgetRun = this.f4327b.f4193f;
            }
            dependencyNode.f4278f = n2;
            u(this.f4327b.f4193f.f4333h);
            widgetRun = this.f4327b.f4193f;
        }
        u(widgetRun.f4334i);
    }

    public void e() {
        if (((Guideline) this.f4327b).m2() == 1) {
            this.f4327b.f2(this.f4333h.f4279g);
        } else {
            this.f4327b.g2(this.f4333h.f4279g);
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f4333h.c();
    }

    /* access modifiers changed from: package-private */
    public void n() {
        this.f4333h.f4282j = false;
        this.f4334i.f4282j = false;
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return false;
    }
}
