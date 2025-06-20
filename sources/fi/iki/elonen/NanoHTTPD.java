package fi.iki.elonen;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.net.HttpHeaders;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.lang3.StringUtils;

public abstract class NanoHTTPD {

    /* renamed from: h  reason: collision with root package name */
    private static final String f28273h = "([ |\t]*Content-Disposition[ |\t]*:)(.*)";
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final Pattern f28274i = Pattern.compile(f28273h, 2);

    /* renamed from: j  reason: collision with root package name */
    private static final String f28275j = "([ |\t]*content-type[ |\t]*:)(.*)";
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final Pattern f28276k = Pattern.compile(f28275j, 2);

    /* renamed from: l  reason: collision with root package name */
    private static final String f28277l = "[ |\t]*([a-zA-Z]*)[ |\t]*=[ |\t]*['|\"]([^\"^']*)['|\"]";
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final Pattern f28278m = Pattern.compile(f28277l);

    /* renamed from: n  reason: collision with root package name */
    public static final int f28279n = 5000;
    public static final String o = "text/plain";
    public static final String p = "text/html";
    private static final String q = "NanoHttpd.QUERY_STRING";
    /* access modifiers changed from: private */
    public static final Logger r = Logger.getLogger(NanoHTTPD.class.getName());
    protected static Map<String, String> s;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f28280a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f28281b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public volatile ServerSocket f28282c;

    /* renamed from: d  reason: collision with root package name */
    private ServerSocketFactory f28283d;

    /* renamed from: e  reason: collision with root package name */
    private Thread f28284e;

    /* renamed from: f  reason: collision with root package name */
    protected AsyncRunner f28285f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TempFileManagerFactory f28286g;

    public interface AsyncRunner {
        void a();

        void b(ClientHandler clientHandler);

        void c(ClientHandler clientHandler);
    }

    public class ClientHandler implements Runnable {
        private final Socket X;
        private final InputStream s;

        public ClientHandler(InputStream inputStream, Socket socket) {
            this.s = inputStream;
            this.X = socket;
        }

        public void a() {
            NanoHTTPD.F(this.s);
            NanoHTTPD.F(this.X);
        }

        public void run() {
            OutputStream outputStream = null;
            try {
                outputStream = this.X.getOutputStream();
                HTTPSession hTTPSession = new HTTPSession(NanoHTTPD.this.f28286g.a(), this.s, outputStream, this.X.getInetAddress());
                while (!this.X.isClosed()) {
                    hTTPSession.execute();
                }
            } catch (Exception e2) {
                if ((!(e2 instanceof SocketException) || !"NanoHttpd Shutdown".equals(e2.getMessage())) && !(e2 instanceof SocketTimeoutException)) {
                    NanoHTTPD.r.log(Level.SEVERE, "Communication with the client broken, or an bug in the handler code", e2);
                }
            } catch (Throwable th) {
                NanoHTTPD.F((Object) null);
                NanoHTTPD.F(this.s);
                NanoHTTPD.F(this.X);
                NanoHTTPD.this.f28285f.c(this);
                throw th;
            }
            NanoHTTPD.F(outputStream);
            NanoHTTPD.F(this.s);
            NanoHTTPD.F(this.X);
            NanoHTTPD.this.f28285f.c(this);
        }
    }

    protected static class ContentType {

        /* renamed from: e  reason: collision with root package name */
        private static final String f28287e = "US-ASCII";

        /* renamed from: f  reason: collision with root package name */
        private static final String f28288f = "multipart/form-data";

        /* renamed from: g  reason: collision with root package name */
        private static final String f28289g = "[ |\t]*([^/^ ^;^,]+/[^ ^;^,]+)";

        /* renamed from: h  reason: collision with root package name */
        private static final Pattern f28290h = Pattern.compile(f28289g, 2);

        /* renamed from: i  reason: collision with root package name */
        private static final String f28291i = "[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?";

        /* renamed from: j  reason: collision with root package name */
        private static final Pattern f28292j = Pattern.compile(f28291i, 2);

        /* renamed from: k  reason: collision with root package name */
        private static final String f28293k = "[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?";

        /* renamed from: l  reason: collision with root package name */
        private static final Pattern f28294l = Pattern.compile(f28293k, 2);

        /* renamed from: a  reason: collision with root package name */
        private final String f28295a;

        /* renamed from: b  reason: collision with root package name */
        private final String f28296b;

        /* renamed from: c  reason: collision with root package name */
        private final String f28297c;

        /* renamed from: d  reason: collision with root package name */
        private final String f28298d;

        public ContentType(String str) {
            String str2;
            this.f28295a = str;
            if (str != null) {
                this.f28296b = d(str, f28290h, "", 1);
                str2 = d(str, f28292j, (String) null, 2);
            } else {
                this.f28296b = "";
                str2 = "UTF-8";
            }
            this.f28297c = str2;
            if ("multipart/form-data".equalsIgnoreCase(this.f28296b)) {
                this.f28298d = d(str, f28294l, (String) null, 2);
            } else {
                this.f28298d = null;
            }
        }

        private String d(String str, Pattern pattern, String str2, int i2) {
            Matcher matcher = pattern.matcher(str);
            return matcher.find() ? matcher.group(i2) : str2;
        }

        public String a() {
            return this.f28298d;
        }

        public String b() {
            return this.f28296b;
        }

        public String c() {
            return this.f28295a;
        }

        public String e() {
            String str = this.f28297c;
            return str == null ? "US-ASCII" : str;
        }

        public boolean f() {
            return "multipart/form-data".equalsIgnoreCase(this.f28296b);
        }

        public ContentType g() {
            if (this.f28297c != null) {
                return this;
            }
            return new ContentType(this.f28295a + "; charset=UTF-8");
        }
    }

    public static class Cookie {

        /* renamed from: a  reason: collision with root package name */
        private final String f28299a;

        /* renamed from: b  reason: collision with root package name */
        private final String f28300b;

        /* renamed from: c  reason: collision with root package name */
        private final String f28301c;

        public Cookie(String str, String str2) {
            this(str, str2, 30);
        }

        public static String b(int i2) {
            Calendar instance = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            instance.add(5, i2);
            return simpleDateFormat.format(instance.getTime());
        }

        public String a() {
            return String.format("%s=%s; expires=%s", new Object[]{this.f28299a, this.f28300b, this.f28301c});
        }

        public Cookie(String str, String str2, int i2) {
            this.f28299a = str;
            this.f28300b = str2;
            this.f28301c = b(i2);
        }

        public Cookie(String str, String str2, String str3) {
            this.f28299a = str;
            this.f28300b = str2;
            this.f28301c = str3;
        }
    }

    public class CookieHandler implements Iterable<String> {
        private final ArrayList<Cookie> X = new ArrayList<>();
        private final HashMap<String, String> s = new HashMap<>();

        public CookieHandler(Map<String, String> map) {
            String str = map.get("cookie");
            if (str != null) {
                for (String trim : str.split(";")) {
                    String[] split = trim.trim().split("=");
                    if (split.length == 2) {
                        this.s.put(split[0], split[1]);
                    }
                }
            }
        }

        public void b(String str) {
            g(str, "-delete-", -30);
        }

        public String c(String str) {
            return this.s.get(str);
        }

        public void d(Cookie cookie) {
            this.X.add(cookie);
        }

        public void g(String str, String str2, int i2) {
            this.X.add(new Cookie(str, str2, Cookie.b(i2)));
        }

        public void h(Response response) {
            Iterator<Cookie> it2 = this.X.iterator();
            while (it2.hasNext()) {
                response.c(HttpHeaders.F0, it2.next().a());
            }
        }

        public Iterator<String> iterator() {
            return this.s.keySet().iterator();
        }
    }

    public static class DefaultAsyncRunner implements AsyncRunner {

        /* renamed from: a  reason: collision with root package name */
        private long f28302a;

        /* renamed from: b  reason: collision with root package name */
        private final List<ClientHandler> f28303b = Collections.synchronizedList(new ArrayList());

        public void a() {
            Iterator it2 = new ArrayList(this.f28303b).iterator();
            while (it2.hasNext()) {
                ((ClientHandler) it2.next()).a();
            }
        }

