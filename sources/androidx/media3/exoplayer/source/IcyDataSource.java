package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class IcyDataSource implements DataSource {

    /* renamed from: b  reason: collision with root package name */
    private final DataSource f12136b;

    /* renamed from: c  reason: collision with root package name */
    private final int f12137c;

    /* renamed from: d  reason: collision with root package name */
    private final Listener f12138d;

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f12139e;

    /* renamed from: f  reason: collision with root package name */
    private int f12140f;

    public interface Listener {
        void b(ParsableByteArray parsableByteArray);
    }

    public IcyDataSource(DataSource dataSource, int i2, Listener listener) {
        Assertions.a(i2 > 0);
        this.f12136b = dataSource;
        this.f12137c = i2;
        this.f12138d = listener;
        this.f12139e = new byte[1];
        this.f12140f = i2;
    }

    private boolean t() throws IOException {
        if (this.f12136b.read(this.f12139e, 0, 1) == -1) {
            return false;
        }
        int i2 = (this.f12139e[0] & 255) << 4;
        if (i2 == 0) {
            return true;
        }
        byte[] bArr = new byte[i2];
        int i3 = i2;
        int i4 = 0;
        while (i3 > 0) {
            int read = this.f12136b.read(bArr, i4, i3);
            if (read == -1) {
                return false;
            }
            i4 += read;
            i3 -= read;
        }
        while (i2 > 0 && bArr[i2 - 1] == 0) {
            i2--;
        }
        if (i2 > 0) {
            this.f12138d.b(new ParsableByteArray(bArr, i2));
        }
        return true;
    }

    public long a(DataSpec dataSpec) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    public Uri c() {
        return this.f12136b.c();
    }

    public void close() {
        throw new UnsupportedOperationException();
    }

    public void e(TransferListener transferListener) {
        Assertions.g(transferListener);
        this.f12136b.e(transferListener);
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this.f12136b.getResponseHeaders();
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f12140f == 0) {
            if (!t()) {
                return -1;
            }
            this.f12140f = this.f12137c;
        }
        int read = this.f12136b.read(bArr, i2, Math.min(this.f12140f, i3));
        if (read != -1) {
            this.f12140f -= read;
        }
        return read;
    }
}
