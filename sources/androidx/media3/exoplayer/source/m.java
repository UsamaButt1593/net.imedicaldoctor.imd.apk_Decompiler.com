package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.ProgressiveMediaExtractor;

public final /* synthetic */ class m implements ProgressiveMediaExtractor.Factory {
    public final ProgressiveMediaExtractor a(PlayerId playerId) {
        return MediaParserExtractorAdapter.h(playerId);
    }
}
