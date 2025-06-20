package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.lang3.ClassUtils;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0003\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "", "it", "b", "(I)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0})
final class CollectionsKt___CollectionsKt$elementAt$1 extends Lambda implements Function1<Integer, T> {
    final /* synthetic */ int X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CollectionsKt___CollectionsKt$elementAt$1(int i2) {
        super(1);
        this.X = i2;
    }

    public final T b(int i2) {
        throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + this.X + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    public /* bridge */ /* synthetic */ Object f(Object obj) {
        return b(((Number) obj).intValue());
    }
}
