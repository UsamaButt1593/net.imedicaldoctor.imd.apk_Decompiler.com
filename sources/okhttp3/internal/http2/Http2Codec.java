package okhttp3.internal.http2;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Http2Codec implements HttpCodec {

    /* renamed from: g  reason: collision with root package name */
    private static final String f31170g = "connection";

    /* renamed from: h  reason: collision with root package name */
    private static final String f31171h = "host";

    /* renamed from: i  reason: collision with root package name */
    private static final String f31172i = "keep-alive";

    /* renamed from: j  reason: collision with root package name */
    private static final String f31173j = "proxy-connection";

    /* renamed from: k  reason: collision with root package name */
    private static final String f31174k = "transfer-encoding";

    /* renamed from: l  reason: collision with root package name */
    private static final String f31175l = "te";

    /* renamed from: m  reason: collision with root package name */
    private static final String f31176m = "encoding";

    /* renamed from: n  reason: collision with root package name */
    private static final String f31177n = "upgrade";
    private static final List<String> o = Util.v(f31170g, f31171h, f31172i, f31173j, f31175l, f31174k, "encoding", f31177n, Header.f31118f, Header.f31119g, Header.f31120h, Header.f31121i);
    private static final List<String> p = Util.v(f31170g, f31171h, f31172i, f31173j, f31175l, f31174k, "encoding", f31177n);

    /* renamed from: b  reason: collision with root package name */
    private final Interceptor.Chain f31178b;

    /* renamed from: c  reason: collision with root package name */
    final StreamAllocation f31179c;

    /* renamed from: d  reason: collision with root package name */
    private final Http2Connection f31180d;

    /* renamed from: e  reason: collision with root package name */
    private Http2Stream f31181e;

    /* renamed from: f  reason: collision with root package name */
    private final Protocol f31182f;

    class StreamFinishingSource extends ForwardingSource {
        boolean X = false;
        long Y = 0;

        StreamFinishingSource(Source source) {
            super(source);
        }

        private void d(IOException iOException) {
            if (!this.X) {
                this.X = true;
                Http2Codec http2Codec = Http2Codec.this;
                http2Codec.f31179c.r(false, http2Codec, this.Y, iOException);
            }
        }

        public void close() throws IOException {
            super.close();
            d((IOException) null);
        }

        public long n2(Buffer buffer, long j2) throws IOException {
            try {
                long n2 = c().n2(buffer, j2);
                if (n2 > 0) {
                    this.Y += n2;
                }
                return n2;
            } catch (IOException e2) {
                d(e2);
                throw e2;
            }
        }
    }

    public Http2Codec(OkHttpClient okHttpClient, Interceptor.Chain chain, StreamAllocation streamAllocation, Http2Connection http2Connection) {
        this.f31178b = chain;
        this.f31179c = streamAllocation;
        this.f31180d = http2Connection;
        List<Protocol> y = okHttpClient.y();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.f31182f = !y.contains(protocol) ? Protocol.HTTP_2 : protocol;
    }

    public static List<Header> g(Request request) {
        Headers e2 = request.e();
        ArrayList arrayList = new ArrayList(e2.l() + 4);
        arrayList.add(new Header(Header.f31123k, request.g()));
        arrayList.add(new Header(Header.f31124l, RequestLine.c(request.k())));
        String c2 = request.c(HttpHeaders.w);
        if (c2 != null) {
            arrayList.add(new Header(Header.f31126n, c2));
        }
        arrayList.add(new Header(Header.f31125m, request.k().P()));
        int l2 = e2.l();
        for (int i2 = 0; i2 < l2; i2++) {
            ByteString n2 = ByteString.n(e2.g(i2).toLowerCase(Locale.US));
            if (!o.contains(n2.I0())) {
                arrayList.add(new Header(n2, e2.n(i2)));
            }
        }
        return arrayList;
    }

    public static Response.Builder h(Headers headers, Protocol protocol) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int l2 = headers.l();
        StatusLine statusLine = null;
        for (int i2 = 0; i2 < l2; i2++) {
            String g2 = headers.g(i2);
            String n2 = headers.n(i2);
            if (g2.equals(Header.f31117e)) {
                statusLine = StatusLine.b("HTTP/1.1 " + n2);
            } else if (!p.contains(g2)) {
                Internal.f30969a.b(builder, g2, n2);
            }
        }
        if (statusLine != null) {
            return new Response.Builder().n(protocol).g(statusLine.f31101b).k(statusLine.f31102c).j(builder.h());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public void a() throws IOException {
        this.f31181e.l().close();
    }

    public void b(Request request) throws IOException {
        if (this.f31181e == null) {
            Http2Stream s = this.f31180d.s(g(request), request.a() != null);
            this.f31181e = s;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            s.p().i((long) this.f31178b.b(), timeUnit);
            this.f31181e.y().i((long) this.f31178b.c(), timeUnit);
        }
    }

    public ResponseBody c(Response response) throws IOException {
        StreamAllocation streamAllocation = this.f31179c;
        streamAllocation.f31060f.q(streamAllocation.f31059e);
        return new RealResponseBody(response.i(HttpHeaders.f22875c), okhttp3.internal.http.HttpHeaders.b(response), Okio.e(new StreamFinishingSource(this.f31181e.m())));
    }

    public void cancel() {
        Http2Stream http2Stream = this.f31181e;
        if (http2Stream != null) {
            http2Stream.h(ErrorCode.CANCEL);
        }
    }

    public Response.Builder d(boolean z) throws IOException {
        Response.Builder h2 = h(this.f31181e.v(), this.f31182f);
        if (!z || Internal.f30969a.d(h2) != 100) {
            return h2;
        }
        return null;
    }

    public void e() throws IOException {
        this.f31180d.flush();
    }

    public Sink f(Request request, long j2) {
        return this.f31181e.l();
    }
}
