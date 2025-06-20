package com.itextpdf.text.pdf;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class PdfNameTree {

    /* renamed from: a  reason: collision with root package name */
    private static final int f26252a = 64;

    private static PdfString a(PdfDictionary pdfDictionary, HashMap<String, PdfObject> hashMap, PdfString pdfString) {
        PdfString pdfString2;
        PdfArray pdfArray = (PdfArray) PdfReader.w0(pdfDictionary.d0(PdfName.sb));
        int i2 = 0;
        if (pdfArray != null) {
            while (i2 < pdfArray.size()) {
                if (pdfString == null) {
                    PdfString pdfString3 = (PdfString) PdfReader.w0(pdfArray.T0(i2));
                    i2++;
                    pdfString2 = pdfString;
                    pdfString = pdfString3;
                } else {
                    pdfString2 = null;
                }
                if (i2 >= pdfArray.size()) {
                    return pdfString;
                }
                hashMap.put(PdfEncodings.d(pdfString.k(), (String) null), pdfArray.T0(i2));
                i2++;
                pdfString = pdfString2;
            }
        } else {
            PdfArray pdfArray2 = (PdfArray) PdfReader.w0(pdfDictionary.d0(PdfName.ia));
            if (pdfArray2 != null) {
                while (i2 < pdfArray2.size()) {
                    pdfString = a((PdfDictionary) PdfReader.w0(pdfArray2.T0(i2)), hashMap, pdfString);
                    i2++;
                }
            }
        }
        return null;
    }

    public static HashMap<String, PdfObject> b(PdfDictionary pdfDictionary) {
        HashMap<String, PdfObject> hashMap = new HashMap<>();
        if (pdfDictionary != null) {
            a(pdfDictionary, hashMap, (PdfString) null);
        }
        return hashMap;
    }

    public static PdfDictionary c(HashMap<String, ? extends PdfObject> hashMap, PdfWriter pdfWriter) throws IOException {
        HashMap<String, ? extends PdfObject> hashMap2 = hashMap;
        PdfWriter pdfWriter2 = pdfWriter;
        if (hashMap.isEmpty()) {
            return null;
        }
        String[] strArr = (String[]) hashMap.keySet().toArray(new String[hashMap.size()]);
        Arrays.sort(strArr);
        int i2 = 64;
        if (strArr.length <= 64) {
            PdfDictionary pdfDictionary = new PdfDictionary();
            PdfArray pdfArray = new PdfArray();
            for (int i3 = 0; i3 < strArr.length; i3++) {
                pdfArray.a0(new PdfString(strArr[i3], (String) null));
                pdfArray.a0((PdfObject) hashMap2.get(strArr[i3]));
            }
            pdfDictionary.V0(PdfName.sb, pdfArray);
            return pdfDictionary;
        }
        int length = (strArr.length + 63) / 64;
        PdfIndirectReference[] pdfIndirectReferenceArr = new PdfIndirectReference[length];
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i4 * 64;
            int min = Math.min(i5 + 64, strArr.length);
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            PdfArray pdfArray2 = new PdfArray();
            pdfArray2.a0(new PdfString(strArr[i5], (String) null));
            pdfArray2.a0(new PdfString(strArr[min - 1], (String) null));
            pdfDictionary2.V0(PdfName.ya, pdfArray2);
            PdfArray pdfArray3 = new PdfArray();
            while (i5 < min) {
                pdfArray3.a0(new PdfString(strArr[i5], (String) null));
                pdfArray3.a0((PdfObject) hashMap2.get(strArr[i5]));
                i5++;
            }
            pdfDictionary2.V0(PdfName.sb, pdfArray3);
            pdfIndirectReferenceArr[i4] = pdfWriter2.v0(pdfDictionary2).a();
        }
        int i6 = 64;
        while (length > i2) {
            i6 *= 64;
            int length2 = ((strArr.length + i6) - 1) / i6;
            int i7 = 0;
            while (i7 < length2) {
                int i8 = i7 * 64;
                int min2 = Math.min(i8 + 64, length);
                PdfDictionary pdfDictionary3 = new PdfDictionary();
                PdfArray pdfArray4 = new PdfArray();
                pdfArray4.a0(new PdfString(strArr[i7 * i6], (String) null));
                int i9 = i7 + 1;
                pdfArray4.a0(new PdfString(strArr[Math.min(i9 * i6, strArr.length) - 1], (String) null));
                pdfDictionary3.V0(PdfName.ya, pdfArray4);
                PdfArray pdfArray5 = new PdfArray();
                while (i8 < min2) {
                    pdfArray5.a0(pdfIndirectReferenceArr[i8]);
                    i8++;
                }
                pdfDictionary3.V0(PdfName.ia, pdfArray5);
                pdfIndirectReferenceArr[i7] = pdfWriter2.v0(pdfDictionary3).a();
                i7 = i9;
                i2 = 64;
            }
            length = length2;
        }
        PdfArray pdfArray6 = new PdfArray();
        for (int i10 = 0; i10 < length; i10++) {
            pdfArray6.a0(pdfIndirectReferenceArr[i10]);
        }
        PdfDictionary pdfDictionary4 = new PdfDictionary();
        pdfDictionary4.V0(PdfName.ia, pdfArray6);
        return pdfDictionary4;
    }
}
