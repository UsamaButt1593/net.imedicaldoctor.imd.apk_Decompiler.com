package com.itextpdf.text.pdf.qrcode;

import java.util.ArrayList;

public final class ReedSolomonEncoder {

    /* renamed from: a  reason: collision with root package name */
    private final GF256 f27235a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<GF256Poly> f27236b;

    public ReedSolomonEncoder(GF256 gf256) {
        if (GF256.f27194e.equals(gf256)) {
            this.f27235a = gf256;
            ArrayList<GF256Poly> arrayList = new ArrayList<>();
            this.f27236b = arrayList;
            arrayList.add(new GF256Poly(gf256, new int[]{1}));
            return;
        }
        throw new IllegalArgumentException("Only QR Code is supported at this time");
    }

    private GF256Poly a(int i2) {
        if (i2 >= this.f27236b.size()) {
            ArrayList<GF256Poly> arrayList = this.f27236b;
            GF256Poly gF256Poly = arrayList.get(arrayList.size() - 1);
            for (int size = this.f27236b.size(); size <= i2; size++) {
                GF256 gf256 = this.f27235a;
                gF256Poly = gF256Poly.i(new GF256Poly(gf256, new int[]{1, gf256.c(size - 1)}));
                this.f27236b.add(gF256Poly);
            }
        }
        return this.f27236b.get(i2);
    }

    public void b(int[] iArr, int i2) {
        if (i2 != 0) {
            int length = iArr.length - i2;
            if (length > 0) {
                GF256Poly a2 = a(i2);
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                int[] e2 = new GF256Poly(this.f27235a, iArr2).j(i2, 1).b(a2)[1].e();
                int length2 = i2 - e2.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    iArr[length + i3] = 0;
                }
                System.arraycopy(e2, 0, iArr, length + length2, e2.length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }
}
