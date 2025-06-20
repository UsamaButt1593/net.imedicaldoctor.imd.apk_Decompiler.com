package androidx.media3.extractor;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class SeekPoint {

    /* renamed from: c  reason: collision with root package name */
    public static final SeekPoint f13116c = new SeekPoint(0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final long f13117a;

    /* renamed from: b  reason: collision with root package name */
    public final long f13118b;

    public SeekPoint(long j2, long j3) {
        this.f13117a = j2;
        this.f13118b = j3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SeekPoint.class != obj.getClass()) {
            return false;
        }
        SeekPoint seekPoint = (SeekPoint) obj;
        return this.f13117a == seekPoint.f13117a && this.f13118b == seekPoint.f13118b;
    }

    public int hashCode() {
        return (((int) this.f13117a) * 31) + ((int) this.f13118b);
    }

    public String toString() {
        return "[timeUs=" + this.f13117a + ", position=" + this.f13118b + "]";
    }
}
