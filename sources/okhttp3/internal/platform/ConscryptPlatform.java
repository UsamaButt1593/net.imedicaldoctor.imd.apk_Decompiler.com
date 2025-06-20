package okhttp3.internal.platform;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;

public class ConscryptPlatform extends Platform {
    private ConscryptPlatform() {
    }

    public static ConscryptPlatform v() {
        try {
            Class.forName("org.conscrypt.Conscrypt");
            if (!Conscrypt.isAvailable()) {
                return null;
            }
            return new ConscryptPlatform();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private Provider w() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }

    public void g(SSLSocketFactory sSLSocketFactory) {
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }

    public void h(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            if (str != null) {
                Conscrypt.setUseSessionTickets(sSLSocket, true);
                Conscrypt.setHostname(sSLSocket, str);
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) Platform.b(list).toArray(new String[0]));
            return;
        }
        super.h(sSLSocket, str, list);
    }

    public SSLContext m() {
        try {
            return SSLContext.getInstance("TLSv1.3", w());
        } catch (NoSuchAlgorithmException e2) {
            try {
                return SSLContext.getInstance("TLS", w());
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("No TLS provider", e2);
            }
        }
    }

    @Nullable
    public String n(SSLSocket sSLSocket) {
        return Conscrypt.isConscrypt(sSLSocket) ? Conscrypt.getApplicationProtocol(sSLSocket) : super.n(sSLSocket);
    }

    @Nullable
    public X509TrustManager u(SSLSocketFactory sSLSocketFactory) {
        if (!Conscrypt.isConscrypt(sSLSocketFactory)) {
            return super.u(sSLSocketFactory);
        }
        try {
            Object t = Platform.t(sSLSocketFactory, Object.class, "sslParameters");
            if (t != null) {
                return (X509TrustManager) Platform.t(t, X509TrustManager.class, "x509TrustManager");
            }
            return null;
        } catch (Exception e2) {
            throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on Conscrypt", e2);
        }
    }
}
