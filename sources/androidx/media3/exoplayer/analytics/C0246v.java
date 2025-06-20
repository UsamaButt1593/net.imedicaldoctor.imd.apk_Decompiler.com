package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.v  reason: case insensitive filesystem */
public final /* synthetic */ class C0246v implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10729a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f10730b;

    public /* synthetic */ C0246v(AnalyticsListener.EventTime eventTime, long j2) {
        this.f10729a = eventTime;
        this.f10730b = j2;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).z0(this.f10729a, this.f10730b);
    }
}
