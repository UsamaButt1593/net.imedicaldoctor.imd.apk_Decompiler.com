package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlin/sequences/DistinctSequence;", "T", "K", "Lkotlin/sequences/Sequence;", "source", "Lkotlin/Function1;", "keySelector", "<init>", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "", "iterator", "()Ljava/util/Iterator;", "a", "Lkotlin/sequences/Sequence;", "b", "Lkotlin/jvm/functions/Function1;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class DistinctSequence<T, K> implements Sequence<T> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Sequence<T> f28995a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Function1<T, K> f28996b;

    public DistinctSequence(@NotNull Sequence<? extends T> sequence, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.p(sequence, "source");
        Intrinsics.p(function1, "keySelector");
        this.f28995a = sequence;
        this.f28996b = function1;
    }

    @NotNull
    public Iterator<T> iterator() {
        return new DistinctIterator(this.f28995a.iterator(), this.f28996b);
    }
}
