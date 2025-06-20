package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001b\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010&¨\u0006("}, d2 = {"Lokio/CipherSink;", "Lokio/Sink;", "Lokio/BufferedSink;", "sink", "Ljavax/crypto/Cipher;", "cipher", "<init>", "(Lokio/BufferedSink;Ljavax/crypto/Cipher;)V", "Lokio/Buffer;", "source", "", "remaining", "", "d", "(Lokio/Buffer;J)I", "", "b", "()Ljava/lang/Throwable;", "byteCount", "", "u1", "(Lokio/Buffer;J)V", "flush", "()V", "Lokio/Timeout;", "j", "()Lokio/Timeout;", "close", "s", "Lokio/BufferedSink;", "X", "Ljavax/crypto/Cipher;", "c", "()Ljavax/crypto/Cipher;", "Y", "I", "blockSize", "", "Z", "closed", "okio"}, k = 1, mv = {1, 5, 1})
public final class CipherSink implements Sink {
    @NotNull
    private final Cipher X;
    private final int Y;
    private boolean Z;
    @NotNull
    private final BufferedSink s;

    public CipherSink(@NotNull BufferedSink bufferedSink, @NotNull Cipher cipher) {
        Intrinsics.p(bufferedSink, "sink");
        Intrinsics.p(cipher, "cipher");
        this.s = bufferedSink;
        this.X = cipher;
        int blockSize = cipher.getBlockSize();
        this.Y = blockSize;
        if (!(blockSize > 0)) {
            throw new IllegalArgumentException(Intrinsics.C("Block cipher required ", c()).toString());
        }
    }

    private final Throwable b() {
        int outputSize = this.X.getOutputSize(0);
        Throwable th = null;
        if (outputSize == 0) {
            return null;
        }
        Buffer m2 = this.s.m();
        Segment Y0 = m2.Y0(outputSize);
        try {
            int doFinal = this.X.doFinal(Y0.f31382a, Y0.f31384c);
            Y0.f31384c += doFinal;
            m2.C0(m2.L0() + ((long) doFinal));
        } catch (Throwable th2) {
            th = th2;
        }
        if (Y0.f31383b == Y0.f31384c) {
            m2.s = Y0.b();
            SegmentPool.d(Y0);
        }
        return th;
    }

    private final int d(Buffer buffer, long j2) {
        Segment segment = buffer.s;
        Intrinsics.m(segment);
        int min = (int) Math.min(j2, (long) (segment.f31384c - segment.f31383b));
        Buffer m2 = this.s.m();
        while (true) {
            int outputSize = this.X.getOutputSize(min);
            if (outputSize > 8192) {
                int i2 = this.Y;
                if (min > i2) {
                    min -= i2;
                } else {
                    throw new IllegalStateException(("Unexpected output size " + outputSize + " for input size " + min).toString());
                }
            } else {
                Segment Y0 = m2.Y0(outputSize);
                int update = this.X.update(segment.f31382a, segment.f31383b, min, Y0.f31382a, Y0.f31384c);
                Y0.f31384c += update;
                m2.C0(m2.L0() + ((long) update));
                if (Y0.f31383b == Y0.f31384c) {
                    m2.s = Y0.b();
                    SegmentPool.d(Y0);
                }
                this.s.F0();
                buffer.C0(buffer.L0() - ((long) min));
                int i3 = segment.f31383b + min;
                segment.f31383b = i3;
                if (i3 == segment.f31384c) {
                    buffer.s = segment.b();
                    SegmentPool.d(segment);
                }
                return min;
            }
        }
    }

    @NotNull
    public final Cipher c() {
        return this.X;
    }

    public void close() throws IOException {
        if (!this.Z) {
            this.Z = true;
            Throwable b2 = b();
            try {
                this.s.close();
            } catch (Throwable th) {
                if (b2 == null) {
                    b2 = th;
                }
            }
            if (b2 != null) {
                throw b2;
            }
        }
    }

    public void flush() {
        this.s.flush();
    }

    @NotNull
    public Timeout j() {
        return this.s.j();
    }

    public void u1(@NotNull Buffer buffer, long j2) throws IOException {
        Intrinsics.p(buffer, "source");
        _UtilKt.e(buffer.L0(), 0, j2);
        if (!this.Z) {
            while (j2 > 0) {
                j2 -= (long) d(buffer, j2);
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }
}
