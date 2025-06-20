package androidx.media3.exoplayer.upstream;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSpec;

@UnstableApi
public interface TimeToFirstByteEstimator {
    void a(DataSpec dataSpec);

    long b();

    void c(DataSpec dataSpec);

    void reset();
}
