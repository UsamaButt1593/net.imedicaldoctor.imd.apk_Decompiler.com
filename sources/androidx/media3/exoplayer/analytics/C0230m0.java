package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.audio.AudioSink;

/* renamed from: androidx.media3.exoplayer.analytics.m0  reason: case insensitive filesystem */
public final /* synthetic */ class C0230m0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10689a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioSink.AudioTrackConfig f10690b;

    public /* synthetic */ C0230m0(AnalyticsListener.EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
        this.f10689a = eventTime;
        this.f10690b = audioTrackConfig;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).g(this.f10689a, this.f10690b);
    }
}
