package androidx.media3.datasource;

import android.net.http.UploadDataProvider;
import android.net.http.UploadDataSink;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.nio.ByteBuffer;

@RequiresApi(34)
final class ByteArrayUploadDataProvider extends UploadDataProvider {
    private int X;
    private final byte[] s;

    public ByteArrayUploadDataProvider(byte[] bArr) {
        this.s = bArr;
    }

    public long getLength() {
        return (long) this.s.length;
    }

    public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) throws IOException {
        int min = Math.min(byteBuffer.remaining(), this.s.length - this.X);
        byteBuffer.put(this.s, this.X, min);
        this.X += min;
        uploadDataSink.onReadSucceeded(false);
    }

    public void rewind(UploadDataSink uploadDataSink) throws IOException {
        this.X = 0;
        uploadDataSink.onRewindSucceeded();
    }
}
