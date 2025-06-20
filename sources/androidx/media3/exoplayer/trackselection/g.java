package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.Format;
import com.google.common.base.Predicate;

public final /* synthetic */ class g implements Predicate {
    public final /* synthetic */ DefaultTrackSelector s;

    public /* synthetic */ g(DefaultTrackSelector defaultTrackSelector) {
        this.s = defaultTrackSelector;
    }

    public final boolean apply(Object obj) {
        return this.s.Q((Format) obj);
    }
}
