package kotlin.sequences;

import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "Lkotlin/collections/IndexedValue;", "it", "", "b", "(Lkotlin/collections/IndexedValue;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0})
final class SequencesKt___SequencesKt$filterIndexed$1 extends Lambda implements Function1<IndexedValue<? extends T>, Boolean> {
    final /* synthetic */ Function2<Integer, T, Boolean> X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$filterIndexed$1(Function2<? super Integer, ? super T, Boolean> function2) {
        super(1);
        this.X = function2;
    }

    @NotNull
    /* renamed from: b */
    public final Boolean f(@NotNull IndexedValue<? extends T> indexedValue) {
        Intrinsics.p(indexedValue, "it");
        return this.X.d0(Integer.valueOf(indexedValue.e()), indexedValue.f());
    }
}
