package androidx.media3.exoplayer.analytics;

import androidx.media3.common.VideoSize;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class Z implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10634a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoSize f10635b;

    public /* synthetic */ Z(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        this.f10634a = eventTime;
        this.f10635b = videoSize;
    }

    public final void f(Object obj) {
        DefaultAnalyticsCollector.o3(this.f10634a, this.f10635b, (AnalyticsListener) obj);
    }
}
