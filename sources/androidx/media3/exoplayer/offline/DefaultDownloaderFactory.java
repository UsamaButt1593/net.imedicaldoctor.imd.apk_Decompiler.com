package androidx.media3.exoplayer.offline;

import android.util.SparseArray;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.exoplayer.dash.offline.DashDownloader;
import androidx.media3.exoplayer.dash.offline.a;
import androidx.media3.exoplayer.hls.offline.HlsDownloader;
import androidx.media3.exoplayer.smoothstreaming.offline.SsDownloader;
import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;

@UnstableApi
public class DefaultDownloaderFactory implements DownloaderFactory {

    /* renamed from: c  reason: collision with root package name */
    private static final SparseArray<Constructor<? extends Downloader>> f11753c = c();

    /* renamed from: a  reason: collision with root package name */
    private final CacheDataSource.Factory f11754a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f11755b;

    @Deprecated
    public DefaultDownloaderFactory(CacheDataSource.Factory factory) {
        this(factory, new a());
    }

    private Downloader b(DownloadRequest downloadRequest, int i2) {
        Constructor constructor = f11753c.get(i2);
        if (constructor != null) {
            MediaItem a2 = new MediaItem.Builder().M(downloadRequest.X).I(downloadRequest.Z).l(downloadRequest.Y2).a();
            try {
                return (Downloader) constructor.newInstance(new Object[]{a2, this.f11754a, this.f11755b});
            } catch (Exception e2) {
                throw new IllegalStateException("Failed to instantiate downloader for content type " + i2, e2);
            }
        } else {
            throw new IllegalStateException("Module missing for content type " + i2);
        }
    }

    private static SparseArray<Constructor<? extends Downloader>> c() {
        SparseArray<Constructor<? extends Downloader>> sparseArray = new SparseArray<>();
        try {
            sparseArray.put(0, d(DashDownloader.class));
        } catch (ClassNotFoundException unused) {
        }
        try {
            sparseArray.put(2, d(HlsDownloader.class));
        } catch (ClassNotFoundException unused2) {
        }
        try {
            sparseArray.put(1, d(SsDownloader.class));
        } catch (ClassNotFoundException unused3) {
        }
        return sparseArray;
    }

    private static Constructor<? extends Downloader> d(Class<?> cls) {
        try {
            return cls.asSubclass(Downloader.class).getConstructor(new Class[]{MediaItem.class, CacheDataSource.Factory.class, Executor.class});
        } catch (NoSuchMethodException e2) {
            throw new IllegalStateException("Downloader constructor missing", e2);
        }
    }

    public Downloader a(DownloadRequest downloadRequest) {
        int b1 = Util.b1(downloadRequest.X, downloadRequest.Y);
        if (b1 == 0 || b1 == 1 || b1 == 2) {
            return b(downloadRequest, b1);
        }
        if (b1 == 4) {
            return new ProgressiveDownloader(new MediaItem.Builder().M(downloadRequest.X).l(downloadRequest.Y2).a(), this.f11754a, this.f11755b);
        }
        throw new IllegalArgumentException("Unsupported type: " + b1);
    }

    public DefaultDownloaderFactory(CacheDataSource.Factory factory, Executor executor) {
        this.f11754a = (CacheDataSource.Factory) Assertions.g(factory);
        this.f11755b = (Executor) Assertions.g(executor);
    }
}
