package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class U implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10625a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f10626b;

    public /* synthetic */ U(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f10625a = eventTime;
        this.f10626b = decoderCounters;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).B(this.f10625a, this.f10626b);
    }
}
