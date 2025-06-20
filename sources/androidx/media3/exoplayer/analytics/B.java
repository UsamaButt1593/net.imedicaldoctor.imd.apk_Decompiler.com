package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class B implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10518a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f10519b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f10520c;

    public /* synthetic */ B(AnalyticsListener.EventTime eventTime, int i2, long j2) {
        this.f10518a = eventTime;
        this.f10519b = i2;
        this.f10520c = j2;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).u(this.f10518a, this.f10519b, this.f10520c);
    }
}
