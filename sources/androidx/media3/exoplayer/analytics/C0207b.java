package androidx.media3.exoplayer.analytics;

import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.b  reason: case insensitive filesystem */
public final /* synthetic */ class C0207b implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10637a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlaybackParameters f10638b;

    public /* synthetic */ C0207b(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        this.f10637a = eventTime;
        this.f10638b = playbackParameters;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).e(this.f10637a, this.f10638b);
    }
}