        public void b(ClientHandler clientHandler) {
            this.f28302a++;
            Thread thread = new Thread(clientHandler);
            thread.setDaemon(true);
            thread.setName("NanoHttpd Request Processor (#" + this.f28302a + ")");
            this.f28303b.add(clientHandler);
            thread.start();
        }

        public void c(ClientHandler clientHandler) {
            this.f28303b.remove(clientHandler);
        }

        public List<ClientHandler> d() {
            return this.f28303b;
        }
    }

    public static class DefaultServerSocketFactory implements ServerSocketFactory {
        public ServerSocket a() throws IOException {
            return new ServerSocket();
        }
    }

    public static class DefaultTempFile implements TempFile {

        /* renamed from: a  reason: collision with root package name */
        private final File f28304a;

        /* renamed from: b  reason: collision with root package name */
        private final OutputStream f28305b;

        public DefaultTempFile(File file) throws IOException {
            File createTempFile = File.createTempFile("NanoHTTPD-", "", file);
            this.f28304a = createTempFile;
            this.f28305b = new FileOutputStream(createTempFile);
        }

        public void a() throws Exception {
            NanoHTTPD.F(this.f28305b);
            if (!this.f28304a.delete()) {
                throw new Exception("could not delete temporary file: " + this.f28304a.getAbsolutePath());
            }
        }

        public String getName() {
            return this.f28304a.getAbsolutePath();
        }

        public OutputStream open() throws Exception {
            return this.f28305b;
        }
    }

    public static class DefaultTempFileManager implements TempFileManager {

        /* renamed from: a  reason: collision with root package name */
        private final File f28306a;

        /* renamed from: b  reason: collision with root package name */
        private final List<TempFile> f28307b;

        public DefaultTempFileManager() {
            File file = new File(System.getProperty("java.io.tmpdir"));
            this.f28306a = file;
            if (!file.exists()) {
                file.mkdirs();
            }
            this.f28307b = new ArrayList();
        }

        public TempFile a(String str) throws Exception {
            DefaultTempFile defaultTempFile = new DefaultTempFile(this.f28306a);
            this.f28307b.add(defaultTempFile);
            return defaultTempFile;
        }

        public void clear() {
            for (TempFile a2 : this.f28307b) {
                try {
                    a2.a();
                } catch (Exception e2) {
                    NanoHTTPD.r.log(Level.WARNING, "could not delete file ", e2);
                }
            }
            this.f28307b.clear();
        }
    }

    private class DefaultTempFileManagerFactory implements TempFileManagerFactory {
        private DefaultTempFileManagerFactory() {
        }

        public TempFileManager a() {
            return new DefaultTempFileManager();
        }
    }

    protected class HTTPSession implements IHTTPSession {
        private static final int p = 512;
        private static final int q = 1024;
        public static final int r = 8192;
        public static final int s = 1024;

        /* renamed from: a  reason: collision with root package name */
        private final TempFileManager f28309a;

        /* renamed from: b  reason: collision with root package name */
        private final OutputStream f28310b;

        /* renamed from: c  reason: collision with root package name */
        private final BufferedInputStream f28311c;

        /* renamed from: d  reason: collision with root package name */
        private int f28312d;

        /* renamed from: e  reason: collision with root package name */
        private int f28313e;

        /* renamed from: f  reason: collision with root package name */
        private String f28314f;

        /* renamed from: g  reason: collision with root package name */
        private Method f28315g;

        /* renamed from: h  reason: collision with root package name */
        private Map<String, List<String>> f28316h;

        /* renamed from: i  reason: collision with root package name */
        private Map<String, String> f28317i;

        /* renamed from: j  reason: collision with root package name */
        private CookieHandler f28318j;

        /* renamed from: k  reason: collision with root package name */
        private String f28319k;

        /* renamed from: l  reason: collision with root package name */
        private String f28320l;

        /* renamed from: m  reason: collision with root package name */
        private String f28321m;

        /* renamed from: n  reason: collision with root package name */
        private String f28322n;

        public HTTPSession(TempFileManager tempFileManager, InputStream inputStream, OutputStream outputStream) {
            this.f28309a = tempFileManager;
            this.f28311c = new BufferedInputStream(inputStream, 8192);
            this.f28310b = outputStream;
        }

