package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.io.RASInputStream;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.io.WindowRandomAccessSource;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.XfaForm;
import com.itextpdf.text.pdf.codec.Base64;
import com.itextpdf.text.pdf.security.PdfPKCS7;
import com.itextpdf.text.xml.XmlToTxt;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.w3c.dom.Node;

public class AcroFields {
    public static final int A = 6;
    public static final int B = 7;
    private static final HashMap<String, String[]> C;
    private static final PdfName[] D = {PdfName.gb, PdfName.F7, PdfName.L7, PdfName.Ad, PdfName.H4, PdfName.D4};
    public static final int r = 0;
    public static final int s = 1;
    public static final int t = 2;
    public static final int u = 0;
    public static final int v = 1;
    public static final int w = 2;
    public static final int x = 3;
    public static final int y = 4;
    public static final int z = 5;

    /* renamed from: a  reason: collision with root package name */
    PdfReader f25824a;

    /* renamed from: b  reason: collision with root package name */
    PdfWriter f25825b;

    /* renamed from: c  reason: collision with root package name */
    Map<String, Item> f25826c;

    /* renamed from: d  reason: collision with root package name */
    private int f25827d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, int[]> f25828e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f25829f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap<Integer, BaseFont> f25830g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private XfaForm f25831h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f25832i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f25833j = true;

    /* renamed from: k  reason: collision with root package name */
    private HashMap<String, BaseFont> f25834k = new HashMap<>();

    /* renamed from: l  reason: collision with root package name */
    private float f25835l;

    /* renamed from: m  reason: collision with root package name */
    private float f25836m;

    /* renamed from: n  reason: collision with root package name */
    private ArrayList<BaseFont> f25837n;
    private ArrayList<String> o;
    private int p;
    private Map<String, TextField> q;

    public static class FieldPosition {

        /* renamed from: a  reason: collision with root package name */
        public int f25838a;

        /* renamed from: b  reason: collision with root package name */
        public Rectangle f25839b;
    }

    private static class InstHit {

        /* renamed from: a  reason: collision with root package name */
        IntHashtable f25840a;

        public InstHit(int[] iArr) {
            if (iArr != null) {
                this.f25840a = new IntHashtable();
                for (int l2 : iArr) {
                    this.f25840a.l(l2, 1);
                }
            }
        }

        public boolean a(int i2) {
            IntHashtable intHashtable = this.f25840a;
            if (intHashtable == null) {
                return true;
            }
            return intHashtable.c(i2);
        }
    }

    public static class Item {

        /* renamed from: g  reason: collision with root package name */
        public static final int f25841g = 1;

        /* renamed from: h  reason: collision with root package name */
        public static final int f25842h = 2;

        /* renamed from: i  reason: collision with root package name */
        public static final int f25843i = 4;

        /* renamed from: a  reason: collision with root package name */
        protected ArrayList<PdfDictionary> f25844a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        protected ArrayList<PdfDictionary> f25845b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        protected ArrayList<PdfIndirectReference> f25846c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        protected ArrayList<PdfDictionary> f25847d = new ArrayList<>();

        /* renamed from: e  reason: collision with root package name */
        protected ArrayList<Integer> f25848e = new ArrayList<>();

        /* renamed from: f  reason: collision with root package name */
        protected ArrayList<Integer> f25849f = new ArrayList<>();

        /* access modifiers changed from: package-private */
        public void a(PdfDictionary pdfDictionary) {
            this.f25847d.add(pdfDictionary);
        }

        /* access modifiers changed from: package-private */
        public void b(int i2) {
            this.f25848e.add(Integer.valueOf(i2));
        }

        /* access modifiers changed from: package-private */
        public void c(int i2) {
            this.f25849f.add(Integer.valueOf(i2));
        }

        /* access modifiers changed from: package-private */
        public void d(PdfDictionary pdfDictionary) {
            this.f25844a.add(pdfDictionary);
        }

        /* access modifiers changed from: package-private */
        public void e(PdfDictionary pdfDictionary) {
            this.f25845b.add(pdfDictionary);
        }

        /* access modifiers changed from: package-private */
        public void f(PdfIndirectReference pdfIndirectReference) {
            this.f25846c.add(pdfIndirectReference);
        }

        /* access modifiers changed from: package-private */
        public void g(int i2, int i3) {
            this.f25848e.set(i2, Integer.valueOf(i3));
        }

        public PdfDictionary h(int i2) {
            return this.f25847d.get(i2);
        }

        public Integer i(int i2) {
            return this.f25848e.get(i2);
        }

        public Integer j(int i2) {
            return this.f25849f.get(i2);
        }

        public PdfDictionary k(int i2) {
            return this.f25844a.get(i2);
        }

        public PdfDictionary l(int i2) {
            return this.f25845b.get(i2);
        }

        public PdfIndirectReference m(int i2) {
            return this.f25846c.get(i2);
        }

