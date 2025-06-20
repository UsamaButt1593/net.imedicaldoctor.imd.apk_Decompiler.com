package okhttp3;

import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;

public final class CertificatePinner {

    /* renamed from: c  reason: collision with root package name */
    public static final CertificatePinner f30778c = new Builder().b();

    /* renamed from: a  reason: collision with root package name */
    private final Set<Pin> f30779a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final CertificateChainCleaner f30780b;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final List<Pin> f30781a = new ArrayList();

        public Builder a(String str, String... strArr) {
            if (str != null) {
                for (String pin : strArr) {
                    this.f30781a.add(new Pin(str, pin));
                }
                return this;
            }
            throw new NullPointerException("pattern == null");
        }

        public CertificatePinner b() {
            return new CertificatePinner(new LinkedHashSet(this.f30781a), (CertificateChainCleaner) null);
        }
    }

    static final class Pin {

        /* renamed from: e  reason: collision with root package name */
        private static final String f30782e = "*.";

        /* renamed from: a  reason: collision with root package name */
        final String f30783a;

        /* renamed from: b  reason: collision with root package name */
        final String f30784b;

        /* renamed from: c  reason: collision with root package name */
        final String f30785c;

        /* renamed from: d  reason: collision with root package name */
        final ByteString f30786d;

        Pin(String str, String str2) {
            StringBuilder sb;
            int i2;
            this.f30783a = str;
            if (str.startsWith(f30782e)) {
                sb = new StringBuilder();
                sb.append("http://");
                str = str.substring(2);
            } else {
                sb = new StringBuilder();
                sb.append("http://");
            }
            sb.append(str);
            this.f30784b = HttpUrl.m(sb.toString()).p();
            if (str2.startsWith("sha1/")) {
                this.f30785c = "sha1/";
                i2 = 5;
            } else if (str2.startsWith("sha256/")) {
                this.f30785c = "sha256/";
                i2 = 7;
            } else {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str2);
            }
            this.f30786d = ByteString.j(str2.substring(i2));
            if (this.f30786d == null) {
                throw new IllegalArgumentException("pins must be base64: " + str2);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(String str) {
            if (!this.f30783a.startsWith(f30782e)) {
                return str.equals(this.f30784b);
            }
            int indexOf = str.indexOf(46);
            if ((str.length() - indexOf) - 1 == this.f30784b.length()) {
                String str2 = this.f30784b;
                if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Pin) {
                Pin pin = (Pin) obj;
                return this.f30783a.equals(pin.f30783a) && this.f30785c.equals(pin.f30785c) && this.f30786d.equals(pin.f30786d);
            }
        }

        public int hashCode() {
            return ((((MetaDo.w + this.f30783a.hashCode()) * 31) + this.f30785c.hashCode()) * 31) + this.f30786d.hashCode();
        }

        public String toString() {
            return this.f30785c + this.f30786d.e();
        }
    }

    CertificatePinner(Set<Pin> set, @Nullable CertificateChainCleaner certificateChainCleaner) {
        this.f30779a = set;
        this.f30780b = certificateChainCleaner;
    }

    public static String d(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + f((X509Certificate) certificate).e();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static ByteString e(X509Certificate x509Certificate) {
        return ByteString.U(x509Certificate.getPublicKey().getEncoded()).i0();
    }

    static ByteString f(X509Certificate x509Certificate) {
        return ByteString.U(x509Certificate.getPublicKey().getEncoded()).j0();
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<Pin> c2 = c(str);
        if (!c2.isEmpty()) {
            CertificateChainCleaner certificateChainCleaner = this.f30780b;
            if (certificateChainCleaner != null) {
                list = certificateChainCleaner.a(list, str);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i2);
                int size2 = c2.size();
                ByteString byteString = null;
                ByteString byteString2 = null;
                for (int i3 = 0; i3 < size2; i3++) {
                    Pin pin = c2.get(i3);
                    if (pin.f30785c.equals("sha256/")) {
                        if (byteString == null) {
                            byteString = f(x509Certificate);
                        }
                        if (pin.f30786d.equals(byteString)) {
                            return;
                        }
                    } else if (pin.f30785c.equals("sha1/")) {
                        if (byteString2 == null) {
                            byteString2 = e(x509Certificate);
                        }
                        if (pin.f30786d.equals(byteString2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError("unsupported hashAlgorithm: " + pin.f30785c);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Certificate pinning failure!");
            sb.append("\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i4 = 0; i4 < size3; i4++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i4);
                sb.append("\n    ");
                sb.append(d(x509Certificate2));
                sb.append(": ");
                sb.append(x509Certificate2.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(":");
            int size4 = c2.size();
            for (int i5 = 0; i5 < size4; i5++) {
                sb.append("\n    ");
                sb.append(c2.get(i5));
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    public void b(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        a(str, Arrays.asList(certificateArr));
    }

    /* access modifiers changed from: package-private */
    public List<Pin> c(String str) {
        List<Pin> emptyList = Collections.emptyList();
        for (Pin next : this.f30779a) {
            if (next.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(next);
            }
        }
        return emptyList;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            return Util.r(this.f30780b, certificatePinner.f30780b) && this.f30779a.equals(certificatePinner.f30779a);
        }
    }

    /* access modifiers changed from: package-private */
    public CertificatePinner g(@Nullable CertificateChainCleaner certificateChainCleaner) {
        return Util.r(this.f30780b, certificateChainCleaner) ? this : new CertificatePinner(this.f30779a, certificateChainCleaner);
    }

    public int hashCode() {
        CertificateChainCleaner certificateChainCleaner = this.f30780b;
        return ((certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0) * 31) + this.f30779a.hashCode();
    }
}
