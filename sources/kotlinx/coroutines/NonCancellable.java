package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.selects.SelectClause0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\r\u001a\u00060\u000bj\u0002`\fH\u0017¢\u0006\u0004\b\r\u0010\u000eJ8\u0010\u0017\u001a\u00020\u00162'\u0010\u0015\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b0\u000fj\u0002`\u0014H\u0017¢\u0006\u0004\b\u0017\u0010\u0018JH\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052'\u0010\u0015\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b0\u000fj\u0002`\u0014H\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\b2\u000e\u0010\u0013\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fH\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0017¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H\u0017¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020&8\u0002XT¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010.\u001a\u00020\u00058VX\u0004¢\u0006\f\u0012\u0004\b-\u0010\u0004\u001a\u0004\b,\u0010\u0007R\u001a\u00101\u001a\u00020\u00058VX\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0004\u001a\u0004\b/\u0010\u0007R\u001a\u00102\u001a\u00020\u00058VX\u0004¢\u0006\f\u0012\u0004\b3\u0010\u0004\u001a\u0004\b2\u0010\u0007R\u001a\u00108\u001a\u0002048VX\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0004\u001a\u0004\b5\u00106R \u0010=\u001a\b\u0012\u0004\u0012\u00020\u0002098VX\u0004¢\u0006\f\u0012\u0004\b<\u0010\u0004\u001a\u0004\b:\u0010;\u0002\u0004\n\u0002\b\u0019¨\u0006>"}, d2 = {"Lkotlinx/coroutines/NonCancellable;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/Job;", "<init>", "()V", "", "start", "()Z", "", "F", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "I", "()Ljava/util/concurrent/CancellationException;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "Z", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "H", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "i", "(Ljava/util/concurrent/CancellationException;)V", "d", "(Ljava/lang/Throwable;)Z", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "m0", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "", "toString", "()Ljava/lang/String;", "Y", "Ljava/lang/String;", "message", "b", "T", "isActive", "p", "g0", "isCompleted", "isCancelled", "W", "Lkotlinx/coroutines/selects/SelectClause0;", "d0", "()Lkotlinx/coroutines/selects/SelectClause0;", "S", "onJoin", "Lkotlin/sequences/Sequence;", "y", "()Lkotlin/sequences/Sequence;", "R", "children", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class NonCancellable extends AbstractCoroutineContextElement implements Job {
    @NotNull
    public static final NonCancellable X = new NonCancellable();
    @NotNull
    private static final String Y = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited";

    private NonCancellable() {
        super(Job.P2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public static /* synthetic */ void R() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public static /* synthetic */ void S() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public static /* synthetic */ void T() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public static /* synthetic */ void W() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public static /* synthetic */ void g0() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    @Nullable
    public Object F(@NotNull Continuation<? super Unit> continuation) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public DisposableHandle H(boolean z, boolean z2, @NotNull Function1<? super Throwable, Unit> function1) {
        return NonDisposableHandle.s;
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public CancellationException I() {
        throw new IllegalStateException("This job is always active");
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public Job O(@NotNull Job job) {
        return Job.DefaultImpls.i(this, job);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public DisposableHandle Z(@NotNull Function1<? super Throwable, Unit> function1) {
        return NonDisposableHandle.s;
    }

    public boolean b() {
        return true;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        i((CancellationException) null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean d(Throwable th) {
        return false;
    }

    @NotNull
    public SelectClause0 d0() {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public void i(@Nullable CancellationException cancellationException) {
    }

    public boolean isCancelled() {
        return false;
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public ChildHandle m0(@NotNull ChildJob childJob) {
        return NonDisposableHandle.s;
    }

    public boolean p() {
        return false;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public boolean start() {
        return false;
    }

    @NotNull
    public String toString() {
        return "NonCancellable";
    }

    @NotNull
    public Sequence<Job> y() {
        return SequencesKt.g();
    }
}
