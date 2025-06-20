package androidx.media3.exoplayer.trackselection;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.RendererConfiguration;
import androidx.media3.exoplayer.V0;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

@UnstableApi
public abstract class MappingTrackSelector extends TrackSelector {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private MappedTrackInfo f12394c;

    public static final class MappedTrackInfo {

        /* renamed from: h  reason: collision with root package name */
        public static final int f12395h = 0;

        /* renamed from: i  reason: collision with root package name */
        public static final int f12396i = 1;

        /* renamed from: j  reason: collision with root package name */
        public static final int f12397j = 2;

        /* renamed from: k  reason: collision with root package name */
        public static final int f12398k = 3;

        /* renamed from: a  reason: collision with root package name */
        private final int f12399a;

        /* renamed from: b  reason: collision with root package name */
        private final String[] f12400b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f12401c;

        /* renamed from: d  reason: collision with root package name */
        private final TrackGroupArray[] f12402d;

        /* renamed from: e  reason: collision with root package name */
        private final int[] f12403e;

        /* renamed from: f  reason: collision with root package name */
        private final int[][][] f12404f;

        /* renamed from: g  reason: collision with root package name */
        private final TrackGroupArray f12405g;

        @Documented
        @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface RendererSupport {
        }

        @VisibleForTesting
        MappedTrackInfo(String[] strArr, int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.f12400b = strArr;
            this.f12401c = iArr;
            this.f12402d = trackGroupArrayArr;
            this.f12404f = iArr3;
            this.f12403e = iArr2;
            this.f12405g = trackGroupArray;
            this.f12399a = iArr.length;
        }

        public int a(int i2, int i3, boolean z) {
            int i4 = this.f12402d[i2].d(i3).s;
            int[] iArr = new int[i4];
            int i5 = 0;
            for (int i6 = 0; i6 < i4; i6++) {
                int i7 = i(i2, i3, i6);
                if (i7 == 4 || (z && i7 == 3)) {
                    iArr[i5] = i6;
                    i5++;
                }
            }
            return b(i2, i3, Arrays.copyOf(iArr, i5));
        }

        public int b(int i2, int i3, int[] iArr) {
            int i4 = 0;
            String str = null;
            boolean z = false;
            int i5 = 0;
            int i6 = 16;
            while (i4 < iArr.length) {
                String str2 = this.f12402d[i2].d(i3).d(iArr[i4]).f3;
                int i7 = i5 + 1;
                if (i5 == 0) {
                    str = str2;
                } else {
                    z |= !Util.g(str, str2);
                }
                i6 = Math.min(i6, V0.h(this.f12404f[i2][i3][i4]));
                i4++;
                i5 = i7;
            }
            return z ? Math.min(i6, this.f12403e[i2]) : i6;
        }

        public int c(int i2, int i3, int i4) {
            return this.f12404f[i2][i3][i4];
        }

        public int d() {
            return this.f12399a;
        }

        public String e(int i2) {
            return this.f12400b[i2];
        }

        public int f(int i2) {
            int i3 = 0;
            for (int[] iArr : this.f12404f[i2]) {
                for (int k2 : r11[r2]) {
                    int k3 = V0.k(k2);
                    int i4 = 1;
                    if (!(k3 == 0 || k3 == 1 || k3 == 2)) {
                        if (k3 == 3) {
                            i4 = 2;
                        } else if (k3 == 4) {
                            return 3;
                        } else {
                            throw new IllegalStateException();
                        }
                    }
                    i3 = Math.max(i3, i4);
                }
            }
            return i3;
        }

        public int g(int i2) {
            return this.f12401c[i2];
        }

        public TrackGroupArray h(int i2) {
            return this.f12402d[i2];
        }

        public int i(int i2, int i3, int i4) {
            return V0.k(c(i2, i3, i4));
        }

        public int j(int i2) {
            int i3 = 0;
            for (int i4 = 0; i4 < this.f12399a; i4++) {
                if (this.f12401c[i4] == i2) {
                    i3 = Math.max(i3, f(i4));
                }
            }
            return i3;
        }

        public TrackGroupArray k() {
            return this.f12405g;
        }
    }

