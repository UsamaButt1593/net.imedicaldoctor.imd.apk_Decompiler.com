package kotlin.collections;

import com.itextpdf.tool.xml.html.HTML;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nMapWithDefault.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MutableMapWithDefaultImpl\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,104:1\n341#2,6:105\n*S KotlinDebug\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MutableMapWithDefaultImpl\n*L\n101#1:105,6\n*E\n"})
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B>\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001a\u0010\u0011J\u0017\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001c\u0010\u0011J\u001a\u0010\u001d\u001a\u0004\u0018\u00018\u00012\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u001f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010!\u001a\u0004\u0018\u00018\u00012\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0004\b!\u0010\u001eJ%\u0010%\u001a\u00020$2\u0014\u0010#\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020$H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00028\u00012\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0004\b)\u0010\u001eR&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R/\u0010\n\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00010\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0014R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00028\u0000028VX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00028\u0001068VX\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R&\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010:028VX\u0004¢\u0006\u0006\u001a\u0004\b;\u00104¨\u0006="}, d2 = {"Lkotlin/collections/MutableMapWithDefaultImpl;", "K", "V", "Lkotlin/collections/MutableMapWithDefault;", "", "map", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "key", "default", "<init>", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "isEmpty", "()Z", "containsKey", "value", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "", "from", "", "putAll", "(Ljava/util/Map;)V", "clear", "()V", "q0", "s", "Ljava/util/Map;", "x", "()Ljava/util/Map;", "X", "Lkotlin/jvm/functions/Function1;", "c", "size", "", "b", "()Ljava/util/Set;", "keys", "", "d", "()Ljava/util/Collection;", "values", "", "a", "entries", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
final class MutableMapWithDefaultImpl<K, V> implements MutableMapWithDefault<K, V> {
    @NotNull
    private final Function1<K, V> X;
    @NotNull
    private final Map<K, V> s;

    public MutableMapWithDefaultImpl(@NotNull Map<K, V> map, @NotNull Function1<? super K, ? extends V> function1) {
        Intrinsics.p(map, HTML.Tag.t0);
        Intrinsics.p(function1, CookiePolicy.DEFAULT);
        this.s = map;
        this.X = function1;
    }

    @NotNull
    public Set<Map.Entry<K, V>> a() {
        return x().entrySet();
    }

    @NotNull
    public Set<K> b() {
        return x().keySet();
    }

    public int c() {
        return x().size();
    }

    public void clear() {
        x().clear();
    }

    public boolean containsKey(Object obj) {
        return x().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return x().containsValue(obj);
    }

    @NotNull
    public Collection<V> d() {
        return x().values();
    }

    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return a();
    }

    public boolean equals(@Nullable Object obj) {
        return x().equals(obj);
    }

    @Nullable
    public V get(Object obj) {
        return x().get(obj);
    }

    public int hashCode() {
        return x().hashCode();
    }

    public boolean isEmpty() {
        return x().isEmpty();
    }

    public final /* bridge */ Set<K> keySet() {
        return b();
    }

    @Nullable
    public V put(K k2, V v) {
        return x().put(k2, v);
    }

    public void putAll(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.p(map, "from");
        x().putAll(map);
    }

    public V q0(K k2) {
        Map x = x();
        V v = x.get(k2);
        return (v != null || x.containsKey(k2)) ? v : this.X.f(k2);
    }

    @Nullable
    public V remove(Object obj) {
        return x().remove(obj);
    }

    public final /* bridge */ int size() {
        return c();
    }

    @NotNull
    public String toString() {
        return x().toString();
    }

    public final /* bridge */ Collection<V> values() {
        return d();
    }

    @NotNull
    public Map<K, V> x() {
        return this.s;
    }
}
