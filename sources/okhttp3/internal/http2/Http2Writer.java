package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSink;

final class Http2Writer implements Closeable {
    private static final Logger Z2 = Logger.getLogger(Http2.class.getName());
    private final boolean X;
    private boolean X2;
    private final Buffer Y;
    final Hpack.Writer Y2;
    private int Z = 16384;
    private final BufferedSink s;

    Http2Writer(BufferedSink bufferedSink, boolean z) {
        this.s = bufferedSink;
        this.X = z;
        Buffer buffer = new Buffer();
        this.Y = buffer;
        this.Y2 = new Hpack.Writer(buffer);
    }

    private void w(int i2, long j2) throws IOException {
        while (j2 > 0) {
            int min = (int) Math.min((long) this.Z, j2);
            long j3 = (long) min;
            j2 -= j3;
            f(i2, min, (byte) 9, j2 == 0 ? (byte) 4 : 0);
            this.s.u1(this.Y, j3);
        }
    }

    private static void x(BufferedSink bufferedSink, int i2) throws IOException {
        bufferedSink.writeByte((i2 >>> 16) & 255);
        bufferedSink.writeByte((i2 >>> 8) & 255);
        bufferedSink.writeByte(i2 & 255);
    }

    public synchronized void b(Settings settings) throws IOException {
        try {
            if (!this.X2) {
                this.Z = settings.g(this.Z);
                if (settings.d() != -1) {
                    this.Y2.e(settings.d());
                }
                f(0, 0, (byte) 4, (byte) 1);
                this.s.flush();
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void c() throws IOException {
        try {
            if (this.X2) {
                throw new IOException("closed");
            } else if (this.X) {
                Logger logger = Z2;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(Util.s(">> CONNECTION %s", Http2.f31156a.w()));
                }
                this.s.write(Http2.f31156a.G0());
                this.s.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void close() throws IOException {
        this.X2 = true;
        this.s.close();
    }

    public synchronized void d(boolean z, int i2, Buffer buffer, int i3) throws IOException {
        if (!this.X2) {
            e(i2, z ? (byte) 1 : 0, buffer, i3);
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: package-private */
    public void e(int i2, byte b2, Buffer buffer, int i3) throws IOException {
        f(i2, i3, (byte) 0, b2);
        if (i3 > 0) {
            this.s.u1(buffer, (long) i3);
        }
    }

    public void f(int i2, int i3, byte b2, byte b3) throws IOException {
        Logger logger = Z2;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Http2.b(false, i2, i3, b2, b3));
        }
        int i4 = this.Z;
        if (i3 > i4) {
            throw Http2.c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i4), Integer.valueOf(i3));
        } else if ((Integer.MIN_VALUE & i2) == 0) {
            x(this.s, i3);
            this.s.writeByte(b2 & 255);
            this.s.writeByte(b3 & 255);
            this.s.writeInt(i2 & Integer.MAX_VALUE);
        } else {
            throw Http2.c("reserved bit set: %s", Integer.valueOf(i2));
        }
    }

    public synchronized void flush() throws IOException {
        if (!this.X2) {
            this.s.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void h(int i2, ErrorCode errorCode, byte[] bArr) throws IOException {
        try {
            if (this.X2) {
                throw new IOException("closed");
            } else if (errorCode.s != -1) {
                f(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.s.writeInt(i2);
                this.s.writeInt(errorCode.s);
                if (bArr.length > 0) {
                    this.s.write(bArr);
                }
                this.s.flush();
            } else {
                throw Http2.c("errorCode.httpCode == -1", new Object[0]);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void i(int i2, List<Header> list) throws IOException {
        if (!this.X2) {
            k(false, i2, list);
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: package-private */
    public void k(boolean z, int i2, List<Header> list) throws IOException {
        if (!this.X2) {
            this.Y2.g(list);
            long L0 = this.Y.L0();
            int min = (int) Math.min((long) this.Z, L0);
            long j2 = (long) min;
            int i3 = (L0 > j2 ? 1 : (L0 == j2 ? 0 : -1));
            byte b2 = i3 == 0 ? (byte) 4 : 0;
            if (z) {
                b2 = (byte) (b2 | 1);
            }
            f(i2, min, (byte) 1, b2);
            this.s.u1(this.Y, j2);
            if (i3 > 0) {
                w(i2, L0 - j2);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    public int n() {
        return this.Z;
    }

    public synchronized void p(boolean z, int i2, int i3) throws IOException {
        if (!this.X2) {
            f(0, 8, (byte) 6, z ? (byte) 1 : 0);
            this.s.writeInt(i2);
            this.s.writeInt(i3);
            this.s.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void q(int i2, int i3, List<Header> list) throws IOException {
        if (!this.X2) {
            this.Y2.g(list);
            long L0 = this.Y.L0();
            int min = (int) Math.min((long) (this.Z - 4), L0);
            long j2 = (long) min;
            int i4 = (L0 > j2 ? 1 : (L0 == j2 ? 0 : -1));
            f(i2, min + 4, (byte) 5, i4 == 0 ? (byte) 4 : 0);
            this.s.writeInt(i3 & Integer.MAX_VALUE);
            this.s.u1(this.Y, j2);
            if (i4 > 0) {
                w(i2, L0 - j2);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void r(int i2, ErrorCode errorCode) throws IOException {
        if (this.X2) {
            throw new IOException("closed");
        } else if (errorCode.s != -1) {
            f(i2, 4, (byte) 3, (byte) 0);
            this.s.writeInt(errorCode.s);
            this.s.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized void s(Settings settings) throws IOException {
        try {
            if (!this.X2) {
                int i2 = 0;
                f(0, settings.l() * 6, (byte) 4, (byte) 0);
                while (i2 < 10) {
                    if (settings.i(i2)) {
                        this.s.writeShort(i2 == 4 ? 3 : i2 == 7 ? 4 : i2);
                        this.s.writeInt(settings.b(i2));
                    }
                    i2++;
                }
                this.s.flush();
            } else {
                throw new IOException("closed");
            }
        } finally {
        }
    }

    public synchronized void t(boolean z, int i2, List<Header> list) throws IOException {
        if (!this.X2) {
            k(z, i2, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void u(boolean z, int i2, int i3, List<Header> list) throws IOException {
        if (!this.X2) {
            k(z, i2, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void v(int i2, long j2) throws IOException {
        if (this.X2) {
            throw new IOException("closed");
        } else if (j2 == 0 || j2 > 2147483647L) {
            throw Http2.c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j2));
        } else {
            f(i2, 4, (byte) 8, (byte) 0);
            this.s.writeInt((int) j2);
            this.s.flush();
        }
    }
}
