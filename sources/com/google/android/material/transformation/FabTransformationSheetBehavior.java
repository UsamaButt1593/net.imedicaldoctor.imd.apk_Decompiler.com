package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.Positioning;
import com.google.android.material.transformation.FabTransformationBehavior;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {
    @Nullable
    private Map<View, Integer> e3;

    public FabTransformationSheetBehavior() {
    }

    private void q0(@NonNull View view, boolean z) {
        int i2;
        ViewParent parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                this.e3 = new HashMap(childCount);
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = coordinatorLayout.getChildAt(i3);
                boolean z2 = (childAt.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).f() instanceof FabTransformationScrimBehavior);
                if (childAt != view && !z2) {
                    Map<View, Integer> map = this.e3;
                    if (z) {
                        map.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        i2 = 4;
                    } else if (map != null && map.containsKey(childAt)) {
                        i2 = this.e3.get(childAt).intValue();
                    }
                    ViewCompat.Z1(childAt, i2);
                }
            }
            if (!z) {
                this.e3 = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public boolean R(@NonNull View view, @NonNull View view2, boolean z, boolean z2) {
        q0(view2, z);
        return super.R(view, view2, z, z2);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public FabTransformationBehavior.FabTransformationSpec o0(Context context, boolean z) {
        int i2 = z ? R.animator.H : R.animator.G;
        FabTransformationBehavior.FabTransformationSpec fabTransformationSpec = new FabTransformationBehavior.FabTransformationSpec();
        fabTransformationSpec.f22089a = MotionSpec.d(context, i2);
        fabTransformationSpec.f22090b = new Positioning(17, 0.0f, 0.0f);
        return fabTransformationSpec;
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
