package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0003\"\u001a\u0010\u000b\u001a\u00020\u00068\u0002X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u0012\u0004\b\t\u0010\n\"\u0014\u0010\u000f\u001a\u00020\f8\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u000e\"\u0014\u0010\u0010\u001a\u00020\f8\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u000e\"\u0014\u0010\u0011\u001a\u00020\f8\u0002XT¢\u0006\u0006\n\u0004\b\u0002\u0010\u000e\"\u0014\u0010\u0014\u001a\u00020\u00008\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013\"\u0014\u0010\u0015\u001a\u00020\u00008\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0013\"\u0014\u0010\u0017\u001a\u00020\u00008\u0002XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013\"\u001a\u0010\u0019\u001a\u00020\u00068\u0002X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\b\u0012\u0004\b\u0012\u0010\n*\u001e\b\u0002\u0010\u001c\u001a\u0004\b\u0000\u0010\u001a\"\b\u0012\u0004\u0012\u00028\u00000\u001b2\b\u0012\u0004\u0012\u00028\u00000\u001b¨\u0006\u001d"}, d2 = {"", "timeMillis", "d", "(J)J", "timeNanos", "c", "Lkotlinx/coroutines/internal/Symbol;", "a", "Lkotlinx/coroutines/internal/Symbol;", "f", "()V", "DISPOSED_TASK", "", "b", "I", "SCHEDULE_OK", "SCHEDULE_COMPLETED", "SCHEDULE_DISPOSED", "e", "J", "MS_TO_NS", "MAX_MS", "g", "MAX_DELAY_NS", "h", "CLOSED_EMPTY", "T", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "Queue", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class EventLoop_commonKt {
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final Symbol f29192a = new Symbol("REMOVED_TASK");

    /* renamed from: b  reason: collision with root package name */
    private static final int f29193b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final int f29194c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static final int f29195d = 2;

    /* renamed from: e  reason: collision with root package name */
    private static final long f29196e = 1000000;

    /* renamed from: f  reason: collision with root package name */
    private static final long f29197f = 9223372036854L;

    /* renamed from: g  reason: collision with root package name */
    private static final long f29198g = 4611686018427387903L;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public static final Symbol f29199h = new Symbol("CLOSED_EMPTY");

    public static final long c(long j2) {
        return j2 / 1000000;
    }

    public static final long d(long j2) {
        if (j2 <= 0) {
            return 0;
        }
        if (j2 >= f29197f) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j2;
    }

    private static /* synthetic */ void e() {
    }

    private static /* synthetic */ void f() {
    }
}
