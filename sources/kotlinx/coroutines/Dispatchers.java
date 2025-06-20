package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003R \u0010\u000b\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\t\u0010\nR \u0010\u000f\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u0010\b\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\r\u0010\nR \u0010\u0011\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\b\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0016\u001a\u00020\u00128FX\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/Dispatchers;", "", "<init>", "()V", "", "i", "Lkotlinx/coroutines/CoroutineDispatcher;", "b", "Lkotlinx/coroutines/CoroutineDispatcher;", "a", "()Lkotlinx/coroutines/CoroutineDispatcher;", "Default", "c", "g", "h", "Unconfined", "d", "IO", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "e", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "f", "Main", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class Dispatchers {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final Dispatchers f29186a = new Dispatchers();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final CoroutineDispatcher f29187b = DefaultScheduler.b3;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final CoroutineDispatcher f29188c = Unconfined.Y;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final CoroutineDispatcher f29189d = DefaultIoScheduler.Z;

    private Dispatchers() {
    }

    @NotNull
    public static final CoroutineDispatcher a() {
        return f29187b;
    }

    @JvmStatic
    public static /* synthetic */ void b() {
    }

    @NotNull
    public static final CoroutineDispatcher c() {
        return f29189d;
    }

    @JvmStatic
    public static /* synthetic */ void d() {
    }

    @NotNull
    public static final MainCoroutineDispatcher e() {
        return MainDispatcherLoader.f29385c;
    }

    @JvmStatic
    public static /* synthetic */ void f() {
    }

    @NotNull
    public static final CoroutineDispatcher g() {
        return f29188c;
    }

    @JvmStatic
    public static /* synthetic */ void h() {
    }

    @DelicateCoroutinesApi
    public final void i() {
        DefaultExecutor.a3.shutdown();
        DefaultScheduler.b3.C0();
    }
}
