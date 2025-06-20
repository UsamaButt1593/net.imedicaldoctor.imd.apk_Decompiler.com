package androidx.media3.datasource;

import android.net.Uri;
import android.net.http.HttpEngine;
import android.net.http.HttpException;
import android.net.http.UrlRequest;
import android.net.http.UrlResponseInfo;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.HttpDataSource;
import com.google.common.base.Ascii;
import com.google.common.base.Predicate;
import com.google.common.net.HttpHeaders;
import com.google.common.primitives.Longs;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

@RequiresApi(34)
@UnstableApi
public final class HttpEngineDataSource extends BaseDataSource implements HttpDataSource {
    @UnstableApi
    public static final int C = 8000;
    @UnstableApi
    public static final int D = 8000;
    private static final int E = 32768;
    /* access modifiers changed from: private */
    public boolean A;
    private volatile long B;

    /* renamed from: f  reason: collision with root package name */
    private final HttpEngine f9845f;

    /* renamed from: g  reason: collision with root package name */
    private final Executor f9846g;

    /* renamed from: h  reason: collision with root package name */
    private final int f9847h;

    /* renamed from: i  reason: collision with root package name */
    private final int f9848i;

    /* renamed from: j  reason: collision with root package name */
    private final int f9849j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final boolean f9850k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final boolean f9851l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private final String f9852m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private final HttpDataSource.RequestProperties f9853n;
    private final HttpDataSource.RequestProperties o = new HttpDataSource.RequestProperties();
    /* access modifiers changed from: private */
    public final ConditionVariable p = new ConditionVariable();
    private final Clock q = Clock.f9502a;
    @Nullable
    private Predicate<String> r;
    /* access modifiers changed from: private */
    public final boolean s;
    private boolean t;
    private long u;
    /* access modifiers changed from: private */
    @Nullable
    public DataSpec v;
    /* access modifiers changed from: private */
    @Nullable
    public UrlRequestWrapper w;
    @Nullable
    private ByteBuffer x;
    /* access modifiers changed from: private */
    @Nullable
    public UrlResponseInfo y;
    /* access modifiers changed from: private */
    @Nullable
    public IOException z;

    public static final class Factory implements HttpDataSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final HttpEngine f9854a;

        /* renamed from: b  reason: collision with root package name */
        private final Executor f9855b;

        /* renamed from: c  reason: collision with root package name */
        private final HttpDataSource.RequestProperties f9856c = new HttpDataSource.RequestProperties();
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private Predicate<String> f9857d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private TransferListener f9858e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private String f9859f;

        /* renamed from: g  reason: collision with root package name */
        private int f9860g = 3;

        /* renamed from: h  reason: collision with root package name */
        private int f9861h = 8000;

        /* renamed from: i  reason: collision with root package name */
        private int f9862i = 8000;

        /* renamed from: j  reason: collision with root package name */
        private boolean f9863j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f9864k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f9865l;

