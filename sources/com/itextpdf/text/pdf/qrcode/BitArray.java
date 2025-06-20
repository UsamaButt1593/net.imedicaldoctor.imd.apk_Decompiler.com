package com.itextpdf.text.pdf.qrcode;

import org.apache.commons.lang3.ClassUtils;

public final class BitArray {

    /* renamed from: a  reason: collision with root package name */
    public int[] f27157a;

    /* renamed from: b  reason: collision with root package name */
    public final int f27158b;

    public BitArray(int i2) {
        if (i2 >= 1) {
            this.f27158b = i2;
            this.f27157a = g(i2);
            return;
        }
        throw new IllegalArgumentException("size must be at least 1");
    }

    private static int[] g(int i2) {
        int i3 = i2 >> 5;
        if ((i2 & 31) != 0) {
            i3++;
        }
        return new int[i3];
    }

    public void a() {
        int length = this.f27157a.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f27157a[i2] = 0;
        }
    }

    public void b(int i2) {
        int[] iArr = this.f27157a;
        int i3 = i2 >> 5;
        iArr[i3] = (1 << (i2 & 31)) ^ iArr[i3];
    }

    public boolean c(int i2) {
        return ((1 << (i2 & 31)) & this.f27157a[i2 >> 5]) != 0;
    }

    public int[] d() {
        return this.f27157a;
    }

    public int e() {
        return this.f27158b;
    }

    public boolean f(int i2, int i3, boolean z) {
        int i4;
        if (i3 < i2) {
            throw new IllegalArgumentException();
        } else if (i3 == i2) {
            return true;
        } else {
            int i5 = i3 - 1;
            int i6 = i2 >> 5;
            int i7 = i5 >> 5;
            int i8 = i6;
            while (i8 <= i7) {
                int i9 = i8 > i6 ? 0 : i2 & 31;
                int i10 = i8 < i7 ? 31 : i5 & 31;
                if (i9 == 0 && i10 == 31) {
                    i4 = -1;
                } else {
                    i4 = 0;
                    while (i9 <= i10) {
                        i4 |= 1 << i9;
                        i9++;
                    }
                }
                int i11 = this.f27157a[i8] & i4;
                if (!z) {
                    i4 = 0;
                }
                if (i11 != i4) {
                    return false;
                }
                i8++;
            }
            return true;
        }
    }

    public void h() {
        int[] iArr = new int[this.f27157a.length];
        int i2 = this.f27158b;
        for (int i3 = 0; i3 < i2; i3++) {
            if (c((i2 - i3) - 1)) {
                int i4 = i3 >> 5;
                iArr[i4] = (1 << (i3 & 31)) | iArr[i4];
            }
        }
        this.f27157a = iArr;
    }

    public void i(int i2) {
        int[] iArr = this.f27157a;
        int i3 = i2 >> 5;
        iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
    }

    public void j(int i2, int i3) {
        this.f27157a[i2 >> 5] = i3;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(this.f27158b);
        for (int i2 = 0; i2 < this.f27158b; i2++) {
            if ((i2 & 7) == 0) {
                stringBuffer.append(' ');
            }
            stringBuffer.append(c(i2) ? 'X' : ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        return stringBuffer.toString();
    }
}
