package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"E", "", "<anonymous parameter 0>", "", "b", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 6, 0})
final class OnUndeliveredElementKt$bindCancellationFun$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ Function1<E, Unit> X;
    final /* synthetic */ E Y;
    final /* synthetic */ CoroutineContext Z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OnUndeliveredElementKt$bindCancellationFun$1(Function1<? super E, Unit> function1, E e2, CoroutineContext coroutineContext) {
        super(1);
        this.X = function1;
        this.Y = e2;
        this.Z = coroutineContext;
    }

    public final void b(@NotNull Throwable th) {
        OnUndeliveredElementKt.b(this.X, this.Y, this.Z);
    }

    public /* bridge */ /* synthetic */ Object f(Object obj) {
        b((Throwable) obj);
        return Unit.f28779a;
    }
}
