package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SubSequence\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,680:1\n1#2:681\n*E\n"})
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lkotlin/sequences/SubSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "", "startIndex", "endIndex", "<init>", "(Lkotlin/sequences/Sequence;II)V", "n", "b", "(I)Lkotlin/sequences/Sequence;", "a", "", "iterator", "()Ljava/util/Iterator;", "Lkotlin/sequences/Sequence;", "I", "c", "f", "()I", "count", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class SubSequence<T> implements Sequence<T>, DropTakeSequence<T> {
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final Sequence<T> f29036a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f29037b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f29038c;

    public SubSequence(@NotNull Sequence<? extends T> sequence, int i2, int i3) {
        Intrinsics.p(sequence, "sequence");
        this.f29036a = sequence;
        this.f29037b = i2;
        this.f29038c = i3;
        if (i2 < 0) {
            throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i2).toString());
        } else if (i3 < 0) {
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i3).toString());
        } else if (i3 < i2) {
            throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i3 + " < " + i2).toString());
        }
    }

    private final int f() {
        return this.f29038c - this.f29037b;
    }

    @NotNull
    public Sequence<T> a(int i2) {
        if (i2 >= f()) {
            return this;
        }
        Sequence<T> sequence = this.f29036a;
        int i3 = this.f29037b;
        return new SubSequence(sequence, i3, i2 + i3);
    }

    @NotNull
    public Sequence<T> b(int i2) {
        return i2 >= f() ? SequencesKt.g() : new SubSequence(this.f29036a, this.f29037b + i2, this.f29038c);
    }

    @NotNull
    public Iterator<T> iterator() {
        return new SubSequence$iterator$1(this);
    }
}
