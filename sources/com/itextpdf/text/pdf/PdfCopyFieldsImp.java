package com.itextpdf.text.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.BadPasswordException;
import com.itextpdf.text.log.Counter;
import com.itextpdf.text.log.CounterFactory;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfDocument;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.StringTokenizer;

@Deprecated
class PdfCopyFieldsImp extends PdfWriter {
    private static final PdfName p6 = new PdfName("_iTextTag_");
    private static final Integer q6 = 0;
    protected static final HashMap<PdfName, Integer> r6;
    protected static final HashMap<PdfName, Integer> s6;
    ArrayList<PdfReader> V5;
    HashMap<PdfReader, IntHashtable> W5;
    HashMap<PdfReader, IntHashtable> X5;
    HashMap<PdfReader, IntHashtable> Y5;
    ArrayList<AcroFields> Z5;
    RandomAccessFileOrArray a6;
    HashMap<String, Object> b6;
    ArrayList<PdfIndirectReference> c6;
    ArrayList<PdfDictionary> d6;
    PdfDictionary e6;
    PdfDictionary f6;
    boolean g6;
    Document h6;
    private HashMap<PdfArray, ArrayList<Integer>> i6;
    private ArrayList<String> j6;
    private ArrayList<Object> k6;
    private boolean l6;
    private boolean m6;
    private HashSet<Object> n6;
    protected Counter o6;

    static {
        HashMap<PdfName, Integer> hashMap = new HashMap<>();
        r6 = hashMap;
        HashMap<PdfName, Integer> hashMap2 = new HashMap<>();
        s6 = hashMap2;
        hashMap.put(PdfName.Cf, 1);
        hashMap.put(PdfName.N5, 1);
        hashMap.put(PdfName.Nd, 1);
        hashMap.put(PdfName.Cb, 1);
        hashMap.put(PdfName.Na, 1);
        hashMap.put(PdfName.F7, 1);
        hashMap.put(PdfName.H4, 1);
        hashMap.put(PdfName.D4, 1);
        hashMap.put(PdfName.S3, 1);
        hashMap.put(PdfName.Z3, 1);
        hashMap.put(PdfName.K4, 1);
        hashMap.put(PdfName.k3, 1);
        hashMap.put(PdfName.vf, 1);
        hashMap.put(PdfName.Pb, 1);
        hashMap.put(PdfName.W8, 1);
        hashMap.put(PdfName.gb, 1);
        hashMap.put(PdfName.g6, 1);
        hashMap.put(PdfName.Ad, 1);
        hashMap.put(PdfName.tc, 1);
        hashMap2.put(PdfName.m3, 1);
        hashMap2.put(PdfName.C8, 1);
        hashMap2.put(PdfName.Dg, 1);
        hashMap2.put(PdfName.kg, 1);
        hashMap2.put(PdfName.L7, 1);
        hashMap2.put(PdfName.kh, 1);
        hashMap2.put(PdfName.a7, 1);
        hashMap2.put(PdfName.U6, 1);
        hashMap2.put(PdfName.Be, 1);
        hashMap2.put(PdfName.hc, 1);
        hashMap2.put(PdfName.Ya, 1);
        hashMap2.put(PdfName.bg, 1);
        hashMap2.put(PdfName.x9, 1);
        hashMap2.put(PdfName.Ha, 1);
        hashMap2.put(PdfName.Ff, 1);
    }

    PdfCopyFieldsImp(OutputStream outputStream) throws DocumentException {
        this(outputStream, 0);
    }

