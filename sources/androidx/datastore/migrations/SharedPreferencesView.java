package androidx.datastore.migrations;

import android.content.SharedPreferences;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u00052\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010 ¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010#R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010$¨\u0006%"}, d2 = {"Landroidx/datastore/migrations/SharedPreferencesView;", "", "Landroid/content/SharedPreferences;", "prefs", "", "", "keySet", "<init>", "(Landroid/content/SharedPreferences;Ljava/util/Set;)V", "key", "a", "(Ljava/lang/String;)Ljava/lang/String;", "", "b", "(Ljava/lang/String;)Z", "defValue", "d", "(Ljava/lang/String;Z)Z", "", "e", "(Ljava/lang/String;F)F", "", "f", "(Ljava/lang/String;I)I", "", "g", "(Ljava/lang/String;J)J", "h", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "defValues", "j", "(Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;", "", "c", "()Ljava/util/Map;", "Landroid/content/SharedPreferences;", "Ljava/util/Set;", "datastore_release"}, k = 1, mv = {1, 5, 1})
public final class SharedPreferencesView {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f6943a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Set<String> f6944b;

    public SharedPreferencesView(@NotNull SharedPreferences sharedPreferences, @Nullable Set<String> set) {
        Intrinsics.p(sharedPreferences, "prefs");
        this.f6943a = sharedPreferences;
        this.f6944b = set;
    }

    private final String a(String str) {
        Set<String> set = this.f6944b;
        if (set == null || set.contains(str)) {
            return str;
        }
        throw new IllegalStateException(Intrinsics.C("Can't access key outside migration: ", str).toString());
    }

    public static /* synthetic */ String i(SharedPreferencesView sharedPreferencesView, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        return sharedPreferencesView.h(str, str2);
    }

    public static /* synthetic */ Set k(SharedPreferencesView sharedPreferencesView, String str, Set set, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            set = null;
        }
        return sharedPreferencesView.j(str, set);
    }

    public final boolean b(@NotNull String str) {
        Intrinsics.p(str, "key");
        return this.f6943a.contains(a(str));
    }

    @NotNull
    public final Map<String, Object> c() {
        Map<String, ?> all = this.f6943a.getAll();
        Intrinsics.o(all, "prefs.all");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : all.entrySet()) {
            String str = (String) next.getKey();
            Set<String> set = this.f6944b;
            if (set == null ? true : set.contains(str)) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.j(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Set) {
                value = CollectionsKt.X5((Iterable) value);
            }
            linkedHashMap2.put(key, value);
        }
        return linkedHashMap2;
    }

    public final boolean d(@NotNull String str, boolean z) {
        Intrinsics.p(str, "key");
        return this.f6943a.getBoolean(a(str), z);
    }

    public final float e(@NotNull String str, float f2) {
        Intrinsics.p(str, "key");
        return this.f6943a.getFloat(a(str), f2);
    }

    public final int f(@NotNull String str, int i2) {
        Intrinsics.p(str, "key");
        return this.f6943a.getInt(a(str), i2);
    }

    public final long g(@NotNull String str, long j2) {
        Intrinsics.p(str, "key");
        return this.f6943a.getLong(a(str), j2);
    }

    @Nullable
    public final String h(@NotNull String str, @Nullable String str2) {
        Intrinsics.p(str, "key");
        return this.f6943a.getString(a(str), str2);
    }

    @Nullable
    public final Set<String> j(@NotNull String str, @Nullable Set<String> set) {
        Intrinsics.p(str, "key");
        Set<String> stringSet = this.f6943a.getStringSet(a(str), set);
        if (stringSet == null) {
            return null;
        }
        return CollectionsKt.W5(stringSet);
    }
}
