package androidx.media3.exoplayer.analytics;

import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.q0  reason: case insensitive filesystem */
public final /* synthetic */ class C0238q0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10709a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaMetadata f10710b;

    public /* synthetic */ C0238q0(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        this.f10709a = eventTime;
        this.f10710b = mediaMetadata;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).U(this.f10709a, this.f10710b);
    }
}
