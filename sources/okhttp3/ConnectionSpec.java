package okhttp3;

import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Util;

public final class ConnectionSpec {

    /* renamed from: e  reason: collision with root package name */
    private static final CipherSuite[] f30811e;

    /* renamed from: f  reason: collision with root package name */
    private static final CipherSuite[] f30812f;

    /* renamed from: g  reason: collision with root package name */
    public static final ConnectionSpec f30813g;

    /* renamed from: h  reason: collision with root package name */
    public static final ConnectionSpec f30814h;

    /* renamed from: i  reason: collision with root package name */
    public static final ConnectionSpec f30815i;

    /* renamed from: j  reason: collision with root package name */
    public static final ConnectionSpec f30816j = new Builder(false).c();

    /* renamed from: a  reason: collision with root package name */
    final boolean f30817a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f30818b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    final String[] f30819c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    final String[] f30820d;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        boolean f30821a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        String[] f30822b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        String[] f30823c;

        /* renamed from: d  reason: collision with root package name */
        boolean f30824d;

        public Builder(ConnectionSpec connectionSpec) {
            this.f30821a = connectionSpec.f30817a;
            this.f30822b = connectionSpec.f30819c;
            this.f30823c = connectionSpec.f30820d;
            this.f30824d = connectionSpec.f30818b;
        }

        public Builder a() {
            if (this.f30821a) {
                this.f30822b = null;
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public Builder b() {
            if (this.f30821a) {
                this.f30823c = null;
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public ConnectionSpec c() {
            return new ConnectionSpec(this);
        }

        public Builder d(String... strArr) {
            if (!this.f30821a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.f30822b = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        public Builder e(CipherSuite... cipherSuiteArr) {
            if (this.f30821a) {
                String[] strArr = new String[cipherSuiteArr.length];
                for (int i2 = 0; i2 < cipherSuiteArr.length; i2++) {
                    strArr[i2] = cipherSuiteArr[i2].f30802a;
                }
                return d(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public Builder f(boolean z) {
            if (this.f30821a) {
                this.f30824d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public Builder g(String... strArr) {
            if (!this.f30821a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.f30823c = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }

        public Builder h(TlsVersion... tlsVersionArr) {
            if (this.f30821a) {
                String[] strArr = new String[tlsVersionArr.length];
                for (int i2 = 0; i2 < tlsVersionArr.length; i2++) {
                    strArr[i2] = tlsVersionArr[i2].s;
                }
                return g(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        Builder(boolean z) {
            this.f30821a = z;
        }
    }

    static {
        CipherSuite cipherSuite = CipherSuite.n1;
        CipherSuite cipherSuite2 = CipherSuite.o1;
        CipherSuite cipherSuite3 = CipherSuite.p1;
        CipherSuite cipherSuite4 = CipherSuite.q1;
        CipherSuite cipherSuite5 = CipherSuite.r1;
        CipherSuite cipherSuite6 = CipherSuite.Z0;
        CipherSuite cipherSuite7 = CipherSuite.d1;
        CipherSuite cipherSuite8 = CipherSuite.a1;
        CipherSuite cipherSuite9 = CipherSuite.e1;
        CipherSuite cipherSuite10 = CipherSuite.k1;
        CipherSuite cipherSuite11 = CipherSuite.j1;
        CipherSuite[] cipherSuiteArr = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, cipherSuite10, cipherSuite11};
        f30811e = cipherSuiteArr;
        CipherSuite[] cipherSuiteArr2 = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, cipherSuite10, cipherSuite11, CipherSuite.K0, CipherSuite.L0, CipherSuite.i0, CipherSuite.j0, CipherSuite.G, CipherSuite.K, CipherSuite.f30798k};
        f30812f = cipherSuiteArr2;
        Builder e2 = new Builder(true).e(cipherSuiteArr);
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        f30813g = e2.h(tlsVersion, tlsVersion2).f(true).c();
        Builder e3 = new Builder(true).e(cipherSuiteArr2);
        TlsVersion tlsVersion3 = TlsVersion.TLS_1_0;
        f30814h = e3.h(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, tlsVersion3).f(true).c();
        f30815i = new Builder(true).e(cipherSuiteArr2).h(tlsVersion3).f(true).c();
    }

    ConnectionSpec(Builder builder) {
        this.f30817a = builder.f30821a;
        this.f30819c = builder.f30822b;
        this.f30820d = builder.f30823c;
        this.f30818b = builder.f30824d;
    }

    private ConnectionSpec e(SSLSocket sSLSocket, boolean z) {
        String[] A = this.f30819c != null ? Util.A(CipherSuite.f30789b, sSLSocket.getEnabledCipherSuites(), this.f30819c) : sSLSocket.getEnabledCipherSuites();
        String[] A2 = this.f30820d != null ? Util.A(Util.q, sSLSocket.getEnabledProtocols(), this.f30820d) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int x = Util.x(CipherSuite.f30789b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && x != -1) {
            A = Util.j(A, supportedCipherSuites[x]);
        }
        return new Builder(this).d(A).g(A2).c();
    }

    /* access modifiers changed from: package-private */
    public void a(SSLSocket sSLSocket, boolean z) {
        ConnectionSpec e2 = e(sSLSocket, z);
        String[] strArr = e2.f30820d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = e2.f30819c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    @Nullable
    public List<CipherSuite> b() {
        String[] strArr = this.f30819c;
        if (strArr != null) {
            return CipherSuite.b(strArr);
        }
        return null;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (!this.f30817a) {
            return false;
        }
        String[] strArr = this.f30820d;
        if (strArr != null && !Util.C(Util.q, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f30819c;
        return strArr2 == null || Util.C(CipherSuite.f30789b, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public boolean d() {
        return this.f30817a;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        boolean z = this.f30817a;
        if (z != connectionSpec.f30817a) {
            return false;
        }
        return !z || (Arrays.equals(this.f30819c, connectionSpec.f30819c) && Arrays.equals(this.f30820d, connectionSpec.f30820d) && this.f30818b == connectionSpec.f30818b);
    }

    public boolean f() {
        return this.f30818b;
    }

    @Nullable
    public List<TlsVersion> g() {
        String[] strArr = this.f30820d;
        if (strArr != null) {
            return TlsVersion.b(strArr);
        }
        return null;
    }

    public int hashCode() {
        if (this.f30817a) {
            return ((((MetaDo.w + Arrays.hashCode(this.f30819c)) * 31) + Arrays.hashCode(this.f30820d)) * 31) + (this.f30818b ^ true ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f30817a) {
            return "ConnectionSpec()";
        }
        String str = "[all enabled]";
        String obj = this.f30819c != null ? b().toString() : str;
        if (this.f30820d != null) {
            str = g().toString();
        }
        return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + str + ", supportsTlsExtensions=" + this.f30818b + ")";
    }
}
