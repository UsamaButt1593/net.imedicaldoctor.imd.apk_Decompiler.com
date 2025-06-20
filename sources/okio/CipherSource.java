package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\u001f\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010!R\u0016\u0010(\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010!¨\u0006)"}, d2 = {"Lokio/CipherSource;", "Lokio/Source;", "Lokio/BufferedSource;", "source", "Ljavax/crypto/Cipher;", "cipher", "<init>", "(Lokio/BufferedSource;Ljavax/crypto/Cipher;)V", "", "d", "()V", "e", "b", "Lokio/Buffer;", "sink", "", "byteCount", "n2", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "j", "()Lokio/Timeout;", "close", "s", "Lokio/BufferedSource;", "X", "Ljavax/crypto/Cipher;", "c", "()Ljavax/crypto/Cipher;", "", "Y", "I", "blockSize", "Z", "Lokio/Buffer;", "buffer", "", "X2", "final", "Y2", "closed", "okio"}, k = 1, mv = {1, 5, 1})
public final class CipherSource implements Source {
    @NotNull
    private final Cipher X;
    private boolean X2;
    private final int Y;
    private boolean Y2;
    @NotNull
    private final Buffer Z = new Buffer();
    @NotNull
    private final BufferedSource s;

    public CipherSource(@NotNull BufferedSource bufferedSource, @NotNull Cipher cipher) {
        Intrinsics.p(bufferedSource, "source");
        Intrinsics.p(cipher, "cipher");
        this.s = bufferedSource;
        this.X = cipher;
        int blockSize = cipher.getBlockSize();
        this.Y = blockSize;
        if (!(blockSize > 0)) {
            throw new IllegalArgumentException(Intrinsics.C("Block cipher required ", c()).toString());
        }
    }

    private final void b() {
        int outputSize = this.X.getOutputSize(0);
        if (outputSize != 0) {
            Segment Y0 = this.Z.Y0(outputSize);
            int doFinal = this.X.doFinal(Y0.f31382a, Y0.f31383b);
            Y0.f31384c += doFinal;
            Buffer buffer = this.Z;
            buffer.C0(buffer.L0() + ((long) doFinal));
            if (Y0.f31383b == Y0.f31384c) {
                this.Z.s = Y0.b();
                SegmentPool.d(Y0);
            }
        }
    }

    private final void d() {
        while (this.Z.L0() == 0) {
            if (this.s.o0()) {
                this.X2 = true;
                b();
                return;
            }
            e();
        }
    }

    private final void e() {
        Segment segment = this.s.m().s;
        Intrinsics.m(segment);
        int i2 = segment.f31384c - segment.f31383b;
        while (true) {
            int outputSize = this.X.getOutputSize(i2);
            if (outputSize > 8192) {
                int i3 = this.Y;
                if (i2 > i3) {
                    i2 -= i3;
                } else {
                    throw new IllegalStateException(("Unexpected output size " + outputSize + " for input size " + i2).toString());
                }
            } else {
                Segment Y0 = this.Z.Y0(outputSize);
                int update = this.X.update(segment.f31382a, segment.f31383b, i2, Y0.f31382a, Y0.f31383b);
                this.s.skip((long) i2);
                Y0.f31384c += update;
                Buffer buffer = this.Z;
                buffer.C0(buffer.L0() + ((long) update));
                if (Y0.f31383b == Y0.f31384c) {
                    this.Z.s = Y0.b();
                    SegmentPool.d(Y0);
                    return;
                }
                return;
            }
        }
    }

    @NotNull
    public final Cipher c() {
        return this.X;
    }

    public void close() throws IOException {
        this.Y2 = true;
        this.s.close();
    }

    @NotNull
    public Timeout j() {
        return this.s.j();
    }

    public long n2(@NotNull Buffer buffer, long j2) throws IOException {
        Intrinsics.p(buffer, "sink");
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(Intrinsics.C("byteCount < 0: ", Long.valueOf(j2)).toString());
        } else if (!(true ^ this.Y2)) {
            throw new IllegalStateException("closed".toString());
        } else if (i2 == 0) {
            return 0;
        } else {
            if (!this.X2) {
                d();
            }
            return this.Z.n2(buffer, j2);
        }
    }
}
