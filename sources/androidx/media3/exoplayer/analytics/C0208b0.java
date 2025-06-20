package androidx.media3.exoplayer.analytics;

import androidx.media3.common.Format;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.b0  reason: case insensitive filesystem */
public final /* synthetic */ class C0208b0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10639a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Format f10640b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderReuseEvaluation f10641c;

    public /* synthetic */ C0208b0(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f10639a = eventTime;
        this.f10640b = format;
        this.f10641c = decoderReuseEvaluation;
    }

    public final void f(Object obj) {
        DefaultAnalyticsCollector.i2(this.f10639a, this.f10640b, this.f10641c, (AnalyticsListener) obj);
    }
}
