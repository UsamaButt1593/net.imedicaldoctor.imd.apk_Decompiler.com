package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.p  reason: case insensitive filesystem */
public final /* synthetic */ class C0235p implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10698a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f10699b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f10700c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f10701d;

    public /* synthetic */ C0235p(AnalyticsListener.EventTime eventTime, int i2, long j2, long j3) {
        this.f10698a = eventTime;
        this.f10699b = i2;
        this.f10700c = j2;
        this.f10701d = j3;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).A0(this.f10698a, this.f10699b, this.f10700c, this.f10701d);
    }
}
