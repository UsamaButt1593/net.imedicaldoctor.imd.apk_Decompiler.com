package androidx.media3.exoplayer.dash.manifest;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.UriUtil;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;

@UnstableApi
public final class RangedUri {

    /* renamed from: a  reason: collision with root package name */
    public final long f11177a;

    /* renamed from: b  reason: collision with root package name */
    public final long f11178b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11179c;

    /* renamed from: d  reason: collision with root package name */
    private int f11180d;

    public RangedUri(@Nullable String str, long j2, long j3) {
        this.f11179c = str == null ? "" : str;
        this.f11177a = j2;
        this.f11178b = j3;
    }

    @Nullable
    public RangedUri a(@Nullable RangedUri rangedUri, String str) {
        String c2 = c(str);
        if (rangedUri != null && c2.equals(rangedUri.c(str))) {
            long j2 = this.f11178b;
            long j3 = -1;
            if (j2 != -1) {
                long j4 = this.f11177a;
                if (j4 + j2 == rangedUri.f11177a) {
                    long j5 = rangedUri.f11178b;
                    if (j5 != -1) {
                        j3 = j2 + j5;
                    }
                    return new RangedUri(c2, j4, j3);
                }
            }
            long j6 = rangedUri.f11178b;
            if (j6 != -1) {
                long j7 = rangedUri.f11177a;
                if (j7 + j6 == this.f11177a) {
                    if (j2 != -1) {
                        j3 = j6 + j2;
                    }
                    return new RangedUri(c2, j7, j3);
                }
            }
        }
        return null;
    }

    public Uri b(String str) {
        return UriUtil.g(str, this.f11179c);
    }

    public String c(String str) {
        return UriUtil.f(str, this.f11179c);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RangedUri.class != obj.getClass()) {
            return false;
        }
        RangedUri rangedUri = (RangedUri) obj;
        return this.f11177a == rangedUri.f11177a && this.f11178b == rangedUri.f11178b && this.f11179c.equals(rangedUri.f11179c);
    }

    public int hashCode() {
        if (this.f11180d == 0) {
            this.f11180d = ((((MetaDo.w + ((int) this.f11177a)) * 31) + ((int) this.f11178b)) * 31) + this.f11179c.hashCode();
        }
        return this.f11180d;
    }

    public String toString() {
        return "RangedUri(referenceUri=" + this.f11179c + ", start=" + this.f11177a + ", length=" + this.f11178b + ")";
    }
}
