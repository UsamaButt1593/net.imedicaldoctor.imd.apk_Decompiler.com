package androidx.media3.ui;

import android.view.View;
import androidx.media3.ui.PlayerControlView;

/* renamed from: androidx.media3.ui.m  reason: case insensitive filesystem */
public final /* synthetic */ class C0373m implements View.OnClickListener {
    public final /* synthetic */ PlayerControlView.TextTrackSelectionAdapter s;

    public /* synthetic */ C0373m(PlayerControlView.TextTrackSelectionAdapter textTrackSelectionAdapter) {
        this.s = textTrackSelectionAdapter;
    }

    public final void onClick(View view) {
        this.s.m0(view);
    }
}
