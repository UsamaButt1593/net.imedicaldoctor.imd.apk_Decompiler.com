package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$2\n*L\n1#1,328:1\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "T", "K", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 9, 0}, xi = 176)
public final class ComparisonsKt__ComparisonsKt$thenByDescending$2<T> implements Comparator {
    final /* synthetic */ Comparator<? super K> X;
    final /* synthetic */ Function1<T, K> Y;
    final /* synthetic */ Comparator<T> s;

    public ComparisonsKt__ComparisonsKt$thenByDescending$2(Comparator<T> comparator, Comparator<? super K> comparator2, Function1<? super T, ? extends K> function1) {
        this.s = comparator;
        this.X = comparator2;
        this.Y = function1;
    }

    public final int compare(T t, T t2) {
        int compare = this.s.compare(t, t2);
        if (compare != 0) {
            return compare;
        }
        Comparator<? super K> comparator = this.X;
        Function1<T, K> function1 = this.Y;
        return comparator.compare(function1.f(t2), function1.f(t));
    }
}
