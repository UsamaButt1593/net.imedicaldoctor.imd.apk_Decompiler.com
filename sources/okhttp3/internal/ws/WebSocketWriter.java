package okhttp3.internal.ws;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.Random;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;

final class WebSocketWriter {

    /* renamed from: a  reason: collision with root package name */
    final boolean f31326a;

    /* renamed from: b  reason: collision with root package name */
    final Random f31327b;

    /* renamed from: c  reason: collision with root package name */
    final BufferedSink f31328c;

    /* renamed from: d  reason: collision with root package name */
    final Buffer f31329d;

    /* renamed from: e  reason: collision with root package name */
    boolean f31330e;

    /* renamed from: f  reason: collision with root package name */
    final Buffer f31331f = new Buffer();

    /* renamed from: g  reason: collision with root package name */
    final FrameSink f31332g = new FrameSink();

    /* renamed from: h  reason: collision with root package name */
    boolean f31333h;

    /* renamed from: i  reason: collision with root package name */
    private final byte[] f31334i;

    /* renamed from: j  reason: collision with root package name */
    private final Buffer.UnsafeCursor f31335j;

    final class FrameSink implements Sink {
        long X;
        boolean Y;
        boolean Z;
        int s;

        FrameSink() {
        }

        public void close() throws IOException {
            if (!this.Z) {
                WebSocketWriter webSocketWriter = WebSocketWriter.this;
                webSocketWriter.d(this.s, webSocketWriter.f31331f.L0(), this.Y, true);
                this.Z = true;
                WebSocketWriter.this.f31333h = false;
                return;
            }
            throw new IOException("closed");
        }

        public void flush() throws IOException {
            if (!this.Z) {
                WebSocketWriter webSocketWriter = WebSocketWriter.this;
                webSocketWriter.d(this.s, webSocketWriter.f31331f.L0(), this.Y, false);
                this.Y = false;
                return;
            }
            throw new IOException("closed");
        }

        public Timeout j() {
            return WebSocketWriter.this.f31328c.j();
        }

        public void u1(Buffer buffer, long j2) throws IOException {
            if (!this.Z) {
                WebSocketWriter.this.f31331f.u1(buffer, j2);
                boolean z = this.Y && this.X != -1 && WebSocketWriter.this.f31331f.L0() > this.X - PlaybackStateCompat.s3;
                long f2 = WebSocketWriter.this.f31331f.f();
                if (f2 > 0 && !z) {
                    WebSocketWriter.this.d(this.s, f2, this.Y, false);
                    this.Y = false;
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }
    }

    WebSocketWriter(boolean z, BufferedSink bufferedSink, Random random) {
        if (bufferedSink == null) {
            throw new NullPointerException("sink == null");
        } else if (random != null) {
            this.f31326a = z;
            this.f31328c = bufferedSink;
            this.f31329d = bufferedSink.g();
            this.f31327b = random;
            Buffer.UnsafeCursor unsafeCursor = null;
            this.f31334i = z ? new byte[4] : null;
            this.f31335j = z ? new Buffer.UnsafeCursor() : unsafeCursor;
        } else {
            throw new NullPointerException("random == null");
        }
    }

    private void c(int i2, ByteString byteString) throws IOException {
        if (!this.f31330e) {
            int m0 = byteString.m0();
            if (((long) m0) <= 125) {
                this.f31329d.writeByte(i2 | 128);
                if (this.f31326a) {
                    this.f31329d.writeByte(m0 | 128);
                    this.f31327b.nextBytes(this.f31334i);
                    this.f31329d.write(this.f31334i);
                    if (m0 > 0) {
                        long L0 = this.f31329d.L0();
                        this.f31329d.g2(byteString);
                        this.f31329d.S(this.f31335j);
                        this.f31335j.f(L0);
                        WebSocketProtocol.c(this.f31335j, this.f31334i);
                        this.f31335j.close();
                    }
                } else {
                    this.f31329d.writeByte(m0);
                    this.f31329d.g2(byteString);
                }
                this.f31328c.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        throw new IOException("closed");
    }

    /* access modifiers changed from: package-private */
    public Sink a(int i2, long j2) {
        if (!this.f31333h) {
            this.f31333h = true;
            FrameSink frameSink = this.f31332g;
            frameSink.s = i2;
            frameSink.X = j2;
            frameSink.Y = true;
            frameSink.Z = false;
            return frameSink;
        }
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    /* access modifiers changed from: package-private */
    public void b(int i2, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.Y2;
        if (!(i2 == 0 && byteString == null)) {
            if (i2 != 0) {
                WebSocketProtocol.d(i2);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i2);
            if (byteString != null) {
                buffer.g2(byteString);
            }
            byteString2 = buffer.A1();
        }
        try {
            c(8, byteString2);
        } finally {
            this.f31330e = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void d(int i2, long j2, boolean z, boolean z2) throws IOException {
        if (!this.f31330e) {
            int i3 = 0;
            if (!z) {
                i2 = 0;
            }
            if (z2) {
                i2 |= 128;
            }
            this.f31329d.writeByte(i2);
            if (this.f31326a) {
                i3 = 128;
            }
            if (j2 <= 125) {
                this.f31329d.writeByte(((int) j2) | i3);
            } else if (j2 <= 65535) {
                this.f31329d.writeByte(i3 | 126);
                this.f31329d.writeShort((int) j2);
            } else {
                this.f31329d.writeByte(i3 | WorkQueueKt.f29430c);
                this.f31329d.writeLong(j2);
            }
            if (this.f31326a) {
                this.f31327b.nextBytes(this.f31334i);
                this.f31329d.write(this.f31334i);
                if (j2 > 0) {
                    long L0 = this.f31329d.L0();
                    this.f31329d.u1(this.f31331f, j2);
                    this.f31329d.S(this.f31335j);
                    this.f31335j.f(L0);
                    WebSocketProtocol.c(this.f31335j, this.f31334i);
                    this.f31335j.close();
                }
            } else {
                this.f31329d.u1(this.f31331f, j2);
            }
            this.f31328c.M();
            return;
        }
        throw new IOException("closed");
    }

    /* access modifiers changed from: package-private */
    public void e(ByteString byteString) throws IOException {
        c(9, byteString);
    }

    /* access modifiers changed from: package-private */
    public void f(ByteString byteString) throws IOException {
        c(10, byteString);
    }
}
