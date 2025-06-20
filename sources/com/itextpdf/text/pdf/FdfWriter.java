package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.log.Counter;
import com.itextpdf.text.log.CounterFactory;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FdfWriter {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f26032f = DocWriter.E("%FDF-1.4\n%âãÏÓ\n");

    /* renamed from: a  reason: collision with root package name */
    HashMap<String, Object> f26033a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    Wrt f26034b = null;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f26035c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f26036d;

    /* renamed from: e  reason: collision with root package name */
    protected Counter f26037e = CounterFactory.b(FdfWriter.class);

    static class Wrt extends PdfWriter {
        private FdfWriter V5;

        Wrt(OutputStream outputStream, FdfWriter fdfWriter) throws IOException {
            super(new PdfDocument(), outputStream);
            this.V5 = fdfWriter;
            this.Y.write(FdfWriter.f26032f);
            this.k3 = new PdfWriter.PdfBody(this);
        }

        /* access modifiers changed from: package-private */
        public PdfArray R2(HashMap<String, Object> hashMap) throws IOException {
            PdfName pdfName;
            PdfObject pdfObject;
            PdfArray pdfArray = new PdfArray();
            for (Map.Entry next : hashMap.entrySet()) {
                Object value = next.getValue();
                PdfDictionary pdfDictionary = new PdfDictionary();
                pdfDictionary.V0(PdfName.If, new PdfString((String) next.getKey(), PdfObject.h3));
                if (value instanceof HashMap) {
                    pdfName = PdfName.ia;
                    pdfObject = R2((HashMap) value);
                } else if (value instanceof PdfAction) {
                    pdfName = PdfName.k3;
                    pdfObject = (PdfAction) value;
                } else if (value instanceof PdfAnnotation) {
                    pdfName = PdfName.m3;
                    pdfObject = (PdfAnnotation) value;
                } else {
                    if (value instanceof PdfDictionary) {
                        PdfDictionary pdfDictionary2 = (PdfDictionary) value;
                        if (pdfDictionary2.size() == 1 && pdfDictionary2.a0(PdfName.kb)) {
                            pdfDictionary.V0(PdfName.S3, pdfDictionary2);
                            pdfArray.a0(pdfDictionary);
                        }
                    }
                    pdfName = PdfName.kh;
                    pdfObject = (PdfObject) value;
                }
                pdfDictionary.V0(pdfName, pdfObject);
                pdfArray.a0(pdfDictionary);
            }
            return pdfArray;
        }

        /* access modifiers changed from: package-private */
        public void S2() throws IOException {
            for (PdfReaderInstance next : this.H3.values()) {
                this.I3 = next;
                next.g();
            }
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.V0(PdfName.P7, R2(this.V5.f26033a));
            if (this.V5.f26035c != null) {
                pdfDictionary.V0(PdfName.F7, new PdfString(this.V5.f26035c, PdfObject.h3));
            }
            if (!(this.V5.f26036d == null || this.V5.f26036d.trim().length() == 0)) {
                pdfDictionary.V0(PdfName.kf, new PdfString(this.V5.f26036d));
            }
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            pdfDictionary2.V0(PdfName.K7, pdfDictionary);
            PdfIndirectReference a2 = v0(pdfDictionary2).a();
            this.Y.write(DocWriter.E("trailer\n"));
            PdfDictionary pdfDictionary3 = new PdfDictionary();
            pdfDictionary3.V0(PdfName.se, a2);
            pdfDictionary3.T((PdfWriter) null, this.Y);
            this.Y.write(DocWriter.E("\n%%EOF\n"));
            this.Y.close();
        }
    }

    public FdfWriter() {
    }

    public PdfTemplate d(float f2, float f3) {
        return PdfTemplate.B3(this.f26034b, f2, f3);
    }

    /* access modifiers changed from: protected */
    public Counter e() {
        return this.f26037e;
    }

    public String f(String str) {
        HashMap<String, Object> hashMap = this.f26033a;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        if (!stringTokenizer.hasMoreTokens()) {
            return null;
        }
        while (true) {
            Object obj = hashMap.get(stringTokenizer.nextToken());
            if (obj == null) {
                return null;
            }
            if (stringTokenizer.hasMoreTokens()) {
                if (!(obj instanceof HashMap)) {
                    return null;
                }
                hashMap = obj;
            } else if (obj instanceof HashMap) {
                return null;
            } else {
                return ((PdfObject) obj).N() ? ((PdfString) obj).m0() : PdfName.a0(obj.toString());
            }
        }
    }

    public HashMap<String, Object> g() {
        HashMap<String, Object> hashMap = new HashMap<>();
        k(hashMap, this.f26033a, "");
        return hashMap;
    }

    public String h() {
        return this.f26035c;
    }

    public PdfImportedPage i(PdfReader pdfReader, int i2) {
        return this.f26034b.m1(pdfReader, i2);
    }

    public String j() {
        return this.f26036d;
    }

    /* access modifiers changed from: package-private */
    public void k(HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, String str) {
        for (Map.Entry next : hashMap2.entrySet()) {
            String str2 = (String) next.getKey();
            Object value = next.getValue();
            if (value instanceof HashMap) {
                k(hashMap, (HashMap) value, str + "." + str2);
            } else {
                hashMap.put((str + "." + str2).substring(1), value);
            }
        }
    }

    public boolean l(String str) {
        HashMap<String, Object> hashMap = this.f26033a;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        if (!stringTokenizer.hasMoreTokens()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            String nextToken = stringTokenizer.nextToken();
            Object obj = hashMap.get(nextToken);
            if (obj == null) {
                return false;
            }
            arrayList.add(hashMap);
            arrayList.add(nextToken);
            if (stringTokenizer.hasMoreTokens()) {
                if (!(obj instanceof HashMap)) {
                    return false;
                }
                hashMap = obj;
            } else if (obj instanceof HashMap) {
                return false;
            } else {
                for (int size = arrayList.size() - 2; size >= 0; size -= 2) {
                    HashMap hashMap2 = (HashMap) arrayList.get(size);
                    hashMap2.remove((String) arrayList.get(size + 1));
                    if (!hashMap2.isEmpty()) {
                        return true;
                    }
                }
                return true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean m(String str, PdfObject pdfObject) {
        HashMap<String, Object> hashMap = this.f26033a;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        if (!stringTokenizer.hasMoreTokens()) {
            return false;
        }
        while (true) {
            String nextToken = stringTokenizer.nextToken();
            Object obj = hashMap.get(nextToken);
            if (stringTokenizer.hasMoreTokens()) {
                if (obj == null) {
                    HashMap<String, Object> hashMap2 = new HashMap<>();
                    hashMap.put(nextToken, hashMap2);
                    hashMap = hashMap2;
                } else if (!(obj instanceof HashMap)) {
                    return false;
                } else {
                    hashMap = obj;
                }
            } else if (obj instanceof HashMap) {
                return false;
            } else {
                hashMap.put(nextToken, pdfObject);
                return true;
            }
        }
    }

    public boolean n(String str, PdfAction pdfAction) {
        return m(str, pdfAction);
    }

    public boolean o(String str, Image image) {
        try {
            if (Float.isNaN(image.D0())) {
                image.V1(0.0f, image.E0());
            }
            if (Float.isNaN(image.E0())) {
                image.V1(image.E0(), 0.0f);
            }
            PdfTemplate B3 = PdfTemplate.B3(this.f26034b, image.a0(), image.N());
            B3.h(image);
            PdfIndirectReference a2 = this.f26034b.v0(B3.G3(0)).a();
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.V0(PdfName.kb, a2);
            return m(str, pdfDictionary);
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public boolean p(String str, PdfName pdfName, String str2) {
        PdfAnnotation M0 = this.f26034b.M0((Rectangle) null, (PdfName) null);
        M0.V0(pdfName, PdfAction.I1(str2, this.f26034b));
        return m(str, M0);
    }

    public boolean q(String str, String str2) {
        return m(str, new PdfName(str2));
    }

    public boolean r(String str, String str2) {
        return m(str, new PdfString(str2, PdfObject.h3));
    }

    public boolean s(String str, PdfTemplate pdfTemplate) {
        PdfIndirectReference a2;
        PdfName pdfName;
        try {
            PdfDictionary pdfDictionary = new PdfDictionary();
            if (pdfTemplate instanceof PdfImportedPage) {
                pdfName = PdfName.kb;
                a2 = pdfTemplate.J3();
            } else {
                a2 = this.f26034b.v0(pdfTemplate.G3(0)).a();
                pdfName = PdfName.kb;
            }
            pdfDictionary.V0(pdfName, a2);
            return m(str, pdfDictionary);
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public void t(AcroFields acroFields) {
        PdfObject w0;
        for (Map.Entry next : acroFields.t().entrySet()) {
            String str = (String) next.getKey();
            PdfDictionary h2 = ((AcroFields.Item) next.getValue()).h(0);
            PdfObject w02 = PdfReader.w0(h2.d0(PdfName.kh));
            if (!(w02 == null || (w0 = PdfReader.w0(h2.d0(PdfName.C8))) == null || PdfName.Pe.equals(w0))) {
                m(str, w02);
            }
        }
    }

    public void u(FdfReader fdfReader) {
        for (Map.Entry next : fdfReader.O1().entrySet()) {
            String str = (String) next.getKey();
            PdfDictionary pdfDictionary = (PdfDictionary) next.getValue();
            PdfObject d0 = pdfDictionary.d0(PdfName.kh);
            if (d0 != null) {
                m(str, d0);
            }
            PdfObject d02 = pdfDictionary.d0(PdfName.k3);
            if (d02 != null) {
                m(str, d02);
            }
        }
    }

    public void v(PdfReader pdfReader) {
        t(pdfReader.C());
    }

    public void w(String str) {
        this.f26035c = str;
    }

    public void x(String str) {
        this.f26036d = str;
    }

    public void y() throws IOException {
        this.f26034b.S2();
    }

    public void z(OutputStream outputStream) throws IOException {
        if (this.f26034b == null) {
            this.f26034b = new Wrt(outputStream, this);
        }
        this.f26034b.S2();
    }

    public FdfWriter(OutputStream outputStream) throws IOException {
        this.f26034b = new Wrt(outputStream, this);
    }
}
