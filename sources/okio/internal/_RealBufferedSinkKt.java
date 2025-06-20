package okio.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.dd.plist.ASCIIPropertyListParser;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.RealBufferedSink;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a$\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001c\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\b¢\u0006\u0004\b\u000b\u0010\f\u001a,\u0010\u000f\u001a\u00020\n*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u0013\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a,\u0010\u0017\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001c\u0010\u001a\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\rH\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001c\u0010\u001d\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001cH\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a,\u0010\u001f\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\b¢\u0006\u0004\b\u001f\u0010 \u001a\u001c\u0010\"\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020!H\b¢\u0006\u0004\b\"\u0010#\u001a$\u0010$\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020!2\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b$\u0010%\u001a\u001c\u0010'\u001a\u00020\n*\u00020\u00002\u0006\u0010&\u001a\u00020\rH\b¢\u0006\u0004\b'\u0010\u001b\u001a\u001c\u0010)\u001a\u00020\n*\u00020\u00002\u0006\u0010(\u001a\u00020\rH\b¢\u0006\u0004\b)\u0010\u001b\u001a\u001c\u0010*\u001a\u00020\n*\u00020\u00002\u0006\u0010(\u001a\u00020\rH\b¢\u0006\u0004\b*\u0010\u001b\u001a\u001c\u0010+\u001a\u00020\n*\u00020\u00002\u0006\u0010$\u001a\u00020\rH\b¢\u0006\u0004\b+\u0010\u001b\u001a\u001c\u0010,\u001a\u00020\n*\u00020\u00002\u0006\u0010$\u001a\u00020\rH\b¢\u0006\u0004\b,\u0010\u001b\u001a\u001c\u0010(\u001a\u00020\n*\u00020\u00002\u0006\u0010*\u001a\u00020\u0003H\b¢\u0006\u0004\b(\u0010-\u001a\u001c\u0010.\u001a\u00020\n*\u00020\u00002\u0006\u0010*\u001a\u00020\u0003H\b¢\u0006\u0004\b.\u0010-\u001a\u001c\u0010/\u001a\u00020\n*\u00020\u00002\u0006\u0010*\u001a\u00020\u0003H\b¢\u0006\u0004\b/\u0010-\u001a\u001c\u00100\u001a\u00020\n*\u00020\u00002\u0006\u0010*\u001a\u00020\u0003H\b¢\u0006\u0004\b0\u0010-\u001a\u0014\u00101\u001a\u00020\n*\u00020\u0000H\b¢\u0006\u0004\b1\u00102\u001a\u0014\u0010&\u001a\u00020\n*\u00020\u0000H\b¢\u0006\u0004\b&\u00102\u001a\u0014\u00103\u001a\u00020\u0005*\u00020\u0000H\b¢\u0006\u0004\b3\u00104\u001a\u0014\u00105\u001a\u00020\u0005*\u00020\u0000H\b¢\u0006\u0004\b5\u00104\u001a\u0014\u00107\u001a\u000206*\u00020\u0000H\b¢\u0006\u0004\b7\u00108\u001a\u0014\u00109\u001a\u00020\u0011*\u00020\u0000H\b¢\u0006\u0004\b9\u0010:¨\u0006;"}, d2 = {"Lokio/RealBufferedSink;", "Lokio/Buffer;", "source", "", "byteCount", "", "l", "(Lokio/RealBufferedSink;Lokio/Buffer;J)V", "Lokio/ByteString;", "byteString", "Lokio/BufferedSink;", "g", "(Lokio/RealBufferedSink;Lokio/ByteString;)Lokio/BufferedSink;", "", "offset", "h", "(Lokio/RealBufferedSink;Lokio/ByteString;II)Lokio/BufferedSink;", "", "string", "w", "(Lokio/RealBufferedSink;Ljava/lang/String;)Lokio/BufferedSink;", "beginIndex", "endIndex", "x", "(Lokio/RealBufferedSink;Ljava/lang/String;II)Lokio/BufferedSink;", "codePoint", "y", "(Lokio/RealBufferedSink;I)Lokio/BufferedSink;", "", "j", "(Lokio/RealBufferedSink;[B)Lokio/BufferedSink;", "k", "(Lokio/RealBufferedSink;[BII)Lokio/BufferedSink;", "Lokio/Source;", "m", "(Lokio/RealBufferedSink;Lokio/Source;)J", "i", "(Lokio/RealBufferedSink;Lokio/Source;J)Lokio/BufferedSink;", "b", "n", "s", "u", "v", "q", "r", "(Lokio/RealBufferedSink;J)Lokio/BufferedSink;", "t", "o", "p", "c", "(Lokio/RealBufferedSink;)Lokio/BufferedSink;", "d", "(Lokio/RealBufferedSink;)V", "a", "Lokio/Timeout;", "e", "(Lokio/RealBufferedSink;)Lokio/Timeout;", "f", "(Lokio/RealBufferedSink;)Ljava/lang/String;", "okio"}, k = 2, mv = {1, 5, 1})
public final class _RealBufferedSinkKt {
    public static final void a(@NotNull RealBufferedSink realBufferedSink) {
        Intrinsics.p(realBufferedSink, "<this>");
        if (!realBufferedSink.Y) {
            try {
                if (realBufferedSink.X.L0() > 0) {
                    Sink sink = realBufferedSink.s;
                    Buffer buffer = realBufferedSink.X;
                    sink.u1(buffer, buffer.L0());
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                realBufferedSink.s.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            realBufferedSink.Y = true;
            if (th != null) {
                throw th;
            }
        }
    }

    @NotNull
    public static final BufferedSink b(@NotNull RealBufferedSink realBufferedSink) {
        Intrinsics.p(realBufferedSink, "<this>");
        if (!realBufferedSink.Y) {
            long L0 = realBufferedSink.X.L0();
            if (L0 > 0) {
                realBufferedSink.s.u1(realBufferedSink.X, L0);
            }
            return realBufferedSink;
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink c(@NotNull RealBufferedSink realBufferedSink) {
        Intrinsics.p(realBufferedSink, "<this>");
        if (!realBufferedSink.Y) {
            long f2 = realBufferedSink.X.f();
            if (f2 > 0) {
                realBufferedSink.s.u1(realBufferedSink.X, f2);
            }
            return realBufferedSink;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final void d(@NotNull RealBufferedSink realBufferedSink) {
        Intrinsics.p(realBufferedSink, "<this>");
        if (!realBufferedSink.Y) {
            if (realBufferedSink.X.L0() > 0) {
                Sink sink = realBufferedSink.s;
                Buffer buffer = realBufferedSink.X;
                sink.u1(buffer, buffer.L0());
            }
            realBufferedSink.s.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final Timeout e(@NotNull RealBufferedSink realBufferedSink) {
        Intrinsics.p(realBufferedSink, "<this>");
        return realBufferedSink.s.j();
    }

    @NotNull
    public static final String f(@NotNull RealBufferedSink realBufferedSink) {
        Intrinsics.p(realBufferedSink, "<this>");
        return "buffer(" + realBufferedSink.s + ASCIIPropertyListParser.f18650h;
    }

    @NotNull
    public static final BufferedSink g(@NotNull RealBufferedSink realBufferedSink, @NotNull ByteString byteString) {
        Intrinsics.p(realBufferedSink, "<this>");
        Intrinsics.p(byteString, "byteString");
        if (!realBufferedSink.Y) {
            realBufferedSink.X.g2(byteString);
            return realBufferedSink.F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink h(@NotNull RealBufferedSink realBufferedSink, @NotNull ByteString byteString, int i2, int i3) {
        Intrinsics.p(realBufferedSink, "<this>");
        Intrinsics.p(byteString, "byteString");
        if (!realBufferedSink.Y) {
            realBufferedSink.X.V(byteString, i2, i3);
            return realBufferedSink.F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink i(@NotNull RealBufferedSink realBufferedSink, @NotNull Source source, long j2) {
        Intrinsics.p(realBufferedSink, "<this>");
        Intrinsics.p(source, "source");
        while (j2 > 0) {
            long n2 = source.n2(realBufferedSink.X, j2);
            if (n2 != -1) {
                j2 -= n2;
                realBufferedSink.F0();
            } else {
                throw new EOFException();
            }
        }
        return realBufferedSink;
    }

    @NotNull
    public static final BufferedSink j(@NotNull RealBufferedSink realBufferedSink, @NotNull byte[] bArr) {
        Intrinsics.p(realBufferedSink, "<this>");
        Intrinsics.p(bArr, "source");
        if (!realBufferedSink.Y) {
            realBufferedSink.X.write(bArr);
            return realBufferedSink.F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink k(@NotNull RealBufferedSink realBufferedSink, @NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.p(realBufferedSink, "<this>");
        Intrinsics.p(bArr, "source");
        if (!realBufferedSink.Y) {
            realBufferedSink.X.write(bArr, i2, i3);
            return realBufferedSink.F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final void l(@NotNull RealBufferedSink realBufferedSink, @NotNull Buffer buffer, long j2) {
        Intrinsics.p(realBufferedSink, "<this>");
        Intrinsics.p(buffer, "source");
        if (!realBufferedSink.Y) {
            realBufferedSink.X.u1(buffer, j2);
            realBufferedSink.F0();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long m(@NotNull RealBufferedSink realBufferedSink, @NotNull Source source) {
        Intrinsics.p(realBufferedSink, "<this>");
        Intrinsics.p(source, "source");
        long j2 = 0;
        while (true) {
            long n2 = source.n2(realBufferedSink.X, PlaybackStateCompat.s3);
            if (n2 == -1) {
                return j2;
            }
            j2 += n2;
            realBufferedSink.F0();
        }
    }

    @NotNull
    public static final BufferedSink n(@NotNull RealBufferedSink realBufferedSink, int i2) {
        Intrinsics.p(realBufferedSink, "<this>");
        if (!realBufferedSink.Y) {
            realBufferedSink.X.writeByte(i2);
            return realBufferedSink.F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink o(@NotNull RealBufferedSink realBufferedSink, long j2) {
        Intrinsics.p(realBufferedSink, "<this>");
        if (!realBufferedSink.Y) {
            realBufferedSink.X.L2(j2);
            return realBufferedSink.F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink p(@NotNull RealBufferedSink realBufferedSink, long j2) {
        Intrinsics.p(realBufferedSink, "<this>");
        if (!realBufferedSink.Y) {
            realBufferedSink.X.z1(j2);
            return realBufferedSink.F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink q(@NotNull RealBufferedSink realBufferedSink, int i2) {
        Intrinsics.p(realBufferedSink, "<this>");
        if (!realBufferedSink.Y) {
            realBufferedSink.X.writeInt(i2);
            return realBufferedSink.F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink r(@NotNull RealBufferedSink realBufferedSink, int i2) {
        Intrinsics.p(realBufferedSink, "<this>");
        if (!realBufferedSink.Y) {
            realBufferedSink.X.n0(i2);
            return realBufferedSink.F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink s(@NotNull RealBufferedSink realBufferedSink, long j2) {
        Intrinsics.p(realBufferedSink, "<this>");
        if (!realBufferedSink.Y) {
            realBufferedSink.X.writeLong(j2);
            return realBufferedSink.F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink t(@NotNull RealBufferedSink realBufferedSink, long j2) {
        Intrinsics.p(realBufferedSink, "<this>");
        if (!realBufferedSink.Y) {
            realBufferedSink.X.Y(j2);
            return realBufferedSink.F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink u(@NotNull RealBufferedSink realBufferedSink, int i2) {
        Intrinsics.p(realBufferedSink, "<this>");
        if (!realBufferedSink.Y) {
            realBufferedSink.X.writeShort(i2);
            return realBufferedSink.F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink v(@NotNull RealBufferedSink realBufferedSink, int i2) {
        Intrinsics.p(realBufferedSink, "<this>");
        if (!realBufferedSink.Y) {
            realBufferedSink.X.O0(i2);
            return realBufferedSink.F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink w(@NotNull RealBufferedSink realBufferedSink, @NotNull String str) {
        Intrinsics.p(realBufferedSink, "<this>");
        Intrinsics.p(str, TypedValues.Custom.f3952e);
        if (!realBufferedSink.Y) {
            realBufferedSink.X.W0(str);
            return realBufferedSink.F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink x(@NotNull RealBufferedSink realBufferedSink, @NotNull String str, int i2, int i3) {
        Intrinsics.p(realBufferedSink, "<this>");
        Intrinsics.p(str, TypedValues.Custom.f3952e);
        if (!realBufferedSink.Y) {
            realBufferedSink.X.w1(str, i2, i3);
            return realBufferedSink.F0();
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink y(@NotNull RealBufferedSink realBufferedSink, int i2) {
        Intrinsics.p(realBufferedSink, "<this>");
        if (!realBufferedSink.Y) {
            realBufferedSink.X.U(i2);
            return realBufferedSink.F0();
        }
        throw new IllegalStateException("closed".toString());
    }
}
