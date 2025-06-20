package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.h0  reason: case insensitive filesystem */
public final /* synthetic */ class C0220h0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10664a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f10665b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f10666c;

    public /* synthetic */ C0220h0(AnalyticsListener.EventTime eventTime, Object obj, long j2) {
        this.f10664a = eventTime;
        this.f10665b = obj;
        this.f10666c = j2;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).b(this.f10664a, this.f10665b, this.f10666c);
    }
}
