package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.s  reason: case insensitive filesystem */
public final /* synthetic */ class C0240s implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10716a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f10717b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f10718c;

    public /* synthetic */ C0240s(AnalyticsListener.EventTime eventTime, boolean z, int i2) {
        this.f10716a = eventTime;
        this.f10717b = z;
        this.f10718c = i2;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).C(this.f10716a, this.f10717b, this.f10718c);
    }
}
