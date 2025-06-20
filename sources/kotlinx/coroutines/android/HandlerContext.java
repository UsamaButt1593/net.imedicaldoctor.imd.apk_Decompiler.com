package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonDisposableHandle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B#\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u001d\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\u000bJ#\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0013J%\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00172\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00103\u001a\u00020\u00008\u0016X\u0004¢\u0006\f\n\u0004\b0\u0010/\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "Landroid/os/Handler;", "handler", "", "name", "", "invokeImmediately", "<init>", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "(Landroid/os/Handler;Ljava/lang/String;)V", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "B0", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "T", "(Lkotlin/coroutines/CoroutineContext;)Z", "R", "", "timeMillis", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "r", "(JLkotlinx/coroutines/CancellableContinuation;)V", "Lkotlinx/coroutines/DisposableHandle;", "N", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "toString", "()Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Y", "Landroid/os/Handler;", "Z", "Ljava/lang/String;", "X2", "_immediate", "Lkotlinx/coroutines/android/HandlerContext;", "Y2", "C0", "()Lkotlinx/coroutines/android/HandlerContext;", "immediate", "kotlinx-coroutines-android"}, k = 1, mv = {1, 6, 0})
public final class HandlerContext extends HandlerDispatcher implements Delay {
    private final boolean X2;
    /* access modifiers changed from: private */
    @NotNull
    public final Handler Y;
    @NotNull
    private final HandlerContext Y2;
    @Nullable
    private final String Z;
    @Nullable
    private volatile HandlerContext _immediate;

    public HandlerContext(@NotNull Handler handler, @Nullable String str) {
        this(handler, str, false);
    }

    private final void B0(CoroutineContext coroutineContext, Runnable runnable) {
        JobKt.f(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        Dispatchers.c().R(coroutineContext, runnable);
    }

    /* access modifiers changed from: private */
    public static final void D0(HandlerContext handlerContext, Runnable runnable) {
        handlerContext.Y.removeCallbacks(runnable);
    }

    @NotNull
    /* renamed from: C0 */
    public HandlerContext r0() {
        return this.Y2;
    }

    @NotNull
    public DisposableHandle N(long j2, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        if (this.Y.postDelayed(runnable, RangesKt.C(j2, DurationKt.f29135c))) {
            return new a(this, runnable);
        }
        B0(coroutineContext, runnable);
        return NonDisposableHandle.s;
    }

    public void R(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        if (!this.Y.post(runnable)) {
            B0(coroutineContext, runnable);
        }
    }

    public boolean T(@NotNull CoroutineContext coroutineContext) {
        return !this.X2 || !Intrinsics.g(Looper.myLooper(), this.Y.getLooper());
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof HandlerContext) && ((HandlerContext) obj).Y == this.Y;
    }

    public int hashCode() {
        return System.identityHashCode(this.Y);
    }

    public void r(long j2, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
        HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1 handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1 = new HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1(cancellableContinuation, this);
        if (this.Y.postDelayed(handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1, RangesKt.C(j2, DurationKt.f29135c))) {
            cancellableContinuation.M(new HandlerContext$scheduleResumeAfterDelay$1(this, handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1));
        } else {
            B0(cancellableContinuation.g(), handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1);
        }
    }

    @NotNull
    public String toString() {
        String q0 = q0();
        if (q0 != null) {
            return q0;
        }
        String str = this.Z;
        if (str == null) {
            str = this.Y.toString();
        }
        if (!this.X2) {
            return str;
        }
        return str + ".immediate";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HandlerContext(Handler handler, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, (i2 & 2) != 0 ? null : str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private HandlerContext(Handler handler, String str, boolean z) {
        super((DefaultConstructorMarker) null);
        HandlerContext handlerContext = null;
        this.Y = handler;
        this.Z = str;
        this.X2 = z;
        this._immediate = z ? this : handlerContext;
        HandlerContext handlerContext2 = this._immediate;
        if (handlerContext2 == null) {
            handlerContext2 = new HandlerContext(handler, str, true);
            this._immediate = handlerContext2;
        }
        this.Y2 = handlerContext2;
    }
}
