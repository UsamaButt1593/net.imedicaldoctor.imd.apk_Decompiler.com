package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.OutputStream;

class PdfCopyFormsImp extends PdfCopyFieldsImp {
    PdfCopyFormsImp(OutputStream outputStream) throws DocumentException {
        super(outputStream);
    }

    /* access modifiers changed from: package-private */
    public void g3() {
        for (int i2 = 0; i2 < this.Z5.size(); i2++) {
            h3(this.Z5.get(i2).t());
        }
    }

    public void m3(PdfReader pdfReader) throws DocumentException {
        if (pdfReader.R0()) {
            if (this.W5.containsKey(pdfReader)) {
                pdfReader = new PdfReader(pdfReader);
            } else if (!pdfReader.U0()) {
                pdfReader.n();
                pdfReader.H1(true);
            } else {
                throw new DocumentException(MessageLocalization.b("the.document.was.reused", new Object[0]));
            }
            pdfReader.K1();
            this.W5.put(pdfReader, new IntHashtable());
            this.Y5.put(pdfReader, new IntHashtable());
            this.Z5.add(pdfReader.C());
            l3(pdfReader);
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.b("pdfreader.not.opened.with.owner.password", new Object[0]));
    }
}
