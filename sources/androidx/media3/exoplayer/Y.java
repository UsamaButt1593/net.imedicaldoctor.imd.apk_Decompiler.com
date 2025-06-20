package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class Y implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f10484a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f10485b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f10486c;

    public /* synthetic */ Y(int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
        this.f10484a = i2;
        this.f10485b = positionInfo;
        this.f10486c = positionInfo2;
    }

    public final void f(Object obj) {
        ExoPlayerImpl.C4(this.f10484a, this.f10485b, this.f10486c, (Player.Listener) obj);
    }
}
