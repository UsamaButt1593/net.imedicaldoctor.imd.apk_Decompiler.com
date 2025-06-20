package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

public interface FragmentResultOwner {
    void a(@NonNull String str, @NonNull Bundle bundle);

    void b(@NonNull String str, @NonNull LifecycleOwner lifecycleOwner, @NonNull FragmentResultListener fragmentResultListener);

    void c(@NonNull String str);

    void d(@NonNull String str);
}
