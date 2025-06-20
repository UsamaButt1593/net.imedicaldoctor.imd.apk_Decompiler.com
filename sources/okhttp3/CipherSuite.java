package okhttp3;

import androidx.media3.extractor.ts.TsExtractor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class CipherSuite {
    public static final CipherSuite A = c("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    public static final CipherSuite A0 = c("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    public static final CipherSuite B = c("TLS_KRB5_WITH_RC4_128_MD5", 36);
    public static final CipherSuite B0 = c("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    public static final CipherSuite C = c("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    public static final CipherSuite C0 = c("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    public static final CipherSuite D = c("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    public static final CipherSuite D0 = c("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    public static final CipherSuite E = c("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    public static final CipherSuite E0 = c("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    public static final CipherSuite F = c("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    public static final CipherSuite F0 = c("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    public static final CipherSuite G = c("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    public static final CipherSuite G0 = c("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    public static final CipherSuite H = c("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    public static final CipherSuite H0 = c("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    public static final CipherSuite I = c("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    public static final CipherSuite I0 = c("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    public static final CipherSuite J = c("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    public static final CipherSuite J0 = c("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    public static final CipherSuite K = c("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    public static final CipherSuite K0 = c("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    public static final CipherSuite L = c("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    public static final CipherSuite L0 = c("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    public static final CipherSuite M = c("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    public static final CipherSuite M0 = c("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    public static final CipherSuite N = c("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    public static final CipherSuite N0 = c("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    public static final CipherSuite O = c("TLS_RSA_WITH_NULL_SHA256", 59);
    public static final CipherSuite O0 = c("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    public static final CipherSuite P = c("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    public static final CipherSuite P0 = c("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    public static final CipherSuite Q = c("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    public static final CipherSuite Q0 = c("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    public static final CipherSuite R = c("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    public static final CipherSuite R0 = c("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    public static final CipherSuite S = c("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    public static final CipherSuite S0 = c("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    public static final CipherSuite T = c("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    public static final CipherSuite T0 = c("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    public static final CipherSuite U = c("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    public static final CipherSuite U0 = c("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    public static final CipherSuite V = c("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
    public static final CipherSuite V0 = c("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    public static final CipherSuite W = c("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    public static final CipherSuite W0 = c("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    public static final CipherSuite X = c("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    public static final CipherSuite X0 = c("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    public static final CipherSuite Y = c("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    public static final CipherSuite Y0 = c("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    public static final CipherSuite Z = c("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    public static final CipherSuite Z0 = c("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    public static final CipherSuite a0 = c("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
    public static final CipherSuite a1 = c("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);

    /* renamed from: b  reason: collision with root package name */
    static final Comparator<String> f30789b = new Comparator<String>() {
        /* renamed from: a */
        public int compare(String str, String str2) {
            int min = Math.min(str.length(), str2.length());
            for (int i2 = 4; i2 < min; i2++) {
                char charAt = str.charAt(i2);
                char charAt2 = str2.charAt(i2);
                if (charAt != charAt2) {
                    return charAt < charAt2 ? -1 : 1;
                }
            }
            int length = str.length();
            int length2 = str2.length();
            if (length != length2) {
                return length < length2 ? -1 : 1;
            }
            return 0;
        }
    };
    public static final CipherSuite b0 = c("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", TsExtractor.M);
    public static final CipherSuite b1 = c("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, CipherSuite> f30790c = new LinkedHashMap();
    public static final CipherSuite c0 = c("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", TsExtractor.V);
    public static final CipherSuite c1 = c("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);

    /* renamed from: d  reason: collision with root package name */
    public static final CipherSuite f30791d = c("SSL_RSA_WITH_NULL_MD5", 1);
    public static final CipherSuite d0 = c("TLS_PSK_WITH_RC4_128_SHA", TsExtractor.K);
    public static final CipherSuite d1 = c("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);

    /* renamed from: e  reason: collision with root package name */
    public static final CipherSuite f30792e = c("SSL_RSA_WITH_NULL_SHA", 2);
    public static final CipherSuite e0 = c("TLS_PSK_WITH_3DES_EDE_CBC_SHA", TsExtractor.W);
    public static final CipherSuite e1 = c("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);

    /* renamed from: f  reason: collision with root package name */
    public static final CipherSuite f30793f = c("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
    public static final CipherSuite f0 = c("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
    public static final CipherSuite f1 = c("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);

    /* renamed from: g  reason: collision with root package name */
    public static final CipherSuite f30794g = c("SSL_RSA_WITH_RC4_128_MD5", 4);
    public static final CipherSuite g0 = c("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
    public static final CipherSuite g1 = c("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);

    /* renamed from: h  reason: collision with root package name */
    public static final CipherSuite f30795h = c("SSL_RSA_WITH_RC4_128_SHA", 5);
    public static final CipherSuite h0 = c("TLS_RSA_WITH_SEED_CBC_SHA", 150);
    public static final CipherSuite h1 = c("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);

    /* renamed from: i  reason: collision with root package name */
    public static final CipherSuite f30796i = c("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
    public static final CipherSuite i0 = c("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    public static final CipherSuite i1 = c("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);

    /* renamed from: j  reason: collision with root package name */
    public static final CipherSuite f30797j = c("SSL_RSA_WITH_DES_CBC_SHA", 9);
    public static final CipherSuite j0 = c("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    public static final CipherSuite j1 = c("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);

    /* renamed from: k  reason: collision with root package name */
    public static final CipherSuite f30798k = c("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    public static final CipherSuite k0 = c("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
    public static final CipherSuite k1 = c("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);

    /* renamed from: l  reason: collision with root package name */
    public static final CipherSuite f30799l = c("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    public static final CipherSuite l0 = c("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
    public static final CipherSuite l1 = c("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);

    /* renamed from: m  reason: collision with root package name */
    public static final CipherSuite f30800m = c("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    public static final CipherSuite m0 = c("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
    public static final CipherSuite m1 = c("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);

    /* renamed from: n  reason: collision with root package name */
    public static final CipherSuite f30801n = c("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    public static final CipherSuite n0 = c("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
    public static final CipherSuite n1 = c("TLS_AES_128_GCM_SHA256", 4865);
    public static final CipherSuite o = c("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    public static final CipherSuite o0 = c("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
    public static final CipherSuite o1 = c("TLS_AES_256_GCM_SHA384", 4866);
    public static final CipherSuite p = c("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    public static final CipherSuite p0 = c("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
    public static final CipherSuite p1 = c("TLS_CHACHA20_POLY1305_SHA256", 4867);
    public static final CipherSuite q = c("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    public static final CipherSuite q0 = c("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
    public static final CipherSuite q1 = c("TLS_AES_128_CCM_SHA256", 4868);
    public static final CipherSuite r = c("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    public static final CipherSuite r0 = c("TLS_FALLBACK_SCSV", 22016);
    public static final CipherSuite r1 = c("TLS_AES_256_CCM_8_SHA256", 4869);
    public static final CipherSuite s = c("SSL_DH_anon_WITH_RC4_128_MD5", 24);
    public static final CipherSuite s0 = c("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
    public static final CipherSuite t = c("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    public static final CipherSuite t0 = c("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
    public static final CipherSuite u = c("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    public static final CipherSuite u0 = c("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    public static final CipherSuite v = c("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    public static final CipherSuite v0 = c("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    public static final CipherSuite w = c("TLS_KRB5_WITH_DES_CBC_SHA", 30);
    public static final CipherSuite w0 = c("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    public static final CipherSuite x = c("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    public static final CipherSuite x0 = c("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    public static final CipherSuite y = c("TLS_KRB5_WITH_RC4_128_SHA", 32);
    public static final CipherSuite y0 = c("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    public static final CipherSuite z = c("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    public static final CipherSuite z0 = c("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);

    /* renamed from: a  reason: collision with root package name */
    final String f30802a;

    private CipherSuite(String str) {
        str.getClass();
        this.f30802a = str;
    }

    public static synchronized CipherSuite a(String str) {
        CipherSuite cipherSuite;
        synchronized (CipherSuite.class) {
            try {
                Map<String, CipherSuite> map = f30790c;
                cipherSuite = map.get(str);
                if (cipherSuite == null) {
                    cipherSuite = map.get(e(str));
                    if (cipherSuite == null) {
                        cipherSuite = new CipherSuite(str);
                    }
                    map.put(str, cipherSuite);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return cipherSuite;
    }

    static List<CipherSuite> b(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String a2 : strArr) {
            arrayList.add(a(a2));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static CipherSuite c(String str, int i2) {
        CipherSuite cipherSuite = new CipherSuite(str);
        f30790c.put(str, cipherSuite);
        return cipherSuite;
    }

    private static String e(String str) {
        if (str.startsWith("TLS_")) {
            return "SSL_" + str.substring(4);
        } else if (!str.startsWith("SSL_")) {
            return str;
        } else {
            return "TLS_" + str.substring(4);
        }
    }

    public String d() {
        return this.f30802a;
    }

    public String toString() {
        return this.f30802a;
    }
}
