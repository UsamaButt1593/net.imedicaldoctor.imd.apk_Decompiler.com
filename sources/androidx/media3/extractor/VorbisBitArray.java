package androidx.media3.extractor;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class VorbisBitArray {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f13146a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13147b;

    /* renamed from: c  reason: collision with root package name */
    private int f13148c;

    /* renamed from: d  reason: collision with root package name */
    private int f13149d;

    public VorbisBitArray(byte[] bArr) {
        this.f13146a = bArr;
        this.f13147b = bArr.length;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.f13147b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r2 = this;
            int r0 = r2.f13148c
            if (r0 < 0) goto L_0x0010
            int r1 = r2.f13147b
            if (r0 < r1) goto L_0x000e
            if (r0 != r1) goto L_0x0010
            int r0 = r2.f13149d
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            androidx.media3.common.util.Assertions.i(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.VorbisBitArray.a():void");
    }

    public int b() {
        return ((this.f13147b - this.f13148c) * 8) - this.f13149d;
    }

    public int c() {
        return (this.f13148c * 8) + this.f13149d;
    }

    public boolean d() {
        boolean z = (((this.f13146a[this.f13148c] & 255) >> this.f13149d) & 1) == 1;
        h(1);
        return z;
    }

    public int e(int i2) {
        int i3 = this.f13148c;
        int min = Math.min(i2, 8 - this.f13149d);
        int i4 = i3 + 1;
        int i5 = ((this.f13146a[i3] & 255) >> this.f13149d) & (255 >> (8 - min));
        while (min < i2) {
            i5 |= (this.f13146a[i4] & 255) << min;
            min += 8;
            i4++;
        }
        int i6 = i5 & (-1 >>> (32 - i2));
        h(i2);
        return i6;
    }

    public void f() {
        this.f13148c = 0;
        this.f13149d = 0;
    }

    public void g(int i2) {
        int i3 = i2 / 8;
        this.f13148c = i3;
        this.f13149d = i2 - (i3 * 8);
        a();
    }

    public void h(int i2) {
        int i3 = i2 / 8;
        int i4 = this.f13148c + i3;
        this.f13148c = i4;
        int i5 = this.f13149d + (i2 - (i3 * 8));
        this.f13149d = i5;
        if (i5 > 7) {
            this.f13148c = i4 + 1;
            this.f13149d = i5 - 8;
        }
        a();
    }
}
