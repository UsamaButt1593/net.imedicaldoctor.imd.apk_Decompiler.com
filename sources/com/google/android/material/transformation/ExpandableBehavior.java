package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.expandable.ExpandableWidget;
import java.util.List;

@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    private static final int X = 0;
    private static final int Y = 1;
    private static final int Z = 2;
    /* access modifiers changed from: private */
    public int s = 0;

    public ExpandableBehavior() {
    }

    private boolean O(boolean z) {
        if (!z) {
            return this.s == 1;
        }
        int i2 = this.s;
        return i2 == 0 || i2 == 2;
    }

    @Nullable
    public static <T extends ExpandableBehavior> T Q(@NonNull View view, @NonNull Class<T> cls) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior f2 = ((CoordinatorLayout.LayoutParams) layoutParams).f();
            if (f2 instanceof ExpandableBehavior) {
                return (ExpandableBehavior) cls.cast(f2);
            }
            throw new IllegalArgumentException("The view is not associated with ExpandableBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    /* access modifiers changed from: protected */
    @Nullable
    public ExpandableWidget P(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
        List<View> w = coordinatorLayout.w(view);
        int size = w.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = w.get(i2);
            if (m(coordinatorLayout, view, view2)) {
                return (ExpandableWidget) view2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract boolean R(View view, View view2, boolean z, boolean z2);

    public abstract boolean m(CoordinatorLayout coordinatorLayout, View view, View view2);

    @CallSuper
    public boolean p(CoordinatorLayout coordinatorLayout, View view, View view2) {
        ExpandableWidget expandableWidget = (ExpandableWidget) view2;
        if (!O(expandableWidget.b())) {
            return false;
        }
        this.s = expandableWidget.b() ? 1 : 2;
        return R((View) expandableWidget, view, expandableWidget.b(), true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r3 = P(r3, r4);
     */
    @androidx.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean t(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r3, @androidx.annotation.NonNull final android.view.View r4, int r5) {
        /*
            r2 = this;
            boolean r5 = androidx.core.view.ViewCompat.Y0(r4)
            if (r5 != 0) goto L_0x002d
            com.google.android.material.expandable.ExpandableWidget r3 = r2.P(r3, r4)
            if (r3 == 0) goto L_0x002d
            boolean r5 = r3.b()
            boolean r5 = r2.O(r5)
            if (r5 == 0) goto L_0x002d
            boolean r5 = r3.b()
            if (r5 == 0) goto L_0x001e
            r5 = 1
            goto L_0x001f
        L_0x001e:
            r5 = 2
        L_0x001f:
            r2.s = r5
            android.view.ViewTreeObserver r0 = r4.getViewTreeObserver()
            com.google.android.material.transformation.ExpandableBehavior$1 r1 = new com.google.android.material.transformation.ExpandableBehavior$1
            r1.<init>(r4, r5, r3)
            r0.addOnPreDrawListener(r1)
        L_0x002d:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transformation.ExpandableBehavior.t(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int):boolean");
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
