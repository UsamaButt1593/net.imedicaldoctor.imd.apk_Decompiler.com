package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class H implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10555a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f10556b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f10557c;

    public /* synthetic */ H(AnalyticsListener.EventTime eventTime, long j2, int i2) {
        this.f10555a = eventTime;
        this.f10556b = j2;
        this.f10557c = i2;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).Z(this.f10555a, this.f10556b, this.f10557c);
    }
}
