package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

@Deprecated
public class ViewModelStores {
    private ViewModelStores() {
    }

    @MainThread
    @NonNull
    @Deprecated
    public static ViewModelStore a(@NonNull Fragment fragment) {
        return fragment.w();
    }

    @MainThread
    @NonNull
    @Deprecated
    public static ViewModelStore b(@NonNull FragmentActivity fragmentActivity) {
        return fragmentActivity.w();
    }
}
