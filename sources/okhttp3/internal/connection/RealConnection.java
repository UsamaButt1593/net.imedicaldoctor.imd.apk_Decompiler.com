package okhttp3.internal.connection;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http1.Http1Codec;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Codec;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import org.apache.commons.httpclient.ConnectMethod;
import org.apache.commons.httpclient.HttpStatus;

public final class RealConnection extends Http2Connection.Listener implements Connection {
    private static final String p = "throw with null exception";
    private static final int q = 21;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectionPool f31031b;

    /* renamed from: c  reason: collision with root package name */
    private final Route f31032c;

    /* renamed from: d  reason: collision with root package name */
    private Socket f31033d;

    /* renamed from: e  reason: collision with root package name */
    private Socket f31034e;

    /* renamed from: f  reason: collision with root package name */
    private Handshake f31035f;

    /* renamed from: g  reason: collision with root package name */
    private Protocol f31036g;

    /* renamed from: h  reason: collision with root package name */
    private Http2Connection f31037h;

    /* renamed from: i  reason: collision with root package name */
    private BufferedSource f31038i;

    /* renamed from: j  reason: collision with root package name */
    private BufferedSink f31039j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f31040k;

    /* renamed from: l  reason: collision with root package name */
    public int f31041l;

    /* renamed from: m  reason: collision with root package name */
    public int f31042m = 1;

    /* renamed from: n  reason: collision with root package name */
    public final List<Reference<StreamAllocation>> f31043n = new ArrayList();
    public long o = Long.MAX_VALUE;

    public RealConnection(ConnectionPool connectionPool, Route route) {
        this.f31031b = connectionPool;
        this.f31032c = route;
    }

