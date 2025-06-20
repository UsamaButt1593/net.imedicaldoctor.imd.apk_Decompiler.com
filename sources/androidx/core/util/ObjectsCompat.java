package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

public class ObjectsCompat {
    private ObjectsCompat() {
    }

    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static int b(@Nullable Object... objArr) {
        return Objects.hash(objArr);
    }

    public static int c(@Nullable Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    @NonNull
    public static <T> T d(@Nullable T t) {
        t.getClass();
        return t;
    }

    @NonNull
    public static <T> T e(@Nullable T t, @NonNull String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    @Nullable
    public static String f(@Nullable Object obj, @Nullable String str) {
        return obj != null ? obj.toString() : str;
    }
}
