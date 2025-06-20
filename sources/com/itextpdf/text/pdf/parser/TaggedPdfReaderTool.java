package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.xml.XMLUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class TaggedPdfReaderTool {

    /* renamed from: a  reason: collision with root package name */
    protected PdfReader f27050a;

    /* renamed from: b  reason: collision with root package name */
    protected PrintWriter f27051b;

    private static String c(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            boolean z = true;
            boolean z2 = charAt == ':' || (charAt >= 'A' && charAt <= 'Z') || charAt == '_' || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 192 && charAt <= 214) || ((charAt >= 216 && charAt <= 246) || ((charAt >= 248 && charAt <= 767) || ((charAt >= 880 && charAt <= 893) || ((charAt >= 895 && charAt <= 8191) || ((charAt >= 8204 && charAt <= 8205) || ((charAt >= 8304 && charAt <= 8591) || ((charAt >= 11264 && charAt <= 12271) || ((charAt >= 12289 && charAt <= 55295) || ((charAt >= 63744 && charAt <= 64975) || (charAt >= 65008 && charAt <= 65533))))))))))));
            if (!(charAt == '-' || charAt == '.' || ((charAt >= '0' && charAt <= '9') || charAt == 183 || ((charAt >= 768 && charAt <= 879) || ((charAt >= 8255 && charAt <= 8256) || z2))))) {
                z = false;
            }
            if (i2 == 0) {
                if (!z2) {
                    charAt = '_';
                }
            } else if (!z) {
                charAt = '-';
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public void a(PdfReader pdfReader, OutputStream outputStream) throws IOException {
        b(pdfReader, outputStream, "UTF-8");
    }

    public void b(PdfReader pdfReader, OutputStream outputStream, String str) throws IOException {
        this.f27050a = pdfReader;
        this.f27051b = new PrintWriter(new OutputStreamWriter(outputStream, str));
        PdfDictionary j0 = pdfReader.F().j0(PdfName.xf);
        if (j0 != null) {
            d(j0.B0(PdfName.ga));
            this.f27051b.flush();
            this.f27051b.close();
            return;
        }
        throw new IOException(MessageLocalization.b("no.structtreeroot.found", new Object[0]));
    }

    public void d(PdfObject pdfObject) throws IOException {
        if (pdfObject != null) {
            if (pdfObject instanceof PdfArray) {
                e((PdfArray) pdfObject);
            } else if (pdfObject instanceof PdfDictionary) {
                f((PdfDictionary) pdfObject);
            }
        }
    }

    public void e(PdfArray pdfArray) throws IOException {
        if (pdfArray != null) {
            for (int i2 = 0; i2 < pdfArray.size(); i2++) {
                d(pdfArray.Q0(i2));
            }
        }
    }

    public void f(PdfDictionary pdfDictionary) throws IOException {
        g(pdfDictionary, false);
    }

    public void g(PdfDictionary pdfDictionary, boolean z) throws IOException {
        PdfDictionary j0;
        if (pdfDictionary != null) {
            PdfName p0 = pdfDictionary.p0(PdfName.Ce);
            if (p0 != null) {
                String a0 = PdfName.a0(p0.toString());
                String c2 = c(a0);
                this.f27051b.print("<");
                this.f27051b.print(c2);
                if (z && (j0 = pdfDictionary.j0(PdfName.k3)) != null) {
                    for (PdfName next : j0.G0()) {
                        this.f27051b.print(' ');
                        PdfObject t0 = PdfReader.t0(j0.d0(next));
                        this.f27051b.print(i(next));
                        this.f27051b.print("=\"");
                        this.f27051b.print(t0.toString());
                        this.f27051b.print("\"");
                    }
                }
                this.f27051b.print(">");
                PdfObject d0 = pdfDictionary.d0(PdfName.J3);
                if (!(d0 == null || d0.toString() == null)) {
                    this.f27051b.print("<alt><![CDATA[");
                    this.f27051b.print(d0.toString().replaceAll("[\\000]*", ""));
                    this.f27051b.print("]]></alt>");
                }
                PdfDictionary j02 = pdfDictionary.j0(PdfName.Rc);
                if (j02 != null) {
                    h(a0, pdfDictionary.B0(PdfName.ga), j02);
                }
                d(pdfDictionary.B0(PdfName.ga));
                this.f27051b.print("</");
                this.f27051b.print(c2);
                this.f27051b.println(">");
                return;
            }
            d(pdfDictionary.B0(PdfName.ga));
        }
    }

    public void h(String str, PdfObject pdfObject, PdfDictionary pdfDictionary) throws IOException {
        if (pdfObject instanceof PdfNumber) {
            MarkedContentRenderFilter markedContentRenderFilter = new MarkedContentRenderFilter(((PdfNumber) pdfObject).e0());
            FilteredTextRenderListener filteredTextRenderListener = new FilteredTextRenderListener(new SimpleTextExtractionStrategy(), markedContentRenderFilter);
            new PdfContentStreamProcessor(filteredTextRenderListener).Q(PdfReader.g0(pdfDictionary), pdfDictionary.j0(PdfName.Wd));
            this.f27051b.print(XMLUtil.a(filteredTextRenderListener.g(), true));
        } else if (pdfObject instanceof PdfArray) {
            PdfArray pdfArray = (PdfArray) pdfObject;
            int size = pdfArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                h(str, pdfArray.T0(i2), pdfDictionary);
                if (i2 < size - 1) {
                    this.f27051b.println();
                }
            }
        } else if (pdfObject instanceof PdfDictionary) {
            PdfDictionary pdfDictionary2 = (PdfDictionary) pdfObject;
            h(str, pdfDictionary2.B0(PdfName.ab), pdfDictionary2.j0(PdfName.Rc));
        }
    }

    /* access modifiers changed from: protected */
    public String i(PdfName pdfName) {
        String replaceFirst = pdfName.toString().replaceFirst("/", "");
        return Character.toLowerCase(replaceFirst.charAt(0)) + replaceFirst.substring(1);
    }
}
