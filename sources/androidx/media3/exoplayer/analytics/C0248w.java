package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.w  reason: case insensitive filesystem */
public final /* synthetic */ class C0248w implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10731a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f10732b;

    public /* synthetic */ C0248w(AnalyticsListener.EventTime eventTime, boolean z) {
        this.f10731a = eventTime;
        this.f10732b = z;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).l(this.f10731a, this.f10732b);
    }
}
