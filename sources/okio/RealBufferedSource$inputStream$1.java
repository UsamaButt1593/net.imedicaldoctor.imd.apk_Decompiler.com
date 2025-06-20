package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"okio/RealBufferedSource$inputStream$1", "Ljava/io/InputStream;", "available", "", "close", "", "read", "data", "", "offset", "byteCount", "toString", "", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RealBufferedSource$inputStream$1 extends InputStream {
    final /* synthetic */ RealBufferedSource s;

    RealBufferedSource$inputStream$1(RealBufferedSource realBufferedSource) {
        this.s = realBufferedSource;
    }

    public int available() {
        RealBufferedSource realBufferedSource = this.s;
        if (!realBufferedSource.Y) {
            return (int) Math.min(realBufferedSource.X.L0(), (long) Integer.MAX_VALUE);
        }
        throw new IOException("closed");
    }

    public void close() {
        this.s.close();
    }

    public int read() {
        RealBufferedSource realBufferedSource = this.s;
        if (!realBufferedSource.Y) {
            if (realBufferedSource.X.L0() == 0) {
                RealBufferedSource realBufferedSource2 = this.s;
                if (realBufferedSource2.s.n2(realBufferedSource2.X, PlaybackStateCompat.s3) == -1) {
                    return -1;
                }
            }
            return this.s.X.readByte() & 255;
        }
        throw new IOException("closed");
    }

    @NotNull
    public String toString() {
        return this.s + ".inputStream()";
    }

    public int read(@NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.p(bArr, "data");
        if (!this.s.Y) {
            _UtilKt.e((long) bArr.length, (long) i2, (long) i3);
            if (this.s.X.L0() == 0) {
                RealBufferedSource realBufferedSource = this.s;
                if (realBufferedSource.s.n2(realBufferedSource.X, PlaybackStateCompat.s3) == -1) {
                    return -1;
                }
            }
            return this.s.X.read(bArr, i2, i3);
        }
        throw new IOException("closed");
    }
}
