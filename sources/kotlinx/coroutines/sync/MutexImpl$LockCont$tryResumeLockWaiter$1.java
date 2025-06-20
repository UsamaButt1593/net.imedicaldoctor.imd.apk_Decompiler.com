package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.sync.MutexImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "b", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 6, 0})
final class MutexImpl$LockCont$tryResumeLockWaiter$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ MutexImpl X;
    final /* synthetic */ MutexImpl.LockCont Y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MutexImpl$LockCont$tryResumeLockWaiter$1(MutexImpl mutexImpl, MutexImpl.LockCont lockCont) {
        super(1);
        this.X = mutexImpl;
        this.Y = lockCont;
    }

    public final void b(@NotNull Throwable th) {
        this.X.d(this.Y.Z);
    }

    public /* bridge */ /* synthetic */ Object f(Object obj) {
        b((Throwable) obj);
        return Unit.f28779a;
    }
}
