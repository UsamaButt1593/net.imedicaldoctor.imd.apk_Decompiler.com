package androidx.media3.exoplayer.hls;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;

@UnstableApi
public final class DefaultHlsDataSourceFactory implements HlsDataSourceFactory {

    /* renamed from: a  reason: collision with root package name */
    private final DataSource.Factory f11375a;

    public DefaultHlsDataSourceFactory(DataSource.Factory factory) {
        this.f11375a = factory;
    }

    public DataSource a(int i2) {
        return this.f11375a.a();
    }
}
