package androidx.core.view;

import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.internal.view.SupportMenu;

public final class MenuCompat {

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static void a(Menu menu, boolean z) {
            menu.setGroupDividerEnabled(z);
        }
    }

    private MenuCompat() {
    }

    public static void a(@NonNull Menu menu, boolean z) {
        if (menu instanceof SupportMenu) {
            ((SupportMenu) menu).setGroupDividerEnabled(z);
        } else if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.a(menu, z);
        }
    }

    @Deprecated
    public static void b(MenuItem menuItem, int i2) {
        menuItem.setShowAsAction(i2);
    }
}
