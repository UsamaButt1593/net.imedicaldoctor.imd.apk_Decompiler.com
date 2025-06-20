package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
    AbstractMapEntry() {
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return Objects.a(getKey(), entry.getKey()) && Objects.a(getValue(), entry.getValue());
    }

    @ParametricNullness
    public abstract K getKey();

    @ParametricNullness
    public abstract V getValue();

    public int hashCode() {
        Object key = getKey();
        Object value = getValue();
        int i2 = 0;
        int hashCode = key == null ? 0 : key.hashCode();
        if (value != null) {
            i2 = value.hashCode();
        }
        return hashCode ^ i2;
    }

    @ParametricNullness
    public V setValue(@ParametricNullness V v) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return getKey() + "=" + getValue();
    }
}
