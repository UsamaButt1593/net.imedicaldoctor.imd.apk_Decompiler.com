package androidx.media3.exoplayer;

import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.MediaSource;
import com.google.common.base.Supplier;

/* renamed from: androidx.media3.exoplayer.t  reason: case insensitive filesystem */
public final /* synthetic */ class C0344t implements Supplier {
    public final /* synthetic */ MediaSource.Factory s;

    public /* synthetic */ C0344t(MediaSource.Factory factory) {
        this.s = factory;
    }

    public final Object get() {
        return ExoPlayer.Builder.M(this.s);
    }
}
