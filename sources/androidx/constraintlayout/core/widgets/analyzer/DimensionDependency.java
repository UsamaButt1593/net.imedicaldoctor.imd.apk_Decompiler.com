package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;

class DimensionDependency extends DependencyNode {

    /* renamed from: m  reason: collision with root package name */
    public int f4285m;

    public DimensionDependency(WidgetRun widgetRun) {
        super(widgetRun);
        this.f4277e = widgetRun instanceof HorizontalWidgetRun ? DependencyNode.Type.HORIZONTAL_DIMENSION : DependencyNode.Type.VERTICAL_DIMENSION;
    }

    public void e(int i2) {
        if (!this.f4282j) {
            this.f4282j = true;
            this.f4279g = i2;
            for (Dependency next : this.f4283k) {
                next.a(next);
            }
        }
    }
}
