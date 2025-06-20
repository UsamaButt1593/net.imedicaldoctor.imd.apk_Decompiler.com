package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.o  reason: case insensitive filesystem */
public final /* synthetic */ class C0233o implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10694a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Exception f10695b;

    public /* synthetic */ C0233o(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.f10694a = eventTime;
        this.f10695b = exc;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).p0(this.f10694a, this.f10695b);
    }
}
