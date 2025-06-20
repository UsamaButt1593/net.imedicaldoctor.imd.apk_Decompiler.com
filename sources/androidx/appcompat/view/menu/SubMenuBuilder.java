package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SubMenuBuilder extends MenuBuilder implements SubMenu {
    private MenuBuilder Q;
    private MenuItemImpl R;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.Q = menuBuilder;
        this.R = menuItemImpl;
    }

    public MenuBuilder G() {
        return this.Q.G();
    }

    public boolean J() {
        return this.Q.J();
    }

    public boolean K() {
        return this.Q.K();
    }

    public boolean L() {
        return this.Q.L();
    }

    public void Y(MenuBuilder.Callback callback) {
        this.Q.Y(callback);
    }

    public boolean g(MenuItemImpl menuItemImpl) {
        return this.Q.g(menuItemImpl);
    }

    public MenuItem getItem() {
        return this.R;
    }

    /* access modifiers changed from: package-private */
    public boolean i(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        return super.i(menuBuilder, menuItem) || this.Q.i(menuBuilder, menuItem);
    }

    public void k0(boolean z) {
        this.Q.k0(z);
    }

    public boolean n(MenuItemImpl menuItemImpl) {
        return this.Q.n(menuItemImpl);
    }

    public Menu o0() {
        return this.Q;
    }

    public void setGroupDividerEnabled(boolean z) {
        this.Q.setGroupDividerEnabled(z);
    }

    public SubMenu setHeaderIcon(int i2) {
        return (SubMenu) super.c0(i2);
    }

    public SubMenu setHeaderTitle(int i2) {
        return (SubMenu) super.f0(i2);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.h0(view);
    }

    public SubMenu setIcon(int i2) {
        this.R.setIcon(i2);
        return this;
    }

    public void setQwertyMode(boolean z) {
        this.Q.setQwertyMode(z);
    }

    public String w() {
        MenuItemImpl menuItemImpl = this.R;
        int itemId = menuItemImpl != null ? menuItemImpl.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.w() + ":" + itemId;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.d0(drawable);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.g0(charSequence);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.R.setIcon(drawable);
        return this;
    }
}
