package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¨\u0006\u0004"}, d2 = {"kotlin/sequences/SequencesKt___SequencesKt$minus$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SequencesKt___SequencesKt$minus$1 implements Sequence<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Sequence<T> f29025a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ T f29026b;

    SequencesKt___SequencesKt$minus$1(Sequence<? extends T> sequence, T t) {
        this.f29025a = sequence;
        this.f29026b = t;
    }

    @NotNull
    public Iterator<T> iterator() {
        return SequencesKt.p0(this.f29025a, new SequencesKt___SequencesKt$minus$1$iterator$1(new Ref.BooleanRef(), this.f29026b)).iterator();
    }
}
