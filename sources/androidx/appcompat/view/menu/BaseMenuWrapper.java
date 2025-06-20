package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

abstract class BaseMenuWrapper {

    /* renamed from: l  reason: collision with root package name */
    final Context f2958l;

    /* renamed from: m  reason: collision with root package name */
    private SimpleArrayMap<SupportMenuItem, MenuItem> f2959m;

    /* renamed from: n  reason: collision with root package name */
    private SimpleArrayMap<SupportSubMenu, SubMenu> f2960n;

    BaseMenuWrapper(Context context) {
        this.f2958l = context;
    }

    /* access modifiers changed from: package-private */
    public final MenuItem e(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.f2959m == null) {
            this.f2959m = new SimpleArrayMap<>();
        }
        MenuItem menuItem2 = this.f2959m.get(supportMenuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS(this.f2958l, supportMenuItem);
        this.f2959m.put(supportMenuItem, menuItemWrapperICS);
        return menuItemWrapperICS;
    }

    /* access modifiers changed from: package-private */
    public final SubMenu f(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.f2960n == null) {
            this.f2960n = new SimpleArrayMap<>();
        }
        SubMenu subMenu2 = this.f2960n.get(supportSubMenu);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenuWrapperICS subMenuWrapperICS = new SubMenuWrapperICS(this.f2958l, supportSubMenu);
        this.f2960n.put(supportSubMenu, subMenuWrapperICS);
        return subMenuWrapperICS;
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        SimpleArrayMap<SupportMenuItem, MenuItem> simpleArrayMap = this.f2959m;
        if (simpleArrayMap != null) {
            simpleArrayMap.clear();
        }
        SimpleArrayMap<SupportSubMenu, SubMenu> simpleArrayMap2 = this.f2960n;
        if (simpleArrayMap2 != null) {
            simpleArrayMap2.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final void h(int i2) {
        if (this.f2959m != null) {
            int i3 = 0;
            while (i3 < this.f2959m.size()) {
                if (this.f2959m.i(i3).getGroupId() == i2) {
                    this.f2959m.k(i3);
                    i3--;
                }
                i3++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void i(int i2) {
        if (this.f2959m != null) {
            for (int i3 = 0; i3 < this.f2959m.size(); i3++) {
                if (this.f2959m.i(i3).getItemId() == i2) {
                    this.f2959m.k(i3);
                    return;
                }
            }
        }
    }
}
