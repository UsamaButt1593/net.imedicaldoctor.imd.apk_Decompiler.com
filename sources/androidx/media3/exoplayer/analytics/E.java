package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class E implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10550a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f10551b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f10552c;

    public /* synthetic */ E(AnalyticsListener.EventTime eventTime, boolean z, int i2) {
        this.f10550a = eventTime;
        this.f10551b = z;
        this.f10552c = i2;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).z(this.f10550a, this.f10551b, this.f10552c);
    }
}
