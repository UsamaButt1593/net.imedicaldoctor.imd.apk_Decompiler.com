package androidx.media3.exoplayer.trackselection;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import java.util.List;
import java.util.Random;

@UnstableApi
public final class RandomTrackSelection extends BaseTrackSelection {

    /* renamed from: j  reason: collision with root package name */
    private final Random f12406j;

    /* renamed from: k  reason: collision with root package name */
    private int f12407k;

    public static final class Factory implements ExoTrackSelection.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final Random f12408a;

        public Factory() {
            this.f12408a = new Random();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ ExoTrackSelection c(ExoTrackSelection.Definition definition) {
            return new RandomTrackSelection(definition.f12389a, definition.f12390b, definition.f12391c, this.f12408a);
        }

        public ExoTrackSelection[] a(ExoTrackSelection.Definition[] definitionArr, BandwidthMeter bandwidthMeter, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            return TrackSelectionUtil.d(definitionArr, new C(this));
        }

        public Factory(int i2) {
            this.f12408a = new Random((long) i2);
        }
    }

    public RandomTrackSelection(TrackGroup trackGroup, int[] iArr, int i2, Random random) {
        super(trackGroup, iArr, i2);
        this.f12406j = random;
        this.f12407k = random.nextInt(this.f12364d);
    }

    public int e() {
        return this.f12407k;
    }

    public void m(long j2, long j3, long j4, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i2 = 0;
        for (int i3 = 0; i3 < this.f12364d; i3++) {
            if (!b(i3, elapsedRealtime)) {
                i2++;
            }
        }
        this.f12407k = this.f12406j.nextInt(i2);
        if (i2 != this.f12364d) {
            int i4 = 0;
            for (int i5 = 0; i5 < this.f12364d; i5++) {
                if (!b(i5, elapsedRealtime)) {
                    int i6 = i4 + 1;
                    if (this.f12407k == i4) {
                        this.f12407k = i5;
                        return;
                    }
                    i4 = i6;
                }
            }
        }
    }

    public int p() {
        return 3;
    }

    @Nullable
    public Object s() {
        return null;
    }
}
