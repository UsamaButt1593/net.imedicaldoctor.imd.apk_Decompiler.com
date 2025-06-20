package okhttp3.internal.platform;

import android.os.Build;
import android.util.Log;
import com.itextpdf.text.pdf.security.SecurityConstants;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

class AndroidPlatform extends Platform {

    /* renamed from: k  reason: collision with root package name */
    private static final int f31225k = 4000;

    /* renamed from: e  reason: collision with root package name */
    private final Class<?> f31226e;

    /* renamed from: f  reason: collision with root package name */
    private final OptionalMethod<Socket> f31227f;

    /* renamed from: g  reason: collision with root package name */
    private final OptionalMethod<Socket> f31228g;

    /* renamed from: h  reason: collision with root package name */
    private final OptionalMethod<Socket> f31229h;

    /* renamed from: i  reason: collision with root package name */
    private final OptionalMethod<Socket> f31230i;

    /* renamed from: j  reason: collision with root package name */
    private final CloseGuard f31231j = CloseGuard.b();

    static final class AndroidCertificateChainCleaner extends CertificateChainCleaner {

        /* renamed from: a  reason: collision with root package name */
        private final Object f31232a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f31233b;

        AndroidCertificateChainCleaner(Object obj, Method method) {
            this.f31232a = obj;
            this.f31233b = method;
        }

        public List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f31233b.invoke(this.f31232a, new Object[]{(X509Certificate[]) list.toArray(new X509Certificate[list.size()]), SecurityConstants.f27341n, str});
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof AndroidCertificateChainCleaner;
        }

