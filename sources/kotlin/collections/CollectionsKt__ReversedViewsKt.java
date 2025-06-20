package kotlin.collections;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0002\u001a\u001f\u0010\u0003\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u001f\u0010\u0006\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0004\u001a#\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\b\u0010\t\u001a%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\nH\u0007¢\u0006\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"", "", "index", "Z0", "(Ljava/util/List;I)I", "b1", "a1", "T", "X0", "(Ljava/util/List;)Ljava/util/List;", "", "Y0", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__ReversedViewsKt extends CollectionsKt__MutableCollectionsKt {
    @NotNull
    public static final <T> List<T> X0(@NotNull List<? extends T> list) {
        Intrinsics.p(list, "<this>");
        return new ReversedListReadOnly(list);
    }

    @NotNull
    @JvmName(name = "asReversedMutable")
    public static final <T> List<T> Y0(@NotNull List<T> list) {
        Intrinsics.p(list, "<this>");
        return new ReversedList(list);
    }

    /* access modifiers changed from: private */
    public static final int Z0(List<?> list, int i2) {
        if (new IntRange(0, CollectionsKt.G(list)).q(i2)) {
            return CollectionsKt.G(list) - i2;
        }
        throw new IndexOutOfBoundsException("Element index " + i2 + " must be in range [" + new IntRange(0, CollectionsKt.G(list)) + "].");
    }

    /* access modifiers changed from: private */
    public static final int a1(List<?> list, int i2) {
        return CollectionsKt.G(list) - i2;
    }

    /* access modifiers changed from: private */
    public static final int b1(List<?> list, int i2) {
        if (new IntRange(0, list.size()).q(i2)) {
            return list.size() - i2;
        }
        throw new IndexOutOfBoundsException("Position index " + i2 + " must be in range [" + new IntRange(0, list.size()) + "].");
    }
}
