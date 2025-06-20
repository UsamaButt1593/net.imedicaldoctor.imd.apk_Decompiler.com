package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
import java.util.List;

public class DependencyNode implements Dependency {

    /* renamed from: a  reason: collision with root package name */
    public Dependency f4273a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4274b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4275c = false;

    /* renamed from: d  reason: collision with root package name */
    WidgetRun f4276d;

    /* renamed from: e  reason: collision with root package name */
    Type f4277e = Type.UNKNOWN;

    /* renamed from: f  reason: collision with root package name */
    int f4278f;

    /* renamed from: g  reason: collision with root package name */
    public int f4279g;

    /* renamed from: h  reason: collision with root package name */
    int f4280h = 1;

    /* renamed from: i  reason: collision with root package name */
    DimensionDependency f4281i = null;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4282j = false;

    /* renamed from: k  reason: collision with root package name */
    List<Dependency> f4283k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    List<DependencyNode> f4284l = new ArrayList();

    enum Type {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public DependencyNode(WidgetRun widgetRun) {
        this.f4276d = widgetRun;
    }

    public void a(Dependency dependency) {
        for (DependencyNode dependencyNode : this.f4284l) {
            if (!dependencyNode.f4282j) {
                return;
            }
        }
        this.f4275c = true;
        Dependency dependency2 = this.f4273a;
        if (dependency2 != null) {
            dependency2.a(this);
        }
        if (this.f4274b) {
            this.f4276d.a(this);
            return;
        }
        DependencyNode dependencyNode2 = null;
        int i2 = 0;
        for (DependencyNode next : this.f4284l) {
            if (!(next instanceof DimensionDependency)) {
                i2++;
                dependencyNode2 = next;
            }
        }
        if (dependencyNode2 != null && i2 == 1 && dependencyNode2.f4282j) {
            DimensionDependency dimensionDependency = this.f4281i;
            if (dimensionDependency != null) {
                if (dimensionDependency.f4282j) {
                    this.f4278f = this.f4280h * dimensionDependency.f4279g;
                } else {
                    return;
                }
            }
            e(dependencyNode2.f4279g + this.f4278f);
        }
        Dependency dependency3 = this.f4273a;
        if (dependency3 != null) {
            dependency3.a(this);
        }
    }

    public void b(Dependency dependency) {
        this.f4283k.add(dependency);
        if (this.f4282j) {
            dependency.a(dependency);
        }
    }

    public void c() {
        this.f4284l.clear();
        this.f4283k.clear();
        this.f4282j = false;
        this.f4279g = 0;
        this.f4275c = false;
        this.f4274b = false;
    }

    public String d() {
        StringBuilder sb;
        String str;
        String y = this.f4276d.f4327b.y();
        Type type = this.f4277e;
        if (type == Type.LEFT || type == Type.RIGHT) {
            sb = new StringBuilder();
            sb.append(y);
            str = "_HORIZONTAL";
        } else {
            sb = new StringBuilder();
            sb.append(y);
            str = "_VERTICAL";
        }
        sb.append(str);
        String sb2 = sb.toString();
        return sb2 + ":" + this.f4277e.name();
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4276d.f4327b.y());
        sb.append(":");
        sb.append(this.f4277e);
        sb.append("(");
        sb.append(this.f4282j ? Integer.valueOf(this.f4279g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f4284l.size());
        sb.append(":d=");
        sb.append(this.f4283k.size());
        sb.append(">");
        return sb.toString();
    }
}
