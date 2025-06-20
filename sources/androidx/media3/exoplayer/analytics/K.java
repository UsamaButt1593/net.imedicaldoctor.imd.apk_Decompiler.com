package androidx.media3.exoplayer.analytics;

import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class K implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10563a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlaybackException f10564b;

    public /* synthetic */ K(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        this.f10563a = eventTime;
        this.f10564b = playbackException;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).r(this.f10563a, this.f10564b);
    }
}