        /* JADX WARNING: CFG modification limit reached, blocks count: 137 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void b(java.io.BufferedReader r6, java.util.Map<java.lang.String, java.lang.String> r7, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r8, java.util.Map<java.lang.String, java.lang.String> r9) throws fi.iki.elonen.NanoHTTPD.ResponseException {
            /*
                r5 = this;
                java.lang.String r0 = r6.readLine()     // Catch:{ IOException -> 0x0040 }
                if (r0 != 0) goto L_0x0007
                return
            L_0x0007:
                java.util.StringTokenizer r1 = new java.util.StringTokenizer     // Catch:{ IOException -> 0x0040 }
                r1.<init>(r0)     // Catch:{ IOException -> 0x0040 }
                boolean r0 = r1.hasMoreTokens()     // Catch:{ IOException -> 0x0040 }
                if (r0 == 0) goto L_0x00a7
                java.lang.String r0 = "method"
                java.lang.String r2 = r1.nextToken()     // Catch:{ IOException -> 0x0040 }
                r7.put(r0, r2)     // Catch:{ IOException -> 0x0040 }
                boolean r0 = r1.hasMoreTokens()     // Catch:{ IOException -> 0x0040 }
                if (r0 == 0) goto L_0x009d
                java.lang.String r0 = r1.nextToken()     // Catch:{ IOException -> 0x0040 }
                r2 = 63
                int r2 = r0.indexOf(r2)     // Catch:{ IOException -> 0x0040 }
                r3 = 0
                if (r2 < 0) goto L_0x0042
                int r4 = r2 + 1
                java.lang.String r4 = r0.substring(r4)     // Catch:{ IOException -> 0x0040 }
                r5.e(r4, r8)     // Catch:{ IOException -> 0x0040 }
                java.lang.String r8 = r0.substring(r3, r2)     // Catch:{ IOException -> 0x0040 }
                java.lang.String r8 = fi.iki.elonen.NanoHTTPD.o(r8)     // Catch:{ IOException -> 0x0040 }
                goto L_0x0046
            L_0x0040:
                r6 = move-exception
                goto L_0x00b1
            L_0x0042:
                java.lang.String r8 = fi.iki.elonen.NanoHTTPD.o(r0)     // Catch:{ IOException -> 0x0040 }
            L_0x0046:
                boolean r0 = r1.hasMoreTokens()     // Catch:{ IOException -> 0x0040 }
                if (r0 == 0) goto L_0x0053
                java.lang.String r0 = r1.nextToken()     // Catch:{ IOException -> 0x0040 }
                r5.f28322n = r0     // Catch:{ IOException -> 0x0040 }
                goto L_0x0092
            L_0x0053:
                java.lang.String r0 = "HTTP/1.1"
                r5.f28322n = r0     // Catch:{ IOException -> 0x0040 }
                java.util.logging.Logger r0 = fi.iki.elonen.NanoHTTPD.r     // Catch:{ IOException -> 0x0040 }
                java.util.logging.Level r1 = java.util.logging.Level.FINE     // Catch:{ IOException -> 0x0040 }
                java.lang.String r2 = "no protocol version specified, strange. Assuming HTTP/1.1."
                r0.log(r1, r2)     // Catch:{ IOException -> 0x0040 }
                goto L_0x0092
            L_0x0063:
                if (r0 == 0) goto L_0x0097
                java.lang.String r1 = r0.trim()     // Catch:{ IOException -> 0x0040 }
                boolean r1 = r1.isEmpty()     // Catch:{ IOException -> 0x0040 }
                if (r1 != 0) goto L_0x0097
                r1 = 58
                int r1 = r0.indexOf(r1)     // Catch:{ IOException -> 0x0040 }
                if (r1 < 0) goto L_0x0092
                java.lang.String r2 = r0.substring(r3, r1)     // Catch:{ IOException -> 0x0040 }
                java.lang.String r2 = r2.trim()     // Catch:{ IOException -> 0x0040 }
                java.util.Locale r4 = java.util.Locale.US     // Catch:{ IOException -> 0x0040 }
                java.lang.String r2 = r2.toLowerCase(r4)     // Catch:{ IOException -> 0x0040 }
                int r1 = r1 + 1
                java.lang.String r0 = r0.substring(r1)     // Catch:{ IOException -> 0x0040 }
                java.lang.String r0 = r0.trim()     // Catch:{ IOException -> 0x0040 }
                r9.put(r2, r0)     // Catch:{ IOException -> 0x0040 }
            L_0x0092:
                java.lang.String r0 = r6.readLine()     // Catch:{ IOException -> 0x0040 }
                goto L_0x0063
            L_0x0097:
                java.lang.String r6 = "uri"
                r7.put(r6, r8)     // Catch:{ IOException -> 0x0040 }
                return
            L_0x009d:
                fi.iki.elonen.NanoHTTPD$ResponseException r6 = new fi.iki.elonen.NanoHTTPD$ResponseException     // Catch:{ IOException -> 0x0040 }
                fi.iki.elonen.NanoHTTPD$Response$Status r7 = fi.iki.elonen.NanoHTTPD.Response.Status.BAD_REQUEST     // Catch:{ IOException -> 0x0040 }
                java.lang.String r8 = "BAD REQUEST: Missing URI. Usage: GET /example/file.html"
                r6.<init>(r7, r8)     // Catch:{ IOException -> 0x0040 }
                throw r6     // Catch:{ IOException -> 0x0040 }
            L_0x00a7:
                fi.iki.elonen.NanoHTTPD$ResponseException r6 = new fi.iki.elonen.NanoHTTPD$ResponseException     // Catch:{ IOException -> 0x0040 }
                fi.iki.elonen.NanoHTTPD$Response$Status r7 = fi.iki.elonen.NanoHTTPD.Response.Status.BAD_REQUEST     // Catch:{ IOException -> 0x0040 }
                java.lang.String r8 = "BAD REQUEST: Syntax error. Usage: GET /example/file.html"
                r6.<init>(r7, r8)     // Catch:{ IOException -> 0x0040 }
                throw r6     // Catch:{ IOException -> 0x0040 }
            L_0x00b1:
                fi.iki.elonen.NanoHTTPD$ResponseException r7 = new fi.iki.elonen.NanoHTTPD$ResponseException
                fi.iki.elonen.NanoHTTPD$Response$Status r8 = fi.iki.elonen.NanoHTTPD.Response.Status.INTERNAL_ERROR
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r0 = "SERVER INTERNAL ERROR: IOException: "
                r9.append(r0)
                java.lang.String r0 = r6.getMessage()
                r9.append(r0)
                java.lang.String r9 = r9.toString()
                r7.<init>(r8, r9, r6)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: fi.iki.elonen.NanoHTTPD.HTTPSession.b(java.io.BufferedReader, java.util.Map, java.util.Map, java.util.Map):void");
        }

        private void d(ContentType contentType, ByteBuffer byteBuffer, Map<String, List<String>> map, Map<String, String> map2) throws ResponseException {
            String str;
            ByteBuffer byteBuffer2 = byteBuffer;
            Map<String, List<String>> map3 = map;
            Map<String, String> map4 = map2;
            try {
                int[] q2 = q(byteBuffer2, contentType.a().getBytes());
                int i2 = 2;
                if (q2.length >= 2) {
                    int i3 = 1024;
                    byte[] bArr = new byte[1024];
                    int i4 = 0;
                    int i5 = 0;
                    int i6 = 0;
                    while (true) {
                        int i7 = 1;
                        if (i5 < q2.length - 1) {
                            byteBuffer2.position(q2[i5]);
                            int remaining = byteBuffer.remaining() < i3 ? byteBuffer.remaining() : 1024;
                            byteBuffer2.get(bArr, i4, remaining);
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, i4, remaining), Charset.forName(contentType.e())), remaining);
                            String readLine = bufferedReader.readLine();
                            if (readLine != null && readLine.contains(contentType.a())) {
                                String readLine2 = bufferedReader.readLine();
                                String str2 = null;
                                String str3 = null;
                                String str4 = null;
                                int i8 = 2;
                                while (readLine2 != null && readLine2.trim().length() > 0) {
                                    Matcher matcher = NanoHTTPD.f28274i.matcher(readLine2);
                                    if (matcher.matches()) {
                                        Matcher matcher2 = NanoHTTPD.f28278m.matcher(matcher.group(i2));
                                        while (matcher2.find()) {
                                            String group = matcher2.group(i7);
                                            if ("name".equalsIgnoreCase(group)) {
                                                str = matcher2.group(2);
                                            } else {
                                                if ("filename".equalsIgnoreCase(group)) {
                                                    String group2 = matcher2.group(2);
                                                    if (!group2.isEmpty()) {
                                                        if (i6 > 0) {
                                                            str = str2 + String.valueOf(i6);
                                                            str3 = group2;
                                                            i6++;
                                                        } else {
                                                            i6++;
                                                        }
                                                    }
                                                    str3 = group2;
                                                }
                                                i7 = 1;
                                            }
                                            str2 = str;
                                            i7 = 1;
                                        }
                                    }
                                    Matcher matcher3 = NanoHTTPD.f28276k.matcher(readLine2);
                                    if (matcher3.matches()) {
                                        str4 = matcher3.group(2).trim();
                                    }
                                    readLine2 = bufferedReader.readLine();
                                    i8++;
                                    i2 = 2;
                                    i7 = 1;
                                }
                                int i9 = 0;
                                while (true) {
                                    int i10 = i8 - 1;
                                    if (i8 <= 0) {
                                        break;
                                    }
                                    i9 = t(bArr, i9);
                                    i8 = i10;
                                }
                                if (i9 < remaining - 4) {
                                    int i11 = q2[i5] + i9;
                                    i5++;
                                    int i12 = q2[i5] - 4;
                                    byteBuffer2.position(i11);
                                    List list = map3.get(str2);
                                    if (list == null) {
                                        list = new ArrayList();
                                        map3.put(str2, list);
                                    }
                                    int i13 = i12 - i11;
                                    if (str4 == null) {
                                        byte[] bArr2 = new byte[i13];
                                        byteBuffer2.get(bArr2);
                                        list.add(new String(bArr2, contentType.e()));
                                    } else {
                                        String s2 = s(byteBuffer2, i11, i13, str3);
                                        if (!map4.containsKey(str2)) {
                                            map4.put(str2, s2);
                                        } else {
                                            int i14 = 2;
                                            while (true) {
                                                if (!map4.containsKey(str2 + i14)) {
                                                    break;
                                                }
                                                i14++;
                                            }
                                            map4.put(str2 + i14, s2);
                                        }
                                        list.add(str3);
                                    }
                                    i3 = 1024;
                                    i2 = 2;
                                    i4 = 0;
                                } else {
                                    throw new ResponseException(Response.Status.INTERNAL_ERROR, "Multipart header size exceeds MAX_HEADER_SIZE.");
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but chunk does not start with boundary.");
                }
                throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but contains less than two boundary strings.");
            } catch (ResponseException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new ResponseException(Response.Status.INTERNAL_ERROR, e3.toString());
            }
        }

        private void e(String str, Map<String, List<String>> map) {
            String str2;
            String str3;
            if (str == null) {
                this.f28319k = "";
                return;
            }
            this.f28319k = str;
            StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf >= 0) {
                    str3 = NanoHTTPD.o(nextToken.substring(0, indexOf)).trim();
                    str2 = NanoHTTPD.o(nextToken.substring(indexOf + 1));
                } else {
                    str3 = NanoHTTPD.o(nextToken).trim();
                    str2 = "";
                }
                List list = map.get(str3);
                if (list == null) {
                    list = new ArrayList();
                    map.put(str3, list);
                }
                list.add(str2);
            }
        }

        private int f(byte[] bArr, int i2) {
            int i3;
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                if (i5 >= i2) {
                    return 0;
                }
                byte b2 = bArr[i4];
                if (b2 == 13 && bArr[i5] == 10 && (i3 = i4 + 3) < i2 && bArr[i4 + 2] == 13 && bArr[i3] == 10) {
                    return i4 + 4;
                }
                if (b2 == 10 && bArr[i5] == 10) {
                    return i4 + 2;
                }
                i4 = i5;
            }
        }

        private int[] q(ByteBuffer byteBuffer, byte[] bArr) {
            int[] iArr = new int[0];
            if (byteBuffer.remaining() < bArr.length) {
                return iArr;
            }
            int length = bArr.length + 4096;
            byte[] bArr2 = new byte[length];
            int remaining = byteBuffer.remaining() < length ? byteBuffer.remaining() : length;
            byteBuffer.get(bArr2, 0, remaining);
            int length2 = remaining - bArr.length;
            int i2 = 0;
            do {
                int i3 = 0;
                while (i3 < length2) {
                    int i4 = 0;
                    while (i4 < bArr.length && bArr2[i3 + i4] == bArr[i4]) {
                        if (i4 == bArr.length - 1) {
                            int[] iArr2 = new int[(iArr.length + 1)];
                            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                            iArr2[iArr.length] = i2 + i3;
                            iArr = iArr2;
                        }
                        i4++;
                    }
                    i3++;
                }
                i2 += length2;
                System.arraycopy(bArr2, length - bArr.length, bArr2, 0, bArr.length);
                length2 = length - bArr.length;
                if (byteBuffer.remaining() < length2) {
                    length2 = byteBuffer.remaining();
                }
                byteBuffer.get(bArr2, bArr.length, length2);
            } while (length2 > 0);
            return iArr;
        }

        private RandomAccessFile r() {
            try {
                return new RandomAccessFile(this.f28309a.a((String) null).getName(), "rw");
            } catch (Exception e2) {
                throw new Error(e2);
            }
        }

        private String s(ByteBuffer byteBuffer, int i2, int i3, String str) {
            if (i3 <= 0) {
                return "";
            }
            FileOutputStream fileOutputStream = null;
            try {
                TempFile a2 = this.f28309a.a(str);
                ByteBuffer duplicate = byteBuffer.duplicate();
                FileOutputStream fileOutputStream2 = new FileOutputStream(a2.getName());
                try {
                    FileChannel channel = fileOutputStream2.getChannel();
                    duplicate.position(i2).limit(i2 + i3);
                    channel.write(duplicate.slice());
                    String name = a2.getName();
                    NanoHTTPD.F(fileOutputStream2);
                    return name;
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    try {
                        throw new Error(e);
                    } catch (Throwable th) {
                        th = th;
                        NanoHTTPD.F(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    NanoHTTPD.F(fileOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                throw new Error(e);
            }
        }

        private int t(byte[] bArr, int i2) {
            byte b2;
            do {
                b2 = bArr[i2];
                i2++;
            } while (b2 != 10);
            return i2;
        }

        public final Map<String, String> a() {
            return this.f28317i;
        }

        public final String c() {
            return this.f28314f;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
            fi.iki.elonen.NanoHTTPD.D(r0.a(), "text/plain", r0.getMessage()).q(r10.f28310b);
            r0 = r10.f28310b;
         */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x003c A[Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c, SSLException -> 0x017a, IOException -> 0x017c, ResponseException -> 0x003c, all -> 0x0039 }, ExcHandler: ResponseException (r0v15 'e' fi.iki.elonen.NanoHTTPD$ResponseException A[CUSTOM_DECLARE, Catch:{  }]), PHI: r4 
          PHI: (r4v5 fi.iki.elonen.NanoHTTPD$Response) = (r4v0 fi.iki.elonen.NanoHTTPD$Response), (r4v0 fi.iki.elonen.NanoHTTPD$Response), (r4v0 fi.iki.elonen.NanoHTTPD$Response), (r4v6 fi.iki.elonen.NanoHTTPD$Response), (r4v0 fi.iki.elonen.NanoHTTPD$Response) binds: [B:1:0x0009, B:2:?, B:3:0x0015, B:57:0x0136, B:8:0x0020] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x0009] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() throws java.io.IOException {
            /*
                r10 = this;
                java.lang.String r0 = "method"
                java.lang.String r1 = "text/plain"
                java.lang.String r2 = "NanoHttpd Shutdown"
                r3 = 8192(0x2000, float:1.14794E-41)
                r4 = 0
                byte[] r5 = new byte[r3]     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r6 = 0
                r10.f28312d = r6     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r10.f28313e = r6     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.io.BufferedInputStream r7 = r10.f28311c     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r7.mark(r3)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.io.BufferedInputStream r7 = r10.f28311c     // Catch:{ SSLException -> 0x017a, IOException -> 0x017c, ResponseException -> 0x003c }
                int r3 = r7.read(r5, r6, r3)     // Catch:{ SSLException -> 0x017a, IOException -> 0x017c, ResponseException -> 0x003c }
                r7 = -1
                if (r3 == r7) goto L_0x016a
            L_0x001e:
                if (r3 <= 0) goto L_0x004b
                int r7 = r10.f28313e     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                int r7 = r7 + r3
                r10.f28313e = r7     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                int r3 = r10.f(r5, r7)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r10.f28312d = r3     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                if (r3 <= 0) goto L_0x002e
                goto L_0x004b
            L_0x002e:
                java.io.BufferedInputStream r3 = r10.f28311c     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                int r7 = r10.f28313e     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                int r8 = 8192 - r7
                int r3 = r3.read(r5, r7, r8)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                goto L_0x001e
            L_0x0039:
                r0 = move-exception
                goto L_0x01ed
            L_0x003c:
                r0 = move-exception
                goto L_0x018d
            L_0x003f:
                r0 = move-exception
                goto L_0x01a4
            L_0x0042:
                r0 = move-exception
                goto L_0x01c7
            L_0x0045:
                r0 = move-exception
                goto L_0x01eb
            L_0x0048:
                r0 = move-exception
                goto L_0x01ec
            L_0x004b:
                int r3 = r10.f28312d     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                int r7 = r10.f28313e     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                if (r3 >= r7) goto L_0x005e
                java.io.BufferedInputStream r3 = r10.f28311c     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r3.reset()     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.io.BufferedInputStream r3 = r10.f28311c     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                int r7 = r10.f28312d     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                long r7 = (long) r7     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r3.skip(r7)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
            L_0x005e:
                java.util.HashMap r3 = new java.util.HashMap     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r3.<init>()     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r10.f28316h = r3     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.util.Map<java.lang.String, java.lang.String> r3 = r10.f28317i     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                if (r3 != 0) goto L_0x0071
                java.util.HashMap r3 = new java.util.HashMap     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r3.<init>()     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r10.f28317i = r3     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                goto L_0x0074
            L_0x0071:
                r3.clear()     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
            L_0x0074:
                java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.io.ByteArrayInputStream r8 = new java.io.ByteArrayInputStream     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                int r9 = r10.f28313e     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r8.<init>(r5, r6, r9)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r7.<init>(r8)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r3.<init>(r7)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.util.HashMap r5 = new java.util.HashMap     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r5.<init>()     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7 = r10.f28316h     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.util.Map<java.lang.String, java.lang.String> r8 = r10.f28317i     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r10.b(r3, r5, r7, r8)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.lang.String r3 = r10.f28320l     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                if (r3 == 0) goto L_0x00a5
                java.util.Map<java.lang.String, java.lang.String> r7 = r10.f28317i     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.lang.String r8 = "remote-addr"
                r7.put(r8, r3)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.util.Map<java.lang.String, java.lang.String> r3 = r10.f28317i     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.lang.String r7 = "http-client-ip"
                java.lang.String r8 = r10.f28320l     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r3.put(r7, r8)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
            L_0x00a5:
                java.lang.Object r3 = r5.get(r0)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                fi.iki.elonen.NanoHTTPD$Method r3 = fi.iki.elonen.NanoHTTPD.Method.a(r3)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r10.f28315g = r3     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                if (r3 == 0) goto L_0x0146
                java.lang.String r0 = "uri"
                java.lang.Object r0 = r5.get(r0)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r10.f28314f = r0     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                fi.iki.elonen.NanoHTTPD$CookieHandler r0 = new fi.iki.elonen.NanoHTTPD$CookieHandler     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                fi.iki.elonen.NanoHTTPD r3 = fi.iki.elonen.NanoHTTPD.this     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.util.Map<java.lang.String, java.lang.String> r5 = r10.f28317i     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r0.<init>(r5)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r10.f28318j = r0     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.util.Map<java.lang.String, java.lang.String> r0 = r10.f28317i     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.lang.String r3 = "connection"
                java.lang.Object r0 = r0.get(r3)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.lang.String r3 = "HTTP/1.1"
                java.lang.String r5 = r10.f28322n     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                boolean r3 = r3.equals(r5)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r5 = 1
                if (r3 == 0) goto L_0x00e9
                if (r0 == 0) goto L_0x00e7
                java.lang.String r3 = "(?i).*close.*"
                boolean r0 = r0.matches(r3)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                if (r0 != 0) goto L_0x00e9
            L_0x00e7:
                r0 = 1
                goto L_0x00ea
            L_0x00e9:
                r0 = 0
            L_0x00ea:
                fi.iki.elonen.NanoHTTPD r3 = fi.iki.elonen.NanoHTTPD.this     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                fi.iki.elonen.NanoHTTPD$Response r4 = r3.G(r10)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                if (r4 == 0) goto L_0x013c
                java.util.Map<java.lang.String, java.lang.String> r3 = r10.f28317i     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.lang.String r7 = "accept-encoding"
                java.lang.Object r3 = r3.get(r7)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                fi.iki.elonen.NanoHTTPD$CookieHandler r7 = r10.f28318j     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r7.h(r4)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                fi.iki.elonen.NanoHTTPD$Method r7 = r10.f28315g     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r4.C(r7)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                fi.iki.elonen.NanoHTTPD r7 = fi.iki.elonen.NanoHTTPD.this     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                boolean r7 = r7.P(r4)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                if (r7 == 0) goto L_0x0119
                if (r3 == 0) goto L_0x0119
                java.lang.String r7 = "gzip"
                boolean r3 = r3.contains(r7)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                if (r3 == 0) goto L_0x0119
                r6 = 1
            L_0x0119:
                r4.x(r6)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r4.y(r0)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.io.OutputStream r3 = r10.f28310b     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r4.q(r3)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                if (r0 == 0) goto L_0x0136
                boolean r0 = r4.n()     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                if (r0 != 0) goto L_0x0136
            L_0x012c:
                fi.iki.elonen.NanoHTTPD.F(r4)
                fi.iki.elonen.NanoHTTPD$TempFileManager r0 = r10.f28309a
                r0.clear()
                goto L_0x01ea
            L_0x0136:
                java.net.SocketException r0 = new java.net.SocketException     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r0.<init>(r2)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                throw r0     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
            L_0x013c:
                fi.iki.elonen.NanoHTTPD$ResponseException r0 = new fi.iki.elonen.NanoHTTPD$ResponseException     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                fi.iki.elonen.NanoHTTPD$Response$Status r2 = fi.iki.elonen.NanoHTTPD.Response.Status.INTERNAL_ERROR     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.lang.String r3 = "SERVER INTERNAL ERROR: Serve() returned a null response."
                r0.<init>(r2, r3)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                throw r0     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
            L_0x0146:
                fi.iki.elonen.NanoHTTPD$ResponseException r2 = new fi.iki.elonen.NanoHTTPD$ResponseException     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                fi.iki.elonen.NanoHTTPD$Response$Status r3 = fi.iki.elonen.NanoHTTPD.Response.Status.BAD_REQUEST     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r6.<init>()     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.lang.String r7 = "BAD REQUEST: Syntax error. HTTP verb "
                r6.append(r7)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.lang.Object r0 = r5.get(r0)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r6.append(r0)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.lang.String r0 = " unhandled."
                r6.append(r0)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.lang.String r0 = r6.toString()     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r2.<init>(r3, r0)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                throw r2     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
            L_0x016a:
                java.io.BufferedInputStream r0 = r10.f28311c     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                fi.iki.elonen.NanoHTTPD.F(r0)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.io.OutputStream r0 = r10.f28310b     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                fi.iki.elonen.NanoHTTPD.F(r0)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.net.SocketException r0 = new java.net.SocketException     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r0.<init>(r2)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                throw r0     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
            L_0x017a:
                r0 = move-exception
                goto L_0x018c
            L_0x017c:
                java.io.BufferedInputStream r0 = r10.f28311c     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                fi.iki.elonen.NanoHTTPD.F(r0)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.io.OutputStream r0 = r10.f28310b     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                fi.iki.elonen.NanoHTTPD.F(r0)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                java.net.SocketException r0 = new java.net.SocketException     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                r0.<init>(r2)     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
                throw r0     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
            L_0x018c:
                throw r0     // Catch:{ SocketException -> 0x0048, SocketTimeoutException -> 0x0045, SSLException -> 0x0042, IOException -> 0x003f, ResponseException -> 0x003c }
            L_0x018d:
                fi.iki.elonen.NanoHTTPD$Response$Status r2 = r0.a()     // Catch:{ all -> 0x0039 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0039 }
                fi.iki.elonen.NanoHTTPD$Response r0 = fi.iki.elonen.NanoHTTPD.D(r2, r1, r0)     // Catch:{ all -> 0x0039 }
                java.io.OutputStream r1 = r10.f28310b     // Catch:{ all -> 0x0039 }
                r0.q(r1)     // Catch:{ all -> 0x0039 }
                java.io.OutputStream r0 = r10.f28310b     // Catch:{ all -> 0x0039 }
            L_0x01a0:
                fi.iki.elonen.NanoHTTPD.F(r0)     // Catch:{ all -> 0x0039 }
                goto L_0x012c
            L_0x01a4:
                fi.iki.elonen.NanoHTTPD$Response$Status r2 = fi.iki.elonen.NanoHTTPD.Response.Status.INTERNAL_ERROR     // Catch:{ all -> 0x0039 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0039 }
                r3.<init>()     // Catch:{ all -> 0x0039 }
                java.lang.String r5 = "SERVER INTERNAL ERROR: IOException: "
                r3.append(r5)     // Catch:{ all -> 0x0039 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0039 }
                r3.append(r0)     // Catch:{ all -> 0x0039 }
                java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0039 }
                fi.iki.elonen.NanoHTTPD$Response r0 = fi.iki.elonen.NanoHTTPD.D(r2, r1, r0)     // Catch:{ all -> 0x0039 }
                java.io.OutputStream r1 = r10.f28310b     // Catch:{ all -> 0x0039 }
                r0.q(r1)     // Catch:{ all -> 0x0039 }
                java.io.OutputStream r0 = r10.f28310b     // Catch:{ all -> 0x0039 }
                goto L_0x01a0
            L_0x01c7:
                fi.iki.elonen.NanoHTTPD$Response$Status r2 = fi.iki.elonen.NanoHTTPD.Response.Status.INTERNAL_ERROR     // Catch:{ all -> 0x0039 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0039 }
                r3.<init>()     // Catch:{ all -> 0x0039 }
                java.lang.String r5 = "SSL PROTOCOL FAILURE: "
                r3.append(r5)     // Catch:{ all -> 0x0039 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0039 }
                r3.append(r0)     // Catch:{ all -> 0x0039 }
                java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0039 }
                fi.iki.elonen.NanoHTTPD$Response r0 = fi.iki.elonen.NanoHTTPD.D(r2, r1, r0)     // Catch:{ all -> 0x0039 }
                java.io.OutputStream r1 = r10.f28310b     // Catch:{ all -> 0x0039 }
                r0.q(r1)     // Catch:{ all -> 0x0039 }
                java.io.OutputStream r0 = r10.f28310b     // Catch:{ all -> 0x0039 }
                goto L_0x01a0
            L_0x01ea:
                return
            L_0x01eb:
                throw r0     // Catch:{ all -> 0x0039 }
            L_0x01ec:
                throw r0     // Catch:{ all -> 0x0039 }
            L_0x01ed:
                fi.iki.elonen.NanoHTTPD.F(r4)
                fi.iki.elonen.NanoHTTPD$TempFileManager r1 = r10.f28309a
                r1.clear()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: fi.iki.elonen.NanoHTTPD.HTTPSession.execute():void");
        }

        public final Map<String, List<String>> g() {
            return this.f28316h;
        }

        public CookieHandler h() {
            return this.f28318j;
        }

        public String i() {
            return this.f28320l;
        }

        @Deprecated
        public final Map<String, String> j() {
            HashMap hashMap = new HashMap();
            for (String next : this.f28316h.keySet()) {
                hashMap.put(next, this.f28316h.get(next).get(0));
            }
            return hashMap;
        }

        public void k(Map<String, String> map) throws IOException, ResponseException {
            DataOutputStream dataOutputStream;
            RandomAccessFile randomAccessFile;
            ByteArrayOutputStream byteArrayOutputStream;
            ByteBuffer byteBuffer;
            Map<String, String> map2 = map;
            RandomAccessFile randomAccessFile2 = null;
            try {
                long p2 = p();
                if (p2 < PlaybackStateCompat.p3) {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    randomAccessFile = null;
                } else {
                    randomAccessFile = r();
                    byteArrayOutputStream = null;
                    dataOutputStream = randomAccessFile;
                }
                try {
                    byte[] bArr = new byte[512];
                    while (this.f28313e >= 0 && p2 > 0) {
                        int read = this.f28311c.read(bArr, 0, (int) Math.min(p2, 512));
                        this.f28313e = read;
                        p2 -= (long) read;
                        if (read > 0) {
                            dataOutputStream.write(bArr, 0, read);
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteBuffer = ByteBuffer.wrap(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                    } else {
                        byteBuffer = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, randomAccessFile.length());
                        randomAccessFile.seek(0);
                    }
                    if (Method.POST.equals(this.f28315g)) {
                        ContentType contentType = new ContentType(this.f28317i.get("content-type"));
                        if (!contentType.f()) {
                            byte[] bArr2 = new byte[byteBuffer.remaining()];
                            byteBuffer.get(bArr2);
                            String trim = new String(bArr2, contentType.e()).trim();
                            if (PostMethod.FORM_URL_ENCODED_CONTENT_TYPE.equalsIgnoreCase(contentType.b())) {
                                e(trim, this.f28316h);
                            } else if (trim.length() != 0) {
                                map2.put("postData", trim);
                            }
                        } else if (contentType.a() != null) {
                            d(contentType, byteBuffer, this.f28316h, map2);
                        } else {
                            throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
                        }
                    } else if (Method.PUT.equals(this.f28315g)) {
                        map2.put(Annotation.i3, s(byteBuffer, 0, byteBuffer.limit(), (String) null));
                    }
                    NanoHTTPD.F(randomAccessFile);
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile2 = randomAccessFile;
                    NanoHTTPD.F(randomAccessFile2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                NanoHTTPD.F(randomAccessFile2);
                throw th;
            }
        }

        public final Method l() {
            return this.f28315g;
        }

        public final InputStream m() {
            return this.f28311c;
        }

        public String n() {
            return this.f28319k;
        }

        public String o() {
            return this.f28321m;
        }

        public long p() {
            if (this.f28317i.containsKey("content-length")) {
                return Long.parseLong(this.f28317i.get("content-length"));
            }
            int i2 = this.f28312d;
            int i3 = this.f28313e;
            if (i2 < i3) {
                return (long) (i3 - i2);
            }
            return 0;
        }

        public HTTPSession(TempFileManager tempFileManager, InputStream inputStream, OutputStream outputStream, InetAddress inetAddress) {
            this.f28309a = tempFileManager;
            this.f28311c = new BufferedInputStream(inputStream, 8192);
            this.f28310b = outputStream;
            this.f28320l = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "127.0.0.1" : inetAddress.getHostAddress().toString();
            this.f28321m = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "localhost" : inetAddress.getHostName().toString();
            this.f28317i = new HashMap();
        }
    }

    public interface IHTTPSession {
        Map<String, String> a();

        String c();

        void execute() throws IOException;

        Map<String, List<String>> g();

        CookieHandler h();

        String i();

        @Deprecated
        Map<String, String> j();

        void k(Map<String, String> map) throws IOException, ResponseException;

        Method l();

        InputStream m();

        String n();

        String o();
    }

    public enum Method {
        GET,
        PUT,
        POST,
        DELETE,
        HEAD,
        OPTIONS,
        TRACE,
        CONNECT,
        PATCH,
        PROPFIND,
        PROPPATCH,
        MKCOL,
        MOVE,
        COPY,
        LOCK,
        UNLOCK;

        static Method a(String str) {
            if (str == null) {
                return null;
            }
            try {
                return valueOf(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    public static class Response implements Closeable {
        private String X;
        private final Map<String, String> X2 = new HashMap<String, String>() {
            /* renamed from: a */
            public String put(String str, String str2) {
                Response.this.Y2.put(str == null ? str : str.toLowerCase(), str2);
                return (String) super.put(str, str2);
            }
        };
        private InputStream Y;
        /* access modifiers changed from: private */
        public final Map<String, String> Y2 = new HashMap();
        private long Z;
        private Method Z2;
        private boolean a3;
        private boolean b3;
        private boolean c3;
        private IStatus s;

