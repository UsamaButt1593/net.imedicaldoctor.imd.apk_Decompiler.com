package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.y  reason: case insensitive filesystem */
public final /* synthetic */ class C0252y implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10735a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f10736b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f10737c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f10738d;

    public /* synthetic */ C0252y(AnalyticsListener.EventTime eventTime, String str, long j2, long j3) {
        this.f10735a = eventTime;
        this.f10736b = str;
        this.f10737c = j2;
        this.f10738d = j3;
    }

    public final void f(Object obj) {
        DefaultAnalyticsCollector.e2(this.f10735a, this.f10736b, this.f10737c, this.f10738d, (AnalyticsListener) obj);
    }
}
