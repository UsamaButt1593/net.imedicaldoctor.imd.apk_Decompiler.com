package androidx.media3.datasource;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@UnstableApi
public final class StatsDataSource implements DataSource {

    /* renamed from: b  reason: collision with root package name */
    private final DataSource f9899b;

    /* renamed from: c  reason: collision with root package name */
    private long f9900c;

    /* renamed from: d  reason: collision with root package name */
    private Uri f9901d = Uri.EMPTY;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, List<String>> f9902e = Collections.emptyMap();

    public StatsDataSource(DataSource dataSource) {
        this.f9899b = (DataSource) Assertions.g(dataSource);
    }

    public long a(DataSpec dataSpec) throws IOException {
        this.f9901d = dataSpec.f9779a;
        this.f9902e = Collections.emptyMap();
        long a2 = this.f9899b.a(dataSpec);
        this.f9901d = (Uri) Assertions.g(c());
        this.f9902e = getResponseHeaders();
        return a2;
    }

    @Nullable
    public Uri c() {
        return this.f9899b.c();
    }

    public void close() throws IOException {
        this.f9899b.close();
    }

    public void e(TransferListener transferListener) {
        Assertions.g(transferListener);
        this.f9899b.e(transferListener);
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this.f9899b.getResponseHeaders();
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = this.f9899b.read(bArr, i2, i3);
        if (read != -1) {
            this.f9900c += (long) read;
        }
        return read;
    }

    public long t() {
        return this.f9900c;
    }

    public Uri u() {
        return this.f9901d;
    }

    public Map<String, List<String>> v() {
        return this.f9902e;
    }

    public void w() {
        this.f9900c = 0;
    }
}
