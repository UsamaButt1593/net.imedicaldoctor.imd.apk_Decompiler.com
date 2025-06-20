package androidx.appcompat.app;

import androidx.annotation.Nullable;
import androidx.appcompat.view.ActionMode;

public interface AppCompatCallback {
    void i(ActionMode actionMode);

    void j(ActionMode actionMode);

    @Nullable
    ActionMode y(ActionMode.Callback callback);
}
