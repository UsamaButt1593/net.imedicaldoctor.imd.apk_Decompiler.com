package androidx.media3.datasource;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@UnstableApi
public final class ByteArrayDataSink implements DataSink {

    /* renamed from: a  reason: collision with root package name */
    private ByteArrayOutputStream f9755a;

    public void a(DataSpec dataSpec) {
        long j2 = dataSpec.f9786h;
        if (j2 == -1) {
            this.f9755a = new ByteArrayOutputStream();
            return;
        }
        Assertions.a(j2 <= 2147483647L);
        this.f9755a = new ByteArrayOutputStream((int) dataSpec.f9786h);
    }

    @Nullable
    public byte[] b() {
        ByteArrayOutputStream byteArrayOutputStream = this.f9755a;
        if (byteArrayOutputStream == null) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public void close() throws IOException {
        ((ByteArrayOutputStream) Util.o(this.f9755a)).close();
    }

    public void write(byte[] bArr, int i2, int i3) {
        ((ByteArrayOutputStream) Util.o(this.f9755a)).write(bArr, i2, i3);
    }
}
