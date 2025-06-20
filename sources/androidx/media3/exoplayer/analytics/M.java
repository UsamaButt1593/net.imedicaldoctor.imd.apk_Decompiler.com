package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class M implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10567a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f10568b;

    public /* synthetic */ M(AnalyticsListener.EventTime eventTime, int i2) {
        this.f10567a = eventTime;
        this.f10568b = i2;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).x0(this.f10567a, this.f10568b);
    }
}
