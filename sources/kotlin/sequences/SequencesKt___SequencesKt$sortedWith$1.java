package kotlin.sequences;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¨\u0006\u0004"}, d2 = {"kotlin/sequences/SequencesKt___SequencesKt$sortedWith$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SequencesKt___SequencesKt$sortedWith$1 implements Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Sequence<T> f29034a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Comparator<? super T> f29035b;

    SequencesKt___SequencesKt$sortedWith$1(Sequence<? extends T> sequence, Comparator<? super T> comparator) {
        this.f29034a = sequence;
        this.f29035b = comparator;
    }

    @NotNull
    public Iterator<T> iterator() {
        List<T> d3 = SequencesKt___SequencesKt.d3(this.f29034a);
        CollectionsKt.m0(d3, this.f29035b);
        return d3.iterator();
    }
}
