package androidx.media3.datasource;

import androidx.annotation.Nullable;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import com.google.common.base.Ascii;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface HttpDataSource extends DataSource {
    @UnstableApi

    /* renamed from: a  reason: collision with root package name */
    public static final Predicate<String> f9841a = new C0200i();

    @UnstableApi
    public static abstract class BaseFactory implements Factory {

        /* renamed from: a  reason: collision with root package name */
        private final RequestProperties f9842a = new RequestProperties();

        @CanIgnoreReturnValue
        public final Factory b(Map<String, String> map) {
            this.f9842a.b(map);
            return this;
        }

        /* access modifiers changed from: protected */
        public abstract HttpDataSource c(RequestProperties requestProperties);

        public final HttpDataSource a() {
            return c(this.f9842a);
        }
    }

    public static final class CleartextNotPermittedException extends HttpDataSourceException {
        @UnstableApi
        public CleartextNotPermittedException(IOException iOException, DataSpec dataSpec) {
            super("Cleartext HTTP traffic not permitted. See https://developer.android.com/guide/topics/media/issues/cleartext-not-permitted", iOException, dataSpec, PlaybackException.h3, 1);
        }
    }

    public interface Factory extends DataSource.Factory {
        @UnstableApi
        /* bridge */ /* synthetic */ DataSource a();

        @UnstableApi
        HttpDataSource a();

        @UnstableApi
        Factory b(Map<String, String> map);
    }

    public static class HttpDataSourceException extends DataSourceException {
        public static final int X2 = 1;
        public static final int Y2 = 2;
        public static final int Z2 = 3;
        @UnstableApi
        public final DataSpec Y;
        public final int Z;

        @Documented
        @Target({ElementType.TYPE_USE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }

        @UnstableApi
        @Deprecated
        public HttpDataSourceException(DataSpec dataSpec, int i2) {
            this(dataSpec, 2000, i2);
        }

        private static int b(int i2, int i3) {
            return (i2 == 2000 && i3 == 1) ? PlaybackException.b3 : i2;
        }

        @UnstableApi
        public static HttpDataSourceException c(IOException iOException, DataSpec dataSpec, int i2) {
            String message = iOException.getMessage();
            int i3 = iOException instanceof SocketTimeoutException ? PlaybackException.c3 : iOException instanceof InterruptedIOException ? 1004 : (message == null || !Ascii.g(message).matches("cleartext.*not permitted.*")) ? PlaybackException.b3 : PlaybackException.h3;
            return i3 == 2007 ? new CleartextNotPermittedException(iOException, dataSpec) : new HttpDataSourceException(iOException, dataSpec, i3, i2);
        }

        @UnstableApi
        public HttpDataSourceException(DataSpec dataSpec, int i2, int i3) {
            super(b(i2, i3));
            this.Y = dataSpec;
            this.Z = i3;
        }

        @UnstableApi
        @Deprecated
        public HttpDataSourceException(IOException iOException, DataSpec dataSpec, int i2) {
            this(iOException, dataSpec, 2000, i2);
        }

        @UnstableApi
        public HttpDataSourceException(IOException iOException, DataSpec dataSpec, int i2, int i3) {
            super((Throwable) iOException, b(i2, i3));
            this.Y = dataSpec;
            this.Z = i3;
        }

        @UnstableApi
        @Deprecated
        public HttpDataSourceException(String str, DataSpec dataSpec, int i2) {
            this(str, dataSpec, 2000, i2);
        }

        @UnstableApi
        public HttpDataSourceException(String str, DataSpec dataSpec, int i2, int i3) {
            super(str, b(i2, i3));
            this.Y = dataSpec;
            this.Z = i3;
        }

        @UnstableApi
        @Deprecated
        public HttpDataSourceException(String str, IOException iOException, DataSpec dataSpec, int i2) {
            this(str, iOException, dataSpec, 2000, i2);
        }

        @UnstableApi
        public HttpDataSourceException(String str, @Nullable IOException iOException, DataSpec dataSpec, int i2, int i3) {
            super(str, iOException, b(i2, i3));
            this.Y = dataSpec;
            this.Z = i3;
        }
    }

    public static final class InvalidContentTypeException extends HttpDataSourceException {
        public final String a3;

        @UnstableApi
        public InvalidContentTypeException(String str, DataSpec dataSpec) {
            super("Invalid content type: " + str, dataSpec, (int) PlaybackException.d3, 1);
            this.a3 = str;
        }
    }

    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public final int a3;
        @Nullable
        public final String b3;
        @UnstableApi
        public final Map<String, List<String>> c3;
        public final byte[] d3;

        @UnstableApi
        public InvalidResponseCodeException(int i2, @Nullable String str, @Nullable IOException iOException, Map<String, List<String>> map, DataSpec dataSpec, byte[] bArr) {
            super("Response code: " + i2, iOException, dataSpec, PlaybackException.e3, 1);
            this.a3 = i2;
            this.b3 = str;
            this.c3 = map;
            this.d3 = bArr;
        }
    }

    @UnstableApi
    public static final class RequestProperties {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, String> f9843a = new HashMap();
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private Map<String, String> f9844b;

        public synchronized void a() {
            this.f9844b = null;
            this.f9843a.clear();
        }

        public synchronized void b(Map<String, String> map) {
            this.f9844b = null;
            this.f9843a.clear();
            this.f9843a.putAll(map);
        }

        public synchronized Map<String, String> c() {
            try {
                if (this.f9844b == null) {
                    this.f9844b = Collections.unmodifiableMap(new HashMap(this.f9843a));
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
            return this.f9844b;
        }

        public synchronized void d(String str) {
            this.f9844b = null;
            this.f9843a.remove(str);
        }

        public synchronized void e(String str, String str2) {
            this.f9844b = null;
            this.f9843a.put(str, str2);
        }

        public synchronized void f(Map<String, String> map) {
            this.f9844b = null;
            this.f9843a.putAll(map);
        }
    }

    @UnstableApi
    long a(DataSpec dataSpec) throws HttpDataSourceException;

    @UnstableApi
    void close() throws HttpDataSourceException;

    @UnstableApi
    void f(String str, String str2);

    @UnstableApi
    Map<String, List<String>> getResponseHeaders();

    @UnstableApi
    int k();

    @UnstableApi
    void p();

    @UnstableApi
    void r(String str);

    @UnstableApi
    int read(byte[] bArr, int i2, int i3) throws HttpDataSourceException;
}
