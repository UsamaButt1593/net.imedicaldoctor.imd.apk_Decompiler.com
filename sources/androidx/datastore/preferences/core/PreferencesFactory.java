package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.Preferences;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002\u001a+\u0010\u0006\u001a\u00020\u00002\u001a\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\"\u0006\u0012\u0002\b\u00030\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a+\u0010\t\u001a\u00020\b2\u001a\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\"\u0006\u0012\u0002\b\u00030\u0004H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/datastore/preferences/core/Preferences;", "b", "()Landroidx/datastore/preferences/core/Preferences;", "", "Landroidx/datastore/preferences/core/Preferences$Pair;", "pairs", "a", "([Landroidx/datastore/preferences/core/Preferences$Pair;)Landroidx/datastore/preferences/core/Preferences;", "Landroidx/datastore/preferences/core/MutablePreferences;", "c", "([Landroidx/datastore/preferences/core/Preferences$Pair;)Landroidx/datastore/preferences/core/MutablePreferences;", "datastore-preferences-core"}, k = 2, mv = {1, 5, 1})
@JvmName(name = "PreferencesFactory")
public final class PreferencesFactory {
    @NotNull
    @JvmName(name = "create")
    public static final Preferences a(@NotNull Preferences.Pair<?>... pairArr) {
        Intrinsics.p(pairArr, "pairs");
        return c((Preferences.Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    @NotNull
    @JvmName(name = "createEmpty")
    public static final Preferences b() {
        return new MutablePreferences((Map) null, true, 1, (DefaultConstructorMarker) null);
    }

    @NotNull
    @JvmName(name = "createMutable")
    public static final MutablePreferences c(@NotNull Preferences.Pair<?>... pairArr) {
        Intrinsics.p(pairArr, "pairs");
        MutablePreferences mutablePreferences = new MutablePreferences((Map) null, false, 1, (DefaultConstructorMarker) null);
        mutablePreferences.m((Preferences.Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        return mutablePreferences;
    }
}
