package androidx.media3.datasource;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import java.io.IOException;
import java.io.InputStream;

@UnstableApi
public final class DataSourceInputStream extends InputStream {
    private final DataSpec X;
    private boolean X2 = false;
    private final byte[] Y;
    private long Y2;
    private boolean Z = false;
    private final DataSource s;

    public DataSourceInputStream(DataSource dataSource, DataSpec dataSpec) {
        this.s = dataSource;
        this.X = dataSpec;
        this.Y = new byte[1];
    }

    private void c() throws IOException {
        if (!this.Z) {
            this.s.a(this.X);
            this.Z = true;
        }
    }

    public long b() {
        return this.Y2;
    }

    public void close() throws IOException {
        if (!this.X2) {
            this.s.close();
            this.X2 = true;
        }
    }

    public void d() throws IOException {
        c();
    }

    public int read() throws IOException {
        if (read(this.Y) == -1) {
            return -1;
        }
        return this.Y[0] & 255;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        Assertions.i(!this.X2);
        c();
        int read = this.s.read(bArr, i2, i3);
        if (read == -1) {
            return -1;
        }
        this.Y2 += (long) read;
        return read;
    }
}
