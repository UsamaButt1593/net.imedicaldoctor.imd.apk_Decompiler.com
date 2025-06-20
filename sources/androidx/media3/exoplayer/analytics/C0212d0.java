package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.d0  reason: case insensitive filesystem */
public final /* synthetic */ class C0212d0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10649a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f10650b;

    public /* synthetic */ C0212d0(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f10649a = eventTime;
        this.f10650b = decoderCounters;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).r0(this.f10649a, this.f10650b);
    }
}
