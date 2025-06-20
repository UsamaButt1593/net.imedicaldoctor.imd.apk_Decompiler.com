package androidx.media3.exoplayer.hls.playlist;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.offline.FilterableManifest;
import java.util.Collections;
import java.util.List;

@UnstableApi
public abstract class HlsPlaylist implements FilterableManifest<HlsPlaylist> {

    /* renamed from: a  reason: collision with root package name */
    public final String f11597a;

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f11598b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f11599c;

    protected HlsPlaylist(String str, List<String> list, boolean z) {
        this.f11597a = str;
        this.f11598b = Collections.unmodifiableList(list);
        this.f11599c = z;
    }
}
