package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import java.util.List;

public final /* synthetic */ class F implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10553a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f10554b;

    public /* synthetic */ F(AnalyticsListener.EventTime eventTime, List list) {
        this.f10553a = eventTime;
        this.f10554b = list;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).o(this.f10553a, this.f10554b);
    }
}
