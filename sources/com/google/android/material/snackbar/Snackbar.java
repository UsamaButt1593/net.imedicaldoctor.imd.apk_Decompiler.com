package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    private static final int[] W;
    private static final int[] X;
    @Nullable
    private final AccessibilityManager T;
    private boolean U;
    @Nullable
    private BaseTransientBottomBar.BaseCallback<Snackbar> V;

    public static class Callback extends BaseTransientBottomBar.BaseCallback<Snackbar> {

        /* renamed from: f  reason: collision with root package name */
        public static final int f21963f = 0;

        /* renamed from: g  reason: collision with root package name */
        public static final int f21964g = 1;

        /* renamed from: h  reason: collision with root package name */
        public static final int f21965h = 2;

        /* renamed from: i  reason: collision with root package name */
        public static final int f21966i = 3;

        /* renamed from: j  reason: collision with root package name */
        public static final int f21967j = 4;

        /* renamed from: c */
        public void a(Snackbar snackbar, int i2) {
        }

        /* renamed from: d */
        public void b(Snackbar snackbar) {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        public /* bridge */ /* synthetic */ void setBackground(@Nullable Drawable drawable) {
            super.setBackground(drawable);
        }

        public /* bridge */ /* synthetic */ void setBackgroundDrawable(@Nullable Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        public /* bridge */ /* synthetic */ void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        public /* bridge */ /* synthetic */ void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        public /* bridge */ /* synthetic */ void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
        }

        public /* bridge */ /* synthetic */ void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    static {
        int i2 = R.attr.Hg;
        W = new int[]{i2};
        X = new int[]{i2, R.attr.Jg};
    }

    private Snackbar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull ContentViewCallback contentViewCallback) {
        super(context, viewGroup, view, contentViewCallback);
        this.T = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    private static boolean A0(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(X);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
        obtainStyledAttributes.recycle();
        return (resourceId == -1 || resourceId2 == -1) ? false : true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B0(View.OnClickListener onClickListener, View view) {
        onClickListener.onClick(view);
        B(1);
    }

    @NonNull
    public static Snackbar C0(@NonNull Context context, @NonNull View view, @NonNull CharSequence charSequence, int i2) {
        return F0(context, view, charSequence, i2);
    }

    @NonNull
    public static Snackbar D0(@NonNull View view, @StringRes int i2, int i3) {
        return E0(view, view.getResources().getText(i2), i3);
    }

    @NonNull
    public static Snackbar E0(@NonNull View view, @NonNull CharSequence charSequence, int i2) {
        return F0((Context) null, view, charSequence, i2);
    }

    @NonNull
    private static Snackbar F0(@Nullable Context context, @NonNull View view, @NonNull CharSequence charSequence, int i2) {
        ViewGroup v0 = v0(view);
        if (v0 != null) {
            if (context == null) {
                context = v0.getContext();
            }
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(context).inflate(A0(context) ? R.layout.F0 : R.layout.G, v0, false);
            Snackbar snackbar = new Snackbar(context, v0, snackbarContentLayout, snackbarContentLayout);
            snackbar.Q0(charSequence);
            snackbar.h0(i2);
            return snackbar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    @Nullable
    private static ViewGroup v0(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                    continue;
                } else {
                    view = null;
                    continue;
                }
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    private Button w0() {
        return x0().getActionView();
    }

    private SnackbarContentLayout x0() {
        return (SnackbarContentLayout) this.f21947i.getChildAt(0);
    }

    private TextView y0() {
        return x0().getMessageView();
    }

    @Deprecated
    protected static boolean z0(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(W);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    public void A() {
        super.A();
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar G0(@StringRes int i2, View.OnClickListener onClickListener) {
        return H0(G().getText(i2), onClickListener);
    }

    public int H() {
        int H = super.H();
        if (H == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return this.T.getRecommendedTimeoutMillis(H, (this.U ? 4 : 0) | 3);
        } else if (!this.U || !this.T.isTouchExplorationEnabled()) {
            return H;
        } else {
            return -2;
        }
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar H0(@Nullable CharSequence charSequence, @Nullable View.OnClickListener onClickListener) {
        Button w0 = w0();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            w0.setVisibility(8);
            w0.setOnClickListener((View.OnClickListener) null);
            this.U = false;
        } else {
            this.U = true;
            w0.setVisibility(0);
            w0.setText(charSequence);
            w0.setOnClickListener(new c(this, onClickListener));
        }
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar I0(@ColorInt int i2) {
        w0().setTextColor(i2);
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar J0(ColorStateList colorStateList) {
        w0().setTextColor(colorStateList);
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar K0(@ColorInt int i2) {
        return L0(ColorStateList.valueOf(i2));
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar L0(@Nullable ColorStateList colorStateList) {
        this.f21947i.setBackgroundTintList(colorStateList);
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar M0(@Nullable PorterDuff.Mode mode) {
        this.f21947i.setBackgroundTintMode(mode);
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    @Deprecated
    public Snackbar N0(@Nullable Callback callback) {
        BaseTransientBottomBar.BaseCallback<Snackbar> baseCallback = this.V;
        if (baseCallback != null) {
            b0(baseCallback);
        }
        if (callback != null) {
            u(callback);
        }
        this.V = callback;
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar O0(@Dimension int i2) {
        x0().setMaxInlineActionWidth(i2);
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar P0(@StringRes int i2) {
        return Q0(G().getText(i2));
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar Q0(@NonNull CharSequence charSequence) {
        y0().setText(charSequence);
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar R0(@ColorInt int i2) {
        y0().setTextColor(i2);
        return this;
    }

    public boolean S() {
        return super.S();
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar S0(ColorStateList colorStateList) {
        y0().setTextColor(colorStateList);
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public Snackbar T0(int i2) {
        y0().setMaxLines(i2);
        return this;
    }

    public void m0() {
        super.m0();
    }
}
