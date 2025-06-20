package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

@Deprecated
public class ViewModelProviders {

    @Deprecated
    public static class DefaultFactory extends ViewModelProvider.AndroidViewModelFactory {
        @Deprecated
        public DefaultFactory(@NonNull Application application) {
            super(application);
        }
    }

    @MainThread
    @NonNull
    @Deprecated
    public static ViewModelProvider a(@NonNull Fragment fragment) {
        return new ViewModelProvider(fragment);
    }

    @MainThread
    @NonNull
    @Deprecated
    public static ViewModelProvider b(@NonNull Fragment fragment, @Nullable ViewModelProvider.Factory factory) {
        if (factory == null) {
            factory = fragment.n();
        }
        return new ViewModelProvider(fragment.w(), factory);
    }

    @MainThread
    @NonNull
    @Deprecated
    public static ViewModelProvider c(@NonNull FragmentActivity fragmentActivity) {
        return new ViewModelProvider(fragmentActivity);
    }

    @MainThread
    @NonNull
    @Deprecated
    public static ViewModelProvider d(@NonNull FragmentActivity fragmentActivity, @Nullable ViewModelProvider.Factory factory) {
        if (factory == null) {
            factory = fragmentActivity.n();
        }
        return new ViewModelProvider(fragmentActivity.w(), factory);
    }
}
