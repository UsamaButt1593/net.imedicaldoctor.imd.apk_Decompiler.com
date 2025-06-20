package com.google.android.material.sidesheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.GravityInt;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.sidesheet.SheetCallback;

abstract class SheetDialog<C extends SheetCallback> extends AppCompatDialog {
    private static final int g3 = R.id.R0;
    private static final int h3 = R.id.l6;
    @Nullable
    private Sheet<C> Y2;
    @Nullable
    private FrameLayout Z2;
    @Nullable
    private FrameLayout a3;
    boolean b3;
    boolean c3 = true;
    private boolean d3 = true;
    private boolean e3;
    @Nullable
    private MaterialBackOrchestrator f3;

    SheetDialog(@NonNull Context context, @StyleRes int i2, @AttrRes int i3, @StyleRes int i4) {
        super(context, B(context, i2, i3, i4));
        o(1);
    }

    private static int B(@NonNull Context context, @StyleRes int i2, @AttrRes int i3, @StyleRes int i4) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(i3, typedValue, true) ? typedValue.resourceId : i4;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(View view) {
        if (this.c3 && isShowing() && H()) {
            cancel();
        }
    }

    private void E() {
        FrameLayout frameLayout;
        Window window = getWindow();
        if (window != null && (frameLayout = this.a3) != null && (frameLayout.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
            window.setWindowAnimations(GravityCompat.d(((CoordinatorLayout.LayoutParams) this.a3.getLayoutParams()).f5079c, ViewCompat.c0(this.a3)) == 3 ? R.style.f20742i : R.style.f20743j);
        }
    }

    private boolean H() {
        if (!this.e3) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
            this.d3 = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.e3 = true;
        }
        return this.d3;
    }

    private void I() {
        MaterialBackOrchestrator materialBackOrchestrator = this.f3;
        if (materialBackOrchestrator != null) {
            if (this.c3) {
                materialBackOrchestrator.c();
            } else {
                materialBackOrchestrator.f();
            }
        }
    }

    private View J(int i2, @Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        r();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) u().findViewById(g3);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, coordinatorLayout, false);
        }
        FrameLayout x = x();
        x.removeAllViews();
        if (layoutParams == null) {
            x.addView(view);
        } else {
            x.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(h3).setOnClickListener(new a(this));
        ViewCompat.H1(x(), new AccessibilityDelegateCompat() {
            public void g(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                boolean z;
                super.g(view, accessibilityNodeInfoCompat);
                if (SheetDialog.this.c3) {
                    accessibilityNodeInfoCompat.a(1048576);
                    z = true;
                } else {
                    z = false;
                }
                accessibilityNodeInfoCompat.r1(z);
            }

            public boolean j(View view, int i2, Bundle bundle) {
                if (i2 == 1048576) {
                    SheetDialog sheetDialog = SheetDialog.this;
                    if (sheetDialog.c3) {
                        sheetDialog.cancel();
                        return true;
                    }
                }
                return super.j(view, i2, bundle);
            }
        });
        return this.Z2;
    }

    private void r() {
        if (this.Z2 == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), w(), (ViewGroup) null);
            this.Z2 = frameLayout;
            FrameLayout frameLayout2 = (FrameLayout) frameLayout.findViewById(v());
            this.a3 = frameLayout2;
            Sheet<C> t = t(frameLayout2);
            this.Y2 = t;
            q(t);
            this.f3 = new MaterialBackOrchestrator(this.Y2, this.a3);
        }
    }

    @NonNull
    private FrameLayout u() {
        if (this.Z2 == null) {
            r();
        }
        return this.Z2;
    }

    @NonNull
    private FrameLayout x() {
        if (this.a3 == null) {
            r();
        }
        return this.a3;
    }

    public boolean C() {
        return this.b3;
    }

    public void F(boolean z) {
        this.b3 = z;
    }

    public void G(@GravityInt int i2) {
        FrameLayout frameLayout = this.a3;
        if (frameLayout == null) {
            throw new IllegalStateException("Sheet view reference is null; sheet edge cannot be changed if the sheet view is null.");
        } else if (!ViewCompat.Y0(frameLayout)) {
            ViewGroup.LayoutParams layoutParams = this.a3.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                ((CoordinatorLayout.LayoutParams) layoutParams).f5079c = i2;
                E();
            }
        } else {
            throw new IllegalStateException("Sheet view has been laid out; sheet edge cannot be changed once the sheet has been laid out.");
        }
    }

    public void cancel() {
        Sheet s = s();
        if (!this.b3 || s.getState() == 5) {
            super.cancel();
        } else {
            s.b(5);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        E();
        I();
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            int i2 = Build.VERSION.SDK_INT;
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            if (i2 < 23) {
                window.addFlags(67108864);
            }
            window.setLayout(-1, -1);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MaterialBackOrchestrator materialBackOrchestrator = this.f3;
        if (materialBackOrchestrator != null) {
            materialBackOrchestrator.f();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        Sheet<C> sheet = this.Y2;
        if (sheet != null && sheet.getState() == 5) {
            this.Y2.b(z());
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void q(Sheet<C> sheet);

    /* access modifiers changed from: package-private */
    @NonNull
    public Sheet<C> s() {
        if (this.Y2 == null) {
            r();
        }
        return this.Y2;
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.c3 != z) {
            this.c3 = z;
        }
        if (getWindow() != null) {
            I();
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.c3) {
            this.c3 = true;
        }
        this.d3 = z;
        this.e3 = true;
    }

    public void setContentView(@LayoutRes int i2) {
        super.setContentView(J(i2, (View) null, (ViewGroup.LayoutParams) null));
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public abstract Sheet<C> t(@NonNull FrameLayout frameLayout);

    /* access modifiers changed from: package-private */
    @IdRes
    public abstract int v();

    /* access modifiers changed from: package-private */
    @LayoutRes
    public abstract int w();

    /* access modifiers changed from: package-private */
    public abstract int z();

    public void setContentView(@Nullable View view) {
        super.setContentView(J(0, view, (ViewGroup.LayoutParams) null));
    }

    public void setContentView(@Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        super.setContentView(J(0, view, layoutParams));
    }
}
