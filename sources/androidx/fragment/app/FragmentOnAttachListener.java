package androidx.fragment.app;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

public interface FragmentOnAttachListener {
    @MainThread
    void b(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment);
}
