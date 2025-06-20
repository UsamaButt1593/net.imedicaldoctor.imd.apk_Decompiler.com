package androidx.media3.exoplayer.analytics;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* renamed from: androidx.media3.exoplayer.analytics.i  reason: case insensitive filesystem */
public final /* synthetic */ class C0221i implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f10667a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Player.Commands f10668b;

    public /* synthetic */ C0221i(AnalyticsListener.EventTime eventTime, Player.Commands commands) {
        this.f10667a = eventTime;
        this.f10668b = commands;
    }

    public final void f(Object obj) {
        ((AnalyticsListener) obj).o0(this.f10667a, this.f10668b);
    }
}
