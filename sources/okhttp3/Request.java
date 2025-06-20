package okhttp3;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.net.HttpHeaders;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

public final class Request {

    /* renamed from: a  reason: collision with root package name */
    final HttpUrl f30935a;

    /* renamed from: b  reason: collision with root package name */
    final String f30936b;

    /* renamed from: c  reason: collision with root package name */
    final Headers f30937c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    final RequestBody f30938d;

    /* renamed from: e  reason: collision with root package name */
    final Map<Class<?>, Object> f30939e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private volatile CacheControl f30940f;

    public static class Builder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        HttpUrl f30941a;

        /* renamed from: b  reason: collision with root package name */
        String f30942b;

        /* renamed from: c  reason: collision with root package name */
        Headers.Builder f30943c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        RequestBody f30944d;

        /* renamed from: e  reason: collision with root package name */
        Map<Class<?>, Object> f30945e;

        public Builder() {
            this.f30945e = Collections.emptyMap();
            this.f30942b = "GET";
            this.f30943c = new Headers.Builder();
        }

        public Builder a(String str, String str2) {
            this.f30943c.b(str, str2);
            return this;
        }

        public Request b() {
            if (this.f30941a != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }

        public Builder c(CacheControl cacheControl) {
            String cacheControl2 = cacheControl.toString();
            return cacheControl2.isEmpty() ? n(HttpHeaders.f22873a) : h(HttpHeaders.f22873a, cacheControl2);
        }

        public Builder d() {
            return e(Util.f30973d);
        }

        public Builder e(@Nullable RequestBody requestBody) {
            return j("DELETE", requestBody);
        }

        public Builder f() {
            return j("GET", (RequestBody) null);
        }

        public Builder g() {
            return j("HEAD", (RequestBody) null);
        }

        public Builder h(String str, String str2) {
            this.f30943c.k(str, str2);
            return this;
        }

        public Builder i(Headers headers) {
            this.f30943c = headers.i();
            return this;
        }

        public Builder j(String str, @Nullable RequestBody requestBody) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (requestBody != null && !HttpMethod.b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (requestBody != null || !HttpMethod.e(str)) {
                this.f30942b = str;
                this.f30944d = requestBody;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        public Builder k(RequestBody requestBody) {
            return j("PATCH", requestBody);
        }

        public Builder l(RequestBody requestBody) {
            return j("POST", requestBody);
        }

        public Builder m(RequestBody requestBody) {
            return j("PUT", requestBody);
        }

        public Builder n(String str) {
            this.f30943c.j(str);
            return this;
        }

        public <T> Builder o(Class<? super T> cls, @Nullable T t) {
            if (cls != null) {
                if (t == null) {
                    this.f30945e.remove(cls);
                } else {
                    if (this.f30945e.isEmpty()) {
                        this.f30945e = new LinkedHashMap();
                    }
                    this.f30945e.put(cls, cls.cast(t));
                }
                return this;
            }
            throw new NullPointerException("type == null");
        }

        public Builder p(@Nullable Object obj) {
            return o(Object.class, obj);
        }

        public Builder q(String str) {
            StringBuilder sb;
            int i2;
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    sb = new StringBuilder();
                    sb.append("http:");
                    i2 = 3;
                } else {
                    if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                        sb = new StringBuilder();
                        sb.append("https:");
                        i2 = 4;
                    }
                    return s(HttpUrl.m(str));
                }
                sb.append(str.substring(i2));
                str = sb.toString();
                return s(HttpUrl.m(str));
            }
            throw new NullPointerException("url == null");
        }

        public Builder r(URL url) {
            if (url != null) {
                return s(HttpUrl.m(url.toString()));
            }
            throw new NullPointerException("url == null");
        }

        public Builder s(HttpUrl httpUrl) {
            if (httpUrl != null) {
                this.f30941a = httpUrl;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        Builder(Request request) {
            this.f30945e = Collections.emptyMap();
            this.f30941a = request.f30935a;
            this.f30942b = request.f30936b;
            this.f30944d = request.f30938d;
            this.f30945e = request.f30939e.isEmpty() ? Collections.emptyMap() : new LinkedHashMap<>(request.f30939e);
            this.f30943c = request.f30937c.i();
        }
    }

    Request(Builder builder) {
        this.f30935a = builder.f30941a;
        this.f30936b = builder.f30942b;
        this.f30937c = builder.f30943c.h();
        this.f30938d = builder.f30944d;
        this.f30939e = Util.w(builder.f30945e);
    }

    @Nullable
    public RequestBody a() {
        return this.f30938d;
    }

    public CacheControl b() {
        CacheControl cacheControl = this.f30940f;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl m2 = CacheControl.m(this.f30937c);
        this.f30940f = m2;
        return m2;
    }

    @Nullable
    public String c(String str) {
        return this.f30937c.d(str);
    }

    public List<String> d(String str) {
        return this.f30937c.o(str);
    }

    public Headers e() {
        return this.f30937c;
    }

    public boolean f() {
        return this.f30935a.q();
    }

    public String g() {
        return this.f30936b;
    }

    public Builder h() {
        return new Builder(this);
    }

    @Nullable
    public Object i() {
        return j(Object.class);
    }

    @Nullable
    public <T> T j(Class<? extends T> cls) {
        return cls.cast(this.f30939e.get(cls));
    }

    public HttpUrl k() {
        return this.f30935a;
    }

    public String toString() {
        return "Request{method=" + this.f30936b + ", url=" + this.f30935a + ", tags=" + this.f30939e + ASCIIPropertyListParser.f18653k;
    }
}
