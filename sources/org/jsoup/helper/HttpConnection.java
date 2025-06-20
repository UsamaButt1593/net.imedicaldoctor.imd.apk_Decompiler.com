package org.jsoup.helper;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.net.HttpHeaders;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import kotlin.text.Typography;
import org.jsoup.Connection;
import org.jsoup.internal.Normalizer;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.parser.TokenQueue;

public class HttpConnection implements Connection {

    /* renamed from: c  reason: collision with root package name */
    public static final String f31567c = "Content-Encoding";

    /* renamed from: d  reason: collision with root package name */
    public static final String f31568d = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36";

    /* renamed from: e  reason: collision with root package name */
    private static final String f31569e = "User-Agent";

    /* renamed from: f  reason: collision with root package name */
    private static final String f31570f = "Content-Type";

    /* renamed from: g  reason: collision with root package name */
    private static final String f31571g = "multipart/form-data";

    /* renamed from: h  reason: collision with root package name */
    private static final String f31572h = "application/x-www-form-urlencoded";

    /* renamed from: i  reason: collision with root package name */
    private static final int f31573i = 307;

    /* renamed from: a  reason: collision with root package name */
    private Connection.Request f31574a = new Request();

    /* renamed from: b  reason: collision with root package name */
    private Connection.Response f31575b = new Response();

    private static abstract class Base<T extends Connection.Base> implements Connection.Base<T> {

        /* renamed from: a  reason: collision with root package name */
        URL f31576a;

        /* renamed from: b  reason: collision with root package name */
        Connection.Method f31577b;

        /* renamed from: c  reason: collision with root package name */
        Map<String, String> f31578c;

        /* renamed from: d  reason: collision with root package name */
        Map<String, String> f31579d;

        private Base() {
            this.f31578c = new LinkedHashMap();
            this.f31579d = new LinkedHashMap();
        }

