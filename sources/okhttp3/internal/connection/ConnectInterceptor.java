package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;

public final class ConnectInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public final OkHttpClient f31026a;

    public ConnectInterceptor(OkHttpClient okHttpClient) {
        this.f31026a = okHttpClient;
    }

    public Response a(Interceptor.Chain chain) throws IOException {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request k2 = realInterceptorChain.k();
        StreamAllocation m2 = realInterceptorChain.m();
        return realInterceptorChain.l(k2, m2, m2.i(this.f31026a, chain, !k2.g().equals("GET")), m2.d());
    }
}
