package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.dd.plist.ASCIIPropertyListParser;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Typography;
import okio.internal._BufferKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020 2\u0006\u0010\t\u001a\u00020#H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020#H\u0016¢\u0006\u0004\b*\u0010+J'\u0010(\u001a\u00020 2\u0006\u0010\t\u001a\u00020#2\u0006\u0010,\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020 H\u0016¢\u0006\u0004\b(\u0010-J\u0017\u0010(\u001a\u00020 2\u0006\u0010\t\u001a\u00020.H\u0016¢\u0006\u0004\b(\u0010/J\u001f\u00100\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\n2\u0006\u0010\t\u001a\u000202H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00106\u001a\u000205H\u0016¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u0002052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010<\u001a\u0002052\u0006\u0010;\u001a\u00020:H\u0016¢\u0006\u0004\b<\u0010=J\u001f\u0010>\u001a\u0002052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010;\u001a\u00020:H\u0016¢\u0006\u0004\b>\u0010?J\u0011\u0010@\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0004\b@\u00107J\u000f\u0010A\u001a\u000205H\u0016¢\u0006\u0004\bA\u00107J\u0017\u0010C\u001a\u0002052\u0006\u0010B\u001a\u00020\nH\u0016¢\u0006\u0004\bC\u00109J\u000f\u0010D\u001a\u00020 H\u0016¢\u0006\u0004\bD\u0010EJ\u000f\u0010G\u001a\u00020FH\u0016¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020FH\u0016¢\u0006\u0004\bI\u0010HJ\u000f\u0010J\u001a\u00020 H\u0016¢\u0006\u0004\bJ\u0010EJ\u000f\u0010K\u001a\u00020 H\u0016¢\u0006\u0004\bK\u0010EJ\u000f\u0010L\u001a\u00020\nH\u0016¢\u0006\u0004\bL\u0010MJ\u000f\u0010N\u001a\u00020\nH\u0016¢\u0006\u0004\bN\u0010MJ\u000f\u0010O\u001a\u00020\nH\u0016¢\u0006\u0004\bO\u0010MJ\u000f\u0010P\u001a\u00020\nH\u0016¢\u0006\u0004\bP\u0010MJ\u0017\u0010Q\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\bQ\u0010\u0013J\u0017\u0010S\u001a\u00020\n2\u0006\u0010R\u001a\u00020\u0016H\u0016¢\u0006\u0004\bS\u0010TJ\u001f\u0010V\u001a\u00020\n2\u0006\u0010R\u001a\u00020\u00162\u0006\u0010U\u001a\u00020\nH\u0016¢\u0006\u0004\bV\u0010WJ'\u0010Y\u001a\u00020\n2\u0006\u0010R\u001a\u00020\u00162\u0006\u0010U\u001a\u00020\n2\u0006\u0010X\u001a\u00020\nH\u0016¢\u0006\u0004\bY\u0010ZJ\u0017\u0010\\\u001a\u00020\n2\u0006\u0010[\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\\\u0010]J\u001f\u0010^\u001a\u00020\n2\u0006\u0010[\u001a\u00020\u00192\u0006\u0010U\u001a\u00020\nH\u0016¢\u0006\u0004\b^\u0010_J\u0017\u0010a\u001a\u00020\n2\u0006\u0010`\u001a\u00020\u0019H\u0016¢\u0006\u0004\ba\u0010]J\u001f\u0010b\u001a\u00020\n2\u0006\u0010`\u001a\u00020\u00192\u0006\u0010U\u001a\u00020\nH\u0016¢\u0006\u0004\bb\u0010_J\u001f\u0010c\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\n2\u0006\u0010[\u001a\u00020\u0019H\u0016¢\u0006\u0004\bc\u0010dJ/\u0010f\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\n2\u0006\u0010[\u001a\u00020\u00192\u0006\u0010e\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020 H\u0016¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020\u0001H\u0016¢\u0006\u0004\bh\u0010iJ\u000f\u0010k\u001a\u00020jH\u0016¢\u0006\u0004\bk\u0010lJ\u000f\u0010m\u001a\u00020\u000eH\u0016¢\u0006\u0004\bm\u0010\u0010J\u000f\u0010n\u001a\u00020\u0011H\u0016¢\u0006\u0004\bn\u0010oJ\u000f\u0010q\u001a\u00020pH\u0016¢\u0006\u0004\bq\u0010rJ\u000f\u0010s\u001a\u000205H\u0016¢\u0006\u0004\bs\u00107R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0014\u0010x\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010{\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u001b\u0010}\u001a\u00020\u00068Ö\u0002X\u0004¢\u0006\f\u0012\u0004\bR\u0010o\u001a\u0004\b|\u0010\b¨\u0006~"}, d2 = {"Lokio/RealBufferedSource;", "Lokio/BufferedSource;", "Lokio/Source;", "source", "<init>", "(Lokio/Source;)V", "Lokio/Buffer;", "g", "()Lokio/Buffer;", "sink", "", "byteCount", "n2", "(Lokio/Buffer;J)J", "", "o0", "()Z", "", "I2", "(J)V", "request", "(J)Z", "", "readByte", "()B", "Lokio/ByteString;", "A1", "()Lokio/ByteString;", "K", "(J)Lokio/ByteString;", "Lokio/Options;", "options", "", "S2", "(Lokio/Options;)I", "", "b0", "()[B", "U1", "(J)[B", "read", "([B)I", "readFully", "([B)V", "offset", "([BII)I", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)I", "w0", "(Lokio/Buffer;J)V", "Lokio/Sink;", "r2", "(Lokio/Sink;)J", "", "a2", "()Ljava/lang/String;", "B", "(J)Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "g1", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "d2", "(JLjava/nio/charset/Charset;)Ljava/lang/String;", "E0", "O1", "limit", "M0", "t1", "()I", "", "readShort", "()S", "j2", "readInt", "R1", "readLong", "()J", "p2", "H0", "Q2", "skip", "b", "N2", "(B)J", "fromIndex", "u0", "(BJ)J", "toIndex", "y0", "(BJJ)J", "bytes", "l0", "(Lokio/ByteString;)J", "E", "(Lokio/ByteString;J)J", "targetBytes", "z0", "G2", "b1", "(JLokio/ByteString;)Z", "bytesOffset", "S1", "(JLokio/ByteString;II)Z", "peek", "()Lokio/BufferedSource;", "Ljava/io/InputStream;", "z", "()Ljava/io/InputStream;", "isOpen", "close", "()V", "Lokio/Timeout;", "j", "()Lokio/Timeout;", "toString", "s", "Lokio/Source;", "X", "Lokio/Buffer;", "bufferField", "Y", "Z", "closed", "m", "buffer", "okio"}, k = 1, mv = {1, 5, 1})
public final class RealBufferedSource implements BufferedSource {
    @NotNull
    @JvmField
    public final Buffer X = new Buffer();
    @JvmField
    public boolean Y;
    @NotNull
    @JvmField
    public final Source s;

