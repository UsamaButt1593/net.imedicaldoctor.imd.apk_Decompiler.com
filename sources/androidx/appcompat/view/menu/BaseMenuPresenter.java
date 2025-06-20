package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class BaseMenuPresenter implements MenuPresenter {
    protected Context X;
    protected LayoutInflater X2;
    protected MenuBuilder Y;
    private MenuPresenter.Callback Y2;
    protected LayoutInflater Z;
    private int Z2;
    private int a3;
    protected MenuView b3;
    private int c3;
    protected Context s;

    public BaseMenuPresenter(Context context, int i2, int i3) {
        this.s = context;
        this.Z = LayoutInflater.from(context);
        this.Z2 = i2;
        this.a3 = i3;
    }

    /* access modifiers changed from: protected */
    public void b(View view, int i2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.b3).addView(view, i2);
    }

    public void c(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.Callback callback = this.Y2;
        if (callback != null) {
            callback.c(menuBuilder, z);
        }
    }

    public void d(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.b3;
        if (viewGroup != null) {
            MenuBuilder menuBuilder = this.Y;
            int i2 = 0;
            if (menuBuilder != null) {
                menuBuilder.u();
                ArrayList<MenuItemImpl> H = this.Y.H();
                int size = H.size();
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    MenuItemImpl menuItemImpl = H.get(i4);
                    if (t(i3, menuItemImpl)) {
                        View childAt = viewGroup.getChildAt(i3);
                        MenuItemImpl itemData = childAt instanceof MenuView.ItemView ? ((MenuView.ItemView) childAt).getItemData() : null;
                        View r = r(menuItemImpl, childAt, viewGroup);
                        if (menuItemImpl != itemData) {
                            r.setPressed(false);
                            r.jumpDrawablesToCurrentState();
                        }
                        if (r != childAt) {
                            b(r, i3);
                        }
                        i3++;
                    }
                }
                i2 = i3;
            }
            while (i2 < viewGroup.getChildCount()) {
                if (!p(viewGroup, i2)) {
                    i2++;
                }
            }
        }
    }

    public boolean e() {
        return false;
    }

    public boolean f(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean g(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public int getId() {
        return this.c3;
    }

    public void h(MenuPresenter.Callback callback) {
        this.Y2 = callback;
    }

    public void i(Context context, MenuBuilder menuBuilder) {
        this.X = context;
        this.X2 = LayoutInflater.from(context);
        this.Y = menuBuilder;
    }

    public abstract void k(MenuItemImpl menuItemImpl, MenuView.ItemView itemView);

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean l(androidx.appcompat.view.menu.SubMenuBuilder r2) {
        /*
            r1 = this;
            androidx.appcompat.view.menu.MenuPresenter$Callback r0 = r1.Y2
            if (r0 == 0) goto L_0x000e
            if (r2 == 0) goto L_0x0007
            goto L_0x0009
        L_0x0007:
            androidx.appcompat.view.menu.MenuBuilder r2 = r1.Y
        L_0x0009:
            boolean r2 = r0.d(r2)
            return r2
        L_0x000e:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.BaseMenuPresenter.l(androidx.appcompat.view.menu.SubMenuBuilder):boolean");
    }

    public MenuView m(ViewGroup viewGroup) {
        if (this.b3 == null) {
            MenuView menuView = (MenuView) this.Z.inflate(this.Z2, viewGroup, false);
            this.b3 = menuView;
            menuView.e(this.Y);
            d(true);
        }
        return this.b3;
    }

    public MenuView.ItemView o(ViewGroup viewGroup) {
        return (MenuView.ItemView) this.Z.inflate(this.a3, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public boolean p(ViewGroup viewGroup, int i2) {
        viewGroup.removeViewAt(i2);
        return true;
    }

    public MenuPresenter.Callback q() {
        return this.Y2;
    }

    public View r(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        MenuView.ItemView o = view instanceof MenuView.ItemView ? (MenuView.ItemView) view : o(viewGroup);
        k(menuItemImpl, o);
        return (View) o;
    }

    public void s(int i2) {
        this.c3 = i2;
    }

    public boolean t(int i2, MenuItemImpl menuItemImpl) {
        return true;
    }
}
