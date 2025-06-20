package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.a0  reason: case insensitive filesystem */
public final /* synthetic */ class C0206a0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10636a;

    public /* synthetic */ C0206a0(AnalyticsListener.EventTime eventTime) {
        this.f10636a = eventTime;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).J(this.f10636a);
    }
}
