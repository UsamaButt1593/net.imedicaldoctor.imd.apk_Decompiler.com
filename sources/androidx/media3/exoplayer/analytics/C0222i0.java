package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.source.MediaLoadData;

/* renamed from: androidx.media3.exoplayer.analytics.i0  reason: case insensitive filesystem */
public final /* synthetic */ class C0222i0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10669a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f10670b;

    public /* synthetic */ C0222i0(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        this.f10669a = eventTime;
        this.f10670b = mediaLoadData;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).n(this.f10669a, this.f10670b);
    }
}
