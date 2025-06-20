package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ToolbarWidgetWrapper implements DecorToolbar {
    private static final String s = "ToolbarWidgetWrapper";
    private static final int t = 3;
    private static final long u = 200;

    /* renamed from: a  reason: collision with root package name */
    Toolbar f3339a;

    /* renamed from: b  reason: collision with root package name */
    private int f3340b;

    /* renamed from: c  reason: collision with root package name */
    private View f3341c;

    /* renamed from: d  reason: collision with root package name */
    private Spinner f3342d;

    /* renamed from: e  reason: collision with root package name */
    private View f3343e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f3344f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f3345g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f3346h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f3347i;

    /* renamed from: j  reason: collision with root package name */
    CharSequence f3348j;

    /* renamed from: k  reason: collision with root package name */
    private CharSequence f3349k;

    /* renamed from: l  reason: collision with root package name */
    private CharSequence f3350l;

    /* renamed from: m  reason: collision with root package name */
    Window.Callback f3351m;

    /* renamed from: n  reason: collision with root package name */
    boolean f3352n;
    private ActionMenuPresenter o;
    private int p;
    private int q;
    private Drawable r;

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        this(toolbar, z, R.string.f2649b, R.drawable.v);
    }

    private int V() {
        if (this.f3339a.getNavigationIcon() == null) {
            return 11;
        }
        this.r = this.f3339a.getNavigationIcon();
        return 15;
    }

    private void W() {
        if (this.f3342d == null) {
            this.f3342d = new AppCompatSpinner(g(), (AttributeSet) null, R.attr.f2563m);
            this.f3342d.setLayoutParams(new Toolbar.LayoutParams(-2, -2, 8388627));
        }
    }

    private void X(CharSequence charSequence) {
        this.f3348j = charSequence;
        if ((this.f3340b & 8) != 0) {
            this.f3339a.setTitle(charSequence);
            if (this.f3347i) {
                ViewCompat.K1(this.f3339a.getRootView(), charSequence);
            }
        }
    }

    private void Y() {
        if ((this.f3340b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f3350l)) {
            this.f3339a.setNavigationContentDescription(this.q);
        } else {
            this.f3339a.setNavigationContentDescription(this.f3350l);
        }
    }

    private void Z() {
        Toolbar toolbar;
        Drawable drawable;
        if ((this.f3340b & 4) != 0) {
            toolbar = this.f3339a;
            drawable = this.f3346h;
            if (drawable == null) {
                drawable = this.r;
            }
        } else {
            toolbar = this.f3339a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void a0() {
        Drawable drawable;
        int i2 = this.f3340b;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) == 0 || (drawable = this.f3345g) == null) {
            drawable = this.f3344f;
        }
        this.f3339a.setLogo(drawable);
    }

    public boolean A() {
        return this.f3341c != null;
    }

    public int B() {
        return this.p;
    }

    public void C(int i2) {
        ViewPropertyAnimatorCompat D = D(i2, u);
        if (D != null) {
            D.y();
        }
    }

    public ViewPropertyAnimatorCompat D(final int i2, long j2) {
        return ViewCompat.g(this.f3339a).b(i2 == 0 ? 1.0f : 0.0f).s(j2).u(new ViewPropertyAnimatorListenerAdapter() {

            /* renamed from: a  reason: collision with root package name */
            private boolean f3353a = false;

            public void a(View view) {
                this.f3353a = true;
            }

            public void b(View view) {
                if (!this.f3353a) {
                    ToolbarWidgetWrapper.this.f3339a.setVisibility(i2);
                }
            }

            public void c(View view) {
                ToolbarWidgetWrapper.this.f3339a.setVisibility(0);
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void E(int r5) {
        /*
            r4 = this;
            int r0 = r4.p
            if (r5 == r0) goto L_0x0072
            r1 = 2
            r2 = 1
            if (r0 == r2) goto L_0x001d
            if (r0 == r1) goto L_0x000b
            goto L_0x002c
        L_0x000b:
            android.view.View r0 = r4.f3341c
            if (r0 == 0) goto L_0x002c
            android.view.ViewParent r0 = r0.getParent()
            androidx.appcompat.widget.Toolbar r3 = r4.f3339a
            if (r0 != r3) goto L_0x002c
            android.view.View r0 = r4.f3341c
        L_0x0019:
            r3.removeView(r0)
            goto L_0x002c
        L_0x001d:
            android.widget.Spinner r0 = r4.f3342d
            if (r0 == 0) goto L_0x002c
            android.view.ViewParent r0 = r0.getParent()
            androidx.appcompat.widget.Toolbar r3 = r4.f3339a
            if (r0 != r3) goto L_0x002c
            android.widget.Spinner r0 = r4.f3342d
            goto L_0x0019
        L_0x002c:
            r4.p = r5
            if (r5 == 0) goto L_0x0072
            r0 = 0
            if (r5 == r2) goto L_0x0068
            if (r5 != r1) goto L_0x0051
            android.view.View r5 = r4.f3341c
            if (r5 == 0) goto L_0x0072
            androidx.appcompat.widget.Toolbar r1 = r4.f3339a
            r1.addView(r5, r0)
            android.view.View r5 = r4.f3341c
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r5 = (androidx.appcompat.widget.Toolbar.LayoutParams) r5
            r0 = -2
            r5.width = r0
            r5.height = r0
            r0 = 8388691(0x800053, float:1.175506E-38)
            r5.f2698a = r0
            goto L_0x0072
        L_0x0051:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid navigation mode "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            throw r0
        L_0x0068:
            r4.W()
            androidx.appcompat.widget.Toolbar r5 = r4.f3339a
            android.widget.Spinner r1 = r4.f3342d
            r5.addView(r1, r0)
        L_0x0072:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ToolbarWidgetWrapper.E(int):void");
    }

    public void F(int i2) {
        T(i2 != 0 ? AppCompatResources.b(g(), i2) : null);
    }

    public void G(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.f3339a.S(callback, callback2);
    }

    public ViewGroup H() {
        return this.f3339a;
    }

    public void I(boolean z) {
    }

    public void J(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        W();
        this.f3342d.setAdapter(spinnerAdapter);
        this.f3342d.setOnItemSelectedListener(onItemSelectedListener);
    }

    public void K(SparseArray<Parcelable> sparseArray) {
        this.f3339a.restoreHierarchyState(sparseArray);
    }

    public CharSequence L() {
        return this.f3339a.getSubtitle();
    }

    public int M() {
        return this.f3340b;
    }

    public int N() {
        Spinner spinner = this.f3342d;
        if (spinner != null) {
            return spinner.getSelectedItemPosition();
        }
        return 0;
    }

    public void O(int i2) {
        u(i2 == 0 ? null : g().getString(i2));
    }

    public void P(View view) {
        View view2 = this.f3343e;
        if (!(view2 == null || (this.f3340b & 16) == 0)) {
            this.f3339a.removeView(view2);
        }
        this.f3343e = view;
        if (view != null && (this.f3340b & 16) != 0) {
            this.f3339a.addView(view);
        }
    }

    public void Q() {
        Log.i(s, "Progress display unsupported");
    }

    public int R() {
        Spinner spinner = this.f3342d;
        if (spinner != null) {
            return spinner.getCount();
        }
        return 0;
    }

    public void S() {
        Log.i(s, "Progress display unsupported");
    }

    public void T(Drawable drawable) {
        this.f3346h = drawable;
        Z();
    }

    public void U(boolean z) {
        this.f3339a.setCollapsible(z);
    }

    public void a(Menu menu, MenuPresenter.Callback callback) {
        if (this.o == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f3339a.getContext());
            this.o = actionMenuPresenter;
            actionMenuPresenter.s(R.id.f2618j);
        }
        this.o.h(callback);
        this.f3339a.R((MenuBuilder) menu, this.o);
    }

    public int b() {
        return this.f3339a.getVisibility();
    }

    public void c(Drawable drawable) {
        this.f3339a.setBackground(drawable);
    }

    public void collapseActionView() {
        this.f3339a.g();
    }

    public boolean d() {
        return this.f3339a.D();
    }

    public void e() {
        this.f3352n = true;
    }

    public boolean f() {
        return this.f3344f != null;
    }

    public Context g() {
        return this.f3339a.getContext();
    }

    public int getHeight() {
        return this.f3339a.getHeight();
    }

    public CharSequence getTitle() {
        return this.f3339a.getTitle();
    }

    public boolean h() {
        return this.f3339a.e();
    }

    public boolean i() {
        return this.f3345g != null;
    }

    public boolean j() {
        return this.f3339a.C();
    }

    public boolean k() {
        return this.f3339a.y();
    }

    public boolean l() {
        return this.f3339a.Y();
    }

    public void m(int i2) {
        if (i2 != this.q) {
            this.q = i2;
            if (TextUtils.isEmpty(this.f3339a.getNavigationContentDescription())) {
                O(this.q);
            }
        }
    }

    public void n() {
        this.f3339a.h();
    }

    public View o() {
        return this.f3343e;
    }

    public void p(ScrollingTabContainerView scrollingTabContainerView) {
        Toolbar toolbar;
        View view = this.f3341c;
        if (view != null && view.getParent() == (toolbar = this.f3339a)) {
            toolbar.removeView(this.f3341c);
        }
        this.f3341c = scrollingTabContainerView;
        if (scrollingTabContainerView != null && this.p == 2) {
            this.f3339a.addView(scrollingTabContainerView, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f3341c.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.f2698a = 8388691;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    public void q(Drawable drawable) {
        this.f3345g = drawable;
        a0();
    }

    public boolean r() {
        return this.f3339a.x();
    }

    public boolean s() {
        return this.f3339a.E();
    }

    public void setIcon(int i2) {
        setIcon(i2 != 0 ? AppCompatResources.b(g(), i2) : null);
    }

    public void setLogo(int i2) {
        q(i2 != 0 ? AppCompatResources.b(g(), i2) : null);
    }

    public void setTitle(CharSequence charSequence) {
        this.f3347i = true;
        X(charSequence);
    }

    public void setVisibility(int i2) {
        this.f3339a.setVisibility(i2);
    }

    public void setWindowCallback(Window.Callback callback) {
        this.f3351m = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.f3347i) {
            X(charSequence);
        }
    }

    public void t(int i2) {
        View view;
        CharSequence charSequence;
        Toolbar toolbar;
        int i3 = this.f3340b ^ i2;
        this.f3340b = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    Y();
                }
                Z();
            }
            if ((i3 & 3) != 0) {
                a0();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.f3339a.setTitle(this.f3348j);
                    toolbar = this.f3339a;
                    charSequence = this.f3349k;
                } else {
                    charSequence = null;
                    this.f3339a.setTitle((CharSequence) null);
                    toolbar = this.f3339a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i3 & 16) != 0 && (view = this.f3343e) != null) {
                if ((i2 & 16) != 0) {
                    this.f3339a.addView(view);
                } else {
                    this.f3339a.removeView(view);
                }
            }
        }
    }

    public void u(CharSequence charSequence) {
        this.f3350l = charSequence;
        Y();
    }

    public void v(CharSequence charSequence) {
        this.f3349k = charSequence;
        if ((this.f3340b & 8) != 0) {
            this.f3339a.setSubtitle(charSequence);
        }
    }

    public void w(Drawable drawable) {
        if (this.r != drawable) {
            this.r = drawable;
            Z();
        }
    }

    public void x(SparseArray<Parcelable> sparseArray) {
        this.f3339a.saveHierarchyState(sparseArray);
    }

    public void y(int i2) {
        Spinner spinner = this.f3342d;
        if (spinner != null) {
            spinner.setSelection(i2);
            return;
        }
        throw new IllegalStateException("Can't set dropdown selected position without an adapter");
    }

    public Menu z() {
        return this.f3339a.getMenu();
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z, int i2, int i3) {
        Drawable drawable;
        this.p = 0;
        this.q = 0;
        this.f3339a = toolbar;
        this.f3348j = toolbar.getTitle();
        this.f3349k = toolbar.getSubtitle();
        this.f3347i = this.f3348j != null;
        this.f3346h = toolbar.getNavigationIcon();
        TintTypedArray G = TintTypedArray.G(toolbar.getContext(), (AttributeSet) null, R.styleable.f2676a, R.attr.f2556f, 0);
        this.r = G.h(R.styleable.q);
        if (z) {
            CharSequence x = G.x(R.styleable.C);
            if (!TextUtils.isEmpty(x)) {
                setTitle(x);
            }
            CharSequence x2 = G.x(R.styleable.A);
            if (!TextUtils.isEmpty(x2)) {
                v(x2);
            }
            Drawable h2 = G.h(R.styleable.v);
            if (h2 != null) {
                q(h2);
            }
            Drawable h3 = G.h(R.styleable.s);
            if (h3 != null) {
                setIcon(h3);
            }
            if (this.f3346h == null && (drawable = this.r) != null) {
                T(drawable);
            }
            t(G.o(R.styleable.f2687l, 0));
            int u2 = G.u(R.styleable.f2686k, 0);
            if (u2 != 0) {
                P(LayoutInflater.from(this.f3339a.getContext()).inflate(u2, this.f3339a, false));
                t(this.f3340b | 16);
            }
            int q2 = G.q(R.styleable.o, 0);
            if (q2 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f3339a.getLayoutParams();
                layoutParams.height = q2;
                this.f3339a.setLayoutParams(layoutParams);
            }
            int f2 = G.f(R.styleable.f2684i, -1);
            int f3 = G.f(R.styleable.f2680e, -1);
            if (f2 >= 0 || f3 >= 0) {
                this.f3339a.Q(Math.max(f2, 0), Math.max(f3, 0));
            }
            int u3 = G.u(R.styleable.D, 0);
            if (u3 != 0) {
                Toolbar toolbar2 = this.f3339a;
                toolbar2.V(toolbar2.getContext(), u3);
            }
            int u4 = G.u(R.styleable.B, 0);
            if (u4 != 0) {
                Toolbar toolbar3 = this.f3339a;
                toolbar3.T(toolbar3.getContext(), u4);
            }
            int u5 = G.u(R.styleable.x, 0);
            if (u5 != 0) {
                this.f3339a.setPopupTheme(u5);
            }
        } else {
            this.f3340b = V();
        }
        G.I();
        m(i2);
        this.f3350l = this.f3339a.getNavigationContentDescription();
        this.f3339a.setNavigationOnClickListener(new View.OnClickListener() {
            final ActionMenuItem s;

            {
                this.s = new ActionMenuItem(ToolbarWidgetWrapper.this.f3339a.getContext(), 0, 16908332, 0, 0, ToolbarWidgetWrapper.this.f3348j);
            }

            public void onClick(View view) {
                ToolbarWidgetWrapper toolbarWidgetWrapper = ToolbarWidgetWrapper.this;
                Window.Callback callback = toolbarWidgetWrapper.f3351m;
                if (callback != null && toolbarWidgetWrapper.f3352n) {
                    callback.onMenuItemSelected(0, this.s);
                }
            }
        });
    }

    public void setIcon(Drawable drawable) {
        this.f3344f = drawable;
        a0();
    }
}
