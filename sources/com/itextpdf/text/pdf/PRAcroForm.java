package com.itextpdf.text.pdf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import org.apache.commons.lang3.ClassUtils;

public class PRAcroForm extends PdfDictionary {
    ArrayList<FieldInformation> p3 = new ArrayList<>();
    ArrayList<PdfDictionary> q3 = new ArrayList<>();
    HashMap<String, FieldInformation> r3 = new HashMap<>();
    PdfReader s3;

    public static class FieldInformation {

        /* renamed from: a  reason: collision with root package name */
        String f26098a;

        /* renamed from: b  reason: collision with root package name */
        PdfDictionary f26099b;

        /* renamed from: c  reason: collision with root package name */
        PRIndirectReference f26100c;

        FieldInformation(String str, PdfDictionary pdfDictionary, PRIndirectReference pRIndirectReference) {
            this.f26098a = str;
            this.f26099b = pdfDictionary;
            this.f26100c = pRIndirectReference;
        }

        public PdfDictionary a() {
            return this.f26099b;
        }

        public String b() {
            return this.f26098a;
        }

        public PRIndirectReference c() {
            return this.f26100c;
        }

        public String d() {
            PdfObject d0 = this.f26099b.d0(PdfName.Cb);
            if (d0 != null) {
                return d0.toString();
            }
            return null;
        }
    }

    public PRAcroForm(PdfReader pdfReader) {
        this.s3 = pdfReader;
    }

    public FieldInformation f1(String str) {
        return this.r3.get(str);
    }

    public ArrayList<FieldInformation> i1() {
        return this.p3;
    }

    public PRIndirectReference m1(String str) {
        FieldInformation fieldInformation = this.r3.get(str);
        if (fieldInformation == null) {
            return null;
        }
        return fieldInformation.c();
    }

    /* access modifiers changed from: protected */
    public void n1(PdfArray pdfArray, PRIndirectReference pRIndirectReference, String str) {
        String str2;
        ListIterator<PdfObject> listIterator = pdfArray.listIterator();
        while (listIterator.hasNext()) {
            PRIndirectReference pRIndirectReference2 = (PRIndirectReference) listIterator.next();
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.w0(pRIndirectReference2);
            PdfName pdfName = PdfName.If;
            PdfString pdfString = (PdfString) pdfDictionary.d0(pdfName);
            boolean z = pdfString != null;
            if (!z) {
                pRIndirectReference2 = pRIndirectReference;
                str2 = str;
            } else if (str == null) {
                str2 = pdfString.toString();
            } else {
                str2 = str + ClassUtils.PACKAGE_SEPARATOR_CHAR + pdfString.toString();
            }
            PdfArray pdfArray2 = (PdfArray) pdfDictionary.d0(PdfName.ia);
            if (pdfArray2 != null) {
                p1(pdfDictionary);
                n1(pdfArray2, pRIndirectReference2, str2);
                ArrayList<PdfDictionary> arrayList = this.q3;
                arrayList.remove(arrayList.size() - 1);
            } else if (pRIndirectReference2 != null) {
                ArrayList<PdfDictionary> arrayList2 = this.q3;
                PdfDictionary pdfDictionary2 = arrayList2.get(arrayList2.size() - 1);
                if (z) {
                    pdfDictionary2 = o1(pdfDictionary2, pdfDictionary);
                }
                pdfDictionary2.V0(pdfName, new PdfString(str2));
                FieldInformation fieldInformation = new FieldInformation(str2, pdfDictionary2, pRIndirectReference2);
                this.p3.add(fieldInformation);
                this.r3.put(str2, fieldInformation);
            }
        }
    }

    /* access modifiers changed from: protected */
    public PdfDictionary o1(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2) {
        PdfDictionary pdfDictionary3 = new PdfDictionary();
        if (pdfDictionary != null) {
            pdfDictionary3.X0(pdfDictionary);
        }
        for (PdfName next : pdfDictionary2.G0()) {
            if (next.equals(PdfName.T6) || next.equals(PdfName.g6) || next.equals(PdfName.Ad) || next.equals(PdfName.L7) || next.equals(PdfName.a7) || next.equals(PdfName.kh) || next.equals(PdfName.C8) || next.equals(PdfName.Cb) || next.equals(PdfName.F7)) {
                pdfDictionary3.V0(next, pdfDictionary2.d0(next));
            }
        }
        return pdfDictionary3;
    }

    /* access modifiers changed from: protected */
    public void p1(PdfDictionary pdfDictionary) {
        PdfDictionary pdfDictionary2;
        if (!this.q3.isEmpty()) {
            ArrayList<PdfDictionary> arrayList = this.q3;
            pdfDictionary2 = arrayList.get(arrayList.size() - 1);
        } else {
            pdfDictionary2 = null;
        }
        this.q3.add(o1(pdfDictionary2, pdfDictionary));
    }

    public void q1(PdfDictionary pdfDictionary) {
        if (pdfDictionary != null) {
            this.j3 = pdfDictionary.j3;
            p1(pdfDictionary);
            PdfArray pdfArray = (PdfArray) PdfReader.w0(pdfDictionary.d0(PdfName.P7));
            if (pdfArray != null) {
                n1(pdfArray, (PRIndirectReference) null, (String) null);
            }
        }
    }

    public int size() {
        return this.p3.size();
    }
}
