package androidx.media3.common;

import android.os.Bundle;
import androidx.media3.common.Bundleable;
import androidx.media3.common.Player;

public final /* synthetic */ class M implements Bundleable.Creator {
    public final Bundleable a(Bundle bundle) {
        return Player.PositionInfo.d(bundle);
    }
}
