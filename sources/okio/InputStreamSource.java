package okio;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0012\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lokio/InputStreamSource;", "Lokio/Source;", "Ljava/io/InputStream;", "input", "Lokio/Timeout;", "timeout", "<init>", "(Ljava/io/InputStream;Lokio/Timeout;)V", "Lokio/Buffer;", "sink", "", "byteCount", "n2", "(Lokio/Buffer;J)J", "", "close", "()V", "j", "()Lokio/Timeout;", "", "toString", "()Ljava/lang/String;", "s", "Ljava/io/InputStream;", "X", "Lokio/Timeout;", "okio"}, k = 1, mv = {1, 5, 1})
class InputStreamSource implements Source {
    @NotNull
    private final Timeout X;
    @NotNull
    private final InputStream s;

    public InputStreamSource(@NotNull InputStream inputStream, @NotNull Timeout timeout) {
        Intrinsics.p(inputStream, HTML.Tag.q0);
        Intrinsics.p(timeout, "timeout");
        this.s = inputStream;
        this.X = timeout;
    }

    public void close() {
        this.s.close();
    }

    @NotNull
    public Timeout j() {
        return this.X;
    }

    public long n2(@NotNull Buffer buffer, long j2) {
        Intrinsics.p(buffer, "sink");
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 == 0) {
            return 0;
        }
        if (i2 >= 0) {
            try {
                this.X.h();
                Segment Y0 = buffer.Y0(1);
                int read = this.s.read(Y0.f31382a, Y0.f31384c, (int) Math.min(j2, (long) (8192 - Y0.f31384c)));
                if (read != -1) {
                    Y0.f31384c += read;
                    long j3 = (long) read;
                    buffer.C0(buffer.L0() + j3);
                    return j3;
                } else if (Y0.f31383b != Y0.f31384c) {
                    return -1;
                } else {
                    buffer.s = Y0.b();
                    SegmentPool.d(Y0);
                    return -1;
                }
            } catch (AssertionError e2) {
                if (Okio.l(e2)) {
                    throw new IOException(e2);
                }
                throw e2;
            }
        } else {
            throw new IllegalArgumentException(Intrinsics.C("byteCount < 0: ", Long.valueOf(j2)).toString());
        }
    }

    @NotNull
    public String toString() {
        return "source(" + this.s + ASCIIPropertyListParser.f18650h;
    }
}
