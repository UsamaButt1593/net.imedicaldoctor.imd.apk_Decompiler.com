package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n*L\n1#1,70:1\n*E\n"})
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¨\u0006\u0004"}, d2 = {"kotlin/collections/CollectionsKt__IterablesKt$Iterable$1", "", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 176)
public final class CollectionsKt__IterablesKt$Iterable$1 implements Iterable<T>, KMappedMarker {
    final /* synthetic */ Function0<Iterator<T>> s;

    public CollectionsKt__IterablesKt$Iterable$1(Function0<? extends Iterator<? extends T>> function0) {
        this.s = function0;
    }

    @NotNull
    public Iterator<T> iterator() {
        return this.s.o();
    }
}
