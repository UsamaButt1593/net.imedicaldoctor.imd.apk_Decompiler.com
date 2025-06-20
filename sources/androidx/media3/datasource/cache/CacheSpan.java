package androidx.media3.datasource.cache;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.util.UnstableApi;
import java.io.File;

@UnstableApi
public class CacheSpan implements Comparable<CacheSpan> {
    public final long X;
    @Nullable
    public final File X2;
    public final long Y;
    public final long Y2;
    public final boolean Z;
    public final String s;

    public CacheSpan(String str, long j2, long j3) {
        this(str, j2, j3, C.f9084b, (File) null);
    }

    /* renamed from: a */
    public int compareTo(CacheSpan cacheSpan) {
        if (!this.s.equals(cacheSpan.s)) {
            return this.s.compareTo(cacheSpan.s);
        }
        int i2 = ((this.X - cacheSpan.X) > 0 ? 1 : ((this.X - cacheSpan.X) == 0 ? 0 : -1));
        if (i2 == 0) {
            return 0;
        }
        return i2 < 0 ? -1 : 1;
    }

    public boolean b() {
        return !this.Z;
    }

    public boolean c() {
        return this.Y == -1;
    }

    public String toString() {
        return "[" + this.X + ", " + this.Y + "]";
    }

    public CacheSpan(String str, long j2, long j3, long j4, @Nullable File file) {
        this.s = str;
        this.X = j2;
        this.Y = j3;
        this.Z = file != null;
        this.X2 = file;
        this.Y2 = j4;
    }
}
