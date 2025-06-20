package kotlinx.coroutines.tasks;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00028\u0000HAø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0013\u001a\u00020\t2\u000e\u0010\r\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J8\u0010\u001a\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00152\u0006\u0010\u0016\u001a\u00028\u00012\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00028\u00010\u0017H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ*\u0010\u001f\u001a\u0004\u0018\u00018\u0001\"\b\b\u0001\u0010\u001c*\u00020\u00182\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u001dH\u0003¢\u0006\u0004\b\u001f\u0010 J\u0014\u0010!\u001a\u00060\u0011j\u0002`\u0012H\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00028\u0000H\u0001¢\u0006\u0004\b#\u0010$J\u0012\u0010%\u001a\u0004\u0018\u00010\fH\u0001¢\u0006\u0004\b%\u0010&JI\u0010/\u001a\u00020.2\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u000e2'\u0010-\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t0)j\u0002`,H\u0001¢\u0006\u0004\b/\u00100J9\u00101\u001a\u00020.2'\u0010-\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t0)j\u0002`,H\u0001¢\u0006\u0004\b1\u00102J\u0013\u00103\u001a\u00020\tHAø\u0001\u0000¢\u0006\u0004\b3\u0010\bJ\u001c\u00105\u001a\u0002042\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0001¢\u0006\u0004\b5\u00106J\u0018\u00108\u001a\u0002042\u0006\u00107\u001a\u000204H\u0003¢\u0006\u0004\b8\u00109J\u0018\u0010<\u001a\u00020:2\u0006\u0010;\u001a\u00020:H\u0003¢\u0006\u0004\b<\u0010=J\u0010\u0010>\u001a\u00020\u000eH\u0001¢\u0006\u0004\b>\u0010?R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020:0@8\u0016X\u0005¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0014\u0010E\u001a\u00020\u000e8\u0016X\u0005¢\u0006\u0006\u001a\u0004\bD\u0010?R\u0014\u0010F\u001a\u00020\u000e8\u0016X\u0005¢\u0006\u0006\u001a\u0004\bF\u0010?R\u0014\u0010H\u001a\u00020\u000e8\u0016X\u0005¢\u0006\u0006\u001a\u0004\bG\u0010?R\u0018\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001d8\u0016X\u0005¢\u0006\u0006\u001a\u0004\bI\u0010JR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000K8\u0016X\u0005¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0014\u0010R\u001a\u00020O8\u0016X\u0005¢\u0006\u0006\u001a\u0004\bP\u0010Q\u0002\u0004\n\u0002\b\u0019¨\u0006S"}, d2 = {"kotlinx/coroutines/tasks/TasksKt$asDeferredImpl$3", "Lkotlinx/coroutines/Deferred;", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "m0", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "J", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cancel", "()V", "", "cause", "", "d", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "i", "(Ljava/util/concurrent/CancellationException;)V", "R", "initial", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "operation", "n", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "E", "Lkotlin/coroutines/CoroutineContext$Key;", "key", "e", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "I", "()Ljava/util/concurrent/CancellationException;", "s", "()Ljava/lang/Object;", "A", "()Ljava/lang/Throwable;", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "H", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "Z", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "F", "Lkotlin/coroutines/CoroutineContext;", "f", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext;", "context", "v", "(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/Job;", "other", "O", "(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/Job;", "start", "()Z", "Lkotlin/sequences/Sequence;", "y", "()Lkotlin/sequences/Sequence;", "children", "b", "isActive", "isCancelled", "p", "isCompleted", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/selects/SelectClause1;", "x", "()Lkotlinx/coroutines/selects/SelectClause1;", "onAwait", "Lkotlinx/coroutines/selects/SelectClause0;", "d0", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "kotlinx-coroutines-play-services"}, k = 1, mv = {1, 6, 0})
public final class TasksKt$asDeferredImpl$3 implements Deferred<T> {
    private final /* synthetic */ CompletableDeferred<T> s;

    TasksKt$asDeferredImpl$3(CompletableDeferred<T> completableDeferred) {
        this.s = completableDeferred;
    }

    @Nullable
    @ExperimentalCoroutinesApi
    public Throwable A() {
        return this.s.A();
    }

    @Nullable
    public Object F(@NotNull Continuation<? super Unit> continuation) {
        return this.s.F(continuation);
    }

    @NotNull
    @InternalCoroutinesApi
    public DisposableHandle H(boolean z, boolean z2, @NotNull Function1<? super Throwable, Unit> function1) {
        return this.s.H(z, z2, function1);
    }

    @NotNull
    @InternalCoroutinesApi
    public CancellationException I() {
        return this.s.I();
    }

    @Nullable
    public Object J(@NotNull Continuation<? super T> continuation) {
        return this.s.J(continuation);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public Job O(@NotNull Job job) {
        return this.s.O(job);
    }

    @NotNull
    public DisposableHandle Z(@NotNull Function1<? super Throwable, Unit> function1) {
        return this.s.Z(function1);
    }

    public boolean b() {
        return this.s.b();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        this.s.cancel();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean d(Throwable th) {
        return this.s.d(th);
    }

    @NotNull
    public SelectClause0 d0() {
        return this.s.d0();
    }

    @Nullable
    public <E extends CoroutineContext.Element> E e(@NotNull CoroutineContext.Key<E> key) {
        return this.s.e(key);
    }

    @NotNull
    public CoroutineContext f(@NotNull CoroutineContext.Key<?> key) {
        return this.s.f(key);
    }

    @NotNull
    public CoroutineContext.Key<?> getKey() {
        return this.s.getKey();
    }

    public void i(@Nullable CancellationException cancellationException) {
        this.s.i(cancellationException);
    }

    public boolean isCancelled() {
        return this.s.isCancelled();
    }

    @NotNull
    @InternalCoroutinesApi
    public ChildHandle m0(@NotNull ChildJob childJob) {
        return this.s.m0(childJob);
    }

    public <R> R n(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return this.s.n(r, function2);
    }

    public boolean p() {
        return this.s.p();
    }

    @ExperimentalCoroutinesApi
    public T s() {
        return this.s.s();
    }

    public boolean start() {
        return this.s.start();
    }

    @NotNull
    public CoroutineContext v(@NotNull CoroutineContext coroutineContext) {
        return this.s.v(coroutineContext);
    }

    @NotNull
    public SelectClause1<T> x() {
        return this.s.x();
    }

    @NotNull
    public Sequence<Job> y() {
        return this.s.y();
    }
}
