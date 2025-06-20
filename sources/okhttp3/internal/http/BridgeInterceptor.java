package okhttp3.internal.http;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okio.GzipSource;
import okio.Okio;

public final class BridgeInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    private final CookieJar f31070a;

    public BridgeInterceptor(CookieJar cookieJar) {
        this.f31070a = cookieJar;
    }

    private String b(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                sb.append("; ");
            }
            Cookie cookie = list.get(i2);
            sb.append(cookie.h());
            sb.append(ASCIIPropertyListParser.f18654l);
            sb.append(cookie.t());
        }
        return sb.toString();
    }

    public Response a(Interceptor.Chain chain) throws IOException {
        Request k2 = chain.k();
        Request.Builder h2 = k2.h();
        RequestBody a2 = k2.a();
        if (a2 != null) {
            MediaType b2 = a2.b();
            if (b2 != null) {
                h2.h(HttpHeaders.f22875c, b2.toString());
            }
            long a3 = a2.a();
            if (a3 != -1) {
                h2.h(HttpHeaders.f22874b, Long.toString(a3));
                h2.n(HttpHeaders.M0);
            } else {
                h2.h(HttpHeaders.M0, "chunked");
                h2.n(HttpHeaders.f22874b);
            }
        }
        boolean z = false;
        if (k2.c(HttpHeaders.w) == null) {
            h2.h(HttpHeaders.w, Util.t(k2.k(), false));
        }
        if (k2.c(HttpHeaders.o) == null) {
            h2.h(HttpHeaders.o, HttpHeaders.u0);
        }
        if (k2.c(HttpHeaders.f22882j) == null && k2.c(HttpHeaders.I) == null) {
            h2.h(HttpHeaders.f22882j, "gzip");
            z = true;
        }
        List<Cookie> b3 = this.f31070a.b(k2.k());
        if (!b3.isEmpty()) {
            h2.h(HttpHeaders.p, b(b3));
        }
        if (k2.c(HttpHeaders.P) == null) {
            h2.h(HttpHeaders.P, Version.a());
        }
        Response e2 = chain.e(h2.b());
        HttpHeaders.k(this.f31070a, k2.k(), e2.p());
        Response.Builder q = e2.u().q(k2);
        if (z && "gzip".equalsIgnoreCase(e2.i("Content-Encoding")) && HttpHeaders.c(e2)) {
            GzipSource gzipSource = new GzipSource(e2.b().q());
            q.j(e2.p().i().j("Content-Encoding").j(HttpHeaders.f22874b).h());
            q.b(new RealResponseBody(e2.i(HttpHeaders.f22875c), -1, Okio.e(gzipSource)));
        }
        return q.c();
    }
}
