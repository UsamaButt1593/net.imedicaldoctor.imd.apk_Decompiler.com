package okhttp3.internal.http;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

public final class CallServerInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f31071a;

    static final class CountingSink extends ForwardingSink {
        long X;

        CountingSink(Sink sink) {
            super(sink);
        }

        public void u1(Buffer buffer, long j2) throws IOException {
            super.u1(buffer, j2);
            this.X += j2;
        }
    }

    public CallServerInterceptor(boolean z) {
        this.f31071a = z;
    }

    public Response a(Interceptor.Chain chain) throws IOException {
        Response.Builder u;
        ResponseBody c2;
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        HttpCodec j2 = realInterceptorChain.j();
        StreamAllocation m2 = realInterceptorChain.m();
        RealConnection realConnection = (RealConnection) realInterceptorChain.f();
        Request k2 = realInterceptorChain.k();
        long currentTimeMillis = System.currentTimeMillis();
        realInterceptorChain.i().o(realInterceptorChain.call());
        j2.b(k2);
        realInterceptorChain.i().n(realInterceptorChain.call(), k2);
        Response.Builder builder = null;
        if (HttpMethod.b(k2.g()) && k2.a() != null) {
            if ("100-continue".equalsIgnoreCase(k2.c(HttpHeaders.s))) {
                j2.e();
                realInterceptorChain.i().s(realInterceptorChain.call());
                builder = j2.d(true);
            }
            if (builder == null) {
                realInterceptorChain.i().m(realInterceptorChain.call());
                CountingSink countingSink = new CountingSink(j2.f(k2, k2.a().a()));
                BufferedSink d2 = Okio.d(countingSink);
                k2.a().h(d2);
                d2.close();
                realInterceptorChain.i().l(realInterceptorChain.call(), countingSink.X);
            } else if (!realConnection.q()) {
                m2.j();
            }
        }
        j2.a();
        if (builder == null) {
            realInterceptorChain.i().s(realInterceptorChain.call());
            builder = j2.d(false);
        }
        Response c3 = builder.q(k2).h(m2.d().c()).r(currentTimeMillis).o(System.currentTimeMillis()).c();
        int f2 = c3.f();
        if (f2 == 100) {
            c3 = j2.d(false).q(k2).h(m2.d().c()).r(currentTimeMillis).o(System.currentTimeMillis()).c();
            f2 = c3.f();
        }
        realInterceptorChain.i().r(realInterceptorChain.call(), c3);
        if (!this.f31071a || f2 != 101) {
            u = c3.u();
            c2 = j2.c(c3);
        } else {
            u = c3.u();
            c2 = Util.f30972c;
        }
        Response c4 = u.b(c2).c();
        if ("close".equalsIgnoreCase(c4.A().c(HttpHeaders.o)) || "close".equalsIgnoreCase(c4.i(HttpHeaders.o))) {
            m2.j();
        }
        if ((f2 != 204 && f2 != 205) || c4.b().f() <= 0) {
            return c4;
        }
        throw new ProtocolException("HTTP " + f2 + " had non-zero Content-Length: " + c4.b().f());
    }
}
