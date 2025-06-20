package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public final class HashMultimap<K, V> extends HashMultimapGwtSerializationDependencies<K, V> {
    private static final int d3 = 2;
    @GwtIncompatible
    @J2ktIncompatible
    private static final long e3 = 0;
    @VisibleForTesting
    transient int c3;

    private HashMultimap() {
        this(12, 2);
    }

    public static <K, V> HashMultimap<K, V> J() {
        return new HashMultimap<>();
    }

    public static <K, V> HashMultimap<K, V> K(int i2, int i3) {
        return new HashMultimap<>(i2, i3);
    }

    public static <K, V> HashMultimap<K, V> L(Multimap<? extends K, ? extends V> multimap) {
        return new HashMultimap<>(multimap);
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void M(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.c3 = 2;
        int h2 = Serialization.h(objectInputStream);
        C(Platform.d(12));
        Serialization.e(this, objectInputStream, h2);
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void N(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.j(this, objectOutputStream);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: H */
    public Set<V> u() {
        return Platform.e(this.c3);
    }

    public /* bridge */ /* synthetic */ boolean N0(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.N0(obj, obj2);
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean T0(@ParametricNullness Object obj, Iterable iterable) {
        return super.T0(obj, iterable);
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean Z(Multimap multimap) {
        return super.Z(multimap);
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Set b(@CheckForNull Object obj) {
        return super.b(obj);
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Set c(@ParametricNullness Object obj, Iterable iterable) {
        return super.c(obj, iterable);
    }

    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public /* bridge */ /* synthetic */ boolean containsKey(@CheckForNull Object obj) {
        return super.containsKey(obj);
    }

    public /* bridge */ /* synthetic */ boolean containsValue(@CheckForNull Object obj) {
        return super.containsValue(obj);
    }

    public /* bridge */ /* synthetic */ Multiset d0() {
        return super.d0();
    }

    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ Map g() {
        return super.g();
    }

    public /* bridge */ /* synthetic */ Set get(@ParametricNullness Object obj) {
        return super.get(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public /* bridge */ /* synthetic */ Set j() {
        return super.j();
    }

    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean put(@ParametricNullness Object obj, @ParametricNullness Object obj2) {
        return super.put(obj, obj2);
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.remove(obj, obj2);
    }

    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    private HashMultimap(int i2, int i3) {
        super(Platform.d(i2));
        this.c3 = 2;
        Preconditions.d(i3 >= 0);
        this.c3 = i3;
    }

    private HashMultimap(Multimap<? extends K, ? extends V> multimap) {
        super(Platform.d(multimap.keySet().size()));
        this.c3 = 2;
        Z(multimap);
    }
}
