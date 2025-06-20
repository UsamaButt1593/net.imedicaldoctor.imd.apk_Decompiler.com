package okio.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.dd.plist.ASCIIPropertyListParser;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Typography;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Timeout;
import okio._UtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\n\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0014\u0010\b\u001a\u00020\u0007*\u00020\u0000H\b¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0014\u0010\u0010\u001a\u00020\u000f*\u00020\u0000H\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0014\u0010\u0013\u001a\u00020\u0012*\u00020\u0000H\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001c\u0010\u0015\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001c\u0010\u001a\u001a\u00020\u0019*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017H\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0014\u0010\u001d\u001a\u00020\u001c*\u00020\u0000H\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001c\u0010\u001f\u001a\u00020\u001c*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u001f\u0010 \u001a\u001c\u0010!\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001cH\b¢\u0006\u0004\b!\u0010\"\u001a,\u0010$\u001a\u00020\u0019*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u0019H\b¢\u0006\u0004\b$\u0010%\u001a$\u0010&\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b&\u0010'\u001a\u001c\u0010)\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020(H\b¢\u0006\u0004\b)\u0010*\u001a\u0014\u0010,\u001a\u00020+*\u00020\u0000H\b¢\u0006\u0004\b,\u0010-\u001a\u001c\u0010.\u001a\u00020+*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b.\u0010/\u001a\u0016\u00100\u001a\u0004\u0018\u00010+*\u00020\u0000H\b¢\u0006\u0004\b0\u0010-\u001a\u001c\u00102\u001a\u00020+*\u00020\u00002\u0006\u00101\u001a\u00020\u0003H\b¢\u0006\u0004\b2\u0010/\u001a\u0014\u00103\u001a\u00020\u0019*\u00020\u0000H\b¢\u0006\u0004\b3\u00104\u001a\u0014\u00106\u001a\u000205*\u00020\u0000H\b¢\u0006\u0004\b6\u00107\u001a\u0014\u00108\u001a\u000205*\u00020\u0000H\b¢\u0006\u0004\b8\u00107\u001a\u0014\u00109\u001a\u00020\u0019*\u00020\u0000H\b¢\u0006\u0004\b9\u00104\u001a\u0014\u0010:\u001a\u00020\u0019*\u00020\u0000H\b¢\u0006\u0004\b:\u00104\u001a\u0014\u0010;\u001a\u00020\u0003*\u00020\u0000H\b¢\u0006\u0004\b;\u0010<\u001a\u0014\u0010=\u001a\u00020\u0003*\u00020\u0000H\b¢\u0006\u0004\b=\u0010<\u001a\u0014\u0010>\u001a\u00020\u0003*\u00020\u0000H\b¢\u0006\u0004\b>\u0010<\u001a\u0014\u0010?\u001a\u00020\u0003*\u00020\u0000H\b¢\u0006\u0004\b?\u0010<\u001a\u001c\u0010@\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b@\u0010\f\u001a,\u0010C\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\b\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u0003H\b¢\u0006\u0004\bC\u0010D\u001a$\u0010F\u001a\u00020\u0003*\u00020\u00002\u0006\u0010E\u001a\u00020\u00122\u0006\u0010A\u001a\u00020\u0003H\b¢\u0006\u0004\bF\u0010G\u001a$\u0010I\u001a\u00020\u0003*\u00020\u00002\u0006\u0010H\u001a\u00020\u00122\u0006\u0010A\u001a\u00020\u0003H\b¢\u0006\u0004\bI\u0010G\u001a4\u0010K\u001a\u00020\u0007*\u00020\u00002\u0006\u0010#\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u00122\u0006\u0010J\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u0019H\b¢\u0006\u0004\bK\u0010L\u001a\u0014\u0010N\u001a\u00020M*\u00020\u0000H\b¢\u0006\u0004\bN\u0010O\u001a\u0014\u0010P\u001a\u00020\n*\u00020\u0000H\b¢\u0006\u0004\bP\u0010Q\u001a\u0014\u0010S\u001a\u00020R*\u00020\u0000H\b¢\u0006\u0004\bS\u0010T\u001a\u0014\u0010U\u001a\u00020+*\u00020\u0000H\b¢\u0006\u0004\bU\u0010-¨\u0006V"}, d2 = {"Lokio/RealBufferedSource;", "Lokio/Buffer;", "sink", "", "byteCount", "i", "(Lokio/RealBufferedSource;Lokio/Buffer;J)J", "", "b", "(Lokio/RealBufferedSource;)Z", "", "F", "(Lokio/RealBufferedSource;J)V", "E", "(Lokio/RealBufferedSource;J)Z", "", "k", "(Lokio/RealBufferedSource;)B", "Lokio/ByteString;", "n", "(Lokio/RealBufferedSource;)Lokio/ByteString;", "o", "(Lokio/RealBufferedSource;J)Lokio/ByteString;", "Lokio/Options;", "options", "", "G", "(Lokio/RealBufferedSource;Lokio/Options;)I", "", "l", "(Lokio/RealBufferedSource;)[B", "m", "(Lokio/RealBufferedSource;J)[B", "r", "(Lokio/RealBufferedSource;[B)V", "offset", "h", "(Lokio/RealBufferedSource;[BII)I", "q", "(Lokio/RealBufferedSource;Lokio/Buffer;J)V", "Lokio/Sink;", "j", "(Lokio/RealBufferedSource;Lokio/Sink;)J", "", "z", "(Lokio/RealBufferedSource;)Ljava/lang/String;", "A", "(Lokio/RealBufferedSource;J)Ljava/lang/String;", "C", "limit", "D", "B", "(Lokio/RealBufferedSource;)I", "", "x", "(Lokio/RealBufferedSource;)S", "y", "t", "u", "v", "(Lokio/RealBufferedSource;)J", "w", "p", "s", "H", "fromIndex", "toIndex", "c", "(Lokio/RealBufferedSource;BJJ)J", "bytes", "d", "(Lokio/RealBufferedSource;Lokio/ByteString;J)J", "targetBytes", "e", "bytesOffset", "g", "(Lokio/RealBufferedSource;JLokio/ByteString;II)Z", "Lokio/BufferedSource;", "f", "(Lokio/RealBufferedSource;)Lokio/BufferedSource;", "a", "(Lokio/RealBufferedSource;)V", "Lokio/Timeout;", "I", "(Lokio/RealBufferedSource;)Lokio/Timeout;", "J", "okio"}, k = 2, mv = {1, 5, 1})
public final class _RealBufferedSourceKt {
    @NotNull
    public static final String A(@NotNull RealBufferedSource realBufferedSource, long j2) {
        Intrinsics.p(realBufferedSource, "<this>");
        realBufferedSource.I2(j2);
        return realBufferedSource.X.B(j2);
    }

