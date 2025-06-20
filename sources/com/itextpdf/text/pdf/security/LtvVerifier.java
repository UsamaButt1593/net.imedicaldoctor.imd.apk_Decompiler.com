package com.itextpdf.text.pdf.security;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.security.LtvVerification;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.spongycastle.cert.ocsp.BasicOCSPResp;
import org.spongycastle.cert.ocsp.OCSPException;
import org.spongycastle.cert.ocsp.OCSPResp;

public class LtvVerifier extends RootStoreVerifier {

    /* renamed from: n  reason: collision with root package name */
    protected static final Logger f27291n = LoggerFactory.b(LtvVerifier.class);

    /* renamed from: e  reason: collision with root package name */
    protected LtvVerification.CertificateOption f27292e = LtvVerification.CertificateOption.SIGNING_CERTIFICATE;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f27293f = true;

    /* renamed from: g  reason: collision with root package name */
    protected PdfReader f27294g;

    /* renamed from: h  reason: collision with root package name */
    protected AcroFields f27295h;

    /* renamed from: i  reason: collision with root package name */
    protected Date f27296i;

    /* renamed from: j  reason: collision with root package name */
    protected String f27297j;

    /* renamed from: k  reason: collision with root package name */
    protected PdfPKCS7 f27298k;

    /* renamed from: l  reason: collision with root package name */
    protected boolean f27299l = true;

    /* renamed from: m  reason: collision with root package name */
    protected PdfDictionary f27300m;

    public LtvVerifier(PdfReader pdfReader) throws GeneralSecurityException {
        super((CertificateVerifier) null);
        this.f27294g = pdfReader;
        AcroFields C = pdfReader.C();
        this.f27295h = C;
        ArrayList<String> E = C.E();
        this.f27297j = E.get(E.size() - 1);
        this.f27296i = new Date();
        PdfPKCS7 d2 = d();
        this.f27298k = d2;
        f27291n.f(String.format("Checking %ssignature %s", new Object[]{d2.F() ? "document-level timestamp " : "", this.f27297j}));
    }

    public List<VerificationOK> b(X509Certificate x509Certificate, X509Certificate x509Certificate2, Date date) throws GeneralSecurityException, IOException {
        RootStoreVerifier rootStoreVerifier = new RootStoreVerifier(this.f27266a);
        rootStoreVerifier.c(this.f27327c);
        CRLVerifier cRLVerifier = new CRLVerifier(rootStoreVerifier, e());
        cRLVerifier.c(this.f27327c);
        boolean z = true;
        cRLVerifier.a(this.f27299l || this.f27267b);
        OCSPVerifier oCSPVerifier = new OCSPVerifier(cRLVerifier, f());
        oCSPVerifier.c(this.f27327c);
        if (!this.f27299l && !this.f27267b) {
            z = false;
        }
        oCSPVerifier.a(z);
        return oCSPVerifier.b(x509Certificate, x509Certificate2, date);
    }

    /* access modifiers changed from: protected */
    public PdfPKCS7 d() throws GeneralSecurityException {
        PdfPKCS7 o0 = this.f27295h.o0(this.f27297j);
        if (this.f27295h.l0(this.f27297j)) {
            Logger logger = f27291n;
            logger.f("The timestamp covers whole document.");
            if (o0.N()) {
                logger.f("The signed document has not been modified.");
                return o0;
            }
            throw new VerificationException((Certificate) null, "The document was altered after the final signature was applied.");
        }
        throw new VerificationException((Certificate) null, "Signature doesn't cover whole document.");
    }

    public List<X509CRL> e() throws GeneralSecurityException, IOException {
        PdfArray e0;
        ArrayList arrayList = new ArrayList();
        PdfDictionary pdfDictionary = this.f27300m;
        if (pdfDictionary == null || (e0 = pdfDictionary.e0(PdfName.Y5)) == null) {
            return arrayList;
        }
        CertificateFactory instance = CertificateFactory.getInstance("X.509");
        for (int i2 = 0; i2 < e0.size(); i2++) {
            arrayList.add((X509CRL) instance.generateCRL(new ByteArrayInputStream(PdfReader.D0((PRStream) e0.N0(i2)))));
        }
        return arrayList;
    }

