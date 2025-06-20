package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"kotlin/sequences/TransformingIndexedSequence$iterator$1", "", "next", "()Ljava/lang/Object;", "", "hasNext", "()Z", "s", "Ljava/util/Iterator;", "b", "()Ljava/util/Iterator;", "iterator", "", "X", "I", "a", "()I", "c", "(I)V", "index", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class TransformingIndexedSequence$iterator$1 implements Iterator<R>, KMappedMarker {
    private int X;
    final /* synthetic */ TransformingIndexedSequence<T, R> Y;
    @NotNull
    private final Iterator<T> s;

    TransformingIndexedSequence$iterator$1(TransformingIndexedSequence<T, R> transformingIndexedSequence) {
        this.Y = transformingIndexedSequence;
        this.s = transformingIndexedSequence.f29043a.iterator();
    }

    public final int a() {
        return this.X;
    }

    @NotNull
    public final Iterator<T> b() {
        return this.s;
    }

    public final void c(int i2) {
        this.X = i2;
    }

    public boolean hasNext() {
        return this.s.hasNext();
    }

    public R next() {
        Function2 d2 = this.Y.f29044b;
        int i2 = this.X;
        this.X = i2 + 1;
        if (i2 < 0) {
            CollectionsKt.W();
        }
        return d2.d0(Integer.valueOf(i2), this.s.next());
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
