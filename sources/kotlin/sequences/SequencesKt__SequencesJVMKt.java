package kotlin.sequences;

import java.util.Enumeration;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\b¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "Ljava/util/Enumeration;", "Lkotlin/sequences/Sequence;", "c", "(Ljava/util/Enumeration;)Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/sequences/SequencesKt")
class SequencesKt__SequencesJVMKt extends SequencesKt__SequenceBuilderKt {
    @InlineOnly
    private static final <T> Sequence<T> c(Enumeration<T> enumeration) {
        Intrinsics.p(enumeration, "<this>");
        return SequencesKt.e(CollectionsKt.c0(enumeration));
    }
}
