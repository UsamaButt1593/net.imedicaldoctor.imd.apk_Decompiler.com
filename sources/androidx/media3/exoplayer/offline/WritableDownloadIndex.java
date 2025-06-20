package androidx.media3.exoplayer.offline;

import androidx.annotation.WorkerThread;
import androidx.media3.common.util.UnstableApi;
import java.io.IOException;

@WorkerThread
@UnstableApi
public interface WritableDownloadIndex extends DownloadIndex {
    void b() throws IOException;

    void c(String str, int i2) throws IOException;

    void d(Download download) throws IOException;

    void e() throws IOException;

    void g(String str) throws IOException;

    void h(int i2) throws IOException;
}
