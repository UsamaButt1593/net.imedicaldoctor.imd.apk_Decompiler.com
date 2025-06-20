package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.time.Duration;
import kotlinx.coroutines.flow.SharingStarted;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/flow/SharingStarted$Companion;", "Lkotlin/time/Duration;", "stopTimeout", "replayExpiration", "Lkotlinx/coroutines/flow/SharingStarted;", "a", "(Lkotlinx/coroutines/flow/SharingStarted$Companion;JJ)Lkotlinx/coroutines/flow/SharingStarted;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class SharingStartedKt {
    @NotNull
    public static final SharingStarted a(@NotNull SharingStarted.Companion companion, long j2, long j3) {
        return new StartedWhileSubscribed(Duration.L(j2), Duration.L(j3));
    }

    public static /* synthetic */ SharingStarted b(SharingStarted.Companion companion, long j2, long j3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = Duration.X.W();
        }
        if ((i2 & 2) != 0) {
            j3 = Duration.X.q();
        }
        return a(companion, j2, j3);
    }
}
