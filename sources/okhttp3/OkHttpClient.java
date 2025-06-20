package okhttp3;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {
    static final List<Protocol> v3 = Util.v(Protocol.HTTP_2, Protocol.HTTP_1_1);
    static final List<ConnectionSpec> w3 = Util.v(ConnectionSpec.f30814h, ConnectionSpec.f30816j);
    @Nullable
    final Proxy X;
    final List<Interceptor> X2;
    final List<Protocol> Y;
    final List<Interceptor> Y2;
    final List<ConnectionSpec> Z;
    final EventListener.Factory Z2;
    final ProxySelector a3;
    final CookieJar b3;
    @Nullable
    final Cache c3;
    @Nullable
    final InternalCache d3;
    final SocketFactory e3;
    final SSLSocketFactory f3;
    final CertificateChainCleaner g3;
    final HostnameVerifier h3;
    final CertificatePinner i3;
    final Authenticator j3;
    final Authenticator k3;
    final ConnectionPool l3;
    final Dns m3;
    final boolean n3;
    final boolean o3;
    final boolean p3;
    final int q3;
    final int r3;
    final Dispatcher s;
    final int s3;
    final int t3;
    final int u3;

    public static final class Builder {
        int A;
        int B;

        /* renamed from: a  reason: collision with root package name */
        Dispatcher f30920a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        Proxy f30921b;

        /* renamed from: c  reason: collision with root package name */
        List<Protocol> f30922c;

        /* renamed from: d  reason: collision with root package name */
        List<ConnectionSpec> f30923d;

        /* renamed from: e  reason: collision with root package name */
        final List<Interceptor> f30924e;

        /* renamed from: f  reason: collision with root package name */
        final List<Interceptor> f30925f;

        /* renamed from: g  reason: collision with root package name */
        EventListener.Factory f30926g;

        /* renamed from: h  reason: collision with root package name */
        ProxySelector f30927h;

        /* renamed from: i  reason: collision with root package name */
        CookieJar f30928i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        Cache f30929j;
        @Nullable

        /* renamed from: k  reason: collision with root package name */
        InternalCache f30930k;

        /* renamed from: l  reason: collision with root package name */
        SocketFactory f30931l;
        @Nullable

        /* renamed from: m  reason: collision with root package name */
        SSLSocketFactory f30932m;
        @Nullable

        /* renamed from: n  reason: collision with root package name */
        CertificateChainCleaner f30933n;
        HostnameVerifier o;
        CertificatePinner p;
        Authenticator q;
        Authenticator r;
        ConnectionPool s;
        Dns t;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        public Builder() {
            this.f30924e = new ArrayList();
            this.f30925f = new ArrayList();
            this.f30920a = new Dispatcher();
            this.f30922c = OkHttpClient.v3;
            this.f30923d = OkHttpClient.w3;
            this.f30926g = EventListener.k(EventListener.f30857a);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f30927h = proxySelector;
            if (proxySelector == null) {
                this.f30927h = new NullProxySelector();
            }
            this.f30928i = CookieJar.f30847a;
            this.f30931l = SocketFactory.getDefault();
            this.o = OkHostnameVerifier.f31276a;
            this.p = CertificatePinner.f30778c;
            Authenticator authenticator = Authenticator.f30737a;
            this.q = authenticator;
            this.r = authenticator;
            this.s = new ConnectionPool();
            this.t = Dns.f30856a;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 0;
            this.y = 10000;
            this.z = 10000;
            this.A = 10000;
            this.B = 0;
        }

        public Builder A(Authenticator authenticator) {
            if (authenticator != null) {
                this.q = authenticator;
                return this;
            }
            throw new NullPointerException("proxyAuthenticator == null");
        }

        public Builder B(ProxySelector proxySelector) {
            if (proxySelector != null) {
                this.f30927h = proxySelector;
                return this;
            }
            throw new NullPointerException("proxySelector == null");
        }

        public Builder C(long j2, TimeUnit timeUnit) {
            this.z = Util.e("timeout", j2, timeUnit);
            return this;
        }

        @IgnoreJRERequirement
        public Builder D(Duration duration) {
            this.z = Util.e("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder E(boolean z2) {
            this.w = z2;
            return this;
        }

        /* access modifiers changed from: package-private */
        public void F(@Nullable InternalCache internalCache) {
            this.f30930k = internalCache;
            this.f30929j = null;
        }

        public Builder G(SocketFactory socketFactory) {
            if (socketFactory != null) {
                this.f30931l = socketFactory;
                return this;
            }
            throw new NullPointerException("socketFactory == null");
        }

        public Builder H(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory != null) {
                this.f30932m = sSLSocketFactory;
                this.f30933n = Platform.k().c(sSLSocketFactory);
                return this;
            }
            throw new NullPointerException("sslSocketFactory == null");
        }

        public Builder I(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            } else if (x509TrustManager != null) {
                this.f30932m = sSLSocketFactory;
                this.f30933n = CertificateChainCleaner.b(x509TrustManager);
                return this;
            } else {
                throw new NullPointerException("trustManager == null");
            }
        }

        public Builder J(long j2, TimeUnit timeUnit) {
            this.A = Util.e("timeout", j2, timeUnit);
            return this;
        }

        @IgnoreJRERequirement
        public Builder K(Duration duration) {
            this.A = Util.e("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder a(Interceptor interceptor) {
            if (interceptor != null) {
                this.f30924e.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public Builder b(Interceptor interceptor) {
            if (interceptor != null) {
                this.f30925f.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public Builder c(Authenticator authenticator) {
            if (authenticator != null) {
                this.r = authenticator;
                return this;
            }
            throw new NullPointerException("authenticator == null");
        }

        public OkHttpClient d() {
            return new OkHttpClient(this);
        }

        public Builder e(@Nullable Cache cache) {
            this.f30929j = cache;
            this.f30930k = null;
            return this;
        }

        public Builder f(long j2, TimeUnit timeUnit) {
            this.x = Util.e("timeout", j2, timeUnit);
            return this;
        }

        @IgnoreJRERequirement
        public Builder g(Duration duration) {
            this.x = Util.e("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder h(CertificatePinner certificatePinner) {
            if (certificatePinner != null) {
                this.p = certificatePinner;
                return this;
            }
            throw new NullPointerException("certificatePinner == null");
        }

        public Builder i(long j2, TimeUnit timeUnit) {
            this.y = Util.e("timeout", j2, timeUnit);
            return this;
        }

        @IgnoreJRERequirement
        public Builder j(Duration duration) {
            this.y = Util.e("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder k(ConnectionPool connectionPool) {
            if (connectionPool != null) {
                this.s = connectionPool;
                return this;
            }
            throw new NullPointerException("connectionPool == null");
        }

        public Builder l(List<ConnectionSpec> list) {
            this.f30923d = Util.u(list);
            return this;
        }

        public Builder m(CookieJar cookieJar) {
            if (cookieJar != null) {
                this.f30928i = cookieJar;
                return this;
            }
            throw new NullPointerException("cookieJar == null");
        }

        public Builder n(Dispatcher dispatcher) {
            if (dispatcher != null) {
                this.f30920a = dispatcher;
                return this;
            }
            throw new IllegalArgumentException("dispatcher == null");
        }

        public Builder o(Dns dns) {
            if (dns != null) {
                this.t = dns;
                return this;
            }
            throw new NullPointerException("dns == null");
        }

        public Builder p(EventListener eventListener) {
            if (eventListener != null) {
                this.f30926g = EventListener.k(eventListener);
                return this;
            }
            throw new NullPointerException("eventListener == null");
        }

        public Builder q(EventListener.Factory factory) {
            if (factory != null) {
                this.f30926g = factory;
                return this;
            }
            throw new NullPointerException("eventListenerFactory == null");
        }

        public Builder r(boolean z2) {
            this.v = z2;
            return this;
        }

        public Builder s(boolean z2) {
            this.u = z2;
            return this;
        }

        public Builder t(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier != null) {
                this.o = hostnameVerifier;
                return this;
            }
            throw new NullPointerException("hostnameVerifier == null");
        }

        public List<Interceptor> u() {
            return this.f30924e;
        }

        public List<Interceptor> v() {
            return this.f30925f;
        }

        public Builder w(long j2, TimeUnit timeUnit) {
            this.B = Util.e("interval", j2, timeUnit);
            return this;
        }

        @IgnoreJRERequirement
        public Builder x(Duration duration) {
            this.B = Util.e("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder y(List<Protocol> list) {
            ArrayList arrayList = new ArrayList(list);
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (!arrayList.contains(protocol) && !arrayList.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
            } else if (arrayList.contains(protocol) && arrayList.size() > 1) {
                throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
            } else if (arrayList.contains(Protocol.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            } else if (!arrayList.contains((Object) null)) {
                arrayList.remove(Protocol.SPDY_3);
                this.f30922c = Collections.unmodifiableList(arrayList);
                return this;
            } else {
                throw new IllegalArgumentException("protocols must not contain null");
            }
        }

        public Builder z(@Nullable Proxy proxy) {
            this.f30921b = proxy;
            return this;
        }

        Builder(OkHttpClient okHttpClient) {
            ArrayList arrayList = new ArrayList();
            this.f30924e = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f30925f = arrayList2;
            this.f30920a = okHttpClient.s;
            this.f30921b = okHttpClient.X;
            this.f30922c = okHttpClient.Y;
            this.f30923d = okHttpClient.Z;
            arrayList.addAll(okHttpClient.X2);
            arrayList2.addAll(okHttpClient.Y2);
            this.f30926g = okHttpClient.Z2;
            this.f30927h = okHttpClient.a3;
            this.f30928i = okHttpClient.b3;
            this.f30930k = okHttpClient.d3;
            this.f30929j = okHttpClient.c3;
            this.f30931l = okHttpClient.e3;
            this.f30932m = okHttpClient.f3;
            this.f30933n = okHttpClient.g3;
            this.o = okHttpClient.h3;
            this.p = okHttpClient.i3;
            this.q = okHttpClient.j3;
            this.r = okHttpClient.k3;
            this.s = okHttpClient.l3;
            this.t = okHttpClient.m3;
            this.u = okHttpClient.n3;
            this.v = okHttpClient.o3;
            this.w = okHttpClient.p3;
            this.x = okHttpClient.q3;
            this.y = okHttpClient.r3;
            this.z = okHttpClient.s3;
            this.A = okHttpClient.t3;
            this.B = okHttpClient.u3;
        }
    }

    static {
        Internal.f30969a = new Internal() {
            public void a(Headers.Builder builder, String str) {
                builder.e(str);
            }

            public void b(Headers.Builder builder, String str, String str2) {
                builder.f(str, str2);
            }

            public void c(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
                connectionSpec.a(sSLSocket, z);
            }

            public int d(Response.Builder builder) {
                return builder.f30956c;
            }

            public boolean e(ConnectionPool connectionPool, RealConnection realConnection) {
                return connectionPool.b(realConnection);
            }

            public Socket f(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                return connectionPool.d(address, streamAllocation);
            }

            public boolean g(Address address, Address address2) {
                return address.d(address2);
            }

            public RealConnection h(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
                return connectionPool.f(address, streamAllocation, route);
            }

            public boolean j(IllegalArgumentException illegalArgumentException) {
                return illegalArgumentException.getMessage().startsWith("Invalid URL host");
            }

            public Call k(OkHttpClient okHttpClient, Request request) {
                return RealCall.e(okHttpClient, request, true);
            }

            public void l(ConnectionPool connectionPool, RealConnection realConnection) {
                connectionPool.i(realConnection);
            }

            public RouteDatabase m(ConnectionPool connectionPool) {
                return connectionPool.f30809e;
            }

            public void n(Builder builder, InternalCache internalCache) {
                builder.F(internalCache);
            }

            public StreamAllocation o(Call call) {
                return ((RealCall) call).g();
            }

            @Nullable
            public IOException p(Call call, @Nullable IOException iOException) {
                return ((RealCall) call).h(iOException);
            }
        };
    }

    public OkHttpClient() {
        this(new Builder());
    }

    private static SSLSocketFactory w(X509TrustManager x509TrustManager) {
        try {
            SSLContext m2 = Platform.k().m();
            m2.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return m2.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw Util.b("No System TLS", e2);
        }
    }

    public Authenticator A() {
        return this.j3;
    }

    public ProxySelector B() {
        return this.a3;
    }

    public int D() {
        return this.s3;
    }

    public boolean E() {
        return this.p3;
    }

    public SocketFactory F() {
        return this.e3;
    }

    public SSLSocketFactory G() {
        return this.f3;
    }

    public int J() {
        return this.t3;
    }

    public Call a(Request request) {
        return RealCall.e(this, request, false);
    }

    public WebSocket b(Request request, WebSocketListener webSocketListener) {
        RealWebSocket realWebSocket = new RealWebSocket(request, webSocketListener, new Random(), (long) this.u3);
        realWebSocket.n(this);
        return realWebSocket;
    }

    public Authenticator c() {
        return this.k3;
    }

    @Nullable
    public Cache d() {
        return this.c3;
    }

    public int e() {
        return this.q3;
    }

    public CertificatePinner f() {
        return this.i3;
    }

    public int g() {
        return this.r3;
    }

    public ConnectionPool h() {
        return this.l3;
    }

    public List<ConnectionSpec> i() {
        return this.Z;
    }

    public CookieJar l() {
        return this.b3;
    }

    public Dispatcher m() {
        return this.s;
    }

    public Dns n() {
        return this.m3;
    }

    public EventListener.Factory o() {
        return this.Z2;
    }

    public boolean p() {
        return this.o3;
    }

    public boolean q() {
        return this.n3;
    }

    public HostnameVerifier r() {
        return this.h3;
    }

    public List<Interceptor> s() {
        return this.X2;
    }

    /* access modifiers changed from: package-private */
    public InternalCache t() {
        Cache cache = this.c3;
        return cache != null ? cache.s : this.d3;
    }

    public List<Interceptor> u() {
        return this.Y2;
    }

    public Builder v() {
        return new Builder(this);
    }

    public int x() {
        return this.u3;
    }

    public List<Protocol> y() {
        return this.Y;
    }

    @Nullable
    public Proxy z() {
        return this.X;
    }

    OkHttpClient(Builder builder) {
        boolean z;
        CertificateChainCleaner certificateChainCleaner;
        this.s = builder.f30920a;
        this.X = builder.f30921b;
        this.Y = builder.f30922c;
        List<ConnectionSpec> list = builder.f30923d;
        this.Z = list;
        this.X2 = Util.u(builder.f30924e);
        this.Y2 = Util.u(builder.f30925f);
        this.Z2 = builder.f30926g;
        this.a3 = builder.f30927h;
        this.b3 = builder.f30928i;
        this.c3 = builder.f30929j;
        this.d3 = builder.f30930k;
        this.e3 = builder.f30931l;
        Iterator<ConnectionSpec> it2 = list.iterator();
        loop0:
        while (true) {
            z = false;
            while (true) {
                if (!it2.hasNext()) {
                    break loop0;
                }
                ConnectionSpec next = it2.next();
                if (z || next.d()) {
                    z = true;
                }
            }
        }
        SSLSocketFactory sSLSocketFactory = builder.f30932m;
        if (sSLSocketFactory != null || !z) {
            this.f3 = sSLSocketFactory;
            certificateChainCleaner = builder.f30933n;
        } else {
            X509TrustManager D = Util.D();
            this.f3 = w(D);
            certificateChainCleaner = CertificateChainCleaner.b(D);
        }
        this.g3 = certificateChainCleaner;
        if (this.f3 != null) {
            Platform.k().g(this.f3);
        }
        this.h3 = builder.o;
        this.i3 = builder.p.g(this.g3);
        this.j3 = builder.q;
        this.k3 = builder.r;
        this.l3 = builder.s;
        this.m3 = builder.t;
        this.n3 = builder.u;
        this.o3 = builder.v;
        this.p3 = builder.w;
        this.q3 = builder.x;
        this.r3 = builder.y;
        this.s3 = builder.z;
        this.t3 = builder.A;
        this.u3 = builder.B;
        if (this.X2.contains((Object) null)) {
            throw new IllegalStateException("Null interceptor: " + this.X2);
        } else if (this.Y2.contains((Object) null)) {
            throw new IllegalStateException("Null network interceptor: " + this.Y2);
        }
    }
}