        public int hashCode() {
            return 0;
        }
    }

    static final class AndroidTrustRootIndex implements TrustRootIndex {

        /* renamed from: a  reason: collision with root package name */
        private final X509TrustManager f31234a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f31235b;

        AndroidTrustRootIndex(X509TrustManager x509TrustManager, Method method) {
            this.f31235b = method;
            this.f31234a = x509TrustManager;
        }

        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f31235b.invoke(this.f31234a, new Object[]{x509Certificate});
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e2) {
                throw Util.b("unable to get issues and signature", e2);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AndroidTrustRootIndex)) {
                return false;
            }
            AndroidTrustRootIndex androidTrustRootIndex = (AndroidTrustRootIndex) obj;
            return this.f31234a.equals(androidTrustRootIndex.f31234a) && this.f31235b.equals(androidTrustRootIndex.f31235b);
        }

        public int hashCode() {
            return this.f31234a.hashCode() + (this.f31235b.hashCode() * 31);
        }
    }

    static final class CloseGuard {

        /* renamed from: a  reason: collision with root package name */
        private final Method f31236a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f31237b;

        /* renamed from: c  reason: collision with root package name */
        private final Method f31238c;

        CloseGuard(Method method, Method method2, Method method3) {
            this.f31236a = method;
            this.f31237b = method2;
            this.f31238c = method3;
        }

        static CloseGuard b() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", (Class[]) null);
                method = cls.getMethod(TtmlNode.B0, new Class[]{String.class});
                method2 = cls.getMethod("warnIfOpen", (Class[]) null);
                method3 = method4;
            } catch (Exception unused) {
                method2 = null;
                method = null;
            }
            return new CloseGuard(method3, method, method2);
        }

        /* access modifiers changed from: package-private */
        public Object a(String str) {
            Method method = this.f31236a;
            if (method != null) {
                try {
                    Object invoke = method.invoke((Object) null, (Object[]) null);
                    this.f31237b.invoke(invoke, new Object[]{str});
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public boolean c(Object obj) {
            if (obj != null) {
                try {
                    this.f31238c.invoke(obj, (Object[]) null);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    AndroidPlatform(Class<?> cls, OptionalMethod<Socket> optionalMethod, OptionalMethod<Socket> optionalMethod2, OptionalMethod<Socket> optionalMethod3, OptionalMethod<Socket> optionalMethod4) {
        this.f31226e = cls;
        this.f31227f = optionalMethod;
        this.f31228g = optionalMethod2;
        this.f31229h = optionalMethod3;
        this.f31230i = optionalMethod4;
    }

    private boolean v(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", (Class[]) null).invoke(obj, (Object[]) null)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.p(str);
        }
    }

    private boolean w(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(obj, new Object[]{str})).booleanValue();
        } catch (NoSuchMethodException unused) {
            return v(str, cls, obj);
        }
    }

    public static Platform x() {
        Class<?> cls;
        OptionalMethod optionalMethod;
        OptionalMethod optionalMethod2;
        Class<byte[]> cls2 = byte[].class;
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException unused) {
            try {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
        Class<?> cls3 = cls;
        OptionalMethod optionalMethod3 = new OptionalMethod((Class<?>) null, "setUseSessionTickets", Boolean.TYPE);
        OptionalMethod optionalMethod4 = new OptionalMethod((Class<?>) null, "setHostname", String.class);
        if (y()) {
            optionalMethod2 = new OptionalMethod(cls2, "getAlpnSelectedProtocol", new Class[0]);
            optionalMethod = new OptionalMethod((Class<?>) null, "setAlpnProtocols", cls2);
        } else {
            optionalMethod2 = null;
            optionalMethod = null;
        }
        return new AndroidPlatform(cls3, optionalMethod3, optionalMethod4, optionalMethod2, optionalMethod);
    }

    private static boolean y() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public CertificateChainCleaner d(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            Class<String> cls2 = String.class;
            return new AndroidCertificateChainCleaner(cls.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, cls2, cls2}));
        } catch (Exception unused) {
            return super.d(x509TrustManager);
        }
    }

    public TrustRootIndex e(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new AndroidTrustRootIndex(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.e(x509TrustManager);
        }
    }

    public void h(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (str != null) {
            this.f31227f.e(sSLSocket, Boolean.TRUE);
            this.f31228g.e(sSLSocket, str);
        }
        OptionalMethod<Socket> optionalMethod = this.f31230i;
        if (optionalMethod != null && optionalMethod.g(sSLSocket)) {
            this.f31230i.f(sSLSocket, Platform.f(list));
        }
    }

    public void i(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        try {
            socket.connect(inetSocketAddress, i2);
        } catch (AssertionError e2) {
            if (Util.B(e2)) {
                throw new IOException(e2);
            }
            throw e2;
        } catch (SecurityException e3) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e3);
            throw iOException;
        } catch (ClassCastException e4) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException2 = new IOException("Exception in connect");
                iOException2.initCause(e4);
                throw iOException2;
            }
            throw e4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        if (android.os.Build.VERSION.SDK_INT < 22) goto L_0x0006;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public javax.net.ssl.SSLContext m() {
        /*
            r3 = this;
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ NoClassDefFoundError -> 0x0006 }
            r1 = 22
            if (r0 >= r1) goto L_0x000d
        L_0x0006:
            java.lang.String r0 = "TLSv1.2"
            javax.net.ssl.SSLContext r0 = javax.net.ssl.SSLContext.getInstance(r0)     // Catch:{ NoSuchAlgorithmException -> 0x000d }
            return r0
        L_0x000d:
            java.lang.String r0 = "TLS"
            javax.net.ssl.SSLContext r0 = javax.net.ssl.SSLContext.getInstance(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0014 }
            return r0
        L_0x0014:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "No TLS provider"
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.AndroidPlatform.m():javax.net.ssl.SSLContext");
    }

    @Nullable
    public String n(SSLSocket sSLSocket) {
        byte[] bArr;
        OptionalMethod<Socket> optionalMethod = this.f31229h;
        if (optionalMethod == null || !optionalMethod.g(sSLSocket) || (bArr = (byte[]) this.f31229h.f(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, Util.f30979j);
    }

    public Object o(String str) {
        return this.f31231j.a(str);
    }

    public boolean p(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return w(str, cls, cls.getMethod("getInstance", (Class[]) null).invoke((Object) null, (Object[]) null));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.p(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            throw Util.b("unable to determine cleartext support", e2);
        }
    }

    public void r(int i2, String str, @Nullable Throwable th) {
        int min;
        int i3 = 5;
        if (i2 != 5) {
            i3 = 3;
        }
        if (th != null) {
            str = str + 10 + Log.getStackTraceString(th);
        }
        int length = str.length();
        int i4 = 0;
        while (i4 < length) {
            int indexOf = str.indexOf(10, i4);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i4 + f31225k);
                Log.println(i3, "OkHttp", str.substring(i4, min));
                if (min >= indexOf) {
                    break;
                }
                i4 = min;
            }
            i4 = min + 1;
        }
    }

    public void s(String str, Object obj) {
        if (!this.f31231j.c(obj)) {
            r(5, str, (Throwable) null);
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public X509TrustManager u(SSLSocketFactory sSLSocketFactory) {
        Object t = Platform.t(sSLSocketFactory, this.f31226e, "sslParameters");
        if (t == null) {
            try {
                t = Platform.t(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (ClassNotFoundException unused) {
                return super.u(sSLSocketFactory);
            }
        }
        Class cls = X509TrustManager.class;
        X509TrustManager x509TrustManager = (X509TrustManager) Platform.t(t, cls, "x509TrustManager");
        return x509TrustManager != null ? x509TrustManager : (X509TrustManager) Platform.t(t, cls, "trustManager");
    }
}
