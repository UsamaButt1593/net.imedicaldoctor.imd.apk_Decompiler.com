package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class D implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10523a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f10524b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f10525c;

    public /* synthetic */ D(AnalyticsListener.EventTime eventTime, int i2, boolean z) {
        this.f10523a = eventTime;
        this.f10524b = i2;
        this.f10525c = z;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).j(this.f10523a, this.f10524b, this.f10525c);
    }
}
