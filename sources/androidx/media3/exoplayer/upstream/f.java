package androidx.media3.exoplayer.upstream;

import androidx.media3.common.util.NetworkTypeObserver;

public final /* synthetic */ class f implements NetworkTypeObserver.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultBandwidthMeter f12695a;

    public /* synthetic */ f(DefaultBandwidthMeter defaultBandwidthMeter) {
        this.f12695a = defaultBandwidthMeter;
    }

    public final void a(int i2) {
        this.f12695a.q(i2);
    }
}