    public static final int B(@NotNull RealBufferedSource realBufferedSource) {
        long j2;
        Intrinsics.p(realBufferedSource, "<this>");
        realBufferedSource.I2(1);
        byte y = realBufferedSource.X.y(0);
        if ((y & 224) == 192) {
            j2 = 2;
        } else if ((y & 240) == 224) {
            j2 = 3;
        } else {
            if ((y & 248) == 240) {
                j2 = 4;
            }
            return realBufferedSource.X.t1();
        }
        realBufferedSource.I2(j2);
        return realBufferedSource.X.t1();
    }

    @Nullable
    public static final String C(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.p(realBufferedSource, "<this>");
        long N2 = realBufferedSource.N2((byte) 10);
        if (N2 != -1) {
            return _BufferKt.j0(realBufferedSource.X, N2);
        }
        if (realBufferedSource.X.L0() != 0) {
            return realBufferedSource.B(realBufferedSource.X.L0());
        }
        return null;
    }

    @NotNull
    public static final String D(@NotNull RealBufferedSource realBufferedSource, long j2) {
        Intrinsics.p(realBufferedSource, "<this>");
        if (j2 >= 0) {
            long j3 = j2 == Long.MAX_VALUE ? Long.MAX_VALUE : j2 + 1;
            byte b2 = (byte) 10;
            long y0 = realBufferedSource.y0(b2, 0, j3);
            if (y0 != -1) {
                return _BufferKt.j0(realBufferedSource.X, y0);
            }
            if (j3 < Long.MAX_VALUE && realBufferedSource.request(j3) && realBufferedSource.X.y(j3 - 1) == ((byte) 13) && realBufferedSource.request(1 + j3) && realBufferedSource.X.y(j3) == b2) {
                return _BufferKt.j0(realBufferedSource.X, j3);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = realBufferedSource.X;
            buffer2.r(buffer, 0, Math.min((long) 32, buffer2.L0()));
            throw new EOFException("\\n not found: limit=" + Math.min(realBufferedSource.X.L0(), j2) + " content=" + buffer.A1().w() + Typography.F);
        }
        throw new IllegalArgumentException(Intrinsics.C("limit < 0: ", Long.valueOf(j2)).toString());
    }

    public static final boolean E(@NotNull RealBufferedSource realBufferedSource, long j2) {
        Intrinsics.p(realBufferedSource, "<this>");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(Intrinsics.C("byteCount < 0: ", Long.valueOf(j2)).toString());
        } else if (!realBufferedSource.Y) {
            while (realBufferedSource.X.L0() < j2) {
                if (realBufferedSource.s.n2(realBufferedSource.X, PlaybackStateCompat.s3) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public static final void F(@NotNull RealBufferedSource realBufferedSource, long j2) {
        Intrinsics.p(realBufferedSource, "<this>");
        if (!realBufferedSource.request(j2)) {
            throw new EOFException();
        }
    }

    public static final int G(@NotNull RealBufferedSource realBufferedSource, @NotNull Options options) {
        Intrinsics.p(realBufferedSource, "<this>");
        Intrinsics.p(options, "options");
        if (!realBufferedSource.Y) {
            do {
                int l0 = _BufferKt.l0(realBufferedSource.X, options, true);
                if (l0 != -2) {
                    if (l0 == -1) {
                        return -1;
                    }
                    realBufferedSource.X.skip((long) options.g()[l0].m0());
                    return l0;
                }
            } while (realBufferedSource.s.n2(realBufferedSource.X, PlaybackStateCompat.s3) != -1);
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final void H(@NotNull RealBufferedSource realBufferedSource, long j2) {
        Intrinsics.p(realBufferedSource, "<this>");
        if (!realBufferedSource.Y) {
            while (j2 > 0) {
                if (realBufferedSource.X.L0() == 0 && realBufferedSource.s.n2(realBufferedSource.X, PlaybackStateCompat.s3) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j2, realBufferedSource.X.L0());
                realBufferedSource.X.skip(min);
                j2 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final Timeout I(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.p(realBufferedSource, "<this>");
        return realBufferedSource.s.j();
    }

    @NotNull
    public static final String J(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.p(realBufferedSource, "<this>");
        return "buffer(" + realBufferedSource.s + ASCIIPropertyListParser.f18650h;
    }

    public static final void a(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.p(realBufferedSource, "<this>");
        if (!realBufferedSource.Y) {
            realBufferedSource.Y = true;
            realBufferedSource.s.close();
            realBufferedSource.X.d();
        }
    }

    public static final boolean b(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.p(realBufferedSource, "<this>");
        if (!realBufferedSource.Y) {
            return realBufferedSource.X.o0() && realBufferedSource.s.n2(realBufferedSource.X, PlaybackStateCompat.s3) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long c(@NotNull RealBufferedSource realBufferedSource, byte b2, long j2, long j3) {
        Intrinsics.p(realBufferedSource, "<this>");
        boolean z = true;
        if (!realBufferedSource.Y) {
            if (0 > j2 || j2 > j3) {
                z = false;
            }
            if (z) {
                while (j2 < j3) {
                    long y0 = realBufferedSource.X.y0(b2, j2, j3);
                    if (y0 == -1) {
                        long L0 = realBufferedSource.X.L0();
                        if (L0 >= j3 || realBufferedSource.s.n2(realBufferedSource.X, PlaybackStateCompat.s3) == -1) {
                            break;
                        }
                        j2 = Math.max(j2, L0);
                    } else {
                        return y0;
                    }
                }
                return -1;
            }
            throw new IllegalArgumentException(("fromIndex=" + j2 + " toIndex=" + j3).toString());
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long d(@NotNull RealBufferedSource realBufferedSource, @NotNull ByteString byteString, long j2) {
        Intrinsics.p(realBufferedSource, "<this>");
        Intrinsics.p(byteString, "bytes");
        if (!realBufferedSource.Y) {
            while (true) {
                long E = realBufferedSource.X.E(byteString, j2);
                if (E != -1) {
                    return E;
                }
                long L0 = realBufferedSource.X.L0();
                if (realBufferedSource.s.n2(realBufferedSource.X, PlaybackStateCompat.s3) == -1) {
                    return -1;
                }
                j2 = Math.max(j2, (L0 - ((long) byteString.m0())) + 1);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public static final long e(@NotNull RealBufferedSource realBufferedSource, @NotNull ByteString byteString, long j2) {
        Intrinsics.p(realBufferedSource, "<this>");
        Intrinsics.p(byteString, "targetBytes");
        if (!realBufferedSource.Y) {
            while (true) {
                long G2 = realBufferedSource.X.G2(byteString, j2);
                if (G2 != -1) {
                    return G2;
                }
                long L0 = realBufferedSource.X.L0();
                if (realBufferedSource.s.n2(realBufferedSource.X, PlaybackStateCompat.s3) == -1) {
                    return -1;
                }
                j2 = Math.max(j2, L0);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    @NotNull
    public static final BufferedSource f(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.p(realBufferedSource, "<this>");
        return Okio.e(new PeekSource(realBufferedSource));
    }

    public static final boolean g(@NotNull RealBufferedSource realBufferedSource, long j2, @NotNull ByteString byteString, int i2, int i3) {
        Intrinsics.p(realBufferedSource, "<this>");
        Intrinsics.p(byteString, "bytes");
        if (!(!realBufferedSource.Y)) {
            throw new IllegalStateException("closed".toString());
        } else if (j2 < 0 || i2 < 0 || i3 < 0 || byteString.m0() - i2 < i3) {
            return false;
        } else {
            if (i3 > 0) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    long j3 = ((long) i4) + j2;
                    if (!realBufferedSource.request(1 + j3) || realBufferedSource.X.y(j3) != byteString.q(i4 + i2)) {
                        return false;
                    }
                    if (i5 >= i3) {
                        break;
                    }
                    i4 = i5;
                }
            }
            return true;
        }
    }

    public static final int h(@NotNull RealBufferedSource realBufferedSource, @NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.p(realBufferedSource, "<this>");
        Intrinsics.p(bArr, "sink");
        long j2 = (long) i3;
        _UtilKt.e((long) bArr.length, (long) i2, j2);
        if (realBufferedSource.X.L0() == 0 && realBufferedSource.s.n2(realBufferedSource.X, PlaybackStateCompat.s3) == -1) {
            return -1;
        }
        return realBufferedSource.X.read(bArr, i2, (int) Math.min(j2, realBufferedSource.X.L0()));
    }

    public static final long i(@NotNull RealBufferedSource realBufferedSource, @NotNull Buffer buffer, long j2) {
        Intrinsics.p(realBufferedSource, "<this>");
        Intrinsics.p(buffer, "sink");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(Intrinsics.C("byteCount < 0: ", Long.valueOf(j2)).toString());
        } else if (!(true ^ realBufferedSource.Y)) {
            throw new IllegalStateException("closed".toString());
        } else if (realBufferedSource.X.L0() == 0 && realBufferedSource.s.n2(realBufferedSource.X, PlaybackStateCompat.s3) == -1) {
            return -1;
        } else {
            return realBufferedSource.X.n2(buffer, Math.min(j2, realBufferedSource.X.L0()));
        }
    }

    public static final long j(@NotNull RealBufferedSource realBufferedSource, @NotNull Sink sink) {
        Buffer buffer;
        Intrinsics.p(realBufferedSource, "<this>");
        Intrinsics.p(sink, "sink");
        long j2 = 0;
        while (true) {
            int i2 = (realBufferedSource.s.n2(realBufferedSource.X, PlaybackStateCompat.s3) > -1 ? 1 : (realBufferedSource.s.n2(realBufferedSource.X, PlaybackStateCompat.s3) == -1 ? 0 : -1));
            buffer = realBufferedSource.X;
            if (i2 == 0) {
                break;
            }
            long f2 = buffer.f();
            if (f2 > 0) {
                j2 += f2;
                sink.u1(realBufferedSource.X, f2);
            }
        }
        if (buffer.L0() <= 0) {
            return j2;
        }
        long L0 = j2 + realBufferedSource.X.L0();
        Buffer buffer2 = realBufferedSource.X;
        sink.u1(buffer2, buffer2.L0());
        return L0;
    }

    public static final byte k(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.p(realBufferedSource, "<this>");
        realBufferedSource.I2(1);
        return realBufferedSource.X.readByte();
    }

    @NotNull
    public static final byte[] l(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.p(realBufferedSource, "<this>");
        realBufferedSource.X.y1(realBufferedSource.s);
        return realBufferedSource.X.b0();
    }

    @NotNull
    public static final byte[] m(@NotNull RealBufferedSource realBufferedSource, long j2) {
        Intrinsics.p(realBufferedSource, "<this>");
        realBufferedSource.I2(j2);
        return realBufferedSource.X.U1(j2);
    }

    @NotNull
    public static final ByteString n(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.p(realBufferedSource, "<this>");
        realBufferedSource.X.y1(realBufferedSource.s);
        return realBufferedSource.X.A1();
    }

    @NotNull
    public static final ByteString o(@NotNull RealBufferedSource realBufferedSource, long j2) {
        Intrinsics.p(realBufferedSource, "<this>");
        realBufferedSource.I2(j2);
        return realBufferedSource.X.K(j2);
    }

    public static final long p(@NotNull RealBufferedSource realBufferedSource) {
        int i2;
        Intrinsics.p(realBufferedSource, "<this>");
        realBufferedSource.I2(1);
        long j2 = 0;
        while (true) {
            long j3 = j2 + 1;
            if (!realBufferedSource.request(j3)) {
                break;
            }
            byte y = realBufferedSource.X.y(j2);
            if ((y >= ((byte) 48) && y <= ((byte) 57)) || (j2 == 0 && y == ((byte) 45))) {
                j2 = j3;
            } else if (i2 == 0) {
                String num = Integer.toString(y, CharsKt.a(CharsKt.a(16)));
                Intrinsics.o(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                throw new NumberFormatException(Intrinsics.C("Expected a digit or '-' but was 0x", num));
            }
        }
        return realBufferedSource.X.H0();
    }

    public static final void q(@NotNull RealBufferedSource realBufferedSource, @NotNull Buffer buffer, long j2) {
        Intrinsics.p(realBufferedSource, "<this>");
        Intrinsics.p(buffer, "sink");
        try {
            realBufferedSource.I2(j2);
            realBufferedSource.X.w0(buffer, j2);
        } catch (EOFException e2) {
            buffer.y1(realBufferedSource.X);
            throw e2;
        }
    }

    public static final void r(@NotNull RealBufferedSource realBufferedSource, @NotNull byte[] bArr) {
        Intrinsics.p(realBufferedSource, "<this>");
        Intrinsics.p(bArr, "sink");
        try {
            realBufferedSource.I2((long) bArr.length);
            realBufferedSource.X.readFully(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (realBufferedSource.X.L0() > 0) {
                Buffer buffer = realBufferedSource.X;
                int read = buffer.read(bArr, i2, (int) buffer.L0());
                if (read != -1) {
                    i2 += read;
                } else {
                    throw new AssertionError();
                }
            }
            throw e2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long s(@org.jetbrains.annotations.NotNull okio.RealBufferedSource r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r5, r0)
            r0 = 1
            r5.I2(r0)
            r0 = 0
        L_0x000b:
            int r1 = r0 + 1
            long r2 = (long) r1
            boolean r2 = r5.request(r2)
            if (r2 == 0) goto L_0x005e
            okio.Buffer r2 = r5.X
            long r3 = (long) r0
            byte r2 = r2.y(r3)
            r3 = 48
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x0025
            r3 = 57
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x003a
        L_0x0025:
            r3 = 97
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x002f
            r3 = 102(0x66, float:1.43E-43)
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x003a
        L_0x002f:
            r3 = 65
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x003c
            r3 = 70
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r0 = r1
            goto L_0x000b
        L_0x003c:
            if (r0 == 0) goto L_0x003f
            goto L_0x005e
        L_0x003f:
            java.lang.NumberFormatException r5 = new java.lang.NumberFormatException
            r0 = 16
            int r0 = kotlin.text.CharsKt.a(r0)
            int r0 = kotlin.text.CharsKt.a(r0)
            java.lang.String r0 = java.lang.Integer.toString(r2, r0)
            java.lang.String r1 = "java.lang.Integer.toStri…(this, checkRadix(radix))"
            kotlin.jvm.internal.Intrinsics.o(r0, r1)
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.C(r1, r0)
            r5.<init>(r0)
            throw r5
        L_0x005e:
            okio.Buffer r5 = r5.X
            long r0 = r5.Q2()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._RealBufferedSourceKt.s(okio.RealBufferedSource):long");
    }

    public static final int t(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.p(realBufferedSource, "<this>");
        realBufferedSource.I2(4);
        return realBufferedSource.X.readInt();
    }

    public static final int u(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.p(realBufferedSource, "<this>");
        realBufferedSource.I2(4);
        return realBufferedSource.X.R1();
    }

    public static final long v(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.p(realBufferedSource, "<this>");
        realBufferedSource.I2(8);
        return realBufferedSource.X.readLong();
    }

    public static final long w(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.p(realBufferedSource, "<this>");
        realBufferedSource.I2(8);
        return realBufferedSource.X.p2();
    }

    public static final short x(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.p(realBufferedSource, "<this>");
        realBufferedSource.I2(2);
        return realBufferedSource.X.readShort();
    }

    public static final short y(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.p(realBufferedSource, "<this>");
        realBufferedSource.I2(2);
        return realBufferedSource.X.j2();
    }

    @NotNull
    public static final String z(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.p(realBufferedSource, "<this>");
        realBufferedSource.X.y1(realBufferedSource.s);
        return realBufferedSource.X.a2();
    }
}
