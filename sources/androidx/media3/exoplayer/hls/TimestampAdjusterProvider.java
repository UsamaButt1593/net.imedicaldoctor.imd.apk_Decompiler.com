package androidx.media3.exoplayer.hls;

import android.util.SparseArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class TimestampAdjusterProvider {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<TimestampAdjuster> f11543a = new SparseArray<>();

    public TimestampAdjuster a(int i2) {
        TimestampAdjuster timestampAdjuster = this.f11543a.get(i2);
        if (timestampAdjuster != null) {
            return timestampAdjuster;
        }
        TimestampAdjuster timestampAdjuster2 = new TimestampAdjuster(TimestampAdjuster.f9635f);
        this.f11543a.put(i2, timestampAdjuster2);
        return timestampAdjuster2;
    }

    public void b() {
        this.f11543a.clear();
    }
}
