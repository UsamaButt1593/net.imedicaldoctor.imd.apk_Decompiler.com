package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.MainDispatchersKt;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"\u001a\u0010\b\u001a\u00020\u00008\u0000X\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0007\u001a\u0004\b\u0004\u0010\u0002¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/Delay;", "b", "()Lkotlinx/coroutines/Delay;", "", "a", "Z", "defaultMainDelayOptIn", "Lkotlinx/coroutines/Delay;", "DefaultDelay", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class DefaultExecutorKt {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f29179a = SystemPropsKt.e("kotlinx.coroutines.main.delay", false);
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Delay f29180b = b();

    @NotNull
    public static final Delay a() {
        return f29180b;
    }

    private static final Delay b() {
        if (!f29179a) {
            return DefaultExecutor.a3;
        }
        MainCoroutineDispatcher e2 = Dispatchers.e();
        return (MainDispatchersKt.d(e2) || !(e2 instanceof Delay)) ? DefaultExecutor.a3 : (Delay) e2;
    }
}
