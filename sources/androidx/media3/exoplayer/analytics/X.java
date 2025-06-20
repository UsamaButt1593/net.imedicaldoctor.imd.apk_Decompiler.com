package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class X implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10630a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f10631b;

    public /* synthetic */ X(AnalyticsListener.EventTime eventTime, int i2) {
        this.f10630a = eventTime;
        this.f10631b = i2;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).B0(this.f10630a, this.f10631b);
    }
}
