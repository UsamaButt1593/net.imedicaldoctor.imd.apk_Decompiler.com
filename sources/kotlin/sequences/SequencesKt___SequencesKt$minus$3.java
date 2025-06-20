package kotlin.sequences;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¨\u0006\u0004"}, d2 = {"kotlin/sequences/SequencesKt___SequencesKt$minus$3", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SequencesKt___SequencesKt$minus$3 implements Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Iterable<T> f29029a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Sequence<T> f29030b;

    SequencesKt___SequencesKt$minus$3(Iterable<? extends T> iterable, Sequence<? extends T> sequence) {
        this.f29029a = iterable;
        this.f29030b = sequence;
    }

    @NotNull
    public Iterator<T> iterator() {
        Collection<T> q0 = CollectionsKt.q0(this.f29029a);
        return (q0.isEmpty() ? this.f29030b : SequencesKt___SequencesKt.u0(this.f29030b, new SequencesKt___SequencesKt$minus$3$iterator$1(q0))).iterator();
    }
}
