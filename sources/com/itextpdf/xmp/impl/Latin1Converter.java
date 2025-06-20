package com.itextpdf.xmp.impl;

import androidx.media3.extractor.ts.PsExtractor;
import java.io.UnsupportedEncodingException;

public class Latin1Converter {

    /* renamed from: a  reason: collision with root package name */
    private static final int f27746a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static final int f27747b = 11;

    private Latin1Converter() {
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) {
        if (!"UTF-8".equals(byteBuffer.i())) {
            return byteBuffer;
        }
        byte[] bArr = new byte[8];
        ByteBuffer byteBuffer2 = new ByteBuffer((byteBuffer.j() * 4) / 3);
        int i2 = 0;
        char c2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < byteBuffer.j()) {
            int f2 = byteBuffer.f(i2);
            if (c2 == 11) {
                if (i3 <= 0 || (f2 & PsExtractor.x) != 128) {
                    byteBuffer2.c(b(bArr[0]));
                    i2 -= i4;
                } else {
                    int i5 = i4 + 1;
                    bArr[i4] = (byte) f2;
                    i3--;
                    if (i3 == 0) {
                        byteBuffer2.d(bArr, 0, i5);
                    } else {
                        i4 = i5;
                    }
                }
                c2 = 0;
                i4 = 0;
            } else if (f2 < 127) {
                byteBuffer2.a((byte) f2);
            } else if (f2 >= 192) {
                int i6 = f2;
                i3 = -1;
                while (i3 < 8 && (i6 & 128) == 128) {
                    i3++;
                    i6 <<= 1;
                }
                bArr[i4] = (byte) f2;
                i4++;
                c2 = 11;
            } else {
                byteBuffer2.c(b((byte) f2));
            }
            i2++;
        }
        if (c2 == 11) {
            for (int i7 = 0; i7 < i4; i7++) {
                byteBuffer2.c(b(bArr[i7]));
            }
        }
        return byteBuffer2;
    }

    private static byte[] b(byte b2) {
        byte b3 = b2 & 255;
        if (b3 >= 128) {
            if (b3 == 129 || b3 == 141 || b3 == 143 || b3 == 144 || b3 == 157) {
                return new byte[]{32};
            }
            try {
                return new String(new byte[]{b2}, "cp1252").getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return new byte[]{b2};
    }
}
