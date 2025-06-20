package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\tJ\u001b\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\u0019\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001f\u001a\u00060\u001bj\u0002`\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R*\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lkotlin/sequences/SequenceBuilderIterator;", "T", "Lkotlin/sequences/SequenceScope;", "", "Lkotlin/coroutines/Continuation;", "", "<init>", "()V", "k", "()Ljava/lang/Object;", "", "h", "()Ljava/lang/Throwable;", "", "hasNext", "()Z", "next", "value", "a", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "iterator", "e", "(Ljava/util/Iterator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Result;", "result", "w", "(Ljava/lang/Object;)V", "", "Lkotlin/sequences/State;", "s", "I", "state", "X", "Ljava/lang/Object;", "nextValue", "Y", "Ljava/util/Iterator;", "nextIterator", "Z", "Lkotlin/coroutines/Continuation;", "j", "()Lkotlin/coroutines/Continuation;", "l", "(Lkotlin/coroutines/Continuation;)V", "nextStep", "Lkotlin/coroutines/CoroutineContext;", "g", "()Lkotlin/coroutines/CoroutineContext;", "context", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
final class SequenceBuilderIterator<T> extends SequenceScope<T> implements Iterator<T>, Continuation<Unit>, KMappedMarker {
    @Nullable
    private T X;
    @Nullable
    private Iterator<? extends T> Y;
    @Nullable
    private Continuation<? super Unit> Z;
    private int s;

    private final Throwable h() {
        int i2 = this.s;
        if (i2 == 4) {
            return new NoSuchElementException();
        }
        if (i2 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.s);
    }

    private final T k() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Nullable
    public Object a(T t, @NotNull Continuation<? super Unit> continuation) {
        this.X = t;
        this.s = 3;
        this.Z = continuation;
        Object l2 = IntrinsicsKt.l();
        if (l2 == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return l2 == IntrinsicsKt.l() ? l2 : Unit.f28779a;
    }

    @Nullable
    public Object e(@NotNull Iterator<? extends T> it2, @NotNull Continuation<? super Unit> continuation) {
        if (!it2.hasNext()) {
            return Unit.f28779a;
        }
        this.Y = it2;
        this.s = 2;
        this.Z = continuation;
        Object l2 = IntrinsicsKt.l();
        if (l2 == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return l2 == IntrinsicsKt.l() ? l2 : Unit.f28779a;
    }

    @NotNull
    public CoroutineContext g() {
        return EmptyCoroutineContext.s;
    }

    public boolean hasNext() {
        while (true) {
            int i2 = this.s;
            if (i2 != 0) {
                if (i2 == 1) {
                    Iterator<? extends T> it2 = this.Y;
                    Intrinsics.m(it2);
                    if (it2.hasNext()) {
                        this.s = 2;
                        return true;
                    }
                    this.Y = null;
                } else if (i2 == 2 || i2 == 3) {
                    return true;
                } else {
                    if (i2 == 4) {
                        return false;
                    }
                    throw h();
                }
            }
            this.s = 5;
            Continuation<? super Unit> continuation = this.Z;
            Intrinsics.m(continuation);
            this.Z = null;
            Result.Companion companion = Result.X;
            continuation.w(Result.b(Unit.f28779a));
        }
    }

    @Nullable
    public final Continuation<Unit> j() {
        return this.Z;
    }

    public final void l(@Nullable Continuation<? super Unit> continuation) {
        this.Z = continuation;
    }

    public T next() {
        int i2 = this.s;
        if (i2 == 0 || i2 == 1) {
            return k();
        }
        if (i2 == 2) {
            this.s = 1;
            Iterator<? extends T> it2 = this.Y;
            Intrinsics.m(it2);
            return it2.next();
        } else if (i2 == 3) {
            this.s = 0;
            T t = this.X;
            this.X = null;
            return t;
        } else {
            throw h();
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void w(@NotNull Object obj) {
        ResultKt.n(obj);
        this.s = 4;
    }
}
