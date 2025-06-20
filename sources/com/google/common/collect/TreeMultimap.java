package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public class TreeMultimap<K, V> extends AbstractSortedKeySortedSetMultimap<K, V> {
    @GwtIncompatible
    @J2ktIncompatible
    private static final long f3 = 0;
    private transient Comparator<? super K> d3;
    private transient Comparator<? super V> e3;

    TreeMultimap(Comparator<? super K> comparator, Comparator<? super V> comparator2) {
        super(new TreeMap(comparator));
        this.d3 = comparator;
        this.e3 = comparator2;
    }

    public static <K extends Comparable, V extends Comparable> TreeMultimap<K, V> Q() {
        return new TreeMultimap<>(Ordering.z(), Ordering.z());
    }

    public static <K extends Comparable, V extends Comparable> TreeMultimap<K, V> R(Multimap<? extends K, ? extends V> multimap) {
        return new TreeMultimap<>(Ordering.z(), Ordering.z(), multimap);
    }

    public static <K, V> TreeMultimap<K, V> S(Comparator<? super K> comparator, Comparator<? super V> comparator2) {
        return new TreeMultimap<>((Comparator) Preconditions.E(comparator), (Comparator) Preconditions.E(comparator2));
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void X(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.d3 = (Comparator) Preconditions.E((Comparator) objectInputStream.readObject());
        this.e3 = (Comparator) Preconditions.E((Comparator) objectInputStream.readObject());
        C(new TreeMap(this.d3));
        Serialization.d(this, objectInputStream);
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void Y(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(U());
        objectOutputStream.writeObject(i0());
        Serialization.j(this, objectOutputStream);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: J */
    public SortedSet<V> u() {
        return new TreeSet(this.e3);
    }

    public /* bridge */ /* synthetic */ boolean N0(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.N0(obj, obj2);
    }

    /* renamed from: P */
    public NavigableMap<K, Collection<V>> g() {
        return (NavigableMap) super.g();
    }

    @GwtIncompatible
    /* renamed from: T */
    public NavigableSet<V> get(@ParametricNullness K k2) {
        return (NavigableSet) super.get((Object) k2);
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean T0(@ParametricNullness Object obj, Iterable iterable) {
        return super.T0(obj, iterable);
    }

    @Deprecated
    public Comparator<? super K> U() {
        return this.d3;
    }

    /* renamed from: V */
    public NavigableSet<K> keySet() {
        return (NavigableSet) super.keySet();
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean Z(Multimap multimap) {
        return super.Z(multimap);
    }

    /* access modifiers changed from: package-private */
    public Map<K, Collection<V>> a() {
        return w();
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ SortedSet b(@CheckForNull Object obj) {
        return super.b(obj);
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ SortedSet c(@ParametricNullness Object obj, Iterable iterable) {
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

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public Comparator<? super V> i0() {
        return this.e3;
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public /* bridge */ /* synthetic */ Set j() {
        return super.j();
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

    /* access modifiers changed from: package-private */
    public Collection<V> v(@ParametricNullness K k2) {
        if (k2 == null) {
            U().compare(k2, k2);
        }
        return super.v(k2);
    }

    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    private TreeMultimap(Comparator<? super K> comparator, Comparator<? super V> comparator2, Multimap<? extends K, ? extends V> multimap) {
        this(comparator, comparator2);
        Z(multimap);
    }
}
