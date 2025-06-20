package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.DefaultAllocator;
import androidx.media3.extractor.DefaultExtractorsFactory;
import androidx.media3.extractor.ExtractorsFactory;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;

@UnstableApi
public final class MetadataRetriever {

    private static final class MetadataRetrieverInternal {

        /* renamed from: e  reason: collision with root package name */
        private static final int f10293e = 0;

        /* renamed from: f  reason: collision with root package name */
        private static final int f10294f = 1;

        /* renamed from: g  reason: collision with root package name */
        private static final int f10295g = 2;

        /* renamed from: h  reason: collision with root package name */
        private static final int f10296h = 3;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final MediaSource.Factory f10297a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final HandlerThread f10298b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final HandlerWrapper f10299c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final SettableFuture<TrackGroupArray> f10300d = SettableFuture.F();

        private final class MediaSourceHandlerCallback implements Handler.Callback {
            private static final int X2 = 100;
            private MediaSource X;
            /* access modifiers changed from: private */
            public MediaPeriod Y;
            private final MediaSourceCaller s = new MediaSourceCaller();

            private final class MediaSourceCaller implements MediaSource.MediaSourceCaller {
                private final Allocator X = new DefaultAllocator(true, 65536);
                private boolean Y;
                private final MediaPeriodCallback s = new MediaPeriodCallback();

                private final class MediaPeriodCallback implements MediaPeriod.Callback {
                    private MediaPeriodCallback() {
                    }

                    /* renamed from: a */
                    public void j(MediaPeriod mediaPeriod) {
                        MetadataRetrieverInternal.this.f10299c.f(2).a();
                    }

                    public void i(MediaPeriod mediaPeriod) {
                        MetadataRetrieverInternal.this.f10300d.B(mediaPeriod.s());
                        MetadataRetrieverInternal.this.f10299c.f(3).a();
                    }
                }

                public MediaSourceCaller() {
                }

                public void W(MediaSource mediaSource, Timeline timeline) {
                    if (!this.Y) {
                        this.Y = true;
                        MediaPeriod unused = MediaSourceHandlerCallback.this.Y = mediaSource.E(new MediaSource.MediaPeriodId(timeline.t(0)), this.X, 0);
                        MediaSourceHandlerCallback.this.Y.r(this.s, 0);
                    }
                }
            }

            public MediaSourceHandlerCallback() {
            }

            public boolean handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 0) {
                    MediaSource c2 = MetadataRetrieverInternal.this.f10297a.c((MediaItem) message.obj);
                    this.X = c2;
                    c2.Y(this.s, (TransferListener) null, PlayerId.f10613b);
                    MetadataRetrieverInternal.this.f10299c.i(1);
                    return true;
                } else if (i2 == 1) {
                    try {
                        MediaPeriod mediaPeriod = this.Y;
                        if (mediaPeriod == null) {
                            ((MediaSource) Assertions.g(this.X)).I();
                        } else {
                            mediaPeriod.l();
                        }
                        MetadataRetrieverInternal.this.f10299c.c(1, 100);
                    } catch (Exception e2) {
                        MetadataRetrieverInternal.this.f10300d.C(e2);
                        MetadataRetrieverInternal.this.f10299c.f(3).a();
                    }
                    return true;
                } else if (i2 == 2) {
                    ((MediaPeriod) Assertions.g(this.Y)).a(new LoadingInfo.Builder().f(0).d());
                    return true;
                } else if (i2 != 3) {
                    return false;
                } else {
                    if (this.Y != null) {
                        ((MediaSource) Assertions.g(this.X)).X(this.Y);
                    }
                    ((MediaSource) Assertions.g(this.X)).x(this.s);
                    MetadataRetrieverInternal.this.f10299c.n((Object) null);
                    MetadataRetrieverInternal.this.f10298b.quit();
                    return true;
                }
            }
        }

        public MetadataRetrieverInternal(MediaSource.Factory factory, Clock clock) {
            this.f10297a = factory;
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:MetadataRetriever");
            this.f10298b = handlerThread;
            handlerThread.start();
            this.f10299c = clock.e(handlerThread.getLooper(), new MediaSourceHandlerCallback());
        }

        public ListenableFuture<TrackGroupArray> e(MediaItem mediaItem) {
            this.f10299c.m(0, mediaItem).a();
            return this.f10300d;
        }
    }

    private MetadataRetriever() {
    }

    public static ListenableFuture<TrackGroupArray> a(Context context, MediaItem mediaItem) {
        return b(context, mediaItem, Clock.f9502a);
    }

    @VisibleForTesting
    static ListenableFuture<TrackGroupArray> b(Context context, MediaItem mediaItem, Clock clock) {
        return d(new DefaultMediaSourceFactory(context, (ExtractorsFactory) new DefaultExtractorsFactory().t(6)), mediaItem, clock);
    }

    public static ListenableFuture<TrackGroupArray> c(MediaSource.Factory factory, MediaItem mediaItem) {
        return d(factory, mediaItem, Clock.f9502a);
    }

    private static ListenableFuture<TrackGroupArray> d(MediaSource.Factory factory, MediaItem mediaItem, Clock clock) {
        return new MetadataRetrieverInternal(factory, clock).e(mediaItem);
    }
}
