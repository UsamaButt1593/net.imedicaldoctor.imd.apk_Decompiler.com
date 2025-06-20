package androidx.media3.exoplayer;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;

final class MediaPeriodInfo {

    /* renamed from: a  reason: collision with root package name */
    public final MediaSource.MediaPeriodId f10249a;

    /* renamed from: b  reason: collision with root package name */
    public final long f10250b;

    /* renamed from: c  reason: collision with root package name */
    public final long f10251c;

    /* renamed from: d  reason: collision with root package name */
    public final long f10252d;

    /* renamed from: e  reason: collision with root package name */
    public final long f10253e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f10254f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f10255g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f10256h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f10257i;

    MediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, long j4, long j5, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = z;
        boolean z6 = z2;
        boolean z7 = z3;
        boolean z8 = z4;
        boolean z9 = true;
        Assertions.a(!z8 || z6);
        Assertions.a(!z7 || z6);
        if (z5 && (z6 || z7 || z8)) {
            z9 = false;
        }
        Assertions.a(z9);
        this.f10249a = mediaPeriodId;
        this.f10250b = j2;
        this.f10251c = j3;
        this.f10252d = j4;
        this.f10253e = j5;
        this.f10254f = z5;
        this.f10255g = z6;
        this.f10256h = z7;
        this.f10257i = z8;
    }

    public MediaPeriodInfo a(long j2) {
        if (j2 == this.f10251c) {
            return this;
        }
        return new MediaPeriodInfo(this.f10249a, this.f10250b, j2, this.f10252d, this.f10253e, this.f10254f, this.f10255g, this.f10256h, this.f10257i);
    }

    public MediaPeriodInfo b(long j2) {
        if (j2 == this.f10250b) {
            return this;
        }
        return new MediaPeriodInfo(this.f10249a, j2, this.f10251c, this.f10252d, this.f10253e, this.f10254f, this.f10255g, this.f10256h, this.f10257i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MediaPeriodInfo.class != obj.getClass()) {
            return false;
        }
        MediaPeriodInfo mediaPeriodInfo = (MediaPeriodInfo) obj;
        return this.f10250b == mediaPeriodInfo.f10250b && this.f10251c == mediaPeriodInfo.f10251c && this.f10252d == mediaPeriodInfo.f10252d && this.f10253e == mediaPeriodInfo.f10253e && this.f10254f == mediaPeriodInfo.f10254f && this.f10255g == mediaPeriodInfo.f10255g && this.f10256h == mediaPeriodInfo.f10256h && this.f10257i == mediaPeriodInfo.f10257i && Util.g(this.f10249a, mediaPeriodInfo.f10249a);
    }

    public int hashCode() {
        return ((((((((((((((((MetaDo.w + this.f10249a.hashCode()) * 31) + ((int) this.f10250b)) * 31) + ((int) this.f10251c)) * 31) + ((int) this.f10252d)) * 31) + ((int) this.f10253e)) * 31) + (this.f10254f ? 1 : 0)) * 31) + (this.f10255g ? 1 : 0)) * 31) + (this.f10256h ? 1 : 0)) * 31) + (this.f10257i ? 1 : 0);
    }
}
