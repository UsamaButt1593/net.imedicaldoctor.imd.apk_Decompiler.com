package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\u001a\u0019\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0005\u001a\u00020\u00002\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\t\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\f\u001a\u00020\u000b*\u00020\u0000H@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a#\u0010\u0011\u001a\u00020\u000b*\u00020\u00002\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0013\u0010\u0013\u001a\u00020\u000b*\u00020\u0000H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001f\u0010\u0016\u001a\u00020\u000b*\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a#\u0010\u0019\u001a\u00020\u000b*\u00020\u00182\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0013\u0010\u001b\u001a\u00020\u000b*\u00020\u0018H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0011\u0010\u001d\u001a\u00020\u000b*\u00020\u0000¢\u0006\u0004\b\u001d\u0010\u0014\u001a\u0011\u0010\u001e\u001a\u00020\u000b*\u00020\u0018¢\u0006\u0004\b\u001e\u0010\u001c\u001a%\u0010!\u001a\u00020\u000b*\u00020\u00002\u0006\u0010 \u001a\u00020\u001f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010$\u001a\u00020#*\u00020\u00182\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\b$\u0010%\u001a#\u0010&\u001a\u00020\u000b*\u00020\u00182\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f¢\u0006\u0004\b&\u0010\u001a\u001a\u0013\u0010'\u001a\u00020\u000b*\u00020\u0018H\u0007¢\u0006\u0004\b'\u0010\u001c\u001a\u001f\u0010(\u001a\u00020\u000b*\u00020\u00182\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\b(\u0010)\u001a\u001d\u0010+\u001a\u00020\u0015*\u0004\u0018\u00010\u00152\u0006\u0010*\u001a\u00020\u0000H\u0002¢\u0006\u0004\b+\u0010,\"\u0015\u0010/\u001a\u00020#*\u00020\u00188F¢\u0006\u0006\u001a\u0004\b-\u0010.\"\u0015\u0010*\u001a\u00020\u0000*\u00020\u00188F¢\u0006\u0006\u001a\u0004\b0\u00101\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lkotlinx/coroutines/Job;", "parent", "Lkotlinx/coroutines/CompletableJob;", "a", "(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/CompletableJob;", "b", "(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/DisposableHandle;", "handle", "w", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/DisposableHandle;)Lkotlinx/coroutines/DisposableHandle;", "", "l", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "r", "(Lkotlinx/coroutines/Job;Ljava/util/concurrent/CancellationException;)V", "p", "(Lkotlinx/coroutines/Job;)V", "", "q", "(Lkotlinx/coroutines/Job;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/CoroutineContext;", "f", "(Lkotlin/coroutines/CoroutineContext;Ljava/util/concurrent/CancellationException;)V", "e", "(Lkotlin/coroutines/CoroutineContext;)V", "y", "x", "", "message", "g", "(Lkotlinx/coroutines/Job;Ljava/lang/String;Ljava/lang/Throwable;)V", "", "h", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)Z", "o", "m", "n", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)V", "job", "B", "(Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "A", "(Lkotlin/coroutines/CoroutineContext;)Z", "isActive", "z", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/JobKt")
final /* synthetic */ class JobKt__JobKt {
    public static final boolean A(@NotNull CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.e(Job.P2);
        return job != null && job.b();
    }

    private static final Throwable B(Throwable th, Job job) {
        return th == null ? new JobCancellationException("Job was cancelled", (Throwable) null, job) : th;
    }

    @NotNull
    public static final CompletableJob a(@Nullable Job job) {
        return new JobImpl(job);
    }

    public static /* synthetic */ CompletableJob c(Job job, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            job = null;
        }
        return JobKt.a(job);
    }

    public static /* synthetic */ Job d(Job job, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            job = null;
        }
        return JobKt.a(job);
    }

    public static final void f(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        Job job = (Job) coroutineContext.e(Job.P2);
        if (job != null) {
            job.i(cancellationException);
        }
    }

    public static final void g(@NotNull Job job, @NotNull String str, @Nullable Throwable th) {
        job.i(ExceptionsKt.a(str, th));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ boolean h(CoroutineContext coroutineContext, Throwable th) {
        CoroutineContext.Element e2 = coroutineContext.e(Job.P2);
        JobSupport jobSupport = e2 instanceof JobSupport ? (JobSupport) e2 : null;
        if (jobSupport == null) {
            return false;
        }
        jobSupport.y0(B(th, jobSupport));
        return true;
    }

    public static /* synthetic */ void i(CoroutineContext coroutineContext, CancellationException cancellationException, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cancellationException = null;
        }
        JobKt.f(coroutineContext, cancellationException);
    }

    public static /* synthetic */ void j(Job job, String str, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        JobKt.g(job, str, th);
    }

    public static /* synthetic */ boolean k(CoroutineContext coroutineContext, Throwable th, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            th = null;
        }
        return h(coroutineContext, th);
    }

    @Nullable
    public static final Object l(@NotNull Job job, @NotNull Continuation<? super Unit> continuation) {
        Job.DefaultImpls.b(job, (CancellationException) null, 1, (Object) null);
        Object F = job.F(continuation);
        return F == IntrinsicsKt.l() ? F : Unit.f28779a;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void n(CoroutineContext coroutineContext, Throwable th) {
        Job job = (Job) coroutineContext.e(Job.P2);
        if (job != null) {
            for (Job next : job.y()) {
                JobSupport jobSupport = next instanceof JobSupport ? (JobSupport) next : null;
                if (jobSupport != null) {
                    jobSupport.y0(B(th, job));
                }
            }
        }
    }

    public static final void o(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        Sequence<Job> y;
        Job job = (Job) coroutineContext.e(Job.P2);
        if (job != null && (y = job.y()) != null) {
            for (Job i2 : y) {
                i2.i(cancellationException);
            }
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void q(Job job, Throwable th) {
        for (Job next : job.y()) {
            JobSupport jobSupport = next instanceof JobSupport ? (JobSupport) next : null;
            if (jobSupport != null) {
                jobSupport.y0(B(th, job));
            }
        }
    }

    public static final void r(@NotNull Job job, @Nullable CancellationException cancellationException) {
        for (Job i2 : job.y()) {
            i2.i(cancellationException);
        }
    }

    public static /* synthetic */ void s(CoroutineContext coroutineContext, Throwable th, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            th = null;
        }
        n(coroutineContext, th);
    }

    public static /* synthetic */ void t(CoroutineContext coroutineContext, CancellationException cancellationException, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cancellationException = null;
        }
        JobKt.o(coroutineContext, cancellationException);
    }

    public static /* synthetic */ void u(Job job, Throwable th, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            th = null;
        }
        q(job, th);
    }

    public static /* synthetic */ void v(Job job, CancellationException cancellationException, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cancellationException = null;
        }
        JobKt.r(job, cancellationException);
    }

    @NotNull
    public static final DisposableHandle w(@NotNull Job job, @NotNull DisposableHandle disposableHandle) {
        return job.Z(new DisposeOnCompletion(disposableHandle));
    }

    public static final void x(@NotNull CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.e(Job.P2);
        if (job != null) {
            JobKt.A(job);
        }
    }

    public static final void y(@NotNull Job job) {
        if (!job.b()) {
            throw job.I();
        }
    }

    @NotNull
    public static final Job z(@NotNull CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.e(Job.P2);
        if (job != null) {
            return job;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }
}
