package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ListIterator;

public class PdfLister {

    /* renamed from: a  reason: collision with root package name */
    PrintStream f26249a;

    public PdfLister(PrintStream printStream) {
        this.f26249a = printStream;
    }

    public void a(PdfObject pdfObject) {
        PrintStream printStream;
        String str;
        int W = pdfObject.W();
        if (W == 3) {
            printStream = this.f26249a;
            str = "(" + pdfObject.toString() + ")";
        } else if (W == 5) {
            b((PdfArray) pdfObject);
            return;
        } else if (W != 6) {
            printStream = this.f26249a;
            str = pdfObject.toString();
        } else {
            c((PdfDictionary) pdfObject);
            return;
        }
        printStream.println(str);
    }

    public void b(PdfArray pdfArray) {
        this.f26249a.println('[');
        ListIterator<PdfObject> listIterator = pdfArray.listIterator();
        while (listIterator.hasNext()) {
            a(listIterator.next());
        }
        this.f26249a.println(']');
    }

    public void c(PdfDictionary pdfDictionary) {
        this.f26249a.println("<<");
        for (PdfName next : pdfDictionary.G0()) {
            PdfObject d0 = pdfDictionary.d0(next);
            this.f26249a.print(next.toString());
            this.f26249a.print(' ');
            a(d0);
        }
        this.f26249a.println(">>");
    }

    public void d(PdfImportedPage pdfImportedPage) {
        int b4 = pdfImportedPage.b4();
        PdfReaderInstance c4 = pdfImportedPage.c4();
        PdfDictionary h0 = c4.d().h0(b4);
        c(h0);
        PdfObject t0 = PdfReader.t0(h0.d0(PdfName.N5));
        if (t0 != null) {
            int i2 = t0.X;
            if (i2 == 5) {
                ListIterator<PdfObject> listIterator = ((PdfArray) t0).listIterator();
                while (listIterator.hasNext()) {
                    e((PRStream) PdfReader.t0(listIterator.next()), c4);
                    this.f26249a.println("-----------");
                }
            } else if (i2 == 7) {
                e((PRStream) t0, c4);
            }
        }
    }

    public void e(PRStream pRStream, PdfReaderInstance pdfReaderInstance) {
        try {
            c(pRStream);
            this.f26249a.println("startstream");
            byte[] D0 = PdfReader.D0(pRStream);
            int length = D0.length - 1;
            for (int i2 = 0; i2 < length; i2++) {
                if (D0[i2] == 13 && D0[i2 + 1] != 10) {
                    D0[i2] = 10;
                }
            }
            this.f26249a.println(new String(D0));
            this.f26249a.println("endstream");
        } catch (IOException e2) {
            System.err.println("I/O exception: " + e2);
        }
    }
}
