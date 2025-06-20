package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.d  reason: case insensitive filesystem */
public final /* synthetic */ class C0211d implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10647a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f10648b;

    public /* synthetic */ C0211d(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f10647a = eventTime;
        this.f10648b = decoderCounters;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).d0(this.f10647a, this.f10648b);
    }
}
