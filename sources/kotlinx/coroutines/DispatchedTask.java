package kotlinx.coroutines;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.Task;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH ¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\fH\u0010¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e8 X \u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "", "resumeMode", "<init>", "(I)V", "", "k", "()Ljava/lang/Object;", "takenState", "", "cause", "", "c", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "state", "h", "(Ljava/lang/Object;)Ljava/lang/Object;", "f", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "run", "()V", "exception", "finallyException", "i", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "Y", "I", "Lkotlin/coroutines/Continuation;", "e", "()Lkotlin/coroutines/Continuation;", "delegate", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class DispatchedTask<T> extends Task {
    @JvmField
    public int Y;

    public DispatchedTask(int i2) {
        this.Y = i2;
    }

    public void c(@Nullable Object obj, @NotNull Throwable th) {
    }

    @NotNull
    public abstract Continuation<T> e();

    @Nullable
    public Throwable f(@Nullable Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.f29164a;
        }
        return null;
    }

    public <T> T h(@Nullable Object obj) {
        return obj;
    }

    public final void i(@Nullable Throwable th, @Nullable Throwable th2) {
        if (th != null || th2 != null) {
            if (!(th == null || th2 == null)) {
                ExceptionsKt.a(th, th2);
            }
            if (th == null) {
                th = th2;
            }
            Intrinsics.m(th);
            CoroutineExceptionHandlerKt.b(e().g(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
        }
    }

    @Nullable
    public abstract Object k();

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0081, code lost:
        if (r4.L1() != false) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a9, code lost:
        if (r4.L1() != false) goto L_0x00ab;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            kotlinx.coroutines.scheduling.TaskContext r0 = r10.X
            kotlin.coroutines.Continuation r1 = r10.e()     // Catch:{ all -> 0x001e }
            kotlinx.coroutines.internal.DispatchedContinuation r1 = (kotlinx.coroutines.internal.DispatchedContinuation) r1     // Catch:{ all -> 0x001e }
            kotlin.coroutines.Continuation<T> r2 = r1.X2     // Catch:{ all -> 0x001e }
            java.lang.Object r1 = r1.Z2     // Catch:{ all -> 0x001e }
            kotlin.coroutines.CoroutineContext r3 = r2.g()     // Catch:{ all -> 0x001e }
            java.lang.Object r1 = kotlinx.coroutines.internal.ThreadContextKt.c(r3, r1)     // Catch:{ all -> 0x001e }
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.internal.ThreadContextKt.f29399a     // Catch:{ all -> 0x001e }
            r5 = 0
            if (r1 == r4) goto L_0x0021
            kotlinx.coroutines.UndispatchedCoroutine r4 = kotlinx.coroutines.CoroutineContextKt.g(r2, r3, r1)     // Catch:{ all -> 0x001e }
            goto L_0x0022
        L_0x001e:
            r1 = move-exception
            goto L_0x00af
        L_0x0021:
            r4 = r5
        L_0x0022:
            kotlin.coroutines.CoroutineContext r6 = r2.g()     // Catch:{ all -> 0x0041 }
            java.lang.Object r7 = r10.k()     // Catch:{ all -> 0x0041 }
            java.lang.Throwable r8 = r10.f(r7)     // Catch:{ all -> 0x0041 }
            if (r8 != 0) goto L_0x0043
            int r9 = r10.Y     // Catch:{ all -> 0x0041 }
            boolean r9 = kotlinx.coroutines.DispatchedTaskKt.c(r9)     // Catch:{ all -> 0x0041 }
            if (r9 == 0) goto L_0x0043
            kotlinx.coroutines.Job$Key r9 = kotlinx.coroutines.Job.P2     // Catch:{ all -> 0x0041 }
            kotlin.coroutines.CoroutineContext$Element r6 = r6.e(r9)     // Catch:{ all -> 0x0041 }
            kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6     // Catch:{ all -> 0x0041 }
            goto L_0x0044
        L_0x0041:
            r2 = move-exception
            goto L_0x00a3
        L_0x0043:
            r6 = r5
        L_0x0044:
            if (r6 == 0) goto L_0x0061
            boolean r9 = r6.b()     // Catch:{ all -> 0x0041 }
            if (r9 != 0) goto L_0x0061
            java.util.concurrent.CancellationException r6 = r6.I()     // Catch:{ all -> 0x0041 }
            r10.c(r7, r6)     // Catch:{ all -> 0x0041 }
            kotlin.Result$Companion r7 = kotlin.Result.X     // Catch:{ all -> 0x0041 }
            java.lang.Object r6 = kotlin.ResultKt.a(r6)     // Catch:{ all -> 0x0041 }
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch:{ all -> 0x0041 }
        L_0x005d:
            r2.w(r6)     // Catch:{ all -> 0x0041 }
            goto L_0x0079
        L_0x0061:
            if (r8 == 0) goto L_0x006e
            kotlin.Result$Companion r6 = kotlin.Result.X     // Catch:{ all -> 0x0041 }
            java.lang.Object r6 = kotlin.ResultKt.a(r8)     // Catch:{ all -> 0x0041 }
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch:{ all -> 0x0041 }
            goto L_0x005d
        L_0x006e:
            kotlin.Result$Companion r6 = kotlin.Result.X     // Catch:{ all -> 0x0041 }
            java.lang.Object r6 = r10.h(r7)     // Catch:{ all -> 0x0041 }
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch:{ all -> 0x0041 }
            goto L_0x005d
        L_0x0079:
            kotlin.Unit r2 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0041 }
            if (r4 == 0) goto L_0x0083
            boolean r4 = r4.L1()     // Catch:{ all -> 0x001e }
            if (r4 == 0) goto L_0x0086
        L_0x0083:
            kotlinx.coroutines.internal.ThreadContextKt.a(r3, r1)     // Catch:{ all -> 0x001e }
        L_0x0086:
            kotlin.Result$Companion r1 = kotlin.Result.X     // Catch:{ all -> 0x0090 }
            r0.w()     // Catch:{ all -> 0x0090 }
            java.lang.Object r0 = kotlin.Result.b(r2)     // Catch:{ all -> 0x0090 }
            goto L_0x009b
        L_0x0090:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.X
            java.lang.Object r0 = kotlin.ResultKt.a(r0)
            java.lang.Object r0 = kotlin.Result.b(r0)
        L_0x009b:
            java.lang.Throwable r0 = kotlin.Result.e(r0)
            r10.i(r5, r0)
            goto L_0x00cd
        L_0x00a3:
            if (r4 == 0) goto L_0x00ab
            boolean r4 = r4.L1()     // Catch:{ all -> 0x001e }
            if (r4 == 0) goto L_0x00ae
        L_0x00ab:
            kotlinx.coroutines.internal.ThreadContextKt.a(r3, r1)     // Catch:{ all -> 0x001e }
        L_0x00ae:
            throw r2     // Catch:{ all -> 0x001e }
        L_0x00af:
            kotlin.Result$Companion r2 = kotlin.Result.X     // Catch:{ all -> 0x00bb }
            r0.w()     // Catch:{ all -> 0x00bb }
            kotlin.Unit r0 = kotlin.Unit.f28779a     // Catch:{ all -> 0x00bb }
            java.lang.Object r0 = kotlin.Result.b(r0)     // Catch:{ all -> 0x00bb }
            goto L_0x00c6
        L_0x00bb:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.X
            java.lang.Object r0 = kotlin.ResultKt.a(r0)
            java.lang.Object r0 = kotlin.Result.b(r0)
        L_0x00c6:
            java.lang.Throwable r0 = kotlin.Result.e(r0)
            r10.i(r1, r0)
        L_0x00cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DispatchedTask.run():void");
    }
}
