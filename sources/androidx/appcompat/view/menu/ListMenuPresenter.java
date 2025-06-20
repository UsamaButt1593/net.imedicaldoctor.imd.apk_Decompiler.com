package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {
    private static final String d3 = "ListMenuPresenter";
    public static final String e3 = "android:menu:list";
    LayoutInflater X;
    int X2;
    MenuBuilder Y;
    int Y2;
    ExpandedMenuView Z;
    int Z2;
    private MenuPresenter.Callback a3;
    MenuAdapter b3;
    private int c3;
    Context s;

    private class MenuAdapter extends BaseAdapter {
        private int s = -1;

        public MenuAdapter() {
            a();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            MenuItemImpl y = ListMenuPresenter.this.Y.y();
            if (y != null) {
                ArrayList<MenuItemImpl> C = ListMenuPresenter.this.Y.C();
                int size = C.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (C.get(i2) == y) {
                        this.s = i2;
                        return;
                    }
                }
            }
            this.s = -1;
        }

        /* renamed from: b */
        public MenuItemImpl getItem(int i2) {
            ArrayList<MenuItemImpl> C = ListMenuPresenter.this.Y.C();
            int i3 = i2 + ListMenuPresenter.this.X2;
            int i4 = this.s;
            if (i4 >= 0 && i3 >= i4) {
                i3++;
            }
            return C.get(i3);
        }

        public int getCount() {
            int size = ListMenuPresenter.this.Y.C().size() - ListMenuPresenter.this.X2;
            return this.s < 0 ? size : size - 1;
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                ListMenuPresenter listMenuPresenter = ListMenuPresenter.this;
                view = listMenuPresenter.X.inflate(listMenuPresenter.Z2, viewGroup, false);
            }
            ((MenuView.ItemView) view).h(getItem(i2), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public ListMenuPresenter(int i2, int i3) {
        this.Z2 = i2;
        this.Y2 = i3;
    }

    public ListAdapter a() {
        if (this.b3 == null) {
            this.b3 = new MenuAdapter();
        }
        return this.b3;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.X2;
    }

    public void c(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.Callback callback = this.a3;
        if (callback != null) {
            callback.c(menuBuilder, z);
        }
    }

    public void d(boolean z) {
        MenuAdapter menuAdapter = this.b3;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
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
        this.a3 = callback;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i(android.content.Context r3, androidx.appcompat.view.menu.MenuBuilder r4) {
        /*
            r2 = this;
            int r0 = r2.Y2
            if (r0 == 0) goto L_0x0014
            android.view.ContextThemeWrapper r0 = new android.view.ContextThemeWrapper
            int r1 = r2.Y2
            r0.<init>(r3, r1)
            r2.s = r0
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r0)
        L_0x0011:
            r2.X = r3
            goto L_0x0023
        L_0x0014:
            android.content.Context r0 = r2.s
            if (r0 == 0) goto L_0x0023
            r2.s = r3
            android.view.LayoutInflater r0 = r2.X
            if (r0 != 0) goto L_0x0023
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            goto L_0x0011
        L_0x0023:
            r2.Y = r4
            androidx.appcompat.view.menu.ListMenuPresenter$MenuAdapter r3 = r2.b3
            if (r3 == 0) goto L_0x002c
            r3.notifyDataSetChanged()
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuPresenter.i(android.content.Context, androidx.appcompat.view.menu.MenuBuilder):void");
    }

    public void j(Parcelable parcelable) {
        k((Bundle) parcelable);
    }

    public void k(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(e3);
        if (sparseParcelableArray != null) {
            this.Z.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public boolean l(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        new MenuDialogHelper(subMenuBuilder).e((IBinder) null);
        MenuPresenter.Callback callback = this.a3;
        if (callback == null) {
            return true;
        }
        callback.d(subMenuBuilder);
        return true;
    }

    public MenuView m(ViewGroup viewGroup) {
        if (this.Z == null) {
            this.Z = (ExpandedMenuView) this.X.inflate(R.layout.f2647n, viewGroup, false);
            if (this.b3 == null) {
                this.b3 = new MenuAdapter();
            }
            this.Z.setAdapter(this.b3);
            this.Z.setOnItemClickListener(this);
        }
        return this.Z;
    }

    public Parcelable n() {
        if (this.Z == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        o(bundle);
        return bundle;
    }

    public void o(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        ExpandedMenuView expandedMenuView = this.Z;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray(e3, sparseArray);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.Y.Q(this.b3.getItem(i2), this, 0);
    }

    public void p(int i2) {
        this.c3 = i2;
    }

    public void q(int i2) {
        this.X2 = i2;
        if (this.Z != null) {
            d(false);
        }
    }

    public ListMenuPresenter(Context context, int i2) {
        this(i2, 0);
        this.s = context;
        this.X = LayoutInflater.from(context);
    }
}
