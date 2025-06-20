package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\n\u001a\u00020\u00048\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\u0005\u0010\t¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/debug/internal/AgentInstallationType;", "", "<init>", "()V", "", "b", "Z", "a", "()Z", "(Z)V", "isInstalledStatically", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class AgentInstallationType {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final AgentInstallationType f29255a = new AgentInstallationType();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f29256b;

    private AgentInstallationType() {
    }

    public final boolean a() {
        return f29256b;
    }

    public final void b(boolean z) {
        f29256b = z;
    }
}