    private static int n(RendererCapabilities[] rendererCapabilitiesArr, TrackGroup trackGroup, int[] iArr, boolean z) throws ExoPlaybackException {
        int length = rendererCapabilitiesArr.length;
        int i2 = 0;
        boolean z2 = true;
        for (int i3 = 0; i3 < rendererCapabilitiesArr.length; i3++) {
            RendererCapabilities rendererCapabilities = rendererCapabilitiesArr[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < trackGroup.s; i5++) {
                i4 = Math.max(i4, V0.k(rendererCapabilities.b(trackGroup.d(i5))));
            }
            boolean z3 = iArr[i3] == 0;
            if (i4 > i2 || (i4 == i2 && z && !z2 && z3)) {
                length = i3;
                z2 = z3;
                i2 = i4;
            }
        }
        return length;
    }

    private static int[] p(RendererCapabilities rendererCapabilities, TrackGroup trackGroup) throws ExoPlaybackException {
        int[] iArr = new int[trackGroup.s];
        for (int i2 = 0; i2 < trackGroup.s; i2++) {
            iArr[i2] = rendererCapabilities.b(trackGroup.d(i2));
        }
        return iArr;
    }

    private static int[] q(RendererCapabilities[] rendererCapabilitiesArr) throws ExoPlaybackException {
        int length = rendererCapabilitiesArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = rendererCapabilitiesArr[i2].y();
        }
        return iArr;
    }

    public final void i(@Nullable Object obj) {
        this.f12394c = (MappedTrackInfo) obj;
    }

    public final TrackSelectorResult k(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException {
        RendererCapabilities[] rendererCapabilitiesArr2 = rendererCapabilitiesArr;
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        int[] iArr = new int[(rendererCapabilitiesArr2.length + 1)];
        int length = rendererCapabilitiesArr2.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length][];
        int[][][] iArr2 = new int[(rendererCapabilitiesArr2.length + 1)][][];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = trackGroupArray2.s;
            trackGroupArr[i2] = new TrackGroup[i3];
            iArr2[i2] = new int[i3][];
        }
        int[] q = q(rendererCapabilitiesArr);
        for (int i4 = 0; i4 < trackGroupArray2.s; i4++) {
            TrackGroup d2 = trackGroupArray2.d(i4);
            int n2 = n(rendererCapabilitiesArr, d2, iArr, d2.Y == 5);
            int[] p = n2 == rendererCapabilitiesArr2.length ? new int[d2.s] : p(rendererCapabilitiesArr2[n2], d2);
            int i5 = iArr[n2];
            trackGroupArr[n2][i5] = d2;
            iArr2[n2][i5] = p;
            iArr[n2] = i5 + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[rendererCapabilitiesArr2.length];
        String[] strArr = new String[rendererCapabilitiesArr2.length];
        int[] iArr3 = new int[rendererCapabilitiesArr2.length];
        for (int i6 = 0; i6 < rendererCapabilitiesArr2.length; i6++) {
            int i7 = iArr[i6];
            trackGroupArrayArr[i6] = new TrackGroupArray((TrackGroup[]) Util.O1(trackGroupArr[i6], i7));
            iArr2[i6] = (int[][]) Util.O1(iArr2[i6], i7);
            strArr[i6] = rendererCapabilitiesArr2[i6].getName();
            iArr3[i6] = rendererCapabilitiesArr2[i6].i();
        }
        MappedTrackInfo mappedTrackInfo = new MappedTrackInfo(strArr, iArr3, trackGroupArrayArr, q, iArr2, new TrackGroupArray((TrackGroup[]) Util.O1(trackGroupArr[rendererCapabilitiesArr2.length], iArr[rendererCapabilitiesArr2.length])));
        Pair<RendererConfiguration[], ExoTrackSelection[]> r = r(mappedTrackInfo, iArr2, q, mediaPeriodId, timeline);
        return new TrackSelectorResult((RendererConfiguration[]) r.first, (ExoTrackSelection[]) r.second, TrackSelectionUtil.a(mappedTrackInfo, (TrackSelection[]) r.second), mappedTrackInfo);
    }

    @Nullable
    public final MappedTrackInfo o() {
        return this.f12394c;
    }

    /* access modifiers changed from: protected */
    public abstract Pair<RendererConfiguration[], ExoTrackSelection[]> r(MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException;
}
