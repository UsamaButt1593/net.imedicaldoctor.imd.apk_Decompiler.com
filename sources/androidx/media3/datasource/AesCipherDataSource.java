package androidx.media3.datasource;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@UnstableApi
public final class AesCipherDataSource implements DataSource {

    /* renamed from: b  reason: collision with root package name */
    private final DataSource f9735b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f9736c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private AesFlushingCipher f9737d;

    public AesCipherDataSource(byte[] bArr, DataSource dataSource) {
        this.f9735b = dataSource;
        this.f9736c = bArr;
    }

    public long a(DataSpec dataSpec) throws IOException {
        long a2 = this.f9735b.a(dataSpec);
        this.f9737d = new AesFlushingCipher(2, this.f9736c, dataSpec.f9787i, dataSpec.f9785g + dataSpec.f9780b);
        return a2;
    }

    @Nullable
    public Uri c() {
        return this.f9735b.c();
    }

    public void close() throws IOException {
        this.f9737d = null;
        this.f9735b.close();
    }

    public void e(TransferListener transferListener) {
        Assertions.g(transferListener);
        this.f9735b.e(transferListener);
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this.f9735b.getResponseHeaders();
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        int read = this.f9735b.read(bArr, i2, i3);
        if (read == -1) {
            return -1;
        }
        ((AesFlushingCipher) Util.o(this.f9737d)).e(bArr, i2, read);
        return read;
    }
}
