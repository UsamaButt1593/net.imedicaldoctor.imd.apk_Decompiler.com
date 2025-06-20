package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.source.MediaLoadData;

public final /* synthetic */ class I implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10558a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f10559b;

    public /* synthetic */ I(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        this.f10558a = eventTime;
        this.f10559b = mediaLoadData;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).e0(this.f10558a, this.f10559b);
    }
}
