package okhttp3;

import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

public final class Address {

    /* renamed from: a  reason: collision with root package name */
    final HttpUrl f30726a;

    /* renamed from: b  reason: collision with root package name */
    final Dns f30727b;

    /* renamed from: c  reason: collision with root package name */
    final SocketFactory f30728c;

    /* renamed from: d  reason: collision with root package name */
    final Authenticator f30729d;

    /* renamed from: e  reason: collision with root package name */
    final List<Protocol> f30730e;

    /* renamed from: f  reason: collision with root package name */
    final List<ConnectionSpec> f30731f;

    /* renamed from: g  reason: collision with root package name */
    final ProxySelector f30732g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    final Proxy f30733h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    final SSLSocketFactory f30734i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    final HostnameVerifier f30735j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    final CertificatePinner f30736k;

    public Address(String str, int i2, Dns dns, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable CertificatePinner certificatePinner, Authenticator authenticator, @Nullable Proxy proxy, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        this.f30726a = new HttpUrl.Builder().H(sSLSocketFactory != null ? "https" : "http").q(str).x(i2).h();
        if (dns != null) {
            this.f30727b = dns;
            if (socketFactory != null) {
                this.f30728c = socketFactory;
                if (authenticator != null) {
                    this.f30729d = authenticator;
                    if (list != null) {
                        this.f30730e = Util.u(list);
                        if (list2 != null) {
                            this.f30731f = Util.u(list2);
                            if (proxySelector != null) {
                                this.f30732g = proxySelector;
                                this.f30733h = proxy;
                                this.f30734i = sSLSocketFactory;
                                this.f30735j = hostnameVerifier;
                                this.f30736k = certificatePinner;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    @Nullable
    public CertificatePinner a() {
        return this.f30736k;
    }

    public List<ConnectionSpec> b() {
        return this.f30731f;
    }

    public Dns c() {
        return this.f30727b;
    }

    /* access modifiers changed from: package-private */
    public boolean d(Address address) {
        return this.f30727b.equals(address.f30727b) && this.f30729d.equals(address.f30729d) && this.f30730e.equals(address.f30730e) && this.f30731f.equals(address.f30731f) && this.f30732g.equals(address.f30732g) && Util.r(this.f30733h, address.f30733h) && Util.r(this.f30734i, address.f30734i) && Util.r(this.f30735j, address.f30735j) && Util.r(this.f30736k, address.f30736k) && l().E() == address.l().E();
    }

    @Nullable
    public HostnameVerifier e() {
        return this.f30735j;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            return this.f30726a.equals(address.f30726a) && d(address);
        }
    }

    public List<Protocol> f() {
        return this.f30730e;
    }

    @Nullable
    public Proxy g() {
        return this.f30733h;
    }

    public Authenticator h() {
        return this.f30729d;
    }

    public int hashCode() {
        int hashCode = (((((((((((MetaDo.w + this.f30726a.hashCode()) * 31) + this.f30727b.hashCode()) * 31) + this.f30729d.hashCode()) * 31) + this.f30730e.hashCode()) * 31) + this.f30731f.hashCode()) * 31) + this.f30732g.hashCode()) * 31;
        Proxy proxy = this.f30733h;
        int i2 = 0;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f30734i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f30735j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        CertificatePinner certificatePinner = this.f30736k;
        if (certificatePinner != null) {
            i2 = certificatePinner.hashCode();
        }
        return hashCode4 + i2;
    }

    public ProxySelector i() {
        return this.f30732g;
    }

    public SocketFactory j() {
        return this.f30728c;
    }

    @Nullable
    public SSLSocketFactory k() {
        return this.f30734i;
    }

    public HttpUrl l() {
        return this.f30726a;
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f30726a.p());
        sb.append(":");
        sb.append(this.f30726a.E());
        if (this.f30733h != null) {
            sb.append(", proxy=");
            obj = this.f30733h;
        } else {
            sb.append(", proxySelector=");
            obj = this.f30732g;
        }
        sb.append(obj);
        sb.append("}");
        return sb.toString();
    }
}
