package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import java.io.IOException;

/* renamed from: androidx.media3.exoplayer.analytics.q  reason: case insensitive filesystem */
public final /* synthetic */ class C0237q implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10704a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f10705b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f10706c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ IOException f10707d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f10708e;

    public /* synthetic */ C0237q(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        this.f10704a = eventTime;
        this.f10705b = loadEventInfo;
        this.f10706c = mediaLoadData;
        this.f10707d = iOException;
        this.f10708e = z;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).y0(this.f10704a, this.f10705b, this.f10706c, this.f10707d, this.f10708e);
    }
}
