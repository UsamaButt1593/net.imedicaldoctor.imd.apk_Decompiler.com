package okio;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0003¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lokio/DeflaterSink;", "Lokio/Sink;", "Lokio/BufferedSink;", "sink", "Ljava/util/zip/Deflater;", "deflater", "<init>", "(Lokio/BufferedSink;Ljava/util/zip/Deflater;)V", "(Lokio/Sink;Ljava/util/zip/Deflater;)V", "", "syncFlush", "", "b", "(Z)V", "Lokio/Buffer;", "source", "", "byteCount", "u1", "(Lokio/Buffer;J)V", "flush", "()V", "c", "close", "Lokio/Timeout;", "j", "()Lokio/Timeout;", "", "toString", "()Ljava/lang/String;", "s", "Lokio/BufferedSink;", "X", "Ljava/util/zip/Deflater;", "Y", "Z", "closed", "okio"}, k = 1, mv = {1, 5, 1})
public final class DeflaterSink implements Sink {
    @NotNull
    private final Deflater X;
    private boolean Y;
    @NotNull
    private final BufferedSink s;

    public DeflaterSink(@NotNull BufferedSink bufferedSink, @NotNull Deflater deflater) {
        Intrinsics.p(bufferedSink, "sink");
        Intrinsics.p(deflater, "deflater");
        this.s = bufferedSink;
        this.X = deflater;
    }

    @IgnoreJRERequirement
    private final void b(boolean z) {
        Segment Y0;
        Buffer m2 = this.s.m();
        while (true) {
            Y0 = m2.Y0(1);
            Deflater deflater = this.X;
            byte[] bArr = Y0.f31382a;
            int i2 = Y0.f31384c;
            int i3 = 8192 - i2;
            int deflate = z ? deflater.deflate(bArr, i2, i3, 2) : deflater.deflate(bArr, i2, i3);
            if (deflate > 0) {
                Y0.f31384c += deflate;
                m2.C0(m2.L0() + ((long) deflate));
                this.s.F0();
            } else if (this.X.needsInput()) {
                break;
            }
        }
        if (Y0.f31383b == Y0.f31384c) {
            m2.s = Y0.b();
            SegmentPool.d(Y0);
        }
    }

    public final void c() {
        this.X.finish();
        b(false);
    }

    public void close() throws IOException {
        if (!this.Y) {
            try {
                c();
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
            this.Y = true;
            if (th != null) {
                throw th;
            }
        }
    }

    public void flush() throws IOException {
        b(true);
        this.s.flush();
    }

    @NotNull
    public Timeout j() {
        return this.s.j();
    }

    @NotNull
    public String toString() {
        return "DeflaterSink(" + this.s + ASCIIPropertyListParser.f18650h;
    }

    public void u1(@NotNull Buffer buffer, long j2) throws IOException {
        Intrinsics.p(buffer, "source");
        _UtilKt.e(buffer.L0(), 0, j2);
        while (j2 > 0) {
            Segment segment = buffer.s;
            Intrinsics.m(segment);
            int min = (int) Math.min(j2, (long) (segment.f31384c - segment.f31383b));
            this.X.setInput(segment.f31382a, segment.f31383b, min);
            b(false);
            long j3 = (long) min;
            buffer.C0(buffer.L0() - j3);
            int i2 = segment.f31383b + min;
            segment.f31383b = i2;
            if (i2 == segment.f31384c) {
                buffer.s = segment.b();
                SegmentPool.d(segment);
            }
            j2 -= j3;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DeflaterSink(@NotNull Sink sink, @NotNull Deflater deflater) {
        this(Okio.d(sink), deflater);
        Intrinsics.p(sink, "sink");
        Intrinsics.p(deflater, "deflater");
    }
}
