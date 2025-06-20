package androidx.core.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0010R(\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Landroidx/core/view/TreeIterator;", "T", "", "rootIterator", "Lkotlin/Function1;", "getChildIterator", "<init>", "(Ljava/util/Iterator;Lkotlin/jvm/functions/Function1;)V", "item", "", "a", "(Ljava/lang/Object;)V", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "s", "Lkotlin/jvm/functions/Function1;", "", "X", "Ljava/util/List;", "stack", "Y", "Ljava/util/Iterator;", "iterator", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
public final class TreeIterator<T> implements Iterator<T>, KMappedMarker {
    @NotNull
    private final List<Iterator<T>> X = new ArrayList();
    @NotNull
    private Iterator<? extends T> Y;
    @NotNull
    private final Function1<T, Iterator<T>> s;

    public TreeIterator(@NotNull Iterator<? extends T> it2, @NotNull Function1<? super T, ? extends Iterator<? extends T>> function1) {
        this.s = function1;
        this.Y = it2;
    }

    private final void a(T t) {
        Iterator<? extends T> f2 = this.s.f(t);
        if (f2 == null || !f2.hasNext()) {
            while (!this.Y.hasNext() && (!this.X.isEmpty())) {
                this.Y = (Iterator) CollectionsKt.m3(this.X);
                CollectionsKt.L0(this.X);
            }
            return;
        }
        this.X.add(this.Y);
        this.Y = f2;
    }

    public boolean hasNext() {
        return this.Y.hasNext();
    }

    public T next() {
        T next = this.Y.next();
        a(next);
        return next;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
