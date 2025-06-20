package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.o0  reason: case insensitive filesystem */
public final /* synthetic */ class C0234o0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10696a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Exception f10697b;

    public /* synthetic */ C0234o0(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.f10696a = eventTime;
        this.f10697b = exc;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).u0(this.f10696a, this.f10697b);
    }
}
