package okio.internal;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00020\f*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014¨\u0006\u0018"}, d2 = {"Lokio/internal/FixedLengthSource;", "Lokio/ForwardingSource;", "Lokio/Source;", "delegate", "", "size", "", "truncate", "<init>", "(Lokio/Source;JZ)V", "Lokio/Buffer;", "newSize", "", "d", "(Lokio/Buffer;J)V", "sink", "byteCount", "n2", "(Lokio/Buffer;J)J", "X", "J", "Y", "Z", "bytesReceived", "okio"}, k = 1, mv = {1, 5, 1})
public final class FixedLengthSource extends ForwardingSource {
    private final long X;
    private final boolean Y;
    private long Z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FixedLengthSource(@NotNull Source source, long j2, boolean z) {
        super(source);
        Intrinsics.p(source, "delegate");
        this.X = j2;
        this.Y = z;
    }

    private final void d(Buffer buffer, long j2) {
        Buffer buffer2 = new Buffer();
        buffer2.y1(buffer);
        buffer.u1(buffer2, j2);
        buffer2.d();
    }

    public long n2(@NotNull Buffer buffer, long j2) {
        Intrinsics.p(buffer, "sink");
        long j3 = this.Z;
        long j4 = this.X;
        if (j3 > j4) {
            j2 = 0;
        } else if (this.Y) {
            long j5 = j4 - j3;
            if (j5 == 0) {
                return -1;
            }
            j2 = Math.min(j2, j5);
        }
        long n2 = super.n2(buffer, j2);
        int i2 = (n2 > -1 ? 1 : (n2 == -1 ? 0 : -1));
        if (i2 != 0) {
            this.Z += n2;
        }
        long j6 = this.Z;
        long j7 = this.X;
        if ((j6 >= j7 || i2 != 0) && j6 <= j7) {
            return n2;
        }
        if (n2 > 0 && j6 > j7) {
            d(buffer, buffer.L0() - (this.Z - this.X));
        }
        throw new IOException("expected " + this.X + " bytes but got " + this.Z);
    }
}
