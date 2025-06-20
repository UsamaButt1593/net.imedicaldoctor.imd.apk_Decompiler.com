package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.l  reason: case insensitive filesystem */
public final /* synthetic */ class C0227l implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10682a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f10683b;

    public /* synthetic */ C0227l(AnalyticsListener.EventTime eventTime, boolean z) {
        this.f10682a = eventTime;
        this.f10683b = z;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).q(this.f10682a, this.f10683b);
    }
}
