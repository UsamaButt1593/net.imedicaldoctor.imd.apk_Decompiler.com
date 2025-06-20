package androidx.media3.datasource;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import java.io.IOException;

@UnstableApi
public final class ByteArrayDataSource extends BaseDataSource {

    /* renamed from: f  reason: collision with root package name */
    private final byte[] f9756f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Uri f9757g;

    /* renamed from: h  reason: collision with root package name */
    private int f9758h;

    /* renamed from: i  reason: collision with root package name */
    private int f9759i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f9760j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ByteArrayDataSource(byte[] bArr) {
        super(false);
        boolean z = false;
        Assertions.g(bArr);
        Assertions.a(bArr.length > 0 ? true : z);
        this.f9756f = bArr;
    }

    public long a(DataSpec dataSpec) throws IOException {
        this.f9757g = dataSpec.f9779a;
        v(dataSpec);
        long j2 = dataSpec.f9785g;
        byte[] bArr = this.f9756f;
        if (j2 <= ((long) bArr.length)) {
            this.f9758h = (int) j2;
            int length = bArr.length - ((int) j2);
            this.f9759i = length;
            long j3 = dataSpec.f9786h;
            if (j3 != -1) {
                this.f9759i = (int) Math.min((long) length, j3);
            }
            this.f9760j = true;
            w(dataSpec);
            long j4 = dataSpec.f9786h;
            return j4 != -1 ? j4 : (long) this.f9759i;
        }
        throw new DataSourceException(2008);
    }

    @Nullable
    public Uri c() {
        return this.f9757g;
    }

    public void close() {
        if (this.f9760j) {
            this.f9760j = false;
            u();
        }
        this.f9757g = null;
    }

    public int read(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        int i4 = this.f9759i;
        if (i4 == 0) {
            return -1;
        }
        int min = Math.min(i3, i4);
        System.arraycopy(this.f9756f, this.f9758h, bArr, i2, min);
        this.f9758h += min;
        this.f9759i -= min;
        t(min);
        return min;
    }
}
