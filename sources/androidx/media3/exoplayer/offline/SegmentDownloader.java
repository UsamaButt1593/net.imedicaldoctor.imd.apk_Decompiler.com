package androidx.media3.exoplayer.offline;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.RunnableFutureTask;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.datasource.cache.CacheKeyFactory;
import androidx.media3.datasource.cache.CacheWriter;
import androidx.media3.datasource.cache.c;
import androidx.media3.exoplayer.offline.Downloader;
import androidx.media3.exoplayer.offline.FilterableManifest;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

@UnstableApi
public abstract class SegmentDownloader<M extends FilterableManifest<M>> implements Downloader {

    /* renamed from: l  reason: collision with root package name */
    public static final long f11850l = 20000;

    /* renamed from: m  reason: collision with root package name */
    private static final int f11851m = 131072;

    /* renamed from: a  reason: collision with root package name */
    private final DataSpec f11852a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ParsingLoadable.Parser<M> f11853b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<StreamKey> f11854c;

    /* renamed from: d  reason: collision with root package name */
    private final CacheDataSource.Factory f11855d;

    /* renamed from: e  reason: collision with root package name */
    private final Cache f11856e;

    /* renamed from: f  reason: collision with root package name */
    private final CacheKeyFactory f11857f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final PriorityTaskManager f11858g;

    /* renamed from: h  reason: collision with root package name */
    private final Executor f11859h;

    /* renamed from: i  reason: collision with root package name */
    private final long f11860i;

    /* renamed from: j  reason: collision with root package name */
    private final ArrayList<RunnableFutureTask<?, ?>> f11861j;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f11862k;

    private static final class ProgressNotifier implements CacheWriter.ProgressListener {

        /* renamed from: a  reason: collision with root package name */
        private final Downloader.ProgressListener f11863a;

        /* renamed from: b  reason: collision with root package name */
        private final long f11864b;

        /* renamed from: c  reason: collision with root package name */
        private final int f11865c;

        /* renamed from: d  reason: collision with root package name */
        private long f11866d;

        /* renamed from: e  reason: collision with root package name */
        private int f11867e;

        public ProgressNotifier(Downloader.ProgressListener progressListener, long j2, int i2, long j3, int i3) {
            this.f11863a = progressListener;
            this.f11864b = j2;
            this.f11865c = i2;
            this.f11866d = j3;
            this.f11867e = i3;
        }

        private float b() {
            long j2 = this.f11864b;
            if (j2 != -1 && j2 != 0) {
                return (((float) this.f11866d) * 100.0f) / ((float) j2);
            }
            int i2 = this.f11865c;
            if (i2 != 0) {
                return (((float) this.f11867e) * 100.0f) / ((float) i2);
            }
            return -1.0f;
        }

        public void a(long j2, long j3, long j4) {
            long j5 = this.f11866d + j4;
            this.f11866d = j5;
            this.f11863a.a(this.f11864b, j5, b());
        }

        public void c() {
            this.f11867e++;
            this.f11863a.a(this.f11864b, this.f11866d, b());
        }
    }

    protected static class Segment implements Comparable<Segment> {
        public final DataSpec X;
        public final long s;

        public Segment(long j2, DataSpec dataSpec) {
            this.s = j2;
            this.X = dataSpec;
        }

        /* renamed from: a */
        public int compareTo(Segment segment) {
            return Util.u(this.s, segment.s);
        }
    }

    private static final class SegmentDownloadRunnable extends RunnableFutureTask<Void, IOException> {
        public final Segment a3;
        public final CacheDataSource b3;
        @Nullable
        private final ProgressNotifier c3;
        public final byte[] d3;
        private final CacheWriter e3;

        public SegmentDownloadRunnable(Segment segment, CacheDataSource cacheDataSource, @Nullable ProgressNotifier progressNotifier, byte[] bArr) {
            this.a3 = segment;
            this.b3 = cacheDataSource;
            this.c3 = progressNotifier;
            this.d3 = bArr;
            this.e3 = new CacheWriter(cacheDataSource, segment.X, bArr, progressNotifier);
        }

        /* access modifiers changed from: protected */
        public void c() {
            this.e3.b();
        }

