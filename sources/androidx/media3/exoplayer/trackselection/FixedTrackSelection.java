package androidx.media3.exoplayer.trackselection;

import androidx.annotation.Nullable;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import java.util.List;

@UnstableApi
public final class FixedTrackSelection extends BaseTrackSelection {

    /* renamed from: j  reason: collision with root package name */
    private final int f12392j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private final Object f12393k;

    public FixedTrackSelection(TrackGroup trackGroup, int i2) {
        this(trackGroup, i2, 0);
    }

    public int e() {
        return 0;
    }

    public void m(long j2, long j3, long j4, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
    }

    public int p() {
        return this.f12392j;
    }

    @Nullable
    public Object s() {
        return this.f12393k;
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i2, int i3) {
        this(trackGroup, i2, i3, 0, (Object) null);
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i2, int i3, int i4, @Nullable Object obj) {
        super(trackGroup, new int[]{i2}, i3);
        this.f12392j = i4;
        this.f12393k = obj;
    }
}
