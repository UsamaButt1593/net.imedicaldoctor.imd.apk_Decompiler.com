package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/TakeSequence\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,680:1\n1#2:681\n*E\n"})
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0011¨\u0006\u0012"}, d2 = {"Lkotlin/sequences/TakeSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "", "count", "<init>", "(Lkotlin/sequences/Sequence;I)V", "n", "b", "(I)Lkotlin/sequences/Sequence;", "a", "", "iterator", "()Ljava/util/Iterator;", "Lkotlin/sequences/Sequence;", "I", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class TakeSequence<T> implements Sequence<T>, DropTakeSequence<T> {
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final Sequence<T> f29039a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f29040b;

    public TakeSequence(@NotNull Sequence<? extends T> sequence, int i2) {
        Intrinsics.p(sequence, "sequence");
        this.f29039a = sequence;
        this.f29040b = i2;
        if (i2 < 0) {
            throw new IllegalArgumentException(("count must be non-negative, but was " + i2 + ClassUtils.PACKAGE_SEPARATOR_CHAR).toString());
        }
    }

    @NotNull
    public Sequence<T> a(int i2) {
        return i2 >= this.f29040b ? this : new TakeSequence(this.f29039a, i2);
    }

    @NotNull
    public Sequence<T> b(int i2) {
        int i3 = this.f29040b;
        return i2 >= i3 ? SequencesKt.g() : new SubSequence(this.f29039a, i2, i3);
    }

    @NotNull
    public Iterator<T> iterator() {
        return new TakeSequence$iterator$1(this);
    }
}
