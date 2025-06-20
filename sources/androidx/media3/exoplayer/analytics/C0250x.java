package androidx.media3.exoplayer.analytics;

import androidx.media3.common.Tracks;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.x  reason: case insensitive filesystem */
public final /* synthetic */ class C0250x implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10733a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Tracks f10734b;

    public /* synthetic */ C0250x(AnalyticsListener.EventTime eventTime, Tracks tracks) {
        this.f10733a = eventTime;
        this.f10734b = tracks;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).M(this.f10733a, this.f10734b);
    }
}
