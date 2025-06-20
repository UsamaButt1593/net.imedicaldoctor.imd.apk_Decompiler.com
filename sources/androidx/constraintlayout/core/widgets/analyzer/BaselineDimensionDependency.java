package androidx.constraintlayout.core.widgets.analyzer;

class BaselineDimensionDependency extends DimensionDependency {
    public BaselineDimensionDependency(WidgetRun widgetRun) {
        super(widgetRun);
    }

    public void f(DependencyNode dependencyNode) {
        WidgetRun widgetRun = this.f4276d;
        ((VerticalWidgetRun) widgetRun).f4307k.f4278f = widgetRun.f4327b.t();
        this.f4282j = true;
    }
}
