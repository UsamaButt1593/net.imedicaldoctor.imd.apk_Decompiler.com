package androidx.media3.exoplayer.analytics;

import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class Y implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10632a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaMetadata f10633b;

    public /* synthetic */ Y(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        this.f10632a = eventTime;
        this.f10633b = mediaMetadata;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).i0(this.f10632a, this.f10633b);
    }
}
