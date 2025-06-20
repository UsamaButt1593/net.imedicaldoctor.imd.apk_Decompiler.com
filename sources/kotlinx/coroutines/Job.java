package kotlinx.coroutines;

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
import kotlinx.coroutines.selects.SelectClause0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 52\u00020\u0001:\u00016J\u0013\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H'¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\n2\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0017¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u000fH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\nH¦@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J8\u0010\u001f\u001a\u00020\u001e2'\u0010\u001d\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0019j\u0002`\u001cH&¢\u0006\u0004\b\u001f\u0010 JL\u0010#\u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u00062'\u0010\u001d\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0019j\u0002`\u001cH'¢\u0006\u0004\b#\u0010$J\u0018\u0010&\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0000H\u0002¢\u0006\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\bR\u0014\u0010+\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\bR\u0014\u0010,\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\bR\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u00000-8&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u00103\u0002\u0004\n\u0002\b\u0019¨\u00067"}, d2 = {"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "I", "()Ljava/util/concurrent/CancellationException;", "", "start", "()Z", "cause", "", "i", "(Ljava/util/concurrent/CancellationException;)V", "cancel", "()V", "", "d", "(Ljava/lang/Throwable;)Z", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "m0", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "F", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "Z", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "H", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "other", "O", "(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/Job;", "b", "isActive", "p", "isCompleted", "isCancelled", "Lkotlin/sequences/Sequence;", "y", "()Lkotlin/sequences/Sequence;", "children", "Lkotlinx/coroutines/selects/SelectClause0;", "d0", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "P2", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public interface Job extends CoroutineContext.Element {
    @NotNull
    public static final Key P2 = Key.s;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void b(Job job, CancellationException cancellationException, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    cancellationException = null;
                }
                job.i(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static /* synthetic */ boolean c(Job job, Throwable th, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    th = null;
                }
                return job.d(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static <R> R d(@NotNull Job job, R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return CoroutineContext.Element.DefaultImpls.a(job, r, function2);
        }

        @Nullable
        public static <E extends CoroutineContext.Element> E e(@NotNull Job job, @NotNull CoroutineContext.Key<E> key) {
            return CoroutineContext.Element.DefaultImpls.b(job, key);
        }

        public static /* synthetic */ DisposableHandle f(Job job, boolean z, boolean z2, Function1 function1, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    z = false;
                }
                if ((i2 & 2) != 0) {
                    z2 = true;
                }
                return job.H(z, z2, function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        @NotNull
        public static CoroutineContext g(@NotNull Job job, @NotNull CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.c(job, key);
        }

        @NotNull
        public static CoroutineContext h(@NotNull Job job, @NotNull CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.d(job, coroutineContext);
        }

        @NotNull
        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static Job i(@NotNull Job job, @NotNull Job job2) {
            return job2;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/Job$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/Job;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Key implements CoroutineContext.Key<Job> {
        static final /* synthetic */ Key s = new Key();

        private Key() {
        }
    }

    @Nullable
    Object F(@NotNull Continuation<? super Unit> continuation);

    @NotNull
    @InternalCoroutinesApi
    DisposableHandle H(boolean z, boolean z2, @NotNull Function1<? super Throwable, Unit> function1);

    @NotNull
    @InternalCoroutinesApi
    CancellationException I();

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    Job O(@NotNull Job job);

    @NotNull
    DisposableHandle Z(@NotNull Function1<? super Throwable, Unit> function1);

    boolean b();

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean d(Throwable th);

    @NotNull
    SelectClause0 d0();

    void i(@Nullable CancellationException cancellationException);

    boolean isCancelled();

    @NotNull
    @InternalCoroutinesApi
    ChildHandle m0(@NotNull ChildJob childJob);

    boolean p();

    boolean start();

    @NotNull
    Sequence<Job> y();
}
