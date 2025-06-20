package androidx.loader.app;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class LoaderManager {

    public interface LoaderCallbacks<D> {
        @MainThread
        void a(@NonNull Loader<D> loader, D d2);

        @MainThread
        @NonNull
        Loader<D> b(int i2, @Nullable Bundle bundle);

        @MainThread
        void c(@NonNull Loader<D> loader);
    }

    public static void c(boolean z) {
        LoaderManagerImpl.f8806d = z;
    }

    @NonNull
    public static <T extends LifecycleOwner & ViewModelStoreOwner> LoaderManager d(@NonNull T t) {
        return new LoaderManagerImpl(t, ((ViewModelStoreOwner) t).w());
    }

    @MainThread
    public abstract void a(int i2);

    @Deprecated
    public abstract void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @Nullable
    public abstract <D> Loader<D> e(int i2);

    public boolean f() {
        return false;
    }

    @MainThread
    @NonNull
    public abstract <D> Loader<D> g(int i2, @Nullable Bundle bundle, @NonNull LoaderCallbacks<D> loaderCallbacks);

    public abstract void h();

    @MainThread
    @NonNull
    public abstract <D> Loader<D> i(int i2, @Nullable Bundle bundle, @NonNull LoaderCallbacks<D> loaderCallbacks);
}
