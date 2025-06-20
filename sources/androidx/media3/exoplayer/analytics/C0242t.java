package androidx.media3.exoplayer.analytics;

import androidx.media3.common.AudioAttributes;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.t  reason: case insensitive filesystem */
public final /* synthetic */ class C0242t implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10721a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioAttributes f10722b;

    public /* synthetic */ C0242t(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        this.f10721a = eventTime;
        this.f10722b = audioAttributes;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).V(this.f10721a, this.f10722b);
    }
}
