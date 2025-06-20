package androidx.media3.datasource;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.DataReader;
import androidx.media3.common.util.UnstableApi;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface DataSource extends DataReader {

    public interface Factory {
        @UnstableApi
        DataSource a();
    }

    @UnstableApi
    long a(DataSpec dataSpec) throws IOException;

    @UnstableApi
    @Nullable
    Uri c();

    @UnstableApi
    void close() throws IOException;

    @UnstableApi
    void e(TransferListener transferListener);

    @UnstableApi
    Map<String, List<String>> getResponseHeaders();
}
