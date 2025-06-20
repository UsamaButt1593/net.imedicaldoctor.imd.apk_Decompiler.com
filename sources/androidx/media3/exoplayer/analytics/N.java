package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class N implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10574a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f10575b;

    public /* synthetic */ N(AnalyticsListener.EventTime eventTime, int i2) {
        this.f10574a = eventTime;
        this.f10575b = i2;
    }

    public final void f(Object obj) {
        DefaultAnalyticsCollector.z2(this.f10574a, this.f10575b, (AnalyticsListener) obj);
    }
}
