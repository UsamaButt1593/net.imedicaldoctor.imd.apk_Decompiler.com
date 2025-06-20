package androidx.media3.exoplayer.trackselection;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.Tracks;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;

@UnstableApi
public final class TrackSelectionUtil {

    public interface AdaptiveTrackSelectionFactory {
        ExoTrackSelection a(ExoTrackSelection.Definition definition);
    }

    private TrackSelectionUtil() {
    }

    public static Tracks a(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, TrackSelection[] trackSelectionArr) {
        List[] listArr = new List[trackSelectionArr.length];
        for (int i2 = 0; i2 < trackSelectionArr.length; i2++) {
            TrackSelection trackSelection = trackSelectionArr[i2];
            listArr[i2] = trackSelection != null ? ImmutableList.K(trackSelection) : ImmutableList.I();
        }
        return b(mappedTrackInfo, listArr);
    }

    public static Tracks b(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, List<? extends TrackSelection>[] listArr) {
        boolean z;
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo2 = mappedTrackInfo;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i2 = 0; i2 < mappedTrackInfo.d(); i2++) {
            TrackGroupArray h2 = mappedTrackInfo2.h(i2);
            List<? extends TrackSelection> list = listArr[i2];
            for (int i3 = 0; i3 < h2.s; i3++) {
                TrackGroup d2 = h2.d(i3);
                boolean z2 = mappedTrackInfo2.a(i2, i3, false) != 0;
                int i4 = d2.s;
                int[] iArr = new int[i4];
                boolean[] zArr = new boolean[i4];
                for (int i5 = 0; i5 < d2.s; i5++) {
                    iArr[i5] = mappedTrackInfo2.i(i2, i3, i5);
                    int i6 = 0;
                    while (true) {
                        if (i6 >= list.size()) {
                            z = false;
                            break;
                        }
                        TrackSelection trackSelection = (TrackSelection) list.get(i6);
                        if (trackSelection.d().equals(d2) && trackSelection.v(i5) != -1) {
                            z = true;
                            break;
                        }
                        i6++;
                    }
                    zArr[i5] = z;
                }
                builder.g(new Tracks.Group(d2, z2, iArr, zArr));
            }
        }
        TrackGroupArray k2 = mappedTrackInfo.k();
        for (int i7 = 0; i7 < k2.s; i7++) {
            TrackGroup d3 = k2.d(i7);
            int[] iArr2 = new int[d3.s];
            Arrays.fill(iArr2, 0);
            builder.g(new Tracks.Group(d3, false, iArr2, new boolean[d3.s]));
        }
        return new Tracks(builder.e());
    }

    public static LoadErrorHandlingPolicy.FallbackOptions c(ExoTrackSelection exoTrackSelection) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = exoTrackSelection.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (exoTrackSelection.b(i3, elapsedRealtime)) {
                i2++;
            }
        }
        return new LoadErrorHandlingPolicy.FallbackOptions(1, 0, length, i2);
    }

    public static ExoTrackSelection[] d(ExoTrackSelection.Definition[] definitionArr, AdaptiveTrackSelectionFactory adaptiveTrackSelectionFactory) {
        ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[definitionArr.length];
        boolean z = false;
        for (int i2 = 0; i2 < definitionArr.length; i2++) {
            ExoTrackSelection.Definition definition = definitionArr[i2];
            if (definition != null) {
                int[] iArr = definition.f12390b;
                if (iArr.length <= 1 || z) {
                    exoTrackSelectionArr[i2] = new FixedTrackSelection(definition.f12389a, iArr[0], definition.f12391c);
                } else {
                    exoTrackSelectionArr[i2] = adaptiveTrackSelectionFactory.a(definition);
                    z = true;
                }
            }
        }
        return exoTrackSelectionArr;
    }

    @Deprecated
    public static DefaultTrackSelector.Parameters e(DefaultTrackSelector.Parameters parameters, int i2, TrackGroupArray trackGroupArray, boolean z, @Nullable DefaultTrackSelector.SelectionOverride selectionOverride) {
        DefaultTrackSelector.Parameters.Builder O1 = parameters.G().S0(i2).O1(i2, z);
        if (selectionOverride != null) {
            O1.Q1(i2, trackGroupArray, selectionOverride);
        }
        return O1.D();
    }
}
