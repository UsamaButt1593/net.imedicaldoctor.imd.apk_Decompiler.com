package androidx.media3.exoplayer.offline;

import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.trackselection.D;
import androidx.media3.exoplayer.trackselection.TrackSelector;

public final /* synthetic */ class b implements TrackSelector.InvalidationListener {
    public /* synthetic */ void a(Renderer renderer) {
        D.a(this, renderer);
    }

    public final void c() {
        DownloadHelper.L();
    }
}
