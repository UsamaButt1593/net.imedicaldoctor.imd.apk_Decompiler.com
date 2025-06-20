package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionMenuItem implements SupportMenuItem {
    private static final int F = 1;
    private static final int G = 2;
    private static final int H = 4;
    private static final int I = 8;
    private static final int J = 16;
    private ColorStateList A = null;
    private PorterDuff.Mode B = null;
    private boolean C = false;
    private boolean D = false;
    private int E = 16;

    /* renamed from: l  reason: collision with root package name */
    private final int f2955l;

    /* renamed from: m  reason: collision with root package name */
    private final int f2956m;

    /* renamed from: n  reason: collision with root package name */
    private final int f2957n;
    private CharSequence o;
    private CharSequence p;
    private Intent q;
    private char r;
    private int s = 4096;
    private char t;
    private int u = 4096;
    private Drawable v;
    private Context w;
    private MenuItem.OnMenuItemClickListener x;
    private CharSequence y;
    private CharSequence z;

    public ActionMenuItem(Context context, int i2, int i3, int i4, int i5, CharSequence charSequence) {
        this.w = context;
        this.f2955l = i3;
        this.f2956m = i2;
        this.f2957n = i5;
        this.o = charSequence;
    }

    private void e() {
        Drawable drawable = this.v;
        if (drawable == null) {
            return;
        }
        if (this.C || this.D) {
            Drawable r2 = DrawableCompat.r(drawable);
            this.v = r2;
            Drawable mutate = r2.mutate();
            this.v = mutate;
            if (this.C) {
                DrawableCompat.o(mutate, this.A);
            }
            if (this.D) {
                DrawableCompat.p(this.v, this.B);
            }
        }
    }

    @NonNull
    public SupportMenuItem a(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public ActionProvider b() {
        return null;
    }

    public boolean c() {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean d() {
        return true;
    }

    public boolean expandActionView() {
        return false;
    }

    public boolean f() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.x;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        Intent intent = this.q;
        if (intent == null) {
            return false;
        }
        this.w.startActivity(intent);
        return true;
    }

    @NonNull
    /* renamed from: g */
    public SupportMenuItem setActionView(int i2) {
        throw new UnsupportedOperationException();
    }

    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public int getAlphabeticModifiers() {
        return this.u;
    }

    public char getAlphabeticShortcut() {
        return this.t;
    }

    public CharSequence getContentDescription() {
        return this.y;
    }

    public int getGroupId() {
        return this.f2956m;
    }

    public Drawable getIcon() {
        return this.v;
    }

    public ColorStateList getIconTintList() {
        return this.A;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.B;
    }

    public Intent getIntent() {
        return this.q;
    }

    public int getItemId() {
        return this.f2955l;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public int getNumericModifiers() {
        return this.s;
    }

    public char getNumericShortcut() {
        return this.r;
    }

    public int getOrder() {
        return this.f2957n;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.o;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.p;
        return charSequence != null ? charSequence : this.o;
    }

    public CharSequence getTooltipText() {
        return this.z;
    }

    @NonNull
    /* renamed from: h */
    public SupportMenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public boolean hasSubMenu() {
        return false;
    }

    public ActionMenuItem i(boolean z2) {
        this.E = (z2 ? 4 : 0) | (this.E & -5);
        return this;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.E & 1) != 0;
    }

    public boolean isChecked() {
        return (this.E & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.E & 16) != 0;
    }

    public boolean isVisible() {
        return (this.E & 8) == 0;
    }

    @NonNull
    /* renamed from: j */
    public SupportMenuItem setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.t = Character.toLowerCase(c2);
        return this;
    }

    public MenuItem setCheckable(boolean z2) {
        this.E = z2 | (this.E & true) ? 1 : 0;
        return this;
    }

    public MenuItem setChecked(boolean z2) {
        this.E = (z2 ? 2 : 0) | (this.E & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z2) {
        this.E = (z2 ? 16 : 0) | (this.E & -17);
        return this;
    }

    public MenuItem setIcon(int i2) {
        this.v = ContextCompat.l(this.w, i2);
        e();
        return this;
    }

    @NonNull
    public MenuItem setIconTintList(@Nullable ColorStateList colorStateList) {
        this.A = colorStateList;
        this.C = true;
        e();
        return this;
    }

    @NonNull
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.B = mode;
        this.D = true;
        e();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.q = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.r = c2;
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.x = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.r = c2;
        this.t = Character.toLowerCase(c3);
        return this;
    }

    public void setShowAsAction(int i2) {
    }

    public MenuItem setTitle(int i2) {
        this.o = this.w.getResources().getString(i2);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.p = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z2) {
        int i2 = 8;
        int i3 = this.E & 8;
        if (z2) {
            i2 = 0;
        }
        this.E = i3 | i2;
        return this;
    }

    @NonNull
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.t = Character.toLowerCase(c2);
        this.u = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @NonNull
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.y = charSequence;
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.v = drawable;
        e();
        return this;
    }

    @NonNull
    public MenuItem setNumericShortcut(char c2, int i2) {
        this.r = c2;
        this.s = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @NonNull
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.r = c2;
        this.s = KeyEvent.normalizeMetaState(i2);
        this.t = Character.toLowerCase(c3);
        this.u = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.o = charSequence;
        return this;
    }

    @NonNull
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.z = charSequence;
        return this;
    }
}
