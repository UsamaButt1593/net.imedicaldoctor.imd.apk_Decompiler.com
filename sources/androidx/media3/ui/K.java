package androidx.media3.ui;

import android.content.DialogInterface;

public final /* synthetic */ class K implements DialogInterface.OnClickListener {
    public final /* synthetic */ TrackSelectionView X;
    public final /* synthetic */ TrackSelectionDialogBuilder s;

    public /* synthetic */ K(TrackSelectionDialogBuilder trackSelectionDialogBuilder, TrackSelectionView trackSelectionView) {
        this.s = trackSelectionDialogBuilder;
        this.X = trackSelectionView;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.s.g(this.X, dialogInterface, i2);
    }
}
