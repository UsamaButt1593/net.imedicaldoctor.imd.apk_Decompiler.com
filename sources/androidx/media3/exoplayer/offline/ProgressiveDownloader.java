package androidx.media3.exoplayer.offline;

import androidx.annotation.Nullable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.RunnableFutureTask;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.datasource.cache.CacheWriter;
import androidx.media3.exoplayer.dash.offline.a;
import androidx.media3.exoplayer.offline.Downloader;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

@UnstableApi
public final class ProgressiveDownloader implements Downloader {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f11842a;

    /* renamed from: b  reason: collision with root package name */
    private final DataSpec f11843b;

    /* renamed from: c  reason: collision with root package name */
    private final CacheDataSource f11844c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final CacheWriter f11845d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final PriorityTaskManager f11846e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Downloader.ProgressListener f11847f;

    /* renamed from: g  reason: collision with root package name */
    private volatile RunnableFutureTask<Void, IOException> f11848g;

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f11849h;

    public ProgressiveDownloader(MediaItem mediaItem, CacheDataSource.Factory factory) {
        this(mediaItem, factory, new a());
    }

    /* access modifiers changed from: private */
    public void d(long j2, long j3, long j4) {
        Downloader.ProgressListener progressListener = this.f11847f;
        if (progressListener != null) {
            progressListener.a(j2, j3, (j2 == -1 || j2 == 0) ? -1.0f : (((float) j3) * 100.0f) / ((float) j2));
        }
    }

    public void a(@Nullable Downloader.ProgressListener progressListener) throws IOException, InterruptedException {
        this.f11847f = progressListener;
        PriorityTaskManager priorityTaskManager = this.f11846e;
        if (priorityTaskManager != null) {
            priorityTaskManager.a(-1000);
        }
        boolean z = false;
        while (!z) {
            try {
                if (this.f11849h) {
                    break;
                }
                this.f11848g = new RunnableFutureTask<Void, IOException>() {
                    /* access modifiers changed from: protected */
                    public void c() {
                        ProgressiveDownloader.this.f11845d.b();
                    }

                    /* access modifiers changed from: protected */
                    /* renamed from: f */
                    public Void d() throws IOException {
                        ProgressiveDownloader.this.f11845d.a();
                        return null;
                    }
                };
                PriorityTaskManager priorityTaskManager2 = this.f11846e;
                if (priorityTaskManager2 != null) {
                    priorityTaskManager2.b(-1000);
                }
                this.f11842a.execute(this.f11848g);
                this.f11848g.get();
                z = true;
            } catch (ExecutionException e2) {
                Throwable th = (Throwable) Assertions.g(e2.getCause());
                if (!(th instanceof PriorityTaskManager.PriorityTooLowException)) {
                    if (!(th instanceof IOException)) {
                        Util.n2(th);
                    } else {
                        throw ((IOException) th);
                    }
                }
            } catch (Throwable th2) {
                ((RunnableFutureTask) Assertions.g(this.f11848g)).a();
                PriorityTaskManager priorityTaskManager3 = this.f11846e;
                if (priorityTaskManager3 != null) {
                    priorityTaskManager3.e(-1000);
                }
                throw th2;
            }
        }
        ((RunnableFutureTask) Assertions.g(this.f11848g)).a();
        PriorityTaskManager priorityTaskManager4 = this.f11846e;
        if (priorityTaskManager4 != null) {
            priorityTaskManager4.e(-1000);
        }
    }

    public void cancel() {
        this.f11849h = true;
        RunnableFutureTask<Void, IOException> runnableFutureTask = this.f11848g;
        if (runnableFutureTask != null) {
            runnableFutureTask.cancel(true);
        }
    }

    public void remove() {
        this.f11844c.u().o(this.f11844c.v().a(this.f11843b));
    }

    public ProgressiveDownloader(MediaItem mediaItem, CacheDataSource.Factory factory, Executor executor) {
        this.f11842a = (Executor) Assertions.g(executor);
        Assertions.g(mediaItem.X);
        DataSpec a2 = new DataSpec.Builder().j(mediaItem.X.s).g(mediaItem.X.Y2).c(4).a();
        this.f11843b = a2;
        CacheDataSource d2 = factory.d();
        this.f11844c = d2;
        this.f11845d = new CacheWriter(d2, a2, (byte[]) null, new p(this));
        this.f11846e = factory.i();
    }
}
