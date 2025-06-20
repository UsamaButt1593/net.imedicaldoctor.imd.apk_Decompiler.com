package androidx.media3.exoplayer.upstream;

import androidx.media3.exoplayer.upstream.SlidingPercentile;
import java.util.Comparator;

public final /* synthetic */ class h implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return SlidingPercentile.g((SlidingPercentile.Sample) obj, (SlidingPercentile.Sample) obj2);
    }
}
