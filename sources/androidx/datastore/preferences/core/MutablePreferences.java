package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.Preferences;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B-\b\u0000\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0000¢\u0006\u0004\b\r\u0010\fJ$\u0010\u0010\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J&\u0010\u0012\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J,\u0010\u0018\u001a\u00020\n\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0017\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001a\u001a\u00020\n2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u001a\u0010\u0019J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001c\u0010 \u001a\u00020\n2\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0002¢\u0006\u0004\b \u0010!J\u001c\u0010\"\u001a\u00020\n2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0004\b\"\u0010#J)\u0010&\u001a\u00020\n2\u001a\u0010%\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u001e0$\"\u0006\u0012\u0002\b\u00030\u001e¢\u0006\u0004\b&\u0010'J!\u0010(\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b(\u0010\u0013J\r\u0010)\u001a\u00020\n¢\u0006\u0004\b)\u0010\fJ\u001a\u0010+\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00101\u001a\u000200H\u0016¢\u0006\u0004\b1\u00102R*\u0010\u0005\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0000X\u0004¢\u0006\f\n\u0004\b\u0015\u00103\u001a\u0004\b4\u0010\u0016R\u0014\u00107\u001a\u0002058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u00106¨\u00068"}, d2 = {"Landroidx/datastore/preferences/core/MutablePreferences;", "Landroidx/datastore/preferences/core/Preferences;", "", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "preferencesMap", "", "startFrozen", "<init>", "(Ljava/util/Map;Z)V", "", "f", "()V", "h", "T", "key", "b", "(Landroidx/datastore/preferences/core/Preferences$Key;)Z", "c", "(Landroidx/datastore/preferences/core/Preferences$Key;)Ljava/lang/Object;", "", "a", "()Ljava/util/Map;", "value", "o", "(Landroidx/datastore/preferences/core/Preferences$Key;Ljava/lang/Object;)V", "p", "prefs", "l", "(Landroidx/datastore/preferences/core/Preferences;)V", "Landroidx/datastore/preferences/core/Preferences$Pair;", "pair", "k", "(Landroidx/datastore/preferences/core/Preferences$Pair;)V", "j", "(Landroidx/datastore/preferences/core/Preferences$Key;)V", "", "pairs", "m", "([Landroidx/datastore/preferences/core/Preferences$Pair;)V", "n", "g", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/Map;", "i", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "frozen", "datastore-preferences-core"}, k = 1, mv = {1, 5, 1})
public final class MutablePreferences extends Preferences {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Map<Preferences.Key<?>, Object> f6955a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f6956b;

    public MutablePreferences() {
        this((Map) null, false, 3, (DefaultConstructorMarker) null);
    }

    @NotNull
    public Map<Preferences.Key<?>, Object> a() {
        Map<Preferences.Key<?>, Object> unmodifiableMap = Collections.unmodifiableMap(this.f6955a);
        Intrinsics.o(unmodifiableMap, "unmodifiableMap(preferencesMap)");
        return unmodifiableMap;
    }

    public <T> boolean b(@NotNull Preferences.Key<T> key) {
        Intrinsics.p(key, "key");
        return this.f6955a.containsKey(key);
    }

    @Nullable
    public <T> T c(@NotNull Preferences.Key<T> key) {
        Intrinsics.p(key, "key");
        return this.f6955a.get(key);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof MutablePreferences) {
            return Intrinsics.g(this.f6955a, ((MutablePreferences) obj).f6955a);
        }
        return false;
    }

    public final void f() {
        if (!(!this.f6956b.get())) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.".toString());
        }
    }

    public final void g() {
        f();
        this.f6955a.clear();
    }

    public final void h() {
        this.f6956b.set(true);
    }

    public int hashCode() {
        return this.f6955a.hashCode();
    }

    @NotNull
    public final Map<Preferences.Key<?>, Object> i() {
        return this.f6955a;
    }

    public final void j(@NotNull Preferences.Key<?> key) {
        Intrinsics.p(key, "key");
        f();
        n(key);
    }

    public final void k(@NotNull Preferences.Pair<?> pair) {
        Intrinsics.p(pair, "pair");
        f();
        m(pair);
    }

    public final void l(@NotNull Preferences preferences) {
        Intrinsics.p(preferences, "prefs");
        f();
        this.f6955a.putAll(preferences.a());
    }

    public final void m(@NotNull Preferences.Pair<?>... pairArr) {
        Intrinsics.p(pairArr, "pairs");
        f();
        for (Preferences.Pair<?> pair : pairArr) {
            p(pair.a(), pair.b());
        }
    }

    public final <T> T n(@NotNull Preferences.Key<T> key) {
        Intrinsics.p(key, "key");
        f();
        return this.f6955a.remove(key);
    }

    public final <T> void o(@NotNull Preferences.Key<T> key, T t) {
        Intrinsics.p(key, "key");
        p(key, t);
    }

    public final void p(@NotNull Preferences.Key<?> key, @Nullable Object obj) {
        Map<Preferences.Key<?>, Object> map;
        Intrinsics.p(key, "key");
        f();
        if (obj == null) {
            n(key);
            return;
        }
        if (obj instanceof Set) {
            map = this.f6955a;
            obj = Collections.unmodifiableSet(CollectionsKt.X5((Iterable) obj));
            Intrinsics.o(obj, "unmodifiableSet(value.toSet())");
        } else {
            map = this.f6955a;
        }
        map.put(key, obj);
    }

    @NotNull
    public String toString() {
        return CollectionsKt.j3(this.f6955a.entrySet(), ",\n", "{\n", "\n}", 0, (CharSequence) null, MutablePreferences$toString$1.X, 24, (Object) null);
    }

    public MutablePreferences(@NotNull Map<Preferences.Key<?>, Object> map, boolean z) {
        Intrinsics.p(map, "preferencesMap");
        this.f6955a = map;
        this.f6956b = new AtomicBoolean(z);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutablePreferences(Map map, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new LinkedHashMap() : map, (i2 & 2) != 0 ? true : z);
    }
}
