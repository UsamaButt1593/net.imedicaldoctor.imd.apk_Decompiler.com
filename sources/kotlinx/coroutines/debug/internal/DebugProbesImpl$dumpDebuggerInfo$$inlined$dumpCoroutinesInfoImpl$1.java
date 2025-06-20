package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "R", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "owner", "b", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)Ljava/lang/Object;", "kotlinx/coroutines/debug/internal/DebugProbesImpl$dumpCoroutinesInfoImpl$1$3"}, k = 3, mv = {1, 6, 0})
final class DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1 extends Lambda implements Function1<DebugProbesImpl.CoroutineOwner<?>, DebuggerInfo> {
    public DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1() {
        super(1);
    }

    @Nullable
    /* renamed from: b */
    public final DebuggerInfo f(@NotNull DebugProbesImpl.CoroutineOwner<?> coroutineOwner) {
        CoroutineContext c2;
        if (!DebugProbesImpl.f29286a.y(coroutineOwner) && (c2 = coroutineOwner.X.c()) != null) {
            return new DebuggerInfo(coroutineOwner.X, c2);
        }
        return null;
    }
}
