package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import com.dd.plist.ASCIIPropertyListParser;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;

@ShowFirstParty
@KeepForSdk
public class Hex {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f20386a = {'0', '1', PdfWriter.p4, PdfWriter.q4, PdfWriter.r4, PdfWriter.s4, PdfWriter.t4, PdfWriter.u4, '8', '9', 'A', ASCIIPropertyListParser.u, 'C', ASCIIPropertyListParser.t, 'E', 'F'};

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f20387b = {'0', '1', PdfWriter.p4, PdfWriter.q4, PdfWriter.r4, PdfWriter.s4, PdfWriter.t4, PdfWriter.u4, '8', '9', 'a', 'b', Barcode128.F, Barcode128.G, Barcode128.H, Barcode128.I};

    @NonNull
    @KeepForSdk
    public static String a(@NonNull byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length + length)];
        int i2 = 0;
        for (byte b2 : bArr) {
            char[] cArr2 = f20387b;
            cArr[i2] = cArr2[(b2 & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b2 & 15];
            i2 += 2;
        }
        return new String(cArr);
    }

    @NonNull
    @KeepForSdk
    public static String b(@NonNull byte[] bArr) {
        return c(bArr, false);
    }

    @NonNull
    @KeepForSdk
    public static String c(@NonNull byte[] bArr, boolean z) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        int i2 = 0;
        while (i2 < length && (!z || i2 != length - 1 || (bArr[i2] & 255) != 0)) {
            char[] cArr = f20386a;
            sb.append(cArr[(bArr[i2] & 240) >>> 4]);
            sb.append(cArr[bArr[i2] & 15]);
            i2++;
        }
        return sb.toString();
    }

    @NonNull
    @KeepForSdk
    public static byte[] d(@NonNull String str) throws IllegalArgumentException {
        int length = str.length();
        if (length % 2 == 0) {
            byte[] bArr = new byte[(length / 2)];
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 2;
                bArr[i2 / 2] = (byte) Integer.parseInt(str.substring(i2, i3), 16);
                i2 = i3;
            }
            return bArr;
        }
        throw new IllegalArgumentException("Hex string has odd number of characters");
    }
}
