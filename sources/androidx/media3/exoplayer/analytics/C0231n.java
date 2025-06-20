package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.n  reason: case insensitive filesystem */
public final /* synthetic */ class C0231n implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10691a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f10692b;

    public /* synthetic */ C0231n(AnalyticsListener.EventTime eventTime, float f2) {
        this.f10691a = eventTime;
        this.f10692b = f2;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).v0(this.f10691a, this.f10692b);
    }
}
