package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.j  reason: case insensitive filesystem */
public final /* synthetic */ class C0223j implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10671a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f10672b;

    public /* synthetic */ C0223j(AnalyticsListener.EventTime eventTime, int i2) {
        this.f10671a = eventTime;
        this.f10672b = i2;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).Y(this.f10671a, this.f10672b);
    }
}
