package kotlin.sequences;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lkotlin/sequences/DropTakeSequence;", "T", "Lkotlin/sequences/Sequence;", "", "n", "b", "(I)Lkotlin/sequences/Sequence;", "a", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public interface DropTakeSequence<T> extends Sequence<T> {
    @NotNull
    Sequence<T> a(int i2);

    @NotNull
    Sequence<T> b(int i2);
}
