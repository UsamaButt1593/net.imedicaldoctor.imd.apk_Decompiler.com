package androidx.media3.datasource;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@UnstableApi
public final class PriorityDataSource implements DataSource {

    /* renamed from: b  reason: collision with root package name */
    private final DataSource f9878b;

    /* renamed from: c  reason: collision with root package name */
    private final PriorityTaskManager f9879c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9880d;

    public static final class Factory implements DataSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final DataSource.Factory f9881a;

        /* renamed from: b  reason: collision with root package name */
        private final PriorityTaskManager f9882b;

        /* renamed from: c  reason: collision with root package name */
        private final int f9883c;

        public Factory(DataSource.Factory factory, PriorityTaskManager priorityTaskManager, int i2) {
            this.f9881a = factory;
            this.f9882b = priorityTaskManager;
            this.f9883c = i2;
        }

        /* renamed from: c */
        public PriorityDataSource a() {
            return new PriorityDataSource(this.f9881a.a(), this.f9882b, this.f9883c);
        }
    }

    public PriorityDataSource(DataSource dataSource, PriorityTaskManager priorityTaskManager, int i2) {
        this.f9878b = (DataSource) Assertions.g(dataSource);
        this.f9879c = (PriorityTaskManager) Assertions.g(priorityTaskManager);
        this.f9880d = i2;
    }

    public long a(DataSpec dataSpec) throws IOException {
        this.f9879c.d(this.f9880d);
        return this.f9878b.a(dataSpec);
    }

    @Nullable
    public Uri c() {
        return this.f9878b.c();
    }

    public void close() throws IOException {
        this.f9878b.close();
    }

    public void e(TransferListener transferListener) {
        Assertions.g(transferListener);
        this.f9878b.e(transferListener);
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this.f9878b.getResponseHeaders();
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        this.f9879c.d(this.f9880d);
        return this.f9878b.read(bArr, i2, i3);
    }
}
