package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;

public final /* synthetic */ class S implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10619a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f10620b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f10621c;

    public /* synthetic */ S(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f10619a = eventTime;
        this.f10620b = loadEventInfo;
        this.f10621c = mediaLoadData;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).L(this.f10619a, this.f10620b, this.f10621c);
    }
}
