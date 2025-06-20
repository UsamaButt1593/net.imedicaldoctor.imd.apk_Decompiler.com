package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.Preferences;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\u001a\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\b\u0010\u0005\u001a\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\n\u0010\u0005\u001a\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\f\u0010\u0005\u001a\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u000e\u0010\u0005\u001a#\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u000f0\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0010\u0010\u0005¨\u0006\u0011"}, d2 = {"", "name", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "d", "(Ljava/lang/String;)Landroidx/datastore/preferences/core/Preferences$Key;", "", "b", "f", "", "a", "", "c", "", "e", "", "g", "datastore-preferences-core"}, k = 2, mv = {1, 5, 1})
@JvmName(name = "PreferencesKeys")
public final class PreferencesKeys {
    @NotNull
    @JvmName(name = "booleanKey")
    public static final Preferences.Key<Boolean> a(@NotNull String str) {
        Intrinsics.p(str, "name");
        return new Preferences.Key<>(str);
    }

    @NotNull
    @JvmName(name = "doubleKey")
    public static final Preferences.Key<Double> b(@NotNull String str) {
        Intrinsics.p(str, "name");
        return new Preferences.Key<>(str);
    }

    @NotNull
    @JvmName(name = "floatKey")
    public static final Preferences.Key<Float> c(@NotNull String str) {
        Intrinsics.p(str, "name");
        return new Preferences.Key<>(str);
    }

    @NotNull
    @JvmName(name = "intKey")
    public static final Preferences.Key<Integer> d(@NotNull String str) {
        Intrinsics.p(str, "name");
        return new Preferences.Key<>(str);
    }

    @NotNull
    @JvmName(name = "longKey")
    public static final Preferences.Key<Long> e(@NotNull String str) {
        Intrinsics.p(str, "name");
        return new Preferences.Key<>(str);
    }

    @NotNull
    @JvmName(name = "stringKey")
    public static final Preferences.Key<String> f(@NotNull String str) {
        Intrinsics.p(str, "name");
        return new Preferences.Key<>(str);
    }

    @NotNull
    @JvmName(name = "stringSetKey")
    public static final Preferences.Key<Set<String>> g(@NotNull String str) {
        Intrinsics.p(str, "name");
        return new Preferences.Key<>(str);
    }
}
