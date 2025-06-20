package androidx.media3.decoder;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
public final class CryptoInfo {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public byte[] f10051a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public byte[] f10052b;

    /* renamed from: c  reason: collision with root package name */
    public int f10053c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public int[] f10054d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public int[] f10055e;

    /* renamed from: f  reason: collision with root package name */
    public int f10056f;

    /* renamed from: g  reason: collision with root package name */
    public int f10057g;

    /* renamed from: h  reason: collision with root package name */
    public int f10058h;

    /* renamed from: i  reason: collision with root package name */
    private final MediaCodec.CryptoInfo f10059i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private final PatternHolderV24 f10060j;

    @RequiresApi(24)
    private static final class PatternHolderV24 {

        /* renamed from: a  reason: collision with root package name */
        private final MediaCodec.CryptoInfo f10061a;

        /* renamed from: b  reason: collision with root package name */
        private final MediaCodec.CryptoInfo.Pattern f10062b;

        private PatternHolderV24(MediaCodec.CryptoInfo cryptoInfo) {
            this.f10061a = cryptoInfo;
            this.f10062b = c.a(0, 0);
        }

        /* access modifiers changed from: private */
        public void b(int i2, int i3) {
            this.f10062b.set(i2, i3);
            this.f10061a.setPattern(this.f10062b);
        }
    }

    public CryptoInfo() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f10059i = cryptoInfo;
        this.f10060j = Util.f9646a >= 24 ? new PatternHolderV24(cryptoInfo) : null;
    }

    public MediaCodec.CryptoInfo a() {
        return this.f10059i;
    }

    public void b(int i2) {
        if (i2 != 0) {
            if (this.f10054d == null) {
                int[] iArr = new int[1];
                this.f10054d = iArr;
                this.f10059i.numBytesOfClearData = iArr;
            }
            int[] iArr2 = this.f10054d;
            iArr2[0] = iArr2[0] + i2;
        }
    }

    public void c(int i2, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i3, int i4, int i5) {
        this.f10056f = i2;
        this.f10054d = iArr;
        this.f10055e = iArr2;
        this.f10052b = bArr;
        this.f10051a = bArr2;
        this.f10053c = i3;
        this.f10057g = i4;
        this.f10058h = i5;
        MediaCodec.CryptoInfo cryptoInfo = this.f10059i;
        cryptoInfo.numSubSamples = i2;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i3;
        if (Util.f9646a >= 24) {
            ((PatternHolderV24) Assertions.g(this.f10060j)).b(i4, i5);
        }
    }
}
