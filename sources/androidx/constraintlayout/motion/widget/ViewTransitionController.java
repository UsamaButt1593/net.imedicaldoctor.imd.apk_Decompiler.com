package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.SharedValues;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ViewTransitionController {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final MotionLayout f4594a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<ViewTransition> f4595b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private HashSet<View> f4596c;

    /* renamed from: d  reason: collision with root package name */
    private String f4597d = "ViewTransitionController";

    /* renamed from: e  reason: collision with root package name */
    ArrayList<ViewTransition.Animate> f4598e;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<ViewTransition.Animate> f4599f = new ArrayList<>();

    public ViewTransitionController(MotionLayout motionLayout) {
        this.f4594a = motionLayout;
    }

    private void i(ViewTransition viewTransition, boolean z) {
        final int i2 = viewTransition.i();
        final int g2 = viewTransition.g();
        final ViewTransition viewTransition2 = viewTransition;
        final boolean z2 = z;
        ConstraintLayout.getSharedValues().a(viewTransition.i(), new SharedValues.SharedValuesListener() {
            public void a(int i2, int i3, int i4) {
                int h2 = viewTransition2.h();
                viewTransition2.r(i3);
                if (i2 == i2 && h2 != i3) {
                    if (z2) {
                        if (g2 == i3) {
                            int childCount = ViewTransitionController.this.f4594a.getChildCount();
                            for (int i5 = 0; i5 < childCount; i5++) {
                                View childAt = ViewTransitionController.this.f4594a.getChildAt(i5);
                                if (viewTransition2.m(childAt)) {
                                    int currentState = ViewTransitionController.this.f4594a.getCurrentState();
                                    ConstraintSet B0 = ViewTransitionController.this.f4594a.B0(currentState);
                                    ViewTransition viewTransition = viewTransition2;
                                    ViewTransitionController viewTransitionController = ViewTransitionController.this;
                                    viewTransition.c(viewTransitionController, viewTransitionController.f4594a, currentState, B0, childAt);
                                }
                            }
                        }
                    } else if (g2 != i3) {
                        int childCount2 = ViewTransitionController.this.f4594a.getChildCount();
                        for (int i6 = 0; i6 < childCount2; i6++) {
                            View childAt2 = ViewTransitionController.this.f4594a.getChildAt(i6);
                            if (viewTransition2.m(childAt2)) {
                                int currentState2 = ViewTransitionController.this.f4594a.getCurrentState();
                                ConstraintSet B02 = ViewTransitionController.this.f4594a.B0(currentState2);
                                ViewTransition viewTransition2 = viewTransition2;
                                ViewTransitionController viewTransitionController2 = ViewTransitionController.this;
                                viewTransition2.c(viewTransitionController2, viewTransitionController2.f4594a, currentState2, B02, childAt2);
                            }
                        }
                    }
                }
            }
        });
    }

    private void n(ViewTransition viewTransition, View... viewArr) {
        int currentState = this.f4594a.getCurrentState();
        if (viewTransition.f4570f == 2) {
            viewTransition.c(this, this.f4594a, currentState, (ConstraintSet) null, viewArr);
        } else if (currentState == -1) {
            String str = this.f4597d;
            Log.w(str, "No support for ViewTransition within transition yet. Currently: " + this.f4594a.toString());
        } else {
            ConstraintSet B0 = this.f4594a.B0(currentState);
            if (B0 != null) {
                viewTransition.c(this, this.f4594a, currentState, B0, viewArr);
            }
        }
    }

    public void b(ViewTransition viewTransition) {
        boolean z;
        this.f4595b.add(viewTransition);
        this.f4596c = null;
        if (viewTransition.j() == 4) {
            z = true;
        } else if (viewTransition.j() == 5) {
            z = false;
        } else {
            return;
        }
        i(viewTransition, z);
    }

    /* access modifiers changed from: package-private */
    public void c(ViewTransition.Animate animate) {
        if (this.f4598e == null) {
            this.f4598e = new ArrayList<>();
        }
        this.f4598e.add(animate);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        ArrayList<ViewTransition.Animate> arrayList = this.f4598e;
        if (arrayList != null) {
            Iterator<ViewTransition.Animate> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().a();
            }
            this.f4598e.removeAll(this.f4599f);
            this.f4599f.clear();
            if (this.f4598e.isEmpty()) {
                this.f4598e = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean e(int i2, MotionController motionController) {
        Iterator<ViewTransition> it2 = this.f4595b.iterator();
        while (it2.hasNext()) {
            ViewTransition next = it2.next();
            if (next.e() == i2) {
                next.f4571g.a(motionController);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void f(int i2, boolean z) {
        Iterator<ViewTransition> it2 = this.f4595b.iterator();
        while (it2.hasNext()) {
            ViewTransition next = it2.next();
            if (next.e() == i2) {
                next.o(z);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        this.f4594a.invalidate();
    }

    /* access modifiers changed from: package-private */
    public boolean h(int i2) {
        Iterator<ViewTransition> it2 = this.f4595b.iterator();
        while (it2.hasNext()) {
            ViewTransition next = it2.next();
            if (next.e() == i2) {
                return next.k();
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void j(int i2) {
        ViewTransition viewTransition;
        Iterator<ViewTransition> it2 = this.f4595b.iterator();
        while (true) {
            if (!it2.hasNext()) {
                viewTransition = null;
                break;
            }
            viewTransition = it2.next();
            if (viewTransition.e() == i2) {
                break;
            }
        }
        if (viewTransition != null) {
            this.f4596c = null;
            this.f4595b.remove(viewTransition);
        }
    }

    /* access modifiers changed from: package-private */
    public void k(ViewTransition.Animate animate) {
        this.f4599f.add(animate);
    }

    /* access modifiers changed from: package-private */
    public void l(MotionEvent motionEvent) {
        ViewTransition viewTransition;
        int currentState = this.f4594a.getCurrentState();
        if (currentState != -1) {
            if (this.f4596c == null) {
                this.f4596c = new HashSet<>();
                Iterator<ViewTransition> it2 = this.f4595b.iterator();
                while (it2.hasNext()) {
                    ViewTransition next = it2.next();
                    int childCount = this.f4594a.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.f4594a.getChildAt(i2);
                        if (next.m(childAt)) {
                            childAt.getId();
                            this.f4596c.add(childAt);
                        }
                    }
                }
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            Rect rect = new Rect();
            int action = motionEvent.getAction();
            ArrayList<ViewTransition.Animate> arrayList = this.f4598e;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<ViewTransition.Animate> it3 = this.f4598e.iterator();
                while (it3.hasNext()) {
                    it3.next().d(action, x, y);
                }
            }
            if (action == 0 || action == 1) {
                ConstraintSet B0 = this.f4594a.B0(currentState);
                Iterator<ViewTransition> it4 = this.f4595b.iterator();
                while (it4.hasNext()) {
                    ViewTransition next2 = it4.next();
                    if (next2.u(action)) {
                        Iterator<View> it5 = this.f4596c.iterator();
                        while (it5.hasNext()) {
                            View next3 = it5.next();
                            if (next2.m(next3)) {
                                next3.getHitRect(rect);
                                if (rect.contains((int) x, (int) y)) {
                                    viewTransition = next2;
                                    next2.c(this, this.f4594a, currentState, B0, next3);
                                } else {
                                    viewTransition = next2;
                                }
                                next2 = viewTransition;
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void m(int i2, View... viewArr) {
        ArrayList arrayList = new ArrayList();
        Iterator<ViewTransition> it2 = this.f4595b.iterator();
        ViewTransition viewTransition = null;
        while (it2.hasNext()) {
            ViewTransition next = it2.next();
            if (next.e() == i2) {
                for (View view : viewArr) {
                    if (next.d(view)) {
                        arrayList.add(view);
                    }
                }
                if (!arrayList.isEmpty()) {
                    n(next, (View[]) arrayList.toArray(new View[0]));
                    arrayList.clear();
                }
                viewTransition = next;
            }
        }
        if (viewTransition == null) {
            Log.e(this.f4597d, " Could not find ViewTransition");
        }
    }
}
