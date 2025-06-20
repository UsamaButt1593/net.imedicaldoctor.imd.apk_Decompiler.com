package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.z  reason: case insensitive filesystem */
public final /* synthetic */ class C0254z implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10739a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f10740b;

    public /* synthetic */ C0254z(AnalyticsListener.EventTime eventTime, int i2) {
        this.f10739a = eventTime;
        this.f10740b = i2;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).k(this.f10739a, this.f10740b);
    }
}
