package androidx.media3.datasource;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.HttpDataSource;
import com.google.common.base.Predicate;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.google.common.net.HttpHeaders;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

public class DefaultHttpDataSource extends BaseDataSource implements HttpDataSource {
    private static final long A = 2048;
    @UnstableApi
    public static final int u = 8000;
    @UnstableApi
    public static final int v = 8000;
    private static final String w = "DefaultHttpDataSource";
    private static final int x = 20;
    private static final int y = 307;
    private static final int z = 308;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f9819f;

    /* renamed from: g  reason: collision with root package name */
    private final int f9820g;

    /* renamed from: h  reason: collision with root package name */
    private final int f9821h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final String f9822i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private final HttpDataSource.RequestProperties f9823j;

    /* renamed from: k  reason: collision with root package name */
    private final HttpDataSource.RequestProperties f9824k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f9825l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private Predicate<String> f9826m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private DataSpec f9827n;
    @Nullable
    private HttpURLConnection o;
    @Nullable
    private InputStream p;
    private boolean q;
    private int r;
    private long s;
    private long t;

    public static final class Factory implements HttpDataSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final HttpDataSource.RequestProperties f9828a = new HttpDataSource.RequestProperties();
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private TransferListener f9829b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private Predicate<String> f9830c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private String f9831d;

        /* renamed from: e  reason: collision with root package name */
        private int f9832e = 8000;

        /* renamed from: f  reason: collision with root package name */
        private int f9833f = 8000;

        /* renamed from: g  reason: collision with root package name */
        private boolean f9834g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f9835h;

