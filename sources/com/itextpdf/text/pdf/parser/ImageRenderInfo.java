package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfIndirectReference;
import com.itextpdf.text.pdf.PdfReader;
import java.io.IOException;

public class ImageRenderInfo {

    /* renamed from: a  reason: collision with root package name */
    private final GraphicsState f26941a;

    /* renamed from: b  reason: collision with root package name */
    private final PdfIndirectReference f26942b;

    /* renamed from: c  reason: collision with root package name */
    private final InlineImageInfo f26943c;

    /* renamed from: d  reason: collision with root package name */
    private final PdfDictionary f26944d;

    /* renamed from: e  reason: collision with root package name */
    private PdfImageObject f26945e = null;

    private ImageRenderInfo(GraphicsState graphicsState, PdfIndirectReference pdfIndirectReference, PdfDictionary pdfDictionary) {
        this.f26941a = graphicsState;
        this.f26942b = pdfIndirectReference;
        this.f26943c = null;
        this.f26944d = pdfDictionary;
    }

    protected static ImageRenderInfo a(GraphicsState graphicsState, InlineImageInfo inlineImageInfo, PdfDictionary pdfDictionary) {
        return new ImageRenderInfo(graphicsState, inlineImageInfo, pdfDictionary);
    }

    public static ImageRenderInfo b(GraphicsState graphicsState, PdfIndirectReference pdfIndirectReference, PdfDictionary pdfDictionary) {
        return new ImageRenderInfo(graphicsState, pdfIndirectReference, pdfDictionary);
    }

    private void i() throws IOException {
        PdfImageObject pdfImageObject;
        if (this.f26945e == null) {
            PdfIndirectReference pdfIndirectReference = this.f26942b;
            if (pdfIndirectReference != null) {
                pdfImageObject = new PdfImageObject((PRStream) PdfReader.t0(pdfIndirectReference), this.f26944d);
            } else {
                InlineImageInfo inlineImageInfo = this.f26943c;
                if (inlineImageInfo != null) {
                    pdfImageObject = new PdfImageObject(inlineImageInfo.a(), this.f26943c.b(), this.f26944d);
                } else {
                    return;
                }
            }
            this.f26945e = pdfImageObject;
        }
    }

    public float c() {
        return this.f26941a.f26927a.b();
    }

    public BaseColor d() {
        return this.f26941a.f26939m;
    }

    public PdfImageObject e() throws IOException {
        i();
        return this.f26945e;
    }

    public Matrix f() {
        return this.f26941a.f26927a;
    }

    public PdfIndirectReference g() {
        return this.f26942b;
    }

    public Vector h() {
        return new Vector(0.0f, 0.0f, 1.0f).a(this.f26941a.f26927a);
    }

    private ImageRenderInfo(GraphicsState graphicsState, InlineImageInfo inlineImageInfo, PdfDictionary pdfDictionary) {
        this.f26941a = graphicsState;
        this.f26942b = null;
        this.f26943c = inlineImageInfo;
        this.f26944d = pdfDictionary;
    }
}
