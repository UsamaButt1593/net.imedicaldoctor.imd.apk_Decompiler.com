package kotlinx.coroutines.flow;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bæ\u0001\u0018\u0000 \u00072\u00020\u0001:\u0001\tJ#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/flow/SharingStarted;", "", "Lkotlinx/coroutines/flow/StateFlow;", "", "subscriptionCount", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "a", "(Lkotlinx/coroutines/flow/StateFlow;)Lkotlinx/coroutines/flow/Flow;", "Companion", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public interface SharingStarted {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f29313a = Companion.f29314a;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000e\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/flow/SharingStarted$Companion;", "", "<init>", "()V", "", "stopTimeoutMillis", "replayExpirationMillis", "Lkotlinx/coroutines/flow/SharingStarted;", "a", "(JJ)Lkotlinx/coroutines/flow/SharingStarted;", "b", "Lkotlinx/coroutines/flow/SharingStarted;", "c", "()Lkotlinx/coroutines/flow/SharingStarted;", "Eagerly", "d", "Lazily", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Companion f29314a = new Companion();
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private static final SharingStarted f29315b = new StartedEagerly();
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private static final SharingStarted f29316c = new StartedLazily();

        private Companion() {
        }

        public static /* synthetic */ SharingStarted b(Companion companion, long j2, long j3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j2 = 0;
            }
            if ((i2 & 2) != 0) {
                j3 = Long.MAX_VALUE;
            }
            return companion.a(j2, j3);
        }

        @NotNull
        public final SharingStarted a(long j2, long j3) {
            return new StartedWhileSubscribed(j2, j3);
        }

        @NotNull
        public final SharingStarted c() {
            return f29315b;
        }

        @NotNull
        public final SharingStarted d() {
            return f29316c;
        }
    }

    @NotNull
    Flow<SharingCommand> a(@NotNull StateFlow<Integer> stateFlow);
}
