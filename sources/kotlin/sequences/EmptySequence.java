package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.EmptyIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lkotlin/sequences/EmptySequence;", "Lkotlin/sequences/Sequence;", "", "Lkotlin/sequences/DropTakeSequence;", "<init>", "()V", "", "iterator", "()Ljava/util/Iterator;", "", "n", "c", "(I)Lkotlin/sequences/EmptySequence;", "d", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
final class EmptySequence implements Sequence, DropTakeSequence {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final EmptySequence f29001a = new EmptySequence();

    private EmptySequence() {
    }

    @NotNull
    /* renamed from: c */
    public EmptySequence b(int i2) {
        return f29001a;
    }

    @NotNull
    /* renamed from: d */
    public EmptySequence a(int i2) {
        return f29001a;
    }

    @NotNull
    public Iterator iterator() {
        return EmptyIterator.s;
    }
}
