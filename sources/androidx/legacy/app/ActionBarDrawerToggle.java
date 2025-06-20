package androidx.legacy.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import java.lang.reflect.Method;

@Deprecated
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {

    /* renamed from: m  reason: collision with root package name */
    private static final String f8070m = "ActionBarDrawerToggle";

    /* renamed from: n  reason: collision with root package name */
    private static final int[] f8071n = {16843531};
    private static final float o = 0.33333334f;
    private static final int p = 16908332;

    /* renamed from: a  reason: collision with root package name */
    final Activity f8072a;

    /* renamed from: b  reason: collision with root package name */
    private final Delegate f8073b;

    /* renamed from: c  reason: collision with root package name */
    private final DrawerLayout f8074c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8075d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8076e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f8077f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f8078g;

    /* renamed from: h  reason: collision with root package name */
    private SlideDrawable f8079h;

    /* renamed from: i  reason: collision with root package name */
    private final int f8080i;

    /* renamed from: j  reason: collision with root package name */
    private final int f8081j;

    /* renamed from: k  reason: collision with root package name */
    private final int f8082k;

    /* renamed from: l  reason: collision with root package name */
    private SetIndicatorInfo f8083l;

    @Deprecated
    public interface Delegate {
        void a(Drawable drawable, @StringRes int i2);

        @Nullable
        Drawable b();

        void c(@StringRes int i2);
    }

    @Deprecated
    public interface DelegateProvider {
        @Nullable
        Delegate b();
    }

    private static class SetIndicatorInfo {

        /* renamed from: a  reason: collision with root package name */
        Method f8084a;

        /* renamed from: b  reason: collision with root package name */
        Method f8085b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f8086c;

        SetIndicatorInfo(Activity activity) {
            Class<ActionBar> cls = ActionBar.class;
            try {
                this.f8084a = cls.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});
                this.f8085b = cls.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});
            } catch (NoSuchMethodException unused) {
                View findViewById = activity.findViewById(ActionBarDrawerToggle.p);
                if (findViewById != null) {
                    ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                    if (viewGroup.getChildCount() == 2) {
                        View childAt = viewGroup.getChildAt(0);
                        childAt = childAt.getId() == ActionBarDrawerToggle.p ? viewGroup.getChildAt(1) : childAt;
                        if (childAt instanceof ImageView) {
                            this.f8086c = (ImageView) childAt;
                        }
                    }
                }
            }
        }
    }

    private class SlideDrawable extends InsetDrawable implements Drawable.Callback {
        private final Rect X = new Rect();
        private float Y;
        private float Z;
        private final boolean s = true;

        SlideDrawable(Drawable drawable) {
            super(drawable, 0);
        }

        public float a() {
            return this.Y;
        }

        public void b(float f2) {
            this.Z = f2;
            invalidateSelf();
        }

        public void c(float f2) {
            this.Y = f2;
            invalidateSelf();
        }

        public void draw(@NonNull Canvas canvas) {
            copyBounds(this.X);
            canvas.save();
            int i2 = 1;
            boolean z = ViewCompat.c0(ActionBarDrawerToggle.this.f8072a.getWindow().getDecorView()) == 1;
            if (z) {
                i2 = -1;
            }
            float width = (float) this.X.width();
            canvas.translate((-this.Z) * width * this.Y * ((float) i2), 0.0f);
            if (z && !this.s) {
                canvas.translate(width, 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            super.draw(canvas);
            canvas.restore();
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, @DrawableRes int i2, @StringRes int i3, @StringRes int i4) {
        this(activity, drawerLayout, !e(activity), i2, i3, i4);
    }

    private static boolean e(Context context) {
        return context.getApplicationInfo().targetSdkVersion >= 21;
    }

    private Drawable f() {
        Delegate delegate = this.f8073b;
        if (delegate != null) {
            return delegate.b();
        }
        ActionBar actionBar = this.f8072a.getActionBar();
        TypedArray obtainStyledAttributes = (actionBar != null ? actionBar.getThemedContext() : this.f8072a).obtainStyledAttributes((AttributeSet) null, f8071n, 16843470, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    private void j(int i2) {
        Delegate delegate = this.f8073b;
        if (delegate != null) {
            delegate.c(i2);
            return;
        }
        ActionBar actionBar = this.f8072a.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(i2);
        }
    }

    private void k(Drawable drawable, int i2) {
        Delegate delegate = this.f8073b;
        if (delegate != null) {
            delegate.a(drawable, i2);
            return;
        }
        ActionBar actionBar = this.f8072a.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(drawable);
            actionBar.setHomeActionContentDescription(i2);
        }
    }

    public void a(View view) {
        this.f8079h.c(1.0f);
        if (this.f8075d) {
            j(this.f8082k);
        }
    }

    public void b(View view) {
        this.f8079h.c(0.0f);
        if (this.f8075d) {
            j(this.f8081j);
        }
    }

    public void c(int i2) {
    }

    public void d(View view, float f2) {
        float a2 = this.f8079h.a();
        this.f8079h.c(f2 > 0.5f ? Math.max(a2, Math.max(0.0f, f2 - 0.5f) * 2.0f) : Math.min(a2, f2 * 2.0f));
    }

    public boolean g() {
        return this.f8075d;
    }

    public void h(Configuration configuration) {
        if (!this.f8076e) {
            this.f8077f = f();
        }
        this.f8078g = ContextCompat.l(this.f8072a, this.f8080i);
        o();
    }

    public boolean i(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != p || !this.f8075d) {
            return false;
        }
        if (this.f8074c.F(GravityCompat.f6387b)) {
            this.f8074c.d(GravityCompat.f6387b);
            return true;
        }
        this.f8074c.K(GravityCompat.f6387b);
        return true;
    }

    public void l(boolean z) {
        Drawable drawable;
        int i2;
        if (z != this.f8075d) {
            if (z) {
                drawable = this.f8079h;
                i2 = this.f8074c.C(GravityCompat.f6387b) ? this.f8082k : this.f8081j;
            } else {
                drawable = this.f8077f;
                i2 = 0;
            }
            k(drawable, i2);
            this.f8075d = z;
        }
    }

    public void m(int i2) {
        n(i2 != 0 ? ContextCompat.l(this.f8072a, i2) : null);
    }

    public void n(Drawable drawable) {
        if (drawable == null) {
            this.f8077f = f();
            this.f8076e = false;
        } else {
            this.f8077f = drawable;
            this.f8076e = true;
        }
        if (!this.f8075d) {
            k(this.f8077f, 0);
        }
    }

    public void o() {
        SlideDrawable slideDrawable;
        float f2;
        if (this.f8074c.C(GravityCompat.f6387b)) {
            slideDrawable = this.f8079h;
            f2 = 1.0f;
        } else {
            slideDrawable = this.f8079h;
            f2 = 0.0f;
        }
        slideDrawable.c(f2);
        if (this.f8075d) {
            k(this.f8079h, this.f8074c.C(GravityCompat.f6387b) ? this.f8082k : this.f8081j);
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, boolean z, @DrawableRes int i2, @StringRes int i3, @StringRes int i4) {
        this.f8075d = true;
        this.f8072a = activity;
        this.f8073b = activity instanceof DelegateProvider ? ((DelegateProvider) activity).b() : null;
        this.f8074c = drawerLayout;
        this.f8080i = i2;
        this.f8081j = i3;
        this.f8082k = i4;
        this.f8077f = f();
        this.f8078g = ContextCompat.l(activity, i2);
        SlideDrawable slideDrawable = new SlideDrawable(this.f8078g);
        this.f8079h = slideDrawable;
        slideDrawable.b(z ? o : 0.0f);
    }
}
