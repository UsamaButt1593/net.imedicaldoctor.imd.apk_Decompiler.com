package kotlinx.coroutines.android;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "b", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 6, 0})
final class HandlerContext$scheduleResumeAfterDelay$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ HandlerContext X;
    final /* synthetic */ Runnable Y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HandlerContext$scheduleResumeAfterDelay$1(HandlerContext handlerContext, Runnable runnable) {
        super(1);
        this.X = handlerContext;
        this.Y = runnable;
    }

    public final void b(@Nullable Throwable th) {
        this.X.Y.removeCallbacks(this.Y);
    }

    public /* bridge */ /* synthetic */ Object f(Object obj) {
        b((Throwable) obj);
        return Unit.f28779a;
    }
}
