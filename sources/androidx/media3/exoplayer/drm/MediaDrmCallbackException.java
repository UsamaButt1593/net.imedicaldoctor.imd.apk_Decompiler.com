package androidx.media3.exoplayer.drm;

import android.net.Uri;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSpec;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@UnstableApi
public final class MediaDrmCallbackException extends IOException {
    public final Uri X;
    public final Map<String, List<String>> Y;
    public final long Z;
    public final DataSpec s;

    public MediaDrmCallbackException(DataSpec dataSpec, Uri uri, Map<String, List<String>> map, long j2, Throwable th) {
        super(th);
        this.s = dataSpec;
        this.X = uri;
        this.Y = map;
        this.Z = j2;
    }
}
