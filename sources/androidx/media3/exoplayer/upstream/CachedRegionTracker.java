package androidx.media3.exoplayer.upstream;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.CacheSpan;
import androidx.media3.extractor.ChunkIndex;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

@UnstableApi
public final class CachedRegionTracker implements Cache.Listener {

    /* renamed from: f  reason: collision with root package name */
    private static final String f12437f = "CachedRegionTracker";

    /* renamed from: g  reason: collision with root package name */
    public static final int f12438g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static final int f12439h = -2;

    /* renamed from: a  reason: collision with root package name */
    private final Cache f12440a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12441b;

    /* renamed from: c  reason: collision with root package name */
    private final ChunkIndex f12442c;

    /* renamed from: d  reason: collision with root package name */
    private final TreeSet<Region> f12443d = new TreeSet<>();

    /* renamed from: e  reason: collision with root package name */
    private final Region f12444e = new Region(0, 0);

    private static class Region implements Comparable<Region> {
        public long X;
        public int Y;
        public long s;

        public Region(long j2, long j3) {
            this.s = j2;
            this.X = j3;
        }

        /* renamed from: a */
        public int compareTo(Region region) {
            return Util.u(this.s, region.s);
        }
    }

    public CachedRegionTracker(Cache cache, String str, ChunkIndex chunkIndex) {
        this.f12440a = cache;
        this.f12441b = str;
        this.f12442c = chunkIndex;
        synchronized (this) {
            try {
                Iterator<CacheSpan> descendingIterator = cache.j(str, this).descendingIterator();
                while (descendingIterator.hasNext()) {
                    h(descendingIterator.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void h(CacheSpan cacheSpan) {
        long j2 = cacheSpan.X;
        Region region = new Region(j2, cacheSpan.Y + j2);
        Region floor = this.f12443d.floor(region);
        Region ceiling = this.f12443d.ceiling(region);
        boolean i2 = i(floor, region);
        if (i(region, ceiling)) {
            if (i2) {
                floor.X = ceiling.X;
                floor.Y = ceiling.Y;
            } else {
                region.X = ceiling.X;
                region.Y = ceiling.Y;
                this.f12443d.add(region);
            }
            this.f12443d.remove(ceiling);
        } else if (i2) {
            floor.X = region.X;
            int i3 = floor.Y;
            while (true) {
                ChunkIndex chunkIndex = this.f12442c;
                if (i3 >= chunkIndex.f12973d - 1) {
                    break;
                }
                int i4 = i3 + 1;
                if (chunkIndex.f12975f[i4] > floor.X) {
                    break;
                }
                i3 = i4;
            }
            floor.Y = i3;
        } else {
            int binarySearch = Arrays.binarySearch(this.f12442c.f12975f, region.X);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            region.Y = binarySearch;
            this.f12443d.add(region);
        }
    }

    private boolean i(@Nullable Region region, @Nullable Region region2) {
        return (region == null || region2 == null || region.X != region2.s) ? false : true;
    }

    public void a(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
    }

    public synchronized void c(Cache cache, CacheSpan cacheSpan) {
        h(cacheSpan);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0062, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void d(androidx.media3.datasource.cache.Cache r7, androidx.media3.datasource.cache.CacheSpan r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            androidx.media3.exoplayer.upstream.CachedRegionTracker$Region r7 = new androidx.media3.exoplayer.upstream.CachedRegionTracker$Region     // Catch:{ all -> 0x001e }
            long r0 = r8.X     // Catch:{ all -> 0x001e }
            long r2 = r8.Y     // Catch:{ all -> 0x001e }
            long r2 = r2 + r0
            r7.<init>(r0, r2)     // Catch:{ all -> 0x001e }
            java.util.TreeSet<androidx.media3.exoplayer.upstream.CachedRegionTracker$Region> r8 = r6.f12443d     // Catch:{ all -> 0x001e }
            java.lang.Object r8 = r8.floor(r7)     // Catch:{ all -> 0x001e }
            androidx.media3.exoplayer.upstream.CachedRegionTracker$Region r8 = (androidx.media3.exoplayer.upstream.CachedRegionTracker.Region) r8     // Catch:{ all -> 0x001e }
            if (r8 != 0) goto L_0x0020
            java.lang.String r7 = "CachedRegionTracker"
            java.lang.String r8 = "Removed a span we were not aware of"
            androidx.media3.common.util.Log.d(r7, r8)     // Catch:{ all -> 0x001e }
            monitor-exit(r6)
            return
        L_0x001e:
            r7 = move-exception
            goto L_0x0063
        L_0x0020:
            java.util.TreeSet<androidx.media3.exoplayer.upstream.CachedRegionTracker$Region> r0 = r6.f12443d     // Catch:{ all -> 0x001e }
            r0.remove(r8)     // Catch:{ all -> 0x001e }
            long r0 = r8.s     // Catch:{ all -> 0x001e }
            long r2 = r7.s     // Catch:{ all -> 0x001e }
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0048
            androidx.media3.exoplayer.upstream.CachedRegionTracker$Region r4 = new androidx.media3.exoplayer.upstream.CachedRegionTracker$Region     // Catch:{ all -> 0x001e }
            r4.<init>(r0, r2)     // Catch:{ all -> 0x001e }
            androidx.media3.extractor.ChunkIndex r0 = r6.f12442c     // Catch:{ all -> 0x001e }
            long[] r0 = r0.f12975f     // Catch:{ all -> 0x001e }
            long r1 = r4.X     // Catch:{ all -> 0x001e }
            int r0 = java.util.Arrays.binarySearch(r0, r1)     // Catch:{ all -> 0x001e }
            if (r0 >= 0) goto L_0x0041
            int r0 = -r0
            int r0 = r0 + -2
        L_0x0041:
            r4.Y = r0     // Catch:{ all -> 0x001e }
            java.util.TreeSet<androidx.media3.exoplayer.upstream.CachedRegionTracker$Region> r0 = r6.f12443d     // Catch:{ all -> 0x001e }
            r0.add(r4)     // Catch:{ all -> 0x001e }
        L_0x0048:
            long r0 = r8.X     // Catch:{ all -> 0x001e }
            long r2 = r7.X     // Catch:{ all -> 0x001e }
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 <= 0) goto L_0x0061
            androidx.media3.exoplayer.upstream.CachedRegionTracker$Region r7 = new androidx.media3.exoplayer.upstream.CachedRegionTracker$Region     // Catch:{ all -> 0x001e }
            r4 = 1
            long r2 = r2 + r4
            r7.<init>(r2, r0)     // Catch:{ all -> 0x001e }
            int r8 = r8.Y     // Catch:{ all -> 0x001e }
            r7.Y = r8     // Catch:{ all -> 0x001e }
            java.util.TreeSet<androidx.media3.exoplayer.upstream.CachedRegionTracker$Region> r8 = r6.f12443d     // Catch:{ all -> 0x001e }
            r8.add(r7)     // Catch:{ all -> 0x001e }
        L_0x0061:
            monitor-exit(r6)
            return
        L_0x0063:
            monitor-exit(r6)     // Catch:{ all -> 0x001e }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.upstream.CachedRegionTracker.d(androidx.media3.datasource.cache.Cache, androidx.media3.datasource.cache.CacheSpan):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int g(long r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            androidx.media3.exoplayer.upstream.CachedRegionTracker$Region r0 = r8.f12444e     // Catch:{ all -> 0x0034 }
            r0.s = r9     // Catch:{ all -> 0x0034 }
            java.util.TreeSet<androidx.media3.exoplayer.upstream.CachedRegionTracker$Region> r1 = r8.f12443d     // Catch:{ all -> 0x0034 }
            java.lang.Object r0 = r1.floor(r0)     // Catch:{ all -> 0x0034 }
            androidx.media3.exoplayer.upstream.CachedRegionTracker$Region r0 = (androidx.media3.exoplayer.upstream.CachedRegionTracker.Region) r0     // Catch:{ all -> 0x0034 }
            r1 = -1
            if (r0 == 0) goto L_0x0052
            long r2 = r0.X     // Catch:{ all -> 0x0034 }
            int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x0052
            int r9 = r0.Y     // Catch:{ all -> 0x0034 }
            if (r9 != r1) goto L_0x001b
            goto L_0x0052
        L_0x001b:
            androidx.media3.extractor.ChunkIndex r10 = r8.f12442c     // Catch:{ all -> 0x0034 }
            int r0 = r10.f12973d     // Catch:{ all -> 0x0034 }
            int r0 = r0 + -1
            if (r9 != r0) goto L_0x0036
            long[] r0 = r10.f12975f     // Catch:{ all -> 0x0034 }
            r4 = r0[r9]     // Catch:{ all -> 0x0034 }
            int[] r0 = r10.f12974e     // Catch:{ all -> 0x0034 }
            r0 = r0[r9]     // Catch:{ all -> 0x0034 }
            long r0 = (long) r0
            long r4 = r4 + r0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0036
            monitor-exit(r8)
            r9 = -2
            return r9
        L_0x0034:
            r9 = move-exception
            goto L_0x0054
        L_0x0036:
            long[] r0 = r10.f12976g     // Catch:{ all -> 0x0034 }
            r4 = r0[r9]     // Catch:{ all -> 0x0034 }
            long[] r0 = r10.f12975f     // Catch:{ all -> 0x0034 }
            r6 = r0[r9]     // Catch:{ all -> 0x0034 }
            long r2 = r2 - r6
            long r4 = r4 * r2
            int[] r0 = r10.f12974e     // Catch:{ all -> 0x0034 }
            r0 = r0[r9]     // Catch:{ all -> 0x0034 }
            long r0 = (long) r0     // Catch:{ all -> 0x0034 }
            long r4 = r4 / r0
            long[] r10 = r10.f12977h     // Catch:{ all -> 0x0034 }
            r9 = r10[r9]     // Catch:{ all -> 0x0034 }
            long r9 = r9 + r4
            r0 = 1000(0x3e8, double:4.94E-321)
            long r9 = r9 / r0
            int r10 = (int) r9
            monitor-exit(r8)
            return r10
        L_0x0052:
            monitor-exit(r8)
            return r1
        L_0x0054:
            monitor-exit(r8)     // Catch:{ all -> 0x0034 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.upstream.CachedRegionTracker.g(long):int");
    }

    public void j() {
        this.f12440a.g(this.f12441b, this);
    }
}
