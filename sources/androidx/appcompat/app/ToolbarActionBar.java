package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

class ToolbarActionBar extends ActionBar {

    /* renamed from: i  reason: collision with root package name */
    final DecorToolbar f2805i;

    /* renamed from: j  reason: collision with root package name */
    final Window.Callback f2806j;

    /* renamed from: k  reason: collision with root package name */
    final AppCompatDelegateImpl.ActionBarMenuCallback f2807k;

    /* renamed from: l  reason: collision with root package name */
    boolean f2808l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f2809m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f2810n;
    private ArrayList<ActionBar.OnMenuVisibilityListener> o = new ArrayList<>();
    private final Runnable p = new Runnable() {
        public void run() {
            ToolbarActionBar.this.F0();
        }
    };
    private final Toolbar.OnMenuItemClickListener q;

    private final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        private boolean s;

        ActionMenuPresenterCallback() {
        }

        public void c(@NonNull MenuBuilder menuBuilder, boolean z) {
            if (!this.s) {
                this.s = true;
                ToolbarActionBar.this.f2805i.n();
                ToolbarActionBar.this.f2806j.onPanelClosed(108, menuBuilder);
                this.s = false;
            }
        }

        public boolean d(@NonNull MenuBuilder menuBuilder) {
            ToolbarActionBar.this.f2806j.onMenuOpened(108, menuBuilder);
            return true;
        }
    }

    private final class MenuBuilderCallback implements MenuBuilder.Callback {
        MenuBuilderCallback() {
        }

        public boolean a(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            return false;
        }

        public void b(@NonNull MenuBuilder menuBuilder) {
            if (ToolbarActionBar.this.f2805i.d()) {
                ToolbarActionBar.this.f2806j.onPanelClosed(108, menuBuilder);
            } else if (ToolbarActionBar.this.f2806j.onPreparePanel(0, (View) null, menuBuilder)) {
                ToolbarActionBar.this.f2806j.onMenuOpened(108, menuBuilder);
            }
        }
    }

    private class ToolbarMenuCallback implements AppCompatDelegateImpl.ActionBarMenuCallback {
        ToolbarMenuCallback() {
        }

        public boolean a(int i2) {
            if (i2 != 0) {
                return false;
            }
            ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
            if (toolbarActionBar.f2808l) {
                return false;
            }
            toolbarActionBar.f2805i.e();
            ToolbarActionBar.this.f2808l = true;
            return false;
        }

        public View onCreatePanelView(int i2) {
            if (i2 == 0) {
                return new View(ToolbarActionBar.this.f2805i.g());
            }
            return null;
        }
    }

    ToolbarActionBar(@NonNull Toolbar toolbar, @Nullable CharSequence charSequence, @NonNull Window.Callback callback) {
        AnonymousClass2 r0 = new Toolbar.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                return ToolbarActionBar.this.f2806j.onMenuItemSelected(0, menuItem);
            }
        };
        this.q = r0;
        Preconditions.l(toolbar);
        ToolbarWidgetWrapper toolbarWidgetWrapper = new ToolbarWidgetWrapper(toolbar, false);
        this.f2805i = toolbarWidgetWrapper;
        this.f2806j = (Window.Callback) Preconditions.l(callback);
        toolbarWidgetWrapper.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(r0);
        toolbarWidgetWrapper.setWindowTitle(charSequence);
        this.f2807k = new ToolbarMenuCallback();
    }

    private Menu E0() {
        if (!this.f2809m) {
            this.f2805i.G(new ActionMenuPresenterCallback(), new MenuBuilderCallback());
            this.f2809m = true;
        }
        return this.f2805i.z();
    }

    public Context A() {
        return this.f2805i.g();
    }

    public void A0(CharSequence charSequence) {
        this.f2805i.setTitle(charSequence);
    }

    public CharSequence B() {
        return this.f2805i.getTitle();
    }

    public void B0(CharSequence charSequence) {
        this.f2805i.setWindowTitle(charSequence);
    }

    public void C() {
        this.f2805i.setVisibility(8);
    }

    public void C0() {
        this.f2805i.setVisibility(0);
    }

    public boolean D() {
        this.f2805i.H().removeCallbacks(this.p);
        ViewCompat.v1(this.f2805i.H(), this.p);
        return true;
    }

    public boolean F() {
        return this.f2805i.b() == 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void F0() {
        /*
            r5 = this;
            android.view.Menu r0 = r5.E0()
            boolean r1 = r0 instanceof androidx.appcompat.view.menu.MenuBuilder
            r2 = 0
            if (r1 == 0) goto L_0x000d
            r1 = r0
            androidx.appcompat.view.menu.MenuBuilder r1 = (androidx.appcompat.view.menu.MenuBuilder) r1
            goto L_0x000e
        L_0x000d:
            r1 = r2
        L_0x000e:
            if (r1 == 0) goto L_0x0013
            r1.n0()
        L_0x0013:
            r0.clear()     // Catch:{ all -> 0x0028 }
            android.view.Window$Callback r3 = r5.f2806j     // Catch:{ all -> 0x0028 }
            r4 = 0
            boolean r3 = r3.onCreatePanelMenu(r4, r0)     // Catch:{ all -> 0x0028 }
            if (r3 == 0) goto L_0x002a
            android.view.Window$Callback r3 = r5.f2806j     // Catch:{ all -> 0x0028 }
            boolean r2 = r3.onPreparePanel(r4, r2, r0)     // Catch:{ all -> 0x0028 }
            if (r2 != 0) goto L_0x002d
            goto L_0x002a
        L_0x0028:
            r0 = move-exception
            goto L_0x0033
        L_0x002a:
            r0.clear()     // Catch:{ all -> 0x0028 }
        L_0x002d:
            if (r1 == 0) goto L_0x0032
            r1.m0()
        L_0x0032:
            return
        L_0x0033:
            if (r1 == 0) goto L_0x0038
            r1.m0()
        L_0x0038:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.ToolbarActionBar.F0():void");
    }

    public boolean G() {
        return super.G();
    }

    public ActionBar.Tab H() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void I(Configuration configuration) {
        super.I(configuration);
    }

    /* access modifiers changed from: package-private */
    public void J() {
        this.f2805i.H().removeCallbacks(this.p);
    }

    public boolean K(int i2, KeyEvent keyEvent) {
        Menu E0 = E0();
        if (E0 == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        E0.setQwertyMode(z);
        return E0.performShortcut(i2, keyEvent, 0);
    }

    public boolean L(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            M();
        }
        return true;
    }

    public boolean M() {
        return this.f2805i.l();
    }

    public void N() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void O(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.o.remove(onMenuVisibilityListener);
    }

    public void P(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void Q(int i2) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public boolean R() {
        ViewGroup H = this.f2805i.H();
        if (H == null || H.hasFocus()) {
            return false;
        }
        H.requestFocus();
        return true;
    }

    public void S(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void T(@Nullable Drawable drawable) {
        this.f2805i.c(drawable);
    }

    public void U(int i2) {
        V(LayoutInflater.from(this.f2805i.g()).inflate(i2, this.f2805i.H(), false));
    }

    public void V(View view) {
        W(view, new ActionBar.LayoutParams(-2, -2));
    }

    public void W(View view, ActionBar.LayoutParams layoutParams) {
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.f2805i.P(view);
    }

    public void X(boolean z) {
    }

    public void Y(boolean z) {
        a0(z ? 4 : 0, 4);
    }

    @SuppressLint({"WrongConstant"})
    public void Z(int i2) {
        a0(i2, -1);
    }

    public void a0(int i2, int i3) {
        this.f2805i.t((i2 & i3) | ((~i3) & this.f2805i.M()));
    }

    public void b0(boolean z) {
        a0(z ? 16 : 0, 16);
    }

    public void c0(boolean z) {
        a0(z ? 2 : 0, 2);
    }

    public void d0(boolean z) {
        a0(z ? 8 : 0, 8);
    }

    public void e0(boolean z) {
        a0(z ? 1 : 0, 1);
    }

    public void f0(float f2) {
        ViewCompat.V1(this.f2805i.H(), f2);
    }

    public void g(ActionBar.OnMenuVisibilityListener onMenuVisibilityListener) {
        this.o.add(onMenuVisibilityListener);
    }

    public void h(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void i(ActionBar.Tab tab, int i2) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void i0(int i2) {
        this.f2805i.O(i2);
    }

    public void j(ActionBar.Tab tab, int i2, boolean z) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void j0(CharSequence charSequence) {
        this.f2805i.u(charSequence);
    }

    public void k(ActionBar.Tab tab, boolean z) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void k0(int i2) {
        this.f2805i.F(i2);
    }

    public boolean l() {
        return this.f2805i.k();
    }

    public void l0(Drawable drawable) {
        this.f2805i.T(drawable);
    }

    public boolean m() {
        if (!this.f2805i.r()) {
            return false;
        }
        this.f2805i.collapseActionView();
        return true;
    }

    public void m0(boolean z) {
    }

    public void n(boolean z) {
        if (z != this.f2810n) {
            this.f2810n = z;
            int size = this.o.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.o.get(i2).a(z);
            }
        }
    }

    public void n0(int i2) {
        this.f2805i.setIcon(i2);
    }

    public View o() {
        return this.f2805i.o();
    }

    public void o0(Drawable drawable) {
        this.f2805i.setIcon(drawable);
    }

    public int p() {
        return this.f2805i.M();
    }

    public void p0(SpinnerAdapter spinnerAdapter, ActionBar.OnNavigationListener onNavigationListener) {
        this.f2805i.J(spinnerAdapter, new NavItemSelectedListener(onNavigationListener));
    }

    public float q() {
        return ViewCompat.T(this.f2805i.H());
    }

    public void q0(int i2) {
        this.f2805i.setLogo(i2);
    }

    public int r() {
        return this.f2805i.getHeight();
    }

    public void r0(Drawable drawable) {
        this.f2805i.q(drawable);
    }

    public void s0(int i2) {
        if (i2 != 2) {
            this.f2805i.E(i2);
            return;
        }
        throw new IllegalArgumentException("Tabs not supported in this configuration");
    }

    public int t() {
        return 0;
    }

    public void t0(int i2) {
        if (this.f2805i.B() == 1) {
            this.f2805i.y(i2);
            return;
        }
        throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    }

    public int u() {
        return 0;
    }

    public void u0(boolean z) {
    }

    public int v() {
        return -1;
    }

    public void v0(Drawable drawable) {
    }

    public ActionBar.Tab w() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void w0(Drawable drawable) {
    }

    public CharSequence x() {
        return this.f2805i.L();
    }

    public void x0(int i2) {
        DecorToolbar decorToolbar = this.f2805i;
        decorToolbar.v(i2 != 0 ? decorToolbar.g().getText(i2) : null);
    }

    public ActionBar.Tab y(int i2) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void y0(CharSequence charSequence) {
        this.f2805i.v(charSequence);
    }

    public int z() {
        return 0;
    }

    public void z0(int i2) {
        DecorToolbar decorToolbar = this.f2805i;
        decorToolbar.setTitle(i2 != 0 ? decorToolbar.g().getText(i2) : null);
    }
}
