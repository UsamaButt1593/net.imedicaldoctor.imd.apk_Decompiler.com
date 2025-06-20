package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {
    private final HashMap<K, SafeIterableMap.Entry<K, V>> X2 = new HashMap<>();

    /* access modifiers changed from: protected */
    @Nullable
    public SafeIterableMap.Entry<K, V> c(K k2) {
        return this.X2.get(k2);
    }

    public boolean contains(K k2) {
        return this.X2.containsKey(k2);
    }

    public V j(@NonNull K k2, @NonNull V v) {
        SafeIterableMap.Entry c2 = c(k2);
        if (c2 != null) {
            return c2.X;
        }
        this.X2.put(k2, h(k2, v));
        return null;
    }

    public V k(@NonNull K k2) {
        V k3 = super.k(k2);
        this.X2.remove(k2);
        return k3;
    }

    @Nullable
    public Map.Entry<K, V> m(K k2) {
        if (contains(k2)) {
            return this.X2.get(k2).Z;
        }
        return null;
    }
}
