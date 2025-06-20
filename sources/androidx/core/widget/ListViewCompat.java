package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.NonNull;

@Deprecated
public final class ListViewCompat {
    private ListViewCompat() {
    }

    @Deprecated
    public static boolean a(@NonNull ListView listView, int i2) {
        return listView.canScrollList(i2);
    }

    @Deprecated
    public static void b(@NonNull ListView listView, int i2) {
        listView.scrollListBy(i2);
    }
}
