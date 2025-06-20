package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0004R0\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006@\u0006X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0014"}, d2 = {"Lkotlin/coroutines/jvm/internal/RunSuspend;", "Lkotlin/coroutines/Continuation;", "", "<init>", "()V", "Lkotlin/Result;", "result", "w", "(Ljava/lang/Object;)V", "a", "s", "Lkotlin/Result;", "c", "()Lkotlin/Result;", "e", "(Lkotlin/Result;)V", "Lkotlin/coroutines/CoroutineContext;", "g", "()Lkotlin/coroutines/CoroutineContext;", "context", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
final class RunSuspend implements Continuation<Unit> {
    @Nullable
    private Result<Unit> s;

    public final void a() {
        synchronized (this) {
            while (true) {
                try {
                    Result<Unit> result = this.s;
                    if (result == null) {
                        Intrinsics.n(this, "null cannot be cast to non-null type java.lang.Object");
                        wait();
                    } else {
                        ResultKt.n(result.l());
                    }
                } finally {
                }
            }
        }
    }

    @Nullable
    public final Result<Unit> c() {
        return this.s;
    }

    public final void e(@Nullable Result<Unit> result) {
        this.s = result;
    }

    @NotNull
    public CoroutineContext g() {
        return EmptyCoroutineContext.s;
    }

    public void w(@NotNull Object obj) {
        synchronized (this) {
            this.s = Result.a(obj);
            Intrinsics.n(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
            Unit unit = Unit.f28779a;
        }
    }
}
