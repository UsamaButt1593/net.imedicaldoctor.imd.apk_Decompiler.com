package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.g0  reason: case insensitive filesystem */
public final /* synthetic */ class C0218g0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10659a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f10660b;

    public /* synthetic */ C0218g0(AnalyticsListener.EventTime eventTime, int i2) {
        this.f10659a = eventTime;
        this.f10660b = i2;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).P(this.f10659a, this.f10660b);
    }
}