    public List<BasicOCSPResp> f() throws IOException, GeneralSecurityException {
        PdfArray e0;
        ArrayList arrayList = new ArrayList();
        PdfDictionary pdfDictionary = this.f27300m;
        if (pdfDictionary == null || (e0 = pdfDictionary.e0(PdfName.Vb)) == null) {
            return arrayList;
        }
        for (int i2 = 0; i2 < e0.size(); i2++) {
            OCSPResp oCSPResp = new OCSPResp(PdfReader.D0((PRStream) e0.N0(i2)));
            if (oCSPResp.getStatus() == 0) {
                try {
                    arrayList.add((BasicOCSPResp) oCSPResp.getResponseObject());
                } catch (OCSPException e2) {
                    throw new GeneralSecurityException(e2);
                }
            }
        }
        return arrayList;
    }

    public void g(LtvVerification.CertificateOption certificateOption) {
        this.f27292e = certificateOption;
    }

    public void h(CertificateVerifier certificateVerifier) {
        this.f27266a = certificateVerifier;
    }

    public void i(boolean z) {
        this.f27293f = z;
    }

    public void j() throws IOException, GeneralSecurityException {
        Logger logger = f27291n;
        logger.f("Switching to previous revision.");
        this.f27299l = false;
        this.f27300m = this.f27294g.F().j0(PdfName.V6);
        Calendar z = this.f27298k.z();
        if (z == null) {
            z = this.f27298k.v();
        }
        this.f27296i = z.getTime();
        ArrayList<String> E = this.f27295h.E();
        if (E.size() > 1) {
            this.f27297j = E.get(E.size() - 2);
            PdfReader pdfReader = new PdfReader(this.f27295h.h(this.f27297j));
            this.f27294g = pdfReader;
            AcroFields C = pdfReader.C();
            this.f27295h = C;
            ArrayList<String> E2 = C.E();
            this.f27297j = E2.get(E2.size() - 1);
            PdfPKCS7 d2 = d();
            this.f27298k = d2;
            logger.f(String.format("Checking %ssignature %s", new Object[]{d2.F() ? "document-level timestamp " : "", this.f27297j}));
            return;
        }
        logger.f("No signatures in revision");
        this.f27298k = null;
    }

    public List<VerificationOK> k(List<VerificationOK> list) throws IOException, GeneralSecurityException {
        if (list == null) {
            list = new ArrayList<>();
        }
        while (this.f27298k != null) {
            list.addAll(m());
        }
        return list;
    }

    public void l(Certificate[] certificateArr) throws GeneralSecurityException {
        for (int i2 = 0; i2 < certificateArr.length; i2++) {
            certificateArr[i2].checkValidity(this.f27296i);
            if (i2 > 0) {
                certificateArr[i2 - 1].verify(certificateArr[i2].getPublicKey());
            }
        }
        Logger logger = f27291n;
        logger.f("All certificates are valid on " + this.f27296i.toString());
    }

    public List<VerificationOK> m() throws GeneralSecurityException, IOException {
        f27291n.f("Verifying signature.");
        ArrayList arrayList = new ArrayList();
        Certificate[] u = this.f27298k.u();
        l(u);
        int length = LtvVerification.CertificateOption.WHOLE_CHAIN.equals(this.f27292e) ? u.length : 1;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            X509Certificate x509Certificate = (X509Certificate) u[i2];
            X509Certificate x509Certificate2 = i3 < u.length ? (X509Certificate) u[i3] : null;
            f27291n.f(x509Certificate.getSubjectDN().getName());
            List<VerificationOK> b2 = b(x509Certificate, x509Certificate2, this.f27296i);
            if (b2.size() == 0) {
                try {
                    x509Certificate.verify(x509Certificate.getPublicKey());
                    if (this.f27299l && u.length > 1) {
                        b2.add(new VerificationOK(x509Certificate, getClass(), "Root certificate in final revision"));
                    }
                    if (b2.size() == 0) {
                        if (this.f27293f) {
                            throw new GeneralSecurityException();
                        }
                    }
                    if (u.length > 1) {
                        b2.add(new VerificationOK(x509Certificate, getClass(), "Root certificate passed without checking"));
                    }
                } catch (GeneralSecurityException unused) {
                    throw new VerificationException(x509Certificate, "Couldn't verify with CRL or OCSP or trusted anchor");
                }
            }
            arrayList.addAll(b2);
            i2 = i3;
        }
        j();
        return arrayList;
    }
}
