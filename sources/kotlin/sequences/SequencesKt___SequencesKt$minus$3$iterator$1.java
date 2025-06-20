package kotlin.sequences;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "it", "", "b", "(Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0})
final class SequencesKt___SequencesKt$minus$3$iterator$1 extends Lambda implements Function1<T, Boolean> {
    final /* synthetic */ Collection<T> X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$minus$3$iterator$1(Collection<? extends T> collection) {
        super(1);
        this.X = collection;
    }

    @NotNull
    /* renamed from: b */
    public final Boolean f(T t) {
        return Boolean.valueOf(this.X.contains(t));
    }
}
