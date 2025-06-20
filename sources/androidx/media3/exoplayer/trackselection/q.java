package androidx.media3.exoplayer.trackselection;

import android.os.Bundle;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import com.google.common.base.Function;

public final /* synthetic */ class q implements Function {
    public final Object apply(Object obj) {
        return DefaultTrackSelector.SelectionOverride.c((Bundle) obj);
    }
}
