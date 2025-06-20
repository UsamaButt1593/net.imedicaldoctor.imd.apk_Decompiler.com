package androidx.media3.exoplayer.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceInputStream;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class Aes128DataSource implements DataSource {

    /* renamed from: b  reason: collision with root package name */
    private final DataSource f11362b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f11363c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f11364d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private CipherInputStream f11365e;

    public Aes128DataSource(DataSource dataSource, byte[] bArr, byte[] bArr2) {
        this.f11362b = dataSource;
        this.f11363c = bArr;
        this.f11364d = bArr2;
    }

    public final long a(DataSpec dataSpec) throws IOException {
        try {
            Cipher t = t();
            try {
                t.init(2, new SecretKeySpec(this.f11363c, "AES"), new IvParameterSpec(this.f11364d));
                DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(this.f11362b, dataSpec);
                this.f11365e = new CipherInputStream(dataSourceInputStream, t);
                dataSourceInputStream.d();
                return -1;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e2) {
                throw new RuntimeException(e2);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Nullable
    public final Uri c() {
        return this.f11362b.c();
    }

    public void close() throws IOException {
        if (this.f11365e != null) {
            this.f11365e = null;
            this.f11362b.close();
        }
    }

    public final void e(TransferListener transferListener) {
        Assertions.g(transferListener);
        this.f11362b.e(transferListener);
    }

    public final Map<String, List<String>> getResponseHeaders() {
        return this.f11362b.getResponseHeaders();
    }

    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        Assertions.g(this.f11365e);
        int read = this.f11365e.read(bArr, i2, i3);
        if (read < 0) {
            return -1;
        }
        return read;
    }

    /* access modifiers changed from: protected */
    public Cipher t() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }
}
