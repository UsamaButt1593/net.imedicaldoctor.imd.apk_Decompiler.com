package androidx.media3.exoplayer.analytics;

import androidx.media3.common.DeviceInfo;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class O implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10576a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeviceInfo f10577b;

    public /* synthetic */ O(AnalyticsListener.EventTime eventTime, DeviceInfo deviceInfo) {
        this.f10576a = eventTime;
        this.f10577b = deviceInfo;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).g0(this.f10576a, this.f10577b);
    }
}
