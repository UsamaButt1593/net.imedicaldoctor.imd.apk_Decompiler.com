package androidx.media3.exoplayer.trackselection;

import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import java.util.Comparator;
import java.util.List;

/* renamed from: androidx.media3.exoplayer.trackselection.c  reason: case insensitive filesystem */
public final /* synthetic */ class C0348c implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return DefaultTrackSelector.TextTrackInfo.c((List) obj, (List) obj2);
    }
}
