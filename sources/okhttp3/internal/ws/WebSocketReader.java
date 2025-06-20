package okhttp3.internal.ws;

import com.google.common.primitives.SignedBytes;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

final class WebSocketReader {

    /* renamed from: a  reason: collision with root package name */
    final boolean f31314a;

    /* renamed from: b  reason: collision with root package name */
    final BufferedSource f31315b;

    /* renamed from: c  reason: collision with root package name */
    final FrameCallback f31316c;

    /* renamed from: d  reason: collision with root package name */
    boolean f31317d;

    /* renamed from: e  reason: collision with root package name */
    int f31318e;

    /* renamed from: f  reason: collision with root package name */
    long f31319f;

    /* renamed from: g  reason: collision with root package name */
    boolean f31320g;

    /* renamed from: h  reason: collision with root package name */
    boolean f31321h;

    /* renamed from: i  reason: collision with root package name */
    private final Buffer f31322i = new Buffer();

    /* renamed from: j  reason: collision with root package name */
    private final Buffer f31323j = new Buffer();

    /* renamed from: k  reason: collision with root package name */
    private final byte[] f31324k;

    /* renamed from: l  reason: collision with root package name */
    private final Buffer.UnsafeCursor f31325l;

    public interface FrameCallback {
        void c(ByteString byteString) throws IOException;

        void d(String str) throws IOException;

        void e(ByteString byteString);

        void h(ByteString byteString);

        void i(int i2, String str);
    }

    WebSocketReader(boolean z, BufferedSource bufferedSource, FrameCallback frameCallback) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        } else if (frameCallback != null) {
            this.f31314a = z;
            this.f31315b = bufferedSource;
            this.f31316c = frameCallback;
            Buffer.UnsafeCursor unsafeCursor = null;
            this.f31324k = z ? null : new byte[4];
            this.f31325l = !z ? new Buffer.UnsafeCursor() : unsafeCursor;
        } else {
            throw new NullPointerException("frameCallback == null");
        }
    }

    private void b() throws IOException {
        String str;
        short s;
        long j2 = this.f31319f;
        if (j2 > 0) {
            this.f31315b.w0(this.f31322i, j2);
            if (!this.f31314a) {
                this.f31322i.S(this.f31325l);
                this.f31325l.f(0);
                WebSocketProtocol.c(this.f31325l, this.f31324k);
                this.f31325l.close();
            }
        }
        switch (this.f31318e) {
            case 8:
                long L0 = this.f31322i.L0();
                if (L0 != 1) {
                    if (L0 != 0) {
                        s = this.f31322i.readShort();
                        str = this.f31322i.a2();
                        String b2 = WebSocketProtocol.b(s);
                        if (b2 != null) {
                            throw new ProtocolException(b2);
                        }
                    } else {
                        s = 1005;
                        str = "";
                    }
                    this.f31316c.i(s, str);
                    this.f31317d = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.f31316c.e(this.f31322i.A1());
                return;
            case 10:
                this.f31316c.h(this.f31322i.A1());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.f31318e));
        }
    }

    /* JADX INFO: finally extract failed */
    private void c() throws IOException {
        if (!this.f31317d) {
            long j2 = this.f31315b.j().j();
            this.f31315b.j().b();
            try {
                byte readByte = this.f31315b.readByte();
                this.f31315b.j().i(j2, TimeUnit.NANOSECONDS);
                this.f31318e = readByte & 15;
                boolean z = false;
                boolean z2 = (readByte & 128) != 0;
                this.f31320g = z2;
                boolean z3 = (readByte & 8) != 0;
                this.f31321h = z3;
                if (!z3 || z2) {
                    boolean z4 = (readByte & SignedBytes.f22967a) != 0;
                    boolean z5 = (readByte & 32) != 0;
                    boolean z6 = (readByte & 16) != 0;
                    if (z4 || z5 || z6) {
                        throw new ProtocolException("Reserved flags are unsupported.");
                    }
                    byte readByte2 = this.f31315b.readByte();
                    if ((readByte2 & 128) != 0) {
                        z = true;
                    }
                    if (z == this.f31314a) {
                        throw new ProtocolException(this.f31314a ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
                    }
                    long j3 = (long) (readByte2 & Byte.MAX_VALUE);
                    this.f31319f = j3;
                    if (j3 == 126) {
                        this.f31319f = ((long) this.f31315b.readShort()) & 65535;
                    } else if (j3 == 127) {
                        long readLong = this.f31315b.readLong();
                        this.f31319f = readLong;
                        if (readLong < 0) {
                            throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f31319f) + " > 0x7FFFFFFFFFFFFFFF");
                        }
                    }
                    if (this.f31321h && this.f31319f > 125) {
                        throw new ProtocolException("Control frame must be less than 125B.");
                    } else if (z) {
                        this.f31315b.readFully(this.f31324k);
                    }
                } else {
                    throw new ProtocolException("Control frames must be final.");
                }
            } catch (Throwable th) {
                this.f31315b.j().i(j2, TimeUnit.NANOSECONDS);
                throw th;
            }
        } else {
            throw new IOException("closed");
        }
    }

    private void d() throws IOException {
        while (!this.f31317d) {
            long j2 = this.f31319f;
            if (j2 > 0) {
                this.f31315b.w0(this.f31323j, j2);
                if (!this.f31314a) {
                    this.f31323j.S(this.f31325l);
                    this.f31325l.f(this.f31323j.L0() - this.f31319f);
                    WebSocketProtocol.c(this.f31325l, this.f31324k);
                    this.f31325l.close();
                }
            }
            if (!this.f31320g) {
                f();
                if (this.f31318e != 0) {
                    throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.f31318e));
                }
            } else {
                return;
            }
        }
        throw new IOException("closed");
    }

    private void e() throws IOException {
        int i2 = this.f31318e;
        if (i2 == 1 || i2 == 2) {
            d();
            if (i2 == 1) {
                this.f31316c.d(this.f31323j.a2());
            } else {
                this.f31316c.c(this.f31323j.A1());
            }
        } else {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i2));
        }
    }

    private void f() throws IOException {
        while (!this.f31317d) {
            c();
            if (this.f31321h) {
                b();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a() throws IOException {
        c();
        if (this.f31321h) {
            b();
        } else {
            e();
        }
    }
}
