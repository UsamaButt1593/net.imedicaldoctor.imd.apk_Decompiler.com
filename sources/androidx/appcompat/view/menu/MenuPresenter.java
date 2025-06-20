package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface MenuPresenter {

    public interface Callback {
        void c(@NonNull MenuBuilder menuBuilder, boolean z);

        boolean d(@NonNull MenuBuilder menuBuilder);
    }

    void c(MenuBuilder menuBuilder, boolean z);

    void d(boolean z);

    boolean e();

    boolean f(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl);

    boolean g(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl);

    int getId();

    void h(Callback callback);

    void i(Context context, MenuBuilder menuBuilder);

    void j(Parcelable parcelable);

    boolean l(SubMenuBuilder subMenuBuilder);

    MenuView m(ViewGroup viewGroup);

    Parcelable n();
}
