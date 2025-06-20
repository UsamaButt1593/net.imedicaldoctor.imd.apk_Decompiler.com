package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface RemovalListener<K, V> {
    void a(RemovalNotification<K, V> removalNotification);
}
