package androidx.media3.datasource;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@UnstableApi
public final class TeeDataSource implements DataSource {

    /* renamed from: b  reason: collision with root package name */
    private final DataSource f9903b;

    /* renamed from: c  reason: collision with root package name */
    private final DataSink f9904c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9905d;

    /* renamed from: e  reason: collision with root package name */
    private long f9906e;

    public TeeDataSource(DataSource dataSource, DataSink dataSink) {
        this.f9903b = (DataSource) Assertions.g(dataSource);
        this.f9904c = (DataSink) Assertions.g(dataSink);
    }

    public long a(DataSpec dataSpec) throws IOException {
        long a2 = this.f9903b.a(dataSpec);
        this.f9906e = a2;
        if (a2 == 0) {
            return 0;
        }
        if (dataSpec.f9786h == -1 && a2 != -1) {
            dataSpec = dataSpec.f(0, a2);
        }
        this.f9905d = true;
        this.f9904c.a(dataSpec);
        return this.f9906e;
    }

    @Nullable
    public Uri c() {
        return this.f9903b.c();
    }

    public void close() throws IOException {
        try {
            this.f9903b.close();
        } finally {
            if (this.f9905d) {
                this.f9905d = false;
                this.f9904c.close();
            }
        }
    }

    public void e(TransferListener transferListener) {
        Assertions.g(transferListener);
        this.f9903b.e(transferListener);
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this.f9903b.getResponseHeaders();
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f9906e == 0) {
            return -1;
        }
        int read = this.f9903b.read(bArr, i2, i3);
        if (read > 0) {
            this.f9904c.write(bArr, i2, read);
            long j2 = this.f9906e;
            if (j2 != -1) {
                this.f9906e = j2 - ((long) read);
            }
        }
        return read;
    }
}
