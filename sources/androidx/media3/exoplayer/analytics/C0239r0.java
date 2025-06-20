package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.r0  reason: case insensitive filesystem */
public final /* synthetic */ class C0239r0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10713a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f10714b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f10715c;

    public /* synthetic */ C0239r0(AnalyticsListener.EventTime eventTime, int i2, int i3) {
        this.f10713a = eventTime;
        this.f10714b = i2;
        this.f10715c = i3;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).j0(this.f10713a, this.f10714b, this.f10715c);
    }
}
