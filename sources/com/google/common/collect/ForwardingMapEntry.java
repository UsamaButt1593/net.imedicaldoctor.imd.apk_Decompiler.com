package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingMapEntry<K, V> extends ForwardingObject implements Map.Entry<K, V> {
    protected ForwardingMapEntry() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a1 */
    public abstract Map.Entry<K, V> Z0();

    public boolean equals(@CheckForNull Object obj) {
        return Z0().equals(obj);
    }

    /* access modifiers changed from: protected */
    public boolean f1(@CheckForNull Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return Objects.a(getKey(), entry.getKey()) && Objects.a(getValue(), entry.getValue());
    }

    @ParametricNullness
    public K getKey() {
        return Z0().getKey();
    }

    @ParametricNullness
    public V getValue() {
        return Z0().getValue();
    }

    public int hashCode() {
        return Z0().hashCode();
    }

    /* access modifiers changed from: protected */
    public int i1() {
        Object key = getKey();
        Object value = getValue();
        int i2 = 0;
        int hashCode = key == null ? 0 : key.hashCode();
        if (value != null) {
            i2 = value.hashCode();
        }
        return hashCode ^ i2;
    }

    /* access modifiers changed from: protected */
    public String m1() {
        return getKey() + "=" + getValue();
    }

    @ParametricNullness
    public V setValue(@ParametricNullness V v) {
        return Z0().setValue(v);
    }
}
