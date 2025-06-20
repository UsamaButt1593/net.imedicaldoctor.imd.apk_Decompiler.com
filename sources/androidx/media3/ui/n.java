package androidx.media3.ui;

import android.view.View;
import androidx.media3.common.Player;
import androidx.media3.common.TrackGroup;
import androidx.media3.ui.PlayerControlView;

public final /* synthetic */ class n implements View.OnClickListener {
    public final /* synthetic */ Player X;
    public final /* synthetic */ TrackGroup Y;
    public final /* synthetic */ PlayerControlView.TrackInformation Z;
    public final /* synthetic */ PlayerControlView.TrackSelectionAdapter s;

    public /* synthetic */ n(PlayerControlView.TrackSelectionAdapter trackSelectionAdapter, Player player, TrackGroup trackGroup, PlayerControlView.TrackInformation trackInformation) {
        this.s = trackSelectionAdapter;
        this.X = player;
        this.Y = trackGroup;
        this.Z = trackInformation;
    }

    public final void onClick(View view) {
        this.s.g0(this.X, this.Y, this.Z, view);
    }
}
