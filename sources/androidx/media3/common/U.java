package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class U implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f9357a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f9358b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f9359c;

    public /* synthetic */ U(int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
        this.f9357a = i2;
        this.f9358b = positionInfo;
        this.f9359c = positionInfo2;
    }

    public final void f(Object obj) {
        SimpleBasePlayer.B5(this.f9357a, this.f9358b, this.f9359c, (Player.Listener) obj);
    }
}
