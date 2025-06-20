package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class Q implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10617a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Exception f10618b;

    public /* synthetic */ Q(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.f10617a = eventTime;
        this.f10618b = exc;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).a0(this.f10617a, this.f10618b);
    }
}
