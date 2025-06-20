package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.k0  reason: case insensitive filesystem */
public final /* synthetic */ class C0226k0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10678a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f10679b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f10680c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f10681d;

    public /* synthetic */ C0226k0(AnalyticsListener.EventTime eventTime, String str, long j2, long j3) {
        this.f10678a = eventTime;
        this.f10679b = str;
        this.f10680c = j2;
        this.f10681d = j3;
    }

    public final void f(Object obj) {
        DefaultAnalyticsCollector.i3(this.f10678a, this.f10679b, this.f10680c, this.f10681d, (AnalyticsListener) obj);
    }
}
