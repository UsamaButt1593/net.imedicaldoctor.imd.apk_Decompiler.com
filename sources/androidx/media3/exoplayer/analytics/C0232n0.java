package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.n0  reason: case insensitive filesystem */
public final /* synthetic */ class C0232n0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10693a;

    public /* synthetic */ C0232n0(AnalyticsListener.EventTime eventTime) {
        this.f10693a = eventTime;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).D(this.f10693a);
    }
}
