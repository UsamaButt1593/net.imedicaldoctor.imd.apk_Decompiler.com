package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.dd.plist.ASCIIPropertyListParser;
import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0013H\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010$\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J/\u0010&\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J'\u0010)\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020(2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0013H\u0016¢\u0006\u0004\b)\u0010+J\u0017\u0010)\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020,H\u0016¢\u0006\u0004\b)\u0010-J\u0017\u0010/\u001a\u00020\n2\u0006\u0010\t\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u001f\u00101\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020.2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u0013H\u0016¢\u0006\u0004\b4\u0010!J\u0017\u00106\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u0013H\u0016¢\u0006\u0004\b6\u0010!J\u0017\u00107\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u0013H\u0016¢\u0006\u0004\b7\u0010!J\u0017\u00109\u001a\u00020\u00012\u0006\u00108\u001a\u00020\u0013H\u0016¢\u0006\u0004\b9\u0010!J\u0017\u0010:\u001a\u00020\u00012\u0006\u00108\u001a\u00020\u0013H\u0016¢\u0006\u0004\b:\u0010!J\u0017\u0010<\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\nH\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\nH\u0016¢\u0006\u0004\b>\u0010=J\u0017\u0010?\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\nH\u0016¢\u0006\u0004\b?\u0010=J\u0017\u0010@\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\nH\u0016¢\u0006\u0004\b@\u0010=J\u000f\u0010A\u001a\u00020\u0001H\u0016¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0001H\u0016¢\u0006\u0004\bC\u0010BJ\u000f\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\fH\u0016¢\u0006\u0004\bG\u0010HJ\u000f\u0010J\u001a\u00020IH\u0016¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\fH\u0016¢\u0006\u0004\bL\u0010HJ\u000f\u0010N\u001a\u00020MH\u0016¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\u0017H\u0016¢\u0006\u0004\bP\u0010QR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b5\u0010RR\u0014\u0010U\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020I8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b>\u0010VR\u001b\u0010Y\u001a\u00020\u00068Ö\u0002X\u0004¢\u0006\f\u0012\u0004\b3\u0010H\u001a\u0004\bX\u0010\b¨\u0006Z"}, d2 = {"Lokio/RealBufferedSink;", "Lokio/BufferedSink;", "Lokio/Sink;", "sink", "<init>", "(Lokio/Sink;)V", "Lokio/Buffer;", "g", "()Lokio/Buffer;", "source", "", "byteCount", "", "u1", "(Lokio/Buffer;J)V", "Lokio/ByteString;", "byteString", "g2", "(Lokio/ByteString;)Lokio/BufferedSink;", "", "offset", "V", "(Lokio/ByteString;II)Lokio/BufferedSink;", "", "string", "W0", "(Ljava/lang/String;)Lokio/BufferedSink;", "beginIndex", "endIndex", "w1", "(Ljava/lang/String;II)Lokio/BufferedSink;", "codePoint", "U", "(I)Lokio/BufferedSink;", "Ljava/nio/charset/Charset;", "charset", "C1", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lokio/BufferedSink;", "E2", "(Ljava/lang/String;IILjava/nio/charset/Charset;)Lokio/BufferedSink;", "", "write", "([B)Lokio/BufferedSink;", "([BII)Lokio/BufferedSink;", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)I", "Lokio/Source;", "y1", "(Lokio/Source;)J", "H1", "(Lokio/Source;J)Lokio/BufferedSink;", "b", "writeByte", "s", "writeShort", "O0", "i", "writeInt", "n0", "v", "writeLong", "(J)Lokio/BufferedSink;", "Y", "L2", "z1", "F0", "()Lokio/BufferedSink;", "M", "Ljava/io/OutputStream;", "M2", "()Ljava/io/OutputStream;", "flush", "()V", "", "isOpen", "()Z", "close", "Lokio/Timeout;", "j", "()Lokio/Timeout;", "toString", "()Ljava/lang/String;", "Lokio/Sink;", "X", "Lokio/Buffer;", "bufferField", "Z", "closed", "m", "buffer", "okio"}, k = 1, mv = {1, 5, 1})
public final class RealBufferedSink implements BufferedSink {
    @NotNull
    @JvmField
    public final Buffer X = new Buffer();
    @JvmField
    public boolean Y;
    @NotNull
    @JvmField
    public final Sink s;

    public RealBufferedSink(@NotNull Sink sink) {
        Intrinsics.p(sink, "sink");
        this.s = sink;
    }

    public static /* synthetic */ void b() {
    }

