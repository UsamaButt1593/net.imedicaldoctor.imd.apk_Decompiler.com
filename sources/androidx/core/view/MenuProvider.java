package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;

public interface MenuProvider {
    boolean a(@NonNull MenuItem menuItem);

    void b(@NonNull Menu menu);

    void c(@NonNull Menu menu, @NonNull MenuInflater menuInflater);

    void d(@NonNull Menu menu);
}
