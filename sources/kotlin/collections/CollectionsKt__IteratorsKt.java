package kotlin.collections;

import com.itextpdf.text.Annotation;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003\u001a)\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0005\u0010\u0003\u001a7\u0010\t\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000b"}, d2 = {"T", "", "e0", "(Ljava/util/Iterator;)Ljava/util/Iterator;", "Lkotlin/collections/IndexedValue;", "f0", "Lkotlin/Function1;", "", "operation", "d0", "(Ljava/util/Iterator;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__IteratorsKt extends CollectionsKt__IteratorsJVMKt {
    public static final <T> void d0(@NotNull Iterator<? extends T> it2, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.p(it2, "<this>");
        Intrinsics.p(function1, Annotation.q3);
        while (it2.hasNext()) {
            function1.f(it2.next());
        }
    }

    @InlineOnly
    private static final <T> Iterator<T> e0(Iterator<? extends T> it2) {
        Intrinsics.p(it2, "<this>");
        return it2;
    }

    @NotNull
    public static final <T> Iterator<IndexedValue<T>> f0(@NotNull Iterator<? extends T> it2) {
        Intrinsics.p(it2, "<this>");
        return new IndexingIterator(it2);
    }
}