        private static class ChunkedOutputStream extends FilterOutputStream {
            public ChunkedOutputStream(OutputStream outputStream) {
                super(outputStream);
            }

            public void b() throws IOException {
                this.out.write("0\r\n\r\n".getBytes());
            }

            public void write(int i2) throws IOException {
                write(new byte[]{(byte) i2}, 0, 1);
            }

            public void write(byte[] bArr) throws IOException {
                write(bArr, 0, bArr.length);
            }

            public void write(byte[] bArr, int i2, int i3) throws IOException {
                if (i3 != 0) {
                    this.out.write(String.format("%x\r\n", new Object[]{Integer.valueOf(i3)}).getBytes());
                    this.out.write(bArr, i2, i3);
                    this.out.write("\r\n".getBytes());
                }
            }
        }

        public interface IStatus {
            int a();

            String b();
        }

        public enum Status implements IStatus {
            SWITCH_PROTOCOL(101, "Switching Protocols"),
            OK(200, "OK"),
            CREATED(201, "Created"),
            ACCEPTED(202, "Accepted"),
            NO_CONTENT(204, "No Content"),
            PARTIAL_CONTENT(HttpStatus.SC_PARTIAL_CONTENT, "Partial Content"),
            MULTI_STATUS(HttpStatus.SC_MULTI_STATUS, "Multi-Status"),
            REDIRECT(301, "Moved Permanently"),
            FOUND(302, "Found"),
            REDIRECT_SEE_OTHER(303, "See Other"),
            NOT_MODIFIED(304, "Not Modified"),
            TEMPORARY_REDIRECT(307, "Temporary Redirect"),
            BAD_REQUEST(400, "Bad Request"),
            UNAUTHORIZED(401, "Unauthorized"),
            FORBIDDEN(403, "Forbidden"),
            NOT_FOUND(HttpStatus.SC_NOT_FOUND, "Not Found"),
            METHOD_NOT_ALLOWED(HttpStatus.SC_METHOD_NOT_ALLOWED, "Method Not Allowed"),
            NOT_ACCEPTABLE(HttpStatus.SC_NOT_ACCEPTABLE, "Not Acceptable"),
            REQUEST_TIMEOUT(HttpStatus.SC_REQUEST_TIMEOUT, "Request Timeout"),
            CONFLICT(HttpStatus.SC_CONFLICT, "Conflict"),
            GONE(HttpStatus.SC_GONE, "Gone"),
            LENGTH_REQUIRED(HttpStatus.SC_LENGTH_REQUIRED, "Length Required"),
            PRECONDITION_FAILED(HttpStatus.SC_PRECONDITION_FAILED, "Precondition Failed"),
            PAYLOAD_TOO_LARGE(HttpStatus.SC_REQUEST_TOO_LONG, "Payload Too Large"),
            UNSUPPORTED_MEDIA_TYPE(HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE, "Unsupported Media Type"),
            RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable"),
            EXPECTATION_FAILED(HttpStatus.SC_EXPECTATION_FAILED, "Expectation Failed"),
            TOO_MANY_REQUESTS(429, "Too Many Requests"),
            INTERNAL_ERROR(500, "Internal Server Error"),
            NOT_IMPLEMENTED(501, "Not Implemented"),
            SERVICE_UNAVAILABLE(503, "Service Unavailable"),
            UNSUPPORTED_HTTP_VERSION(505, "HTTP Version Not Supported");
            
