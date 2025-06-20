package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0011J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010\"¨\u0006$"}, d2 = {"Lokio/InflaterSource;", "Lokio/Source;", "Lokio/BufferedSource;", "source", "Ljava/util/zip/Inflater;", "inflater", "<init>", "(Lokio/BufferedSource;Ljava/util/zip/Inflater;)V", "(Lokio/Source;Ljava/util/zip/Inflater;)V", "", "d", "()V", "Lokio/Buffer;", "sink", "", "byteCount", "n2", "(Lokio/Buffer;J)J", "b", "", "c", "()Z", "Lokio/Timeout;", "j", "()Lokio/Timeout;", "close", "s", "Lokio/BufferedSource;", "X", "Ljava/util/zip/Inflater;", "", "Y", "I", "bufferBytesHeldByInflater", "Z", "closed", "okio"}, k = 1, mv = {1, 5, 1})
public final class InflaterSource implements Source {
    @NotNull
    private final Inflater X;
    private int Y;
    private boolean Z;
    @NotNull
    private final BufferedSource s;

    public InflaterSource(@NotNull BufferedSource bufferedSource, @NotNull Inflater inflater) {
        Intrinsics.p(bufferedSource, "source");
        Intrinsics.p(inflater, "inflater");
        this.s = bufferedSource;
        this.X = inflater;
    }

    private final void d() {
        int i2 = this.Y;
        if (i2 != 0) {
            int remaining = i2 - this.X.getRemaining();
            this.Y -= remaining;
            this.s.skip((long) remaining);
        }
    }

    public final long b(@NotNull Buffer buffer, long j2) throws IOException {
        Intrinsics.p(buffer, "sink");
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(Intrinsics.C("byteCount < 0: ", Long.valueOf(j2)).toString());
        } else if (!(!this.Z)) {
            throw new IllegalStateException("closed".toString());
        } else if (i2 == 0) {
            return 0;
        } else {
            try {
                Segment Y0 = buffer.Y0(1);
                int min = (int) Math.min(j2, (long) (8192 - Y0.f31384c));
                c();
                int inflate = this.X.inflate(Y0.f31382a, Y0.f31384c, min);
                d();
                if (inflate > 0) {
                    Y0.f31384c += inflate;
                    long j3 = (long) inflate;
                    buffer.C0(buffer.L0() + j3);
                    return j3;
                }
                if (Y0.f31383b == Y0.f31384c) {
                    buffer.s = Y0.b();
                    SegmentPool.d(Y0);
                }
                return 0;
            } catch (DataFormatException e2) {
                throw new IOException(e2);
            }
        }
    }

    public final boolean c() throws IOException {
        if (!this.X.needsInput()) {
            return false;
        }
        if (this.s.o0()) {
            return true;
        }
        Segment segment = this.s.m().s;
        Intrinsics.m(segment);
        int i2 = segment.f31384c;
        int i3 = segment.f31383b;
        int i4 = i2 - i3;
        this.Y = i4;
        this.X.setInput(segment.f31382a, i3, i4);
        return false;
    }

    public void close() throws IOException {
        if (!this.Z) {
            this.X.end();
            this.Z = true;
            this.s.close();
        }
    }

    @NotNull
    public Timeout j() {
        return this.s.j();
    }

    public long n2(@NotNull Buffer buffer, long j2) throws IOException {
        Intrinsics.p(buffer, "sink");
        do {
            long b2 = b(buffer, j2);
            if (b2 > 0) {
                return b2;
            }
            if (this.X.finished() || this.X.needsDictionary()) {
                return -1;
            }
        } while (!this.s.o0());
        throw new EOFException("source exhausted prematurely");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InflaterSource(@NotNull Source source, @NotNull Inflater inflater) {
        this(Okio.e(source), inflater);
        Intrinsics.p(source, "source");
        Intrinsics.p(inflater, "inflater");
    }
}
