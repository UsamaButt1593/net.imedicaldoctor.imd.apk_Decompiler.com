package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class MultimapBuilder<K0, V0> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f22461a = 8;

    private static final class ArrayListSupplier<V> implements Supplier<List<V>>, Serializable {
        private final int s;

        ArrayListSupplier(int i2) {
            this.s = CollectPreconditions.b(i2, "expectedValuesPerKey");
        }

        /* renamed from: a */
        public List<V> get() {
            return new ArrayList(this.s);
        }
    }

    private static final class EnumSetSupplier<V extends Enum<V>> implements Supplier<Set<V>>, Serializable {
        private final Class<V> s;

        EnumSetSupplier(Class<V> cls) {
            this.s = (Class) Preconditions.E(cls);
        }

        /* renamed from: a */
        public Set<V> get() {
            return EnumSet.noneOf(this.s);
        }
    }

    private static final class HashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
        private final int s;

        HashSetSupplier(int i2) {
            this.s = CollectPreconditions.b(i2, "expectedValuesPerKey");
        }

        /* renamed from: a */
        public Set<V> get() {
            return Platform.e(this.s);
        }
    }

    private static final class LinkedHashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
        private final int s;

        LinkedHashSetSupplier(int i2) {
            this.s = CollectPreconditions.b(i2, "expectedValuesPerKey");
        }

        /* renamed from: a */
        public Set<V> get() {
            return Platform.g(this.s);
        }
    }

    private enum LinkedListSupplier implements Supplier<List<?>> {
        INSTANCE;

        public static <V> Supplier<List<V>> c() {
            return INSTANCE;
        }

        /* renamed from: b */
        public List<?> get() {
            return new LinkedList();
        }
    }

    public static abstract class ListMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        ListMultimapBuilder() {
            super();
        }

        /* renamed from: j */
        public abstract <K extends K0, V extends V0> ListMultimap<K, V> a();

        /* renamed from: k */
        public <K extends K0, V extends V0> ListMultimap<K, V> b(Multimap<? extends K, ? extends V> multimap) {
            return (ListMultimap) MultimapBuilder.super.b(multimap);
        }
    }

    public static abstract class MultimapBuilderWithKeys<K0> {

        /* renamed from: a  reason: collision with root package name */
        private static final int f22466a = 2;

        MultimapBuilderWithKeys() {
        }

        public ListMultimapBuilder<K0, Object> a() {
            return b(2);
        }

        public ListMultimapBuilder<K0, Object> b(final int i2) {
            CollectPreconditions.b(i2, "expectedValuesPerKey");
            return new ListMultimapBuilder<K0, Object>() {
                /* renamed from: j */
                public <K extends K0, V> ListMultimap<K, V> a() {
                    return Multimaps.u(MultimapBuilderWithKeys.this.c(), new ArrayListSupplier(i2));
                }
            };
        }

        /* access modifiers changed from: package-private */
        public abstract <K extends K0, V> Map<K, Collection<V>> c();

        public <V0 extends Enum<V0>> SetMultimapBuilder<K0, V0> d(final Class<V0> cls) {
            Preconditions.F(cls, "valueClass");
            return new SetMultimapBuilder<K0, V0>() {
                /* renamed from: j */
                public <K extends K0, V extends V0> SetMultimap<K, V> a() {
                    return Multimaps.w(MultimapBuilderWithKeys.this.c(), new EnumSetSupplier(cls));
                }
            };
        }

        public SetMultimapBuilder<K0, Object> e() {
            return f(2);
        }

        public SetMultimapBuilder<K0, Object> f(final int i2) {
            CollectPreconditions.b(i2, "expectedValuesPerKey");
            return new SetMultimapBuilder<K0, Object>() {
                /* renamed from: j */
                public <K extends K0, V> SetMultimap<K, V> a() {
                    return Multimaps.w(MultimapBuilderWithKeys.this.c(), new HashSetSupplier(i2));
                }
            };
        }

        public SetMultimapBuilder<K0, Object> g() {
            return h(2);
        }

        public SetMultimapBuilder<K0, Object> h(final int i2) {
            CollectPreconditions.b(i2, "expectedValuesPerKey");
            return new SetMultimapBuilder<K0, Object>() {
                /* renamed from: j */
                public <K extends K0, V> SetMultimap<K, V> a() {
                    return Multimaps.w(MultimapBuilderWithKeys.this.c(), new LinkedHashSetSupplier(i2));
                }
            };
        }

        public ListMultimapBuilder<K0, Object> i() {
            return new ListMultimapBuilder<K0, Object>() {
                /* renamed from: j */
                public <K extends K0, V> ListMultimap<K, V> a() {
                    return Multimaps.u(MultimapBuilderWithKeys.this.c(), LinkedListSupplier.c());
                }
            };
        }

        public SortedSetMultimapBuilder<K0, Comparable> j() {
            return k(Ordering.z());
        }

        public <V0> SortedSetMultimapBuilder<K0, V0> k(final Comparator<V0> comparator) {
            Preconditions.F(comparator, "comparator");
            return new SortedSetMultimapBuilder<K0, V0>() {
                /* renamed from: l */
                public <K extends K0, V extends V0> SortedSetMultimap<K, V> j() {
                    return Multimaps.x(MultimapBuilderWithKeys.this.c(), new TreeSetSupplier(comparator));
                }
            };
        }
    }

    public static abstract class SetMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        SetMultimapBuilder() {
            super();
        }

        /* renamed from: j */
        public abstract <K extends K0, V extends V0> SetMultimap<K, V> a();

        /* renamed from: k */
        public <K extends K0, V extends V0> SetMultimap<K, V> b(Multimap<? extends K, ? extends V> multimap) {
            return (SetMultimap) MultimapBuilder.super.b(multimap);
        }
    }

    public static abstract class SortedSetMultimapBuilder<K0, V0> extends SetMultimapBuilder<K0, V0> {
        SortedSetMultimapBuilder() {
        }

        /* renamed from: l */
        public abstract <K extends K0, V extends V0> SortedSetMultimap<K, V> j();

        /* renamed from: m */
        public <K extends K0, V extends V0> SortedSetMultimap<K, V> k(Multimap<? extends K, ? extends V> multimap) {
            return (SortedSetMultimap) super.b(multimap);
        }
    }

    private static final class TreeSetSupplier<V> implements Supplier<SortedSet<V>>, Serializable {
        private final Comparator<? super V> s;

        TreeSetSupplier(Comparator<? super V> comparator) {
            this.s = (Comparator) Preconditions.E(comparator);
        }

        /* renamed from: a */
        public SortedSet<V> get() {
            return new TreeSet(this.s);
        }
    }

    private MultimapBuilder() {
    }

    public static <K0 extends Enum<K0>> MultimapBuilderWithKeys<K0> c(final Class<K0> cls) {
        Preconditions.E(cls);
        return new MultimapBuilderWithKeys<K0>() {
            /* access modifiers changed from: package-private */
            public <K extends K0, V> Map<K, Collection<V>> c() {
                return new EnumMap(cls);
            }
        };
    }

    public static MultimapBuilderWithKeys<Object> d() {
        return e(8);
    }

    public static MultimapBuilderWithKeys<Object> e(final int i2) {
        CollectPreconditions.b(i2, "expectedKeys");
        return new MultimapBuilderWithKeys<Object>() {
            /* access modifiers changed from: package-private */
            public <K, V> Map<K, Collection<V>> c() {
                return Platform.d(i2);
            }
        };
    }

    public static MultimapBuilderWithKeys<Object> f() {
        return g(8);
    }

    public static MultimapBuilderWithKeys<Object> g(final int i2) {
        CollectPreconditions.b(i2, "expectedKeys");
        return new MultimapBuilderWithKeys<Object>() {
            /* access modifiers changed from: package-private */
            public <K, V> Map<K, Collection<V>> c() {
                return Platform.f(i2);
            }
        };
    }

    public static MultimapBuilderWithKeys<Comparable> h() {
        return i(Ordering.z());
    }

    public static <K0> MultimapBuilderWithKeys<K0> i(final Comparator<K0> comparator) {
        Preconditions.E(comparator);
        return new MultimapBuilderWithKeys<K0>() {
            /* access modifiers changed from: package-private */
            public <K extends K0, V> Map<K, Collection<V>> c() {
                return new TreeMap(comparator);
            }
        };
    }

    public abstract <K extends K0, V extends V0> Multimap<K, V> a();

    public <K extends K0, V extends V0> Multimap<K, V> b(Multimap<? extends K, ? extends V> multimap) {
        Multimap<K, V> a2 = a();
        a2.Z(multimap);
        return a2;
    }
}
