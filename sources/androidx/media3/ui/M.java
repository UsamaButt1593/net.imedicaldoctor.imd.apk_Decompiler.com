package androidx.media3.ui;

import androidx.media3.ui.TrackSelectionView;
import java.util.Comparator;

public final /* synthetic */ class M implements Comparator {
    public final /* synthetic */ Comparator s;

    public /* synthetic */ M(Comparator comparator) {
        this.s = comparator;
    }

    public final int compare(Object obj, Object obj2) {
        return this.s.compare(((TrackSelectionView.TrackInfo) obj).a(), ((TrackSelectionView.TrackInfo) obj2).a());
    }
}
