package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\n_Collections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt$groupingBy$1\n*L\n1#1,3683:1\n*E\n"})
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0015\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"kotlin/collections/CollectionsKt___CollectionsKt$groupingBy$1", "Lkotlin/collections/Grouping;", "", "b", "()Ljava/util/Iterator;", "element", "a", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class CollectionsKt___CollectionsKt$groupingBy$1 implements Grouping<T, K> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Iterable<T> f28795a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Function1<T, K> f28796b;

    public CollectionsKt___CollectionsKt$groupingBy$1(Iterable<? extends T> iterable, Function1<? super T, ? extends K> function1) {
        this.f28795a = iterable;
        this.f28796b = function1;
    }

    public K a(T t) {
        return this.f28796b.f(t);
    }

    @NotNull
    public Iterator<T> b() {
        return this.f28795a.iterator();
    }
}
