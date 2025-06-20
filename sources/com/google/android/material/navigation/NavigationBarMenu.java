package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class NavigationBarMenu extends MenuBuilder {
    @NonNull
    private final Class<?> Q;
    private final int R;

    public NavigationBarMenu(@NonNull Context context, @NonNull Class<?> cls, int i2) {
        super(context);
        this.Q = cls;
        this.R = i2;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public MenuItem a(int i2, int i3, int i4, @NonNull CharSequence charSequence) {
        if (size() + 1 <= this.R) {
            n0();
            MenuItem a2 = super.a(i2, i3, i4, charSequence);
            if (a2 instanceof MenuItemImpl) {
                ((MenuItemImpl) a2).w(true);
            }
            m0();
            return a2;
        }
        String simpleName = this.Q.getSimpleName();
        throw new IllegalArgumentException("Maximum number of items supported by " + simpleName + " is " + this.R + ". Limit can be checked with " + simpleName + "#getMaxItemCount()");
    }

    @NonNull
    public SubMenu addSubMenu(int i2, int i3, int i4, @NonNull CharSequence charSequence) {
        throw new UnsupportedOperationException(this.Q.getSimpleName() + " does not support submenus");
    }

    public int o0() {
        return this.R;
    }
}
