package com.itextpdf.text.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.log.Counter;
import com.itextpdf.text.log.CounterFactory;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.PdfCopy;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;

public class PdfSmartCopy extends PdfCopy {
    private static final Logger O6 = LoggerFactory.b(PdfSmartCopy.class);
    private HashMap<ByteStore, PdfIndirectReference> L6;
    private final HashMap<RefKey, Integer> M6;
    protected Counter N6;

    static class ByteStore {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f26327a;

        /* renamed from: b  reason: collision with root package name */
        private final int f26328b;

        /* renamed from: c  reason: collision with root package name */
        private MessageDigest f26329c;

        ByteStore(PRStream pRStream, HashMap<RefKey, Integer> hashMap) throws IOException {
            try {
                this.f26329c = MessageDigest.getInstance("MD5");
                ByteBuffer byteBuffer = new ByteBuffer();
                d(pRStream, 100, byteBuffer, hashMap);
                byte[] F = byteBuffer.F();
                this.f26327a = F;
                this.f26328b = a(F);
                this.f26329c = null;
            } catch (Exception e2) {
                throw new ExceptionConverter(e2);
            }
        }

        private static int a(byte[] bArr) {
            int i2 = 0;
            for (byte b2 : bArr) {
                i2 = (i2 * 31) + (b2 & 255);
            }
            return i2;
        }

        private void b(PdfArray pdfArray, int i2, ByteBuffer byteBuffer, HashMap<RefKey, Integer> hashMap) throws IOException {
            byteBuffer.k("$A");
            if (i2 > 0) {
                for (int i3 = 0; i3 < pdfArray.size(); i3++) {
                    d(pdfArray.T0(i3), i2, byteBuffer, hashMap);
                }
            }
        }

        private void c(PdfDictionary pdfDictionary, int i2, ByteBuffer byteBuffer, HashMap<RefKey, Integer> hashMap) throws IOException {
            byteBuffer.k("$D");
            if (i2 > 0) {
                Object[] array = pdfDictionary.G0().toArray();
                Arrays.sort(array);
                for (int i3 = 0; i3 < array.length; i3++) {
                    if (!array[i3].equals(PdfName.tc) || (!pdfDictionary.d0((PdfName) array[i3]).C() && !pdfDictionary.d0((PdfName) array[i3]).z())) {
                        d((PdfObject) array[i3], i2, byteBuffer, hashMap);
                        d(pdfDictionary.d0((PdfName) array[i3]), i2, byteBuffer, hashMap);
                    }
                }
            }
        }

        private void d(PdfObject pdfObject, int i2, ByteBuffer byteBuffer, HashMap<RefKey, Integer> hashMap) throws IOException {
            PdfIndirectReference pdfIndirectReference;
            ByteBuffer byteBuffer2;
            if (i2 > 0) {
                if (pdfObject == null) {
                    byteBuffer.k("$Lnull");
                    return;
                }
                if (pdfObject.C()) {
                    PdfIndirectReference pdfIndirectReference2 = (PdfIndirectReference) pdfObject;
                    RefKey refKey = new RefKey(pdfIndirectReference2);
                    if (hashMap.containsKey(refKey)) {
                        byteBuffer.f(hashMap.get(refKey).intValue());
                        return;
                    }
                    PdfIndirectReference pdfIndirectReference3 = pdfIndirectReference2;
                    byteBuffer2 = byteBuffer;
                    byteBuffer = new ByteBuffer();
                    pdfIndirectReference = pdfIndirectReference3;
                } else {
                    byteBuffer2 = null;
                    pdfIndirectReference = null;
                }
                PdfObject t0 = PdfReader.t0(pdfObject);
                if (t0.K()) {
                    byteBuffer.k("$B");
                    c((PdfDictionary) t0, i2 - 1, byteBuffer, hashMap);
                    if (i2 > 0) {
                        this.f26329c.reset();
                        byteBuffer.n(this.f26329c.digest(PdfReader.F0((PRStream) t0)));
                    }
                } else if (t0.z()) {
                    c((PdfDictionary) t0, i2 - 1, byteBuffer, hashMap);
                } else if (t0.q()) {
                    b((PdfArray) t0, i2 - 1, byteBuffer, hashMap);
                } else {
                    byteBuffer.k(t0.N() ? "$S" : t0.E() ? "$N" : "$L").k(t0.toString());
                }
                if (byteBuffer2 != null) {
                    RefKey refKey2 = new RefKey(pdfIndirectReference);
                    if (!hashMap.containsKey(refKey2)) {
                        hashMap.put(refKey2, Integer.valueOf(a(byteBuffer.w())));
                    }
                    byteBuffer2.i(byteBuffer);
                }
            }
        }

