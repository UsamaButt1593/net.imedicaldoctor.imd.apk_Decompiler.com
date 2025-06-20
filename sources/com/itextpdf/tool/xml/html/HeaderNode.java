package com.itextpdf.tool.xml.html;

import com.itextpdf.text.pdf.PdfOutline;

public class HeaderNode {

    /* renamed from: a  reason: collision with root package name */
    private int f27627a;

    /* renamed from: b  reason: collision with root package name */
    private PdfOutline f27628b;

    /* renamed from: c  reason: collision with root package name */
    private HeaderNode f27629c;

    public HeaderNode(int i2, PdfOutline pdfOutline, HeaderNode headerNode) {
        this.f27627a = i2;
        this.f27628b = pdfOutline;
        this.f27629c = headerNode;
    }

    public int a() {
        return this.f27627a;
    }

    public PdfOutline b() {
        return this.f27628b;
    }

    public HeaderNode c() {
        return this.f27629c;
    }
}
