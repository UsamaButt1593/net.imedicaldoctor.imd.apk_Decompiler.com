package kotlin.sequences;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "element", "b", "(ILjava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0})
final class SequencesKt___SequencesKt$onEachIndexed$1 extends Lambda implements Function2<Integer, T, T> {
    final /* synthetic */ Function2<Integer, T, Unit> X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$onEachIndexed$1(Function2<? super Integer, ? super T, Unit> function2) {
        super(2);
        this.X = function2;
    }

    public final T b(int i2, T t) {
        this.X.d0(Integer.valueOf(i2), t);
        return t;
    }

    public /* bridge */ /* synthetic */ Object d0(Object obj, Object obj2) {
        return b(((Number) obj).intValue(), obj2);
    }
}
