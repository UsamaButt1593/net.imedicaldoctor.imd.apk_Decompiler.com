package androidx.media3.exoplayer.analytics;

import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class C implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10521a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlaybackException f10522b;

    public /* synthetic */ C(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        this.f10521a = eventTime;
        this.f10522b = playbackException;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).H(this.f10521a, this.f10522b);
    }
}
