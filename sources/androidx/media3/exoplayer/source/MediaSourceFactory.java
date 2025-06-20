package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.extractor.text.SubtitleParser;

@UnstableApi
@Deprecated
public interface MediaSourceFactory extends MediaSource.Factory {
    @UnstableApi

    /* renamed from: b  reason: collision with root package name */
    public static final MediaSourceFactory f12173b = new MediaSourceFactory() {
        public /* synthetic */ MediaSource.Factory a(SubtitleParser.Factory factory) {
            return p.c(this, factory);
        }

        public /* synthetic */ MediaSource.Factory b(boolean z) {
            return p.a(this, z);
        }

        public MediaSource c(MediaItem mediaItem) {
            throw new UnsupportedOperationException();
        }

        public int[] f() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ MediaSource.Factory g(CmcdConfiguration.Factory factory) {
            return p.b(this, factory);
        }

        /* renamed from: h */
        public MediaSourceFactory e(@Nullable DrmSessionManagerProvider drmSessionManagerProvider) {
            return this;
        }

        /* renamed from: i */
        public MediaSourceFactory d(@Nullable LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            return this;
        }
    };
}