        @UnstableApi
        /* renamed from: c */
        public DefaultHttpDataSource a() {
            DefaultHttpDataSource defaultHttpDataSource = new DefaultHttpDataSource(this.f9831d, this.f9832e, this.f9833f, this.f9834g, this.f9828a, this.f9830c, this.f9835h);
            TransferListener transferListener = this.f9829b;
            if (transferListener != null) {
                defaultHttpDataSource.e(transferListener);
            }
            return defaultHttpDataSource;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Factory d(boolean z) {
            this.f9834g = z;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Factory e(int i2) {
            this.f9832e = i2;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Factory f(@Nullable Predicate<String> predicate) {
            this.f9830c = predicate;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        /* renamed from: g */
        public Factory b(Map<String, String> map) {
            this.f9828a.b(map);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Factory h(boolean z) {
            this.f9835h = z;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Factory i(int i2) {
            this.f9833f = i2;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Factory j(@Nullable TransferListener transferListener) {
            this.f9829b = transferListener;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Factory k(@Nullable String str) {
            this.f9831d = str;
            return this;
        }
    }

    private static class NullFilteringHeadersMap extends ForwardingMap<String, List<String>> {
        private final Map<String, List<String>> s;

        public NullFilteringHeadersMap(Map<String, List<String>> map) {
            this.s = map;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean E1(Map.Entry entry) {
            return entry.getKey() != null;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean G1(String str) {
            return str != null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a1 */
        public Map<String, List<String>> Z0() {
            return this.s;
        }

        public boolean containsKey(@Nullable Object obj) {
            return obj != null && super.containsKey(obj);
        }

        public boolean containsValue(@Nullable Object obj) {
            return super.m1(obj);
        }

        public Set<Map.Entry<String, List<String>>> entrySet() {
            return Sets.i(super.entrySet(), new C0198g());
        }

        public boolean equals(@Nullable Object obj) {
            return obj != null && super.n1(obj);
        }

        public int hashCode() {
            return super.o1();
        }

        public boolean isEmpty() {
            if (!super.isEmpty()) {
                return super.size() == 1 && super.containsKey((Object) null);
            }
            return true;
        }

        public Set<String> keySet() {
            return Sets.i(super.keySet(), new C0199h());
        }

        public int size() {
            return super.size() - (super.containsKey((Object) null) ? 1 : 0);
        }

        @Nullable
        public List<String> get(@Nullable Object obj) {
            if (obj == null) {
                return null;
            }
            return (List) super.get(obj);
        }
    }

    @UnstableApi
    @Deprecated
    public DefaultHttpDataSource() {
        this((String) null, 8000, 8000);
    }

    private HttpURLConnection A(DataSpec dataSpec) throws IOException {
        HttpURLConnection B;
        URL url;
        DataSpec dataSpec2 = dataSpec;
        URL url2 = new URL(dataSpec2.f9779a.toString());
        int i2 = dataSpec2.f9781c;
        byte[] bArr = dataSpec2.f9782d;
        long j2 = dataSpec2.f9785g;
        long j3 = dataSpec2.f9786h;
        boolean d2 = dataSpec2.d(1);
        if (!this.f9819f && !this.f9825l) {
            return B(url2, i2, bArr, j2, j3, d2, true, dataSpec2.f9783e);
        }
        int i3 = 0;
        URL url3 = url2;
        int i4 = i2;
        byte[] bArr2 = bArr;
        while (true) {
            int i5 = i3 + 1;
            if (i3 <= 20) {
                long j4 = j2;
                long j5 = j2;
                int i6 = i4;
                int i7 = i5;
                URL url4 = url3;
                long j6 = j3;
                B = B(url3, i4, bArr2, j4, j3, d2, false, dataSpec2.f9783e);
                int responseCode = B.getResponseCode();
                String headerField = B.getHeaderField(HttpHeaders.t0);
                if ((i6 == 1 || i6 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                    URL url5 = url4;
                    B.disconnect();
                    url3 = y(url5, headerField, dataSpec2);
                    i4 = i6;
                } else if (i6 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    return B;
                } else {
                    B.disconnect();
                    if (!this.f9825l || responseCode != 302) {
                        bArr2 = null;
                        url = url4;
                        i4 = 1;
                    } else {
                        i4 = i6;
                        url = url4;
                    }
                    url3 = y(url, headerField, dataSpec2);
                }
                i3 = i7;
                j2 = j5;
                j3 = j6;
            } else {
                throw new HttpDataSource.HttpDataSourceException((IOException) new NoRouteToHostException("Too many redirects: " + i5), dataSpec2, (int) PlaybackException.b3, 1);
            }
        }
        return B;
    }

    private HttpURLConnection B(URL url, int i2, @Nullable byte[] bArr, long j2, long j3, boolean z2, boolean z3, Map<String, String> map) throws IOException {
        HttpURLConnection D = D(url);
        D.setConnectTimeout(this.f9820g);
        D.setReadTimeout(this.f9821h);
        HashMap hashMap = new HashMap();
        HttpDataSource.RequestProperties requestProperties = this.f9823j;
        if (requestProperties != null) {
            hashMap.putAll(requestProperties.c());
        }
        hashMap.putAll(this.f9824k.c());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            D.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String a2 = HttpUtil.a(j2, j3);
        if (a2 != null) {
            D.setRequestProperty(HttpHeaders.I, a2);
        }
        String str = this.f9822i;
        if (str != null) {
            D.setRequestProperty(HttpHeaders.P, str);
        }
        D.setRequestProperty(HttpHeaders.f22882j, z2 ? "gzip" : "identity");
        D.setInstanceFollowRedirects(z3);
        D.setDoOutput(bArr != null);
        D.setRequestMethod(DataSpec.c(i2));
        if (bArr != null) {
            D.setFixedLengthStreamingMode(bArr.length);
            D.connect();
            OutputStream outputStream = D.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            D.connect();
        }
        return D;
    }

    private static void C(@Nullable HttpURLConnection httpURLConnection, long j2) {
        int i2;
        if (httpURLConnection != null && (i2 = Util.f9646a) >= 19 && i2 <= 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j2 == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j2 <= 2048) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                    Method declaredMethod = ((Class) Assertions.g(inputStream.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", (Class[]) null);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, (Object[]) null);
                }
            } catch (Exception unused) {
            }
        }
    }

    private int E(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.s;
        if (j2 != -1) {
            long j3 = j2 - this.t;
            if (j3 == 0) {
                return -1;
            }
            i3 = (int) Math.min((long) i3, j3);
        }
        int read = ((InputStream) Util.o(this.p)).read(bArr, i2, i3);
        if (read == -1) {
            return -1;
        }
        this.t += (long) read;
        t(read);
        return read;
    }

    private void G(long j2, DataSpec dataSpec) throws IOException {
        if (j2 != 0) {
            byte[] bArr = new byte[4096];
            while (j2 > 0) {
                int read = ((InputStream) Util.o(this.p)).read(bArr, 0, (int) Math.min(j2, (long) 4096));
                if (Thread.currentThread().isInterrupted()) {
                    throw new HttpDataSource.HttpDataSourceException((IOException) new InterruptedIOException(), dataSpec, 2000, 1);
                } else if (read != -1) {
                    j2 -= (long) read;
                    t(read);
                } else {
                    throw new HttpDataSource.HttpDataSourceException(dataSpec, 2008, 1);
                }
            }
        }
    }

    private void x() {
        HttpURLConnection httpURLConnection = this.o;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                Log.e(w, "Unexpected error while disconnecting", e2);
            }
            this.o = null;
        }
    }

    private URL y(URL url, @Nullable String str, DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        if (str != null) {
            try {
                URL url2 = new URL(url, str);
                String protocol = url2.getProtocol();
                if (!"https".equals(protocol) && !"http".equals(protocol)) {
                    throw new HttpDataSource.HttpDataSourceException("Unsupported protocol redirect: " + protocol, dataSpec, (int) PlaybackException.b3, 1);
                } else if (this.f9819f || protocol.equals(url.getProtocol())) {
                    return url2;
                } else {
                    throw new HttpDataSource.HttpDataSourceException("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", dataSpec, (int) PlaybackException.b3, 1);
                }
            } catch (MalformedURLException e2) {
                throw new HttpDataSource.HttpDataSourceException((IOException) e2, dataSpec, (int) PlaybackException.b3, 1);
            }
        } else {
            throw new HttpDataSource.HttpDataSourceException("Null location redirect", dataSpec, (int) PlaybackException.b3, 1);
        }
    }

    private static boolean z(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"));
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public HttpURLConnection D(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    @UnstableApi
    @Deprecated
    public void F(@Nullable Predicate<String> predicate) {
        this.f9826m = predicate;
    }

    @UnstableApi
    public long a(DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        byte[] bArr;
        this.f9827n = dataSpec;
        long j2 = 0;
        this.t = 0;
        this.s = 0;
        v(dataSpec);
        try {
            HttpURLConnection A2 = A(dataSpec);
            this.o = A2;
            this.r = A2.getResponseCode();
            String responseMessage = A2.getResponseMessage();
            int i2 = this.r;
            long j3 = -1;
            if (i2 < 200 || i2 > 299) {
                Map<String, List<String>> headerFields = A2.getHeaderFields();
                if (this.r == 416) {
                    if (dataSpec.f9785g == HttpUtil.c(A2.getHeaderField(HttpHeaders.f0))) {
                        this.q = true;
                        w(dataSpec);
                        long j4 = dataSpec.f9786h;
                        if (j4 != -1) {
                            return j4;
                        }
                        return 0;
                    }
                }
                InputStream errorStream = A2.getErrorStream();
                if (errorStream != null) {
                    try {
                        bArr = Util.y2(errorStream);
                    } catch (IOException unused) {
                        bArr = Util.f9651f;
                    }
                } else {
                    bArr = Util.f9651f;
                }
                byte[] bArr2 = bArr;
                x();
                throw new HttpDataSource.InvalidResponseCodeException(this.r, responseMessage, this.r == 416 ? new DataSourceException(2008) : null, headerFields, dataSpec, bArr2);
            }
            String contentType = A2.getContentType();
            Predicate<String> predicate = this.f9826m;
            if (predicate == null || predicate.apply(contentType)) {
                if (this.r == 200) {
                    long j5 = dataSpec.f9785g;
                    if (j5 != 0) {
                        j2 = j5;
                    }
                }
                boolean z2 = z(A2);
                if (!z2) {
                    long j6 = dataSpec.f9786h;
                    if (j6 != -1) {
                        this.s = j6;
                    } else {
                        long b2 = HttpUtil.b(A2.getHeaderField(HttpHeaders.f22874b), A2.getHeaderField(HttpHeaders.f0));
                        if (b2 != -1) {
                            j3 = b2 - j2;
                        }
                        this.s = j3;
                    }
                } else {
                    this.s = dataSpec.f9786h;
                }
                try {
                    this.p = A2.getInputStream();
                    if (z2) {
                        this.p = new GZIPInputStream(this.p);
                    }
                    this.q = true;
                    w(dataSpec);
                    try {
                        G(j2, dataSpec);
                        return this.s;
                    } catch (IOException e2) {
                        x();
                        if (e2 instanceof HttpDataSource.HttpDataSourceException) {
                            throw ((HttpDataSource.HttpDataSourceException) e2);
                        }
                        throw new HttpDataSource.HttpDataSourceException(e2, dataSpec, 2000, 1);
                    }
                } catch (IOException e3) {
                    x();
                    throw new HttpDataSource.HttpDataSourceException(e3, dataSpec, 2000, 1);
                }
            } else {
                x();
                throw new HttpDataSource.InvalidContentTypeException(contentType, dataSpec);
            }
        } catch (IOException e4) {
            x();
            throw HttpDataSource.HttpDataSourceException.c(e4, dataSpec, 1);
        }
    }

    @UnstableApi
    @Nullable
    public Uri c() {
        HttpURLConnection httpURLConnection = this.o;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @UnstableApi
    public void close() throws HttpDataSource.HttpDataSourceException {
        try {
            InputStream inputStream = this.p;
            if (inputStream != null) {
                long j2 = this.s;
                long j3 = -1;
                if (j2 != -1) {
                    j3 = j2 - this.t;
                }
                C(this.o, j3);
                inputStream.close();
            }
            this.p = null;
            x();
            if (this.q) {
                this.q = false;
                u();
            }
        } catch (IOException e2) {
            throw new HttpDataSource.HttpDataSourceException(e2, (DataSpec) Util.o(this.f9827n), 2000, 3);
        } catch (Throwable th) {
            this.p = null;
            x();
            if (this.q) {
                this.q = false;
                u();
            }
            throw th;
        }
    }

    @UnstableApi
    public void f(String str, String str2) {
        Assertions.g(str);
        Assertions.g(str2);
        this.f9824k.e(str, str2);
    }

    @UnstableApi
    public Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.o;
        return httpURLConnection == null ? ImmutableMap.s() : new NullFilteringHeadersMap(httpURLConnection.getHeaderFields());
    }

    @UnstableApi
    public int k() {
        int i2;
        if (this.o == null || (i2 = this.r) <= 0) {
            return -1;
        }
        return i2;
    }

    @UnstableApi
    public void p() {
        this.f9824k.a();
    }

    @UnstableApi
    public void r(String str) {
        Assertions.g(str);
        this.f9824k.d(str);
    }

    @UnstableApi
    public int read(byte[] bArr, int i2, int i3) throws HttpDataSource.HttpDataSourceException {
        try {
            return E(bArr, i2, i3);
        } catch (IOException e2) {
            throw HttpDataSource.HttpDataSourceException.c(e2, (DataSpec) Util.o(this.f9827n), 2);
        }
    }

    @UnstableApi
    @Deprecated
    public DefaultHttpDataSource(@Nullable String str) {
        this(str, 8000, 8000);
    }

    @UnstableApi
    @Deprecated
    public DefaultHttpDataSource(@Nullable String str, int i2, int i3) {
        this(str, i2, i3, false, (HttpDataSource.RequestProperties) null);
    }

    @UnstableApi
    @Deprecated
    public DefaultHttpDataSource(@Nullable String str, int i2, int i3, boolean z2, @Nullable HttpDataSource.RequestProperties requestProperties) {
        this(str, i2, i3, z2, requestProperties, (Predicate<String>) null, false);
    }

    private DefaultHttpDataSource(@Nullable String str, int i2, int i3, boolean z2, @Nullable HttpDataSource.RequestProperties requestProperties, @Nullable Predicate<String> predicate, boolean z3) {
        super(true);
        this.f9822i = str;
        this.f9820g = i2;
        this.f9821h = i3;
        this.f9819f = z2;
        this.f9823j = requestProperties;
        this.f9826m = predicate;
        this.f9824k = new HttpDataSource.RequestProperties();
        this.f9825l = z3;
    }
}
