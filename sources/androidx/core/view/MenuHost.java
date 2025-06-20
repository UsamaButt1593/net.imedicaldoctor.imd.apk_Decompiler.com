package androidx.core.view;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

public interface MenuHost {
    @SuppressLint({"LambdaLast"})
    void F(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.State state);

    void H(@NonNull MenuProvider menuProvider);

    void K();

    void c(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner);

    void f(@NonNull MenuProvider menuProvider);
}
