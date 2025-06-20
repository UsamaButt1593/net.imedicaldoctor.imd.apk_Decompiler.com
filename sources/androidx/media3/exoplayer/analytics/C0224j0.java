package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.j0  reason: case insensitive filesystem */
public final /* synthetic */ class C0224j0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10673a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Exception f10674b;

    public /* synthetic */ C0224j0(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.f10673a = eventTime;
        this.f10674b = exc;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).F(this.f10673a, this.f10674b);
    }
}
