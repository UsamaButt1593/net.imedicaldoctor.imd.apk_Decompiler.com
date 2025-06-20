package androidx.media3.extractor.ts;

import androidx.media3.common.util.Assertions;
import java.util.Arrays;

final class NalUnitTargetBuffer {

    /* renamed from: a  reason: collision with root package name */
    private final int f14422a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f14423b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14424c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f14425d;

    /* renamed from: e  reason: collision with root package name */
    public int f14426e;

    public NalUnitTargetBuffer(int i2, int i3) {
        this.f14422a = i2;
        byte[] bArr = new byte[(i3 + 3)];
        this.f14425d = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i2, int i3) {
        if (this.f14423b) {
            int i4 = i3 - i2;
            byte[] bArr2 = this.f14425d;
            int length = bArr2.length;
            int i5 = this.f14426e;
            if (length < i5 + i4) {
                this.f14425d = Arrays.copyOf(bArr2, (i5 + i4) * 2);
            }
            System.arraycopy(bArr, i2, this.f14425d, this.f14426e, i4);
            this.f14426e += i4;
        }
    }

    public boolean b(int i2) {
        if (!this.f14423b) {
            return false;
        }
        this.f14426e -= i2;
        this.f14423b = false;
        this.f14424c = true;
        return true;
    }

    public boolean c() {
        return this.f14424c;
    }

    public void d() {
        this.f14423b = false;
        this.f14424c = false;
    }

    public void e(int i2) {
        boolean z = true;
        Assertions.i(!this.f14423b);
        if (i2 != this.f14422a) {
            z = false;
        }
        this.f14423b = z;
        if (z) {
            this.f14426e = 3;
            this.f14424c = false;
        }
    }
}
