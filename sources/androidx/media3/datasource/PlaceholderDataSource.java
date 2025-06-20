package androidx.media3.datasource;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import java.io.IOException;
import java.util.Map;

@UnstableApi
public final class PlaceholderDataSource implements DataSource {

    /* renamed from: b  reason: collision with root package name */
    public static final PlaceholderDataSource f9876b = new PlaceholderDataSource();

    /* renamed from: c  reason: collision with root package name */
    public static final DataSource.Factory f9877c = new I();

    private PlaceholderDataSource() {
    }

    public static /* synthetic */ PlaceholderDataSource t() {
        return new PlaceholderDataSource();
    }

    public long a(DataSpec dataSpec) throws IOException {
        throw new IOException("PlaceholderDataSource cannot be opened");
    }

    @Nullable
    public Uri c() {
        return null;
    }

    public void close() {
    }

    public void e(TransferListener transferListener) {
    }

    public /* synthetic */ Map getResponseHeaders() {
        return C0194c.a(this);
    }

    public int read(byte[] bArr, int i2, int i3) {
        throw new UnsupportedOperationException();
    }
}
