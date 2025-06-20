package androidx.media3.exoplayer.source.chunk;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import java.io.IOException;
import java.util.Arrays;

@UnstableApi
public abstract class DataChunk extends Chunk {

    /* renamed from: l  reason: collision with root package name */
    private static final int f12289l = 16384;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f12290j;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f12291k;

    public DataChunk(DataSource dataSource, DataSpec dataSpec, int i2, Format format, int i3, @Nullable Object obj, @Nullable byte[] bArr) {
        super(dataSource, dataSpec, i2, format, i3, obj, C.f9084b, C.f9084b);
        DataChunk dataChunk;
        byte[] bArr2;
        if (bArr == null) {
            bArr2 = Util.f9651f;
            dataChunk = this;
        } else {
            dataChunk = this;
            bArr2 = bArr;
        }
        dataChunk.f12290j = bArr2;
    }

    private void i(int i2) {
        byte[] bArr = this.f12290j;
        if (bArr.length < i2 + 16384) {
            this.f12290j = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }

    public final void a() throws IOException {
        try {
            this.f12286i.a(this.f12279b);
            int i2 = 0;
            int i3 = 0;
            while (i2 != -1 && !this.f12291k) {
                i(i3);
                i2 = this.f12286i.read(this.f12290j, i3, 16384);
                if (i2 != -1) {
                    i3 += i2;
                }
            }
            if (!this.f12291k) {
                g(this.f12290j, i3);
            }
            DataSourceUtil.a(this.f12286i);
        } catch (Throwable th) {
            DataSourceUtil.a(this.f12286i);
            throw th;
        }
    }

    public final void c() {
        this.f12291k = true;
    }

    /* access modifiers changed from: protected */
    public abstract void g(byte[] bArr, int i2) throws IOException;

    public byte[] h() {
        return this.f12290j;
    }
}
