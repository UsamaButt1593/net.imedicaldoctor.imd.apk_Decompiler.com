package okio;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lokio/OutputStreamSink;", "Lokio/Sink;", "Ljava/io/OutputStream;", "out", "Lokio/Timeout;", "timeout", "<init>", "(Ljava/io/OutputStream;Lokio/Timeout;)V", "Lokio/Buffer;", "source", "", "byteCount", "", "u1", "(Lokio/Buffer;J)V", "flush", "()V", "close", "j", "()Lokio/Timeout;", "", "toString", "()Ljava/lang/String;", "s", "Ljava/io/OutputStream;", "X", "Lokio/Timeout;", "okio"}, k = 1, mv = {1, 5, 1})
final class OutputStreamSink implements Sink {
    @NotNull
    private final Timeout X;
    @NotNull
    private final OutputStream s;

    public OutputStreamSink(@NotNull OutputStream outputStream, @NotNull Timeout timeout) {
        Intrinsics.p(outputStream, "out");
        Intrinsics.p(timeout, "timeout");
        this.s = outputStream;
        this.X = timeout;
    }

    public void close() {
        this.s.close();
    }

    public void flush() {
        this.s.flush();
    }

    @NotNull
    public Timeout j() {
        return this.X;
    }

    @NotNull
    public String toString() {
        return "sink(" + this.s + ASCIIPropertyListParser.f18650h;
    }

    public void u1(@NotNull Buffer buffer, long j2) {
        Intrinsics.p(buffer, "source");
        _UtilKt.e(buffer.L0(), 0, j2);
        while (j2 > 0) {
            this.X.h();
            Segment segment = buffer.s;
            Intrinsics.m(segment);
            int min = (int) Math.min(j2, (long) (segment.f31384c - segment.f31383b));
            this.s.write(segment.f31382a, segment.f31383b, min);
            segment.f31383b += min;
            long j3 = (long) min;
            j2 -= j3;
            buffer.C0(buffer.L0() - j3);
            if (segment.f31383b == segment.f31384c) {
                buffer.s = segment.b();
                SegmentPool.d(segment);
            }
        }
    }
}
