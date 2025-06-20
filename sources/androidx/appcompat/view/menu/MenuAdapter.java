package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuAdapter extends BaseAdapter {
    private int X = -1;
    private final LayoutInflater X2;
    private boolean Y;
    private final int Y2;
    private final boolean Z;
    MenuBuilder s;

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z, int i2) {
        this.Z = z;
        this.X2 = layoutInflater;
        this.s = menuBuilder;
        this.Y2 = i2;
        a();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        MenuItemImpl y = this.s.y();
        if (y != null) {
            ArrayList<MenuItemImpl> C = this.s.C();
            int size = C.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (C.get(i2) == y) {
                    this.X = i2;
                    return;
                }
            }
        }
        this.X = -1;
    }

    public MenuBuilder b() {
        return this.s;
    }

    public boolean c() {
        return this.Y;
    }

    /* renamed from: d */
    public MenuItemImpl getItem(int i2) {
        ArrayList<MenuItemImpl> C = this.Z ? this.s.C() : this.s.H();
        int i3 = this.X;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return C.get(i2);
    }

    public void e(boolean z) {
        this.Y = z;
    }

    public int getCount() {
        ArrayList<MenuItemImpl> C = this.Z ? this.s.C() : this.s.H();
        int i2 = this.X;
        int size = C.size();
        return i2 < 0 ? size : size - 1;
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.X2.inflate(this.Y2, viewGroup, false);
        }
        int groupId = getItem(i2).getGroupId();
        int i3 = i2 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.s.J() && groupId != (i3 >= 0 ? getItem(i3).getGroupId() : groupId));
        MenuView.ItemView itemView = (MenuView.ItemView) view;
        if (this.Y) {
            listMenuItemView.setForceShowIcon(true);
        }
        itemView.h(getItem(i2), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
