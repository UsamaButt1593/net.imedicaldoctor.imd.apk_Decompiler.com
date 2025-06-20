package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UShort;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

final class Http2Reader implements Closeable {
    static final Logger X2 = Logger.getLogger(Http2.class.getName());
    private final ContinuationSource X;
    private final boolean Y;
    final Hpack.Reader Z;
    private final BufferedSource s;

    static final class ContinuationSource implements Source {
        int X;
        int X2;
        byte Y;
        short Y2;
        int Z;
        private final BufferedSource s;

        ContinuationSource(BufferedSource bufferedSource) {
            this.s = bufferedSource;
        }

        private void b() throws IOException {
            int i2 = this.Z;
            int k2 = Http2Reader.k(this.s);
            this.X2 = k2;
            this.X = k2;
            byte readByte = (byte) (this.s.readByte() & 255);
            this.Y = (byte) (this.s.readByte() & 255);
            Logger logger = Http2Reader.X2;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.b(true, this.Z, this.X, readByte, this.Y));
            }
            int readInt = this.s.readInt() & Integer.MAX_VALUE;
            this.Z = readInt;
            if (readByte != 9) {
                throw Http2.d("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            } else if (readInt != i2) {
                throw Http2.d("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        public void close() throws IOException {
        }

        public Timeout j() {
            return this.s.j();
        }

        public long n2(Buffer buffer, long j2) throws IOException {
            while (true) {
                int i2 = this.X2;
                if (i2 == 0) {
                    this.s.skip((long) this.Y2);
                    this.Y2 = 0;
                    if ((this.Y & 4) != 0) {
                        return -1;
                    }
                    b();
                } else {
                    long n2 = this.s.n2(buffer, Math.min(j2, (long) i2));
                    if (n2 == -1) {
                        return -1;
                    }
                    this.X2 = (int) (((long) this.X2) - n2);
                    return n2;
                }
            }
        }
    }

    interface Handler {
        void a();

        void b(boolean z, Settings settings);

        void c(boolean z, int i2, int i3, List<Header> list);

        void d(int i2, long j2);

        void e(int i2, String str, ByteString byteString, String str2, int i3, long j2);

        void f(boolean z, int i2, BufferedSource bufferedSource, int i3) throws IOException;

        void g(boolean z, int i2, int i3);

        void h(int i2, int i3, int i4, boolean z);

        void i(int i2, ErrorCode errorCode);

        void j(int i2, int i3, List<Header> list) throws IOException;

        void k(int i2, ErrorCode errorCode, ByteString byteString);
    }

    Http2Reader(BufferedSource bufferedSource, boolean z) {
        this.s = bufferedSource;
        this.Y = z;
        ContinuationSource continuationSource = new ContinuationSource(bufferedSource);
        this.X = continuationSource;
        this.Z = new Hpack.Reader(4096, continuationSource);
    }

    static int b(int i2, byte b2, short s2) throws IOException {
        if ((b2 & 8) != 0) {
            i2--;
        }
        if (s2 <= i2) {
            return (short) (i2 - s2);
        }
        throw Http2.d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s2), Integer.valueOf(i2));
    }

    private void e(Handler handler, int i2, byte b2, int i3) throws IOException {
        short s2 = 0;
        if (i3 != 0) {
            boolean z = (b2 & 1) != 0;
            if ((b2 & 32) == 0) {
                if ((b2 & 8) != 0) {
                    s2 = (short) (this.s.readByte() & 255);
                }
                handler.f(z, i3, this.s, b(i2, b2, s2));
                this.s.skip((long) s2);
                return;
            }
            throw Http2.d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        throw Http2.d("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }

    private void f(Handler handler, int i2, byte b2, int i3) throws IOException {
        if (i2 < 8) {
            throw Http2.d("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i2));
        } else if (i3 == 0) {
            int readInt = this.s.readInt();
            int readInt2 = this.s.readInt();
            int i4 = i2 - 8;
            ErrorCode a2 = ErrorCode.a(readInt2);
            if (a2 != null) {
                ByteString byteString = ByteString.Y2;
                if (i4 > 0) {
                    byteString = this.s.K((long) i4);
                }
                handler.k(readInt, a2, byteString);
                return;
            }
            throw Http2.d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
        } else {
            throw Http2.d("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
    }

    private List<Header> h(int i2, short s2, byte b2, int i3) throws IOException {
        ContinuationSource continuationSource = this.X;
        continuationSource.X2 = i2;
        continuationSource.X = i2;
        continuationSource.Y2 = s2;
        continuationSource.Y = b2;
        continuationSource.Z = i3;
        this.Z.l();
        return this.Z.e();
    }

    private void i(Handler handler, int i2, byte b2, int i3) throws IOException {
        short s2 = 0;
        if (i3 != 0) {
            boolean z = (b2 & 1) != 0;
            if ((b2 & 8) != 0) {
                s2 = (short) (this.s.readByte() & 255);
            }
            if ((b2 & 32) != 0) {
                p(handler, i3);
                i2 -= 5;
            }
            handler.c(z, i3, -1, h(b(i2, b2, s2), s2, b2, i3));
            return;
        }
        throw Http2.d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    static int k(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    private void n(Handler handler, int i2, byte b2, int i3) throws IOException {
        boolean z = true;
        if (i2 != 8) {
            throw Http2.d("TYPE_PING length != 8: %s", Integer.valueOf(i2));
        } else if (i3 == 0) {
            int readInt = this.s.readInt();
            int readInt2 = this.s.readInt();
            if ((b2 & 1) == 0) {
                z = false;
            }
            handler.g(z, readInt, readInt2);
        } else {
            throw Http2.d("TYPE_PING streamId != 0", new Object[0]);
        }
    }

    private void p(Handler handler, int i2) throws IOException {
        int readInt = this.s.readInt();
        handler.h(i2, readInt & Integer.MAX_VALUE, (this.s.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    private void q(Handler handler, int i2, byte b2, int i3) throws IOException {
        if (i2 != 5) {
            throw Http2.d("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i2));
        } else if (i3 != 0) {
            p(handler, i3);
        } else {
            throw Http2.d("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
    }

    private void r(Handler handler, int i2, byte b2, int i3) throws IOException {
        short s2 = 0;
        if (i3 != 0) {
            if ((b2 & 8) != 0) {
                s2 = (short) (this.s.readByte() & 255);
            }
            handler.j(i3, this.s.readInt() & Integer.MAX_VALUE, h(b(i2 - 4, b2, s2), s2, b2, i3));
            return;
        }
        throw Http2.d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    private void s(Handler handler, int i2, byte b2, int i3) throws IOException {
        if (i2 != 4) {
            throw Http2.d("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i2));
        } else if (i3 != 0) {
            int readInt = this.s.readInt();
            ErrorCode a2 = ErrorCode.a(readInt);
            if (a2 != null) {
                handler.i(i3, a2);
                return;
            }
            throw Http2.d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
        } else {
            throw Http2.d("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
    }

    private void t(Handler handler, int i2, byte b2, int i3) throws IOException {
        if (i3 != 0) {
            throw Http2.d("TYPE_SETTINGS streamId != 0", new Object[0]);
        } else if ((b2 & 1) != 0) {
            if (i2 == 0) {
                handler.a();
                return;
            }
            throw Http2.d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        } else if (i2 % 6 == 0) {
            Settings settings = new Settings();
            for (int i4 = 0; i4 < i2; i4 += 6) {
                short readShort = this.s.readShort() & UShort.Z;
                int readInt = this.s.readInt();
                if (readShort != 2) {
                    if (readShort == 3) {
                        readShort = 4;
                    } else if (readShort != 4) {
                        if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                            throw Http2.d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                        }
                    } else if (readInt >= 0) {
                        readShort = 7;
                    } else {
                        throw Http2.d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    }
                } else if (!(readInt == 0 || readInt == 1)) {
                    throw Http2.d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
                settings.k(readShort, readInt);
            }
            handler.b(false, settings);
        } else {
            throw Http2.d("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i2));
        }
    }

    private void u(Handler handler, int i2, byte b2, int i3) throws IOException {
        if (i2 == 4) {
            long readInt = ((long) this.s.readInt()) & 2147483647L;
            if (readInt != 0) {
                handler.d(i3, readInt);
            } else {
                throw Http2.d("windowSizeIncrement was 0", Long.valueOf(readInt));
            }
        } else {
            throw Http2.d("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i2));
        }
    }

    public boolean c(boolean z, Handler handler) throws IOException {
        try {
            this.s.I2(9);
            int k2 = k(this.s);
            if (k2 < 0 || k2 > 16384) {
                throw Http2.d("FRAME_SIZE_ERROR: %s", Integer.valueOf(k2));
            }
            byte readByte = (byte) (this.s.readByte() & 255);
            if (!z || readByte == 4) {
                byte readByte2 = (byte) (this.s.readByte() & 255);
                int readInt = this.s.readInt() & Integer.MAX_VALUE;
                Logger logger = X2;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(Http2.b(true, readInt, k2, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        e(handler, k2, readByte2, readInt);
                        break;
                    case 1:
                        i(handler, k2, readByte2, readInt);
                        break;
                    case 2:
                        q(handler, k2, readByte2, readInt);
                        break;
                    case 3:
                        s(handler, k2, readByte2, readInt);
                        break;
                    case 4:
                        t(handler, k2, readByte2, readInt);
                        break;
                    case 5:
                        r(handler, k2, readByte2, readInt);
                        break;
                    case 6:
                        n(handler, k2, readByte2, readInt);
                        break;
                    case 7:
                        f(handler, k2, readByte2, readInt);
                        break;
                    case 8:
                        u(handler, k2, readByte2, readInt);
                        break;
                    default:
                        this.s.skip((long) k2);
                        break;
                }
                return true;
            }
            throw Http2.d("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
        } catch (IOException unused) {
            return false;
        }
    }

    public void close() throws IOException {
        this.s.close();
    }

    public void d(Handler handler) throws IOException {
        if (!this.Y) {
            BufferedSource bufferedSource = this.s;
            ByteString byteString = Http2.f31156a;
            ByteString K = bufferedSource.K((long) byteString.m0());
            Logger logger = X2;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Util.s("<< CONNECTION %s", K.w()));
            }
            if (!byteString.equals(K)) {
                throw Http2.d("Expected a connection header but was %s", K.I0());
            }
        } else if (!c(true, handler)) {
            throw Http2.d("Required SETTINGS preface not received", new Object[0]);
        }
    }
}