        public void n(AcroFields acroFields, int i2) {
            if ((i2 & 4) != 0) {
                for (int i3 = 0; i3 < p(); i3++) {
                    acroFields.L(k(i3));
                }
            }
            if ((i2 & 2) != 0) {
                for (int i4 = 0; i4 < p(); i4++) {
                    acroFields.L(l(i4));
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void o(int i2) {
            this.f25844a.remove(i2);
            this.f25845b.remove(i2);
            this.f25846c.remove(i2);
            this.f25847d.remove(i2);
            this.f25848e.remove(i2);
            this.f25849f.remove(i2);
        }

        public int p() {
            return this.f25844a.size();
        }

        public void q(PdfName pdfName, PdfObject pdfObject, int i2) {
            if ((i2 & 1) != 0) {
                for (int i3 = 0; i3 < this.f25847d.size(); i3++) {
                    h(i3).V0(pdfName, pdfObject);
                }
            }
            if ((i2 & 2) != 0) {
                for (int i4 = 0; i4 < this.f25845b.size(); i4++) {
                    l(i4).V0(pdfName, pdfObject);
                }
            }
            if ((i2 & 4) != 0) {
                for (int i5 = 0; i5 < this.f25844a.size(); i5++) {
                    k(i5).V0(pdfName, pdfObject);
                }
            }
        }
    }

    private static class SorterComparator implements Comparator<Object[]> {
        private SorterComparator() {
        }

        /* renamed from: a */
        public int compare(Object[] objArr, Object[] objArr2) {
            return objArr[1][0] - objArr2[1][0];
        }
    }

    static {
        HashMap<String, String[]> hashMap = new HashMap<>();
        C = hashMap;
        hashMap.put("CoBO", new String[]{"Courier-BoldOblique"});
        hashMap.put("CoBo", new String[]{"Courier-Bold"});
        hashMap.put("CoOb", new String[]{"Courier-Oblique"});
        hashMap.put("Cour", new String[]{"Courier"});
        hashMap.put("HeBO", new String[]{"Helvetica-BoldOblique"});
        hashMap.put("HeBo", new String[]{"Helvetica-Bold"});
        hashMap.put("HeOb", new String[]{"Helvetica-Oblique"});
        hashMap.put("Helv", new String[]{"Helvetica"});
        hashMap.put("Symb", new String[]{"Symbol"});
        hashMap.put("TiBI", new String[]{"Times-BoldItalic"});
        hashMap.put("TiBo", new String[]{"Times-Bold"});
        hashMap.put("TiIt", new String[]{"Times-Italic"});
        hashMap.put("TiRo", new String[]{"Times-Roman"});
        hashMap.put("ZaDb", new String[]{"ZapfDingbats"});
        hashMap.put("HySm", new String[]{"HYSMyeongJo-Medium", "UniKS-UCS2-H"});
        hashMap.put("HyGo", new String[]{"HYGoThic-Medium", "UniKS-UCS2-H"});
        hashMap.put("KaGo", new String[]{"HeiseiKakuGo-W5", "UniKS-UCS2-H"});
        hashMap.put("KaMi", new String[]{"HeiseiMin-W3", "UniJIS-UCS2-H"});
        hashMap.put("MHei", new String[]{"MHei-Medium", "UniCNS-UCS2-H"});
        hashMap.put("MSun", new String[]{"MSung-Light", "UniCNS-UCS2-H"});
        hashMap.put("STSo", new String[]{"STSong-Light", "UniGB-UCS2-H"});
    }

    AcroFields(PdfReader pdfReader, PdfWriter pdfWriter) {
        this.f25824a = pdfReader;
        this.f25825b = pdfWriter;
        try {
            this.f25831h = new XfaForm(pdfReader);
            if (pdfWriter instanceof PdfStamperImp) {
                this.f25829f = ((PdfStamperImp) pdfWriter).u3();
            }
            i();
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* access modifiers changed from: private */
    public void L(PdfObject pdfObject) {
        if (this.f25829f) {
            ((PdfStamperImp) this.f25825b).z3(pdfObject);
        }
    }

    private int R(PdfArray pdfArray, PdfObject pdfObject) {
        if (pdfObject == null || !pdfObject.C()) {
            return pdfArray.size();
        }
        PdfIndirectReference pdfIndirectReference = (PdfIndirectReference) pdfObject;
        int i2 = 0;
        while (i2 < pdfArray.size()) {
            PdfObject T0 = pdfArray.T0(i2);
            if (T0.C() && ((PdfIndirectReference) T0).d() == pdfIndirectReference.d()) {
                pdfArray.U0(i2);
                i2--;
            }
            i2++;
        }
        return pdfArray.size();
    }

    private static void c(PdfDictionary pdfDictionary) {
        pdfDictionary.a1(PdfName.S3);
        pdfDictionary.a1(PdfName.Z3);
        pdfDictionary.a1(PdfName.kh);
        pdfDictionary.a1(PdfName.a7);
        pdfDictionary.a1(PdfName.Ff);
        pdfDictionary.a1(PdfName.L7);
        pdfDictionary.V0(PdfName.F7, new PdfNumber(4));
    }

    public static Object[] m0(String str) {
        try {
            PRTokeniser pRTokeniser = new PRTokeniser(new RandomAccessFileOrArray(new RandomAccessSourceFactory().j(PdfEncodings.c(str, (String) null))));
            ArrayList arrayList = new ArrayList();
            Object[] objArr = new Object[3];
            while (pRTokeniser.x()) {
                if (pRTokeniser.o() != PRTokeniser.TokenType.COMMENT) {
                    if (pRTokeniser.o() == PRTokeniser.TokenType.OTHER) {
                        String n2 = pRTokeniser.n();
                        if (n2.equals("Tf")) {
                            if (arrayList.size() >= 2) {
                                objArr[0] = arrayList.get(arrayList.size() - 2);
                                objArr[1] = new Float((String) arrayList.get(arrayList.size() - 1));
                            }
                        } else if (n2.equals("g")) {
                            if (arrayList.size() >= 1) {
                                float floatValue = new Float((String) arrayList.get(arrayList.size() - 1)).floatValue();
                                if (floatValue != 0.0f) {
                                    objArr[2] = new GrayColor(floatValue);
                                }
                            }
                        } else if (n2.equals("rg")) {
                            if (arrayList.size() >= 3) {
                                objArr[2] = new BaseColor(new Float((String) arrayList.get(arrayList.size() - 3)).floatValue(), new Float((String) arrayList.get(arrayList.size() - 2)).floatValue(), new Float((String) arrayList.get(arrayList.size() - 1)).floatValue());
                            }
                        } else if (n2.equals("k") && arrayList.size() >= 4) {
                            objArr[2] = new CMYKColor(new Float((String) arrayList.get(arrayList.size() - 4)).floatValue(), new Float((String) arrayList.get(arrayList.size() - 3)).floatValue(), new Float((String) arrayList.get(arrayList.size() - 2)).floatValue(), new Float((String) arrayList.get(arrayList.size() - 1)).floatValue());
                        }
                        arrayList.clear();
                    } else {
                        arrayList.add(pRTokeniser.n());
                    }
                }
            }
            return objArr;
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e A[SYNTHETIC, Splitter:B:25:0x004e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void n0(com.itextpdf.text.pdf.security.PdfPKCS7 r5, com.itextpdf.text.pdf.PdfDictionary r6) {
        /*
            r4 = this;
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.J4
            com.itextpdf.text.pdf.PdfArray r6 = r6.e0(r0)
            com.itextpdf.text.pdf.PdfReader r0 = r4.f25824a
            com.itextpdf.text.pdf.RandomAccessFileOrArray r0 = r0.B0()
            r1 = 0
            com.itextpdf.text.io.RASInputStream r2 = new com.itextpdf.text.io.RASInputStream     // Catch:{ Exception -> 0x0045 }
            com.itextpdf.text.io.RandomAccessSourceFactory r3 = new com.itextpdf.text.io.RandomAccessSourceFactory     // Catch:{ Exception -> 0x0045 }
            r3.<init>()     // Catch:{ Exception -> 0x0045 }
            com.itextpdf.text.io.RandomAccessSource r0 = r0.a()     // Catch:{ Exception -> 0x0045 }
            long[] r6 = r6.m0()     // Catch:{ Exception -> 0x0045 }
            com.itextpdf.text.io.RandomAccessSource r6 = r3.f(r0, r6)     // Catch:{ Exception -> 0x0045 }
            r2.<init>(r6)     // Catch:{ Exception -> 0x0045 }
            r6 = 8192(0x2000, float:1.14794E-41)
            byte[] r0 = new byte[r6]     // Catch:{ Exception -> 0x0035, all -> 0x0032 }
        L_0x0027:
            r1 = 0
            int r3 = r2.read(r0, r1, r6)     // Catch:{ Exception -> 0x0035, all -> 0x0032 }
            if (r3 <= 0) goto L_0x0038
            r5.M(r0, r1, r3)     // Catch:{ Exception -> 0x0035, all -> 0x0032 }
            goto L_0x0027
        L_0x0032:
            r5 = move-exception
            r1 = r2
            goto L_0x004c
        L_0x0035:
            r5 = move-exception
            r1 = r2
            goto L_0x0046
        L_0x0038:
            r2.close()     // Catch:{ IOException -> 0x003c }
            return
        L_0x003c:
            r5 = move-exception
            com.itextpdf.text.ExceptionConverter r6 = new com.itextpdf.text.ExceptionConverter
            r6.<init>(r5)
            throw r6
        L_0x0043:
            r5 = move-exception
            goto L_0x004c
        L_0x0045:
            r5 = move-exception
        L_0x0046:
            com.itextpdf.text.ExceptionConverter r6 = new com.itextpdf.text.ExceptionConverter     // Catch:{ all -> 0x0043 }
            r6.<init>(r5)     // Catch:{ all -> 0x0043 }
            throw r6     // Catch:{ all -> 0x0043 }
        L_0x004c:
            if (r1 == 0) goto L_0x0059
            r1.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0059
        L_0x0052:
            r5 = move-exception
            com.itextpdf.text.ExceptionConverter r6 = new com.itextpdf.text.ExceptionConverter
            r6.<init>(r5)
            throw r6
        L_0x0059:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.AcroFields.n0(com.itextpdf.text.pdf.security.PdfPKCS7, com.itextpdf.text.pdf.PdfDictionary):void");
    }

    private String[] u(String str, int i2) {
        Item p2 = p(str);
        if (p2 == null) {
            return null;
        }
        PdfArray e0 = p2.h(0).e0(PdfName.hc);
        if (e0 == null) {
            return null;
        }
        String[] strArr = new String[e0.size()];
        for (int i3 = 0; i3 < e0.size(); i3++) {
            PdfObject Q0 = e0.Q0(i3);
            try {
                if (Q0.q()) {
                    Q0 = ((PdfArray) Q0).Q0(i2);
                }
                if (Q0.N()) {
                    strArr[i3] = ((PdfString) Q0).m0();
                } else {
                    strArr[i3] = Q0.toString();
                }
            } catch (Exception unused) {
                strArr[i3] = "";
            }
        }
        return strArr;
    }

    public PushbuttonField A(String str, int i2) {
        try {
            if (s(str) != 1) {
                return null;
            }
            Item p2 = p(str);
            if (i2 >= p2.p()) {
                return null;
            }
            PushbuttonField pushbuttonField = new PushbuttonField(this.f25825b, q(str).get(i2).f25839b, (String) null);
            PdfDictionary h2 = p2.h(i2);
            e(h2, pushbuttonField);
            PdfDictionary j0 = h2.j0(PdfName.gb);
            if (j0 != null) {
                PdfString A0 = j0.A0(PdfName.N4);
                if (A0 != null) {
                    pushbuttonField.K(A0.m0());
                }
                PdfNumber q0 = j0.q0(PdfName.qg);
                if (q0 != null) {
                    pushbuttonField.g0(q0.e0() + 1);
                }
                PdfDictionary j02 = j0.j0(PdfName.D9);
                if (j02 != null) {
                    PdfName p0 = j02.p0(PdfName.Gf);
                    if (p0 != null) {
                        pushbuttonField.i0(p0.equals(PdfName.h4) ? 3 : p0.equals(PdfName.Ce) ? 4 : p0.equals(PdfName.kb) ? 2 : 1);
                    }
                    PdfName p02 = j02.p0(PdfName.Ce);
                    if (p02 != null && p02.equals(PdfName.k3)) {
                        pushbuttonField.h0(false);
                    }
                    PdfArray e0 = j02.e0(PdfName.k3);
                    if (e0 != null && e0.size() == 2) {
                        float a0 = e0.J0(0).a0();
                        float a02 = e0.J0(1).a0();
                        pushbuttonField.c0(a0);
                        pushbuttonField.e0(a02);
                    }
                    PdfBoolean i0 = j02.i0(PdfName.H7);
                    if (i0 != null && i0.Z()) {
                        pushbuttonField.b0(true);
                    }
                }
                PdfObject d0 = j0.d0(PdfName.x9);
                if (d0 != null && d0.C()) {
                    pushbuttonField.d0((PRIndirectReference) d0);
                }
            }
            return pushbuttonField;
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public PdfIndirectReference B(String str) {
        PdfDictionary j0;
        PdfIndirectReference m0;
        E();
        Item item = this.f25826c.get(H(str));
        if (item == null || (j0 = item.h(0).j0(PdfName.S3)) == null || (m0 = j0.m0(PdfName.kb)) == null) {
            return null;
        }
        return m0;
    }

    public int C(String str) {
        E();
        String H = H(str);
        if (!this.f25828e.containsKey(H)) {
            return 0;
        }
        return this.f25828e.get(H)[1];
    }

    public PdfDictionary D(String str) {
        E();
        String H = H(str);
        if (!this.f25828e.containsKey(H)) {
            return null;
        }
        return this.f25826c.get(H).h(0).j0(PdfName.kh);
    }

    public ArrayList<String> E() {
        PdfDictionary j0;
        PdfArray e0;
        int size;
        if (this.f25828e != null) {
            return new ArrayList<>(this.o);
        }
        this.f25828e = new HashMap<>();
        this.o = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.f25826c.entrySet()) {
            PdfDictionary h2 = ((Item) next.getValue()).h(0);
            if (!(!PdfName.Pe.equals(h2.d0(PdfName.C8)) || (j0 = h2.j0(PdfName.kh)) == null || j0.A0(PdfName.N5) == null || (e0 = j0.e0(PdfName.J4)) == null || (size = e0.size()) < 2)) {
                arrayList.add(new Object[]{next.getKey(), new int[]{e0.J0(size - 1).e0() + e0.J0(size - 2).e0(), 0}});
            }
        }
        Collections.sort(arrayList, new SorterComparator());
        if (!arrayList.isEmpty()) {
            this.p = ((long) ((int[]) ((Object[]) arrayList.get(arrayList.size() - 1))[1])[0]) == this.f25824a.N() ? arrayList.size() : arrayList.size() + 1;
            int i2 = 0;
            while (i2 < arrayList.size()) {
                Object[] objArr = (Object[]) arrayList.get(i2);
                String str = (String) objArr[0];
                int[] iArr = (int[]) objArr[1];
                i2++;
                iArr[1] = i2;
                this.f25828e.put(str, iArr);
                this.o.add(str);
            }
        }
        return new ArrayList<>(this.o);
    }

    public ArrayList<BaseFont> F() {
        return this.f25837n;
    }

    public int G() {
        E();
        return this.p;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r1.f25831h.n(r2, r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String H(java.lang.String r2) {
        /*
            r1 = this;
            com.itextpdf.text.pdf.XfaForm r0 = r1.f25831h
            boolean r0 = r0.z()
            if (r0 == 0) goto L_0x0011
            com.itextpdf.text.pdf.XfaForm r0 = r1.f25831h
            java.lang.String r0 = r0.n(r2, r1)
            if (r0 == 0) goto L_0x0011
            r2 = r0
        L_0x0011:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.AcroFields.H(java.lang.String):java.lang.String");
    }

    public XfaForm I() {
        return this.f25831h;
    }

    public boolean J() {
        return this.f25833j;
    }

    /* access modifiers changed from: package-private */
    public boolean K(PdfDictionary pdfDictionary, PdfName pdfName) {
        return (pdfDictionary == null || pdfDictionary.d0(pdfName) == null) ? false : true;
    }

    public void M(Node node) throws IOException, DocumentException {
        XfaForm.Xml2SomDatasets xml2SomDatasets = new XfaForm.Xml2SomDatasets(node);
        Iterator<String> it2 = xml2SomDatasets.d().iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            X(next, XfaForm.t(xml2SomDatasets.c().get(next)));
        }
    }

    public boolean N(String str) throws IOException, DocumentException {
        String n2 = n(str);
        return Y(str, n2, n2);
    }

    public boolean O(String str) {
        return P(str, -1);
    }

    public boolean P(String str, int i2) {
        PdfDictionary pdfDictionary;
        PdfArray e0;
        PdfIndirectReference m0;
        Item p2 = p(str);
        int i3 = 0;
        if (p2 == null || (pdfDictionary = (PdfDictionary) PdfReader.u0(this.f25824a.F().d0(PdfName.p3), this.f25824a.F())) == null || (e0 = pdfDictionary.e0(PdfName.P7)) == null) {
            return false;
        }
        while (i3 < p2.p()) {
            int intValue = p2.i(i3).intValue();
            if (i2 == -1 || i2 == intValue) {
                PdfIndirectReference m2 = p2.m(i3);
                PdfDictionary l2 = p2.l(i3);
                PdfDictionary h0 = this.f25824a.h0(intValue);
                PdfName pdfName = PdfName.Q3;
                PdfArray e02 = h0.e0(pdfName);
                if (e02 != null) {
                    if (R(e02, m2) == 0) {
                        h0.a1(pdfName);
                        L(h0);
                    } else {
                        L(e02);
                    }
                }
                PdfReader.W0(m2);
                while (true) {
                    PdfName pdfName2 = PdfName.Dc;
                    m0 = l2.m0(pdfName2);
                    if (m0 == null) {
                        break;
                    }
                    l2 = l2.j0(pdfName2);
                    if (R(l2.e0(PdfName.ia), m2) != 0) {
                        break;
                    }
                    PdfReader.W0(m0);
                    m2 = m0;
                }
                if (m0 == null) {
                    R(e0, m2);
                    L(e0);
                }
                if (i2 != -1) {
                    p2.o(i3);
                    i3--;
                }
            }
            i3++;
        }
        if (i2 == -1 || p2.p() == 0) {
            this.f25826c.remove(str);
        }
        return true;
    }

    public boolean Q(int i2) {
        if (i2 < 1) {
            return false;
        }
        int size = this.f25826c.size();
        String[] strArr = new String[size];
        this.f25826c.keySet().toArray(strArr);
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            z2 = z2 || P(strArr[i3], i2);
        }
        return z2;
    }

    public void S() {
        this.f25824a.F().j0(PdfName.p3).a1(PdfName.Yh);
        try {
            this.f25831h = new XfaForm(this.f25824a);
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public boolean T(String str, String str2) {
        Item item;
        int lastIndexOf = str.lastIndexOf(46) + 1;
        int lastIndexOf2 = str2.lastIndexOf(46) + 1;
        if (lastIndexOf != lastIndexOf2 || !str.substring(0, lastIndexOf).equals(str2.substring(0, lastIndexOf2)) || this.f25826c.containsKey(str2) || (item = this.f25826c.get(str)) == null) {
            return false;
        }
        String substring = str2.substring(lastIndexOf2);
        item.q(PdfName.If, new PdfString(substring, PdfObject.h3), 5);
        item.n(this, 4);
        this.f25826c.remove(str);
        this.f25826c.put(substring, item);
        return true;
    }

    public boolean U(String str, PdfFormField pdfFormField) {
        return V(str, pdfFormField, 0);
    }

    public boolean V(String str, PdfFormField pdfFormField, int i2) {
        int i3 = 0;
        if (s(str) != 1) {
            return false;
        }
        Item p2 = p(str);
        if (i2 >= p2.p()) {
            return false;
        }
        PdfDictionary h2 = p2.h(i2);
        PdfDictionary k2 = p2.k(i2);
        PdfDictionary l2 = p2.l(i2);
        while (true) {
            PdfName[] pdfNameArr = D;
            if (i3 >= pdfNameArr.length) {
                break;
            }
            h2.a1(pdfNameArr[i3]);
            k2.a1(pdfNameArr[i3]);
            l2.a1(pdfNameArr[i3]);
            i3++;
        }
        for (PdfName next : pdfFormField.G0()) {
            if (!next.equals(PdfName.If)) {
                if (next.equals(PdfName.L7)) {
                    k2.V0(next, pdfFormField.d0(next));
                } else {
                    l2.V0(next, pdfFormField.d0(next));
                }
                h2.V0(next, pdfFormField.d0(next));
                L(k2);
                L(l2);
            }
        }
        return true;
    }

    public void W(float f2, float f3) {
        this.f25835l = f2;
        this.f25836m = f3;
    }

    public boolean X(String str, String str2) throws IOException, DocumentException {
        return Y(str, str2, (String) null);
    }

    public boolean Y(String str, String str2, String str3) throws IOException, DocumentException {
        return Z(str, str2, str3, false);
    }

    public boolean Z(String str, String str2, String str3, boolean z2) throws IOException, DocumentException {
        if (this.f25825b != null) {
            if (this.f25831h.z()) {
                str = this.f25831h.n(str, this);
                if (str == null) {
                    return false;
                }
                String e2 = XfaForm.Xml2Som.e(str);
                Node m2 = this.f25831h.m(e2);
                if (m2 == null) {
                    m2 = this.f25831h.q().p(this.f25831h.p(), e2);
                }
                this.f25831h.F(m2, str2);
            }
            Item item = this.f25826c.get(str);
            if (item == null) {
                return false;
            }
            PdfDictionary h2 = item.h(0);
            PdfName p0 = h2.p0(PdfName.C8);
            PdfName pdfName = PdfName.Jg;
            if (pdfName.equals(p0)) {
                PdfNumber q0 = h2.q0(PdfName.Ya);
                int e0 = q0 != null ? q0.e0() : 0;
                if (e0 > 0) {
                    str2 = str2.substring(0, Math.min(e0, str2.length()));
                }
            }
            if (str3 == null) {
                str3 = str2;
            }
            if (pdfName.equals(p0) || PdfName.e5.equals(p0)) {
                PdfString pdfString = new PdfString(str2, PdfObject.h3);
                for (int i2 = 0; i2 < item.p(); i2++) {
                    PdfDictionary k2 = item.k(i2);
                    PdfName pdfName2 = PdfName.kh;
                    k2.V0(pdfName2, pdfString);
                    PdfName pdfName3 = PdfName.x9;
                    k2.a1(pdfName3);
                    L(k2);
                    PdfDictionary h3 = item.h(i2);
                    h3.a1(pdfName3);
                    h3.V0(pdfName2, pdfString);
                    PdfDictionary l2 = item.l(i2);
                    if (this.f25833j) {
                        PdfAppearance j2 = j(h3, str3, str);
                        if (PdfName.e5.equals(p0)) {
                            PdfNumber pdfNumber = new PdfNumber(this.f25827d);
                            PdfName pdfName4 = PdfName.bg;
                            l2.V0(pdfName4, pdfNumber);
                            h3.V0(pdfName4, pdfNumber);
                        }
                        PdfName pdfName5 = PdfName.S3;
                        PdfDictionary j0 = l2.j0(pdfName5);
                        if (j0 == null) {
                            j0 = new PdfDictionary();
                            l2.V0(pdfName5, j0);
                            h3.V0(pdfName5, j0);
                        }
                        j0.V0(PdfName.kb, j2.J3());
                        this.f25825b.d2(j2);
                    } else {
                        PdfName pdfName6 = PdfName.S3;
                        l2.a1(pdfName6);
                        h3.a1(pdfName6);
                    }
                    L(l2);
                }
                return true;
            } else if (!PdfName.I4.equals(p0)) {
                return false;
            } else {
                PdfNumber q02 = item.h(0).q0(PdfName.L7);
                if (((q02 != null ? q02.e0() : 0) & 65536) != 0) {
                    try {
                        Image f1 = Image.f1(Base64.f(str2));
                        PushbuttonField z3 = z(str);
                        z3.f0(f1);
                        U(str, z3.R());
                        return true;
                    } catch (Exception unused) {
                        return false;
                    }
                } else {
                    PdfName pdfName7 = new PdfName(str2);
                    ArrayList arrayList = new ArrayList();
                    PdfArray e02 = item.k(0).e0(PdfName.hc);
                    if (e02 != null) {
                        for (int i3 = 0; i3 < e02.size(); i3++) {
                            PdfString P0 = e02.P0(i3);
                            arrayList.add(P0 != null ? P0.m0() : null);
                        }
                    }
                    int indexOf = arrayList.indexOf(str2);
                    if (indexOf >= 0) {
                        pdfName7 = new PdfName(String.valueOf(indexOf));
                    }
                    for (int i4 = 0; i4 < item.p(); i4++) {
                        PdfDictionary h4 = item.h(i4);
                        PdfDictionary l3 = item.l(i4);
                        PdfDictionary k3 = item.k(i4);
                        L(item.k(i4));
                        PdfName pdfName8 = PdfName.kh;
                        k3.V0(pdfName8, pdfName7);
                        h4.V0(pdfName8, pdfName7);
                        L(l3);
                        PdfDictionary j02 = l3.j0(PdfName.S3);
                        if (j02 == null) {
                            return false;
                        }
                        PdfName pdfName9 = PdfName.kb;
                        PdfDictionary j03 = j02.j0(pdfName9);
                        if (K(j03, pdfName7) || j03 == null) {
                            PdfName pdfName10 = PdfName.Z3;
                            h4.V0(pdfName10, pdfName7);
                            l3.V0(pdfName10, pdfName7);
                        } else {
                            PdfName pdfName11 = PdfName.Z3;
                            PdfName pdfName12 = PdfName.Xb;
                            h4.V0(pdfName11, pdfName12);
                            l3.V0(pdfName11, pdfName12);
                        }
                        if (this.f25833j && !z2) {
                            PdfAppearance j3 = j(h4, str3, str);
                            if (j03 != null) {
                                j03.V0(h4.p0(PdfName.Z3), j3.J3());
                            } else {
                                j02.V0(pdfName9, j3.J3());
                            }
                            this.f25825b.d2(j3);
                        }
                    }
                    return true;
                }
            }
        } else {
            throw new DocumentException(MessageLocalization.b("this.acrofields.instance.is.read.only", new Object[0]));
        }
    }

    public boolean a0(String str, String str2, boolean z2) throws IOException, DocumentException {
        return Z(str, str2, (String) null, z2);
    }

    public void b(BaseFont baseFont) {
        if (this.f25837n == null) {
            this.f25837n = new ArrayList<>();
        }
        this.f25837n.add(baseFont);
    }

    public void b0(Map<String, TextField> map) {
        this.q = map;
    }

    public boolean c0(String str, String str2, int i2, int[] iArr) {
        int i3 = 0;
        if (this.f25825b != null) {
            Item item = this.f25826c.get(str);
            if (item == null) {
                return false;
            }
            InstHit instHit = new InstHit(iArr);
            if (str2.equalsIgnoreCase("flags")) {
                PdfNumber pdfNumber = new PdfNumber(i2);
                while (i3 < item.p()) {
                    if (instHit.a(i3)) {
                        PdfDictionary h2 = item.h(i3);
                        PdfName pdfName = PdfName.F7;
                        h2.V0(pdfName, pdfNumber);
                        item.l(i3).V0(pdfName, pdfNumber);
                        L(item.l(i3));
                    }
                    i3++;
                }
                return true;
            } else if (str2.equalsIgnoreCase("setflags")) {
                for (int i4 = 0; i4 < item.p(); i4++) {
                    if (instHit.a(i4)) {
                        PdfDictionary l2 = item.l(i4);
                        PdfName pdfName2 = PdfName.F7;
                        PdfNumber q0 = l2.q0(pdfName2);
                        PdfNumber pdfNumber2 = new PdfNumber((q0 != null ? q0.e0() : 0) | i2);
                        item.h(i4).V0(pdfName2, pdfNumber2);
                        item.l(i4).V0(pdfName2, pdfNumber2);
                        L(item.l(i4));
                    }
                }
                return true;
            } else if (str2.equalsIgnoreCase("clrflags")) {
                for (int i5 = 0; i5 < item.p(); i5++) {
                    if (instHit.a(i5)) {
                        PdfDictionary l3 = item.l(i5);
                        PdfName pdfName3 = PdfName.F7;
                        PdfNumber q02 = l3.q0(pdfName3);
                        PdfNumber pdfNumber3 = new PdfNumber((q02 != null ? q02.e0() : 0) & (~i2));
                        item.h(i5).V0(pdfName3, pdfNumber3);
                        l3.V0(pdfName3, pdfNumber3);
                        L(l3);
                    }
                }
                return true;
            } else if (str2.equalsIgnoreCase("fflags")) {
                PdfNumber pdfNumber4 = new PdfNumber(i2);
                while (i3 < item.p()) {
                    if (instHit.a(i3)) {
                        PdfDictionary h3 = item.h(i3);
                        PdfName pdfName4 = PdfName.L7;
                        h3.V0(pdfName4, pdfNumber4);
                        item.k(i3).V0(pdfName4, pdfNumber4);
                        L(item.k(i3));
                    }
                    i3++;
                }
                return true;
            } else if (str2.equalsIgnoreCase("setfflags")) {
                for (int i6 = 0; i6 < item.p(); i6++) {
                    if (instHit.a(i6)) {
                        PdfDictionary k2 = item.k(i6);
                        PdfName pdfName5 = PdfName.L7;
                        PdfNumber q03 = k2.q0(pdfName5);
                        PdfNumber pdfNumber5 = new PdfNumber((q03 != null ? q03.e0() : 0) | i2);
                        item.h(i6).V0(pdfName5, pdfNumber5);
                        k2.V0(pdfName5, pdfNumber5);
                        L(k2);
                    }
                }
                return true;
            } else if (!str2.equalsIgnoreCase("clrfflags")) {
                return false;
            } else {
                for (int i7 = 0; i7 < item.p(); i7++) {
                    if (instHit.a(i7)) {
                        PdfDictionary k3 = item.k(i7);
                        PdfName pdfName6 = PdfName.L7;
                        PdfNumber q04 = k3.q0(pdfName6);
                        PdfNumber pdfNumber6 = new PdfNumber((q04 != null ? q04.e0() : 0) & (~i2));
                        item.h(i7).V0(pdfName6, pdfNumber6);
                        k3.V0(pdfName6, pdfNumber6);
                        L(k3);
                    }
                }
                return true;
            }
        } else {
            throw new RuntimeException(MessageLocalization.b("this.acrofields.instance.is.read.only", new Object[0]));
        }
    }

    public boolean d(String str) {
        this.f25828e = null;
        E();
        if (!this.f25828e.containsKey(str)) {
            return false;
        }
        Item item = this.f25826c.get(str);
        item.n(this, 6);
        int p2 = item.p();
        for (int i2 = 0; i2 < p2; i2++) {
            c(item.h(i2));
            c(item.l(i2));
            c(item.k(i2));
        }
        return true;
    }

    public boolean d0(String str, String str2, Object obj, int[] iArr) {
        PdfName pdfName;
        PdfString A0;
        PdfName pdfName2;
        PdfString A02;
        PdfDictionary pdfDictionary;
        FontDetails fontDetails;
        String str3 = str2;
        char c2 = 0;
        if (this.f25825b != null) {
            try {
                Item item = this.f25826c.get(str);
                if (item == null) {
                    return false;
                }
                InstHit instHit = new InstHit(iArr);
                if (str3.equalsIgnoreCase("textfont")) {
                    int i2 = 0;
                    while (i2 < item.p()) {
                        if (instHit.a(i2)) {
                            PdfDictionary h2 = item.h(i2);
                            PdfName pdfName3 = PdfName.g6;
                            PdfString A03 = h2.A0(pdfName3);
                            PdfName pdfName4 = PdfName.T6;
                            PdfDictionary j0 = h2.j0(pdfName4);
                            if (A03 != null) {
                                if (j0 == null) {
                                    j0 = new PdfDictionary();
                                    h2.V0(pdfName4, j0);
                                }
                                Object[] m0 = m0(A03.m0());
                                PdfAppearance pdfAppearance = new PdfAppearance();
                                if (m0[c2] != null) {
                                    BaseFont baseFont = (BaseFont) obj;
                                    PdfName pdfName5 = PdfAppearance.O3.get(baseFont.P());
                                    if (pdfName5 == null) {
                                        pdfName5 = new PdfName(baseFont.P());
                                    }
                                    PdfName pdfName6 = PdfName.l8;
                                    PdfDictionary j02 = j0.j0(pdfName6);
                                    if (j02 == null) {
                                        pdfDictionary = new PdfDictionary();
                                        j0.V0(pdfName6, pdfDictionary);
                                    } else {
                                        pdfDictionary = j02;
                                    }
                                    PdfIndirectReference pdfIndirectReference = (PdfIndirectReference) pdfDictionary.d0(pdfName5);
                                    PdfDictionary j03 = this.f25824a.F().j0(PdfName.p3);
                                    L(j03);
                                    PdfDictionary j04 = j03.j0(pdfName4);
                                    if (j04 == null) {
                                        j04 = new PdfDictionary();
                                        j03.V0(pdfName4, j04);
                                    }
                                    L(j04);
                                    PdfDictionary j05 = j04.j0(pdfName6);
                                    if (j05 == null) {
                                        j05 = new PdfDictionary();
                                        j04.V0(pdfName6, j05);
                                    }
                                    L(j05);
                                    PdfIndirectReference pdfIndirectReference2 = (PdfIndirectReference) j05.d0(pdfName5);
                                    if (pdfIndirectReference2 != null) {
                                        if (pdfIndirectReference == null) {
                                            pdfDictionary.V0(pdfName5, pdfIndirectReference2);
                                        }
                                    } else if (pdfIndirectReference == null) {
                                        if (baseFont.K() == 4) {
                                            fontDetails = new FontDetails((PdfName) null, ((DocumentFont) baseFont).F0(), baseFont);
                                        } else {
                                            baseFont.s0(false);
                                            fontDetails = this.f25825b.o0(baseFont);
                                            this.f25834k.put(pdfName5.toString().substring(1), baseFont);
                                        }
                                        j05.V0(pdfName5, fontDetails.h());
                                        pdfDictionary.V0(pdfName5, fontDetails.h());
                                    }
                                    pdfAppearance.a1().n(pdfName5.k()).c(' ').e(((Float) m0[1]).floatValue()).k(" Tf ");
                                    Object obj2 = m0[2];
                                    if (obj2 != null) {
                                        pdfAppearance.h2((BaseColor) obj2);
                                    }
                                    PdfString pdfString = new PdfString(pdfAppearance.toString());
                                    item.h(i2).V0(pdfName3, pdfString);
                                    item.l(i2).V0(pdfName3, pdfString);
                                    L(item.l(i2));
                                }
                            }
                        }
                        i2++;
                        c2 = 0;
                    }
                } else if (str3.equalsIgnoreCase("textcolor")) {
                    for (int i3 = 0; i3 < item.p(); i3++) {
                        if (instHit.a(i3) && (A02 = item.h(i3).A0(pdfName2)) != null) {
                            Object[] m02 = m0(A02.m0());
                            PdfAppearance pdfAppearance2 = new PdfAppearance();
                            if (m02[0] != null) {
                                pdfAppearance2.a1().n(new PdfName((String) m02[0]).k()).c(' ').e(((Float) m02[1]).floatValue()).k(" Tf ");
                                pdfAppearance2.h2((BaseColor) obj);
                                PdfString pdfString2 = new PdfString(pdfAppearance2.toString());
                                item.h(i3).V0((pdfName2 = PdfName.g6), pdfString2);
                                item.l(i3).V0(pdfName2, pdfString2);
                                L(item.l(i3));
                            }
                        }
                    }
                } else if (str3.equalsIgnoreCase("textsize")) {
                    for (int i4 = 0; i4 < item.p(); i4++) {
                        if (instHit.a(i4) && (A0 = item.h(i4).A0(pdfName)) != null) {
                            Object[] m03 = m0(A0.m0());
                            PdfAppearance pdfAppearance3 = new PdfAppearance();
                            if (m03[0] != null) {
                                pdfAppearance3.a1().n(new PdfName((String) m03[0]).k()).c(' ').e(((Float) obj).floatValue()).k(" Tf ");
                                Object obj3 = m03[2];
                                if (obj3 != null) {
                                    pdfAppearance3.h2((BaseColor) obj3);
                                }
                                PdfString pdfString3 = new PdfString(pdfAppearance3.toString());
                                item.h(i4).V0((pdfName = PdfName.g6), pdfString3);
                                item.l(i4).V0(pdfName, pdfString3);
                                L(item.l(i4));
                            }
                        }
                    }
                } else {
                    if (!str3.equalsIgnoreCase(HtmlTags.I)) {
                        if (!str3.equalsIgnoreCase("bordercolor")) {
                            return false;
                        }
                    }
                    PdfName pdfName7 = str3.equalsIgnoreCase(HtmlTags.I) ? PdfName.p4 : PdfName.o4;
                    for (int i5 = 0; i5 < item.p(); i5++) {
                        if (instHit.a(i5)) {
                            PdfDictionary h3 = item.h(i5);
                            PdfName pdfName8 = PdfName.gb;
                            PdfDictionary j06 = h3.j0(pdfName8);
                            if (j06 != null) {
                                L(j06);
                            } else if (obj == null) {
                                return true;
                            } else {
                                j06 = new PdfDictionary();
                                item.h(i5).V0(pdfName8, j06);
                                item.l(i5).V0(pdfName8, j06);
                                L(item.l(i5));
                            }
                            if (obj == null) {
                                j06.a1(pdfName7);
                            } else {
                                j06.V0(pdfName7, PdfAnnotation.N1((BaseColor) obj));
                            }
                        }
                    }
                }
                return true;
            } catch (Exception e2) {
                throw new ExceptionConverter(e2);
            }
        } else {
            throw new RuntimeException(MessageLocalization.b("this.acrofields.instance.is.read.only", new Object[0]));
        }
    }

    /* JADX WARNING: type inference failed for: r5v13, types: [com.itextpdf.text.pdf.PdfObject] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(com.itextpdf.text.pdf.PdfDictionary r14, com.itextpdf.text.pdf.BaseField r15) throws java.io.IOException, com.itextpdf.text.DocumentException {
        /*
            r13 = this;
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.g6
            com.itextpdf.text.pdf.PdfString r0 = r14.A0(r0)
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x00ff
            java.lang.String r0 = r0.m0()
            java.lang.Object[] r0 = m0(r0)
            r4 = r0[r2]
            if (r4 == 0) goto L_0x0020
            java.lang.Float r4 = (java.lang.Float) r4
            float r4 = r4.floatValue()
            r15.F(r4)
        L_0x0020:
            r4 = r0[r1]
            if (r4 == 0) goto L_0x0029
            com.itextpdf.text.BaseColor r4 = (com.itextpdf.text.BaseColor) r4
            r15.L(r4)
        L_0x0029:
            r4 = r0[r3]
            if (r4 == 0) goto L_0x00ff
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.T6
            com.itextpdf.text.pdf.PdfDictionary r4 = r14.j0(r4)
            if (r4 == 0) goto L_0x00d0
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.l8
            com.itextpdf.text.pdf.PdfDictionary r5 = r4.j0(r5)
            if (r5 == 0) goto L_0x00d0
            com.itextpdf.text.pdf.PdfName r6 = new com.itextpdf.text.pdf.PdfName
            r7 = r0[r3]
            java.lang.String r7 = (java.lang.String) r7
            r6.<init>((java.lang.String) r7)
            com.itextpdf.text.pdf.PdfObject r5 = r5.d0(r6)
            if (r5 == 0) goto L_0x00d0
            int r6 = r5.W()
            r7 = 10
            if (r6 != r7) goto L_0x00d0
            r0 = r5
            com.itextpdf.text.pdf.PRIndirectReference r0 = (com.itextpdf.text.pdf.PRIndirectReference) r0
            com.itextpdf.text.pdf.DocumentFont r6 = new com.itextpdf.text.pdf.DocumentFont
            com.itextpdf.text.pdf.PdfName r7 = com.itextpdf.text.pdf.PdfName.m7
            com.itextpdf.text.pdf.PdfDictionary r4 = r4.j0(r7)
            r6.<init>(r0, r4)
            r15.E(r6)
            int r0 = r0.d()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.util.HashMap<java.lang.Integer, com.itextpdf.text.pdf.BaseFont> r4 = r13.f25830g
            java.lang.Object r4 = r4.get(r0)
            com.itextpdf.text.pdf.BaseFont r4 = (com.itextpdf.text.pdf.BaseFont) r4
            if (r4 != 0) goto L_0x00c5
            java.util.HashMap<java.lang.Integer, com.itextpdf.text.pdf.BaseFont> r6 = r13.f25830g
            boolean r6 = r6.containsKey(r0)
            if (r6 != 0) goto L_0x00c5
            com.itextpdf.text.pdf.PdfObject r5 = com.itextpdf.text.pdf.PdfReader.t0(r5)
            com.itextpdf.text.pdf.PdfDictionary r5 = (com.itextpdf.text.pdf.PdfDictionary) r5
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.n8
            com.itextpdf.text.pdf.PdfDictionary r5 = r5.j0(r6)
            if (r5 == 0) goto L_0x00c5
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.q8
            com.itextpdf.text.pdf.PdfObject r6 = r5.d0(r6)
            com.itextpdf.text.pdf.PdfObject r6 = com.itextpdf.text.pdf.PdfReader.t0(r6)
            com.itextpdf.text.pdf.PRStream r6 = (com.itextpdf.text.pdf.PRStream) r6
            if (r6 != 0) goto L_0x00a8
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.r8
            com.itextpdf.text.pdf.PdfObject r5 = r5.d0(r6)
            com.itextpdf.text.pdf.PdfObject r5 = com.itextpdf.text.pdf.PdfReader.t0(r5)
            r6 = r5
            com.itextpdf.text.pdf.PRStream r6 = (com.itextpdf.text.pdf.PRStream) r6
        L_0x00a8:
            if (r6 != 0) goto L_0x00b1
            java.util.HashMap<java.lang.Integer, com.itextpdf.text.pdf.BaseFont> r5 = r13.f25830g
            r6 = 0
            r5.put(r0, r6)
            goto L_0x00c5
        L_0x00b1:
            java.lang.String r7 = "font.ttf"
            java.lang.String r8 = "Identity-H"
            byte[] r11 = com.itextpdf.text.pdf.PdfReader.D0(r6)     // Catch:{ Exception -> 0x00c0 }
            r12 = 0
            r9 = 1
            r10 = 0
            com.itextpdf.text.pdf.BaseFont r4 = com.itextpdf.text.pdf.BaseFont.l(r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x00c0 }
        L_0x00c0:
            java.util.HashMap<java.lang.Integer, com.itextpdf.text.pdf.BaseFont> r5 = r13.f25830g
            r5.put(r0, r4)
        L_0x00c5:
            boolean r0 = r15 instanceof com.itextpdf.text.pdf.TextField
            if (r0 == 0) goto L_0x00ff
            r0 = r15
            com.itextpdf.text.pdf.TextField r0 = (com.itextpdf.text.pdf.TextField) r0
            r0.q0(r4)
            goto L_0x00ff
        L_0x00d0:
            java.util.HashMap<java.lang.String, com.itextpdf.text.pdf.BaseFont> r4 = r13.f25834k
            r5 = r0[r3]
            java.lang.Object r4 = r4.get(r5)
            com.itextpdf.text.pdf.BaseFont r4 = (com.itextpdf.text.pdf.BaseFont) r4
            if (r4 != 0) goto L_0x00fc
            java.util.HashMap<java.lang.String, java.lang.String[]> r4 = C
            r0 = r0[r3]
            java.lang.Object r0 = r4.get(r0)
            java.lang.String[] r0 = (java.lang.String[]) r0
            if (r0 == 0) goto L_0x00ff
            java.lang.String r4 = "winansi"
            int r5 = r0.length     // Catch:{ Exception -> 0x00f0 }
            if (r5 <= r2) goto L_0x00f2
            r4 = r0[r2]     // Catch:{ Exception -> 0x00f0 }
            goto L_0x00f2
        L_0x00f0:
            goto L_0x00ff
        L_0x00f2:
            r0 = r0[r3]     // Catch:{ Exception -> 0x00f0 }
            com.itextpdf.text.pdf.BaseFont r0 = com.itextpdf.text.pdf.BaseFont.j(r0, r4, r3)     // Catch:{ Exception -> 0x00f0 }
            r15.E(r0)     // Catch:{ Exception -> 0x00f0 }
            goto L_0x00ff
        L_0x00fc:
            r15.E(r4)
        L_0x00ff:
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.gb
            com.itextpdf.text.pdf.PdfDictionary r0 = r14.j0(r0)
            if (r0 == 0) goto L_0x0137
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.o4
            com.itextpdf.text.pdf.PdfArray r4 = r0.e0(r4)
            com.itextpdf.text.BaseColor r4 = r13.y(r4)
            r15.z(r4)
            if (r4 == 0) goto L_0x011b
            r4 = 1065353216(0x3f800000, float:1.0)
            r15.B(r4)
        L_0x011b:
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.p4
            com.itextpdf.text.pdf.PdfArray r4 = r0.e0(r4)
            com.itextpdf.text.BaseColor r4 = r13.y(r4)
            r15.y(r4)
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.Dd
            com.itextpdf.text.pdf.PdfNumber r0 = r0.q0(r4)
            if (r0 == 0) goto L_0x0137
            int r0 = r0.e0()
            r15.I(r0)
        L_0x0137:
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.F7
            com.itextpdf.text.pdf.PdfNumber r0 = r14.q0(r0)
            r15.M(r1)
            r4 = 3
            if (r0 == 0) goto L_0x0162
            int r0 = r0.e0()
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0153
            r6 = r0 & 2
            if (r6 == 0) goto L_0x0153
            r15.M(r2)
            goto L_0x0162
        L_0x0153:
            if (r5 == 0) goto L_0x015d
            r0 = r0 & 32
            if (r0 == 0) goto L_0x015d
            r15.M(r4)
            goto L_0x0162
        L_0x015d:
            if (r5 == 0) goto L_0x0162
            r15.M(r3)
        L_0x0162:
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.L7
            com.itextpdf.text.pdf.PdfNumber r0 = r14.q0(r0)
            if (r0 == 0) goto L_0x016f
            int r0 = r0.e0()
            goto L_0x0170
        L_0x016f:
            r0 = 0
        L_0x0170:
            r15.H(r0)
            r5 = 16777216(0x1000000, float:2.3509887E-38)
            r0 = r0 & r5
            if (r0 == 0) goto L_0x0187
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.Ya
            com.itextpdf.text.pdf.PdfNumber r0 = r14.q0(r0)
            if (r0 == 0) goto L_0x0184
            int r3 = r0.e0()
        L_0x0184:
            r15.G(r3)
        L_0x0187:
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.Ad
            com.itextpdf.text.pdf.PdfNumber r0 = r14.q0(r0)
            if (r0 == 0) goto L_0x01a2
            int r3 = r0.e0()
            if (r3 != r2) goto L_0x0199
            r15.x(r2)
            goto L_0x01a2
        L_0x0199:
            int r0 = r0.e0()
            if (r0 != r1) goto L_0x01a2
            r15.x(r1)
        L_0x01a2:
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.H4
            com.itextpdf.text.pdf.PdfDictionary r0 = r14.j0(r0)
            r3 = 4
            if (r0 == 0) goto L_0x01ed
            com.itextpdf.text.pdf.PdfName r14 = com.itextpdf.text.pdf.PdfName.Dh
            com.itextpdf.text.pdf.PdfNumber r14 = r0.q0(r14)
            if (r14 == 0) goto L_0x01ba
            float r14 = r14.a0()
            r15.B(r14)
        L_0x01ba:
            com.itextpdf.text.pdf.PdfName r14 = com.itextpdf.text.pdf.PdfName.Ce
            com.itextpdf.text.pdf.PdfName r14 = r0.p0(r14)
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.f6
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x01c9
            goto L_0x020c
        L_0x01c9:
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.h4
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x01d5
            r15.A(r1)
            goto L_0x020f
        L_0x01d5:
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.x9
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x01e1
            r15.A(r4)
            goto L_0x020f
        L_0x01e1:
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.Og
            boolean r14 = r0.equals(r14)
            if (r14 == 0) goto L_0x020f
            r15.A(r3)
            goto L_0x020f
        L_0x01ed:
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.D4
            com.itextpdf.text.pdf.PdfArray r14 = r14.e0(r0)
            if (r14 == 0) goto L_0x020f
            int r0 = r14.size()
            if (r0 < r4) goto L_0x0206
            com.itextpdf.text.pdf.PdfNumber r0 = r14.J0(r1)
            float r0 = r0.a0()
            r15.B(r0)
        L_0x0206:
            int r14 = r14.size()
            if (r14 < r3) goto L_0x020f
        L_0x020c:
            r15.A(r2)
        L_0x020f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.AcroFields.e(com.itextpdf.text.pdf.PdfDictionary, com.itextpdf.text.pdf.BaseField):void");
    }

    public boolean e0(String str, String str2) throws DocumentException, IOException {
        if (this.f25825b != null) {
            Item p2 = p(str);
            if (p2 == null || s(str) != 4) {
                return false;
            }
            PdfNumber q0 = p2.h(0).q0(PdfName.L7);
            if (((q0 != null ? q0.e0() : 0) & 33554432) == 0) {
                return false;
            }
            p2.q(PdfName.Be, new PdfString(str2), 5);
            p2.q(PdfName.kh, new PdfString(XmlToTxt.b(new ByteArrayInputStream(str2.getBytes()))), 5);
            return true;
        }
        throw new DocumentException(MessageLocalization.b("this.acrofields.instance.is.read.only", new Object[0]));
    }

    public boolean f(String str) {
        return m().contains(str) || E().contains(str);
    }

    public void f0(FdfReader fdfReader) throws IOException, DocumentException {
        for (String next : fdfReader.O1().keySet()) {
            String N1 = fdfReader.N1(next);
            if (N1 != null) {
                X(next, N1);
            }
        }
    }

    public void g(FdfWriter fdfWriter) {
        for (Map.Entry next : this.f25826c.entrySet()) {
            String str = (String) next.getKey();
            if (((Item) next.getValue()).h(0).d0(PdfName.kh) != null) {
                String n2 = n(str);
                if (this.f25832i) {
                    fdfWriter.r(str, n2);
                } else {
                    fdfWriter.q(str, n2);
                }
            }
        }
    }

    public void g0(XfdfReader xfdfReader) throws IOException, DocumentException {
        for (String next : xfdfReader.f().keySet()) {
            String c2 = xfdfReader.c(next);
            if (c2 != null) {
                X(next, c2);
            }
            List<String> h2 = xfdfReader.h(next);
            if (h2 != null) {
                j0(c2, (String[]) h2.toArray(new String[h2.size()]));
            }
        }
    }

    public InputStream h(String str) throws IOException {
        E();
        String H = H(str);
        if (!this.f25828e.containsKey(H)) {
            return null;
        }
        return new RASInputStream(new WindowRandomAccessSource(this.f25824a.B0().a(), 0, (long) this.f25828e.get(H)[0]));
    }

    public void h0(boolean z2) {
        this.f25833j = z2;
        PdfDictionary j0 = this.f25824a.F().j0(PdfName.p3);
        if (z2) {
            j0.a1(PdfName.xb);
        } else {
            j0.V0(PdfName.xb, PdfBoolean.j3);
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        this.f25826c = new LinkedHashMap();
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.w0(this.f25824a.F().d0(PdfName.p3));
        if (pdfDictionary != null) {
            PdfBoolean i0 = pdfDictionary.i0(PdfName.xb);
            if (i0 == null || !i0.Z()) {
                h0(true);
            } else {
                h0(false);
            }
            PdfArray pdfArray = (PdfArray) PdfReader.w0(pdfDictionary.d0(PdfName.P7));
            if (pdfArray != null && pdfArray.size() != 0) {
                for (int i2 = 1; i2 <= this.f25824a.c0(); i2++) {
                    PdfDictionary i02 = this.f25824a.i0(i2);
                    PdfArray pdfArray2 = (PdfArray) PdfReader.x0(i02.d0(PdfName.Q3), i02);
                    if (pdfArray2 != null) {
                        for (int i3 = 0; i3 < pdfArray2.size(); i3++) {
                            PdfDictionary B0 = pdfArray2.B0(i3);
                            if (B0 != null && PdfName.Ih.equals(B0.p0(PdfName.Cf))) {
                                PdfDictionary pdfDictionary2 = new PdfDictionary();
                                pdfDictionary2.X0(B0);
                                PdfObject pdfObject = null;
                                String str = "";
                                PdfDictionary pdfDictionary3 = null;
                                for (PdfDictionary pdfDictionary4 = B0; pdfDictionary4 != null; pdfDictionary4 = pdfDictionary4.j0(PdfName.Dc)) {
                                    pdfDictionary2.U0(pdfDictionary4);
                                    PdfString A0 = pdfDictionary4.A0(PdfName.If);
                                    if (A0 != null) {
                                        str = A0.m0() + "." + str;
                                    }
                                    if (pdfObject == null) {
                                        PdfName pdfName = PdfName.kh;
                                        if (pdfDictionary4.d0(pdfName) != null) {
                                            pdfObject = PdfReader.w0(pdfDictionary4.d0(pdfName));
                                        }
                                    }
                                    if (pdfDictionary3 == null && A0 != null) {
                                        PdfName pdfName2 = PdfName.kh;
                                        if (pdfDictionary4.d0(pdfName2) == null && pdfObject != null) {
                                            pdfDictionary4.V0(pdfName2, pdfObject);
                                        }
                                        pdfDictionary3 = pdfDictionary4;
                                    }
                                }
                                if (str.length() > 0) {
                                    str = str.substring(0, str.length() - 1);
                                }
                                Item item = this.f25826c.get(str);
                                if (item == null) {
                                    item = new Item();
                                    this.f25826c.put(str, item);
                                }
                                if (pdfDictionary3 == null) {
                                    item.d(B0);
                                } else {
                                    item.d(pdfDictionary3);
                                }
                                item.e(B0);
                                item.f(pdfArray2.G0(i3));
                                pdfDictionary2.U0(pdfDictionary);
                                item.a(pdfDictionary2);
                                item.b(i2);
                                item.c(i3);
                            } else {
                                PdfReader.q1(pdfArray2.G0(i3));
                            }
                        }
                    }
                }
                PdfNumber q0 = pdfDictionary.q0(PdfName.Re);
                if (q0 != null && (q0.e0() & 1) == 1) {
                    for (int i4 = 0; i4 < pdfArray.size(); i4++) {
                        PdfDictionary B02 = pdfArray.B0(i4);
                        if (B02 == null || !PdfName.Ih.equals(B02.p0(PdfName.Cf))) {
                            PdfReader.q1(pdfArray.G0(i4));
                        } else if (((PdfArray) PdfReader.w0(B02.d0(PdfName.ia))) == null) {
                            PdfDictionary pdfDictionary5 = new PdfDictionary();
                            pdfDictionary5.X0(B02);
                            PdfString A02 = B02.A0(PdfName.If);
                            if (A02 != null) {
                                String m0 = A02.m0();
                                if (!this.f25826c.containsKey(m0)) {
                                    Item item2 = new Item();
                                    this.f25826c.put(m0, item2);
                                    item2.d(pdfDictionary5);
                                    item2.e(pdfDictionary5);
                                    item2.f(pdfArray.G0(i4));
                                    item2.a(pdfDictionary5);
                                    item2.b(-1);
                                    item2.c(-1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean i0(String str, String[] strArr, String[] strArr2) {
        int i2 = 0;
        if (strArr == null && strArr2 == null) {
            return false;
        }
        if (strArr == null || strArr2 == null || strArr.length == strArr2.length) {
            int s2 = s(str);
            if (s2 != 6 && s2 != 5) {
                return false;
            }
            Item item = this.f25826c.get(str);
            String[] strArr3 = (strArr != null || strArr2 == null) ? (strArr == null || strArr2 != null) ? null : strArr : strArr2;
            PdfArray pdfArray = new PdfArray();
            if (strArr3 != null) {
                while (i2 < strArr3.length) {
                    pdfArray.a0(new PdfString(strArr3[i2], PdfObject.h3));
                    i2++;
                }
            } else {
                while (i2 < strArr.length) {
                    PdfArray pdfArray2 = new PdfArray();
                    pdfArray2.a0(new PdfString(strArr[i2], PdfObject.h3));
                    pdfArray2.a0(new PdfString(strArr2[i2], PdfObject.h3));
                    pdfArray.a0(pdfArray2);
                    i2++;
                }
            }
            item.q(PdfName.hc, pdfArray, 5);
            return true;
        }
        throw new IllegalArgumentException(MessageLocalization.b("the.export.and.the.display.array.must.have.the.same.size", new Object[0]));
    }

    /* access modifiers changed from: package-private */
    public PdfAppearance j(PdfDictionary pdfDictionary, String str, String str2) throws IOException, DocumentException {
        return k(pdfDictionary, new String[]{str}, str2);
    }

    public boolean j0(String str, String[] strArr) throws IOException, DocumentException {
        Item p2 = p(str);
        if (p2 == null) {
            return false;
        }
        PdfDictionary h2 = p2.h(0);
        if (!PdfName.e5.equals(h2.p0(PdfName.C8))) {
            return false;
        }
        String[] w2 = w(str);
        PdfArray pdfArray = new PdfArray();
        for (String str2 : strArr) {
            int i2 = 0;
            while (true) {
                if (i2 >= w2.length) {
                    break;
                } else if (w2[i2].equals(str2)) {
                    pdfArray.a0(new PdfNumber(i2));
                    break;
                } else {
                    i2++;
                }
            }
        }
        p2.q(PdfName.x9, pdfArray, 5);
        PdfArray pdfArray2 = new PdfArray();
        for (String pdfString : strArr) {
            pdfArray2.a0(new PdfString(pdfString));
        }
        p2.q(PdfName.kh, pdfArray2, 5);
        PdfAppearance k2 = k(h2, strArr, str);
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.V0(PdfName.kb, k2.J3());
        p2.q(PdfName.S3, pdfDictionary, 3);
        this.f25825b.d2(k2);
        p2.n(this, 6);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v1, types: [int] */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.pdf.PdfAppearance k(com.itextpdf.text.pdf.PdfDictionary r12, java.lang.String[] r13, java.lang.String r14) throws java.io.IOException, com.itextpdf.text.DocumentException {
        /*
            r11 = this;
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.C8
            com.itextpdf.text.pdf.PdfName r0 = r12.p0(r0)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.I4
            boolean r1 = r1.equals(r0)
            r2 = 270(0x10e, float:3.78E-43)
            r3 = 90
            r4 = 0
            r5 = 1
            r6 = 0
            if (r1 == 0) goto L_0x0067
            com.itextpdf.text.pdf.PdfName r13 = com.itextpdf.text.pdf.PdfName.L7
            com.itextpdf.text.pdf.PdfNumber r13 = r12.q0(r13)
            if (r13 == 0) goto L_0x0028
            int r13 = r13.e0()
            r14 = 32768(0x8000, float:4.5918E-41)
            r13 = r13 & r14
            if (r13 == 0) goto L_0x0028
            r6 = 1
        L_0x0028:
            com.itextpdf.text.pdf.RadioCheckField r13 = new com.itextpdf.text.pdf.RadioCheckField
            com.itextpdf.text.pdf.PdfWriter r14 = r11.f25825b
            r13.<init>(r14, r4, r4, r4)
            r11.e(r12, r13)
            com.itextpdf.text.pdf.PdfName r14 = com.itextpdf.text.pdf.PdfName.Nd
            com.itextpdf.text.pdf.PdfArray r14 = r12.e0(r14)
            com.itextpdf.text.Rectangle r14 = com.itextpdf.text.pdf.PdfReader.b0(r14)
            int r0 = r13.r()
            if (r0 == r3) goto L_0x0048
            int r0 = r13.r()
            if (r0 != r2) goto L_0x004c
        L_0x0048:
            com.itextpdf.text.Rectangle r14 = r14.g0()
        L_0x004c:
            r13.C(r14)
            if (r6 != 0) goto L_0x0055
            r14 = 3
            r13.Y(r14)
        L_0x0055:
            com.itextpdf.text.pdf.PdfName r14 = com.itextpdf.text.pdf.PdfName.Z3
            com.itextpdf.text.pdf.PdfName r12 = r12.p0(r14)
            com.itextpdf.text.pdf.PdfName r14 = com.itextpdf.text.pdf.PdfName.Xb
            boolean r12 = r12.equals(r14)
            r12 = r12 ^ r5
            com.itextpdf.text.pdf.PdfAppearance r12 = r13.P(r6, r12)
            return r12
        L_0x0067:
            r11.f25827d = r6
            int r1 = r13.length
            if (r1 <= 0) goto L_0x006f
            r1 = r13[r6]
            goto L_0x0070
        L_0x006f:
            r1 = r4
        L_0x0070:
            java.util.Map<java.lang.String, com.itextpdf.text.pdf.TextField> r7 = r11.q
            if (r7 == 0) goto L_0x0089
            boolean r7 = r7.containsKey(r14)
            if (r7 != 0) goto L_0x007b
            goto L_0x0089
        L_0x007b:
            java.util.Map<java.lang.String, com.itextpdf.text.pdf.TextField> r2 = r11.q
            java.lang.Object r14 = r2.get(r14)
            com.itextpdf.text.pdf.TextField r14 = (com.itextpdf.text.pdf.TextField) r14
            com.itextpdf.text.pdf.PdfWriter r2 = r11.f25825b
            r14.N(r2)
            goto L_0x00c8
        L_0x0089:
            com.itextpdf.text.pdf.TextField r7 = new com.itextpdf.text.pdf.TextField
            com.itextpdf.text.pdf.PdfWriter r8 = r11.f25825b
            r7.<init>(r8, r4, r4)
            float r4 = r11.f25835l
            float r8 = r11.f25836m
            r7.r0(r4, r8)
            r4 = 0
            r7.B(r4)
            java.util.ArrayList<com.itextpdf.text.pdf.BaseFont> r4 = r11.f25837n
            r7.s0(r4)
            r11.e(r12, r7)
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.Nd
            com.itextpdf.text.pdf.PdfArray r4 = r12.e0(r4)
            com.itextpdf.text.Rectangle r4 = com.itextpdf.text.pdf.PdfReader.b0(r4)
            int r8 = r7.r()
            if (r8 == r3) goto L_0x00b9
            int r3 = r7.r()
            if (r3 != r2) goto L_0x00bd
        L_0x00b9:
            com.itextpdf.text.Rectangle r4 = r4.g0()
        L_0x00bd:
            r7.C(r4)
            java.util.Map<java.lang.String, com.itextpdf.text.pdf.TextField> r2 = r11.q
            if (r2 == 0) goto L_0x00c7
            r2.put(r14, r7)
        L_0x00c7:
            r14 = r7
        L_0x00c8:
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.Jg
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00df
            int r12 = r13.length
            if (r12 <= 0) goto L_0x00da
            r12 = r13[r6]
            if (r12 == 0) goto L_0x00da
            r14.K(r12)
        L_0x00da:
            com.itextpdf.text.pdf.PdfAppearance r12 = r14.T()
            return r12
        L_0x00df:
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.e5
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x01a1
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.hc
            com.itextpdf.text.pdf.PdfArray r0 = r12.e0(r0)
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.L7
            com.itextpdf.text.pdf.PdfNumber r12 = r12.q0(r2)
            if (r12 == 0) goto L_0x00fa
            int r12 = r12.e0()
            goto L_0x00fb
        L_0x00fa:
            r12 = 0
        L_0x00fb:
            r2 = 131072(0x20000, float:1.83671E-40)
            r12 = r12 & r2
            if (r12 == 0) goto L_0x010a
            if (r0 != 0) goto L_0x010a
            r14.K(r1)
            com.itextpdf.text.pdf.PdfAppearance r12 = r14.T()
            return r12
        L_0x010a:
            if (r0 == 0) goto L_0x0196
            int r2 = r0.size()
            java.lang.String[] r3 = new java.lang.String[r2]
            int r4 = r0.size()
            java.lang.String[] r7 = new java.lang.String[r4]
            r8 = 0
        L_0x0119:
            int r9 = r0.size()
            if (r8 >= r9) goto L_0x014d
            com.itextpdf.text.pdf.PdfObject r9 = r0.T0(r8)
            boolean r10 = r9.N()
            if (r10 == 0) goto L_0x0134
            com.itextpdf.text.pdf.PdfString r9 = (com.itextpdf.text.pdf.PdfString) r9
            java.lang.String r9 = r9.m0()
            r7[r8] = r9
            r3[r8] = r9
            goto L_0x014a
        L_0x0134:
            com.itextpdf.text.pdf.PdfArray r9 = (com.itextpdf.text.pdf.PdfArray) r9
            com.itextpdf.text.pdf.PdfString r10 = r9.P0(r6)
            java.lang.String r10 = r10.m0()
            r7[r8] = r10
            com.itextpdf.text.pdf.PdfString r9 = r9.P0(r5)
            java.lang.String r9 = r9.m0()
            r3[r8] = r9
        L_0x014a:
            int r8 = r8 + 1
            goto L_0x0119
        L_0x014d:
            if (r12 == 0) goto L_0x0167
        L_0x014f:
            if (r6 >= r2) goto L_0x015f
            r12 = r7[r6]
            boolean r12 = r1.equals(r12)
            if (r12 == 0) goto L_0x015c
            r1 = r3[r6]
            goto L_0x015f
        L_0x015c:
            int r6 = r6 + 1
            goto L_0x014f
        L_0x015f:
            r14.K(r1)
            com.itextpdf.text.pdf.PdfAppearance r12 = r14.T()
            return r12
        L_0x0167:
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            r0 = 0
        L_0x016d:
            if (r0 >= r4) goto L_0x018d
            r1 = 0
        L_0x0170:
            int r2 = r13.length
            if (r1 >= r2) goto L_0x018a
            r2 = r13[r1]
            if (r2 == 0) goto L_0x0187
            r5 = r7[r0]
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0187
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            r12.add(r1)
            goto L_0x018a
        L_0x0187:
            int r1 = r1 + 1
            goto L_0x0170
        L_0x018a:
            int r0 = r0 + 1
            goto L_0x016d
        L_0x018d:
            r14.o0(r3)
            r14.l0(r7)
            r14.n0(r12)
        L_0x0196:
            com.itextpdf.text.pdf.PdfAppearance r12 = r14.c0()
            int r13 = r14.h0()
            r11.f25827d = r13
            return r12
        L_0x01a1:
            com.itextpdf.text.DocumentException r12 = new com.itextpdf.text.DocumentException
            java.lang.String r13 = "an.appearance.was.requested.without.a.variable.text.field"
            java.lang.Object[] r14 = new java.lang.Object[r6]
            java.lang.String r13 = com.itextpdf.text.error_messages.MessageLocalization.b(r13, r14)
            r12.<init>((java.lang.String) r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.AcroFields.k(com.itextpdf.text.pdf.PdfDictionary, java.lang.String[], java.lang.String):com.itextpdf.text.pdf.PdfAppearance");
    }

    public void k0(ArrayList<BaseFont> arrayList) {
        this.f25837n = arrayList;
    }

    public String[] l(String str) {
        PdfDictionary j0;
        Item item = this.f25826c.get(str);
        if (item == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        PdfDictionary k2 = item.k(0);
        PdfName pdfName = PdfName.hc;
        PdfString A0 = k2.A0(pdfName);
        if (A0 != null) {
            linkedHashSet.add(A0.m0());
        } else {
            PdfArray e0 = k2.e0(pdfName);
            if (e0 != null) {
                for (int i2 = 0; i2 < e0.size(); i2++) {
                    PdfObject Q0 = e0.Q0(i2);
                    int W = Q0.W();
                    PdfString P0 = W != 3 ? W != 5 ? null : ((PdfArray) Q0).P0(1) : (PdfString) Q0;
                    if (P0 != null) {
                        linkedHashSet.add(P0.m0());
                    }
                }
            }
        }
        for (int i3 = 0; i3 < item.p(); i3++) {
            PdfDictionary j02 = item.l(i3).j0(PdfName.S3);
            if (!(j02 == null || (j0 = j02.j0(PdfName.kb)) == null)) {
                for (PdfName pdfObject : j0.G0()) {
                    linkedHashSet.add(PdfName.a0(pdfObject.toString()));
                }
            }
        }
        return (String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]);
    }

    public boolean l0(String str) {
        E();
        String H = H(str);
        return this.f25828e.containsKey(H) && ((long) this.f25828e.get(H)[0]) == this.f25824a.N();
    }

    public ArrayList<String> m() {
        E();
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry next : this.f25826c.entrySet()) {
            if (PdfName.Pe.equals(((Item) next.getValue()).h(0).p0(PdfName.C8)) && !this.f25828e.containsKey(next.getKey())) {
                arrayList.add(next.getKey());
            }
        }
        return arrayList;
    }

    public String n(String str) {
        if (this.f25831h.z()) {
            String n2 = this.f25831h.n(str, this);
            if (n2 == null) {
                return null;
            }
            return XfaForm.t(this.f25831h.m(XfaForm.Xml2Som.e(n2)));
        }
        Item item = this.f25826c.get(str);
        if (item == null) {
            return null;
        }
        this.f25832i = false;
        PdfDictionary h2 = item.h(0);
        PdfObject t0 = PdfReader.t0(h2.d0(PdfName.kh));
        String str2 = "";
        if (t0 == null) {
            return str2;
        }
        if (t0 instanceof PRStream) {
            try {
                return new String(PdfReader.D0((PRStream) t0));
            } catch (IOException e2) {
                throw new ExceptionConverter(e2);
            }
        } else {
            if (PdfName.I4.equals(h2.p0(PdfName.C8))) {
                PdfNumber q0 = h2.q0(PdfName.L7);
                if (((q0 != null ? q0.e0() : 0) & 65536) != 0) {
                    return str2;
                }
                if (t0 instanceof PdfName) {
                    str2 = PdfName.a0(t0.toString());
                } else if (t0 instanceof PdfString) {
                    str2 = ((PdfString) t0).m0();
                }
                PdfArray e0 = item.k(0).e0(PdfName.hc);
                if (e0 == null) {
                    return str2;
                }
                try {
                    str2 = e0.P0(Integer.parseInt(str2)).m0();
                    this.f25832i = true;
                    return str2;
                } catch (Exception unused) {
                    return str2;
                }
            } else if (!(t0 instanceof PdfString)) {
                return t0 instanceof PdfName ? PdfName.a0(t0.toString()) : str2;
            } else {
                this.f25832i = true;
                return ((PdfString) t0).m0();
            }
        }
    }

    public Map<String, TextField> o() {
        return this.q;
    }

    public PdfPKCS7 o0(String str) {
        return p0(str, (String) null);
    }

    public Item p(String str) {
        if (!this.f25831h.z() || (str = this.f25831h.n(str, this)) != null) {
            return this.f25826c.get(str);
        }
        return null;
    }

    public PdfPKCS7 p0(String str, String str2) {
        PdfPKCS7 pdfPKCS7;
        String a0;
        PdfDictionary D2 = D(str);
        if (D2 == null) {
            return null;
        }
        try {
            PdfName p0 = D2.p0(PdfName.zf);
            PdfString A0 = D2.A0(PdfName.N5);
            if (p0.equals(PdfName.y3)) {
                PdfName pdfName = PdfName.a5;
                PdfString A02 = D2.A0(pdfName);
                if (A02 == null) {
                    A02 = D2.e0(pdfName).P0(0);
                }
                pdfPKCS7 = new PdfPKCS7(A0.d0(), A02.k(), str2);
            } else {
                pdfPKCS7 = new PdfPKCS7(A0.d0(), p0, str2);
            }
            n0(pdfPKCS7, D2);
            PdfString A03 = D2.A0(PdfName.Na);
            if (A03 != null) {
                pdfPKCS7.J(PdfDate.p0(A03.toString()));
            }
            PdfObject t0 = PdfReader.t0(D2.d0(PdfName.qb));
            if (t0 != null) {
                if (t0.N()) {
                    a0 = ((PdfString) t0).m0();
                } else if (t0.E()) {
                    a0 = PdfName.a0(t0.toString());
                }
                pdfPKCS7.K(a0);
            }
            PdfString A04 = D2.A0(PdfName.Ld);
            if (A04 != null) {
                pdfPKCS7.I(A04.m0());
            }
            PdfString A05 = D2.A0(PdfName.Ga);
            if (A05 != null) {
                pdfPKCS7.H(A05.m0());
            }
            return pdfPKCS7;
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public List<FieldPosition> q(String str) {
        Rectangle rectangle;
        Item p2 = p(str);
        if (p2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < p2.p(); i2++) {
            try {
                PdfArray e0 = p2.l(i2).e0(PdfName.Nd);
                if (e0 != null) {
                    Rectangle b0 = PdfReader.b0(e0);
                    int intValue = p2.i(i2).intValue();
                    int m0 = this.f25824a.m0(intValue);
                    FieldPosition fieldPosition = new FieldPosition();
                    fieldPosition.f25838a = intValue;
                    if (m0 != 0) {
                        Rectangle o0 = this.f25824a.o0(intValue);
                        if (m0 == 90) {
                            rectangle = new Rectangle(b0.H(), o0.Q() - b0.O(), b0.T(), o0.Q() - b0.Q());
                        } else if (m0 == 180) {
                            rectangle = new Rectangle(o0.Q() - b0.O(), o0.T() - b0.H(), o0.Q() - b0.Q(), o0.T() - b0.T());
                        } else if (m0 != 270) {
                            b0.e0();
                        } else {
                            rectangle = new Rectangle(o0.T() - b0.H(), b0.O(), o0.T() - b0.T(), b0.Q());
                        }
                        b0 = rectangle;
                        b0.e0();
                    }
                    fieldPosition.f25839b = b0;
                    arrayList.add(fieldPosition);
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public String r(String str) {
        Item item;
        PdfString A0;
        if (this.f25831h.z() || (item = this.f25826c.get(str)) == null || (A0 = item.h(0).A0(PdfName.Be)) == null) {
            return null;
        }
        return A0.toString();
    }

    public int s(String str) {
        PdfDictionary h2;
        PdfName p0;
        Item p2 = p(str);
        if (p2 == null || (p0 = h2.p0(PdfName.C8)) == null) {
            return 0;
        }
        PdfNumber q0 = (h2 = p2.h(0)).q0(PdfName.L7);
        int e0 = q0 != null ? q0.e0() : 0;
        if (PdfName.I4.equals(p0)) {
            if ((65536 & e0) != 0) {
                return 1;
            }
            return (e0 & 32768) != 0 ? 3 : 2;
        } else if (PdfName.Jg.equals(p0)) {
            return 4;
        } else {
            return PdfName.e5.equals(p0) ? (e0 & 131072) != 0 ? 6 : 5 : PdfName.Pe.equals(p0) ? 7 : 0;
        }
    }

    public Map<String, Item> t() {
        return this.f25826c;
    }

    public String[] v(String str) {
        return u(str, 1);
    }

    public String[] w(String str) {
        return u(str, 0);
    }

    public String[] x(String str) {
        String[] strArr;
        PdfArray e0;
        String n2 = n(str);
        int i2 = 0;
        if (n2 == null) {
            strArr = new String[0];
        } else {
            strArr = new String[]{n2};
        }
        Item item = this.f25826c.get(str);
        if (item == null || (e0 = item.h(0).e0(PdfName.x9)) == null) {
            return strArr;
        }
        String[] strArr2 = new String[e0.size()];
        String[] w2 = w(str);
        ListIterator<PdfObject> listIterator = e0.listIterator();
        while (listIterator.hasNext()) {
            strArr2[i2] = w2[((PdfNumber) listIterator.next()).e0()];
            i2++;
        }
        return strArr2;
    }

    /* access modifiers changed from: package-private */
    public BaseColor y(PdfArray pdfArray) {
        if (pdfArray == null) {
            return null;
        }
        int size = pdfArray.size();
        if (size == 1) {
            return new GrayColor(pdfArray.J0(0).a0());
        }
        if (size == 3) {
            return new BaseColor(ExtendedColor.l(pdfArray.J0(0).a0()), ExtendedColor.l(pdfArray.J0(1).a0()), ExtendedColor.l(pdfArray.J0(2).a0()));
        }
        if (size != 4) {
            return null;
        }
        return new CMYKColor(pdfArray.J0(0).a0(), pdfArray.J0(1).a0(), pdfArray.J0(2).a0(), pdfArray.J0(3).a0());
    }

    public PushbuttonField z(String str) {
        return A(str, 0);
    }
}
