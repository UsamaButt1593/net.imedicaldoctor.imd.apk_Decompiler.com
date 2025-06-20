package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.Reference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;

public class GuidelineReference implements Facade, Reference {

    /* renamed from: a  reason: collision with root package name */
    final State f4151a;

    /* renamed from: b  reason: collision with root package name */
    private int f4152b;

    /* renamed from: c  reason: collision with root package name */
    private Guideline f4153c;

    /* renamed from: d  reason: collision with root package name */
    private int f4154d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f4155e = -1;

    /* renamed from: f  reason: collision with root package name */
    private float f4156f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    private Object f4157g;

    public GuidelineReference(State state) {
        this.f4151a = state;
    }

    public ConstraintWidget a() {
        if (this.f4153c == null) {
            this.f4153c = new Guideline();
        }
        return this.f4153c;
    }

    public void apply() {
        this.f4153c.B2(this.f4152b);
        int i2 = this.f4154d;
        if (i2 != -1) {
            this.f4153c.w2(i2);
            return;
        }
        int i3 = this.f4155e;
        if (i3 != -1) {
            this.f4153c.x2(i3);
        } else {
            this.f4153c.y2(this.f4156f);
        }
    }

    public void b(ConstraintWidget constraintWidget) {
        this.f4153c = constraintWidget instanceof Guideline ? (Guideline) constraintWidget : null;
    }

    public void c(Object obj) {
        this.f4157g = obj;
    }

    public Facade d() {
        return null;
    }

    public GuidelineReference e(Object obj) {
        this.f4154d = -1;
        this.f4155e = this.f4151a.f(obj);
        this.f4156f = 0.0f;
        return this;
    }

    public int f() {
        return this.f4152b;
    }

    public GuidelineReference g(float f2) {
        this.f4154d = -1;
        this.f4155e = -1;
        this.f4156f = f2;
        return this;
    }

    public Object getKey() {
        return this.f4157g;
    }

    public void h(int i2) {
        this.f4152b = i2;
    }

    public GuidelineReference i(Object obj) {
        this.f4154d = this.f4151a.f(obj);
        this.f4155e = -1;
        this.f4156f = 0.0f;
        return this;
    }
}
