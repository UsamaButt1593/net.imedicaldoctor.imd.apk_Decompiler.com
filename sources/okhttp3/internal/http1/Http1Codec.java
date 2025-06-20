package okhttp3.internal.http1;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http1Codec implements HttpCodec {

    /* renamed from: h  reason: collision with root package name */
    private static final int f31103h = 0;

    /* renamed from: i  reason: collision with root package name */
    private static final int f31104i = 1;

    /* renamed from: j  reason: collision with root package name */
    private static final int f31105j = 2;

    /* renamed from: k  reason: collision with root package name */
    private static final int f31106k = 3;

    /* renamed from: l  reason: collision with root package name */
    private static final int f31107l = 4;

    /* renamed from: m  reason: collision with root package name */
    private static final int f31108m = 5;

    /* renamed from: n  reason: collision with root package name */
    private static final int f31109n = 6;
    private static final int o = 262144;

    /* renamed from: b  reason: collision with root package name */
    final OkHttpClient f31110b;

    /* renamed from: c  reason: collision with root package name */
    final StreamAllocation f31111c;

    /* renamed from: d  reason: collision with root package name */
    final BufferedSource f31112d;

    /* renamed from: e  reason: collision with root package name */
    final BufferedSink f31113e;

    /* renamed from: f  reason: collision with root package name */
    int f31114f = 0;

    /* renamed from: g  reason: collision with root package name */
    private long f31115g = PlaybackStateCompat.x3;

    private abstract class AbstractSource implements Source {
        protected boolean X;
        protected long Y;
        protected final ForwardingTimeout s;

        private AbstractSource() {
            this.s = new ForwardingTimeout(Http1Codec.this.f31112d.j());
            this.Y = 0;
        }

        /* access modifiers changed from: protected */
        public final void b(boolean z, IOException iOException) throws IOException {
            Http1Codec http1Codec = Http1Codec.this;
            int i2 = http1Codec.f31114f;
            if (i2 != 6) {
                if (i2 == 5) {
                    http1Codec.g(this.s);
                    Http1Codec http1Codec2 = Http1Codec.this;
                    http1Codec2.f31114f = 6;
                    StreamAllocation streamAllocation = http1Codec2.f31111c;
                    if (streamAllocation != null) {
                        streamAllocation.r(!z, http1Codec2, this.Y, iOException);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("state: " + Http1Codec.this.f31114f);
            }
        }

        public Timeout j() {
            return this.s;
        }

        public long n2(Buffer buffer, long j2) throws IOException {
            try {
                long n2 = Http1Codec.this.f31112d.n2(buffer, j2);
                if (n2 > 0) {
                    this.Y += n2;
                }
                return n2;
            } catch (IOException e2) {
                b(false, e2);
                throw e2;
            }
        }
    }

    private final class ChunkedSink implements Sink {
        private boolean X;
        private final ForwardingTimeout s;

        ChunkedSink() {
            this.s = new ForwardingTimeout(Http1Codec.this.f31113e.j());
        }

        public synchronized void close() throws IOException {
            if (!this.X) {
                this.X = true;
                Http1Codec.this.f31113e.W0("0\r\n\r\n");
                Http1Codec.this.g(this.s);
                Http1Codec.this.f31114f = 3;
            }
        }

        public synchronized void flush() throws IOException {
            if (!this.X) {
                Http1Codec.this.f31113e.flush();
            }
        }

        public Timeout j() {
            return this.s;
        }

        public void u1(Buffer buffer, long j2) throws IOException {
            if (this.X) {
                throw new IllegalStateException("closed");
            } else if (j2 != 0) {
                Http1Codec.this.f31113e.z1(j2);
                Http1Codec.this.f31113e.W0("\r\n");
                Http1Codec.this.f31113e.u1(buffer, j2);
                Http1Codec.this.f31113e.W0("\r\n");
            }
        }
    }

    private class ChunkedSource extends AbstractSource {
        private static final long b3 = -1;
        private final HttpUrl X2;
        private long Y2 = -1;
        private boolean Z2 = true;

        ChunkedSource(HttpUrl httpUrl) {
            super();
            this.X2 = httpUrl;
        }

        private void c() throws IOException {
            if (this.Y2 != -1) {
                Http1Codec.this.f31112d.O1();
            }
            try {
                this.Y2 = Http1Codec.this.f31112d.Q2();
                String trim = Http1Codec.this.f31112d.O1().trim();
                if (this.Y2 < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.Y2 + trim + "\"");
                } else if (this.Y2 == 0) {
                    this.Z2 = false;
                    HttpHeaders.k(Http1Codec.this.f31110b.l(), this.X2, Http1Codec.this.o());
                    b(true, (IOException) null);
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        public void close() throws IOException {
            if (!this.X) {
                if (this.Z2 && !Util.q(this, 100, TimeUnit.MILLISECONDS)) {
                    b(false, (IOException) null);
                }
                this.X = true;
            }
        }

        public long n2(Buffer buffer, long j2) throws IOException {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            } else if (this.X) {
                throw new IllegalStateException("closed");
            } else if (!this.Z2) {
                return -1;
            } else {
                long j3 = this.Y2;
                if (j3 == 0 || j3 == -1) {
                    c();
                    if (!this.Z2) {
                        return -1;
                    }
                }
                long n2 = super.n2(buffer, Math.min(j2, this.Y2));
                if (n2 != -1) {
                    this.Y2 -= n2;
                    return n2;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                b(false, protocolException);
                throw protocolException;
            }
        }
    }

    private final class FixedLengthSink implements Sink {
        private boolean X;
        private long Y;
        private final ForwardingTimeout s;

        FixedLengthSink(long j2) {
            this.s = new ForwardingTimeout(Http1Codec.this.f31113e.j());
            this.Y = j2;
        }

        public void close() throws IOException {
            if (!this.X) {
                this.X = true;
                if (this.Y <= 0) {
                    Http1Codec.this.g(this.s);
                    Http1Codec.this.f31114f = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }

        public void flush() throws IOException {
            if (!this.X) {
                Http1Codec.this.f31113e.flush();
            }
        }

        public Timeout j() {
            return this.s;
        }

        public void u1(Buffer buffer, long j2) throws IOException {
            if (!this.X) {
                Util.f(buffer.L0(), 0, j2);
                if (j2 <= this.Y) {
                    Http1Codec.this.f31113e.u1(buffer, j2);
                    this.Y -= j2;
                    return;
                }
                throw new ProtocolException("expected " + this.Y + " bytes but received " + j2);
            }
            throw new IllegalStateException("closed");
        }
    }

    private class FixedLengthSource extends AbstractSource {
        private long X2;

        FixedLengthSource(long j2) throws IOException {
            super();
            this.X2 = j2;
            if (j2 == 0) {
                b(true, (IOException) null);
            }
        }

        public void close() throws IOException {
            if (!this.X) {
                if (this.X2 != 0 && !Util.q(this, 100, TimeUnit.MILLISECONDS)) {
                    b(false, (IOException) null);
                }
                this.X = true;
            }
        }

        public long n2(Buffer buffer, long j2) throws IOException {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            } else if (!this.X) {
                long j3 = this.X2;
                if (j3 == 0) {
                    return -1;
                }
                long n2 = super.n2(buffer, Math.min(j3, j2));
                if (n2 != -1) {
                    long j4 = this.X2 - n2;
                    this.X2 = j4;
                    if (j4 == 0) {
                        b(true, (IOException) null);
                    }
                    return n2;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                b(false, protocolException);
                throw protocolException;
            } else {
                throw new IllegalStateException("closed");
            }
        }
    }

    private class UnknownLengthSource extends AbstractSource {
        private boolean X2;

        UnknownLengthSource() {
            super();
        }

        public void close() throws IOException {
            if (!this.X) {
                if (!this.X2) {
                    b(false, (IOException) null);
                }
                this.X = true;
            }
        }

        public long n2(Buffer buffer, long j2) throws IOException {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            } else if (this.X) {
                throw new IllegalStateException("closed");
            } else if (this.X2) {
                return -1;
            } else {
                long n2 = super.n2(buffer, j2);
                if (n2 != -1) {
                    return n2;
                }
                this.X2 = true;
                b(true, (IOException) null);
                return -1;
            }
        }
    }

    public Http1Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.f31110b = okHttpClient;
        this.f31111c = streamAllocation;
        this.f31112d = bufferedSource;
        this.f31113e = bufferedSink;
    }

    private String n() throws IOException {
        String M0 = this.f31112d.M0(this.f31115g);
        this.f31115g -= (long) M0.length();
        return M0;
    }

    public void a() throws IOException {
        this.f31113e.flush();
    }

    public void b(Request request) throws IOException {
        p(request.e(), RequestLine.a(request, this.f31111c.d().b().b().type()));
    }

    public ResponseBody c(Response response) throws IOException {
        StreamAllocation streamAllocation = this.f31111c;
        streamAllocation.f31060f.q(streamAllocation.f31059e);
        String i2 = response.i(com.google.common.net.HttpHeaders.f22875c);
        if (!HttpHeaders.c(response)) {
            return new RealResponseBody(i2, 0, Okio.e(l(0)));
        }
        if ("chunked".equalsIgnoreCase(response.i(com.google.common.net.HttpHeaders.M0))) {
            return new RealResponseBody(i2, -1, Okio.e(j(response.A().k())));
        }
        long b2 = HttpHeaders.b(response);
        return b2 != -1 ? new RealResponseBody(i2, b2, Okio.e(l(b2))) : new RealResponseBody(i2, -1, Okio.e(m()));
    }

    public void cancel() {
        RealConnection d2 = this.f31111c.d();
        if (d2 != null) {
            d2.g();
        }
    }

    public Response.Builder d(boolean z) throws IOException {
        int i2 = this.f31114f;
        if (i2 == 1 || i2 == 3) {
            try {
                StatusLine b2 = StatusLine.b(n());
                Response.Builder j2 = new Response.Builder().n(b2.f31100a).g(b2.f31101b).k(b2.f31102c).j(o());
                if (z && b2.f31101b == 100) {
                    return null;
                }
                if (b2.f31101b == 100) {
                    this.f31114f = 3;
                    return j2;
                }
                this.f31114f = 4;
                return j2;
            } catch (EOFException e2) {
                IOException iOException = new IOException("unexpected end of stream on " + this.f31111c);
                iOException.initCause(e2);
                throw iOException;
            }
        } else {
            throw new IllegalStateException("state: " + this.f31114f);
        }
    }

    public void e() throws IOException {
        this.f31113e.flush();
    }

    public Sink f(Request request, long j2) {
        if ("chunked".equalsIgnoreCase(request.c(com.google.common.net.HttpHeaders.M0))) {
            return i();
        }
        if (j2 != -1) {
            return k(j2);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    /* access modifiers changed from: package-private */
    public void g(ForwardingTimeout forwardingTimeout) {
        Timeout l2 = forwardingTimeout.l();
        forwardingTimeout.m(Timeout.f31400e);
        l2.a();
        l2.b();
    }

    public boolean h() {
        return this.f31114f == 6;
    }

    public Sink i() {
        if (this.f31114f == 1) {
            this.f31114f = 2;
            return new ChunkedSink();
        }
        throw new IllegalStateException("state: " + this.f31114f);
    }

    public Source j(HttpUrl httpUrl) throws IOException {
        if (this.f31114f == 4) {
            this.f31114f = 5;
            return new ChunkedSource(httpUrl);
        }
        throw new IllegalStateException("state: " + this.f31114f);
    }

    public Sink k(long j2) {
        if (this.f31114f == 1) {
            this.f31114f = 2;
            return new FixedLengthSink(j2);
        }
        throw new IllegalStateException("state: " + this.f31114f);
    }

    public Source l(long j2) throws IOException {
        if (this.f31114f == 4) {
            this.f31114f = 5;
            return new FixedLengthSource(j2);
        }
        throw new IllegalStateException("state: " + this.f31114f);
    }

    public Source m() throws IOException {
        if (this.f31114f == 4) {
            StreamAllocation streamAllocation = this.f31111c;
            if (streamAllocation != null) {
                this.f31114f = 5;
                streamAllocation.j();
                return new UnknownLengthSource();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.f31114f);
    }

    public Headers o() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String n2 = n();
            if (n2.length() == 0) {
                return builder.h();
            }
            Internal.f30969a.a(builder, n2);
        }
    }

    public void p(Headers headers, String str) throws IOException {
        if (this.f31114f == 0) {
            this.f31113e.W0(str).W0("\r\n");
            int l2 = headers.l();
            for (int i2 = 0; i2 < l2; i2++) {
                this.f31113e.W0(headers.g(i2)).W0(": ").W0(headers.n(i2)).W0("\r\n");
            }
            this.f31113e.W0("\r\n");
            this.f31114f = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f31114f);
    }
}
