package androidx.media3.datasource.cache;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

final class CachedContent {

    /* renamed from: f  reason: collision with root package name */
    private static final String f9984f = "CachedContent";

    /* renamed from: a  reason: collision with root package name */
    public final int f9985a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9986b;

    /* renamed from: c  reason: collision with root package name */
    private final TreeSet<SimpleCacheSpan> f9987c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<Range> f9988d;

    /* renamed from: e  reason: collision with root package name */
    private DefaultContentMetadata f9989e;

    private static final class Range {

        /* renamed from: a  reason: collision with root package name */
        public final long f9990a;

        /* renamed from: b  reason: collision with root package name */
        public final long f9991b;

        public Range(long j2, long j3) {
            this.f9990a = j2;
            this.f9991b = j3;
        }

        public boolean a(long j2, long j3) {
            long j4 = this.f9991b;
            if (j4 == -1) {
                return j2 >= this.f9990a;
            }
            if (j3 == -1) {
                return false;
            }
            long j5 = this.f9990a;
            return j5 <= j2 && j2 + j3 <= j5 + j4;
        }

        public boolean b(long j2, long j3) {
            long j4 = this.f9990a;
            if (j4 > j2) {
                return j3 == -1 || j2 + j3 > j4;
            }
            long j5 = this.f9991b;
            return j5 == -1 || j4 + j5 > j2;
        }
    }

    public CachedContent(int i2, String str) {
        this(i2, str, DefaultContentMetadata.f10029f);
    }

    public void a(SimpleCacheSpan simpleCacheSpan) {
        this.f9987c.add(simpleCacheSpan);
    }

    public boolean b(ContentMetadataMutations contentMetadataMutations) {
        DefaultContentMetadata defaultContentMetadata = this.f9989e;
        DefaultContentMetadata f2 = defaultContentMetadata.f(contentMetadataMutations);
        this.f9989e = f2;
        return !f2.equals(defaultContentMetadata);
    }

    public long c(long j2, long j3) {
        boolean z = true;
        Assertions.a(j2 >= 0);
        if (j3 < 0) {
            z = false;
        }
        Assertions.a(z);
        SimpleCacheSpan e2 = e(j2, j3);
        long j4 = Long.MAX_VALUE;
        if (e2.b()) {
            if (!e2.c()) {
                j4 = e2.Y;
            }
            return -Math.min(j4, j3);
        }
        long j5 = j2 + j3;
        if (j5 >= 0) {
            j4 = j5;
        }
        long j6 = e2.X + e2.Y;
        if (j6 < j4) {
            for (SimpleCacheSpan next : this.f9987c.tailSet(e2, false)) {
                long j7 = next.X;
                if (j7 <= j6) {
                    j6 = Math.max(j6, j7 + next.Y);
                    if (j6 >= j4) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return Math.min(j6 - j2, j3);
    }

    public DefaultContentMetadata d() {
        return this.f9989e;
    }

    public SimpleCacheSpan e(long j2, long j3) {
        SimpleCacheSpan i2 = SimpleCacheSpan.i(this.f9986b, j2);
        SimpleCacheSpan floor = this.f9987c.floor(i2);
        if (floor != null && floor.X + floor.Y > j2) {
            return floor;
        }
        SimpleCacheSpan ceiling = this.f9987c.ceiling(i2);
        if (ceiling != null) {
            long j4 = ceiling.X - j2;
            j3 = j3 == -1 ? j4 : Math.min(j4, j3);
        }
        return SimpleCacheSpan.h(this.f9986b, j2, j3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CachedContent.class != obj.getClass()) {
            return false;
        }
        CachedContent cachedContent = (CachedContent) obj;
        return this.f9985a == cachedContent.f9985a && this.f9986b.equals(cachedContent.f9986b) && this.f9987c.equals(cachedContent.f9987c) && this.f9989e.equals(cachedContent.f9989e);
    }

    public TreeSet<SimpleCacheSpan> f() {
        return this.f9987c;
    }

    public boolean g() {
        return this.f9987c.isEmpty();
    }

    public boolean h(long j2, long j3) {
        for (int i2 = 0; i2 < this.f9988d.size(); i2++) {
            if (this.f9988d.get(i2).a(j2, j3)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f9985a * 31) + this.f9986b.hashCode()) * 31) + this.f9989e.hashCode();
    }

    public boolean i() {
        return this.f9988d.isEmpty();
    }

    public boolean j(long j2, long j3) {
        for (int i2 = 0; i2 < this.f9988d.size(); i2++) {
            if (this.f9988d.get(i2).b(j2, j3)) {
                return false;
            }
        }
        this.f9988d.add(new Range(j2, j3));
        return true;
    }

    public boolean k(CacheSpan cacheSpan) {
        if (!this.f9987c.remove(cacheSpan)) {
            return false;
        }
        File file = cacheSpan.X2;
        if (file == null) {
            return true;
        }
        file.delete();
        return true;
    }

    public SimpleCacheSpan l(SimpleCacheSpan simpleCacheSpan, long j2, boolean z) {
        Assertions.i(this.f9987c.remove(simpleCacheSpan));
        File file = (File) Assertions.g(simpleCacheSpan.X2);
        if (z) {
            File j3 = SimpleCacheSpan.j((File) Assertions.g(file.getParentFile()), this.f9985a, simpleCacheSpan.X, j2);
            if (file.renameTo(j3)) {
                file = j3;
            } else {
                Log.n(f9984f, "Failed to rename " + file + " to " + j3);
            }
        }
        SimpleCacheSpan e2 = simpleCacheSpan.e(file, j2);
        this.f9987c.add(e2);
        return e2;
    }

    public void m(long j2) {
        for (int i2 = 0; i2 < this.f9988d.size(); i2++) {
            if (this.f9988d.get(i2).f9990a == j2) {
                this.f9988d.remove(i2);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public CachedContent(int i2, String str, DefaultContentMetadata defaultContentMetadata) {
        this.f9985a = i2;
        this.f9986b = str;
        this.f9989e = defaultContentMetadata;
        this.f9987c = new TreeSet<>();
        this.f9988d = new ArrayList<>();
    }
}
