package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class V0 implements Supplier {
    public final /* synthetic */ PlaybackParameters X;
    public final /* synthetic */ SimpleBasePlayer.State s;

    public /* synthetic */ V0(SimpleBasePlayer.State state, PlaybackParameters playbackParameters) {
        this.s = state;
        this.X = playbackParameters;
    }

    public final Object get() {
        return this.s.a().i0(this.X).O();
    }
}
