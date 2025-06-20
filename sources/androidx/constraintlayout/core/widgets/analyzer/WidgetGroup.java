package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.Chain;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

public class WidgetGroup {

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f4310g = false;

    /* renamed from: h  reason: collision with root package name */
    static int f4311h;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<ConstraintWidget> f4312a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    int f4313b;

    /* renamed from: c  reason: collision with root package name */
    boolean f4314c = false;

    /* renamed from: d  reason: collision with root package name */
    int f4315d;

    /* renamed from: e  reason: collision with root package name */
    ArrayList<MeasureResult> f4316e = null;

    /* renamed from: f  reason: collision with root package name */
    private int f4317f = -1;

    class MeasureResult {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<ConstraintWidget> f4318a;

        /* renamed from: b  reason: collision with root package name */
        int f4319b;

        /* renamed from: c  reason: collision with root package name */
        int f4320c;

        /* renamed from: d  reason: collision with root package name */
        int f4321d;

        /* renamed from: e  reason: collision with root package name */
        int f4322e;

        /* renamed from: f  reason: collision with root package name */
        int f4323f;

        /* renamed from: g  reason: collision with root package name */
        int f4324g;

        public MeasureResult(ConstraintWidget constraintWidget, LinearSystem linearSystem, int i2) {
            this.f4318a = new WeakReference<>(constraintWidget);
            this.f4319b = linearSystem.O(constraintWidget.Q);
            this.f4320c = linearSystem.O(constraintWidget.R);
            this.f4321d = linearSystem.O(constraintWidget.S);
            this.f4322e = linearSystem.O(constraintWidget.T);
            this.f4323f = linearSystem.O(constraintWidget.U);
            this.f4324g = i2;
        }

        public void a() {
            ConstraintWidget constraintWidget = this.f4318a.get();
            if (constraintWidget != null) {
                constraintWidget.p1(this.f4319b, this.f4320c, this.f4321d, this.f4322e, this.f4323f, this.f4324g);
            }
        }
    }

    public WidgetGroup(int i2) {
        int i3 = f4311h;
        f4311h = i3 + 1;
        this.f4313b = i3;
        this.f4315d = i2;
    }

    private boolean e(ConstraintWidget constraintWidget) {
        return this.f4312a.contains(constraintWidget);
    }

    private String h() {
        int i2 = this.f4315d;
        if (i2 == 0) {
            return "Horizontal";
        }
        if (i2 == 1) {
            return "Vertical";
        }
        return i2 == 2 ? "Both" : "Unknown";
    }

    private int k(int i2, ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour z = constraintWidget.z(i2);
        if (z == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || z == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || z == ConstraintWidget.DimensionBehaviour.FIXED) {
            return i2 == 0 ? constraintWidget.m0() : constraintWidget.D();
        }
        return -1;
    }

    private int q(LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i2) {
        int O;
        ConstraintAnchor constraintAnchor;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) arrayList.get(0).U();
        linearSystem.Y();
        constraintWidgetContainer.g(linearSystem, false);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList.get(i3).g(linearSystem, false);
        }
        if (i2 == 0 && constraintWidgetContainer.M1 > 0) {
            Chain.b(constraintWidgetContainer, linearSystem, arrayList, 0);
        }
        if (i2 == 1 && constraintWidgetContainer.N1 > 0) {
            Chain.b(constraintWidgetContainer, linearSystem, arrayList, 1);
        }
        try {
            linearSystem.T();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f4316e = new ArrayList<>();
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            this.f4316e.add(new MeasureResult(arrayList.get(i4), linearSystem, i2));
        }
        if (i2 == 0) {
            O = linearSystem.O(constraintWidgetContainer.Q);
            constraintAnchor = constraintWidgetContainer.S;
        } else {
            O = linearSystem.O(constraintWidgetContainer.R);
            constraintAnchor = constraintWidgetContainer.T;
        }
        int O2 = linearSystem.O(constraintAnchor);
        linearSystem.Y();
        return O2 - O;
    }

    public boolean a(ConstraintWidget constraintWidget) {
        if (this.f4312a.contains(constraintWidget)) {
            return false;
        }
        this.f4312a.add(constraintWidget);
        return true;
    }

    public void b() {
        if (this.f4316e != null && this.f4314c) {
            for (int i2 = 0; i2 < this.f4316e.size(); i2++) {
                this.f4316e.get(i2).a();
            }
        }
    }

    public void c(ArrayList<WidgetGroup> arrayList) {
        int size = this.f4312a.size();
        if (this.f4317f != -1 && size > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                WidgetGroup widgetGroup = arrayList.get(i2);
                if (this.f4317f == widgetGroup.f4313b) {
                    m(this.f4315d, widgetGroup);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public void d() {
        this.f4312a.clear();
    }

    public int f() {
        return this.f4313b;
    }

    public int g() {
        return this.f4315d;
    }

    public boolean i(WidgetGroup widgetGroup) {
        for (int i2 = 0; i2 < this.f4312a.size(); i2++) {
            if (widgetGroup.e(this.f4312a.get(i2))) {
                return true;
            }
        }
        return false;
    }

    public boolean j() {
        return this.f4314c;
    }

    public int l(LinearSystem linearSystem, int i2) {
        if (this.f4312a.size() == 0) {
            return 0;
        }
        return q(linearSystem, this.f4312a, i2);
    }

    public void m(int i2, WidgetGroup widgetGroup) {
        Iterator<ConstraintWidget> it2 = this.f4312a.iterator();
        while (it2.hasNext()) {
            ConstraintWidget next = it2.next();
            widgetGroup.a(next);
            int f2 = widgetGroup.f();
            if (i2 == 0) {
                next.S0 = f2;
            } else {
                next.T0 = f2;
            }
        }
        this.f4317f = widgetGroup.f4313b;
    }

    public void n(boolean z) {
        this.f4314c = z;
    }

    public void o(int i2) {
        this.f4315d = i2;
    }

    public int p() {
        return this.f4312a.size();
    }

    public String toString() {
        String str = h() + " [" + this.f4313b + "] <";
        Iterator<ConstraintWidget> it2 = this.f4312a.iterator();
        while (it2.hasNext()) {
            str = str + StringUtils.SPACE + it2.next().y();
        }
        return str + " >";
    }
}
