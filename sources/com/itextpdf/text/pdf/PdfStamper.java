package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.collection.PdfCollection;
import com.itextpdf.text.pdf.interfaces.PdfEncryptionSettings;
import com.itextpdf.text.pdf.interfaces.PdfViewerPreferences;
import com.itextpdf.text.pdf.security.LtvVerification;
import com.itextpdf.text.xml.xmp.PdfSchema;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PdfStamper implements PdfViewerPreferences, PdfEncryptionSettings {
    private Map<String, String> X;
    protected XmlSignatureAppearance X2;
    protected boolean Y;
    private LtvVerification Y2;
    protected PdfSignatureAppearance Z;
    protected PdfStamperImp s;

    protected PdfStamper() {
    }

    public static PdfStamper k(PdfReader pdfReader, OutputStream outputStream, char c2) throws DocumentException, IOException {
        return n(pdfReader, outputStream, c2, (File) null, false);
    }

    public static PdfStamper l(PdfReader pdfReader, OutputStream outputStream, char c2, File file) throws DocumentException, IOException {
        return n(pdfReader, outputStream, c2, file, false);
    }

    public static PdfStamper n(PdfReader pdfReader, OutputStream outputStream, char c2, File file, boolean z) throws DocumentException, IOException {
        PdfStamper pdfStamper;
        if (file == null) {
            ByteBuffer byteBuffer = new ByteBuffer();
            pdfStamper = new PdfStamper(pdfReader, byteBuffer, c2, z);
            PdfSignatureAppearance pdfSignatureAppearance = new PdfSignatureAppearance(pdfStamper.s);
            pdfStamper.Z = pdfSignatureAppearance;
            pdfSignatureAppearance.m0(byteBuffer);
        } else {
            if (file.isDirectory()) {
                file = File.createTempFile(PdfSchema.Z, ".pdf", file);
            }
            PdfStamper pdfStamper2 = new PdfStamper(pdfReader, new FileOutputStream(file), c2, z);
            PdfSignatureAppearance pdfSignatureAppearance2 = new PdfSignatureAppearance(pdfStamper2.s);
            pdfStamper2.Z = pdfSignatureAppearance2;
            pdfSignatureAppearance2.o0(file);
            pdfStamper = pdfStamper2;
        }
        pdfStamper.Z.c0(outputStream);
        pdfStamper.Z.n0(pdfStamper);
        pdfStamper.Y = true;
        PdfDictionary F = pdfReader.F();
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.u0(F.d0(PdfName.p3), F);
        if (pdfDictionary != null) {
            pdfDictionary.a1(PdfName.xb);
            pdfStamper.s.z3(pdfDictionary);
        }
        return pdfStamper;
    }

    public static PdfStamper o(PdfReader pdfReader, OutputStream outputStream) throws IOException, DocumentException {
        PdfStamper pdfStamper = new PdfStamper(pdfReader, outputStream);
        XmlSignatureAppearance xmlSignatureAppearance = new XmlSignatureAppearance(pdfStamper.s);
        pdfStamper.X2 = xmlSignatureAppearance;
        xmlSignatureAppearance.n(pdfStamper);
        return pdfStamper;
    }

    public PdfSignatureAppearance A() {
        return this.Z;
    }

    public PdfContentByte B(int i2) {
        return this.s.s3(i2);
    }

    public PdfWriter C() {
        return this.s;
    }

    public XmlSignatureAppearance D() {
        return this.X2;
    }

    public XmpWriter E() {
        return this.s.P1();
    }

    public void F(int i2, Rectangle rectangle) {
        this.s.t3(i2, rectangle);
    }

    public boolean G() {
        return this.s.R1();
    }

    public boolean H() {
        return this.s.w3();
    }

    public void I(PdfName pdfName) {
        PdfCollection pdfCollection = new PdfCollection(0);
        pdfCollection.V0(PdfName.sh, pdfName);
        this.s.x3(pdfCollection);
    }

    public void J(PdfCollection pdfCollection) {
        this.s.x3(pdfCollection);
    }

    public void K(PdfObject pdfObject) {
        this.s.z3(pdfObject);
    }

    /* access modifiers changed from: package-private */
    public void L() throws IOException {
        LtvVerification ltvVerification = this.Y2;
        if (ltvVerification != null) {
            ltvVerification.i();
        }
    }

    public boolean M(String str) {
        return this.s.C3(str);
    }

    public void N(PdfReader pdfReader, int i2, int i3) {
        this.s.G3(pdfReader, i2, i3);
    }

    public void O(boolean z) {
        this.s.I3(z);
    }

    public void P(int i2, int i3) {
        this.s.H3(i2, i3);
    }

    public void Q(int i2, String str, String str2, int i3) throws DocumentException {
        r(DocWriter.E(str), DocWriter.E(str2), i3, i2);
    }

    public void R(boolean z, String str, String str2, int i2) throws DocumentException {
        S(DocWriter.E(str), DocWriter.E(str2), i2, z);
    }

    public void S(byte[] bArr, byte[] bArr2, int i2, boolean z) throws DocumentException {
        if (this.s.u3()) {
            throw new DocumentException(MessageLocalization.b("append.mode.does.not.support.changing.the.encryption.status", new Object[0]));
        } else if (!this.s.v3()) {
            this.s.r(bArr, bArr2, i2, z ? 1 : 0);
        } else {
            throw new DocumentException(MessageLocalization.b("content.was.already.written.to.the.output", new Object[0]));
        }
    }

    public void T(boolean z) {
        this.s.J3(z);
    }

    public void U(boolean z) {
        this.s.K3(z);
    }

    public void V() throws DocumentException {
        if (!this.s.u3()) {
            PdfStamperImp pdfStamperImp = this.s;
            pdfStamperImp.B3 = true;
            pdfStamperImp.e(PdfWriter.s4);
        }
    }

    public void W(Map<String, String> map) {
        this.X = map;
    }

    public void X(List<HashMap<String, Object>> list) {
        this.s.u2(list);
    }

    public void Y(PdfName pdfName, PdfAction pdfAction, int i2) throws PdfException {
        this.s.N3(pdfName, pdfAction, i2);
    }

    public void Z(boolean z) {
        this.s.O3(z);
    }

    public void a(int i2) {
        this.s.a(i2);
    }

    public void a0(Image image, int i2) throws PdfException, DocumentException {
        this.s.P3(image, i2);
    }

    public void b(PdfAnnotation pdfAnnotation, int i2) {
        this.s.U(pdfAnnotation, i2);
    }

    public void b0(PdfTransition pdfTransition, int i2) {
        this.s.Q3(pdfTransition, i2);
    }

    public void c(FdfReader fdfReader) throws IOException {
        this.s.S2(fdfReader);
    }

    public void c0(byte[] bArr) {
        this.s.N2(bArr);
    }

    public void d(String str, PdfFileSpecification pdfFileSpecification) throws IOException {
        this.s.Z(str, pdfFileSpecification);
    }

    public void e(String str, byte[] bArr, String str2, String str3) throws IOException {
        d(str, PdfFileSpecification.m1(this.s, str2, str3, bArr));
    }

    public void f(String str) {
        this.s.g0(str, !PdfEncodings.e(str));
    }

    public void g(String str, String str2) {
        PdfStamperImp pdfStamperImp = this.s;
        pdfStamperImp.d0(str, PdfAction.J1(str2, pdfStamperImp, !PdfEncodings.e(str2)));
    }

    public boolean h(String str, int i2, PdfDestination pdfDestination) throws IOException {
        HashMap<Object, PdfObject> n3 = this.s.n3();
        if (z().W().containsKey(str)) {
            return false;
        }
        PdfDestination pdfDestination2 = new PdfDestination(pdfDestination);
        pdfDestination2.X0(z().j0(i2));
        n3.put(str, new PdfArray((PdfArray) pdfDestination2));
        return true;
    }

    public PdfFormField i(String str, int i2, float f2, float f3, float f4, float f5) {
        PdfAcroForm B = this.s.B();
        PdfFormField X22 = PdfFormField.X2(this.s);
        PdfAcroForm pdfAcroForm = B;
        PdfFormField pdfFormField = X22;
        pdfAcroForm.l2(pdfFormField, str, f2, f3, f4, f5);
        pdfAcroForm.W1(pdfFormField, f2, f3, f4, f5);
        b(X22, i2);
        return X22;
    }

    public void j() throws DocumentException, IOException {
        if (!this.s.b6) {
            if (!this.Y) {
                L();
                this.s.b3(this.X);
                return;
            }
            throw new DocumentException("Signature defined. Must be closed in PdfSignatureAppearance.");
        }
    }

    public void m(Certificate[] certificateArr, int[] iArr, int i2) throws DocumentException {
        if (this.s.u3()) {
            throw new DocumentException(MessageLocalization.b("append.mode.does.not.support.changing.the.encryption.status", new Object[0]));
        } else if (!this.s.v3()) {
            this.s.m(certificateArr, iArr, i2);
        } else {
            throw new DocumentException(MessageLocalization.b("content.was.already.written.to.the.output", new Object[0]));
        }
    }

    public void p() {
        this.s.N0();
    }

    public void q() {
        try {
            this.s.X2();
            this.s.a6.clear();
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public void r(byte[] bArr, byte[] bArr2, int i2, int i3) throws DocumentException {
        if (this.s.u3()) {
            throw new DocumentException(MessageLocalization.b("append.mode.does.not.support.changing.the.encryption.status", new Object[0]));
        } else if (!this.s.v3()) {
            this.s.r(bArr, bArr2, i2, i3);
        } else {
            throw new DocumentException(MessageLocalization.b("content.was.already.written.to.the.output", new Object[0]));
        }
    }

    public AcroFields s() {
        return this.s.l3();
    }

    public PdfImportedPage t(PdfReader pdfReader, int i2) {
        return this.s.m1(pdfReader, i2);
    }

    public LtvVerification u() {
        if (this.Y2 == null) {
            this.Y2 = new LtvVerification(this);
        }
        return this.Y2;
    }

    public void v(PdfName pdfName, PdfObject pdfObject) {
        this.s.v(pdfName, pdfObject);
    }

    public Map<String, String> w() {
        return this.X;
    }

    public PdfContentByte x(int i2) {
        return this.s.o3(i2);
    }

    public Map<String, PdfLayer> y() {
        return this.s.q3();
    }

    public PdfReader z() {
        return this.s.Y5;
    }

    public PdfStamper(PdfReader pdfReader, OutputStream outputStream) throws DocumentException, IOException {
        this.s = new PdfStamperImp(pdfReader, outputStream, 0, false);
    }

    public PdfStamper(PdfReader pdfReader, OutputStream outputStream, char c2) throws DocumentException, IOException {
        this.s = new PdfStamperImp(pdfReader, outputStream, c2, false);
    }

    public PdfStamper(PdfReader pdfReader, OutputStream outputStream, char c2, boolean z) throws DocumentException, IOException {
        this.s = new PdfStamperImp(pdfReader, outputStream, c2, z);
    }
}