        public boolean equals(Object obj) {
            if ((obj instanceof ByteStore) && hashCode() == obj.hashCode()) {
                return Arrays.equals(this.f26327a, ((ByteStore) obj).f26327a);
            }
            return false;
        }

        public int hashCode() {
            return this.f26328b;
        }

        ByteStore(PdfDictionary pdfDictionary, HashMap<RefKey, Integer> hashMap) throws IOException {
            try {
                this.f26329c = MessageDigest.getInstance("MD5");
                ByteBuffer byteBuffer = new ByteBuffer();
                d(pdfDictionary, 100, byteBuffer, hashMap);
                byte[] F = byteBuffer.F();
                this.f26327a = F;
                this.f26328b = a(F);
                this.f26329c = null;
            } catch (Exception e2) {
                throw new ExceptionConverter(e2);
            }
        }
    }

    public PdfSmartCopy(Document document, OutputStream outputStream) throws DocumentException {
        super(document, outputStream);
        this.L6 = null;
        this.M6 = new HashMap<>();
        this.N6 = CounterFactory.b(PdfSmartCopy.class);
        this.L6 = new HashMap<>();
    }

    public void U0(PdfReader pdfReader) throws IOException {
        this.M6.clear();
        super.U0(pdfReader);
    }

    public void X2(PdfImportedPage pdfImportedPage) throws IOException, BadPdfFormatException {
        if (this.I3.d() != this.Z5) {
            this.M6.clear();
        }
        super.X2(pdfImportedPage);
    }

    /* access modifiers changed from: protected */
    public Counter b1() {
        return this.N6;
    }

    /* access modifiers changed from: protected */
    public PdfIndirectReference j3(PRIndirectReference pRIndirectReference) throws IOException, BadPdfFormatException {
        ByteStore byteStore;
        PdfIndirectReference pdfIndirectReference;
        PdfObject w0;
        PdfObject w02 = PdfReader.w0(pRIndirectReference);
        boolean z = true;
        if (w02.K()) {
            byteStore = new ByteStore((PRStream) w02, this.M6);
            PdfIndirectReference pdfIndirectReference2 = this.L6.get(byteStore);
            if (pdfIndirectReference2 != null) {
                return pdfIndirectReference2;
            }
        } else if (w02.z()) {
            byteStore = new ByteStore((PdfDictionary) w02, this.M6);
            PdfIndirectReference pdfIndirectReference3 = this.L6.get(byteStore);
            if (pdfIndirectReference3 != null) {
                return pdfIndirectReference3;
            }
        } else {
            byteStore = null;
            z = false;
        }
        RefKey refKey = new RefKey(pRIndirectReference);
        PdfCopy.IndirectReferences indirectReferences = this.V5.get(refKey);
        if (indirectReferences != null) {
            pdfIndirectReference = indirectReferences.b();
            if (indirectReferences.a()) {
                return pdfIndirectReference;
            }
        } else {
            PdfIndirectReference j2 = this.k3.j();
            PdfCopy.IndirectReferences indirectReferences2 = new PdfCopy.IndirectReferences(j2);
            this.V5.put(refKey, indirectReferences2);
            pdfIndirectReference = j2;
            indirectReferences = indirectReferences2;
        }
        if (w02.z() && (w0 = PdfReader.w0(((PdfDictionary) w02).d0(PdfName.Kg))) != null) {
            if (PdfName.uc.equals(w0)) {
                return pdfIndirectReference;
            }
            if (PdfName.U4.equals(w0)) {
                O6.g(MessageLocalization.b("make.copy.of.catalog.dictionary.is.forbidden", new Object[0]));
                return null;
            }
        }
        indirectReferences.c();
        if (z) {
            this.L6.put(byteStore, pdfIndirectReference);
        }
        y0(l3(w02), pdfIndirectReference);
        return pdfIndirectReference;
    }
}
