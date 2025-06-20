package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {
    private int i3;

    public void clear() {
        this.i3 = 0;
        super.clear();
    }

    public int hashCode() {
        if (this.i3 == 0) {
            this.i3 = super.hashCode();
        }
        return this.i3;
    }

    public void j(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.i3 = 0;
        super.j(simpleArrayMap);
    }

    public V k(int i2) {
        this.i3 = 0;
        return super.k(i2);
    }

    public V l(int i2, V v) {
        this.i3 = 0;
        return super.l(i2, v);
    }

    public V put(K k2, V v) {
        this.i3 = 0;
        return super.put(k2, v);
    }
}
