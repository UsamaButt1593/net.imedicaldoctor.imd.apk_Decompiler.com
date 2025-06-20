package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;

public final class RealInterceptorChain implements Interceptor.Chain {

    /* renamed from: a  reason: collision with root package name */
    private final List<Interceptor> f31079a;

    /* renamed from: b  reason: collision with root package name */
    private final StreamAllocation f31080b;

    /* renamed from: c  reason: collision with root package name */
    private final HttpCodec f31081c;

    /* renamed from: d  reason: collision with root package name */
    private final RealConnection f31082d;

    /* renamed from: e  reason: collision with root package name */
    private final int f31083e;

    /* renamed from: f  reason: collision with root package name */
    private final Request f31084f;

    /* renamed from: g  reason: collision with root package name */
    private final Call f31085g;

    /* renamed from: h  reason: collision with root package name */
    private final EventListener f31086h;

    /* renamed from: i  reason: collision with root package name */
    private final int f31087i;

    /* renamed from: j  reason: collision with root package name */
    private final int f31088j;

    /* renamed from: k  reason: collision with root package name */
    private final int f31089k;

    /* renamed from: l  reason: collision with root package name */
    private int f31090l;

    public RealInterceptorChain(List<Interceptor> list, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection, int i2, Request request, Call call, EventListener eventListener, int i3, int i4, int i5) {
        this.f31079a = list;
        this.f31082d = realConnection;
        this.f31080b = streamAllocation;
        this.f31081c = httpCodec;
        this.f31083e = i2;
        this.f31084f = request;
        this.f31085g = call;
        this.f31086h = eventListener;
        this.f31087i = i3;
        this.f31088j = i4;
        this.f31089k = i5;
    }

    public Interceptor.Chain a(int i2, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.f31079a, this.f31080b, this.f31081c, this.f31082d, this.f31083e, this.f31084f, this.f31085g, this.f31086h, this.f31087i, this.f31088j, Util.e("timeout", (long) i2, timeUnit));
    }

    public int b() {
        return this.f31088j;
    }

    public int c() {
        return this.f31089k;
    }

    public Call call() {
        return this.f31085g;
    }

    public Interceptor.Chain d(int i2, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.f31079a, this.f31080b, this.f31081c, this.f31082d, this.f31083e, this.f31084f, this.f31085g, this.f31086h, Util.e("timeout", (long) i2, timeUnit), this.f31088j, this.f31089k);
    }

    public Response e(Request request) throws IOException {
        return l(request, this.f31080b, this.f31081c, this.f31082d);
    }

    public Connection f() {
        return this.f31082d;
    }

    public Interceptor.Chain g(int i2, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.f31079a, this.f31080b, this.f31081c, this.f31082d, this.f31083e, this.f31084f, this.f31085g, this.f31086h, this.f31087i, Util.e("timeout", (long) i2, timeUnit), this.f31089k);
    }

    public int h() {
        return this.f31087i;
    }

    public EventListener i() {
        return this.f31086h;
    }

    public HttpCodec j() {
        return this.f31081c;
    }

    public Request k() {
        return this.f31084f;
    }

    public Response l(Request request, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection) throws IOException {
        if (this.f31083e < this.f31079a.size()) {
            this.f31090l++;
            if (this.f31081c != null && !this.f31082d.u(request.k())) {
                throw new IllegalStateException("network interceptor " + this.f31079a.get(this.f31083e - 1) + " must retain the same host and port");
            } else if (this.f31081c == null || this.f31090l <= 1) {
                RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.f31079a, streamAllocation, httpCodec, realConnection, this.f31083e + 1, request, this.f31085g, this.f31086h, this.f31087i, this.f31088j, this.f31089k);
                Interceptor interceptor = this.f31079a.get(this.f31083e);
                Response a2 = interceptor.a(realInterceptorChain);
                if (httpCodec != null && this.f31083e + 1 < this.f31079a.size() && realInterceptorChain.f31090l != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                } else if (a2 == null) {
                    throw new NullPointerException("interceptor " + interceptor + " returned null");
                } else if (a2.b() != null) {
                    return a2;
                } else {
                    throw new IllegalStateException("interceptor " + interceptor + " returned a response with no body");
                }
            } else {
                throw new IllegalStateException("network interceptor " + this.f31079a.get(this.f31083e - 1) + " must call proceed() exactly once");
            }
        } else {
            throw new AssertionError();
        }
    }

    public StreamAllocation m() {
        return this.f31080b;
    }
}
