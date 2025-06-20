package com.itextpdf.text.pdf;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class PdfNumberTree {

    /* renamed from: a  reason: collision with root package name */
    private static final int f26253a = 64;

    private static void a(PdfDictionary pdfDictionary, HashMap<Integer, PdfObject> hashMap) {
        PdfArray pdfArray = (PdfArray) PdfReader.w0(pdfDictionary.d0(PdfName.Kb));
        int i2 = 0;
        if (pdfArray != null) {
            while (i2 < pdfArray.size()) {
                hashMap.put(Integer.valueOf(((PdfNumber) PdfReader.w0(pdfArray.T0(i2))).e0()), pdfArray.T0(i2 + 1));
                i2 += 2;
            }
            return;
        }
        PdfArray pdfArray2 = (PdfArray) PdfReader.w0(pdfDictionary.d0(PdfName.ia));
        if (pdfArray2 != null) {
            while (i2 < pdfArray2.size()) {
                a((PdfDictionary) PdfReader.w0(pdfArray2.T0(i2)), hashMap);
                i2++;
            }
        }
    }

    public static HashMap<Integer, PdfObject> b(PdfDictionary pdfDictionary) {
        HashMap<Integer, PdfObject> hashMap = new HashMap<>();
        if (pdfDictionary != null) {
            a(pdfDictionary, hashMap);
        }
        return hashMap;
    }

    public static <O extends PdfObject> PdfDictionary c(HashMap<Integer, O> hashMap, PdfWriter pdfWriter) throws IOException {
        HashMap<Integer, O> hashMap2 = hashMap;
        PdfWriter pdfWriter2 = pdfWriter;
        if (hashMap.isEmpty()) {
            return null;
        }
        Integer[] numArr = (Integer[]) hashMap.keySet().toArray(new Integer[hashMap.size()]);
        Arrays.sort(numArr);
        if (numArr.length <= 64) {
            PdfDictionary pdfDictionary = new PdfDictionary();
            PdfArray pdfArray = new PdfArray();
            for (int i2 = 0; i2 < numArr.length; i2++) {
                pdfArray.a0(new PdfNumber(numArr[i2].intValue()));
                pdfArray.a0((PdfObject) hashMap2.get(numArr[i2]));
            }
            pdfDictionary.V0(PdfName.Kb, pdfArray);
            return pdfDictionary;
        }
        int length = (numArr.length + 63) / 64;
        PdfIndirectReference[] pdfIndirectReferenceArr = new PdfIndirectReference[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 * 64;
            int min = Math.min(i4 + 64, numArr.length);
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            PdfArray pdfArray2 = new PdfArray();
            pdfArray2.a0(new PdfNumber(numArr[i4].intValue()));
            pdfArray2.a0(new PdfNumber(numArr[min - 1].intValue()));
            pdfDictionary2.V0(PdfName.ya, pdfArray2);
            PdfArray pdfArray3 = new PdfArray();
            while (i4 < min) {
                pdfArray3.a0(new PdfNumber(numArr[i4].intValue()));
                pdfArray3.a0((PdfObject) hashMap2.get(numArr[i4]));
                i4++;
            }
            pdfDictionary2.V0(PdfName.Kb, pdfArray3);
            pdfIndirectReferenceArr[i3] = pdfWriter2.v0(pdfDictionary2).a();
        }
        int i5 = 64;
        while (length > 64) {
            i5 *= 64;
            int length2 = ((numArr.length + i5) - 1) / i5;
            int i6 = 0;
            while (i6 < length2) {
                int i7 = i6 * 64;
                int min2 = Math.min(i7 + 64, length);
                PdfDictionary pdfDictionary3 = new PdfDictionary();
                PdfArray pdfArray4 = new PdfArray();
                pdfArray4.a0(new PdfNumber(numArr[i6 * i5].intValue()));
                int i8 = i6 + 1;
                pdfArray4.a0(new PdfNumber(numArr[Math.min(i8 * i5, numArr.length) - 1].intValue()));
                pdfDictionary3.V0(PdfName.ya, pdfArray4);
                PdfArray pdfArray5 = new PdfArray();
                while (i7 < min2) {
                    pdfArray5.a0(pdfIndirectReferenceArr[i7]);
                    i7++;
                }
                pdfDictionary3.V0(PdfName.ia, pdfArray5);
                pdfIndirectReferenceArr[i6] = pdfWriter2.v0(pdfDictionary3).a();
                i6 = i8;
            }
            length = length2;
        }
        PdfArray pdfArray6 = new PdfArray();
        for (int i9 = 0; i9 < length; i9++) {
            pdfArray6.a0(pdfIndirectReferenceArr[i9]);
        }
        PdfDictionary pdfDictionary4 = new PdfDictionary();
        pdfDictionary4.V0(PdfName.ia, pdfArray6);
        return pdfDictionary4;
    }
}
