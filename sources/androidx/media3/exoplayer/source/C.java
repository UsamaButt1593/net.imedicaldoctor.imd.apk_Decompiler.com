package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.ProgressiveMediaExtractor;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.extractor.ExtractorsFactory;

public final /* synthetic */ class C implements ProgressiveMediaExtractor.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtractorsFactory f12085a;

    public /* synthetic */ C(ExtractorsFactory extractorsFactory) {
        this.f12085a = extractorsFactory;
    }

    public final ProgressiveMediaExtractor a(PlayerId playerId) {
        return ProgressiveMediaSource.Factory.j(this.f12085a, playerId);
    }
}
