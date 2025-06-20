package com.itextpdf.text.pdf.security;

import com.itextpdf.text.ExceptionConverter;
import java.security.cert.CRL;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;

public class CrlClientOffline implements CrlClient {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<byte[]> f27268a;

    public CrlClientOffline(CRL crl) {
        ArrayList<byte[]> arrayList = new ArrayList<>();
        this.f27268a = arrayList;
        try {
            arrayList.add(((X509CRL) crl).getEncoded());
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public Collection<byte[]> a(X509Certificate x509Certificate, String str) {
        return this.f27268a;
    }

    public CrlClientOffline(byte[] bArr) {
        ArrayList<byte[]> arrayList = new ArrayList<>();
        this.f27268a = arrayList;
        arrayList.add(bArr);
    }
}