    private void i(int i2, int i3, Call call, EventListener eventListener) throws IOException {
        Proxy b2 = this.f31032c.b();
        this.f31033d = (b2.type() == Proxy.Type.DIRECT || b2.type() == Proxy.Type.HTTP) ? this.f31032c.a().j().createSocket() : new Socket(b2);
        eventListener.f(call, this.f31032c.d(), b2);
        this.f31033d.setSoTimeout(i3);
        try {
            Platform.k().i(this.f31033d, this.f31032c.d(), i2);
            try {
                this.f31038i = Okio.e(Okio.v(this.f31033d));
                this.f31039j = Okio.d(Okio.q(this.f31033d));
            } catch (NullPointerException e2) {
                if (p.equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f31032c.d());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0110 A[Catch:{ all -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0116 A[Catch:{ all -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0119  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void j(okhttp3.internal.connection.ConnectionSpecSelector r8) throws java.io.IOException {
        /*
            r7 = this;
            okhttp3.Route r0 = r7.f31032c
            okhttp3.Address r0 = r0.a()
            javax.net.ssl.SSLSocketFactory r1 = r0.k()
            r2 = 0
            java.net.Socket r3 = r7.f31033d     // Catch:{ AssertionError -> 0x0109 }
            okhttp3.HttpUrl r4 = r0.l()     // Catch:{ AssertionError -> 0x0109 }
            java.lang.String r4 = r4.p()     // Catch:{ AssertionError -> 0x0109 }
            okhttp3.HttpUrl r5 = r0.l()     // Catch:{ AssertionError -> 0x0109 }
            int r5 = r5.E()     // Catch:{ AssertionError -> 0x0109 }
            r6 = 1
            java.net.Socket r1 = r1.createSocket(r3, r4, r5, r6)     // Catch:{ AssertionError -> 0x0109 }
            javax.net.ssl.SSLSocket r1 = (javax.net.ssl.SSLSocket) r1     // Catch:{ AssertionError -> 0x0109 }
            okhttp3.ConnectionSpec r8 = r8.a(r1)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            boolean r3 = r8.f()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            if (r3 == 0) goto L_0x004a
            okhttp3.internal.platform.Platform r3 = okhttp3.internal.platform.Platform.k()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            okhttp3.HttpUrl r4 = r0.l()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r4 = r4.p()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.util.List r5 = r0.f()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r3.h(r1, r4, r5)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            goto L_0x004a
        L_0x0042:
            r8 = move-exception
            r2 = r1
            goto L_0x0117
        L_0x0046:
            r8 = move-exception
            r2 = r1
            goto L_0x010a
        L_0x004a:
            r1.startHandshake()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            javax.net.ssl.SSLSession r3 = r1.getSession()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            okhttp3.Handshake r4 = okhttp3.Handshake.b(r3)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            javax.net.ssl.HostnameVerifier r5 = r0.e()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            okhttp3.HttpUrl r6 = r0.l()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r6 = r6.p()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            boolean r3 = r5.verify(r6, r3)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            if (r3 == 0) goto L_0x00b5
            okhttp3.CertificatePinner r3 = r0.a()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            okhttp3.HttpUrl r0 = r0.l()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = r0.p()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.util.List r5 = r4.f()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r3.a(r0, r5)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            boolean r8 = r8.f()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            if (r8 == 0) goto L_0x0088
            okhttp3.internal.platform.Platform r8 = okhttp3.internal.platform.Platform.k()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r2 = r8.n(r1)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
        L_0x0088:
            r7.f31034e = r1     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            okio.Source r8 = okio.Okio.v(r1)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            okio.BufferedSource r8 = okio.Okio.e(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r7.f31038i = r8     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.net.Socket r8 = r7.f31034e     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            okio.Sink r8 = okio.Okio.q(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            okio.BufferedSink r8 = okio.Okio.d(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r7.f31039j = r8     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r7.f31035f = r4     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            if (r2 == 0) goto L_0x00a9
            okhttp3.Protocol r8 = okhttp3.Protocol.a(r2)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            goto L_0x00ab
        L_0x00a9:
            okhttp3.Protocol r8 = okhttp3.Protocol.HTTP_1_1     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
        L_0x00ab:
            r7.f31036g = r8     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            okhttp3.internal.platform.Platform r8 = okhttp3.internal.platform.Platform.k()
            r8.a(r1)
            return
        L_0x00b5:
            java.util.List r8 = r4.f()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r2 = 0
            java.lang.Object r8 = r8.get(r2)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            javax.net.ssl.SSLPeerUnverifiedException r2 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r3.<init>()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r4 = "Hostname "
            r3.append(r4)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            okhttp3.HttpUrl r0 = r0.l()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = r0.p()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = " not verified:\n    certificate: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = okhttp3.CertificatePinner.d(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = "\n    DN: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.security.Principal r0 = r8.getSubjectDN()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = r0.getName()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r0 = "\n    subjectAltNames: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.util.List r8 = okhttp3.internal.tls.OkHostnameVerifier.a(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r3.append(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            java.lang.String r8 = r3.toString()     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            r2.<init>(r8)     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
            throw r2     // Catch:{ AssertionError -> 0x0046, all -> 0x0042 }
        L_0x0107:
            r8 = move-exception
            goto L_0x0117
        L_0x0109:
            r8 = move-exception
        L_0x010a:
            boolean r0 = okhttp3.internal.Util.B(r8)     // Catch:{ all -> 0x0107 }
            if (r0 == 0) goto L_0x0116
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0107 }
            r0.<init>(r8)     // Catch:{ all -> 0x0107 }
            throw r0     // Catch:{ all -> 0x0107 }
        L_0x0116:
            throw r8     // Catch:{ all -> 0x0107 }
        L_0x0117:
            if (r2 == 0) goto L_0x0120
            okhttp3.internal.platform.Platform r0 = okhttp3.internal.platform.Platform.k()
            r0.a(r2)
        L_0x0120:
            okhttp3.internal.Util.i(r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.j(okhttp3.internal.connection.ConnectionSpecSelector):void");
    }

    private void k(int i2, int i3, int i4, Call call, EventListener eventListener) throws IOException {
        Request m2 = m();
        HttpUrl k2 = m2.k();
        int i5 = 0;
        while (i5 < 21) {
            i(i2, i3, call, eventListener);
            m2 = l(i3, i4, m2, k2);
            if (m2 != null) {
                Util.i(this.f31033d);
                this.f31033d = null;
                this.f31039j = null;
                this.f31038i = null;
                eventListener.d(call, this.f31032c.d(), this.f31032c.b(), (Protocol) null);
                i5++;
            } else {
                return;
            }
        }
    }

    private Request l(int i2, int i3, Request request, HttpUrl httpUrl) throws IOException {
        String str = "CONNECT " + Util.t(httpUrl, true) + " HTTP/1.1";
        while (true) {
            Http1Codec http1Codec = new Http1Codec((OkHttpClient) null, (StreamAllocation) null, this.f31038i, this.f31039j);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f31038i.j().i((long) i2, timeUnit);
            this.f31039j.j().i((long) i3, timeUnit);
            http1Codec.p(request.e(), str);
            http1Codec.a();
            Response c2 = http1Codec.d(false).q(request).c();
            long b2 = HttpHeaders.b(c2);
            if (b2 == -1) {
                b2 = 0;
            }
            Source l2 = http1Codec.l(b2);
            Util.E(l2, Integer.MAX_VALUE, timeUnit);
            l2.close();
            int f2 = c2.f();
            if (f2 != 200) {
                if (f2 == 407) {
                    Request a2 = this.f31032c.a().h().a(this.f31032c, c2);
                    if (a2 == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if ("close".equalsIgnoreCase(c2.i(com.google.common.net.HttpHeaders.o))) {
                        return a2;
                    } else {
                        request = a2;
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + c2.f());
                }
            } else if (this.f31038i.g().o0() && this.f31039j.g().o0()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    private Request m() throws IOException {
        Request b2 = new Request.Builder().s(this.f31032c.a().l()).j(ConnectMethod.NAME, (RequestBody) null).h(com.google.common.net.HttpHeaders.w, Util.t(this.f31032c.a().l(), true)).h("Proxy-Connection", com.google.common.net.HttpHeaders.u0).h(com.google.common.net.HttpHeaders.P, Version.a()).b();
        Request a2 = this.f31032c.a().h().a(this.f31032c, new Response.Builder().q(b2).n(Protocol.HTTP_1_1).g(HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED).k("Preemptive Authenticate").b(Util.f30972c).r(-1).o(-1).i("Proxy-Authenticate", "OkHttp-Preemptive").c());
        return a2 != null ? a2 : b2;
    }

    private void n(ConnectionSpecSelector connectionSpecSelector, int i2, Call call, EventListener eventListener) throws IOException {
        if (this.f31032c.a().k() == null) {
            List<Protocol> f2 = this.f31032c.a().f();
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (f2.contains(protocol)) {
                this.f31034e = this.f31033d;
                this.f31036g = protocol;
                t(i2);
                return;
            }
            this.f31034e = this.f31033d;
            this.f31036g = Protocol.HTTP_1_1;
            return;
        }
        eventListener.u(call);
        j(connectionSpecSelector);
        eventListener.t(call, this.f31035f);
        if (this.f31036g == Protocol.HTTP_2) {
            t(i2);
        }
    }

    private void t(int i2) throws IOException {
        this.f31034e.setSoTimeout(0);
        Http2Connection a2 = new Http2Connection.Builder(true).f(this.f31034e, this.f31032c.a().l().p(), this.f31038i, this.f31039j).b(this).c(i2).a();
        this.f31037h = a2;
        a2.I();
    }

    public static RealConnection v(ConnectionPool connectionPool, Route route, Socket socket, long j2) {
        RealConnection realConnection = new RealConnection(connectionPool, route);
        realConnection.f31034e = socket;
        realConnection.o = j2;
        return realConnection;
    }

    public Protocol a() {
        return this.f31036g;
    }

    public Route b() {
        return this.f31032c;
    }

    public Handshake c() {
        return this.f31035f;
    }

    public Socket d() {
        return this.f31034e;
    }

    public void e(Http2Connection http2Connection) {
        synchronized (this.f31031b) {
            this.f31042m = http2Connection.q();
        }
    }

    public void f(Http2Stream http2Stream) throws IOException {
        http2Stream.f(ErrorCode.REFUSED_STREAM);
    }

    public void g() {
        Util.i(this.f31033d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090 A[Catch:{ IOException -> 0x00ab }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h(int r17, int r18, int r19, int r20, boolean r21, okhttp3.Call r22, okhttp3.EventListener r23) {
        /*
            r16 = this;
            r7 = r16
            r8 = r22
            r9 = r23
            okhttp3.Protocol r0 = r7.f31036g
            if (r0 != 0) goto L_0x0152
            okhttp3.Route r0 = r7.f31032c
            okhttp3.Address r0 = r0.a()
            java.util.List r0 = r0.b()
            okhttp3.internal.connection.ConnectionSpecSelector r10 = new okhttp3.internal.connection.ConnectionSpecSelector
            r10.<init>(r0)
            okhttp3.Route r1 = r7.f31032c
            okhttp3.Address r1 = r1.a()
            javax.net.ssl.SSLSocketFactory r1 = r1.k()
            if (r1 != 0) goto L_0x0074
            okhttp3.ConnectionSpec r1 = okhttp3.ConnectionSpec.f30816j
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0067
            okhttp3.Route r0 = r7.f31032c
            okhttp3.Address r0 = r0.a()
            okhttp3.HttpUrl r0 = r0.l()
            java.lang.String r0 = r0.p()
            okhttp3.internal.platform.Platform r1 = okhttp3.internal.platform.Platform.k()
            boolean r1 = r1.p(r0)
            if (r1 == 0) goto L_0x0046
            goto L_0x0086
        L_0x0046:
            okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r2 = new java.net.UnknownServiceException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "CLEARTEXT communication to "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = " not permitted by network security policy"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            r1.<init>(r2)
            throw r1
        L_0x0067:
            okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "CLEARTEXT communication not enabled for client"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0074:
            okhttp3.Route r0 = r7.f31032c
            okhttp3.Address r0 = r0.a()
            java.util.List r0 = r0.f()
            okhttp3.Protocol r1 = okhttp3.Protocol.H2_PRIOR_KNOWLEDGE
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x0145
        L_0x0086:
            r11 = 0
            r12 = r11
        L_0x0088:
            okhttp3.Route r0 = r7.f31032c     // Catch:{ IOException -> 0x00ab }
            boolean r0 = r0.c()     // Catch:{ IOException -> 0x00ab }
            if (r0 == 0) goto L_0x00b3
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r22
            r6 = r23
            r1.k(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x00ab }
            java.net.Socket r0 = r7.f31033d     // Catch:{ IOException -> 0x00ab }
            if (r0 != 0) goto L_0x00a4
            goto L_0x00cf
        L_0x00a4:
            r13 = r17
            r14 = r18
        L_0x00a8:
            r15 = r20
            goto L_0x00bb
        L_0x00ab:
            r0 = move-exception
            r13 = r17
            r14 = r18
        L_0x00b0:
            r15 = r20
            goto L_0x0102
        L_0x00b3:
            r13 = r17
            r14 = r18
            r7.i(r13, r14, r8, r9)     // Catch:{ IOException -> 0x0100 }
            goto L_0x00a8
        L_0x00bb:
            r7.n(r10, r15, r8, r9)     // Catch:{ IOException -> 0x00fe }
            okhttp3.Route r0 = r7.f31032c     // Catch:{ IOException -> 0x00fe }
            java.net.InetSocketAddress r0 = r0.d()     // Catch:{ IOException -> 0x00fe }
            okhttp3.Route r1 = r7.f31032c     // Catch:{ IOException -> 0x00fe }
            java.net.Proxy r1 = r1.b()     // Catch:{ IOException -> 0x00fe }
            okhttp3.Protocol r2 = r7.f31036g     // Catch:{ IOException -> 0x00fe }
            r9.d(r8, r0, r1, r2)     // Catch:{ IOException -> 0x00fe }
        L_0x00cf:
            okhttp3.Route r0 = r7.f31032c
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x00e9
            java.net.Socket r0 = r7.f31033d
            if (r0 == 0) goto L_0x00dc
            goto L_0x00e9
        L_0x00dc:
            java.net.ProtocolException r0 = new java.net.ProtocolException
            java.lang.String r1 = "Too many tunnel connections attempted: 21"
            r0.<init>(r1)
            okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
            r1.<init>(r0)
            throw r1
        L_0x00e9:
            okhttp3.internal.http2.Http2Connection r0 = r7.f31037h
            if (r0 == 0) goto L_0x00fd
            okhttp3.ConnectionPool r1 = r7.f31031b
            monitor-enter(r1)
            okhttp3.internal.http2.Http2Connection r0 = r7.f31037h     // Catch:{ all -> 0x00fa }
            int r0 = r0.q()     // Catch:{ all -> 0x00fa }
            r7.f31042m = r0     // Catch:{ all -> 0x00fa }
            monitor-exit(r1)     // Catch:{ all -> 0x00fa }
            goto L_0x00fd
        L_0x00fa:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00fa }
            throw r0
        L_0x00fd:
            return
        L_0x00fe:
            r0 = move-exception
            goto L_0x0102
        L_0x0100:
            r0 = move-exception
            goto L_0x00b0
        L_0x0102:
            java.net.Socket r1 = r7.f31034e
            okhttp3.internal.Util.i(r1)
            java.net.Socket r1 = r7.f31033d
            okhttp3.internal.Util.i(r1)
            r7.f31034e = r11
            r7.f31033d = r11
            r7.f31038i = r11
            r7.f31039j = r11
            r7.f31035f = r11
            r7.f31036g = r11
            r7.f31037h = r11
            okhttp3.Route r1 = r7.f31032c
            java.net.InetSocketAddress r3 = r1.d()
            okhttp3.Route r1 = r7.f31032c
            java.net.Proxy r4 = r1.b()
            r5 = 0
            r1 = r23
            r2 = r22
            r6 = r0
            r1.e(r2, r3, r4, r5, r6)
            if (r12 != 0) goto L_0x0137
            okhttp3.internal.connection.RouteException r12 = new okhttp3.internal.connection.RouteException
            r12.<init>(r0)
            goto L_0x013a
        L_0x0137:
            r12.a(r0)
        L_0x013a:
            if (r21 == 0) goto L_0x0144
            boolean r0 = r10.b(r0)
            if (r0 == 0) goto L_0x0144
            goto L_0x0088
        L_0x0144:
            throw r12
        L_0x0145:
            okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0152:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "already connected"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.h(int, int, int, int, boolean, okhttp3.Call, okhttp3.EventListener):void");
    }

    public boolean o(Address address, @Nullable Route route) {
        Proxy.Type type;
        if (this.f31043n.size() >= this.f31042m || this.f31040k || !Internal.f30969a.g(this.f31032c.a(), address)) {
            return false;
        }
        if (address.l().p().equals(b().a().l().p())) {
            return true;
        }
        if (this.f31037h == null || route == null || route.b().type() != (type = Proxy.Type.DIRECT) || this.f31032c.b().type() != type || !this.f31032c.d().equals(route.d()) || route.a().e() != OkHostnameVerifier.f31276a || !u(address.l())) {
            return false;
        }
        try {
            address.a().a(address.l().p(), c().f());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean p(boolean z) {
        int soTimeout;
        if (this.f31034e.isClosed() || this.f31034e.isInputShutdown() || this.f31034e.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.f31037h;
        if (http2Connection != null) {
            return !http2Connection.p();
        }
        if (z) {
            try {
                soTimeout = this.f31034e.getSoTimeout();
                this.f31034e.setSoTimeout(1);
                if (this.f31038i.o0()) {
                    this.f31034e.setSoTimeout(soTimeout);
                    return false;
                }
                this.f31034e.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.f31034e.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    public boolean q() {
        return this.f31037h != null;
    }

    public HttpCodec r(OkHttpClient okHttpClient, Interceptor.Chain chain, StreamAllocation streamAllocation) throws SocketException {
        if (this.f31037h != null) {
            return new Http2Codec(okHttpClient, chain, streamAllocation, this.f31037h);
        }
        this.f31034e.setSoTimeout(chain.b());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f31038i.j().i((long) chain.b(), timeUnit);
        this.f31039j.j().i((long) chain.c(), timeUnit);
        return new Http1Codec(okHttpClient, streamAllocation, this.f31038i, this.f31039j);
    }

    public RealWebSocket.Streams s(StreamAllocation streamAllocation) {
        final StreamAllocation streamAllocation2 = streamAllocation;
        return new RealWebSocket.Streams(true, this.f31038i, this.f31039j) {
            public void close() throws IOException {
                StreamAllocation streamAllocation = streamAllocation2;
                streamAllocation.r(true, streamAllocation.c(), -1, (IOException) null);
            }
        };
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f31032c.a().l().p());
        sb.append(":");
        sb.append(this.f31032c.a().l().E());
        sb.append(", proxy=");
        sb.append(this.f31032c.b());
        sb.append(" hostAddress=");
        sb.append(this.f31032c.d());
        sb.append(" cipherSuite=");
        Handshake handshake = this.f31035f;
        sb.append(handshake != null ? handshake.a() : "none");
        sb.append(" protocol=");
        sb.append(this.f31036g);
        sb.append(ASCIIPropertyListParser.f18653k);
        return sb.toString();
    }

    public boolean u(HttpUrl httpUrl) {
        if (httpUrl.E() != this.f31032c.a().l().E()) {
            return false;
        }
        if (!httpUrl.p().equals(this.f31032c.a().l().p())) {
            return this.f31035f != null && OkHostnameVerifier.f31276a.c(httpUrl.p(), (X509Certificate) this.f31035f.f().get(0));
        }
        return true;
    }
}
