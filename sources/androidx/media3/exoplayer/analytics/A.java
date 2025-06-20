package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class A implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10490a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f10491b;

    public /* synthetic */ A(AnalyticsListener.EventTime eventTime, String str) {
        this.f10490a = eventTime;
        this.f10491b = str;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).h(this.f10490a, this.f10491b);
    }
}
