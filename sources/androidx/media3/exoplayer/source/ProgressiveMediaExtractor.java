package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.DataReader;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@UnstableApi
public interface ProgressiveMediaExtractor {

    public interface Factory {
        ProgressiveMediaExtractor a(PlayerId playerId);
    }

    void a();

    void c(long j2, long j3);

    long d();

    void e();

    int f(PositionHolder positionHolder) throws IOException;

    void g(DataReader dataReader, Uri uri, Map<String, List<String>> map, long j2, long j3, ExtractorOutput extractorOutput) throws IOException;
}
