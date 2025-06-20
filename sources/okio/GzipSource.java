package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007J'\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u0007R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\u0002\u001a\u00020\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020%8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00061"}, d2 = {"Lokio/GzipSource;", "Lokio/Source;", "source", "<init>", "(Lokio/Source;)V", "", "c", "()V", "d", "Lokio/Buffer;", "buffer", "", "offset", "byteCount", "e", "(Lokio/Buffer;JJ)V", "", "name", "", "expected", "actual", "b", "(Ljava/lang/String;II)V", "sink", "n2", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "j", "()Lokio/Timeout;", "close", "", "s", "B", "section", "Lokio/RealBufferedSource;", "X", "Lokio/RealBufferedSource;", "Ljava/util/zip/Inflater;", "Y", "Ljava/util/zip/Inflater;", "inflater", "Lokio/InflaterSource;", "Z", "Lokio/InflaterSource;", "inflaterSource", "Ljava/util/zip/CRC32;", "X2", "Ljava/util/zip/CRC32;", "crc", "okio"}, k = 1, mv = {1, 5, 1})
public final class GzipSource implements Source {
    @NotNull
    private final RealBufferedSource X;
    @NotNull
    private final CRC32 X2 = new CRC32();
    @NotNull
    private final Inflater Y;
    @NotNull
    private final InflaterSource Z;
    private byte s;

    public GzipSource(@NotNull Source source) {
        Intrinsics.p(source, "source");
        RealBufferedSource realBufferedSource = new RealBufferedSource(source);
        this.X = realBufferedSource;
        Inflater inflater = new Inflater(true);
        this.Y = inflater;
        this.Z = new InflaterSource((BufferedSource) realBufferedSource, inflater);
    }

    private final void b(String str, int i2, int i3) {
        if (i3 != i2) {
            String format = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i3), Integer.valueOf(i2)}, 3));
            Intrinsics.o(format, "java.lang.String.format(this, *args)");
            throw new IOException(format);
        }
    }

    private final void c() throws IOException {
        this.X.I2(10);
        byte y = this.X.X.y(3);
        boolean z = ((y >> 1) & 1) == 1;
        if (z) {
            e(this.X.X, 0, 10);
        }
        b("ID1ID2", 8075, this.X.readShort());
        this.X.skip(8);
        if (((y >> 2) & 1) == 1) {
            this.X.I2(2);
            if (z) {
                e(this.X.X, 0, 2);
            }
            long j2 = (long) this.X.X.j2();
            this.X.I2(j2);
            if (z) {
                e(this.X.X, 0, j2);
            }
            this.X.skip(j2);
        }
        if (((y >> 3) & 1) == 1) {
            long N2 = this.X.N2((byte) 0);
            if (N2 != -1) {
                if (z) {
                    e(this.X.X, 0, N2 + 1);
                }
                this.X.skip(N2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((y >> 4) & 1) == 1) {
            long N22 = this.X.N2((byte) 0);
            if (N22 != -1) {
                if (z) {
                    e(this.X.X, 0, N22 + 1);
                }
                this.X.skip(N22 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            b("FHCRC", this.X.j2(), (short) ((int) this.X2.getValue()));
            this.X2.reset();
        }
    }

    private final void d() throws IOException {
        b("CRC", this.X.R1(), (int) this.X2.getValue());
        b("ISIZE", this.X.R1(), (int) this.Y.getBytesWritten());
    }

    private final void e(Buffer buffer, long j2, long j3) {
        Segment segment = buffer.s;
        while (true) {
            Intrinsics.m(segment);
            int i2 = segment.f31384c;
            int i3 = segment.f31383b;
            if (j2 < ((long) (i2 - i3))) {
                break;
            }
            j2 -= (long) (i2 - i3);
            segment = segment.f31387f;
        }
        while (j3 > 0) {
            int i4 = (int) (((long) segment.f31383b) + j2);
            int min = (int) Math.min((long) (segment.f31384c - i4), j3);
            this.X2.update(segment.f31382a, i4, min);
            j3 -= (long) min;
            segment = segment.f31387f;
            Intrinsics.m(segment);
            j2 = 0;
        }
    }

    public void close() throws IOException {
        this.Z.close();
    }

    @NotNull
    public Timeout j() {
        return this.X.j();
    }

    public long n2(@NotNull Buffer buffer, long j2) throws IOException {
        Intrinsics.p(buffer, "sink");
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(Intrinsics.C("byteCount < 0: ", Long.valueOf(j2)).toString());
        } else if (i2 == 0) {
            return 0;
        } else {
            if (this.s == 0) {
                c();
                this.s = 1;
            }
            if (this.s == 1) {
                long L0 = buffer.L0();
                long n2 = this.Z.n2(buffer, j2);
                if (n2 != -1) {
                    e(buffer, L0, n2);
                    return n2;
                }
                this.s = 2;
            }
            if (this.s == 2) {
                d();
                this.s = 3;
                if (!this.X.o0()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }
}
