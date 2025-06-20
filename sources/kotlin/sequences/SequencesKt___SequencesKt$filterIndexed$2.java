package kotlin.sequences;

import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlin/collections/IndexedValue;", "it", "b", "(Lkotlin/collections/IndexedValue;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0})
final class SequencesKt___SequencesKt$filterIndexed$2 extends Lambda implements Function1<IndexedValue<? extends T>, T> {
    public static final SequencesKt___SequencesKt$filterIndexed$2 X = new SequencesKt___SequencesKt$filterIndexed$2();

    SequencesKt___SequencesKt$filterIndexed$2() {
        super(1);
    }

    /* renamed from: b */
    public final T f(@NotNull IndexedValue<? extends T> indexedValue) {
        Intrinsics.p(indexedValue, "it");
        return indexedValue.f();
    }
}
