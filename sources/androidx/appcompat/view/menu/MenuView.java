package androidx.appcompat.view.menu;

import android.graphics.drawable.Drawable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface MenuView {

    public interface ItemView {
        void c(boolean z, char c2);

        boolean f();

        boolean g();

        MenuItemImpl getItemData();

        void h(MenuItemImpl menuItemImpl, int i2);

        void setCheckable(boolean z);

        void setChecked(boolean z);

        void setEnabled(boolean z);

        void setIcon(Drawable drawable);

        void setTitle(CharSequence charSequence);
    }

    void e(MenuBuilder menuBuilder);

    int getWindowAnimations();
}
