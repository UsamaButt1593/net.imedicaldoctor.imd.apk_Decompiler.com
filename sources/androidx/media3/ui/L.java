package androidx.media3.ui;

import androidx.media3.common.Player;
import androidx.media3.ui.TrackSelectionDialogBuilder;
import java.util.Map;

public final /* synthetic */ class L implements TrackSelectionDialogBuilder.DialogCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Player f14627a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f14628b;

    public /* synthetic */ L(Player player, int i2) {
        this.f14627a = player;
        this.f14628b = i2;
    }

    public final void a(boolean z, Map map) {
        TrackSelectionDialogBuilder.f(this.f14627a, this.f14628b, z, map);
    }
}
