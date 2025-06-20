package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.p0  reason: case insensitive filesystem */
public final /* synthetic */ class C0236p0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10702a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f10703b;

    public /* synthetic */ C0236p0(AnalyticsListener.EventTime eventTime, boolean z) {
        this.f10702a = eventTime;
        this.f10703b = z;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).w0(this.f10702a, this.f10703b);
    }
}
