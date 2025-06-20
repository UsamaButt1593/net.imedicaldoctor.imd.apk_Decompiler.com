package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface MenuItemHoverListener {
    void e(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem);

    void h(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem);
}
