package androidx.media3.exoplayer.trackselection;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import java.util.Arrays;
import java.util.List;

@UnstableApi
public abstract class BaseTrackSelection implements ExoTrackSelection {

    /* renamed from: c  reason: collision with root package name */
    protected final TrackGroup f12363c;

    /* renamed from: d  reason: collision with root package name */
    protected final int f12364d;

    /* renamed from: e  reason: collision with root package name */
    protected final int[] f12365e;

    /* renamed from: f  reason: collision with root package name */
    private final int f12366f;

    /* renamed from: g  reason: collision with root package name */
    private final Format[] f12367g;

    /* renamed from: h  reason: collision with root package name */
    private final long[] f12368h;

    /* renamed from: i  reason: collision with root package name */
    private int f12369i;

    public BaseTrackSelection(TrackGroup trackGroup, int... iArr) {
        this(trackGroup, iArr, 0);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int x(Format format, Format format2) {
        return format2.b3 - format.b3;
    }

    public /* synthetic */ long a() {
        return B.a(this);
    }

    public boolean b(int i2, long j2) {
        return this.f12368h[i2] > j2;
    }

    public final int c(Format format) {
        for (int i2 = 0; i2 < this.f12364d; i2++) {
            if (this.f12367g[i2] == format) {
                return i2;
            }
        }
        return -1;
    }

    public final TrackGroup d() {
        return this.f12363c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseTrackSelection baseTrackSelection = (BaseTrackSelection) obj;
        return this.f12363c.equals(baseTrackSelection.f12363c) && Arrays.equals(this.f12365e, baseTrackSelection.f12365e);
    }

    public /* synthetic */ boolean f(long j2, Chunk chunk, List list) {
        return B.e(this, j2, chunk, list);
    }

    public /* synthetic */ void g(boolean z) {
        B.c(this, z);
    }

    public final int getType() {
        return this.f12366f;
    }

    public void h() {
    }

    public int hashCode() {
        if (this.f12369i == 0) {
            this.f12369i = (System.identityHashCode(this.f12363c) * 31) + Arrays.hashCode(this.f12365e);
        }
        return this.f12369i;
    }

    public final Format i(int i2) {
        return this.f12367g[i2];
    }

    public void j() {
    }

    public final int k(int i2) {
        return this.f12365e[i2];
    }

    public int l(long j2, List<? extends MediaChunk> list) {
        return list.size();
    }

    public final int length() {
        return this.f12365e.length;
    }

    public final int n() {
        return this.f12365e[e()];
    }

    public final Format o() {
        return this.f12367g[e()];
    }

    public boolean q(int i2, long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean b2 = b(i2, elapsedRealtime);
        int i3 = 0;
        while (i3 < this.f12364d && !b2) {
            b2 = i3 != i2 && !b(i3, elapsedRealtime);
            i3++;
        }
        if (!b2) {
            return false;
        }
        long[] jArr = this.f12368h;
        jArr[i2] = Math.max(jArr[i2], Util.f(elapsedRealtime, j2, Long.MAX_VALUE));
        return true;
    }

    public void r(float f2) {
    }

    public /* synthetic */ void t() {
        B.b(this);
    }

    public /* synthetic */ void u() {
        B.d(this);
    }

    public final int v(int i2) {
        for (int i3 = 0; i3 < this.f12364d; i3++) {
            if (this.f12365e[i3] == i2) {
                return i3;
            }
        }
        return -1;
    }

    public BaseTrackSelection(TrackGroup trackGroup, int[] iArr, int i2) {
        int i3 = 0;
        Assertions.i(iArr.length > 0);
        this.f12366f = i2;
        this.f12363c = (TrackGroup) Assertions.g(trackGroup);
        int length = iArr.length;
        this.f12364d = length;
        this.f12367g = new Format[length];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            this.f12367g[i4] = trackGroup.d(iArr[i4]);
        }
        Arrays.sort(this.f12367g, new C0346a());
        this.f12365e = new int[this.f12364d];
        while (true) {
            int i5 = this.f12364d;
            if (i3 < i5) {
                this.f12365e[i3] = trackGroup.e(this.f12367g[i3]);
                i3++;
            } else {
                this.f12368h = new long[i5];
                return;
            }
        }
    }
}
