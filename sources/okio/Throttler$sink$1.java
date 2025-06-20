package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"okio/Throttler$sink$1", "Lokio/ForwardingSink;", "Lokio/Buffer;", "source", "", "byteCount", "", "u1", "(Lokio/Buffer;J)V", "okio"}, k = 1, mv = {1, 5, 1})
public final class Throttler$sink$1 extends ForwardingSink {
    final /* synthetic */ Throttler X;
    final /* synthetic */ Sink Y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Throttler$sink$1(Throttler throttler, Sink sink) {
        super(sink);
        this.X = throttler;
        this.Y = sink;
    }

    public void u1(@NotNull Buffer buffer, long j2) throws IOException {
        Intrinsics.p(buffer, "source");
        while (j2 > 0) {
            try {
                long j3 = this.X.j(j2);
                super.u1(buffer, j3);
                j2 -= j3;
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException("interrupted");
            }
        }
    }
}
