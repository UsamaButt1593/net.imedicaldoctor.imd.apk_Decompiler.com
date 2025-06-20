package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u0011\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJJ\u0010\u0015\u001a\u00020\u0014\"\u0004\b\u0001\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e2\"\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u00188PX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lkotlinx/coroutines/CompletableDeferredImpl;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlinx/coroutines/Job;", "parent", "<init>", "(Lkotlinx/coroutines/Job;)V", "s", "()Ljava/lang/Object;", "J", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "block", "", "h", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "value", "", "e0", "(Ljava/lang/Object;)Z", "", "exception", "k", "(Ljava/lang/Throwable;)Z", "Q0", "()Z", "onCancelComplete", "x", "()Lkotlinx/coroutines/selects/SelectClause1;", "onAwait", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class CompletableDeferredImpl<T> extends JobSupport implements CompletableDeferred<T>, SelectClause1<T> {
    public CompletableDeferredImpl(@Nullable Job job) {
        super(true);
        W0(job);
    }

    @Nullable
    public Object J(@NotNull Continuation<? super T> continuation) {
        Object t0 = t0(continuation);
        IntrinsicsKt.l();
        return t0;
    }

    public boolean Q0() {
        return true;
    }

    public boolean e0(T t) {
        return e1(t);
    }

    public <R> void h(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        r1(selectInstance, function2);
    }

    public boolean k(@NotNull Throwable th) {
        return e1(new CompletedExceptionally(th, false, 2, (DefaultConstructorMarker) null));
    }

    public T s() {
        return K0();
    }

    @NotNull
    public SelectClause1<T> x() {
        return this;
    }
}
