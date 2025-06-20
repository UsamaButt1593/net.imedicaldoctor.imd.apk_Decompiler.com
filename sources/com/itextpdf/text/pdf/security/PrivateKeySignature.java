package com.itextpdf.text.pdf.security;

import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.Signature;

public class PrivateKeySignature implements ExternalSignature {

    /* renamed from: a  reason: collision with root package name */
    private PrivateKey f27321a;

    /* renamed from: b  reason: collision with root package name */
    private String f27322b;

    /* renamed from: c  reason: collision with root package name */
    private String f27323c;

    /* renamed from: d  reason: collision with root package name */
    private String f27324d;

    public PrivateKeySignature(PrivateKey privateKey, String str, String str2) {
        this.f27321a = privateKey;
        this.f27324d = str2;
        this.f27322b = DigestAlgorithms.d(DigestAlgorithms.c(str));
        String algorithm = privateKey.getAlgorithm();
        this.f27323c = algorithm;
        if (algorithm.startsWith("EC")) {
            this.f27323c = "ECDSA";
        }
    }

    public String a() {
        return this.f27323c;
    }

    public String b() {
        return this.f27322b;
    }

    public byte[] c(byte[] bArr) throws GeneralSecurityException {
        String str = this.f27322b + "with" + this.f27323c;
        String str2 = this.f27324d;
        Signature instance = str2 == null ? Signature.getInstance(str) : Signature.getInstance(str, str2);
        instance.initSign(this.f27321a);
        instance.update(bArr);
        return instance.sign();
    }
}
