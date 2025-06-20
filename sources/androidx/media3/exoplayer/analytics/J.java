package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;

public final /* synthetic */ class J implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10560a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f10561b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f10562c;

    public /* synthetic */ J(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f10560a = eventTime;
        this.f10561b = loadEventInfo;
        this.f10562c = mediaLoadData;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).q0(this.f10560a, this.f10561b, this.f10562c);
    }
}