        /* access modifiers changed from: protected */
        /* renamed from: f */
        public Void d() throws IOException {
            this.e3.a();
            ProgressNotifier progressNotifier = this.c3;
            if (progressNotifier == null) {
                return null;
            }
            progressNotifier.c();
            return null;
        }
    }

    @Deprecated
    public SegmentDownloader(MediaItem mediaItem, ParsingLoadable.Parser<M> parser, CacheDataSource.Factory factory, Executor executor) {
        this(mediaItem, parser, factory, executor, 20000);
    }

    private <T> void c(RunnableFutureTask<T, ?> runnableFutureTask) throws InterruptedException {
        synchronized (this.f11861j) {
            try {
                if (!this.f11862k) {
                    this.f11861j.add(runnableFutureTask);
                } else {
                    throw new InterruptedException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean d(DataSpec dataSpec, DataSpec dataSpec2) {
        if (dataSpec.f9779a.equals(dataSpec2.f9779a)) {
            long j2 = dataSpec.f9786h;
            return j2 != -1 && dataSpec.f9785g + j2 == dataSpec2.f9785g && Util.g(dataSpec.f9787i, dataSpec2.f9787i) && dataSpec.f9788j == dataSpec2.f9788j && dataSpec.f9781c == dataSpec2.f9781c && dataSpec.f9783e.equals(dataSpec2.f9783e);
        }
    }

    protected static DataSpec f(Uri uri) {
        return new DataSpec.Builder().j(uri).c(1).a();
    }

    private static void i(List<Segment> list, CacheKeyFactory cacheKeyFactory, long j2) {
        HashMap hashMap = new HashMap();
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Segment segment = list.get(i3);
            String a2 = cacheKeyFactory.a(segment.X);
            Integer num = (Integer) hashMap.get(a2);
            Segment segment2 = num == null ? null : list.get(num.intValue());
            if (segment2 == null || segment.s > segment2.s + j2 || !d(segment2.X, segment.X)) {
                hashMap.put(a2, Integer.valueOf(i2));
                list.set(i2, segment);
                i2++;
            } else {
                long j3 = segment.X.f9786h;
                long j4 = -1;
                if (j3 != -1) {
                    j4 = segment2.X.f9786h + j3;
                }
                list.set(((Integer) Assertions.g(num)).intValue(), new Segment(segment2.s, segment2.X.f(0, j4)));
            }
        }
        Util.Y1(list, i2, list.size());
    }

    private void j(int i2) {
        synchronized (this.f11861j) {
            this.f11861j.remove(i2);
        }
    }

    private void k(RunnableFutureTask<?, ?> runnableFutureTask) {
        synchronized (this.f11861j) {
            this.f11861j.remove(runnableFutureTask);
        }
    }

    public final void a(@Nullable Downloader.ProgressListener progressListener) throws IOException, InterruptedException {
        CacheDataSource cacheDataSource;
        byte[] bArr;
        int size;
        SegmentDownloadRunnable segmentDownloadRunnable;
        int i2;
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayDeque arrayDeque2 = new ArrayDeque();
        PriorityTaskManager priorityTaskManager = this.f11858g;
        if (priorityTaskManager != null) {
            priorityTaskManager.a(-1000);
        }
        try {
            CacheDataSource d2 = this.f11855d.d();
            FilterableManifest g2 = g(d2, this.f11852a, false);
            if (!this.f11854c.isEmpty()) {
                g2 = (FilterableManifest) g2.a(this.f11854c);
            }
            List<Segment> h2 = h(d2, g2, false);
            Collections.sort(h2);
            i(h2, this.f11857f, this.f11860i);
            int size2 = h2.size();
            long j2 = 0;
            long j3 = 0;
            int i3 = 0;
            for (int size3 = h2.size() - 1; size3 >= 0; size3 = i2 - 1) {
                DataSpec dataSpec = h2.get(size3).X;
                String a2 = this.f11857f.a(dataSpec);
                long j4 = dataSpec.f9786h;
                if (j4 == -1) {
                    long a3 = c.a(this.f11856e.e(a2));
                    if (a3 != -1) {
                        j4 = a3 - dataSpec.f9785g;
                    }
                }
                int i4 = size3;
                long f2 = this.f11856e.f(a2, dataSpec.f9785g, j4);
                j3 += f2;
                if (j4 != -1) {
                    if (j4 == f2) {
                        i3++;
                        i2 = i4;
                        h2.remove(i2);
                    } else {
                        i2 = i4;
                    }
                    if (j2 != -1) {
                        j2 += j4;
                    }
                } else {
                    i2 = i4;
                    j2 = -1;
                }
            }
            ProgressNotifier progressNotifier = progressListener != null ? new ProgressNotifier(progressListener, j2, size2, j3, i3) : null;
            arrayDeque.addAll(h2);
            while (!this.f11862k && !arrayDeque.isEmpty()) {
                PriorityTaskManager priorityTaskManager2 = this.f11858g;
                if (priorityTaskManager2 != null) {
                    priorityTaskManager2.b(-1000);
                }
                if (!arrayDeque2.isEmpty()) {
                    SegmentDownloadRunnable segmentDownloadRunnable2 = (SegmentDownloadRunnable) arrayDeque2.removeFirst();
                    cacheDataSource = segmentDownloadRunnable2.b3;
                    bArr = segmentDownloadRunnable2.d3;
                } else {
                    cacheDataSource = this.f11855d.d();
                    bArr = new byte[131072];
                }
                SegmentDownloadRunnable segmentDownloadRunnable3 = new SegmentDownloadRunnable((Segment) arrayDeque.removeFirst(), cacheDataSource, progressNotifier, bArr);
                c(segmentDownloadRunnable3);
                this.f11859h.execute(segmentDownloadRunnable3);
                size = this.f11861j.size() - 1;
                while (size >= 0) {
                    segmentDownloadRunnable = (SegmentDownloadRunnable) this.f11861j.get(size);
                    if (arrayDeque.isEmpty() || segmentDownloadRunnable.isDone()) {
                        segmentDownloadRunnable.get();
                        j(size);
                        arrayDeque2.addLast(segmentDownloadRunnable);
                    }
                    size--;
                }
                segmentDownloadRunnable3.b();
            }
            for (int i5 = 0; i5 < this.f11861j.size(); i5++) {
                this.f11861j.get(i5).cancel(true);
            }
            for (int size4 = this.f11861j.size() - 1; size4 >= 0; size4--) {
                this.f11861j.get(size4).a();
                j(size4);
            }
            PriorityTaskManager priorityTaskManager3 = this.f11858g;
            if (priorityTaskManager3 != null) {
                priorityTaskManager3.e(-1000);
            }
        } catch (ExecutionException e2) {
            Throwable th = (Throwable) Assertions.g(e2.getCause());
            if (th instanceof PriorityTaskManager.PriorityTooLowException) {
                arrayDeque.addFirst(segmentDownloadRunnable.a3);
                j(size);
                arrayDeque2.addLast(segmentDownloadRunnable);
            } else if (!(th instanceof IOException)) {
                Util.n2(th);
            } else {
                throw ((IOException) th);
            }
        } catch (Throwable th2) {
            for (int i6 = 0; i6 < this.f11861j.size(); i6++) {
                this.f11861j.get(i6).cancel(true);
            }
            for (int size5 = this.f11861j.size() - 1; size5 >= 0; size5--) {
                this.f11861j.get(size5).a();
                j(size5);
            }
            PriorityTaskManager priorityTaskManager4 = this.f11858g;
            if (priorityTaskManager4 != null) {
                priorityTaskManager4.e(-1000);
            }
            throw th2;
        }
    }

    public void cancel() {
        synchronized (this.f11861j) {
            try {
                this.f11862k = true;
                for (int i2 = 0; i2 < this.f11861j.size(); i2++) {
                    this.f11861j.get(i2).cancel(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final <T> T e(RunnableFutureTask<T, ?> runnableFutureTask, boolean z) throws InterruptedException, IOException {
        if (z) {
            runnableFutureTask.run();
            try {
                return runnableFutureTask.get();
            } catch (ExecutionException e2) {
                Throwable th = (Throwable) Assertions.g(e2.getCause());
                if (!(th instanceof IOException)) {
                    Util.n2(e2);
                } else {
                    throw ((IOException) th);
                }
            }
        }
        while (!this.f11862k) {
            PriorityTaskManager priorityTaskManager = this.f11858g;
            if (priorityTaskManager != null) {
                priorityTaskManager.b(-1000);
            }
            c(runnableFutureTask);
            this.f11859h.execute(runnableFutureTask);
            try {
                return runnableFutureTask.get();
            } catch (ExecutionException e3) {
                Throwable th2 = (Throwable) Assertions.g(e3.getCause());
                if (!(th2 instanceof PriorityTaskManager.PriorityTooLowException)) {
                    if (!(th2 instanceof IOException)) {
                        Util.n2(e3);
                    } else {
                        throw ((IOException) th2);
                    }
                }
            } finally {
                runnableFutureTask.a();
                k(runnableFutureTask);
            }
        }
        throw new InterruptedException();
    }

    /* access modifiers changed from: protected */
    public final M g(final DataSource dataSource, final DataSpec dataSpec, boolean z) throws InterruptedException, IOException {
        return (FilterableManifest) e(new RunnableFutureTask<M, IOException>() {
            /* access modifiers changed from: protected */
            /* renamed from: f */
            public M d() throws IOException {
                return (FilterableManifest) ParsingLoadable.h(dataSource, SegmentDownloader.this.f11853b, dataSpec, 4);
            }
        }, z);
    }

    /* access modifiers changed from: protected */
    public abstract List<Segment> h(DataSource dataSource, M m2, boolean z) throws IOException, InterruptedException;

    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void remove() {
        /*
            r5 = this;
            androidx.media3.datasource.cache.CacheDataSource$Factory r0 = r5.f11855d
            androidx.media3.datasource.cache.CacheDataSource r0 = r0.e()
            androidx.media3.datasource.DataSpec r1 = r5.f11852a     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            r2 = 1
            androidx.media3.exoplayer.offline.FilterableManifest r1 = r5.g(r0, r1, r2)     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            java.util.List r0 = r5.h(r0, r1, r2)     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            r1 = 0
        L_0x0012:
            int r2 = r0.size()     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            if (r1 >= r2) goto L_0x0030
            androidx.media3.datasource.cache.Cache r2 = r5.f11856e     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            androidx.media3.datasource.cache.CacheKeyFactory r3 = r5.f11857f     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            java.lang.Object r4 = r0.get(r1)     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            androidx.media3.exoplayer.offline.SegmentDownloader$Segment r4 = (androidx.media3.exoplayer.offline.SegmentDownloader.Segment) r4     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            androidx.media3.datasource.DataSpec r4 = r4.X     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            java.lang.String r3 = r3.a(r4)     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            r2.o(r3)     // Catch:{ InterruptedException -> 0x003e, Exception -> 0x0030 }
            int r1 = r1 + 1
            goto L_0x0012
        L_0x002e:
            r0 = move-exception
            goto L_0x0047
        L_0x0030:
            androidx.media3.datasource.cache.Cache r0 = r5.f11856e
            androidx.media3.datasource.cache.CacheKeyFactory r1 = r5.f11857f
            androidx.media3.datasource.DataSpec r2 = r5.f11852a
            java.lang.String r1 = r1.a(r2)
            r0.o(r1)
            goto L_0x0046
        L_0x003e:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x002e }
            r0.interrupt()     // Catch:{ all -> 0x002e }
            goto L_0x0030
        L_0x0046:
            return
        L_0x0047:
            androidx.media3.datasource.cache.Cache r1 = r5.f11856e
            androidx.media3.datasource.cache.CacheKeyFactory r2 = r5.f11857f
            androidx.media3.datasource.DataSpec r3 = r5.f11852a
            java.lang.String r2 = r2.a(r3)
            r1.o(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.offline.SegmentDownloader.remove():void");
    }

    public SegmentDownloader(MediaItem mediaItem, ParsingLoadable.Parser<M> parser, CacheDataSource.Factory factory, Executor executor, long j2) {
        Assertions.g(mediaItem.X);
        this.f11852a = f(mediaItem.X.s);
        this.f11853b = parser;
        this.f11854c = new ArrayList<>(mediaItem.X.X2);
        this.f11855d = factory;
        this.f11859h = executor;
        this.f11856e = (Cache) Assertions.g(factory.g());
        this.f11857f = factory.h();
        this.f11858g = factory.i();
        this.f11861j = new ArrayList<>();
        this.f11860i = Util.I1(j2);
    }
}
