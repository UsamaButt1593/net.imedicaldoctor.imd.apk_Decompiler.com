package androidx.media3.exoplayer.trackselection;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import java.util.List;

@UnstableApi
public interface ExoTrackSelection extends TrackSelection {

    public static final class Definition {

        /* renamed from: d  reason: collision with root package name */
        private static final String f12388d = "ETSDefinition";

        /* renamed from: a  reason: collision with root package name */
        public final TrackGroup f12389a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f12390b;

        /* renamed from: c  reason: collision with root package name */
        public final int f12391c;

        public Definition(TrackGroup trackGroup, int... iArr) {
            this(trackGroup, iArr, 0);
        }

        public Definition(TrackGroup trackGroup, int[] iArr, int i2) {
            if (iArr.length == 0) {
                Log.e(f12388d, "Empty tracks are not allowed", new IllegalArgumentException());
            }
            this.f12389a = trackGroup;
            this.f12390b = iArr;
            this.f12391c = i2;
        }
    }

    public interface Factory {
        ExoTrackSelection[] a(Definition[] definitionArr, BandwidthMeter bandwidthMeter, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline);
    }

    long a();

    boolean b(int i2, long j2);

    int e();

    boolean f(long j2, Chunk chunk, List<? extends MediaChunk> list);

    void g(boolean z);

    void h();

    void j();

    int l(long j2, List<? extends MediaChunk> list);

    void m(long j2, long j3, long j4, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr);

    int n();

    Format o();

    int p();

    boolean q(int i2, long j2);

    void r(float f2);

    @Nullable
    Object s();

    void t();

    void u();
}
