package androidx.core.util;

import android.util.LruCache;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LruCache.kt\nandroidx/core/util/LruCacheKt$lruCache$4\n*L\n1#1,54:1\n*E\n"})
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0004J/\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u00012\b\u0010\n\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010\u000bJ\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/util/LruCacheKt$lruCache$4", "Landroid/util/LruCache;", "create", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "sizeOf", "", "value", "(Ljava/lang/Object;Ljava/lang/Object;)I", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 176)
public final class LruCacheKt$lruCache$4 extends LruCache<K, V> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function2<K, V, Integer> f6293a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Function1<K, V> f6294b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Function4<Boolean, K, V, V, Unit> f6295c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LruCacheKt$lruCache$4(int i2, Function2<? super K, ? super V, Integer> function2, Function1<? super K, ? extends V> function1, Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> function4) {
        super(i2);
        this.f6293a = function2;
        this.f6294b = function1;
        this.f6295c = function4;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public V create(@NotNull K k2) {
        return this.f6294b.f(k2);
    }

    /* access modifiers changed from: protected */
    public void entryRemoved(boolean z, @NotNull K k2, @NotNull V v, @Nullable V v2) {
        this.f6295c.O(Boolean.valueOf(z), k2, v, v2);
    }

    /* access modifiers changed from: protected */
    public int sizeOf(@NotNull K k2, @NotNull V v) {
        return this.f6293a.d0(k2, v).intValue();
    }
}
