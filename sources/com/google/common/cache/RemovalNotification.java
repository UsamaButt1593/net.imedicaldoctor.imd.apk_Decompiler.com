package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.AbstractMap;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long X = 0;
    private final RemovalCause s;

    private RemovalNotification(@CheckForNull K k2, @CheckForNull V v, RemovalCause removalCause) {
        super(k2, v);
        this.s = (RemovalCause) Preconditions.E(removalCause);
    }

    public static <K, V> RemovalNotification<K, V> a(@CheckForNull K k2, @CheckForNull V v, RemovalCause removalCause) {
        return new RemovalNotification<>(k2, v, removalCause);
    }

    public RemovalCause b() {
        return this.s;
    }

    public boolean c() {
        return this.s.b();
    }
}
