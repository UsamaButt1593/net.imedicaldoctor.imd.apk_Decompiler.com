package androidx.media3.exoplayer.drm;

import androidx.media3.exoplayer.drm.ExoMediaDrm;
import java.util.UUID;

public final /* synthetic */ class G implements ExoMediaDrm.Provider {
    public final ExoMediaDrm a(UUID uuid) {
        return FrameworkMediaDrm.P(uuid);
    }
}
