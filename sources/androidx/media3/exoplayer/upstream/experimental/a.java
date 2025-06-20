package androidx.media3.exoplayer.upstream.experimental;

import androidx.media3.common.util.NetworkTypeObserver;

public final /* synthetic */ class a implements NetworkTypeObserver.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExperimentalBandwidthMeter f12691a;

    public /* synthetic */ a(ExperimentalBandwidthMeter experimentalBandwidthMeter) {
        this.f12691a = experimentalBandwidthMeter;
    }

    public final void a(int i2) {
        this.f12691a.o(i2);
    }
}
