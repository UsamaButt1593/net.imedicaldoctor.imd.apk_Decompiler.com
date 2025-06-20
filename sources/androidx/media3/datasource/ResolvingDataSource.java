package androidx.media3.datasource;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@UnstableApi
public final class ResolvingDataSource implements DataSource {

    /* renamed from: b  reason: collision with root package name */
    private final DataSource f9894b;

    /* renamed from: c  reason: collision with root package name */
    private final Resolver f9895c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9896d;

    public static final class Factory implements DataSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final DataSource.Factory f9897a;

        /* renamed from: b  reason: collision with root package name */
        private final Resolver f9898b;

        public Factory(DataSource.Factory factory, Resolver resolver) {
            this.f9897a = factory;
            this.f9898b = resolver;
        }

        /* renamed from: c */
        public ResolvingDataSource a() {
            return new ResolvingDataSource(this.f9897a.a(), this.f9898b);
        }
    }

    public interface Resolver {
        Uri a(Uri uri);

        DataSpec b(DataSpec dataSpec) throws IOException;
    }

    public ResolvingDataSource(DataSource dataSource, Resolver resolver) {
        this.f9894b = dataSource;
        this.f9895c = resolver;
    }

    public long a(DataSpec dataSpec) throws IOException {
        DataSpec b2 = this.f9895c.b(dataSpec);
        this.f9896d = true;
        return this.f9894b.a(b2);
    }

    @Nullable
    public Uri c() {
        Uri c2 = this.f9894b.c();
        if (c2 == null) {
            return null;
        }
        return this.f9895c.a(c2);
    }

    public void close() throws IOException {
        if (this.f9896d) {
            this.f9896d = false;
            this.f9894b.close();
        }
    }

    public void e(TransferListener transferListener) {
        Assertions.g(transferListener);
        this.f9894b.e(transferListener);
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this.f9894b.getResponseHeaders();
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        return this.f9894b.read(bArr, i2, i3);
    }
}
