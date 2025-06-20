package androidx.media3.exoplayer.analytics;

import androidx.media3.common.Format;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

public final /* synthetic */ class T implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10622a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Format f10623b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderReuseEvaluation f10624c;

    public /* synthetic */ T(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f10622a = eventTime;
        this.f10623b = format;
        this.f10624c = decoderReuseEvaluation;
    }

    public final void f(Object obj) {
        DefaultAnalyticsCollector.n3(this.f10622a, this.f10623b, this.f10624c, (AnalyticsListener) obj);
    }
}
