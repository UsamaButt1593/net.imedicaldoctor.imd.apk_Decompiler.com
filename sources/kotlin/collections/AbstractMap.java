package kotlin.collections;

import com.dd.plist.ASCIIPropertyListParser;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nAbstractMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractMap.kt\nkotlin/collections/AbstractMap\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,153:1\n1747#2,3:154\n1726#2,3:157\n288#2,2:160\n*S KotlinDebug\n*F\n+ 1 AbstractMap.kt\nkotlin/collections/AbstractMap\n*L\n28#1:154,3\n60#1:157,3\n141#1:160,2\n*E\n"})
@SinceKotlin(version = "1.1")
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u000e\b'\u0018\u0000 4*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003:\u00015B\t\b\u0004¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\b¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J!\u0010\u0017\u001a\u00020\u00122\u0010\u0010\u0007\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\u0014J\u001a\u0010\u001b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0012H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\bH\u0016¢\u0006\u0004\b\"\u0010#R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010(8\b@\bX\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u001fR\u001a\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000$8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00028\u00010(8VX\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00066"}, d2 = {"Lkotlin/collections/AbstractMap;", "K", "V", "", "<init>", "()V", "", "entry", "", "j", "(Ljava/util/Map$Entry;)Ljava/lang/String;", "", "o", "h", "(Ljava/lang/Object;)Ljava/lang/String;", "key", "g", "(Ljava/lang/Object;)Ljava/util/Map$Entry;", "", "containsKey", "(Ljava/lang/Object;)Z", "value", "containsValue", "b", "(Ljava/util/Map$Entry;)Z", "other", "equals", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "hashCode", "()I", "isEmpty", "()Z", "toString", "()Ljava/lang/String;", "", "s", "Ljava/util/Set;", "_keys", "", "X", "Ljava/util/Collection;", "_values", "e", "size", "d", "()Ljava/util/Set;", "keys", "f", "()Ljava/util/Collection;", "values", "Y", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public abstract class AbstractMap<K, V> implements Map<K, V>, KMappedMarker {
    @NotNull
    public static final Companion Y = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private volatile Collection<? extends V> X;
    @Nullable
    private volatile Set<? extends K> s;

    @SourceDebugExtension({"SMAP\nAbstractMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractMap.kt\nkotlin/collections/AbstractMap$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,153:1\n1#2:154\n*E\n"})
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\t2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlin/collections/AbstractMap$Companion;", "", "<init>", "()V", "", "e", "", "b", "(Ljava/util/Map$Entry;)I", "", "c", "(Ljava/util/Map$Entry;)Ljava/lang/String;", "other", "", "a", "(Ljava/util/Map$Entry;Ljava/lang/Object;)Z", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public final boolean a(@NotNull Map.Entry<?, ?> entry, @Nullable Object obj) {
            Intrinsics.p(entry, "e");
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry2 = (Map.Entry) obj;
            return Intrinsics.g(entry.getKey(), entry2.getKey()) && Intrinsics.g(entry.getValue(), entry2.getValue());
        }

        public final int b(@NotNull Map.Entry<?, ?> entry) {
            Intrinsics.p(entry, "e");
            Object key = entry.getKey();
            int i2 = 0;
            int hashCode = key != null ? key.hashCode() : 0;
            Object value = entry.getValue();
            if (value != null) {
                i2 = value.hashCode();
            }
            return hashCode ^ i2;
        }

        @NotNull
        public final String c(@NotNull Map.Entry<?, ?> entry) {
            Intrinsics.p(entry, "e");
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getKey());
            sb.append(ASCIIPropertyListParser.f18654l);
            sb.append(entry.getValue());
            return sb.toString();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    protected AbstractMap() {
    }

    private final Map.Entry<K, V> g(K k2) {
        Object obj;
        Iterator it2 = entrySet().iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (Intrinsics.g(((Map.Entry) obj).getKey(), k2)) {
                break;
            }
        }
        return (Map.Entry) obj;
    }

    private final String h(Object obj) {
        return obj == this ? "(this Map)" : String.valueOf(obj);
    }

    /* access modifiers changed from: private */
    public final String j(Map.Entry<? extends K, ? extends V> entry) {
        return h(entry.getKey()) + ASCIIPropertyListParser.f18654l + h(entry.getValue());
    }

    public final boolean b(@Nullable Map.Entry<?, ?> entry) {
        if (entry == null) {
            return false;
        }
        Object key = entry.getKey();
        Object value = entry.getValue();
        Intrinsics.n(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        Object obj = get(key);
        if (!Intrinsics.g(value, obj)) {
            return false;
        }
        if (obj != null) {
            return true;
        }
        Intrinsics.n(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.containsKey, *>");
        return containsKey(key);
    }

    public abstract Set c();

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsKey(Object obj) {
        return g(obj) != null;
    }

    public boolean containsValue(Object obj) {
        Set<Map.Entry> entrySet = entrySet();
        if ((entrySet instanceof Collection) && entrySet.isEmpty()) {
            return false;
        }
        for (Map.Entry value : entrySet) {
            if (Intrinsics.g(value.getValue(), obj)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public Set<K> d() {
        if (this.s == null) {
            this.s = new AbstractMap$keys$1(this);
        }
        Set<? extends K> set = this.s;
        Intrinsics.m(set);
        return set;
    }

    public int e() {
        return entrySet().size();
    }

    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return c();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        Set<Map.Entry> entrySet = map.entrySet();
        if ((entrySet instanceof Collection) && entrySet.isEmpty()) {
            return true;
        }
        for (Map.Entry b2 : entrySet) {
            if (!b(b2)) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public Collection<V> f() {
        if (this.X == null) {
            this.X = new AbstractMap$values$1(this);
        }
        Collection<? extends V> collection = this.X;
        Intrinsics.m(collection);
        return collection;
    }

    @Nullable
    public V get(Object obj) {
        Map.Entry g2 = g(obj);
        if (g2 != null) {
            return g2.getValue();
        }
        return null;
    }

    public int hashCode() {
        return entrySet().hashCode();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public final /* bridge */ Set<K> keySet() {
        return d();
    }

    public V put(K k2, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return e();
    }

    @NotNull
    public String toString() {
        return CollectionsKt.j3(entrySet(), ", ", "{", "}", 0, (CharSequence) null, new AbstractMap$toString$1(this), 24, (Object) null);
    }

    public final /* bridge */ Collection<V> values() {
        return f();
    }
}
