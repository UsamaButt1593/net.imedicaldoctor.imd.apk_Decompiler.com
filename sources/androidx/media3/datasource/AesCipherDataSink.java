package androidx.media3.datasource;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.io.IOException;

@UnstableApi
public final class AesCipherDataSink implements DataSink {

    /* renamed from: a  reason: collision with root package name */
    private final DataSink f9731a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f9732b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f9733c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private AesFlushingCipher f9734d;

    public AesCipherDataSink(byte[] bArr, DataSink dataSink) {
        this(bArr, dataSink, (byte[]) null);
    }

    public void a(DataSpec dataSpec) throws IOException {
        this.f9731a.a(dataSpec);
        this.f9734d = new AesFlushingCipher(1, this.f9732b, dataSpec.f9787i, dataSpec.f9785g + dataSpec.f9780b);
    }

    public void close() throws IOException {
        this.f9734d = null;
        this.f9731a.close();
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f9733c == null) {
            ((AesFlushingCipher) Util.o(this.f9734d)).e(bArr, i2, i3);
            this.f9731a.write(bArr, i2, i3);
            return;
        }
        int i4 = 0;
        while (i4 < i3) {
            int min = Math.min(i3 - i4, this.f9733c.length);
            ((AesFlushingCipher) Util.o(this.f9734d)).d(bArr, i2 + i4, min, this.f9733c, 0);
            this.f9731a.write(this.f9733c, 0, min);
            i4 += min;
        }
    }

    public AesCipherDataSink(byte[] bArr, DataSink dataSink, @Nullable byte[] bArr2) {
        this.f9731a = dataSink;
        this.f9732b = bArr;
        this.f9733c = bArr2;
    }
}
