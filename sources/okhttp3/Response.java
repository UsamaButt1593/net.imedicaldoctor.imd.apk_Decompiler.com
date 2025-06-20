package okhttp3;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;

public final class Response implements Closeable {
    final Protocol X;
    @Nullable
    final Handshake X2;
    final int Y;
    final Headers Y2;
    final String Z;
    @Nullable
    final ResponseBody Z2;
    @Nullable
    final Response a3;
    @Nullable
    final Response b3;
    @Nullable
    final Response c3;
    final long d3;
    final long e3;
    @Nullable
    private volatile CacheControl f3;
    final Request s;

    public static class Builder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        Request f30954a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        Protocol f30955b;

        /* renamed from: c  reason: collision with root package name */
        int f30956c;

        /* renamed from: d  reason: collision with root package name */
        String f30957d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        Handshake f30958e;

        /* renamed from: f  reason: collision with root package name */
        Headers.Builder f30959f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        ResponseBody f30960g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        Response f30961h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        Response f30962i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        Response f30963j;

        /* renamed from: k  reason: collision with root package name */
        long f30964k;

        /* renamed from: l  reason: collision with root package name */
        long f30965l;

        public Builder() {
            this.f30956c = -1;
            this.f30959f = new Headers.Builder();
        }

        private void e(Response response) {
            if (response.Z2 != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        private void f(String str, Response response) {
            if (response.Z2 != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (response.a3 != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (response.b3 != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (response.c3 != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public Builder a(String str, String str2) {
            this.f30959f.b(str, str2);
            return this;
        }

        public Builder b(@Nullable ResponseBody responseBody) {
            this.f30960g = responseBody;
            return this;
        }

        public Response c() {
            if (this.f30954a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f30955b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f30956c < 0) {
                throw new IllegalStateException("code < 0: " + this.f30956c);
            } else if (this.f30957d != null) {
                return new Response(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }

        public Builder d(@Nullable Response response) {
            if (response != null) {
                f("cacheResponse", response);
            }
            this.f30962i = response;
            return this;
        }

        public Builder g(int i2) {
            this.f30956c = i2;
            return this;
        }

        public Builder h(@Nullable Handshake handshake) {
            this.f30958e = handshake;
            return this;
        }

        public Builder i(String str, String str2) {
            this.f30959f.k(str, str2);
            return this;
        }

        public Builder j(Headers headers) {
            this.f30959f = headers.i();
            return this;
        }

        public Builder k(String str) {
            this.f30957d = str;
            return this;
        }

        public Builder l(@Nullable Response response) {
            if (response != null) {
                f("networkResponse", response);
            }
            this.f30961h = response;
            return this;
        }

        public Builder m(@Nullable Response response) {
            if (response != null) {
                e(response);
            }
            this.f30963j = response;
            return this;
        }

        public Builder n(Protocol protocol) {
            this.f30955b = protocol;
            return this;
        }

        public Builder o(long j2) {
            this.f30965l = j2;
            return this;
        }

        public Builder p(String str) {
            this.f30959f.j(str);
            return this;
        }

        public Builder q(Request request) {
            this.f30954a = request;
            return this;
        }

        public Builder r(long j2) {
            this.f30964k = j2;
            return this;
        }

        Builder(Response response) {
            this.f30956c = -1;
            this.f30954a = response.s;
            this.f30955b = response.X;
            this.f30956c = response.Y;
            this.f30957d = response.Z;
            this.f30958e = response.X2;
            this.f30959f = response.Y2.i();
            this.f30960g = response.Z2;
            this.f30961h = response.a3;
            this.f30962i = response.b3;
            this.f30963j = response.c3;
            this.f30964k = response.d3;
            this.f30965l = response.e3;
        }
    }

    Response(Builder builder) {
        this.s = builder.f30954a;
        this.X = builder.f30955b;
        this.Y = builder.f30956c;
        this.Z = builder.f30957d;
        this.X2 = builder.f30958e;
        this.Y2 = builder.f30959f.h();
        this.Z2 = builder.f30960g;
        this.a3 = builder.f30961h;
        this.b3 = builder.f30962i;
        this.c3 = builder.f30963j;
        this.d3 = builder.f30964k;
        this.e3 = builder.f30965l;
    }

    public Request A() {
        return this.s;
    }

    public long C() {
        return this.d3;
    }

    @Nullable
    public ResponseBody b() {
        return this.Z2;
    }

    public CacheControl c() {
        CacheControl cacheControl = this.f3;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl m2 = CacheControl.m(this.Y2);
        this.f3 = m2;
        return m2;
    }

    public void close() {
        ResponseBody responseBody = this.Z2;
        if (responseBody != null) {
            responseBody.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    @Nullable
    public Response d() {
        return this.b3;
    }

    public List<Challenge> e() {
        String str;
        int i2 = this.Y;
        if (i2 == 401) {
            str = "WWW-Authenticate";
        } else if (i2 != 407) {
            return Collections.emptyList();
        } else {
            str = "Proxy-Authenticate";
        }
        return HttpHeaders.g(p(), str);
    }

    public int f() {
        return this.Y;
    }

    @Nullable
    public Handshake h() {
        return this.X2;
    }

    @Nullable
    public String i(String str) {
        return k(str, (String) null);
    }

    @Nullable
    public String k(String str, @Nullable String str2) {
        String d2 = this.Y2.d(str);
        return d2 != null ? d2 : str2;
    }

    public List<String> n(String str) {
        return this.Y2.o(str);
    }

    public Headers p() {
        return this.Y2;
    }

    public boolean q() {
        int i2 = this.Y;
        if (i2 == 307 || i2 == 308) {
            return true;
        }
        switch (i2) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    public boolean r() {
        int i2 = this.Y;
        return i2 >= 200 && i2 < 300;
    }

    public String s() {
        return this.Z;
    }

    @Nullable
    public Response t() {
        return this.a3;
    }

    public String toString() {
        return "Response{protocol=" + this.X + ", code=" + this.Y + ", message=" + this.Z + ", url=" + this.s.k() + ASCIIPropertyListParser.f18653k;
    }

    public Builder u() {
        return new Builder(this);
    }

    public ResponseBody v(long j2) throws IOException {
        BufferedSource q = this.Z2.q();
        q.request(j2);
        Buffer e2 = q.g().clone();
        if (e2.L0() > j2) {
            Buffer buffer = new Buffer();
            buffer.u1(e2, j2);
            e2.d();
            e2 = buffer;
        }
        return ResponseBody.i(this.Z2.h(), e2.L0(), e2);
    }

    @Nullable
    public Response w() {
        return this.c3;
    }

    public Protocol x() {
        return this.X;
    }

    public long y() {
        return this.e3;
    }
}