            private final String X;
            private final int s;

            private Status(int i2, String str) {
                this.s = i2;
                this.X = str;
            }

            public static Status c(int i2) {
                for (Status status : values()) {
                    if (status.a() == i2) {
                        return status;
                    }
                }
                return null;
            }

            public int a() {
                return this.s;
            }

            public String b() {
                return "" + this.s + StringUtils.SPACE + this.X;
            }
        }

        protected Response(IStatus iStatus, String str, InputStream inputStream, long j2) {
            this.s = iStatus;
            this.X = str;
            boolean z = false;
            if (inputStream == null) {
                this.Y = new ByteArrayInputStream(new byte[0]);
                this.Z = 0;
            } else {
                this.Y = inputStream;
                this.Z = j2;
            }
            this.a3 = this.Z < 0 ? true : z;
            this.c3 = true;
        }

        private void r(OutputStream outputStream, long j2) throws IOException {
            byte[] bArr = new byte[((int) PlaybackStateCompat.t3)];
            boolean z = j2 == -1;
            while (true) {
                if (j2 > 0 || z) {
                    int read = this.Y.read(bArr, 0, (int) (z ? 16384 : Math.min(j2, PlaybackStateCompat.t3)));
                    if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        if (!z) {
                            j2 -= (long) read;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        private void s(OutputStream outputStream, long j2) throws IOException {
            if (this.b3) {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                r(gZIPOutputStream, -1);
                gZIPOutputStream.finish();
                return;
            }
            r(outputStream, j2);
        }

        private void t(OutputStream outputStream, long j2) throws IOException {
            if (this.Z2 == Method.HEAD || !this.a3) {
                s(outputStream, j2);
                return;
            }
            ChunkedOutputStream chunkedOutputStream = new ChunkedOutputStream(outputStream);
            s(chunkedOutputStream, -1);
            chunkedOutputStream.b();
        }

        public void A(String str) {
            this.X = str;
        }

        public void C(Method method) {
            this.Z2 = method;
        }

        public void F(IStatus iStatus) {
            this.s = iStatus;
        }

        public void c(String str, String str2) {
            this.X2.put(str, str2);
        }

        public void close() throws IOException {
            InputStream inputStream = this.Y;
            if (inputStream != null) {
                inputStream.close();
            }
        }

        public void d(boolean z) {
            if (z) {
                this.X2.put("connection", "close");
            } else {
                this.X2.remove("connection");
            }
        }

        public InputStream e() {
            return this.Y;
        }

        public String f(String str) {
            return this.Y2.get(str.toLowerCase());
        }

        public String h() {
            return this.X;
        }

        public Method i() {
            return this.Z2;
        }

        public IStatus k() {
            return this.s;
        }

        public boolean n() {
            return "close".equals(f("connection"));
        }

        /* access modifiers changed from: protected */
        public void p(PrintWriter printWriter, String str, String str2) {
            printWriter.append(str).append(": ").append(str2).append("\r\n");
        }

        /* access modifiers changed from: protected */
        public void q(OutputStream outputStream) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            try {
                if (this.s != null) {
                    PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream, new ContentType(this.X).e())), false);
                    printWriter.append("HTTP/1.1 ").append(this.s.b()).append(" \r\n");
                    String str = this.X;
                    if (str != null) {
                        p(printWriter, HttpHeaders.f22875c, str);
                    }
                    if (f(DublinCoreProperties.f27398d) == null) {
                        p(printWriter, HttpHeaders.f22876d, simpleDateFormat.format(new Date()));
                    }
                    for (Map.Entry next : this.X2.entrySet()) {
                        p(printWriter, (String) next.getKey(), (String) next.getValue());
                    }
                    if (f("connection") == null) {
                        p(printWriter, HttpHeaders.o, this.c3 ? "keep-alive" : "close");
                    }
                    if (f("content-length") != null) {
                        this.b3 = false;
                    }
                    if (this.b3) {
                        p(printWriter, "Content-Encoding", "gzip");
                        v(true);
                    }
                    long j2 = this.Y != null ? this.Z : 0;
                    if (this.Z2 != Method.HEAD && this.a3) {
                        p(printWriter, HttpHeaders.M0, "chunked");
                    } else if (!this.b3) {
                        j2 = u(printWriter, j2);
                    }
                    printWriter.append("\r\n");
                    printWriter.flush();
                    t(outputStream, j2);
                    outputStream.flush();
                    NanoHTTPD.F(this.Y);
                    return;
                }
                throw new Error("sendResponse(): Status can't be null.");
            } catch (IOException e2) {
                NanoHTTPD.r.log(Level.SEVERE, "Could not send response to the client", e2);
            }
        }

