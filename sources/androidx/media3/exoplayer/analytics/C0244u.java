package androidx.media3.exoplayer.analytics;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.u  reason: case insensitive filesystem */
public final /* synthetic */ class C0244u implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10725a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Metadata f10726b;

    public /* synthetic */ C0244u(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        this.f10725a = eventTime;
        this.f10726b = metadata;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).m(this.f10725a, this.f10726b);
    }
}
