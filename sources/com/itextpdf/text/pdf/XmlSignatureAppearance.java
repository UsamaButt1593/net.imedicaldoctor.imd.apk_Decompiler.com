package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.security.XmlLocator;
import com.itextpdf.text.pdf.security.XpathConstructor;
import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Calendar;

public class XmlSignatureAppearance {

    /* renamed from: a  reason: collision with root package name */
    private PdfStamperImp f26514a;

    /* renamed from: b  reason: collision with root package name */
    private PdfStamper f26515b;

    /* renamed from: c  reason: collision with root package name */
    private Certificate f26516c;

    /* renamed from: d  reason: collision with root package name */
    private XmlLocator f26517d;

    /* renamed from: e  reason: collision with root package name */
    private XpathConstructor f26518e;

    /* renamed from: f  reason: collision with root package name */
    private Calendar f26519f;

    /* renamed from: g  reason: collision with root package name */
    private String f26520g;

    /* renamed from: h  reason: collision with root package name */
    private String f26521h = "text/xml";

    XmlSignatureAppearance(PdfStamperImp pdfStamperImp) {
        this.f26514a = pdfStamperImp;
    }

    public void a() throws IOException, DocumentException {
        this.f26514a.b3(this.f26515b.w());
    }

    public Certificate b() {
        return this.f26516c;
    }

    public String c() {
        return this.f26520g;
    }

    public String d() {
        return this.f26521h;
    }

    public Calendar e() {
        if (this.f26519f == null) {
            this.f26519f = Calendar.getInstance();
        }
        return this.f26519f;
    }

    public PdfStamper f() {
        return this.f26515b;
    }

    public PdfStamperImp g() {
        return this.f26514a;
    }

    public XmlLocator h() {
        return this.f26517d;
    }

    public XpathConstructor i() {
        return this.f26518e;
    }

    public void j(Certificate certificate) {
        this.f26516c = certificate;
    }

    public void k(String str) {
        this.f26520g = str;
    }

    public void l(String str) {
        this.f26521h = str;
    }

    public void m(Calendar calendar) {
        this.f26519f = calendar;
    }

    public void n(PdfStamper pdfStamper) {
        this.f26515b = pdfStamper;
    }

    public void o(XmlLocator xmlLocator) {
        this.f26517d = xmlLocator;
    }

    public void p(XpathConstructor xpathConstructor) {
        this.f26518e = xpathConstructor;
    }
}
