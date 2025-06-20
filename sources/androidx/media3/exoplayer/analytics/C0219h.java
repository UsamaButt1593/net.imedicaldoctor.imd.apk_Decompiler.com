package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;

/* renamed from: androidx.media3.exoplayer.analytics.h  reason: case insensitive filesystem */
public final /* synthetic */ class C0219h implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10661a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f10662b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f10663c;

    public /* synthetic */ C0219h(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f10661a = eventTime;
        this.f10662b = loadEventInfo;
        this.f10663c = mediaLoadData;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).y(this.f10661a, this.f10662b, this.f10663c);
    }
}
