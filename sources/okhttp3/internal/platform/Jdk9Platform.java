package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.Util;

final class Jdk9Platform extends Platform {

    /* renamed from: e  reason: collision with root package name */
    final Method f31239e;

    /* renamed from: f  reason: collision with root package name */
    final Method f31240f;

    Jdk9Platform(Method method, Method method2) {
        this.f31239e = method;
        this.f31240f = method2;
    }

    public static Jdk9Platform v() {
        try {
            return new Jdk9Platform(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", (Class[]) null));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public void h(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> b2 = Platform.b(list);
            this.f31239e.invoke(sSLParameters, new Object[]{b2.toArray(new String[b2.size()])});
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw Util.b("unable to set ssl parameters", e2);
        }
    }

    @Nullable
    public String n(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f31240f.invoke(sSLSocket, (Object[]) null);
            if (str == null || str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw Util.b("unable to get selected protocols", e2);
        }
    }

    public X509TrustManager u(SSLSocketFactory sSLSocketFactory) {
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }
}