    private void U2(PdfArray pdfArray, PdfIndirectReference pdfIndirectReference, PdfNumber pdfNumber) {
        int e0 = pdfNumber.e0();
        ArrayList arrayList = this.i6.get(pdfArray);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            int size = pdfArray.size() - 1;
            for (int i2 = 0; i2 < size; i2++) {
                arrayList2.add(q6);
            }
            arrayList2.add(Integer.valueOf(e0));
            this.i6.put(pdfArray, arrayList2);
            pdfArray.a0(pdfIndirectReference);
            return;
        }
        int size2 = arrayList.size() - 1;
        int i3 = size2;
        while (true) {
            if (i3 < 0) {
                break;
            } else if (((Integer) arrayList.get(i3)).intValue() <= e0) {
                int i4 = i3 + 1;
                arrayList.add(i4, Integer.valueOf(e0));
                pdfArray.Z(i4, pdfIndirectReference);
                size2 = -2;
                break;
            } else {
                i3--;
            }
        }
        if (size2 != -2) {
            arrayList.add(0, Integer.valueOf(e0));
            pdfArray.Z(0, pdfIndirectReference);
        }
    }

    private static String Z2(PdfReader pdfReader, PRIndirectReference pRIndirectReference) {
        PdfObject t0;
        String str = "";
        while (pRIndirectReference != null && (t0 = PdfReader.t0(pRIndirectReference)) != null && t0.W() == 6) {
            PdfDictionary pdfDictionary = (PdfDictionary) t0;
            PdfString A0 = pdfDictionary.A0(PdfName.If);
            if (A0 != null) {
                str = A0.m0() + "." + str;
            }
            pRIndirectReference = (PRIndirectReference) pdfDictionary.d0(PdfName.Dc);
        }
        return str.endsWith(".") ? str.substring(0, str.length() - 1) : str;
    }

    public PdfIndirectReference A1(int i2) {
        return this.c6.get(i2 - 1);
    }

    /* access modifiers changed from: package-private */
    public RandomAccessFileOrArray G1(PdfReader pdfReader) {
        return this.a6;
    }

    /* access modifiers changed from: package-private */
    public void R2(PdfReader pdfReader) throws DocumentException, IOException {
        if (pdfReader.R0()) {
            i3();
            if (this.W5.containsKey(pdfReader)) {
                pdfReader = new PdfReader(pdfReader);
            } else if (!pdfReader.U0()) {
                pdfReader.n();
                pdfReader.H1(true);
            } else {
                throw new DocumentException(MessageLocalization.b("the.document.was.reused", new Object[0]));
            }
            pdfReader.K1();
            this.W5.put(pdfReader, new IntHashtable());
            this.V5.add(pdfReader);
            int c0 = pdfReader.c0();
            IntHashtable intHashtable = new IntHashtable();
            for (int i2 = 1; i2 <= c0; i2++) {
                intHashtable.l(pdfReader.j0(i2).d(), 1);
                pdfReader.r1(i2);
            }
            this.X5.put(pdfReader, intHashtable);
            this.Y5.put(pdfReader, new IntHashtable());
            AcroFields C = pdfReader.C();
            if (!C.J()) {
                this.m6 = true;
            }
            this.Z5.add(C);
            l3(pdfReader);
            return;
        }
        throw new BadPasswordException(MessageLocalization.b("pdfreader.not.opened.with.owner.password", new Object[0]));
    }

    /* access modifiers changed from: package-private */
    public void S2(PdfReader pdfReader, List<Integer> list) throws DocumentException, IOException {
        if (this.W5.containsKey(pdfReader) || !pdfReader.U0()) {
            PdfReader pdfReader2 = new PdfReader(pdfReader);
            pdfReader2.B1(list);
            if (pdfReader2.c0() != 0) {
                pdfReader2.H1(false);
                R2(pdfReader2);
                return;
            }
            return;
        }
        throw new DocumentException(MessageLocalization.b("the.document.was.reused", new Object[0]));
    }

    /* access modifiers changed from: package-private */
    public void T2(Map<String, AcroFields.Item> map, int i2) {
        if (i2 != 0) {
            for (AcroFields.Item next : map.values()) {
                for (int i3 = 0; i3 < next.p(); i3++) {
                    next.g(i3, next.i(i3).intValue() + i2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public PdfArray V2(HashMap<String, Object> hashMap, PdfIndirectReference pdfIndirectReference, String str) throws IOException {
        Iterator<Map.Entry<String, Object>> it2;
        PdfIndirectReference pdfIndirectReference2;
        boolean z;
        PdfArray pdfArray;
        Iterator<Map.Entry<String, Object>> it3;
        PdfIndirectReference pdfIndirectReference3 = pdfIndirectReference;
        PdfArray pdfArray2 = new PdfArray();
        Iterator<Map.Entry<String, Object>> it4 = hashMap.entrySet().iterator();
        while (it4.hasNext()) {
            Map.Entry next = it4.next();
            String str2 = (String) next.getKey();
            Object value = next.getValue();
            PdfIndirectReference D1 = D1();
            PdfDictionary pdfDictionary = new PdfDictionary();
            if (pdfIndirectReference3 != null) {
                pdfDictionary.V0(PdfName.Dc, pdfIndirectReference3);
            }
            pdfDictionary.V0(PdfName.If, new PdfString(str2, PdfObject.h3));
            String str3 = str + "." + str2;
            int indexOf = this.j6.indexOf(str3);
            if (indexOf >= 0) {
                this.k6.set(indexOf, D1);
            }
            if (value instanceof HashMap) {
                pdfDictionary.V0(PdfName.ia, V2((HashMap) value, D1, str3));
                pdfArray2.a0(D1);
                y0(pdfDictionary, D1);
                it2 = it4;
            } else {
                ArrayList arrayList = (ArrayList) value;
                pdfDictionary.U0((PdfDictionary) arrayList.get(0));
                int i2 = 1;
                if (arrayList.size() == 3) {
                    pdfDictionary.U0((PdfDictionary) arrayList.get(2));
                    PdfDictionary pdfDictionary2 = this.d6.get(((Integer) arrayList.get(1)).intValue() - 1);
                    PdfName pdfName = PdfName.Q3;
                    PdfArray e0 = pdfDictionary2.e0(pdfName);
                    if (e0 == null) {
                        e0 = new PdfArray();
                        pdfDictionary2.V0(pdfName, e0);
                    }
                    PdfName pdfName2 = p6;
                    pdfDictionary.a1(pdfName2);
                    U2(e0, D1, (PdfNumber) pdfDictionary.d0(pdfName2));
                    it2 = it4;
                    z = false;
                    pdfIndirectReference2 = null;
                } else {
                    PdfDictionary pdfDictionary3 = (PdfDictionary) arrayList.get(0);
                    PdfName p0 = pdfDictionary3.p0(PdfName.kh);
                    PdfArray pdfArray3 = new PdfArray();
                    int i3 = 1;
                    while (i3 < arrayList.size()) {
                        PdfDictionary pdfDictionary4 = this.d6.get(((Integer) arrayList.get(i3)).intValue() - i2);
                        PdfName pdfName3 = PdfName.Q3;
                        PdfArray e02 = pdfDictionary4.e0(pdfName3);
                        if (e02 == null) {
                            pdfArray = new PdfArray();
                            pdfDictionary4.V0(pdfName3, pdfArray);
                        } else {
                            pdfArray = e02;
                        }
                        PdfDictionary pdfDictionary5 = new PdfDictionary();
                        pdfDictionary5.T0((PdfDictionary) arrayList.get(i3 + 1));
                        pdfDictionary5.V0(PdfName.Dc, D1);
                        PdfName pdfName4 = p6;
                        PdfNumber pdfNumber = (PdfNumber) pdfDictionary5.d0(pdfName4);
                        pdfDictionary5.a1(pdfName4);
                        if (PdfCopy.F3(pdfDictionary3)) {
                            PdfName pdfName5 = PdfName.Z3;
                            PdfName p02 = pdfDictionary5.p0(pdfName5);
                            if (!(p0 == null || p02 == null)) {
                                pdfDictionary5.V0(pdfName5, p0);
                            }
                        } else if (PdfCopy.G3(pdfDictionary3)) {
                            PdfName pdfName6 = PdfName.Z3;
                            PdfName p03 = pdfDictionary5.p0(pdfName6);
                            if (!(p0 == null || p03 == null)) {
                                it3 = it4;
                                if (!p03.equals(b3(pdfDictionary5))) {
                                    if (!this.n6.contains(arrayList)) {
                                        this.n6.add(arrayList);
                                        pdfDictionary5.V0(pdfName6, p0);
                                    } else {
                                        pdfDictionary5.V0(pdfName6, b3(pdfDictionary5));
                                    }
                                }
                                PdfIndirectReference a2 = v0(pdfDictionary5).a();
                                U2(pdfArray, a2, pdfNumber);
                                pdfArray3.a0(a2);
                                j3(pdfDictionary5, (PdfIndirectReference) null, false);
                                i3 += 2;
                                PdfIndirectReference pdfIndirectReference4 = pdfIndirectReference;
                                it4 = it3;
                                i2 = 1;
                            }
                        }
                        it3 = it4;
                        PdfIndirectReference a22 = v0(pdfDictionary5).a();
                        U2(pdfArray, a22, pdfNumber);
                        pdfArray3.a0(a22);
                        j3(pdfDictionary5, (PdfIndirectReference) null, false);
                        i3 += 2;
                        PdfIndirectReference pdfIndirectReference42 = pdfIndirectReference;
                        it4 = it3;
                        i2 = 1;
                    }
                    it2 = it4;
                    z = false;
                    pdfIndirectReference2 = null;
                    pdfDictionary.V0(PdfName.ia, pdfArray3);
                }
                pdfArray2.a0(D1);
                y0(pdfDictionary, D1);
                j3(pdfDictionary, pdfIndirectReference2, z);
            }
            pdfIndirectReference3 = pdfIndirectReference;
            it4 = it2;
        }
        return pdfArray2;
    }

    /* access modifiers changed from: protected */
    public void W2() throws IOException {
        for (int i2 = 0; i2 < this.V5.size(); i2++) {
            this.V5.get(i2).t1();
        }
        int i3 = 0;
        while (true) {
            if (i3 >= this.V5.size()) {
                break;
            }
            PdfReader pdfReader = this.V5.get(i3);
            for (int i4 = 1; i4 <= pdfReader.c0(); i4++) {
                this.c6.add(a3(pdfReader.j0(i4)));
                this.d6.add(pdfReader.h0(i4));
            }
            i3++;
        }
        g3();
        X2();
        for (int i5 = 0; i5 < this.V5.size(); i5++) {
            PdfReader pdfReader2 = this.V5.get(i5);
            for (int i7 = 1; i7 <= pdfReader2.c0(); i7++) {
                PdfDictionary h0 = pdfReader2.h0(i7);
                PdfIndirectReference a3 = a3(pdfReader2.j0(i7));
                h0.V0(PdfName.Dc, this.n3.c(a3));
                j3(h0, a3, false);
            }
        }
        for (Map.Entry next : this.W5.entrySet()) {
            PdfReader pdfReader3 = (PdfReader) next.getKey();
            try {
                RandomAccessFileOrArray B0 = pdfReader3.B0();
                this.a6 = B0;
                B0.g();
                IntHashtable intHashtable = (IntHashtable) next.getValue();
                int[] p = intHashtable.p();
                for (int i8 = 0; i8 < p.length; i8++) {
                    w0(PdfReader.w0(new PRIndirectReference(pdfReader3, p[i8])), intHashtable.e(p[i8]));
                }
            } finally {
                try {
                    this.a6.close();
                } catch (Exception unused) {
                }
            }
        }
        this.h3.close();
    }

    /* access modifiers changed from: protected */
    public PdfDictionary X0(PdfIndirectReference pdfIndirectReference) {
        try {
            PdfDocument.PdfCatalog w0 = this.h3.w0(pdfIndirectReference);
            PdfDictionary pdfDictionary = this.f6;
            if (pdfDictionary != null) {
                w0.V0(PdfName.p3, v0(pdfDictionary).a());
            }
            return w0;
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* access modifiers changed from: protected */
    public void X2() throws IOException {
        if (!this.b6.isEmpty()) {
            PdfDictionary pdfDictionary = new PdfDictionary();
            this.f6 = pdfDictionary;
            pdfDictionary.V0(PdfName.T6, this.e6);
            j3(this.e6, (PdfIndirectReference) null, false);
            if (this.m6) {
                this.f6.V0(PdfName.xb, PdfBoolean.j3);
            }
            this.f6.V0(PdfName.g6, new PdfString("/Helv 0 Tf 0 g "));
            this.i6 = new HashMap<>();
            this.k6 = new ArrayList<>(this.j6);
            this.f6.V0(PdfName.P7, V2(this.b6, (PdfIndirectReference) null, ""));
            if (this.l6) {
                this.f6.V0(PdfName.Re, new PdfNumber(3));
            }
            PdfArray pdfArray = new PdfArray();
            for (int i2 = 0; i2 < this.k6.size(); i2++) {
                Object obj = this.k6.get(i2);
                if (obj instanceof PdfIndirectReference) {
                    pdfArray.a0((PdfIndirectReference) obj);
                }
            }
            if (pdfArray.size() > 0) {
                this.f6.V0(PdfName.r5, pdfArray);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void Y2(ArrayList<Object> arrayList, AcroFields.Item item) {
        for (int i2 = 0; i2 < item.p(); i2++) {
            arrayList.add(item.i(i2));
            PdfDictionary h2 = item.h(i2);
            PdfObject d0 = h2.d0(PdfName.T6);
            if (d0 != null) {
                PdfFormField.b3(this.e6, (PdfDictionary) PdfReader.t0(d0));
            }
            PdfDictionary pdfDictionary = new PdfDictionary();
            for (PdfName next : h2.G0()) {
                if (r6.containsKey(next)) {
                    pdfDictionary.V0(next, h2.d0(next));
                }
            }
            pdfDictionary.V0(p6, new PdfNumber(item.j(i2).intValue() + 1));
            arrayList.add(pdfDictionary);
        }
    }

    /* access modifiers changed from: protected */
    public PdfIndirectReference a3(PRIndirectReference pRIndirectReference) {
        return new PdfIndirectReference(0, s1(pRIndirectReference.a0(), pRIndirectReference.d(), 0));
    }

    /* access modifiers changed from: protected */
    public Counter b1() {
        return this.o6;
    }

    /* access modifiers changed from: protected */
    public PdfName b3(PdfDictionary pdfDictionary) {
        return PdfName.Xb;
    }

    /* access modifiers changed from: protected */
    public boolean c3(PRIndirectReference pRIndirectReference) {
        IntHashtable intHashtable = this.X5.get(pRIndirectReference.a0());
        if (intHashtable != null) {
            return intHashtable.c(pRIndirectReference.d());
        }
        return false;
    }

    public void close() {
        if (this.g6) {
            super.close();
            return;
        }
        this.g6 = true;
        try {
            W2();
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean d3(PRIndirectReference pRIndirectReference) {
        IntHashtable intHashtable = this.Y5.get(pRIndirectReference.a0());
        if (intHashtable != null) {
            return intHashtable.c(pRIndirectReference.d());
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean e3(PdfReader pdfReader, int i2, int i3) {
        return this.W5.get(pdfReader).c(i2);
    }

    /* access modifiers changed from: package-private */
    public void f3(String str, AcroFields.Item item) {
        HashMap<String, Object> hashMap = this.b6;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        if (stringTokenizer.hasMoreTokens()) {
            while (true) {
                String nextToken = stringTokenizer.nextToken();
                Object obj = hashMap.get(nextToken);
                if (stringTokenizer.hasMoreTokens()) {
                    if (obj == null) {
                        HashMap<String, Object> hashMap2 = new HashMap<>();
                        hashMap.put(nextToken, hashMap2);
                        hashMap = hashMap2;
                    } else if (obj instanceof HashMap) {
                        hashMap = obj;
                    } else {
                        return;
                    }
                } else if (!(obj instanceof HashMap)) {
                    int i2 = 0;
                    PdfDictionary h2 = item.h(0);
                    if (obj == null) {
                        PdfDictionary pdfDictionary = new PdfDictionary();
                        if (PdfName.Pe.equals(h2.d0(PdfName.C8))) {
                            this.l6 = true;
                        }
                        for (PdfName next : h2.G0()) {
                            if (s6.containsKey(next)) {
                                pdfDictionary.V0(next, h2.d0(next));
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(pdfDictionary);
                        Y2(arrayList, item);
                        hashMap.put(nextToken, arrayList);
                        return;
                    }
                    ArrayList arrayList2 = (ArrayList) obj;
                    PdfDictionary pdfDictionary2 = (PdfDictionary) arrayList2.get(0);
                    PdfName pdfName = PdfName.C8;
                    PdfName pdfName2 = (PdfName) pdfDictionary2.d0(pdfName);
                    PdfName pdfName3 = (PdfName) h2.d0(pdfName);
                    if (pdfName2 != null && pdfName2.equals(pdfName3)) {
                        PdfName pdfName4 = PdfName.L7;
                        PdfObject d0 = pdfDictionary2.d0(pdfName4);
                        int e0 = (d0 == null || !d0.I()) ? 0 : ((PdfNumber) d0).e0();
                        PdfObject d02 = h2.d0(pdfName4);
                        if (d02 != null && d02.I()) {
                            i2 = ((PdfNumber) d02).e0();
                        }
                        if (pdfName2.equals(PdfName.I4)) {
                            int i3 = e0 ^ i2;
                            if ((i3 & 65536) == 0) {
                                if ((e0 & 65536) == 0 && (32768 & i3) != 0) {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else if (pdfName2.equals(PdfName.e5) && ((e0 ^ i2) & 131072) != 0) {
                            return;
                        }
                        Y2(arrayList2, item);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g3() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.Z5.size(); i3++) {
            Map<String, AcroFields.Item> t = this.Z5.get(i3).t();
            T2(t, i2);
            h3(t);
            i2 += this.V5.get(i3).c0();
        }
    }

    /* access modifiers changed from: package-private */
    public void h3(Map<String, AcroFields.Item> map) {
        for (Map.Entry next : map.entrySet()) {
            f3((String) next.getKey(), (AcroFields.Item) next.getValue());
        }
    }

    public void i3() {
        if (!this.h6.F()) {
            this.h6.open();
        }
    }

    /* access modifiers changed from: package-private */
    public void j3(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference, boolean z) throws IOException {
        if (pdfObject != null && !(pdfObject instanceof PdfIndirectReference)) {
            int W = pdfObject.W();
            if (W == 5) {
                ListIterator<PdfObject> listIterator = ((PdfArray) pdfObject).listIterator();
                while (listIterator.hasNext()) {
                    PdfObject next = listIterator.next();
                    if (next == null || !next.C()) {
                        j3(next, (PdfIndirectReference) null, z);
                    } else {
                        PRIndirectReference pRIndirectReference = (PRIndirectReference) next;
                        if (!d3(pRIndirectReference) && !c3(pRIndirectReference)) {
                            j3(PdfReader.w0(pRIndirectReference), a3(pRIndirectReference), z);
                        }
                    }
                }
            } else if (W == 6 || W == 7) {
                PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
                for (PdfName next2 : pdfDictionary.G0()) {
                    if (!z || (!next2.equals(PdfName.Dc) && !next2.equals(PdfName.ia))) {
                        PdfObject d0 = pdfDictionary.d0(next2);
                        if (d0 == null || !d0.C()) {
                            j3(d0, (PdfIndirectReference) null, z);
                        } else {
                            PRIndirectReference pRIndirectReference2 = (PRIndirectReference) d0;
                            if (!k3(pRIndirectReference2) && !c3(pRIndirectReference2)) {
                                j3(PdfReader.w0(pRIndirectReference2), a3(pRIndirectReference2), z);
                            }
                        }
                    }
                }
            } else if (W == 10) {
                throw new RuntimeException(MessageLocalization.b("reference.pointing.to.reference", new Object[0]));
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean k3(PRIndirectReference pRIndirectReference) {
        IntHashtable intHashtable = this.Y5.get(pRIndirectReference.a0());
        return (intHashtable == null || intHashtable.l(pRIndirectReference.d(), 1) == 0) ? false : true;
    }

    /* access modifiers changed from: protected */
    public void l3(PdfReader pdfReader) {
        PdfArray e0;
        PdfDictionary j0 = pdfReader.F().j0(PdfName.p3);
        if (j0 != null && (e0 = j0.e0(PdfName.r5)) != null && e0.size() != 0) {
            AcroFields C = pdfReader.C();
            for (int i2 = 0; i2 < e0.size(); i2++) {
                PdfObject T0 = e0.T0(i2);
                if (T0 != null && T0.C()) {
                    String Z2 = Z2(pdfReader, (PRIndirectReference) T0);
                    if (C.p(Z2) != null) {
                        String str = "." + Z2;
                        if (!this.j6.contains(str)) {
                            this.j6.add(str);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public int s1(PdfReader pdfReader, int i2, int i3) {
        IntHashtable intHashtable = this.W5.get(pdfReader);
        int e2 = intHashtable.e(i2);
        if (e2 != 0) {
            return e2;
        }
        int n1 = n1();
        intHashtable.l(i2, n1);
        return n1;
    }

    PdfCopyFieldsImp(OutputStream outputStream, char c2) throws DocumentException {
        super(new PdfDocument(), outputStream);
        this.V5 = new ArrayList<>();
        this.W5 = new HashMap<>();
        this.X5 = new HashMap<>();
        this.Y5 = new HashMap<>();
        this.Z5 = new ArrayList<>();
        this.b6 = new HashMap<>();
        this.c6 = new ArrayList<>();
        this.d6 = new ArrayList<>();
        this.e6 = new PdfDictionary();
        this.g6 = false;
        this.j6 = new ArrayList<>();
        this.m6 = false;
        this.n6 = new HashSet<>();
        this.o6 = CounterFactory.b(PdfCopyFields.class);
        this.h3.i0(this);
        if (c2 != 0) {
            super.q(c2);
        }
        Document document = new Document();
        this.h6 = document;
        document.h(this.h3);
    }
}
