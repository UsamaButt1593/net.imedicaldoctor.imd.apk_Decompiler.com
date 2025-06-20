package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.audio.AudioSink;

public final /* synthetic */ class V implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10627a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioSink.AudioTrackConfig f10628b;

    public /* synthetic */ V(AnalyticsListener.EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
        this.f10627a = eventTime;
        this.f10628b = audioTrackConfig;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).d(this.f10627a, this.f10628b);
    }
}
