package com.google.android.material.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class BottomSheetDragHandleView extends AppCompatImageView implements AccessibilityManager.AccessibilityStateChangeListener {
    private static final int i3 = R.style.mf;
    @Nullable
    private final AccessibilityManager Z2;
    @Nullable
    private BottomSheetBehavior<?> a3;
    private boolean b3;
    private boolean c3;
    private boolean d3;
    private final String e3;
    private final String f3;
    private final String g3;
    private final BottomSheetBehavior.BottomSheetCallback h3;

    public BottomSheetDragHandleView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void f(String str) {
        if (this.Z2 != null) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(16384);
            obtain.getText().add(str);
            this.Z2.sendAccessibilityEvent(obtain);
        }
    }

    /* access modifiers changed from: private */
    public boolean g() {
        boolean z = false;
        if (!this.c3) {
            return false;
        }
        f(this.g3);
        if (!this.a3.R0() && !this.a3.B1()) {
            z = true;
        }
        int state = this.a3.getState();
        int i2 = 6;
        int i4 = 3;
        if (state == 4) {
            if (!z) {
                i2 = 3;
            }
        } else if (state != 3) {
            if (!this.d3) {
                i4 = 4;
            }
            i2 = i4;
        } else if (!z) {
            i2 = 4;
        }
        this.a3.b(i2);
        return true;
    }

    @Nullable
    private BottomSheetBehavior<?> h() {
        View view = this;
        while (true) {
            view = i(view);
            if (view == null) {
                return null;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.Behavior f2 = ((CoordinatorLayout.LayoutParams) layoutParams).f();
                if (f2 instanceof BottomSheetBehavior) {
                    return (BottomSheetBehavior) f2;
                }
            }
        }
    }

    @Nullable
    private static View i(View view) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean j(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return g();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0012  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k(int r3) {
        /*
            r2 = this;
            r0 = 4
            if (r3 != r0) goto L_0x0007
            r3 = 1
        L_0x0004:
            r2.d3 = r3
            goto L_0x000c
        L_0x0007:
            r0 = 3
            if (r3 != r0) goto L_0x000c
            r3 = 0
            goto L_0x0004
        L_0x000c:
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat r3 = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6657j
            boolean r0 = r2.d3
            if (r0 == 0) goto L_0x0015
            java.lang.String r0 = r2.e3
            goto L_0x0017
        L_0x0015:
            java.lang.String r0 = r2.f3
        L_0x0017:
            com.google.android.material.bottomsheet.d r1 = new com.google.android.material.bottomsheet.d
            r1.<init>(r2)
            androidx.core.view.ViewCompat.A1(r2, r3, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetDragHandleView.k(int):void");
    }

    private void l() {
        int i2 = 1;
        this.c3 = this.b3 && this.a3 != null;
        if (this.a3 == null) {
            i2 = 2;
        }
        ViewCompat.Z1(this, i2);
        setClickable(this.c3);
    }

    private void setBottomSheetBehavior(@Nullable BottomSheetBehavior<?> bottomSheetBehavior) {
        BottomSheetBehavior<?> bottomSheetBehavior2 = this.a3;
        if (bottomSheetBehavior2 != null) {
            bottomSheetBehavior2.Y0(this.h3);
            this.a3.d1((View) null);
        }
        this.a3 = bottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.d1(this);
            k(this.a3.getState());
            this.a3.h0(this.h3);
        }
        l();
    }

    public void onAccessibilityStateChanged(boolean z) {
        this.b3 = z;
        l();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setBottomSheetBehavior(h());
        AccessibilityManager accessibilityManager = this.Z2;
        if (accessibilityManager != null) {
            accessibilityManager.addAccessibilityStateChangeListener(this);
            onAccessibilityStateChanged(this.Z2.isEnabled());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AccessibilityManager accessibilityManager = this.Z2;
        if (accessibilityManager != null) {
            accessibilityManager.removeAccessibilityStateChangeListener(this);
        }
        setBottomSheetBehavior((BottomSheetBehavior<?>) null);
        super.onDetachedFromWindow();
    }

    public BottomSheetDragHandleView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.m1);
    }

    public BottomSheetDragHandleView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(MaterialThemeOverlay.c(context, attributeSet, i2, i3), attributeSet, i2);
        this.e3 = getResources().getString(R.string.E);
        this.f3 = getResources().getString(R.string.D);
        this.g3 = getResources().getString(R.string.G);
        this.h3 = new BottomSheetBehavior.BottomSheetCallback() {
            public void b(@NonNull View view, float f2) {
            }

            public void c(@NonNull View view, int i2) {
                BottomSheetDragHandleView.this.k(i2);
            }
        };
        this.Z2 = (AccessibilityManager) getContext().getSystemService("accessibility");
        l();
        ViewCompat.H1(this, new AccessibilityDelegateCompat() {
            public void h(View view, @NonNull AccessibilityEvent accessibilityEvent) {
                super.h(view, accessibilityEvent);
                if (accessibilityEvent.getEventType() == 1) {
                    boolean unused = BottomSheetDragHandleView.this.g();
                }
            }
        });
    }
}
