package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.fragment.app.FragmentTransaction;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class ActionBar {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final int f2690a = 0;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final int f2691b = 1;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final int f2692c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f2693d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static final int f2694e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static final int f2695f = 4;

    /* renamed from: g  reason: collision with root package name */
    public static final int f2696g = 8;

    /* renamed from: h  reason: collision with root package name */
    public static final int f2697h = 16;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DisplayOptions {
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f2698a;

        public LayoutParams(int i2) {
            this(-2, -1, i2);
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.f2698a = 8388627;
        }

        public LayoutParams(int i2, int i3, int i4) {
            super(i2, i3);
            this.f2698a = i4;
        }

        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2698a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.E);
            this.f2698a = obtainStyledAttributes.getInt(R.styleable.F, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2698a = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f2698a = 0;
            this.f2698a = layoutParams.f2698a;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface NavigationMode {
    }

    public interface OnMenuVisibilityListener {
        void a(boolean z);
    }

    @Deprecated
    public interface OnNavigationListener {
        boolean a(int i2, long j2);
    }

    @Deprecated
    public static abstract class Tab {

        /* renamed from: a  reason: collision with root package name */
        public static final int f2699a = -1;

        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract int d();

        public abstract Object e();

        public abstract CharSequence f();

        public abstract void g();

        public abstract Tab h(@StringRes int i2);

        public abstract Tab i(CharSequence charSequence);

        public abstract Tab j(int i2);

        public abstract Tab k(View view);

        public abstract Tab l(@DrawableRes int i2);

        public abstract Tab m(Drawable drawable);

        public abstract Tab n(TabListener tabListener);

        public abstract Tab o(Object obj);

        public abstract Tab p(int i2);

        public abstract Tab q(CharSequence charSequence);
    }

    @Deprecated
    public interface TabListener {
        void C(Tab tab, FragmentTransaction fragmentTransaction);

        void I(Tab tab, FragmentTransaction fragmentTransaction);

        void s(Tab tab, FragmentTransaction fragmentTransaction);
    }

    public Context A() {
        return null;
    }

    public abstract void A0(CharSequence charSequence);

    @Nullable
    public abstract CharSequence B();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void B0(CharSequence charSequence) {
    }

    public abstract void C();

    public abstract void C0();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean D() {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ActionMode D0(ActionMode.Callback callback) {
        return null;
    }

    public boolean E() {
        return false;
    }

    public abstract boolean F();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean G() {
        return false;
    }

    @Deprecated
    public abstract Tab H();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void I(Configuration configuration) {
    }

    /* access modifiers changed from: package-private */
    public void J() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean K(int i2, KeyEvent keyEvent) {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean L(KeyEvent keyEvent) {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean M() {
        return false;
    }

    @Deprecated
    public abstract void N();

    public abstract void O(OnMenuVisibilityListener onMenuVisibilityListener);

    @Deprecated
    public abstract void P(Tab tab);

    @Deprecated
    public abstract void Q(int i2);

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean R() {
        return false;
    }

    @Deprecated
    public abstract void S(Tab tab);

    public abstract void T(@Nullable Drawable drawable);

    public abstract void U(int i2);

    public abstract void V(View view);

    public abstract void W(View view, LayoutParams layoutParams);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void X(boolean z) {
    }

    public abstract void Y(boolean z);

    public abstract void Z(int i2);

    public abstract void a0(int i2, int i3);

    public abstract void b0(boolean z);

    public abstract void c0(boolean z);

    public abstract void d0(boolean z);

    public abstract void e0(boolean z);

    public void f0(float f2) {
        if (f2 != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public abstract void g(OnMenuVisibilityListener onMenuVisibilityListener);

    public void g0(int i2) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Setting an explicit action bar hide offset is not supported in this action bar configuration.");
        }
    }

    @Deprecated
    public abstract void h(Tab tab);

    public void h0(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    @Deprecated
    public abstract void i(Tab tab, int i2);

    public void i0(@StringRes int i2) {
    }

    @Deprecated
    public abstract void j(Tab tab, int i2, boolean z);

    public void j0(@Nullable CharSequence charSequence) {
    }

    @Deprecated
    public abstract void k(Tab tab, boolean z);

    public void k0(@DrawableRes int i2) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean l() {
        return false;
    }

    public void l0(@Nullable Drawable drawable) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean m() {
        return false;
    }

    public void m0(boolean z) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void n(boolean z) {
    }

    public abstract void n0(@DrawableRes int i2);

    public abstract View o();

    public abstract void o0(Drawable drawable);

    public abstract int p();

    @Deprecated
    public abstract void p0(SpinnerAdapter spinnerAdapter, OnNavigationListener onNavigationListener);

    public float q() {
        return 0.0f;
    }

    public abstract void q0(@DrawableRes int i2);

    public abstract int r();

    public abstract void r0(Drawable drawable);

    public int s() {
        return 0;
    }

    @Deprecated
    public abstract void s0(int i2);

    @Deprecated
    public abstract int t();

    @Deprecated
    public abstract void t0(int i2);

    @Deprecated
    public abstract int u();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void u0(boolean z) {
    }

    @Deprecated
    public abstract int v();

    public void v0(Drawable drawable) {
    }

    @Deprecated
    @Nullable
    public abstract Tab w();

    public void w0(Drawable drawable) {
    }

    @Nullable
    public abstract CharSequence x();

    public abstract void x0(int i2);

    @Deprecated
    public abstract Tab y(int i2);

    public abstract void y0(CharSequence charSequence);

    @Deprecated
    public abstract int z();

    public abstract void z0(@StringRes int i2);
}