        private static String U(String str) {
            try {
                byte[] bytes = str.getBytes("ISO-8859-1");
                return !W(bytes) ? str : new String(bytes, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return str;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x001d, code lost:
            r3 = X(r3);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String V(java.lang.String r3) {
            /*
                r2 = this;
                java.lang.String r0 = "Header name must not be null"
                org.jsoup.helper.Validate.k(r3, r0)
                java.util.Map<java.lang.String, java.lang.String> r0 = r2.f31578c
                java.lang.Object r0 = r0.get(r3)
                java.lang.String r0 = (java.lang.String) r0
                if (r0 != 0) goto L_0x001b
                java.util.Map<java.lang.String, java.lang.String> r0 = r2.f31578c
                java.lang.String r1 = org.jsoup.internal.Normalizer.a(r3)
                java.lang.Object r0 = r0.get(r1)
                java.lang.String r0 = (java.lang.String) r0
            L_0x001b:
                if (r0 != 0) goto L_0x002a
                java.util.Map$Entry r3 = r2.X(r3)
                if (r3 == 0) goto L_0x002a
                java.lang.Object r3 = r3.getValue()
                r0 = r3
                java.lang.String r0 = (java.lang.String) r0
            L_0x002a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Base.V(java.lang.String):java.lang.String");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
            if ((((r8[1] & 255) == 187) & ((r8[2] & 255) == 191)) != false) goto L_0x002a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean W(byte[] r8) {
            /*
                int r0 = r8.length
                r1 = 1
                r2 = 0
                r3 = 3
                if (r0 < r3) goto L_0x0029
                byte r0 = r8[r2]
                r0 = r0 & 255(0xff, float:3.57E-43)
                r4 = 239(0xef, float:3.35E-43)
                if (r0 != r4) goto L_0x0029
                byte r0 = r8[r1]
                r0 = r0 & 255(0xff, float:3.57E-43)
                r4 = 187(0xbb, float:2.62E-43)
                if (r0 != r4) goto L_0x0018
                r0 = 1
                goto L_0x0019
            L_0x0018:
                r0 = 0
            L_0x0019:
                r4 = 2
                byte r4 = r8[r4]
                r4 = r4 & 255(0xff, float:3.57E-43)
                r5 = 191(0xbf, float:2.68E-43)
                if (r4 != r5) goto L_0x0024
                r4 = 1
                goto L_0x0025
            L_0x0024:
                r4 = 0
            L_0x0025:
                r0 = r0 & r4
                if (r0 == 0) goto L_0x0029
                goto L_0x002a
            L_0x0029:
                r3 = 0
            L_0x002a:
                int r0 = r8.length
            L_0x002b:
                if (r3 >= r0) goto L_0x005d
                byte r4 = r8[r3]
                r5 = r4 & 128(0x80, float:1.794E-43)
                if (r5 != 0) goto L_0x0034
                goto L_0x005a
            L_0x0034:
                r5 = r4 & 224(0xe0, float:3.14E-43)
                r6 = 192(0xc0, float:2.69E-43)
                if (r5 != r6) goto L_0x003d
                int r4 = r3 + 1
                goto L_0x004e
            L_0x003d:
                r5 = r4 & 240(0xf0, float:3.36E-43)
                r7 = 224(0xe0, float:3.14E-43)
                if (r5 != r7) goto L_0x0046
                int r4 = r3 + 2
                goto L_0x004e
            L_0x0046:
                r4 = r4 & 248(0xf8, float:3.48E-43)
                r5 = 240(0xf0, float:3.36E-43)
                if (r4 != r5) goto L_0x005c
                int r4 = r3 + 3
            L_0x004e:
                if (r3 >= r4) goto L_0x005a
                int r3 = r3 + 1
                byte r5 = r8[r3]
                r5 = r5 & r6
                r7 = 128(0x80, float:1.794E-43)
                if (r5 == r7) goto L_0x004e
                return r2
            L_0x005a:
                int r3 = r3 + r1
                goto L_0x002b
            L_0x005c:
                return r2
            L_0x005d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Base.W(byte[]):boolean");
        }

        private Map.Entry<String, String> X(String str) {
            String a2 = Normalizer.a(str);
            for (Map.Entry<String, String> next : this.f31578c.entrySet()) {
                if (Normalizer.a(next.getKey()).equals(a2)) {
                    return next;
                }
            }
            return null;
        }

        public Connection.Method A() {
            return this.f31577b;
        }

        public T B(String str) {
            Validate.i(str, "Cookie name must not be empty");
            this.f31579d.remove(str);
            return this;
        }

        public Map<String, String> G() {
            return this.f31579d;
        }

        public String H(String str) {
            Validate.i(str, "Cookie name must not be empty");
            return this.f31579d.get(str);
        }

        public boolean K(String str) {
            Validate.i(str, "Cookie name must not be empty");
            return this.f31579d.containsKey(str);
        }

        public T L(String str) {
            Validate.i(str, "Header name must not be empty");
            Map.Entry<String, String> X = X(str);
            if (X != null) {
                this.f31578c.remove(X.getKey());
            }
            return this;
        }

        public String M(String str) {
            Validate.k(str, "Header name must not be null");
            String V = V(str);
            return V != null ? U(V) : V;
        }

        public Map<String, String> N() {
            return this.f31578c;
        }

        public T a(String str, String str2) {
            Validate.i(str, "Header name must not be empty");
            Validate.k(str2, "Header value must not be null");
            L(str);
            this.f31578c.put(str, str2);
            return this;
        }

        public T c(Connection.Method method) {
            Validate.k(method, "Method must not be null");
            this.f31577b = method;
            return this;
        }

        public T f(String str, String str2) {
            Validate.i(str, "Cookie name must not be empty");
            Validate.k(str2, "Cookie value must not be null");
            this.f31579d.put(str, str2);
            return this;
        }

        public T r(URL url) {
            Validate.k(url, "URL must not be null");
            this.f31576a = url;
            return this;
        }

        public boolean v(String str) {
            Validate.i(str, "Header name must not be empty");
            return V(str) != null;
        }

        public URL y() {
            return this.f31576a;
        }

        public boolean z(String str, String str2) {
            return v(str) && M(str).equalsIgnoreCase(str2);
        }
    }

    public static class KeyVal implements Connection.KeyVal {

        /* renamed from: a  reason: collision with root package name */
        private String f31580a;

        /* renamed from: b  reason: collision with root package name */
        private String f31581b;

        /* renamed from: c  reason: collision with root package name */
        private InputStream f31582c;

        private KeyVal() {
        }

        public static KeyVal f(String str, String str2) {
            return new KeyVal().c(str).a(str2);
        }

        public static KeyVal g(String str, String str2, InputStream inputStream) {
            return new KeyVal().c(str).a(str2).b(inputStream);
        }

        public String d() {
            return this.f31580a;
        }

        public boolean e() {
            return this.f31582c != null;
        }

        /* renamed from: h */
        public KeyVal b(InputStream inputStream) {
            Validate.k(this.f31581b, "Data input stream must not be null");
            this.f31582c = inputStream;
            return this;
        }

        /* renamed from: i */
        public KeyVal c(String str) {
            Validate.i(str, "Data key must not be empty");
            this.f31580a = str;
            return this;
        }

        /* renamed from: j */
        public KeyVal a(String str) {
            Validate.k(str, "Data value must not be null");
            this.f31581b = str;
            return this;
        }

        public String toString() {
            return this.f31580a + "=" + this.f31581b;
        }

        public String value() {
            return this.f31581b;
        }

        public InputStream z() {
            return this.f31582c;
        }
    }

    public static class Request extends Base<Connection.Request> implements Connection.Request {

        /* renamed from: e  reason: collision with root package name */
        private Proxy f31583e;

        /* renamed from: f  reason: collision with root package name */
        private int f31584f;

        /* renamed from: g  reason: collision with root package name */
        private int f31585g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f31586h;

        /* renamed from: i  reason: collision with root package name */
        private Collection<Connection.KeyVal> f31587i;

        /* renamed from: j  reason: collision with root package name */
        private String f31588j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f31589k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f31590l;

        /* renamed from: m  reason: collision with root package name */
        private Parser f31591m;
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public boolean f31592n;
        private boolean o;
        private String p;

        private Request() {
            super();
            this.f31588j = null;
            this.f31589k = false;
            this.f31590l = false;
            this.f31592n = false;
            this.o = true;
            this.p = "UTF-8";
            this.f31584f = 30000;
            this.f31585g = 1048576;
            this.f31586h = true;
            this.f31587i = new ArrayList();
            this.f31577b = Connection.Method.GET;
            this.f31578c.put(HttpHeaders.f22882j, "gzip");
            this.f31578c.put("User-Agent", HttpConnection.f31568d);
            this.f31591m = Parser.c();
        }

        public /* bridge */ /* synthetic */ Connection.Method A() {
            return super.A();
        }

        public Proxy C() {
            return this.f31583e;
        }

        public /* bridge */ /* synthetic */ Map G() {
            return super.G();
        }

        public /* bridge */ /* synthetic */ String H(String str) {
            return super.H(str);
        }

        public boolean I() {
            return this.f31586h;
        }

        public /* bridge */ /* synthetic */ boolean K(String str) {
            return super.K(str);
        }

        public /* bridge */ /* synthetic */ String M(String str) {
            return super.M(str);
        }

        public /* bridge */ /* synthetic */ Map N() {
            return super.N();
        }

        public String P() {
            return this.f31588j;
        }

        public int Q() {
            return this.f31585g;
        }

        public Parser T() {
            return this.f31591m;
        }

        /* renamed from: Z */
        public Request F(Connection.KeyVal keyVal) {
            Validate.k(keyVal, "Key val must not be null");
            this.f31587i.add(keyVal);
            return this;
        }

        /* renamed from: a0 */
        public Request q(Parser parser) {
            this.f31591m = parser;
            this.f31592n = true;
            return this;
        }

        public Connection.Request b(boolean z) {
            this.f31586h = z;
            return this;
        }

        /* renamed from: b0 */
        public Request e(String str, int i2) {
            this.f31583e = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i2));
            return this;
        }

        /* renamed from: c0 */
        public Request o(Proxy proxy) {
            this.f31583e = proxy;
            return this;
        }

        public Connection.Request d(String str) {
            this.f31588j = str;
            return this;
        }

        /* renamed from: d0 */
        public Request g(int i2) {
            Validate.e(i2 >= 0, "Timeout milliseconds must be 0 (infinite) or greater");
            this.f31584f = i2;
            return this;
        }

        public Connection.Request h(int i2) {
            Validate.e(i2 >= 0, "maxSize must be 0 (unlimited) or larger");
            this.f31585g = i2;
            return this;
        }

        public Collection<Connection.KeyVal> i() {
            return this.f31587i;
        }

        public int j() {
            return this.f31584f;
        }

        public void l(boolean z) {
            this.o = z;
        }

        public Connection.Request m(boolean z) {
            this.f31589k = z;
            return this;
        }

        public Connection.Request n(String str) {
            Validate.k(str, "Charset must not be null");
            if (Charset.isSupported(str)) {
                this.p = str;
                return this;
            }
            throw new IllegalCharsetNameException(str);
        }

        public Connection.Request p(boolean z) {
            this.f31590l = z;
            return this;
        }

        public boolean s() {
            return this.f31589k;
        }

        public String t() {
            return this.p;
        }

        public boolean u() {
            return this.o;
        }

        public /* bridge */ /* synthetic */ boolean v(String str) {
            return super.v(str);
        }

        public boolean x() {
            return this.f31590l;
        }

        public /* bridge */ /* synthetic */ URL y() {
            return super.y();
        }

        public /* bridge */ /* synthetic */ boolean z(String str, String str2) {
            return super.z(str, str2);
        }
    }

    public static class Response extends Base<Connection.Response> implements Connection.Response {

        /* renamed from: m  reason: collision with root package name */
        private static final int f31593m = 20;

        /* renamed from: n  reason: collision with root package name */
        private static SSLSocketFactory f31594n = null;
        private static final String o = "Location";
        private static final Pattern p = Pattern.compile("(application|text)/\\w*\\+?xml.*");

        /* renamed from: e  reason: collision with root package name */
        private int f31595e;

        /* renamed from: f  reason: collision with root package name */
        private String f31596f;

        /* renamed from: g  reason: collision with root package name */
        private ByteBuffer f31597g;

        /* renamed from: h  reason: collision with root package name */
        private String f31598h;

        /* renamed from: i  reason: collision with root package name */
        private String f31599i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f31600j = false;

        /* renamed from: k  reason: collision with root package name */
        private int f31601k = 0;

        /* renamed from: l  reason: collision with root package name */
        private Connection.Request f31602l;

        Response() {
            super();
        }

        private static HttpURLConnection Z(Connection.Request request) throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) (request.C() == null ? request.y().openConnection() : request.y().openConnection(request.C()));
            httpURLConnection.setRequestMethod(request.A().name());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setConnectTimeout(request.j());
            httpURLConnection.setReadTimeout(request.j());
            if ((httpURLConnection instanceof HttpsURLConnection) && !request.u()) {
                f0();
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                httpsURLConnection.setSSLSocketFactory(f31594n);
                httpsURLConnection.setHostnameVerifier(d0());
            }
            if (request.A().a()) {
                httpURLConnection.setDoOutput(true);
            }
            if (request.G().size() > 0) {
                httpURLConnection.addRequestProperty(HttpHeaders.p, e0(request));
            }
            for (Map.Entry next : request.N().entrySet()) {
                httpURLConnection.addRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            return httpURLConnection;
        }

        private static LinkedHashMap<String, List<String>> a0(HttpURLConnection httpURLConnection) {
            LinkedHashMap<String, List<String>> linkedHashMap = new LinkedHashMap<>();
            int i2 = 0;
            while (true) {
                String headerFieldKey = httpURLConnection.getHeaderFieldKey(i2);
                String headerField = httpURLConnection.getHeaderField(i2);
                if (headerFieldKey == null && headerField == null) {
                    return linkedHashMap;
                }
                i2++;
                if (!(headerFieldKey == null || headerField == null)) {
                    if (linkedHashMap.containsKey(headerFieldKey)) {
                        linkedHashMap.get(headerFieldKey).add(headerField);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(headerField);
                        linkedHashMap.put(headerFieldKey, arrayList);
                    }
                }
            }
        }

        static Response b0(Connection.Request request) throws IOException {
            return c0(request, (Response) null);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.util.zip.GZIPInputStream} */
        /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.String, java.io.InputStream] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x007c A[Catch:{ all -> 0x0194, all -> 0x0084 }] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00a1 A[Catch:{ all -> 0x0194, all -> 0x0084 }] */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0111  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static org.jsoup.helper.HttpConnection.Response c0(org.jsoup.Connection.Request r6, org.jsoup.helper.HttpConnection.Response r7) throws java.io.IOException {
            /*
                java.lang.String r0 = "Location"
                java.lang.String r1 = "Request must not be null"
                org.jsoup.helper.Validate.k(r6, r1)
                java.net.URL r1 = r6.y()
                java.lang.String r1 = r1.getProtocol()
                java.lang.String r2 = "http"
                boolean r2 = r1.equals(r2)
                if (r2 != 0) goto L_0x0028
                java.lang.String r2 = "https"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0020
                goto L_0x0028
            L_0x0020:
                java.net.MalformedURLException r6 = new java.net.MalformedURLException
                java.lang.String r7 = "Only http & https protocols supported"
                r6.<init>(r7)
                throw r6
            L_0x0028:
                org.jsoup.Connection$Method r1 = r6.A()
                boolean r1 = r1.a()
                java.lang.String r2 = r6.P()
                r3 = 1
                if (r2 == 0) goto L_0x0039
                r2 = 1
                goto L_0x003a
            L_0x0039:
                r2 = 0
            L_0x003a:
                if (r1 != 0) goto L_0x0054
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "Cannot set a request body for HTTP method "
                r4.append(r5)
                org.jsoup.Connection$Method r5 = r6.A()
                r4.append(r5)
                java.lang.String r4 = r4.toString()
                org.jsoup.helper.Validate.c(r2, r4)
            L_0x0054:
                java.util.Collection r4 = r6.i()
                int r4 = r4.size()
                r5 = 0
                if (r4 <= 0) goto L_0x0067
                if (r1 == 0) goto L_0x0063
                if (r2 == 0) goto L_0x0067
            L_0x0063:
                h0(r6)
                goto L_0x006e
            L_0x0067:
                if (r1 == 0) goto L_0x006e
                java.lang.String r1 = i0(r6)
                goto L_0x006f
            L_0x006e:
                r1 = r5
            L_0x006f:
                java.net.HttpURLConnection r2 = Z(r6)
                r2.connect()     // Catch:{ all -> 0x0084 }
                boolean r4 = r2.getDoOutput()     // Catch:{ all -> 0x0084 }
                if (r4 == 0) goto L_0x0087
                java.io.OutputStream r4 = r2.getOutputStream()     // Catch:{ all -> 0x0084 }
                k0(r6, r4, r1)     // Catch:{ all -> 0x0084 }
                goto L_0x0087
            L_0x0084:
                r6 = move-exception
                goto L_0x01dd
            L_0x0087:
                int r1 = r2.getResponseCode()     // Catch:{ all -> 0x0084 }
                org.jsoup.helper.HttpConnection$Response r4 = new org.jsoup.helper.HttpConnection$Response     // Catch:{ all -> 0x0084 }
                r4.<init>(r7)     // Catch:{ all -> 0x0084 }
                r4.j0(r2, r7)     // Catch:{ all -> 0x0084 }
                r4.f31602l = r6     // Catch:{ all -> 0x0084 }
                boolean r7 = r4.v(r0)     // Catch:{ all -> 0x0084 }
                if (r7 == 0) goto L_0x0111
                boolean r7 = r6.I()     // Catch:{ all -> 0x0084 }
                if (r7 == 0) goto L_0x0111
                r7 = 307(0x133, float:4.3E-43)
                if (r1 == r7) goto L_0x00b9
                org.jsoup.Connection$Method r7 = org.jsoup.Connection.Method.GET     // Catch:{ all -> 0x0084 }
                r6.c(r7)     // Catch:{ all -> 0x0084 }
                java.util.Collection r7 = r6.i()     // Catch:{ all -> 0x0084 }
                r7.clear()     // Catch:{ all -> 0x0084 }
                r6.d(r5)     // Catch:{ all -> 0x0084 }
                java.lang.String r7 = "Content-Type"
                r6.L(r7)     // Catch:{ all -> 0x0084 }
            L_0x00b9:
                java.lang.String r7 = r4.M(r0)     // Catch:{ all -> 0x0084 }
                if (r7 == 0) goto L_0x00d4
                java.lang.String r0 = "http:/"
                boolean r0 = r7.startsWith(r0)     // Catch:{ all -> 0x0084 }
                if (r0 == 0) goto L_0x00d4
                r0 = 6
                char r1 = r7.charAt(r0)     // Catch:{ all -> 0x0084 }
                r3 = 47
                if (r1 == r3) goto L_0x00d4
                java.lang.String r7 = r7.substring(r0)     // Catch:{ all -> 0x0084 }
            L_0x00d4:
                java.net.URL r0 = r6.y()     // Catch:{ all -> 0x0084 }
                java.net.URL r7 = org.jsoup.helper.StringUtil.l(r0, r7)     // Catch:{ all -> 0x0084 }
                java.net.URL r7 = org.jsoup.helper.HttpConnection.M(r7)     // Catch:{ all -> 0x0084 }
                r6.r(r7)     // Catch:{ all -> 0x0084 }
                java.util.Map<java.lang.String, java.lang.String> r7 = r4.f31579d     // Catch:{ all -> 0x0084 }
                java.util.Set r7 = r7.entrySet()     // Catch:{ all -> 0x0084 }
                java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x0084 }
            L_0x00ed:
                boolean r0 = r7.hasNext()     // Catch:{ all -> 0x0084 }
                if (r0 == 0) goto L_0x0109
                java.lang.Object r0 = r7.next()     // Catch:{ all -> 0x0084 }
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0084 }
                java.lang.Object r1 = r0.getKey()     // Catch:{ all -> 0x0084 }
                java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0084 }
                java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x0084 }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0084 }
                r6.f(r1, r0)     // Catch:{ all -> 0x0084 }
                goto L_0x00ed
            L_0x0109:
                org.jsoup.helper.HttpConnection$Response r6 = c0(r6, r4)     // Catch:{ all -> 0x0084 }
                r2.disconnect()
                return r6
            L_0x0111:
                r7 = 200(0xc8, float:2.8E-43)
                if (r1 < r7) goto L_0x0119
                r7 = 400(0x190, float:5.6E-43)
                if (r1 < r7) goto L_0x011f
            L_0x0119:
                boolean r7 = r6.s()     // Catch:{ all -> 0x0084 }
                if (r7 == 0) goto L_0x01cd
            L_0x011f:
                java.lang.String r7 = r4.D()     // Catch:{ all -> 0x0084 }
                if (r7 == 0) goto L_0x0150
                boolean r0 = r6.x()     // Catch:{ all -> 0x0084 }
                if (r0 != 0) goto L_0x0150
                java.lang.String r0 = "text/"
                boolean r0 = r7.startsWith(r0)     // Catch:{ all -> 0x0084 }
                if (r0 != 0) goto L_0x0150
                java.util.regex.Pattern r0 = p     // Catch:{ all -> 0x0084 }
                java.util.regex.Matcher r0 = r0.matcher(r7)     // Catch:{ all -> 0x0084 }
                boolean r0 = r0.matches()     // Catch:{ all -> 0x0084 }
                if (r0 == 0) goto L_0x0140
                goto L_0x0150
            L_0x0140:
                org.jsoup.UnsupportedMimeTypeException r0 = new org.jsoup.UnsupportedMimeTypeException     // Catch:{ all -> 0x0084 }
                java.lang.String r1 = "Unhandled content type. Must be text/*, application/xml, or application/xhtml+xml"
                java.net.URL r6 = r6.y()     // Catch:{ all -> 0x0084 }
                java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0084 }
                r0.<init>(r1, r7, r6)     // Catch:{ all -> 0x0084 }
                throw r0     // Catch:{ all -> 0x0084 }
            L_0x0150:
                if (r7 == 0) goto L_0x0172
                java.util.regex.Pattern r0 = p     // Catch:{ all -> 0x0084 }
                java.util.regex.Matcher r7 = r0.matcher(r7)     // Catch:{ all -> 0x0084 }
                boolean r7 = r7.matches()     // Catch:{ all -> 0x0084 }
                if (r7 == 0) goto L_0x0172
                boolean r7 = r6 instanceof org.jsoup.helper.HttpConnection.Request     // Catch:{ all -> 0x0084 }
                if (r7 == 0) goto L_0x0172
                r7 = r6
                org.jsoup.helper.HttpConnection$Request r7 = (org.jsoup.helper.HttpConnection.Request) r7     // Catch:{ all -> 0x0084 }
                boolean r7 = r7.f31592n     // Catch:{ all -> 0x0084 }
                if (r7 != 0) goto L_0x0172
                org.jsoup.parser.Parser r7 = org.jsoup.parser.Parser.q()     // Catch:{ all -> 0x0084 }
                r6.q(r7)     // Catch:{ all -> 0x0084 }
            L_0x0172:
                java.lang.String r7 = r4.f31599i     // Catch:{ all -> 0x0084 }
                java.lang.String r7 = org.jsoup.helper.DataUtil.d(r7)     // Catch:{ all -> 0x0084 }
                r4.f31598h = r7     // Catch:{ all -> 0x0084 }
                int r7 = r2.getContentLength()     // Catch:{ all -> 0x0084 }
                if (r7 == 0) goto L_0x01c1
                org.jsoup.Connection$Method r7 = r6.A()     // Catch:{ all -> 0x0084 }
                org.jsoup.Connection$Method r0 = org.jsoup.Connection.Method.HEAD     // Catch:{ all -> 0x0084 }
                if (r7 == r0) goto L_0x01c1
                java.io.InputStream r7 = r2.getErrorStream()     // Catch:{ all -> 0x0194 }
                if (r7 == 0) goto L_0x0196
                java.io.InputStream r7 = r2.getErrorStream()     // Catch:{ all -> 0x0194 }
            L_0x0192:
                r5 = r7
                goto L_0x019b
            L_0x0194:
                r6 = move-exception
                goto L_0x01bb
            L_0x0196:
                java.io.InputStream r7 = r2.getInputStream()     // Catch:{ all -> 0x0194 }
                goto L_0x0192
            L_0x019b:
                java.lang.String r7 = "Content-Encoding"
                java.lang.String r0 = "gzip"
                boolean r7 = r4.z(r7, r0)     // Catch:{ all -> 0x0194 }
                if (r7 == 0) goto L_0x01ab
                java.util.zip.GZIPInputStream r7 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x0194 }
                r7.<init>(r5)     // Catch:{ all -> 0x0194 }
                r5 = r7
            L_0x01ab:
                int r6 = r6.Q()     // Catch:{ all -> 0x0194 }
                java.nio.ByteBuffer r6 = org.jsoup.helper.DataUtil.l(r5, r6)     // Catch:{ all -> 0x0194 }
                r4.f31597g = r6     // Catch:{ all -> 0x0194 }
                if (r5 == 0) goto L_0x01c7
                r5.close()     // Catch:{ all -> 0x0084 }
                goto L_0x01c7
            L_0x01bb:
                if (r5 == 0) goto L_0x01c0
                r5.close()     // Catch:{ all -> 0x0084 }
            L_0x01c0:
                throw r6     // Catch:{ all -> 0x0084 }
            L_0x01c1:
                java.nio.ByteBuffer r6 = org.jsoup.helper.DataUtil.c()     // Catch:{ all -> 0x0084 }
                r4.f31597g = r6     // Catch:{ all -> 0x0084 }
            L_0x01c7:
                r2.disconnect()
                r4.f31600j = r3
                return r4
            L_0x01cd:
                org.jsoup.HttpStatusException r7 = new org.jsoup.HttpStatusException     // Catch:{ all -> 0x0084 }
                java.lang.String r0 = "HTTP error fetching URL"
                java.net.URL r6 = r6.y()     // Catch:{ all -> 0x0084 }
                java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0084 }
                r7.<init>(r0, r1, r6)     // Catch:{ all -> 0x0084 }
                throw r7     // Catch:{ all -> 0x0084 }
            L_0x01dd:
                r2.disconnect()
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Response.c0(org.jsoup.Connection$Request, org.jsoup.helper.HttpConnection$Response):org.jsoup.helper.HttpConnection$Response");
        }

        private static HostnameVerifier d0() {
            return new HostnameVerifier() {
                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            };
        }

        private static String e0(Connection.Request request) {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (Map.Entry next : request.G().entrySet()) {
                if (!z) {
                    sb.append("; ");
                } else {
                    z = false;
                }
                sb.append((String) next.getKey());
                sb.append(ASCIIPropertyListParser.f18654l);
                sb.append((String) next.getValue());
            }
            return sb.toString();
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static synchronized void f0() throws java.io.IOException {
            /*
                java.lang.Class<org.jsoup.helper.HttpConnection$Response> r0 = org.jsoup.helper.HttpConnection.Response.class
                monitor-enter(r0)
                javax.net.ssl.SSLSocketFactory r1 = f31594n     // Catch:{ all -> 0x0028 }
                if (r1 != 0) goto L_0x003a
                org.jsoup.helper.HttpConnection$Response$2 r1 = new org.jsoup.helper.HttpConnection$Response$2     // Catch:{ all -> 0x0028 }
                r1.<init>()     // Catch:{ all -> 0x0028 }
                r2 = 1
                javax.net.ssl.TrustManager[] r2 = new javax.net.ssl.TrustManager[r2]     // Catch:{ all -> 0x0028 }
                r3 = 0
                r2[r3] = r1     // Catch:{ all -> 0x0028 }
                java.lang.String r1 = "SSL"
                javax.net.ssl.SSLContext r1 = javax.net.ssl.SSLContext.getInstance(r1)     // Catch:{ NoSuchAlgorithmException -> 0x0032, KeyManagementException -> 0x002a }
                java.security.SecureRandom r3 = new java.security.SecureRandom     // Catch:{ NoSuchAlgorithmException -> 0x0032, KeyManagementException -> 0x002a }
                r3.<init>()     // Catch:{ NoSuchAlgorithmException -> 0x0032, KeyManagementException -> 0x002a }
                r4 = 0
                r1.init(r4, r2, r3)     // Catch:{ NoSuchAlgorithmException -> 0x0032, KeyManagementException -> 0x002a }
                javax.net.ssl.SSLSocketFactory r1 = r1.getSocketFactory()     // Catch:{ NoSuchAlgorithmException -> 0x0032, KeyManagementException -> 0x002a }
                f31594n = r1     // Catch:{ NoSuchAlgorithmException -> 0x0032, KeyManagementException -> 0x002a }
                goto L_0x003a
            L_0x0028:
                r1 = move-exception
                goto L_0x003c
            L_0x002a:
                java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x0028 }
                java.lang.String r2 = "Can't create unsecure trust manager"
                r1.<init>(r2)     // Catch:{ all -> 0x0028 }
                throw r1     // Catch:{ all -> 0x0028 }
            L_0x0032:
                java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x0028 }
                java.lang.String r2 = "Can't create unsecure trust manager"
                r1.<init>(r2)     // Catch:{ all -> 0x0028 }
                throw r1     // Catch:{ all -> 0x0028 }
            L_0x003a:
                monitor-exit(r0)
                return
            L_0x003c:
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Response.f0():void");
        }

        private static void h0(Connection.Request request) throws IOException {
            boolean z;
            URL y = request.y();
            StringBuilder sb = new StringBuilder();
            sb.append(y.getProtocol());
            sb.append("://");
            sb.append(y.getAuthority());
            sb.append(y.getPath());
            sb.append("?");
            if (y.getQuery() != null) {
                sb.append(y.getQuery());
                z = false;
            } else {
                z = true;
            }
            for (Connection.KeyVal next : request.i()) {
                Validate.c(next.e(), "InputStream data not supported in URL query string.");
                if (!z) {
                    sb.append(Typography.f29117d);
                } else {
                    z = false;
                }
                sb.append(URLEncoder.encode(next.d(), "UTF-8"));
                sb.append(ASCIIPropertyListParser.f18654l);
                sb.append(URLEncoder.encode(next.value(), "UTF-8"));
            }
            request.r(new URL(sb.toString()));
            request.i().clear();
        }

        private static String i0(Connection.Request request) {
            if (!request.v("Content-Type")) {
                if (HttpConnection.N(request)) {
                    String h2 = DataUtil.h();
                    request.a("Content-Type", "multipart/form-data; boundary=" + h2);
                    return h2;
                }
                request.a("Content-Type", "application/x-www-form-urlencoded; charset=" + request.t());
            }
            return null;
        }

        private void j0(HttpURLConnection httpURLConnection, Connection.Response response) throws IOException {
            this.f31577b = Connection.Method.valueOf(httpURLConnection.getRequestMethod());
            this.f31576a = httpURLConnection.getURL();
            this.f31595e = httpURLConnection.getResponseCode();
            this.f31596f = httpURLConnection.getResponseMessage();
            this.f31599i = httpURLConnection.getContentType();
            g0(a0(httpURLConnection));
            if (response != null) {
                for (Map.Entry next : response.G().entrySet()) {
                    if (!K((String) next.getKey())) {
                        f((String) next.getKey(), (String) next.getValue());
                    }
                }
            }
        }

        private static void k0(Connection.Request request, OutputStream outputStream, String str) throws IOException {
            Collection<Connection.KeyVal> i2 = request.i();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, request.t()));
            if (str != null) {
                for (Connection.KeyVal next : i2) {
                    bufferedWriter.write("--");
                    bufferedWriter.write(str);
                    bufferedWriter.write("\r\n");
                    bufferedWriter.write("Content-Disposition: form-data; name=\"");
                    bufferedWriter.write(HttpConnection.K(next.d()));
                    bufferedWriter.write("\"");
                    if (next.e()) {
                        bufferedWriter.write("; filename=\"");
                        bufferedWriter.write(HttpConnection.K(next.value()));
                        bufferedWriter.write("\"\r\nContent-Type: application/octet-stream\r\n\r\n");
                        bufferedWriter.flush();
                        DataUtil.a(next.z(), outputStream);
                        outputStream.flush();
                    } else {
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.write(next.value());
                    }
                    bufferedWriter.write("\r\n");
                }
                bufferedWriter.write("--");
                bufferedWriter.write(str);
                bufferedWriter.write("--");
            } else if (request.P() != null) {
                bufferedWriter.write(request.P());
            } else {
                boolean z = true;
                for (Connection.KeyVal next2 : i2) {
                    if (!z) {
                        bufferedWriter.append(Typography.f29117d);
                    } else {
                        z = false;
                    }
                    bufferedWriter.write(URLEncoder.encode(next2.d(), request.t()));
                    bufferedWriter.write(61);
                    bufferedWriter.write(URLEncoder.encode(next2.value(), request.t()));
                }
            }
            bufferedWriter.close();
        }

        public /* bridge */ /* synthetic */ Connection.Method A() {
            return super.A();
        }

        public String D() {
            return this.f31599i;
        }

        public /* bridge */ /* synthetic */ Map G() {
            return super.G();
        }

        public /* bridge */ /* synthetic */ String H(String str) {
            return super.H(str);
        }

        public Document J() throws IOException {
            Validate.e(this.f31600j, "Request must be executed (with .execute(), .get(), or .post() before parsing response");
            Document i2 = DataUtil.i(this.f31597g, this.f31598h, this.f31576a.toExternalForm(), this.f31602l.T());
            this.f31597g.rewind();
            this.f31598h = i2.z3().a().name();
            return i2;
        }

        public /* bridge */ /* synthetic */ boolean K(String str) {
            return super.K(str);
        }

        public /* bridge */ /* synthetic */ String M(String str) {
            return super.M(str);
        }

        public /* bridge */ /* synthetic */ Map N() {
            return super.N();
        }

        public int O() {
            return this.f31595e;
        }

        public String R() {
            return this.f31596f;
        }

        public byte[] S() {
            Validate.e(this.f31600j, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
            return this.f31597g.array();
        }

        /* renamed from: Y */
        public Response E(String str) {
            this.f31598h = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public void g0(Map<String, List<String>> map) {
            String sb;
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                if (str != null) {
                    List<String> list = (List) next.getValue();
                    if (str.equalsIgnoreCase(HttpHeaders.F0)) {
                        for (String str2 : list) {
                            if (str2 != null) {
                                TokenQueue tokenQueue = new TokenQueue(str2);
                                String trim = tokenQueue.e("=").trim();
                                String trim2 = tokenQueue.m(";").trim();
                                if (trim.length() > 0) {
                                    f(trim, trim2);
                                }
                            }
                        }
                    } else {
                        if (list.size() == 1) {
                            sb = (String) list.get(0);
                        } else if (list.size() > 1) {
                            StringBuilder sb2 = new StringBuilder();
                            for (int i2 = 0; i2 < list.size(); i2++) {
                                String str3 = (String) list.get(i2);
                                if (i2 != 0) {
                                    sb2.append(", ");
                                }
                                sb2.append(str3);
                            }
                            sb = sb2.toString();
                        }
                        a(str, sb);
                    }
                }
            }
        }

        public String k() {
            Validate.e(this.f31600j, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
            String str = this.f31598h;
            if (str == null) {
                str = "UTF-8";
            }
            String charBuffer = Charset.forName(str).decode(this.f31597g).toString();
            this.f31597g.rewind();
            return charBuffer;
        }

        public /* bridge */ /* synthetic */ boolean v(String str) {
            return super.v(str);
        }

        public String w() {
            return this.f31598h;
        }

        public /* bridge */ /* synthetic */ URL y() {
            return super.y();
        }

        public /* bridge */ /* synthetic */ boolean z(String str, String str2) {
            return super.z(str, str2);
        }

        private Response(Response response) throws IOException {
            super();
            if (response != null) {
                int i2 = response.f31601k + 1;
                this.f31601k = i2;
                if (i2 >= 20) {
                    throw new IOException(String.format("Too many redirects occurred trying to load URL %s", new Object[]{response.y()}));
                }
            }
        }
    }

    private HttpConnection() {
    }

    public static Connection I(String str) {
        HttpConnection httpConnection = new HttpConnection();
        httpConnection.u(str);
        return httpConnection;
    }

    public static Connection J(URL url) {
        HttpConnection httpConnection = new HttpConnection();
        httpConnection.r(url);
        return httpConnection;
    }

    /* access modifiers changed from: private */
    public static String K(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("\"", "%22");
    }

    private static String L(String str) {
        try {
            return M(new URL(str)).toExternalForm();
        } catch (Exception unused) {
            return str;
        }
    }

    /* access modifiers changed from: private */
    public static URL M(URL url) {
        try {
            return new URL(new URI(url.toExternalForm()).toASCIIString());
        } catch (Exception unused) {
            return url;
        }
    }

    /* access modifiers changed from: private */
    public static boolean N(Connection.Request request) {
        for (Connection.KeyVal e2 : request.i()) {
            if (e2.e()) {
                return true;
            }
        }
        return false;
    }

    public Connection A(Connection.Response response) {
        this.f31575b = response;
        return this;
    }

    public Document B() throws IOException {
        this.f31574a.c(Connection.Method.POST);
        execute();
        return this.f31575b.J();
    }

    public Connection C(String... strArr) {
        Validate.k(strArr, "Data key value pairs must not be null");
        Validate.e(strArr.length % 2 == 0, "Must supply an even number of key value pairs");
        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
            String str = strArr[i2];
            String str2 = strArr[i2 + 1];
            Validate.i(str, "Data key must not be empty");
            Validate.k(str2, "Data value must not be null");
            this.f31574a.F(KeyVal.f(str, str2));
        }
        return this;
    }

    public Connection.KeyVal D(String str) {
        Validate.i(str, "Data key must not be empty");
        for (Connection.KeyVal next : k().i()) {
            if (next.d().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public Connection E(Map<String, String> map) {
        Validate.k(map, "Data map must not be null");
        for (Map.Entry next : map.entrySet()) {
            this.f31574a.F(KeyVal.f((String) next.getKey(), (String) next.getValue()));
        }
        return this;
    }

    public Connection a(String str, String str2) {
        this.f31574a.a(str, str2);
        return this;
    }

    public Connection b(boolean z) {
        this.f31574a.b(z);
        return this;
    }

    public Connection c(Connection.Method method) {
        this.f31574a.c(method);
        return this;
    }

    public Connection d(String str) {
        this.f31574a.d(str);
        return this;
    }

    public Connection e(String str, int i2) {
        this.f31574a.e(str, i2);
        return this;
    }

    public Connection.Response execute() throws IOException {
        Response b0 = Response.b0(this.f31574a);
        this.f31575b = b0;
        return b0;
    }

    public Connection f(String str, String str2) {
        this.f31574a.f(str, str2);
        return this;
    }

    public Connection g(int i2) {
        this.f31574a.g(i2);
        return this;
    }

    public Document get() throws IOException {
        this.f31574a.c(Connection.Method.GET);
        execute();
        return this.f31575b.J();
    }

    public Connection h(int i2) {
        this.f31574a.h(i2);
        return this;
    }

    public Connection i(String str) {
        Validate.k(str, "User agent must not be null");
        this.f31574a.a("User-Agent", str);
        return this;
    }

    public Connection j(Collection<Connection.KeyVal> collection) {
        Validate.k(collection, "Data collection must not be null");
        for (Connection.KeyVal F : collection) {
            this.f31574a.F(F);
        }
        return this;
    }

    public Connection.Request k() {
        return this.f31574a;
    }

    public Connection l(boolean z) {
        this.f31574a.l(z);
        return this;
    }

    public Connection m(boolean z) {
        this.f31574a.m(z);
        return this;
    }

    public Connection n(String str) {
        this.f31574a.n(str);
        return this;
    }

    public Connection o(Proxy proxy) {
        this.f31574a.o(proxy);
        return this;
    }

    public Connection p(boolean z) {
        this.f31574a.p(z);
        return this;
    }

    public Connection q(Parser parser) {
        this.f31574a.q(parser);
        return this;
    }

    public Connection r(URL url) {
        this.f31574a.r(url);
        return this;
    }

    public Connection s(Map<String, String> map) {
        Validate.k(map, "Header map must not be null");
        for (Map.Entry next : map.entrySet()) {
            this.f31574a.a((String) next.getKey(), (String) next.getValue());
        }
        return this;
    }

    public Connection t(Connection.Request request) {
        this.f31574a = request;
        return this;
    }

    public Connection u(String str) {
        Validate.i(str, "Must supply a valid URL");
        try {
            this.f31574a.r(new URL(L(str)));
            return this;
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException("Malformed URL: " + str, e2);
        }
    }

    public Connection.Response v() {
        return this.f31575b;
    }

    public Connection w(String str, String str2) {
        this.f31574a.F(KeyVal.f(str, str2));
        return this;
    }

    public Connection x(String str) {
        Validate.k(str, "Referrer must not be null");
        this.f31574a.a(HttpHeaders.J, str);
        return this;
    }

    public Connection y(Map<String, String> map) {
        Validate.k(map, "Cookie map must not be null");
        for (Map.Entry next : map.entrySet()) {
            this.f31574a.f((String) next.getKey(), (String) next.getValue());
        }
        return this;
    }

    public Connection z(String str, String str2, InputStream inputStream) {
        this.f31574a.F(KeyVal.g(str, str2, inputStream));
        return this;
    }
}
