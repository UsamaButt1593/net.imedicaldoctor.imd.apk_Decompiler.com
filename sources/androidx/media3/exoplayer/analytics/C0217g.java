package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.g  reason: case insensitive filesystem */
public final /* synthetic */ class C0217g implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10657a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f10658b;

    public /* synthetic */ C0217g(AnalyticsListener.EventTime eventTime, String str) {
        this.f10657a = eventTime;
        this.f10658b = str;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).f(this.f10657a, this.f10658b);
    }
}
