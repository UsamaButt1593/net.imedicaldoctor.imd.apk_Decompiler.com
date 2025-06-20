package okio;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"okio/Timeout$Companion$NONE$1", "Lokio/Timeout;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "i", "(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;", "deadlineNanoTime", "e", "(J)Lokio/Timeout;", "", "h", "()V", "okio"}, k = 1, mv = {1, 5, 1})
public final class Timeout$Companion$NONE$1 extends Timeout {
    Timeout$Companion$NONE$1() {
    }

    @NotNull
    public Timeout e(long j2) {
        return this;
    }

    public void h() {
    }

    @NotNull
    public Timeout i(long j2, @NotNull TimeUnit timeUnit) {
        Intrinsics.p(timeUnit, "unit");
        return this;
    }
}
