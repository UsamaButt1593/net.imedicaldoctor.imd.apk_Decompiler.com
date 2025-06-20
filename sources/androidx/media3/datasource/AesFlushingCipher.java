package androidx.media3.datasource;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@UnstableApi
public final class AesFlushingCipher {

    /* renamed from: a  reason: collision with root package name */
    private final Cipher f9738a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9739b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f9740c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f9741d;

    /* renamed from: e  reason: collision with root package name */
    private int f9742e;

    public AesFlushingCipher(int i2, byte[] bArr, long j2, long j3) {
        try {
            Cipher instance = Cipher.getInstance("AES/CTR/NoPadding");
            this.f9738a = instance;
            int blockSize = instance.getBlockSize();
            this.f9739b = blockSize;
            this.f9740c = new byte[blockSize];
            this.f9741d = new byte[blockSize];
            int i3 = (int) (j3 % ((long) blockSize));
            instance.init(i2, new SecretKeySpec(bArr, Util.q2(instance.getAlgorithm(), "/")[0]), new IvParameterSpec(b(j2, j3 / ((long) blockSize))));
            if (i3 != 0) {
                e(new byte[i3], 0, i3);
            }
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static long a(@Nullable String str) {
        long j2 = 0;
        if (str == null) {
            return 0;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            long charAt = j2 ^ ((long) str.charAt(i2));
            j2 = charAt + (charAt << 1) + (charAt << 4) + (charAt << 5) + (charAt << 7) + (charAt << 8) + (charAt << 40);
        }
        return j2;
    }

    private byte[] b(long j2, long j3) {
        return ByteBuffer.allocate(16).putLong(j2).putLong(j3).array();
    }

    private int c(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        try {
            return this.f9738a.update(bArr, i2, i3, bArr2, i4);
        } catch (ShortBufferException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void d(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5 = i2;
        do {
            int i6 = this.f9742e;
            if (i6 > 0) {
                bArr2[i4] = (byte) (bArr[i5] ^ this.f9741d[this.f9739b - i6]);
                i4++;
                i5++;
                this.f9742e = i6 - 1;
                i3--;
            } else {
                int c2 = c(bArr, i5, i3, bArr2, i4);
                if (i3 != c2) {
                    int i7 = i3 - c2;
                    int i8 = 0;
                    boolean z = true;
                    Assertions.i(i7 < this.f9739b);
                    int i9 = i4 + c2;
                    int i10 = this.f9739b - i7;
                    this.f9742e = i10;
                    if (c(this.f9740c, 0, i10, this.f9741d, 0) != this.f9739b) {
                        z = false;
                    }
                    Assertions.i(z);
                    while (i8 < i7) {
                        bArr2[i9] = this.f9741d[i8];
                        i8++;
                        i9++;
                    }
                    return;
                }
                return;
            }
        } while (i3 != 0);
    }

    public void e(byte[] bArr, int i2, int i3) {
        d(bArr, i2, i3, bArr, i2);
    }

    public AesFlushingCipher(int i2, byte[] bArr, @Nullable String str, long j2) {
        this(i2, bArr, a(str), j2);
    }
}
