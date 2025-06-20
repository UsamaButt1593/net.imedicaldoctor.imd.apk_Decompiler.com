package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00060\u0004j\u0002`\u0005B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\rJ\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8\u0002XT¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0010R(\u0010'\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030$0#8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001c\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020#8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010&R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030*8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006."}, d2 = {"Lkotlin/collections/EmptyMap;", "", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "<init>", "()V", "h", "()Ljava/lang/Object;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "isEmpty", "()Z", "key", "containsKey", "value", "a", "(Ljava/lang/Void;)Z", "b", "(Ljava/lang/Object;)Ljava/lang/Void;", "", "X", "J", "serialVersionUID", "e", "size", "", "", "c", "()Ljava/util/Set;", "entries", "d", "keys", "", "f", "()Ljava/util/Collection;", "values", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
final class EmptyMap implements Map, Serializable, KMappedMarker {
    private static final long X = 8246714829545688274L;
    @NotNull
    public static final EmptyMap s = new EmptyMap();

    private EmptyMap() {
    }

    private final Object h() {
        return s;
    }

    public boolean a(@NotNull Void voidR) {
        Intrinsics.p(voidR, "value");
        return false;
    }

    @Nullable
    /* renamed from: b */
    public Void get(@Nullable Object obj) {
        return null;
    }

    @NotNull
    public Set<Map.Entry> c() {
        return EmptySet.s;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsKey(@Nullable Object obj) {
        return false;
    }

    public final /* bridge */ boolean containsValue(Object obj) {
        if (!(obj instanceof Void)) {
            return false;
        }
        return a((Void) obj);
    }

    @NotNull
    public Set<Object> d() {
        return EmptySet.s;
    }

    public int e() {
        return 0;
    }

    public final /* bridge */ Set<Map.Entry> entrySet() {
        return c();
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    @NotNull
    public Collection f() {
        return EmptyList.s;
    }

    public Void g(Object obj, Void voidR) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    /* renamed from: j */
    public Void remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ Set<Object> keySet() {
        return d();
    }

    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return e();
    }

    @NotNull
    public String toString() {
        return "{}";
    }

    public final /* bridge */ Collection values() {
        return f();
    }
}
