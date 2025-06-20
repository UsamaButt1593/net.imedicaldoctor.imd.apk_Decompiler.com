package okhttp3;

import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;

public final class Handshake {

    /* renamed from: a  reason: collision with root package name */
    private final TlsVersion f30865a;

    /* renamed from: b  reason: collision with root package name */
    private final CipherSuite f30866b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Certificate> f30867c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Certificate> f30868d;

    private Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        this.f30865a = tlsVersion;
        this.f30866b = cipherSuite;
        this.f30867c = list;
        this.f30868d = list2;
    }

    public static Handshake b(SSLSession sSLSession) throws IOException {
        Certificate[] certificateArr;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        } else if (!"SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            CipherSuite a2 = CipherSuite.a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            } else if (!"NONE".equals(protocol)) {
                TlsVersion a3 = TlsVersion.a(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                List v = certificateArr != null ? Util.v(certificateArr) : Collections.emptyList();
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                return new Handshake(a3, a2, v, localCertificates != null ? Util.v(localCertificates) : Collections.emptyList());
            } else {
                throw new IOException("tlsVersion == NONE");
            }
        } else {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
    }

    public static Handshake c(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        if (tlsVersion == null) {
            throw new NullPointerException("tlsVersion == null");
        } else if (cipherSuite != null) {
            return new Handshake(tlsVersion, cipherSuite, Util.u(list), Util.u(list2));
        } else {
            throw new NullPointerException("cipherSuite == null");
        }
    }

    public CipherSuite a() {
        return this.f30866b;
    }

    public List<Certificate> d() {
        return this.f30868d;
    }

    @Nullable
    public Principal e() {
        if (!this.f30868d.isEmpty()) {
            return ((X509Certificate) this.f30868d.get(0)).getSubjectX500Principal();
        }
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        return this.f30865a.equals(handshake.f30865a) && this.f30866b.equals(handshake.f30866b) && this.f30867c.equals(handshake.f30867c) && this.f30868d.equals(handshake.f30868d);
    }

    public List<Certificate> f() {
        return this.f30867c;
    }

    @Nullable
    public Principal g() {
        if (!this.f30867c.isEmpty()) {
            return ((X509Certificate) this.f30867c.get(0)).getSubjectX500Principal();
        }
        return null;
    }

    public TlsVersion h() {
        return this.f30865a;
    }

    public int hashCode() {
        return ((((((MetaDo.w + this.f30865a.hashCode()) * 31) + this.f30866b.hashCode()) * 31) + this.f30867c.hashCode()) * 31) + this.f30868d.hashCode();
    }
}
