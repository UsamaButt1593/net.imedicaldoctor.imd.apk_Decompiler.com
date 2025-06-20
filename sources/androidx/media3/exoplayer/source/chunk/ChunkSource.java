package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import java.io.IOException;
import java.util.List;

@UnstableApi
public interface ChunkSource {
    void a();

    void b() throws IOException;

    void d(Chunk chunk);

    void e(LoadingInfo loadingInfo, long j2, List<? extends MediaChunk> list, ChunkHolder chunkHolder);

    long f(long j2, SeekParameters seekParameters);

    boolean g(Chunk chunk, boolean z, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, LoadErrorHandlingPolicy loadErrorHandlingPolicy);

    int j(long j2, List<? extends MediaChunk> list);

    boolean k(long j2, Chunk chunk, List<? extends MediaChunk> list);
}
