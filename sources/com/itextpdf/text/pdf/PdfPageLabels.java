package com.itextpdf.text.pdf;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.factories.RomanAlphabetFactory;
import com.itextpdf.text.factories.RomanNumberFactory;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class PdfPageLabels {

    /* renamed from: b  reason: collision with root package name */
    public static final int f26262b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final int f26263c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f26264d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f26265e = 3;

    /* renamed from: f  reason: collision with root package name */
    public static final int f26266f = 4;

    /* renamed from: g  reason: collision with root package name */
    public static final int f26267g = 5;

    /* renamed from: h  reason: collision with root package name */
    static PdfName[] f26268h = {PdfName.f6, PdfName.Dd, new PdfName("r"), PdfName.k3, new PdfName("a")};

    /* renamed from: a  reason: collision with root package name */
    private HashMap<Integer, PdfDictionary> f26269a = new HashMap<>();

    public static class PdfPageLabelFormat {

        /* renamed from: a  reason: collision with root package name */
        public int f26270a;

        /* renamed from: b  reason: collision with root package name */
        public int f26271b;

        /* renamed from: c  reason: collision with root package name */
        public String f26272c;

        /* renamed from: d  reason: collision with root package name */
        public int f26273d;

        public PdfPageLabelFormat(int i2, int i3, String str, int i4) {
            this.f26270a = i2;
            this.f26271b = i3;
            this.f26272c = str;
            this.f26273d = i4;
        }

        public String toString() {
            return String.format("Physical page %s: style: %s; prefix '%s'; logical page: %s", new Object[]{Integer.valueOf(this.f26270a), Integer.valueOf(this.f26271b), this.f26272c, Integer.valueOf(this.f26273d)});
        }
    }

    public PdfPageLabels() {
        c(1, 0, (String) null, 1);
    }

    public static PdfPageLabelFormat[] g(PdfReader pdfReader) {
        int i2;
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.w0(pdfReader.F().d0(PdfName.wc));
        if (pdfDictionary == null) {
            return null;
        }
        HashMap<Integer, PdfObject> b2 = PdfNumberTree.b(pdfDictionary);
        Integer[] numArr = (Integer[]) b2.keySet().toArray(new Integer[b2.size()]);
        Arrays.sort(numArr);
        PdfPageLabelFormat[] pdfPageLabelFormatArr = new PdfPageLabelFormat[b2.size()];
        for (int i3 = 0; i3 < numArr.length; i3++) {
            Integer num = numArr[i3];
            PdfDictionary pdfDictionary2 = (PdfDictionary) PdfReader.w0(b2.get(num));
            PdfName pdfName = PdfName.f6if;
            int e0 = pdfDictionary2.a0(pdfName) ? ((PdfNumber) pdfDictionary2.d0(pdfName)).e0() : 1;
            PdfName pdfName2 = PdfName.tc;
            String m0 = pdfDictionary2.a0(pdfName2) ? ((PdfString) pdfDictionary2.d0(pdfName2)).m0() : "";
            PdfName pdfName3 = PdfName.Ce;
            if (pdfDictionary2.a0(pdfName3)) {
                char charAt = ((PdfName) pdfDictionary2.d0(pdfName3)).toString().charAt(1);
                i2 = charAt != 'A' ? charAt != 'R' ? charAt != 'a' ? charAt != 'r' ? 0 : 2 : 4 : 1 : 3;
            } else {
                i2 = 5;
            }
            pdfPageLabelFormatArr[i3] = new PdfPageLabelFormat(num.intValue() + 1, i2, m0, e0);
        }
        return pdfPageLabelFormatArr;
    }

    public static String[] h(PdfReader pdfReader) {
        int i2;
        int c0 = pdfReader.c0();
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.w0(pdfReader.F().d0(PdfName.wc));
        if (pdfDictionary == null) {
            return null;
        }
        String[] strArr = new String[c0];
        HashMap<Integer, PdfObject> b2 = PdfNumberTree.b(pdfDictionary);
        char c2 = ASCIIPropertyListParser.t;
        String str = "";
        int i3 = 1;
        for (int i4 = 0; i4 < c0; i4++) {
            Integer valueOf = Integer.valueOf(i4);
            if (b2.containsKey(valueOf)) {
                PdfDictionary pdfDictionary2 = (PdfDictionary) PdfReader.w0(b2.get(valueOf));
                PdfName pdfName = PdfName.f6if;
                i2 = pdfDictionary2.a0(pdfName) ? ((PdfNumber) pdfDictionary2.d0(pdfName)).e0() : 1;
                PdfName pdfName2 = PdfName.tc;
                str = pdfDictionary2.a0(pdfName2) ? ((PdfString) pdfDictionary2.d0(pdfName2)).m0() : "";
                PdfName pdfName3 = PdfName.Ce;
                c2 = pdfDictionary2.a0(pdfName3) ? ((PdfName) pdfDictionary2.d0(pdfName3)).toString().charAt(1) : Barcode128.H;
            }
            if (c2 == 'A') {
                strArr[i4] = str + RomanAlphabetFactory.d(i2);
            } else if (c2 == 'R') {
                strArr[i4] = str + RomanNumberFactory.d(i2);
            } else if (c2 == 'a') {
                strArr[i4] = str + RomanAlphabetFactory.a(i2);
            } else if (c2 == 'e') {
                strArr[i4] = str;
            } else if (c2 != 'r') {
                strArr[i4] = str + i2;
            } else {
                strArr[i4] = str + RomanNumberFactory.a(i2);
            }
            i3 = i2 + 1;
        }
        return strArr;
    }

    public void a(int i2, int i3) {
        c(i2, i3, (String) null, 1);
    }

    public void b(int i2, int i3, String str) {
        c(i2, i3, str, 1);
    }

    public void c(int i2, int i3, String str, int i4) {
        if (i2 < 1 || i4 < 1) {
            throw new IllegalArgumentException(MessageLocalization.b("in.a.page.label.the.page.numbers.must.be.greater.or.equal.to.1", new Object[0]));
        }
        PdfDictionary pdfDictionary = new PdfDictionary();
        if (i3 >= 0 && i3 < f26268h.length) {
            pdfDictionary.V0(PdfName.Ce, f26268h[i3]);
        }
        if (str != null) {
            pdfDictionary.V0(PdfName.tc, new PdfString(str, PdfObject.h3));
        }
        if (i4 != 1) {
            pdfDictionary.V0(PdfName.f6if, new PdfNumber(i4));
        }
        this.f26269a.put(Integer.valueOf(i2 - 1), pdfDictionary);
    }

    public void d(int i2, int i3, String str, int i4, boolean z) {
        if (i2 < 1 || i4 < 1) {
            throw new IllegalArgumentException(MessageLocalization.b("in.a.page.label.the.page.numbers.must.be.greater.or.equal.to.1", new Object[0]));
        }
        PdfDictionary pdfDictionary = new PdfDictionary();
        if (i3 >= 0 && i3 < f26268h.length) {
            pdfDictionary.V0(PdfName.Ce, f26268h[i3]);
        }
        if (str != null) {
            pdfDictionary.V0(PdfName.tc, new PdfString(str, PdfObject.h3));
        }
        if (i4 != 1 || z) {
            pdfDictionary.V0(PdfName.f6if, new PdfNumber(i4));
        }
        this.f26269a.put(Integer.valueOf(i2 - 1), pdfDictionary);
    }

    public void e(PdfPageLabelFormat pdfPageLabelFormat) {
        c(pdfPageLabelFormat.f26270a, pdfPageLabelFormat.f26271b, pdfPageLabelFormat.f26272c, pdfPageLabelFormat.f26273d);
    }

    public PdfDictionary f(PdfWriter pdfWriter) {
        try {
            return PdfNumberTree.c(this.f26269a, pdfWriter);
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public void i(int i2) {
        if (i2 > 1) {
            this.f26269a.remove(Integer.valueOf(i2 - 1));
        }
    }
}
