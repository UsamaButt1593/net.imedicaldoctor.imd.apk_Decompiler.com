package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import java.lang.reflect.Method;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuItemWrapperICS extends BaseMenuWrapper implements MenuItem {
    static final String q = "MenuItemWrapper";
    private final SupportMenuItem o;
    private Method p;

    private class ActionProviderWrapper extends ActionProvider implements ActionProvider.VisibilityListener {

        /* renamed from: e  reason: collision with root package name */
        private ActionProvider.VisibilityListener f2971e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final android.view.ActionProvider f2972f;

        ActionProviderWrapper(Context context, android.view.ActionProvider actionProvider) {
            super(context);
            this.f2972f = actionProvider;
        }

        public boolean b() {
            return this.f2972f.hasSubMenu();
        }

        public boolean c() {
            return this.f2972f.isVisible();
        }

        @NonNull
        public View d() {
            return this.f2972f.onCreateActionView();
        }

        public View e(MenuItem menuItem) {
            return this.f2972f.onCreateActionView(menuItem);
        }

        public boolean f() {
            return this.f2972f.onPerformDefaultAction();
        }

        public void g(SubMenu subMenu) {
            this.f2972f.onPrepareSubMenu(MenuItemWrapperICS.this.f(subMenu));
        }

        public boolean h() {
            return this.f2972f.overridesItemVisibility();
        }

        public void i() {
            this.f2972f.refreshVisibility();
        }

        public void l(ActionProvider.VisibilityListener visibilityListener) {
            this.f2971e = visibilityListener;
            this.f2972f.setVisibilityListener(visibilityListener != null ? this : null);
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            ActionProvider.VisibilityListener visibilityListener = this.f2971e;
            if (visibilityListener != null) {
                visibilityListener.onActionProviderVisibilityChanged(z);
            }
        }
    }

    static class CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView {
        final android.view.CollapsibleActionView s;

        CollapsibleActionViewWrapper(View view) {
            super(view.getContext());
            this.s = (android.view.CollapsibleActionView) view;
            addView(view);
        }

        /* access modifiers changed from: package-private */
        public View a() {
            return (View) this.s;
        }

        public void b() {
            this.s.onActionViewExpanded();
        }

        public void d() {
            this.s.onActionViewCollapsed();
        }
    }

    private class OnActionExpandListenerWrapper implements MenuItem.OnActionExpandListener {

        /* renamed from: a  reason: collision with root package name */
        private final MenuItem.OnActionExpandListener f2974a;

        OnActionExpandListenerWrapper(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f2974a = onActionExpandListener;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f2974a.onMenuItemActionCollapse(MenuItemWrapperICS.this.e(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f2974a.onMenuItemActionExpand(MenuItemWrapperICS.this.e(menuItem));
        }
    }

    private class OnMenuItemClickListenerWrapper implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        private final MenuItem.OnMenuItemClickListener f2976a;

        OnMenuItemClickListenerWrapper(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f2976a = onMenuItemClickListener;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f2976a.onMenuItemClick(MenuItemWrapperICS.this.e(menuItem));
        }
    }

    public MenuItemWrapperICS(Context context, SupportMenuItem supportMenuItem) {
        super(context);
        if (supportMenuItem != null) {
            this.o = supportMenuItem;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public boolean collapseActionView() {
        return this.o.collapseActionView();
    }

    public boolean expandActionView() {
        return this.o.expandActionView();
    }

    public android.view.ActionProvider getActionProvider() {
        androidx.core.view.ActionProvider b2 = this.o.b();
        if (b2 instanceof ActionProviderWrapper) {
            return ((ActionProviderWrapper) b2).f2972f;
        }
        return null;
    }

    public View getActionView() {
        View actionView = this.o.getActionView();
        return actionView instanceof CollapsibleActionViewWrapper ? ((CollapsibleActionViewWrapper) actionView).a() : actionView;
    }

    public int getAlphabeticModifiers() {
        return this.o.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.o.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.o.getContentDescription();
    }

    public int getGroupId() {
        return this.o.getGroupId();
    }

    public Drawable getIcon() {
        return this.o.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.o.getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.o.getIconTintMode();
    }

    public Intent getIntent() {
        return this.o.getIntent();
    }

    public int getItemId() {
        return this.o.getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.o.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.o.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.o.getNumericShortcut();
    }

    public int getOrder() {
        return this.o.getOrder();
    }

    public SubMenu getSubMenu() {
        return f(this.o.getSubMenu());
    }

    public CharSequence getTitle() {
        return this.o.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.o.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.o.getTooltipText();
    }

    public boolean hasSubMenu() {
        return this.o.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.o.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.o.isCheckable();
    }

    public boolean isChecked() {
        return this.o.isChecked();
    }

    public boolean isEnabled() {
        return this.o.isEnabled();
    }

    public boolean isVisible() {
        return this.o.isVisible();
    }

    public void j(boolean z) {
        try {
            if (this.p == null) {
                this.p = this.o.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.p.invoke(this.o, new Object[]{Boolean.valueOf(z)});
        } catch (Exception e2) {
            Log.w(q, "Error while calling setExclusiveCheckable", e2);
        }
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        ActionProviderWrapper actionProviderWrapper = new ActionProviderWrapper(this.f2958l, actionProvider);
        SupportMenuItem supportMenuItem = this.o;
        if (actionProvider == null) {
            actionProviderWrapper = null;
        }
        supportMenuItem.a(actionProviderWrapper);
        return this;
    }

    public MenuItem setActionView(int i2) {
        this.o.setActionView(i2);
        View actionView = this.o.getActionView();
        if (actionView instanceof android.view.CollapsibleActionView) {
            this.o.setActionView((View) new CollapsibleActionViewWrapper(actionView));
        }
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.o.setAlphabeticShortcut(c2);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.o.setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.o.setChecked(z);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.o.setContentDescription(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.o.setEnabled(z);
        return this;
    }

    public MenuItem setIcon(int i2) {
        this.o.setIcon(i2);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.o.setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.o.setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.o.setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.o.setNumericShortcut(c2);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.o.setOnActionExpandListener(onActionExpandListener != null ? new OnActionExpandListenerWrapper(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.o.setOnMenuItemClickListener(onMenuItemClickListener != null ? new OnMenuItemClickListenerWrapper(onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.o.setShortcut(c2, c3);
        return this;
    }

    public void setShowAsAction(int i2) {
        this.o.setShowAsAction(i2);
    }

    public MenuItem setShowAsActionFlags(int i2) {
        this.o.setShowAsActionFlags(i2);
        return this;
    }

    public MenuItem setTitle(int i2) {
        this.o.setTitle(i2);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.o.setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.o.setTooltipText(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return this.o.setVisible(z);
    }

    public MenuItem setActionView(View view) {
        if (view instanceof android.view.CollapsibleActionView) {
            view = new CollapsibleActionViewWrapper(view);
        }
        this.o.setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.o.setAlphabeticShortcut(c2, i2);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.o.setIcon(drawable);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i2) {
        this.o.setNumericShortcut(c2, i2);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.o.setShortcut(c2, c3, i2, i3);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.o.setTitle(charSequence);
        return this;
    }
}
