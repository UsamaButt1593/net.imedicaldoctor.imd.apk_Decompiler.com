package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0004\u001a\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001aK\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\u0007\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0000¢\u0006\u0004\b\f\u0010\r\u001aO\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\u000e\"\u0004\b\u0000\u0010\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"", "size", "step", "", "a", "(II)V", "T", "Lkotlin/sequences/Sequence;", "", "partialWindows", "reuseBuffer", "", "c", "(Lkotlin/sequences/Sequence;IIZZ)Lkotlin/sequences/Sequence;", "", "iterator", "b", "(Ljava/util/Iterator;IIZZ)Ljava/util/Iterator;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class SlidingWindowKt {
    public static final void a(int i2, int i3) {
        String str;
        if (i2 <= 0 || i3 <= 0) {
            if (i2 != i3) {
                str = "Both size " + i2 + " and step " + i3 + " must be greater than zero.";
            } else {
                str = "size " + i2 + " must be greater than zero.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }

    @NotNull
    public static final <T> Iterator<List<T>> b(@NotNull Iterator<? extends T> it2, int i2, int i3, boolean z, boolean z2) {
        Intrinsics.p(it2, "iterator");
        return !it2.hasNext() ? EmptyIterator.s : SequencesKt.a(new SlidingWindowKt$windowedIterator$1(i2, i3, it2, z2, z, (Continuation<? super SlidingWindowKt$windowedIterator$1>) null));
    }

    @NotNull
    public static final <T> Sequence<List<T>> c(@NotNull Sequence<? extends T> sequence, int i2, int i3, boolean z, boolean z2) {
        Intrinsics.p(sequence, "<this>");
        a(i2, i3);
        return new SlidingWindowKt$windowedSequence$$inlined$Sequence$1(sequence, i2, i3, z, z2);
    }
}
