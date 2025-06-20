package okio;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"okio/Buffer$inputStream$1", "Ljava/io/InputStream;", "available", "", "close", "", "read", "sink", "", "offset", "byteCount", "toString", "", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Buffer$inputStream$1 extends InputStream {
    final /* synthetic */ Buffer s;

    Buffer$inputStream$1(Buffer buffer) {
        this.s = buffer;
    }

    public int available() {
        return (int) Math.min(this.s.L0(), (long) Integer.MAX_VALUE);
    }

    public void close() {
    }

    public int read() {
        if (this.s.L0() > 0) {
            return this.s.readByte() & 255;
        }
        return -1;
    }

    @NotNull
    public String toString() {
        return this.s + ".inputStream()";
    }

    public int read(@NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.p(bArr, "sink");
        return this.s.read(bArr, i2, i3);
    }
}
