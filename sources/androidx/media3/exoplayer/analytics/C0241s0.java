package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.s0  reason: case insensitive filesystem */
public final /* synthetic */ class C0241s0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10719a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f10720b;

    public /* synthetic */ C0241s0(AnalyticsListener.EventTime eventTime, long j2) {
        this.f10719a = eventTime;
        this.f10720b = j2;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).v(this.f10719a, this.f10720b);
    }
}
