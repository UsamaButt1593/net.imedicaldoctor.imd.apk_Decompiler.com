package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.t0  reason: case insensitive filesystem */
public final /* synthetic */ class C0243t0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10723a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f10724b;

    public /* synthetic */ C0243t0(AnalyticsListener.EventTime eventTime, long j2) {
        this.f10723a = eventTime;
        this.f10724b = j2;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).O(this.f10723a, this.f10724b);
    }
}
