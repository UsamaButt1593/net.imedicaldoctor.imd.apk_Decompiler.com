package okio;

import java.io.InterruptedIOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"okio/Throttler$source$1", "Lokio/ForwardingSource;", "Lokio/Buffer;", "sink", "", "byteCount", "n2", "(Lokio/Buffer;J)J", "okio"}, k = 1, mv = {1, 5, 1})
public final class Throttler$source$1 extends ForwardingSource {
    final /* synthetic */ Throttler X;
    final /* synthetic */ Source Y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Throttler$source$1(Throttler throttler, Source source) {
        super(source);
        this.X = throttler;
        this.Y = source;
    }

    public long n2(@NotNull Buffer buffer, long j2) {
        Intrinsics.p(buffer, "sink");
        try {
            return super.n2(buffer, this.X.j(j2));
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}
