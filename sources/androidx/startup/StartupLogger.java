package androidx.startup;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class StartupLogger {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15851a = "StartupLogger";

    /* renamed from: b  reason: collision with root package name */
    static final boolean f15852b = false;

    private StartupLogger() {
    }

    public static void a(@NonNull String str, @Nullable Throwable th) {
        Log.e(f15851a, str, th);
    }

    public static void b(@NonNull String str) {
        Log.i(f15851a, str);
    }

    public static void c(@NonNull String str) {
        Log.w(f15851a, str);
    }
}
