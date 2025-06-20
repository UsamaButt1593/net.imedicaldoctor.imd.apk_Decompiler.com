package androidx.media3.exoplayer.source.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.source.ads.AdsMediaSource;
import java.io.IOException;

public interface AdsLoader {

    @UnstableApi
    public interface EventListener {
        void a(AdPlaybackState adPlaybackState);

        void b();

        void c(AdsMediaSource.AdLoadException adLoadException, DataSpec dataSpec);

        void d();
    }

    public interface Provider {
        @Nullable
        AdsLoader a(MediaItem.AdsConfiguration adsConfiguration);
    }

    void a();

    @UnstableApi
    void b(AdsMediaSource adsMediaSource, DataSpec dataSpec, Object obj, AdViewProvider adViewProvider, EventListener eventListener);

    @UnstableApi
    void c(AdsMediaSource adsMediaSource, EventListener eventListener);

    @UnstableApi
    void d(AdsMediaSource adsMediaSource, int i2, int i3, IOException iOException);

    @UnstableApi
    void e(AdsMediaSource adsMediaSource, int i2, int i3);

    void f(@Nullable Player player);

    @UnstableApi
    void g(int... iArr);
}