    public RealBufferedSource(@NotNull Source source) {
        Intrinsics.p(source, "source");
        this.s = source;
    }

    public static /* synthetic */ void b() {
    }

    @NotNull
    public ByteString A1() {
        this.X.y1(this.s);
        return this.X.A1();
    }

    @NotNull
    public String B(long j2) {
        I2(j2);
        return this.X.B(j2);
    }

    public long E(@NotNull ByteString byteString, long j2) {
        Intrinsics.p(byteString, "bytes");
        if (!this.Y) {
            while (true) {
                long E = this.X.E(byteString, j2);
                if (E != -1) {
                    return E;
                }
                long L0 = this.X.L0();
                if (this.s.n2(this.X, PlaybackStateCompat.s3) == -1) {
                    return -1;
                }
                j2 = Math.max(j2, (L0 - ((long) byteString.m0())) + 1);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    @Nullable
    public String E0() {
        long N2 = N2((byte) 10);
        if (N2 != -1) {
            return _BufferKt.j0(this.X, N2);
        }
        if (this.X.L0() != 0) {
            return B(this.X.L0());
        }
        return null;
    }

    public long G2(@NotNull ByteString byteString, long j2) {
        Intrinsics.p(byteString, "targetBytes");
        if (!this.Y) {
            while (true) {
                long G2 = this.X.G2(byteString, j2);
                if (G2 != -1) {
                    return G2;
                }
                long L0 = this.X.L0();
                if (this.s.n2(this.X, PlaybackStateCompat.s3) == -1) {
                    return -1;
                }
                j2 = Math.max(j2, L0);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public long H0() {
        int i2;
        I2(1);
        long j2 = 0;
        while (true) {
            long j3 = j2 + 1;
            if (!request(j3)) {
                break;
            }
            byte y = this.X.y(j2);
            if ((y >= ((byte) 48) && y <= ((byte) 57)) || (j2 == 0 && y == ((byte) 45))) {
                j2 = j3;
            } else if (i2 == 0) {
                String num = Integer.toString(y, CharsKt.a(CharsKt.a(16)));
                Intrinsics.o(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                throw new NumberFormatException(Intrinsics.C("Expected a digit or '-' but was 0x", num));
            }
        }
        return this.X.H0();
    }

    public void I2(long j2) {
        if (!request(j2)) {
            throw new EOFException();
        }
    }

    @NotNull
    public ByteString K(long j2) {
        I2(j2);
        return this.X.K(j2);
    }

    @NotNull
    public String M0(long j2) {
        if (j2 >= 0) {
            long j3 = j2 == Long.MAX_VALUE ? Long.MAX_VALUE : j2 + 1;
            byte b2 = (byte) 10;
            long y0 = y0(b2, 0, j3);
            if (y0 != -1) {
                return _BufferKt.j0(this.X, y0);
            }
            if (j3 < Long.MAX_VALUE && request(j3) && this.X.y(j3 - 1) == ((byte) 13) && request(1 + j3) && this.X.y(j3) == b2) {
                return _BufferKt.j0(this.X, j3);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = this.X;
            buffer2.r(buffer, 0, Math.min((long) 32, buffer2.L0()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.X.L0(), j2) + " content=" + buffer.A1().w() + Typography.F);
        }
        throw new IllegalArgumentException(Intrinsics.C("limit < 0: ", Long.valueOf(j2)).toString());
    }

    public long N2(byte b2) {
        return y0(b2, 0, Long.MAX_VALUE);
    }

    @NotNull
    public String O1() {
        return M0(Long.MAX_VALUE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long Q2() {
        /*
            r5 = this;
            r0 = 1
            r5.I2(r0)
            r0 = 0
        L_0x0006:
            int r1 = r0 + 1
            long r2 = (long) r1
            boolean r2 = r5.request(r2)
            if (r2 == 0) goto L_0x0059
            okio.Buffer r2 = r5.X
            long r3 = (long) r0
            byte r2 = r2.y(r3)
            r3 = 48
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x0020
            r3 = 57
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x0035
        L_0x0020:
            r3 = 97
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x002a
            r3 = 102(0x66, float:1.43E-43)
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x0035
        L_0x002a:
            r3 = 65
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x0037
            r3 = 70
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r0 = r1
            goto L_0x0006
        L_0x0037:
            if (r0 == 0) goto L_0x003a
            goto L_0x0059
        L_0x003a:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r1 = 16
            int r1 = kotlin.text.CharsKt.a(r1)
            int r1 = kotlin.text.CharsKt.a(r1)
            java.lang.String r1 = java.lang.Integer.toString(r2, r1)
            java.lang.String r2 = "java.lang.Integer.toStri…(this, checkRadix(radix))"
            kotlin.jvm.internal.Intrinsics.o(r1, r2)
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.C(r2, r1)
            r0.<init>(r1)
            throw r0
        L_0x0059:
            okio.Buffer r0 = r5.X
            long r0 = r0.Q2()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.RealBufferedSource.Q2():long");
    }

    public int R1() {
        I2(4);
        return this.X.R1();
    }

    public boolean S1(long j2, @NotNull ByteString byteString, int i2, int i3) {
        Intrinsics.p(byteString, "bytes");
        if (!this.Y) {
            if (j2 >= 0 && i2 >= 0 && i3 >= 0 && byteString.m0() - i2 >= i3) {
                if (i3 > 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        long j3 = ((long) i4) + j2;
                        if (!request(1 + j3) || this.X.y(j3) != byteString.q(i4 + i2)) {
                            break;
                        } else if (i5 >= i3) {
                            return true;
                        } else {
                            i4 = i5;
                        }
                    }
                } else {
                    return true;
                }
            }
            return false;
        }
        throw new IllegalStateException("closed".toString());
    }

    public int S2(@NotNull Options options) {
        Intrinsics.p(options, "options");
        if (!this.Y) {
            while (true) {
                int l0 = _BufferKt.l0(this.X, options, true);
                if (l0 == -2) {
                    if (this.s.n2(this.X, PlaybackStateCompat.s3) == -1) {
                        break;
                    }
                } else if (l0 != -1) {
                    this.X.skip((long) options.g()[l0].m0());
                    return l0;
                }
            }
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public byte[] U1(long j2) {
        I2(j2);
        return this.X.U1(j2);
    }

    @NotNull
    public String a2() {
        this.X.y1(this.s);
        return this.X.a2();
    }

    @NotNull
    public byte[] b0() {
        this.X.y1(this.s);
        return this.X.b0();
    }

    public boolean b1(long j2, @NotNull ByteString byteString) {
        Intrinsics.p(byteString, "bytes");
        return S1(j2, byteString, 0, byteString.m0());
    }

    public void close() {
        if (!this.Y) {
            this.Y = true;
            this.s.close();
            this.X.d();
        }
    }

    @NotNull
    public String d2(long j2, @NotNull Charset charset) {
        Intrinsics.p(charset, "charset");
        I2(j2);
        return this.X.d2(j2, charset);
    }

    @NotNull
    public Buffer g() {
        return this.X;
    }

    @NotNull
    public String g1(@NotNull Charset charset) {
        Intrinsics.p(charset, "charset");
        this.X.y1(this.s);
        return this.X.g1(charset);
    }

    public boolean isOpen() {
        return !this.Y;
    }

    @NotNull
    public Timeout j() {
        return this.s.j();
    }

    public short j2() {
        I2(2);
        return this.X.j2();
    }

    public long l0(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "bytes");
        return E(byteString, 0);
    }

    @NotNull
    public Buffer m() {
        return this.X;
    }

    public long n2(@NotNull Buffer buffer, long j2) {
        Intrinsics.p(buffer, "sink");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(Intrinsics.C("byteCount < 0: ", Long.valueOf(j2)).toString());
        } else if (!(true ^ this.Y)) {
            throw new IllegalStateException("closed".toString());
        } else if (this.X.L0() == 0 && this.s.n2(this.X, PlaybackStateCompat.s3) == -1) {
            return -1;
        } else {
            return this.X.n2(buffer, Math.min(j2, this.X.L0()));
        }
    }

    public boolean o0() {
        if (!this.Y) {
            return this.X.o0() && this.s.n2(this.X, PlaybackStateCompat.s3) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public long p2() {
        I2(8);
        return this.X.p2();
    }

    @NotNull
    public BufferedSource peek() {
        return Okio.e(new PeekSource(this));
    }

    public long r2(@NotNull Sink sink) {
        Buffer buffer;
        Intrinsics.p(sink, "sink");
        long j2 = 0;
        while (true) {
            int i2 = (this.s.n2(this.X, PlaybackStateCompat.s3) > -1 ? 1 : (this.s.n2(this.X, PlaybackStateCompat.s3) == -1 ? 0 : -1));
            buffer = this.X;
            if (i2 == 0) {
                break;
            }
            long f2 = buffer.f();
            if (f2 > 0) {
                j2 += f2;
                sink.u1(this.X, f2);
            }
        }
        if (buffer.L0() <= 0) {
            return j2;
        }
        long L0 = j2 + this.X.L0();
        Buffer buffer2 = this.X;
        sink.u1(buffer2, buffer2.L0());
        return L0;
    }

    public int read(@NotNull ByteBuffer byteBuffer) {
        Intrinsics.p(byteBuffer, "sink");
        if (this.X.L0() == 0 && this.s.n2(this.X, PlaybackStateCompat.s3) == -1) {
            return -1;
        }
        return this.X.read(byteBuffer);
    }

    public byte readByte() {
        I2(1);
        return this.X.readByte();
    }

    public void readFully(@NotNull byte[] bArr) {
        Intrinsics.p(bArr, "sink");
        try {
            I2((long) bArr.length);
            this.X.readFully(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (this.X.L0() > 0) {
                Buffer buffer = this.X;
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

    public int readInt() {
        I2(4);
        return this.X.readInt();
    }

    public long readLong() {
        I2(8);
        return this.X.readLong();
    }

    public short readShort() {
        I2(2);
        return this.X.readShort();
    }

    public boolean request(long j2) {
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(Intrinsics.C("byteCount < 0: ", Long.valueOf(j2)).toString());
        } else if (!this.Y) {
            while (this.X.L0() < j2) {
                if (this.s.n2(this.X, PlaybackStateCompat.s3) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public void skip(long j2) {
        if (!this.Y) {
            while (j2 > 0) {
                if (this.X.L0() == 0 && this.s.n2(this.X, PlaybackStateCompat.s3) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j2, this.X.L0());
                this.X.skip(min);
                j2 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public int t1() {
        long j2;
        I2(1);
        byte y = this.X.y(0);
        if ((y & 224) == 192) {
            j2 = 2;
        } else if ((y & 240) == 224) {
            j2 = 3;
        } else {
            if ((y & 248) == 240) {
                j2 = 4;
            }
            return this.X.t1();
        }
        I2(j2);
        return this.X.t1();
    }

    @NotNull
    public String toString() {
        return "buffer(" + this.s + ASCIIPropertyListParser.f18650h;
    }

    public long u0(byte b2, long j2) {
        return y0(b2, j2, Long.MAX_VALUE);
    }

    public void w0(@NotNull Buffer buffer, long j2) {
        Intrinsics.p(buffer, "sink");
        try {
            I2(j2);
            this.X.w0(buffer, j2);
        } catch (EOFException e2) {
            buffer.y1(this.X);
            throw e2;
        }
    }

    public long y0(byte b2, long j2, long j3) {
        boolean z = true;
        if (!this.Y) {
            if (0 > j2 || j2 > j3) {
                z = false;
            }
            if (z) {
                while (j2 < j3) {
                    long y0 = this.X.y0(b2, j2, j3);
                    if (y0 != -1) {
                        return y0;
                    }
                    long L0 = this.X.L0();
                    if (L0 >= j3 || this.s.n2(this.X, PlaybackStateCompat.s3) == -1) {
                        return -1;
                    }
                    j2 = Math.max(j2, L0);
                }
                return -1;
            }
            throw new IllegalArgumentException(("fromIndex=" + j2 + " toIndex=" + j3).toString());
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public InputStream z() {
        return new RealBufferedSource$inputStream$1(this);
    }

    public long z0(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "targetBytes");
        return G2(byteString, 0);
    }

    public int read(@NotNull byte[] bArr) {
        Intrinsics.p(bArr, "sink");
        return read(bArr, 0, bArr.length);
    }

    public int read(@NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.p(bArr, "sink");
        long j2 = (long) i3;
        _UtilKt.e((long) bArr.length, (long) i2, j2);
        if (this.X.L0() == 0 && this.s.n2(this.X, PlaybackStateCompat.s3) == -1) {
            return -1;
        }
        return this.X.read(bArr, i2, (int) Math.min(j2, this.X.L0()));
    }
}
