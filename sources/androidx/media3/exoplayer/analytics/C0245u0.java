package androidx.media3.exoplayer.analytics;

import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.u0  reason: case insensitive filesystem */
public final /* synthetic */ class C0245u0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10727a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TrackSelectionParameters f10728b;

    public /* synthetic */ C0245u0(AnalyticsListener.EventTime eventTime, TrackSelectionParameters trackSelectionParameters) {
        this.f10727a = eventTime;
        this.f10728b = trackSelectionParameters;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).T(this.f10727a, this.f10728b);
    }
}
