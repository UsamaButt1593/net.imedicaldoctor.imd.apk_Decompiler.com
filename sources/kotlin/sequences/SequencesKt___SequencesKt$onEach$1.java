package kotlin.sequences;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "it", "f", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0})
final class SequencesKt___SequencesKt$onEach$1 extends Lambda implements Function1<T, T> {
    final /* synthetic */ Function1<T, Unit> X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$onEach$1(Function1<? super T, Unit> function1) {
        super(1);
        this.X = function1;
    }

    public final T f(T t) {
        this.X.f(t);
        return t;
    }
}
