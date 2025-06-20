package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.cache.LocalCache;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
interface ReferenceEntry<K, V> {
    @CheckForNull
    ReferenceEntry<K, V> a();

    @CheckForNull
    LocalCache.ValueReference<K, V> b();

    int c();

    ReferenceEntry<K, V> e();

    void f(LocalCache.ValueReference<K, V> valueReference);

    long g();

    @CheckForNull
    K getKey();

    void h(long j2);

    ReferenceEntry<K, V> i();

    long j();

    void k(long j2);

    ReferenceEntry<K, V> l();

    void m(ReferenceEntry<K, V> referenceEntry);

    void n(ReferenceEntry<K, V> referenceEntry);

    void o(ReferenceEntry<K, V> referenceEntry);

    void p(ReferenceEntry<K, V> referenceEntry);

    ReferenceEntry<K, V> q();
}
