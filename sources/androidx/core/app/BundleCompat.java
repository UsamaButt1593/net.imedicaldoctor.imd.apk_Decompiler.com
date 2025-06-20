package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@Deprecated
public final class BundleCompat {
    private BundleCompat() {
    }

    @Nullable
    public static IBinder a(@NonNull Bundle bundle, @Nullable String str) {
        return bundle.getBinder(str);
    }

    public static void b(@NonNull Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        bundle.putBinder(str, iBinder);
    }
}
