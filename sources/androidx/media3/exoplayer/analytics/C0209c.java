package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.c  reason: case insensitive filesystem */
public final /* synthetic */ class C0209c implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10642a;

    public /* synthetic */ C0209c(AnalyticsListener.EventTime eventTime) {
        this.f10642a = eventTime;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).h0(this.f10642a);
    }
}
