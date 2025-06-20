package okhttp3.internal.cache;

import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class CacheInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    final InternalCache f30984a;

    public CacheInterceptor(InternalCache internalCache) {
        this.f30984a = internalCache;
    }

    private Response b(final CacheRequest cacheRequest, Response response) throws IOException {
        Sink k2;
        if (cacheRequest == null || (k2 = cacheRequest.k()) == null) {
            return response;
        }
        final BufferedSource q = response.b().q();
        final BufferedSink d2 = Okio.d(k2);
        AnonymousClass1 r2 = new Source() {
            boolean s;

            public void close() throws IOException {
                if (!this.s && !Util.q(this, 100, TimeUnit.MILLISECONDS)) {
                    this.s = true;
                    cacheRequest.abort();
                }
                q.close();
            }

            public Timeout j() {
                return q.j();
            }

            public long n2(Buffer buffer, long j2) throws IOException {
                try {
                    long n2 = q.n2(buffer, j2);
                    if (n2 == -1) {
                        if (!this.s) {
                            this.s = true;
                            d2.close();
                        }
                        return -1;
                    }
                    buffer.r(d2.g(), buffer.L0() - n2, n2);
                    d2.F0();
                    return n2;
                } catch (IOException e2) {
                    if (!this.s) {
                        this.s = true;
                        cacheRequest.abort();
                    }
                    throw e2;
                }
            }
        };
        return response.u().b(new RealResponseBody(response.i(HttpHeaders.f22875c), response.b().f(), Okio.e(r2))).c();
    }

    private static Headers c(Headers headers, Headers headers2) {
        Headers.Builder builder = new Headers.Builder();
        int l2 = headers.l();
        for (int i2 = 0; i2 < l2; i2++) {
            String g2 = headers.g(i2);
            String n2 = headers.n(i2);
            if ((!HttpHeaders.f22879g.equalsIgnoreCase(g2) || !n2.startsWith(IcyHeaders.a3)) && (d(g2) || !e(g2) || headers2.d(g2) == null)) {
                Internal.f30969a.b(builder, g2, n2);
            }
        }
        int l3 = headers2.l();
        for (int i3 = 0; i3 < l3; i3++) {
            String g3 = headers2.g(i3);
            if (!d(g3) && e(g3)) {
                Internal.f30969a.b(builder, g3, headers2.n(i3));
            }
        }
        return builder.h();
    }

    static boolean d(String str) {
        return HttpHeaders.f22874b.equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || HttpHeaders.f22875c.equalsIgnoreCase(str);
    }

    static boolean e(String str) {
        return !HttpHeaders.o.equalsIgnoreCase(str) && !HttpHeaders.u0.equalsIgnoreCase(str) && !"Proxy-Authenticate".equalsIgnoreCase(str) && !"Proxy-Authorization".equalsIgnoreCase(str) && !HttpHeaders.M.equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !HttpHeaders.M0.equalsIgnoreCase(str) && !HttpHeaders.N.equalsIgnoreCase(str);
    }

    private static Response f(Response response) {
        return (response == null || response.b() == null) ? response : response.u().b((ResponseBody) null).c();
    }

    public Response a(Interceptor.Chain chain) throws IOException {
        InternalCache internalCache = this.f30984a;
        Response e2 = internalCache != null ? internalCache.e(chain.k()) : null;
        CacheStrategy c2 = new CacheStrategy.Factory(System.currentTimeMillis(), chain.k(), e2).c();
        Request request = c2.f30985a;
        Response response = c2.f30986b;
        InternalCache internalCache2 = this.f30984a;
        if (internalCache2 != null) {
            internalCache2.b(c2);
        }
        if (e2 != null && response == null) {
            Util.g(e2.b());
        }
        if (request == null && response == null) {
            return new Response.Builder().q(chain.k()).n(Protocol.HTTP_1_1).g(504).k("Unsatisfiable Request (only-if-cached)").b(Util.f30972c).r(-1).o(System.currentTimeMillis()).c();
        }
        if (request == null) {
            return response.u().d(f(response)).c();
        }
        try {
            Response e3 = chain.e(request);
            if (e3 == null && e2 != null) {
            }
            if (response != null) {
                if (e3.f() == 304) {
                    Response c3 = response.u().j(c(response.p(), e3.p())).r(e3.C()).o(e3.y()).d(f(response)).l(f(e3)).c();
                    e3.b().close();
                    this.f30984a.a();
                    this.f30984a.f(response, c3);
                    return c3;
                }
                Util.g(response.b());
            }
            Response c4 = e3.u().d(f(response)).l(f(e3)).c();
            if (this.f30984a != null) {
                if (okhttp3.internal.http.HttpHeaders.c(c4) && CacheStrategy.a(c4, request)) {
                    return b(this.f30984a.d(c4), c4);
                }
                if (HttpMethod.a(request.g())) {
                    try {
                        this.f30984a.c(request);
                    } catch (IOException unused) {
                    }
                }
            }
            return c4;
        } finally {
            if (e2 != null) {
                Util.g(e2.b());
            }
        }
    }
}
