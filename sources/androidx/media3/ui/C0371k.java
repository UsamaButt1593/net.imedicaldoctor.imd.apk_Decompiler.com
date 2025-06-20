package androidx.media3.ui;

import android.view.View;
import androidx.media3.ui.PlayerControlView;

/* renamed from: androidx.media3.ui.k  reason: case insensitive filesystem */
public final /* synthetic */ class C0371k implements View.OnClickListener {
    public final /* synthetic */ int X;
    public final /* synthetic */ PlayerControlView.PlaybackSpeedAdapter s;

    public /* synthetic */ C0371k(PlayerControlView.PlaybackSpeedAdapter playbackSpeedAdapter, int i2) {
        this.s = playbackSpeedAdapter;
        this.X = i2;
    }

    public final void onClick(View view) {
        this.s.f0(this.X, view);
    }
}