        public Factory(HttpEngine httpEngine, Executor executor) {
            this.f9854a = u.a(Assertions.g(httpEngine));
            this.f9855b = executor;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Factory c(int i2) {
            this.f9861h = i2;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Factory d(@Nullable Predicate<String> predicate) {
            this.f9857d = predicate;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        /* renamed from: e */
        public final Factory b(Map<String, String> map) {
            this.f9856c.b(map);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Factory f(boolean z) {
            this.f9864k = z;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Factory g(boolean z) {
            this.f9865l = z;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Factory h(int i2) {
            this.f9862i = i2;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Factory i(int i2) {
            this.f9860g = i2;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Factory j(boolean z) {
            this.f9863j = z;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Factory k(@Nullable TransferListener transferListener) {
            this.f9858e = transferListener;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Factory l(@Nullable String str) {
            this.f9859f = str;
            return this;
        }

        @UnstableApi
        public HttpDataSource a() {
            HttpEngineDataSource httpEngineDataSource = new HttpEngineDataSource(this.f9854a, this.f9855b, this.f9860g, this.f9861h, this.f9862i, this.f9863j, this.f9864k, this.f9859f, this.f9856c, this.f9857d, this.f9865l);
            TransferListener transferListener = this.f9858e;
            if (transferListener != null) {
                httpEngineDataSource.e(transferListener);
            }
            return httpEngineDataSource;
        }
    }

    @UnstableApi
    public static final class OpenException extends HttpDataSource.HttpDataSourceException {
        public final int a3;

        public OpenException(DataSpec dataSpec, int i2, int i3) {
            super(dataSpec, i2, 1);
            this.a3 = i3;
        }

        public OpenException(IOException iOException, DataSpec dataSpec, int i2, int i3) {
            super(iOException, dataSpec, i2, 1);
            this.a3 = i3;
        }

        public OpenException(String str, DataSpec dataSpec, int i2, int i3) {
            super(str, dataSpec, i2, 1);
            this.a3 = i3;
        }
    }

    private final class UrlRequestCallback implements UrlRequest.Callback {

        /* renamed from: a  reason: collision with root package name */
        private volatile boolean f9866a;

        private UrlRequestCallback() {
            this.f9866a = false;
        }

        public void a() {
            this.f9866a = true;
        }

        public synchronized void onCanceled(UrlRequest urlRequest, @Nullable UrlResponseInfo urlResponseInfo) {
        }

        public synchronized void onFailed(UrlRequest urlRequest, @Nullable UrlResponseInfo urlResponseInfo, HttpException httpException) {
            try {
                if (!this.f9866a) {
                    if (!A.a(httpException) || B.a(httpException).getErrorCode() != 1) {
                        IOException unused = HttpEngineDataSource.this.z = httpException;
                    } else {
                        IOException unused2 = HttpEngineDataSource.this.z = new UnknownHostException();
                    }
                    HttpEngineDataSource.this.p.f();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }

        public synchronized void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
            if (!this.f9866a) {
                HttpEngineDataSource.this.p.f();
            }
        }

        public synchronized void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
            if (!this.f9866a) {
                DataSpec dataSpec = (DataSpec) Assertions.g(HttpEngineDataSource.this.v);
                int a2 = urlResponseInfo.getHttpStatusCode();
                if (dataSpec.f9781c == 2 && (a2 == 307 || a2 == 308)) {
                    IOException unused = HttpEngineDataSource.this.z = new HttpDataSource.InvalidResponseCodeException(a2, urlResponseInfo.getHttpStatusText(), (IOException) null, urlResponseInfo.getHeaders().getAsMap(), dataSpec, Util.f9651f);
                    HttpEngineDataSource.this.p.f();
                    return;
                }
                if (HttpEngineDataSource.this.f9850k) {
                    HttpEngineDataSource.this.W();
                }
                boolean z = HttpEngineDataSource.this.s && dataSpec.f9781c == 2 && a2 == 302;
                if (z || HttpEngineDataSource.this.f9851l) {
                    String I = HttpEngineDataSource.S((List) urlResponseInfo.getHeaders().getAsMap().get(HttpHeaders.F0));
                    if (z || !TextUtils.isEmpty(I)) {
                        urlRequest.cancel();
                        DataSpec i2 = (z || dataSpec.f9781c != 2) ? dataSpec.i(Uri.parse(str)) : dataSpec.a().k(str).e(1).d((byte[]) null).a();
                        if (!TextUtils.isEmpty(I)) {
                            HashMap hashMap = new HashMap();
                            hashMap.putAll(dataSpec.f9783e);
                            hashMap.put(HttpHeaders.p, I);
                            i2 = i2.a().f(hashMap).a();
                        }
                        try {
                            UrlRequestWrapper J = HttpEngineDataSource.this.M(i2);
                            if (HttpEngineDataSource.this.w != null) {
                                HttpEngineDataSource.this.w.a();
                            }
                            UrlRequestWrapper unused2 = HttpEngineDataSource.this.w = J;
                            HttpEngineDataSource.this.w.e();
                        } catch (IOException e2) {
                            IOException unused3 = HttpEngineDataSource.this.z = e2;
                        }
                    } else {
                        urlRequest.followRedirect();
                    }
                } else {
                    urlRequest.followRedirect();
                }
            }
        }

        public synchronized void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            if (!this.f9866a) {
                UrlResponseInfo unused = HttpEngineDataSource.this.y = urlResponseInfo;
                HttpEngineDataSource.this.p.f();
            }
        }

        public synchronized void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
            if (!this.f9866a) {
                boolean unused = HttpEngineDataSource.this.A = true;
                HttpEngineDataSource.this.p.f();
            }
        }
    }

    private static final class UrlRequestWrapper {

        /* renamed from: a  reason: collision with root package name */
        private final UrlRequest f9868a;

        /* renamed from: b  reason: collision with root package name */
        private final UrlRequestCallback f9869b;

        UrlRequestWrapper(UrlRequest urlRequest, UrlRequestCallback urlRequestCallback) {
            this.f9868a = urlRequest;
            this.f9869b = urlRequestCallback;
        }

        public void a() {
            this.f9869b.a();
            this.f9868a.cancel();
        }

        public int b() throws InterruptedException {
            final ConditionVariable conditionVariable = new ConditionVariable();
            final int[] iArr = new int[1];
            this.f9868a.getStatus(new UrlRequest.StatusListener() {
                public void onStatus(int i2) {
                    iArr[0] = i2;
                    conditionVariable.f();
                }
            });
            conditionVariable.a();
            return iArr[0];
        }

        public UrlRequest.Callback c() {
            return this.f9869b;
        }

        public void d(ByteBuffer byteBuffer) {
            this.f9868a.read(byteBuffer);
        }

        public void e() {
            this.f9868a.start();
        }
    }

    static {
        MediaLibraryInfo.a("media3.datasource.httpengine");
    }

    @UnstableApi
    HttpEngineDataSource(HttpEngine httpEngine, Executor executor, int i2, int i3, int i4, boolean z2, boolean z3, @Nullable String str, @Nullable HttpDataSource.RequestProperties requestProperties, @Nullable Predicate<String> predicate, boolean z4) {
        super(true);
        this.f9845f = u.a(Assertions.g(httpEngine));
        this.f9846g = (Executor) Assertions.g(executor);
        this.f9847h = i2;
        this.f9848i = i3;
        this.f9849j = i4;
        this.f9850k = z2;
        this.f9851l = z3;
        this.f9852m = str;
        this.f9853n = requestProperties;
        this.r = predicate;
        this.s = z4;
    }

    private boolean K() throws InterruptedException {
        long b2 = this.q.b();
        boolean z2 = false;
        while (!z2 && b2 < this.B) {
            z2 = this.p.b((this.B - b2) + 5);
            b2 = this.q.b();
        }
        return z2;
    }

    private UrlRequest.Builder L(DataSpec dataSpec, UrlRequest.Callback callback) throws IOException {
        UrlRequest.Builder a2 = this.f9845f.newUrlRequestBuilder(dataSpec.f9779a.toString(), this.f9846g, callback).setPriority(this.f9847h).setDirectExecutorAllowed(true);
        HashMap hashMap = new HashMap();
        HttpDataSource.RequestProperties requestProperties = this.f9853n;
        if (requestProperties != null) {
            hashMap.putAll(requestProperties.c());
        }
        hashMap.putAll(this.o.c());
        hashMap.putAll(dataSpec.f9783e);
        for (Map.Entry entry : hashMap.entrySet()) {
            UrlRequest.Builder unused = a2.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        if (dataSpec.f9782d == null || hashMap.containsKey(HttpHeaders.f22875c)) {
            String a3 = HttpUtil.a(dataSpec.f9785g, dataSpec.f9786h);
            if (a3 != null) {
                UrlRequest.Builder unused2 = a2.addHeader(HttpHeaders.I, a3);
            }
            String str = this.f9852m;
            if (str != null) {
                UrlRequest.Builder unused3 = a2.addHeader(HttpHeaders.P, str);
            }
            UrlRequest.Builder unused4 = a2.setHttpMethod(dataSpec.b());
            if (dataSpec.f9782d != null) {
                UrlRequest.Builder unused5 = a2.setUploadDataProvider(new ByteArrayUploadDataProvider(dataSpec.f9782d), this.f9846g);
            }
            return a2;
        }
        throw new OpenException("HTTP request with non-empty body must set Content-Type", dataSpec, 1004, 0);
    }

    /* access modifiers changed from: private */
    public UrlRequestWrapper M(DataSpec dataSpec) throws IOException {
        UrlRequestCallback urlRequestCallback = new UrlRequestCallback();
        return new UrlRequestWrapper(L(dataSpec, urlRequestCallback).build(), urlRequestCallback);
    }

    private static int N(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int min = Math.min(byteBuffer.remaining(), byteBuffer2.remaining());
        int limit = byteBuffer.limit();
        byteBuffer.limit(byteBuffer.position() + min);
        byteBuffer2.put(byteBuffer);
        byteBuffer.limit(limit);
        return min;
    }

    @Nullable
    private static String P(Map<String, List<String>> map, String str) {
        List list = map.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (String) list.get(0);
    }

    private ByteBuffer Q() {
        if (this.x == null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(32768);
            this.x = allocateDirect;
            allocateDirect.limit(0);
        }
        return this.x;
    }

    private static boolean R(UrlResponseInfo urlResponseInfo) {
        for (Map.Entry entry : urlResponseInfo.getHeaders().getAsList()) {
            if (((String) entry.getKey()).equalsIgnoreCase("Content-Encoding")) {
                return !((String) entry.getValue()).equalsIgnoreCase("identity");
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    @Nullable
    public static String S(@Nullable List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return TextUtils.join(";", list);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0056 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void U(java.nio.ByteBuffer r6, androidx.media3.datasource.DataSpec r7) throws androidx.media3.datasource.HttpDataSource.HttpDataSourceException {
        /*
            r5 = this;
            androidx.media3.datasource.HttpEngineDataSource$UrlRequestWrapper r0 = r5.w
            java.lang.Object r0 = androidx.media3.common.util.Util.o(r0)
            androidx.media3.datasource.HttpEngineDataSource$UrlRequestWrapper r0 = (androidx.media3.datasource.HttpEngineDataSource.UrlRequestWrapper) r0
            r0.d(r6)
            r0 = 2
            r1 = 0
            androidx.media3.common.util.ConditionVariable r2 = r5.p     // Catch:{ InterruptedException -> 0x0021, SocketTimeoutException -> 0x001f }
            int r3 = r5.f9849j     // Catch:{ InterruptedException -> 0x0021, SocketTimeoutException -> 0x001f }
            long r3 = (long) r3     // Catch:{ InterruptedException -> 0x0021, SocketTimeoutException -> 0x001f }
            boolean r2 = r2.b(r3)     // Catch:{ InterruptedException -> 0x0021, SocketTimeoutException -> 0x001f }
            if (r2 == 0) goto L_0x0019
            goto L_0x0046
        L_0x0019:
            java.net.SocketTimeoutException r2 = new java.net.SocketTimeoutException     // Catch:{ InterruptedException -> 0x0021, SocketTimeoutException -> 0x001f }
            r2.<init>()     // Catch:{ InterruptedException -> 0x0021, SocketTimeoutException -> 0x001f }
            throw r2     // Catch:{ InterruptedException -> 0x0021, SocketTimeoutException -> 0x001f }
        L_0x001f:
            r2 = move-exception
            goto L_0x0023
        L_0x0021:
            goto L_0x0033
        L_0x0023:
            java.nio.ByteBuffer r3 = r5.x
            if (r6 != r3) goto L_0x0029
            r5.x = r1
        L_0x0029:
            androidx.media3.datasource.HttpDataSource$HttpDataSourceException r6 = new androidx.media3.datasource.HttpDataSource$HttpDataSourceException
            r1 = 2002(0x7d2, float:2.805E-42)
            r6.<init>((java.io.IOException) r2, (androidx.media3.datasource.DataSpec) r7, (int) r1, (int) r0)
        L_0x0030:
            r5.z = r6
            goto L_0x0046
        L_0x0033:
            java.nio.ByteBuffer r2 = r5.x
            if (r6 != r2) goto L_0x0039
            r5.x = r1
        L_0x0039:
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            r6.interrupt()
            java.io.InterruptedIOException r6 = new java.io.InterruptedIOException
            r6.<init>()
            goto L_0x0030
        L_0x0046:
            java.io.IOException r6 = r5.z
            if (r6 == 0) goto L_0x0056
            boolean r1 = r6 instanceof androidx.media3.datasource.HttpDataSource.HttpDataSourceException
            if (r1 == 0) goto L_0x0051
            androidx.media3.datasource.HttpDataSource$HttpDataSourceException r6 = (androidx.media3.datasource.HttpDataSource.HttpDataSourceException) r6
            throw r6
        L_0x0051:
            androidx.media3.datasource.HttpDataSource$HttpDataSourceException r6 = androidx.media3.datasource.HttpDataSource.HttpDataSourceException.c(r6, r7, r0)
            throw r6
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.datasource.HttpEngineDataSource.U(java.nio.ByteBuffer, androidx.media3.datasource.DataSpec):void");
    }

    private byte[] V() throws IOException {
        byte[] bArr = Util.f9651f;
        ByteBuffer Q = Q();
        while (!this.A) {
            this.p.d();
            Q.clear();
            U(Q, (DataSpec) Util.o(this.v));
            Q.flip();
            if (Q.remaining() > 0) {
                int length = bArr.length;
                bArr = Arrays.copyOf(bArr, bArr.length + Q.remaining());
                Q.get(bArr, length, Q.remaining());
            }
        }
        return bArr;
    }

    /* access modifiers changed from: private */
    public void W() {
        this.B = this.q.b() + ((long) this.f9848i);
    }

    private void X(long j2, DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        if (j2 != 0) {
            ByteBuffer Q = Q();
            while (j2 > 0) {
                try {
                    this.p.d();
                    Q.clear();
                    U(Q, dataSpec);
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedIOException();
                    } else if (!this.A) {
                        Q.flip();
                        Assertions.i(Q.hasRemaining());
                        int min = (int) Math.min((long) Q.remaining(), j2);
                        Q.position(Q.position() + min);
                        j2 -= (long) min;
                    } else {
                        throw new OpenException(dataSpec, 2008, 14);
                    }
                } catch (IOException e2) {
                    if (!(e2 instanceof HttpDataSource.HttpDataSourceException)) {
                        throw new OpenException(e2, dataSpec, e2 instanceof SocketTimeoutException ? PlaybackException.c3 : PlaybackException.b3, 14);
                    }
                    throw ((HttpDataSource.HttpDataSourceException) e2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @UnstableApi
    @Nullable
    public UrlRequest.Callback O() {
        UrlRequestWrapper urlRequestWrapper = this.w;
        if (urlRequestWrapper == null) {
            return null;
        }
        return urlRequestWrapper.c();
    }

    @UnstableApi
    public int T(ByteBuffer byteBuffer) throws HttpDataSource.HttpDataSourceException {
        int N;
        Assertions.i(this.t);
        if (byteBuffer.isDirect()) {
            boolean z2 = false;
            if (!byteBuffer.hasRemaining()) {
                return 0;
            }
            if (this.u == 0) {
                return -1;
            }
            int remaining = byteBuffer.remaining();
            ByteBuffer byteBuffer2 = this.x;
            if (byteBuffer2 == null || (N = N(byteBuffer2, byteBuffer)) == 0) {
                this.p.d();
                U(byteBuffer, (DataSpec) Util.o(this.v));
                if (this.A) {
                    this.u = 0;
                    return -1;
                }
                if (remaining > byteBuffer.remaining()) {
                    z2 = true;
                }
                Assertions.i(z2);
                int remaining2 = remaining - byteBuffer.remaining();
                long j2 = this.u;
                if (j2 != -1) {
                    this.u = j2 - ((long) remaining2);
                }
                t(remaining2);
                return remaining2;
            }
            long j3 = this.u;
            if (j3 != -1) {
                this.u = j3 - ((long) N);
            }
            t(N);
            return N;
        }
        throw new IllegalArgumentException("Passed buffer is not a direct ByteBuffer");
    }

    @UnstableApi
    public long a(DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        byte[] bArr;
        String P;
        DataSpec dataSpec2 = dataSpec;
        Assertions.g(dataSpec);
        Assertions.i(!this.t);
        this.p.d();
        W();
        this.v = dataSpec2;
        try {
            UrlRequestWrapper M = M(dataSpec);
            this.w = M;
            M.e();
            v(dataSpec);
            try {
                boolean K = K();
                IOException iOException = this.z;
                if (iOException != null) {
                    String message = iOException.getMessage();
                    if (message == null || !Ascii.g(message).contains("err_cleartext_not_permitted")) {
                        throw new OpenException(iOException, dataSpec2, (int) PlaybackException.b3, M.b());
                    }
                    throw new HttpDataSource.CleartextNotPermittedException(iOException, dataSpec2);
                } else if (K) {
                    UrlResponseInfo a2 = p.a(Assertions.g(this.y));
                    int a3 = a2.getHttpStatusCode();
                    Map a4 = a2.getHeaders().getAsMap();
                    long j2 = 0;
                    long j3 = -1;
                    if (a3 < 200 || a3 > 299) {
                        if (a3 == 416) {
                            if (dataSpec2.f9785g == HttpUtil.c(P(a4, HttpHeaders.f0))) {
                                this.t = true;
                                w(dataSpec);
                                long j4 = dataSpec2.f9786h;
                                if (j4 != -1) {
                                    return j4;
                                }
                                return 0;
                            }
                        }
                        try {
                            bArr = V();
                        } catch (IOException unused) {
                            bArr = Util.f9651f;
                        }
                        throw new HttpDataSource.InvalidResponseCodeException(a3, a2.getHttpStatusText(), a3 == 416 ? new DataSourceException(2008) : null, a4, dataSpec, bArr);
                    }
                    Predicate<String> predicate = this.r;
                    if (predicate == null || (P = P(a4, HttpHeaders.f22875c)) == null || predicate.apply(P)) {
                        if (a3 == 200) {
                            long j5 = dataSpec2.f9785g;
                            if (j5 != 0) {
                                j2 = j5;
                            }
                        }
                        if (!R(a2)) {
                            long j6 = dataSpec2.f9786h;
                            if (j6 != -1) {
                                this.u = j6;
                            } else {
                                long b2 = HttpUtil.b(P(a4, HttpHeaders.f22874b), P(a4, HttpHeaders.f0));
                                if (b2 != -1) {
                                    j3 = b2 - j2;
                                }
                                this.u = j3;
                            }
                        } else {
                            this.u = dataSpec2.f9786h;
                        }
                        this.t = true;
                        w(dataSpec);
                        X(j2, dataSpec2);
                        return this.u;
                    }
                    throw new HttpDataSource.InvalidContentTypeException(P, dataSpec2);
                } else {
                    throw new OpenException((IOException) new SocketTimeoutException(), dataSpec2, (int) PlaybackException.c3, M.b());
                }
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
                throw new OpenException((IOException) new InterruptedIOException(), dataSpec2, 1004, -1);
            }
        } catch (IOException e2) {
            if (e2 instanceof HttpDataSource.HttpDataSourceException) {
                throw ((HttpDataSource.HttpDataSourceException) e2);
            }
            throw new OpenException(e2, dataSpec2, 2000, 0);
        }
    }

    @UnstableApi
    @Nullable
    public Uri c() {
        UrlResponseInfo urlResponseInfo = this.y;
        if (urlResponseInfo == null) {
            return null;
        }
        return Uri.parse(urlResponseInfo.getUrl());
    }

    @UnstableApi
    public synchronized void close() {
        try {
            UrlRequestWrapper urlRequestWrapper = this.w;
            if (urlRequestWrapper != null) {
                urlRequestWrapper.a();
                this.w = null;
            }
            ByteBuffer byteBuffer = this.x;
            if (byteBuffer != null) {
                byteBuffer.limit(0);
            }
            this.v = null;
            this.y = null;
            this.z = null;
            this.A = false;
            if (this.t) {
                this.t = false;
                u();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    @UnstableApi
    public void f(String str, String str2) {
        this.o.e(str, str2);
    }

    @UnstableApi
    public Map<String, List<String>> getResponseHeaders() {
        UrlResponseInfo urlResponseInfo = this.y;
        return urlResponseInfo == null ? Collections.emptyMap() : urlResponseInfo.getHeaders().getAsMap();
    }

    @UnstableApi
    public int k() {
        UrlResponseInfo urlResponseInfo = this.y;
        if (urlResponseInfo == null || urlResponseInfo.getHttpStatusCode() <= 0) {
            return -1;
        }
        return this.y.getHttpStatusCode();
    }

    @UnstableApi
    public void p() {
        this.o.a();
    }

    @UnstableApi
    public void r(String str) {
        this.o.d(str);
    }

    @UnstableApi
    public int read(byte[] bArr, int i2, int i3) throws HttpDataSource.HttpDataSourceException {
        Assertions.i(this.t);
        if (i3 == 0) {
            return 0;
        }
        if (this.u == 0) {
            return -1;
        }
        ByteBuffer Q = Q();
        if (!Q.hasRemaining()) {
            this.p.d();
            Q.clear();
            U(Q, (DataSpec) Util.o(this.v));
            if (this.A) {
                this.u = 0;
                return -1;
            }
            Q.flip();
            Assertions.i(Q.hasRemaining());
        }
        long j2 = this.u;
        if (j2 == -1) {
            j2 = Long.MAX_VALUE;
        }
        int u2 = (int) Longs.u(j2, (long) Q.remaining(), (long) i3);
        Q.get(bArr, i2, u2);
        long j3 = this.u;
        if (j3 != -1) {
            this.u = j3 - ((long) u2);
        }
        t(u2);
        return u2;
    }
}
