package androidx.media3.common;

import android.os.Bundle;
import androidx.media3.common.Bundleable;
import androidx.media3.common.MediaItem;

public final /* synthetic */ class D implements Bundleable.Creator {
    public final Bundleable a(Bundle bundle) {
        return MediaItem.RequestMetadata.c(bundle);
    }
}
