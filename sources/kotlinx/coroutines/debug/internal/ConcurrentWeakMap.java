package kotlinx.coroutines.debug.internal;

import com.google.common.util.concurrent.I;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u0006\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0003()*B\u0011\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\f\u001a\u00028\u00002\b\u0010\r\u001a\u0004\u0018\u00018\u0001H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\u00020\t2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0014\u001a\u0004\u0018\u00018\u00012\u0006\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0016\u001a\u0004\u0018\u00018\u00012\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0016\u0010\u000fJ\u0019\u0010\u0017\u001a\u0004\u0018\u00018\u00012\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0018\u0010\u000bJ\r\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u000bR\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000!8VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R&\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010%0!8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010#¨\u0006+"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "", "K", "V", "Lkotlin/collections/AbstractMutableMap;", "", "weakRefQueue", "<init>", "(Z)V", "", "h", "()V", "key", "value", "j", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "w", "g", "(Lkotlinx/coroutines/debug/internal/HashedWeakRef;)V", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "remove", "clear", "k", "Ljava/lang/ref/ReferenceQueue;", "s", "Ljava/lang/ref/ReferenceQueue;", "", "c", "()I", "size", "", "b", "()Ljava/util/Set;", "keys", "", "a", "entries", "Core", "Entry", "KeyValueSet", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class ConcurrentWeakMap<K, V> extends AbstractMutableMap<K, V> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater X = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");
    @NotNull
    private volatile /* synthetic */ int _size;
    @NotNull
    volatile /* synthetic */ Object core;
    /* access modifiers changed from: private */
    @Nullable
    public final ReferenceQueue<K> s;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00028\u00002\b\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\u00120\u0000R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\n2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ3\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00020\u001e\"\u0004\b\u0002\u0010\u001b2\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u001c¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\"R\u0014\u0010$\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\"¨\u0006&"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "", "", "allocated", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;I)V", "hash", "d", "(I)I", "index", "", "i", "(I)V", "key", "c", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "Lkotlinx/coroutines/debug/internal/HashedWeakRef;", "weakKey0", "f", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlinx/coroutines/debug/internal/HashedWeakRef;)Ljava/lang/Object;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "h", "()Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;", "weakRef", "b", "(Lkotlinx/coroutines/debug/internal/HashedWeakRef;)V", "E", "Lkotlin/Function2;", "factory", "", "e", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "a", "I", "shift", "threshold", "KeyValueIterator", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private final class Core {

        /* renamed from: g  reason: collision with root package name */
        private static final /* synthetic */ AtomicIntegerFieldUpdater f29257g = AtomicIntegerFieldUpdater.newUpdater(Core.class, "load");
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f29258a;

        /* renamed from: b  reason: collision with root package name */
        private final int f29259b;

        /* renamed from: c  reason: collision with root package name */
        private final int f29260c;
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        /* synthetic */ AtomicReferenceArray f29261d;
        @NotNull

        /* renamed from: e  reason: collision with root package name */
        /* synthetic */ AtomicReferenceArray f29262e;
        @NotNull
        private volatile /* synthetic */ int load = 0;

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B!\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00028\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R&\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00028\u00008\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00028\u00018\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core$KeyValueIterator;", "E", "", "Lkotlin/Function2;", "factory", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Core;Lkotlin/jvm/functions/Function2;)V", "", "a", "()V", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "", "b", "()Ljava/lang/Void;", "s", "Lkotlin/jvm/functions/Function2;", "", "X", "I", "index", "Y", "Ljava/lang/Object;", "key", "Z", "value", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
        private final class KeyValueIterator<E> implements Iterator<E>, KMutableIterator {
            private int X = -1;
            private K Y;
            private V Z;
            @NotNull
            private final Function2<K, V, E> s;

            public KeyValueIterator(@NotNull Function2<? super K, ? super V, ? extends E> function2) {
                this.s = function2;
                a();
            }

            private final void a() {
                K k2;
                while (true) {
                    int i2 = this.X + 1;
                    this.X = i2;
                    if (i2 < Core.this.f29258a) {
                        HashedWeakRef hashedWeakRef = (HashedWeakRef) Core.this.f29261d.get(this.X);
                        if (!(hashedWeakRef == null || (k2 = hashedWeakRef.get()) == null)) {
                            this.Y = k2;
                            V v = Core.this.f29262e.get(this.X);
                            if (v instanceof Marked) {
                                v = ((Marked) v).f29299a;
                            }
                            if (v != null) {
                                this.Z = v;
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }

            @NotNull
            /* renamed from: b */
            public Void remove() {
                Void unused = ConcurrentWeakMapKt.e();
                throw new KotlinNothingValueException();
            }

            public boolean hasNext() {
                return this.X < Core.this.f29258a;
            }

            public E next() {
                if (this.X < Core.this.f29258a) {
                    Function2<K, V, E> function2 = this.s;
                    K k2 = this.Y;
                    if (k2 == null) {
                        Intrinsics.S("key");
                        k2 = Unit.f28779a;
                    }
                    V v = this.Z;
                    if (v == null) {
                        Intrinsics.S("value");
                        v = Unit.f28779a;
                    }
                    E d0 = function2.d0(k2, v);
                    a();
                    return d0;
                }
                throw new NoSuchElementException();
            }
        }

        public Core(int i2) {
            this.f29258a = i2;
            this.f29259b = Integer.numberOfLeadingZeros(i2) + 1;
            this.f29260c = (i2 * 2) / 3;
            this.f29261d = new AtomicReferenceArray(i2);
            this.f29262e = new AtomicReferenceArray(i2);
        }

        private final int d(int i2) {
            return (i2 * -1640531527) >>> this.f29259b;
        }

        public static /* synthetic */ Object g(Core core, Object obj, Object obj2, HashedWeakRef hashedWeakRef, int i2, Object obj3) {
            if ((i2 & 4) != 0) {
                hashedWeakRef = null;
            }
            return core.f(obj, obj2, hashedWeakRef);
        }

        private final void i(int i2) {
            Object obj;
            do {
                obj = this.f29262e.get(i2);
                if (obj == null || (obj instanceof Marked)) {
                    return;
                }
            } while (!I.a(this.f29262e, i2, obj, (Object) null));
            ConcurrentWeakMap.this.h();
        }

        public final void b(@NotNull HashedWeakRef<?> hashedWeakRef) {
            int d2 = d(hashedWeakRef.f29298a);
            while (true) {
                HashedWeakRef<?> hashedWeakRef2 = (HashedWeakRef) this.f29261d.get(d2);
                if (hashedWeakRef2 != null) {
                    if (hashedWeakRef2 == hashedWeakRef) {
                        i(d2);
                        return;
                    }
                    if (d2 == 0) {
                        d2 = this.f29258a;
                    }
                    d2--;
                } else {
                    return;
                }
            }
        }

        @Nullable
        public final V c(@NotNull K k2) {
            int d2 = d(k2.hashCode());
            while (true) {
                HashedWeakRef hashedWeakRef = (HashedWeakRef) this.f29261d.get(d2);
                if (hashedWeakRef == null) {
                    return null;
                }
                Object obj = hashedWeakRef.get();
                if (Intrinsics.g(k2, obj)) {
                    V v = this.f29262e.get(d2);
                    return v instanceof Marked ? ((Marked) v).f29299a : v;
                }
                if (obj == null) {
                    i(d2);
                }
                if (d2 == 0) {
                    d2 = this.f29258a;
                }
                d2--;
            }
        }

        @NotNull
        public final <E> Iterator<E> e(@NotNull Function2<? super K, ? super V, ? extends E> function2) {
            return new KeyValueIterator(function2);
        }

        @Nullable
        public final Object f(@NotNull K k2, @Nullable V v, @Nullable HashedWeakRef<K> hashedWeakRef) {
            Object obj;
            int i2;
            int d2 = d(k2.hashCode());
            boolean z = false;
            while (true) {
                HashedWeakRef hashedWeakRef2 = (HashedWeakRef) this.f29261d.get(d2);
                if (hashedWeakRef2 == null) {
                    if (v != null) {
                        if (!z) {
                            do {
                                i2 = this.load;
                                if (i2 >= this.f29260c) {
                                    return ConcurrentWeakMapKt.f29266c;
                                }
                            } while (!f29257g.compareAndSet(this, i2, i2 + 1));
                            z = true;
                        }
                        if (hashedWeakRef == null) {
                            hashedWeakRef = new HashedWeakRef<>(k2, ConcurrentWeakMap.this.s);
                        }
                        if (I.a(this.f29261d, d2, (Object) null, hashedWeakRef)) {
                            break;
                        }
                    } else {
                        return null;
                    }
                } else {
                    Object obj2 = hashedWeakRef2.get();
                    if (!Intrinsics.g(k2, obj2)) {
                        if (obj2 == null) {
                            i(d2);
                        }
                        if (d2 == 0) {
                            d2 = this.f29258a;
                        }
                        d2--;
                    } else if (z) {
                        f29257g.decrementAndGet(this);
                    }
                }
            }
            do {
                obj = this.f29262e.get(d2);
                if (obj instanceof Marked) {
                    return ConcurrentWeakMapKt.f29266c;
                }
            } while (!I.a(this.f29262e, d2, obj, v));
            return obj;
        }

        @NotNull
        public final ConcurrentWeakMap<K, V>.Core h() {
            Object obj;
            while (true) {
                ConcurrentWeakMap<K, V>.Core core = new Core(Integer.highestOneBit(RangesKt.u(ConcurrentWeakMap.this.size(), 4)) * 4);
                int i2 = this.f29258a;
                int i3 = 0;
                while (true) {
                    if (i3 >= i2) {
                        return core;
                    }
                    HashedWeakRef hashedWeakRef = (HashedWeakRef) this.f29261d.get(i3);
                    Object obj2 = hashedWeakRef != null ? hashedWeakRef.get() : null;
                    if (hashedWeakRef != null && obj2 == null) {
                        i(i3);
                    }
                    while (true) {
                        obj = this.f29262e.get(i3);
                        if (!(obj instanceof Marked)) {
                            if (I.a(this.f29262e, i3, obj, ConcurrentWeakMapKt.d(obj))) {
                                break;
                            }
                        } else {
                            obj = ((Marked) obj).f29299a;
                            break;
                        }
                    }
                    if (obj2 == null || obj == null || core.f(obj2, obj, hashedWeakRef) != ConcurrentWeakMapKt.f29266c) {
                        i3++;
                    }
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\b\u000e\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\u0006\u0010\u0005\u001a\u00028\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00028\u00032\u0006\u0010\b\u001a\u00028\u0003H\u0016¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00028\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u00028\u00038\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$Entry;", "K", "V", "", "key", "value", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "s", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "X", "getValue", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class Entry<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        private final V X;
        private final K s;

        public Entry(K k2, V v) {
            this.s = k2;
            this.X = v;
        }

        public K getKey() {
            return this.s;
        }

        public V getValue() {
            return this.X;
        }

        public V setValue(V v) {
            Void unused = ConcurrentWeakMapKt.e();
            throw new KotlinNothingValueException();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B!\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rR&\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap$KeyValueSet;", "E", "Lkotlin/collections/AbstractMutableSet;", "Lkotlin/Function2;", "factory", "<init>", "(Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;Lkotlin/jvm/functions/Function2;)V", "element", "", "add", "(Ljava/lang/Object;)Z", "", "iterator", "()Ljava/util/Iterator;", "s", "Lkotlin/jvm/functions/Function2;", "", "b", "()I", "size", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private final class KeyValueSet<E> extends AbstractMutableSet<E> {
        @NotNull
        private final Function2<K, V, E> s;

        public KeyValueSet(@NotNull Function2<? super K, ? super V, ? extends E> function2) {
            this.s = function2;
        }

        public boolean add(E e2) {
            Void unused = ConcurrentWeakMapKt.e();
            throw new KotlinNothingValueException();
        }

        public int b() {
            return ConcurrentWeakMap.this.size();
        }

        @NotNull
        public Iterator<E> iterator() {
            return ((Core) ConcurrentWeakMap.this.core).e(this.s);
        }
    }

    public ConcurrentWeakMap() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    private final void g(HashedWeakRef<?> hashedWeakRef) {
        ((Core) this.core).b(hashedWeakRef);
    }

    /* access modifiers changed from: private */
    public final void h() {
        X.decrementAndGet(this);
    }

    private final synchronized V j(K k2, V v) {
        V g2;
        ConcurrentWeakMap<K, V>.Core core2 = (Core) this.core;
        while (true) {
            g2 = Core.g(core2, k2, v, (HashedWeakRef) null, 4, (Object) null);
            if (g2 == ConcurrentWeakMapKt.f29266c) {
                core2 = core2.h();
                this.core = core2;
            }
        }
        return g2;
    }

    @NotNull
    public Set<Map.Entry<K, V>> a() {
        return new KeyValueSet(ConcurrentWeakMap$entries$1.X);
    }

    @NotNull
    public Set<K> b() {
        return new KeyValueSet(ConcurrentWeakMap$keys$1.X);
    }

    public int c() {
        return this._size;
    }

    public void clear() {
        for (Object remove : keySet()) {
            remove(remove);
        }
    }

    @Nullable
    public V get(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        return ((Core) this.core).c(obj);
    }

    public final void k() {
        if (this.s != null) {
            while (true) {
                try {
                    Reference<? extends K> remove = this.s.remove();
                    if (remove != null) {
                        g((HashedWeakRef) remove);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
        }
    }

    @Nullable
    public V put(@NotNull K k2, @NotNull V v) {
        V g2 = Core.g((Core) this.core, k2, v, (HashedWeakRef) null, 4, (Object) null);
        if (g2 == ConcurrentWeakMapKt.f29266c) {
            g2 = j(k2, v);
        }
        if (g2 == null) {
            X.incrementAndGet(this);
        }
        return g2;
    }

    @Nullable
    public V remove(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        V g2 = Core.g((Core) this.core, obj, (Object) null, (HashedWeakRef) null, 4, (Object) null);
        if (g2 == ConcurrentWeakMapKt.f29266c) {
            g2 = j(obj, (Object) null);
        }
        if (g2 != null) {
            X.decrementAndGet(this);
        }
        return g2;
    }

    public ConcurrentWeakMap(boolean z) {
        this._size = 0;
        this.core = new Core(16);
        this.s = z ? new ReferenceQueue<>() : null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConcurrentWeakMap(boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z);
    }
}
