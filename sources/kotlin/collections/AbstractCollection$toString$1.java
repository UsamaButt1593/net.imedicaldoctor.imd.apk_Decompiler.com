package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0006\b\u0000\u0010\u0000 \u00012\u0006\u0010\u0001\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"E", "it", "", "b", "(Ljava/lang/Object;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 9, 0})
final class AbstractCollection$toString$1 extends Lambda implements Function1<E, CharSequence> {
    final /* synthetic */ AbstractCollection<E> X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractCollection$toString$1(AbstractCollection<? extends E> abstractCollection) {
        super(1);
        this.X = abstractCollection;
    }

    @NotNull
    /* renamed from: b */
    public final CharSequence f(E e2) {
        return e2 == this.X ? "(this Collection)" : String.valueOf(e2);
    }
}
