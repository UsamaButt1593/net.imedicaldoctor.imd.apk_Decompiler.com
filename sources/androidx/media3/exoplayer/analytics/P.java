package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class P implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10578a;

    public /* synthetic */ P(AnalyticsListener.EventTime eventTime) {
        this.f10578a = eventTime;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).p(this.f10578a);
    }
}
