package androidx.media3.exoplayer.offline;

import androidx.media3.common.StreamKey;
import androidx.media3.common.util.UnstableApi;
import java.util.List;

@UnstableApi
public interface FilterableManifest<T> {
    T a(List<StreamKey> list);
}