        /* access modifiers changed from: protected */
        public long u(PrintWriter printWriter, long j2) {
            String f2 = f("content-length");
            if (f2 != null) {
                try {
                    j2 = Long.parseLong(f2);
                } catch (NumberFormatException unused) {
                    Logger c2 = NanoHTTPD.r;
                    c2.severe("content-length was no number " + f2);
                }
            }
            printWriter.print("Content-Length: " + j2 + "\r\n");
            return j2;
        }

        public void v(boolean z) {
            this.a3 = z;
        }

        public void w(InputStream inputStream) {
            this.Y = inputStream;
        }

        public void x(boolean z) {
            this.b3 = z;
        }

        public void y(boolean z) {
            this.c3 = z;
        }
    }

    public static final class ResponseException extends Exception {
        private static final long X = 6569838532917408380L;
        private final Response.Status s;

        public ResponseException(Response.Status status, String str) {
            super(str);
            this.s = status;
        }

        public Response.Status a() {
            return this.s;
        }

        public ResponseException(Response.Status status, String str, Exception exc) {
            super(str, exc);
            this.s = status;
        }
    }

    public static class SecureServerSocketFactory implements ServerSocketFactory {

        /* renamed from: a  reason: collision with root package name */
        private SSLServerSocketFactory f28323a;

        /* renamed from: b  reason: collision with root package name */
        private String[] f28324b;

        public SecureServerSocketFactory(SSLServerSocketFactory sSLServerSocketFactory, String[] strArr) {
            this.f28323a = sSLServerSocketFactory;
            this.f28324b = strArr;
        }

        public ServerSocket a() throws IOException {
            SSLServerSocket sSLServerSocket = (SSLServerSocket) this.f28323a.createServerSocket();
            String[] strArr = this.f28324b;
            if (strArr != null) {
                sSLServerSocket.setEnabledProtocols(strArr);
            } else {
                sSLServerSocket.setEnabledProtocols(sSLServerSocket.getSupportedProtocols());
            }
            sSLServerSocket.setUseClientMode(false);
            sSLServerSocket.setWantClientAuth(false);
            sSLServerSocket.setNeedClientAuth(false);
            return sSLServerSocket;
        }
    }

    public class ServerRunnable implements Runnable {
        /* access modifiers changed from: private */
        public IOException X;
        /* access modifiers changed from: private */
        public boolean Y = false;
        private final int s;

        public ServerRunnable(int i2) {
            this.s = i2;
        }

        public void run() {
            try {
                NanoHTTPD.this.f28282c.bind(NanoHTTPD.this.f28280a != null ? new InetSocketAddress(NanoHTTPD.this.f28280a, NanoHTTPD.this.f28281b) : new InetSocketAddress(NanoHTTPD.this.f28281b));
                this.Y = true;
                do {
                    try {
                        Socket accept = NanoHTTPD.this.f28282c.accept();
                        int i2 = this.s;
                        if (i2 > 0) {
                            accept.setSoTimeout(i2);
                        }
                        InputStream inputStream = accept.getInputStream();
                        NanoHTTPD nanoHTTPD = NanoHTTPD.this;
                        nanoHTTPD.f28285f.b(nanoHTTPD.k(accept, inputStream));
                    } catch (IOException e2) {
                        NanoHTTPD.r.log(Level.FINE, "Communication with the client broken", e2);
                    }
                } while (!NanoHTTPD.this.f28282c.isClosed());
            } catch (IOException e3) {
                this.X = e3;
            }
        }
    }

    public interface ServerSocketFactory {
        ServerSocket a() throws IOException;
    }

    public interface TempFile {
        void a() throws Exception;

        String getName();

        OutputStream open() throws Exception;
    }

    public interface TempFileManager {
        TempFile a(String str) throws Exception;

        void clear();
    }

    public interface TempFileManagerFactory {
        TempFileManager a();
    }

    public NanoHTTPD(int i2) {
        this((String) null, i2);
    }

    public static Map<String, String> A() {
        if (s == null) {
            HashMap hashMap = new HashMap();
            s = hashMap;
            v(hashMap, "META-INF/nanohttpd/default-mimetypes.properties");
            v(s, "META-INF/nanohttpd/mimetypes.properties");
            if (s.isEmpty()) {
                r.log(Level.WARNING, "no mime types found in the classpath! please provide mimetypes.properties");
            }
        }
        return s;
    }

    public static Response B(Response.IStatus iStatus, String str, InputStream inputStream) {
        return new Response(iStatus, str, inputStream, -1);
    }

    public static Response C(Response.IStatus iStatus, String str, InputStream inputStream, long j2) {
        return new Response(iStatus, str, inputStream, j2);
    }

    public static Response D(Response.IStatus iStatus, String str, String str2) {
        byte[] bArr;
        ContentType contentType = new ContentType(str);
        if (str2 == null) {
            return C(iStatus, str, new ByteArrayInputStream(new byte[0]), 0);
        }
        try {
            if (!Charset.forName(contentType.e()).newEncoder().canEncode(str2)) {
                contentType = contentType.g();
            }
            bArr = str2.getBytes(contentType.e());
        } catch (UnsupportedEncodingException e2) {
            r.log(Level.SEVERE, "encoding problem, responding nothing", e2);
            bArr = new byte[0];
        }
        return C(iStatus, contentType.c(), new ByteArrayInputStream(bArr), (long) bArr.length);
    }

    public static Response E(String str) {
        return D(Response.Status.OK, p, str);
    }

    /* access modifiers changed from: private */
    public static final void F(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof Socket) {
                    ((Socket) obj).close();
                } else if (obj instanceof ServerSocket) {
                    ((ServerSocket) obj).close();
                } else {
                    throw new IllegalArgumentException("Unknown object to close");
                }
            } catch (IOException e2) {
                r.log(Level.SEVERE, "Could not close", e2);
            }
        }
    }

    protected static Map<String, List<String>> m(String str) {
        HashMap hashMap = new HashMap();
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                String trim = (indexOf >= 0 ? o(nextToken.substring(0, indexOf)) : o(nextToken)).trim();
                if (!hashMap.containsKey(trim)) {
                    hashMap.put(trim, new ArrayList());
                }
                String o2 = indexOf >= 0 ? o(nextToken.substring(indexOf + 1)) : null;
                if (o2 != null) {
                    ((List) hashMap.get(trim)).add(o2);
                }
            }
        }
        return hashMap;
    }

    protected static Map<String, List<String>> n(Map<String, String> map) {
        return m(map.get(q));
    }

    protected static String o(String str) {
        try {
            return URLDecoder.decode(str, "UTF8");
        } catch (UnsupportedEncodingException e2) {
            r.log(Level.WARNING, "Encoding not supported, ignored", e2);
            return null;
        }
    }

    public static String r(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        String str2 = lastIndexOf >= 0 ? A().get(str.substring(lastIndexOf + 1).toLowerCase()) : null;
        return str2 == null ? FilePart.DEFAULT_CONTENT_TYPE : str2;
    }

    private static void v(Map<String, String> map, String str) {
        InputStream inputStream;
        try {
            Enumeration<URL> resources = NanoHTTPD.class.getClassLoader().getResources(str);
            while (resources.hasMoreElements()) {
                URL nextElement = resources.nextElement();
                Properties properties = new Properties();
                inputStream = null;
                try {
                    inputStream = nextElement.openStream();
                    properties.load(inputStream);
                } catch (IOException e2) {
                    Logger logger = r;
                    Level level = Level.SEVERE;
                    logger.log(level, "could not load mimetypes from " + nextElement, e2);
                }
                F(inputStream);
                map.putAll(properties);
            }
        } catch (IOException unused) {
            Logger logger2 = r;
            Level level2 = Level.INFO;
            logger2.log(level2, "no mime types available at " + str);
        } catch (Throwable th) {
            F(inputStream);
            throw th;
        }
    }

    public static SSLServerSocketFactory w(String str, char[] cArr) throws IOException {
        try {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            InputStream resourceAsStream = NanoHTTPD.class.getResourceAsStream(str);
            if (resourceAsStream != null) {
                instance.load(resourceAsStream, cArr);
                KeyManagerFactory instance2 = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                instance2.init(instance, cArr);
                return x(instance, instance2);
            }
            throw new IOException("Unable to load keystore from classpath: " + str);
        } catch (Exception e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public static SSLServerSocketFactory x(KeyStore keyStore, KeyManagerFactory keyManagerFactory) throws IOException {
        try {
            return y(keyStore, keyManagerFactory.getKeyManagers());
        } catch (Exception e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public static SSLServerSocketFactory y(KeyStore keyStore, KeyManager[] keyManagerArr) throws IOException {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(keyStore);
            SSLContext instance2 = SSLContext.getInstance("TLS");
            instance2.init(keyManagerArr, instance.getTrustManagers(), (SecureRandom) null);
            return instance2.getServerSocketFactory();
        } catch (Exception e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public Response G(IHTTPSession iHTTPSession) {
        HashMap hashMap = new HashMap();
        Method l2 = iHTTPSession.l();
        if (Method.PUT.equals(l2) || Method.POST.equals(l2)) {
            try {
                iHTTPSession.k(hashMap);
            } catch (IOException e2) {
                Response.Status status = Response.Status.INTERNAL_ERROR;
                return D(status, "text/plain", "SERVER INTERNAL ERROR: IOException: " + e2.getMessage());
            } catch (ResponseException e3) {
                return D(e3.a(), "text/plain", e3.getMessage());
            }
        }
        Map<String, String> j2 = iHTTPSession.j();
        j2.put(q, iHTTPSession.n());
        return H(iHTTPSession.c(), l2, iHTTPSession.a(), j2, hashMap);
    }

    @Deprecated
    public Response H(String str, Method method, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        return D(Response.Status.NOT_FOUND, "text/plain", "Not Found");
    }

    public void I(AsyncRunner asyncRunner) {
        this.f28285f = asyncRunner;
    }

    public void J(ServerSocketFactory serverSocketFactory) {
        this.f28283d = serverSocketFactory;
    }

    public void K(TempFileManagerFactory tempFileManagerFactory) {
        this.f28286g = tempFileManagerFactory;
    }

    public void L() throws IOException {
        M(5000);
    }

    public void M(int i2) throws IOException {
        N(i2, true);
    }

    public void N(int i2, boolean z) throws IOException {
        this.f28282c = s().a();
        this.f28282c.setReuseAddress(true);
        ServerRunnable l2 = l(i2);
        Thread thread = new Thread(l2);
        this.f28284e = thread;
        thread.setDaemon(z);
        this.f28284e.setName("NanoHttpd Main Listener");
        this.f28284e.start();
        while (!l2.Y && l2.X == null) {
            try {
                Thread.sleep(10);
            } catch (Throwable unused) {
            }
        }
        if (l2.X != null) {
            throw l2.X;
        }
    }

    public void O() {
        try {
            F(this.f28282c);
            this.f28285f.a();
            Thread thread = this.f28284e;
            if (thread != null) {
                thread.join();
            }
        } catch (Exception e2) {
            r.log(Level.SEVERE, "Could not stop all connections", e2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean P(Response response) {
        return response.h() != null && (response.h().toLowerCase().contains("text/") || response.h().toLowerCase().contains("/json"));
    }

    public final boolean Q() {
        return (this.f28282c == null || this.f28284e == null) ? false : true;
    }

    public synchronized void j() {
        O();
    }

    /* access modifiers changed from: protected */
    public ClientHandler k(Socket socket, InputStream inputStream) {
        return new ClientHandler(inputStream, socket);
    }

    /* access modifiers changed from: protected */
    public ServerRunnable l(int i2) {
        return new ServerRunnable(i2);
    }

    public String p() {
        return this.f28280a;
    }

    public final int q() {
        if (this.f28282c == null) {
            return -1;
        }
        return this.f28282c.getLocalPort();
    }

    public ServerSocketFactory s() {
        return this.f28283d;
    }

    public TempFileManagerFactory t() {
        return this.f28286g;
    }

    public final boolean u() {
        return Q() && !this.f28282c.isClosed() && this.f28284e.isAlive();
    }

    public void z(SSLServerSocketFactory sSLServerSocketFactory, String[] strArr) {
        this.f28283d = new SecureServerSocketFactory(sSLServerSocketFactory, strArr);
    }

    public NanoHTTPD(String str, int i2) {
        this.f28283d = new DefaultServerSocketFactory();
        this.f28280a = str;
        this.f28281b = i2;
        K(new DefaultTempFileManagerFactory());
        I(new DefaultAsyncRunner());
    }
}
