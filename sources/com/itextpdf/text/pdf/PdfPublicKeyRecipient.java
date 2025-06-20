package com.itextpdf.text.pdf;

import java.security.cert.Certificate;

public class PdfPublicKeyRecipient {

    /* renamed from: a  reason: collision with root package name */
    private Certificate f26279a;

    /* renamed from: b  reason: collision with root package name */
    private int f26280b;

    /* renamed from: c  reason: collision with root package name */
    protected byte[] f26281c = null;

    public PdfPublicKeyRecipient(Certificate certificate, int i2) {
        this.f26279a = certificate;
        this.f26280b = i2;
    }

    public Certificate a() {
        return this.f26279a;
    }

    /* access modifiers changed from: protected */
    public byte[] b() {
        return this.f26281c;
    }

    public int c() {
        return this.f26280b;
    }

    /* access modifiers changed from: protected */
    public void d(byte[] bArr) {
        this.f26281c = bArr;
    }
}
