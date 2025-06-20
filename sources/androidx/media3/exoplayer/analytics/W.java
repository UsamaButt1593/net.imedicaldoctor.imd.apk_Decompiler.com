package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class W implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10629a;

    public /* synthetic */ W(AnalyticsListener.EventTime eventTime) {
        this.f10629a = eventTime;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).K(this.f10629a);
    }
}
