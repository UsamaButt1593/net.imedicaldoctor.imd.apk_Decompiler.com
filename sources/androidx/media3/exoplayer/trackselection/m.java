package androidx.media3.exoplayer.trackselection;

import android.os.Bundle;
import androidx.media3.common.Bundleable;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;

public final /* synthetic */ class m implements Bundleable.Creator {
    public final Bundleable a(Bundle bundle) {
        return DefaultTrackSelector.Parameters.P(bundle);
    }
}
