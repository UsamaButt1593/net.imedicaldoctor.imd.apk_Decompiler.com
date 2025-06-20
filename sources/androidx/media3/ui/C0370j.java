package androidx.media3.ui;

import android.view.View;
import androidx.media3.ui.PlayerControlView;

/* renamed from: androidx.media3.ui.j  reason: case insensitive filesystem */
public final /* synthetic */ class C0370j implements View.OnClickListener {
    public final /* synthetic */ PlayerControlView.AudioTrackSelectionAdapter s;

    public /* synthetic */ C0370j(PlayerControlView.AudioTrackSelectionAdapter audioTrackSelectionAdapter) {
        this.s = audioTrackSelectionAdapter;
    }

    public final void onClick(View view) {
        this.s.n0(view);
    }
}
