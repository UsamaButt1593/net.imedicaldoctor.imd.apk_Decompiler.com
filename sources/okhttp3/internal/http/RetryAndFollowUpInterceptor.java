package okhttp3.internal.http;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http2.ConnectionShutdownException;

public final class RetryAndFollowUpInterceptor implements Interceptor {

    /* renamed from: f  reason: collision with root package name */
    private static final int f31091f = 20;

    /* renamed from: a  reason: collision with root package name */
    private final OkHttpClient f31092a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f31093b;

    /* renamed from: c  reason: collision with root package name */
    private volatile StreamAllocation f31094c;

    /* renamed from: d  reason: collision with root package name */
    private Object f31095d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f31096e;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient, boolean z) {
        this.f31092a = okHttpClient;
        this.f31093b = z;
    }

    private Address c(HttpUrl httpUrl) {
        CertificatePinner certificatePinner;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (httpUrl.q()) {
            sSLSocketFactory = this.f31092a.G();
            hostnameVerifier = this.f31092a.r();
            certificatePinner = this.f31092a.f();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.p(), httpUrl.E(), this.f31092a.n(), this.f31092a.F(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.f31092a.A(), this.f31092a.z(), this.f31092a.y(), this.f31092a.i(), this.f31092a.B());
    }

    private Request d(Response response, Route route) throws IOException {
        String i2;
        HttpUrl O;
        if (response != null) {
            int f2 = response.f();
            String g2 = response.A().g();
            RequestBody requestBody = null;
            if (f2 == 307 || f2 == 308) {
                if (!g2.equals("GET") && !g2.equals("HEAD")) {
                    return null;
                }
            } else if (f2 == 401) {
                return this.f31092a.c().a(route, response);
            } else {
                if (f2 != 503) {
                    if (f2 == 407) {
                        if ((route != null ? route.b() : this.f31092a.z()).type() == Proxy.Type.HTTP) {
                            return this.f31092a.A().a(route, response);
                        }
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    } else if (f2 != 408) {
                        switch (f2) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                return null;
                        }
                    } else if (!this.f31092a.E() || (response.A().a() instanceof UnrepeatableRequestBody)) {
                        return null;
                    } else {
                        if ((response.w() == null || response.w().f() != 408) && h(response, 0) <= 0) {
                            return response.A();
                        }
                        return null;
                    }
                } else if ((response.w() == null || response.w().f() != 503) && h(response, Integer.MAX_VALUE) == 0) {
                    return response.A();
                } else {
                    return null;
                }
            }
            if (!this.f31092a.p() || (i2 = response.i(HttpHeaders.t0)) == null || (O = response.A().k().O(i2)) == null) {
                return null;
            }
            if (!O.P().equals(response.A().k().P()) && !this.f31092a.q()) {
                return null;
            }
            Request.Builder h2 = response.A().h();
            if (HttpMethod.b(g2)) {
                boolean d2 = HttpMethod.d(g2);
                if (HttpMethod.c(g2)) {
                    h2.j("GET", (RequestBody) null);
                } else {
                    if (d2) {
                        requestBody = response.A().a();
                    }
                    h2.j(g2, requestBody);
                }
                if (!d2) {
                    h2.n(HttpHeaders.M0);
                    h2.n(HttpHeaders.f22874b);
                    h2.n(HttpHeaders.f22875c);
                }
            }
            if (!i(response, O)) {
                h2.n("Authorization");
            }
            return h2.s(O).b();
        }
        throw new IllegalStateException();
    }

    private boolean f(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException);
    }

    private boolean g(IOException iOException, StreamAllocation streamAllocation, boolean z, Request request) {
        streamAllocation.q(iOException);
        if (!this.f31092a.E()) {
            return false;
        }
        return (!z || !(request.a() instanceof UnrepeatableRequestBody)) && f(iOException, z) && streamAllocation.h();
    }

    private int h(Response response, int i2) {
        String i3 = response.i(HttpHeaders.B0);
        if (i3 == null) {
            return i2;
        }
        if (i3.matches("\\d+")) {
            return Integer.valueOf(i3).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private boolean i(Response response, HttpUrl httpUrl) {
        HttpUrl k2 = response.A().k();
        return k2.p().equals(httpUrl.p()) && k2.E() == httpUrl.E() && k2.P().equals(httpUrl.P());
    }

    public Response a(Interceptor.Chain chain) throws IOException {
        Request k2 = chain.k();
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Call call = realInterceptorChain.call();
        EventListener i2 = realInterceptorChain.i();
        StreamAllocation streamAllocation = new StreamAllocation(this.f31092a.h(), c(k2.k()), call, i2, this.f31095d);
        this.f31094c = streamAllocation;
        Response response = null;
        int i3 = 0;
        while (!this.f31096e) {
            try {
                Response l2 = realInterceptorChain.l(k2, streamAllocation, (HttpCodec) null, (RealConnection) null);
                if (response != null) {
                    l2 = l2.u().m(response.u().b((ResponseBody) null).c()).c();
                }
                try {
                    Request d2 = d(l2, streamAllocation.o());
                    if (d2 == null) {
                        streamAllocation.k();
                        return l2;
                    }
                    Util.g(l2.b());
                    int i4 = i3 + 1;
                    if (i4 > 20) {
                        streamAllocation.k();
                        throw new ProtocolException("Too many follow-up requests: " + i4);
                    } else if (!(d2.a() instanceof UnrepeatableRequestBody)) {
                        if (!i(l2, d2.k())) {
                            streamAllocation.k();
                            streamAllocation = new StreamAllocation(this.f31092a.h(), c(d2.k()), call, i2, this.f31095d);
                            this.f31094c = streamAllocation;
                        } else if (streamAllocation.c() != null) {
                            throw new IllegalStateException("Closing the body of " + l2 + " didn't close its backing stream. Bad interceptor?");
                        }
                        response = l2;
                        k2 = d2;
                        i3 = i4;
                    } else {
                        streamAllocation.k();
                        throw new HttpRetryException("Cannot retry streamed HTTP body", l2.f());
                    }
                } catch (IOException e2) {
                    streamAllocation.k();
                    throw e2;
                }
            } catch (RouteException e3) {
                if (!g(e3.c(), streamAllocation, false, k2)) {
                    throw e3.b();
                }
            } catch (IOException e4) {
                if (!g(e4, streamAllocation, !(e4 instanceof ConnectionShutdownException), k2)) {
                    throw e4;
                }
            } catch (Throwable th) {
                streamAllocation.q((IOException) null);
                streamAllocation.k();
                throw th;
            }
        }
        streamAllocation.k();
        throw new IOException("Canceled");
    }

    public void b() {
        this.f31096e = true;
        StreamAllocation streamAllocation = this.f31094c;
        if (streamAllocation != null) {
            streamAllocation.b();
        }
    }

    public boolean e() {
        return this.f31096e;
    }

    public void j(Object obj) {
        this.f31095d = obj;
    }

    public StreamAllocation k() {
        return this.f31094c;
    }
}
