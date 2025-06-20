package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportSubMenu;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {
    private final SupportSubMenu p;

    SubMenuWrapperICS(Context context, SupportSubMenu supportSubMenu) {
        super(context, supportSubMenu);
        this.p = supportSubMenu;
    }

    public void clearHeader() {
        this.p.clearHeader();
    }

    public MenuItem getItem() {
        return e(this.p.getItem());
    }

    public SubMenu setHeaderIcon(int i2) {
        this.p.setHeaderIcon(i2);
        return this;
    }

    public SubMenu setHeaderTitle(int i2) {
        this.p.setHeaderTitle(i2);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        this.p.setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i2) {
        this.p.setIcon(i2);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        this.p.setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.p.setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.p.setIcon(drawable);
        return this;
    }
}
