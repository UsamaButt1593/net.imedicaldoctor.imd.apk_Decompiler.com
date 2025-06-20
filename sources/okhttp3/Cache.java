package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Cache implements Closeable, Flushable {
    private static final int a3 = 201105;
    private static final int b3 = 0;
    private static final int c3 = 1;
    private static final int d3 = 2;
    final DiskLruCache X;
    private int X2;
    int Y;
    private int Y2;
    int Z;
    private int Z2;
    final InternalCache s;

    private final class CacheRequestImpl implements CacheRequest {

        /* renamed from: a  reason: collision with root package name */
        private final DiskLruCache.Editor f30739a;

        /* renamed from: b  reason: collision with root package name */
        private Sink f30740b;

        /* renamed from: c  reason: collision with root package name */
        private Sink f30741c;

        /* renamed from: d  reason: collision with root package name */
        boolean f30742d;

        CacheRequestImpl(final DiskLruCache.Editor editor) {
            this.f30739a = editor;
            Sink e2 = editor.e(1);
            this.f30740b = e2;
            this.f30741c = new ForwardingSink(e2, Cache.this) {
                public void close() throws IOException {
                    synchronized (Cache.this) {
                        try {
                            CacheRequestImpl cacheRequestImpl = CacheRequestImpl.this;
                            if (!cacheRequestImpl.f30742d) {
                                cacheRequestImpl.f30742d = true;
                                Cache.this.Y++;
                                super.close();
                                editor.c();
                            }
                        } catch (Throwable th) {
                            while (true) {
                                throw th;
                            }
                        }
                    }
                }
            };
        }

        public void abort() {
            synchronized (Cache.this) {
                try {
                    if (!this.f30742d) {
                        this.f30742d = true;
                        Cache.this.Z++;
                        Util.g(this.f30740b);
                        try {
                            this.f30739a.a();
                        } catch (IOException unused) {
                        }
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        public Sink k() {
            return this.f30741c;
        }
    }

    private static class CacheResponseBody extends ResponseBody {
        final DiskLruCache.Snapshot X;
        @Nullable
        private final String X2;
        private final BufferedSource Y;
        @Nullable
        private final String Z;

        CacheResponseBody(final DiskLruCache.Snapshot snapshot, String str, String str2) {
            this.X = snapshot;
            this.Z = str;
            this.X2 = str2;
            this.Y = Okio.e(new ForwardingSource(snapshot.e(1)) {
                public void close() throws IOException {
                    snapshot.close();
                    super.close();
                }
            });
        }

        public long f() {
            try {
                String str = this.X2;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        public MediaType h() {
            String str = this.Z;
            if (str != null) {
                return MediaType.d(str);
            }
            return null;
        }

        public BufferedSource q() {
            return this.Y;
        }
    }

    private static final class Entry {

        /* renamed from: k  reason: collision with root package name */
        private static final String f30744k = (Platform.k().l() + "-Sent-Millis");

        /* renamed from: l  reason: collision with root package name */
        private static final String f30745l = (Platform.k().l() + "-Received-Millis");

        /* renamed from: a  reason: collision with root package name */
        private final String f30746a;

        /* renamed from: b  reason: collision with root package name */
        private final Headers f30747b;

        /* renamed from: c  reason: collision with root package name */
        private final String f30748c;

        /* renamed from: d  reason: collision with root package name */
        private final Protocol f30749d;

        /* renamed from: e  reason: collision with root package name */
        private final int f30750e;

        /* renamed from: f  reason: collision with root package name */
        private final String f30751f;

        /* renamed from: g  reason: collision with root package name */
        private final Headers f30752g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private final Handshake f30753h;

        /* renamed from: i  reason: collision with root package name */
        private final long f30754i;

        /* renamed from: j  reason: collision with root package name */
        private final long f30755j;

        Entry(Response response) {
            this.f30746a = response.A().k().toString();
            this.f30747b = HttpHeaders.u(response);
            this.f30748c = response.A().g();
            this.f30749d = response.x();
            this.f30750e = response.f();
            this.f30751f = response.s();
            this.f30752g = response.p();
            this.f30753h = response.h();
            this.f30754i = response.C();
            this.f30755j = response.y();
        }

        private boolean a() {
            return this.f30746a.startsWith("https://");
        }

        private List<Certificate> c(BufferedSource bufferedSource) throws IOException {
            int r = Cache.r(bufferedSource);
            if (r == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(r);
                for (int i2 = 0; i2 < r; i2++) {
                    String O1 = bufferedSource.O1();
                    Buffer buffer = new Buffer();
                    buffer.g2(ByteString.j(O1));
                    arrayList.add(instance.generateCertificate(buffer.z()));
                }
                return arrayList;
            } catch (CertificateException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        private void e(BufferedSink bufferedSink, List<Certificate> list) throws IOException {
            try {
                bufferedSink.L2((long) list.size()).writeByte(10);
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    bufferedSink.W0(ByteString.U(list.get(i2).getEncoded()).e()).writeByte(10);
                }
            } catch (CertificateEncodingException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        public boolean b(Request request, Response response) {
            return this.f30746a.equals(request.k().toString()) && this.f30748c.equals(request.g()) && HttpHeaders.v(response, this.f30747b, request);
        }

        public Response d(DiskLruCache.Snapshot snapshot) {
            String d2 = this.f30752g.d(com.google.common.net.HttpHeaders.f22875c);
            String d3 = this.f30752g.d(com.google.common.net.HttpHeaders.f22874b);
            return new Response.Builder().q(new Request.Builder().q(this.f30746a).j(this.f30748c, (RequestBody) null).i(this.f30747b).b()).n(this.f30749d).g(this.f30750e).k(this.f30751f).j(this.f30752g).b(new CacheResponseBody(snapshot, d2, d3)).h(this.f30753h).r(this.f30754i).o(this.f30755j).c();
        }

        public void f(DiskLruCache.Editor editor) throws IOException {
            BufferedSink d2 = Okio.d(editor.e(0));
            d2.W0(this.f30746a).writeByte(10);
            d2.W0(this.f30748c).writeByte(10);
            d2.L2((long) this.f30747b.l()).writeByte(10);
            int l2 = this.f30747b.l();
            for (int i2 = 0; i2 < l2; i2++) {
                d2.W0(this.f30747b.g(i2)).W0(": ").W0(this.f30747b.n(i2)).writeByte(10);
            }
            d2.W0(new StatusLine(this.f30749d, this.f30750e, this.f30751f).toString()).writeByte(10);
            d2.L2((long) (this.f30752g.l() + 2)).writeByte(10);
            int l3 = this.f30752g.l();
            for (int i3 = 0; i3 < l3; i3++) {
                d2.W0(this.f30752g.g(i3)).W0(": ").W0(this.f30752g.n(i3)).writeByte(10);
            }
            d2.W0(f30744k).W0(": ").L2(this.f30754i).writeByte(10);
            d2.W0(f30745l).W0(": ").L2(this.f30755j).writeByte(10);
            if (a()) {
                d2.writeByte(10);
                d2.W0(this.f30753h.a().d()).writeByte(10);
                e(d2, this.f30753h.f());
                e(d2, this.f30753h.d());
                d2.W0(this.f30753h.h().c()).writeByte(10);
            }
            d2.close();
        }

        Entry(Source source) throws IOException {
            try {
                BufferedSource e2 = Okio.e(source);
                this.f30746a = e2.O1();
                this.f30748c = e2.O1();
                Headers.Builder builder = new Headers.Builder();
                int r = Cache.r(e2);
                for (int i2 = 0; i2 < r; i2++) {
                    builder.e(e2.O1());
                }
                this.f30747b = builder.h();
                StatusLine b2 = StatusLine.b(e2.O1());
                this.f30749d = b2.f31100a;
                this.f30750e = b2.f31101b;
                this.f30751f = b2.f31102c;
                Headers.Builder builder2 = new Headers.Builder();
                int r2 = Cache.r(e2);
                for (int i3 = 0; i3 < r2; i3++) {
                    builder2.e(e2.O1());
                }
                String str = f30744k;
                String i4 = builder2.i(str);
                String str2 = f30745l;
                String i5 = builder2.i(str2);
                builder2.j(str);
                builder2.j(str2);
                long j2 = 0;
                this.f30754i = i4 != null ? Long.parseLong(i4) : 0;
                this.f30755j = i5 != null ? Long.parseLong(i5) : j2;
                this.f30752g = builder2.h();
                if (a()) {
                    String O1 = e2.O1();
                    if (O1.length() <= 0) {
                        this.f30753h = Handshake.c(!e2.o0() ? TlsVersion.a(e2.O1()) : TlsVersion.SSL_3_0, CipherSuite.a(e2.O1()), c(e2), c(e2));
                    } else {
                        throw new IOException("expected \"\" but was \"" + O1 + "\"");
                    }
                } else {
                    this.f30753h = null;
                }
            } finally {
                source.close();
            }
        }
    }

    public Cache(File file, long j2) {
        this(file, j2, FileSystem.f31224a);
    }

    private void b(@Nullable DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.a();
            } catch (IOException unused) {
            }
        }
    }

    public static String k(HttpUrl httpUrl) {
        return ByteString.n(httpUrl.toString()).S().w();
    }

    static int r(BufferedSource bufferedSource) throws IOException {
        try {
            long H0 = bufferedSource.H0();
            String O1 = bufferedSource.O1();
            if (H0 >= 0 && H0 <= 2147483647L && O1.isEmpty()) {
                return (int) H0;
            }
            throw new IOException("expected an int but was \"" + H0 + O1 + "\"");
        } catch (NumberFormatException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public synchronized int A() {
        return this.Z;
    }

    public synchronized int C() {
        return this.Y;
    }

    public void c() throws IOException {
        this.X.e();
    }

    public void close() throws IOException {
        this.X.close();
    }

    public File d() {
        return this.X.n();
    }

    public void e() throws IOException {
        this.X.i();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Response f(Request request) {
        try {
            DiskLruCache.Snapshot k2 = this.X.k(k(request.k()));
            if (k2 == null) {
                return null;
            }
            try {
                Entry entry = new Entry(k2.e(0));
                Response d2 = entry.d(k2);
                if (entry.b(request, d2)) {
                    return d2;
                }
                Util.g(d2.b());
                return null;
            } catch (IOException unused) {
                Util.g(k2);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    public void flush() throws IOException {
        this.X.flush();
    }

    public synchronized int h() {
        return this.Y2;
    }

    public void i() throws IOException {
        this.X.q();
    }

    public boolean isClosed() {
        return this.X.isClosed();
    }

    public long n() {
        return this.X.p();
    }

    public synchronized int p() {
        return this.X2;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CacheRequest q(Response response) {
        DiskLruCache.Editor editor;
        String g2 = response.A().g();
        if (HttpMethod.a(response.A().g())) {
            try {
                s(response.A());
            } catch (IOException unused) {
            }
            return null;
        } else if (!g2.equals("GET") || HttpHeaders.e(response)) {
            return null;
        } else {
            Entry entry = new Entry(response);
            try {
                editor = this.X.f(k(response.A().k()));
                if (editor == null) {
                    return null;
                }
                try {
                    entry.f(editor);
                    return new CacheRequestImpl(editor);
                } catch (IOException unused2) {
                    b(editor);
                    return null;
                }
            } catch (IOException unused3) {
                editor = null;
                b(editor);
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void s(Request request) throws IOException {
        this.X.x(k(request.k()));
    }

    public synchronized int t() {
        return this.Z2;
    }

    public long u() throws IOException {
        return this.X.C();
    }

    /* access modifiers changed from: package-private */
    public synchronized void v() {
        this.Y2++;
    }

    /* access modifiers changed from: package-private */
    public synchronized void w(CacheStrategy cacheStrategy) {
        try {
            this.Z2++;
            if (cacheStrategy.f30985a != null) {
                this.X2++;
            } else if (cacheStrategy.f30986b != null) {
                this.Y2++;
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void x(Response response, Response response2) {
        DiskLruCache.Editor editor;
        Entry entry = new Entry(response2);
        try {
            editor = ((CacheResponseBody) response.b()).X.c();
            if (editor != null) {
                try {
                    entry.f(editor);
                    editor.c();
                } catch (IOException unused) {
                }
            }
        } catch (IOException unused2) {
            editor = null;
            b(editor);
        }
    }

    public Iterator<String> y() throws IOException {
        return new Iterator<String>() {
            @Nullable
            String X;
            boolean Y;
            final Iterator<DiskLruCache.Snapshot> s;

            {
                this.s = Cache.this.X.F();
            }

            /* renamed from: a */
            public String next() {
                if (hasNext()) {
                    String str = this.X;
                    this.X = null;
                    this.Y = true;
                    return str;
                }
                throw new NoSuchElementException();
            }

            public boolean hasNext() {
                if (this.X != null) {
                    return true;
                }
                this.Y = false;
                while (this.s.hasNext()) {
                    DiskLruCache.Snapshot next = this.s.next();
                    try {
                        this.X = Okio.e(next.e(0)).O1();
                        return true;
                    } catch (IOException unused) {
                    } finally {
                        next.close();
                    }
                }
                return false;
            }

            public void remove() {
                if (this.Y) {
                    this.s.remove();
                    return;
                }
                throw new IllegalStateException("remove() before next()");
            }
        };
    }

    Cache(File file, long j2, FileSystem fileSystem) {
        this.s = new InternalCache() {
            public void a() {
                Cache.this.v();
            }

            public void b(CacheStrategy cacheStrategy) {
                Cache.this.w(cacheStrategy);
            }

            public void c(Request request) throws IOException {
                Cache.this.s(request);
            }

            public CacheRequest d(Response response) throws IOException {
                return Cache.this.q(response);
            }

            public Response e(Request request) throws IOException {
                return Cache.this.f(request);
            }

            public void f(Response response, Response response2) {
                Cache.this.x(response, response2);
            }
        };
        this.X = DiskLruCache.d(fileSystem, file, a3, 2, j2);
    }
}
