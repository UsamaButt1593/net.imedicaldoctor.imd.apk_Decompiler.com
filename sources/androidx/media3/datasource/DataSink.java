package androidx.media3.datasource;

import androidx.media3.common.util.UnstableApi;
import java.io.IOException;

@UnstableApi
public interface DataSink {

    public interface Factory {
        DataSink a();
    }

    void a(DataSpec dataSpec) throws IOException;

    void close() throws IOException;

    void write(byte[] bArr, int i2, int i3) throws IOException;
}
