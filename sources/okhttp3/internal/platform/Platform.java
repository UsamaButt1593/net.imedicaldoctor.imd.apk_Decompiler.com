package okhttp3.internal.platform;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;

public class Platform {

    /* renamed from: a  reason: collision with root package name */
    private static final Platform f31252a = j();

    /* renamed from: b  reason: collision with root package name */
    public static final int f31253b = 4;

    /* renamed from: c  reason: collision with root package name */
    public static final int f31254c = 5;

    /* renamed from: d  reason: collision with root package name */
    private static final Logger f31255d = Logger.getLogger(OkHttpClient.class.getName());

    public static List<String> b(List<Protocol> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Protocol protocol = list.get(i2);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    static byte[] f(List<Protocol> list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Protocol protocol = list.get(i2);
            if (protocol != Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.toString().length());
                buffer.W0(protocol.toString());
            }
        }
        return buffer.b0();
    }

    private static Platform j() {
        ConscryptPlatform v;
        Platform x = AndroidPlatform.x();
        if (x != null) {
            return x;
        }
        if (q() && (v = ConscryptPlatform.v()) != null) {
            return v;
        }
        Jdk9Platform v2 = Jdk9Platform.v();
        if (v2 != null) {
            return v2;
        }
        Platform v3 = JdkWithJettyBootPlatform.v();
        return v3 != null ? v3 : new Platform();
    }

    public static Platform k() {
        return f31252a;
    }

    public static boolean q() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    @Nullable
    static <T> T t(Object obj, Class<T> cls, String str) {
        Object t;
        Class cls2 = obj.getClass();
        while (true) {
            Class<Object> cls3 = Object.class;
            if (cls2 != cls3) {
                try {
                    Field declaredField = cls2.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    Object obj2 = declaredField.get(obj);
                    if (obj2 != null) {
                        if (cls.isInstance(obj2)) {
                            return cls.cast(obj2);
                        }
                    }
                    return null;
                } catch (NoSuchFieldException unused) {
                    cls2 = cls2.getSuperclass();
                } catch (IllegalAccessException unused2) {
                    throw new AssertionError();
                }
            } else if (str.equals("delegate") || (t = t(obj, cls3, "delegate")) == null) {
                return null;
            } else {
                return t(t, cls, str);
            }
        }
    }

    public void a(SSLSocket sSLSocket) {
    }

    public CertificateChainCleaner c(SSLSocketFactory sSLSocketFactory) {
        X509TrustManager u = u(sSLSocketFactory);
        if (u != null) {
            return d(u);
        }
        throw new IllegalStateException("Unable to extract the trust manager on " + k() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
    }

    public CertificateChainCleaner d(X509TrustManager x509TrustManager) {
        return new BasicCertificateChainCleaner(e(x509TrustManager));
    }

    public TrustRootIndex e(X509TrustManager x509TrustManager) {
        return new BasicTrustRootIndex(x509TrustManager.getAcceptedIssuers());
    }

    public void g(SSLSocketFactory sSLSocketFactory) {
    }

    public void h(SSLSocket sSLSocket, @Nullable String str, List<Protocol> list) {
    }

    public void i(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        socket.connect(inetSocketAddress, i2);
    }

    public String l() {
        return "OkHttp";
    }

    public SSLContext m() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException("No TLS provider", e2);
        }
    }

    @Nullable
    public String n(SSLSocket sSLSocket) {
        return null;
    }

    public Object o(String str) {
        if (f31255d.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean p(String str) {
        return true;
    }

    public void r(int i2, String str, @Nullable Throwable th) {
        f31255d.log(i2 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void s(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        r(5, str, (Throwable) obj);
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public X509TrustManager u(SSLSocketFactory sSLSocketFactory) {
        try {
            Object t = t(sSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (t == null) {
                return null;
            }
            return (X509TrustManager) t(t, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
