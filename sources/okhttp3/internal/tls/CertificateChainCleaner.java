package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.platform.Platform;

public abstract class CertificateChainCleaner {
    public static CertificateChainCleaner b(X509TrustManager x509TrustManager) {
        return Platform.k().d(x509TrustManager);
    }

    public static CertificateChainCleaner c(X509Certificate... x509CertificateArr) {
        return new BasicCertificateChainCleaner(new BasicTrustRootIndex(x509CertificateArr));
    }

    public abstract List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}
