package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.m  reason: case insensitive filesystem */
public final /* synthetic */ class C0229m implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10685a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f10686b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f10687c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f10688d;

    public /* synthetic */ C0229m(AnalyticsListener.EventTime eventTime, int i2, long j2, long j3) {
        this.f10685a = eventTime;
        this.f10686b = i2;
        this.f10687c = j2;
        this.f10688d = j3;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).E(this.f10685a, this.f10686b, this.f10687c, this.f10688d);
    }
}
