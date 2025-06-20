package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class MenuItemImpl implements SupportMenuItem {
    private static final String Q = "MenuItemImpl";
    private static final int R = 3;
    private static final int S = 1;
    private static final int T = 2;
    private static final int U = 4;
    private static final int V = 8;
    private static final int W = 16;
    private static final int X = 32;
    static final int Y = 0;
    private Runnable A;
    private MenuItem.OnMenuItemClickListener B;
    private CharSequence C;
    private CharSequence D;
    private ColorStateList E = null;
    private PorterDuff.Mode F = null;
    private boolean G = false;
    private boolean H = false;
    private boolean I = false;
    private int J = 16;
    private int K;
    private View L;
    private ActionProvider M;
    private MenuItem.OnActionExpandListener N;
    private boolean O = false;
    private ContextMenu.ContextMenuInfo P;

    /* renamed from: l  reason: collision with root package name */
    private final int f2967l;

    /* renamed from: m  reason: collision with root package name */
    private final int f2968m;

    /* renamed from: n  reason: collision with root package name */
    private final int f2969n;
    private final int o;
    private CharSequence p;
    private CharSequence q;
    private Intent r;
    private char s;
    private int t = 4096;
    private char u;
    private int v = 4096;
    private Drawable w;
    private int x = 0;
    MenuBuilder y;
    private SubMenuBuilder z;

    MenuItemImpl(MenuBuilder menuBuilder, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.y = menuBuilder;
        this.f2967l = i3;
        this.f2968m = i2;
        this.f2969n = i4;
        this.o = i5;
        this.p = charSequence;
        this.K = i6;
    }

    private static void f(StringBuilder sb, int i2, int i3, String str) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    private Drawable g(Drawable drawable) {
        if (drawable != null && this.I && (this.G || this.H)) {
            drawable = DrawableCompat.r(drawable).mutate();
            if (this.G) {
                DrawableCompat.o(drawable, this.E);
            }
            if (this.H) {
                DrawableCompat.p(drawable, this.F);
            }
            this.I = false;
        }
        return drawable;
    }

    public void A(SubMenuBuilder subMenuBuilder) {
        this.z = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    /* access modifiers changed from: package-private */
    public boolean B(boolean z2) {
        int i2 = this.J;
        int i3 = (z2 ? 0 : 8) | (i2 & -9);
        this.J = i3;
        return i2 != i3;
    }

    public boolean C() {
        return this.y.D();
    }

    /* access modifiers changed from: package-private */
    public boolean D() {
        return this.y.L() && j() != 0;
    }

    public boolean E() {
        return (this.K & 4) == 4;
    }

    @NonNull
    public SupportMenuItem a(ActionProvider actionProvider) {
        ActionProvider actionProvider2 = this.M;
        if (actionProvider2 != null) {
            actionProvider2.j();
        }
        this.L = null;
        this.M = actionProvider;
        this.y.O(true);
        ActionProvider actionProvider3 = this.M;
        if (actionProvider3 != null) {
            actionProvider3.l(new ActionProvider.VisibilityListener() {
                public void onActionProviderVisibilityChanged(boolean z) {
                    MenuItemImpl menuItemImpl = MenuItemImpl.this;
                    menuItemImpl.y.N(menuItemImpl);
                }
            });
        }
        return this;
    }

    public ActionProvider b() {
        return this.M;
    }

    public boolean c() {
        return !d() && !q();
    }

    public boolean collapseActionView() {
        if ((this.K & 8) == 0) {
            return false;
        }
        if (this.L == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.N;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.y.g(this);
        }
        return false;
    }

    public boolean d() {
        return (this.K & 2) == 2;
    }

    public void e() {
        this.y.M(this);
    }

    public boolean expandActionView() {
        if (!m()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.N;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.y.n(this);
        }
        return false;
    }

    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        View view = this.L;
        if (view != null) {
            return view;
        }
        ActionProvider actionProvider = this.M;
        if (actionProvider == null) {
            return null;
        }
        View e2 = actionProvider.e(this);
        this.L = e2;
        return e2;
    }

    public int getAlphabeticModifiers() {
        return this.v;
    }

    public char getAlphabeticShortcut() {
        return this.u;
    }

    public CharSequence getContentDescription() {
        return this.C;
    }

    public int getGroupId() {
        return this.f2968m;
    }

    public Drawable getIcon() {
        Drawable drawable = this.w;
        if (drawable != null) {
            return g(drawable);
        }
        if (this.x == 0) {
            return null;
        }
        Drawable b2 = AppCompatResources.b(this.y.x(), this.x);
        this.x = 0;
        this.w = b2;
        return g(b2);
    }

    public ColorStateList getIconTintList() {
        return this.E;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.F;
    }

    public Intent getIntent() {
        return this.r;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f2967l;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.P;
    }

    public int getNumericModifiers() {
        return this.t;
    }

    public char getNumericShortcut() {
        return this.s;
    }

    public int getOrder() {
        return this.f2969n;
    }

    public SubMenu getSubMenu() {
        return this.z;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.p;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.q;
        return charSequence != null ? charSequence : this.p;
    }

    public CharSequence getTooltipText() {
        return this.D;
    }

    /* access modifiers changed from: package-private */
    public Runnable h() {
        return this.A;
    }

    public boolean hasSubMenu() {
        return this.z != null;
    }

    public int i() {
        return this.o;
    }

    public boolean isActionViewExpanded() {
        return this.O;
    }

    public boolean isCheckable() {
        return (this.J & 1) == 1;
    }

    public boolean isChecked() {
        return (this.J & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.J & 16) != 0;
    }

    public boolean isVisible() {
        ActionProvider actionProvider = this.M;
        return (actionProvider == null || !actionProvider.h()) ? (this.J & 8) == 0 : (this.J & 8) == 0 && this.M.c();
    }

    /* access modifiers changed from: package-private */
    public char j() {
        return this.y.K() ? this.u : this.s;
    }

    /* access modifiers changed from: package-private */
    public String k() {
        int i2;
        char j2 = j();
        if (j2 == 0) {
            return "";
        }
        Resources resources = this.y.x().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.y.x()).hasPermanentMenuKey()) {
            sb.append(resources.getString(R.string.r));
        }
        int i3 = this.y.K() ? this.v : this.t;
        f(sb, i3, 65536, resources.getString(R.string.f2661n));
        f(sb, i3, 4096, resources.getString(R.string.f2657j));
        f(sb, i3, 2, resources.getString(R.string.f2656i));
        f(sb, i3, 1, resources.getString(R.string.o));
        f(sb, i3, 4, resources.getString(R.string.q));
        f(sb, i3, 8, resources.getString(R.string.f2660m));
        if (j2 == 8) {
            i2 = R.string.f2658k;
        } else if (j2 == 10) {
            i2 = R.string.f2659l;
        } else if (j2 != ' ') {
            sb.append(j2);
            return sb.toString();
        } else {
            i2 = R.string.p;
        }
        sb.append(resources.getString(i2));
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public CharSequence l(MenuView.ItemView itemView) {
        return (itemView == null || !itemView.f()) ? getTitle() : getTitleCondensed();
    }

    public boolean m() {
        ActionProvider actionProvider;
        if ((this.K & 8) == 0) {
            return false;
        }
        if (this.L == null && (actionProvider = this.M) != null) {
            this.L = actionProvider.e(this);
        }
        return this.L != null;
    }

    public boolean n() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.B;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        MenuBuilder menuBuilder = this.y;
        if (menuBuilder.i(menuBuilder, this)) {
            return true;
        }
        Runnable runnable = this.A;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.r != null) {
            try {
                this.y.x().startActivity(this.r);
                return true;
            } catch (ActivityNotFoundException e2) {
                Log.e(Q, "Can't find activity to handle intent; ignoring", e2);
            }
        }
        ActionProvider actionProvider = this.M;
        return actionProvider != null && actionProvider.f();
    }

    public boolean o() {
        return (this.J & 32) == 32;
    }

    public boolean p() {
        return (this.J & 4) != 0;
    }

    public boolean q() {
        return (this.K & 1) == 1;
    }

    @NonNull
    /* renamed from: r */
    public SupportMenuItem setActionView(int i2) {
        Context x2 = this.y.x();
        setActionView(LayoutInflater.from(x2).inflate(i2, new LinearLayout(x2), false));
        return this;
    }

    @NonNull
    /* renamed from: s */
    public SupportMenuItem setActionView(View view) {
        int i2;
        this.L = view;
        this.M = null;
        if (view != null && view.getId() == -1 && (i2 = this.f2967l) > 0) {
            view.setId(i2);
        }
        this.y.M(this);
        return this;
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.u == c2) {
            return this;
        }
        this.u = Character.toLowerCase(c2);
        this.y.O(false);
        return this;
    }

    public MenuItem setCheckable(boolean z2) {
        int i2 = this.J;
        boolean z3 = z2 | (i2 & true);
        this.J = z3 ? 1 : 0;
        if (i2 != z3) {
            this.y.O(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z2) {
        if ((this.J & 4) != 0) {
            this.y.b0(this);
        } else {
            v(z2);
        }
        return this;
    }

    public MenuItem setEnabled(boolean z2) {
        this.J = z2 ? this.J | 16 : this.J & -17;
        this.y.O(false);
        return this;
    }

    public MenuItem setIcon(int i2) {
        this.w = null;
        this.x = i2;
        this.I = true;
        this.y.O(false);
        return this;
    }

    @NonNull
    public MenuItem setIconTintList(@Nullable ColorStateList colorStateList) {
        this.E = colorStateList;
        this.G = true;
        this.I = true;
        this.y.O(false);
        return this;
    }

    @NonNull
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.F = mode;
        this.H = true;
        this.I = true;
        this.y.O(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.r = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        if (this.s == c2) {
            return this;
        }
        this.s = c2;
        this.y.O(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.N = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.B = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.s = c2;
        this.u = Character.toLowerCase(c3);
        this.y.O(false);
        return this;
    }

    public void setShowAsAction(int i2) {
        int i3 = i2 & 3;
        if (i3 == 0 || i3 == 1 || i3 == 2) {
            this.K = i2;
            this.y.M(this);
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    public MenuItem setTitle(int i2) {
        return setTitle((CharSequence) this.y.x().getString(i2));
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.q = charSequence;
        this.y.O(false);
        return this;
    }

    public MenuItem setVisible(boolean z2) {
        if (B(z2)) {
            this.y.N(this);
        }
        return this;
    }

    public void t(boolean z2) {
        this.O = z2;
        this.y.O(false);
    }

    public String toString() {
        CharSequence charSequence = this.p;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public MenuItem u(Runnable runnable) {
        this.A = runnable;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void v(boolean z2) {
        int i2 = this.J;
        int i3 = (z2 ? 2 : 0) | (i2 & -3);
        this.J = i3;
        if (i2 != i3) {
            this.y.O(false);
        }
    }

    public void w(boolean z2) {
        this.J = (z2 ? 4 : 0) | (this.J & -5);
    }

    public void x(boolean z2) {
        this.J = z2 ? this.J | 32 : this.J & -33;
    }

    /* access modifiers changed from: package-private */
    public void y(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.P = contextMenuInfo;
    }

    @NonNull
    /* renamed from: z */
    public SupportMenuItem setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    @NonNull
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        if (this.u == c2 && this.v == i2) {
            return this;
        }
        this.u = Character.toLowerCase(c2);
        this.v = KeyEvent.normalizeMetaState(i2);
        this.y.O(false);
        return this;
    }

    @NonNull
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.C = charSequence;
        this.y.O(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.x = 0;
        this.w = drawable;
        this.I = true;
        this.y.O(false);
        return this;
    }

    @NonNull
    public MenuItem setNumericShortcut(char c2, int i2) {
        if (this.s == c2 && this.t == i2) {
            return this;
        }
        this.s = c2;
        this.t = KeyEvent.normalizeMetaState(i2);
        this.y.O(false);
        return this;
    }

    @NonNull
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.s = c2;
        this.t = KeyEvent.normalizeMetaState(i2);
        this.u = Character.toLowerCase(c3);
        this.v = KeyEvent.normalizeMetaState(i3);
        this.y.O(false);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.p = charSequence;
        this.y.O(false);
        SubMenuBuilder subMenuBuilder = this.z;
        if (subMenuBuilder != null) {
            subMenuBuilder.setHeaderTitle(charSequence);
        }
        return this;
    }

    @NonNull
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.D = charSequence;
        this.y.O(false);
        return this;
    }
}
