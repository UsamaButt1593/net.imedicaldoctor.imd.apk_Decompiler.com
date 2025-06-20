package kotlin.sequences;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B)\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R$\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00028\u00010\u0011j\b\u0012\u0004\u0012\u00028\u0001`\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lkotlin/sequences/DistinctIterator;", "T", "K", "Lkotlin/collections/AbstractIterator;", "", "source", "Lkotlin/Function1;", "keySelector", "<init>", "(Ljava/util/Iterator;Lkotlin/jvm/functions/Function1;)V", "", "a", "()V", "Y", "Ljava/util/Iterator;", "Z", "Lkotlin/jvm/functions/Function1;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "X2", "Ljava/util/HashSet;", "observed", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
final class DistinctIterator<T, K> extends AbstractIterator<T> {
    @NotNull
    private final HashSet<K> X2 = new HashSet<>();
    @NotNull
    private final Iterator<T> Y;
    @NotNull
    private final Function1<T, K> Z;

    public DistinctIterator(@NotNull Iterator<? extends T> it2, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.p(it2, "source");
        Intrinsics.p(function1, "keySelector");
        this.Y = it2;
        this.Z = function1;
    }

    /* access modifiers changed from: protected */
    public void a() {
        while (this.Y.hasNext()) {
            T next = this.Y.next();
            if (this.X2.add(this.Z.f(next))) {
                c(next);
                return;
            }
        }
        b();
    }
}
