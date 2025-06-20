package androidx.media3.exoplayer.offline;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import java.io.IOException;

@UnstableApi
public interface Downloader {

    public interface ProgressListener {
        void a(long j2, long j3, float f2);
    }

    void a(@Nullable ProgressListener progressListener) throws IOException, InterruptedException;

    void cancel();

    void remove();
}
