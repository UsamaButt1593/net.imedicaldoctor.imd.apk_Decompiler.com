package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.interfaces.PdfEncryptionSettings;
import com.itextpdf.text.pdf.interfaces.PdfViewerPreferences;
import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.util.HashMap;
import java.util.List;

public class PdfCopyForms implements PdfViewerPreferences, PdfEncryptionSettings {
    private PdfCopyFormsImp s;

    public PdfCopyForms(OutputStream outputStream) throws DocumentException {
        this.s = new PdfCopyFormsImp(outputStream);
    }

    public void a(int i2) {
        this.s.a(i2);
    }

    public void b(PdfReader pdfReader) throws DocumentException, IOException {
        this.s.R2(pdfReader);
    }

    public void c(PdfReader pdfReader, String str) throws DocumentException, IOException {
        this.s.S2(pdfReader, SequenceList.a(str, pdfReader.c0()));
    }

    public void d(PdfReader pdfReader, List<Integer> list) throws DocumentException, IOException {
        this.s.S2(pdfReader, list);
    }

    public void e(String str) {
        this.s.g0(str, !PdfEncodings.e(str));
    }

    public void f() {
        this.s.close();
    }

    public void g(PdfReader pdfReader) throws DocumentException {
        this.s.m3(pdfReader);
    }

    public PdfWriter h() {
        return this.s;
    }

    public boolean i() {
        return this.s.R1();
    }

    public void j() {
        this.s.i3();
    }

    public void k(boolean z, String str, String str2, int i2) throws DocumentException {
        l(DocWriter.E(str), DocWriter.E(str2), i2, z);
    }

    public void l(byte[] bArr, byte[] bArr2, int i2, boolean z) throws DocumentException {
        this.s.r(bArr, bArr2, i2, z ? 1 : 0);
    }

    public void m(Certificate[] certificateArr, int[] iArr, int i2) throws DocumentException {
        this.s.m(certificateArr, iArr, i2);
    }

    public void n() throws DocumentException {
        this.s.p2();
    }

    public void o(List<HashMap<String, Object>> list) {
        this.s.u2(list);
    }

    public void r(byte[] bArr, byte[] bArr2, int i2, int i3) throws DocumentException {
        this.s.r(bArr, bArr2, i2, i3);
    }

    public void v(PdfName pdfName, PdfObject pdfObject) {
        this.s.v(pdfName, pdfObject);
    }
}
