package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.pdf.PRIndirectReference;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ListIterator;

public class ContentByteUtils {
    private ContentByteUtils() {
    }

    public static byte[] a(PdfReader pdfReader, int i2) throws IOException {
        PdfObject d0 = pdfReader.h0(i2).d0(PdfName.N5);
        return d0 == null ? new byte[0] : b(d0);
    }

    public static byte[] b(PdfObject pdfObject) throws IOException {
        int W = pdfObject.W();
        if (W == 5) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ListIterator<PdfObject> listIterator = ((PdfArray) pdfObject).listIterator();
            while (listIterator.hasNext()) {
                byteArrayOutputStream.write(b(listIterator.next()));
                byteArrayOutputStream.write(32);
            }
            return byteArrayOutputStream.toByteArray();
        } else if (W == 7) {
            return PdfReader.D0((PRStream) PdfReader.w0(pdfObject));
        } else {
            if (W == 10) {
                return b(PdfReader.w0((PRIndirectReference) pdfObject));
            }
            throw new IllegalStateException("Unable to handle Content of type " + pdfObject.getClass());
        }
    }
}
