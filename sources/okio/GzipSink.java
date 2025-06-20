package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0007J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0007J\u000f\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001e\u001a\u00020\u00158G¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0017R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lokio/GzipSink;", "Lokio/Sink;", "sink", "<init>", "(Lokio/Sink;)V", "", "e", "()V", "Lokio/Buffer;", "buffer", "", "byteCount", "d", "(Lokio/Buffer;J)V", "source", "u1", "flush", "Lokio/Timeout;", "j", "()Lokio/Timeout;", "close", "Ljava/util/zip/Deflater;", "b", "()Ljava/util/zip/Deflater;", "Lokio/RealBufferedSink;", "s", "Lokio/RealBufferedSink;", "X", "Ljava/util/zip/Deflater;", "c", "deflater", "Lokio/DeflaterSink;", "Y", "Lokio/DeflaterSink;", "deflaterSink", "", "Z", "closed", "Ljava/util/zip/CRC32;", "X2", "Ljava/util/zip/CRC32;", "crc", "okio"}, k = 1, mv = {1, 5, 1})
public final class GzipSink implements Sink {
    @NotNull
    private final Deflater X;
    @NotNull
    private final CRC32 X2 = new CRC32();
    @NotNull
    private final DeflaterSink Y;
    private boolean Z;
    @NotNull
    private final RealBufferedSink s;

    public GzipSink(@NotNull Sink sink) {
        Intrinsics.p(sink, "sink");
        RealBufferedSink realBufferedSink = new RealBufferedSink(sink);
        this.s = realBufferedSink;
        Deflater deflater = new Deflater(-1, true);
        this.X = deflater;
        this.Y = new DeflaterSink((BufferedSink) realBufferedSink, deflater);
        Buffer buffer = realBufferedSink.X;
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    private final void d(Buffer buffer, long j2) {
        Segment segment = buffer.s;
        while (true) {
            Intrinsics.m(segment);
            if (j2 > 0) {
                int min = (int) Math.min(j2, (long) (segment.f31384c - segment.f31383b));
                this.X2.update(segment.f31382a, segment.f31383b, min);
                j2 -= (long) min;
                segment = segment.f31387f;
            } else {
                return;
            }
        }
    }

    private final void e() {
        this.s.n0((int) this.X2.getValue());
        this.s.n0((int) this.X.getBytesRead());
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "deflater", imports = {}))
    @JvmName(name = "-deprecated_deflater")
    public final Deflater b() {
        return this.X;
    }

    @NotNull
    @JvmName(name = "deflater")
    public final Deflater c() {
        return this.X;
    }

    public void close() throws IOException {
        if (!this.Z) {
            try {
                this.Y.c();
                e();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.X.end();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            try {
                this.s.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.Z = true;
            if (th != null) {
                throw th;
            }
        }
    }

    public void flush() throws IOException {
        this.Y.flush();
    }

    @NotNull
    public Timeout j() {
        return this.s.j();
    }

    public void u1(@NotNull Buffer buffer, long j2) throws IOException {
        Intrinsics.p(buffer, "source");
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(Intrinsics.C("byteCount < 0: ", Long.valueOf(j2)).toString());
        } else if (i2 != 0) {
            d(buffer, j2);
            this.Y.u1(buffer, j2);
        }
    }
}
