package com.itextpdf.text.pdf.fonts.cmaps;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;
import java.util.ArrayList;

public class CMapByteCid extends AbstractCMap {

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<char[]> f26803e;

    public CMapByteCid() {
        ArrayList<char[]> arrayList = new ArrayList<>();
        this.f26803e = arrayList;
        arrayList.add(new char[256]);
    }

    private void q(byte[] bArr, char c2) {
        int length = bArr.length - 1;
        int i2 = 0;
        char c3 = 0;
        while (i2 < length) {
            char[] cArr = this.f26803e.get(c3);
            byte b2 = bArr[i2] & 255;
            char c4 = cArr[b2];
            if (c4 == 0 || (c4 & 32768) != 0) {
                if (c4 == 0) {
                    this.f26803e.add(new char[256]);
                    c4 = (char) ((this.f26803e.size() - 1) | 32768);
                    cArr[b2] = c4;
                }
                c3 = c4 & BaseFont.r4;
                i2++;
            } else {
                throw new RuntimeException(MessageLocalization.b("inconsistent.mapping", new Object[0]));
            }
        }
        char[] cArr2 = this.f26803e.get(c3);
        byte b3 = bArr[length] & 255;
        if ((cArr2[b3] & 32768) == 0) {
            cArr2[b3] = c2;
            return;
        }
        throw new RuntimeException(MessageLocalization.b("inconsistent.mapping", new Object[0]));
    }

    /* access modifiers changed from: package-private */
    public void a(PdfString pdfString, PdfObject pdfObject) {
        if (pdfObject instanceof PdfNumber) {
            q(AbstractCMap.d(pdfString), (char) ((PdfNumber) pdfObject).e0());
        }
    }

    public String o(CMapSequence cMapSequence) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int p = p(cMapSequence);
            if (p < 0) {
                return sb.toString();
            }
            sb.append((char) p);
        }
    }

    public int p(CMapSequence cMapSequence) {
        int i2 = cMapSequence.f26820b + cMapSequence.f26821c;
        char c2 = 0;
        while (true) {
            int i3 = cMapSequence.f26820b;
            if (i3 >= i2) {
                return -1;
            }
            byte[] bArr = cMapSequence.f26819a;
            cMapSequence.f26820b = i3 + 1;
            cMapSequence.f26821c--;
            char c3 = this.f26803e.get(c2)[bArr[i3] & 255];
            if ((32768 & c3) == 0) {
                return c3;
            }
            c2 = c3 & BaseFont.r4;
        }
    }
}
