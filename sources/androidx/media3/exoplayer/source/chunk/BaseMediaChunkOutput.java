package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.extractor.DummyTrackOutput;
import androidx.media3.extractor.TrackOutput;

@UnstableApi
public final class BaseMediaChunkOutput implements ChunkExtractor.TrackOutputProvider {

    /* renamed from: c  reason: collision with root package name */
    private static final String f12266c = "BaseMediaChunkOutput";

    /* renamed from: a  reason: collision with root package name */
    private final int[] f12267a;

    /* renamed from: b  reason: collision with root package name */
    private final SampleQueue[] f12268b;

    public BaseMediaChunkOutput(int[] iArr, SampleQueue[] sampleQueueArr) {
        this.f12267a = iArr;
        this.f12268b = sampleQueueArr;
    }

    public int[] a() {
        int[] iArr = new int[this.f12268b.length];
        int i2 = 0;
        while (true) {
            SampleQueue[] sampleQueueArr = this.f12268b;
            if (i2 >= sampleQueueArr.length) {
                return iArr;
            }
            iArr[i2] = sampleQueueArr[i2].J();
            i2++;
        }
    }

    public void b(long j2) {
        for (SampleQueue d0 : this.f12268b) {
            d0.d0(j2);
        }
    }

    public TrackOutput d(int i2, int i3) {
        int i4 = 0;
        while (true) {
            int[] iArr = this.f12267a;
            if (i4 >= iArr.length) {
                Log.d(f12266c, "Unmatched track of type: " + i3);
                return new DummyTrackOutput();
            } else if (i3 == iArr[i4]) {
                return this.f12268b[i4];
            } else {
                i4++;
            }
        }
    }
}
