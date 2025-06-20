package kotlin.sequences;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "R", "t1", "t2", "Lkotlin/Pair;", "b", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;"}, k = 3, mv = {1, 9, 0})
final class SequencesKt___SequencesKt$zip$1 extends Lambda implements Function2<T, R, Pair<? extends T, ? extends R>> {
    public static final SequencesKt___SequencesKt$zip$1 X = new SequencesKt___SequencesKt$zip$1();

    SequencesKt___SequencesKt$zip$1() {
        super(2);
    }

    @NotNull
    /* renamed from: b */
    public final Pair<T, R> d0(T t, R r) {
        return TuplesKt.a(t, r);
    }
}
