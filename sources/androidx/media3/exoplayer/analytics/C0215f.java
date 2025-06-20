package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.f  reason: case insensitive filesystem */
public final /* synthetic */ class C0215f implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10653a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f10654b;

    public /* synthetic */ C0215f(AnalyticsListener.EventTime eventTime, boolean z) {
        this.f10653a = eventTime;
        this.f10654b = z;
    }

    public final void f(Object obj) {
        DefaultAnalyticsCollector.D2(this.f10653a, this.f10654b, (AnalyticsListener) obj);
    }
}
