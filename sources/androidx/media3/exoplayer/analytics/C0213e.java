package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.e  reason: case insensitive filesystem */
public final /* synthetic */ class C0213e implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10651a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f10652b;

    public /* synthetic */ C0213e(AnalyticsListener.EventTime eventTime, long j2) {
        this.f10651a = eventTime;
        this.f10652b = j2;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).X(this.f10651a, this.f10652b);
    }
}
