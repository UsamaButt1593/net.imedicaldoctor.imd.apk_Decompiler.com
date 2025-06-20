package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingConcurrentMap<K, V> extends ForwardingMap<K, V> implements ConcurrentMap<K, V> {
    protected ForwardingConcurrentMap() {
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V putIfAbsent(K k2, V v) {
        return a1().putIfAbsent(k2, v);
    }

    @CanIgnoreReturnValue
    public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return a1().remove(obj, obj2);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V replace(K k2, V v) {
        return a1().replace(k2, v);
    }

    /* access modifiers changed from: protected */
    /* renamed from: x1 */
    public abstract ConcurrentMap<K, V> a1();

    @CanIgnoreReturnValue
    public boolean replace(K k2, V v, V v2) {
        return a1().replace(k2, v, v2);
    }
}
