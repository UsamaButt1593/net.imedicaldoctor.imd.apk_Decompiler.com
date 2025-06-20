package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {
    private static final String N = "WindowDecorActionBar";
    private static final Interpolator O = new AccelerateInterpolator();
    private static final Interpolator P = new DecelerateInterpolator();
    private static final int Q = -1;
    private static final long R = 100;
    private static final long S = 200;
    private boolean A;
    private int B = 0;
    boolean C = true;
    boolean D;
    boolean E;
    private boolean F;
    private boolean G = true;
    ViewPropertyAnimatorCompatSet H;
    private boolean I;
    boolean J;
    final ViewPropertyAnimatorListener K = new ViewPropertyAnimatorListenerAdapter() {
        public void b(View view) {
            View view2;
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.C && (view2 = windowDecorActionBar.p) != null) {
                view2.setTranslationY(0.0f);
                WindowDecorActionBar.this.f2840m.setTranslationY(0.0f);
            }
            WindowDecorActionBar.this.f2840m.setVisibility(8);
            WindowDecorActionBar.this.f2840m.setTransitioning(false);
            WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
            windowDecorActionBar2.H = null;
            windowDecorActionBar2.H0();
            ActionBarOverlayLayout actionBarOverlayLayout = WindowDecorActionBar.this.f2839l;
            if (actionBarOverlayLayout != null) {
                ViewCompat.B1(actionBarOverlayLayout);
            }
        }
    };
    final ViewPropertyAnimatorListener L = new ViewPropertyAnimatorListenerAdapter() {
        public void b(View view) {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            windowDecorActionBar.H = null;
            windowDecorActionBar.f2840m.requestLayout();
        }
    };
    final ViewPropertyAnimatorUpdateListener M = new ViewPropertyAnimatorUpdateListener() {
        public void a(View view) {
            ((View) WindowDecorActionBar.this.f2840m.getParent()).invalidate();
        }
    };

    /* renamed from: i  reason: collision with root package name */
    Context f2836i;

    /* renamed from: j  reason: collision with root package name */
    private Context f2837j;

    /* renamed from: k  reason: collision with root package name */
    private Activity f2838k;

    /* renamed from: l  reason: collision with root package name */
    ActionBarOverlayLayout f2839l;

    /* renamed from: m  reason: collision with root package name */
    ActionBarContainer f2840m;

    /* renamed from: n  reason: collision with root package name */
    DecorToolbar f2841n;
    ActionBarContextView o;
    View p;
    ScrollingTabContainerView q;
    private ArrayList<TabImpl> r = new ArrayList<>();
    private TabImpl s;
    private int t = -1;
    private boolean u;
    ActionModeImpl v;
    ActionMode w;
    ActionMode.Callback x;
    private boolean y;
    private ArrayList<ActionBar.OnMenuVisibilityListener> z = new ArrayList<>();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        private ActionMode.Callback X2;
        private final Context Y;
        private WeakReference<View> Y2;
        private final MenuBuilder Z;

        public ActionModeImpl(Context context, ActionMode.Callback callback) {
            this.Y = context;
            this.X2 = callback;
            MenuBuilder a0 = new MenuBuilder(context).a0(1);
            this.Z = a0;
            a0.Y(this);
        }

        public boolean a(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            ActionMode.Callback callback = this.X2;
            if (callback != null) {
                return callback.d(this, menuItem);
            }
            return false;
        }

        public void b(@NonNull MenuBuilder menuBuilder) {
            if (this.X2 != null) {
                k();
                WindowDecorActionBar.this.o.o();
            }
        }

        public void c() {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.v == this) {
                if (!WindowDecorActionBar.F0(windowDecorActionBar.D, windowDecorActionBar.E, false)) {
                    WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
                    windowDecorActionBar2.w = this;
                    windowDecorActionBar2.x = this.X2;
                } else {
                    this.X2.a(this);
                }
                this.X2 = null;
                WindowDecorActionBar.this.E0(false);
                WindowDecorActionBar.this.o.p();
                WindowDecorActionBar windowDecorActionBar3 = WindowDecorActionBar.this;
                windowDecorActionBar3.f2839l.setHideOnContentScrollEnabled(windowDecorActionBar3.J);
                WindowDecorActionBar.this.v = null;
            }
        }

        public View d() {
            WeakReference<View> weakReference = this.Y2;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        public Menu e() {
            return this.Z;
        }

        public MenuInflater f() {
            return new SupportMenuInflater(this.Y);
        }

        public CharSequence g() {
            return WindowDecorActionBar.this.o.getSubtitle();
        }

        public CharSequence i() {
            return WindowDecorActionBar.this.o.getTitle();
        }

        public void k() {
            if (WindowDecorActionBar.this.v == this) {
                this.Z.n0();
                try {
                    this.X2.c(this, this.Z);
                } finally {
                    this.Z.m0();
                }
            }
        }

        public boolean l() {
            return WindowDecorActionBar.this.o.s();
        }

        public void n(View view) {
            WindowDecorActionBar.this.o.setCustomView(view);
            this.Y2 = new WeakReference<>(view);
        }

        public void o(int i2) {
            p(WindowDecorActionBar.this.f2836i.getResources().getString(i2));
        }

        public void p(CharSequence charSequence) {
            WindowDecorActionBar.this.o.setSubtitle(charSequence);
        }

        public void r(int i2) {
            s(WindowDecorActionBar.this.f2836i.getResources().getString(i2));
        }

        public void s(CharSequence charSequence) {
            WindowDecorActionBar.this.o.setTitle(charSequence);
        }

        public void t(boolean z) {
            super.t(z);
            WindowDecorActionBar.this.o.setTitleOptional(z);
        }

        public boolean u() {
            this.Z.n0();
            try {
                return this.X2.b(this, this.Z);
            } finally {
                this.Z.m0();
            }
        }

        public void v(MenuBuilder menuBuilder, boolean z) {
        }

        public void w(SubMenuBuilder subMenuBuilder) {
        }

        public boolean x(SubMenuBuilder subMenuBuilder) {
            if (this.X2 == null) {
                return false;
            }
            if (!subMenuBuilder.hasVisibleItems()) {
                return true;
            }
            new MenuPopupHelper(WindowDecorActionBar.this.A(), subMenuBuilder).l();
            return true;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public class TabImpl extends ActionBar.Tab {

        /* renamed from: b  reason: collision with root package name */
        private ActionBar.TabListener f2845b;

        /* renamed from: c  reason: collision with root package name */
        private Object f2846c;

        /* renamed from: d  reason: collision with root package name */
        private Drawable f2847d;

        /* renamed from: e  reason: collision with root package name */
        private CharSequence f2848e;

        /* renamed from: f  reason: collision with root package name */
        private CharSequence f2849f;

        /* renamed from: g  reason: collision with root package name */
        private int f2850g = -1;

        /* renamed from: h  reason: collision with root package name */
        private View f2851h;

        public TabImpl() {
        }

        public CharSequence a() {
            return this.f2849f;
        }

        public View b() {
            return this.f2851h;
        }

        public Drawable c() {
            return this.f2847d;
        }

        public int d() {
            return this.f2850g;
        }

        public Object e() {
            return this.f2846c;
        }

        public CharSequence f() {
            return this.f2848e;
        }

        public void g() {
            WindowDecorActionBar.this.S(this);
        }

        public ActionBar.Tab h(int i2) {
            return i(WindowDecorActionBar.this.f2836i.getResources().getText(i2));
        }

        public ActionBar.Tab i(CharSequence charSequence) {
            this.f2849f = charSequence;
            int i2 = this.f2850g;
            if (i2 >= 0) {
                WindowDecorActionBar.this.q.m(i2);
            }
            return this;
        }

        public ActionBar.Tab j(int i2) {
            return k(LayoutInflater.from(WindowDecorActionBar.this.A()).inflate(i2, (ViewGroup) null));
        }

        public ActionBar.Tab k(View view) {
            this.f2851h = view;
            int i2 = this.f2850g;
            if (i2 >= 0) {
                WindowDecorActionBar.this.q.m(i2);
            }
            return this;
        }

        public ActionBar.Tab l(int i2) {
            return m(AppCompatResources.b(WindowDecorActionBar.this.f2836i, i2));
        }

        public ActionBar.Tab m(Drawable drawable) {
            this.f2847d = drawable;
            int i2 = this.f2850g;
            if (i2 >= 0) {
                WindowDecorActionBar.this.q.m(i2);
            }
            return this;
        }

        public ActionBar.Tab n(ActionBar.TabListener tabListener) {
            this.f2845b = tabListener;
            return this;
        }

        public ActionBar.Tab o(Object obj) {
            this.f2846c = obj;
            return this;
        }

        public ActionBar.Tab p(int i2) {
            return q(WindowDecorActionBar.this.f2836i.getResources().getText(i2));
        }

        public ActionBar.Tab q(CharSequence charSequence) {
            this.f2848e = charSequence;
            int i2 = this.f2850g;
            if (i2 >= 0) {
                WindowDecorActionBar.this.q.m(i2);
            }
            return this;
        }

        public ActionBar.TabListener r() {
            return this.f2845b;
        }

        public void s(int i2) {
            this.f2850g = i2;
        }
    }

    public WindowDecorActionBar(Activity activity, boolean z2) {
        this.f2838k = activity;
        View decorView = activity.getWindow().getDecorView();
        Q0(decorView);
        if (!z2) {
            this.p = decorView.findViewById(16908290);
        }
    }

    static boolean F0(boolean z2, boolean z3, boolean z4) {
        if (z4) {
            return true;
        }
        return !z2 && !z3;
    }

    private void G0() {
        if (this.s != null) {
            S((ActionBar.Tab) null);
        }
        this.r.clear();
        ScrollingTabContainerView scrollingTabContainerView = this.q;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.k();
        }
        this.t = -1;
    }

    private void I0(ActionBar.Tab tab, int i2) {
        TabImpl tabImpl = (TabImpl) tab;
        if (tabImpl.r() != null) {
            tabImpl.s(i2);
            this.r.add(i2, tabImpl);
            int size = this.r.size();
            while (true) {
                i2++;
                if (i2 < size) {
                    this.r.get(i2).s(i2);
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
    }

    private void L0() {
        if (this.q == null) {
            ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.f2836i);
            if (this.A) {
                scrollingTabContainerView.setVisibility(0);
                this.f2841n.p(scrollingTabContainerView);
            } else {
                if (u() == 2) {
                    scrollingTabContainerView.setVisibility(0);
                    ActionBarOverlayLayout actionBarOverlayLayout = this.f2839l;
                    if (actionBarOverlayLayout != null) {
                        ViewCompat.B1(actionBarOverlayLayout);
                    }
                } else {
                    scrollingTabContainerView.setVisibility(8);
                }
                this.f2840m.setTabContainer(scrollingTabContainerView);
            }
            this.q = scrollingTabContainerView;
        }
    }

    private DecorToolbar M0(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void P0() {
        if (this.F) {
            this.F = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f2839l;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            U0(false);
        }
    }

    private void Q0(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R.id.x);
        this.f2839l = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f2841n = M0(view.findViewById(R.id.f2609a));
        this.o = (ActionBarContextView) view.findViewById(R.id.f2616h);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R.id.f2611c);
        this.f2840m = actionBarContainer;
        DecorToolbar decorToolbar = this.f2841n;
        if (decorToolbar == null || this.o == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f2836i = decorToolbar.g();
        boolean z2 = (this.f2841n.M() & 4) != 0;
        if (z2) {
            this.u = true;
        }
        ActionBarPolicy b2 = ActionBarPolicy.b(this.f2836i);
        m0(b2.a() || z2);
        R0(b2.g());
        TypedArray obtainStyledAttributes = this.f2836i.obtainStyledAttributes((AttributeSet) null, R.styleable.f2676a, R.attr.f2556f, 0);
        if (obtainStyledAttributes.getBoolean(R.styleable.p, false)) {
            h0(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.f2689n, 0);
        if (dimensionPixelSize != 0) {
            f0((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private void R0(boolean z2) {
        this.A = z2;
        if (!z2) {
            this.f2841n.p((ScrollingTabContainerView) null);
            this.f2840m.setTabContainer(this.q);
        } else {
            this.f2840m.setTabContainer((ScrollingTabContainerView) null);
            this.f2841n.p(this.q);
        }
        boolean z3 = true;
        boolean z4 = u() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.q;
        if (scrollingTabContainerView != null) {
            if (z4) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f2839l;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.B1(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.f2841n.U(!this.A && z4);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f2839l;
        if (this.A || !z4) {
            z3 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z3);
    }

    private boolean S0() {
        return this.f2840m.isLaidOut();
    }

    private void T0() {
        if (!this.F) {
            this.F = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f2839l;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            U0(false);
        }
    }

    private void U0(boolean z2) {
        if (F0(this.D, this.E, this.F)) {
            if (!this.G) {
                this.G = true;
                K0(z2);
            }
        } else if (this.G) {
            this.G = false;
            J0(z2);
        }
    }

    public Context A() {
        if (this.f2837j == null) {
            TypedValue typedValue = new TypedValue();
            this.f2836i.getTheme().resolveAttribute(R.attr.f2561k, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.f2837j = new ContextThemeWrapper(this.f2836i, i2);
            } else {
                this.f2837j = this.f2836i;
            }
        }
        return this.f2837j;
    }

    public void A0(CharSequence charSequence) {
        this.f2841n.setTitle(charSequence);
    }

    public CharSequence B() {
        return this.f2841n.getTitle();
    }

    public void B0(CharSequence charSequence) {
        this.f2841n.setWindowTitle(charSequence);
    }

    public void C() {
        if (!this.D) {
            this.D = true;
            U0(false);
        }
    }

    public void C0() {
        if (this.D) {
            this.D = false;
            U0(false);
        }
    }

    public ActionMode D0(ActionMode.Callback callback) {
        ActionModeImpl actionModeImpl = this.v;
        if (actionModeImpl != null) {
            actionModeImpl.c();
        }
        this.f2839l.setHideOnContentScrollEnabled(false);
        this.o.t();
        ActionModeImpl actionModeImpl2 = new ActionModeImpl(this.o.getContext(), callback);
        if (!actionModeImpl2.u()) {
            return null;
        }
        this.v = actionModeImpl2;
        actionModeImpl2.k();
        this.o.q(actionModeImpl2);
        E0(true);
        return actionModeImpl2;
    }

    public boolean E() {
        return this.f2839l.B();
    }

    public void E0(boolean z2) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
        if (z2) {
            T0();
        } else {
            P0();
        }
        if (S0()) {
            if (z2) {
                viewPropertyAnimatorCompat = this.f2841n.D(4, R);
                viewPropertyAnimatorCompat2 = this.o.n(0, S);
            } else {
                viewPropertyAnimatorCompat2 = this.f2841n.D(0, S);
                viewPropertyAnimatorCompat = this.o.n(8, R);
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            viewPropertyAnimatorCompatSet.d(viewPropertyAnimatorCompat, viewPropertyAnimatorCompat2);
            viewPropertyAnimatorCompatSet.h();
        } else if (z2) {
            this.f2841n.setVisibility(4);
            this.o.setVisibility(0);
        } else {
            this.f2841n.setVisibility(0);
            this.o.setVisibility(8);
        }
    }

    public boolean F() {
        int r2 = r();
        return this.G && (r2 == 0 || s() < r2);
    }

    public boolean G() {
        DecorToolbar decorToolbar = this.f2841n;
        return decorToolbar != null && decorToolbar.s();
    }

    public ActionBar.Tab H() {
        return new TabImpl();
    }

    /* access modifiers changed from: package-private */
    public void H0() {
        ActionMode.Callback callback = this.x;
        if (callback != null) {
            callback.a(this.w);
            this.w = null;
            this.x = null;
        }
    }

    public void I(Configuration configuration) {
        R0(ActionBarPolicy.b(this.f2836i).g());
    }

    public void J0(boolean z2) {
        View view;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.H;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
        }
        if (this.B != 0 || (!this.I && !z2)) {
            this.K.b((View) null);
            return;
        }
        this.f2840m.setAlpha(1.0f);
        this.f2840m.setTransitioning(true);
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
        float f2 = (float) (-this.f2840m.getHeight());
        if (z2) {
            int[] iArr = {0, 0};
            this.f2840m.getLocationInWindow(iArr);
            f2 -= (float) iArr[1];
        }
        ViewPropertyAnimatorCompat B2 = ViewCompat.g(this.f2840m).B(f2);
        B2.x(this.M);
        viewPropertyAnimatorCompatSet2.c(B2);
        if (this.C && (view = this.p) != null) {
            viewPropertyAnimatorCompatSet2.c(ViewCompat.g(view).B(f2));
        }
        viewPropertyAnimatorCompatSet2.f(O);
        viewPropertyAnimatorCompatSet2.e(250);
        viewPropertyAnimatorCompatSet2.g(this.K);
        this.H = viewPropertyAnimatorCompatSet2;
        viewPropertyAnimatorCompatSet2.h();
    }

    public boolean K(int i2, KeyEvent keyEvent) {
        Menu e2;
        ActionModeImpl actionModeImpl = this.v;
        if (actionModeImpl == null || (e2 = actionModeImpl.e()) == null) {
            return false;
        }
        boolean z2 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z2 = false;
        }
        e2.setQwertyMode(z2);
        return e2.performShortcut(i2, keyEvent, 0);
    }

    public void K0(boolean z2) {
        View view;
        View view2;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.H;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
        }
        this.f2840m.setVisibility(0);
        if (this.B != 0 || (!this.I && !z2)) {
            this.f2840m.setAlpha(1.0f);
            this.f2840m.setTranslationY(0.0f);
            if (this.C && (view = this.p) != null) {
                view.setTranslationY(0.0f);
            }
            this.L.b((View) null);
        } else {
            this.f2840m.setTranslationY(0.0f);
            float f2 = (float) (-this.f2840m.getHeight());
            if (z2) {
                int[] iArr = {0, 0};
                this.f2840m.getLocationInWindow(iArr);
                f2 -= (float) iArr[1];
            }
            this.f2840m.setTranslationY(f2);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat B2 = ViewCompat.g(this.f2840m).B(0.0f);
            B2.x(this.M);
            viewPropertyAnimatorCompatSet2.c(B2);
            if (this.C && (view2 = this.p) != null) {
                view2.setTranslationY(f2);
                viewPropertyAnimatorCompatSet2.c(ViewCompat.g(this.p).B(0.0f));
            }
            viewPropertyAnimatorCompatSet2.f(P);
            viewPropertyAnimatorCompatSet2.e(250);
            viewPropertyAnimatorCompatSet2.g(this.L);
            this.H = viewPropertyAnimatorCompatSet2;
            viewPropertyAnimatorCompatSet2.h();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f2839l;
        if (actionBarOverlayLayout != null) {
            ViewCompat.B1(actionBarOverlayLayout);
        }
    }

    public void N() {
        G0();
    }

    public boolean N0() {
        return this.f2841n.f();
    }

    public void O(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.z.remove(onMenuVisibilityListener);
    }

    public boolean O0() {
        return this.f2841n.i();
    }

    public void P(ActionBar.Tab tab) {
        Q(tab.d());
    }

    public void Q(int i2) {
        if (this.q != null) {
            TabImpl tabImpl = this.s;
            int d2 = tabImpl != null ? tabImpl.d() : this.t;
            this.q.l(i2);
            TabImpl remove = this.r.remove(i2);
            if (remove != null) {
                remove.s(-1);
            }
            int size = this.r.size();
            for (int i3 = i2; i3 < size; i3++) {
                this.r.get(i3).s(i3);
            }
            if (d2 == i2) {
                S(this.r.isEmpty() ? null : this.r.get(Math.max(0, i2 - 1)));
            }
        }
    }

    public boolean R() {
        ViewGroup H2 = this.f2841n.H();
        if (H2 == null || H2.hasFocus()) {
            return false;
        }
        H2.requestFocus();
        return true;
    }

    public void S(ActionBar.Tab tab) {
        int i2 = -1;
        if (u() != 2) {
            if (tab != null) {
                i2 = tab.d();
            }
            this.t = i2;
            return;
        }
        FragmentTransaction w2 = (!(this.f2838k instanceof FragmentActivity) || this.f2841n.H().isInEditMode()) ? null : ((FragmentActivity) this.f2838k).k0().u().w();
        TabImpl tabImpl = this.s;
        if (tabImpl != tab) {
            ScrollingTabContainerView scrollingTabContainerView = this.q;
            if (tab != null) {
                i2 = tab.d();
            }
            scrollingTabContainerView.setTabSelected(i2);
            TabImpl tabImpl2 = this.s;
            if (tabImpl2 != null) {
                tabImpl2.r().C(this.s, w2);
            }
            TabImpl tabImpl3 = (TabImpl) tab;
            this.s = tabImpl3;
            if (tabImpl3 != null) {
                tabImpl3.r().s(this.s, w2);
            }
        } else if (tabImpl != null) {
            tabImpl.r().I(this.s, w2);
            this.q.c(tab.d());
        }
        if (w2 != null && !w2.A()) {
            w2.q();
        }
    }

    public void T(Drawable drawable) {
        this.f2840m.setPrimaryBackground(drawable);
    }

    public void U(int i2) {
        V(LayoutInflater.from(A()).inflate(i2, this.f2841n.H(), false));
    }

    public void V(View view) {
        this.f2841n.P(view);
    }

    public void W(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.f2841n.P(view);
    }

    public void X(boolean z2) {
        if (!this.u) {
            Y(z2);
        }
    }

    public void Y(boolean z2) {
        a0(z2 ? 4 : 0, 4);
    }

    public void Z(int i2) {
        if ((i2 & 4) != 0) {
            this.u = true;
        }
        this.f2841n.t(i2);
    }

    public void a() {
        if (this.E) {
            this.E = false;
            U0(true);
        }
    }

    public void a0(int i2, int i3) {
        int M2 = this.f2841n.M();
        if ((i3 & 4) != 0) {
            this.u = true;
        }
        this.f2841n.t((i2 & i3) | ((~i3) & M2));
    }

    public void b() {
    }

    public void b0(boolean z2) {
        a0(z2 ? 16 : 0, 16);
    }

    public void c(boolean z2) {
        this.C = z2;
    }

    public void c0(boolean z2) {
        a0(z2 ? 2 : 0, 2);
    }

    public void d() {
        if (!this.E) {
            this.E = true;
            U0(true);
        }
    }

    public void d0(boolean z2) {
        a0(z2 ? 8 : 0, 8);
    }

    public void e() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.H;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
            this.H = null;
        }
    }

    public void e0(boolean z2) {
        a0(z2 ? 1 : 0, 1);
    }

    public void f(int i2) {
        this.B = i2;
    }

    public void f0(float f2) {
        ViewCompat.V1(this.f2840m, f2);
    }

    public void g(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.z.add(onMenuVisibilityListener);
    }

    public void g0(int i2) {
        if (i2 == 0 || this.f2839l.C()) {
            this.f2839l.setActionBarHideOffset(i2);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
    }

    public void h(ActionBar.Tab tab) {
        k(tab, this.r.isEmpty());
    }

    public void h0(boolean z2) {
        if (!z2 || this.f2839l.C()) {
            this.J = z2;
            this.f2839l.setHideOnContentScrollEnabled(z2);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void i(ActionBar.Tab tab, int i2) {
        j(tab, i2, this.r.isEmpty());
    }

    public void i0(int i2) {
        this.f2841n.O(i2);
    }

    public void j(ActionBar.Tab tab, int i2, boolean z2) {
        L0();
        this.q.a(tab, i2, z2);
        I0(tab, i2);
        if (z2) {
            S(tab);
        }
    }

    public void j0(CharSequence charSequence) {
        this.f2841n.u(charSequence);
    }

    public void k(ActionBar.Tab tab, boolean z2) {
        L0();
        this.q.b(tab, z2);
        I0(tab, this.r.size());
        if (z2) {
            S(tab);
        }
    }

    public void k0(int i2) {
        this.f2841n.F(i2);
    }

    public void l0(Drawable drawable) {
        this.f2841n.T(drawable);
    }

    public boolean m() {
        DecorToolbar decorToolbar = this.f2841n;
        if (decorToolbar == null || !decorToolbar.r()) {
            return false;
        }
        this.f2841n.collapseActionView();
        return true;
    }

    public void m0(boolean z2) {
        this.f2841n.I(z2);
    }

    public void n(boolean z2) {
        if (z2 != this.y) {
            this.y = z2;
            int size = this.z.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.z.get(i2).a(z2);
            }
        }
    }

    public void n0(int i2) {
        this.f2841n.setIcon(i2);
    }

    public View o() {
        return this.f2841n.o();
    }

    public void o0(Drawable drawable) {
        this.f2841n.setIcon(drawable);
    }

    public int p() {
        return this.f2841n.M();
    }

    public void p0(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.f2841n.J(spinnerAdapter, new NavItemSelectedListener(onNavigationListener));
    }

    public float q() {
        return ViewCompat.T(this.f2840m);
    }

    public void q0(int i2) {
        this.f2841n.setLogo(i2);
    }

    public int r() {
        return this.f2840m.getHeight();
    }

    public void r0(Drawable drawable) {
        this.f2841n.q(drawable);
    }

    public int s() {
        return this.f2839l.getActionBarHideOffset();
    }

    public void s0(int i2) {
        ActionBarOverlayLayout actionBarOverlayLayout;
        int B2 = this.f2841n.B();
        if (B2 == 2) {
            this.t = v();
            S((ActionBar.Tab) null);
            this.q.setVisibility(8);
        }
        if (!(B2 == i2 || this.A || (actionBarOverlayLayout = this.f2839l) == null)) {
            ViewCompat.B1(actionBarOverlayLayout);
        }
        this.f2841n.E(i2);
        boolean z2 = false;
        if (i2 == 2) {
            L0();
            this.q.setVisibility(0);
            int i3 = this.t;
            if (i3 != -1) {
                t0(i3);
                this.t = -1;
            }
        }
        this.f2841n.U(i2 == 2 && !this.A);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f2839l;
        if (i2 == 2 && !this.A) {
            z2 = true;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z2);
    }

    public int t() {
        int B2 = this.f2841n.B();
        if (B2 == 1) {
            return this.f2841n.R();
        }
        if (B2 != 2) {
            return 0;
        }
        return this.r.size();
    }

    public void t0(int i2) {
        int B2 = this.f2841n.B();
        if (B2 == 1) {
            this.f2841n.y(i2);
        } else if (B2 == 2) {
            S(this.r.get(i2));
        } else {
            throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    public int u() {
        return this.f2841n.B();
    }

    public void u0(boolean z2) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.I = z2;
        if (!z2 && (viewPropertyAnimatorCompatSet = this.H) != null) {
            viewPropertyAnimatorCompatSet.a();
        }
    }

    public int v() {
        TabImpl tabImpl;
        int B2 = this.f2841n.B();
        if (B2 == 1) {
            return this.f2841n.N();
        }
        if (B2 == 2 && (tabImpl = this.s) != null) {
            return tabImpl.d();
        }
        return -1;
    }

    public void v0(Drawable drawable) {
    }

    public ActionBar.Tab w() {
        return this.s;
    }

    public void w0(Drawable drawable) {
        this.f2840m.setStackedBackground(drawable);
    }

    public CharSequence x() {
        return this.f2841n.L();
    }

    public void x0(int i2) {
        y0(this.f2836i.getString(i2));
    }

    public ActionBar.Tab y(int i2) {
        return this.r.get(i2);
    }

    public void y0(CharSequence charSequence) {
        this.f2841n.v(charSequence);
    }

    public int z() {
        return this.r.size();
    }

    public void z0(int i2) {
        A0(this.f2836i.getString(i2));
    }

    public WindowDecorActionBar(Dialog dialog) {
        Q0(dialog.getWindow().getDecorView());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public WindowDecorActionBar(View view) {
        Q0(view);
    }
}