    @NotNull
    public BufferedSink C1(@NotNull String str, @NotNull Charset charset) {
        Intrinsics.p(str, TypedValues.Custom.f3952e);
        Intrinsics.p(charset, "charset");
        if (!this.Y) {
            this.X.C1(str, charset);
            return F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink E2(@NotNull String str, int i2, int i3, @NotNull Charset charset) {
        Intrinsics.p(str, TypedValues.Custom.f3952e);
        Intrinsics.p(charset, "charset");
        if (!this.Y) {
            this.X.E2(str, i2, i3, charset);
            return F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink F0() {
        if (!this.Y) {
            long f2 = this.X.f();
            if (f2 > 0) {
                this.s.u1(this.X, f2);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink H1(@NotNull Source source, long j2) {
        Intrinsics.p(source, "source");
        while (j2 > 0) {
            long n2 = source.n2(this.X, j2);
            if (n2 != -1) {
                j2 -= n2;
                F0();
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    @NotNull
    public BufferedSink L2(long j2) {
        if (!this.Y) {
            this.X.L2(j2);
            return F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink M() {
        if (!this.Y) {
            long L0 = this.X.L0();
            if (L0 > 0) {
                this.s.u1(this.X, L0);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public OutputStream M2() {
        return new RealBufferedSink$outputStream$1(this);
    }

    @NotNull
    public BufferedSink O0(int i2) {
        if (!this.Y) {
            this.X.O0(i2);
            return F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink U(int i2) {
        if (!this.Y) {
            this.X.U(i2);
            return F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink V(@NotNull ByteString byteString, int i2, int i3) {
        Intrinsics.p(byteString, "byteString");
        if (!this.Y) {
            this.X.V(byteString, i2, i3);
            return F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink W0(@NotNull String str) {
        Intrinsics.p(str, TypedValues.Custom.f3952e);
        if (!this.Y) {
            this.X.W0(str);
            return F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink Y(long j2) {
        if (!this.Y) {
            this.X.Y(j2);
            return F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    public void close() {
        if (!this.Y) {
            try {
                if (this.X.L0() > 0) {
                    Sink sink = this.s;
                    Buffer buffer = this.X;
                    sink.u1(buffer, buffer.L0());
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.s.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            this.Y = true;
            if (th != null) {
                throw th;
            }
        }
    }

    public void flush() {
        if (!this.Y) {
            if (this.X.L0() > 0) {
                Sink sink = this.s;
                Buffer buffer = this.X;
                sink.u1(buffer, buffer.L0());
            }
            this.s.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public Buffer g() {
        return this.X;
    }

    @NotNull
    public BufferedSink g2(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "byteString");
        if (!this.Y) {
            this.X.g2(byteString);
            return F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    public boolean isOpen() {
        return !this.Y;
    }

    @NotNull
    public Timeout j() {
        return this.s.j();
    }

    @NotNull
    public Buffer m() {
        return this.X;
    }

    @NotNull
    public BufferedSink n0(int i2) {
        if (!this.Y) {
            this.X.n0(i2);
            return F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public String toString() {
        return "buffer(" + this.s + ASCIIPropertyListParser.f18650h;
    }

    public void u1(@NotNull Buffer buffer, long j2) {
        Intrinsics.p(buffer, "source");
        if (!this.Y) {
            this.X.u1(buffer, j2);
            F0();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink w1(@NotNull String str, int i2, int i3) {
        Intrinsics.p(str, TypedValues.Custom.f3952e);
        if (!this.Y) {
            this.X.w1(str, i2, i3);
            return F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    public int write(@NotNull ByteBuffer byteBuffer) {
        Intrinsics.p(byteBuffer, "source");
        if (!this.Y) {
            int write = this.X.write(byteBuffer);
            F0();
            return write;
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink writeByte(int i2) {
        if (!this.Y) {
            this.X.writeByte(i2);
            return F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink writeInt(int i2) {
        if (!this.Y) {
            this.X.writeInt(i2);
            return F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink writeLong(long j2) {
        if (!this.Y) {
            this.X.writeLong(j2);
            return F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink writeShort(int i2) {
        if (!this.Y) {
            this.X.writeShort(i2);
            return F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    public long y1(@NotNull Source source) {
        Intrinsics.p(source, "source");
        long j2 = 0;
        while (true) {
            long n2 = source.n2(this.X, PlaybackStateCompat.s3);
            if (n2 == -1) {
                return j2;
            }
            j2 += n2;
            F0();
        }
    }

    @NotNull
    public BufferedSink z1(long j2) {
        if (!this.Y) {
            this.X.z1(j2);
            return F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink write(@NotNull byte[] bArr) {
        Intrinsics.p(bArr, "source");
        if (!this.Y) {
            this.X.write(bArr);
            return F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public BufferedSink write(@NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.p(bArr, "source");
        if (!this.Y) {
            this.X.write(bArr, i2, i3);
            return F0();
        }
        throw new IllegalStateException("closed".toString());
    }
}
