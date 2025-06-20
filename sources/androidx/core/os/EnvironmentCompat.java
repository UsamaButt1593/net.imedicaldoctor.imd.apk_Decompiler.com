package androidx.core.os;

import android.os.Environment;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.File;

public final class EnvironmentCompat {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final String f6056a = "unknown";

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static String a(File file) {
            return Environment.getExternalStorageState(file);
        }
    }

    private EnvironmentCompat() {
    }

    @NonNull
    public static String a(@NonNull File file) {
        return Api21Impl.a(file);
    }
}
