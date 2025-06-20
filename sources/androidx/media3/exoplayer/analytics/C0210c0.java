package androidx.media3.exoplayer.analytics;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.c0  reason: case insensitive filesystem */
public final /* synthetic */ class C0210c0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10643a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f10644b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f10645c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f10646d;

    public /* synthetic */ C0210c0(AnalyticsListener.EventTime eventTime, int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
        this.f10643a = eventTime;
        this.f10644b = i2;
        this.f10645c = positionInfo;
        this.f10646d = positionInfo2;
    }

    public final void f(Object obj) {
        DefaultAnalyticsCollector.V2(this.f10643a, this.f10644b, this.f10645c, this.f10646d, (AnalyticsListener) obj);
    }
}
