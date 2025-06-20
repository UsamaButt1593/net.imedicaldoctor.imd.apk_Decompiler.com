package androidx.media3.exoplayer.upstream;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import java.io.FileNotFoundException;
import java.io.IOException;

@UnstableApi
public class DefaultLoadErrorHandlingPolicy implements LoadErrorHandlingPolicy {

    /* renamed from: d  reason: collision with root package name */
    public static final int f12550d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f12551e = 6;

    /* renamed from: f  reason: collision with root package name */
    public static final long f12552f = 60000;
    @Deprecated

    /* renamed from: g  reason: collision with root package name */
    public static final long f12553g = 60000;

    /* renamed from: h  reason: collision with root package name */
    public static final long f12554h = 300000;

    /* renamed from: i  reason: collision with root package name */
    private static final int f12555i = -1;

    /* renamed from: c  reason: collision with root package name */
    private final int f12556c;

    public DefaultLoadErrorHandlingPolicy() {
        this(-1);
    }

    public long a(LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        IOException iOException = loadErrorInfo.f12567c;
        return ((iOException instanceof ParserException) || (iOException instanceof FileNotFoundException) || (iOException instanceof HttpDataSource.CleartextNotPermittedException) || (iOException instanceof Loader.UnexpectedLoaderException) || DataSourceException.a(iOException)) ? C.f9084b : (long) Math.min((loadErrorInfo.f12568d - 1) * 1000, 5000);
    }

    public /* synthetic */ void b(long j2) {
        g.a(this, j2);
    }

    public int c(int i2) {
        int i3 = this.f12556c;
        if (i3 == -1) {
            return i2 == 7 ? 6 : 3;
        }
        return i3;
    }

    @Nullable
    public LoadErrorHandlingPolicy.FallbackSelection d(LoadErrorHandlingPolicy.FallbackOptions fallbackOptions, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        if (!e(loadErrorInfo.f12567c)) {
            return null;
        }
        if (fallbackOptions.a(1)) {
            return new LoadErrorHandlingPolicy.FallbackSelection(1, 300000);
        }
        if (fallbackOptions.a(2)) {
            return new LoadErrorHandlingPolicy.FallbackSelection(2, 60000);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean e(IOException iOException) {
        if (!(iOException instanceof HttpDataSource.InvalidResponseCodeException)) {
            return false;
        }
        int i2 = ((HttpDataSource.InvalidResponseCodeException) iOException).a3;
        return i2 == 403 || i2 == 404 || i2 == 410 || i2 == 416 || i2 == 500 || i2 == 503;
    }

    public DefaultLoadErrorHandlingPolicy(int i2) {
        this.f12556c = i2;
    }
}
