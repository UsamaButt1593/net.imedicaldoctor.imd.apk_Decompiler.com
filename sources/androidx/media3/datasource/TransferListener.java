package androidx.media3.datasource;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface TransferListener {
    void d(DataSource dataSource, DataSpec dataSpec, boolean z, int i2);

    void e(DataSource dataSource, DataSpec dataSpec, boolean z);

    void g(DataSource dataSource, DataSpec dataSpec, boolean z);

    void h(DataSource dataSource, DataSpec dataSpec, boolean z);
}
