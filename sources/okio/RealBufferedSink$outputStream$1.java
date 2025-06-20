package okio;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, d2 = {"okio/RealBufferedSink$outputStream$1", "Ljava/io/OutputStream;", "close", "", "flush", "toString", "", "write", "data", "", "offset", "", "byteCount", "b", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RealBufferedSink$outputStream$1 extends OutputStream {
    final /* synthetic */ RealBufferedSink s;

    RealBufferedSink$outputStream$1(RealBufferedSink realBufferedSink) {
        this.s = realBufferedSink;
    }

    public void close() {
        this.s.close();
    }

    public void flush() {
        RealBufferedSink realBufferedSink = this.s;
        if (!realBufferedSink.Y) {
            realBufferedSink.flush();
        }
    }

    @NotNull
    public String toString() {
        return this.s + ".outputStream()";
    }

    public void write(int i2) {
        RealBufferedSink realBufferedSink = this.s;
        if (!realBufferedSink.Y) {
            realBufferedSink.X.writeByte((byte) i2);
            this.s.F0();
            return;
        }
        throw new IOException("closed");
    }

    public void write(@NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.p(bArr, "data");
        RealBufferedSink realBufferedSink = this.s;
        if (!realBufferedSink.Y) {
            realBufferedSink.X.write(bArr, i2, i3);
            this.s.F0();
            return;
        }
        throw new IOException("closed");
    }
}
