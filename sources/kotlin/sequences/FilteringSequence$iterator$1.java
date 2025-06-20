package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001c\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"kotlin/sequences/FilteringSequence$iterator$1", "", "", "a", "()V", "next", "()Ljava/lang/Object;", "", "hasNext", "()Z", "s", "Ljava/util/Iterator;", "b", "()Ljava/util/Iterator;", "iterator", "", "X", "I", "d", "()I", "f", "(I)V", "nextState", "Y", "Ljava/lang/Object;", "c", "e", "(Ljava/lang/Object;)V", "nextItem", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class FilteringSequence$iterator$1 implements Iterator<T>, KMappedMarker {
    private int X = -1;
    @Nullable
    private T Y;
    final /* synthetic */ FilteringSequence<T> Z;
    @NotNull
    private final Iterator<T> s;

    FilteringSequence$iterator$1(FilteringSequence<T> filteringSequence) {
        this.Z = filteringSequence;
        this.s = filteringSequence.f29002a.iterator();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a() {
        /*
            r3 = this;
        L_0x0000:
            java.util.Iterator<T> r0 = r3.s
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x002c
            java.util.Iterator<T> r0 = r3.s
            java.lang.Object r0 = r0.next()
            kotlin.sequences.FilteringSequence<T> r1 = r3.Z
            kotlin.jvm.functions.Function1 r1 = r1.f29004c
            java.lang.Object r1 = r1.f(r0)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            kotlin.sequences.FilteringSequence<T> r2 = r3.Z
            boolean r2 = r2.f29003b
            if (r1 != r2) goto L_0x0000
            r3.Y = r0
            r0 = 1
        L_0x0029:
            r3.X = r0
            return
        L_0x002c:
            r0 = 0
            goto L_0x0029
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.FilteringSequence$iterator$1.a():void");
    }

    @NotNull
    public final Iterator<T> b() {
        return this.s;
    }

    @Nullable
    public final T c() {
        return this.Y;
    }

    public final int d() {
        return this.X;
    }

    public final void e(@Nullable T t) {
        this.Y = t;
    }

    public final void f(int i2) {
        this.X = i2;
    }

    public boolean hasNext() {
        if (this.X == -1) {
            a();
        }
        return this.X == 1;
    }

    public T next() {
        if (this.X == -1) {
            a();
        }
        if (this.X != 0) {
            T t = this.Y;
            this.Y = null;
            this.X = -1;
            return t;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
