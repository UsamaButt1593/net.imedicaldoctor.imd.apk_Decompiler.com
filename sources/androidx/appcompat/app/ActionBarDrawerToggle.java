package androidx.appcompat.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {

    /* renamed from: a  reason: collision with root package name */
    private final Delegate f2700a;

    /* renamed from: b  reason: collision with root package name */
    private final DrawerLayout f2701b;

    /* renamed from: c  reason: collision with root package name */
    private DrawerArrowDrawable f2702c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2703d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f2704e;

    /* renamed from: f  reason: collision with root package name */
    boolean f2705f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2706g;

    /* renamed from: h  reason: collision with root package name */
    private final int f2707h;

    /* renamed from: i  reason: collision with root package name */
    private final int f2708i;

    /* renamed from: j  reason: collision with root package name */
    View.OnClickListener f2709j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f2710k;

    public interface Delegate {
        void a(Drawable drawable, @StringRes int i2);

        Drawable b();

        void c(@StringRes int i2);

        boolean d();

        Context e();
    }

    public interface DelegateProvider {
        @Nullable
        Delegate b();
    }

    private static class FrameworkActionBarDelegate implements Delegate {

        /* renamed from: a  reason: collision with root package name */
        private final Activity f2711a;

        FrameworkActionBarDelegate(Activity activity) {
            this.f2711a = activity;
        }

        public void a(Drawable drawable, int i2) {
            ActionBar actionBar = this.f2711a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(drawable);
                actionBar.setHomeActionContentDescription(i2);
            }
        }

        public Drawable b() {
            TypedArray obtainStyledAttributes = e().obtainStyledAttributes((AttributeSet) null, new int[]{16843531}, 16843470, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        public void c(int i2) {
            ActionBar actionBar = this.f2711a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i2);
            }
        }

        public boolean d() {
            ActionBar actionBar = this.f2711a.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        public Context e() {
            ActionBar actionBar = this.f2711a.getActionBar();
            return actionBar != null ? actionBar.getThemedContext() : this.f2711a;
        }
    }

    static class ToolbarCompatDelegate implements Delegate {

        /* renamed from: a  reason: collision with root package name */
        final Toolbar f2712a;

        /* renamed from: b  reason: collision with root package name */
        final Drawable f2713b;

        /* renamed from: c  reason: collision with root package name */
        final CharSequence f2714c;

        ToolbarCompatDelegate(Toolbar toolbar) {
            this.f2712a = toolbar;
            this.f2713b = toolbar.getNavigationIcon();
            this.f2714c = toolbar.getNavigationContentDescription();
        }

        public void a(Drawable drawable, @StringRes int i2) {
            this.f2712a.setNavigationIcon(drawable);
            c(i2);
        }

        public Drawable b() {
            return this.f2713b;
        }

        public void c(@StringRes int i2) {
            if (i2 == 0) {
                this.f2712a.setNavigationContentDescription(this.f2714c);
            } else {
                this.f2712a.setNavigationContentDescription(i2);
            }
        }

        public boolean d() {
            return true;
        }

        public Context e() {
            return this.f2712a.getContext();
        }
    }

    ActionBarDrawerToggle(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, DrawerArrowDrawable drawerArrowDrawable, @StringRes int i2, @StringRes int i3) {
        this.f2703d = true;
        this.f2705f = true;
        this.f2710k = false;
        if (toolbar != null) {
            this.f2700a = new ToolbarCompatDelegate(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ActionBarDrawerToggle actionBarDrawerToggle = ActionBarDrawerToggle.this;
                    if (actionBarDrawerToggle.f2705f) {
                        actionBarDrawerToggle.v();
                        return;
                    }
                    View.OnClickListener onClickListener = actionBarDrawerToggle.f2709j;
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                }
            });
        } else if (activity instanceof DelegateProvider) {
            this.f2700a = ((DelegateProvider) activity).b();
        } else {
            this.f2700a = new FrameworkActionBarDelegate(activity);
        }
        this.f2701b = drawerLayout;
        this.f2707h = i2;
        this.f2708i = i3;
        if (drawerArrowDrawable == null) {
            this.f2702c = new DrawerArrowDrawable(this.f2700a.e());
        } else {
            this.f2702c = drawerArrowDrawable;
        }
        this.f2704e = f();
    }

    private void s(float f2) {
        DrawerArrowDrawable drawerArrowDrawable;
        boolean z;
        if (f2 == 1.0f) {
            drawerArrowDrawable = this.f2702c;
            z = true;
        } else {
            if (f2 == 0.0f) {
                drawerArrowDrawable = this.f2702c;
                z = false;
            }
            this.f2702c.s(f2);
        }
        drawerArrowDrawable.u(z);
        this.f2702c.s(f2);
    }

    public void a(View view) {
        s(1.0f);
        if (this.f2705f) {
            l(this.f2708i);
        }
    }

    public void b(View view) {
        s(0.0f);
        if (this.f2705f) {
            l(this.f2707h);
        }
    }

    public void c(int i2) {
    }

    public void d(View view, float f2) {
        if (this.f2703d) {
            s(Math.min(1.0f, Math.max(0.0f, f2)));
        } else {
            s(0.0f);
        }
    }

    @NonNull
    public DrawerArrowDrawable e() {
        return this.f2702c;
    }

    /* access modifiers changed from: package-private */
    public Drawable f() {
        return this.f2700a.b();
    }

    public View.OnClickListener g() {
        return this.f2709j;
    }

    public boolean h() {
        return this.f2705f;
    }

    public boolean i() {
        return this.f2703d;
    }

    public void j(Configuration configuration) {
        if (!this.f2706g) {
            this.f2704e = f();
        }
        u();
    }

    public boolean k(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.f2705f) {
            return false;
        }
        v();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void l(int i2) {
        this.f2700a.c(i2);
    }

    /* access modifiers changed from: package-private */
    public void m(Drawable drawable, int i2) {
        if (!this.f2710k && !this.f2700a.d()) {
            Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            this.f2710k = true;
        }
        this.f2700a.a(drawable, i2);
    }

    public void n(@NonNull DrawerArrowDrawable drawerArrowDrawable) {
        this.f2702c = drawerArrowDrawable;
        u();
    }

    public void o(boolean z) {
        Drawable drawable;
        int i2;
        if (z != this.f2705f) {
            if (z) {
                drawable = this.f2702c;
                i2 = this.f2701b.C(GravityCompat.f6387b) ? this.f2708i : this.f2707h;
            } else {
                drawable = this.f2704e;
                i2 = 0;
            }
            m(drawable, i2);
            this.f2705f = z;
        }
    }

    public void p(boolean z) {
        this.f2703d = z;
        if (!z) {
            s(0.0f);
        }
    }

    public void q(int i2) {
        r(i2 != 0 ? this.f2701b.getResources().getDrawable(i2) : null);
    }

    public void r(Drawable drawable) {
        if (drawable == null) {
            this.f2704e = f();
            this.f2706g = false;
        } else {
            this.f2704e = drawable;
            this.f2706g = true;
        }
        if (!this.f2705f) {
            m(this.f2704e, 0);
        }
    }

    public void t(View.OnClickListener onClickListener) {
        this.f2709j = onClickListener;
    }

    public void u() {
        s(this.f2701b.C(GravityCompat.f6387b) ? 1.0f : 0.0f);
        if (this.f2705f) {
            m(this.f2702c, this.f2701b.C(GravityCompat.f6387b) ? this.f2708i : this.f2707h);
        }
    }

    /* access modifiers changed from: package-private */
    public void v() {
        int q = this.f2701b.q(GravityCompat.f6387b);
        if (this.f2701b.F(GravityCompat.f6387b) && q != 2) {
            this.f2701b.d(GravityCompat.f6387b);
        } else if (q != 1) {
            this.f2701b.K(GravityCompat.f6387b);
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, @StringRes int i2, @StringRes int i3) {
        this(activity, (Toolbar) null, drawerLayout, (DrawerArrowDrawable) null, i2, i3);
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, @StringRes int i2, @StringRes int i3) {
        this(activity, toolbar, drawerLayout, (DrawerArrowDrawable) null, i2, i3);
    }
}
