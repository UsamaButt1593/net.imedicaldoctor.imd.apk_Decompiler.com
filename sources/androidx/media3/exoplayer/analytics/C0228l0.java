package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.l0  reason: case insensitive filesystem */
public final /* synthetic */ class C0228l0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10684a;

    public /* synthetic */ C0228l0(AnalyticsListener.EventTime eventTime) {
        this.f10684a = eventTime;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).n0(this.f10684a);
    }
}
