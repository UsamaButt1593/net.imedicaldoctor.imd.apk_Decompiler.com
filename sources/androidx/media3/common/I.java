package androidx.media3.common;

import android.os.Bundle;
import androidx.media3.common.Bundleable;

public final /* synthetic */ class I implements Bundleable.Creator {
    public final Bundleable a(Bundle bundle) {
        return new PlaybackException(bundle);
    }
}
