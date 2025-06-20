package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class L implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10565a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f10566b;

    public /* synthetic */ L(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f10565a = eventTime;
        this.f10566b = decoderCounters;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).b0(this.f10565a, this.f10566b);
    }
}
